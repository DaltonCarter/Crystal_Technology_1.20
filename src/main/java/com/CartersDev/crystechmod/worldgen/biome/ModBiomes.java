package com.CartersDev.crystechmod.worldgen.biome;

import com.CartersDev.crystechmod.CrystalTech;
import com.CartersDev.crystechmod.entity.ModEntities;
import com.CartersDev.crystechmod.sound.ModSounds;
import com.CartersDev.crystechmod.worldgen.ModPlacedFeatures;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BiomeDefaultFeatures;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.data.worldgen.Carvers;
import net.minecraft.data.worldgen.placement.OrePlacements;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.Musics;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.level.biome.*;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;

public class ModBiomes {
//Overworld:
    //Ember themed:
    public static final ResourceKey<Biome> EMBER_GLOW_FOREST = register("ember_glow_forest");
    public static final ResourceKey<Biome> EMBRAN_VALLEY = register("embran_valley");
    //Marika themed:
    public static final ResourceKey<Biome> AMBER_GROVE = register("amber_grove");
    public static final ResourceKey<Biome> HORNSENT_HILLS = register("hornsent_hills");


//The Vitric Expanse:
    //Blue Zones:
    public static final ResourceKey<Biome> CALIDIAN_MARSH = register("calidian_marsh");
    public static final ResourceKey<Biome> GROVE_OF_LIFE = register("grove_of_life");
    public static final ResourceKey<Biome> FOOTHILLS = register("foothills");
    public static final ResourceKey<Biome> PRIMAL_JUNGLE = register("primal_jungle");


        //Ember themed:
    public static final ResourceKey<Biome> BURNING_HILLS = register("burning_hills");
    public static final ResourceKey<Biome> EMBER_GROVE = register("ember_grove");
    public static final ResourceKey<Biome> INFERNO_PEAK = register("inferno_peak");


        //Marika themed:
    public static final ResourceKey<Biome> UNTARNISHED_HILLS = register("untarnished_hills");
    public static final ResourceKey<Biome> EVERGOLD_EXPANSE = register("evergold_expanse");
    public static final ResourceKey<Biome> VALLEY_OF_GOLD = register("valley_of_gold");

    //Yellow Zone:
    public static final ResourceKey<Biome> DEAD_FOREST = register("dead_forest");
    public static final ResourceKey<Biome> TIBERIAN_DESERT = register("tiberian_desert");
    public static final ResourceKey<Biome> TIBERIAN_DESERT_HILLS = register("tiberian_desert_hills");
    public static final ResourceKey<Biome> TIBERIAN_BADLANDS = register("tiberian_badlands");
    public static final ResourceKey<Biome> TIBERIAN_HIGHLANDS = register("tiberian_highlands");
    public static final ResourceKey<Biome> OLD_BATTLEFIELD = register("old_battlefield");
    public static final ResourceKey<Biome> LOST_STEPPES = register("lost_steppes");
    public static final ResourceKey<Biome> YELLOW_ZONE_SHORE = register("yellow_zone_shore");
    public static final ResourceKey<Biome> INFECTED_RIVER = register("infected_river");
    public static final ResourceKey<Biome> INFECTED_OCEAN = register("infected_ocean");
    public static final ResourceKey<Biome> DRY_HILLS = register("dry_hills");
    public static final ResourceKey<Biome> DRY_VALLEY = register("dry_valley");
    public static final ResourceKey<Biome> FORGOTTEN_HIGHLANDS = register("forgotten_highlands");
    public static final ResourceKey<Biome> RED_ZONE_BORDER = register("red_zone_border");
    public static final ResourceKey<Biome> BLUE_ZONE_BORDER = register("blue_zone_border");
    public static final ResourceKey<Biome> TIBERIAN_TAIGA = register("tiberian_taiga");
    public static final ResourceKey<Biome> TIBERIAN_SWAMP = register("tiberian_swamp");
    public static final ResourceKey<Biome> TIBERIAN_TUNDRA = register("tiberian_tundra");
    public static final ResourceKey<Biome> CRYSTAL_FIELDS = register("crystal_fields");
    public static final ResourceKey<Biome> OLD_TRENCHES = register("old_trenches");


    //Red Zone:
    public static final ResourceKey<Biome> ASHLANDS = register("ashlands");
    public static final ResourceKey<Biome> BROODING_LANDS = register("brooding_lands");
    public static final ResourceKey<Biome> WASTELAND = register("wasteland");
    public static final ResourceKey<Biome> WASTELAND_HILLS = register("wasteland_hills");
    public static final ResourceKey<Biome> SCORCHED_HILLS = register("scorched_hills");
    public static final ResourceKey<Biome> SCORCHED_DESERT = register("scorched_desert");
    public static final ResourceKey<Biome> YELLOW_ZONE_BORDER = register("yellow_zone_border");
    public static final ResourceKey<Biome> ICHOR_MARSH = register("ichor_marsh");
    public static final ResourceKey<Biome> ABYSSAL_MARSH = register("abyssal_marsh");
    public static final ResourceKey<Biome> DEAD_PLAINS = register("dead_plains");
    public static final ResourceKey<Biome> RED_ZONE_RIVER = register("red_zone_river");
    public static final ResourceKey<Biome> RED_ZONE_SHORE = register("red_zone_shore");
    public static final ResourceKey<Biome> FIRESTORM_PLAINS = register("firestorm_plains");
    public static final ResourceKey<Biome> CRYSTALLINE_CANYON = register("crystalline_canyon");
    public static final ResourceKey<Biome> CRYSTALLINE_HILLS = register("crystalline_hills");
    public static final ResourceKey<Biome> DEAD_ZONE = register("dead_zone");
    public static final ResourceKey<Biome> TIBERIAN_WASTES = register("tiberian_wastes");
    public static final ResourceKey<Biome> PLAGUED_WOODS = register("plagued_woods");
    public static final ResourceKey<Biome> ICHOR_BOG = register("ichor_bog");
    public static final ResourceKey<Biome> OLD_WAR_ZONE = register("old_war_zone");





public static void bootstrap(BootstapContext<Biome> context){
    context.register(EMBER_GLOW_FOREST, emberGlowForest(context));
    context.register(AMBER_GROVE, amberGrove(context));
    context.register(EMBRAN_VALLEY, embranValley(context));
    context.register(HORNSENT_HILLS, hornsentHills(context));
}

    public static void globalOverworldGeneration(BiomeGenerationSettings.Builder builder) {
        BiomeDefaultFeatures.addDefaultCarversAndLakes(builder);
        BiomeDefaultFeatures.addDefaultCrystalFormations(builder);
        BiomeDefaultFeatures.addDefaultMonsterRoom(builder);
        BiomeDefaultFeatures.addDefaultUndergroundVariety(builder);
        BiomeDefaultFeatures.addDefaultSprings(builder);
        BiomeDefaultFeatures.addSurfaceFreezing(builder);
    }

    //OVERWORLD:
    public static Biome emberGlowForest(BootstapContext<Biome> context) {
        MobSpawnSettings.Builder spawnBuilder = new MobSpawnSettings.Builder();
//        spawnBuilder.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(ModEntities.RHINO.get(), 2, 3, 5));
        spawnBuilder.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.MAGMA_CUBE, 5, 4, 4));
        spawnBuilder.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.WOLF, 5, 4, 4));

        BiomeDefaultFeatures.farmAnimals(spawnBuilder);
        BiomeDefaultFeatures.commonSpawns(spawnBuilder);

        BiomeGenerationSettings.Builder biomeBuilder =
                new BiomeGenerationSettings.Builder(context.lookup(Registries.PLACED_FEATURE), context.lookup(Registries.CONFIGURED_CARVER));

        globalOverworldGeneration(biomeBuilder);

        BiomeDefaultFeatures.addForestFlowers(biomeBuilder);
        BiomeDefaultFeatures.addFerns(biomeBuilder);
        BiomeDefaultFeatures.addDefaultOres(biomeBuilder);
        BiomeDefaultFeatures.addExtraGold(biomeBuilder);


        BiomeDefaultFeatures.addDefaultMushrooms(biomeBuilder);
        BiomeDefaultFeatures.addDefaultExtraVegetation(biomeBuilder);
        biomeBuilder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, OrePlacements.ORE_ANCIENT_DEBRIS_LARGE);
        biomeBuilder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, ModPlacedFeatures.CRYSTECH_GUNDANIUM_PLACED_KEY);
        biomeBuilder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, ModPlacedFeatures.CRYSTECH_ILLUMINA_PLACED_KEY);
        biomeBuilder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, ModPlacedFeatures.CRYSTECH_KRYON_PLACED_KEY);
        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, ModPlacedFeatures.SPITFIRE_PLACED_KEY);
        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, ModPlacedFeatures.EMBER_PLACED_KEY);
        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, ModPlacedFeatures.SM_EMBER_PLACED_KEY);
        biomeBuilder.addFeature(GenerationStep.Decoration.LOCAL_MODIFICATIONS, ModPlacedFeatures.TIBERIUM_GEODE_PLACED_KEY);


        return new Biome.BiomeBuilder()
                .hasPrecipitation(true)
                .downfall(0.8f)
                .temperature(0.7f)
                .generationSettings(biomeBuilder.build())
                .mobSpawnSettings(spawnBuilder.build())
                .specialEffects((new BiomeSpecialEffects.Builder())
                        .waterColor(0x0000FF)
                        .waterFogColor(0x0000FF)
                        .skyColor(0xFF8585)
                        .grassColorOverride(0xFF0A0A)
                        .foliageColorOverride(0xA30000)
                        .fogColor(0xFF4747)
//                        .ambientMoodSound(AmbientMoodSettings.LEGACY_CAVE_SETTINGS)
                        .ambientParticle(new AmbientParticleSettings(ParticleTypes.FLAME, 0.0008925F))
                        .backgroundMusic(Musics.createGameMusic(ModSounds.HYOUHAKU_WANDERING.getHolder().get())).build())
                .build();
    }

    public static Biome amberGrove(BootstapContext<Biome> context) {
        MobSpawnSettings.Builder spawnBuilder = new MobSpawnSettings.Builder();
        spawnBuilder.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.PIGLIN, 9, 4, 4));
        spawnBuilder.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.PILLAGER, 6, 4, 4));
        spawnBuilder.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(ModEntities.RHINO.get(), 2, 3, 5));
        spawnBuilder.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.WOLF, 5, 4, 4));


        BiomeDefaultFeatures.farmAnimals(spawnBuilder);
        BiomeDefaultFeatures.commonSpawns(spawnBuilder);

        BiomeGenerationSettings.Builder biomeBuilder =
                new BiomeGenerationSettings.Builder(context.lookup(Registries.PLACED_FEATURE), context.lookup(Registries.CONFIGURED_CARVER));

        globalOverworldGeneration(biomeBuilder);

        BiomeDefaultFeatures.addForestFlowers(biomeBuilder);
        BiomeDefaultFeatures.addFerns(biomeBuilder);
        BiomeDefaultFeatures.addDefaultOres(biomeBuilder);
        BiomeDefaultFeatures.addExtraGold(biomeBuilder);


        BiomeDefaultFeatures.addDefaultMushrooms(biomeBuilder);
        BiomeDefaultFeatures.addDefaultExtraVegetation(biomeBuilder);
        biomeBuilder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, OrePlacements.ORE_ANCIENT_DEBRIS_LARGE);
        biomeBuilder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, ModPlacedFeatures.CRYSTECH_GUNDANIUM_PLACED_KEY);
        biomeBuilder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, ModPlacedFeatures.CRYSTECH_ILLUMINA_PLACED_KEY);
        biomeBuilder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, ModPlacedFeatures.CRYSTECH_KRYON_PLACED_KEY);
        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, ModPlacedFeatures.FULGURBLOOM_PLACED_KEY);
        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, ModPlacedFeatures.MARIKA_PLACED_KEY);
        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, ModPlacedFeatures.SM_MARIKA_PLACED_KEY);
        biomeBuilder.addFeature(GenerationStep.Decoration.LOCAL_MODIFICATIONS, ModPlacedFeatures.TIBERIUM_GEODE_PLACED_KEY);



        return new Biome.BiomeBuilder()
                .hasPrecipitation(true)
                .downfall(0.8f)
                .temperature(0.7f)
                .generationSettings(biomeBuilder.build())
                .mobSpawnSettings(spawnBuilder.build())
                .specialEffects((new BiomeSpecialEffects.Builder())
                        .waterColor(0x0000FF)
                        .waterFogColor(0x0000FF)
                        .skyColor(0xFFD60A)
                        .grassColorOverride(0xFFD60A)
                        .foliageColorOverride(0xF5CC00)
                        .fogColor(0xFFE770)
//                        .ambientMoodSound(AmbientMoodSettings.LEGACY_CAVE_SETTINGS)
                        .backgroundMusic(Musics.createGameMusic(ModSounds.VALVES.getHolder().get())).build())
                .build();
    }

    public static Biome embranValley(BootstapContext<Biome> context) {
        MobSpawnSettings.Builder spawnBuilder = new MobSpawnSettings.Builder();
        spawnBuilder.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.MAGMA_CUBE, 8, 4, 4));
        spawnBuilder.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.WOLF, 5, 4, 4));


        BiomeDefaultFeatures.farmAnimals(spawnBuilder);
        BiomeDefaultFeatures.commonSpawns(spawnBuilder);

        BiomeGenerationSettings.Builder biomeBuilder =
                new BiomeGenerationSettings.Builder(context.lookup(Registries.PLACED_FEATURE), context.lookup(Registries.CONFIGURED_CARVER));

        globalOverworldGeneration(biomeBuilder);

        BiomeDefaultFeatures.addForestFlowers(biomeBuilder);
        BiomeDefaultFeatures.addFerns(biomeBuilder);
        BiomeDefaultFeatures.addDefaultOres(biomeBuilder);
        BiomeDefaultFeatures.addExtraGold(biomeBuilder);


        BiomeDefaultFeatures.addDefaultMushrooms(biomeBuilder);
        BiomeDefaultFeatures.addDefaultExtraVegetation(biomeBuilder);
        biomeBuilder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, OrePlacements.ORE_ANCIENT_DEBRIS_LARGE);
        biomeBuilder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, ModPlacedFeatures.CRYSTECH_GUNDANIUM_PLACED_KEY);
        biomeBuilder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, ModPlacedFeatures.CRYSTECH_ILLUMINA_PLACED_KEY);
        biomeBuilder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, ModPlacedFeatures.CRYSTECH_KRYON_PLACED_KEY);
        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, ModPlacedFeatures.SPITFIRE_PLACED_KEY);
        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, ModPlacedFeatures.EMBER_PLACED_KEY);
        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, ModPlacedFeatures.SM_EMBER_PLACED_KEY);
        biomeBuilder.addFeature(GenerationStep.Decoration.LOCAL_MODIFICATIONS, ModPlacedFeatures.TIBERIUM_GEODE_PLACED_KEY);


        return new Biome.BiomeBuilder()
                .hasPrecipitation(true)
                .downfall(0.8f)
                .temperature(0.7f)
                .generationSettings(biomeBuilder.build())
                .mobSpawnSettings(spawnBuilder.build())
                .specialEffects((new BiomeSpecialEffects.Builder())
                        .waterColor(0x0000FF)
                        .waterFogColor(0x0000FF)
                        .skyColor(0xFF8585)
                        .grassColorOverride(0xFF0A0A)
                        .foliageColorOverride(0xA30000)
                        .fogColor(0xFF4747)
//                        .ambientMoodSound(AmbientMoodSettings.LEGACY_CAVE_SETTINGS)
                        .ambientParticle(new AmbientParticleSettings(ParticleTypes.FLAME, 0.0008925F))
                        .backgroundMusic(Musics.createGameMusic(ModSounds.CORRODED_VALVES.getHolder().get())).build())
                .build();
    }

    public static Biome hornsentHills(BootstapContext<Biome> context) {
        MobSpawnSettings.Builder spawnBuilder = new MobSpawnSettings.Builder();
        spawnBuilder.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.PIGLIN, 9, 4, 4));
        spawnBuilder.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.PILLAGER, 6, 4, 4));
        spawnBuilder.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(ModEntities.RHINO.get(), 2, 3, 5));


        BiomeDefaultFeatures.farmAnimals(spawnBuilder);
        BiomeDefaultFeatures.commonSpawns(spawnBuilder);

        BiomeGenerationSettings.Builder biomeBuilder =
                new BiomeGenerationSettings.Builder(context.lookup(Registries.PLACED_FEATURE), context.lookup(Registries.CONFIGURED_CARVER));

        globalOverworldGeneration(biomeBuilder);

        BiomeDefaultFeatures.addForestFlowers(biomeBuilder);
        BiomeDefaultFeatures.addFerns(biomeBuilder);
        BiomeDefaultFeatures.addDefaultOres(biomeBuilder);
        BiomeDefaultFeatures.addExtraGold(biomeBuilder);


        BiomeDefaultFeatures.addDefaultMushrooms(biomeBuilder);
        BiomeDefaultFeatures.addDefaultExtraVegetation(biomeBuilder);
        biomeBuilder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, OrePlacements.ORE_ANCIENT_DEBRIS_LARGE);
        biomeBuilder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, ModPlacedFeatures.CRYSTECH_GUNDANIUM_PLACED_KEY);
        biomeBuilder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, ModPlacedFeatures.CRYSTECH_ILLUMINA_PLACED_KEY);
        biomeBuilder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, ModPlacedFeatures.CRYSTECH_KRYON_PLACED_KEY);
        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, ModPlacedFeatures.FULGURBLOOM_PLACED_KEY);
        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, ModPlacedFeatures.MARIKA_PLACED_KEY);
        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, ModPlacedFeatures.SM_MARIKA_PLACED_KEY);
        biomeBuilder.addFeature(GenerationStep.Decoration.LOCAL_MODIFICATIONS, ModPlacedFeatures.TIBERIUM_GEODE_PLACED_KEY);



        return new Biome.BiomeBuilder()
                .hasPrecipitation(true)
                .downfall(0.8f)
                .temperature(0.7f)
                .generationSettings(biomeBuilder.build())
                .mobSpawnSettings(spawnBuilder.build())
                .specialEffects((new BiomeSpecialEffects.Builder())
                        .waterColor(0x0000FF)
                        .waterFogColor(0x0000FF)
                        .skyColor(0xFFD60A)
                        .grassColorOverride(0xFFD60A)
                        .foliageColorOverride(0xF5CC00)
                        .fogColor(0xFFE770)
//                        .ambientMoodSound(AmbientMoodSettings.LEGACY_CAVE_SETTINGS)
                        .backgroundMusic(Musics.createGameMusic(ModSounds.DARK_VALLEY.getHolder().get())).build())
                .build();
    }

//The Vitric Expanse:
    //Blue Zone:

    //YellowZone:

    //Red Zone:




    public static ResourceKey<Biome> register(String name) {
        return ResourceKey.create(Registries.BIOME, new ResourceLocation(CrystalTech.MOD_ID, name));
    }
}
