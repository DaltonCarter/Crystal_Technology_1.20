package com.CartersDev.crystechmod.datagen;

import com.CartersDev.crystechmod.CrystalTech;

import com.CartersDev.crystechmod.block.ModBlocks;
import net.minecraft.data.PackOutput;
import net.minecraft.world.level.block.*;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;

public class ModBlockStateProvider extends BlockStateProvider {
    public ModBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, CrystalTech.MOD_ID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {

        blockWithItem(ModBlocks.GUNDANIUM_BLOCK);
        blockWithItem(ModBlocks.ALYTHUM_BLOCK);
        blockWithItem(ModBlocks.ILLYRIM_BLOCK);
        blockWithItem(ModBlocks.LG_CORE_BLOCK);
        blockWithItem(ModBlocks.MG_CORE_BLOCK);
        blockWithItem(ModBlocks.HG_CORE_BLOCK);

        blockWithItem(ModBlocks.TIBERIUM_BLOCK);
        blockWithItem(ModBlocks.TIBERIUM_BLUE_BLOCK);
        blockWithItem(ModBlocks.TIBERIUM_RED_BLOCK);
        blockWithItem(ModBlocks.TIBERIUM_PURPLE_BLOCK);

        blockWithItem((ModBlocks.AERIES_BLOCK));
        blockWithItem((ModBlocks.ENIGMA_BLOCK));
        blockWithItem((ModBlocks.ILLUMINA_BLOCK));
        blockWithItem((ModBlocks.KRYON_BLOCK));

        blockWithItem(ModBlocks.GUNDANIUM_ORE);
        blockWithItem(ModBlocks.DEEPSLATE_GUNDANIUM_ORE);

        blockWithItem(ModBlocks.ALYTHUM_ORE);
        blockWithItem(ModBlocks.DEEPSLATE_ALYTHUM_ORE);
        blockWithItem(ModBlocks.NETHER_ALYTHUM_ORE);

        blockWithItem(ModBlocks.AERIES_ORE);
        blockWithItem(ModBlocks.DEEPSLATE_AERIES_ORE);
        blockWithItem(ModBlocks.NETHER_AERIES_ORE);

        blockWithItem(ModBlocks.KRYON_ORE);
        blockWithItem(ModBlocks.DEEPSLATE_KRYON_ORE);
        blockWithItem(ModBlocks.NETHER_KRYON_ORE);
        blockWithItem(ModBlocks.END_KRYON_ORE);

        blockWithItem(ModBlocks.ENIGMA_ORE);
        blockWithItem(ModBlocks.DEEPSLATE_ENIGMA_ORE);
        blockWithItem(ModBlocks.END_ENIGMA_ORE);

        blockWithItem(ModBlocks.ILLUMINA_ORE);
        blockWithItem(ModBlocks.DEEPSLATE_ILLUMINA_ORE);

        blockWithItem(ModBlocks.QUALRITE_ORE);
        blockWithItem(ModBlocks.DEEPSLATE_QUALRITE_ORE);
        blockWithItem(ModBlocks.NETHER_QUALRITE_ORE);

        blockWithItem(ModBlocks.INFESTED_STONE);
        blockWithItem(ModBlocks.INFESTED_STONE_BRICKS);
        blockWithItem(ModBlocks.INFESTED_COBBLE);
        blockWithItem(ModBlocks.INFESTED_ANDESITE);
        blockWithItem(ModBlocks.INFESTED_DIORITE);
        blockWithItem(ModBlocks.INFESTED_GRANITE);
        blockWithItem(ModBlocks.RED_ZONE_DIRT);
        blockWithItem(ModBlocks.RED_ZONE_SAND);
        blockWithItem(ModBlocks.SEEDED_RED_ZONE_DIRT);
        blockWithItem(ModBlocks.YELLOW_ZONE_SAND);
        blockWithItem(ModBlocks.YELLOW_ZONE_CRACKED_DIRT);
        blockWithItem(ModBlocks.SEEDED_YELLOW_ZONE_CRACKED_DIRT);
        blockWithItem(ModBlocks.SEEDED_DIRT);
        blockWithItem(ModBlocks.RIPARIUS_STONE);
        blockWithItem(ModBlocks.VINIFERA_STONE);
        blockWithItem(ModBlocks.CRUENTUS_STONE);
        blockWithItem(ModBlocks.ABOREUS_STONE);
        blockWithItem(ModBlocks.RIPARIUS_CRYSTAL);
        blockWithItem(ModBlocks.VINIFERA_CRYSTAL);
        blockWithItem(ModBlocks.CRUENTUS_CRYSTAL);
        blockWithItem(ModBlocks.ABOREUS_CRYSTAL);

        blockWithItem(ModBlocks.FIRESTONE_BLOCK);

        blockWithItem((ModBlocks.CLEAR_TIBERGLASS));
        blockWithItem((ModBlocks.MOSAIC_TIBERGLASS));
        blockWithItem((ModBlocks.GDI_TIBERGLASS));
        blockWithItem((ModBlocks.NOD_TIBERGLASS));
        blockWithItem((ModBlocks.WOLF_TIBERGLASS));
        blockWithItem((ModBlocks.BLACK_TIBERGLASS));
        blockWithItem((ModBlocks.BLUE_TIBERGLASS));
        blockWithItem((ModBlocks.BROWN_TIBERGLASS));
        blockWithItem((ModBlocks.CYAN_TIBERGLASS));
        blockWithItem((ModBlocks.GRAY_TIBERGLASS));
        blockWithItem((ModBlocks.GREEN_TIBERGLASS));
        blockWithItem((ModBlocks.LIGHT_BLUE_TIBERGLASS));
        blockWithItem((ModBlocks.LIGHT_GRAY_TIBERGLASS));
        blockWithItem((ModBlocks.LIME_TIBERGLASS));
        blockWithItem((ModBlocks.MAGENTA_TIBERGLASS));
        blockWithItem((ModBlocks.ORANGE_TIBERGLASS));
        blockWithItem((ModBlocks.PINK_TIBERGLASS));
        blockWithItem((ModBlocks.PURPLE_TIBERGLASS));
        blockWithItem((ModBlocks.RED_TIBERGLASS));
        blockWithItem((ModBlocks.WHITE_TIBERGLASS));
        blockWithItem((ModBlocks.YELLOW_TIBERGLASS));

        blockWithItem(ModBlocks.BLACK_TIBERCRETE);
        blockWithItem(ModBlocks.BLUE_TIBERCRETE);
        blockWithItem(ModBlocks.BROWN_TIBERCRETE);
        blockWithItem(ModBlocks.CYAN_TIBERCRETE);
        blockWithItem(ModBlocks.GRAY_TIBERCRETE);
        blockWithItem(ModBlocks.GREEN_TIBERCRETE);
        blockWithItem(ModBlocks.LIGHT_BLUE_TIBERCRETE);
        blockWithItem(ModBlocks.LIGHT_GRAY_TIBERCRETE);
        blockWithItem(ModBlocks.LIME_TIBERCRETE);
        blockWithItem(ModBlocks.MAGENTA_TIBERCRETE);
        blockWithItem(ModBlocks.ORANGE_TIBERCRETE);
        blockWithItem(ModBlocks.PINK_TIBERCRETE);
        blockWithItem(ModBlocks.PURPLE_TIBERCRETE);
        blockWithItem(ModBlocks.RED_TIBERCRETE);
        blockWithItem(ModBlocks.WHITE_TIBERCRETE);
        blockWithItem(ModBlocks.YELLOW_TIBERCRETE);

        blockWithItem(ModBlocks.BLACK_TIBERCRETE_POWDER);
        blockWithItem(ModBlocks.BLUE_TIBERCRETE_POWDER);
        blockWithItem(ModBlocks.BROWN_TIBERCRETE_POWDER);
        blockWithItem(ModBlocks.CYAN_TIBERCRETE_POWDER);
        blockWithItem(ModBlocks.GRAY_TIBERCRETE_POWDER);
        blockWithItem(ModBlocks.GREEN_TIBERCRETE_POWDER);
        blockWithItem(ModBlocks.LIGHT_BLUE_TIBERCRETE_POWDER);
        blockWithItem(ModBlocks.LIGHT_GRAY_TIBERCRETE_POWDER);
        blockWithItem(ModBlocks.LIME_TIBERCRETE_POWDER);
        blockWithItem(ModBlocks.MAGENTA_TIBERCRETE_POWDER);
        blockWithItem(ModBlocks.ORANGE_TIBERCRETE_POWDER);
        blockWithItem(ModBlocks.PINK_TIBERCRETE_POWDER);
        blockWithItem(ModBlocks.PURPLE_TIBERCRETE_POWDER);
        blockWithItem(ModBlocks.RED_TIBERCRETE_POWDER);
        blockWithItem(ModBlocks.WHITE_TIBERCRETE_POWDER);
        blockWithItem(ModBlocks.YELLOW_TIBERCRETE_POWDER);
        blockWithItem(ModBlocks.PLAGUED_PLANKS);

        blockWithItem(ModBlocks.TIBERIUM_SOIL);
        blockWithItem(ModBlocks.ICHOR_SOIL);

        blockWithItem(ModBlocks.BLOSSOM_SPOUT);

       paneBlockWithRenderType((IronBarsBlock) ModBlocks.CLEAR_TIBERGLASS_PANE.get(), modLoc("block/clear_tiberglass"), modLoc("block/clear_tiberglass_pane_top"),"translucent");
       paneBlockWithRenderType((IronBarsBlock) ModBlocks.MOSAIC_TIBERGLASS_PANE.get(), modLoc("block/mosaic_tiberglass"), modLoc("block/mosaic_tiberglass_pane_top"),"translucent");
       paneBlockWithRenderType((IronBarsBlock) ModBlocks.GDI_TIBERGLASS_PANE.get(), modLoc("block/gdi_tiberglass"), modLoc("block/yellow_tiberglass_pane_top"),"translucent");
       paneBlockWithRenderType((IronBarsBlock) ModBlocks.NOD_TIBERGLASS_PANE.get(), modLoc("block/nod_tiberglass"), modLoc("block/red_tiberglass_pane_top"),"translucent");
       paneBlockWithRenderType((IronBarsBlock) ModBlocks.WOLF_TIBERGLASS_PANE.get(), modLoc("block/wolf_tiberglass"), modLoc("block/black_tiberglass_pane_top"),"translucent");
       paneBlockWithRenderType((StainedGlassPaneBlock) ModBlocks.BLACK_TIBERGLASS_PANE.get(), modLoc("block/black_tiberglass"), modLoc("block/black_tiberglass_pane_top"),"translucent");
       paneBlockWithRenderType((StainedGlassPaneBlock) ModBlocks.BLUE_TIBERGLASS_PANE.get(), modLoc("block/blue_tiberglass"), modLoc("block/blue_tiberglass_pane_top"),"translucent");
       paneBlockWithRenderType((StainedGlassPaneBlock) ModBlocks.BROWN_TIBERGLASS_PANE.get(), modLoc("block/brown_tiberglass"), modLoc("block/brown_tiberglass_pane_top"),"translucent");
       paneBlockWithRenderType((StainedGlassPaneBlock) ModBlocks.CYAN_TIBERGLASS_PANE.get(), modLoc("block/cyan_tiberglass"), modLoc("block/cyan_tiberglass_pane_top"),"translucent");
       paneBlockWithRenderType((StainedGlassPaneBlock) ModBlocks.LIGHT_BLUE_TIBERGLASS_PANE.get(), modLoc("block/light_blue_tiberglass"), modLoc("block/light_blue_tiberglass_pane_top"),"translucent");
       paneBlockWithRenderType((StainedGlassPaneBlock) ModBlocks.LIGHT_GRAY_TIBERGLASS_PANE.get(), modLoc("block/light_gray_tiberglass"), modLoc("block/light_gray_tiberglass_pane_top"),"translucent");
       paneBlockWithRenderType((StainedGlassPaneBlock) ModBlocks.LIME_TIBERGLASS_PANE.get(), modLoc("block/lime_tiberglass"), modLoc("block/lime_tiberglass_pane_top"),"translucent");
       paneBlockWithRenderType((StainedGlassPaneBlock) ModBlocks.MAGENTA_TIBERGLASS_PANE.get(), modLoc("block/magenta_tiberglass"), modLoc("block/magenta_tiberglass_pane_top"),"translucent");
       paneBlockWithRenderType((StainedGlassPaneBlock) ModBlocks.ORANGE_TIBERGLASS_PANE.get(), modLoc("block/orange_tiberglass"), modLoc("block/orange_tiberglass_pane_top"),"translucent");
       paneBlockWithRenderType((StainedGlassPaneBlock) ModBlocks.PINK_TIBERGLASS_PANE.get(), modLoc("block/pink_tiberglass"), modLoc("block/pink_tiberglass_pane_top"),"translucent");
       paneBlockWithRenderType((StainedGlassPaneBlock) ModBlocks.PURPLE_TIBERGLASS_PANE.get(), modLoc("block/purple_tiberglass"), modLoc("block/purple_tiberglass_pane_top"),"translucent");
       paneBlockWithRenderType((StainedGlassPaneBlock) ModBlocks.GRAY_TIBERGLASS_PANE.get(), modLoc("block/gray_tiberglass"), modLoc("block/gray_tiberglass_pane_top"),"translucent");
       paneBlockWithRenderType((StainedGlassPaneBlock) ModBlocks.GREEN_TIBERGLASS_PANE.get(), modLoc("block/green_tiberglass"), modLoc("block/green_tiberglass_pane_top"),"translucent");
       paneBlockWithRenderType((StainedGlassPaneBlock) ModBlocks.RED_TIBERGLASS_PANE.get(), modLoc("block/red_tiberglass"), modLoc("block/red_tiberglass_pane_top"),"translucent");
       paneBlockWithRenderType((StainedGlassPaneBlock) ModBlocks.WHITE_TIBERGLASS_PANE.get(), modLoc("block/white_tiberglass"), modLoc("block/white_tiberglass_pane_top"),"translucent");
       paneBlockWithRenderType((StainedGlassPaneBlock) ModBlocks.YELLOW_TIBERGLASS_PANE.get(), modLoc("block/yellow_tiberglass"), modLoc("block/yellow_tiberglass_pane_top"),"translucent");

       stairsBlock((StairBlock) ModBlocks.PLAGUED_STAIRS.get(), blockTexture(ModBlocks.PLAGUED_PLANKS.get()));
       stairsBlock((StairBlock) ModBlocks.INFESTED_STONE_BRICK_STAIRS.get(), blockTexture(ModBlocks.INFESTED_STONE_BRICKS.get()));
       stairsBlock((StairBlock) ModBlocks.INFESTED_COBBLE_STAIRS.get(), blockTexture(ModBlocks.INFESTED_COBBLE.get()));
       stairsBlock((StairBlock) ModBlocks.BLACK_TIBERCRETE_STAIRS.get(), blockTexture(ModBlocks.BLACK_TIBERCRETE.get()));
       stairsBlock((StairBlock) ModBlocks.BLUE_TIBERCRETE_STAIRS.get(), blockTexture(ModBlocks.BLUE_TIBERCRETE.get()));
       stairsBlock((StairBlock) ModBlocks.BROWN_TIBERCRETE_STAIRS.get(), blockTexture(ModBlocks.BROWN_TIBERCRETE.get()));
       stairsBlock((StairBlock) ModBlocks.CYAN_TIBERCRETE_STAIRS.get(), blockTexture(ModBlocks.CYAN_TIBERCRETE.get()));
       stairsBlock((StairBlock) ModBlocks.GRAY_TIBERCRETE_STAIRS.get(), blockTexture(ModBlocks.GRAY_TIBERCRETE.get()));
       stairsBlock((StairBlock) ModBlocks.GREEN_TIBERCRETE_STAIRS.get(), blockTexture(ModBlocks.GREEN_TIBERCRETE.get()));
       stairsBlock((StairBlock) ModBlocks.LIGHT_BLUE_TIBERCRETE_STAIRS.get(), blockTexture(ModBlocks.LIGHT_BLUE_TIBERCRETE.get()));
       stairsBlock((StairBlock) ModBlocks.LIGHT_GRAY_TIBERCRETE_STAIRS.get(), blockTexture(ModBlocks.LIGHT_GRAY_TIBERCRETE.get()));
       stairsBlock((StairBlock) ModBlocks.LIME_TIBERCRETE_STAIRS.get(), blockTexture(ModBlocks.LIME_TIBERCRETE.get()));
       stairsBlock((StairBlock) ModBlocks.MAGENTA_TIBERCRETE_STAIRS.get(), blockTexture(ModBlocks.MAGENTA_TIBERCRETE.get()));
       stairsBlock((StairBlock) ModBlocks.ORANGE_TIBERCRETE_STAIRS.get(), blockTexture(ModBlocks.ORANGE_TIBERCRETE.get()));
       stairsBlock((StairBlock) ModBlocks.PINK_TIBERCRETE_STAIRS.get(), blockTexture(ModBlocks.PINK_TIBERCRETE.get()));
       stairsBlock((StairBlock) ModBlocks.PURPLE_TIBERCRETE_STAIRS.get(), blockTexture(ModBlocks.PURPLE_TIBERCRETE.get()));
       stairsBlock((StairBlock) ModBlocks.RED_TIBERCRETE_STAIRS.get(), blockTexture(ModBlocks.RED_TIBERCRETE.get()));
       stairsBlock((StairBlock) ModBlocks.WHITE_TIBERCRETE_STAIRS.get(), blockTexture(ModBlocks.WHITE_TIBERCRETE.get()));
       stairsBlock((StairBlock) ModBlocks.YELLOW_TIBERCRETE_STAIRS.get(), blockTexture(ModBlocks.YELLOW_TIBERCRETE.get()));

       slabBlock((SlabBlock) ModBlocks.PLAGUED_SLAB.get(), blockTexture(ModBlocks.PLAGUED_PLANKS.get()), blockTexture(ModBlocks.PLAGUED_PLANKS.get()));
       slabBlock((SlabBlock) ModBlocks.INFESTED_STONE_BRICK_SLAB.get(), blockTexture(ModBlocks.INFESTED_STONE_BRICKS.get()), blockTexture(ModBlocks.INFESTED_STONE_BRICKS.get()));
       slabBlock((SlabBlock) ModBlocks.INFESTED_COBBLE_SLAB.get(), blockTexture(ModBlocks.INFESTED_COBBLE.get()), blockTexture(ModBlocks.INFESTED_COBBLE.get()));

        buttonBlock((ButtonBlock) ModBlocks.PLAGUED_BUTTON.get(), blockTexture(ModBlocks.PLAGUED_PLANKS.get()));
        pressurePlateBlock((PressurePlateBlock) ModBlocks.PLAGUED_PRESSURE_PLATE.get(), blockTexture(ModBlocks.PLAGUED_PLANKS.get()));

        fenceBlock((FenceBlock) ModBlocks.PLAGUED_FENCE.get(), blockTexture(ModBlocks.PLAGUED_PLANKS.get()));
        fenceGateBlock((FenceGateBlock) ModBlocks.PLAGUED_FENCE_GATE.get(), blockTexture(ModBlocks.PLAGUED_PLANKS.get()));

        doorBlockWithRenderType((((DoorBlock) ModBlocks.PLAGUED_DOOR.get())), modLoc("block/plagued_door_bottom"), modLoc("block/plagued_door_top"), "cutout");
        trapdoorBlockWithRenderType((((TrapDoorBlock) ModBlocks.PLAGUED_TRAPDOOR.get())), modLoc("block/plagued_trapdoor"), true, "cutout");

        wallBlock((((WallBlock) ModBlocks.FIRESTONE_WALL.get())), blockTexture(( ModBlocks.FIRESTONE_BLOCK.get())));

    }


   private void blockWithItem(RegistryObject<Block> blockRegistryObject) {
        simpleBlockWithItem(blockRegistryObject.get(), cubeAll(blockRegistryObject.get()));
   }


}
