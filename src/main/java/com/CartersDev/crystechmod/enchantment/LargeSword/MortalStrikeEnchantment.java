package com.CartersDev.crystechmod.enchantment.LargeSword;

import com.CartersDev.crystechmod.item.custom.Weapons.LargeSword;
import com.CartersDev.crystechmod.util.ModTags;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentCategory;

public class MortalStrikeEnchantment extends Enchantment {
    public MortalStrikeEnchantment(Rarity pRarity, EnchantmentCategory pCategory, EquipmentSlot... pApplicableSlots) {
        super(pRarity, pCategory, pApplicableSlots);
    }

    public int getMinCost(int pEnchantmentLevel) {
        return 1 + (pEnchantmentLevel - 1) * 10;
    }

    public int getMaxCost(int pEnchantmentLevel) {
        return this.getMinCost(pEnchantmentLevel) + 20;
    }

    @Override
    public int getMaxLevel() {
        return 5;
    }

    @Override
    public void doPostAttack(LivingEntity pAttacker, Entity pTarget, int pLevel) {
        RandomSource rand = RandomSource.create();
        if(!pAttacker.level().isClientSide() && !pTarget.getType().is(ModTags.Entities.CANNOT_EXECUTE) && !(pTarget instanceof Player)) {
            switch (pLevel){
                case 1: if(rand.nextInt(100) <= 1) {
                    pTarget.kill();
                    break;
                }
                case 2: if(rand.nextInt(100) <= 2) {
                    pTarget.kill();
                    break;
                }
                case 3: if(rand.nextInt(100) <= 3) {
                    pTarget.kill();
                    break;
                }
                case 4: if(rand.nextInt(100) <= 4) {
                    pTarget.kill();
                    break;
                }
                case 5: if(rand.nextInt(100) <= 5) {
                    pTarget.kill();
                    break;
                }
                default:break;
            }

        }

        super.doPostAttack(pAttacker, pTarget, pLevel);
    }



    @Override
    public boolean canEnchant(ItemStack pStack) {
        return pStack.getItem() instanceof LargeSword || super.canEnchant(pStack);
    }
}
