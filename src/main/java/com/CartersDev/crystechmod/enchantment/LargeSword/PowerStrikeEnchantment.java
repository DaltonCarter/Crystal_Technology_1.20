package com.CartersDev.crystechmod.enchantment.LargeSword;


import com.CartersDev.crystechmod.item.custom.Weapons.LargeSword;
import net.minecraft.world.entity.*;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentCategory;
import net.minecraft.world.item.enchantment.Enchantments;

public class PowerStrikeEnchantment extends Enchantment {
    public PowerStrikeEnchantment(Rarity pRarity, EnchantmentCategory pCategory, EquipmentSlot... pApplicableSlots) {
        super(pRarity, pCategory, pApplicableSlots);
    }

    public int getMinCost(int pEnchantmentLevel) {
        return 1 + (pEnchantmentLevel - 1) * 11;
    }

    public int getMaxCost(int pEnchantmentLevel) {
        return this.getMinCost(pEnchantmentLevel) + 20;
    }

    @Override
    public int getMaxLevel() {
        return 5;
    }

    @Override
    public float getDamageBonus(int pLevel, MobType pCreatureType) {
        return 1.0F + (float)Math.max(0, pLevel - 1) * 2.0F;
    }

    @Override
    public void doPostAttack(LivingEntity pAttacker, Entity pTarget, int pLevel) {
        if(!pAttacker.level().isClientSide() && pTarget instanceof LivingEntity mook) {
            double dx = pAttacker.getX() - mook.getX();
            double dz = pAttacker.getZ() - mook.getZ();

            mook.knockback(pLevel * 0.75, dx, dz);
        }
        super.doPostAttack(pAttacker, pTarget, pLevel);
    }

    public boolean checkCompatibility(Enchantment pEnch) {
        return super.checkCompatibility(pEnch) && pEnch != Enchantments.KNOCKBACK;
    }

    @Override
    public boolean canEnchant(ItemStack pStack) {
        return pStack.getItem() instanceof LargeSword || super.canEnchant(pStack);
    }
}
