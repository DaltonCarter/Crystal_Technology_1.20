package com.CartersDev.crystechmod.datagen;


import com.CartersDev.crystechmod.CrystalTech;
import com.CartersDev.crystechmod.block.ModBlocks;

import com.CartersDev.crystechmod.util.ModTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.data.BlockTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagGenerator extends BlockTagsProvider {
    public ModBlockTagGenerator(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider , @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, CrystalTech.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {

        this.tag(ModTags.Blocks.TIBERIUM_VIABLE_BLOCKS)
                .add(
                        ModBlocks.RED_ZONE_DIRT.get(),
                        ModBlocks.YELLOW_ZONE_CRACKED_DIRT.get(),
                        Blocks.DIRT,
                        Blocks.COBBLESTONE,
                        Blocks.STONE,
                        Blocks.STONE_BRICKS,
                        Blocks.ANDESITE,
                        Blocks.DIORITE,
                        Blocks.GRANITE
                );

        this.tag(ModTags.Blocks.HAZMAT_GLASS_PANES)
                .add(
                        ModBlocks.CLEAR_TIBERGLASS_PANE.get(),
                        Blocks.GLASS_PANE
                );

        this.tag(ModTags.Blocks.HAZMAT_GLASS_PANES2)
                .add(
                        ModBlocks.RED_TIBERGLASS_PANE.get(),
                        Blocks.RED_STAINED_GLASS_PANE
                );

        this.tag(ModTags.Blocks.TIBERIUM_SEED_BLOCKS)
                .add(
                        ModBlocks.SEEDED_RED_ZONE_DIRT.get(),
                        ModBlocks.SEEDED_YELLOW_ZONE_CRACKED_DIRT.get(),
                        ModBlocks.SEEDED_DIRT.get()
                );


        this.tag(ModTags.Blocks.TIBERCRETE_SANDS)
                .add(ModBlocks.RED_ZONE_SAND.get(),
                        ModBlocks.YELLOW_ZONE_SAND.get(),
                        Blocks.SAND,
                        Blocks.RED_SAND);

        this.tag(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(ModBlocks.TIBERIUM_BLOCK.get(),
                ModBlocks.TIBERIUM_BLUE_BLOCK.get(),
                ModBlocks.TIBERIUM_RED_BLOCK.get(),
                ModBlocks.TIBERIUM_PURPLE_BLOCK.get(),
                ModBlocks.GUNDANIUM_ORE.get(),
                ModBlocks.DEEPSLATE_GUNDANIUM_ORE.get(),
                ModBlocks.GUNDANIUM_BLOCK.get(),
                ModBlocks.AERIES_BLOCK.get(),
                ModBlocks.AERIES_ORE.get(),
                ModBlocks.DEEPSLATE_AERIES_ORE.get(),
                ModBlocks.NETHER_AERIES_ORE.get(),
                ModBlocks.ENIGMA_ORE.get(),
                ModBlocks.DEEPSLATE_ENIGMA_ORE.get(),
                ModBlocks.END_ENIGMA_ORE.get(),
                ModBlocks.ENIGMA_BLOCK.get(),
                ModBlocks.ILLUMINA_BLOCK.get(),
                ModBlocks.ILLUMINA_ORE.get(),
                ModBlocks.DEEPSLATE_ILLUMINA_ORE.get(),
                ModBlocks.KRYON_BLOCK.get(),
                ModBlocks.KRYON_ORE.get(),
                ModBlocks.DEEPSLATE_KRYON_ORE.get(),
                ModBlocks.NETHER_KRYON_ORE.get(),
                ModBlocks.END_KRYON_ORE.get(),
                ModBlocks.ALYTHUM_BLOCK.get(),
                ModBlocks.ALYTHUM_ORE.get(),
                ModBlocks.DEEPSLATE_ALYTHUM_ORE.get(),
                ModBlocks.NETHER_ALYTHUM_ORE.get(),
                ModBlocks.QUALRITE_ORE.get(),
                ModBlocks.DEEPSLATE_QUALRITE_ORE.get(),
                ModBlocks.NETHER_QUALRITE_ORE.get(),
                ModBlocks.RIPARIUS_CRYSTAL.get(),
                ModBlocks.ABOREUS_CRYSTAL.get(),
                ModBlocks.VINIFERA_CRYSTAL.get(),
                ModBlocks.CRUENTUS_CRYSTAL.get(),
                ModBlocks.RIPARIUS_STONE.get(),
                ModBlocks.VINIFERA_STONE.get(),
                ModBlocks.CRUENTUS_STONE.get(),
                ModBlocks.ABOREUS_STONE.get(),
                ModBlocks.INFESTED_STONE.get(),
                ModBlocks.INFESTED_ANDESITE.get(),
                ModBlocks.INFESTED_COBBLE.get(),
                ModBlocks.INFESTED_COBBLE_SLAB.get(),
                ModBlocks.INFESTED_COBBLE_STAIRS.get(),
                ModBlocks.INFESTED_DIORITE.get(),
                ModBlocks.INFESTED_GRANITE.get(),
                ModBlocks.INFESTED_STONE_BRICKS.get(),
                ModBlocks.INFESTED_STONE_BRICK_STAIRS.get(),
                ModBlocks.INFESTED_STONE_BRICK_SLAB.get(),
                ModBlocks.LG_CORE_BLOCK.get(),
                ModBlocks.MG_CORE_BLOCK.get(),
                ModBlocks.HG_CORE_BLOCK.get(),
                ModBlocks.CLEAR_TIBERGLASS.get(),
                ModBlocks.MOSAIC_TIBERGLASS.get(),
                ModBlocks.GDI_TIBERGLASS.get(),
                ModBlocks.NOD_TIBERGLASS.get(),
                ModBlocks.WOLF_TIBERGLASS.get(),
                ModBlocks.BLACK_TIBERGLASS.get(),
                ModBlocks.BLUE_TIBERGLASS.get(),
                ModBlocks.BROWN_TIBERGLASS.get(),
                ModBlocks.CYAN_TIBERGLASS.get(),
                ModBlocks.GRAY_TIBERGLASS.get(),
                ModBlocks.GREEN_TIBERGLASS.get(),
                ModBlocks.LIGHT_BLUE_TIBERGLASS.get(),
                ModBlocks.LIGHT_GRAY_TIBERGLASS.get(),
                ModBlocks.LIME_TIBERGLASS.get(),
                ModBlocks.MAGENTA_TIBERGLASS.get(),
                ModBlocks.ORANGE_TIBERGLASS.get(),
                ModBlocks.PINK_TIBERGLASS.get(),
                ModBlocks.PURPLE_TIBERGLASS.get(),
                ModBlocks.RED_TIBERGLASS.get(),
                ModBlocks.WHITE_TIBERGLASS.get(),
                ModBlocks.YELLOW_TIBERGLASS.get(),
                ModBlocks.FIRESTONE_BLOCK.get(),
                ModBlocks.FIRESTONE_WALL.get(),
                ModBlocks.BLACK_TIBERCRETE.get(),
                ModBlocks.BLUE_TIBERCRETE.get(),
                ModBlocks.BROWN_TIBERCRETE.get(),
                ModBlocks.CYAN_TIBERCRETE.get(),
                ModBlocks.GRAY_TIBERCRETE.get(),
                ModBlocks.GREEN_TIBERCRETE.get(),
                ModBlocks.LIGHT_BLUE_TIBERCRETE.get(),
                ModBlocks.LIGHT_GRAY_TIBERCRETE.get(),
                ModBlocks.LIME_TIBERCRETE.get(),
                ModBlocks.MAGENTA_TIBERCRETE.get(),
                ModBlocks.ORANGE_TIBERCRETE.get(),
                ModBlocks.PINK_TIBERCRETE.get(),
                ModBlocks.PURPLE_TIBERCRETE.get(),
                ModBlocks.RED_TIBERCRETE.get(),
                ModBlocks.WHITE_TIBERCRETE.get(),
                ModBlocks.YELLOW_TIBERCRETE.get(),
                ModBlocks.CLEAR_TIBERGLASS_PANE.get(),
                ModBlocks.MOSAIC_TIBERGLASS_PANE.get(),
                ModBlocks.GDI_TIBERGLASS_PANE.get(),
                ModBlocks.NOD_TIBERGLASS_PANE.get(),
                ModBlocks.WOLF_TIBERGLASS_PANE.get(),
                ModBlocks.BLACK_TIBERGLASS_PANE.get(),
                ModBlocks.BLUE_TIBERGLASS_PANE.get(),
                ModBlocks.BROWN_TIBERGLASS_PANE.get(),
                ModBlocks.CYAN_TIBERGLASS_PANE.get(),
                ModBlocks.GRAY_TIBERGLASS_PANE.get(),
                ModBlocks.GREEN_TIBERGLASS_PANE.get(),
                ModBlocks.LIGHT_BLUE_TIBERGLASS_PANE.get(),
                ModBlocks.LIGHT_GRAY_TIBERGLASS_PANE.get(),
                ModBlocks.LIME_TIBERGLASS_PANE.get(),
                ModBlocks.MAGENTA_TIBERGLASS_PANE.get(),
                ModBlocks.ORANGE_TIBERGLASS_PANE.get(),
                ModBlocks.PINK_TIBERGLASS_PANE.get(),
                ModBlocks.PURPLE_TIBERGLASS_PANE.get(),
                ModBlocks.RED_TIBERGLASS_PANE.get(),
                ModBlocks.WHITE_TIBERGLASS_PANE.get(),
                ModBlocks.YELLOW_TIBERGLASS_PANE.get(),
                ModBlocks.BLACK_TIBERCRETE_STAIRS.get(),
                ModBlocks.BLUE_TIBERCRETE_STAIRS.get(),
                ModBlocks.BROWN_TIBERCRETE_STAIRS.get(),
                ModBlocks.CYAN_TIBERCRETE_STAIRS.get(),
                ModBlocks.GRAY_TIBERCRETE_STAIRS.get(),
                ModBlocks.GREEN_TIBERCRETE_STAIRS.get(),
                ModBlocks.LIGHT_BLUE_TIBERCRETE_STAIRS.get(),
                ModBlocks.LIGHT_GRAY_TIBERCRETE_STAIRS.get(),
                ModBlocks.LIME_TIBERCRETE_STAIRS.get(),
                ModBlocks.MAGENTA_TIBERCRETE_STAIRS.get(),
                ModBlocks.ORANGE_TIBERCRETE_STAIRS.get(),
                ModBlocks.PINK_TIBERCRETE_STAIRS.get(),
                ModBlocks.PURPLE_TIBERCRETE_STAIRS.get(),
                ModBlocks.RED_TIBERCRETE_STAIRS.get(),
                ModBlocks.WHITE_TIBERCRETE_STAIRS.get(),
                ModBlocks.YELLOW_TIBERCRETE_STAIRS.get()
                );

        this.tag(BlockTags.MINEABLE_WITH_SHOVEL)
                .add(ModBlocks.YELLOW_ZONE_SAND.get(),
                        ModBlocks.RED_ZONE_SAND.get(),
                        ModBlocks.RED_ZONE_DIRT.get(),
                        ModBlocks.YELLOW_ZONE_CRACKED_DIRT.get(),
                        ModBlocks.SEEDED_YELLOW_ZONE_CRACKED_DIRT.get(),
                        ModBlocks.SEEDED_RED_ZONE_DIRT.get(),
                        ModBlocks.SEEDED_DIRT.get(),
                        ModBlocks.TIBERIUM_SOIL.get(),
                        ModBlocks.ICHOR_SOIL.get(),
                        ModBlocks.BLACK_TIBERCRETE_POWDER.get(),
                        ModBlocks.BLUE_TIBERCRETE_POWDER.get(),
                        ModBlocks.BROWN_TIBERCRETE_POWDER.get(),
                        ModBlocks.CYAN_TIBERCRETE_POWDER.get(),
                        ModBlocks.GRAY_TIBERCRETE_POWDER.get(),
                        ModBlocks.GREEN_TIBERCRETE_POWDER.get(),
                        ModBlocks.LIGHT_BLUE_TIBERCRETE_POWDER.get(),
                        ModBlocks.LIGHT_GRAY_TIBERCRETE_POWDER.get(),
                        ModBlocks.LIME_TIBERCRETE_POWDER.get(),
                        ModBlocks.MAGENTA_TIBERCRETE_POWDER.get(),
                        ModBlocks.ORANGE_TIBERCRETE_POWDER.get(),
                        ModBlocks.PINK_TIBERCRETE_POWDER.get(),
                        ModBlocks.PURPLE_TIBERCRETE_POWDER.get(),
                        ModBlocks.RED_TIBERCRETE_POWDER.get(),
                        ModBlocks.WHITE_TIBERCRETE_POWDER.get(),
                        ModBlocks.YELLOW_TIBERCRETE_POWDER.get()
                );

        this.tag(BlockTags.MINEABLE_WITH_AXE)
                .add(ModBlocks.PLAGUED_TRAPDOOR.get(),
                        ModBlocks.PLAGUED_PLANKS.get(),
                        ModBlocks.PLAGUED_BUTTON.get(),
                        ModBlocks.PLAGUED_DOOR.get(),
                        ModBlocks.PLAGUED_PRESSURE_PLATE.get(),
                        ModBlocks.PLAGUED_FENCE.get(),
                        ModBlocks.PLAGUED_FENCE_GATE.get(),
                        ModBlocks.PLAGUED_STAIRS.get(),
                        ModBlocks.PLAGUED_SLAB.get()

                );

        this.tag(BlockTags.NEEDS_STONE_TOOL)
                .add(ModBlocks.CLEAR_TIBERGLASS.get(),
                        ModBlocks.CLEAR_TIBERGLASS_PANE.get(),
                        ModBlocks.MOSAIC_TIBERGLASS.get(),
                        ModBlocks.MOSAIC_TIBERGLASS_PANE.get(),
                        ModBlocks.GDI_TIBERGLASS.get(),
                        ModBlocks.GDI_TIBERGLASS_PANE.get(),
                        ModBlocks.NOD_TIBERGLASS.get(),
                        ModBlocks.NOD_TIBERGLASS_PANE.get(),
                        ModBlocks.WOLF_TIBERGLASS.get(),
                        ModBlocks.WOLF_TIBERGLASS_PANE.get(),
                        ModBlocks.BLACK_TIBERGLASS.get(),
                        ModBlocks.BLACK_TIBERGLASS_PANE.get(),
                        ModBlocks.BLUE_TIBERGLASS.get(),
                        ModBlocks.BLUE_TIBERGLASS_PANE.get(),
                        ModBlocks.BROWN_TIBERGLASS.get(),
                        ModBlocks.BROWN_TIBERGLASS_PANE.get(),
                        ModBlocks.CYAN_TIBERGLASS.get(),
                        ModBlocks.CYAN_TIBERGLASS_PANE.get(),
                        ModBlocks.GRAY_TIBERGLASS.get(),
                        ModBlocks.GRAY_TIBERGLASS_PANE.get(),
                        ModBlocks.GREEN_TIBERGLASS.get(),
                        ModBlocks.GREEN_TIBERGLASS_PANE.get(),
                        ModBlocks.LIGHT_BLUE_TIBERGLASS.get(),
                        ModBlocks.LIGHT_BLUE_TIBERGLASS_PANE.get(),
                        ModBlocks.LIGHT_GRAY_TIBERGLASS.get(),
                        ModBlocks.LIGHT_GRAY_TIBERGLASS_PANE.get(),
                        ModBlocks.LIME_TIBERGLASS.get(),
                        ModBlocks.LIME_TIBERGLASS_PANE.get(),
                        ModBlocks.MAGENTA_TIBERGLASS.get(),
                        ModBlocks.MAGENTA_TIBERGLASS_PANE.get(),
                        ModBlocks.ORANGE_TIBERGLASS.get(),
                        ModBlocks.ORANGE_TIBERGLASS_PANE.get(),
                        ModBlocks.PINK_TIBERGLASS.get(),
                        ModBlocks.PINK_TIBERGLASS_PANE.get(),
                        ModBlocks.PURPLE_TIBERGLASS.get(),
                        ModBlocks.PURPLE_TIBERGLASS_PANE.get(),
                        ModBlocks.RED_TIBERGLASS.get(),
                        ModBlocks.RED_TIBERGLASS_PANE.get(),
                        ModBlocks.WHITE_TIBERGLASS.get(),
                        ModBlocks.WHITE_TIBERGLASS_PANE.get(),
                        ModBlocks.YELLOW_TIBERGLASS.get(),
                        ModBlocks.YELLOW_TIBERGLASS_PANE.get(),
                        ModBlocks.PLAGUED_TRAPDOOR.get(),
                        ModBlocks.PLAGUED_PLANKS.get(),
                        ModBlocks.PLAGUED_BUTTON.get(),
                        ModBlocks.PLAGUED_DOOR.get(),
                        ModBlocks.PLAGUED_PRESSURE_PLATE.get(),
                        ModBlocks.PLAGUED_FENCE.get(),
                        ModBlocks.PLAGUED_FENCE_GATE.get(),
                        ModBlocks.PLAGUED_STAIRS.get(),
                        ModBlocks.PLAGUED_SLAB.get()
                );

        this.tag(ModTags.Blocks.NEEDS_PLAGUED_TOOL)
                .add(ModBlocks.INFESTED_STONE.get(),
                     ModBlocks.INFESTED_COBBLE.get(),
                     ModBlocks.INFESTED_STONE_BRICKS.get(),
                     ModBlocks.INFESTED_ANDESITE.get(),
                     ModBlocks.INFESTED_DIORITE.get(),
                     ModBlocks.INFESTED_GRANITE.get(),
                     ModBlocks.INFESTED_COBBLE_SLAB.get(),
                     ModBlocks.INFESTED_STONE_BRICK_SLAB.get(),
                     ModBlocks.INFESTED_STONE_BRICK_STAIRS.get(),
                     ModBlocks.INFESTED_COBBLE_STAIRS.get(),
                        ModBlocks.BLACK_TIBERCRETE_POWDER.get(),
                        ModBlocks.BLUE_TIBERCRETE_POWDER.get(),
                        ModBlocks.BROWN_TIBERCRETE_POWDER.get(),
                        ModBlocks.CYAN_TIBERCRETE_POWDER.get(),
                        ModBlocks.GRAY_TIBERCRETE_POWDER.get(),
                        ModBlocks.GREEN_TIBERCRETE_POWDER.get(),
                        ModBlocks.LIGHT_BLUE_TIBERCRETE_POWDER.get(),
                        ModBlocks.LIGHT_GRAY_TIBERCRETE_POWDER.get(),
                        ModBlocks.LIME_TIBERCRETE_POWDER.get(),
                        ModBlocks.MAGENTA_TIBERCRETE_POWDER.get(),
                        ModBlocks.ORANGE_TIBERCRETE_POWDER.get(),
                        ModBlocks.PINK_TIBERCRETE_POWDER.get(),
                        ModBlocks.PURPLE_TIBERCRETE_POWDER.get(),
                        ModBlocks.RED_TIBERCRETE_POWDER.get(),
                        ModBlocks.WHITE_TIBERCRETE_POWDER.get(),
                        ModBlocks.YELLOW_TIBERCRETE_POWDER.get(),
                        ModBlocks.BLACK_TIBERCRETE.get(),
                        ModBlocks.BLUE_TIBERCRETE.get(),
                        ModBlocks.BROWN_TIBERCRETE.get(),
                        ModBlocks.CYAN_TIBERCRETE.get(),
                        ModBlocks.GRAY_TIBERCRETE.get(),
                        ModBlocks.GREEN_TIBERCRETE.get(),
                        ModBlocks.LIGHT_BLUE_TIBERCRETE.get(),
                        ModBlocks.LIGHT_GRAY_TIBERCRETE.get(),
                        ModBlocks.LIME_TIBERCRETE.get(),
                        ModBlocks.MAGENTA_TIBERCRETE.get(),
                        ModBlocks.ORANGE_TIBERCRETE.get(),
                        ModBlocks.PINK_TIBERCRETE.get(),
                        ModBlocks.PURPLE_TIBERCRETE.get(),
                        ModBlocks.RED_TIBERCRETE.get(),
                        ModBlocks.WHITE_TIBERCRETE.get(),
                        ModBlocks.YELLOW_TIBERCRETE.get(),
                        ModBlocks.BLACK_TIBERCRETE_STAIRS.get(),
                        ModBlocks.BLUE_TIBERCRETE_STAIRS.get(),
                        ModBlocks.BROWN_TIBERCRETE_STAIRS.get(),
                        ModBlocks.CYAN_TIBERCRETE_STAIRS.get(),
                        ModBlocks.GRAY_TIBERCRETE_STAIRS.get(),
                        ModBlocks.GREEN_TIBERCRETE_STAIRS.get(),
                        ModBlocks.LIGHT_BLUE_TIBERCRETE_STAIRS.get(),
                        ModBlocks.LIGHT_GRAY_TIBERCRETE_STAIRS.get(),
                        ModBlocks.LIME_TIBERCRETE_STAIRS.get(),
                        ModBlocks.MAGENTA_TIBERCRETE_STAIRS.get(),
                        ModBlocks.ORANGE_TIBERCRETE_STAIRS.get(),
                        ModBlocks.PINK_TIBERCRETE_STAIRS.get(),
                        ModBlocks.PURPLE_TIBERCRETE_STAIRS.get(),
                        ModBlocks.RED_TIBERCRETE_STAIRS.get(),
                        ModBlocks.WHITE_TIBERCRETE_STAIRS.get(),
                        ModBlocks.YELLOW_TIBERCRETE_STAIRS.get()
                );

        this.tag(BlockTags.NEEDS_IRON_TOOL)
                .add(ModBlocks.GUNDANIUM_ORE.get(),
                ModBlocks.TIBERIUM_BLOCK.get(),
                ModBlocks.TIBERIUM_BLUE_BLOCK.get(),
                ModBlocks.RIPARIUS_STONE.get(),
                ModBlocks.VINIFERA_STONE.get(),
                ModBlocks.CRUENTUS_STONE.get(),
                ModBlocks.ABOREUS_STONE.get(),
                ModBlocks.FIRESTONE_BLOCK.get(),
                ModBlocks.FIRESTONE_WALL.get(),
                ModBlocks.AERIES_BLOCK.get(),
                ModBlocks.ENIGMA_BLOCK.get(),
                ModBlocks.ILLUMINA_BLOCK.get(),
                ModBlocks.KRYON_BLOCK.get(),
                ModBlocks.GUNDANIUM_BLOCK.get(),
                ModBlocks.ALYTHUM_BLOCK.get(),
                ModBlocks.ILLYRIM_BLOCK.get(),
                ModBlocks.DEEPSLATE_GUNDANIUM_ORE.get(),
                ModBlocks.TIBERIUM_SOIL.get()
                );

        this.tag(ModTags.Blocks.NEEDS_GUNDANIUM_TOOL)
                .add(ModBlocks.DEEPSLATE_GUNDANIUM_ORE.get()
                );

        this.tag(BlockTags.NEEDS_DIAMOND_TOOL)
                .add(ModBlocks.LG_CORE_BLOCK.get(),
                 ModBlocks.MG_CORE_BLOCK.get(),
                 ModBlocks.HG_CORE_BLOCK.get(),
                 ModBlocks.TIBERIUM_RED_BLOCK.get(),
                 ModBlocks.AERIES_ORE.get(),
                 ModBlocks.DEEPSLATE_AERIES_ORE.get(),
                 ModBlocks.NETHER_AERIES_ORE.get(),
                 ModBlocks.ENIGMA_ORE.get(),
                 ModBlocks.DEEPSLATE_ENIGMA_ORE.get(),
                 ModBlocks.END_ENIGMA_ORE.get(),
                 ModBlocks.ILLUMINA_ORE.get(),
                 ModBlocks.DEEPSLATE_ILLUMINA_ORE.get(),
                 ModBlocks.KRYON_ORE.get(),
                 ModBlocks.DEEPSLATE_KRYON_ORE.get(),
                 ModBlocks.NETHER_KRYON_ORE.get(),
                 ModBlocks.END_KRYON_ORE.get(),
                 ModBlocks.ALYTHUM_ORE.get(),
                 ModBlocks.DEEPSLATE_ALYTHUM_ORE.get(),
                 ModBlocks.NETHER_ALYTHUM_ORE.get(),
                 ModBlocks.QUALRITE_ORE.get(),
                 ModBlocks.DEEPSLATE_QUALRITE_ORE.get(),
                 ModBlocks.NETHER_QUALRITE_ORE.get(),
                 ModBlocks.ICHOR_SOIL.get()
                );

        this.tag(ModTags.Blocks.NEEDS_ALYTHUM_TOOL)
                .add(
                        ModBlocks.DEEPSLATE_AERIES_ORE.get(),
                        ModBlocks.NETHER_AERIES_ORE.get(),
                        ModBlocks.DEEPSLATE_ENIGMA_ORE.get(),
                        ModBlocks.END_ENIGMA_ORE.get(),
                        ModBlocks.DEEPSLATE_ILLUMINA_ORE.get(),
                        ModBlocks.DEEPSLATE_KRYON_ORE.get(),
                        ModBlocks.NETHER_KRYON_ORE.get(),
                        ModBlocks.END_KRYON_ORE.get(),
                        ModBlocks.NETHER_ALYTHUM_ORE.get(),
                        ModBlocks.NETHER_QUALRITE_ORE.get()
                );

        this.tag(Tags.Blocks.NEEDS_NETHERITE_TOOL)
                .add(ModBlocks.RIPARIUS_CRYSTAL.get(),
                ModBlocks.VINIFERA_CRYSTAL.get(),
                ModBlocks.CRUENTUS_CRYSTAL.get(),
                ModBlocks.ABOREUS_CRYSTAL.get()
                );

        this.tag(BlockTags.FENCES)
                .add(ModBlocks.PLAGUED_FENCE.get()
                );

        this.tag(BlockTags.FENCE_GATES)
                .add(ModBlocks.PLAGUED_FENCE_GATE.get()
                );

        this.tag(BlockTags.WALLS)
                .add(ModBlocks.FIRESTONE_WALL.get()
                );

    }
}
