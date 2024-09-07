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
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.ApplyBonusCount;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.predicates.LootItemBlockStatePropertyCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;
import net.minecraftforge.fml.common.Mod;
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
        this.dropSelf(ModBlocks.NOD_CREST_LARGE.get());
        this.dropSelf(ModBlocks.YOKARAN_BLOOM.get());



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
        this.dropSelf(ModBlocks.EMBER_OAK_STAIRS.get());
        this.dropSelf(ModBlocks.EMBER_OAK_PLANKS.get());
        this.dropSelf(ModBlocks.EMBER_OAK_FENCE.get());
        this.dropSelf(ModBlocks.EMBER_OAK_BUTTON.get());
        this.dropSelf(ModBlocks.EMBER_OAK_PRESSURE_PLATE.get());
        this.dropSelf(ModBlocks.EMBER_OAK_TRAPDOOR.get());
        this.dropSelf(ModBlocks.EMBER_OAK_FENCE_GATE.get());
        this.dropSelf(ModBlocks.INFESTED_COBBLE_WALL.get());
        this.dropSelf(ModBlocks.INFESTED_STONE_BRICK_WALL.get());


        this.dropSelf(ModBlocks.INFESTED_STONE_BRICK_STAIRS.get());
        this.dropSelf(ModBlocks.INFESTED_COBBLE_STAIRS.get());

        this.dropSelf(ModBlocks.HYACINTH.get());
        this.dropSelf(ModBlocks.FLOWER_OF_LIFE.get());
        this.dropSelf(ModBlocks.DEVILS_BLOOD.get());
        this.dropSelf(ModBlocks.SOUND_BLOCK.get());

        this.dropSelf(ModBlocks.TIBERIUM_GRINDER.get());

        //End of Self Drops


        //Complex Self Drops

        this.add(ModBlocks.POTTED_HYACINTH.get(), createPotFlowerItemTable(ModBlocks.HYACINTH.get()));
        this.add(ModBlocks.POTTED_FLOWER_OF_LIFE.get(), createPotFlowerItemTable(ModBlocks.FLOWER_OF_LIFE.get()));
        this.add(ModBlocks.POTTED_DEVILS_BLOOD.get(), createPotFlowerItemTable(ModBlocks.DEVILS_BLOOD.get()));

        this.add(ModBlocks.PLAGUED_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.PLAGUED_SLAB.get()));

        this.add(ModBlocks.EMBER_OAK_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.EMBER_OAK_SLAB.get()));

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

        this.add(ModBlocks.PLAGUED_DOOR.get(),
                block -> createDoorTable(ModBlocks.PLAGUED_DOOR.get()));

        this.add(ModBlocks.EMBER_OAK_DOOR.get(),
                block -> createDoorTable(ModBlocks.EMBER_OAK_DOOR.get()));

        //End of Complex Self Drops


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

        //End of Ore Drops


        //Crops Handling
        LootItemCondition.Builder lootitemcondition$builder = LootItemBlockStatePropertyCondition
                .hasBlockStateProperties(ModBlocks.STRAWBERRY_CROP.get())
                .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(StrawberryCropBlock.AGE, 5));

        this.add(ModBlocks.STRAWBERRY_CROP.get(), createCropDrops(ModBlocks.STRAWBERRY_CROP.get(), ModItems.STRAWBERRY.get(),
                ModItems.STRAWBERRY_SEEDS.get(), lootitemcondition$builder));


//        LootItemCondition.Builder lootitemcondition$builder2 = LootItemBlockStatePropertyCondition
//                .hasBlockStateProperties(ModBlocks.CORN_CROP.get())
//                .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(CornCropBlock.AGE, 7))
//                .or(LootItemBlockStatePropertyCondition
//                        .hasBlockStateProperties(ModBlocks.CORN_CROP.get())
//                        .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(CornCropBlock.AGE, 8)));

         LootItemCondition.Builder lootitemcondition$builder2 = LootItemBlockStatePropertyCondition
                 .hasBlockStateProperties(ModBlocks.CORN_CROP.get())
                 .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(CornCropBlock.AGE, 8));

        this.add(ModBlocks.CORN_CROP.get(), createCropDrops(ModBlocks.CORN_CROP.get(), ModItems.CORN.get(),
                ModItems.CORN_SEEDS.get(), lootitemcondition$builder2));


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
