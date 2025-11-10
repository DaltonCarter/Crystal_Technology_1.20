package com.CartersDev.crystechmod.item.custom.Weapons.Bows;

import com.CartersDev.crystechmod.util.ModEnergyStorage;

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

import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.energy.IEnergyStorage;


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

    private final int energyAmount = 10;

    @Override
    public void releaseUsing(ItemStack pStack, Level pLevel, LivingEntity pEntityLiving, int pTimeLeft) {
        if (pEntityLiving instanceof Player player) {
            boolean flag = player.getAbilities().instabuild || this.ENERGY_STORAGE.getEnergyStored() >= energyAmount;
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


                        if (flag1 || player.getAbilities().instabuild && (itemstack.is(Items.SPECTRAL_ARROW) || itemstack.is(Items.TIPPED_ARROW))) {
                            abstractarrow.pickup = AbstractArrow.Pickup.CREATIVE_ONLY;
                        }

                        pLevel.addFreshEntity(abstractarrow);
                    }

                    pLevel.playSound((Player)null, player.getX(), player.getY(), player.getZ(), SoundEvents.ARROW_SHOOT, SoundSource.PLAYERS, 1.0F, 1.0F / (pLevel.getRandom().nextFloat() * 0.4F + 1.2F) + f * 0.5F);
                    if (!flag1 && !player.getAbilities().instabuild) {
                        extractEnergy();
                        }
                    }

                    player.awardStat(Stats.ITEM_USED.get(this));

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
            return InteractionResultHolder.success(itemstack);
        }
    }

    @Override
    public boolean isBarVisible(ItemStack pStack) {
        return true;
    }

    @Override
    public int getBarWidth(ItemStack pStack) {
        return Math.round(13.0F - (float)this.ENERGY_STORAGE.getEnergyStored() * 13.0F / (float)this.ENERGY_STORAGE.getMaxEnergyStored());
    }
    @Override
    public int getBarColor(ItemStack pStack) {
        float stackMaxDamage = this.ENERGY_STORAGE.getMaxEnergyStored();
        float f = Math.max(0.0F, (stackMaxDamage - (float)this.ENERGY_STORAGE.getEnergyStored()) / stackMaxDamage);
        return Mth.hsvToRgb(f / 3.0F, 1.0F, 1.0F);
    }

    //Custom Logic:



    private final ModEnergyStorage ENERGY_STORAGE = createEnergyStorage();

    private LazyOptional<IEnergyStorage> lazyEnergyHandler = LazyOptional.empty();

    private ModEnergyStorage createEnergyStorage() {
        return new ModEnergyStorage(1000, 1000) {
            @Override
            public void onEnergyChanged() {


            }
        };
    }

    private void extractEnergy() {
        this.ENERGY_STORAGE.extractEnergy(energyAmount, false);

    }

    private void fillEnergy() {
        this.ENERGY_STORAGE.receiveEnergy(1000, false);

        }



}


