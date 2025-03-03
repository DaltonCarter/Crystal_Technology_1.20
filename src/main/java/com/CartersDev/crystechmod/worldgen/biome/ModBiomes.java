package com.CartersDev.crystechmod.worldgen.biome;

import com.CartersDev.crystechmod.CrystalTech;
import com.CartersDev.crystechmod.entity.ModEntities;
import com.CartersDev.crystechmod.sound.ModSounds;
import com.CartersDev.crystechmod.worldgen.ModPlacedFeatures;
import com.CartersDev.crystechmod.worldgen.carvers.ModCarvers;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BiomeDefaultFeatures;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.data.worldgen.Carvers;
import net.minecraft.data.worldgen.placement.*;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.Musics;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.level.biome.*;
import net.minecraft.world.level.levelgen.GenerationStep;


public class ModBiomes {

    protected static int calculateSkyColor(float pTemperature) {
        float $$1 = pTemperature / 3.0F;
        $$1 = Mth.clamp($$1, -1.0F, 1.0F);
        return Mth.hsvToRgb(0.62222224F - $$1 * 0.05F, 0.5F + $$1 * 0.1F, 1.0F);
    }

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
    public static final ResourceKey<Biome> BLUE_AND_YELLOW_ZONE_BORDER = register("blue_and_yellow_zone_border");
//
//
//        //Ember themed:
    public static final ResourceKey<Biome> BURNING_HILLS = register("burning_hills");
    public static final ResourceKey<Biome> EMBER_GROVE = register("ember_grove");
    public static final ResourceKey<Biome> INFERNO_PEAK = register("inferno_peak");
//
//
//        //Marika themed:
    public static final ResourceKey<Biome> UNTARNISHED_HILLS = register("untarnished_hills");
    public static final ResourceKey<Biome> EVERGOLD_EXPANSE = register("evergold_expanse");
    public static final ResourceKey<Biome> VALLEY_OF_GOLD = register("valley_of_gold");
//
//    //Yellow Zone:
    public static final ResourceKey<Biome> DEAD_FOREST = register("dead_forest");
    public static final ResourceKey<Biome> TIBERIAN_DESERT = register("tiberian_desert");
    public static final ResourceKey<Biome> TIBERIAN_DESERT_HILLS = register("tiberian_desert_hills");
    public static final ResourceKey<Biome> TIBERIAN_BADLANDS = register("tiberian_badlands");
    public static final ResourceKey<Biome> TIBERIAN_HIGHLANDS = register("tiberian_highlands");
    public static final ResourceKey<Biome> OLD_BATTLEFIELD = register("old_battlefield");
    public static final ResourceKey<Biome> LOST_STEPPES = register("lost_steppes");
    public static final ResourceKey<Biome> YELLOW_ZONE_SHORE = register("yellow_zone_shore");
    public static final ResourceKey<Biome> YELLOW_ZONE_STONY_SHORE = register("yellow_zone_stony_shore");
    public static final ResourceKey<Biome> INFECTED_RIVER = register("infected_river");
    public static final ResourceKey<Biome> INFECTED_OCEAN = register("infected_ocean");
    public static final ResourceKey<Biome> DRY_HILLS = register("dry_hills");
    public static final ResourceKey<Biome> DRY_VALLEY = register("dry_valley");
    public static final ResourceKey<Biome> FORGOTTEN_HIGHLANDS = register("forgotten_highlands");
    public static final ResourceKey<Biome> RED_AND_YELLOW_ZONE_BORDER = register("red_and_yellow_zone_border");
    public static final ResourceKey<Biome> RUINED_CITY = register("ruined_city");
    public static final ResourceKey<Biome> TIBERIAN_TAIGA = register("tiberian_taiga");
    public static final ResourceKey<Biome> TIBERIAN_SWAMP = register("tiberian_swamp");
    public static final ResourceKey<Biome> TIBERIAN_WOODS = register("tiberian_woods");
    public static final ResourceKey<Biome> CRYSTAL_FIELDS = register("crystal_fields");
    public static final ResourceKey<Biome> TIBERIAN_STONE_FIELDS = register("tiberian_stone_fields");


//    //Red Zone:
//    public static final ResourceKey<Biome> ASHLANDS = register("ashlands");
//    public static final ResourceKey<Biome> BROODING_LANDS = register("brooding_lands");
//    public static final ResourceKey<Biome> WASTELAND = register("wasteland");
//    public static final ResourceKey<Biome> WASTELAND_HILLS = register("wasteland_hills");
//    public static final ResourceKey<Biome> SCORCHED_HILLS = register("scorched_hills");
//    public static final ResourceKey<Biome> SCORCHED_DESERT = register("scorched_desert");
//    public static final ResourceKey<Biome> RED_AND_BLUE_ZONE_BORDER = register("yellow_zone_border");
//    public static final ResourceKey<Biome> ICHOR_MARSH = register("ichor_marsh");
//    public static final ResourceKey<Biome> ABYSSAL_MARSH = register("abyssal_marsh");
//    public static final ResourceKey<Biome> DEAD_PLAINS = register("dead_plains");
//    public static final ResourceKey<Biome> RED_ZONE_RIVER = register("red_zone_river");
//    public static final ResourceKey<Biome> RED_ZONE_SHORE = register("red_zone_shore");
//    public static final ResourceKey<Biome> FIRESTORM_PLAINS = register("firestorm_plains");
//    public static final ResourceKey<Biome> CRYSTALLINE_CANYON = register("crystalline_canyon");
//    public static final ResourceKey<Biome> CRYSTALLINE_HILLS = register("crystalline_hills");
//    public static final ResourceKey<Biome> DEAD_ZONE = register("dead_zone");
//    public static final ResourceKey<Biome> TIBERIAN_WASTES = register("tiberian_wastes");
//    public static final ResourceKey<Biome> PLAGUED_WOODS = register("plagued_woods");
//    public static final ResourceKey<Biome> ICHOR_BOG = register("ichor_bog");
//    public static final ResourceKey<Biome> OLD_WAR_ZONE = register("old_war_zone");



public static void bootstrap(BootstapContext<Biome> context){
    //Overworld:
    context.register(EMBER_GLOW_FOREST, emberGlowForest(context));
    context.register(AMBER_GROVE, amberGrove(context));
    context.register(EMBRAN_VALLEY, embranValley(context));
    context.register(HORNSENT_HILLS, hornsentHills(context));
    //Blue Zone:
    context.register(CALIDIAN_MARSH, calidianMarsh(context));
    context.register(GROVE_OF_LIFE, groveOfLife(context));
    context.register(FOOTHILLS, foothills(context));
    context.register(PRIMAL_JUNGLE, primalJungle(context));
    context.register(BLUE_AND_YELLOW_ZONE_BORDER, blueAndYellowZoneBorder(context));
    context.register(BURNING_HILLS, burningHills(context));
    context.register(EMBER_GROVE, emberGrove(context));
    context.register(INFERNO_PEAK, infernoPeak(context));
    context.register(UNTARNISHED_HILLS, untarnishedHills(context));
    context.register(EVERGOLD_EXPANSE, evergoldExpanse(context));
    context.register(VALLEY_OF_GOLD, valleyOfGold(context));
    //Yellow Zone:
    context.register(DEAD_FOREST, deadForest(context));
    context.register(TIBERIAN_DESERT, tiberianDesert(context));
    context.register(TIBERIAN_DESERT_HILLS, tiberianDesertHills(context));
    context.register(TIBERIAN_BADLANDS, tiberianBadlands(context));
    context.register(TIBERIAN_HIGHLANDS, tiberianHighlands(context));
    context.register(OLD_BATTLEFIELD, oldBattlefield(context));
    context.register(LOST_STEPPES, lostSteppes(context));
    context.register(YELLOW_ZONE_SHORE, yellowZoneShore(context));
    context.register(YELLOW_ZONE_STONY_SHORE, yellowZoneStonyShore(context));
    context.register(INFECTED_RIVER, infectedRiver(context));
    context.register(INFECTED_OCEAN, infectedOcean(context));
    context.register(DRY_HILLS, dryHills(context));
    context.register(DRY_VALLEY, dryValley(context));
    context.register(FORGOTTEN_HIGHLANDS, forgottenHighlands(context));
    context.register(RED_AND_YELLOW_ZONE_BORDER, redAndYellowZoneBorder(context));
    context.register(RUINED_CITY, ruinedCity(context));
    context.register(TIBERIAN_TAIGA, tiberianTaiga(context));
    context.register(TIBERIAN_SWAMP, tiberianSwamp(context));
    context.register(TIBERIAN_WOODS, tiberianWoods(context));
    context.register(CRYSTAL_FIELDS, crystalFields(context));
    context.register(TIBERIAN_STONE_FIELDS, tiberianStoneFields(context));





}

    public static void globalOverworldGeneration(BiomeGenerationSettings.Builder builder) {
        BiomeDefaultFeatures.addDefaultCarversAndLakes(builder);
        BiomeDefaultFeatures.addDefaultCrystalFormations(builder);
        BiomeDefaultFeatures.addDefaultMonsterRoom(builder);
        BiomeDefaultFeatures.addDefaultUndergroundVariety(builder);
        BiomeDefaultFeatures.addDefaultSprings(builder);
        BiomeDefaultFeatures.addSurfaceFreezing(builder);
    }

    public static void vitricExpanseYZGeneration(BiomeGenerationSettings.Builder builder) {
        ModBiomeDefaultFeatures.addYZCarversAndLakes(builder);
        ModBiomeDefaultFeatures.addVitricGeodes(builder);
        BiomeDefaultFeatures.addDefaultMonsterRoom(builder);
        ModBiomeDefaultFeatures.addYZUndergroundVariety(builder);
        BiomeDefaultFeatures.addSurfaceFreezing(builder);
    }

    public static void vitricExpanseRZGeneration(BiomeGenerationSettings.Builder builder) {
        ModBiomeDefaultFeatures.addRZCarversAndLakes(builder);
        ModBiomeDefaultFeatures.addVitricGeodes(builder);
        BiomeDefaultFeatures.addDefaultMonsterRoom(builder);
        ModBiomeDefaultFeatures.addRZUndergroundVariety(builder);
        BiomeDefaultFeatures.addSurfaceFreezing(builder);
    }


    //OVERWORLD:
    public static Biome emberGlowForest(BootstapContext<Biome> context) {
        MobSpawnSettings.Builder spawnBuilder = new MobSpawnSettings.Builder();

        spawnBuilder.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.MAGMA_CUBE, 4, 4, 4));
        spawnBuilder.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.WOLF, 5, 4, 4));

        BiomeDefaultFeatures.farmAnimals(spawnBuilder);
        BiomeDefaultFeatures.commonSpawns(spawnBuilder);

        BiomeGenerationSettings.Builder biomeBuilder =
                new BiomeGenerationSettings.Builder(context.lookup(Registries.PLACED_FEATURE), context.lookup(Registries.CONFIGURED_CARVER))
//
                        .addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, ModPlacedFeatures.CT_MAGMA_PLACED_KEY)

                       ;


        BiomeDefaultFeatures.addFossilDecoration(biomeBuilder);
        globalOverworldGeneration(biomeBuilder);

        BiomeDefaultFeatures.addDefaultOres(biomeBuilder);
        BiomeDefaultFeatures.addDefaultSoftDisks(biomeBuilder);

        BiomeDefaultFeatures.addForestFlowers(biomeBuilder);
        BiomeDefaultFeatures.addFerns(biomeBuilder);
        BiomeDefaultFeatures.addDefaultGrass(biomeBuilder);
        BiomeDefaultFeatures.addForestGrass(biomeBuilder);
        BiomeDefaultFeatures.addDefaultMushrooms(biomeBuilder);
        BiomeDefaultFeatures.addDefaultExtraVegetation(biomeBuilder);


        biomeBuilder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, ModPlacedFeatures.CRYSTECH_DEBRIS_PLACED_KEY);
        biomeBuilder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, ModPlacedFeatures.CRYSTECH_GUNDANIUM_PLACED_KEY);
        biomeBuilder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, ModPlacedFeatures.CRYSTECH_ILLUMINA_PLACED_KEY);
        biomeBuilder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, ModPlacedFeatures.CRYSTECH_KRYON_PLACED_KEY);
        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, ModPlacedFeatures.SPITFIRE_PLACED_KEY);
        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, ModPlacedFeatures.EMBER_PLACED_KEY);
        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, ModPlacedFeatures.SM_EMBER_PLACED_KEY);
        biomeBuilder.addFeature(GenerationStep.Decoration.LOCAL_MODIFICATIONS, ModPlacedFeatures.TIBERIUM_GEODE_PLACED_KEY);


        return new Biome.BiomeBuilder()
                .hasPrecipitation(false)
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
                        .ambientMoodSound(AmbientMoodSettings.LEGACY_CAVE_SETTINGS)
                        .ambientParticle(new AmbientParticleSettings(ParticleTypes.FLAME, 0.0008925F))
                        .backgroundMusic(Musics.createGameMusic(ModSounds.VITRIC_EXPANSE_MUSIC.getHolder().get())).build())
                .build();
    }

    public static Biome amberGrove(BootstapContext<Biome> context) {
        MobSpawnSettings.Builder spawnBuilder = new MobSpawnSettings.Builder();
        spawnBuilder.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.PIGLIN, 4, 4, 4));
        spawnBuilder.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.PILLAGER, 6, 4, 4));
        spawnBuilder.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(ModEntities.RHINO.get(), 2, 3, 5));
        spawnBuilder.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.WOLF, 5, 4, 4));


        BiomeDefaultFeatures.farmAnimals(spawnBuilder);
        BiomeDefaultFeatures.commonSpawns(spawnBuilder);

        BiomeGenerationSettings.Builder biomeBuilder =
                new BiomeGenerationSettings.Builder(context.lookup(Registries.PLACED_FEATURE), context.lookup(Registries.CONFIGURED_CARVER))
                        .addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, ModPlacedFeatures.CT_GLOWSTONE_PLACED_KEY);

        BiomeDefaultFeatures.addFossilDecoration(biomeBuilder);
        globalOverworldGeneration(biomeBuilder);

        BiomeDefaultFeatures.addDefaultOres(biomeBuilder);
        BiomeDefaultFeatures.addDefaultSoftDisks(biomeBuilder);
        
        BiomeDefaultFeatures.addForestFlowers(biomeBuilder);
        BiomeDefaultFeatures.addFerns(biomeBuilder);
        BiomeDefaultFeatures.addDefaultGrass(biomeBuilder);
        BiomeDefaultFeatures.addForestGrass(biomeBuilder);
        BiomeDefaultFeatures.addDefaultMushrooms(biomeBuilder);
        BiomeDefaultFeatures.addDefaultExtraVegetation(biomeBuilder);

        biomeBuilder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, ModPlacedFeatures.CRYSTECH_DEBRIS_PLACED_KEY);
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
                        .ambientMoodSound(AmbientMoodSettings.LEGACY_CAVE_SETTINGS)
                        .backgroundMusic(Musics.createGameMusic(ModSounds.VITRIC_EXPANSE_MUSIC.getHolder().get())).build())
                .build();
    }

    public static Biome embranValley(BootstapContext<Biome> context) {
        MobSpawnSettings.Builder spawnBuilder = new MobSpawnSettings.Builder();
        spawnBuilder.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.MAGMA_CUBE, 4, 4, 4));
        spawnBuilder.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.WOLF, 5, 4, 4));


        BiomeDefaultFeatures.farmAnimals(spawnBuilder);
        BiomeDefaultFeatures.commonSpawns(spawnBuilder);

        BiomeGenerationSettings.Builder biomeBuilder =
                new BiomeGenerationSettings.Builder(context.lookup(Registries.PLACED_FEATURE), context.lookup(Registries.CONFIGURED_CARVER))
                        .addCarver(GenerationStep.Carving.AIR, Carvers.CANYON)
                        .addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, ModPlacedFeatures.CT_MAGMA_PLACED_KEY)

                        ;

        BiomeDefaultFeatures.addFossilDecoration(biomeBuilder);
        globalOverworldGeneration(biomeBuilder);

        BiomeDefaultFeatures.addDefaultOres(biomeBuilder);
        BiomeDefaultFeatures.addDefaultSoftDisks(biomeBuilder);

        BiomeDefaultFeatures.addForestFlowers(biomeBuilder);
        BiomeDefaultFeatures.addFerns(biomeBuilder);
        BiomeDefaultFeatures.addDefaultGrass(biomeBuilder);
        BiomeDefaultFeatures.addForestGrass(biomeBuilder);
        BiomeDefaultFeatures.addDefaultMushrooms(biomeBuilder);
        BiomeDefaultFeatures.addDefaultExtraVegetation(biomeBuilder);
        BiomeDefaultFeatures.addMossyStoneBlock(biomeBuilder);




        biomeBuilder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, ModPlacedFeatures.CRYSTECH_DEBRIS_PLACED_KEY);
        biomeBuilder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, ModPlacedFeatures.CRYSTECH_GUNDANIUM_PLACED_KEY);
        biomeBuilder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, ModPlacedFeatures.CRYSTECH_ILLUMINA_PLACED_KEY);
        biomeBuilder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, ModPlacedFeatures.CRYSTECH_KRYON_PLACED_KEY);
        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, ModPlacedFeatures.SPITFIRE_PLACED_KEY);
        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, ModPlacedFeatures.EMBER_PLACED_KEY);
        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, ModPlacedFeatures.SM_EMBER_PLACED_KEY);
        biomeBuilder.addFeature(GenerationStep.Decoration.LOCAL_MODIFICATIONS, ModPlacedFeatures.TIBERIUM_GEODE_PLACED_KEY);


        return new Biome.BiomeBuilder()
                .hasPrecipitation(false)
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
                        .ambientMoodSound(AmbientMoodSettings.LEGACY_CAVE_SETTINGS)
                        .ambientParticle(new AmbientParticleSettings(ParticleTypes.FLAME, 0.0008925F))
                        .backgroundMusic(Musics.createGameMusic(ModSounds.VITRIC_EXPANSE_MUSIC.getHolder().get())).build())
                .build();
    }

    public static Biome hornsentHills(BootstapContext<Biome> context) {
        MobSpawnSettings.Builder spawnBuilder = new MobSpawnSettings.Builder();
        spawnBuilder.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.PIGLIN, 4, 4, 4));
        spawnBuilder.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.PILLAGER, 6, 4, 4));
        spawnBuilder.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(ModEntities.RHINO.get(), 2, 3, 5));


        BiomeDefaultFeatures.farmAnimals(spawnBuilder);
        BiomeDefaultFeatures.commonSpawns(spawnBuilder);

        BiomeGenerationSettings.Builder biomeBuilder =
                new BiomeGenerationSettings.Builder(context.lookup(Registries.PLACED_FEATURE), context.lookup(Registries.CONFIGURED_CARVER))
                        .addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, ModPlacedFeatures.CT_GLOWSTONE_PLACED_KEY);

        BiomeDefaultFeatures.addFossilDecoration(biomeBuilder);
        globalOverworldGeneration(biomeBuilder);


        BiomeDefaultFeatures.addDefaultOres(biomeBuilder);
        BiomeDefaultFeatures.addDefaultSoftDisks(biomeBuilder);

        BiomeDefaultFeatures.addForestFlowers(biomeBuilder);
        BiomeDefaultFeatures.addFerns(biomeBuilder);
        BiomeDefaultFeatures.addDefaultGrass(biomeBuilder);
        BiomeDefaultFeatures.addForestGrass(biomeBuilder);
        BiomeDefaultFeatures.addDefaultMushrooms(biomeBuilder);
        BiomeDefaultFeatures.addDefaultExtraVegetation(biomeBuilder);



        biomeBuilder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, ModPlacedFeatures.CRYSTECH_DEBRIS_PLACED_KEY);
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
                        .skyColor(calculateSkyColor(0.7F))
                        .grassColorOverride(0xFFD60A)
                        .foliageColorOverride(0xF5CC00)
                        .fogColor(0xFFE770)
                        .ambientMoodSound(AmbientMoodSettings.LEGACY_CAVE_SETTINGS)
                        .backgroundMusic(Musics.createGameMusic(ModSounds.VITRIC_EXPANSE_MUSIC.getHolder().get())).build())
                .build();
    }

//    public static Biome warpedForest(HolderGetter<PlacedFeature> pPlacedFeatures, HolderGetter<ConfiguredWorldCarver<?>> pWorldCarvers) {
//        MobSpawnSettings mobspawnsettings = (new MobSpawnSettings.Builder())
//                .addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.ENDERMAN, 1, 4, 4))
//                .addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.STRIDER, 60, 1, 2))
//                .addMobCharge(EntityType.ENDERMAN, 1.0D, 0.12D).build();
//        BiomeGenerationSettings.Builder biomegenerationsettings$builder =
//                (new BiomeGenerationSettings.Builder(pPlacedFeatures, pWorldCarvers))
//                        .addCarver(GenerationStep.Carving.AIR, Carvers.NETHER_CAVE)
//                        .addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, MiscOverworldPlacements.SPRING_LAVA);
//        BiomeDefaultFeatures.addDefaultMushrooms(biomegenerationsettings$builder);
//        biomegenerationsettings$builder
//                .addFeature(GenerationStep.Decoration.UNDERGROUND_DECORATION, NetherPlacements.SPRING_OPEN)
//                .addFeature(GenerationStep.Decoration.UNDERGROUND_DECORATION, NetherPlacements.PATCH_FIRE)
//                .addFeature(GenerationStep.Decoration.UNDERGROUND_DECORATION, NetherPlacements.PATCH_SOUL_FIRE)
//                .addFeature(GenerationStep.Decoration.UNDERGROUND_DECORATION, NetherPlacements.GLOWSTONE_EXTRA)
//                .addFeature(GenerationStep.Decoration.UNDERGROUND_DECORATION, NetherPlacements.GLOWSTONE)
//                .addFeature(GenerationStep.Decoration.UNDERGROUND_DECORATION, OrePlacements.ORE_MAGMA)
//                .addFeature(GenerationStep.Decoration.UNDERGROUND_DECORATION, NetherPlacements.SPRING_CLOSED)
//                .addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, TreePlacements.WARPED_FUNGI)
//                .addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, NetherPlacements.WARPED_FOREST_VEGETATION)
//                .addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, NetherPlacements.NETHER_SPROUTS)
//                .addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, NetherPlacements.TWISTING_VINES);
//        BiomeDefaultFeatures.addNetherDefaultOres(biomegenerationsettings$builder);
//        return (new Biome.BiomeBuilder())
//                .hasPrecipitation(false)
//                .temperature(2.0F)
//                .downfall(0.0F)
//                .specialEffects((new BiomeSpecialEffects.Builder())
//                        .waterColor(4159204)
//                        .waterFogColor(329011)
//                        .fogColor(1705242)
//                        .skyColor(OverworldBiomes.calculateSkyColor(2.0F))
//                        .ambientParticle(new AmbientParticleSettings(ParticleTypes.WARPED_SPORE, 0.01428F))
//                        .ambientLoopSound(SoundEvents.AMBIENT_WARPED_FOREST_LOOP)
//                        .ambientMoodSound(new AmbientMoodSettings(SoundEvents.AMBIENT_WARPED_FOREST_MOOD, 6000, 8, 2.0D))
//                        .ambientAdditionsSound(new AmbientAdditionsSettings(SoundEvents.AMBIENT_WARPED_FOREST_ADDITIONS, 0.0111D))
//                        .backgroundMusic(Musics.createGameMusic(SoundEvents.MUSIC_BIOME_WARPED_FOREST)).build())
//                .mobSpawnSettings(mobspawnsettings).generationSettings(biomegenerationsettings$builder.build()).build();
//    }

//The Vitric Expanse:
    //Blue Zone:
public static Biome calidianMarsh(BootstapContext<Biome> context) {
    MobSpawnSettings.Builder spawnBuilder = new MobSpawnSettings.Builder();
    BiomeDefaultFeatures.commonSpawns(spawnBuilder);
    spawnBuilder.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.SLIME, 1, 1, 1));
    spawnBuilder.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.FROG, 10, 2, 5));
    spawnBuilder.addSpawn(MobCategory.WATER_AMBIENT, new MobSpawnSettings.SpawnerData(EntityType.TROPICAL_FISH, 25, 8, 8));



    BiomeGenerationSettings.Builder biomeBuilder =
            new BiomeGenerationSettings.Builder(context.lookup(Registries.PLACED_FEATURE), context.lookup(Registries.CONFIGURED_CARVER));

    BiomeDefaultFeatures.addFossilDecoration(biomeBuilder);
    globalOverworldGeneration(biomeBuilder);
    BiomeDefaultFeatures.addDefaultOres(biomeBuilder);
    ModBiomeDefaultFeatures.addVitricOreVariety(biomeBuilder);
    BiomeDefaultFeatures.addMangroveSwampDisks(biomeBuilder);
    BiomeDefaultFeatures.addMangroveSwampVegetation(biomeBuilder);
    biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, AquaticPlacements.SEAGRASS_SWAMP);


    biomeBuilder.addFeature(GenerationStep.Decoration.LOCAL_MODIFICATIONS, ModPlacedFeatures.TIBERIUM_GEODE_PLACED_KEY);

    return (new Biome.BiomeBuilder())
            .hasPrecipitation(true)
            .temperature(0.8F)
            .downfall(0.9F)
            .specialEffects((new BiomeSpecialEffects.Builder())
                    .waterColor(3832426)
                    .waterFogColor(5077600)
                    .fogColor(12638463)
                    .skyColor(calculateSkyColor(0.8F))
                    .foliageColorOverride(9285927)
                    .grassColorModifier(BiomeSpecialEffects.GrassColorModifier.SWAMP)
                    .ambientMoodSound(new AmbientMoodSettings(ModSounds.VITRIC_AMBIENT.getHolder().get(), 6000, 8, 2.0D))
                    .backgroundMusic(Musics.createGameMusic(ModSounds.VITRIC_EXPANSE_MUSIC.getHolder().get())).build())

            .mobSpawnSettings(spawnBuilder.build())
            .generationSettings(biomeBuilder.build()).build();
}

    public static Biome groveOfLife(BootstapContext<Biome> context) {
        MobSpawnSettings.Builder spawnBuilder = new MobSpawnSettings.Builder();
        BiomeDefaultFeatures.commonSpawns(spawnBuilder);
        BiomeDefaultFeatures.farmAnimals(spawnBuilder);

        spawnBuilder.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.WOLF, 10, 2, 5));
        spawnBuilder.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.RABBIT, 10, 2, 5));

        BiomeGenerationSettings.Builder biomeBuilder =
                new BiomeGenerationSettings.Builder(context.lookup(Registries.PLACED_FEATURE), context.lookup(Registries.CONFIGURED_CARVER));

        BiomeDefaultFeatures.addFossilDecoration(biomeBuilder);
        globalOverworldGeneration(biomeBuilder);
        BiomeDefaultFeatures.addDefaultOres(biomeBuilder);
        ModBiomeDefaultFeatures.addVitricOreVariety(biomeBuilder);
        BiomeDefaultFeatures.addDefaultSoftDisks(biomeBuilder);
        BiomeDefaultFeatures.addPlainGrass(biomeBuilder);
        BiomeDefaultFeatures.addMeadowVegetation(biomeBuilder);

        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, ModPlacedFeatures.SM_MARIKA_PLACED_KEY);
        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, ModPlacedFeatures.SM_EMBER_PLACED_KEY);
        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, ModPlacedFeatures.DEAD_PLACED_KEY);
        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, ModPlacedFeatures.FLOWER_OF_LIFE_PLACED_KEY);
        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, ModPlacedFeatures.SPITFIRE_PLACED_KEY);
        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, ModPlacedFeatures.FULGURBLOOM_PLACED_KEY);
        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, ModPlacedFeatures.HYACINTH_PLACED_KEY);
        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, ModPlacedFeatures.YOKARAN_BLOOM_PLACED_KEY);
        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, ModPlacedFeatures.DEVILS_BLOOD_PLACED_KEY);

        biomeBuilder.addFeature(GenerationStep.Decoration.LOCAL_MODIFICATIONS, ModPlacedFeatures.TIBERIUM_GEODE_PLACED_KEY);

        return (new Biome.BiomeBuilder())
                .hasPrecipitation(true)
                .temperature(0.8F)
                .downfall(0.9F)
                .specialEffects((new BiomeSpecialEffects.Builder())
                        .waterColor(4159204)
                        .waterFogColor(329011)
                        .fogColor(12638463)
                        .skyColor(calculateSkyColor(0.8F))
                        .ambientMoodSound(new AmbientMoodSettings(ModSounds.VITRIC_AMBIENT.getHolder().get(), 6000, 8, 2.0D))
                        .backgroundMusic(Musics.createGameMusic(ModSounds.VITRIC_EXPANSE_MUSIC.getHolder().get())).build())

                .mobSpawnSettings(spawnBuilder.build())
                .generationSettings(biomeBuilder.build()).build();
    }

    public static Biome foothills(BootstapContext<Biome> context) {
        MobSpawnSettings.Builder spawnBuilder = new MobSpawnSettings.Builder();
        BiomeDefaultFeatures.commonSpawns(spawnBuilder);
        BiomeDefaultFeatures.farmAnimals(spawnBuilder);


        spawnBuilder.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.LLAMA, 5, 2, 5));

        BiomeGenerationSettings.Builder biomeBuilder =
                new BiomeGenerationSettings.Builder(context.lookup(Registries.PLACED_FEATURE), context.lookup(Registries.CONFIGURED_CARVER));

        BiomeDefaultFeatures.addFossilDecoration(biomeBuilder);
        globalOverworldGeneration(biomeBuilder);
        BiomeDefaultFeatures.addDefaultOres(biomeBuilder);
        ModBiomeDefaultFeatures.addVitricOreVariety(biomeBuilder);
        BiomeDefaultFeatures.addDefaultSoftDisks(biomeBuilder);
        BiomeDefaultFeatures.addDefaultFlowers(biomeBuilder);
        BiomeDefaultFeatures.addDefaultGrass(biomeBuilder);
        BiomeDefaultFeatures.addDefaultMushrooms(biomeBuilder);
        BiomeDefaultFeatures.addDefaultExtraVegetation(biomeBuilder);


        biomeBuilder.addFeature(GenerationStep.Decoration.LOCAL_MODIFICATIONS, ModPlacedFeatures.TIBERIUM_GEODE_PLACED_KEY);

        return (new Biome.BiomeBuilder())
                .hasPrecipitation(true)
                .temperature(0.2F)
                .downfall(0.3F)
                .specialEffects((new BiomeSpecialEffects.Builder())
                        .waterColor(4159204)
                        .waterFogColor(329011)
                        .fogColor(12638463)
                        .skyColor(calculateSkyColor(0.2F))
                        .ambientMoodSound(AmbientMoodSettings.LEGACY_CAVE_SETTINGS)
                        .backgroundMusic(Musics.createGameMusic(ModSounds.VITRIC_EXPANSE_MUSIC.getHolder().get())).build())

                .mobSpawnSettings(spawnBuilder.build())
                .generationSettings(biomeBuilder.build()).build();
    }

    public static Biome primalJungle(BootstapContext<Biome> context) {
        MobSpawnSettings.Builder spawnBuilder = new MobSpawnSettings.Builder();
        BiomeDefaultFeatures.baseJungleSpawns(spawnBuilder);


        spawnBuilder.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.OCELOT, 2, 2, 5));
        spawnBuilder.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.PANDA, 1, 2, 5));
        spawnBuilder.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.PARROT, 20, 2, 5));

        BiomeGenerationSettings.Builder biomeBuilder =
                new BiomeGenerationSettings.Builder(context.lookup(Registries.PLACED_FEATURE), context.lookup(Registries.CONFIGURED_CARVER));

        BiomeDefaultFeatures.addFossilDecoration(biomeBuilder);
        globalOverworldGeneration(biomeBuilder);
        BiomeDefaultFeatures.addDefaultOres(biomeBuilder);
        ModBiomeDefaultFeatures.addVitricOreVariety(biomeBuilder);
        BiomeDefaultFeatures.addDefaultSoftDisks(biomeBuilder);
        BiomeDefaultFeatures.addJungleMelons(biomeBuilder);
        BiomeDefaultFeatures.addJungleGrass(biomeBuilder);
        BiomeDefaultFeatures.addJungleTrees(biomeBuilder);
        BiomeDefaultFeatures.addJungleVines(biomeBuilder);
        BiomeDefaultFeatures.addDefaultMushrooms(biomeBuilder);
        BiomeDefaultFeatures.addDefaultExtraVegetation(biomeBuilder);
        BiomeDefaultFeatures.addWarmFlowers(biomeBuilder);


        biomeBuilder.addFeature(GenerationStep.Decoration.LOCAL_MODIFICATIONS, ModPlacedFeatures.TIBERIUM_GEODE_PLACED_KEY);

        return (new Biome.BiomeBuilder())
                .hasPrecipitation(true)
                .temperature(0.95F)
                .downfall(0.9F)
                .specialEffects((new BiomeSpecialEffects.Builder())
                        .waterColor(4159204)
                        .waterFogColor(329011)
                        .fogColor(12638463)
                        .skyColor(calculateSkyColor(0.95F))
                        .ambientMoodSound(new AmbientMoodSettings(ModSounds.VITRIC_AMBIENT.getHolder().get(), 6000, 8, 2.0D))
                        .backgroundMusic(Musics.createGameMusic(ModSounds.VITRIC_EXPANSE_MUSIC.getHolder().get())).build())

                .mobSpawnSettings(spawnBuilder.build())
                .generationSettings(biomeBuilder.build()).build();
    }

    public static Biome blueAndYellowZoneBorder(BootstapContext<Biome> context) {
        MobSpawnSettings.Builder spawnBuilder = new MobSpawnSettings.Builder();


        BiomeDefaultFeatures.commonSpawns(spawnBuilder);

        BiomeGenerationSettings.Builder biomeBuilder =
                new BiomeGenerationSettings.Builder(context.lookup(Registries.PLACED_FEATURE), context.lookup(Registries.CONFIGURED_CARVER));


        vitricExpanseYZGeneration(biomeBuilder);



        BiomeDefaultFeatures.addDefaultOres(biomeBuilder);
        ModBiomeDefaultFeatures.addVitricOreVariety(biomeBuilder);
        ModBiomeDefaultFeatures.addYZSoftDisks(biomeBuilder);


        BiomeDefaultFeatures.addDefaultGrass(biomeBuilder);
        BiomeDefaultFeatures.addDefaultMushrooms(biomeBuilder);
        BiomeDefaultFeatures.addDefaultExtraVegetation(biomeBuilder);




        biomeBuilder.addFeature(GenerationStep.Decoration.LOCAL_MODIFICATIONS, ModPlacedFeatures.CT_YELLOW_ZONE_DIRT_PLACED_KEY);
        biomeBuilder.addFeature(GenerationStep.Decoration.LOCAL_MODIFICATIONS, ModPlacedFeatures.CT_SEEDED_YELLOW_ZONE_DIRT_PLACED_KEY);




        return new Biome.BiomeBuilder()
                .hasPrecipitation(true)
                .downfall(0.4f)
                .temperature(0.5f)
                .generationSettings(biomeBuilder.build())
                .mobSpawnSettings(spawnBuilder.build())
                .specialEffects((new BiomeSpecialEffects.Builder())
                        .waterColor(0x0000FF)
                        .waterFogColor(0x0000FF)
                        .skyColor(calculateSkyColor(0.3F))
                        .grassColorOverride(0x6C6E3C)
                        .foliageColorOverride(0x6C6E3C)
                        .fogColor(0xFFE770)
                        .ambientMoodSound(new AmbientMoodSettings(ModSounds.VITRIC_AMBIENT.getHolder().get(), 6000, 8, 2.0D))
                        .backgroundMusic(Musics.createGameMusic(ModSounds.VITRIC_EXPANSE_MUSIC.getHolder().get())).build())
                .build();
    }

        //Ember themed:
        public static Biome burningHills(BootstapContext<Biome> context) {
            MobSpawnSettings.Builder spawnBuilder = new MobSpawnSettings.Builder();
            spawnBuilder.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.MAGMA_CUBE, 4, 4, 4));
            spawnBuilder.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.BLAZE, 2, 4, 4));
            spawnBuilder.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.WOLF, 5, 4, 4));


            BiomeDefaultFeatures.farmAnimals(spawnBuilder);
            BiomeDefaultFeatures.commonSpawns(spawnBuilder);

            BiomeGenerationSettings.Builder biomeBuilder =
                    new BiomeGenerationSettings.Builder(context.lookup(Registries.PLACED_FEATURE), context.lookup(Registries.CONFIGURED_CARVER))
                            .addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, ModPlacedFeatures.CT_MAGMA_PLACED_KEY)

                    ;

            globalOverworldGeneration(biomeBuilder);
            BiomeDefaultFeatures.addDefaultOres(biomeBuilder);
            ModBiomeDefaultFeatures.addVitricOreVariety(biomeBuilder);
            BiomeDefaultFeatures.addDefaultSoftDisks(biomeBuilder);

            BiomeDefaultFeatures.addWarmFlowers(biomeBuilder);
            BiomeDefaultFeatures.addFerns(biomeBuilder);
            BiomeDefaultFeatures.addDefaultGrass(biomeBuilder);
            BiomeDefaultFeatures.addForestGrass(biomeBuilder);
            BiomeDefaultFeatures.addDefaultMushrooms(biomeBuilder);
            BiomeDefaultFeatures.addDefaultExtraVegetation(biomeBuilder);


            biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, ModPlacedFeatures.SPITFIRE_PLACED_KEY);
            biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, ModPlacedFeatures.SM_EMBER_PLACED_KEY);
            biomeBuilder.addFeature(GenerationStep.Decoration.LOCAL_MODIFICATIONS, ModPlacedFeatures.TIBERIUM_GEODE_PLACED_KEY);


            return new Biome.BiomeBuilder()
                    .hasPrecipitation(false)
                    .downfall(0.8f)
                    .temperature(1.5f)
                    .generationSettings(biomeBuilder.build())
                    .mobSpawnSettings(spawnBuilder.build())
                    .specialEffects((new BiomeSpecialEffects.Builder())
                            .waterColor(0x0000FF)
                            .waterFogColor(0x0000FF)
                            .skyColor(0xFF8585)
                            .grassColorOverride(0xFF0A0A)
                            .foliageColorOverride(0xA30000)
                            .fogColor(0xFF4747)
                            .ambientMoodSound(new AmbientMoodSettings(ModSounds.VITRIC_AMBIENT.getHolder().get(), 6000, 8, 2.0D))
                            .ambientParticle(new AmbientParticleSettings(ParticleTypes.FLAME, 0.0008925F))
                            .backgroundMusic(Musics.createGameMusic(ModSounds.VITRIC_EXPANSE_MUSIC.getHolder().get())).build())
                    .build();
        }

    public static Biome emberGrove(BootstapContext<Biome> context) {
        MobSpawnSettings.Builder spawnBuilder = new MobSpawnSettings.Builder();
        spawnBuilder.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.MAGMA_CUBE, 4, 4, 4));
        spawnBuilder.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.BLAZE, 2, 4, 4));
        spawnBuilder.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.WOLF, 5, 4, 4));


        BiomeDefaultFeatures.farmAnimals(spawnBuilder);
        BiomeDefaultFeatures.commonSpawns(spawnBuilder);

        BiomeGenerationSettings.Builder biomeBuilder =
                new BiomeGenerationSettings.Builder(context.lookup(Registries.PLACED_FEATURE), context.lookup(Registries.CONFIGURED_CARVER));

        globalOverworldGeneration(biomeBuilder);
        BiomeDefaultFeatures.addFossilDecoration(biomeBuilder);
        BiomeDefaultFeatures.addDefaultOres(biomeBuilder);
        ModBiomeDefaultFeatures.addVitricOreVariety(biomeBuilder);
        BiomeDefaultFeatures.addDefaultSoftDisks(biomeBuilder);

        BiomeDefaultFeatures.addWarmFlowers(biomeBuilder);
        BiomeDefaultFeatures.addFerns(biomeBuilder);
        BiomeDefaultFeatures.addDefaultGrass(biomeBuilder);
        BiomeDefaultFeatures.addForestGrass(biomeBuilder);
        BiomeDefaultFeatures.addDefaultMushrooms(biomeBuilder);
        BiomeDefaultFeatures.addDefaultExtraVegetation(biomeBuilder);
        BiomeDefaultFeatures.addMossyStoneBlock(biomeBuilder);


        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, ModPlacedFeatures.SPITFIRE_PLACED_KEY);
        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, ModPlacedFeatures.YOKARAN_BLOOM_PLACED_KEY);
        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, ModPlacedFeatures.DEVILS_BLOOD_PLACED_KEY);
        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, ModPlacedFeatures.FULGURBLOOM_PLACED_KEY);
        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, ModPlacedFeatures.EMBER_PLACED_KEY);
        biomeBuilder.addFeature(GenerationStep.Decoration.LOCAL_MODIFICATIONS, ModPlacedFeatures.TIBERIUM_GEODE_PLACED_KEY);


        return new Biome.BiomeBuilder()
                .hasPrecipitation(false)
                .downfall(0.8f)
                .temperature(1.5f)
                .generationSettings(biomeBuilder.build())
                .mobSpawnSettings(spawnBuilder.build())
                .specialEffects((new BiomeSpecialEffects.Builder())
                        .waterColor(0x0000FF)
                        .waterFogColor(0x0000FF)
                        .skyColor(0xFF8585)
                        .grassColorOverride(0xFF0A0A)
                        .foliageColorOverride(0xA30000)
                        .fogColor(0xFF4747)
                        .ambientMoodSound(new AmbientMoodSettings(ModSounds.VITRIC_AMBIENT.getHolder().get(), 6000, 8, 2.0D))
                        .ambientParticle(new AmbientParticleSettings(ParticleTypes.FLAME, 0.0008925F))
                        .backgroundMusic(Musics.createGameMusic(ModSounds.VITRIC_EXPANSE_MUSIC.getHolder().get())).build())
                .build();
    }

    public static Biome infernoPeak(BootstapContext<Biome> context) {
        MobSpawnSettings.Builder spawnBuilder = new MobSpawnSettings.Builder();
        spawnBuilder.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.MAGMA_CUBE, 4, 4, 4));
        spawnBuilder.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.BLAZE, 2, 4, 4));
        spawnBuilder.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.WOLF, 5, 4, 4));


        BiomeDefaultFeatures.farmAnimals(spawnBuilder);
        BiomeDefaultFeatures.commonSpawns(spawnBuilder);

        BiomeGenerationSettings.Builder biomeBuilder =
                new BiomeGenerationSettings.Builder(context.lookup(Registries.PLACED_FEATURE), context.lookup(Registries.CONFIGURED_CARVER))
                        .addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, ModPlacedFeatures.CT_MAGMA_PLACED_KEY)
                ;

        globalOverworldGeneration(biomeBuilder);
        BiomeDefaultFeatures.addFossilDecoration(biomeBuilder);
        BiomeDefaultFeatures.addDefaultOres(biomeBuilder);
        ModBiomeDefaultFeatures.addVitricOreVariety(biomeBuilder);
        BiomeDefaultFeatures.addDefaultSoftDisks(biomeBuilder);

        BiomeDefaultFeatures.addWarmFlowers(biomeBuilder);
        BiomeDefaultFeatures.addFerns(biomeBuilder);
        BiomeDefaultFeatures.addDefaultGrass(biomeBuilder);
        BiomeDefaultFeatures.addForestGrass(biomeBuilder);
        BiomeDefaultFeatures.addDefaultMushrooms(biomeBuilder);
        BiomeDefaultFeatures.addDefaultExtraVegetation(biomeBuilder);


        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, ModPlacedFeatures.SPITFIRE_PLACED_KEY);
        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, ModPlacedFeatures.SM_EMBER_PLACED_KEY);
        biomeBuilder.addFeature(GenerationStep.Decoration.LOCAL_MODIFICATIONS, ModPlacedFeatures.TIBERIUM_GEODE_PLACED_KEY);


        return new Biome.BiomeBuilder()
                .hasPrecipitation(false)
                .downfall(0.8f)
                .temperature(1.5f)
                .generationSettings(biomeBuilder.build())
                .mobSpawnSettings(spawnBuilder.build())
                .specialEffects((new BiomeSpecialEffects.Builder())
                        .waterColor(0x0000FF)
                        .waterFogColor(0x0000FF)
                        .skyColor(0xFF8585)
                        .grassColorOverride(0xFF0A0A)
                        .foliageColorOverride(0xA30000)
                        .fogColor(0xFF4747)
                        .ambientMoodSound(new AmbientMoodSettings(ModSounds.VITRIC_AMBIENT.getHolder().get(), 6000, 8, 2.0D))
                        .ambientParticle(new AmbientParticleSettings(ParticleTypes.FLAME, 0.0008925F))
                        .backgroundMusic(Musics.createGameMusic(ModSounds.VITRIC_EXPANSE_MUSIC.getHolder().get())).build())
                .build();
    }

        //Marika Themed:
        public static Biome untarnishedHills(BootstapContext<Biome> context) {
            MobSpawnSettings.Builder spawnBuilder = new MobSpawnSettings.Builder();
            spawnBuilder.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.PIGLIN, 4, 4, 4));
            spawnBuilder.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.PILLAGER, 6, 4, 4));
            spawnBuilder.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(ModEntities.RHINO.get(), 2, 3, 5));


            BiomeDefaultFeatures.farmAnimals(spawnBuilder);
            BiomeDefaultFeatures.commonSpawns(spawnBuilder);

            BiomeGenerationSettings.Builder biomeBuilder =
                    new BiomeGenerationSettings.Builder(context.lookup(Registries.PLACED_FEATURE), context.lookup(Registries.CONFIGURED_CARVER))
                            .addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, ModPlacedFeatures.CT_GLOWSTONE_PLACED_KEY);

            BiomeDefaultFeatures.addFossilDecoration(biomeBuilder);
            globalOverworldGeneration(biomeBuilder);


            BiomeDefaultFeatures.addDefaultOres(biomeBuilder);
            ModBiomeDefaultFeatures.addVitricOreVariety(biomeBuilder);
            BiomeDefaultFeatures.addDefaultSoftDisks(biomeBuilder);

            BiomeDefaultFeatures.addForestFlowers(biomeBuilder);
            BiomeDefaultFeatures.addFerns(biomeBuilder);
            BiomeDefaultFeatures.addDefaultGrass(biomeBuilder);
            BiomeDefaultFeatures.addForestGrass(biomeBuilder);
            BiomeDefaultFeatures.addDefaultMushrooms(biomeBuilder);
            BiomeDefaultFeatures.addDefaultExtraVegetation(biomeBuilder);


            biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, ModPlacedFeatures.FULGURBLOOM_PLACED_KEY);
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
                            .skyColor(calculateSkyColor(0.7F))
                            .grassColorOverride(0xFFD60A)
                            .foliageColorOverride(0xF5CC00)
                            .fogColor(0xFFE770)
                            .ambientMoodSound(AmbientMoodSettings.LEGACY_CAVE_SETTINGS)
                            .backgroundMusic(Musics.createGameMusic(ModSounds.VITRIC_EXPANSE_MUSIC.getHolder().get())).build())
                    .build();
        }

    public static Biome evergoldExpanse(BootstapContext<Biome> context) {
        MobSpawnSettings.Builder spawnBuilder = new MobSpawnSettings.Builder();
        spawnBuilder.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.PIGLIN, 4, 4, 4));
        spawnBuilder.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.PILLAGER, 6, 4, 4));
        spawnBuilder.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(ModEntities.RHINO.get(), 2, 3, 5));


        BiomeDefaultFeatures.farmAnimals(spawnBuilder);
        BiomeDefaultFeatures.commonSpawns(spawnBuilder);

        BiomeGenerationSettings.Builder biomeBuilder =
                new BiomeGenerationSettings.Builder(context.lookup(Registries.PLACED_FEATURE), context.lookup(Registries.CONFIGURED_CARVER))
                        .addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, ModPlacedFeatures.CT_GLOWSTONE_PLACED_KEY);

        BiomeDefaultFeatures.addFossilDecoration(biomeBuilder);
        globalOverworldGeneration(biomeBuilder);


        BiomeDefaultFeatures.addDefaultOres(biomeBuilder);
        ModBiomeDefaultFeatures.addVitricOreVariety(biomeBuilder);
        BiomeDefaultFeatures.addDefaultSoftDisks(biomeBuilder);


        BiomeDefaultFeatures.addDefaultGrass(biomeBuilder);
        BiomeDefaultFeatures.addForestGrass(biomeBuilder);
        BiomeDefaultFeatures.addDefaultExtraVegetation(biomeBuilder);


        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, ModPlacedFeatures.FULGURBLOOM_PLACED_KEY);
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
                        .skyColor(calculateSkyColor(0.7F))
                        .grassColorOverride(0xFFD60A)
                        .foliageColorOverride(0xF5CC00)
                        .fogColor(0xFFE770)
                        .ambientMoodSound(new AmbientMoodSettings(ModSounds.VITRIC_AMBIENT.getHolder().get(), 6000, 8, 2.0D))
                        .backgroundMusic(Musics.createGameMusic(ModSounds.VITRIC_EXPANSE_MUSIC.getHolder().get())).build())
                .build();
    }

    public static Biome valleyOfGold (BootstapContext<Biome> context) {
        MobSpawnSettings.Builder spawnBuilder = new MobSpawnSettings.Builder();
        spawnBuilder.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.PIGLIN, 4, 4, 4));
        spawnBuilder.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.PILLAGER, 6, 4, 4));
        spawnBuilder.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(ModEntities.RHINO.get(), 2, 3, 5));


        BiomeDefaultFeatures.farmAnimals(spawnBuilder);
        BiomeDefaultFeatures.commonSpawns(spawnBuilder);

        BiomeGenerationSettings.Builder biomeBuilder =
                new BiomeGenerationSettings.Builder(context.lookup(Registries.PLACED_FEATURE), context.lookup(Registries.CONFIGURED_CARVER))
                        .addCarver(GenerationStep.Carving.AIR, Carvers.CANYON)
                        .addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, ModPlacedFeatures.CT_GLOWSTONE_PLACED_KEY);

        BiomeDefaultFeatures.addFossilDecoration(biomeBuilder);
        globalOverworldGeneration(biomeBuilder);

        BiomeDefaultFeatures.addDefaultOres(biomeBuilder);
        BiomeDefaultFeatures.addDefaultSoftDisks(biomeBuilder);
        ModBiomeDefaultFeatures.addVitricOreVariety(biomeBuilder);

        BiomeDefaultFeatures.addDefaultGrass(biomeBuilder);
        BiomeDefaultFeatures.addForestGrass(biomeBuilder);
        BiomeDefaultFeatures.addDefaultExtraVegetation(biomeBuilder);




        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, ModPlacedFeatures.FULGURBLOOM_PLACED_KEY);
        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, ModPlacedFeatures.SM_MARIKA_PLACED_KEY);



        return new Biome.BiomeBuilder()
                .hasPrecipitation(true)
                .downfall(0.8f)
                .temperature(0.7f)
                .generationSettings(biomeBuilder.build())
                .mobSpawnSettings(spawnBuilder.build())
                .specialEffects((new BiomeSpecialEffects.Builder())
                        .waterColor(0x0000FF)
                        .waterFogColor(0x0000FF)
                        .skyColor(calculateSkyColor(0.7F))
                        .grassColorOverride(0xFFD60A)
                        .foliageColorOverride(0xF5CC00)
                        .fogColor(0xFFE770)
                        .ambientMoodSound(new AmbientMoodSettings(ModSounds.VITRIC_AMBIENT.getHolder().get(), 6000, 8, 2.0D))
                        .backgroundMusic(Musics.createGameMusic(ModSounds.VITRIC_EXPANSE_MUSIC.getHolder().get())).build())
                .build();
    }

    //YellowZone:
    public static Biome deadForest (BootstapContext<Biome> context) {
        MobSpawnSettings.Builder spawnBuilder = new MobSpawnSettings.Builder();


        BiomeDefaultFeatures.farmAnimals(spawnBuilder);
        BiomeDefaultFeatures.commonSpawns(spawnBuilder);

        BiomeGenerationSettings.Builder biomeBuilder =
                new BiomeGenerationSettings.Builder(context.lookup(Registries.PLACED_FEATURE), context.lookup(Registries.CONFIGURED_CARVER));


        vitricExpanseYZGeneration(biomeBuilder);

        BiomeDefaultFeatures.addDefaultOres(biomeBuilder);
        ModBiomeDefaultFeatures.addVitricOreVariety(biomeBuilder);
        ModBiomeDefaultFeatures.addYZSoftDisks(biomeBuilder);


        BiomeDefaultFeatures.addDefaultGrass(biomeBuilder);
        BiomeDefaultFeatures.addForestGrass(biomeBuilder);
        BiomeDefaultFeatures.addDefaultExtraVegetation(biomeBuilder);


        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, ModPlacedFeatures.DEAD_HEAVY_PLACED_KEY);
        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, ModPlacedFeatures.DEAD_PLACED_KEY);

        biomeBuilder.addFeature(GenerationStep.Decoration.LOCAL_MODIFICATIONS, ModPlacedFeatures.CT_TIBERIUM_SOIL_PLACED_KEY);
        biomeBuilder.addFeature(GenerationStep.Decoration.LOCAL_MODIFICATIONS, ModPlacedFeatures.CT_DIRT_PLACED_KEY);




        return new Biome.BiomeBuilder()
                .hasPrecipitation(true)
                .downfall(0.8f)
                .temperature(0.7f)
                .generationSettings(biomeBuilder.build())
                .mobSpawnSettings(spawnBuilder.build())
                .specialEffects((new BiomeSpecialEffects.Builder())
                        .waterColor(0x0000FF)
                        .waterFogColor(0x0000FF)
                        .skyColor(calculateSkyColor(0.7F))
                        .grassColorOverride(0x7A4301)
                        .foliageColorOverride(0x7A4301)
                        .fogColor(0xFFE770)
                        .ambientMoodSound(new AmbientMoodSettings(ModSounds.VITRIC_AMBIENT.getHolder().get(), 6000, 8, 2.0D))
                        .backgroundMusic(Musics.createGameMusic(ModSounds.VITRIC_EXPANSE_MUSIC.getHolder().get())).build())
                .build();
    }

    public static Biome tiberianDesert (BootstapContext<Biome> context) {
        MobSpawnSettings.Builder spawnBuilder = new MobSpawnSettings.Builder();


        BiomeDefaultFeatures.desertSpawns(spawnBuilder);

        BiomeGenerationSettings.Builder biomeBuilder =
                new BiomeGenerationSettings.Builder(context.lookup(Registries.PLACED_FEATURE), context.lookup(Registries.CONFIGURED_CARVER));

        BiomeDefaultFeatures.addFossilDecoration(biomeBuilder);
        vitricExpanseYZGeneration(biomeBuilder);

        BiomeDefaultFeatures.addDefaultOres(biomeBuilder);
        ModBiomeDefaultFeatures.addYZSoftDisks(biomeBuilder);
        ModBiomeDefaultFeatures.addVitricOreVariety(biomeBuilder);

        BiomeDefaultFeatures.addDefaultFlowers(biomeBuilder);
        BiomeDefaultFeatures.addDefaultGrass(biomeBuilder);
        BiomeDefaultFeatures.addDesertVegetation(biomeBuilder);
        BiomeDefaultFeatures.addDefaultMushrooms(biomeBuilder);
        BiomeDefaultFeatures.addDesertExtraVegetation(biomeBuilder);
        BiomeDefaultFeatures.addDesertExtraDecoration(biomeBuilder);

        biomeBuilder.addFeature(GenerationStep.Decoration.LOCAL_MODIFICATIONS, ModPlacedFeatures.CT_TIBERIUM_SOIL_PLACED_KEY);
        biomeBuilder.addFeature(GenerationStep.Decoration.LOCAL_MODIFICATIONS, ModPlacedFeatures.CT_DIRT_PLACED_KEY);

        return new Biome.BiomeBuilder()
                .hasPrecipitation(false)
                .downfall(0.0f)
                .temperature(2.0f)
                .generationSettings(biomeBuilder.build())
                .mobSpawnSettings(spawnBuilder.build())
                .specialEffects((new BiomeSpecialEffects.Builder())
                        .waterColor(0x0000FF)
                        .waterFogColor(0x0000FF)
                        .skyColor(calculateSkyColor(2.0F))
                        .grassColorOverride(0x6C6E3C)
                        .foliageColorOverride(0x6C6E3C)
                        .fogColor(0xFFE770)
                        .ambientMoodSound(new AmbientMoodSettings(ModSounds.VITRIC_AMBIENT.getHolder().get(), 6000, 8, 2.0D))
                        .backgroundMusic(Musics.createGameMusic(ModSounds.VITRIC_EXPANSE_MUSIC.getHolder().get())).build())
                .build();
    }

    public static Biome tiberianDesertHills (BootstapContext<Biome> context) {
        MobSpawnSettings.Builder spawnBuilder = new MobSpawnSettings.Builder();


        BiomeDefaultFeatures.desertSpawns(spawnBuilder);

        BiomeGenerationSettings.Builder biomeBuilder =
                new BiomeGenerationSettings.Builder(context.lookup(Registries.PLACED_FEATURE), context.lookup(Registries.CONFIGURED_CARVER));

        BiomeDefaultFeatures.addFossilDecoration(biomeBuilder);
        vitricExpanseYZGeneration(biomeBuilder);

        BiomeDefaultFeatures.addDefaultOres(biomeBuilder);
        ModBiomeDefaultFeatures.addYZSoftDisks(biomeBuilder);
        ModBiomeDefaultFeatures.addVitricOreVariety(biomeBuilder);


        BiomeDefaultFeatures.addDefaultFlowers(biomeBuilder);
        BiomeDefaultFeatures.addDefaultGrass(biomeBuilder);
        BiomeDefaultFeatures.addDesertVegetation(biomeBuilder);
        BiomeDefaultFeatures.addDefaultMushrooms(biomeBuilder);
        BiomeDefaultFeatures.addDesertExtraVegetation(biomeBuilder);
        BiomeDefaultFeatures.addDesertExtraDecoration(biomeBuilder);

        biomeBuilder.addFeature(GenerationStep.Decoration.LOCAL_MODIFICATIONS, ModPlacedFeatures.CT_TIBERIUM_SOIL_PLACED_KEY);
        biomeBuilder.addFeature(GenerationStep.Decoration.LOCAL_MODIFICATIONS, ModPlacedFeatures.CT_RIPARIUS_STONE_CLUMP_PLACED_KEY);

        return new Biome.BiomeBuilder()
                .hasPrecipitation(false)
                .downfall(0.0f)
                .temperature(2.0f)
                .generationSettings(biomeBuilder.build())
                .mobSpawnSettings(spawnBuilder.build())
                .specialEffects((new BiomeSpecialEffects.Builder())
                        .waterColor(0x0000FF)
                        .waterFogColor(0x0000FF)
                        .skyColor(calculateSkyColor(2.0F))
                        .grassColorOverride(0x6C6E3C)
                        .foliageColorOverride(0x6C6E3C)
                        .fogColor(0xFFE770)
                        .ambientMoodSound(new AmbientMoodSettings(ModSounds.VITRIC_AMBIENT.getHolder().get(), 6000, 8, 2.0D))
                        .backgroundMusic(Musics.createGameMusic(ModSounds.VITRIC_EXPANSE_MUSIC.getHolder().get())).build())
                .build();
    }

    public static Biome tiberianBadlands (BootstapContext<Biome> context) {
        MobSpawnSettings.Builder spawnBuilder = new MobSpawnSettings.Builder();


        BiomeDefaultFeatures.commonSpawns(spawnBuilder);

        BiomeGenerationSettings.Builder biomeBuilder =
                new BiomeGenerationSettings.Builder(context.lookup(Registries.PLACED_FEATURE), context.lookup(Registries.CONFIGURED_CARVER));

        BiomeDefaultFeatures.addFossilDecoration(biomeBuilder);
        vitricExpanseYZGeneration(biomeBuilder);


        BiomeDefaultFeatures.addDefaultOres(biomeBuilder);
        ModBiomeDefaultFeatures.addYZSoftDisks(biomeBuilder);
        ModBiomeDefaultFeatures.addVitricOreVariety(biomeBuilder);


        BiomeDefaultFeatures.addBadlandGrass(biomeBuilder);
        BiomeDefaultFeatures.addDefaultMushrooms(biomeBuilder);
        BiomeDefaultFeatures.addBadlandExtraVegetation(biomeBuilder);

        biomeBuilder.addFeature(GenerationStep.Decoration.LOCAL_MODIFICATIONS, ModPlacedFeatures.CT_TIBERIUM_SOIL_PLACED_KEY);
        biomeBuilder.addFeature(GenerationStep.Decoration.LOCAL_MODIFICATIONS, ModPlacedFeatures.CT_DIRT_PLACED_KEY);
        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, ModPlacedFeatures.DEAD_PLACED_KEY);

        return new Biome.BiomeBuilder()
                .hasPrecipitation(true)
                .downfall(0.5f)
                .temperature(2.0f)
                .generationSettings(biomeBuilder.build())
                .mobSpawnSettings(spawnBuilder.build())
                .specialEffects((new BiomeSpecialEffects.Builder())
                        .waterColor(0x0000FF)
                        .waterFogColor(0x0000FF)
                        .skyColor(calculateSkyColor(0.5F))
                        .grassColorOverride(0x6C6E3C)
                        .foliageColorOverride(0x6C6E3C)
                        .fogColor(0xFFE770)
                        .ambientMoodSound(new AmbientMoodSettings(ModSounds.VITRIC_AMBIENT.getHolder().get(), 6000, 8, 2.0D))
                        .backgroundMusic(Musics.createGameMusic(ModSounds.VITRIC_EXPANSE_MUSIC.getHolder().get())).build())
                .build();
    }

    public static Biome tiberianHighlands (BootstapContext<Biome> context) {
        MobSpawnSettings.Builder spawnBuilder = new MobSpawnSettings.Builder();


        BiomeDefaultFeatures.commonSpawns(spawnBuilder);

        BiomeGenerationSettings.Builder biomeBuilder =
                new BiomeGenerationSettings.Builder(context.lookup(Registries.PLACED_FEATURE), context.lookup(Registries.CONFIGURED_CARVER));

        BiomeDefaultFeatures.addFossilDecoration(biomeBuilder);
        vitricExpanseYZGeneration(biomeBuilder);


        BiomeDefaultFeatures.addDefaultOres(biomeBuilder);
        ModBiomeDefaultFeatures.addYZSoftDisks(biomeBuilder);
        ModBiomeDefaultFeatures.addVitricOreVariety(biomeBuilder);


        BiomeDefaultFeatures.addBadlandGrass(biomeBuilder);
        BiomeDefaultFeatures.addDefaultMushrooms(biomeBuilder);
        BiomeDefaultFeatures.addBadlandExtraVegetation(biomeBuilder);

        biomeBuilder.addFeature(GenerationStep.Decoration.LOCAL_MODIFICATIONS, ModPlacedFeatures.CT_TIBERIUM_SOIL_PLACED_KEY);
        biomeBuilder.addFeature(GenerationStep.Decoration.LOCAL_MODIFICATIONS, ModPlacedFeatures.CT_DIRT_PLACED_KEY);
        biomeBuilder.addFeature(GenerationStep.Decoration.LOCAL_MODIFICATIONS, ModPlacedFeatures.CT_VINIFERA_STONE_CLUMP_PLACED_KEY);

        return new Biome.BiomeBuilder()
                .hasPrecipitation(true)
                .downfall(0.3f)
                .temperature(2.0f)
                .generationSettings(biomeBuilder.build())
                .mobSpawnSettings(spawnBuilder.build())
                .specialEffects((new BiomeSpecialEffects.Builder())
                        .waterColor(0x0000FF)
                        .waterFogColor(0x0000FF)
                        .skyColor(calculateSkyColor(0.3F))
                        .grassColorOverride(0x6C6E3C)
                        .foliageColorOverride(0x6C6E3C)
                        .fogColor(0xFFE770)
                        .ambientMoodSound(new AmbientMoodSettings(ModSounds.VITRIC_AMBIENT.getHolder().get(), 6000, 8, 2.0D))
                        .backgroundMusic(Musics.createGameMusic(ModSounds.VITRIC_EXPANSE_MUSIC.getHolder().get())).build())
                .build();
    }

    public static Biome oldBattlefield (BootstapContext<Biome> context) {
        MobSpawnSettings.Builder spawnBuilder = new MobSpawnSettings.Builder();


        BiomeDefaultFeatures.commonSpawns(spawnBuilder);

        BiomeGenerationSettings.Builder biomeBuilder =
                new BiomeGenerationSettings.Builder(context.lookup(Registries.PLACED_FEATURE), context.lookup(Registries.CONFIGURED_CARVER));

        BiomeDefaultFeatures.addFossilDecoration(biomeBuilder);
        vitricExpanseYZGeneration(biomeBuilder);


        BiomeDefaultFeatures.addDefaultOres(biomeBuilder);
        ModBiomeDefaultFeatures.addYZSoftDisks(biomeBuilder);
        ModBiomeDefaultFeatures.addVitricOreVariety(biomeBuilder);


        BiomeDefaultFeatures.addBadlandGrass(biomeBuilder);
        BiomeDefaultFeatures.addDefaultMushrooms(biomeBuilder);
        BiomeDefaultFeatures.addBadlandExtraVegetation(biomeBuilder);

        biomeBuilder.addFeature(GenerationStep.Decoration.LOCAL_MODIFICATIONS, ModPlacedFeatures.CT_TIBERIUM_SOIL_PLACED_KEY);
        biomeBuilder.addFeature(GenerationStep.Decoration.LOCAL_MODIFICATIONS, ModPlacedFeatures.CT_RIPARIUS_STONE_CLUMP_PLACED_KEY);



        return new Biome.BiomeBuilder()
                .hasPrecipitation(true)
                .downfall(0.3f)
                .temperature(2.0f)
                .generationSettings(biomeBuilder.build())
                .mobSpawnSettings(spawnBuilder.build())
                .specialEffects((new BiomeSpecialEffects.Builder())
                        .waterColor(0x0000FF)
                        .waterFogColor(0x0000FF)
                        .skyColor(calculateSkyColor(0.3F))
                        .grassColorOverride(0x6C6E3C)
                        .foliageColorOverride(0x6C6E3C)
                        .fogColor(0xFFE770)
                        .ambientMoodSound(new AmbientMoodSettings(ModSounds.VITRIC_AMBIENT.getHolder().get(), 6000, 8, 2.0D))
                        .backgroundMusic(Musics.createGameMusic(ModSounds.VITRIC_EXPANSE_MUSIC.getHolder().get())).build())
                .build();
    }

    public static Biome lostSteppes (BootstapContext<Biome> context) {
        MobSpawnSettings.Builder spawnBuilder = new MobSpawnSettings.Builder();


        BiomeDefaultFeatures.commonSpawns(spawnBuilder);

        BiomeGenerationSettings.Builder biomeBuilder =
                new BiomeGenerationSettings.Builder(context.lookup(Registries.PLACED_FEATURE), context.lookup(Registries.CONFIGURED_CARVER));

        BiomeDefaultFeatures.addFossilDecoration(biomeBuilder);
        vitricExpanseYZGeneration(biomeBuilder);


        BiomeDefaultFeatures.addDefaultOres(biomeBuilder);
        ModBiomeDefaultFeatures.addYZSoftDisks(biomeBuilder);
        ModBiomeDefaultFeatures.addVitricOreVariety(biomeBuilder);


        BiomeDefaultFeatures.addBadlandGrass(biomeBuilder);
        BiomeDefaultFeatures.addDefaultMushrooms(biomeBuilder);
        BiomeDefaultFeatures.addBadlandExtraVegetation(biomeBuilder);

        biomeBuilder.addFeature(GenerationStep.Decoration.LOCAL_MODIFICATIONS, ModPlacedFeatures.CT_TIBERIUM_SOIL_PLACED_KEY);
        biomeBuilder.addFeature(GenerationStep.Decoration.LOCAL_MODIFICATIONS, ModPlacedFeatures.CT_CRUENTUS_STONE_CLUMP_PLACED_KEY);



        return new Biome.BiomeBuilder()
                .hasPrecipitation(true)
                .downfall(0.3f)
                .temperature(2.0f)
                .generationSettings(biomeBuilder.build())
                .mobSpawnSettings(spawnBuilder.build())
                .specialEffects((new BiomeSpecialEffects.Builder())
                        .waterColor(0x0000FF)
                        .waterFogColor(0x0000FF)
                        .skyColor(calculateSkyColor(0.3F))
                        .grassColorOverride(0x6C6E3C)
                        .foliageColorOverride(0x6C6E3C)
                        .fogColor(0xFFE770)
                        .ambientMoodSound(new AmbientMoodSettings(ModSounds.VITRIC_AMBIENT.getHolder().get(), 6000, 8, 2.0D))
                        .backgroundMusic(Musics.createGameMusic(ModSounds.VITRIC_EXPANSE_MUSIC.getHolder().get())).build())
                .build();
    }

    public static Biome yellowZoneShore (BootstapContext<Biome> context) {
        MobSpawnSettings.Builder spawnBuilder = new MobSpawnSettings.Builder();


        BiomeDefaultFeatures.commonSpawns(spawnBuilder);

        BiomeGenerationSettings.Builder biomeBuilder =
                new BiomeGenerationSettings.Builder(context.lookup(Registries.PLACED_FEATURE), context.lookup(Registries.CONFIGURED_CARVER));

        BiomeDefaultFeatures.addFossilDecoration(biomeBuilder);
        vitricExpanseYZGeneration(biomeBuilder);


        BiomeDefaultFeatures.addDefaultOres(biomeBuilder);
        ModBiomeDefaultFeatures.addYZSoftDisks(biomeBuilder);
        ModBiomeDefaultFeatures.addVitricOreVariety(biomeBuilder);


        BiomeDefaultFeatures.addDefaultGrass(biomeBuilder);
        BiomeDefaultFeatures.addDefaultFlowers(biomeBuilder);
        BiomeDefaultFeatures.addDefaultMushrooms(biomeBuilder);
        BiomeDefaultFeatures.addDefaultExtraVegetation(biomeBuilder);

        biomeBuilder.addFeature(GenerationStep.Decoration.LOCAL_MODIFICATIONS, ModPlacedFeatures.CT_TIBERIUM_SOIL_PLACED_KEY);



        return new Biome.BiomeBuilder()
                .hasPrecipitation(true)
                .downfall(0.4f)
                .temperature(0.8f)
                .generationSettings(biomeBuilder.build())
                .mobSpawnSettings(spawnBuilder.build())
                .specialEffects((new BiomeSpecialEffects.Builder())
                        .waterColor(0x0000FF)
                        .waterFogColor(0x0000FF)
                        .skyColor(calculateSkyColor(0.8F))
                        .grassColorOverride(0x6C6E3C)
                        .foliageColorOverride(0x6C6E3C)
                        .fogColor(0xFFE770)
                        .ambientMoodSound(new AmbientMoodSettings(ModSounds.VITRIC_AMBIENT.getHolder().get(), 6000, 8, 2.0D))
                        .backgroundMusic(Musics.createGameMusic(ModSounds.VITRIC_EXPANSE_MUSIC.getHolder().get())).build())
                .build();
    }

    public static Biome yellowZoneStonyShore (BootstapContext<Biome> context) {
        MobSpawnSettings.Builder spawnBuilder = new MobSpawnSettings.Builder();


        BiomeDefaultFeatures.commonSpawns(spawnBuilder);

        BiomeGenerationSettings.Builder biomeBuilder =
                new BiomeGenerationSettings.Builder(context.lookup(Registries.PLACED_FEATURE), context.lookup(Registries.CONFIGURED_CARVER));

        BiomeDefaultFeatures.addFossilDecoration(biomeBuilder);
        vitricExpanseYZGeneration(biomeBuilder);


        BiomeDefaultFeatures.addDefaultOres(biomeBuilder);
        ModBiomeDefaultFeatures.addYZSoftDisks(biomeBuilder);
        ModBiomeDefaultFeatures.addVitricOreVariety(biomeBuilder);


        BiomeDefaultFeatures.addDefaultGrass(biomeBuilder);
        BiomeDefaultFeatures.addDefaultFlowers(biomeBuilder);
        BiomeDefaultFeatures.addDefaultMushrooms(biomeBuilder);
        BiomeDefaultFeatures.addDefaultExtraVegetation(biomeBuilder);

        biomeBuilder.addFeature(GenerationStep.Decoration.LOCAL_MODIFICATIONS, ModPlacedFeatures.CT_TIBERIUM_SOIL_PLACED_KEY);
        biomeBuilder.addFeature(GenerationStep.Decoration.LOCAL_MODIFICATIONS, ModPlacedFeatures.CT_RIPARIUS_STONE_CLUMP_PLACED_KEY);



        return new Biome.BiomeBuilder()
                .hasPrecipitation(true)
                .downfall(0.4f)
                .temperature(0.8f)
                .generationSettings(biomeBuilder.build())
                .mobSpawnSettings(spawnBuilder.build())
                .specialEffects((new BiomeSpecialEffects.Builder())
                        .waterColor(0x0000FF)
                        .waterFogColor(0x0000FF)
                        .skyColor(calculateSkyColor(0.8F))
                        .grassColorOverride(0x6C6E3C)
                        .foliageColorOverride(0x6C6E3C)
                        .fogColor(0xFFE770)
                        .ambientMoodSound(new AmbientMoodSettings(ModSounds.VITRIC_AMBIENT.getHolder().get(), 6000, 8, 2.0D))
                        .backgroundMusic(Musics.createGameMusic(ModSounds.VITRIC_EXPANSE_MUSIC.getHolder().get())).build())
                .build();
    }

    public static Biome infectedRiver (BootstapContext<Biome> context) {
        MobSpawnSettings.Builder spawnBuilder = new MobSpawnSettings.Builder();

        spawnBuilder.addSpawn(MobCategory.WATER_CREATURE, new MobSpawnSettings.SpawnerData(EntityType.SQUID, 2, 1, 4));
        spawnBuilder.addSpawn(MobCategory.WATER_AMBIENT, new MobSpawnSettings.SpawnerData(EntityType.SALMON, 5, 1, 5));
        spawnBuilder.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.DROWNED, 1, 1, 1));

        BiomeDefaultFeatures.commonSpawns(spawnBuilder);

        BiomeGenerationSettings.Builder biomeBuilder =
                new BiomeGenerationSettings.Builder(context.lookup(Registries.PLACED_FEATURE), context.lookup(Registries.CONFIGURED_CARVER));

        BiomeDefaultFeatures.addFossilDecoration(biomeBuilder);
        vitricExpanseYZGeneration(biomeBuilder);


        BiomeDefaultFeatures.addDefaultOres(biomeBuilder);
        ModBiomeDefaultFeatures.addYZSoftDisks(biomeBuilder);
        ModBiomeDefaultFeatures.addVitricOreVariety(biomeBuilder);


        BiomeDefaultFeatures.addDefaultGrass(biomeBuilder);
        BiomeDefaultFeatures.addDefaultFlowers(biomeBuilder);
        BiomeDefaultFeatures.addDefaultMushrooms(biomeBuilder);
        BiomeDefaultFeatures.addDefaultExtraVegetation(biomeBuilder);

        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, AquaticPlacements.SEAGRASS_RIVER);
        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, ModPlacedFeatures.DEAD_HEAVY_PLACED_KEY);





        return new Biome.BiomeBuilder()
                .hasPrecipitation(true)
                .downfall(0.5f)
                .temperature(0.5f)
                .generationSettings(biomeBuilder.build())
                .mobSpawnSettings(spawnBuilder.build())
                .specialEffects((new BiomeSpecialEffects.Builder())
                        .waterColor(0x0000FF)
                        .waterFogColor(0x0000FF)
                        .skyColor(calculateSkyColor(0.5F))
                        .grassColorOverride(0x6C6E3C)
                        .foliageColorOverride(0x6C6E3C)
                        .fogColor(0xFFE770)
                        .ambientMoodSound(new AmbientMoodSettings(ModSounds.VITRIC_AMBIENT.getHolder().get(), 6000, 8, 2.0D))
                        .backgroundMusic(Musics.createGameMusic(ModSounds.VITRIC_EXPANSE_MUSIC.getHolder().get())).build())
                .build();
    }

    public static Biome infectedOcean (BootstapContext<Biome> context) {
        MobSpawnSettings.Builder spawnBuilder = new MobSpawnSettings.Builder();

        spawnBuilder.addSpawn(MobCategory.WATER_AMBIENT, new MobSpawnSettings.SpawnerData(EntityType.SALMON, 15, 1, 5));
        spawnBuilder.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.DROWNED, 5, 1, 5));

        BiomeDefaultFeatures.oceanSpawns(spawnBuilder, 3, 4, 15);

        BiomeGenerationSettings.Builder biomeBuilder =
                new BiomeGenerationSettings.Builder(context.lookup(Registries.PLACED_FEATURE), context.lookup(Registries.CONFIGURED_CARVER));

        BiomeDefaultFeatures.addFossilDecoration(biomeBuilder);
        vitricExpanseYZGeneration(biomeBuilder);


        BiomeDefaultFeatures.addDefaultOres(biomeBuilder);
        ModBiomeDefaultFeatures.addYZSoftDisks(biomeBuilder);
        ModBiomeDefaultFeatures.addVitricOreVariety(biomeBuilder);


        BiomeDefaultFeatures.addDefaultSeagrass(biomeBuilder);
        BiomeDefaultFeatures.addDefaultGrass(biomeBuilder);
        BiomeDefaultFeatures.addDefaultFlowers(biomeBuilder);
        BiomeDefaultFeatures.addDefaultMushrooms(biomeBuilder);
        BiomeDefaultFeatures.addDefaultExtraVegetation(biomeBuilder);

        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, AquaticPlacements.SEAGRASS_NORMAL);
        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, AquaticPlacements.SEAGRASS_DEEP);
        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, AquaticPlacements.SEA_PICKLE);


        return new Biome.BiomeBuilder()
                .hasPrecipitation(true)
                .downfall(0.5f)
                .temperature(0.5f)
                .generationSettings(biomeBuilder.build())
                .mobSpawnSettings(spawnBuilder.build())
                .specialEffects((new BiomeSpecialEffects.Builder())
                        .waterColor(0x0000FF)
                        .waterFogColor(0x0000FF)
                        .skyColor(calculateSkyColor(0.5F))
                        .grassColorOverride(0x6C6E3C)
                        .foliageColorOverride(0x6C6E3C)
                        .fogColor(0xFFE770)
                        .ambientMoodSound(new AmbientMoodSettings(ModSounds.VITRIC_AMBIENT.getHolder().get(), 6000, 8, 2.0D))
                        .backgroundMusic(Musics.createGameMusic(ModSounds.VITRIC_EXPANSE_MUSIC.getHolder().get())).build())
                .build();
    }

    public static Biome dryHills (BootstapContext<Biome> context) {
        MobSpawnSettings.Builder spawnBuilder = new MobSpawnSettings.Builder();


        BiomeDefaultFeatures.commonSpawns(spawnBuilder);

        BiomeGenerationSettings.Builder biomeBuilder =
                new BiomeGenerationSettings.Builder(context.lookup(Registries.PLACED_FEATURE), context.lookup(Registries.CONFIGURED_CARVER));

        vitricExpanseYZGeneration(biomeBuilder);

        BiomeDefaultFeatures.addDefaultOres(biomeBuilder);
        ModBiomeDefaultFeatures.addYZSoftDisks(biomeBuilder);
        ModBiomeDefaultFeatures.addVitricOreVariety(biomeBuilder);



        BiomeDefaultFeatures.addBadlandGrass(biomeBuilder);
        BiomeDefaultFeatures.addDefaultMushrooms(biomeBuilder);
        BiomeDefaultFeatures.addBadlandExtraVegetation(biomeBuilder);

        biomeBuilder.addFeature(GenerationStep.Decoration.LOCAL_MODIFICATIONS, ModPlacedFeatures.CT_TIBERIUM_SOIL_PLACED_KEY);
        biomeBuilder.addFeature(GenerationStep.Decoration.LOCAL_MODIFICATIONS, ModPlacedFeatures.CT_DIRT_PLACED_KEY);



        return new Biome.BiomeBuilder()
                .hasPrecipitation(false)
                .downfall(0.0f)
                .temperature(1.5f)
                .generationSettings(biomeBuilder.build())
                .mobSpawnSettings(spawnBuilder.build())
                .specialEffects((new BiomeSpecialEffects.Builder())
                        .waterColor(0x0000FF)
                        .waterFogColor(0x0000FF)
                        .skyColor(calculateSkyColor(1.5F))
                        .grassColorOverride(0x6C6E3C)
                        .foliageColorOverride(0x6C6E3C)
                        .fogColor(0xFFE770)
                        .ambientMoodSound(new AmbientMoodSettings(ModSounds.VITRIC_AMBIENT.getHolder().get(), 6000, 8, 2.0D))
                        .backgroundMusic(Musics.createGameMusic(ModSounds.VITRIC_EXPANSE_MUSIC.getHolder().get())).build())
                .build();
    }

    public static Biome dryValley (BootstapContext<Biome> context) {
        MobSpawnSettings.Builder spawnBuilder = new MobSpawnSettings.Builder();


        BiomeDefaultFeatures.commonSpawns(spawnBuilder);

        BiomeGenerationSettings.Builder biomeBuilder =
                new BiomeGenerationSettings.Builder(context.lookup(Registries.PLACED_FEATURE), context.lookup(Registries.CONFIGURED_CARVER))
                        .addCarver(GenerationStep.Carving.AIR, ModCarvers.VITRIC_YZ_CANYON);

        BiomeDefaultFeatures.addFossilDecoration(biomeBuilder);
        vitricExpanseYZGeneration(biomeBuilder);


        BiomeDefaultFeatures.addDefaultOres(biomeBuilder);
        ModBiomeDefaultFeatures.addYZSoftDisks(biomeBuilder);
        ModBiomeDefaultFeatures.addVitricOreVariety(biomeBuilder);


        BiomeDefaultFeatures.addBadlandGrass(biomeBuilder);
        BiomeDefaultFeatures.addDefaultMushrooms(biomeBuilder);
        BiomeDefaultFeatures.addBadlandExtraVegetation(biomeBuilder);

        biomeBuilder.addFeature(GenerationStep.Decoration.LOCAL_MODIFICATIONS, ModPlacedFeatures.CT_TIBERIUM_SOIL_PLACED_KEY);
        biomeBuilder.addFeature(GenerationStep.Decoration.LOCAL_MODIFICATIONS, ModPlacedFeatures.CT_DIRT_PLACED_KEY);



        return new Biome.BiomeBuilder()
                .hasPrecipitation(false)
                .downfall(0.0f)
                .temperature(1.5f)
                .generationSettings(biomeBuilder.build())
                .mobSpawnSettings(spawnBuilder.build())
                .specialEffects((new BiomeSpecialEffects.Builder())
                        .waterColor(0x0000FF)
                        .waterFogColor(0x0000FF)
                        .skyColor(calculateSkyColor(1.5F))
                        .grassColorOverride(0x6C6E3C)
                        .foliageColorOverride(0x6C6E3C)
                        .fogColor(0xFFE770)
                        .ambientMoodSound(new AmbientMoodSettings(ModSounds.VITRIC_AMBIENT.getHolder().get(), 6000, 8, 2.0D))
                        .backgroundMusic(Musics.createGameMusic(ModSounds.VITRIC_EXPANSE_MUSIC.getHolder().get())).build())
                .build();
    }

    public static Biome forgottenHighlands (BootstapContext<Biome> context) {
        MobSpawnSettings.Builder spawnBuilder = new MobSpawnSettings.Builder();


        BiomeDefaultFeatures.commonSpawns(spawnBuilder);

        BiomeGenerationSettings.Builder biomeBuilder =
                new BiomeGenerationSettings.Builder(context.lookup(Registries.PLACED_FEATURE), context.lookup(Registries.CONFIGURED_CARVER));

        BiomeDefaultFeatures.addFossilDecoration(biomeBuilder);
        vitricExpanseYZGeneration(biomeBuilder);


        BiomeDefaultFeatures.addDefaultOres(biomeBuilder);
        ModBiomeDefaultFeatures.addYZSoftDisks(biomeBuilder);
        ModBiomeDefaultFeatures.addVitricOreVariety(biomeBuilder);


        BiomeDefaultFeatures.addBadlandGrass(biomeBuilder);
        BiomeDefaultFeatures.addDefaultMushrooms(biomeBuilder);
        BiomeDefaultFeatures.addBadlandExtraVegetation(biomeBuilder);

        biomeBuilder.addFeature(GenerationStep.Decoration.LOCAL_MODIFICATIONS, ModPlacedFeatures.CT_TIBERIUM_SOIL_PLACED_KEY);
        biomeBuilder.addFeature(GenerationStep.Decoration.LOCAL_MODIFICATIONS, ModPlacedFeatures.CT_DIRT_PLACED_KEY);
        biomeBuilder.addFeature(GenerationStep.Decoration.LOCAL_MODIFICATIONS, ModPlacedFeatures.CT_RIPARIUS_STONE_PLACED_KEY);
        biomeBuilder.addFeature(GenerationStep.Decoration.LOCAL_MODIFICATIONS, ModPlacedFeatures.CT_VINIFERA_STONE_PLACED_KEY);



        return new Biome.BiomeBuilder()
                .hasPrecipitation(true)
                .downfall(0.4f)
                .temperature(0.3f)
                .generationSettings(biomeBuilder.build())
                .mobSpawnSettings(spawnBuilder.build())
                .specialEffects((new BiomeSpecialEffects.Builder())
                        .waterColor(0x0000FF)
                        .waterFogColor(0x0000FF)
                        .skyColor(calculateSkyColor(0.3F))
                        .grassColorOverride(0x6C6E3C)
                        .foliageColorOverride(0x6C6E3C)
                        .fogColor(0xFFE770)
                        .ambientMoodSound(new AmbientMoodSettings(ModSounds.VITRIC_AMBIENT.getHolder().get(), 6000, 8, 2.0D))
                        .backgroundMusic(Musics.createGameMusic(ModSounds.VITRIC_EXPANSE_MUSIC.getHolder().get())).build())
                .build();
    }

    public static Biome redAndYellowZoneBorder (BootstapContext<Biome> context) {
        MobSpawnSettings.Builder spawnBuilder = new MobSpawnSettings.Builder();


        BiomeDefaultFeatures.commonSpawns(spawnBuilder);

        BiomeGenerationSettings.Builder biomeBuilder =
                new BiomeGenerationSettings.Builder(context.lookup(Registries.PLACED_FEATURE), context.lookup(Registries.CONFIGURED_CARVER));

        BiomeDefaultFeatures.addFossilDecoration(biomeBuilder);
        vitricExpanseYZGeneration(biomeBuilder);


        BiomeDefaultFeatures.addDefaultOres(biomeBuilder);
        ModBiomeDefaultFeatures.addYZSoftDisks(biomeBuilder);
        ModBiomeDefaultFeatures.addVitricOreVariety(biomeBuilder);



        BiomeDefaultFeatures.addBadlandGrass(biomeBuilder);
        BiomeDefaultFeatures.addDefaultMushrooms(biomeBuilder);
        BiomeDefaultFeatures.addBadlandExtraVegetation(biomeBuilder);

        biomeBuilder.addFeature(GenerationStep.Decoration.LOCAL_MODIFICATIONS, ModPlacedFeatures.CT_TIBERIUM_SOIL_PLACED_KEY);
        biomeBuilder.addFeature(GenerationStep.Decoration.LOCAL_MODIFICATIONS, ModPlacedFeatures.CT_RED_ZONE_DIRT_PLACED_KEY);
        biomeBuilder.addFeature(GenerationStep.Decoration.LOCAL_MODIFICATIONS, ModPlacedFeatures.CT_VINIFERA_STONE_CLUMP_PLACED_KEY);
        biomeBuilder.addFeature(GenerationStep.Decoration.LOCAL_MODIFICATIONS, ModPlacedFeatures.CT_CRUENTUS_STONE_CLUMP_PLACED_KEY);



        return new Biome.BiomeBuilder()
                .hasPrecipitation(true)
                .downfall(0.4f)
                .temperature(0.5f)
                .generationSettings(biomeBuilder.build())
                .mobSpawnSettings(spawnBuilder.build())
                .specialEffects((new BiomeSpecialEffects.Builder())
                        .waterColor(0x0000FF)
                        .waterFogColor(0x0000FF)
                        .skyColor(calculateSkyColor(0.3F))
                        .grassColorOverride(0x6C6E3C)
                        .foliageColorOverride(0x6C6E3C)
                        .fogColor(0xFFE770)
                        .ambientMoodSound(new AmbientMoodSettings(ModSounds.VITRIC_AMBIENT.getHolder().get(), 6000, 8, 2.0D))
                        .backgroundMusic(Musics.createGameMusic(ModSounds.VITRIC_EXPANSE_MUSIC.getHolder().get())).build())
                .build();
    }


    public static Biome ruinedCity (BootstapContext<Biome> context) {
        MobSpawnSettings.Builder spawnBuilder = new MobSpawnSettings.Builder();


        BiomeDefaultFeatures.commonSpawns(spawnBuilder);

        BiomeGenerationSettings.Builder biomeBuilder =
                new BiomeGenerationSettings.Builder(context.lookup(Registries.PLACED_FEATURE), context.lookup(Registries.CONFIGURED_CARVER));

        BiomeDefaultFeatures.addFossilDecoration(biomeBuilder);
        vitricExpanseYZGeneration(biomeBuilder);


        BiomeDefaultFeatures.addDefaultOres(biomeBuilder);
        ModBiomeDefaultFeatures.addYZSoftDisks(biomeBuilder);
        ModBiomeDefaultFeatures.addVitricOreVariety(biomeBuilder);


        BiomeDefaultFeatures.addDefaultGrass(biomeBuilder);
        BiomeDefaultFeatures.addDefaultMushrooms(biomeBuilder);
        BiomeDefaultFeatures.addBadlandExtraVegetation(biomeBuilder);

        biomeBuilder.addFeature(GenerationStep.Decoration.LOCAL_MODIFICATIONS, ModPlacedFeatures.CT_TIBERIUM_SOIL_PLACED_KEY);
        biomeBuilder.addFeature(GenerationStep.Decoration.LOCAL_MODIFICATIONS, ModPlacedFeatures.CT_DIRT_PLACED_KEY);

        return new Biome.BiomeBuilder()
                .hasPrecipitation(true)
                .downfall(0.4f)
                .temperature(0.7f)
                .generationSettings(biomeBuilder.build())
                .mobSpawnSettings(spawnBuilder.build())
                .specialEffects((new BiomeSpecialEffects.Builder())
                        .waterColor(0x0000FF)
                        .waterFogColor(0x0000FF)
                        .skyColor(calculateSkyColor(0.7F))
                        .grassColorOverride(0x6C6E3C)
                        .foliageColorOverride(0x6C6E3C)
                        .fogColor(0xFFE770)
                        .ambientMoodSound(new AmbientMoodSettings(ModSounds.VITRIC_AMBIENT.getHolder().get(), 6000, 8, 2.0D))
                        .backgroundMusic(Musics.createGameMusic(ModSounds.VITRIC_EXPANSE_MUSIC.getHolder().get())).build())
                .build();
    }

    public static Biome tiberianStoneFields (BootstapContext<Biome> context) {
        MobSpawnSettings.Builder spawnBuilder = new MobSpawnSettings.Builder();


        BiomeDefaultFeatures.commonSpawns(spawnBuilder);

        BiomeGenerationSettings.Builder biomeBuilder =
                new BiomeGenerationSettings.Builder(context.lookup(Registries.PLACED_FEATURE), context.lookup(Registries.CONFIGURED_CARVER));

        BiomeDefaultFeatures.addFossilDecoration(biomeBuilder);
        vitricExpanseYZGeneration(biomeBuilder);


        BiomeDefaultFeatures.addDefaultOres(biomeBuilder);
        ModBiomeDefaultFeatures.addYZSoftDisks(biomeBuilder);
        ModBiomeDefaultFeatures.addVitricOreVariety(biomeBuilder);


        BiomeDefaultFeatures.addDefaultGrass(biomeBuilder);
        BiomeDefaultFeatures.addDefaultMushrooms(biomeBuilder);
        BiomeDefaultFeatures.addBadlandExtraVegetation(biomeBuilder);

        biomeBuilder.addFeature(GenerationStep.Decoration.LOCAL_MODIFICATIONS, ModPlacedFeatures.CT_TIBERIUM_SOIL_PLACED_KEY);
        biomeBuilder.addFeature(GenerationStep.Decoration.LOCAL_MODIFICATIONS, ModPlacedFeatures.CT_RIPARIUS_STONE_SMALL_COLUMN_PLACED_KEY);
        biomeBuilder.addFeature(GenerationStep.Decoration.LOCAL_MODIFICATIONS, ModPlacedFeatures.CT_VINIFERA_STONE_SMALL_COLUMN_PLACED_KEY);

        return new Biome.BiomeBuilder()
                .hasPrecipitation(true)
                .downfall(0.2f)
                .temperature(1.0f)
                .generationSettings(biomeBuilder.build())
                .mobSpawnSettings(spawnBuilder.build())
                .specialEffects((new BiomeSpecialEffects.Builder())
                        .waterColor(0x0000FF)
                        .waterFogColor(0x0000FF)
                        .skyColor(calculateSkyColor(1.0F))
                        .grassColorOverride(0x6C6E3C)
                        .foliageColorOverride(0x6C6E3C)
                        .fogColor(0xFFE770)
                        .ambientMoodSound(new AmbientMoodSettings(ModSounds.VITRIC_AMBIENT.getHolder().get(), 6000, 8, 2.0D))
                        .backgroundMusic(Musics.createGameMusic(ModSounds.VITRIC_EXPANSE_MUSIC.getHolder().get())).build())
                .build();
    }

    public static Biome crystalFields (BootstapContext<Biome> context) {
        MobSpawnSettings.Builder spawnBuilder = new MobSpawnSettings.Builder();


        BiomeDefaultFeatures.commonSpawns(spawnBuilder);

        BiomeGenerationSettings.Builder biomeBuilder =
                new BiomeGenerationSettings.Builder(context.lookup(Registries.PLACED_FEATURE), context.lookup(Registries.CONFIGURED_CARVER));

        BiomeDefaultFeatures.addFossilDecoration(biomeBuilder);
        vitricExpanseYZGeneration(biomeBuilder);


        BiomeDefaultFeatures.addDefaultOres(biomeBuilder);
        ModBiomeDefaultFeatures.addYZSoftDisks(biomeBuilder);
        ModBiomeDefaultFeatures.addVitricOreVariety(biomeBuilder);


        BiomeDefaultFeatures.addDefaultGrass(biomeBuilder);
        BiomeDefaultFeatures.addDefaultMushrooms(biomeBuilder);
        BiomeDefaultFeatures.addBadlandExtraVegetation(biomeBuilder);

        biomeBuilder.addFeature(GenerationStep.Decoration.LOCAL_MODIFICATIONS, ModPlacedFeatures.CT_TIBERIUM_SOIL_PLACED_KEY);
        biomeBuilder.addFeature(GenerationStep.Decoration.LOCAL_MODIFICATIONS, ModPlacedFeatures.CT_RIPARIUS_CRYSTAL_SMALL_COLUMN_PLACED_KEY);
        biomeBuilder.addFeature(GenerationStep.Decoration.LOCAL_MODIFICATIONS, ModPlacedFeatures.CT_VINIFERA_CRYSTAL_SMALL_COLUMN_PLACED_KEY);

        return new Biome.BiomeBuilder()
                .hasPrecipitation(true)
                .downfall(0.2f)
                .temperature(1.0f)
                .generationSettings(biomeBuilder.build())
                .mobSpawnSettings(spawnBuilder.build())
                .specialEffects((new BiomeSpecialEffects.Builder())
                        .waterColor(0x0000FF)
                        .waterFogColor(0x0000FF)
                        .skyColor(calculateSkyColor(1.0F))
                        .grassColorOverride(0x6C6E3C)
                        .foliageColorOverride(0x6C6E3C)
                        .fogColor(0xFFE770)
                        .ambientMoodSound(new AmbientMoodSettings(ModSounds.VITRIC_AMBIENT.getHolder().get(), 6000, 8, 2.0D))
                        .backgroundMusic(Musics.createGameMusic(ModSounds.VITRIC_EXPANSE_MUSIC.getHolder().get())).build())
                .build();
    }

    public static Biome tiberianTaiga (BootstapContext<Biome> context) {
        MobSpawnSettings.Builder spawnBuilder = new MobSpawnSettings.Builder();

        spawnBuilder.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.WOLF, 8, 4, 4))
                .addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.RABBIT, 4, 2, 3))
                .addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.FOX, 8, 2, 4));



        BiomeDefaultFeatures.commonSpawns(spawnBuilder);

        BiomeGenerationSettings.Builder biomeBuilder =
                new BiomeGenerationSettings.Builder(context.lookup(Registries.PLACED_FEATURE), context.lookup(Registries.CONFIGURED_CARVER));

        BiomeDefaultFeatures.addFossilDecoration(biomeBuilder);
        vitricExpanseYZGeneration(biomeBuilder);


        BiomeDefaultFeatures.addDefaultOres(biomeBuilder);
        ModBiomeDefaultFeatures.addYZSoftDisks(biomeBuilder);
        ModBiomeDefaultFeatures.addVitricOreVariety(biomeBuilder);



        BiomeDefaultFeatures.addTaigaGrass(biomeBuilder);
        BiomeDefaultFeatures.addDefaultFlowers(biomeBuilder);
        BiomeDefaultFeatures.addDefaultMushrooms(biomeBuilder);
        BiomeDefaultFeatures.addDefaultExtraVegetation(biomeBuilder);

        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, ModPlacedFeatures.DEAD_HEAVY_PLACED_KEY);

        biomeBuilder.addFeature(GenerationStep.Decoration.LOCAL_MODIFICATIONS, ModPlacedFeatures.CT_TIBERIUM_SOIL_PLACED_KEY);
        biomeBuilder.addFeature(GenerationStep.Decoration.LOCAL_MODIFICATIONS, ModPlacedFeatures.CT_DIRT_PLACED_KEY);
        biomeBuilder.addFeature(GenerationStep.Decoration.LOCAL_MODIFICATIONS, ModPlacedFeatures.CT_VINIFERA_STONE_PLACED_KEY);

        return new Biome.BiomeBuilder()
                .hasPrecipitation(true)
                .downfall(0.2f)
                .temperature(0.4f)
                .generationSettings(biomeBuilder.build())
                .mobSpawnSettings(spawnBuilder.build())
                .specialEffects((new BiomeSpecialEffects.Builder())
                        .waterColor(0x0000FF)
                        .waterFogColor(0x0000FF)
                        .skyColor(calculateSkyColor(0.4F))
                        .grassColorOverride(0x6C6E3C)
                        .foliageColorOverride(0x6C6E3C)
                        .fogColor(0xFFE770)
                        .ambientMoodSound(new AmbientMoodSettings(ModSounds.VITRIC_AMBIENT.getHolder().get(), 6000, 8, 2.0D))
                        .backgroundMusic(Musics.createGameMusic(ModSounds.VITRIC_EXPANSE_MUSIC.getHolder().get())).build())
                .build();
    }

    public static Biome tiberianSwamp(BootstapContext<Biome> context) {
        MobSpawnSettings.Builder spawnBuilder = new MobSpawnSettings.Builder();
        BiomeDefaultFeatures.commonSpawns(spawnBuilder);
        spawnBuilder.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.SLIME, 1, 1, 1));
        spawnBuilder.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.FROG, 10, 2, 5));
        spawnBuilder.addSpawn(MobCategory.WATER_AMBIENT, new MobSpawnSettings.SpawnerData(EntityType.TROPICAL_FISH, 25, 8, 8));



        BiomeGenerationSettings.Builder biomeBuilder =
                new BiomeGenerationSettings.Builder(context.lookup(Registries.PLACED_FEATURE), context.lookup(Registries.CONFIGURED_CARVER));

        BiomeDefaultFeatures.addFossilDecoration(biomeBuilder);
        vitricExpanseYZGeneration(biomeBuilder);


        BiomeDefaultFeatures.addDefaultOres(biomeBuilder);
        ModBiomeDefaultFeatures.addYZSoftDisks(biomeBuilder);
        ModBiomeDefaultFeatures.addVitricOreVariety(biomeBuilder);


        BiomeDefaultFeatures.addSwampVegetation(biomeBuilder);
        BiomeDefaultFeatures.addSwampExtraVegetation(biomeBuilder);

        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, AquaticPlacements.SEAGRASS_SWAMP);
        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, ModPlacedFeatures.PLAGUED_PLACED_KEY);

        biomeBuilder.addFeature(GenerationStep.Decoration.LOCAL_MODIFICATIONS, ModPlacedFeatures.CT_TIBERIUM_SOIL_PLACED_KEY);
        biomeBuilder.addFeature(GenerationStep.Decoration.LOCAL_MODIFICATIONS, ModPlacedFeatures.CT_DIRT_PLACED_KEY);
        biomeBuilder.addFeature(GenerationStep.Decoration.LOCAL_MODIFICATIONS, ModPlacedFeatures.CT_RIPARIUS_STONE_PLACED_KEY);



        return (new Biome.BiomeBuilder())
                .hasPrecipitation(true)
                .temperature(0.8F)
                .downfall(0.9F)
                .specialEffects((new BiomeSpecialEffects.Builder())
                        .waterColor(3832426)
                        .waterFogColor(5077600)
                        .fogColor(12638463)
                        .skyColor(calculateSkyColor(0.8F))
                        .grassColorOverride(0x6C6E3C)
                        .foliageColorOverride(0x6C6E3C)
                        .ambientMoodSound(new AmbientMoodSettings(ModSounds.VITRIC_AMBIENT.getHolder().get(), 6000, 8, 2.0D))
                        .backgroundMusic(Musics.createGameMusic(ModSounds.VITRIC_EXPANSE_MUSIC.getHolder().get())).build())

                .mobSpawnSettings(spawnBuilder.build())
                .generationSettings(biomeBuilder.build()).build();
    }

    public static Biome tiberianWoods(BootstapContext<Biome> context) {
        MobSpawnSettings.Builder spawnBuilder = new MobSpawnSettings.Builder();
        BiomeDefaultFeatures.commonSpawns(spawnBuilder);
        spawnBuilder.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.SLIME, 1, 1, 1));
        spawnBuilder.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.FROG, 10, 2, 5));
        spawnBuilder.addSpawn(MobCategory.WATER_AMBIENT, new MobSpawnSettings.SpawnerData(EntityType.TROPICAL_FISH, 25, 8, 8));



        BiomeGenerationSettings.Builder biomeBuilder =
                new BiomeGenerationSettings.Builder(context.lookup(Registries.PLACED_FEATURE), context.lookup(Registries.CONFIGURED_CARVER));

        BiomeDefaultFeatures.addFossilDecoration(biomeBuilder);
        vitricExpanseYZGeneration(biomeBuilder);


        BiomeDefaultFeatures.addDefaultOres(biomeBuilder);
        ModBiomeDefaultFeatures.addYZSoftDisks(biomeBuilder);
        ModBiomeDefaultFeatures.addVitricOreVariety(biomeBuilder);


        BiomeDefaultFeatures.addDefaultGrass(biomeBuilder);
        BiomeDefaultFeatures.addDefaultExtraVegetation(biomeBuilder);
        BiomeDefaultFeatures.addDefaultFlowers(biomeBuilder);
        BiomeDefaultFeatures.addDefaultMushrooms(biomeBuilder);

        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, AquaticPlacements.SEAGRASS_SWAMP);
        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, ModPlacedFeatures.PLAGUED_PLACED_KEY);
        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, ModPlacedFeatures.DEAD_PLACED_KEY);

        biomeBuilder.addFeature(GenerationStep.Decoration.LOCAL_MODIFICATIONS, ModPlacedFeatures.CT_TIBERIUM_SOIL_PLACED_KEY);
        biomeBuilder.addFeature(GenerationStep.Decoration.LOCAL_MODIFICATIONS, ModPlacedFeatures.CT_DIRT_PLACED_KEY);
        biomeBuilder.addFeature(GenerationStep.Decoration.LOCAL_MODIFICATIONS, ModPlacedFeatures.CT_RIPARIUS_STONE_PLACED_KEY);


        return (new Biome.BiomeBuilder())
                .hasPrecipitation(true)
                .temperature(0.9F)
                .downfall(0.9F)
                .specialEffects((new BiomeSpecialEffects.Builder())
                        .waterColor(3832426)
                        .waterFogColor(5077600)
                        .fogColor(12638463)
                        .skyColor(calculateSkyColor(0.9F))
                        .grassColorOverride(0x6C6E3C)
                        .foliageColorOverride(0x6C6E3C)
                        .ambientMoodSound(new AmbientMoodSettings(ModSounds.VITRIC_AMBIENT.getHolder().get(), 6000, 8, 2.0D))
                        .backgroundMusic(Musics.createGameMusic(ModSounds.VITRIC_EXPANSE_MUSIC.getHolder().get())).build())

                .mobSpawnSettings(spawnBuilder.build())
                .generationSettings(biomeBuilder.build()).build();
    }

    //Red Zone:




    public static ResourceKey<Biome> register(String name) {
        return ResourceKey.create(Registries.BIOME, new ResourceLocation(CrystalTech.MOD_ID, name));
    }
}
