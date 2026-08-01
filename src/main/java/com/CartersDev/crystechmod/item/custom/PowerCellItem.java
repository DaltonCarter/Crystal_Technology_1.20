package com.CartersDev.crystechmod.item.custom;

import com.CartersDev.crystechmod.util.item.ModItemEnergyStorage;
import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.ForgeCapabilities;
import net.minecraftforge.common.capabilities.ICapabilityProvider;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.energy.IEnergyStorage;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class PowerCellItem extends Item {

    private final int capacity;
    private final int maxTransfer;

    public PowerCellItem(Properties itemProperties, int capacity, int maxTransfer) {
        super(itemProperties.stacksTo(1));
        this.capacity = capacity;
        this.maxTransfer = maxTransfer;
    }

    @Override
    public @Nullable ICapabilityProvider initCapabilities(ItemStack stack, @Nullable CompoundTag nbt) {
        return new ICapabilityProvider() {

            private final net.minecraftforge.common.util.LazyOptional<IEnergyStorage> ENERGY_STORAGE =
                    LazyOptional.of(() -> new ModItemEnergyStorage(stack, capacity, maxTransfer));

            @Override
            public @NotNull <T> LazyOptional<T> getCapability(@NotNull Capability<T> cap, @Nullable Direction side) {

                if(cap == ForgeCapabilities.ENERGY){
                    return ENERGY_STORAGE.cast();
                }

                return LazyOptional.empty();
            }
        };
    }


    @Override
    public InteractionResultHolder<ItemStack> use(Level pLevel, Player pPlayer, InteractionHand pUsedHand) {
        ItemStack powerCell = pPlayer.getItemInHand(pUsedHand);

        if(pPlayer.isCrouching()){
            if(!pLevel.isClientSide()) {
                CompoundTag tag = powerCell.getOrCreateTag();
                boolean chargingModeToggle = !tag.getBoolean("Charging_Mode");
                tag.putBoolean("Charging_Mode", chargingModeToggle);

                if(chargingModeToggle) {
                    pPlayer.sendSystemMessage(Component.literal("§aPower Cell: Now charging inventory items."));
                } else {
                    pPlayer.sendSystemMessage(Component.literal("§aPower Cell: No longer charging inventory items."));
                }
            }
            return InteractionResultHolder.sidedSuccess(powerCell, pLevel.isClientSide());
        }
        return InteractionResultHolder.pass(powerCell);
    }

    @Override
    public void inventoryTick(ItemStack pStack, Level pLevel, Entity pEntity, int pSlotId, boolean pIsSelected) {

        if (pLevel.isClientSide() || !(pEntity instanceof Player player)) {
            return;
        }

        CompoundTag tag = pStack.getTag();
        if(tag == null || !tag.getBoolean("Charging_Mode")){
            return;
        }

        pStack.getCapability(ForgeCapabilities.ENERGY).ifPresent(powerCell -> {
            if(powerCell.getEnergyStored() <= 0) {
                tag.putBoolean("Charging_Mode", false);
                player.sendSystemMessage(Component.literal("§4Power Cell is empty, deactivating inventory charging."));
                return;
            }

            for (int i = 0; i < player.getInventory().getContainerSize(); i++) {
                if (i == pSlotId) {
                    continue;
                }

                ItemStack target = player.getInventory().getItem(i);
                if (target.isEmpty()) {
                    continue;
                }

                target.getCapability(ForgeCapabilities.ENERGY).ifPresent(targetsEnergy -> {
                    if (targetsEnergy.canReceive()) {
                        int maxExtractAmount = powerCell.extractEnergy(maxTransfer, true);
                        int acceptedAmount = targetsEnergy.receiveEnergy(maxExtractAmount, false);
                        powerCell.extractEnergy(acceptedAmount, false);
                    }
                });
            }
        });
    }

    @Override
    public boolean isFoil(ItemStack pStack) {
        return pStack.hasTag() && pStack.getTag().getBoolean("Charging_Mode");
    }

    @Override
    public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> pTooltipComponents, TooltipFlag pIsAdvanced) {

        pStack.getCapability(ForgeCapabilities.ENERGY).ifPresent(energy -> {
            pTooltipComponents.add(Component.literal("§ePower Stored: §7" + String.format("%,d", energy.getEnergyStored()) + " / " + String.format("%,d", capacity) + " FE"));
        });

        boolean currentMode = pStack.hasTag() && pStack.getTag().getBoolean("Charging_Mode");
        pTooltipComponents.add(Component.literal("§7Mode: " + (currentMode ? "§aAuto-Charge Items" : "§cIdle")));
        pTooltipComponents.add(Component.literal("§8Shift+Right-Click to toggle inventory item charging."));
        super.appendHoverText(pStack, pLevel, pTooltipComponents, pIsAdvanced);
    }


    public static ItemStack getFilledVariant(Item item, int energyAmount) {
        ItemStack stack = new ItemStack(item);

        stack.getOrCreateTag().putInt("Energy", energyAmount);

        return stack;
    }

}
