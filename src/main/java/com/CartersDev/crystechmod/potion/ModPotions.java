package com.CartersDev.crystechmod.potion;

import com.CartersDev.crystechmod.CrystalTech;
import com.CartersDev.crystechmod.effect.ModEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.item.alchemy.Potion;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModPotions {
    public static final DeferredRegister<Potion> POTIONS =
            DeferredRegister.create(ForgeRegistries.POTIONS, CrystalTech.MOD_ID);


public static final RegistryObject<Potion> FREEZE_POTION = POTIONS.register("freeze_potion",
        () -> new Potion(new MobEffectInstance(ModEffects.FREEZE.get(), 200, 0)));

    public static final RegistryObject<Potion> CLIMBING_POTION = POTIONS.register("climbing_potion",
            () -> new Potion(new MobEffectInstance(ModEffects.SLIMEY_EFFECT.get(), 200, 0)));




    public static void register (IEventBus eventBus) {
        POTIONS.register(eventBus);
    }
}
