package com.CartersDev.crystechmod.worldgen.ModFeatureTypes;

import com.CartersDev.crystechmod.CrystalTech;
import com.CartersDev.crystechmod.worldgen.ModFeatureTypes.Features.*;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.ColumnFeatureConfiguration;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModFeatures {
    public static final DeferredRegister<Feature<?>> FEATURES =
            DeferredRegister.create(Registries.FEATURE, CrystalTech.MOD_ID);

    public static final RegistryObject<Feature<ColumnFeatureConfiguration>> RIPARIUS_STONE_COLUMNS =
            FEATURES.register("riparius_stone_columns", () -> new RipariusStoneColumnFeature(ColumnFeatureConfiguration.CODEC));

    public static final RegistryObject<Feature<ColumnFeatureConfiguration>> VINIFERA_STONE_COLUMNS =
            FEATURES.register("vinifera_stone_columns", () -> new ViniferaStoneColumnFeature(ColumnFeatureConfiguration.CODEC));

    public static final RegistryObject<Feature<ColumnFeatureConfiguration>> CRUENTUS_STONE_COLUMNS =
            FEATURES.register("cruentus_stone_columns", () -> new CruentusStoneColumnFeature(ColumnFeatureConfiguration.CODEC));

    public static final RegistryObject<Feature<ColumnFeatureConfiguration>> ABOREUS_STONE_COLUMNS =
            FEATURES.register("aboreus_stone_columns", () -> new AboreusStoneColumnFeature(ColumnFeatureConfiguration.CODEC));


    public static final RegistryObject<Feature<ColumnFeatureConfiguration>> RIPARIUS_CRYSTAL_COLUMNS =
            FEATURES.register("riparius_crystal_columns", () -> new RipariusCrystalColumnFeature(ColumnFeatureConfiguration.CODEC));

    public static final RegistryObject<Feature<ColumnFeatureConfiguration>> VINIFERA_CRYSTAL_COLUMNS =
            FEATURES.register("vinifera_crystal_columns", () -> new ViniferaCrystalColumnFeature(ColumnFeatureConfiguration.CODEC));

    public static final RegistryObject<Feature<ColumnFeatureConfiguration>> CRUENTUS_CRYSTAL_COLUMNS =
            FEATURES.register("cruentus_crystal_columns", () -> new CruentusCrystalColumnFeature(ColumnFeatureConfiguration.CODEC));

    public static final RegistryObject<Feature<ColumnFeatureConfiguration>> ABOREUS_CRYSTAL_COLUMNS =
            FEATURES.register("aboreus_crystal_columns", () -> new AboreusCrystalColumnFeature(ColumnFeatureConfiguration.CODEC));


    public static void register(IEventBus eventBus) {
        FEATURES.register(eventBus);
    }
}

