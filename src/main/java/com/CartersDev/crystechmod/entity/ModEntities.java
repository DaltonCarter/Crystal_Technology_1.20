package com.CartersDev.crystechmod.entity;

import com.CartersDev.crystechmod.CrystalTech;

import com.CartersDev.crystechmod.entity.custom.LaserBeamEntity;
import com.CartersDev.crystechmod.entity.custom.RhinoEntity;
import com.CartersDev.crystechmod.entity.custom.VitricCowEntity;
import com.CartersDev.crystechmod.entity.custom.VitricSheepEntity;
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


    public static final RegistryObject<EntityType<LaserBeamEntity>> LASER_BEAM =
            ENTITY_TYPES.register("laser_beam",
                    () -> EntityType.Builder.<LaserBeamEntity>of(LaserBeamEntity::new, MobCategory.MISC)
                            .sized(0.75f, 0.75f)
                            .clientTrackingRange(7)
                            .updateInterval(20)
                            .build("laser_beam"));


    public static void register(IEventBus eventBus) {
        ENTITY_TYPES.register(eventBus);
    }
}
