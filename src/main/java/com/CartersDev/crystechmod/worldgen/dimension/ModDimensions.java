package com.CartersDev.crystechmod.worldgen.dimension;

import com.CartersDev.crystechmod.CrystalTech;
import com.CartersDev.crystechmod.worldgen.biome.ModBiomes;
import com.google.common.collect.ImmutableSet;
import com.mojang.datafixers.util.Pair;
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
                OptionalLong.of(12000), // fixedTime
                true, // hasSkylight
                false, // hasCeiling
                false, // ultraWarm
                false, // natural
                1.0, // coordinateScale
                true, // bedWorks
                true, // respawnAnchorWorks
                0, // minY
                384, // height
                384, // logicalHeight
                BlockTags.INFINIBURN_OVERWORLD, // infiniburn
                BuiltinDimensionTypes.OVERWORLD_EFFECTS, // effectsLocation
                0.0f, // ambientLight
                new DimensionType.MonsterSettings(false, false, ConstantInt.of(0), 0)));
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
                noiseGenSettings.getOrThrow(VITRIC_EXPANSE_SETTINGS));

        NoiseBasedChunkGenerator noiseBasedChunkGenerator = new NoiseBasedChunkGenerator(
                MultiNoiseBiomeSource.createFromList(
                        new Climate.ParameterList<>(List.of(Pair.of(
                                        Climate.parameters(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F), biomeRegistry.getOrThrow(ModBiomes.TIBERIAN_DESERT)),
                                Pair.of(Climate.parameters(0.1F, 0.2F, 0.0F, 0.2F, 0.0F, 0.0F, 0.0F), biomeRegistry.getOrThrow(ModBiomes.DEAD_FOREST)),
                                Pair.of(Climate.parameters(0.3F, 0.6F, 0.1F, 0.1F, 0.0F, 0.0F, 0.0F), biomeRegistry.getOrThrow(ModBiomes.INFECTED_OCEAN)),
                                Pair.of(Climate.parameters(0.4F, 0.3F, 0.2F, 0.1F, 0.0F, 0.0F, 0.0F), biomeRegistry.getOrThrow(ModBiomes.BURNING_HILLS))

                        ))),
                noiseGenSettings.getOrThrow(VITRIC_EXPANSE_SETTINGS));

        LevelStem stem = new LevelStem(dimTypes.getOrThrow(ModDimensions.VITRIC_EXPANSE_TYPE), wrappedChunkGenerator);

        context.register(VITRIC_EXPANSE_KEY, stem);

    }

}
