package com.CartersDev.crystechmod.effect.VitriciumResistance;

import com.CartersDev.crystechmod.effect.ModEffects;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;

public class CompleteVitriciumResistanceEffect extends MobEffect {
    public CompleteVitriciumResistanceEffect(MobEffectCategory pCategory, int pColor) {
        super(pCategory, pColor);
    }

    @Override
    public void applyEffectTick(LivingEntity pLivingEntity, int pAmplifier) {
        super.applyEffectTick(pLivingEntity, pAmplifier);

        if(pLivingEntity.hasEffect(ModEffects.INITIAL_VITRICIUM_INFECTION_EFFECT.get()) || pLivingEntity.hasEffect(ModEffects.SERIOUS_VITRICIUM_INFECTION_EFFECT.get())
                || pLivingEntity.hasEffect(ModEffects.CRITICAL_VITRICIUM_INFECTION_EFFECT.get()) || pLivingEntity.hasEffect(ModEffects.TERMINAL_VITRICIUM_INFECTION_EFFECT.get())){
            pLivingEntity.removeEffect(ModEffects.INITIAL_VITRICIUM_INFECTION_EFFECT.get());
            pLivingEntity.removeEffect(ModEffects.SERIOUS_VITRICIUM_INFECTION_EFFECT.get());
            pLivingEntity.removeEffect(ModEffects.CRITICAL_VITRICIUM_INFECTION_EFFECT.get());
            pLivingEntity.removeEffect(ModEffects.TERMINAL_VITRICIUM_INFECTION_EFFECT.get());

        }
    }

    @Override
    public boolean isDurationEffectTick(int pDuration, int pAmplifier) {
        return pDuration > 0;
    }
}
