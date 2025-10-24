package com.CartersDev.crystechmod.item.custom.Weapons.Bows;

import net.minecraft.ChatFormatting;
import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.stats.Stats;
import net.minecraft.util.Mth;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.item.*;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.Level;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.ForgeCapabilities;
import net.minecraftforge.common.capabilities.ICapabilityProvider;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.energy.IEnergyStorage;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.List;

   /*
    This class needs to have the Energy Capability and modifications to the bow logic. I.E If Energy > 10FE Has ammo == true.

    It would also need to handle the check for the Existence of the ACTUAL Upgrade items Like the Focus Lens in order to reduce the durability on use,
    Or multiply the energy capacity, attack damage, Bow Pull animation reduction ect...

    This is also the class where if a Focus Lens is present its effects will be applied to the "Arrow" just like the Enchantment check in the Vanilla bow class

    Obviously this is also where the traditional Bow logic would be located
     */

public class ThermalEnergyBow extends BowItem {


    public ThermalEnergyBow(Properties pProperties) {
        super(pProperties);
    }

//    @Override
//    public ICapabilityProvider initCapabilities(ItemStack stack, CompoundTag nbt)
//    {
//        if(!stack.isEmpty())
//            return new IEItemStackHandler(stack)
//            {
//                final LazyOptional<EnergyHelper.ItemEnergyStorage> energyStorage = CapabilityUtils.constantOptional(
//                        new EnergyHelper.ItemEnergyStorage(stack, RailgunItem::getMaxEnergyStored)
//                );
//
//
//                @Nonnull
//                @Override
//                public <T> LazyOptional<T> getCapability(@Nonnull Capability<T> capability, Direction facing)
//                {
//                    if(capability== ForgeCapabilities.ENERGY)
//                        return energyStorage.cast();
//
//                    return super.getCapability(capability, facing);
//                }
//            };
//        return null;
//    }
//
//    @Override
//    public void appendHoverText(ItemStack stack, @Nullable Level world, List<Component> list, TooltipFlag flag)
//    {
//        IEnergyStorage energy = CapabilityUtils.getPresentCapability(stack, ForgeCapabilities.ENERGY);
//        String stored = energy.getEnergyStored()+"/"+getMaxEnergyStored(stack);
//        list.add(Component.translatable(Lib.DESC+"info.energyStored", stored).withStyle(ChatFormatting.GRAY));
//    }
//

    @Override
    public void releaseUsing(ItemStack pStack, Level pLevel, LivingEntity pEntityLiving, int pTimeLeft) {
        if (pEntityLiving instanceof Player player) {
            boolean flag = player.getAbilities().instabuild || EnchantmentHelper.getItemEnchantmentLevel(Enchantments.INFINITY_ARROWS, pStack) > 0;
            ItemStack itemstack = player.getProjectile(pStack);

            int i = this.getUseDuration(pStack) - pTimeLeft;
            i = net.minecraftforge.event.ForgeEventFactory.onArrowLoose(pStack, pLevel, player, i, !itemstack.isEmpty() || flag);
            if (i < 0) return;

            if (!itemstack.isEmpty() || flag) {
                if (itemstack.isEmpty()) {
                    itemstack = new ItemStack(Items.ARROW);
                }

                float f = getPowerForTime(i);
                if (!((double)f < 0.1D)) {
                    boolean flag1 = player.getAbilities().instabuild || (itemstack.getItem() instanceof ArrowItem && ((ArrowItem)itemstack.getItem()).isInfinite(itemstack, pStack, player));
                    if (!pLevel.isClientSide) {
                        ArrowItem arrowitem = (ArrowItem)(itemstack.getItem() instanceof ArrowItem ? itemstack.getItem() : Items.ARROW);
                        AbstractArrow abstractarrow = arrowitem.createArrow(pLevel, itemstack, player);
                        abstractarrow = customArrow(abstractarrow);
                        abstractarrow.shootFromRotation(player, player.getXRot(), player.getYRot(), 0.0F, f * 3.0F, 1.0F);
                        if (f == 1.0F) {
                            abstractarrow.setCritArrow(true);
                        }

                        int j = EnchantmentHelper.getItemEnchantmentLevel(Enchantments.POWER_ARROWS, pStack);
                        if (j > 0) {
                            abstractarrow.setBaseDamage(abstractarrow.getBaseDamage() + (double)j * 0.5D + 0.5D);
                        }

                        int k = EnchantmentHelper.getItemEnchantmentLevel(Enchantments.PUNCH_ARROWS, pStack);
                        if (k > 0) {
                            abstractarrow.setKnockback(k);
                        }

                        if (EnchantmentHelper.getItemEnchantmentLevel(Enchantments.FLAMING_ARROWS, pStack) > 0) {
                            abstractarrow.setSecondsOnFire(100);
                        }

                        pStack.hurtAndBreak(1, player, (p_289501_) -> {
                            p_289501_.broadcastBreakEvent(player.getUsedItemHand());
                        });
                        if (flag1 || player.getAbilities().instabuild && (itemstack.is(Items.SPECTRAL_ARROW) || itemstack.is(Items.TIPPED_ARROW))) {
                            abstractarrow.pickup = AbstractArrow.Pickup.CREATIVE_ONLY;
                        }

                        pLevel.addFreshEntity(abstractarrow);
                    }

                    pLevel.playSound((Player)null, player.getX(), player.getY(), player.getZ(), SoundEvents.ARROW_SHOOT, SoundSource.PLAYERS, 1.0F, 1.0F / (pLevel.getRandom().nextFloat() * 0.4F + 1.2F) + f * 0.5F);
                    if (!flag1 && !player.getAbilities().instabuild) {
                        itemstack.shrink(1);
                        if (itemstack.isEmpty()) {
                            player.getInventory().removeItem(itemstack);
                        }
                    }

                    player.awardStat(Stats.ITEM_USED.get(this));
                }
            }
        }
    }


    public InteractionResultHolder<ItemStack> use(Level pLevel, Player pPlayer, InteractionHand pHand) {
        ItemStack itemstack = pPlayer.getItemInHand(pHand);
        boolean flag = !pPlayer.getProjectile(itemstack).isEmpty();

        InteractionResultHolder<ItemStack> ret = net.minecraftforge.event.ForgeEventFactory.onArrowNock(itemstack, pLevel, pPlayer, pHand, flag);
        if (ret != null) return ret;

        if (!pPlayer.getAbilities().instabuild && !flag) {
            return InteractionResultHolder.fail(itemstack);
        } else {
            pPlayer.startUsingItem(pHand);
            return InteractionResultHolder.consume(itemstack);
        }
    }

    public boolean isBarVisible(ItemStack pStack) {
        return true;
    }

    public int getBarWidth(ItemStack pStack) {
        return Math.round(13.0F - (float)pStack.getDamageValue() * 13.0F / (float)this.getMaxDamage(pStack));
    }

    public int getBarColor(ItemStack pStack) {
        float stackMaxDamage = this.getMaxDamage(pStack);
        float f = Math.max(0.0F, (stackMaxDamage - (float)pStack.getDamageValue()) / stackMaxDamage);
        return Mth.hsvToRgb(f / 3.0F, 1.0F, 1.0F);
    }

    //Custom Logic:

}


