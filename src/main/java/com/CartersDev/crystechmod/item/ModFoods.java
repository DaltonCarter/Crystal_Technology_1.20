package com.CartersDev.crystechmod.item;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;

public class ModFoods {

    public static final FoodProperties TIBERIUM_FRUIT = new FoodProperties.Builder().nutrition(6).fast()
            .saturationMod(0.6f).effect(() -> new MobEffectInstance(MobEffects.WEAKNESS,200),
                    0.3f).effect(() -> new MobEffectInstance(MobEffects.REGENERATION,200),
                    0.2f).effect(() -> new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE,200),
                    0.1f)
            .alwaysEat().build();

    public static final FoodProperties STRAWBERRY = new FoodProperties.Builder().nutrition(2).fast()
            .saturationMod(0.2f).effect(() -> new MobEffectInstance(MobEffects.MOVEMENT_SPEED,200),
                    0.1f).build();

    public static final FoodProperties RIPARIUS_TIBERIUM_DUST = new FoodProperties.Builder().nutrition(3).fast()
            .saturationMod(0.2f).effect(() -> new MobEffectInstance(MobEffects.CONFUSION,200),
                    0.2f).alwaysEat().build();

    public static final FoodProperties VINIFERA_TIBERIUM_DUST = new FoodProperties.Builder().nutrition(3).fast()
            .saturationMod(0.2f).effect(() -> new MobEffectInstance(MobEffects.POISON,200),
                    0.2f).alwaysEat().build();

    public static final FoodProperties CRUENTUS_TIBERIUM_DUST = new FoodProperties.Builder().nutrition(3).fast()
            .saturationMod(0.2f).effect(() -> new MobEffectInstance(MobEffects.POISON,200, 1),
                    0.2f).alwaysEat().build();

    public static final FoodProperties ABOREUS_TIBERIUM_DUST = new FoodProperties.Builder().nutrition(3).fast()
            .saturationMod(0.2f).effect(() -> new MobEffectInstance(MobEffects.WITHER,200),
                    0.2f).alwaysEat().build();




}
