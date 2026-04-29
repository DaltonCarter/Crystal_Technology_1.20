package com.CartersDev.crystechmod.entity;

import com.CartersDev.crystechmod.CrystalTech;

import com.CartersDev.crystechmod.entity.custom.*;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModEntities {
    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES =
            DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, CrystalTech.MOD_ID);

public static final RegistryObject<EntityType<RhinoEntity>> RHINO =
        ENTITY_TYPES.register("rhino", () -> EntityType.Builder.of(RhinoEntity::new, MobCategory.CREATURE)
                .sized(2.5F, 2.5F).build("rhino"));

    public static final RegistryObject<EntityType<VitricSheepEntity>> VITRIC_SHEEP =
            ENTITY_TYPES.register("vitric_sheep", () -> EntityType.Builder.of(VitricSheepEntity::new, MobCategory.CREATURE)
                    .sized(0.9F, 1.3F).build("vitric_sheep"));

    public static final RegistryObject<EntityType<VitricCowEntity>> VITRIC_COW =
            ENTITY_TYPES.register("vitric_cow", () -> EntityType.Builder.of(VitricCowEntity::new, MobCategory.CREATURE)
                    .sized(0.9F, 1.4F).build("vitric_cow"));


    //Projectiles Lasers:
    public static final RegistryObject<EntityType<LaserBeamEntity>> LASER_BEAM =
            ENTITY_TYPES.register("laser_beam",
                    () -> EntityType.Builder.<LaserBeamEntity>of(LaserBeamEntity::new, MobCategory.MISC)
                            .sized(0.75f, 0.75f)
                            .clientTrackingRange(7)
                            .updateInterval(20)
                            .build("laser_beam"));

    public static final RegistryObject<EntityType<ImprovedLaserBeamEntity>> IMPROVED_LASER_BEAM =
            ENTITY_TYPES.register("improved_laser_beam",
                    () -> EntityType.Builder.<ImprovedLaserBeamEntity>of(ImprovedLaserBeamEntity::new, MobCategory.MISC)
                            .sized(0.75f, 0.75f)
                            .clientTrackingRange(7)
                            .updateInterval(20)
                            .build("improved_laser_beam"));

    public static final RegistryObject<EntityType<AdvancedLaserBeamEntity>> ADVANCED_LASER_BEAM =
            ENTITY_TYPES.register("advanced_laser_beam",
                    () -> EntityType.Builder.<AdvancedLaserBeamEntity>of(AdvancedLaserBeamEntity::new, MobCategory.MISC)
                            .sized(0.75f, 0.75f)
                            .clientTrackingRange(7)
                            .updateInterval(20)
                            .build("advanced_laser_beam"));

    public static final RegistryObject<EntityType<OverchargedLaserBeamEntity>> OVERCHARGED_LASER_BEAM =
            ENTITY_TYPES.register("overcharged_laser_beam",
                    () -> EntityType.Builder.<OverchargedLaserBeamEntity>of(OverchargedLaserBeamEntity::new, MobCategory.MISC)
                            .sized(0.75f, 0.75f)
                            .clientTrackingRange(7)
                            .updateInterval(20)
                            .build("overcharged_laser_beam"));

    public static final RegistryObject<EntityType<ProtocultureLaserBeamEntity>> PROTOCULTURE_LASER_BEAM =
            ENTITY_TYPES.register("protoculture_laser_beam",
                    () -> EntityType.Builder.<ProtocultureLaserBeamEntity>of(ProtocultureLaserBeamEntity::new, MobCategory.MISC)
                            .sized(0.75f, 0.75f)
                            .clientTrackingRange(7)
                            .updateInterval(20)
                            .build("protoculture_laser_beam"));

    public static final RegistryObject<EntityType<PoisonLaserBeamEntity>> POISON_LASER_BEAM =
            ENTITY_TYPES.register("poison_laser_beam",
                    () -> EntityType.Builder.<PoisonLaserBeamEntity>of(PoisonLaserBeamEntity::new, MobCategory.MISC)
                            .sized(0.75f, 0.75f)
                            .clientTrackingRange(7)
                            .updateInterval(20)
                            .build("poison_laser_beam"));


    public static void register(IEventBus eventBus) {
        ENTITY_TYPES.register(eventBus);
    }
}
