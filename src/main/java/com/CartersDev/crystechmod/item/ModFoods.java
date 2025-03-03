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

    public static final FoodProperties HEIM_BERRY = new FoodProperties.Builder().nutrition(4).fast()
            .saturationMod(0.2f).effect(() -> new MobEffectInstance(MobEffects.MOVEMENT_SPEED,200),
                    0.1f).build();

    public static final FoodProperties HEL_FRUIT = new FoodProperties.Builder().nutrition(2).fast()
            .saturationMod(0.4f).effect(() -> new MobEffectInstance(MobEffects.DIG_SPEED,200),
                    0.1f).build();

    public static final FoodProperties LAI_MELON_SLICE = new FoodProperties.Builder().nutrition(7).fast()
            .saturationMod(0.8f).effect(() -> new MobEffectInstance(MobEffects.REGENERATION,200),
                    0.1f).build();

    public static final FoodProperties SABER_CORN = new FoodProperties.Builder().nutrition(6).fast()
            .saturationMod(0.5f).effect(() -> new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE,200),
                    0.1f).build();

    public static final FoodProperties RAW_INFECTED_MEAT = new FoodProperties.Builder().nutrition(3).fast()
            .saturationMod(0.3f).effect(() -> new MobEffectInstance(MobEffects.HUNGER,200),
                    0.1f).build();

    public static final FoodProperties COOKED_INFECTED_MEAT = new FoodProperties.Builder().nutrition(8).fast()
            .saturationMod(0.8f).build();

    public static final FoodProperties ZAIRAN_FRUIT_SALAD = new FoodProperties.Builder().nutrition(13).fast()
            .saturationMod(1.4f).effect(() -> new MobEffectInstance(MobEffects.REGENERATION,400),
                    0.2f).build();

    public static final FoodProperties SABER_BREAD = new FoodProperties.Builder().nutrition(10).fast()
            .saturationMod(0.5f).build();



}
