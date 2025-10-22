package com.CartersDev.crystechmod.effect;

import com.CartersDev.crystechmod.CrystalTech;
import com.CartersDev.crystechmod.effect.Misc.FreezeEffect;
import com.CartersDev.crystechmod.effect.Misc.SlimeyEffect;
import com.CartersDev.crystechmod.effect.Resistances.HazmatEffect;
import com.CartersDev.crystechmod.effect.Resistances.PoisonResistanceEffect;
import com.CartersDev.crystechmod.effect.Resistances.WitherResistanceEffect;
import com.CartersDev.crystechmod.effect.VitriciumInfection.CriticalVitriciumInfectionEffect;
import com.CartersDev.crystechmod.effect.VitriciumInfection.InitialVitriciumInfectionEffect;
import com.CartersDev.crystechmod.effect.VitriciumInfection.SeriousVitriciumInfectionEffect;
import com.CartersDev.crystechmod.effect.VitriciumInfection.TerminalVitriciumInfectionEffect;
import com.CartersDev.crystechmod.effect.VitriciumResistance.AdvancedVitriciumResistanceEffect;
import com.CartersDev.crystechmod.effect.VitriciumResistance.BasicVitriciumResistanceEffect;
import com.CartersDev.crystechmod.effect.VitriciumResistance.CompleteVitriciumResistanceEffect;
import com.CartersDev.crystechmod.effect.VitriciumResistance.ImprovedVitriciumResistanceEffect;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModEffects {

    public static final DeferredRegister<MobEffect> MOB_EFFECTS =
            DeferredRegister.create(ForgeRegistries.MOB_EFFECTS, CrystalTech.MOD_ID);

public static final RegistryObject<MobEffect> FREEZE = MOB_EFFECTS.register("freeze",
        () -> new FreezeEffect(MobEffectCategory.HARMFUL, 3124687));

    public static final RegistryObject<MobEffect> SLIMEY_EFFECT = MOB_EFFECTS.register("slimey",
            () -> new SlimeyEffect(MobEffectCategory.NEUTRAL, 0x36ebab).addAttributeModifier(Attributes.MOVEMENT_SPEED,
                    "7107DE5E-7CE8-4030-940E-514C1F160890", -0.25f, AttributeModifier.Operation.MULTIPLY_TOTAL));


    //Vanilla Resistances:
    public static final RegistryObject<MobEffect> POISON_RESISTANCE_EFFECT = MOB_EFFECTS.register("poison_resistance",
            () -> new PoisonResistanceEffect(MobEffectCategory.BENEFICIAL, 0xd3faa0));

    public static final RegistryObject<MobEffect> WITHER_RESISTANCE_EFFECT = MOB_EFFECTS.register("wither_resistance",
            () -> new WitherResistanceEffect(MobEffectCategory.BENEFICIAL, 0xf5cfb8));

    public static final RegistryObject<MobEffect> HAZMAT_EFFECT = MOB_EFFECTS.register("hazmat",
            () -> new HazmatEffect(MobEffectCategory.BENEFICIAL, 0xDDD92A));


    //Vitric Resistances:

    public static final RegistryObject<MobEffect> BASIC_VITRICIUM_RESISTANCE_EFFECT = MOB_EFFECTS.register("vitricium_resistance_1",
            () -> new BasicVitriciumResistanceEffect(MobEffectCategory.BENEFICIAL, 0x0a9100));

    public static final RegistryObject<MobEffect> IMPROVED_VITRICIUM_RESISTANCE_EFFECT = MOB_EFFECTS.register("vitricium_resistance_2",
            () -> new ImprovedVitriciumResistanceEffect(MobEffectCategory.BENEFICIAL, 0x000091));

    public static final RegistryObject<MobEffect> ADVANCED_VITRICIUM_RESISTANCE_EFFECT = MOB_EFFECTS.register("vitricium_resistance_3",
            () -> new AdvancedVitriciumResistanceEffect(MobEffectCategory.BENEFICIAL, 0x910000));

    public static final RegistryObject<MobEffect> COMPLETE_VITRICIUM_RESISTANCE_EFFECT = MOB_EFFECTS.register("vitricium_resistance_4",
            () -> new CompleteVitriciumResistanceEffect(MobEffectCategory.BENEFICIAL, 0x520091));


    //Vitricium Infection:

    public static final RegistryObject<MobEffect> INITIAL_VITRICIUM_INFECTION_EFFECT = MOB_EFFECTS.register("vitricium_infection_1",
            () -> new InitialVitriciumInfectionEffect(MobEffectCategory.HARMFUL, 0x064002));

    public static final RegistryObject<MobEffect> SERIOUS_VITRICIUM_INFECTION_EFFECT = MOB_EFFECTS.register("vitricium_infection_2",
            () -> new SeriousVitriciumInfectionEffect(MobEffectCategory.HARMFUL, 0x010144));

    public static final RegistryObject<MobEffect> CRITICAL_VITRICIUM_INFECTION_EFFECT = MOB_EFFECTS.register("vitricium_infection_3",
            () -> new CriticalVitriciumInfectionEffect(MobEffectCategory.HARMFUL, 0x4a0101));

    public static final RegistryObject<MobEffect> TERMINAL_VITRICIUM_INFECTION_EFFECT = MOB_EFFECTS.register("vitricium_infection_4",
            () -> new TerminalVitriciumInfectionEffect(MobEffectCategory.HARMFUL, 0x260242));


public static void register(IEventBus eventBus) {
    MOB_EFFECTS.register(eventBus);
}
}
