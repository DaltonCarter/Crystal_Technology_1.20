package com.CartersDev.crystechmod.effect.Resistances;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;

public class HazmatEffect extends MobEffect {
    public HazmatEffect(MobEffectCategory pCategory, int pColor) {
        super(pCategory, pColor);
    }

    @Override
    public void applyEffectTick(LivingEntity pLivingEntity, int pAmplifier) {
        super.applyEffectTick(pLivingEntity, pAmplifier);

        if(pLivingEntity.hasEffect(MobEffects.POISON) || pLivingEntity.hasEffect(MobEffects.WITHER)){
            pLivingEntity.removeEffect(MobEffects.POISON);
            pLivingEntity.removeEffect(MobEffects.WITHER);

        }
    }

    @Override
    public boolean isDurationEffectTick(int pDuration, int pAmplifier) {
        return pDuration > 0;
    }
}
