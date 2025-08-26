package com.CartersDev.crystechmod.worldgen.dimension;

import com.CartersDev.crystechmod.CrystalTech;
import com.CartersDev.crystechmod.worldgen.biome.ModBiomes;
import com.google.common.collect.ImmutableSet;
import com.mojang.datafixers.util.Pair;
import com.mojang.serialization.Codec;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.HolderSet;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.biome.*;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.dimension.BuiltinDimensionTypes;
import net.minecraft.world.level.dimension.DimensionType;
import net.minecraft.world.level.dimension.LevelStem;
import net.minecraft.world.level.levelgen.*;
import net.minecraft.world.level.levelgen.flat.FlatLayerInfo;
import net.minecraft.world.level.levelgen.flat.FlatLevelGeneratorSettings;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraft.world.level.levelgen.structure.BuiltinStructureSets;
import net.minecraft.world.level.levelgen.structure.StructureSet;

import java.util.List;
import java.util.Optional;
import java.util.OptionalLong;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ModDimensions {

///   The below was taken from vanilla and was left here in case I ever need to tweak, or find a better way of populating the Biomes.

//    private static final Climate.Parameter FULL_RANGE = Climate.Parameter.span(-1.0F, 1.0F);
//    private static final Climate.Parameter[] temperatures = new Climate.Parameter[]{Climate.Parameter.span(-1.0F, -0.45F), Climate.Parameter.span(-0.45F, -0.15F), Climate.Parameter.span(-0.15F, 0.2F), Climate.Parameter.span(0.2F, 0.55F), Climate.Parameter.span(0.55F, 1.0F)};
//    private static final Climate.Parameter[] humidities = new Climate.Parameter[]{Climate.Parameter.span(-1.0F, -0.35F), Climate.Parameter.span(-0.35F, -0.1F), Climate.Parameter.span(-0.1F, 0.1F), Climate.Parameter.span(0.1F, 0.3F), Climate.Parameter.span(0.3F, 1.0F)};
//    private static final Climate.Parameter[] erosions = new Climate.Parameter[]{Climate.Parameter.span(-1.0F, -0.78F), Climate.Parameter.span(-0.78F, -0.375F), Climate.Parameter.span(-0.375F, -0.2225F), Climate.Parameter.span(-0.2225F, 0.05F), Climate.Parameter.span(0.05F, 0.45F), Climate.Parameter.span(0.45F, 0.55F), Climate.Parameter.span(0.55F, 1.0F)};
//    private static final Climate.Parameter FROZEN_RANGE = temperatures[0];
//    private static final Climate.Parameter UNFROZEN_RANGE = Climate.Parameter.span(temperatures[1], temperatures[4]);
//    private static final Climate.Parameter mushroomFieldsContinentalness = Climate.Parameter.span(-1.2F, -1.05F);
//    private static final Climate.Parameter deepOceanContinentalness = Climate.Parameter.span(-1.05F, -0.455F);
//    private static final Climate.Parameter oceanContinentalness = Climate.Parameter.span(-0.455F, -0.19F);
//    private static final Climate.Parameter coastContinentalness = Climate.Parameter.span(-0.19F, -0.11F);
//    private static final Climate.Parameter inlandContinentalness = Climate.Parameter.span(-0.11F, 0.55F);
//    private static final Climate.Parameter nearInlandContinentalness = Climate.Parameter.span(-0.11F, 0.03F);
//    private static final Climate.Parameter midInlandContinentalness = Climate.Parameter.span(0.03F, 0.3F);
//    public static final Climate.Parameter farInlandContinentalness = Climate.Parameter.span(0.3F, 1.0F);

////-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------


    public static final ResourceKey<LevelStem> VITRIC_EXPANSE_KEY = ResourceKey.create(Registries.LEVEL_STEM,
            new ResourceLocation(CrystalTech.MOD_ID, "vitric_expanse"));

    public static final ResourceKey<Level> VITRIC_EXPANSE_LEVEL_KEY = ResourceKey.create(Registries.DIMENSION,
            new ResourceLocation(CrystalTech.MOD_ID, "vitric_expanse"));

    public static final ResourceKey<DimensionType> VITRIC_EXPANSE_TYPE = ResourceKey.create(Registries.DIMENSION_TYPE,
            new ResourceLocation(CrystalTech.MOD_ID, "vitric_expanse_type"));

    public static final ResourceKey<NoiseGeneratorSettings> VITRIC_EXPANSE_SETTINGS = ResourceKey.create(Registries.NOISE_SETTINGS,
            new ResourceLocation(CrystalTech.MOD_ID, "vitric_expanse_settings"));

    public static void bootstrapType(BootstapContext<DimensionType> context) {
        context.register(VITRIC_EXPANSE_TYPE, new DimensionType(
                OptionalLong.empty(), // fixedTime
                true, // hasSkylight
                false, // hasCeiling
                false, // ultraWarm
                true, // natural
                1.0, // coordinateScale
                true, // bedWorks
                false, // respawnAnchorWorks
                -64, // minY
                384, // height
                384, // logicalHeight
                BlockTags.INFINIBURN_OVERWORLD, // infiniburn
                BuiltinDimensionTypes.OVERWORLD_EFFECTS, // effectsLocation
                0.0f, // ambientLight
                new DimensionType.MonsterSettings(true, false, ConstantInt.of(8), 0)));
    }

    public static void bootstrapStem(BootstapContext<LevelStem> context) {
        HolderGetter<Biome> biomeRegistry = context.lookup(Registries.BIOME);
        HolderGetter<DimensionType> dimTypes = context.lookup(Registries.DIMENSION_TYPE);
        HolderGetter<NoiseGeneratorSettings> noiseGenSettings = context.lookup(Registries.NOISE_SETTINGS);


    ///  Flat World Generation:
        HolderGetter<StructureSet> structures = context.lookup(Registries.STRUCTURE_SET);
        HolderGetter<PlacedFeature> placedFeatures = context.lookup(Registries.PLACED_FEATURE);
        HolderSet.Direct<StructureSet> direct = HolderSet.direct(ImmutableSet.of(BuiltinStructureSets.VILLAGES).stream()
                .map(structures::getOrThrow).collect(Collectors.toList()));

//        FlatLevelGeneratorSettings flatLevelGeneratorSettings = new FlatLevelGeneratorSettings(Optional.of(direct), biomeRegistry.getOrThrow(ModBiomes.TIBERIAN_DESERT),
//                FlatLevelGeneratorSettings.createLakesList(placedFeatures));
//        FlatLayerInfo bedrock = new FlatLayerInfo(1, Blocks.BEDROCK);
//        FlatLayerInfo deepslate = new FlatLayerInfo(60, Blocks.DEEPSLATE);
//        FlatLayerInfo stone = new FlatLayerInfo(60, Blocks.STONE);
//        FlatLayerInfo dirt = new FlatLayerInfo(3, Blocks.DIRT);
//        FlatLayerInfo grass_block = new FlatLayerInfo(1, Blocks.GRASS_BLOCK);
//        flatLevelGeneratorSettings.getLayersInfo().add(bedrock);
//        flatLevelGeneratorSettings.getLayersInfo().add(deepslate);
//        flatLevelGeneratorSettings.getLayersInfo().add(stone);
//        flatLevelGeneratorSettings.getLayersInfo().add(dirt);
//        flatLevelGeneratorSettings.getLayersInfo().add(grass_block);
//        flatLevelGeneratorSettings.setAddLakes();
//        flatLevelGeneratorSettings.setDecoration();
//        FlatLevelSource flatChunkGenerator = new FlatLevelSource(
//                flatLevelGeneratorSettings
//        );


///     End of Flat World Generation



///     Single Chunk Gen

        NoiseBasedChunkGenerator wrappedChunkGenerator = new NoiseBasedChunkGenerator(
                new FixedBiomeSource(biomeRegistry.getOrThrow(ModBiomes.TIBERIAN_DESERT)),
                noiseGenSettings.getOrThrow(NoiseGeneratorSettings.OVERWORLD));

///    End Single Chunk Gen




///       Overworld Like Generation

        NoiseBasedChunkGenerator noiseBasedChunkGenerator = new NoiseBasedChunkGenerator(


                MultiNoiseBiomeSource.createFromList(
                        new Climate.ParameterList<>(List.of(

////                                  Shores/Beaches:
                                Pair.of(Climate.parameters(-0.45F, -1.0F, -0.4F, 0.45F, 0.0F, -1.0F, 0.4F), biomeRegistry.getOrThrow(ModBiomes.YELLOW_ZONE_SHORE)),
                                Pair.of(Climate.parameters(-0.15F, -0.35F, -0.25F, 0.55F, 0.0F, -0.9333F, 0.4F), biomeRegistry.getOrThrow(ModBiomes.YELLOW_ZONE_SHORE)),
                                Pair.of(Climate.parameters(-1.0F, -1.0F, -0.39F, 0.55F, 0.0F, -0.4F, 0.4F), biomeRegistry.getOrThrow(ModBiomes.YELLOW_ZONE_STONY_SHORE)),
                                Pair.of(Climate.parameters(-0.45F, -0.35F, -0.21F, 1.0F, 0.0F, -0.2666F, 0.4F), biomeRegistry.getOrThrow(ModBiomes.YELLOW_ZONE_STONY_SHORE)),
                                Pair.of(Climate.parameters(-0.45F, -0.35F, -0.19F, -0.2225F, 0.0F, 0.05F, 0.4F), biomeRegistry.getOrThrow(ModBiomes.RED_ZONE_SHORE)),
                                Pair.of(Climate.parameters(-0.15F, -0.1F, -0.11F, 0.45F, 0.0F, 0.2666F, 0.4F), biomeRegistry.getOrThrow(ModBiomes.RED_ZONE_SHORE)),
                                Pair.of(Climate.parameters(-0.45F, -1.0F, -0.19F, 1.0F, 0.0F, -0.05F, 0.4F), biomeRegistry.getOrThrow(ModBiomes.INFECTED_RIVER)),
                                Pair.of(Climate.parameters(1.0F, 1.0F, -0.11F, -0.375F, 0.0F, 0.05F, 0.4F), biomeRegistry.getOrThrow(ModBiomes.INFECTED_RIVER)),
                                Pair.of(Climate.parameters(-1.0F, -1.0F, -0.19F, -0.375F, 0.0F, -0.05F, 0.4F), biomeRegistry.getOrThrow(ModBiomes.RED_ZONE_RIVER)),
                                Pair.of(Climate.parameters(1.0F, 1.0F, 1.0F, 0.55F, 0.0F, 0.05F, 0.4F), biomeRegistry.getOrThrow(ModBiomes.RED_ZONE_RIVER)),



////                                  Ocean:
                                Pair.of(Climate.parameters(-0.15F, -1.0F, -0.455F, -1.0F, 0.0F, -1.0F, 0.0F), biomeRegistry.getOrThrow(ModBiomes.INFECTED_OCEAN)),
                                Pair.of(Climate.parameters(0.2F, 1.0F, -0.19F, 1.0F, 0.0F, 1.0F, 0.0F), biomeRegistry.getOrThrow(ModBiomes.INFECTED_OCEAN)),
                                Pair.of(Climate.parameters(-0.15F, -1.0F, -1.05F, -1.0F, 0.0F, -1.0F, 0.0F), biomeRegistry.getOrThrow(ModBiomes.INFECTED_OCEAN)),
                                Pair.of(Climate.parameters(0.2F, 1.0F, -0.455F, 1.0F, 0.0F, 1.0F, 0.0F), biomeRegistry.getOrThrow(ModBiomes.INFECTED_OCEAN)),
                                Pair.of(Climate.parameters(-0.45F, -1.0F, -0.455F, -1.0F, 0.0F, -1.0F, 0.0F), biomeRegistry.getOrThrow(ModBiomes.INFECTED_OCEAN)),
                                Pair.of(Climate.parameters(-0.15F, 1.0F, -0.19F, 1.0F, 0.0F, 1.0F, 0.0F), biomeRegistry.getOrThrow(ModBiomes.INFECTED_OCEAN)),
                                Pair.of(Climate.parameters(-0.45F, -1.0F, -1.05F, -1.0F, 0.0F, -1.0F, 0.0F), biomeRegistry.getOrThrow(ModBiomes.INFECTED_OCEAN)),
                                Pair.of(Climate.parameters(-0.15F, 1.0F, -0.455F, 1.0F, 0.0F, 1.0F, 0.0F), biomeRegistry.getOrThrow(ModBiomes.INFECTED_OCEAN)),
                                Pair.of(Climate.parameters(0.2F, -1.0F, -0.455F, -1.0F, 0.0F, -1.0F, 0.0F), biomeRegistry.getOrThrow(ModBiomes.INFECTED_OCEAN)),
                                Pair.of(Climate.parameters(0.55F, 1.0F, -0.19F, 1.0F, 0.0F, 1.0F, 0.0F), biomeRegistry.getOrThrow(ModBiomes.INFECTED_OCEAN)),
                                Pair.of(Climate.parameters(0.2F, -1.0F, -1.05F, -1.0F, 0.0F, -1.0F, 0.0F), biomeRegistry.getOrThrow(ModBiomes.INFECTED_OCEAN)),
                                Pair.of(Climate.parameters(0.55F, 1.0F, -0.455F, 1.0F, 0.0F, 1.0F, 0.0F), biomeRegistry.getOrThrow(ModBiomes.INFECTED_OCEAN)),
                                Pair.of(Climate.parameters(0.55F, -1.0F, -0.455F, -1.0F, 0.0F, -1.0F, 0.0F), biomeRegistry.getOrThrow(ModBiomes.INFECTED_OCEAN)),
                                Pair.of(Climate.parameters(1.0F, 1.0F, -0.19F, 1.0F, 0.0F, 1.0F, 0.0F), biomeRegistry.getOrThrow(ModBiomes.INFECTED_OCEAN)),
                                Pair.of(Climate.parameters(0.55F, -1.0F, -1.05F, -1.0F, 0.0F, -1.0F, 0.0F), biomeRegistry.getOrThrow(ModBiomes.INFECTED_OCEAN)),
                                Pair.of(Climate.parameters(1.0F, 1.0F, -0.455F, 1.0F, 0.0F, 1.0F, 0.0F), biomeRegistry.getOrThrow(ModBiomes.INFECTED_OCEAN)),
                                Pair.of(Climate.parameters(-1.05F, -1.0F, -0.455F, -1.0F, 0.0F, -1.0F, 0.0F), biomeRegistry.getOrThrow(ModBiomes.INFECTED_OCEAN)),
                                Pair.of(Climate.parameters(-0.455F, 1.0F, -0.19F, 1.0F, 0.0F, 1.0F, 0.0F), biomeRegistry.getOrThrow(ModBiomes.INFECTED_OCEAN)),
                                Pair.of(Climate.parameters(-1.05F, -1.0F, -1.05F, -1.0F, 0.0F, -1.0F, 0.0F), biomeRegistry.getOrThrow(ModBiomes.INFECTED_OCEAN)),
                                Pair.of(Climate.parameters(-0.455F, 1.0F, -0.455F, 1.0F, 0.0F, 1.0F, 0.0F), biomeRegistry.getOrThrow(ModBiomes.INFECTED_OCEAN)),



////                                  Start of Blue Zone Biomes:
                                    Pair.of(Climate.parameters(-0.45F, -1.0F, -0.11F, 0.55F, 0.0F, 0.05F, 0.0F), biomeRegistry.getOrThrow(ModBiomes.CALIDIAN_MARSH)),
                                    Pair.of(Climate.parameters(-1.0F, 1.0F, 1.0F, 1.0F, 0.0F, 0.2666F, 0.0F), biomeRegistry.getOrThrow(ModBiomes.CALIDIAN_MARSH)),
                                    Pair.of(Climate.parameters(-1.0F, -0.1F, 1.5F, -1.0F, 0.0F, -0.4F, 0.0F), biomeRegistry.getOrThrow(ModBiomes.GROVE_OF_LIFE)),
                                    Pair.of(Climate.parameters(-1.0F, 0.1F, 1.0F, -0.7799F, 0.0F, -0.2666F, 0.0F), biomeRegistry.getOrThrow(ModBiomes.GROVE_OF_LIFE)),
                                    Pair.of(Climate.parameters(0.2F, -0.35F, 0.9F, -1.0F, 0.0F, -0.4F, 0.0F), biomeRegistry.getOrThrow(ModBiomes.FOOTHILLS)),
                                    Pair.of(Climate.parameters(0.55F, -0.1F, 1.0F, -0.7799F, 0.0F, -0.5666F, 0.0F), biomeRegistry.getOrThrow(ModBiomes.FOOTHILLS)),
                                    Pair.of(Climate.parameters(0.2F, -0.3F, 0.11F, -1.0F, 0.0F, -0.4F, 0.0F), biomeRegistry.getOrThrow(ModBiomes.PRIMAL_JUNGLE)),
                                    Pair.of(Climate.parameters(0.55F, 1.0F, 0.03F, -0.7799F, 0.0F, -0.5666F, 0.0F), biomeRegistry.getOrThrow(ModBiomes.PRIMAL_JUNGLE)),
                                    Pair.of(Climate.parameters(-0.45F, -1.0F, 0.25F, -0.375F, 0.0F, -0.5666F, 0.0F), biomeRegistry.getOrThrow(ModBiomes.BLUE_AND_YELLOW_ZONE_BORDER)),
                                    Pair.of(Climate.parameters(-0.15F, -0.35F, 0.75F, 0.05F, 0.0F, -0.7666F, 0.0F), biomeRegistry.getOrThrow(ModBiomes.BLUE_AND_YELLOW_ZONE_BORDER)),
                                    Pair.of(Climate.parameters(0.75F, -0.35F, 0.75F, -1.0F, 0.0F, -0.4F, 0.0F), biomeRegistry.getOrThrow(ModBiomes.BURNING_HILLS)),
                                    Pair.of(Climate.parameters(1.5F, -0.1F, 1.0F, -0.7799F, 0.0F, -0.5666F, 0.0F), biomeRegistry.getOrThrow(ModBiomes.BURNING_HILLS)),
                                    Pair.of(Climate.parameters(1.25F, 0.5F, 0.3F, -0.375F, 0.0F, -0.5666F, 0.0F), biomeRegistry.getOrThrow(ModBiomes.EMBER_GROVE)),
                                    Pair.of(Climate.parameters(2.0F, 0.1F, 1.0F, -0.2225F, 0.0F, -0.7666F, 0.0F), biomeRegistry.getOrThrow(ModBiomes.EMBER_GROVE)),
                                    Pair.of(Climate.parameters(1.25F, 0.5F, 0.9F, -1.0F, 0.0F, 1.9F, 0.0F), biomeRegistry.getOrThrow(ModBiomes.INFERNO_PEAK)),
                                    Pair.of(Climate.parameters(2.0F, 0.1F, 1.0F, -0.8559F, 0.0F, 1.5F, 0.0F), biomeRegistry.getOrThrow(ModBiomes.INFERNO_PEAK)),
                                    Pair.of(Climate.parameters(0.2F, -0.35F, 0.75F, -1.0F, 0.0F, -0.4F, 0.0F), biomeRegistry.getOrThrow(ModBiomes.UNTARNISHED_HILLS)),
                                    Pair.of(Climate.parameters(-0.2F, -0.1F, 1.0F, -0.7799F, 0.0F, -0.5666F, 0.0F), biomeRegistry.getOrThrow(ModBiomes.UNTARNISHED_HILLS)),
                                    Pair.of(Climate.parameters(0.45F, -1.0F, 0.03F, 0.7799F, 0.0F, 0.5666F, 0.0F), biomeRegistry.getOrThrow(ModBiomes.EVERGOLD_EXPANSE)),
                                    Pair.of(Climate.parameters(0.15F, -0.35F, 0.3F, 0.9999F, 0.0F, 0.7666F, 0.0F), biomeRegistry.getOrThrow(ModBiomes.EVERGOLD_EXPANSE)),
                                    Pair.of(Climate.parameters(0.45F, -1.0F, 0.03F, -0.7799F, 0.0F, -0.5666F, 0.0F), biomeRegistry.getOrThrow(ModBiomes.VALLEY_OF_GOLD)),
                                    Pair.of(Climate.parameters(0.15F, -0.35F, 0.3F, -0.9999F, 0.0F, -0.7666F, 0.0F), biomeRegistry.getOrThrow(ModBiomes.VALLEY_OF_GOLD)),



////                                  Start of Yellow Zone Biomes:
                                Pair.of(Climate.parameters(-0.45F, -0.1F, 0.19F, -0.7799F, 0.0F, 0.5666F, 0.0F), biomeRegistry.getOrThrow(ModBiomes.DEAD_FOREST)),
                                Pair.of(Climate.parameters(-0.15F, 0.1F, 0.03F, -0.375F, 0.0F, 0.7666F, 0.0F), biomeRegistry.getOrThrow(ModBiomes.DEAD_FOREST)),
                                Pair.of(Climate.parameters(1.0F, -1.0F, 0.11F, -0.375F, 0.0F, -1.0F, 0.0F), biomeRegistry.getOrThrow(ModBiomes.TIBERIAN_DESERT)),
                                Pair.of(Climate.parameters(0.55F, -0.35F, 0.03F, -0.2225F, 0.0F, -0.9333F, 0.0F), biomeRegistry.getOrThrow(ModBiomes.TIBERIAN_DESERT)),
                                Pair.of(Climate.parameters(1.0F, -1.0F, 0.8F, 0.45F, 0.0F, -0.9333F, 0.0F), biomeRegistry.getOrThrow(ModBiomes.TIBERIAN_DESERT_HILLS)),
                                Pair.of(Climate.parameters(0.55F, -0.35F, 1.0F, 0.55F, 0.0F, -0.7666F, 0.0F), biomeRegistry.getOrThrow(ModBiomes.TIBERIAN_DESERT_HILLS)),
                                Pair.of(Climate.parameters(0.55F, -0.1F, 0.19F, -0.7799F, 0.0F, 0.5666F, 0.0F), biomeRegistry.getOrThrow(ModBiomes.TIBERIAN_BADLANDS)),
                                Pair.of(Climate.parameters(1.0F, 0.1F, 0.15F, -0.375F, 0.0F, 0.7666F, 0.0F), biomeRegistry.getOrThrow(ModBiomes.TIBERIAN_BADLANDS)),
                                Pair.of(Climate.parameters(-0.55F, -0.1F, 0.19F, -0.7799F, 0.0F, 0.5666F, 0.0F), biomeRegistry.getOrThrow(ModBiomes.TIBERIAN_HIGHLANDS)),
                                Pair.of(Climate.parameters(-1.0F, 0.1F, 0.15F, -0.375F, 0.0F, 0.7666F, 0.0F), biomeRegistry.getOrThrow(ModBiomes.TIBERIAN_HIGHLANDS)),
                                Pair.of(Climate.parameters(0.45F, -0.1F, 0.19F, -0.7799F, 0.0F, 0.5666F, 0.0F), biomeRegistry.getOrThrow(ModBiomes.OLD_BATTLEFIELD)),
                                Pair.of(Climate.parameters(0.15F, 0.1F, 0.03F, -0.375F, 0.0F, 0.7666F, 0.0F), biomeRegistry.getOrThrow(ModBiomes.OLD_BATTLEFIELD)),
                                Pair.of(Climate.parameters(0.2F, -0.35F, 1.0F, -1.0F, 0.0F, -0.4F, 0.0F), biomeRegistry.getOrThrow(ModBiomes.LOST_STEPPES)),
                                Pair.of(Climate.parameters(0.55F, -0.1F, 1.3F, -0.7799F, 0.0F, -0.5666F, 0.0F), biomeRegistry.getOrThrow(ModBiomes.LOST_STEPPES)),
                                Pair.of(Climate.parameters(1.2F, 0.8F, 0.800F, 1.0F, 0.0F, 0.05F, 0.0F), biomeRegistry.getOrThrow(ModBiomes.DRY_HILLS)),
                                Pair.of(Climate.parameters(1.5F, 1.0F, 0.600F, 0.375F, 0.0F, 0.05F, 0.0F), biomeRegistry.getOrThrow(ModBiomes.DRY_HILLS)),
                                Pair.of(Climate.parameters(1.2F, 0.8F, 0.700F, -1.0F, 0.0F, -0.05F, 0.0F), biomeRegistry.getOrThrow(ModBiomes.DRY_VALLEY)),
                                Pair.of(Climate.parameters(1.5F, 1.0F, 0.500F, -0.375F, 0.0F, -0.05F, 0.0F), biomeRegistry.getOrThrow(ModBiomes.DRY_VALLEY)),
                                Pair.of(Climate.parameters(0.3F, -0.1F, 0.40F, -0.7799F, 0.0F, 0.5666F, 0.0F), biomeRegistry.getOrThrow(ModBiomes.FORGOTTEN_HIGHLANDS)),
                                Pair.of(Climate.parameters(0.4F, 0.1F, 0.60F, -0.375F, 0.0F, 0.7666F, 0.0F), biomeRegistry.getOrThrow(ModBiomes.FORGOTTEN_HIGHLANDS)),
                                Pair.of(Climate.parameters(-0.45F, -1.0F, 0.24F, -0.375F, 0.0F, -0.5666F, 0.0F), biomeRegistry.getOrThrow(ModBiomes.RED_AND_YELLOW_ZONE_BORDER)),
                                Pair.of(Climate.parameters(-0.15F, -0.35F, 0.54F, 0.05F, 0.0F, -0.7666F, 0.0F), biomeRegistry.getOrThrow(ModBiomes.RED_AND_YELLOW_ZONE_BORDER)),
                                Pair.of(Climate.parameters(0.5F, -0.1F, 0.10F, -0.7799F, 0.0F, 0.5666F, 0.0F), biomeRegistry.getOrThrow(ModBiomes.RUINED_CITY)),
                                Pair.of(Climate.parameters(0.1F, 0.1F, 0.06F, -0.375F, 0.0F, 0.7666F, 0.0F), biomeRegistry.getOrThrow(ModBiomes.RUINED_CITY)),
                                Pair.of(Climate.parameters(-1.0F, -0.1F, 0.1F, -0.2225F, 0.0F, -1.0F, 0.0F), biomeRegistry.getOrThrow(ModBiomes.TIBERIAN_STONE_FIELDS)),
                                Pair.of(Climate.parameters(-0.45F, -0.35F, 1.0F, 0.05F, 0.0F, -0.9333F, 0.0F), biomeRegistry.getOrThrow(ModBiomes.TIBERIAN_STONE_FIELDS)),
                                Pair.of(Climate.parameters(-1.0F, -0.15F, 0.15F, -0.2225F, 0.0F, -1.0F, 0.0F), biomeRegistry.getOrThrow(ModBiomes.CRYSTAL_FIELDS)),
                                Pair.of(Climate.parameters(-0.45F, -0.45F, 1.0F, 0.05F, 0.0F, -0.9333F, 0.0F), biomeRegistry.getOrThrow(ModBiomes.CRYSTAL_FIELDS)),
                                Pair.of(Climate.parameters(-1.0F, 0.1F, 0.03F, -1.0F, 0.0F, -0.05F, 0.0F), biomeRegistry.getOrThrow(ModBiomes.TIBERIAN_TAIGA)),
                                Pair.of(Climate.parameters(-0.45F, 0.3F, 1.0F, -0.375F, 0.0F, 0.05F, 0.0F), biomeRegistry.getOrThrow(ModBiomes.TIBERIAN_TAIGA)),
                                Pair.of(Climate.parameters(-0.45F, -1.0F, -0.11F, 0.55F, 0.0F, 0.05F, 0.0F), biomeRegistry.getOrThrow(ModBiomes.TIBERIAN_SWAMP)),
                                Pair.of(Climate.parameters(-0.15F, 1.0F, 1.0F, 1.0F, 0.0F, 0.2666F, 0.0F), biomeRegistry.getOrThrow(ModBiomes.TIBERIAN_SWAMP)),
                                Pair.of(Climate.parameters(-0.15F, 0.3F, -0.19F, -1.0F, 0.0F, 0.05F, 0.0F), biomeRegistry.getOrThrow(ModBiomes.TIBERIAN_WOODS)),
                                Pair.of(Climate.parameters(0.2F, 1.0F, 0.03F, -0.375F, 0.0F, 0.2666F, 0.0F), biomeRegistry.getOrThrow(ModBiomes.TIBERIAN_WOODS)),



////                                  Start of Red Zone Biomes:
                                Pair.of(Climate.parameters(0.2F, -1.0F, -0.11F, -1.0F, 0.0F, 0.05F, 0.0F), biomeRegistry.getOrThrow(ModBiomes.ASHLANDS)),
                                Pair.of(Climate.parameters(0.55F, -0.35F, 0.03F, -0.375F, 0.0F, 0.2666F, 0.0F), biomeRegistry.getOrThrow(ModBiomes.ASHLANDS)),
                                Pair.of(Climate.parameters(0.55F, -1.0F, 0.19F, -0.2225F, 0.0F, -0.05F, 0.0F), biomeRegistry.getOrThrow(ModBiomes.SCORCHED_DESERT)),
                                Pair.of(Climate.parameters(1.0F, -0.35F, 0.11F, 0.45F, 0.0F, 0.2666F, 0.0F), biomeRegistry.getOrThrow(ModBiomes.SCORCHED_DESERT)),
                                Pair.of(Climate.parameters(0.55F, -1.0F, 0.19F, 0.45F, 0.0F, 0.05F, 0.0F), biomeRegistry.getOrThrow(ModBiomes.SCORCHED_HILLS)),
                                Pair.of(Climate.parameters(1.0F, -0.35F, 0.11F, 0.55F, 0.0F, 0.2666F, 0.0F), biomeRegistry.getOrThrow(ModBiomes.SCORCHED_HILLS)),
                                Pair.of(Climate.parameters(0.55F, -0.35F, 0.11F, -1.0F, 0.0F, 0.05F, 0.0F), biomeRegistry.getOrThrow(ModBiomes.WASTELAND)),
                                Pair.of(Climate.parameters(1.0F, -0.1F, 0.03F, -0.375F, 0.0F, 0.2666F, 0.0F), biomeRegistry.getOrThrow(ModBiomes.WASTELAND)),
                                Pair.of(Climate.parameters(0.55F, -1.0F, 0.25F, 0.45F, 0.0F, 0.05F, 0.0F), biomeRegistry.getOrThrow(ModBiomes.WASTELAND_HILLS)),
                                Pair.of(Climate.parameters(1.0F, -0.35F, 0.19F, 0.55F, 0.0F, 0.2666F, 0.0F), biomeRegistry.getOrThrow(ModBiomes.WASTELAND_HILLS)),
                                Pair.of(Climate.parameters(0.45F, -1.0F, 0.14F, -0.375F, 0.0F, -0.5666F, 0.0F), biomeRegistry.getOrThrow(ModBiomes.RED_AND_BLUE_ZONE_BORDER)),
                                Pair.of(Climate.parameters(-0.15F, -0.35F, 0.34F, 0.05F, 0.0F, -0.7666F, 0.0F), biomeRegistry.getOrThrow(ModBiomes.RED_AND_BLUE_ZONE_BORDER)),
                                Pair.of(Climate.parameters(-0.45F, -0.1F, 0.6F, -0.7799F, 0.0F, 0.5666F, 0.0F), biomeRegistry.getOrThrow(ModBiomes.OLD_WAR_ZONE)),
                                Pair.of(Climate.parameters(0.15F, 0.1F, 0.06F, -0.375F, 0.0F, 0.7666F, 0.0F), biomeRegistry.getOrThrow(ModBiomes.OLD_WAR_ZONE)),
                                Pair.of(Climate.parameters(-0.15F, 0.1F, -0.11F, -0.7799F, 0.0F, 0.2666F, 0.0F), biomeRegistry.getOrThrow(ModBiomes.PLAGUED_WOODS)),
                                Pair.of(Climate.parameters(0.2F, 0.3F, 0.03F, -0.375F, 0.0F, 0.4F, 0.0F), biomeRegistry.getOrThrow(ModBiomes.PLAGUED_WOODS)),
                                Pair.of(Climate.parameters(-0.15F, -1.0F, -0.08F, 0.55F, 0.0F, 0.05F, 0.0F), biomeRegistry.getOrThrow(ModBiomes.ICHOR_MARSH)),
                                Pair.of(Climate.parameters(0.2F, 1.0F, 1.0F, 1.0F, 0.0F, 0.2666F, 0.0F), biomeRegistry.getOrThrow(ModBiomes.ICHOR_MARSH)),
                                Pair.of(Climate.parameters(0.2F, -1.0F, 0.25F, 0.55F, 0.0F, 0.05F, 0.0F), biomeRegistry.getOrThrow(ModBiomes.ABYSSAL_MARSH)),
                                Pair.of(Climate.parameters(0.55F, 1.0F, 1.0F, 1.0F, 0.0F, 0.2666F, 0.0F), biomeRegistry.getOrThrow(ModBiomes.ABYSSAL_MARSH)),
                                Pair.of(Climate.parameters(0.55F, -1.0F, -0.09F, -0.19F, 0.0F, 0.05F, 0.0F), biomeRegistry.getOrThrow(ModBiomes.ICHOR_BOG)),
                                Pair.of(Climate.parameters(1.0F, 1.0F, 1.0F, 0.3F, 0.0F, 0.2666F, 0.0F), biomeRegistry.getOrThrow(ModBiomes.ICHOR_BOG)),
                                Pair.of(Climate.parameters(-1.0F, -1.0F, 0.0F, -0.0256F, 0.0F, -0.4655F, 0.0F), biomeRegistry.getOrThrow(ModBiomes.TIBERIAN_WASTES)),
                                Pair.of(Climate.parameters(1.0F, 1.0F, 0.40F, 0.3900F, 0.0F, 0.2975F, 0.0F), biomeRegistry.getOrThrow(ModBiomes.TIBERIAN_WASTES)),
                                Pair.of(Climate.parameters(0.6F, -0.5F, 0.06F, 0.0256F, 0.0F, 0.4655F, 0.0F), biomeRegistry.getOrThrow(ModBiomes.DEAD_ZONE)),
                                Pair.of(Climate.parameters(0.8F, 0.9F, 0.670F, -0.3900F, 0.0F, -0.2975F, 0.0F), biomeRegistry.getOrThrow(ModBiomes.DEAD_ZONE)),
                                Pair.of(Climate.parameters(0.15F, -0.6F, 0.075F, 0.0256F, 0.0F, 0.4655F, 0.0F), biomeRegistry.getOrThrow(ModBiomes.DEAD_PLAINS)),
                                Pair.of(Climate.parameters(0.25F, 0.1F, 0.370F, 0.0F, 0.0F, 0.0F, 0.0F), biomeRegistry.getOrThrow(ModBiomes.DEAD_PLAINS)),
                                Pair.of(Climate.parameters(1.0F, -0.6F, 0.175F, 0.0256F, 0.0F, 0.4655F, 0.0F), biomeRegistry.getOrThrow(ModBiomes.FIRESTORM_PLAINS)),
                                Pair.of(Climate.parameters(0.8F, 0.1F, 0.270F, 0.0F, 0.0F, 0.0F, 0.0F), biomeRegistry.getOrThrow(ModBiomes.FIRESTORM_PLAINS)),
                                Pair.of(Climate.parameters(1.0F, -0.6F, 0.175F, -0.0256F, 0.0F, 0.4655F, 0.0F), biomeRegistry.getOrThrow(ModBiomes.BROODING_LANDS)),
                                Pair.of(Climate.parameters(0.8F, 0.1F, 0.270F, 0.0F, 0.0F, 0.8776F, 0.0F), biomeRegistry.getOrThrow(ModBiomes.BROODING_LANDS)),
                                Pair.of(Climate.parameters(1.0F, -0.6F, 0.200F, -0.0256F, 0.0F, 0.4655F, 0.0F), biomeRegistry.getOrThrow(ModBiomes.CRYSTALLINE_PLATEAU)),
                                Pair.of(Climate.parameters(0.8F, 0.1F, 0.470F, 0.0F, 0.0F, 0.8776F, 0.0F), biomeRegistry.getOrThrow(ModBiomes.CRYSTALLINE_PLATEAU)),

                                Pair.of(Climate.parameters(1.0F, -0.6F, 0.280F, -0.6777F, 0.0F, 0.4655F, 0.0F), biomeRegistry.getOrThrow(ModBiomes.CRYSTALLINE_HILLS)),
                                Pair.of(Climate.parameters(0.8F, 0.1F, 0.570F, -0.4555F, 0.0F, 0.8776F, 0.0F), biomeRegistry.getOrThrow(ModBiomes.CRYSTALLINE_HILLS
                                ))

                        ))),
                noiseGenSettings.getOrThrow(NoiseGeneratorSettings.OVERWORLD));

        LevelStem stem = new LevelStem(dimTypes.getOrThrow(ModDimensions.VITRIC_EXPANSE_TYPE), noiseBasedChunkGenerator);

        context.register(VITRIC_EXPANSE_KEY, stem);

    }

}
