package com.CartersDev.crystechmod.enchantment.BeamCaster;

import com.CartersDev.crystechmod.item.custom.Weapons.Bows.ThermalEnergyBow;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentCategory;

public class EfficientCellsEnchantment extends Enchantment {
    public EfficientCellsEnchantment(Rarity pRarity, EnchantmentCategory pCategory, EquipmentSlot... pApplicableSlots) {
        super(pRarity, pCategory, pApplicableSlots);
    }


    public int getMinCost(int pEnchantmentLevel) {
        return 5 + (pEnchantmentLevel - 1) * 8;
    }

    public int getMaxCost(int pEnchantmentLevel) {
        return super.getMinCost(pEnchantmentLevel) + 50;
    }


    public int getMaxLevel() {
        return 3;
    }


    public boolean canEnchant(ItemStack pStack) {
        return pStack.getItem() instanceof ThermalEnergyBow || super.canEnchant(pStack);
    }


    public static boolean shouldIgnoreChargeDrop(ItemStack pStack, int pLevel, RandomSource pRandom) {

        if (pLevel == 1 && pRandom.nextFloat() < 0.2F) {
            return true;
        } else if (pLevel == 2 && pRandom.nextFloat() < 0.4F) {
            return true;
        }  else if (pLevel == 3 && pRandom.nextFloat() < 0.6F) {
            return true;
        }
        return false;
    }

}
