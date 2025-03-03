package com.CartersDev.crystechmod.worldgen;

import com.CartersDev.crystechmod.CrystalTech;
import com.CartersDev.crystechmod.block.ModBlocks;
import com.CartersDev.crystechmod.fluid.ModFluids;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.data.worldgen.placement.VegetationPlacements;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.blockpredicates.BlockPredicate;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.heightproviders.UniformHeight;
import net.minecraft.world.level.levelgen.heightproviders.VeryBiasedToBottomHeight;
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

    public static final ResourceKey<PlacedFeature> CRYSTECH_YELLOW_ZONE_DIRT_PLACED_KEY = registerKey("crystech_yellow_zone_dirt_placed");
    public static final ResourceKey<PlacedFeature> CRYSTECH_SEEDED_YELLOW_ZONE_DIRT_PLACED_KEY = registerKey("crystech_seeded_yellow_zone_dirt_placed");
    public static final ResourceKey<PlacedFeature> CRYSTECH_RED_ZONE_DIRT_PLACED_KEY = registerKey("crystech_red_zone_dirt_placed");
    public static final ResourceKey<PlacedFeature> CRYSTECH_SEEDED_RED_ZONE_DIRT_PLACED_KEY = registerKey("crystech_seeded_red_zone_dirt_placed");

    public static final ResourceKey<PlacedFeature> CRYSTECH_INFESTED_GRANITE_UPPER_PLACED_KEY = registerKey("crystech_infested_granite_upper_placed");
    public static final ResourceKey<PlacedFeature> CRYSTECH_INFESTED_GRANITE_LOWER_PLACED_KEY = registerKey("crystech_infested_granite_lower_placed");

    public static final ResourceKey<PlacedFeature> CRYSTECH_INFESTED_DIORITE_UPPER_PLACED_KEY = registerKey("crystech_infested_diorite_upper_placed");
    public static final ResourceKey<PlacedFeature> CRYSTECH_INFESTED_DIORITE_LOWER_PLACED_KEY = registerKey("crystech_infested_diorite_lower_placed");

    public static final ResourceKey<PlacedFeature> CRYSTECH_INFESTED_ANDESITE_UPPER_PLACED_KEY = registerKey("crystech_infested_andesite_upper_placed");
    public static final ResourceKey<PlacedFeature> CRYSTECH_INFESTED_ANDESITE_LOWER_PLACED_KEY = registerKey("crystech_infested_andesite_lower_placed");

    public static final ResourceKey<PlacedFeature> CRYSTECH_VITRIC_DEEPSLATE_PLACED_KEY = registerKey("crystech_vitric_deepslate_placed");

    public static final ResourceKey<PlacedFeature> CT_RIPARIUS_STONE_CLUMP_PLACED_KEY = registerKey("ct_riparius_stone_clump_placed");
    public static final ResourceKey<PlacedFeature> CT_VINIFERA_STONE_CLUMP_PLACED_KEY = registerKey("ct_vinifera_stone_clump_placed");
    public static final ResourceKey<PlacedFeature> CT_CRUENTUS_STONE_CLUMP_PLACED_KEY = registerKey("ct_cruentus_stone_clump_placed");
    public static final ResourceKey<PlacedFeature> CT_ABOREUS_STONE_CLUMP_PLACED_KEY = registerKey("ct_aboreus_stone_clump_placed");

    //Geode:
    public static final ResourceKey<PlacedFeature> TIBERIUM_GEODE_PLACED_KEY = registerKey("tiberium_geode_placed");

    public static final ResourceKey<PlacedFeature> VITRIC_TIBERIUM_GEODE_PLACED_KEY = registerKey("vitric_tiberium_geode_placed");
    public static final ResourceKey<PlacedFeature> VITRIC_ICHOR_GEODE_PLACED_KEY = registerKey("vitric_ichor_geode_placed");
    public static final ResourceKey<PlacedFeature> VITRIC_AMETHYST_GEODE_PLACED_KEY = registerKey("vitric_amethyst_geode_placed");

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

    public static final ResourceKey<PlacedFeature> CT_YELLOW_ZONE_SAND_KEY = registerKey("ct_yellow_zone_sand_placed");
    public static final ResourceKey<PlacedFeature> CT_RED_ZONE_SAND_PLACED_KEY = registerKey("ct_red_zone_sand_placed");

    public static final ResourceKey<PlacedFeature> CT_TIBERIUM_SOIL_PLACED_KEY = registerKey("ct_tiberium_soil_placed");
    public static final ResourceKey<PlacedFeature> CT_ICHOR_SOIL_PLACED_KEY = registerKey("ct_ichor_soil_placed");

    public static final ResourceKey<PlacedFeature> CT_DIRT_PLACED_KEY = registerKey("ct_dirt_placed");
    public static final ResourceKey<PlacedFeature> CT_YELLOW_ZONE_DIRT_PLACED_KEY = registerKey("ct_yellow_zone_dirt_placed");
    public static final ResourceKey<PlacedFeature> CT_RED_ZONE_DIRT_PLACED_KEY = registerKey("ct_red_zone_dirt_placed");

    public static final ResourceKey<PlacedFeature> CT_SEEDED_DIRT_PLACED_KEY = registerKey("ct_seeded_dirt_placed");
    public static final ResourceKey<PlacedFeature> CT_SEEDED_YELLOW_ZONE_DIRT_PLACED_KEY = registerKey("ct_seeded_yellow_zone_dirt_placed");
    public static final ResourceKey<PlacedFeature> CT_SEEDED_RED_ZONE_DIRT_PLACED_KEY = registerKey("ct_seeded_red_zone_dirt_placed");


    //Blobs:

    public static final ResourceKey<PlacedFeature> CT_RIPARIUS_STONE_PLACED_KEY = registerKey("ct_riparius_stone_placed");
    public static final ResourceKey<PlacedFeature> CT_VINIFERA_STONE_PLACED_KEY = registerKey("ct_vinifera_stone_placed");
    public static final ResourceKey<PlacedFeature> CT_CRUENTUS_STONE_PLACED_KEY = registerKey("ct_cruentus_stone_placed");
    public static final ResourceKey<PlacedFeature> CT_ABOREUS_STONE_PLACED_KEY = registerKey("ct_aboreus_stone_placed");

    public static final ResourceKey<PlacedFeature> CT_RIPARIUS_CRYSTAL_PLACED_KEY = registerKey("ct_riparius_crystal_placed");
    public static final ResourceKey<PlacedFeature> CT_VINIFERA_CRYSTAL_PLACED_KEY = registerKey("ct_vinifera_crystal_placed");
    public static final ResourceKey<PlacedFeature> CT_CRUENTUS_CRYSTAL_PLACED_KEY = registerKey("ct_cruentus_crystal_placed");
    public static final ResourceKey<PlacedFeature> CT_ABOREUS_CRYSTAL_PLACED_KEY = registerKey("ct_aboreus_crystal_placed");
    
    //Springs:
    public static final ResourceKey<PlacedFeature> CT_INFECTED_WATER_SPRING_PLACED_KEY = registerKey("ct_infected_water_spring_placed");

    public static final ResourceKey<PlacedFeature> CT_MOLTEN_RIPARIUS_SPRING_UPPER_PLACED_KEY = registerKey("ct_molten_riparius_spring_upper_placed");
    public static final ResourceKey<PlacedFeature> CT_MOLTEN_VINIFERA_SPRING_UPPER_PLACED_KEY = registerKey("ct_molten_vinifera_spring_upper_placed");
    public static final ResourceKey<PlacedFeature> CT_MOLTEN_CRUENTUS_SPRING_UPPER_PLACED_KEY = registerKey("ct_molten_cruentus_spring_upper_placed");
    public static final ResourceKey<PlacedFeature> CT_MOLTEN_ABOREUS_SPRING_UPPER_PLACED_KEY = registerKey("ct_molten_aboreus_spring_upper_placed");

    public static final ResourceKey<PlacedFeature> CT_MOLTEN_RIPARIUS_SPRING_LOWER_PLACED_KEY = registerKey("ct_molten_riparius_spring_lower_placed");
    public static final ResourceKey<PlacedFeature> CT_MOLTEN_VINIFERA_SPRING_LOWER_PLACED_KEY = registerKey("ct_molten_vinifera_spring_lower_placed");
    public static final ResourceKey<PlacedFeature> CT_MOLTEN_CRUENTUS_SPRING_LOWER_PLACED_KEY = registerKey("ct_molten_cruentus_spring_lower_placed");
    public static final ResourceKey<PlacedFeature> CT_MOLTEN_ABOREUS_SPRING_LOWER_PLACED_KEY = registerKey("ct_molten_aboreus_spring_lower_placed");

    //Lakes:
    public static final ResourceKey<PlacedFeature> CT_INFECTED_WATER_SURFACE_LAKE_PLACED_KEY = registerKey("ct_infected_water_surface_lake_placed");

    public static final ResourceKey<PlacedFeature> CT_MOLTEN_RIPARIUS_SURFACE_LAKE_PLACED_KEY = registerKey("ct_molten_riparius_surface_lake_placed");
    public static final ResourceKey<PlacedFeature> CT_MOLTEN_VINIFERA_SURFACE_LAKE_PLACED_KEY = registerKey("ct_molten_vinifera_surface_lake_placed");
    public static final ResourceKey<PlacedFeature> CT_MOLTEN_CRUENTUS_SURFACE_LAKE_PLACED_KEY = registerKey("ct_molten_cruentus_surface_lake_placed");
    public static final ResourceKey<PlacedFeature> CT_MOLTEN_ABOREUS_SURFACE_LAKE_PLACED_KEY = registerKey("ct_molten_aboreus_surface_lake_placed");

    public static final ResourceKey<PlacedFeature> CT_INFECTED_WATER_UNDERGROUND_LAKE_PLACED_KEY = registerKey("ct_infected_water_underground_lake_placed");

    public static final ResourceKey<PlacedFeature> CT_MOLTEN_RIPARIUS_UNDERGROUND_LAKE_PLACED_KEY = registerKey("ct_molten_riparius_underground_lake_placed");
    public static final ResourceKey<PlacedFeature> CT_MOLTEN_VINIFERA_UNDERGROUND_LAKE_PLACED_KEY = registerKey("ct_molten_vinifera_underground_lake_placed");
    public static final ResourceKey<PlacedFeature> CT_MOLTEN_CRUENTUS_UNDERGROUND_LAKE_PLACED_KEY = registerKey("ct_molten_cruentus_underground_lake_placed");
    public static final ResourceKey<PlacedFeature> CT_MOLTEN_ABOREUS_UNDERGROUND_LAKE_PLACED_KEY = registerKey("ct_molten_aboreus_underground_lake_placed");

    //Small Columns:
    public static final ResourceKey<PlacedFeature> CT_RIPARIUS_STONE_SMALL_COLUMN_PLACED_KEY = registerKey("ct_riparius_stone_small_column_placed");
    public static final ResourceKey<PlacedFeature> CT_VINIFERA_STONE_SMALL_COLUMN_PLACED_KEY = registerKey("ct_vinifera_stone_small_column_placed");
    public static final ResourceKey<PlacedFeature> CT_CRUENTUS_STONE_SMALL_COLUMN_PLACED_KEY = registerKey("ct_cruentus_stone_small_column_placed");
    public static final ResourceKey<PlacedFeature> CT_ABOREUS_STONE_SMALL_COLUMN_PLACED_KEY = registerKey("ct_aboreus_stone_small_column_placed");

    public static final ResourceKey<PlacedFeature> CT_RIPARIUS_CRYSTAL_SMALL_COLUMN_PLACED_KEY = registerKey("ct_riparius_crystal_small_column_placed");
    public static final ResourceKey<PlacedFeature> CT_VINIFERA_CRYSTAL_SMALL_COLUMN_PLACED_KEY = registerKey("ct_vinifera_crystal_small_column_placed");
    public static final ResourceKey<PlacedFeature> CT_CRUENTUS_CRYSTAL_SMALL_COLUMN_PLACED_KEY = registerKey("ct_cruentus_crystal_small_column_placed");
    public static final ResourceKey<PlacedFeature> CT_ABOREUS_CRYSTAL_SMALL_COLUMN_PLACED_KEY = registerKey("ct_aboreus_crystal_small_column_placed");

    //Large Columns:
    public static final ResourceKey<PlacedFeature> CT_RIPARIUS_STONE_LARGE_COLUMN_PLACED_KEY = registerKey("ct_riparius_stone_large_column_placed");
    public static final ResourceKey<PlacedFeature> CT_VINIFERA_STONE_LARGE_COLUMN_PLACED_KEY = registerKey("ct_vinifera_stone_large_column_placed");
    public static final ResourceKey<PlacedFeature> CT_CRUENTUS_STONE_LARGE_COLUMN_PLACED_KEY = registerKey("ct_cruentus_stone_large_column_placed");
    public static final ResourceKey<PlacedFeature> CT_ABOREUS_STONE_LARGE_COLUMN_PLACED_KEY = registerKey("ct_aboreus_stone_large_column_placed");

    public static final ResourceKey<PlacedFeature> CT_RIPARIUS_CRYSTAL_LARGE_COLUMN_PLACED_KEY = registerKey("ct_riparius_crystal_large_column_placed");
    public static final ResourceKey<PlacedFeature> CT_VINIFERA_CRYSTAL_LARGE_COLUMN_PLACED_KEY = registerKey("ct_vinifera_crystal_large_column_placed");
    public static final ResourceKey<PlacedFeature> CT_CRUENTUS_CRYSTAL_LARGE_COLUMN_PLACED_KEY = registerKey("ct_cruentus_crystal_large_column_placed");
    public static final ResourceKey<PlacedFeature> CT_ABOREUS_CRYSTAL_LARGE_COLUMN_PLACED_KEY = registerKey("ct_aboreus_crystal_large_column_placed");



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

    register(context, PLAGUED_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.PLAGUED_KEY),
            VegetationPlacements.treePlacement(PlacementUtils.countExtra(1, 0.5f, 2),
                    ModBlocks.PLAGUED_SAPLING.get()));

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



    //Alt Stones and dirts for the Vitric Expanse:

    register(context, CRYSTECH_YELLOW_ZONE_DIRT_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.CRYSTECH_YELLOW_ZONE_DIRT_KEY),
            ModOrePlacement.commonOrePlacement(7,
                    HeightRangePlacement.uniform(VerticalAnchor.absolute(0), VerticalAnchor.absolute(160))));

    register(context, CRYSTECH_SEEDED_YELLOW_ZONE_DIRT_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.CRYSTECH_SEEDED_YELLOW_ZONE_DIRT_KEY),
            ModOrePlacement.commonOrePlacement(7,
                    HeightRangePlacement.uniform(VerticalAnchor.absolute(0), VerticalAnchor.absolute(160))));

    register(context, CRYSTECH_RED_ZONE_DIRT_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.CRYSTECH_RED_ZONE_DIRT_KEY),
            ModOrePlacement.commonOrePlacement(7,
                    HeightRangePlacement.uniform(VerticalAnchor.absolute(0), VerticalAnchor.absolute(160))));

    register(context, CRYSTECH_SEEDED_RED_ZONE_DIRT_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.CRYSTECH_SEEDED_RED_ZONE_DIRT_KEY),
            ModOrePlacement.commonOrePlacement(7,
                    HeightRangePlacement.uniform(VerticalAnchor.absolute(0), VerticalAnchor.absolute(160))));


    register(context, CRYSTECH_INFESTED_GRANITE_UPPER_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.CRYSTECH_INFESTED_GRANITE_KEY),
            ModOrePlacement.rareOrePlacement(6,
                    HeightRangePlacement.uniform(VerticalAnchor.absolute(64), VerticalAnchor.absolute(128))));

    register(context, CRYSTECH_INFESTED_GRANITE_LOWER_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.CRYSTECH_INFESTED_GRANITE_KEY),
            ModOrePlacement.commonOrePlacement(2,
                    HeightRangePlacement.uniform(VerticalAnchor.absolute(0), VerticalAnchor.absolute(60))));

    register(context, CRYSTECH_INFESTED_DIORITE_UPPER_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.CRYSTECH_INFESTED_DIORITE_KEY),
            ModOrePlacement.rareOrePlacement(6,
                    HeightRangePlacement.uniform(VerticalAnchor.absolute(64), VerticalAnchor.absolute(128))));

    register(context, CRYSTECH_INFESTED_DIORITE_LOWER_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.CRYSTECH_INFESTED_DIORITE_KEY),
            ModOrePlacement.commonOrePlacement(2,
                    HeightRangePlacement.uniform(VerticalAnchor.absolute(0), VerticalAnchor.absolute(60))));

    register(context, CRYSTECH_INFESTED_ANDESITE_UPPER_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.CRYSTECH_INFESTED_ANDESITE_KEY),
            ModOrePlacement.rareOrePlacement(6,
                    HeightRangePlacement.uniform(VerticalAnchor.absolute(64), VerticalAnchor.absolute(128))));

    register(context, CRYSTECH_INFESTED_ANDESITE_LOWER_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.CRYSTECH_INFESTED_ANDESITE_KEY),
            ModOrePlacement.commonOrePlacement(2,
                    HeightRangePlacement.uniform(VerticalAnchor.absolute(0), VerticalAnchor.absolute(60))));

    register(context, CRYSTECH_VITRIC_DEEPSLATE_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.CRYSTECH_VITRIC_DEEPSLATE_KEY),
            ModOrePlacement.commonOrePlacement(4,
                    HeightRangePlacement.uniform(VerticalAnchor.absolute(-64), VerticalAnchor.absolute(0))));

    register(context, CT_RIPARIUS_STONE_CLUMP_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.CT_RIPARIUS_STONE_CLUMP_KEY),
            ModOrePlacement.commonOrePlacement(2,
                    HeightRangePlacement.uniform(VerticalAnchor.absolute(0), VerticalAnchor.absolute(60))));

    register(context, CT_VINIFERA_STONE_CLUMP_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.CT_VINIFERA_STONE_CLUMP_KEY),
            ModOrePlacement.commonOrePlacement(2,
                    HeightRangePlacement.uniform(VerticalAnchor.absolute(0), VerticalAnchor.absolute(60))));

    register(context, CT_CRUENTUS_STONE_CLUMP_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.CT_CRUENTUS_STONE_CLUMP_KEY),
            ModOrePlacement.commonOrePlacement(2,
                    HeightRangePlacement.uniform(VerticalAnchor.absolute(-64), VerticalAnchor.absolute(0))));

    register(context, CT_ABOREUS_STONE_CLUMP_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.CT_ABOREUS_STONE_CLUMP_KEY),
            ModOrePlacement.commonOrePlacement(2,
                    HeightRangePlacement.uniform(VerticalAnchor.absolute(-64), VerticalAnchor.absolute(0))));




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

    register(context, VITRIC_AMETHYST_GEODE_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.VITRIC_AMETHYST_GEODE_KEY),
            List.of(RarityFilter.onAverageOnceEvery(60), InSquarePlacement.spread(),
                    HeightRangePlacement.uniform(VerticalAnchor.aboveBottom(6), VerticalAnchor.absolute(30)),
                    BiomeFilter.biome()));

    register(context, VITRIC_ICHOR_GEODE_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.VITRIC_ICHOR_GEODE_KEY),
            List.of(RarityFilter.onAverageOnceEvery(60), InSquarePlacement.spread(),
                    HeightRangePlacement.uniform(VerticalAnchor.aboveBottom(6), VerticalAnchor.absolute(30)),
                    BiomeFilter.biome()));

    register(context, VITRIC_TIBERIUM_GEODE_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.VITRIC_TIBERIUM_GEODE_KEY),
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

    register(context, CT_YELLOW_ZONE_SAND_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.CT_YELLOW_ZONE_SAND_KEY),
            List.of(CountPlacement.of(3), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_TOP_SOLID, BlockPredicateFilter.forPredicate(BlockPredicate.matchesFluids(Fluids.WATER, ModFluids.SOURCE_TIBERIUM_WATER.get())), BiomeFilter.biome()));

    register(context, CT_RED_ZONE_SAND_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.CT_RED_ZONE_SAND_KEY),
            List.of(CountPlacement.of(3), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_TOP_SOLID, BlockPredicateFilter.forPredicate(BlockPredicate.matchesFluids(Fluids.WATER, ModFluids.SOURCE_TIBERIUM_WATER.get())), BiomeFilter.biome()));

    register(context, CT_TIBERIUM_SOIL_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.CT_TIBERIUM_SOIL_KEY),
            List.of(CountPlacement.of(1), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_WORLD_SURFACE, BiomeFilter.biome()));

    register(context, CT_ICHOR_SOIL_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.CT_ICHOR_SOIL_KEY),
            List.of(CountPlacement.of(1), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_WORLD_SURFACE, BiomeFilter.biome()));

    register(context, CT_DIRT_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.CT_DIRT_KEY),
            List.of(CountPlacement.of(1), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_WORLD_SURFACE, BiomeFilter.biome()));

    register(context, CT_SEEDED_DIRT_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.CT_SEEDED_DIRT_KEY),
            List.of(CountPlacement.of(1), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_WORLD_SURFACE, BiomeFilter.biome()));

    register(context, CT_YELLOW_ZONE_DIRT_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.CT_YELLOW_ZONE_DIRT_KEY),
            List.of(CountPlacement.of(1), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_WORLD_SURFACE, BiomeFilter.biome()));

    register(context, CT_SEEDED_YELLOW_ZONE_DIRT_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.CT_SEEDED_YELLOW_ZONE_DIRT_KEY),
            List.of(CountPlacement.of(1), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_WORLD_SURFACE, BiomeFilter.biome()));

    register(context, CT_RED_ZONE_DIRT_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.CT_RED_ZONE_DIRT_KEY),
            List.of(CountPlacement.of(1), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_WORLD_SURFACE, BiomeFilter.biome()));

    register(context, CT_SEEDED_RED_ZONE_DIRT_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.CT_SEEDED_RED_ZONE_DIRT_KEY),
            List.of(CountPlacement.of(1), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_WORLD_SURFACE, BiomeFilter.biome()));

    //Blobs:

    register(context, CT_RIPARIUS_STONE_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.CT_RIPARIUS_STONE_KEY),
            List.of(CountPlacement.of(2), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP, BiomeFilter.biome()));

    register(context, CT_VINIFERA_STONE_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.CT_VINIFERA_STONE_KEY),
            List.of(CountPlacement.of(2), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP, BiomeFilter.biome()));

    register(context, CT_CRUENTUS_STONE_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.CT_CRUENTUS_STONE_KEY),
            List.of(CountPlacement.of(2), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP, BiomeFilter.biome()));

    register(context, CT_ABOREUS_STONE_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.CT_ABOREUS_STONE_KEY),
            List.of(CountPlacement.of(2), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP, BiomeFilter.biome()));

    register(context, CT_RIPARIUS_CRYSTAL_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.CT_RIPARIUS_CRYSTAL_KEY),
            List.of(CountPlacement.of(2), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP, BiomeFilter.biome()));

    register(context, CT_VINIFERA_CRYSTAL_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.CT_VINIFERA_CRYSTAL_KEY),
            List.of(CountPlacement.of(2), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP, BiomeFilter.biome()));

    register(context, CT_CRUENTUS_CRYSTAL_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.CT_CRUENTUS_CRYSTAL_KEY),
            List.of(CountPlacement.of(2), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP, BiomeFilter.biome()));

    register(context, CT_ABOREUS_CRYSTAL_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.CT_ABOREUS_CRYSTAL_KEY),
            List.of(CountPlacement.of(2), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP, BiomeFilter.biome()));
    
    //Springs:
    register(context, CT_INFECTED_WATER_SPRING_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.CT_INFECTED_WATER_SPRING_KEY),
            List.of(CountPlacement.of(25), InSquarePlacement.spread(), HeightRangePlacement.uniform(VerticalAnchor.bottom(), VerticalAnchor.absolute(192)), BiomeFilter.biome()));

    register(context, CT_MOLTEN_RIPARIUS_SPRING_LOWER_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.CT_MOLTEN_RIPARIUS_SPRING_KEY),
            List.of(CountPlacement.of(25), InSquarePlacement.spread(), HeightRangePlacement.of(VeryBiasedToBottomHeight.of(VerticalAnchor.bottom(), VerticalAnchor.belowTop(8), 8)), BiomeFilter.biome()));

    register(context, CT_MOLTEN_VINIFERA_SPRING_LOWER_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.CT_MOLTEN_VINIFERA_SPRING_KEY),
            List.of(CountPlacement.of(25), InSquarePlacement.spread(), HeightRangePlacement.of(VeryBiasedToBottomHeight.of(VerticalAnchor.bottom(), VerticalAnchor.belowTop(8), 8)), BiomeFilter.biome()));

    register(context, CT_MOLTEN_CRUENTUS_SPRING_LOWER_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.CT_MOLTEN_CRUENTUS_SPRING_KEY),
            List.of(CountPlacement.of(25), InSquarePlacement.spread(), HeightRangePlacement.of(VeryBiasedToBottomHeight.of(VerticalAnchor.bottom(), VerticalAnchor.belowTop(8), 8)), BiomeFilter.biome()));

    register(context, CT_MOLTEN_ABOREUS_SPRING_LOWER_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.CT_MOLTEN_ABOREUS_SPRING_KEY),
            List.of(CountPlacement.of(25), InSquarePlacement.spread(), HeightRangePlacement.of(VeryBiasedToBottomHeight.of(VerticalAnchor.bottom(), VerticalAnchor.belowTop(8), 8)), BiomeFilter.biome()));


    register(context, CT_MOLTEN_RIPARIUS_SPRING_UPPER_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.CT_MOLTEN_RIPARIUS_SPRING_KEY),
            List.of(CountPlacement.of(15), InSquarePlacement.spread(), HeightRangePlacement.uniform(VerticalAnchor.absolute(0), VerticalAnchor.absolute(192)), BiomeFilter.biome()));

    register(context, CT_MOLTEN_VINIFERA_SPRING_UPPER_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.CT_MOLTEN_VINIFERA_SPRING_KEY),
            List.of(CountPlacement.of(15), InSquarePlacement.spread(), HeightRangePlacement.uniform(VerticalAnchor.absolute(0), VerticalAnchor.absolute(192)), BiomeFilter.biome()));

    register(context, CT_MOLTEN_CRUENTUS_SPRING_UPPER_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.CT_MOLTEN_CRUENTUS_SPRING_KEY),
            List.of(CountPlacement.of(15), InSquarePlacement.spread(), HeightRangePlacement.uniform(VerticalAnchor.absolute(0), VerticalAnchor.absolute(192)), BiomeFilter.biome()));

    register(context, CT_MOLTEN_ABOREUS_SPRING_UPPER_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.CT_MOLTEN_ABOREUS_SPRING_KEY),
            List.of(CountPlacement.of(15), InSquarePlacement.spread(), HeightRangePlacement.uniform(VerticalAnchor.absolute(0), VerticalAnchor.absolute(192)), BiomeFilter.biome()));


    //Lakes:
    register(context, CT_INFECTED_WATER_SURFACE_LAKE_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.CT_INFECTED_WATER_LAKE_KEY),
    List.of(RarityFilter.onAverageOnceEvery(10), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_WORLD_SURFACE, BiomeFilter.biome()));


    register(context, CT_INFECTED_WATER_UNDERGROUND_LAKE_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.CT_INFECTED_WATER_LAKE_KEY),
            List.of(RarityFilter.onAverageOnceEvery(9), InSquarePlacement.spread(),  HeightRangePlacement.of(UniformHeight.of(VerticalAnchor.absolute(0), VerticalAnchor.top())),
                    EnvironmentScanPlacement.scanningFor(Direction.DOWN, BlockPredicate.allOf(BlockPredicate.not(BlockPredicate.ONLY_IN_AIR_PREDICATE),
                            BlockPredicate.insideWorld(new BlockPos(0, -5, 0))), 32), SurfaceRelativeThresholdFilter.of(Heightmap.Types.OCEAN_FLOOR_WG,
                            Integer.MIN_VALUE, -5), BiomeFilter.biome()));


    register(context, CT_MOLTEN_RIPARIUS_SURFACE_LAKE_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.CT_MOLTEN_RIPARIUS_LAKE_KEY),
            List.of(RarityFilter.onAverageOnceEvery(10), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_WORLD_SURFACE, BiomeFilter.biome()));


    register(context, CT_MOLTEN_RIPARIUS_UNDERGROUND_LAKE_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.CT_MOLTEN_RIPARIUS_LAKE_KEY),
            List.of(RarityFilter.onAverageOnceEvery(9), InSquarePlacement.spread(),  HeightRangePlacement.of(UniformHeight.of(VerticalAnchor.absolute(0), VerticalAnchor.top())),
                    EnvironmentScanPlacement.scanningFor(Direction.DOWN, BlockPredicate.allOf(BlockPredicate.not(BlockPredicate.ONLY_IN_AIR_PREDICATE),
                            BlockPredicate.insideWorld(new BlockPos(0, -5, 0))), 32), SurfaceRelativeThresholdFilter.of(Heightmap.Types.OCEAN_FLOOR_WG,
                            Integer.MIN_VALUE, -5), BiomeFilter.biome()));


    register(context, CT_MOLTEN_VINIFERA_SURFACE_LAKE_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.CT_MOLTEN_VINIFERA_LAKE_KEY),
            List.of(RarityFilter.onAverageOnceEvery(10), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_WORLD_SURFACE, BiomeFilter.biome()));


    register(context, CT_MOLTEN_VINIFERA_UNDERGROUND_LAKE_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.CT_MOLTEN_VINIFERA_LAKE_KEY),
            List.of(RarityFilter.onAverageOnceEvery(9), InSquarePlacement.spread(),  HeightRangePlacement.of(UniformHeight.of(VerticalAnchor.absolute(0), VerticalAnchor.top())),
                    EnvironmentScanPlacement.scanningFor(Direction.DOWN, BlockPredicate.allOf(BlockPredicate.not(BlockPredicate.ONLY_IN_AIR_PREDICATE),
                            BlockPredicate.insideWorld(new BlockPos(0, -5, 0))), 32), SurfaceRelativeThresholdFilter.of(Heightmap.Types.OCEAN_FLOOR_WG,
                            Integer.MIN_VALUE, -5), BiomeFilter.biome()));


    register(context, CT_MOLTEN_CRUENTUS_SURFACE_LAKE_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.CT_MOLTEN_CRUENTUS_LAKE_KEY),
            List.of(RarityFilter.onAverageOnceEvery(10), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_WORLD_SURFACE, BiomeFilter.biome()));


    register(context, CT_MOLTEN_CRUENTUS_UNDERGROUND_LAKE_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.CT_MOLTEN_CRUENTUS_LAKE_KEY),
            List.of(RarityFilter.onAverageOnceEvery(9), InSquarePlacement.spread(),  HeightRangePlacement.of(UniformHeight.of(VerticalAnchor.absolute(0), VerticalAnchor.top())),
                    EnvironmentScanPlacement.scanningFor(Direction.DOWN, BlockPredicate.allOf(BlockPredicate.not(BlockPredicate.ONLY_IN_AIR_PREDICATE),
                            BlockPredicate.insideWorld(new BlockPos(0, -5, 0))), 32), SurfaceRelativeThresholdFilter.of(Heightmap.Types.OCEAN_FLOOR_WG,
                            Integer.MIN_VALUE, -5), BiomeFilter.biome()));


    register(context, CT_MOLTEN_ABOREUS_SURFACE_LAKE_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.CT_MOLTEN_ABOREUS_LAKE_KEY),
            List.of(RarityFilter.onAverageOnceEvery(10), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_WORLD_SURFACE, BiomeFilter.biome()));


    register(context, CT_MOLTEN_ABOREUS_UNDERGROUND_LAKE_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.CT_MOLTEN_ABOREUS_LAKE_KEY),
            List.of(RarityFilter.onAverageOnceEvery(9), InSquarePlacement.spread(),  HeightRangePlacement.of(UniformHeight.of(VerticalAnchor.absolute(0), VerticalAnchor.top())),
                    EnvironmentScanPlacement.scanningFor(Direction.DOWN, BlockPredicate.allOf(BlockPredicate.not(BlockPredicate.ONLY_IN_AIR_PREDICATE),
                            BlockPredicate.insideWorld(new BlockPos(0, -5, 0))), 32), SurfaceRelativeThresholdFilter.of(Heightmap.Types.OCEAN_FLOOR_WG,
                            Integer.MIN_VALUE, -5), BiomeFilter.biome()));

    //Small Columns:
    register(context, CT_RIPARIUS_STONE_SMALL_COLUMN_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.CT_RIPARIUS_STONE_SMALL_COLUMN_KEY),
            List.of(CountOnEveryLayerPlacement.of(2), BiomeFilter.biome()));

    register(context, CT_VINIFERA_STONE_SMALL_COLUMN_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.CT_VINIFERA_STONE_SMALL_COLUMN_KEY),
            List.of(CountOnEveryLayerPlacement.of(2), BiomeFilter.biome()));

    register(context, CT_CRUENTUS_STONE_SMALL_COLUMN_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.CT_CRUENTUS_STONE_SMALL_COLUMN_KEY),
            List.of(CountOnEveryLayerPlacement.of(2), BiomeFilter.biome()));

    register(context, CT_ABOREUS_STONE_SMALL_COLUMN_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.CT_ABOREUS_STONE_SMALL_COLUMN_KEY),
            List.of(CountOnEveryLayerPlacement.of(2), BiomeFilter.biome()));


    register(context, CT_RIPARIUS_CRYSTAL_SMALL_COLUMN_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.CT_RIPARIUS_CRYSTAL_SMALL_COLUMN_KEY),
            List.of(CountOnEveryLayerPlacement.of(2), BiomeFilter.biome()));

    register(context, CT_VINIFERA_CRYSTAL_SMALL_COLUMN_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.CT_VINIFERA_CRYSTAL_SMALL_COLUMN_KEY),
            List.of(CountOnEveryLayerPlacement.of(2), BiomeFilter.biome()));

    register(context, CT_CRUENTUS_CRYSTAL_SMALL_COLUMN_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.CT_CRUENTUS_CRYSTAL_SMALL_COLUMN_KEY),
            List.of(CountOnEveryLayerPlacement.of(2), BiomeFilter.biome()));

    register(context, CT_ABOREUS_CRYSTAL_SMALL_COLUMN_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.CT_ABOREUS_CRYSTAL_SMALL_COLUMN_KEY),
            List.of(CountOnEveryLayerPlacement.of(2), BiomeFilter.biome()));


    //Large Columns:
    register(context, CT_RIPARIUS_STONE_LARGE_COLUMN_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.CT_RIPARIUS_STONE_LARGE_COLUMN_KEY),
            List.of(CountOnEveryLayerPlacement.of(1), BiomeFilter.biome()));

    register(context, CT_VINIFERA_STONE_LARGE_COLUMN_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.CT_VINIFERA_STONE_LARGE_COLUMN_KEY),
            List.of(CountOnEveryLayerPlacement.of(1), BiomeFilter.biome()));

    register(context, CT_CRUENTUS_STONE_LARGE_COLUMN_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.CT_CRUENTUS_STONE_LARGE_COLUMN_KEY),
            List.of(CountOnEveryLayerPlacement.of(1), BiomeFilter.biome()));

    register(context, CT_ABOREUS_STONE_LARGE_COLUMN_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.CT_ABOREUS_STONE_LARGE_COLUMN_KEY),
            List.of(CountOnEveryLayerPlacement.of(1), BiomeFilter.biome()));


    register(context, CT_RIPARIUS_CRYSTAL_LARGE_COLUMN_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.CT_RIPARIUS_CRYSTAL_LARGE_COLUMN_KEY),
            List.of(CountOnEveryLayerPlacement.of(1), BiomeFilter.biome()));

    register(context, CT_VINIFERA_CRYSTAL_LARGE_COLUMN_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.CT_VINIFERA_CRYSTAL_LARGE_COLUMN_KEY),
            List.of(CountOnEveryLayerPlacement.of(1), BiomeFilter.biome()));

    register(context, CT_CRUENTUS_CRYSTAL_LARGE_COLUMN_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.CT_CRUENTUS_CRYSTAL_LARGE_COLUMN_KEY),
            List.of(CountOnEveryLayerPlacement.of(1), BiomeFilter.biome()));

    register(context, CT_ABOREUS_CRYSTAL_LARGE_COLUMN_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.CT_ABOREUS_CRYSTAL_LARGE_COLUMN_KEY),
            List.of(CountOnEveryLayerPlacement.of(1), BiomeFilter.biome()));



}



    private static ResourceKey<PlacedFeature> registerKey(String name) {
        return ResourceKey.create(Registries.PLACED_FEATURE, new ResourceLocation(CrystalTech.MOD_ID, name));
    }

    private static void register(BootstapContext<PlacedFeature> context, ResourceKey<PlacedFeature> key, Holder<ConfiguredFeature<?, ?>> configuration,
                                 List<PlacementModifier> modifiers) {
        context.register(key, new PlacedFeature(configuration, List.copyOf(modifiers)));
    }
}
