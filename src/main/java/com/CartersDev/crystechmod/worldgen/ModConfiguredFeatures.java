package com.CartersDev.crystechmod.worldgen;

import com.CartersDev.crystechmod.CrystalTech;
import com.CartersDev.crystechmod.block.ModBlocks;
import com.CartersDev.crystechmod.fluid.ModFluids;
import com.CartersDev.crystechmod.util.ModTags;
import com.CartersDev.crystechmod.worldgen.ModFeatureTypes.ModFeatures;
import net.minecraft.core.HolderSet;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.GeodeBlockSettings;
import net.minecraft.world.level.levelgen.GeodeCrackSettings;
import net.minecraft.world.level.levelgen.GeodeLayerSettings;
import net.minecraft.world.level.levelgen.blockpredicates.BlockPredicate;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.LakeFeature;
import net.minecraft.world.level.levelgen.feature.configurations.*;
import net.minecraft.world.level.levelgen.feature.featuresize.ThreeLayersFeatureSize;
import net.minecraft.world.level.levelgen.feature.featuresize.TwoLayersFeatureSize;
import net.minecraft.world.level.levelgen.feature.foliageplacers.BlobFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.feature.stateproviders.RuleBasedBlockStateProvider;
import net.minecraft.world.level.levelgen.feature.trunkplacers.*;
import net.minecraft.world.level.levelgen.structure.templatesystem.BlockMatchTest;
import net.minecraft.world.level.levelgen.structure.templatesystem.RuleTest;
import net.minecraft.world.level.levelgen.structure.templatesystem.TagMatchTest;

import java.util.List;
import java.util.OptionalInt;

public class ModConfiguredFeatures {

    //Trees:
    public static final ResourceKey<ConfiguredFeature<?,?>> PLAGUED_KEY = registerKey("plagued");
    public static final ResourceKey<ConfiguredFeature<?,?>> DEAD_KEY = registerKey("dead");
    public static final ResourceKey<ConfiguredFeature<?,?>> EMBER_KEY = registerKey("ember");
    public static final ResourceKey<ConfiguredFeature<?,?>> SM_EMBER_KEY = registerKey("sm_ember");
    public static final ResourceKey<ConfiguredFeature<?,?>> MARIKA_KEY = registerKey("marika");
    public static final ResourceKey<ConfiguredFeature<?,?>> SM_MARIKA_KEY = registerKey("sm_marika");

    //Ores:
        //Overworld:
    public static final ResourceKey<ConfiguredFeature<?,?>> CRYSTECH_GUNDANIUM_ORE_KEY = registerKey("gundanium_ores");
    public static final ResourceKey<ConfiguredFeature<?,?>> CRYSTECH_KRYON_ORE_KEY = registerKey("kryon_ores");
    public static final ResourceKey<ConfiguredFeature<?,?>> CRYSTECH_ILLUMINA_ORE_KEY = registerKey("illumina_ores");
    public static final ResourceKey<ConfiguredFeature<?,?>> CRYSTECH_AERIES_ORE_KEY = registerKey("aeries_ores");
    public static final ResourceKey<ConfiguredFeature<?,?>> CRYSTECH_ENIGMA_ORE_KEY = registerKey("enigma_ores");
    public static final ResourceKey<ConfiguredFeature<?,?>> CRYSTECH_ALYTHUM_ORE_KEY = registerKey("alythum_ores");
    public static final ResourceKey<ConfiguredFeature<?,?>> CRYSTECH_QUALRITE_ORE_KEY = registerKey("qualrite_ores");
    public static final ResourceKey<ConfiguredFeature<?,?>> CRYSTECH_ANCIENT_DEBRIS_KEY = registerKey("ct_ancient_debris");

        //Stones & Dirts:
    public static final ResourceKey<ConfiguredFeature<?,?>> CRYSTECH_YELLOW_ZONE_DIRT_KEY = registerKey("yellow_zone_dirt");
    public static final ResourceKey<ConfiguredFeature<?,?>> CRYSTECH_SEEDED_YELLOW_ZONE_DIRT_KEY = registerKey("seeded_yellow_zone_dirt");
    public static final ResourceKey<ConfiguredFeature<?,?>> CRYSTECH_RED_ZONE_DIRT_KEY = registerKey("red_zone_dirt");
    public static final ResourceKey<ConfiguredFeature<?,?>> CRYSTECH_SEEDED_RED_ZONE_DIRT_KEY = registerKey("seeded_red_zone_dirt");
    public static final ResourceKey<ConfiguredFeature<?,?>> CRYSTECH_INFESTED_GRANITE_KEY = registerKey("infested_granite");
    public static final ResourceKey<ConfiguredFeature<?,?>> CRYSTECH_INFESTED_DIORITE_KEY = registerKey("infested_diorite");
    public static final ResourceKey<ConfiguredFeature<?,?>> CRYSTECH_INFESTED_ANDESITE_KEY = registerKey("infested_andesite");
    public static final ResourceKey<ConfiguredFeature<?,?>> CRYSTECH_VITRIC_DEEPSLATE_KEY = registerKey("vitric_deepslate");
    public static final ResourceKey<ConfiguredFeature<?,?>> CT_RIPARIUS_STONE_CLUMP_KEY = registerKey("ct_riparius_stone_clump");
    public static final ResourceKey<ConfiguredFeature<?,?>> CT_VINIFERA_STONE_CLUMP_KEY = registerKey("ct_vinifera_stone_clump");
    public static final ResourceKey<ConfiguredFeature<?,?>> CT_CRUENTUS_STONE_CLUMP_KEY = registerKey("ct_cruentus_stone_clump");
    public static final ResourceKey<ConfiguredFeature<?,?>> CT_ABOREUS_STONE_CLUMP_KEY = registerKey("ct_aboreus_stone_clump");



        //Nether:
    public static final ResourceKey<ConfiguredFeature<?,?>> CRYSTECH_NETHER_ALYTHUM_ORE_KEY = registerKey("nether_alythum_ores");
    public static final ResourceKey<ConfiguredFeature<?,?>> CRYSTECH_NETHER_QUALRITE_ORE_KEY = registerKey("nether_qualrite_ores");
    public static final ResourceKey<ConfiguredFeature<?,?>> CRYSTECH_NETHER_KRYON_ORE_KEY = registerKey("nether_kryon_ores");
    public static final ResourceKey<ConfiguredFeature<?,?>> CRYSTECH_NETHER_AERIES_ORE_KEY = registerKey("nether_aeries_ores");

        //End:
    public static final ResourceKey<ConfiguredFeature<?,?>> CRYSTECH_END_KRYON_ORE_KEY = registerKey("end_crystech_kryon_ores");
    public static final ResourceKey<ConfiguredFeature<?,?>> CRYSTECH_END_ENIGMA_ORE_KEY = registerKey("end_crystech_enigma_ores");

        //Geode:
     public static final ResourceKey<ConfiguredFeature<?,?>> TIBERIUM_GEODE_KEY = registerKey("tiberium_geode");

     public static final ResourceKey<ConfiguredFeature<?,?>> VITRIC_AMETHYST_GEODE_KEY = registerKey("vitric_amethyst_geode");
     public static final ResourceKey<ConfiguredFeature<?,?>> VITRIC_TIBERIUM_GEODE_KEY = registerKey("vitric_tiberium_geode");
     public static final ResourceKey<ConfiguredFeature<?,?>> VITRIC_ICHOR_GEODE_KEY = registerKey("vitric_ichor_geode");

    //Flowers:
    public static final ResourceKey<ConfiguredFeature<?,?>> HYACINTH_KEY = registerKey("hyacinth");
    public static final ResourceKey<ConfiguredFeature<?,?>> SPITFIRE_KEY = registerKey("spitfire");
    public static final ResourceKey<ConfiguredFeature<?,?>> FULGURBLOOM_KEY = registerKey("fulgurbloom");
    public static final ResourceKey<ConfiguredFeature<?,?>> FLOWER_OF_LIFE_KEY = registerKey("flower_of_life");
    public static final ResourceKey<ConfiguredFeature<?,?>> YOKARAN_BLOOM_KEY = registerKey("yokaran_bloom");
    public static final ResourceKey<ConfiguredFeature<?,?>> DEVILS_BLOOD_KEY = registerKey("devils_blood");

    //Overworld Features:
        //Disks:
    public static final ResourceKey<ConfiguredFeature<?,?>> CT_MAGMA_KEY = registerKey("ct_magma");
    public static final ResourceKey<ConfiguredFeature<?,?>> CT_GLOWSTONE_KEY = registerKey("ct_glowstone");
    public static final ResourceKey<ConfiguredFeature<?,?>> CT_YELLOW_ZONE_SAND_KEY = registerKey("ct_yellow_zone_sand");
    public static final ResourceKey<ConfiguredFeature<?,?>> CT_RED_ZONE_SAND_KEY = registerKey("ct_red_zone_sand");
    public static final ResourceKey<ConfiguredFeature<?,?>> CT_TIBERIUM_SOIL_KEY = registerKey("ct_tiberium_soil");
    public static final ResourceKey<ConfiguredFeature<?,?>> CT_ICHOR_SOIL_KEY = registerKey("ct_ichor_soil");
    
    public static final ResourceKey<ConfiguredFeature<?,?>> CT_DIRT_KEY = registerKey("ct_dirt");
    public static final ResourceKey<ConfiguredFeature<?,?>> CT_YELLOW_ZONE_DIRT_KEY = registerKey("ct_yellow_zone_dirt");
    public static final ResourceKey<ConfiguredFeature<?,?>> CT_RED_ZONE_DIRT_KEY = registerKey("ct_red_zone_dirt");

    public static final ResourceKey<ConfiguredFeature<?,?>> CT_SEEDED_DIRT_KEY = registerKey("ct_seeded_dirt");
    public static final ResourceKey<ConfiguredFeature<?,?>> CT_SEEDED_YELLOW_ZONE_DIRT_KEY = registerKey("ct_seeded_yellow_zone_dirt");
    public static final ResourceKey<ConfiguredFeature<?,?>> CT_SEEDED_RED_ZONE_DIRT_KEY = registerKey("ct_seeded_red_zone_dirt");

        //Springs:
    public static final ResourceKey<ConfiguredFeature<?,?>> CT_INFECTED_WATER_SPRING_KEY = registerKey("ct_infected_water_spring");

    public static final ResourceKey<ConfiguredFeature<?,?>> CT_MOLTEN_RIPARIUS_SPRING_KEY = registerKey("ct_molten_riparius_spring");
    public static final ResourceKey<ConfiguredFeature<?,?>> CT_MOLTEN_VINIFERA_SPRING_KEY = registerKey("ct_molten_vinifera_spring");
    public static final ResourceKey<ConfiguredFeature<?,?>> CT_MOLTEN_CRUENTUS_SPRING_KEY = registerKey("ct_molten_cruentus_spring");
    public static final ResourceKey<ConfiguredFeature<?,?>> CT_MOLTEN_ABOREUS_SPRING_KEY = registerKey("ct_molten_aboreus_spring");

        //Lakes:
     public static final ResourceKey<ConfiguredFeature<?,?>> CT_INFECTED_WATER_LAKE_KEY = registerKey("ct_infected_water_lake");

    public static final ResourceKey<ConfiguredFeature<?,?>> CT_MOLTEN_RIPARIUS_LAKE_KEY = registerKey("ct_molten_riparius_lake");
    public static final ResourceKey<ConfiguredFeature<?,?>> CT_MOLTEN_VINIFERA_LAKE_KEY = registerKey("ct_molten_vinifera_lake");
    public static final ResourceKey<ConfiguredFeature<?,?>> CT_MOLTEN_CRUENTUS_LAKE_KEY = registerKey("ct_molten_cruentus_lake");
    public static final ResourceKey<ConfiguredFeature<?,?>> CT_MOLTEN_ABOREUS_LAKE_KEY = registerKey("ct_molten_aboreus_lake");

        //Small Columns:
    public static final ResourceKey<ConfiguredFeature<?,?>> CT_RIPARIUS_STONE_SMALL_COLUMN_KEY = registerKey("ct_riparius_stone_small_column");
    public static final ResourceKey<ConfiguredFeature<?,?>> CT_VINIFERA_STONE_SMALL_COLUMN_KEY = registerKey("ct_vinifera_stone_small_column");
    public static final ResourceKey<ConfiguredFeature<?,?>> CT_CRUENTUS_STONE_SMALL_COLUMN_KEY = registerKey("ct_cruentus_stone_small_column");
    public static final ResourceKey<ConfiguredFeature<?,?>> CT_ABOREUS_STONE_SMALL_COLUMN_KEY = registerKey("ct_aboreus_stone_small_column");

    public static final ResourceKey<ConfiguredFeature<?,?>> CT_RIPARIUS_CRYSTAL_SMALL_COLUMN_KEY = registerKey("ct_riparius_crystal_small_column");
    public static final ResourceKey<ConfiguredFeature<?,?>> CT_VINIFERA_CRYSTAL_SMALL_COLUMN_KEY = registerKey("ct_vinifera_crystal_small_column");
    public static final ResourceKey<ConfiguredFeature<?,?>> CT_CRUENTUS_CRYSTAL_SMALL_COLUMN_KEY = registerKey("ct_cruentus_crystal_small_column");
    public static final ResourceKey<ConfiguredFeature<?,?>> CT_ABOREUS_CRYSTAL_SMALL_COLUMN_KEY = registerKey("ct_aboreus_crystal_small_column");


        //Large Columns:
    public static final ResourceKey<ConfiguredFeature<?,?>> CT_RIPARIUS_STONE_LARGE_COLUMN_KEY = registerKey("ct_riparius_stone_large_column");
    public static final ResourceKey<ConfiguredFeature<?,?>> CT_VINIFERA_STONE_LARGE_COLUMN_KEY = registerKey("ct_vinifera_stone_large_column");
    public static final ResourceKey<ConfiguredFeature<?,?>> CT_CRUENTUS_STONE_LARGE_COLUMN_KEY = registerKey("ct_cruentus_stone_large_column");
    public static final ResourceKey<ConfiguredFeature<?,?>> CT_ABOREUS_STONE_LARGE_COLUMN_KEY = registerKey("ct_aboreus_stone_large_column");

    public static final ResourceKey<ConfiguredFeature<?,?>> CT_RIPARIUS_CRYSTAL_LARGE_COLUMN_KEY = registerKey("ct_riparius_crystal_large_column");
    public static final ResourceKey<ConfiguredFeature<?,?>> CT_VINIFERA_CRYSTAL_LARGE_COLUMN_KEY = registerKey("ct_vinifera_crystal_large_column");
    public static final ResourceKey<ConfiguredFeature<?,?>> CT_CRUENTUS_CRYSTAL_LARGE_COLUMN_KEY = registerKey("ct_cruentus_crystal_large_column");
    public static final ResourceKey<ConfiguredFeature<?,?>> CT_ABOREUS_CRYSTAL_LARGE_COLUMN_KEY = registerKey("ct_aboreus_crystal_large_column");

        //Blobs:
    public static final ResourceKey<ConfiguredFeature<?,?>> CT_RIPARIUS_STONE_KEY = registerKey("ct_riparius_stone");
    public static final ResourceKey<ConfiguredFeature<?,?>> CT_VINIFERA_STONE_KEY = registerKey("ct_vinifera_stone");
    public static final ResourceKey<ConfiguredFeature<?,?>> CT_CRUENTUS_STONE_KEY = registerKey("ct_cruentus_stone");
    public static final ResourceKey<ConfiguredFeature<?,?>> CT_ABOREUS_STONE_KEY = registerKey("ct_aboreus_stone");

    public static final ResourceKey<ConfiguredFeature<?,?>> CT_RIPARIUS_CRYSTAL_KEY = registerKey("ct_riparius_crystal");
    public static final ResourceKey<ConfiguredFeature<?,?>> CT_VINIFERA_CRYSTAL_KEY = registerKey("ct_vinifera_crystal");
    public static final ResourceKey<ConfiguredFeature<?,?>> CT_CRUENTUS_CRYSTAL_KEY = registerKey("ct_cruentus_crystal");
    public static final ResourceKey<ConfiguredFeature<?,?>> CT_ABOREUS_CRYSTAL_KEY = registerKey("ct_aboreus_crystal");


    public static void bootstrap (BootstapContext<ConfiguredFeature<?, ?>> context) {

        RuleTest vitricExpanseBaseStone = new TagMatchTest(ModTags.Blocks.VITRIC_EXPANSE_STONES);
        RuleTest stoneReplaceables = new TagMatchTest(BlockTags.STONE_ORE_REPLACEABLES);
        RuleTest deepslateReplaceables = new TagMatchTest(BlockTags.DEEPSLATE_ORE_REPLACEABLES);
        RuleTest netherrackReplaceables = new BlockMatchTest(Blocks.NETHERRACK);
        RuleTest endReplaceables = new BlockMatchTest(Blocks.END_STONE);


        List<OreConfiguration.TargetBlockState> gundaniumOre = List.of(
                OreConfiguration.target(stoneReplaceables, ModBlocks.GUNDANIUM_ORE.get().defaultBlockState()),
                OreConfiguration.target(deepslateReplaceables, ModBlocks.DEEPSLATE_GUNDANIUM_ORE.get().defaultBlockState()));

        List<OreConfiguration.TargetBlockState> kryonOre = List.of(
                OreConfiguration.target(stoneReplaceables, ModBlocks.KRYON_ORE.get().defaultBlockState()),
                OreConfiguration.target(deepslateReplaceables, ModBlocks.DEEPSLATE_KRYON_ORE.get().defaultBlockState()));

        List<OreConfiguration.TargetBlockState> illuminaOre = List.of(
                OreConfiguration.target(stoneReplaceables, ModBlocks.ILLUMINA_ORE.get().defaultBlockState()),
                OreConfiguration.target(deepslateReplaceables, ModBlocks.DEEPSLATE_ILLUMINA_ORE.get().defaultBlockState()));

        List<OreConfiguration.TargetBlockState> aeriesOre = List.of(
                OreConfiguration.target(stoneReplaceables, ModBlocks.AERIES_ORE.get().defaultBlockState()),
                OreConfiguration.target(deepslateReplaceables, ModBlocks.DEEPSLATE_AERIES_ORE.get().defaultBlockState()));

        List<OreConfiguration.TargetBlockState> enigmaOre = List.of(
                OreConfiguration.target(stoneReplaceables, ModBlocks.ENIGMA_ORE.get().defaultBlockState()),
                OreConfiguration.target(deepslateReplaceables, ModBlocks.DEEPSLATE_ENIGMA_ORE.get().defaultBlockState()));

        List<OreConfiguration.TargetBlockState> alythumOre = List.of(
                OreConfiguration.target(stoneReplaceables, ModBlocks.ALYTHUM_ORE.get().defaultBlockState()),
                OreConfiguration.target(deepslateReplaceables, ModBlocks.DEEPSLATE_ALYTHUM_ORE.get().defaultBlockState()));

        List<OreConfiguration.TargetBlockState> qualriteOre = List.of(
                OreConfiguration.target(stoneReplaceables, ModBlocks.QUALRITE_ORE.get().defaultBlockState()),
                OreConfiguration.target(deepslateReplaceables, ModBlocks.DEEPSLATE_QUALRITE_ORE.get().defaultBlockState()));

        List<OreConfiguration.TargetBlockState> ctAncientDebris = List.of(
                OreConfiguration.target(stoneReplaceables, Blocks.ANCIENT_DEBRIS.defaultBlockState()),
                OreConfiguration.target(deepslateReplaceables, Blocks.ANCIENT_DEBRIS.defaultBlockState()));



        //Trees:
        register(context, PLAGUED_KEY, Feature.TREE, new TreeConfiguration.TreeConfigurationBuilder(
           BlockStateProvider.simple(ModBlocks.PLAGUED_LOG.get()),
            new ForkingTrunkPlacer(3,4,3),
                BlockStateProvider.simple(ModBlocks.PLAGUED_LEAVES.get()),
                new BlobFoliagePlacer(ConstantInt.of(2), ConstantInt.of(1), 2),
                new TwoLayersFeatureSize(1,0,1
                )).ignoreVines().build());

        register(context, DEAD_KEY, Feature.TREE, new TreeConfiguration.TreeConfigurationBuilder(
                BlockStateProvider.simple(ModBlocks.DEAD_LOG.get()),
                new StraightTrunkPlacer(3,1,2),
                BlockStateProvider.simple(ModBlocks.DEAD_LEAVES.get()),
                new BlobFoliagePlacer(ConstantInt.of(2), ConstantInt.of(1), 2),
                new TwoLayersFeatureSize(1,0,2
                )).ignoreVines().build());

        register(context, EMBER_KEY, Feature.TREE, new TreeConfiguration.TreeConfigurationBuilder(
                BlockStateProvider.simple(ModBlocks.EMBER_OAK_LOG.get()),
                new DarkOakTrunkPlacer(8, 2, 1),
                BlockStateProvider.simple(ModBlocks.EMBER_OAK_LEAVES.get()),
                new BlobFoliagePlacer(ConstantInt.of(3), ConstantInt.of(1), 4),
                new ThreeLayersFeatureSize(1,1,0,1,2,
                        OptionalInt.empty())).ignoreVines().build());

        register(context, SM_EMBER_KEY, Feature.TREE, new TreeConfiguration.TreeConfigurationBuilder(
                BlockStateProvider.simple(ModBlocks.EMBER_OAK_LOG.get()),
                new ForkingTrunkPlacer(4,4,3),
                BlockStateProvider.simple(ModBlocks.EMBER_OAK_LEAVES.get()),
                new BlobFoliagePlacer(ConstantInt.of(2), ConstantInt.of(1), 3),
                new TwoLayersFeatureSize(1,0,1
                )).ignoreVines().build());

        register(context, MARIKA_KEY, Feature.TREE, new TreeConfiguration.TreeConfigurationBuilder(
                BlockStateProvider.simple(ModBlocks.MARIKA_OAK_LOG.get()),
                new MegaJungleTrunkPlacer(22, 2, 1),
                BlockStateProvider.simple(ModBlocks.MARIKA_OAK_LEAVES.get()),
                new BlobFoliagePlacer(ConstantInt.of(2), ConstantInt.of(0), 10),
                new ThreeLayersFeatureSize(1,1,0,1,2,
                        OptionalInt.empty())).ignoreVines().build());

        register(context, SM_MARIKA_KEY, Feature.TREE, new TreeConfiguration.TreeConfigurationBuilder(
                BlockStateProvider.simple(ModBlocks.MARIKA_OAK_LOG.get()),
                new ForkingTrunkPlacer(4,4,3),
                BlockStateProvider.simple(ModBlocks.MARIKA_OAK_LEAVES.get()),
                new BlobFoliagePlacer(ConstantInt.of(2), ConstantInt.of(1), 3),
                new TwoLayersFeatureSize(1,0,1
                )).ignoreVines().build());

        //Overworld Ores:
        register(context,CRYSTECH_GUNDANIUM_ORE_KEY, Feature.ORE, new OreConfiguration(gundaniumOre, 10));
        register(context,CRYSTECH_ALYTHUM_ORE_KEY, Feature.ORE, new OreConfiguration(alythumOre, 8));
        register(context,CRYSTECH_KRYON_ORE_KEY, Feature.ORE, new OreConfiguration(kryonOre, 6));
        register(context,CRYSTECH_ILLUMINA_ORE_KEY, Feature.ORE, new OreConfiguration(illuminaOre, 6));
        register(context,CRYSTECH_AERIES_ORE_KEY, Feature.ORE, new OreConfiguration(aeriesOre, 6));
        register(context,CRYSTECH_QUALRITE_ORE_KEY, Feature.ORE, new OreConfiguration(qualriteOre, 6));
        register(context,CRYSTECH_ENIGMA_ORE_KEY, Feature.ORE, new OreConfiguration(enigmaOre, 7));
        register(context, CRYSTECH_ANCIENT_DEBRIS_KEY, Feature.ORE, new OreConfiguration(ctAncientDebris, 5));

        //Alt Ores for the Vitric Expanse:
        register(context, CRYSTECH_YELLOW_ZONE_DIRT_KEY, Feature.ORE, new OreConfiguration(vitricExpanseBaseStone, ModBlocks.YELLOW_ZONE_CRACKED_DIRT.get().defaultBlockState(), 33));
        register(context, CRYSTECH_SEEDED_YELLOW_ZONE_DIRT_KEY, Feature.ORE, new OreConfiguration(vitricExpanseBaseStone, ModBlocks.SEEDED_YELLOW_ZONE_CRACKED_DIRT.get().defaultBlockState(), 33));
        register(context, CRYSTECH_RED_ZONE_DIRT_KEY, Feature.ORE, new OreConfiguration(vitricExpanseBaseStone, ModBlocks.RED_ZONE_DIRT.get().defaultBlockState(), 33));
        register(context, CRYSTECH_SEEDED_RED_ZONE_DIRT_KEY, Feature.ORE, new OreConfiguration(vitricExpanseBaseStone, ModBlocks.SEEDED_RED_ZONE_DIRT.get().defaultBlockState(), 33));

        register(context, CRYSTECH_INFESTED_GRANITE_KEY, Feature.ORE, new OreConfiguration(vitricExpanseBaseStone, ModBlocks.INFESTED_GRANITE.get().defaultBlockState(), 64));
        register(context, CRYSTECH_INFESTED_DIORITE_KEY, Feature.ORE, new OreConfiguration(vitricExpanseBaseStone, ModBlocks.INFESTED_DIORITE.get().defaultBlockState(), 64));
        register(context, CRYSTECH_INFESTED_ANDESITE_KEY, Feature.ORE, new OreConfiguration(vitricExpanseBaseStone, ModBlocks.INFESTED_ANDESITE.get().defaultBlockState(), 64));

        register(context, CRYSTECH_VITRIC_DEEPSLATE_KEY, Feature.ORE, new OreConfiguration(vitricExpanseBaseStone, ModBlocks.VITRIC_DEEPSLATE.get().defaultBlockState(), 64));

        register(context, CT_RIPARIUS_STONE_CLUMP_KEY, Feature.ORE, new OreConfiguration(vitricExpanseBaseStone, ModBlocks.RIPARIUS_STONE.get().defaultBlockState(), 33));
        register(context, CT_VINIFERA_STONE_CLUMP_KEY, Feature.ORE, new OreConfiguration(vitricExpanseBaseStone, ModBlocks.VINIFERA_STONE.get().defaultBlockState(), 33));
        register(context, CT_CRUENTUS_STONE_CLUMP_KEY, Feature.ORE, new OreConfiguration(vitricExpanseBaseStone, ModBlocks.CRUENTUS_STONE.get().defaultBlockState(), 33));
        register(context, CT_ABOREUS_STONE_CLUMP_KEY, Feature.ORE, new OreConfiguration(vitricExpanseBaseStone, ModBlocks.ABOREUS_STONE.get().defaultBlockState(), 33));



        //Nether Ores:
        register(context,CRYSTECH_NETHER_AERIES_ORE_KEY, Feature.ORE, new OreConfiguration(netherrackReplaceables, ModBlocks.NETHER_AERIES_ORE.get().defaultBlockState(), 4));
        register(context,CRYSTECH_NETHER_QUALRITE_ORE_KEY, Feature.ORE, new OreConfiguration(netherrackReplaceables, ModBlocks.NETHER_QUALRITE_ORE.get().defaultBlockState(), 4));
        register(context,CRYSTECH_NETHER_ALYTHUM_ORE_KEY, Feature.ORE, new OreConfiguration(netherrackReplaceables, ModBlocks.NETHER_ALYTHUM_ORE.get().defaultBlockState(), 5));
        register(context,CRYSTECH_NETHER_KRYON_ORE_KEY, Feature.ORE, new OreConfiguration(netherrackReplaceables, ModBlocks.NETHER_KRYON_ORE.get().defaultBlockState(), 5));

        //End Ores:
        register(context,CRYSTECH_END_ENIGMA_ORE_KEY, Feature.ORE, new OreConfiguration(endReplaceables, ModBlocks.END_ENIGMA_ORE.get().defaultBlockState(), 5));
        register(context,CRYSTECH_END_KRYON_ORE_KEY, Feature.ORE, new OreConfiguration(endReplaceables, ModBlocks.END_KRYON_ORE.get().defaultBlockState(), 6));

        //Geodes:
        register(context, TIBERIUM_GEODE_KEY, Feature.GEODE,
                new GeodeConfiguration(new GeodeBlockSettings(BlockStateProvider.simple(Blocks.AIR),
                        BlockStateProvider.simple(Blocks.DEEPSLATE),
                        BlockStateProvider.simple(ModBlocks.TIBERIUM_SOIL.get()),
                        BlockStateProvider.simple(ModBlocks.TIBERIUM_SOIL.get()),
                        BlockStateProvider.simple(ModBlocks.INFESTED_STONE.get()),
                        List.of(ModBlocks.TIBERIUM_SOIL.get().defaultBlockState(), ModBlocks.GUNDANIUM_ORE.get().defaultBlockState(), ModBlocks.ALYTHUM_ORE.get().defaultBlockState()),
                        BlockTags.FEATURES_CANNOT_REPLACE , BlockTags.GEODE_INVALID_BLOCKS),
                        new GeodeLayerSettings(1.7D, 2.2D, 3.2D, 4.2D),
                        new GeodeCrackSettings(0.95D, 2.0D, 2), 0.35D, 0.083D, true,
                        UniformInt.of(4, 6), UniformInt.of(3, 4),
                        UniformInt.of(1, 2), -16, 16, 0.05D, 1));

        register(context, VITRIC_TIBERIUM_GEODE_KEY, Feature.GEODE,
                new GeodeConfiguration(new GeodeBlockSettings(BlockStateProvider.simple(Blocks.AIR),
                        BlockStateProvider.simple(ModBlocks.INFESTED_STONE.get()),
                        BlockStateProvider.simple(ModBlocks.TIBERIUM_SOIL.get()),
                        BlockStateProvider.simple(ModBlocks.RIPARIUS_STONE.get()),
                        BlockStateProvider.simple(ModBlocks.VITRIC_DEEPSLATE.get()),
                        List.of(ModBlocks.TIBERIUM_SOIL.get().defaultBlockState(), ModBlocks.GUNDANIUM_ORE.get().defaultBlockState(), ModBlocks.ALYTHUM_ORE.get().defaultBlockState()),
                        BlockTags.FEATURES_CANNOT_REPLACE , BlockTags.GEODE_INVALID_BLOCKS),
                        new GeodeLayerSettings(1.7D, 2.2D, 3.2D, 4.2D),
                        new GeodeCrackSettings(0.95D, 2.0D, 2), 0.35D, 0.083D, true,
                        UniformInt.of(4, 6), UniformInt.of(3, 4),
                        UniformInt.of(1, 2), -16, 16, 0.05D, 1));

        register(context, VITRIC_ICHOR_GEODE_KEY, Feature.GEODE,
                new GeodeConfiguration(new GeodeBlockSettings(BlockStateProvider.simple(Blocks.AIR),
                        BlockStateProvider.simple(ModBlocks.ABOREUS_CRYSTAL.get()),
                        BlockStateProvider.simple(ModBlocks.ICHOR_SOIL.get()),
                        BlockStateProvider.simple(ModBlocks.ABOREUS_STONE.get()),
                        BlockStateProvider.simple(ModBlocks.VITRIC_DEEPSLATE.get()),
                        List.of(ModBlocks.TIBERIUM_SOIL.get().defaultBlockState(), ModBlocks.ICHOR_SOIL.get().defaultBlockState(), ModBlocks.GUNDANIUM_ORE.get().defaultBlockState(), ModBlocks.ALYTHUM_ORE.get().defaultBlockState()),
                        BlockTags.FEATURES_CANNOT_REPLACE , BlockTags.GEODE_INVALID_BLOCKS),
                        new GeodeLayerSettings(1.7D, 2.2D, 3.2D, 4.2D),
                        new GeodeCrackSettings(0.95D, 2.0D, 2), 0.35D, 0.083D, true,
                        UniformInt.of(4, 6), UniformInt.of(3, 4),
                        UniformInt.of(1, 2), -16, 16, 0.05D, 1));
        //MAXIMUM SETTINGS
//                        new GeodeLayerSettings(1.7D, 1.2D, 2.5D, 3.5D),
//                        new GeodeCrackSettings(0.25D, 1.5D, 1), 0.5D, 0.1D,
//                        true, UniformInt.of(3, 8),
//                        UniformInt.of(2, 6), UniformInt.of(1, 2),
//                        -18, 18, 0.075D, 1));

        register(context, VITRIC_AMETHYST_GEODE_KEY, Feature.GEODE,
        new GeodeConfiguration(new GeodeBlockSettings(BlockStateProvider.simple(Blocks.AIR),
        BlockStateProvider.simple(Blocks.AMETHYST_BLOCK),
        BlockStateProvider.simple(Blocks.BUDDING_AMETHYST),
        BlockStateProvider.simple(ModBlocks.INFESTED_STONE.get()),
        BlockStateProvider.simple(ModBlocks.VITRIC_DEEPSLATE.get()),
        List.of(Blocks.SMALL_AMETHYST_BUD.defaultBlockState(),
        Blocks.MEDIUM_AMETHYST_BUD.defaultBlockState(),
        Blocks.LARGE_AMETHYST_BUD.defaultBlockState(),
        Blocks.AMETHYST_CLUSTER.defaultBlockState()),
        BlockTags.FEATURES_CANNOT_REPLACE,
        BlockTags.GEODE_INVALID_BLOCKS),
        new GeodeLayerSettings(1.7D, 2.2D, 3.2D, 4.2D),
        new GeodeCrackSettings(0.95D, 2.0D, 2), 0.35D, 0.083D,
        true, UniformInt.of(4, 6), UniformInt.of(3, 4),
        UniformInt.of(1, 2), -16, 16, 0.05D, 1));


        //Flowers:
        register(context, HYACINTH_KEY, Feature.FLOWER,
                new RandomPatchConfiguration(32, 12, 2, PlacementUtils.onlyWhenEmpty(Feature.SIMPLE_BLOCK,
                        new SimpleBlockConfiguration(BlockStateProvider.simple(ModBlocks.HYACINTH.get())))));

        register(context, SPITFIRE_KEY, Feature.FLOWER,
                new RandomPatchConfiguration(64, 12, 2, PlacementUtils.onlyWhenEmpty(Feature.SIMPLE_BLOCK,
                        new SimpleBlockConfiguration(BlockStateProvider.simple(ModBlocks.SPITFIRE.get())))));

        register(context, FULGURBLOOM_KEY, Feature.FLOWER,
                new RandomPatchConfiguration(64, 12, 2, PlacementUtils.onlyWhenEmpty(Feature.SIMPLE_BLOCK,
                        new SimpleBlockConfiguration(BlockStateProvider.simple(ModBlocks.FULGURBLOOM.get())))));

        register(context, FLOWER_OF_LIFE_KEY, Feature.FLOWER,
                new RandomPatchConfiguration(64, 12, 2, PlacementUtils.onlyWhenEmpty(Feature.SIMPLE_BLOCK,
                        new SimpleBlockConfiguration(BlockStateProvider.simple(ModBlocks.FLOWER_OF_LIFE.get())))));

        register(context, YOKARAN_BLOOM_KEY, Feature.FLOWER,
                new RandomPatchConfiguration(64, 12, 2, PlacementUtils.onlyWhenEmpty(Feature.SIMPLE_BLOCK,
                        new SimpleBlockConfiguration(BlockStateProvider.simple(ModBlocks.YOKARAN_BLOOM.get())))));

        register(context, DEVILS_BLOOD_KEY, Feature.FLOWER,
                new RandomPatchConfiguration(64, 12, 2, PlacementUtils.onlyWhenEmpty(Feature.SIMPLE_BLOCK,
                        new SimpleBlockConfiguration(BlockStateProvider.simple(ModBlocks.DEVILS_BLOOD.get())))));


//Misc Overworld:
        //Blobs:
        register(context, CT_RIPARIUS_STONE_KEY, Feature.FOREST_ROCK, new BlockStateConfiguration(ModBlocks.RIPARIUS_STONE.get().defaultBlockState()));
        register(context, CT_VINIFERA_STONE_KEY, Feature.FOREST_ROCK, new BlockStateConfiguration(ModBlocks.VINIFERA_STONE.get().defaultBlockState()));
        register(context, CT_CRUENTUS_STONE_KEY, Feature.FOREST_ROCK, new BlockStateConfiguration(ModBlocks.CRUENTUS_STONE.get().defaultBlockState()));
        register(context, CT_ABOREUS_STONE_KEY, Feature.FOREST_ROCK, new BlockStateConfiguration(ModBlocks.ABOREUS_STONE.get().defaultBlockState()));

        register(context, CT_RIPARIUS_CRYSTAL_KEY, Feature.FOREST_ROCK, new BlockStateConfiguration(ModBlocks.RIPARIUS_CRYSTAL.get().defaultBlockState()));
        register(context, CT_VINIFERA_CRYSTAL_KEY, Feature.FOREST_ROCK, new BlockStateConfiguration(ModBlocks.VINIFERA_CRYSTAL.get().defaultBlockState()));
        register(context, CT_CRUENTUS_CRYSTAL_KEY, Feature.FOREST_ROCK, new BlockStateConfiguration(ModBlocks.CRUENTUS_CRYSTAL.get().defaultBlockState()));
        register(context, CT_ABOREUS_CRYSTAL_KEY, Feature.FOREST_ROCK, new BlockStateConfiguration(ModBlocks.ABOREUS_CRYSTAL.get().defaultBlockState()));
        
        //Discs:
        register(context, CT_MAGMA_KEY, Feature.DISK, new DiskConfiguration(RuleBasedBlockStateProvider.simple(Blocks.MAGMA_BLOCK), BlockPredicate.matchesBlocks(List.of(Blocks.DIRT, Blocks.GRASS_BLOCK)), UniformInt.of(1, 3), 1));
        register(context, CT_GLOWSTONE_KEY, Feature.DISK, new DiskConfiguration(RuleBasedBlockStateProvider.simple(Blocks.GLOWSTONE), BlockPredicate.matchesBlocks(List.of(Blocks.DIRT, Blocks.GRASS_BLOCK)), UniformInt.of(1, 2), 1));

        register(context, CT_YELLOW_ZONE_SAND_KEY, Feature.DISK, new DiskConfiguration(RuleBasedBlockStateProvider.simple(ModBlocks.YELLOW_ZONE_SAND.get()), BlockPredicate.matchesBlocks(List.of(ModBlocks.YELLOW_ZONE_CRACKED_DIRT.get(), ModBlocks.SEEDED_YELLOW_ZONE_CRACKED_DIRT.get(), ModBlocks.YZ_SANDSTONE.get())), UniformInt.of(2, 6), 2));
        register(context, CT_RED_ZONE_SAND_KEY, Feature.DISK, new DiskConfiguration(RuleBasedBlockStateProvider.simple(ModBlocks.RED_ZONE_SAND.get()), BlockPredicate.matchesBlocks(List.of(ModBlocks.RED_ZONE_DIRT.get(), ModBlocks.SEEDED_RED_ZONE_DIRT.get(), ModBlocks.RZ_SANDSTONE.get())), UniformInt.of(2, 6), 2));


        register(context, CT_TIBERIUM_SOIL_KEY, Feature.DISK, new DiskConfiguration(RuleBasedBlockStateProvider.simple(ModBlocks.TIBERIUM_SOIL.get()), BlockPredicate.matchesBlocks(List.of(Blocks.DIRT, Blocks.GRASS_BLOCK)), UniformInt.of(1, 5), 2));
        register(context, CT_ICHOR_SOIL_KEY, Feature.DISK, new DiskConfiguration(RuleBasedBlockStateProvider.simple(ModBlocks.ICHOR_SOIL.get()), BlockPredicate.matchesBlocks(List.of(Blocks.DIRT, Blocks.GRASS_BLOCK)), UniformInt.of(1, 3), 1));

        register(context, CT_DIRT_KEY, Feature.DISK, new DiskConfiguration(RuleBasedBlockStateProvider.simple(Blocks.GRASS_BLOCK), BlockPredicate.matchesBlocks(List.of(ModBlocks.YELLOW_ZONE_CRACKED_DIRT.get(), ModBlocks.RED_ZONE_DIRT.get(), ModBlocks.SEEDED_YELLOW_ZONE_CRACKED_DIRT.get(), ModBlocks.SEEDED_RED_ZONE_DIRT.get(), ModBlocks.SEEDED_DIRT.get())), UniformInt.of(1, 5), 2));
        register(context, CT_SEEDED_DIRT_KEY, Feature.DISK, new DiskConfiguration(RuleBasedBlockStateProvider.simple(ModBlocks.SEEDED_DIRT.get()), BlockPredicate.matchesBlocks(List.of(Blocks.DIRT, Blocks.GRASS_BLOCK, ModBlocks.YELLOW_ZONE_CRACKED_DIRT.get(), ModBlocks.RED_ZONE_DIRT.get())), UniformInt.of(1, 5), 2));

        register(context, CT_YELLOW_ZONE_DIRT_KEY, Feature.DISK, new DiskConfiguration(RuleBasedBlockStateProvider.simple(ModBlocks.YELLOW_ZONE_CRACKED_DIRT.get()), BlockPredicate.matchesBlocks(List.of(Blocks.DIRT, Blocks.GRASS_BLOCK, ModBlocks.SEEDED_DIRT.get(), ModBlocks.RED_ZONE_DIRT.get(), ModBlocks.SEEDED_YELLOW_ZONE_CRACKED_DIRT.get(), ModBlocks.SEEDED_RED_ZONE_DIRT.get())), UniformInt.of(1, 5), 2));
        register(context, CT_SEEDED_YELLOW_ZONE_DIRT_KEY, Feature.DISK, new DiskConfiguration(RuleBasedBlockStateProvider.simple(ModBlocks.SEEDED_YELLOW_ZONE_CRACKED_DIRT.get()), BlockPredicate.matchesBlocks(List.of(Blocks.DIRT, Blocks.GRASS_BLOCK, ModBlocks.YELLOW_ZONE_CRACKED_DIRT.get(), ModBlocks.RED_ZONE_DIRT.get())), UniformInt.of(1, 5), 2));

        register(context, CT_RED_ZONE_DIRT_KEY, Feature.DISK, new DiskConfiguration(RuleBasedBlockStateProvider.simple(ModBlocks.RED_ZONE_DIRT.get()), BlockPredicate.matchesBlocks(List.of(Blocks.DIRT, Blocks.GRASS_BLOCK, ModBlocks.SEEDED_DIRT.get(), ModBlocks.YELLOW_ZONE_CRACKED_DIRT.get(), ModBlocks.SEEDED_YELLOW_ZONE_CRACKED_DIRT.get(), ModBlocks.SEEDED_RED_ZONE_DIRT.get())), UniformInt.of(1, 5), 2));
        register(context, CT_SEEDED_RED_ZONE_DIRT_KEY, Feature.DISK, new DiskConfiguration(RuleBasedBlockStateProvider.simple(ModBlocks.SEEDED_RED_ZONE_DIRT.get()), BlockPredicate.matchesBlocks(List.of(Blocks.DIRT, Blocks.GRASS_BLOCK, ModBlocks.YELLOW_ZONE_CRACKED_DIRT.get(), ModBlocks.RED_ZONE_DIRT.get())), UniformInt.of(1, 5), 2));

        //Springs
        register(context, CT_INFECTED_WATER_SPRING_KEY, Feature.SPRING, new SpringConfiguration(ModFluids.SOURCE_TIBERIUM_WATER.get().defaultFluidState(), true, 4, 1, HolderSet.direct(Block::builtInRegistryHolder, Blocks.STONE, Blocks.GRANITE, Blocks.DIORITE, Blocks.ANDESITE, Blocks.DEEPSLATE, Blocks.TUFF, Blocks.CALCITE, Blocks.DIRT, ModBlocks.YELLOW_ZONE_CRACKED_DIRT.get(), ModBlocks.SEEDED_YELLOW_ZONE_CRACKED_DIRT.get(), ModBlocks.SEEDED_DIRT.get(), ModBlocks.RED_ZONE_DIRT.get(), ModBlocks.SEEDED_RED_ZONE_DIRT.get(), ModBlocks.INFESTED_STONE.get(), ModBlocks.INFESTED_DIORITE.get(), ModBlocks.INFESTED_GRANITE.get(), ModBlocks.INFESTED_ANDESITE.get())));

        register(context, CT_MOLTEN_RIPARIUS_SPRING_KEY, Feature.SPRING, new SpringConfiguration(ModFluids.SOURCE_MOLTEN_TIBERIUM.get().defaultFluidState(), true, 4, 1, HolderSet.direct(Block::builtInRegistryHolder, Blocks.STONE, Blocks.GRANITE, Blocks.DIORITE, Blocks.ANDESITE, Blocks.DEEPSLATE, Blocks.TUFF, Blocks.CALCITE, Blocks.DIRT, ModBlocks.YELLOW_ZONE_CRACKED_DIRT.get(), ModBlocks.SEEDED_YELLOW_ZONE_CRACKED_DIRT.get(), ModBlocks.SEEDED_DIRT.get(), ModBlocks.RED_ZONE_DIRT.get(), ModBlocks.SEEDED_RED_ZONE_DIRT.get(), ModBlocks.INFESTED_STONE.get(), ModBlocks.INFESTED_DIORITE.get(), ModBlocks.INFESTED_GRANITE.get(), ModBlocks.INFESTED_ANDESITE.get())));
        register(context, CT_MOLTEN_VINIFERA_SPRING_KEY, Feature.SPRING, new SpringConfiguration(ModFluids.SOURCE_MOLTEN_BLUE_TIBERIUM.get().defaultFluidState(), true, 4, 1, HolderSet.direct(Block::builtInRegistryHolder, Blocks.STONE, Blocks.GRANITE, Blocks.DIORITE, Blocks.ANDESITE, Blocks.DEEPSLATE, Blocks.TUFF, Blocks.CALCITE, Blocks.DIRT, ModBlocks.YELLOW_ZONE_CRACKED_DIRT.get(), ModBlocks.SEEDED_YELLOW_ZONE_CRACKED_DIRT.get(), ModBlocks.SEEDED_DIRT.get(), ModBlocks.RED_ZONE_DIRT.get(), ModBlocks.SEEDED_RED_ZONE_DIRT.get(), ModBlocks.INFESTED_STONE.get(), ModBlocks.INFESTED_DIORITE.get(), ModBlocks.INFESTED_GRANITE.get(), ModBlocks.INFESTED_ANDESITE.get())));
        register(context, CT_MOLTEN_CRUENTUS_SPRING_KEY, Feature.SPRING, new SpringConfiguration(ModFluids.SOURCE_MOLTEN_RED_TIBERIUM.get().defaultFluidState(), true, 4, 1, HolderSet.direct(Block::builtInRegistryHolder, Blocks.STONE, Blocks.GRANITE, Blocks.DIORITE, Blocks.ANDESITE, Blocks.DEEPSLATE, Blocks.TUFF, Blocks.CALCITE, Blocks.DIRT, ModBlocks.YELLOW_ZONE_CRACKED_DIRT.get(), ModBlocks.SEEDED_YELLOW_ZONE_CRACKED_DIRT.get(), ModBlocks.SEEDED_DIRT.get(), ModBlocks.RED_ZONE_DIRT.get(), ModBlocks.SEEDED_RED_ZONE_DIRT.get(), ModBlocks.INFESTED_STONE.get(), ModBlocks.INFESTED_DIORITE.get(), ModBlocks.INFESTED_GRANITE.get(), ModBlocks.INFESTED_ANDESITE.get())));
        register(context, CT_MOLTEN_ABOREUS_SPRING_KEY, Feature.SPRING, new SpringConfiguration(ModFluids.SOURCE_MOLTEN_PURPLE_TIBERIUM.get().defaultFluidState(), true, 4, 1, HolderSet.direct(Block::builtInRegistryHolder, Blocks.STONE, Blocks.GRANITE, Blocks.DIORITE, Blocks.ANDESITE, Blocks.DEEPSLATE, Blocks.TUFF, Blocks.CALCITE, Blocks.DIRT, ModBlocks.YELLOW_ZONE_CRACKED_DIRT.get(), ModBlocks.SEEDED_YELLOW_ZONE_CRACKED_DIRT.get(), ModBlocks.SEEDED_DIRT.get(), ModBlocks.RED_ZONE_DIRT.get(), ModBlocks.SEEDED_RED_ZONE_DIRT.get(), ModBlocks.INFESTED_STONE.get(), ModBlocks.INFESTED_DIORITE.get(), ModBlocks.INFESTED_GRANITE.get(), ModBlocks.INFESTED_ANDESITE.get())));

        //Lakes
        register(context, CT_INFECTED_WATER_LAKE_KEY, Feature.LAKE, new LakeFeature.Configuration(BlockStateProvider.simple(ModBlocks.TIBERIUM_WATER_BLOCK.get().defaultBlockState()), BlockStateProvider.simple(ModBlocks.INFESTED_STONE.get().defaultBlockState())));

        register(context, CT_MOLTEN_RIPARIUS_LAKE_KEY, Feature.LAKE, new LakeFeature.Configuration(BlockStateProvider.simple(ModBlocks.MOLTEN_TIBERIUM_BLOCK.get().defaultBlockState()), BlockStateProvider.simple(ModBlocks.RIPARIUS_STONE.get().defaultBlockState())));
        register(context, CT_MOLTEN_VINIFERA_LAKE_KEY, Feature.LAKE, new LakeFeature.Configuration(BlockStateProvider.simple(ModBlocks.MOLTEN_BLUE_TIBERIUM_BLOCK.get().defaultBlockState()), BlockStateProvider.simple(ModBlocks.VINIFERA_STONE.get().defaultBlockState())));
        register(context, CT_MOLTEN_CRUENTUS_LAKE_KEY, Feature.LAKE, new LakeFeature.Configuration(BlockStateProvider.simple(ModBlocks.MOLTEN_RED_TIBERIUM_BLOCK.get().defaultBlockState()), BlockStateProvider.simple(ModBlocks.CRUENTUS_STONE.get().defaultBlockState())));
        register(context, CT_MOLTEN_ABOREUS_LAKE_KEY, Feature.LAKE, new LakeFeature.Configuration(BlockStateProvider.simple(ModBlocks.MOLTEN_PURPLE_TIBERIUM_BLOCK.get().defaultBlockState()), BlockStateProvider.simple(ModBlocks.ABOREUS_STONE.get().defaultBlockState())));

        //Small Columns:
        register(context, CT_RIPARIUS_STONE_SMALL_COLUMN_KEY, ModFeatures.RIPARIUS_STONE_COLUMNS.get(), new ColumnFeatureConfiguration(ConstantInt.of(1), UniformInt.of(1, 4)));
        register(context, CT_VINIFERA_STONE_SMALL_COLUMN_KEY, ModFeatures.VINIFERA_STONE_COLUMNS.get(), new ColumnFeatureConfiguration(ConstantInt.of(1), UniformInt.of(1, 4)));
        register(context, CT_CRUENTUS_STONE_SMALL_COLUMN_KEY, ModFeatures.CRUENTUS_STONE_COLUMNS.get(), new ColumnFeatureConfiguration(ConstantInt.of(1), UniformInt.of(1, 4)));
        register(context, CT_ABOREUS_STONE_SMALL_COLUMN_KEY, ModFeatures.ABOREUS_STONE_COLUMNS.get(), new ColumnFeatureConfiguration(ConstantInt.of(1), UniformInt.of(1, 4)));

        register(context, CT_RIPARIUS_CRYSTAL_SMALL_COLUMN_KEY, ModFeatures.RIPARIUS_CRYSTAL_COLUMNS.get(), new ColumnFeatureConfiguration(ConstantInt.of(1), UniformInt.of(1, 4)));
        register(context, CT_VINIFERA_CRYSTAL_SMALL_COLUMN_KEY, ModFeatures.VINIFERA_CRYSTAL_COLUMNS.get(), new ColumnFeatureConfiguration(ConstantInt.of(1), UniformInt.of(1, 4)));
        register(context, CT_CRUENTUS_CRYSTAL_SMALL_COLUMN_KEY, ModFeatures.CRUENTUS_CRYSTAL_COLUMNS.get(), new ColumnFeatureConfiguration(ConstantInt.of(1), UniformInt.of(1, 4)));
        register(context, CT_ABOREUS_CRYSTAL_SMALL_COLUMN_KEY, ModFeatures.ABOREUS_CRYSTAL_COLUMNS.get(), new ColumnFeatureConfiguration(ConstantInt.of(1), UniformInt.of(1, 4)));

        //Large Columns:
        register(context, CT_RIPARIUS_STONE_LARGE_COLUMN_KEY, ModFeatures.RIPARIUS_STONE_COLUMNS.get(), new ColumnFeatureConfiguration(UniformInt.of(2, 3), UniformInt.of(5, 10)));
        register(context, CT_VINIFERA_STONE_LARGE_COLUMN_KEY, ModFeatures.VINIFERA_STONE_COLUMNS.get(), new ColumnFeatureConfiguration(UniformInt.of(2, 3), UniformInt.of(5, 10)));
        register(context, CT_CRUENTUS_STONE_LARGE_COLUMN_KEY, ModFeatures.CRUENTUS_STONE_COLUMNS.get(), new ColumnFeatureConfiguration(UniformInt.of(2, 3), UniformInt.of(5, 10)));
        register(context, CT_ABOREUS_STONE_LARGE_COLUMN_KEY, ModFeatures.ABOREUS_STONE_COLUMNS.get(), new ColumnFeatureConfiguration(UniformInt.of(2, 3), UniformInt.of(5, 10)));

        register(context, CT_RIPARIUS_CRYSTAL_LARGE_COLUMN_KEY, ModFeatures.RIPARIUS_CRYSTAL_COLUMNS.get(), new ColumnFeatureConfiguration(UniformInt.of(2, 3), UniformInt.of(5, 10)));
        register(context, CT_VINIFERA_CRYSTAL_LARGE_COLUMN_KEY, ModFeatures.VINIFERA_CRYSTAL_COLUMNS.get(), new ColumnFeatureConfiguration(UniformInt.of(2, 3), UniformInt.of(5, 10)));
        register(context, CT_CRUENTUS_CRYSTAL_LARGE_COLUMN_KEY, ModFeatures.CRUENTUS_CRYSTAL_COLUMNS.get(), new ColumnFeatureConfiguration(UniformInt.of(2, 3), UniformInt.of(5, 10)));
        register(context, CT_ABOREUS_CRYSTAL_LARGE_COLUMN_KEY, ModFeatures.ABOREUS_CRYSTAL_COLUMNS.get(), new ColumnFeatureConfiguration(UniformInt.of(2, 3), UniformInt.of(5, 10)));

    }



    public static ResourceKey<ConfiguredFeature<?, ?>> registerKey(String name) {
        return ResourceKey.create(Registries.CONFIGURED_FEATURE, new ResourceLocation(CrystalTech.MOD_ID, name));
    }

    private static <FC extends FeatureConfiguration, F extends Feature<FC>> void register(BootstapContext<ConfiguredFeature<?, ?>> context,
                                                                                          ResourceKey<ConfiguredFeature<?, ?>> key, F feature, FC configuration) {
        context.register(key, new ConfiguredFeature<>(feature, configuration));
    }
}
