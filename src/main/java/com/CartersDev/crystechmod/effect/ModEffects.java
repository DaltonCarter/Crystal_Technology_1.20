package com.CartersDev.crystechmod.effect;

import com.CartersDev.crystechmod.CrystalTech;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModEffects {

    public static final DeferredRegister<MobEffect> MOB_EFFECTS =
            DeferredRegister.create(ForgeRegistries.MOB_EFFECTS, CrystalTech.MOD_ID);

public static final RegistryObject<MobEffect> FREEZE = MOB_EFFECTS.register("freeze",
        () -> new FreezeEffect(MobEffectCategory.HARMFUL, 3124687));


public static void register(IEventBus eventBus) {
    MOB_EFFECTS.register(eventBus);
}
}
