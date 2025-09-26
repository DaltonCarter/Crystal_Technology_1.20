package com.CartersDev.crystechmod.particle;

import com.CartersDev.crystechmod.CrystalTech;
import net.minecraft.core.particles.ParticleType;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModParticles {
    public static final DeferredRegister<ParticleType<?>> PARTICLE_TYPES =
            DeferredRegister.create(ForgeRegistries.PARTICLE_TYPES, CrystalTech.MOD_ID);

public static final RegistryObject<SimpleParticleType> YOKARITE_PARTICLES =
        PARTICLE_TYPES.register("yokarite_particles", () -> new SimpleParticleType(true));

    public static final RegistryObject<SimpleParticleType> MARIKA_PARTICLES =
            PARTICLE_TYPES.register("marika_particles", () -> new SimpleParticleType(true));

    public static final RegistryObject<SimpleParticleType> EMBER_PARTICLES =
            PARTICLE_TYPES.register("ember_particles", () -> new SimpleParticleType(true));

    public static final RegistryObject<SimpleParticleType> CHARGE_PARTICLES =
            PARTICLE_TYPES.register("charge_particles", () -> new SimpleParticleType(true));

    public static final RegistryObject<SimpleParticleType> SMALL_CHARGE_PARTICLES =
            PARTICLE_TYPES.register("small_charge_particles", () -> new SimpleParticleType(true));

    public static final RegistryObject<SimpleParticleType> PROTOCULTURE_PARTICLES =
            PARTICLE_TYPES.register("protoculture_particles", () -> new SimpleParticleType(true));

    public static final RegistryObject<SimpleParticleType> CONTAMINATION_PARTICLES =
            PARTICLE_TYPES.register("contamination_particles", () -> new SimpleParticleType(true));

    public static final RegistryObject<SimpleParticleType> INFECTION_PARTICLES =
            PARTICLE_TYPES.register("infection_particles", () -> new SimpleParticleType(true));

    public static final RegistryObject<SimpleParticleType> RIPARIUS_PARTICLES =
            PARTICLE_TYPES.register("riparius_particles", () -> new SimpleParticleType(true));

    public static final RegistryObject<SimpleParticleType> SMALL_RIPARIUS_PARTICLES =
            PARTICLE_TYPES.register("small_riparius_particles", () -> new SimpleParticleType(true));

    public static final RegistryObject<SimpleParticleType> VINIFERA_PARTICLES =
            PARTICLE_TYPES.register("vinifera_particles", () -> new SimpleParticleType(true));

    public static final RegistryObject<SimpleParticleType> SMALL_VINIFERA_PARTICLES =
            PARTICLE_TYPES.register("small_vinifera_particles", () -> new SimpleParticleType(true));

    public static final RegistryObject<SimpleParticleType> CRUENTUS_PARTICLES =
            PARTICLE_TYPES.register("cruentus_particles", () -> new SimpleParticleType(true));

    public static final RegistryObject<SimpleParticleType> SMALL_CRUENTUS_PARTICLES =
            PARTICLE_TYPES.register("small_cruentus_particles", () -> new SimpleParticleType(true));

    public static final RegistryObject<SimpleParticleType> ABOREUS_PARTICLES =
            PARTICLE_TYPES.register("aboreus_particles", () -> new SimpleParticleType(true));

    public static final RegistryObject<SimpleParticleType> SMALL_ABOREUS_PARTICLES =
            PARTICLE_TYPES.register("small_aboreus_particles", () -> new SimpleParticleType(true));

    public static final RegistryObject<SimpleParticleType> BLUE_FLAME_PARTICLES =
            PARTICLE_TYPES.register("blue_flame_particles", () -> new SimpleParticleType(true));

public static void register(IEventBus eventBus) {
    PARTICLE_TYPES.register(eventBus);
}
}
