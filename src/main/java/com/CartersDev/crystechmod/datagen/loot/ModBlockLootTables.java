package com.CartersDev.crystechmod.datagen.loot;


import com.CartersDev.crystechmod.block.ModBlocks;
import com.CartersDev.crystechmod.item.ModItems;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.ApplyBonusCount;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
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
        this.dropSelf(ModBlocks.TIBERIUM_BLOCK.get());
        this.dropSelf(ModBlocks.TIBERIUM_BLUE_BLOCK.get());
        this.dropSelf(ModBlocks.TIBERIUM_RED_BLOCK.get());
        this.dropSelf(ModBlocks.TIBERIUM_PURPLE_BLOCK.get());

        this.dropSelf(ModBlocks.AERIES_BLOCK.get());
        this.dropSelf(ModBlocks.ENIGMA_BLOCK.get());
        this.dropSelf(ModBlocks.ILLUMINA_BLOCK.get());
        this.dropSelf(ModBlocks.KRYON_BLOCK.get());

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
        this.dropSelf(ModBlocks.VINIFERA_STONE.get());
        this.dropSelf(ModBlocks.CRUENTUS_STONE.get());
        this.dropSelf(ModBlocks.ABOREUS_STONE.get());

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

        this.dropSelf(ModBlocks.PLAGUED_STAIRS.get());
        this.dropSelf(ModBlocks.PLAGUED_PLANKS.get());
        this.dropSelf(ModBlocks.PLAGUED_FENCE.get());
        this.dropSelf(ModBlocks.PLAGUED_BUTTON.get());
        this.dropSelf(ModBlocks.PLAGUED_PRESSURE_PLATE.get());
        this.dropSelf(ModBlocks.PLAGUED_TRAPDOOR.get());
        this.dropSelf(ModBlocks.PLAGUED_FENCE_GATE.get());
        this.dropSelf(ModBlocks.FIRESTONE_WALL.get());

        this.dropSelf(ModBlocks.INFESTED_STONE_BRICK_STAIRS.get());
        this.dropSelf(ModBlocks.INFESTED_COBBLE_STAIRS.get());

        this.add(ModBlocks.PLAGUED_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.PLAGUED_SLAB.get()));

        this.add(ModBlocks.INFESTED_STONE_BRICK_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.INFESTED_STONE_BRICK_SLAB.get()));

        this.add(ModBlocks.INFESTED_COBBLE_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.INFESTED_COBBLE_SLAB.get()));

        this.add(ModBlocks.PLAGUED_DOOR.get(),
                block -> createDoorTable(ModBlocks.PLAGUED_DOOR.get()));


        //Ore Drops:
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


    }


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
