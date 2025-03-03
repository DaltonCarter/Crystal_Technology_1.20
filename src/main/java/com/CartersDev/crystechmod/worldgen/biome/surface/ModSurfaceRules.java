package com.CartersDev.crystechmod.worldgen.biome.surface;

import com.CartersDev.crystechmod.block.ModBlocks;
import com.CartersDev.crystechmod.worldgen.biome.ModBiomes;
import com.google.common.collect.ImmutableList;
import net.minecraft.world.level.biome.Biomes;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.Noises;
import net.minecraft.world.level.levelgen.SurfaceRules;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraftforge.fml.common.Mod;

import static net.minecraft.world.level.levelgen.SurfaceRules.sequence;

/*
IMPORTANT NOTE:
While the Below work is my own typing, and my own experiments, Surface Rules is an UNHOLY MESS.
As such Special Thanks to Both Kaupenjoe, and The GlitchFiend Team is Due, Because without Kaupenjoes Introduction
to this Subject, and the Ability to look over and Study Biomes o' Plenty's MUCH NEATER code I likely would not have
even managed this much.
*/

public class ModSurfaceRules {
    //Base Overworld Blocks:
    private static final SurfaceRules.RuleSource GRASS_BLOCK = makeStateRule(Blocks.GRASS_BLOCK);
    private static final SurfaceRules.RuleSource AIR = makeStateRule(Blocks.AIR);
    private static final SurfaceRules.RuleSource BEDROCK = makeStateRule(Blocks.BEDROCK);
    private static final SurfaceRules.RuleSource ORANGE_TERRACOTTA = makeStateRule(Blocks.ORANGE_TERRACOTTA);
    private static final SurfaceRules.RuleSource YELLOW_TERRACOTTA = makeStateRule(Blocks.YELLOW_TERRACOTTA);
    private static final SurfaceRules.RuleSource BLACK_TERRACOTTA = makeStateRule(Blocks.BLACK_TERRACOTTA);
    private static final SurfaceRules.RuleSource TERRACOTTA = makeStateRule(Blocks.TERRACOTTA);
    private static final SurfaceRules.RuleSource STONE = makeStateRule(Blocks.STONE);
    private static final SurfaceRules.RuleSource DIRT = makeStateRule(Blocks.DIRT);
    private static final SurfaceRules.RuleSource COARSE_DIRT = makeStateRule(Blocks.COARSE_DIRT);
    private static final SurfaceRules.RuleSource GRAVEL = makeStateRule(Blocks.GRAVEL);
    private static final SurfaceRules.RuleSource SAND = makeStateRule(Blocks.SAND);
    private static final SurfaceRules.RuleSource SANDSTONE = makeStateRule(Blocks.SANDSTONE);
    private static final SurfaceRules.RuleSource SNOW_BLOCK = makeStateRule(Blocks.SNOW_BLOCK);
    private static final SurfaceRules.RuleSource POWDER_SNOW = makeStateRule(Blocks.POWDER_SNOW);
    private static final SurfaceRules.RuleSource WATER = makeStateRule(Blocks.WATER);
    private static final SurfaceRules.RuleSource LAVA = makeStateRule(Blocks.LAVA);
    private static final SurfaceRules.RuleSource MAGMA = makeStateRule(Blocks.MAGMA_BLOCK);
    private static final SurfaceRules.RuleSource OBSIDIAN = makeStateRule(Blocks.OBSIDIAN);
    private static final SurfaceRules.RuleSource TUFF = makeStateRule(Blocks.TUFF);
    private static final SurfaceRules.RuleSource SMOOTH_BASALT = makeStateRule(Blocks.SMOOTH_BASALT);
    private static final SurfaceRules.RuleSource MUD = makeStateRule(Blocks.MUD);
    private static final SurfaceRules.RuleSource DEEPSLATE = makeStateRule(Blocks.DEEPSLATE


    );

    //Base Nether:
    private static final SurfaceRules.RuleSource NETHERRACK = makeStateRule(Blocks.NETHERRACK);
    private static final SurfaceRules.RuleSource BASALT = makeStateRule(Blocks.BASALT);
    private static final SurfaceRules.RuleSource BLACKSTONE = makeStateRule(Blocks.BLACKSTONE);

    //Crystal Tech:
    private static final SurfaceRules.RuleSource YELLOW_ZONE_CRACKED_DIRT = makeStateRule(ModBlocks.YELLOW_ZONE_CRACKED_DIRT.get());
    private static final SurfaceRules.RuleSource YELLOW_ZONE_SAND = makeStateRule(ModBlocks.YELLOW_ZONE_SAND.get());
    private static final SurfaceRules.RuleSource SEEDED_YELLOW_ZONE_CRACKED_DIRT = makeStateRule(ModBlocks.SEEDED_YELLOW_ZONE_CRACKED_DIRT.get());
    private static final SurfaceRules.RuleSource RED_ZONE_DIRT = makeStateRule(ModBlocks.RED_ZONE_DIRT.get());
    private static final SurfaceRules.RuleSource SEEDED_RED_ZONE_DIRT = makeStateRule(ModBlocks.SEEDED_RED_ZONE_DIRT.get());
    private static final SurfaceRules.RuleSource RED_ZONE_SAND = makeStateRule(ModBlocks.RED_ZONE_SAND.get());
    private static final SurfaceRules.RuleSource RED_ZONE_SANDSTONE = makeStateRule(ModBlocks.RZ_SANDSTONE.get());
    private static final SurfaceRules.RuleSource YELLOW_ZONE_SANDSTONE = makeStateRule(ModBlocks.YZ_SANDSTONE.get());
    private static final SurfaceRules.RuleSource SEEDED_DIRT = makeStateRule(ModBlocks.SEEDED_DIRT.get());
    private static final SurfaceRules.RuleSource TIBERIUM_SOIL = makeStateRule(ModBlocks.TIBERIUM_SOIL.get());
    private static final SurfaceRules.RuleSource ICHOR_SOIL = makeStateRule(ModBlocks.ICHOR_SOIL.get());
    private static final SurfaceRules.RuleSource INFESTED_GRANITE = makeStateRule(ModBlocks.INFESTED_GRANITE.get());
    private static final SurfaceRules.RuleSource INFESTED_DIORITE = makeStateRule(ModBlocks.INFESTED_DIORITE.get());
    private static final SurfaceRules.RuleSource INFESTED_ANDESITE = makeStateRule(ModBlocks.INFESTED_ANDESITE.get());
    private static final SurfaceRules.RuleSource INFESTED_STONE = makeStateRule(ModBlocks.INFESTED_STONE.get());
    private static final SurfaceRules.RuleSource TIBERIUM_WATER = makeStateRule(ModBlocks.TIBERIUM_WATER_BLOCK.get());
    private static final SurfaceRules.RuleSource MOLTEN_TIBERIUM_BLOCK = makeStateRule(ModBlocks.MOLTEN_TIBERIUM_BLOCK.get());
    private static final SurfaceRules.RuleSource MOLTEN_BLUE_TIBERIUM = makeStateRule(ModBlocks.MOLTEN_BLUE_TIBERIUM_BLOCK.get());
    private static final SurfaceRules.RuleSource MOLTEN_RED_TIBERIUM = makeStateRule(ModBlocks.MOLTEN_RED_TIBERIUM_BLOCK.get());
    private static final SurfaceRules.RuleSource MOLTEN_PURPLE_TIBERIUM = makeStateRule(ModBlocks.MOLTEN_PURPLE_TIBERIUM_BLOCK.get());
    private static final SurfaceRules.RuleSource RIPARIUS_STONE = makeStateRule(ModBlocks.RIPARIUS_STONE.get());
    private static final SurfaceRules.RuleSource VINIFERA_STONE = makeStateRule(ModBlocks.VINIFERA_STONE.get());
    private static final SurfaceRules.RuleSource CRUENTUS_STONE = makeStateRule(ModBlocks.CRUENTUS_STONE.get());
    private static final SurfaceRules.RuleSource ABOREUS_STONE = makeStateRule(ModBlocks.ABOREUS_STONE.get());
    private static final SurfaceRules.RuleSource RIPARIUS_CRYSTAL = makeStateRule(ModBlocks.RIPARIUS_CRYSTAL.get());
    private static final SurfaceRules.RuleSource VINIFERA_CRYSTAL = makeStateRule(ModBlocks.VINIFERA_CRYSTAL.get());
    private static final SurfaceRules.RuleSource CRUENTUS_CRYSTAL = makeStateRule(ModBlocks.CRUENTUS_CRYSTAL.get());
    private static final SurfaceRules.RuleSource ABOREUS_CRYSTAL = makeStateRule(ModBlocks.ABOREUS_CRYSTAL.get());


    private static SurfaceRules.RuleSource makeStateRule(Block block) {
        return SurfaceRules.state(block.defaultBlockState());
    }

    public static SurfaceRules.RuleSource vitricExpanse() {
        return overworldLike(true, false, true);
    }

    public static SurfaceRules.RuleSource overworldLike(boolean p_198381_, boolean pBedrockRoof, boolean pBedrockFloor) {
        SurfaceRules.ConditionSource surfacerules$conditionsource = SurfaceRules.yBlockCheck(VerticalAnchor.absolute(97), 2);
        SurfaceRules.ConditionSource surfacerules$conditionsource1 = SurfaceRules.yBlockCheck(VerticalAnchor.absolute(256), 0);
        SurfaceRules.ConditionSource surfacerules$conditionsource2 = SurfaceRules.yStartCheck(VerticalAnchor.absolute(63), -1);
        SurfaceRules.ConditionSource surfacerules$conditionsource3 = SurfaceRules.yStartCheck(VerticalAnchor.absolute(74), 1);
        SurfaceRules.ConditionSource surfacerules$conditionsource4 = SurfaceRules.yBlockCheck(VerticalAnchor.absolute(60), 0);
        SurfaceRules.ConditionSource surfacerules$conditionsource5 = SurfaceRules.yBlockCheck(VerticalAnchor.absolute(62), 0);
        SurfaceRules.ConditionSource surfacerules$conditionsource6 = SurfaceRules.yBlockCheck(VerticalAnchor.absolute(63), 0);
        SurfaceRules.ConditionSource surfacerules$conditionsource7 = SurfaceRules.waterBlockCheck(-1, 0);
        SurfaceRules.ConditionSource surfacerules$conditionsource8 = SurfaceRules.waterBlockCheck(0, 0);
        SurfaceRules.ConditionSource surfacerules$conditionsource9 = SurfaceRules.waterStartCheck(-6, -1);
        SurfaceRules.ConditionSource surfacerules$conditionsource10 = SurfaceRules.hole();
        SurfaceRules.ConditionSource surfacerules$conditionsource11 = SurfaceRules.isBiome(ModBiomes.INFECTED_OCEAN);
        SurfaceRules.ConditionSource surfacerules$conditionsource12 = SurfaceRules.steep();
        SurfaceRules.ConditionSource surfacerules$conditionsource13 = SurfaceRules.isBiome(ModBiomes.YELLOW_ZONE_SHORE);
        SurfaceRules.ConditionSource surfacerules$conditionsource14 = SurfaceRules.isBiome(ModBiomes.TIBERIAN_DESERT);
        SurfaceRules.ConditionSource surfacerules$conditionsource15 = SurfaceRules.noiseCondition(Noises.SURFACE, -0.909D, -0.5454D);
        SurfaceRules.ConditionSource surfacerules$conditionsource16 = SurfaceRules.noiseCondition(Noises.SURFACE, -0.1818D, 0.1818D);
        SurfaceRules.ConditionSource surfacerules$conditionsource17 = SurfaceRules.noiseCondition(Noises.SURFACE, 0.5454D, 0.909D);


        SurfaceRules.RuleSource surfacerules$rulesource = SurfaceRules.sequence(SurfaceRules.ifTrue(surfacerules$conditionsource8, YELLOW_ZONE_CRACKED_DIRT), SEEDED_YELLOW_ZONE_CRACKED_DIRT);

        SurfaceRules.RuleSource surfacerules$rulesource1 = SurfaceRules.sequence(SurfaceRules.ifTrue(SurfaceRules.ON_CEILING, YELLOW_ZONE_SANDSTONE), YELLOW_ZONE_SAND);


        SurfaceRules.RuleSource surfacerules$rulesource2 = SurfaceRules.sequence(SurfaceRules.ifTrue(SurfaceRules.ON_CEILING, INFESTED_STONE), GRAVEL);

        SurfaceRules.RuleSource surfacerules$rulesource3 = SurfaceRules.sequence(SurfaceRules.ifTrue(SurfaceRules.isBiome(ModBiomes.TIBERIAN_STONE_FIELDS),
                SurfaceRules.sequence(SurfaceRules.ifTrue(SurfaceRules.noiseCondition(Noises.CALCITE, -0.0125D, 0.0125D), RIPARIUS_STONE), INFESTED_STONE)),

                SurfaceRules.ifTrue(SurfaceRules.isBiome(ModBiomes.YELLOW_ZONE_STONY_SHORE),
                SurfaceRules.sequence(SurfaceRules.ifTrue(SurfaceRules.noiseCondition(Noises.GRAVEL, -0.05D, 0.05D), surfacerules$rulesource2), INFESTED_STONE)),

                SurfaceRules.ifTrue(SurfaceRules.isBiome(ModBiomes.LOST_STEPPES),
                SurfaceRules.ifTrue(surfaceNoiseAbove(1.0D), INFESTED_STONE)), SurfaceRules.ifTrue(surfacerules$conditionsource13, surfacerules$rulesource1),
                SurfaceRules.ifTrue(surfacerules$conditionsource14, surfacerules$rulesource1), SurfaceRules.ifTrue(SurfaceRules.isBiome(Biomes.DRIPSTONE_CAVES), INFESTED_STONE));

        SurfaceRules.RuleSource surfacerules$rulesource4 = SurfaceRules.ifTrue(SurfaceRules.noiseCondition(Noises.POWDER_SNOW, 0.45D, 0.58D),
                SurfaceRules.ifTrue(surfacerules$conditionsource8, POWDER_SNOW));

        SurfaceRules.RuleSource surfacerules$rulesource5 = SurfaceRules.ifTrue(SurfaceRules.noiseCondition(Noises.POWDER_SNOW, 0.35D, 0.6D),
                SurfaceRules.ifTrue(surfacerules$conditionsource8, POWDER_SNOW));

        SurfaceRules.RuleSource surfacerules$rulesource6 = SurfaceRules.sequence(SurfaceRules.ifTrue(SurfaceRules.isBiome(ModBiomes.INFERNO_PEAK),
                SurfaceRules.sequence(SurfaceRules.ifTrue(surfacerules$conditionsource12, BASALT),
                        SurfaceRules.ifTrue(SurfaceRules.noiseCondition(Noises.PACKED_ICE, -0.5D, 0.2D), BASALT),
                        SurfaceRules.ifTrue(SurfaceRules.noiseCondition(Noises.ICE, -0.0625D, 0.025D), WATER),
                        SurfaceRules.ifTrue(surfacerules$conditionsource8, NETHERRACK))),

                SurfaceRules.ifTrue(SurfaceRules.isBiome(ModBiomes.DRY_HILLS, ModBiomes.DRY_VALLEY),
                SurfaceRules.sequence(SurfaceRules.ifTrue(surfacerules$conditionsource12, INFESTED_STONE), surfacerules$rulesource4, SurfaceRules.ifTrue(surfacerules$conditionsource8, YELLOW_ZONE_SANDSTONE))),

                SurfaceRules.ifTrue(SurfaceRules.isBiome(ModBiomes.RUINED_CITY), INFESTED_STONE),

                SurfaceRules.ifTrue(SurfaceRules.isBiome(ModBiomes.TIBERIAN_WOODS), SurfaceRules.sequence(surfacerules$rulesource4, YELLOW_ZONE_CRACKED_DIRT)), surfacerules$rulesource3,

                SurfaceRules.ifTrue(SurfaceRules.isBiome(ModBiomes.CRYSTAL_FIELDS), SurfaceRules.ifTrue(surfaceNoiseAbove(1.75D), INFESTED_STONE)),

                SurfaceRules.ifTrue(SurfaceRules.isBiome(ModBiomes.FORGOTTEN_HIGHLANDS), SurfaceRules.sequence(SurfaceRules.ifTrue(surfaceNoiseAbove(2.0D), surfacerules$rulesource2),
                        SurfaceRules.ifTrue(surfaceNoiseAbove(1.0D), INFESTED_STONE), SurfaceRules.ifTrue(surfaceNoiseAbove(-1.0D), YELLOW_ZONE_CRACKED_DIRT), surfacerules$rulesource2)),

                SurfaceRules.ifTrue(SurfaceRules.isBiome(ModBiomes.CALIDIAN_MARSH), MUD), DIRT,
                SurfaceRules.ifTrue(SurfaceRules.isBiome(ModBiomes.TIBERIAN_SWAMP), MUD), YELLOW_ZONE_CRACKED_DIRT);



        SurfaceRules.RuleSource surfacerules$rulesource7 = SurfaceRules.sequence(SurfaceRules.ifTrue(SurfaceRules.isBiome(ModBiomes.INFERNO_PEAK),
                SurfaceRules.sequence(SurfaceRules.ifTrue(surfacerules$conditionsource12, BASALT),
                        SurfaceRules.ifTrue(SurfaceRules.noiseCondition(Noises.PACKED_ICE, 0.0D, 0.2D), BASALT),
                        SurfaceRules.ifTrue(SurfaceRules.noiseCondition(Noises.ICE, 0.0D, 0.025D), WATER),
                        SurfaceRules.ifTrue(surfacerules$conditionsource8, MAGMA))),


                SurfaceRules.ifTrue(SurfaceRules.isBiome(ModBiomes.FORGOTTEN_HIGHLANDS),
                        SurfaceRules.sequence(SurfaceRules.ifTrue(surfacerules$conditionsource12, INFESTED_STONE), SurfaceRules.ifTrue(surfacerules$conditionsource8, SNOW_BLOCK))),

                SurfaceRules.ifTrue(SurfaceRules.isBiome(ModBiomes.TIBERIAN_WOODS), SurfaceRules.sequence(surfacerules$rulesource5,
                        SurfaceRules.ifTrue(surfacerules$conditionsource8, SNOW_BLOCK))), surfacerules$rulesource3,

                SurfaceRules.ifTrue(SurfaceRules.isBiome(ModBiomes.OLD_BATTLEFIELD), SurfaceRules.sequence(SurfaceRules.ifTrue(surfaceNoiseAbove(1.75D), INFESTED_STONE),
                        SurfaceRules.ifTrue(surfaceNoiseAbove(-0.5D), YELLOW_ZONE_CRACKED_DIRT))),

                SurfaceRules.ifTrue(SurfaceRules.isBiome(ModBiomes.DRY_VALLEY),
                        SurfaceRules.sequence(SurfaceRules.ifTrue(surfaceNoiseAbove(2.0D), surfacerules$rulesource2), SurfaceRules.ifTrue(surfaceNoiseAbove(1.0D), INFESTED_STONE),
                                SurfaceRules.ifTrue(surfaceNoiseAbove(-1.0D), surfacerules$rulesource), surfacerules$rulesource2)),

                SurfaceRules.ifTrue(SurfaceRules.isBiome(ModBiomes.TIBERIAN_TAIGA),
                        SurfaceRules.sequence(SurfaceRules.ifTrue(surfaceNoiseAbove(1.75D), YELLOW_ZONE_CRACKED_DIRT),
                                SurfaceRules.ifTrue(surfaceNoiseAbove(-0.95D), SEEDED_DIRT))),

                SurfaceRules.ifTrue(SurfaceRules.isBiome(ModBiomes.CALIDIAN_MARSH), MUD),
                SurfaceRules.ifTrue(SurfaceRules.isBiome(ModBiomes.TIBERIAN_SWAMP), MUD));

        SurfaceRules.RuleSource surfacerules$rulesource8 = SurfaceRules.sequence(SurfaceRules.ifTrue(SurfaceRules.ON_FLOOR,
                SurfaceRules.sequence(SurfaceRules.ifTrue(SurfaceRules.isBiome(Biomes.WOODED_BADLANDS),
                        SurfaceRules.ifTrue(surfacerules$conditionsource,
                                SurfaceRules.sequence(SurfaceRules.ifTrue(surfacerules$conditionsource15, YELLOW_ZONE_CRACKED_DIRT),
                                        SurfaceRules.ifTrue(surfacerules$conditionsource16, YELLOW_ZONE_CRACKED_DIRT),
                                        SurfaceRules.ifTrue(surfacerules$conditionsource17, YELLOW_ZONE_CRACKED_DIRT), surfacerules$rulesource))),

                        SurfaceRules.ifTrue(SurfaceRules.isBiome(ModBiomes.CALIDIAN_MARSH), SurfaceRules.ifTrue(surfacerules$conditionsource5,
                                SurfaceRules.ifTrue(SurfaceRules.not(surfacerules$conditionsource6),
                                        SurfaceRules.ifTrue(SurfaceRules.noiseCondition(Noises.SWAMP, 0.0D), WATER)))),

                        SurfaceRules.ifTrue(SurfaceRules.isBiome(ModBiomes.TIBERIAN_SWAMP), SurfaceRules.ifTrue(surfacerules$conditionsource4,
                                SurfaceRules.ifTrue(SurfaceRules.not(surfacerules$conditionsource6),
                                        SurfaceRules.ifTrue(SurfaceRules.noiseCondition(Noises.SWAMP, 0.0D), TIBERIUM_WATER)))))),

                SurfaceRules.ifTrue(SurfaceRules.isBiome(ModBiomes.TIBERIAN_BADLANDS),
                        SurfaceRules.sequence(SurfaceRules.ifTrue(SurfaceRules.ON_FLOOR, SurfaceRules.sequence(SurfaceRules.ifTrue(surfacerules$conditionsource1, YELLOW_ZONE_SANDSTONE),
                                SurfaceRules.ifTrue(surfacerules$conditionsource3, SurfaceRules.sequence(SurfaceRules.ifTrue(surfacerules$conditionsource15, TERRACOTTA),
                                        SurfaceRules.ifTrue(surfacerules$conditionsource16, INFESTED_DIORITE), SurfaceRules.ifTrue(surfacerules$conditionsource17, INFESTED_GRANITE),
                                        SurfaceRules.bandlands())), SurfaceRules.ifTrue(surfacerules$conditionsource7,
                                        SurfaceRules.sequence(SurfaceRules.ifTrue(SurfaceRules.ON_CEILING, YELLOW_ZONE_SANDSTONE), YELLOW_ZONE_SAND)),

                                SurfaceRules.ifTrue(SurfaceRules.not(surfacerules$conditionsource10), INFESTED_ANDESITE),
                                SurfaceRules.ifTrue(surfacerules$conditionsource9, INFESTED_GRANITE), surfacerules$rulesource2)),
                                SurfaceRules.ifTrue(surfacerules$conditionsource2, SurfaceRules.sequence(SurfaceRules.ifTrue(surfacerules$conditionsource6,
                                        SurfaceRules.ifTrue(SurfaceRules.not(surfacerules$conditionsource3), TERRACOTTA)), SurfaceRules.bandlands())),
                                SurfaceRules.ifTrue(SurfaceRules.UNDER_FLOOR, SurfaceRules.ifTrue(surfacerules$conditionsource9, YELLOW_ZONE_SANDSTONE)))),
                SurfaceRules.ifTrue(SurfaceRules.ON_FLOOR, SurfaceRules.ifTrue(surfacerules$conditionsource7,
                        SurfaceRules.sequence(SurfaceRules.ifTrue(surfacerules$conditionsource11,
                                SurfaceRules.ifTrue(surfacerules$conditionsource10, SurfaceRules.sequence(SurfaceRules.ifTrue(surfacerules$conditionsource8, AIR),
                                        SurfaceRules.ifTrue(SurfaceRules.temperature(), TIBERIUM_WATER), TIBERIUM_WATER))), surfacerules$rulesource7))),

                SurfaceRules.ifTrue(surfacerules$conditionsource9, SurfaceRules.sequence(SurfaceRules.ifTrue(SurfaceRules.ON_FLOOR,
                        SurfaceRules.ifTrue(surfacerules$conditionsource11, SurfaceRules.ifTrue(surfacerules$conditionsource10, TIBERIUM_WATER))),
                        SurfaceRules.ifTrue(SurfaceRules.UNDER_FLOOR, surfacerules$rulesource6), SurfaceRules.ifTrue(surfacerules$conditionsource13,
                                SurfaceRules.ifTrue(SurfaceRules.DEEP_UNDER_FLOOR, YELLOW_ZONE_SANDSTONE)), SurfaceRules.ifTrue(surfacerules$conditionsource14,
                                SurfaceRules.ifTrue(SurfaceRules.VERY_DEEP_UNDER_FLOOR, YELLOW_ZONE_SANDSTONE)))), SurfaceRules.ifTrue(SurfaceRules.ON_FLOOR,
                        SurfaceRules.sequence(SurfaceRules.ifTrue(SurfaceRules.isBiome(ModBiomes.FORGOTTEN_HIGHLANDS, ModBiomes.LOST_STEPPES), INFESTED_STONE),

                                SurfaceRules.ifTrue(SurfaceRules.isBiome(ModBiomes.INFECTED_OCEAN), surfacerules$rulesource1), surfacerules$rulesource2)));

        SurfaceRules.RuleSource surfacerules$rulesource9 = SurfaceRules.sequence(SurfaceRules.ifTrue(SurfaceRules.ON_CEILING, RED_ZONE_SANDSTONE), RED_ZONE_SAND);

        ImmutableList.Builder<SurfaceRules.RuleSource> builder = ImmutableList.builder();

        if (pBedrockRoof) {
            builder.add(SurfaceRules.ifTrue(SurfaceRules.not(SurfaceRules.verticalGradient("bedrock_roof", VerticalAnchor.belowTop(5), VerticalAnchor.top())), BEDROCK));
        }

        if (pBedrockFloor) {
            builder.add(SurfaceRules.ifTrue(SurfaceRules.verticalGradient("bedrock_floor", VerticalAnchor.bottom(), VerticalAnchor.aboveBottom(5)), BEDROCK));
        }

        SurfaceRules.RuleSource surfacerules$rulesource10 = SurfaceRules.ifTrue(SurfaceRules.abovePreliminarySurface(), surfacerules$rulesource8);
        builder.add(p_198381_ ? surfacerules$rulesource10 : surfacerules$rulesource8);
        builder.add(SurfaceRules.ifTrue(SurfaceRules.verticalGradient("deepslate", VerticalAnchor.absolute(0), VerticalAnchor.absolute(8)), DEEPSLATE));
        return SurfaceRules.sequence(builder.build().toArray((p_198379_) -> {
            return new SurfaceRules.RuleSource[p_198379_];
        }));
    }



    private static SurfaceRules.ConditionSource surfaceNoiseAbove(double p_194809_) {
        return SurfaceRules.noiseCondition(Noises.SURFACE, p_194809_ / 8.25D, Double.MAX_VALUE);
    }


}
