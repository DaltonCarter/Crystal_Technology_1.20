package com.CartersDev.crystechmod.item.custom.Weapons.Bows;

import com.CartersDev.crystechmod.block.entity.ModSignBlockEntity;
import com.CartersDev.crystechmod.enchantment.ModEnchantments;
import com.CartersDev.crystechmod.entity.custom.LaserBeamEntity;
import com.CartersDev.crystechmod.item.ModItems;
import com.CartersDev.crystechmod.item.custom.Util.FocusContainer;
import com.CartersDev.crystechmod.sound.ModSounds;
import com.CartersDev.crystechmod.util.ModEnergyStorage;

import com.CartersDev.crystechmod.util.NBTHelper;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.stats.Stats;
import net.minecraft.util.Mth;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.MobSpawnType;
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
import net.minecraftforge.event.entity.living.LivingAttackEvent;
import net.minecraftforge.event.level.BlockEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Locale;

import static net.minecraft.commands.arguments.coordinates.BlockPosArgument.getBlockPos;
import static org.apache.logging.log4j.Level.getLevel;


   /*
    This class needs to have the Energy Capability and modifications to the bow logic. I.E If Energy > 10FE Has ammo == true.

    It would also need to handle the check for the Existence of the ACTUAL Upgrade items Like the Focus Lens in order to reduce the durability on use,
    Or multiply the energy capacity, attack damage, Bow Pull animation reduction ect...

    This is also the class where if a Focus Lens is present its effects will be applied to the "Arrow" just like the Enchantment check in the Vanilla bow class

    Obviously this is also where the traditional Bow logic would be located
     */

public class ThermalEnergyBow extends CrossbowItem implements FocusContainer {

    public static final String TAG_LASER_FOCUS = "LaserFocus";
    public static Integer CHARGE = 0;


    public ThermalEnergyBow(Properties pProperties) {
        super(pProperties);
    }

//    @Override
//    public InteractionResultHolder<ItemStack> use(Level pLevel, Player pPlayer, InteractionHand pUsedHand) {
//
//        ItemStack itemstack = pPlayer.getItemInHand(pUsedHand);
//        pLevel.playSound(null, pPlayer.getX(), pPlayer.getY(), pPlayer.getZ(), ModSounds.LASER.get(), SoundSource.NEUTRAL,
//                1.5F, 1F);
//        pPlayer.getCooldowns().addCooldown(this, 40);
//
//        if(!pLevel.isClientSide()) {
//            LaserBeamEntity laserProjectile = new LaserBeamEntity(pLevel, pPlayer);
//            laserProjectile.shootFromRotation(pPlayer, pPlayer.getXRot(), pPlayer.getYRot(), 0.0F, 1.5F, 0.25F);
//            pLevel.addFreshEntity(laserProjectile);
//        }
//
//        pPlayer.awardStat(Stats.ITEM_USED.get(this));
//        if (!pPlayer.getAbilities().instabuild) {
//            itemstack.hurtAndBreak(1, pPlayer, p -> p.broadcastBreakEvent(pUsedHand));
//        }
//
//        return InteractionResultHolder.sidedSuccess(itemstack, pLevel.isClientSide());
//    }

    @Override
    public UseAnim getUseAnimation(ItemStack pStack) {
        return UseAnim.CROSSBOW;
    }

    @Override
    public void releaseUsing(ItemStack pStack, Level pLevel, LivingEntity pEntityLiving, int pTimeLeft) {
        if (pEntityLiving instanceof Player player) {


            ItemStack weapon = player.getMainHandItem();

            if (CHARGE == 1) {
                removeFocus(weapon);
                spawnEmptyFocus(player);
                --CHARGE;

            }

            ItemStack itemstack = player.getProjectile(pStack);
            int i = this.getUseDuration(pStack) - pTimeLeft;
            i = net.minecraftforge.event.ForgeEventFactory.onArrowLoose(pStack, pLevel, player, i, itemstack.isEmpty());
            if (i < 0) return;


            float f = getPowerForTime(i, weapon);
            if (!((double) f < 0.1D)) {

                if (!pLevel.isClientSide) {
                    LaserBeamEntity laserProjectile = new LaserBeamEntity(pLevel, player);
                    laserProjectile.shootFromRotation(player, player.getXRot(), player.getYRot(), 0.0F, 1.5F, 0.25F);
                    pLevel.addFreshEntity(laserProjectile);

//
//
//                    int j = EnchantmentHelper.getItemEnchantmentLevel(Enchantments.POWER_ARROWS, pStack);
//                    if (j > 0) {
//                        abstractarrow.setBaseDamage(abstractarrow.getBaseDamage() + (double)j * 0.5D + 0.5D);
//                    }
//
//
//
//                    if (EnchantmentHelper.getItemEnchantmentLevel(Enchantments.FLAMING_ARROWS, pStack) > 0) {
//                        abstractarrow.setSecondsOnFire(100);
//                    }

//
//                    pStack.hurtAndBreak(1, player, (p_289501_) -> {
//                        p_289501_.broadcastBreakEvent(player.getUsedItemHand());
//                    });
//


//                    pLevel.addFreshEntity(abstractarrow);
//                }

                    pLevel.playSound(null, player.getX(), player.getY(), player.getZ(), ModSounds.LASER.get(), SoundSource.NEUTRAL,
                            1.5F, 1F);


                    player.awardStat(Stats.ITEM_USED.get(this));
                }
            }
        }
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level pLevel, Player pPlayer, InteractionHand pHand) {
        ItemStack itemstack = pPlayer.getItemInHand(pHand);
        boolean flag = pPlayer.getItemInHand(pHand).isEmpty();

        if(!isLoaded(itemstack)) {

        }


        InteractionResultHolder<ItemStack> ret = net.minecraftforge.event.ForgeEventFactory.onArrowNock(itemstack, pLevel, pPlayer, pHand, flag);
        if (ret != null) return ret;
        pPlayer.startUsingItem(pHand);
        if (!pPlayer.getAbilities().instabuild) {

        }

        return InteractionResultHolder.sidedSuccess(itemstack, pLevel.isClientSide());
    }

    private static float getPowerForTime(int pUseTime, ItemStack pCrossbowStack) {
        float f = (float)pUseTime / (float)getChargeDuration(pCrossbowStack);
        if (f > 1.0F) {
            f = 1.0F;
        }

        return f;
    }

    @Override
    public void addFocus(ItemStack stack, FocusType focus) {
        NBTHelper.setBoolean(stack, TAG_LASER_FOCUS + "_" + focus.name().toLowerCase(Locale.ROOT), true);

    }

    @Override
    public boolean hasFocus(ItemStack stack, FocusType focus) {
        return hasFocus_(stack, focus);
    }

    private static boolean hasFocus_(ItemStack stack, FocusType focus) {
        return NBTHelper.getBoolean(stack, TAG_LASER_FOCUS + "_" + focus.name().toLowerCase(Locale.ROOT), false);
    }

    @Override
    public void removeFocus(ItemStack stack) {
        NBTHelper.setBoolean(stack, TAG_LASER_FOCUS, true);
    }

    private void spawnEmptyFocus(Player player) {
        ItemStack emptyFocus = new ItemStack(ModItems.EMPTY_FOCUS.get());
        if (!player.getInventory().add(emptyFocus)) {
            player.spawnAtLocation(emptyFocus, 0.1F);
        }
    }

    public static boolean isLoaded(ItemStack stack) {
        for(FocusType type : FocusType.values()) {
            if (hasFocus_(stack, type)) {
                return true;
            }
        }
        return false;
    }



}



