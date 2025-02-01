package com.CartersDev.crystechmod.datagen.loot;


import com.CartersDev.crystechmod.block.ModBlocks;
import com.CartersDev.crystechmod.block.custom.*;
import com.CartersDev.crystechmod.item.ModItems;
import net.minecraft.advancements.critereon.StatePropertiesPredicate;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.StemBlock;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.ApplyBonusCount;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.predicates.LootItemBlockStatePropertyCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;
import net.minecraftforge.registries.RegistryObject;

import java.util.Set;

public class ModBlockLootTables extends BlockLootSubProvider {
    public ModBlockLootTables() {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags());
    }

    @Override
    protected void generate() {

        //Self Drops:
        this.dropSelf(ModBlocks.TEST_BLOCK.get());

        this.dropSelf(ModBlocks.CRYSTAL_CORE_LAMP_G.get());
        this.dropSelf(ModBlocks.INVERTED_CRYSTAL_CORE_LAMP_G.get());
        this.dropSelf(ModBlocks.CRYSTAL_CORE_LAMP_B.get());
        this.dropSelf(ModBlocks.INVERTED_CRYSTAL_CORE_LAMP_B.get());
        this.dropSelf(ModBlocks.CRYSTAL_CORE_LAMP_R.get());
        this.dropSelf(ModBlocks.INVERTED_CRYSTAL_CORE_LAMP_R.get());
        this.dropSelf(ModBlocks.CRYSTAL_CORE_LAMP_P.get());
        this.dropSelf(ModBlocks.INVERTED_CRYSTAL_CORE_LAMP_P.get());

        this.dropSelf(ModBlocks.CRYSTAL_CORE_LIGHT.get());
        this.dropSelf(ModBlocks.INVERTED_CRYSTAL_CORE_LIGHT.get());

        this.dropSelf(ModBlocks.TIBERIUM_BLOCK.get());
        this.dropSelf(ModBlocks.TIBERIUM_BLUE_BLOCK.get());
        this.dropSelf(ModBlocks.TIBERIUM_RED_BLOCK.get());
        this.dropSelf(ModBlocks.TIBERIUM_PURPLE_BLOCK.get());
        this.dropSelf(ModBlocks.NOD_CREST_LARGE.get());
        this.dropSelf(ModBlocks.YOKARAN_BLOOM.get());
        this.dropSelf(ModBlocks.SPITFIRE.get());
        this.dropSelf(ModBlocks.FULGURBLOOM.get());
        this.dropSelf(ModBlocks.VITRIC_BLOOM.get());
        this.dropSelf(ModBlocks.VITRIC_ROSE.get());



        this.dropSelf(ModBlocks.AERIES_BLOCK.get());
        this.dropSelf(ModBlocks.ENIGMA_BLOCK.get());
        this.dropSelf(ModBlocks.ILLUMINA_BLOCK.get());
        this.dropSelf(ModBlocks.KRYON_BLOCK.get());

        this.dropSelf(ModBlocks.VITRIC_DEEPSLATE.get());
        this.dropSelf(ModBlocks.VITRIC_DEEPSLATE_BRICKS.get());
        this.dropSelf(ModBlocks.VITRIC_DEEPSLATE_BRICK_WALL.get());
        this.dropSelf(ModBlocks.VITRIC_DEEPSLATE_BRICK_STAIRS.get());

        this.dropSelf(ModBlocks.VITRIC_DEEPSLATE_TILES.get());
        this.dropSelf(ModBlocks.VITRIC_DEEPSLATE_TILE_WALL.get());
        this.dropSelf(ModBlocks.VITRIC_DEEPSLATE_TILE_STAIRS.get());

        this.dropSelf(ModBlocks.GUNDANIUM_BLOCK.get());
        this.dropSelf(ModBlocks.ALYTHUM_BLOCK.get());
        this.dropSelf(ModBlocks.ILLYRIM_BLOCK.get());
        this.dropSelf(ModBlocks.LG_CORE_BLOCK.get());
        this.dropSelf(ModBlocks.MG_CORE_BLOCK.get());
        this.dropSelf(ModBlocks.HG_CORE_BLOCK.get());
        this.dropSelf(ModBlocks.FIRESTONE_BLOCK.get());

        this.dropSelf(ModBlocks.INFESTED_STONE.get());
        this.dropSelf(ModBlocks.INFESTED_STONE_BRICKS.get());
        this.dropSelf(ModBlocks.INFESTED_COBBLE.get());
        this.dropSelf(ModBlocks.INFESTED_ANDESITE.get());
        this.dropSelf(ModBlocks.INFESTED_DIORITE.get());
        this.dropSelf(ModBlocks.INFESTED_GRANITE.get());

        this.dropSelf(ModBlocks.YELLOW_ZONE_SAND.get());
        this.dropSelf(ModBlocks.RED_ZONE_DIRT.get());
        this.dropSelf(ModBlocks.RED_ZONE_SAND.get());
        this.dropSelf(ModBlocks.YELLOW_ZONE_CRACKED_DIRT.get());
        this.dropSelf(ModBlocks.SEEDED_RED_ZONE_DIRT.get());
        this.dropSelf(ModBlocks.SEEDED_YELLOW_ZONE_CRACKED_DIRT.get());
        this.dropSelf(ModBlocks.SEEDED_DIRT.get());

        this.dropSelf(ModBlocks.RIPARIUS_STONE.get());
        this.dropSelf(ModBlocks.RIPARIUS_STONE_BRICKS.get());
        this.dropSelf(ModBlocks.RIPARIUS_STONE_BRICK_WALL.get());
        this.dropSelf(ModBlocks.RIPARIUS_STONE_BRICK_STAIRS.get());
        this.dropSelf(ModBlocks.VINIFERA_STONE.get());
        this.dropSelf(ModBlocks.VINIFERA_STONE_BRICKS.get());
        this.dropSelf(ModBlocks.VINIFERA_STONE_BRICK_WALL.get());
        this.dropSelf(ModBlocks.VINIFERA_STONE_BRICK_STAIRS.get());
        this.dropSelf(ModBlocks.CRUENTUS_STONE.get());
        this.dropSelf(ModBlocks.CRUENTUS_STONE_BRICKS.get());
        this.dropSelf(ModBlocks.CRUENTUS_STONE_BRICK_WALL.get());
        this.dropSelf(ModBlocks.CRUENTUS_STONE_BRICK_STAIRS.get());
        this.dropSelf(ModBlocks.ABOREUS_STONE.get());
        this.dropSelf(ModBlocks.ABOREUS_STONE_BRICKS.get());
        this.dropSelf(ModBlocks.ABOREUS_STONE_BRICK_WALL.get());
        this.dropSelf(ModBlocks.ABOREUS_STONE_BRICK_STAIRS.get());

        this.dropSelf(ModBlocks.RIPARIUS_CRYSTAL.get());
        this.dropSelf(ModBlocks.VINIFERA_CRYSTAL.get());
        this.dropSelf(ModBlocks.CRUENTUS_CRYSTAL.get());
        this.dropSelf(ModBlocks.ABOREUS_CRYSTAL.get());

        this.dropSelf(ModBlocks.BLACK_TIBERCRETE.get());
        this.dropSelf(ModBlocks.BLUE_TIBERCRETE.get());
        this.dropSelf(ModBlocks.BROWN_TIBERCRETE.get());
        this.dropSelf(ModBlocks.CYAN_TIBERCRETE.get());
        this.dropSelf(ModBlocks.GRAY_TIBERCRETE.get());
        this.dropSelf(ModBlocks.GREEN_TIBERCRETE.get());
        this.dropSelf(ModBlocks.LIGHT_GRAY_TIBERCRETE.get());
        this.dropSelf(ModBlocks.LIGHT_BLUE_TIBERCRETE.get());
        this.dropSelf(ModBlocks.LIME_TIBERCRETE.get());
        this.dropSelf(ModBlocks.MAGENTA_TIBERCRETE.get());
        this.dropSelf(ModBlocks.ORANGE_TIBERCRETE.get());
        this.dropSelf(ModBlocks.PINK_TIBERCRETE.get());
        this.dropSelf(ModBlocks.PURPLE_TIBERCRETE.get());
        this.dropSelf(ModBlocks.RED_TIBERCRETE.get());
        this.dropSelf(ModBlocks.WHITE_TIBERCRETE.get());
        this.dropSelf(ModBlocks.YELLOW_TIBERCRETE.get());

        this.dropSelf(ModBlocks.BLACK_TIBERCRETE_POWDER.get());
        this.dropSelf(ModBlocks.BLUE_TIBERCRETE_POWDER.get());
        this.dropSelf(ModBlocks.BROWN_TIBERCRETE_POWDER.get());
        this.dropSelf(ModBlocks.CYAN_TIBERCRETE_POWDER.get());
        this.dropSelf(ModBlocks.GRAY_TIBERCRETE_POWDER.get());
        this.dropSelf(ModBlocks.GREEN_TIBERCRETE_POWDER.get());
        this.dropSelf(ModBlocks.LIGHT_GRAY_TIBERCRETE_POWDER.get());
        this.dropSelf(ModBlocks.LIGHT_BLUE_TIBERCRETE_POWDER.get());
        this.dropSelf(ModBlocks.LIME_TIBERCRETE_POWDER.get());
        this.dropSelf(ModBlocks.MAGENTA_TIBERCRETE_POWDER.get());
        this.dropSelf(ModBlocks.ORANGE_TIBERCRETE_POWDER.get());
        this.dropSelf(ModBlocks.PINK_TIBERCRETE_POWDER.get());
        this.dropSelf(ModBlocks.PURPLE_TIBERCRETE_POWDER.get());
        this.dropSelf(ModBlocks.RED_TIBERCRETE_POWDER.get());
        this.dropSelf(ModBlocks.WHITE_TIBERCRETE_POWDER.get());
        this.dropSelf(ModBlocks.YELLOW_TIBERCRETE_POWDER.get());

        this.dropSelf(ModBlocks.BLACK_TIBERCRETE_STAIRS.get());
        this.dropSelf(ModBlocks.BLUE_TIBERCRETE_STAIRS.get());
        this.dropSelf(ModBlocks.BROWN_TIBERCRETE_STAIRS.get());
        this.dropSelf(ModBlocks.CYAN_TIBERCRETE_STAIRS.get());
        this.dropSelf(ModBlocks.GRAY_TIBERCRETE_STAIRS.get());
        this.dropSelf(ModBlocks.GREEN_TIBERCRETE_STAIRS.get());
        this.dropSelf(ModBlocks.LIGHT_GRAY_TIBERCRETE_STAIRS.get());
        this.dropSelf(ModBlocks.LIGHT_BLUE_TIBERCRETE_STAIRS.get());
        this.dropSelf(ModBlocks.LIME_TIBERCRETE_STAIRS.get());
        this.dropSelf(ModBlocks.MAGENTA_TIBERCRETE_STAIRS.get());
        this.dropSelf(ModBlocks.ORANGE_TIBERCRETE_STAIRS.get());
        this.dropSelf(ModBlocks.PINK_TIBERCRETE_STAIRS.get());
        this.dropSelf(ModBlocks.PURPLE_TIBERCRETE_STAIRS.get());
        this.dropSelf(ModBlocks.RED_TIBERCRETE_STAIRS.get());
        this.dropSelf(ModBlocks.WHITE_TIBERCRETE_STAIRS.get());
        this.dropSelf(ModBlocks.YELLOW_TIBERCRETE_STAIRS.get());

        this.dropSelf(ModBlocks.BLACK_TIBERCRETE_BRICKS.get());
        this.dropSelf(ModBlocks.BLUE_TIBERCRETE_BRICKS.get());
        this.dropSelf(ModBlocks.BROWN_TIBERCRETE_BRICKS.get());
        this.dropSelf(ModBlocks.CYAN_TIBERCRETE_BRICKS.get());
        this.dropSelf(ModBlocks.GRAY_TIBERCRETE_BRICKS.get());
        this.dropSelf(ModBlocks.GREEN_TIBERCRETE_BRICKS.get());
        this.dropSelf(ModBlocks.LIGHT_GRAY_TIBERCRETE_BRICKS.get());
        this.dropSelf(ModBlocks.LIGHT_BLUE_TIBERCRETE_BRICKS.get());
        this.dropSelf(ModBlocks.LIME_TIBERCRETE_BRICKS.get());
        this.dropSelf(ModBlocks.MAGENTA_TIBERCRETE_BRICKS.get());
        this.dropSelf(ModBlocks.ORANGE_TIBERCRETE_BRICKS.get());
        this.dropSelf(ModBlocks.PINK_TIBERCRETE_BRICKS.get());
        this.dropSelf(ModBlocks.PURPLE_TIBERCRETE_BRICKS.get());
        this.dropSelf(ModBlocks.RED_TIBERCRETE_BRICKS.get());
        this.dropSelf(ModBlocks.WHITE_TIBERCRETE_BRICKS.get());
        this.dropSelf(ModBlocks.YELLOW_TIBERCRETE_BRICKS.get());

        this.dropSelf(ModBlocks.BLACK_TIBERCRETE_WALL.get());
        this.dropSelf(ModBlocks.BLUE_TIBERCRETE_WALL.get());
        this.dropSelf(ModBlocks.BROWN_TIBERCRETE_WALL.get());
        this.dropSelf(ModBlocks.CYAN_TIBERCRETE_WALL.get());
        this.dropSelf(ModBlocks.GRAY_TIBERCRETE_WALL.get());
        this.dropSelf(ModBlocks.GREEN_TIBERCRETE_WALL.get());
        this.dropSelf(ModBlocks.LIGHT_GRAY_TIBERCRETE_WALL.get());
        this.dropSelf(ModBlocks.LIGHT_BLUE_TIBERCRETE_WALL.get());
        this.dropSelf(ModBlocks.LIME_TIBERCRETE_WALL.get());
        this.dropSelf(ModBlocks.MAGENTA_TIBERCRETE_WALL.get());
        this.dropSelf(ModBlocks.ORANGE_TIBERCRETE_WALL.get());
        this.dropSelf(ModBlocks.PINK_TIBERCRETE_WALL.get());
        this.dropSelf(ModBlocks.PURPLE_TIBERCRETE_WALL.get());
        this.dropSelf(ModBlocks.RED_TIBERCRETE_WALL.get());
        this.dropSelf(ModBlocks.WHITE_TIBERCRETE_WALL.get());
        this.dropSelf(ModBlocks.YELLOW_TIBERCRETE_WALL.get());

        this.dropSelf(ModBlocks.BLACK_TIBERCRETE_BRICK_STAIRS.get());
        this.dropSelf(ModBlocks.BLUE_TIBERCRETE_BRICK_STAIRS.get());
        this.dropSelf(ModBlocks.BROWN_TIBERCRETE_BRICK_STAIRS.get());
        this.dropSelf(ModBlocks.CYAN_TIBERCRETE_BRICK_STAIRS.get());
        this.dropSelf(ModBlocks.GRAY_TIBERCRETE_BRICK_STAIRS.get());
        this.dropSelf(ModBlocks.GREEN_TIBERCRETE_BRICK_STAIRS.get());
        this.dropSelf(ModBlocks.LIGHT_GRAY_TIBERCRETE_BRICK_STAIRS.get());
        this.dropSelf(ModBlocks.LIGHT_BLUE_TIBERCRETE_BRICK_STAIRS.get());
        this.dropSelf(ModBlocks.LIME_TIBERCRETE_BRICK_STAIRS.get());
        this.dropSelf(ModBlocks.MAGENTA_TIBERCRETE_BRICK_STAIRS.get());
        this.dropSelf(ModBlocks.ORANGE_TIBERCRETE_BRICK_STAIRS.get());
        this.dropSelf(ModBlocks.PINK_TIBERCRETE_BRICK_STAIRS.get());
        this.dropSelf(ModBlocks.PURPLE_TIBERCRETE_BRICK_STAIRS.get());
        this.dropSelf(ModBlocks.RED_TIBERCRETE_BRICK_STAIRS.get());
        this.dropSelf(ModBlocks.WHITE_TIBERCRETE_BRICK_STAIRS.get());
        this.dropSelf(ModBlocks.YELLOW_TIBERCRETE_BRICK_STAIRS.get());

        this.dropSelf(ModBlocks.BLACK_TIBERCRETE_BRICK_WALL.get());
        this.dropSelf(ModBlocks.BLUE_TIBERCRETE_BRICK_WALL.get());
        this.dropSelf(ModBlocks.BROWN_TIBERCRETE_BRICK_WALL.get());
        this.dropSelf(ModBlocks.CYAN_TIBERCRETE_BRICK_WALL.get());
        this.dropSelf(ModBlocks.GRAY_TIBERCRETE_BRICK_WALL.get());
        this.dropSelf(ModBlocks.GREEN_TIBERCRETE_BRICK_WALL.get());
        this.dropSelf(ModBlocks.LIGHT_GRAY_TIBERCRETE_BRICK_WALL.get());
        this.dropSelf(ModBlocks.LIGHT_BLUE_TIBERCRETE_BRICK_WALL.get());
        this.dropSelf(ModBlocks.LIME_TIBERCRETE_BRICK_WALL.get());
        this.dropSelf(ModBlocks.MAGENTA_TIBERCRETE_BRICK_WALL.get());
        this.dropSelf(ModBlocks.ORANGE_TIBERCRETE_BRICK_WALL.get());
        this.dropSelf(ModBlocks.PINK_TIBERCRETE_BRICK_WALL.get());
        this.dropSelf(ModBlocks.PURPLE_TIBERCRETE_BRICK_WALL.get());
        this.dropSelf(ModBlocks.RED_TIBERCRETE_BRICK_WALL.get());
        this.dropSelf(ModBlocks.WHITE_TIBERCRETE_BRICK_WALL.get());
        this.dropSelf(ModBlocks.YELLOW_TIBERCRETE_BRICK_WALL.get());

        this.dropSelf(ModBlocks.PLAGUED_ANDESITE_STAIRS.get());
        this.dropSelf(ModBlocks.PLAGUED_ANDESITE_WALL.get());
        this.dropSelf(ModBlocks.PLAGUED_STONE_STAIRS.get());
        this.dropSelf(ModBlocks.PLAGUED_STONE_WALL.get());
        this.dropSelf(ModBlocks.PLAGUED_GRANITE_STAIRS.get());
        this.dropSelf(ModBlocks.PLAGUED_GRANITE_WALL.get());
        this.dropSelf(ModBlocks.PLAGUED_DIORITE_STAIRS.get());
        this.dropSelf(ModBlocks.PLAGUED_DIORITE_WALL.get());
        this.dropSelf(ModBlocks.RIPARIUS_STONE_STAIRS.get());
        this.dropSelf(ModBlocks.RIPARIUS_STONE_WALL.get());
        this.dropSelf(ModBlocks.VINIFERA_STONE_STAIRS.get());
        this.dropSelf(ModBlocks.VINIFERA_STONE_WALL.get());
        this.dropSelf(ModBlocks.CRUENTUS_STONE_STAIRS.get());
        this.dropSelf(ModBlocks.CRUENTUS_STONE_WALL.get());
        this.dropSelf(ModBlocks.ABOREUS_STONE_STAIRS.get());
        this.dropSelf(ModBlocks.ABOREUS_STONE_WALL.get());
        this.dropSelf(ModBlocks.RIPARIUS_CRYSTAL_STAIRS.get());
        this.dropSelf(ModBlocks.RIPARIUS_CRYSTAL_WALL.get());
        this.dropSelf(ModBlocks.VINIFERA_CRYSTAL_STAIRS.get());
        this.dropSelf(ModBlocks.VINIFERA_CRYSTAL_WALL.get());
        this.dropSelf(ModBlocks.CRUENTUS_CRYSTAL_STAIRS.get());
        this.dropSelf(ModBlocks.CRUENTUS_CRYSTAL_WALL.get());
        this.dropSelf(ModBlocks.ABOREUS_CRYSTAL_STAIRS.get());
        this.dropSelf(ModBlocks.ABOREUS_CRYSTAL_WALL.get());

        this.dropSelf(ModBlocks.CLEAR_TIBERGLASS.get());
        this.dropSelf(ModBlocks.CLEAR_TIBERGLASS_PANE.get());
        this.dropSelf(ModBlocks.MOSAIC_TIBERGLASS.get());
        this.dropSelf(ModBlocks.MOSAIC_TIBERGLASS_PANE.get());
        this.dropSelf(ModBlocks.GDI_TIBERGLASS.get());
        this.dropSelf(ModBlocks.GDI_TIBERGLASS_PANE.get());
        this.dropSelf(ModBlocks.NOD_TIBERGLASS.get());
        this.dropSelf(ModBlocks.NOD_TIBERGLASS_PANE.get());
        this.dropSelf(ModBlocks.WOLF_TIBERGLASS.get());
        this.dropSelf(ModBlocks.WOLF_TIBERGLASS_PANE.get());
        this.dropSelf(ModBlocks.BLACK_TIBERGLASS.get());
        this.dropSelf(ModBlocks.BLACK_TIBERGLASS_PANE.get());
        this.dropSelf(ModBlocks.BLUE_TIBERGLASS.get());
        this.dropSelf(ModBlocks.BLUE_TIBERGLASS_PANE.get());
        this.dropSelf(ModBlocks.BROWN_TIBERGLASS.get());
        this.dropSelf(ModBlocks.BROWN_TIBERGLASS_PANE.get());
        this.dropSelf(ModBlocks.CYAN_TIBERGLASS.get());
        this.dropSelf(ModBlocks.CYAN_TIBERGLASS_PANE.get());
        this.dropSelf(ModBlocks.GREEN_TIBERGLASS.get());
        this.dropSelf(ModBlocks.GREEN_TIBERGLASS_PANE.get());
        this.dropSelf(ModBlocks.GRAY_TIBERGLASS.get());
        this.dropSelf(ModBlocks.GRAY_TIBERGLASS_PANE.get());
        this.dropSelf(ModBlocks.LIGHT_BLUE_TIBERGLASS.get());
        this.dropSelf(ModBlocks.LIGHT_BLUE_TIBERGLASS_PANE.get());
        this.dropSelf(ModBlocks.LIGHT_GRAY_TIBERGLASS.get());
        this.dropSelf(ModBlocks.LIGHT_GRAY_TIBERGLASS_PANE.get());
        this.dropSelf(ModBlocks.LIME_TIBERGLASS.get());
        this.dropSelf(ModBlocks.LIME_TIBERGLASS_PANE.get());
        this.dropSelf(ModBlocks.MAGENTA_TIBERGLASS.get());
        this.dropSelf(ModBlocks.MAGENTA_TIBERGLASS_PANE.get());
        this.dropSelf(ModBlocks.ORANGE_TIBERGLASS.get());
        this.dropSelf(ModBlocks.ORANGE_TIBERGLASS_PANE.get());
        this.dropSelf(ModBlocks.PINK_TIBERGLASS.get());
        this.dropSelf(ModBlocks.PINK_TIBERGLASS_PANE.get());
        this.dropSelf(ModBlocks.PURPLE_TIBERGLASS.get());
        this.dropSelf(ModBlocks.PURPLE_TIBERGLASS_PANE.get());
        this.dropSelf(ModBlocks.RED_TIBERGLASS.get());
        this.dropSelf(ModBlocks.RED_TIBERGLASS_PANE.get());
        this.dropSelf(ModBlocks.WHITE_TIBERGLASS.get());
        this.dropSelf(ModBlocks.WHITE_TIBERGLASS_PANE.get());
        this.dropSelf(ModBlocks.YELLOW_TIBERGLASS.get());
        this.dropSelf(ModBlocks.YELLOW_TIBERGLASS_PANE.get());

        this.dropSelf(ModBlocks.TIBERIUM_SOIL.get());
        this.dropSelf(ModBlocks.ICHOR_SOIL.get());

        this.dropSelf(ModBlocks.PLAGUED_LOG.get());
        this.dropSelf(ModBlocks.PLAGUED_WOOD.get());
        this.dropSelf(ModBlocks.STRIPPED_PLAGUED_LOG.get());
        this.dropSelf(ModBlocks.STRIPPED_PLAGUED_WOOD.get());

        this.add(ModBlocks.PLAGUED_LEAVES.get(), block -> createLeavesDrops(block, ModBlocks.PLAGUED_SAPLING.get(), NORMAL_LEAVES_SAPLING_CHANCES));

        this.dropSelf(ModBlocks.PLAGUED_STAIRS.get());
        this.dropSelf(ModBlocks.PLAGUED_PLANKS.get());
        this.dropSelf(ModBlocks.PLAGUED_FENCE.get());
        this.dropSelf(ModBlocks.PLAGUED_BUTTON.get());
        this.dropSelf(ModBlocks.PLAGUED_PRESSURE_PLATE.get());
        this.dropSelf(ModBlocks.PLAGUED_TRAPDOOR.get());
        this.dropSelf(ModBlocks.PLAGUED_FENCE_GATE.get());

        this.dropSelf(ModBlocks.FIRESTONE_WALL.get());

        this.dropSelf(ModBlocks.EMBER_OAK_LOG.get());
        this.dropSelf(ModBlocks.EMBER_OAK_WOOD.get());
        this.dropSelf(ModBlocks.STRIPPED_EMBER_OAK_LOG.get());
        this.dropSelf(ModBlocks.STRIPPED_EMBER_OAK_WOOD.get());

        this.add(ModBlocks.EMBER_OAK_LEAVES.get(), block -> createLeavesDrops(block, ModBlocks.EMBER_OAK_SAPLING.get(), NORMAL_LEAVES_SAPLING_CHANCES));
        this.dropSelf(ModBlocks.EMBER_OAK_STAIRS.get());
        this.dropSelf(ModBlocks.EMBER_OAK_PLANKS.get());
        this.dropSelf(ModBlocks.EMBER_OAK_FENCE.get());
        this.dropSelf(ModBlocks.EMBER_OAK_BUTTON.get());
        this.dropSelf(ModBlocks.EMBER_OAK_PRESSURE_PLATE.get());
        this.dropSelf(ModBlocks.EMBER_OAK_TRAPDOOR.get());
        this.dropSelf(ModBlocks.EMBER_OAK_FENCE_GATE.get());

        this.dropSelf(ModBlocks.DEAD_LOG.get());
        this.dropSelf(ModBlocks.DEAD_WOOD.get());
        this.dropSelf(ModBlocks.STRIPPED_DEAD_LOG.get());
        this.dropSelf(ModBlocks.STRIPPED_DEAD_WOOD.get());

        this.add(ModBlocks.DEAD_LEAVES.get(), block -> createLeavesDrops(block, ModBlocks.DYING_SAPLING.get(), NORMAL_LEAVES_SAPLING_CHANCES));
        this.dropSelf(ModBlocks.DEAD_STAIRS.get());
        this.dropSelf(ModBlocks.DEAD_PLANKS.get());
        this.dropSelf(ModBlocks.DEAD_FENCE.get());
        this.dropSelf(ModBlocks.DEAD_BUTTON.get());
        this.dropSelf(ModBlocks.DEAD_PRESSURE_PLATE.get());
        this.dropSelf(ModBlocks.DEAD_TRAPDOOR.get());
        this.dropSelf(ModBlocks.DEAD_FENCE_GATE.get());

        this.dropSelf(ModBlocks.MARIKA_OAK_LOG.get());
        this.dropSelf(ModBlocks.MARIKA_OAK_WOOD.get());
        this.dropSelf(ModBlocks.STRIPPED_MARIKA_OAK_LOG.get());
        this.dropSelf(ModBlocks.STRIPPED_MARIKA_OAK_WOOD.get());

        this.add(ModBlocks.MARIKA_OAK_LEAVES.get(), block -> createLeavesDrops(block, ModBlocks.MARIKA_OAK_SAPLING.get(), NORMAL_LEAVES_SAPLING_CHANCES));
        this.dropSelf(ModBlocks.MARIKA_OAK_STAIRS.get());
        this.dropSelf(ModBlocks.MARIKA_OAK_PLANKS.get());
        this.dropSelf(ModBlocks.MARIKA_OAK_FENCE.get());
        this.dropSelf(ModBlocks.MARIKA_OAK_BUTTON.get());
        this.dropSelf(ModBlocks.MARIKA_OAK_PRESSURE_PLATE.get());
        this.dropSelf(ModBlocks.MARIKA_OAK_TRAPDOOR.get());
        this.dropSelf(ModBlocks.MARIKA_OAK_FENCE_GATE.get());



        this.dropSelf(ModBlocks.INFESTED_COBBLE_WALL.get());
        this.dropSelf(ModBlocks.INFESTED_STONE_BRICK_WALL.get());
        this.dropSelf(ModBlocks.INFESTED_STONE_BRICK_STAIRS.get());
        this.dropSelf(ModBlocks.INFESTED_COBBLE_STAIRS.get());

        this.dropSelf(ModBlocks.HYACINTH.get());
        this.dropSelf(ModBlocks.FLOWER_OF_LIFE.get());
        this.dropSelf(ModBlocks.DEVILS_BLOOD.get());
        this.dropSelf(ModBlocks.SOUND_BLOCK.get());

        this.dropSelf(ModBlocks.TIBERIUM_GRINDER.get());
        this.dropSelf(ModBlocks.TIBERIUM_INFUSER.get());

        this.dropSelf(ModBlocks.PLAGUED_SAPLING.get());
        this.dropSelf(ModBlocks.EMBER_OAK_SAPLING.get());
        this.dropSelf(ModBlocks.MARIKA_OAK_SAPLING.get());
        this.dropSelf(ModBlocks.DYING_SAPLING.get());

        this.dropSelf(ModBlocks.YZ_SANDSTONE.get());
        this.dropSelf(ModBlocks.YZ_SANDSTONE_STAIRS.get());
        this.dropSelf(ModBlocks.YZ_SANDSTONE_WALL.get());

        this.dropSelf(ModBlocks.SMOOTH_YZ_SANDSTONE.get());
        this.dropSelf(ModBlocks.SMOOTH_YZ_SANDSTONE_STAIRS.get());
        this.dropSelf(ModBlocks.CUT_YZ_SANDSTONE.get());
        this.dropSelf(ModBlocks.CHISELED_YZ_SANDSTONE.get());

        this.dropSelf(ModBlocks.RZ_SANDSTONE.get());
        this.dropSelf(ModBlocks.RZ_SANDSTONE_STAIRS.get());
        this.dropSelf(ModBlocks.RZ_SANDSTONE_WALL.get());

        this.dropSelf(ModBlocks.SMOOTH_RZ_SANDSTONE.get());
        this.dropSelf(ModBlocks.SMOOTH_RZ_SANDSTONE_STAIRS.get());
        this.dropSelf(ModBlocks.CUT_RZ_SANDSTONE.get());
        this.dropSelf(ModBlocks.CHISELED_RZ_SANDSTONE.get());

        this.dropSelf(ModBlocks.CS_CHAINLINK.get());
        this.dropSelf(ModBlocks.CS_SCAFFOLD.get());
        this.dropSelf(ModBlocks.CS_SCAFFOLD_STAIRS.get());
        this.dropSelf(ModBlocks.CS_TILE.get());
        this.dropSelf(ModBlocks.CS_TILE_STAIRS.get());
        this.dropSelf(ModBlocks.CS_TILE_WALL.get());
        this.dropSelf(ModBlocks.CS_TILE_G.get());
        this.dropSelf(ModBlocks.CS_TILE_G_BAND.get());
        this.dropSelf(ModBlocks.CS_TILE_G_BAND_STAIRS.get());
        this.dropSelf(ModBlocks.CS_TILE_G_BAND_WALL.get());
        this.dropSelf(ModBlocks.CS_TILE_G_FRAME.get());
        this.dropSelf(ModBlocks.CS_TILE_G_FRAME_WALL.get());
        this.dropSelf(ModBlocks.CS_TILE_G_FRAME_STAIRS.get());
        this.dropSelf(ModBlocks.CS_TILE_B_BAND.get());
        this.dropSelf(ModBlocks.CS_TILE_B_BAND_STAIRS.get());
        this.dropSelf(ModBlocks.CS_TILE_B_BAND_WALL.get());
        this.dropSelf(ModBlocks.CS_TILE_B_FRAME.get());
        this.dropSelf(ModBlocks.CS_TILE_B_FRAME_WALL.get());
        this.dropSelf(ModBlocks.CS_TILE_B_FRAME_STAIRS.get());
        this.dropSelf(ModBlocks.CS_TILE_B.get());
        this.dropSelf(ModBlocks.CS_TILE_R.get());
        this.dropSelf(ModBlocks.CS_TILE_P.get());
        this.dropSelf(ModBlocks.CS_TILE_LG.get());
        this.dropSelf(ModBlocks.CS_TILE_MG.get());
        this.dropSelf(ModBlocks.CS_TILE_HG.get());
        this.dropSelf(ModBlocks.CS_CATWALK_W.get());
        this.dropSelf(ModBlocks.CS_CATWALK_W_STAIRS.get());
        this.dropSelf(ModBlocks.CS_CATWALK_BL.get());
        this.dropSelf(ModBlocks.CS_CATWALK_BL_SLAB.get());
        this.dropSelf(ModBlocks.CS_CATWALK_BL_STAIRS.get());
        this.dropSelf(ModBlocks.CS_CATWALK_B.get());
        this.dropSelf(ModBlocks.CS_CATWALK_B_SLAB.get());
        this.dropSelf(ModBlocks.CS_CATWALK_B_STAIRS.get());
        this.dropSelf(ModBlocks.CS_CATWALK_G.get());
        this.dropSelf(ModBlocks.CS_CATWALK_G_SLAB.get());
        this.dropSelf(ModBlocks.CS_CATWALK_G_STAIRS.get());
        this.dropSelf(ModBlocks.CS_CATWALK_R.get());
        this.dropSelf(ModBlocks.CS_CATWALK_R_SLAB.get());
        this.dropSelf(ModBlocks.CS_CATWALK_R_STAIRS.get());
        this.dropSelf(ModBlocks.CS_CATWALK_P.get());
        this.dropSelf(ModBlocks.CS_CATWALK_P_SLAB.get());
        this.dropSelf(ModBlocks.CS_CATWALK_P_STAIRS.get());
        this.dropSelf(ModBlocks.CS_TILE_BR.get());
        this.dropSelf(ModBlocks.CS_TILE_BR_STAIRS.get());
        this.dropSelf(ModBlocks.CS_TILE_BR_WALL.get());
        this.dropSelf(ModBlocks.CS_TILE_YB.get());
        this.dropSelf(ModBlocks.CS_TILE_YB_STAIRS.get());
        this.dropSelf(ModBlocks.CS_TILE_YB_WALL.get());
        this.dropSelf(ModBlocks.CS_TILE_G_STAIRS.get());
        this.dropSelf(ModBlocks.CS_TILE_G_WALL.get());
        this.dropSelf(ModBlocks.CS_TILE_B_STAIRS.get());
        this.dropSelf(ModBlocks.CS_TILE_R_STAIRS.get());
        this.dropSelf(ModBlocks.CS_TILE_B_WALL.get());
        this.dropSelf(ModBlocks.CS_TILE_R_WALL.get());
        this.dropSelf(ModBlocks.CS_TILE_P_STAIRS.get());
        this.dropSelf(ModBlocks.CS_TILE_P_WALL.get());
        this.dropSelf(ModBlocks.CS_TILE_LG_STAIRS.get());
        this.dropSelf(ModBlocks.CS_TILE_LG_WALL.get());
        this.dropSelf(ModBlocks.CS_TILE_HG_STAIRS.get());
        this.dropSelf(ModBlocks.CS_TILE_HG_WALL.get());
        this.dropSelf(ModBlocks.CS_TILE_MG_STAIRS.get());
        this.dropSelf(ModBlocks.CS_TILE_MG_WALL.get());
        this.dropSelf(ModBlocks.CS_TILE_MG_VERT.get());
        this.dropSelf(ModBlocks.CS_TILE_MG_FRAME_VERT.get());
        this.dropSelf(ModBlocks.CS_TILE_MG_BAND_VERT.get());
        this.dropSelf(ModBlocks.CS_TILE_LG_VERT.get());
        this.dropSelf(ModBlocks.CS_TILE_LG_FRAME_VERT.get());
        this.dropSelf(ModBlocks.CS_TILE_LG_BAND_VERT.get());
        this.dropSelf(ModBlocks.CS_TILE_HG_VERT.get());
        this.dropSelf(ModBlocks.CS_TILE_VERT.get());
        this.dropSelf(ModBlocks.CS_SCAFFOLD_VERT.get());
        this.dropSelf(ModBlocks.CS_CATWALK_W_VERT.get());
        this.dropSelf(ModBlocks.CS_CATWALK_BL_VERT.get());
        this.dropSelf(ModBlocks.CS_CATWALK_G_VERT.get());
        this.dropSelf(ModBlocks.CS_CATWALK_B_VERT.get());
        this.dropSelf(ModBlocks.CS_CATWALK_R_VERT.get());
        this.dropSelf(ModBlocks.CS_CATWALK_P_VERT.get());
        this.dropSelf(ModBlocks.CS_TILE_G_VERT.get());
        this.dropSelf(ModBlocks.CS_TILE_G_FRAME_VERT.get());
        this.dropSelf(ModBlocks.CS_TILE_G_BAND_VERT.get());
        this.dropSelf(ModBlocks.CS_TILE_B_VERT.get());
        this.dropSelf(ModBlocks.CS_TILE_B_FRAME_VERT.get());
        this.dropSelf(ModBlocks.CS_TILE_B_BAND_VERT.get());
        this.dropSelf(ModBlocks.CS_TILE_P_VERT.get());
        this.dropSelf(ModBlocks.CS_TILE_P_FRAME_VERT.get());
        this.dropSelf(ModBlocks.CS_TILE_P_BAND_VERT.get());
        this.dropSelf(ModBlocks.CS_TILE_R_VERT.get());
        this.dropSelf(ModBlocks.CS_TILE_R_FRAME_VERT.get());
        this.dropSelf(ModBlocks.CS_TILE_R_BAND_VERT.get());
        this.dropSelf(ModBlocks.CS_TILE_BR_VERT.get());
        this.dropSelf(ModBlocks.CS_TILE_YB_VERT.get());
        this.dropSelf(ModBlocks.CS_TILE_HG_FRAME_VERT.get());
        this.dropSelf(ModBlocks.CS_TILE_HG_BAND_VERT.get());
        this.dropSelf(ModBlocks.CS_TILE_R_BAND.get());
        this.dropSelf(ModBlocks.CS_TILE_R_BAND_STAIRS.get());
        this.dropSelf(ModBlocks.CS_TILE_R_BAND_WALL.get());
        this.dropSelf(ModBlocks.CS_TILE_R_FRAME.get());
        this.dropSelf(ModBlocks.CS_TILE_R_FRAME_WALL.get());
        this.dropSelf(ModBlocks.CS_TILE_R_FRAME_STAIRS.get());
        this.dropSelf(ModBlocks.CS_TILE_P_BAND.get());
        this.dropSelf(ModBlocks.CS_TILE_P_BAND_STAIRS.get());
        this.dropSelf(ModBlocks.CS_TILE_P_BAND_WALL.get());
        this.dropSelf(ModBlocks.CS_TILE_P_FRAME.get());
        this.dropSelf(ModBlocks.CS_TILE_P_FRAME_WALL.get());
        this.dropSelf(ModBlocks.CS_TILE_P_FRAME_STAIRS.get());
        this.dropSelf(ModBlocks.CS_TILE_LG_BAND.get());
        this.dropSelf(ModBlocks.CS_TILE_LG_BAND_STAIRS.get());
        this.dropSelf(ModBlocks.CS_TILE_LG_BAND_WALL.get());
        this.dropSelf(ModBlocks.CS_TILE_LG_FRAME.get());
        this.dropSelf(ModBlocks.CS_TILE_LG_FRAME_WALL.get());
        this.dropSelf(ModBlocks.CS_TILE_LG_FRAME_STAIRS.get());
        this.dropSelf(ModBlocks.CS_TILE_MG_BAND.get());
        this.dropSelf(ModBlocks.CS_TILE_MG_BAND_STAIRS.get());
        this.dropSelf(ModBlocks.CS_TILE_MG_BAND_WALL.get());
        this.dropSelf(ModBlocks.CS_TILE_MG_FRAME.get());
        this.dropSelf(ModBlocks.CS_TILE_MG_FRAME_WALL.get());
        this.dropSelf(ModBlocks.CS_TILE_MG_FRAME_STAIRS.get());
        this.dropSelf(ModBlocks.CS_TILE_HG_BAND.get());
        this.dropSelf(ModBlocks.CS_TILE_HG_BAND_STAIRS.get());
        this.dropSelf(ModBlocks.CS_TILE_HG_BAND_WALL.get());
        this.dropSelf(ModBlocks.CS_TILE_HG_FRAME.get());
        this.dropSelf(ModBlocks.CS_TILE_HG_FRAME_WALL.get());
        this.dropSelf(ModBlocks.CS_TILE_HG_FRAME_STAIRS.get());

        this.dropSelf(ModBlocks.CS_PILLAR.get());
        this.dropSelf(ModBlocks.CS_PILLAR_G.get());
        this.dropSelf(ModBlocks.CS_PILLAR_G_2.get());
        this.dropSelf(ModBlocks.CS_PILLAR_G_3.get());
        this.dropSelf(ModBlocks.CS_PILLAR_G_4.get());
        this.dropSelf(ModBlocks.CS_PILLAR_B.get());
        this.dropSelf(ModBlocks.CS_PILLAR_B_2.get());
        this.dropSelf(ModBlocks.CS_PILLAR_B_3.get());
        this.dropSelf(ModBlocks.CS_PILLAR_B_4.get());
        this.dropSelf(ModBlocks.CS_PILLAR_R.get());
        this.dropSelf(ModBlocks.CS_PILLAR_R_2.get());
        this.dropSelf(ModBlocks.CS_PILLAR_R_3.get());
        this.dropSelf(ModBlocks.CS_PILLAR_R_4.get());
        this.dropSelf(ModBlocks.CS_PILLAR_P.get());
        this.dropSelf(ModBlocks.CS_PILLAR_P_2.get());
        this.dropSelf(ModBlocks.CS_PILLAR_P_3.get());
        this.dropSelf(ModBlocks.CS_PILLAR_P_4.get());
        this.dropSelf(ModBlocks.CS_PILLAR_LG.get());
        this.dropSelf(ModBlocks.CS_PILLAR_LG_2.get());
        this.dropSelf(ModBlocks.CS_PILLAR_LG_3.get());
        this.dropSelf(ModBlocks.CS_PILLAR_LG_4.get());
        this.dropSelf(ModBlocks.CS_PILLAR_MG.get());
        this.dropSelf(ModBlocks.CS_PILLAR_MG_2.get());
        this.dropSelf(ModBlocks.CS_PILLAR_MG_3.get());
        this.dropSelf(ModBlocks.CS_PILLAR_MG_4.get());
        this.dropSelf(ModBlocks.CS_PILLAR_HG.get());
        this.dropSelf(ModBlocks.CS_PILLAR_HG_2.get());
        this.dropSelf(ModBlocks.CS_PILLAR_HG_3.get());
        this.dropSelf(ModBlocks.CS_PILLAR_HG_4.get());

        this.dropSelf(ModBlocks.CT_PILLAR.get());
        this.dropSelf(ModBlocks.CT_PILLAR_2.get());
        this.dropSelf(ModBlocks.CT_PILLAR_3.get());
        this.dropSelf(ModBlocks.CT_PILLAR_G.get());
        this.dropSelf(ModBlocks.CT_PILLAR_G_2.get());
        this.dropSelf(ModBlocks.CT_PILLAR_B.get());
        this.dropSelf(ModBlocks.CT_PILLAR_B_2.get());
        this.dropSelf(ModBlocks.CT_PILLAR_R.get());
        this.dropSelf(ModBlocks.CT_PILLAR_R_2.get());
        this.dropSelf(ModBlocks.CT_PILLAR_P.get());
        this.dropSelf(ModBlocks.CT_PILLAR_P_2.get());

        this.dropSelf(ModBlocks.CT_PILLAR_TOP.get());
        this.dropSelf(ModBlocks.CT_PILLAR_TOP_VERT.get());
        this.dropSelf(ModBlocks.CT_PILLAR_TOP_G_VERT.get());
        this.dropSelf(ModBlocks.CT_PILLAR_TOP_B_VERT.get());
        this.dropSelf(ModBlocks.CT_PILLAR_TOP_R_VERT.get());
        this.dropSelf(ModBlocks.CT_PILLAR_TOP_P_VERT.get());

        this.dropSelf(ModBlocks.CT_TILE_VERT_2.get());
        this.dropSelf(ModBlocks.CT_TILE_G_VERT_2.get());
        this.dropSelf(ModBlocks.CT_TILE_B_VERT_2.get());
        this.dropSelf(ModBlocks.CT_TILE_R_VERT_2.get());
        this.dropSelf(ModBlocks.CT_TILE_P_VERT_2.get());
        this.dropSelf(ModBlocks.CT_TILE_VERT_3.get());
        this.dropSelf(ModBlocks.CT_TILE_G_VERT_3.get());
        this.dropSelf(ModBlocks.CT_TILE_B_VERT_3.get());
        this.dropSelf(ModBlocks.CT_TILE_R_VERT_3.get());
        this.dropSelf(ModBlocks.CT_TILE_P_VERT_3.get());

        this.dropSelf(ModBlocks.CT_TILE_WALL.get());
        this.dropSelf(ModBlocks.CT_TILE_STAIRS.get());
        this.dropSelf(ModBlocks.CT_PILLAR_TOP_G.get());
        this.dropSelf(ModBlocks.CT_TILE_WALL_G.get());
        this.dropSelf(ModBlocks.CT_TILE_STAIRS_G.get());
        this.dropSelf(ModBlocks.CT_PILLAR_TOP_B.get());
        this.dropSelf(ModBlocks.CT_PILLAR_TOP_R.get());
        this.dropSelf(ModBlocks.CT_PILLAR_TOP_P.get());
        this.dropSelf(ModBlocks.CT_TILE_WALL_B.get());
        this.dropSelf(ModBlocks.CT_TILE_STAIRS_B.get());
        this.dropSelf(ModBlocks.CT_TILE_WALL_R.get());
        this.dropSelf(ModBlocks.CT_TILE_STAIRS_R.get());
        this.dropSelf(ModBlocks.CT_TILE_WALL_P.get());
        this.dropSelf(ModBlocks.CT_TILE_STAIRS_P.get());

        this.dropSelf(ModBlocks.CT_TILE_2.get());
        this.dropSelf(ModBlocks.CT_TILE_G_2.get());
        this.dropSelf(ModBlocks.CT_TILE_B_2.get());
        this.dropSelf(ModBlocks.CT_TILE_R_2.get());
        this.dropSelf(ModBlocks.CT_TILE_P_2.get());
        this.dropSelf(ModBlocks.CT_TILE_WALL_2.get());
        this.dropSelf(ModBlocks.CT_TILE_STAIRS_2.get());
        this.dropSelf(ModBlocks.CT_TILE_WALL_G_2.get());
        this.dropSelf(ModBlocks.CT_TILE_STAIRS_G_2.get());
        this.dropSelf(ModBlocks.CT_TILE_WALL_B_2.get());
        this.dropSelf(ModBlocks.CT_TILE_STAIRS_B_2.get());
        this.dropSelf(ModBlocks.CT_TILE_WALL_R_2.get());
        this.dropSelf(ModBlocks.CT_TILE_STAIRS_R_2.get());
        this.dropSelf(ModBlocks.CT_TILE_WALL_P_2.get());
        this.dropSelf(ModBlocks.CT_TILE_STAIRS_P_2.get());

        this.dropSelf(ModBlocks.CT_TILE_3.get());
        this.dropSelf(ModBlocks.CT_TILE_G_3.get());
        this.dropSelf(ModBlocks.CT_TILE_B_3.get());
        this.dropSelf(ModBlocks.CT_TILE_R_3.get());
        this.dropSelf(ModBlocks.CT_TILE_P_3.get());
        this.dropSelf(ModBlocks.CT_TILE_WALL_3.get());
        this.dropSelf(ModBlocks.CT_TILE_STAIRS_3.get());
        this.dropSelf(ModBlocks.CT_TILE_WALL_G_3.get());
        this.dropSelf(ModBlocks.CT_TILE_STAIRS_G_3.get());
        this.dropSelf(ModBlocks.CT_TILE_WALL_B_3.get());
        this.dropSelf(ModBlocks.CT_TILE_STAIRS_B_3.get());
        this.dropSelf(ModBlocks.CT_TILE_WALL_R_3.get());
        this.dropSelf(ModBlocks.CT_TILE_STAIRS_R_3.get());
        this.dropSelf(ModBlocks.CT_TILE_WALL_P_3.get());
        this.dropSelf(ModBlocks.CT_TILE_STAIRS_P_3.get());




        //End of Self Drops


        //Complex Self Drops
            //Flower Pots:
        this.add(ModBlocks.POTTED_HYACINTH.get(), createPotFlowerItemTable(ModBlocks.HYACINTH.get()));
        this.add(ModBlocks.POTTED_FLOWER_OF_LIFE.get(), createPotFlowerItemTable(ModBlocks.FLOWER_OF_LIFE.get()));
        this.add(ModBlocks.POTTED_DEVILS_BLOOD.get(), createPotFlowerItemTable(ModBlocks.DEVILS_BLOOD.get()));
        this.add(ModBlocks.POTTED_FULGURBLOOM.get(), createPotFlowerItemTable(ModBlocks.FULGURBLOOM.get()));
        this.add(ModBlocks.POTTED_SPITFIRE.get(), createPotFlowerItemTable(ModBlocks.SPITFIRE.get()));
        this.add(ModBlocks.POTTED_VITRIC_BLOOM.get(), createPotFlowerItemTable(ModBlocks.VITRIC_BLOOM.get()));

        //Slabs:
        this.add(ModBlocks.PLAGUED_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.PLAGUED_SLAB.get()));

        this.add(ModBlocks.VITRIC_DEEPSLATE_BRICK_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.VITRIC_DEEPSLATE_BRICK_SLAB.get()));

        this.add(ModBlocks.VITRIC_DEEPSLATE_TILE_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.VITRIC_DEEPSLATE_TILE_SLAB.get()));

        this.add(ModBlocks.EMBER_OAK_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.EMBER_OAK_SLAB.get()));
        this.add(ModBlocks.DEAD_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.DEAD_SLAB.get()));
        this.add(ModBlocks.MARIKA_OAK_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.MARIKA_OAK_SLAB.get()));
        this.add(ModBlocks.INFESTED_STONE_BRICK_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.INFESTED_STONE_BRICK_SLAB.get()));
        this.add(ModBlocks.INFESTED_COBBLE_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.INFESTED_COBBLE_SLAB.get()));

        this.add(ModBlocks.BLACK_TIBERCRETE_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.BLACK_TIBERCRETE_SLAB.get()));
        this.add(ModBlocks.BLUE_TIBERCRETE_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.BLUE_TIBERCRETE_SLAB.get()));
        this.add(ModBlocks.BROWN_TIBERCRETE_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.BROWN_TIBERCRETE_SLAB.get()));
        this.add(ModBlocks.CYAN_TIBERCRETE_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.CYAN_TIBERCRETE_SLAB.get()));
        this.add(ModBlocks.GRAY_TIBERCRETE_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.GRAY_TIBERCRETE_SLAB.get()));
        this.add(ModBlocks.GREEN_TIBERCRETE_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.GREEN_TIBERCRETE_SLAB.get()));
        this.add(ModBlocks.LIGHT_BLUE_TIBERCRETE_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.LIGHT_BLUE_TIBERCRETE_SLAB.get()));
        this.add(ModBlocks.LIGHT_GRAY_TIBERCRETE_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.LIGHT_GRAY_TIBERCRETE_SLAB.get()));
        this.add(ModBlocks.LIME_TIBERCRETE_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.LIME_TIBERCRETE_SLAB.get()));
        this.add(ModBlocks.MAGENTA_TIBERCRETE_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.MAGENTA_TIBERCRETE_SLAB.get()));
        this.add(ModBlocks.ORANGE_TIBERCRETE_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.ORANGE_TIBERCRETE_SLAB.get()));
        this.add(ModBlocks.PINK_TIBERCRETE_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.PINK_TIBERCRETE_SLAB.get()));
        this.add(ModBlocks.PURPLE_TIBERCRETE_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.PURPLE_TIBERCRETE_SLAB.get()));
        this.add(ModBlocks.RED_TIBERCRETE_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.RED_TIBERCRETE_SLAB.get()));
        this.add(ModBlocks.WHITE_TIBERCRETE_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.WHITE_TIBERCRETE_SLAB.get()));
        this.add(ModBlocks.YELLOW_TIBERCRETE_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.YELLOW_TIBERCRETE_SLAB.get()));

        this.add(ModBlocks.BLACK_TIBERCRETE_BRICK_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.BLACK_TIBERCRETE_BRICK_SLAB.get()));
        this.add(ModBlocks.BLUE_TIBERCRETE_BRICK_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.BLUE_TIBERCRETE_BRICK_SLAB.get()));
        this.add(ModBlocks.BROWN_TIBERCRETE_BRICK_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.BROWN_TIBERCRETE_BRICK_SLAB.get()));
        this.add(ModBlocks.CYAN_TIBERCRETE_BRICK_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.CYAN_TIBERCRETE_BRICK_SLAB.get()));
        this.add(ModBlocks.GRAY_TIBERCRETE_BRICK_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.GRAY_TIBERCRETE_BRICK_SLAB.get()));
        this.add(ModBlocks.GREEN_TIBERCRETE_BRICK_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.GREEN_TIBERCRETE_BRICK_SLAB.get()));
        this.add(ModBlocks.LIGHT_BLUE_TIBERCRETE_BRICK_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.LIGHT_BLUE_TIBERCRETE_BRICK_SLAB.get()));
        this.add(ModBlocks.LIGHT_GRAY_TIBERCRETE_BRICK_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.LIGHT_GRAY_TIBERCRETE_BRICK_SLAB.get()));
        this.add(ModBlocks.LIME_TIBERCRETE_BRICK_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.LIME_TIBERCRETE_BRICK_SLAB.get()));
        this.add(ModBlocks.MAGENTA_TIBERCRETE_BRICK_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.MAGENTA_TIBERCRETE_BRICK_SLAB.get()));
        this.add(ModBlocks.ORANGE_TIBERCRETE_BRICK_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.ORANGE_TIBERCRETE_BRICK_SLAB.get()));
        this.add(ModBlocks.PINK_TIBERCRETE_BRICK_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.PINK_TIBERCRETE_BRICK_SLAB.get()));
        this.add(ModBlocks.PURPLE_TIBERCRETE_BRICK_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.PURPLE_TIBERCRETE_BRICK_SLAB.get()));
        this.add(ModBlocks.RED_TIBERCRETE_BRICK_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.RED_TIBERCRETE_BRICK_SLAB.get()));
        this.add(ModBlocks.WHITE_TIBERCRETE_BRICK_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.WHITE_TIBERCRETE_BRICK_SLAB.get()));
        this.add(ModBlocks.YELLOW_TIBERCRETE_BRICK_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.YELLOW_TIBERCRETE_BRICK_SLAB.get()));

        this.add(ModBlocks.RIPARIUS_STONE_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.RIPARIUS_STONE_SLAB.get()));
        this.add(ModBlocks.RIPARIUS_STONE_BRICK_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.RIPARIUS_STONE_BRICK_SLAB.get()));
        this.add(ModBlocks.VINIFERA_STONE_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.VINIFERA_STONE_SLAB.get()));
        this.add(ModBlocks.VINIFERA_STONE_BRICK_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.VINIFERA_STONE_BRICK_SLAB.get()));
        this.add(ModBlocks.CRUENTUS_STONE_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.CRUENTUS_STONE_SLAB.get()));
        this.add(ModBlocks.CRUENTUS_STONE_BRICK_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.CRUENTUS_STONE_BRICK_SLAB.get()));
        this.add(ModBlocks.ABOREUS_STONE_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.ABOREUS_STONE_SLAB.get()));
        this.add(ModBlocks.ABOREUS_STONE_BRICK_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.ABOREUS_STONE_BRICK_SLAB.get()));

        this.add(ModBlocks.RIPARIUS_CRYSTAL_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.RIPARIUS_CRYSTAL_SLAB.get()));
        this.add(ModBlocks.VINIFERA_CRYSTAL_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.VINIFERA_CRYSTAL_SLAB.get()));
        this.add(ModBlocks.CRUENTUS_CRYSTAL_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.CRUENTUS_CRYSTAL_SLAB.get()));
        this.add(ModBlocks.ABOREUS_CRYSTAL_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.ABOREUS_CRYSTAL_SLAB.get()));

        this.add(ModBlocks.PLAGUED_ANDESITE_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.PLAGUED_ANDESITE_SLAB.get()));
        this.add(ModBlocks.PLAGUED_STONE_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.PLAGUED_STONE_SLAB.get()));
        this.add(ModBlocks.PLAGUED_GRANITE_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.PLAGUED_GRANITE_SLAB.get()));
        this.add(ModBlocks.PLAGUED_DIORITE_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.PLAGUED_DIORITE_SLAB.get()));

        this.add(ModBlocks.YZ_SANDSTONE_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.YZ_SANDSTONE_SLAB.get()));
        this.add(ModBlocks.SMOOTH_YZ_SANDSTONE_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.SMOOTH_YZ_SANDSTONE_SLAB.get()));
        this.add(ModBlocks.CUT_YZ_SANDSTONE_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.CUT_YZ_SANDSTONE_SLAB.get()));

        this.add(ModBlocks.RZ_SANDSTONE_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.RZ_SANDSTONE_SLAB.get()));
        this.add(ModBlocks.SMOOTH_RZ_SANDSTONE_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.SMOOTH_RZ_SANDSTONE_SLAB.get()));
        this.add(ModBlocks.CUT_RZ_SANDSTONE_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.CUT_RZ_SANDSTONE_SLAB.get()));

        this.add(ModBlocks.CS_SCAFFOLD_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.CS_SCAFFOLD_SLAB.get()));

        this.add(ModBlocks.CS_CATWALK_W_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.CS_CATWALK_W_SLAB.get()));

        this.add(ModBlocks.CS_CATWALK_BL_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.CS_CATWALK_BL_SLAB.get()));

        this.add(ModBlocks.CS_CATWALK_B_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.CS_CATWALK_B_SLAB.get()));

        this.add(ModBlocks.CS_CATWALK_G_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.CS_CATWALK_G_SLAB.get()));

        this.add(ModBlocks.CS_CATWALK_R_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.CS_CATWALK_R_SLAB.get()));

        this.add(ModBlocks.CS_CATWALK_P_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.CS_CATWALK_P_SLAB.get()));

        this.add(ModBlocks.CS_TILE_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.CS_TILE_SLAB.get()));

        this.add(ModBlocks.CS_TILE_BR_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.CS_TILE_BR_SLAB.get()));

        this.add(ModBlocks.CS_TILE_YB_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.CS_TILE_YB_SLAB.get()));

        this.add(ModBlocks.CS_TILE_G_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.CS_TILE_G_SLAB.get()));

        this.add(ModBlocks.CS_TILE_G_BAND_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.CS_TILE_G_BAND_SLAB.get()));

        this.add(ModBlocks.CS_TILE_G_FRAME_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.CS_TILE_G_FRAME_SLAB.get()));

        this.add(ModBlocks.CS_TILE_B_BAND_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.CS_TILE_B_BAND_SLAB.get()));

        this.add(ModBlocks.CS_TILE_B_FRAME_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.CS_TILE_B_FRAME_SLAB.get()));

        this.add(ModBlocks.CS_TILE_R_BAND_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.CS_TILE_R_BAND_SLAB.get()));

        this.add(ModBlocks.CS_TILE_R_FRAME_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.CS_TILE_R_FRAME_SLAB.get()));

        this.add(ModBlocks.CS_TILE_P_BAND_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.CS_TILE_P_BAND_SLAB.get()));

        this.add(ModBlocks.CS_TILE_P_FRAME_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.CS_TILE_P_FRAME_SLAB.get()));

        this.add(ModBlocks.CS_TILE_LG_BAND_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.CS_TILE_LG_BAND_SLAB.get()));

        this.add(ModBlocks.CS_TILE_LG_FRAME_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.CS_TILE_LG_FRAME_SLAB.get()));

        this.add(ModBlocks.CS_TILE_MG_BAND_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.CS_TILE_MG_BAND_SLAB.get()));

        this.add(ModBlocks.CS_TILE_MG_FRAME_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.CS_TILE_MG_FRAME_SLAB.get()));

        this.add(ModBlocks.CS_TILE_HG_BAND_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.CS_TILE_HG_BAND_SLAB.get()));

        this.add(ModBlocks.CS_TILE_HG_FRAME_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.CS_TILE_HG_FRAME_SLAB.get()));

        this.add(ModBlocks.CS_TILE_B_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.CS_TILE_B_SLAB.get()));

        this.add(ModBlocks.CS_TILE_R_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.CS_TILE_R_SLAB.get()));

        this.add(ModBlocks.CS_TILE_P_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.CS_TILE_P_SLAB.get()));

        this.add(ModBlocks.CS_TILE_LG_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.CS_TILE_LG_SLAB.get()));

        this.add(ModBlocks.CS_TILE_MG_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.CS_TILE_MG_SLAB.get()));

        this.add(ModBlocks.CS_TILE_HG_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.CS_TILE_HG_SLAB.get()));

        this.add(ModBlocks.CT_TILE_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.CT_TILE_SLAB.get()));

        this.add(ModBlocks.CT_TILE_SLAB_G.get(),
                block -> createSlabItemTable(ModBlocks.CT_TILE_SLAB_G.get()));

        this.add(ModBlocks.CT_TILE_SLAB_P.get(),
                block -> createSlabItemTable(ModBlocks.CT_TILE_SLAB_P.get()));

        this.add(ModBlocks.CT_TILE_SLAB_R.get(),
                block -> createSlabItemTable(ModBlocks.CT_TILE_SLAB_R.get()));

        this.add(ModBlocks.CT_TILE_SLAB_B.get(),
                block -> createSlabItemTable(ModBlocks.CT_TILE_SLAB_B.get()));

        this.add(ModBlocks.CT_TILE_SLAB_2.get(),
                block -> createSlabItemTable(ModBlocks.CT_TILE_SLAB_2.get()));

        this.add(ModBlocks.CT_TILE_SLAB_G_2.get(),
                block -> createSlabItemTable(ModBlocks.CT_TILE_SLAB_G_2.get()));

        this.add(ModBlocks.CT_TILE_SLAB_P_2.get(),
                block -> createSlabItemTable(ModBlocks.CT_TILE_SLAB_P_2.get()));

        this.add(ModBlocks.CT_TILE_SLAB_R_2.get(),
                block -> createSlabItemTable(ModBlocks.CT_TILE_SLAB_R_2.get()));

        this.add(ModBlocks.CT_TILE_SLAB_B_2.get(),
                block -> createSlabItemTable(ModBlocks.CT_TILE_SLAB_B_2.get()));

        this.add(ModBlocks.CT_TILE_SLAB_3.get(),
                block -> createSlabItemTable(ModBlocks.CT_TILE_SLAB_3.get()));

        this.add(ModBlocks.CT_TILE_SLAB_G_3.get(),
                block -> createSlabItemTable(ModBlocks.CT_TILE_SLAB_G_3.get()));

        this.add(ModBlocks.CT_TILE_SLAB_P_3.get(),
                block -> createSlabItemTable(ModBlocks.CT_TILE_SLAB_P_3.get()));

        this.add(ModBlocks.CT_TILE_SLAB_R_3.get(),
                block -> createSlabItemTable(ModBlocks.CT_TILE_SLAB_R_3.get()));

        this.add(ModBlocks.CT_TILE_SLAB_B_3.get(),
                block -> createSlabItemTable(ModBlocks.CT_TILE_SLAB_B_3.get()));

        //Doors:

        this.add(ModBlocks.PLAGUED_DOOR.get(),
                block -> createDoorTable(ModBlocks.PLAGUED_DOOR.get()));

        this.add(ModBlocks.EMBER_OAK_DOOR.get(),
                block -> createDoorTable(ModBlocks.EMBER_OAK_DOOR.get()));

        this.add(ModBlocks.DEAD_DOOR.get(),
                block -> createDoorTable(ModBlocks.DEAD_DOOR.get()));

        this.add(ModBlocks.MARIKA_OAK_DOOR.get(),
                block -> createDoorTable(ModBlocks.MARIKA_OAK_DOOR.get()));


        //Signs:
        this.add(ModBlocks.PLAGUED_SIGN.get(), block -> createSingleItemTable(ModItems.PLAGUED_SIGN.get()));
        this.add(ModBlocks.PLAGUED_WALL_SIGN.get(), block -> createSingleItemTable(ModItems.PLAGUED_SIGN.get()));
        this.add(ModBlocks.PLAGUED_HANGING_SIGN.get(), block -> createSingleItemTable(ModItems.PLAGUED_HANGING_SIGN.get()));
        this.add(ModBlocks.PLAGUED_WALL_HANGING_SIGN.get(), block -> createSingleItemTable(ModItems.PLAGUED_HANGING_SIGN.get()));

        this.add(ModBlocks.DEAD_SIGN.get(), block -> createSingleItemTable(ModItems.DEAD_SIGN.get()));
        this.add(ModBlocks.DEAD_WALL_SIGN.get(), block -> createSingleItemTable(ModItems.DEAD_SIGN.get()));
        this.add(ModBlocks.DEAD_HANGING_SIGN.get(), block -> createSingleItemTable(ModItems.DEAD_HANGING_SIGN.get()));
        this.add(ModBlocks.DEAD_WALL_HANGING_SIGN.get(), block -> createSingleItemTable(ModItems.DEAD_HANGING_SIGN.get()));

        this.add(ModBlocks.EMBER_OAK_SIGN.get(), block -> createSingleItemTable(ModItems.EMBER_OAK_SIGN.get()));
        this.add(ModBlocks.EMBER_OAK_WALL_SIGN.get(), block -> createSingleItemTable(ModItems.EMBER_OAK_SIGN.get()));
        this.add(ModBlocks.EMBER_OAK_HANGING_SIGN.get(), block -> createSingleItemTable(ModItems.EMBER_OAK_HANGING_SIGN.get()));
        this.add(ModBlocks.EMBER_OAK_WALL_HANGING_SIGN.get(), block -> createSingleItemTable(ModItems.EMBER_OAK_HANGING_SIGN.get()));

        this.add(ModBlocks.MARIKA_OAK_SIGN.get(), block -> createSingleItemTable(ModItems.MARIKA_OAK_SIGN.get()));
        this.add(ModBlocks.MARIKA_OAK_WALL_SIGN.get(), block -> createSingleItemTable(ModItems.MARIKA_OAK_SIGN.get()));
        this.add(ModBlocks.MARIKA_OAK_HANGING_SIGN.get(), block -> createSingleItemTable(ModItems.MARIKA_OAK_HANGING_SIGN.get()));
        this.add(ModBlocks.MARIKA_OAK_WALL_HANGING_SIGN.get(), block -> createSingleItemTable(ModItems.MARIKA_OAK_HANGING_SIGN.get()));

        //End of Complex Self Drops


        //Ore Drops:
        this.add(ModBlocks.LAI_MELON.get(),
                block -> createModGemOreDrops(ModBlocks.LAI_MELON.get(), ModItems.LAI_MELON_SLICE.get()));

        this.add(ModBlocks.AERIES_ORE.get(),
                block -> createModGemOreDrops(ModBlocks.AERIES_ORE.get(), ModItems.AERIES_CRYSTAL.get()));

        this.add(ModBlocks.DEEPSLATE_AERIES_ORE.get(),
                block -> createModGemOreDrops(ModBlocks.DEEPSLATE_AERIES_ORE.get(), ModItems.AERIES_CRYSTAL.get()));

        this.add(ModBlocks.NETHER_AERIES_ORE.get(),
                block -> createModGemOreDrops(ModBlocks.NETHER_AERIES_ORE.get(), ModItems.AERIES_CRYSTAL.get()));

        this.add(ModBlocks.KRYON_ORE.get(),
                block -> createModGemOreDrops(ModBlocks.KRYON_ORE.get(), ModItems.KRYON_CRYSTAL.get()));

        this.add(ModBlocks.DEEPSLATE_KRYON_ORE.get(),
                block -> createModGemOreDrops(ModBlocks.DEEPSLATE_KRYON_ORE.get(), ModItems.KRYON_CRYSTAL.get()));

        this.add(ModBlocks.NETHER_KRYON_ORE.get(),
                block -> createModGemOreDrops(ModBlocks.NETHER_KRYON_ORE.get(), ModItems.KRYON_CRYSTAL.get()));

        this.add(ModBlocks.END_KRYON_ORE.get(),
                block -> createModGemOreDrops(ModBlocks.END_KRYON_ORE.get(), ModItems.KRYON_CRYSTAL.get()));

        this.add(ModBlocks.ILLUMINA_ORE.get(),
                block -> createModGemOreDrops(ModBlocks.ILLUMINA_ORE.get(), ModItems.ILLUMINA_CRYSTAL.get()));

        this.add(ModBlocks.DEEPSLATE_ILLUMINA_ORE.get(),
                block -> createModGemOreDrops(ModBlocks.DEEPSLATE_ILLUMINA_ORE.get(), ModItems.ILLUMINA_CRYSTAL.get()));

        this.add(ModBlocks.ENIGMA_ORE.get(),
                block -> createModGemOreDrops(ModBlocks.ENIGMA_ORE.get(), ModItems.ENIGMA_CRYSTAL.get()));

        this.add(ModBlocks.DEEPSLATE_ENIGMA_ORE.get(),
                block -> createModGemOreDrops(ModBlocks.DEEPSLATE_ENIGMA_ORE.get(), ModItems.ENIGMA_CRYSTAL.get()));

        this.add(ModBlocks.END_ENIGMA_ORE.get(),
                block -> createModGemOreDrops(ModBlocks.END_ENIGMA_ORE.get(), ModItems.ENIGMA_CRYSTAL.get()));

        this.add(ModBlocks.GUNDANIUM_ORE.get(),
                block -> createModOreDrops(ModBlocks.GUNDANIUM_ORE.get(), ModItems.RAW_GUNDANIUM.get()));

        this.add(ModBlocks.DEEPSLATE_GUNDANIUM_ORE.get(),
                block -> createModOreDrops(ModBlocks.DEEPSLATE_GUNDANIUM_ORE.get(), ModItems.RAW_GUNDANIUM.get()));

        this.add(ModBlocks.ALYTHUM_ORE.get(),
                block -> createModOreDrops(ModBlocks.ALYTHUM_ORE.get(), ModItems.RAW_ALYTHUM.get()));

        this.add(ModBlocks.DEEPSLATE_ALYTHUM_ORE.get(),
                block -> createModOreDrops(ModBlocks.DEEPSLATE_ALYTHUM_ORE.get(), ModItems.RAW_ALYTHUM.get()));

        this.add(ModBlocks.NETHER_ALYTHUM_ORE.get(),
                block -> createModOreDrops(ModBlocks.NETHER_ALYTHUM_ORE.get(), ModItems.RAW_ALYTHUM.get()));

        this.add(ModBlocks.QUALRITE_ORE.get(),
                block -> createModOreDrops(ModBlocks.QUALRITE_ORE.get(), ModItems.RAW_QUALRITE.get()));

        this.add(ModBlocks.DEEPSLATE_QUALRITE_ORE.get(),
                block -> createModOreDrops(ModBlocks.DEEPSLATE_QUALRITE_ORE.get(), ModItems.RAW_QUALRITE.get()));

        this.add(ModBlocks.NETHER_QUALRITE_ORE.get(),
                block -> createModOreDrops(ModBlocks.NETHER_QUALRITE_ORE.get(), ModItems.RAW_QUALRITE.get()));

        //End of Ore Drops


        //Crops Handling
        LootItemCondition.Builder lootitemcondition$builder = LootItemBlockStatePropertyCondition
                .hasBlockStateProperties(ModBlocks.HEIM_BERRY_CROP.get())
                .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(HelFruitCropBlock.AGE, 5));

        this.add(ModBlocks.HEIM_BERRY_CROP.get(), createCropDrops(ModBlocks.HEIM_BERRY_CROP.get(), ModItems.HEIM_BERRY.get(),
                ModItems.HEIM_BERRY_SEEDS.get(), lootitemcondition$builder));

        LootItemCondition.Builder lootitemcondition$builder7 = LootItemBlockStatePropertyCondition
                .hasBlockStateProperties(ModBlocks.HEL_FRUIT_CROP.get())
                .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(HelFruitCropBlock.AGE, 5));

        this.add(ModBlocks.HEL_FRUIT_CROP.get(), createCropDrops(ModBlocks.HEL_FRUIT_CROP.get(), ModItems.HEL_FRUIT.get(),
                ModItems.HEL_FRUIT_SEEDS.get(), lootitemcondition$builder7));

        LootItemCondition.Builder lootitemcondition$builder8 = LootItemBlockStatePropertyCondition
                .hasBlockStateProperties(ModBlocks.LAI_MELON_STEM.get())
                .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(StemBlock.AGE, 7));

        this.add(ModBlocks.LAI_MELON_STEM.get(), createCropDrops(ModBlocks.LAI_MELON_STEM.get(), ModItems.LAI_MELON_SEEDS.get(),
                ModItems.LAI_MELON_SEEDS.get(), lootitemcondition$builder8));

        this.add(ModBlocks.ATTACHED_LAI_MELON_STEM.get(), createCropDrops(ModBlocks.ATTACHED_LAI_MELON_STEM.get(), ModItems.LAI_MELON_SEEDS.get(),
                ModItems.LAI_MELON_SEEDS.get(), lootitemcondition$builder8));


//        LootItemCondition.Builder lootitemcondition$builder2 = LootItemBlockStatePropertyCondition
//                .hasBlockStateProperties(ModBlocks.CORN_CROP.get())
//                .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(CornCropBlock.AGE, 7))
//                .or(LootItemBlockStatePropertyCondition
//                        .hasBlockStateProperties(ModBlocks.CORN_CROP.get())
//                        .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(CornCropBlock.AGE, 8)));

         LootItemCondition.Builder lootitemcondition$builder2 = LootItemBlockStatePropertyCondition
                 .hasBlockStateProperties(ModBlocks.SABER_CORN_CROP.get())
                 .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(SaberCornCropBlock.AGE, 8));

        this.add(ModBlocks.SABER_CORN_CROP.get(), createCropDrops(ModBlocks.SABER_CORN_CROP.get(), ModItems.SABER_CORN.get(),
                ModItems.SABER_CORN_SEEDS.get(), lootitemcondition$builder2));


        LootItemCondition.Builder lootitemcondition$builder3 = LootItemBlockStatePropertyCondition
                .hasBlockStateProperties(ModBlocks.GREEN_TIBERIUM_CROP.get())
                .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(GreenTiberiumCrystalBlock.AGE, 7));

        this.add(ModBlocks.GREEN_TIBERIUM_CROP.get(), createCropDrops(ModBlocks.GREEN_TIBERIUM_CROP.get(), ModItems.TIBERIUM.get(),
                ModItems.GREEN_TIBERIUM_DUST.get(), lootitemcondition$builder3));


        LootItemCondition.Builder lootitemcondition$builder4 = LootItemBlockStatePropertyCondition
                .hasBlockStateProperties(ModBlocks.BLUE_TIBERIUM_CROP.get())
                .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(BlueTiberiumCrystalBlock.AGE, 7));

        this.add(ModBlocks.BLUE_TIBERIUM_CROP.get(), createCropDrops(ModBlocks.BLUE_TIBERIUM_CROP.get(), ModItems.TIBERIUM_BLUE.get(),
                ModItems.BLUE_TIBERIUM_DUST.get(), lootitemcondition$builder4));

        LootItemCondition.Builder lootitemcondition$builder5 = LootItemBlockStatePropertyCondition
                .hasBlockStateProperties(ModBlocks.RED_TIBERIUM_CROP.get())
                .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(RedTiberiumCrystalBlock.AGE, 7));

        this.add(ModBlocks.RED_TIBERIUM_CROP.get(), createCropDrops(ModBlocks.RED_TIBERIUM_CROP.get(), ModItems.TIBERIUM_RED.get(),
                ModItems.RED_TIBERIUM_DUST.get(), lootitemcondition$builder5));


        LootItemCondition.Builder lootitemcondition$builder6 = LootItemBlockStatePropertyCondition
                .hasBlockStateProperties(ModBlocks.PURPLE_TIBERIUM_CROP.get())
                .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(PurpleTiberiumCrystalBlock.AGE, 7));

        this.add(ModBlocks.PURPLE_TIBERIUM_CROP.get(), createCropDrops(ModBlocks.PURPLE_TIBERIUM_CROP.get(), ModItems.TIBERIUM_PURPLE.get(),
                ModItems.PURPLE_TIBERIUM_DUST.get(), lootitemcondition$builder6));

    }


    //End of Crops Handling







    protected LootTable.Builder createModGemOreDrops(Block pBlock, Item item) {
        return createSilkTouchDispatchTable(pBlock,
                this.applyExplosionDecay(pBlock,
                        LootItem.lootTableItem(item)
                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0F, 3.0F)))
                                .apply(ApplyBonusCount.addOreBonusCount(Enchantments.BLOCK_FORTUNE))));
    }

    protected LootTable.Builder createModOreDrops(Block pBlock, Item item) {
        return createSilkTouchDispatchTable(pBlock,
                this.applyExplosionDecay(pBlock,
                        LootItem.lootTableItem(item)
                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(2.0F, 5.0F)))
                                .apply(ApplyBonusCount.addOreBonusCount(Enchantments.BLOCK_FORTUNE))));
    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return ModBlocks.BLOCKS.getEntries().stream().map(RegistryObject::get)::iterator;
    }
}
