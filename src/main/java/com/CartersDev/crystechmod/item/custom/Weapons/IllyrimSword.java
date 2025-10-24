package com.CartersDev.crystechmod.item.custom.Weapons;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Tier;

public class IllyrimSword extends SwordItem {
    public IllyrimSword(Tier pTier, int pAttackDamageModifier, float pAttackSpeedModifier, Properties pProperties) {
        super(pTier, pAttackDamageModifier, pAttackSpeedModifier, pProperties);
    }

    @Override
    public boolean onLeftClickEntity(ItemStack stack, Player player, Entity entity) {
        if(entity instanceof LivingEntity livingEntity) {
            livingEntity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 400), player);
            livingEntity.addEffect(new MobEffectInstance(MobEffects.WEAKNESS, 400), player);
            livingEntity.addEffect(new MobEffectInstance(MobEffects.CONFUSION, 400), player);
        }



        return super.onLeftClickEntity(stack, player, entity);
    }
}
