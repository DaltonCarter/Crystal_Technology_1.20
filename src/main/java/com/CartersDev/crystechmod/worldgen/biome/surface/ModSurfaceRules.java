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

    public static SurfaceRules.RuleSource overworld()
    {
        SurfaceRules.RuleSource surfaceRules = SurfaceRules.sequence(
                makeRules());

        ImmutableList.Builder<SurfaceRules.RuleSource> builder = ImmutableList.builder();

        SurfaceRules.RuleSource surfacerules$rulesource9 = SurfaceRules.ifTrue(SurfaceRules.abovePreliminarySurface(), surfaceRules);
        builder.add(surfacerules$rulesource9);
        return SurfaceRules.sequence(builder.build().toArray((p_198379_) -> {
            return new SurfaceRules.RuleSource[p_198379_];
        }));
    }


        public static SurfaceRules.RuleSource makeRules() {
            // Conditions
            SurfaceRules.ConditionSource isAtOrAboveWaterLevel = SurfaceRules.waterBlockCheck(-1, 0);
            SurfaceRules.ConditionSource sixBelowWater = SurfaceRules.waterStartCheck(-6, -1);
            SurfaceRules.ConditionSource isAbove62 = SurfaceRules.yBlockCheck(VerticalAnchor.absolute(62), 0);
            SurfaceRules.ConditionSource isAbove63 = SurfaceRules.yBlockCheck(VerticalAnchor.absolute(63), 0);

            SurfaceRules.RuleSource powderedSnowSurface = SurfaceRules.sequence(
                    SurfaceRules.ifTrue(SurfaceRules.ON_FLOOR, POWDER_SNOW),
                    SurfaceRules.ifTrue(SurfaceRules.UNDER_FLOOR, POWDER_SNOW)
            );

            SurfaceRules.RuleSource snowSurface = SurfaceRules.sequence(
                    SurfaceRules.ifTrue(SurfaceRules.ON_FLOOR, SNOW_BLOCK),
                    SurfaceRules.ifTrue(SurfaceRules.UNDER_FLOOR, SNOW_BLOCK)
            );

            SurfaceRules.RuleSource gravelStoneSurface = SurfaceRules.sequence(
                    SurfaceRules.ifTrue(SurfaceRules.ON_FLOOR, GRAVEL),
                    SurfaceRules.ifTrue(SurfaceRules.UNDER_FLOOR, STONE)
            );

            SurfaceRules.RuleSource gravelBeachSurface = SurfaceRules.sequence(
                    SurfaceRules.ifTrue(SurfaceRules.ON_FLOOR, SurfaceRules.sequence(SurfaceRules.ifTrue(isAbove63, AIR), SurfaceRules.sequence(SurfaceRules.ifTrue(isAbove62, WATER), GRAVEL))),
                    SurfaceRules.ifTrue(SurfaceRules.UNDER_FLOOR, GRAVEL)
            );

            SurfaceRules.RuleSource yzBeach = SurfaceRules.sequence(
                    SurfaceRules.ifTrue(surfaceNoiseAbove(1.5D), GRAVEL), YELLOW_ZONE_SAND
            );

            SurfaceRules.RuleSource rzBeach = SurfaceRules.sequence(
                    SurfaceRules.ifTrue(surfaceNoiseAbove(1.5D), GRAVEL), RED_ZONE_SAND
            );


            SurfaceRules.RuleSource yellowZoneDesertSurface = SurfaceRules.sequence(
                    SurfaceRules.ifTrue(surfaceNoiseAbove(1.9D), YELLOW_ZONE_SANDSTONE),
                    YELLOW_ZONE_SAND
            );

            SurfaceRules.RuleSource redZoneDesertSurface = SurfaceRules.sequence(
                    SurfaceRules.ifTrue(surfaceNoiseAbove(1.9D), RED_ZONE_SANDSTONE),
                    RED_ZONE_SAND
            );

//            SurfaceRules.RuleSource mixedColdDesertSurface = SurfaceRules.sequence(
//                    SurfaceRules.ifTrue(surfaceNoiseAbove(3.4D), powderedSnowSurface),
//                    SurfaceRules.sequence(SurfaceRules.ifTrue(surfaceNoiseAbove(2.6D), snowSurface),
//                            gravelStoneSurface
//                    ));

//            SurfaceRules.RuleSource volcanoSurface = SurfaceRules.sequence(
//                    SurfaceRules.ifTrue(SurfaceRules.ON_FLOOR, BASALT),
//                    SMOOTH_BASALT
//            );

            // Sandstone linings
//            SurfaceRules.RuleSource sandstoneLinedSand = SurfaceRules.sequence(SurfaceRules.ifTrue(SurfaceRules.ON_CEILING, SANDSTONE), SAND);
//            SurfaceRules.RuleSource lushDesertSandstoneLinedOrangeSand = SurfaceRules.sequence(SurfaceRules.ifTrue(SurfaceRules.ON_CEILING, ORANGE_SANDSTONE), mixedLushDesertSurface);
//            SurfaceRules.RuleSource blackSandstoneLining = SurfaceRules.sequence(SurfaceRules.ifTrue(SurfaceRules.ON_CEILING, BLACK_SANDSTONE), BLACK_SAND);
//            SurfaceRules.RuleSource coldDesertStoneLinedGravelSnow = SurfaceRules.sequence(SurfaceRules.ifTrue(SurfaceRules.ON_CEILING, STONE), mixedColdDesertSurface);
//
            return SurfaceRules.sequence(
                    SurfaceRules.ifTrue(SurfaceRules.isBiome(ModBiomes.HORNSENT_HILLS),
                            SurfaceRules.ifTrue(surfaceNoiseAbove(1.9D), STONE)
                    ));
//                    SurfaceRules.ifTrue(SurfaceRules.isBiome(BOPBiomes.ROCKY_RAINFOREST),
//                            SurfaceRules.sequence(SurfaceRules.ifTrue(surfaceNoiseAbove(4.0D), LIGHT_BLUE_TERRACOTTA),
//                                    SurfaceRules.sequence(SurfaceRules.ifTrue(surfaceNoiseAbove(3.0D), CYAN_TERRACOTTA),
//                                            SurfaceRules.sequence(SurfaceRules.ifTrue(surfaceNoiseAbove(2.0D), LIGHT_GRAY_TERRACOTTA),
//                                                    SurfaceRules.ifTrue(surfaceNoiseAbove(1.0D), TERRACOTTA))))
//                    ),
//                    SurfaceRules.ifTrue(
//                            sixBelowWater,
//                            SurfaceRules.sequence(
//                                    SurfaceRules.ifTrue(
//                                            SurfaceRules.UNDER_FLOOR,
//                                            SurfaceRules.sequence(
//                                                    SurfaceRules.ifTrue(SurfaceRules.isBiome(BOPBiomes.DRYLAND),
//                                                            SurfaceRules.ifTrue(surfaceNoiseAbove(1.75D), sandstoneLinedSand)
//                                                    ),
//                                                    SurfaceRules.ifTrue(SurfaceRules.isBiome(BOPBiomes.DUNE_BEACH), sandstoneLinedSand),
//                                                    SurfaceRules.ifTrue(SurfaceRules.isBiome(BOPBiomes.COLD_DESERT), coldDesertStoneLinedGravelSnow),
//                                                    SurfaceRules.ifTrue(SurfaceRules.isBiome(BOPBiomes.LUSH_DESERT), lushDesertSandstoneLinedOrangeSand),
//                                                    SurfaceRules.ifTrue(SurfaceRules.isBiome(BOPBiomes.VOLCANIC_PLAINS), blackSandstoneLining)
//                                            )
//                                    ),
//                                    SurfaceRules.ifTrue(
//                                            SurfaceRules.DEEP_UNDER_FLOOR,
//                                            SurfaceRules.sequence(
//                                                    SurfaceRules.ifTrue(SurfaceRules.isBiome(BOPBiomes.DRYLAND),
//                                                            SurfaceRules.ifTrue(surfaceNoiseAbove(1.75D), SANDSTONE)
//                                                    ),
//                                                    SurfaceRules.ifTrue(SurfaceRules.isBiome(BOPBiomes.COLD_DESERT), STONE),
//                                                    SurfaceRules.ifTrue(SurfaceRules.isBiome(BOPBiomes.LUSH_DESERT), ORANGE_SANDSTONE),
//                                                    SurfaceRules.ifTrue(SurfaceRules.isBiome(BOPBiomes.VOLCANIC_PLAINS), BLACK_SANDSTONE)
//                                            )
//                                    )
//                            )
//                    ),
//                    SurfaceRules.ifTrue(
//                            SurfaceRules.ON_FLOOR,
//                            SurfaceRules.sequence(
//                                    SurfaceRules.ifTrue(
//                                            // Swamp water noise
//                                            SurfaceRules.isBiome(BOPBiomes.MARSH, BOPBiomes.FLOODPLAIN),
//                                            SurfaceRules.ifTrue(
//                                                    isAbove62,
//                                                    SurfaceRules.ifTrue(
//                                                            SurfaceRules.not(isAbove63),
//                                                            SurfaceRules.ifTrue(
//                                                                    SurfaceRules.noiseCondition(Noises.SWAMP, 0.0D),
//                                                                    WATER
//                                                            )
//                                                    )
//                                            )
//                                    ),
//                                    SurfaceRules.ifTrue(
//                                            // Grass substitutes
//                                            isAtOrAboveWaterLevel,
//                                            SurfaceRules.sequence(
//                                                    SurfaceRules.ifTrue(
//                                                            SurfaceRules.isBiome(BOPBiomes.LUSH_SAVANNA),
//                                                            SurfaceRules.ifTrue(surfaceNoiseAbove(2.0D), ORANGE_SAND)
//                                                    ),
//                                                    SurfaceRules.ifTrue(
//                                                            SurfaceRules.isBiome(BOPBiomes.OVERGROWN_GREENS),
//                                                            SurfaceRules.ifTrue(surfaceNoiseAbove(1.7D), COARSE_DIRT)
//                                                    ),
//                                                    SurfaceRules.ifTrue(
//                                                            SurfaceRules.isBiome(BOPBiomes.HOT_SPRINGS),
//                                                            SurfaceRules.ifTrue(surfaceNoiseAbove(2.0D), COARSE_DIRT)
//                                                    ),
//                                                    SurfaceRules.ifTrue(
//                                                            SurfaceRules.isBiome(BOPBiomes.OLD_GROWTH_WOODLAND),
//                                                            SurfaceRules.ifTrue(surfaceNoiseAbove(2.6D), COARSE_DIRT)
//                                                    ),
//                                                    SurfaceRules.ifTrue(
//                                                            SurfaceRules.isBiome(BOPBiomes.OLD_GROWTH_DEAD_FOREST),
//                                                            SurfaceRules.ifTrue(surfaceNoiseAbove(2.3D), PODZOL)
//                                                    ),
//                                                    SurfaceRules.ifTrue(
//                                                            SurfaceRules.isBiome(BOPBiomes.MEDITERRANEAN_FOREST),
//                                                            SurfaceRules.ifTrue(surfaceNoiseAbove(1.9D), PODZOL)
//                                                    ),
//                                                    SurfaceRules.ifTrue(SurfaceRules.isBiome(BOPBiomes.ORIGIN_VALLEY, BOPBiomes.WINTRY_ORIGIN_VALLEY), SurfaceRules.sequence(SurfaceRules.ifTrue(SurfaceRules.yStartCheck(VerticalAnchor.absolute(66), 0), ORIGIN_GRASS), SurfaceRules.ifTrue(SurfaceRules.yBlockCheck(VerticalAnchor.absolute(65), 0), originBeach))),
//                                                    SurfaceRules.ifTrue(SurfaceRules.isBiome(BOPBiomes.REDWOOD_FOREST), PODZOL)
//                                            )
//                                    ),
//                                    SurfaceRules.ifTrue(
//                                            // Underwater lining
//                                            SurfaceRules.not(isAtOrAboveWaterLevel),
//                                            SurfaceRules.sequence(
//                                                    SurfaceRules.ifTrue(SurfaceRules.isBiome(BOPBiomes.CRAG, BOPBiomes.ROCKY_RAINFOREST), GRAVEL),
//                                                    SurfaceRules.ifTrue(
//                                                            SurfaceRules.isBiome(BOPBiomes.VOLCANO),
//                                                            SurfaceRules.ifTrue(surfaceNoiseAbove(2.7D), SMOOTH_BASALT)
//                                                    )
//                                            )
//                                    )
//                            )
//                    ),
//                    SurfaceRules.ifTrue(SurfaceRules.isBiome(BOPBiomes.COLD_DESERT),
//                            SurfaceRules.sequence(SurfaceRules.ifTrue(surfaceNoiseAbove(3.4D), powderedSnowSurface),
//                                    SurfaceRules.sequence(SurfaceRules.ifTrue(surfaceNoiseAbove(2.6D), snowSurface),
//                                            gravelStoneSurface
//                                    ))
//                    ),
//                    SurfaceRules.ifTrue(SurfaceRules.isBiome(BOPBiomes.CRAG), STONE),
//                    SurfaceRules.ifTrue(
//                            SurfaceRules.isBiome(BOPBiomes.VOLCANO),
//                            SurfaceRules.sequence(SurfaceRules.ifTrue(surfaceNoiseAbove(3.7D), MAGMA),
//                                    SurfaceRules.sequence(SurfaceRules.ifTrue(surfaceNoiseAbove(2.6D), BLACK_SANDSTONE),
//                                            SurfaceRules.sequence(SurfaceRules.ifTrue(surfaceNoiseAbove(1.5D), SMOOTH_BASALT),
//                                                    volcanoSurface
//                                            )))
//                    ),
//                    SurfaceRules.ifTrue(SurfaceRules.isBiome(BOPBiomes.GRAVEL_BEACH), gravelBeachSurface),
//                    SurfaceRules.ifTrue(SurfaceRules.isBiome(BOPBiomes.ORIGIN_VALLEY, BOPBiomes.WINTRY_ORIGIN_VALLEY), SurfaceRules.sequence(SurfaceRules.ifTrue(SurfaceRules.yStartCheck(VerticalAnchor.absolute(66), 0), SurfaceRules.ifTrue(SurfaceRules.stoneDepthCheck(0, true, 0, CaveSurface.FLOOR), DIRT)), SurfaceRules.ifTrue(SurfaceRules.stoneDepthCheck(0, true, 0, CaveSurface.FLOOR), originBeach))),
//
//                    SurfaceRules.ifTrue(
//                            SurfaceRules.isBiome(BOPBiomes.ROCKY_SHRUBLAND),
//                            SurfaceRules.ifTrue(surfaceNoiseAbove(1.4D), STONE)
//                    ),
//                    SurfaceRules.ifTrue(SurfaceRules.isBiome(BOPBiomes.WASTELAND), DRIED_SALT)
//            );
        }


    private static SurfaceRules.ConditionSource surfaceNoiseAbove(double p_194809_) {
        return SurfaceRules.noiseCondition(Noises.SURFACE, p_194809_ / 8.25D, Double.MAX_VALUE);
    }

    private static SurfaceRules.RuleSource makeStateRule(Block block) {
            return SurfaceRules.state(block.defaultBlockState());
        }
}
