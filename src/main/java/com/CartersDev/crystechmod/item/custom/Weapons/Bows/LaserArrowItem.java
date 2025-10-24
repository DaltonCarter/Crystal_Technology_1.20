package com.CartersDev.crystechmod.item.custom.Weapons.Bows;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.entity.projectile.Arrow;
import net.minecraft.world.item.ArrowItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraftforge.common.capabilities.ForgeCapabilities;

public class LaserArrowItem extends ArrowItem {
    public LaserArrowItem(Properties pProperties) {
        super(pProperties);
    }

//    @Override
//    public AbstractArrow createArrow(Level pLevel, ItemStack pStack, LivingEntity pShooter) {
//        Arrow arrow = new Arrow(pLevel, pShooter);
//        arrow.setEffectsFromItem(pStack);
//        return arrow;
//    }
//
//    @Override
//    public boolean isInfinite(ItemStack stack, ItemStack bow, net.minecraft.world.entity.player.Player player) {
//        int hasEnergy = bow.getCapability(ForgeCapabilities.ENERGY).;
//        return hasEnergy <= 0 ? false : this.getClass() == ArrowItem.class;
//    }

}
