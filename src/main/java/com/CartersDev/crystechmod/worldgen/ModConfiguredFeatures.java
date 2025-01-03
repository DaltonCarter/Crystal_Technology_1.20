package com.CartersDev.crystechmod.worldgen;

import com.CartersDev.crystechmod.CrystalTech;
import com.CartersDev.crystechmod.block.ModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.GeodeBlockSettings;
import net.minecraft.world.level.levelgen.GeodeCrackSettings;
import net.minecraft.world.level.levelgen.GeodeLayerSettings;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.*;
import net.minecraft.world.level.levelgen.feature.featuresize.ThreeLayersFeatureSize;
import net.minecraft.world.level.levelgen.feature.featuresize.TwoLayersFeatureSize;
import net.minecraft.world.level.levelgen.feature.foliageplacers.BlobFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
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

    //Flowers:
    public static final ResourceKey<ConfiguredFeature<?,?>> HYACINTH_KEY = registerKey("hyacinth");
    public static final ResourceKey<ConfiguredFeature<?,?>> SPITFIRE_KEY = registerKey("spitfire");
    public static final ResourceKey<ConfiguredFeature<?,?>> FULGURBLOOM_KEY = registerKey("fulgurbloom");

    public static void bootstrap (BootstapContext<ConfiguredFeature<?, ?>> context) {

        RuleTest stoneReplaceables = new TagMatchTest(BlockTags.STONE_ORE_REPLACEABLES);
        RuleTest deepslateReplaceables = new TagMatchTest(BlockTags.DEEPSLATE_ORE_REPLACEABLES);
        RuleTest netherrackReplaceables = new BlockMatchTest(Blocks.NETHERRACK);
        RuleTest endReplaceables = new BlockMatchTest(Blocks.END_STONE);
        RuleTest dimensionStoneReplaceables = new TagMatchTest(BlockTags.STONE_ORE_REPLACEABLES);

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
        register(context,CRYSTECH_GUNDANIUM_ORE_KEY, Feature.ORE, new OreConfiguration(gundaniumOre, 8));
        register(context,CRYSTECH_KRYON_ORE_KEY, Feature.ORE, new OreConfiguration(kryonOre, 4));
        register(context,CRYSTECH_ILLUMINA_ORE_KEY, Feature.ORE, new OreConfiguration(illuminaOre, 4));

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
        //MAXIMUM SETTINGS
//                        new GeodeLayerSettings(1.7D, 1.2D, 2.5D, 3.5D),
//                        new GeodeCrackSettings(0.25D, 1.5D, 1), 0.5D, 0.1D,
//                        true, UniformInt.of(3, 8),
//                        UniformInt.of(2, 6), UniformInt.of(1, 2),
//                        -18, 18, 0.075D, 1));


        //Flowers:
        register(context, HYACINTH_KEY, Feature.FLOWER,
                new RandomPatchConfiguration(32, 6, 2, PlacementUtils.onlyWhenEmpty(Feature.SIMPLE_BLOCK,
                        new SimpleBlockConfiguration(BlockStateProvider.simple(ModBlocks.HYACINTH.get())))));

        register(context, SPITFIRE_KEY, Feature.FLOWER,
                new RandomPatchConfiguration(64, 6, 2, PlacementUtils.onlyWhenEmpty(Feature.SIMPLE_BLOCK,
                        new SimpleBlockConfiguration(BlockStateProvider.simple(ModBlocks.SPITFIRE.get())))));

        register(context, FULGURBLOOM_KEY, Feature.FLOWER,
                new RandomPatchConfiguration(64, 6, 2, PlacementUtils.onlyWhenEmpty(Feature.SIMPLE_BLOCK,
                        new SimpleBlockConfiguration(BlockStateProvider.simple(ModBlocks.FULGURBLOOM.get())))));







    }



    public static ResourceKey<ConfiguredFeature<?, ?>> registerKey(String name) {
        return ResourceKey.create(Registries.CONFIGURED_FEATURE, new ResourceLocation(CrystalTech.MOD_ID, name));
    }

    private static <FC extends FeatureConfiguration, F extends Feature<FC>> void register(BootstapContext<ConfiguredFeature<?, ?>> context,
                                                                                          ResourceKey<ConfiguredFeature<?, ?>> key, F feature, FC configuration) {
        context.register(key, new ConfiguredFeature<>(feature, configuration));
    }
}