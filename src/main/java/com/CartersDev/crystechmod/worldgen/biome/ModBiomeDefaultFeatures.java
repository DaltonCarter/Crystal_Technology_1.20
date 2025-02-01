package com.CartersDev.crystechmod.worldgen.biome;

import com.CartersDev.crystechmod.worldgen.ModPlacedFeatures;
import com.CartersDev.crystechmod.worldgen.carvers.ModCarvers;
import net.minecraft.data.worldgen.Carvers;
import net.minecraft.data.worldgen.placement.CavePlacements;
import net.minecraft.data.worldgen.placement.MiscOverworldPlacements;
import net.minecraft.data.worldgen.placement.OrePlacements;
import net.minecraft.world.level.biome.BiomeGenerationSettings;
import net.minecraft.world.level.levelgen.GenerationStep;

public class ModBiomeDefaultFeatures {

    public static void addYZCarversAndLakes(BiomeGenerationSettings.Builder pBuilder) {
        pBuilder.addCarver(GenerationStep.Carving.AIR, ModCarvers.VITRIC_YZ_CAVE);
        pBuilder.addCarver(GenerationStep.Carving.AIR, ModCarvers.VITRIC_YZ_CAVE_EXTRA_UNDERGROUND);
        pBuilder.addCarver(GenerationStep.Carving.AIR, ModCarvers.VITRIC_YZ_CANYON);
        pBuilder.addFeature(GenerationStep.Decoration.LAKES, MiscOverworldPlacements.LAKE_LAVA_UNDERGROUND);
        pBuilder.addFeature(GenerationStep.Decoration.LAKES, MiscOverworldPlacements.LAKE_LAVA_SURFACE);
    }

    public static void addRZCarversAndLakes(BiomeGenerationSettings.Builder pBuilder) {
        pBuilder.addCarver(GenerationStep.Carving.AIR, ModCarvers.VITRIC_RZ_CAVE);
        pBuilder.addCarver(GenerationStep.Carving.AIR, ModCarvers.VITRIC_RZ_CAVE_EXTRA_UNDERGROUND);
        pBuilder.addCarver(GenerationStep.Carving.AIR, ModCarvers.VITRIC_RZ_CANYON);
        pBuilder.addFeature(GenerationStep.Decoration.LAKES, MiscOverworldPlacements.LAKE_LAVA_UNDERGROUND);
        pBuilder.addFeature(GenerationStep.Decoration.LAKES, MiscOverworldPlacements.LAKE_LAVA_SURFACE);
    }


    public static void addYZUndergroundVariety(BiomeGenerationSettings.Builder pBuilder) {
        pBuilder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, ModPlacedFeatures.CRYSTECH_YELLOW_ZONE_DIRT_PLACED_KEY);
        pBuilder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, ModPlacedFeatures.CRYSTECH_SEEDED_YELLOW_ZONE_DIRT_PLACED_KEY);
        pBuilder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, ModPlacedFeatures.CRYSTECH_INFESTED_GRANITE_UPPER_PLACED_KEY);
        pBuilder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, ModPlacedFeatures.CRYSTECH_INFESTED_GRANITE_LOWER_PLACED_KEY);
        pBuilder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, ModPlacedFeatures.CRYSTECH_INFESTED_DIORITE_UPPER_PLACED_KEY);
        pBuilder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, ModPlacedFeatures.CRYSTECH_INFESTED_DIORITE_LOWER_PLACED_KEY);
        pBuilder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, ModPlacedFeatures.CRYSTECH_INFESTED_ANDESITE_UPPER_PLACED_KEY);
        pBuilder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, ModPlacedFeatures.CRYSTECH_INFESTED_ANDESITE_LOWER_PLACED_KEY);
        pBuilder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, ModPlacedFeatures.CT_RIPARIUS_STONE_CLUMP_PLACED_KEY);
        pBuilder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, ModPlacedFeatures.CT_VINIFERA_STONE_CLUMP_PLACED_KEY);
        pBuilder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, ModPlacedFeatures.CRYSTECH_VITRIC_DEEPSLATE_PLACED_KEY);
        pBuilder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, OrePlacements.ORE_TUFF);
        pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, CavePlacements.GLOW_LICHEN);
    }

    public static void addRZUndergroundVariety(BiomeGenerationSettings.Builder pBuilder) {
        pBuilder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, ModPlacedFeatures.CRYSTECH_RED_ZONE_DIRT_PLACED_KEY);
        pBuilder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, ModPlacedFeatures.CRYSTECH_SEEDED_RED_ZONE_DIRT_PLACED_KEY);
        pBuilder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, ModPlacedFeatures.CRYSTECH_INFESTED_GRANITE_UPPER_PLACED_KEY);
        pBuilder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, ModPlacedFeatures.CRYSTECH_INFESTED_GRANITE_LOWER_PLACED_KEY);
        pBuilder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, ModPlacedFeatures.CRYSTECH_INFESTED_DIORITE_UPPER_PLACED_KEY);
        pBuilder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, ModPlacedFeatures.CRYSTECH_INFESTED_DIORITE_LOWER_PLACED_KEY);
        pBuilder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, ModPlacedFeatures.CRYSTECH_INFESTED_ANDESITE_UPPER_PLACED_KEY);
        pBuilder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, ModPlacedFeatures.CRYSTECH_INFESTED_ANDESITE_LOWER_PLACED_KEY);
        pBuilder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, ModPlacedFeatures.CT_RIPARIUS_STONE_CLUMP_PLACED_KEY);
        pBuilder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, ModPlacedFeatures.CT_VINIFERA_STONE_CLUMP_PLACED_KEY);
        pBuilder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, ModPlacedFeatures.CT_CRUENTUS_STONE_CLUMP_PLACED_KEY);
        pBuilder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, ModPlacedFeatures.CT_ABOREUS_STONE_CLUMP_PLACED_KEY);
        pBuilder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, ModPlacedFeatures.CRYSTECH_VITRIC_DEEPSLATE_PLACED_KEY);
        pBuilder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, OrePlacements.ORE_TUFF);
        pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, CavePlacements.GLOW_LICHEN);
    }

    public static void addYZSoftDisks(BiomeGenerationSettings.Builder pBuilder) {
        pBuilder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, ModPlacedFeatures.CT_YELLOW_ZONE_SAND_KEY);
        pBuilder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, MiscOverworldPlacements.DISK_CLAY);
        pBuilder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, MiscOverworldPlacements.DISK_GRAVEL);
    }

    public static void addRZSoftDisks(BiomeGenerationSettings.Builder pBuilder) {
        pBuilder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, ModPlacedFeatures.CT_RED_ZONE_SAND_PLACED_KEY);
        pBuilder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, MiscOverworldPlacements.DISK_CLAY);
        pBuilder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, MiscOverworldPlacements.DISK_GRAVEL);
    }

}
