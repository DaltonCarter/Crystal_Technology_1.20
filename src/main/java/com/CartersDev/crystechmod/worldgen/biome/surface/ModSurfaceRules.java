package com.CartersDev.crystechmod.worldgen.biome.surface;

import com.CartersDev.crystechmod.block.ModBlocks;
import com.CartersDev.crystechmod.worldgen.biome.ModBiomes;
import net.minecraft.world.level.biome.Biomes;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.Noises;
import net.minecraft.world.level.levelgen.SurfaceRules;
import net.minecraft.world.level.levelgen.VerticalAnchor;

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
    private static final SurfaceRules.RuleSource RED_ZONE_SAND = makeStateRule(ModBlocks.YELLOW_ZONE_CRACKED_DIRT.get());
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



        public static SurfaceRules.RuleSource makeRules() {
            SurfaceRules.ConditionSource isAtOrAboveWaterLevel = SurfaceRules.waterBlockCheck(-1, 0);

            SurfaceRules.RuleSource grassSurface = SurfaceRules.sequence(SurfaceRules.ifTrue(isAtOrAboveWaterLevel, GRASS_BLOCK), DIRT);

            return SurfaceRules.sequence(
                    SurfaceRules.sequence(SurfaceRules.ifTrue(SurfaceRules.isBiome(ModBiomes.EMBER_GLOW_FOREST),
                                    SurfaceRules.ifTrue(SurfaceRules.ON_FLOOR, GRASS_BLOCK)),

                            SurfaceRules.ifTrue(SurfaceRules.ON_CEILING, STONE)),

                    SurfaceRules.sequence(SurfaceRules.ifTrue(SurfaceRules.isBiome(ModBiomes.AMBER_GROVE),
                                    SurfaceRules.ifTrue(SurfaceRules.ON_FLOOR, GRASS_BLOCK)),
                            SurfaceRules.ifTrue(SurfaceRules.ON_CEILING, STONE)),


                    // Default to a grass and dirt surface
                    SurfaceRules.ifTrue(SurfaceRules.ON_FLOOR, grassSurface)
            );
        }




    private static SurfaceRules.RuleSource makeStateRule(Block block) {
            return SurfaceRules.state(block.defaultBlockState());
        }
}
