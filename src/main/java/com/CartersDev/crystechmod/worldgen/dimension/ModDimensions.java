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
                new DimensionType.MonsterSettings(true, false, ConstantInt.of(0), 0)));
    }

    public static void bootstrapStem(BootstapContext<LevelStem> context) {
        HolderGetter<Biome> biomeRegistry = context.lookup(Registries.BIOME);
        HolderGetter<DimensionType> dimTypes = context.lookup(Registries.DIMENSION_TYPE);
        HolderGetter<NoiseGeneratorSettings> noiseGenSettings = context.lookup(Registries.NOISE_SETTINGS);


    //Flat World Generation:
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


        //End of Flat World Generation




        NoiseBasedChunkGenerator wrappedChunkGenerator = new NoiseBasedChunkGenerator(
                new FixedBiomeSource(biomeRegistry.getOrThrow(ModBiomes.TIBERIAN_DESERT)),
                noiseGenSettings.getOrThrow(NoiseGeneratorSettings.OVERWORLD));

        NoiseBasedChunkGenerator noiseBasedChunkGenerator = new NoiseBasedChunkGenerator(
                MultiNoiseBiomeSource.createFromList(
                        new Climate.ParameterList<>(List.of(
//                                  Start of Blue Zone Biomes:
                                    Pair.of(Climate.parameters(-0.45F, -1.0F, 0.11F, 0.55F, 0.0F, -0.4F, 0.0F), biomeRegistry.getOrThrow(ModBiomes.CALIDIAN_MARSH)),
                                    Pair.of(Climate.parameters(0.2F, 1.0F, 1.0F, 1.0F, 0.0F, -0.2666F, 0.0F), biomeRegistry.getOrThrow(ModBiomes.CALIDIAN_MARSH)),
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


//                                  Start of Yellow Zone Biomes:
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

//                                  Shores/Beaches:
                                Pair.of(Climate.parameters(-0.45F, -1.0F, -0.4F, 0.45F, 0.0F, -1.0F, 0.4F), biomeRegistry.getOrThrow(ModBiomes.YELLOW_ZONE_SHORE)),
                                Pair.of(Climate.parameters(-0.15F, -0.35F, -0.25F, 0.55F, 0.0F, -0.9333F, 0.4F), biomeRegistry.getOrThrow(ModBiomes.YELLOW_ZONE_SHORE)),
                                Pair.of(Climate.parameters(-1.0F, -1.0F, -0.39F, 0.55F, 0.0F, -0.4F, 0.4F), biomeRegistry.getOrThrow(ModBiomes.YELLOW_ZONE_STONY_SHORE)),
                                Pair.of(Climate.parameters(-0.45F, -0.35F, -0.21F, 1.0F, 0.0F, -0.2666F, 0.4F), biomeRegistry.getOrThrow(ModBiomes.YELLOW_ZONE_STONY_SHORE)),
                                Pair.of(Climate.parameters(-0.45F, -1.0F, -0.19F, 1.0F, 0.0F, -0.05F, 0.4F), biomeRegistry.getOrThrow(ModBiomes.INFECTED_RIVER)),
                                Pair.of(Climate.parameters(1.0F, 1.0F, -0.11F, -0.375F, 0.0F, 0.05F, 0.4F), biomeRegistry.getOrThrow(ModBiomes.INFECTED_RIVER)),

//                                  Ocean
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
                                Pair.of(Climate.parameters(-0.455F, 1.0F, -0.455F, 1.0F, 0.0F, 1.0F, 0.0F), biomeRegistry.getOrThrow(ModBiomes.INFECTED_OCEAN))



//                                  Start of Red Zone Biomes:


                        ))),
                noiseGenSettings.getOrThrow(NoiseGeneratorSettings.OVERWORLD));

        LevelStem stem = new LevelStem(dimTypes.getOrThrow(ModDimensions.VITRIC_EXPANSE_TYPE), noiseBasedChunkGenerator);

        context.register(VITRIC_EXPANSE_KEY, stem);

    }

}
