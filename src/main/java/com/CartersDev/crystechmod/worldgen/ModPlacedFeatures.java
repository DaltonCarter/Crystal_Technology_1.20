package com.CartersDev.crystechmod.worldgen;

import com.CartersDev.crystechmod.CrystalTech;
import com.CartersDev.crystechmod.block.ModBlocks;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.data.worldgen.placement.VegetationPlacements;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.blockpredicates.BlockPredicate;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.placement.*;
import net.minecraft.world.level.material.Fluids;

import java.util.List;

public class ModPlacedFeatures {
    //Trees:
    public static final ResourceKey<PlacedFeature> DEAD_PLACED_KEY = registerKey("dead_placed");
    public static final ResourceKey<PlacedFeature> DEAD_HEAVY_PLACED_KEY = registerKey("dead_heavy_placed");
    public static final ResourceKey<PlacedFeature> PLAGUED_PLACED_KEY = registerKey("plagued_placed");
    public static final ResourceKey<PlacedFeature> EMBER_PLACED_KEY = registerKey("ember_placed");
    public static final ResourceKey<PlacedFeature> SM_EMBER_PLACED_KEY = registerKey("sm_ember_placed");
    public static final ResourceKey<PlacedFeature> MARIKA_PLACED_KEY = registerKey("marika_placed");
    public static final ResourceKey<PlacedFeature> SM_MARIKA_PLACED_KEY = registerKey("sm_marika_placed");


    //Ores:
    public static final ResourceKey<PlacedFeature> CRYSTECH_GUNDANIUM_PLACED_KEY = registerKey("crystech_gundanium_ores_placed");
    public static final ResourceKey<PlacedFeature> CRYSTECH_KRYON_PLACED_KEY = registerKey("crystech_kryon_ores_placed");
    public static final ResourceKey<PlacedFeature> CRYSTECH_ILLUMINA_PLACED_KEY = registerKey("crystech_illumina_ores_placed");
    public static final ResourceKey<PlacedFeature> CRYSTECH_ALYTHUM_PLACED_KEY = registerKey("crystech_alythum_ores_placed");
    public static final ResourceKey<PlacedFeature> CRYSTECH_QUALRITE_PLACED_KEY = registerKey("crystech_qualrite_ores_placed");
    public static final ResourceKey<PlacedFeature> CRYSTECH_AERIES_PLACED_KEY = registerKey("crystech_aeries_ores_placed");
    public static final ResourceKey<PlacedFeature> CRYSTECH_ENIGMA_PLACED_KEY = registerKey("crystech_enigma_ores_placed");
    public static final ResourceKey<PlacedFeature> CRYSTECH_DEBRIS_PLACED_KEY = registerKey("crystech_ancient_debris_placed");

    public static final ResourceKey<PlacedFeature> CRYSTECH_NETHER_ALYTHUM_PLACED_KEY = registerKey("crystech_nether_alythum_placed");
    public static final ResourceKey<PlacedFeature> CRYSTECH_NETHER_QUALRITE_PLACED_KEY = registerKey("crystech_nether_qualrite_placed");
    public static final ResourceKey<PlacedFeature> CRYSTECH_NETHER_AERIES_PLACED_KEY = registerKey("crystech_nether_aeries_placed");
    public static final ResourceKey<PlacedFeature> CRYSTECH_NETHER_KRYON_PLACED_KEY = registerKey("crystech_nether_kryon_placed");

    public static final ResourceKey<PlacedFeature> CRYSTECH_END_ENIGMA_PLACED_KEY = registerKey("crystech_end_enigma_placed");
    public static final ResourceKey<PlacedFeature> CRYSTECH_END_KRYON_PLACED_KEY = registerKey("crystech_end_kryon_placed");

    //Geode:
    public static final ResourceKey<PlacedFeature> TIBERIUM_GEODE_PLACED_KEY = registerKey("tiberium_geode_placed");

    //Flowers:
    public static final ResourceKey<PlacedFeature> HYACINTH_PLACED_KEY = registerKey("hyacinth_placed");
    public static final ResourceKey<PlacedFeature> SPITFIRE_PLACED_KEY = registerKey("spitfire_placed");
    public static final ResourceKey<PlacedFeature> FULGURBLOOM_PLACED_KEY = registerKey("fulgurbloom_placed");
    public static final ResourceKey<PlacedFeature> FLOWER_OF_LIFE_PLACED_KEY = registerKey("flower_of_life_placed");
    public static final ResourceKey<PlacedFeature> YOKARAN_BLOOM_PLACED_KEY = registerKey("yokaran_bloom_placed");
    public static final ResourceKey<PlacedFeature> DEVILS_BLOOD_PLACED_KEY = registerKey("devils_blood_placed");

    //Disk:
    public static final ResourceKey<PlacedFeature> CT_MAGMA_PLACED_KEY = registerKey("ct_magma_placed");
    public static final ResourceKey<PlacedFeature> CT_GLOWSTONE_PLACED_KEY = registerKey("ct_glowstone_placed");

    //Springs:

    //Overworld Features:

public static void bootstrap(BootstapContext<PlacedFeature> context) {
    HolderGetter<ConfiguredFeature<?, ?>> configuredFeatures = context.lookup(Registries.CONFIGURED_FEATURE);

    //Trees:
    register(context, DEAD_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.DEAD_KEY),
            VegetationPlacements.treePlacement(PlacementUtils.countExtra(1, 0.5f, 1),
                    ModBlocks.DYING_SAPLING.get()));

    register(context, DEAD_HEAVY_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.DEAD_KEY),
            VegetationPlacements.treePlacement(PlacementUtils.countExtra(1, 0.5f, 3),
                    ModBlocks.DYING_SAPLING.get()));

    register(context, SM_MARIKA_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.SM_MARIKA_KEY),
            VegetationPlacements.treePlacement(PlacementUtils.countExtra(1, 0.5f, 1),
                    ModBlocks.MARIKA_OAK_SAPLING.get()));


    register(context, MARIKA_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.MARIKA_KEY),
            VegetationPlacements.treePlacement(PlacementUtils.countExtra(1, 0.5f, 1),
                    ModBlocks.MARIKA_OAK_SAPLING.get()));

    register(context, SM_EMBER_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.SM_EMBER_KEY),
            VegetationPlacements.treePlacement(PlacementUtils.countExtra(1, 0.5f, 1),
                    ModBlocks.EMBER_OAK_SAPLING.get()));


    register(context, EMBER_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.EMBER_KEY),
            VegetationPlacements.treePlacement(PlacementUtils.countExtra(1, 0.5f, 1),
                    ModBlocks.EMBER_OAK_SAPLING.get()));

    //Ores:
            //Overworld:
    register(context, CRYSTECH_GUNDANIUM_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.CRYSTECH_GUNDANIUM_ORE_KEY),
            ModOrePlacement.commonOrePlacement(6,
                    HeightRangePlacement.triangle(VerticalAnchor.absolute(-64), VerticalAnchor.absolute(40))));

    register(context, CRYSTECH_ALYTHUM_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.CRYSTECH_ALYTHUM_ORE_KEY),
            ModOrePlacement.commonOrePlacement(5,
                    HeightRangePlacement.triangle(VerticalAnchor.absolute(-64), VerticalAnchor.absolute(30))));

    register(context, CRYSTECH_KRYON_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.CRYSTECH_KRYON_ORE_KEY),
            ModOrePlacement.commonOrePlacement(4,
                    HeightRangePlacement.triangle(VerticalAnchor.absolute(-64), VerticalAnchor.absolute(40))));

    register(context, CRYSTECH_ILLUMINA_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.CRYSTECH_ILLUMINA_ORE_KEY),
            ModOrePlacement.commonOrePlacement(3,
                    HeightRangePlacement.triangle(VerticalAnchor.absolute(-64), VerticalAnchor.absolute(30))));

    register(context, CRYSTECH_AERIES_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.CRYSTECH_AERIES_ORE_KEY),
            ModOrePlacement.commonOrePlacement(4,
                    HeightRangePlacement.triangle(VerticalAnchor.absolute(-64), VerticalAnchor.absolute(30))));

    register(context, CRYSTECH_ENIGMA_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.CRYSTECH_ENIGMA_ORE_KEY),
            ModOrePlacement.rareOrePlacement(5,
                    HeightRangePlacement.triangle(VerticalAnchor.absolute(-64), VerticalAnchor.absolute(30))));

    register(context, CRYSTECH_QUALRITE_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.CRYSTECH_QUALRITE_ORE_KEY),
            ModOrePlacement.commonOrePlacement(3,
                    HeightRangePlacement.triangle(VerticalAnchor.absolute(-64), VerticalAnchor.absolute(30))));

    register(context, CRYSTECH_DEBRIS_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.CRYSTECH_ANCIENT_DEBRIS_KEY),
            ModOrePlacement.rareOrePlacement(5,
                    HeightRangePlacement.triangle(VerticalAnchor.absolute(-64), VerticalAnchor.absolute(30))));


    //Nether:
    register(context, CRYSTECH_NETHER_ALYTHUM_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.CRYSTECH_NETHER_ALYTHUM_ORE_KEY),
            ModOrePlacement.commonOrePlacement(5,
                    HeightRangePlacement.triangle(VerticalAnchor.absolute(-64), VerticalAnchor.absolute(100))));

    register(context, CRYSTECH_NETHER_QUALRITE_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.CRYSTECH_NETHER_QUALRITE_ORE_KEY),
            ModOrePlacement.commonOrePlacement(5,
                    HeightRangePlacement.triangle(VerticalAnchor.absolute(-64), VerticalAnchor.absolute(100))));

    register(context, CRYSTECH_NETHER_KRYON_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.CRYSTECH_NETHER_KRYON_ORE_KEY),
            ModOrePlacement.commonOrePlacement(5,
                    HeightRangePlacement.triangle(VerticalAnchor.absolute(-64), VerticalAnchor.absolute(100))));

    register(context, CRYSTECH_NETHER_AERIES_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.CRYSTECH_NETHER_AERIES_ORE_KEY),
            ModOrePlacement.commonOrePlacement(5,
                    HeightRangePlacement.triangle(VerticalAnchor.absolute(-64), VerticalAnchor.absolute(100))));

            //End:
    register(context, CRYSTECH_END_ENIGMA_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.CRYSTECH_END_ENIGMA_ORE_KEY),
            ModOrePlacement.commonOrePlacement(5,
                    HeightRangePlacement.uniform(VerticalAnchor.absolute(-64), VerticalAnchor.absolute(80))));

    register(context, CRYSTECH_END_KRYON_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.CRYSTECH_END_KRYON_ORE_KEY),
            ModOrePlacement.commonOrePlacement(5,
                    HeightRangePlacement.uniform(VerticalAnchor.absolute(-64), VerticalAnchor.absolute(80))));

            //Geode:
    register(context, TIBERIUM_GEODE_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.TIBERIUM_GEODE_KEY),
            List.of(RarityFilter.onAverageOnceEvery(60), InSquarePlacement.spread(),
                    HeightRangePlacement.uniform(VerticalAnchor.aboveBottom(6), VerticalAnchor.absolute(30)),
                    BiomeFilter.biome()));


    //Flowers:
    register(context, HYACINTH_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.HYACINTH_KEY),
            List.of(RarityFilter.onAverageOnceEvery(16), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP, BiomeFilter.biome()));

    register(context, SPITFIRE_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.SPITFIRE_KEY),
            List.of(RarityFilter.onAverageOnceEvery(10), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP, BiomeFilter.biome()));

    register(context, FULGURBLOOM_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.FULGURBLOOM_KEY),
            List.of(RarityFilter.onAverageOnceEvery(10), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP, BiomeFilter.biome()));

    register(context, FLOWER_OF_LIFE_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.FLOWER_OF_LIFE_KEY),
            List.of(RarityFilter.onAverageOnceEvery(10), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP, BiomeFilter.biome()));

    register(context, YOKARAN_BLOOM_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.YOKARAN_BLOOM_KEY),
            List.of(RarityFilter.onAverageOnceEvery(10), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP, BiomeFilter.biome()));

    register(context, DEVILS_BLOOD_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.DEVILS_BLOOD_KEY),
            List.of(RarityFilter.onAverageOnceEvery(10), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP, BiomeFilter.biome()));


    //Disk:
    register(context, CT_MAGMA_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.CT_MAGMA_KEY),
            List.of(CountPlacement.of(1), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_WORLD_SURFACE, BiomeFilter.biome()));

    register(context, CT_GLOWSTONE_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.CT_GLOWSTONE_KEY),
            List.of(CountPlacement.of(1), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_WORLD_SURFACE, BiomeFilter.biome()));

    //Springs:



}



    private static ResourceKey<PlacedFeature> registerKey(String name) {
        return ResourceKey.create(Registries.PLACED_FEATURE, new ResourceLocation(CrystalTech.MOD_ID, name));
    }

    private static void register(BootstapContext<PlacedFeature> context, ResourceKey<PlacedFeature> key, Holder<ConfiguredFeature<?, ?>> configuration,
                                 List<PlacementModifier> modifiers) {
        context.register(key, new PlacedFeature(configuration, List.copyOf(modifiers)));
    }
}
