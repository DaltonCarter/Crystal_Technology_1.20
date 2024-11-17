package com.CartersDev.crystechmod.datagen;

import com.CartersDev.crystechmod.CrystalTech;

import com.CartersDev.crystechmod.block.ModBlocks;
import com.CartersDev.crystechmod.block.custom.CornCropBlock;
import com.CartersDev.crystechmod.block.custom.CrystalCoreLampBlock;
import com.CartersDev.crystechmod.block.custom.CrystalCoreLampDemo;
import com.CartersDev.crystechmod.block.custom.StrawberryCropBlock;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.client.model.generators.ConfiguredModel;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Function;

public class ModBlockStateProvider extends BlockStateProvider {
    public ModBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, CrystalTech.MOD_ID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {

        blockWithItem(ModBlocks.TEST_BLOCK);

        //Basic Block States:
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
        blockWithItem(ModBlocks.RIPARIUS_STONE_BRICKS);
        blockWithItem(ModBlocks.VINIFERA_STONE_BRICKS);
        blockWithItem(ModBlocks.CRUENTUS_STONE_BRICKS);
        blockWithItem(ModBlocks.ABOREUS_STONE_BRICKS);

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

        blockWithItem(ModBlocks.BLACK_TIBERCRETE_BRICKS);
        blockWithItem(ModBlocks.BLUE_TIBERCRETE_BRICKS);
        blockWithItem(ModBlocks.BROWN_TIBERCRETE_BRICKS);
        blockWithItem(ModBlocks.CYAN_TIBERCRETE_BRICKS);
        blockWithItem(ModBlocks.GRAY_TIBERCRETE_BRICKS);
        blockWithItem(ModBlocks.GREEN_TIBERCRETE_BRICKS);
        blockWithItem(ModBlocks.LIGHT_BLUE_TIBERCRETE_BRICKS);
        blockWithItem(ModBlocks.LIGHT_GRAY_TIBERCRETE_BRICKS);
        blockWithItem(ModBlocks.LIME_TIBERCRETE_BRICKS);
        blockWithItem(ModBlocks.MAGENTA_TIBERCRETE_BRICKS);
        blockWithItem(ModBlocks.ORANGE_TIBERCRETE_BRICKS);
        blockWithItem(ModBlocks.PINK_TIBERCRETE_BRICKS);
        blockWithItem(ModBlocks.PURPLE_TIBERCRETE_BRICKS);
        blockWithItem(ModBlocks.RED_TIBERCRETE_BRICKS);
        blockWithItem(ModBlocks.WHITE_TIBERCRETE_BRICKS);
        blockWithItem(ModBlocks.YELLOW_TIBERCRETE_BRICKS);

        blockWithItem(ModBlocks.PLAGUED_PLANKS);
        blockWithItem(ModBlocks.EMBER_OAK_PLANKS);
        blockWithItem(ModBlocks.DEAD_PLANKS);
        blockWithItem(ModBlocks.MARIKA_OAK_PLANKS);

        blockWithItem(ModBlocks.TIBERIUM_SOIL);
        blockWithItem(ModBlocks.ICHOR_SOIL);
        blockWithItem(ModBlocks.SOUND_BLOCK);

        //Rotated Pillar Blocks:






        //Wood Blocks:
        logBlock(((RotatedPillarBlock) ModBlocks.PLAGUED_LOG.get()));

        axisBlock(((RotatedPillarBlock) ModBlocks.PLAGUED_WOOD.get()), blockTexture(ModBlocks.PLAGUED_LOG.get()),blockTexture(ModBlocks.PLAGUED_LOG.get()));

        axisBlock(((RotatedPillarBlock) ModBlocks.STRIPPED_PLAGUED_LOG.get()), blockTexture(ModBlocks.STRIPPED_PLAGUED_LOG.get()),
                new ResourceLocation(CrystalTech.MOD_ID, "block/stripped_plagued_log_top"));

        axisBlock(((RotatedPillarBlock) ModBlocks.STRIPPED_PLAGUED_WOOD.get()), blockTexture(ModBlocks.STRIPPED_PLAGUED_LOG.get()),blockTexture(ModBlocks.STRIPPED_PLAGUED_LOG.get()));

        blockItem(ModBlocks.PLAGUED_LOG);
        blockItem(ModBlocks.PLAGUED_WOOD);
        blockItem(ModBlocks.STRIPPED_PLAGUED_LOG);
        blockItem(ModBlocks.STRIPPED_PLAGUED_WOOD);



        leavesBlock(ModBlocks.PLAGUED_LEAVES);

        logBlock(((RotatedPillarBlock) ModBlocks.EMBER_OAK_LOG.get()));
        axisBlock(((RotatedPillarBlock) ModBlocks.EMBER_OAK_WOOD.get()), blockTexture(ModBlocks.EMBER_OAK_LOG.get()),blockTexture(ModBlocks.EMBER_OAK_LOG.get()));

        axisBlock(((RotatedPillarBlock) ModBlocks.STRIPPED_EMBER_OAK_LOG.get()), blockTexture(ModBlocks.STRIPPED_EMBER_OAK_LOG.get()),
                new ResourceLocation(CrystalTech.MOD_ID, "block/stripped_ember_oak_log_top"));

        axisBlock(((RotatedPillarBlock) ModBlocks.STRIPPED_EMBER_OAK_WOOD.get()), blockTexture(ModBlocks.STRIPPED_EMBER_OAK_LOG.get()),blockTexture(ModBlocks.STRIPPED_EMBER_OAK_LOG.get()));

        blockItem(ModBlocks.EMBER_OAK_LOG);
        blockItem(ModBlocks.EMBER_OAK_WOOD);
        blockItem(ModBlocks.STRIPPED_EMBER_OAK_LOG);
        blockItem(ModBlocks.STRIPPED_EMBER_OAK_WOOD);

        leavesBlock(ModBlocks.EMBER_OAK_LEAVES);

        logBlock(((RotatedPillarBlock) ModBlocks.DEAD_LOG.get()));
        axisBlock(((RotatedPillarBlock) ModBlocks.DEAD_WOOD.get()), blockTexture(ModBlocks.DEAD_LOG.get()),blockTexture(ModBlocks.DEAD_LOG.get()));

        axisBlock(((RotatedPillarBlock) ModBlocks.STRIPPED_DEAD_LOG.get()), blockTexture(ModBlocks.STRIPPED_DEAD_LOG.get()),
                new ResourceLocation(CrystalTech.MOD_ID, "block/stripped_dead_log_top"));

        axisBlock(((RotatedPillarBlock) ModBlocks.STRIPPED_DEAD_WOOD.get()), blockTexture(ModBlocks.STRIPPED_DEAD_LOG.get()),blockTexture(ModBlocks.STRIPPED_DEAD_LOG.get()));

        blockItem(ModBlocks.DEAD_LOG);
        blockItem(ModBlocks.DEAD_WOOD);
        blockItem(ModBlocks.STRIPPED_DEAD_LOG);
        blockItem(ModBlocks.STRIPPED_DEAD_WOOD);

        leavesBlock(ModBlocks.DEAD_LEAVES);

        logBlock(((RotatedPillarBlock) ModBlocks.MARIKA_OAK_LOG.get()));
        axisBlock(((RotatedPillarBlock) ModBlocks.MARIKA_OAK_WOOD.get()), blockTexture(ModBlocks.MARIKA_OAK_LOG.get()),blockTexture(ModBlocks.MARIKA_OAK_LOG.get()));

        axisBlock(((RotatedPillarBlock) ModBlocks.STRIPPED_MARIKA_OAK_LOG.get()), blockTexture(ModBlocks.STRIPPED_MARIKA_OAK_LOG.get()),
                new ResourceLocation(CrystalTech.MOD_ID, "block/stripped_marika_oak_log_top"));

        axisBlock(((RotatedPillarBlock) ModBlocks.STRIPPED_MARIKA_OAK_WOOD.get()), blockTexture(ModBlocks.STRIPPED_MARIKA_OAK_LOG.get()),blockTexture(ModBlocks.STRIPPED_MARIKA_OAK_LOG.get()));

        blockItem(ModBlocks.MARIKA_OAK_LOG);
        blockItem(ModBlocks.MARIKA_OAK_WOOD);
        blockItem(ModBlocks.STRIPPED_MARIKA_OAK_LOG);
        blockItem(ModBlocks.STRIPPED_MARIKA_OAK_WOOD);

        leavesBlock(ModBlocks.MARIKA_OAK_LEAVES);

        //Signs:
        signBlock(((StandingSignBlock) ModBlocks.PLAGUED_SIGN.get()), ((WallSignBlock) ModBlocks.PLAGUED_WALL_SIGN.get()),
                blockTexture(ModBlocks.PLAGUED_PLANKS.get()));

        hangingSignBlock(ModBlocks.PLAGUED_HANGING_SIGN.get(), ModBlocks.PLAGUED_WALL_HANGING_SIGN.get(), blockTexture(ModBlocks.PLAGUED_PLANKS.get()));

        signBlock(((StandingSignBlock) ModBlocks.MARIKA_OAK_SIGN.get()), ((WallSignBlock) ModBlocks.MARIKA_OAK_WALL_SIGN.get()),
                blockTexture(ModBlocks.MARIKA_OAK_PLANKS.get()));

        hangingSignBlock(ModBlocks.MARIKA_OAK_HANGING_SIGN.get(), ModBlocks.MARIKA_OAK_WALL_HANGING_SIGN.get(), blockTexture(ModBlocks.MARIKA_OAK_PLANKS.get()));

        signBlock(((StandingSignBlock) ModBlocks.EMBER_OAK_SIGN.get()), ((WallSignBlock) ModBlocks.EMBER_OAK_WALL_SIGN.get()),
                blockTexture(ModBlocks.EMBER_OAK_PLANKS.get()));

        hangingSignBlock(ModBlocks.EMBER_OAK_HANGING_SIGN.get(), ModBlocks.EMBER_OAK_WALL_HANGING_SIGN.get(), blockTexture(ModBlocks.EMBER_OAK_PLANKS.get()));

        signBlock(((StandingSignBlock) ModBlocks.DEAD_SIGN.get()), ((WallSignBlock) ModBlocks.DEAD_WALL_SIGN.get()),
                blockTexture(ModBlocks.DEAD_PLANKS.get()));

        hangingSignBlock(ModBlocks.DEAD_HANGING_SIGN.get(), ModBlocks.DEAD_WALL_HANGING_SIGN.get(), blockTexture(ModBlocks.DEAD_PLANKS.get()));

        //Panel Blocks/ Glass Panes:
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

       //Stairs:
       stairsBlock((StairBlock) ModBlocks.PLAGUED_STAIRS.get(), blockTexture(ModBlocks.PLAGUED_PLANKS.get()));
       stairsBlock((StairBlock) ModBlocks.EMBER_OAK_STAIRS.get(), blockTexture(ModBlocks.EMBER_OAK_PLANKS.get()));
       stairsBlock((StairBlock) ModBlocks.DEAD_STAIRS.get(), blockTexture(ModBlocks.DEAD_PLANKS.get()));
       stairsBlock((StairBlock) ModBlocks.MARIKA_OAK_STAIRS.get(), blockTexture(ModBlocks.MARIKA_OAK_PLANKS.get()));
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

        stairsBlock((StairBlock) ModBlocks.BLACK_TIBERCRETE_BRICK_STAIRS.get(), blockTexture(ModBlocks.BLACK_TIBERCRETE_BRICKS.get()));
        stairsBlock((StairBlock) ModBlocks.BLUE_TIBERCRETE_BRICK_STAIRS.get(), blockTexture(ModBlocks.BLUE_TIBERCRETE_BRICKS.get()));
        stairsBlock((StairBlock) ModBlocks.BROWN_TIBERCRETE_BRICK_STAIRS.get(), blockTexture(ModBlocks.BROWN_TIBERCRETE_BRICKS.get()));
        stairsBlock((StairBlock) ModBlocks.CYAN_TIBERCRETE_BRICK_STAIRS.get(), blockTexture(ModBlocks.CYAN_TIBERCRETE_BRICKS.get()));
        stairsBlock((StairBlock) ModBlocks.GRAY_TIBERCRETE_BRICK_STAIRS.get(), blockTexture(ModBlocks.GRAY_TIBERCRETE_BRICKS.get()));
        stairsBlock((StairBlock) ModBlocks.GREEN_TIBERCRETE_BRICK_STAIRS.get(), blockTexture(ModBlocks.GREEN_TIBERCRETE_BRICKS.get()));
        stairsBlock((StairBlock) ModBlocks.LIGHT_BLUE_TIBERCRETE_BRICK_STAIRS.get(), blockTexture(ModBlocks.LIGHT_BLUE_TIBERCRETE_BRICKS.get()));
        stairsBlock((StairBlock) ModBlocks.LIGHT_GRAY_TIBERCRETE_BRICK_STAIRS.get(), blockTexture(ModBlocks.LIGHT_GRAY_TIBERCRETE_BRICKS.get()));
        stairsBlock((StairBlock) ModBlocks.LIME_TIBERCRETE_BRICK_STAIRS.get(), blockTexture(ModBlocks.LIME_TIBERCRETE_BRICKS.get()));
        stairsBlock((StairBlock) ModBlocks.MAGENTA_TIBERCRETE_BRICK_STAIRS.get(), blockTexture(ModBlocks.MAGENTA_TIBERCRETE_BRICKS.get()));
        stairsBlock((StairBlock) ModBlocks.ORANGE_TIBERCRETE_BRICK_STAIRS.get(), blockTexture(ModBlocks.ORANGE_TIBERCRETE_BRICKS.get()));
        stairsBlock((StairBlock) ModBlocks.PINK_TIBERCRETE_BRICK_STAIRS.get(), blockTexture(ModBlocks.PINK_TIBERCRETE_BRICKS.get()));
        stairsBlock((StairBlock) ModBlocks.PURPLE_TIBERCRETE_BRICK_STAIRS.get(), blockTexture(ModBlocks.PURPLE_TIBERCRETE_BRICKS.get()));
        stairsBlock((StairBlock) ModBlocks.RED_TIBERCRETE_BRICK_STAIRS.get(), blockTexture(ModBlocks.RED_TIBERCRETE_BRICKS.get()));
        stairsBlock((StairBlock) ModBlocks.WHITE_TIBERCRETE_BRICK_STAIRS.get(), blockTexture(ModBlocks.WHITE_TIBERCRETE_BRICKS.get()));
        stairsBlock((StairBlock) ModBlocks.YELLOW_TIBERCRETE_BRICK_STAIRS.get(), blockTexture(ModBlocks.YELLOW_TIBERCRETE_BRICKS.get()));

        stairsBlock((StairBlock) ModBlocks.PLAGUED_ANDESITE_STAIRS.get(), blockTexture(ModBlocks.INFESTED_ANDESITE.get()));
        stairsBlock((StairBlock) ModBlocks.PLAGUED_STONE_STAIRS.get(), blockTexture(ModBlocks.INFESTED_STONE.get()));
        stairsBlock((StairBlock) ModBlocks.PLAGUED_GRANITE_STAIRS.get(), blockTexture(ModBlocks.INFESTED_GRANITE.get()));
        stairsBlock((StairBlock) ModBlocks.PLAGUED_DIORITE_STAIRS.get(), blockTexture(ModBlocks.INFESTED_DIORITE.get()));

        stairsBlock((StairBlock) ModBlocks.RIPARIUS_STONE_STAIRS.get(), blockTexture(ModBlocks.RIPARIUS_STONE.get()));
        stairsBlock((StairBlock) ModBlocks.RIPARIUS_STONE_BRICK_STAIRS.get(), blockTexture(ModBlocks.RIPARIUS_STONE_BRICKS.get()));

        stairsBlock((StairBlock) ModBlocks.VINIFERA_STONE_STAIRS.get(), blockTexture(ModBlocks.VINIFERA_STONE.get()));
        stairsBlock((StairBlock) ModBlocks.VINIFERA_STONE_BRICK_STAIRS.get(), blockTexture(ModBlocks.VINIFERA_STONE_BRICKS.get()));

        stairsBlock((StairBlock) ModBlocks.CRUENTUS_STONE_STAIRS.get(), blockTexture(ModBlocks.CRUENTUS_STONE.get()));
        stairsBlock((StairBlock) ModBlocks.CRUENTUS_STONE_BRICK_STAIRS.get(), blockTexture(ModBlocks.CRUENTUS_STONE_BRICKS.get()));

        stairsBlock((StairBlock) ModBlocks.ABOREUS_STONE_STAIRS.get(), blockTexture(ModBlocks.ABOREUS_STONE.get()));
        stairsBlock((StairBlock) ModBlocks.ABOREUS_STONE_BRICK_STAIRS.get(), blockTexture(ModBlocks.ABOREUS_STONE_BRICKS.get()));

        stairsBlock((StairBlock) ModBlocks.RIPARIUS_CRYSTAL_STAIRS.get(), blockTexture(ModBlocks.RIPARIUS_CRYSTAL.get()));
        stairsBlock((StairBlock) ModBlocks.VINIFERA_CRYSTAL_STAIRS.get(), blockTexture(ModBlocks.VINIFERA_CRYSTAL.get()));
        stairsBlock((StairBlock) ModBlocks.CRUENTUS_CRYSTAL_STAIRS.get(), blockTexture(ModBlocks.CRUENTUS_CRYSTAL.get()));
        stairsBlock((StairBlock) ModBlocks.ABOREUS_CRYSTAL_STAIRS.get(), blockTexture(ModBlocks.ABOREUS_CRYSTAL.get()));

        //Slabs:
       slabBlock((SlabBlock) ModBlocks.PLAGUED_SLAB.get(), blockTexture(ModBlocks.PLAGUED_PLANKS.get()), blockTexture(ModBlocks.PLAGUED_PLANKS.get()));
       slabBlock((SlabBlock) ModBlocks.EMBER_OAK_SLAB.get(), blockTexture(ModBlocks.EMBER_OAK_PLANKS.get()), blockTexture(ModBlocks.EMBER_OAK_PLANKS.get()));
       slabBlock((SlabBlock) ModBlocks.DEAD_SLAB.get(), blockTexture(ModBlocks.DEAD_PLANKS.get()), blockTexture(ModBlocks.DEAD_PLANKS.get()));
       slabBlock((SlabBlock) ModBlocks.MARIKA_OAK_SLAB.get(), blockTexture(ModBlocks.MARIKA_OAK_PLANKS.get()), blockTexture(ModBlocks.MARIKA_OAK_PLANKS.get()));
       slabBlock((SlabBlock) ModBlocks.INFESTED_STONE_BRICK_SLAB.get(), blockTexture(ModBlocks.INFESTED_STONE_BRICKS.get()), blockTexture(ModBlocks.INFESTED_STONE_BRICKS.get()));
       slabBlock((SlabBlock) ModBlocks.INFESTED_COBBLE_SLAB.get(), blockTexture(ModBlocks.INFESTED_COBBLE.get()), blockTexture(ModBlocks.INFESTED_COBBLE.get()));
       slabBlock((SlabBlock) ModBlocks.PLAGUED_STONE_SLAB.get(), blockTexture(ModBlocks.INFESTED_STONE.get()), blockTexture(ModBlocks.INFESTED_STONE.get()));
       slabBlock((SlabBlock) ModBlocks.PLAGUED_GRANITE_SLAB.get(), blockTexture(ModBlocks.INFESTED_GRANITE.get()), blockTexture(ModBlocks.INFESTED_GRANITE.get()));
       slabBlock((SlabBlock) ModBlocks.PLAGUED_DIORITE_SLAB.get(), blockTexture(ModBlocks.INFESTED_DIORITE.get()), blockTexture(ModBlocks.INFESTED_DIORITE.get()));

        slabBlock((SlabBlock) ModBlocks.BLACK_TIBERCRETE_SLAB.get(), blockTexture(ModBlocks.BLACK_TIBERCRETE.get()), blockTexture(ModBlocks.BLACK_TIBERCRETE.get()));
        slabBlock((SlabBlock) ModBlocks.BLUE_TIBERCRETE_SLAB.get(), blockTexture(ModBlocks.BLUE_TIBERCRETE.get()), blockTexture(ModBlocks.BLUE_TIBERCRETE.get()));
        slabBlock((SlabBlock) ModBlocks.BROWN_TIBERCRETE_SLAB.get(), blockTexture(ModBlocks.BROWN_TIBERCRETE.get()), blockTexture(ModBlocks.BROWN_TIBERCRETE.get()));
        slabBlock((SlabBlock) ModBlocks.CYAN_TIBERCRETE_SLAB.get(), blockTexture(ModBlocks.CYAN_TIBERCRETE.get()), blockTexture(ModBlocks.CYAN_TIBERCRETE.get()));
        slabBlock((SlabBlock) ModBlocks.GRAY_TIBERCRETE_SLAB.get(), blockTexture(ModBlocks.GRAY_TIBERCRETE.get()), blockTexture(ModBlocks.GRAY_TIBERCRETE.get()));
        slabBlock((SlabBlock) ModBlocks.GREEN_TIBERCRETE_SLAB.get(), blockTexture(ModBlocks.GREEN_TIBERCRETE.get()), blockTexture(ModBlocks.GREEN_TIBERCRETE.get()));
        slabBlock((SlabBlock) ModBlocks.LIGHT_BLUE_TIBERCRETE_SLAB.get(), blockTexture(ModBlocks.LIGHT_BLUE_TIBERCRETE.get()), blockTexture(ModBlocks.LIGHT_BLUE_TIBERCRETE.get()));
        slabBlock((SlabBlock) ModBlocks.LIGHT_GRAY_TIBERCRETE_SLAB.get(), blockTexture(ModBlocks.LIGHT_GRAY_TIBERCRETE.get()), blockTexture(ModBlocks.LIGHT_GRAY_TIBERCRETE.get()));
        slabBlock((SlabBlock) ModBlocks.LIME_TIBERCRETE_SLAB.get(), blockTexture(ModBlocks.LIME_TIBERCRETE.get()), blockTexture(ModBlocks.LIME_TIBERCRETE.get()));
        slabBlock((SlabBlock) ModBlocks.MAGENTA_TIBERCRETE_SLAB.get(), blockTexture(ModBlocks.MAGENTA_TIBERCRETE.get()), blockTexture(ModBlocks.MAGENTA_TIBERCRETE.get()));
        slabBlock((SlabBlock) ModBlocks.ORANGE_TIBERCRETE_SLAB.get(), blockTexture(ModBlocks.ORANGE_TIBERCRETE.get()), blockTexture(ModBlocks.ORANGE_TIBERCRETE.get()));
        slabBlock((SlabBlock) ModBlocks.PINK_TIBERCRETE_SLAB.get(), blockTexture(ModBlocks.PINK_TIBERCRETE.get()), blockTexture(ModBlocks.PINK_TIBERCRETE.get()));
        slabBlock((SlabBlock) ModBlocks.PURPLE_TIBERCRETE_SLAB.get(), blockTexture(ModBlocks.PURPLE_TIBERCRETE.get()), blockTexture(ModBlocks.PURPLE_TIBERCRETE.get()));
        slabBlock((SlabBlock) ModBlocks.RED_TIBERCRETE_SLAB.get(), blockTexture(ModBlocks.RED_TIBERCRETE.get()), blockTexture(ModBlocks.RED_TIBERCRETE.get()));
        slabBlock((SlabBlock) ModBlocks.WHITE_TIBERCRETE_SLAB.get(), blockTexture(ModBlocks.WHITE_TIBERCRETE.get()), blockTexture(ModBlocks.WHITE_TIBERCRETE.get()));
        slabBlock((SlabBlock) ModBlocks.YELLOW_TIBERCRETE_SLAB.get(), blockTexture(ModBlocks.YELLOW_TIBERCRETE.get()), blockTexture(ModBlocks.YELLOW_TIBERCRETE.get()));

        slabBlock((SlabBlock) ModBlocks.BLACK_TIBERCRETE_BRICK_SLAB.get(), blockTexture(ModBlocks.BLACK_TIBERCRETE_BRICKS.get()), blockTexture(ModBlocks.BLACK_TIBERCRETE_BRICKS.get()));
        slabBlock((SlabBlock) ModBlocks.BLUE_TIBERCRETE_BRICK_SLAB.get(), blockTexture(ModBlocks.BLUE_TIBERCRETE_BRICKS.get()), blockTexture(ModBlocks.BLUE_TIBERCRETE_BRICKS.get()));
        slabBlock((SlabBlock) ModBlocks.BROWN_TIBERCRETE_BRICK_SLAB.get(), blockTexture(ModBlocks.BROWN_TIBERCRETE_BRICKS.get()), blockTexture(ModBlocks.BROWN_TIBERCRETE_BRICKS.get()));
        slabBlock((SlabBlock) ModBlocks.CYAN_TIBERCRETE_BRICK_SLAB.get(), blockTexture(ModBlocks.CYAN_TIBERCRETE_BRICKS.get()), blockTexture(ModBlocks.CYAN_TIBERCRETE_BRICKS.get()));
        slabBlock((SlabBlock) ModBlocks.GRAY_TIBERCRETE_BRICK_SLAB.get(), blockTexture(ModBlocks.GRAY_TIBERCRETE_BRICKS.get()), blockTexture(ModBlocks.GRAY_TIBERCRETE_BRICKS.get()));
        slabBlock((SlabBlock) ModBlocks.GREEN_TIBERCRETE_BRICK_SLAB.get(), blockTexture(ModBlocks.GREEN_TIBERCRETE_BRICKS.get()), blockTexture(ModBlocks.GREEN_TIBERCRETE_BRICKS.get()));
        slabBlock((SlabBlock) ModBlocks.LIGHT_BLUE_TIBERCRETE_BRICK_SLAB.get(), blockTexture(ModBlocks.LIGHT_BLUE_TIBERCRETE_BRICKS.get()), blockTexture(ModBlocks.LIGHT_BLUE_TIBERCRETE_BRICKS.get()));
        slabBlock((SlabBlock) ModBlocks.LIGHT_GRAY_TIBERCRETE_BRICK_SLAB.get(), blockTexture(ModBlocks.LIGHT_GRAY_TIBERCRETE_BRICKS.get()), blockTexture(ModBlocks.LIGHT_GRAY_TIBERCRETE_BRICKS.get()));
        slabBlock((SlabBlock) ModBlocks.LIME_TIBERCRETE_BRICK_SLAB.get(), blockTexture(ModBlocks.LIME_TIBERCRETE_BRICKS.get()), blockTexture(ModBlocks.LIME_TIBERCRETE_BRICKS.get()));
        slabBlock((SlabBlock) ModBlocks.MAGENTA_TIBERCRETE_BRICK_SLAB.get(), blockTexture(ModBlocks.MAGENTA_TIBERCRETE_BRICKS.get()), blockTexture(ModBlocks.MAGENTA_TIBERCRETE_BRICKS.get()));
        slabBlock((SlabBlock) ModBlocks.ORANGE_TIBERCRETE_BRICK_SLAB.get(), blockTexture(ModBlocks.ORANGE_TIBERCRETE_BRICKS.get()), blockTexture(ModBlocks.ORANGE_TIBERCRETE_BRICKS.get()));
        slabBlock((SlabBlock) ModBlocks.PINK_TIBERCRETE_BRICK_SLAB.get(), blockTexture(ModBlocks.PINK_TIBERCRETE_BRICKS.get()), blockTexture(ModBlocks.PINK_TIBERCRETE_BRICKS.get()));
        slabBlock((SlabBlock) ModBlocks.PURPLE_TIBERCRETE_BRICK_SLAB.get(), blockTexture(ModBlocks.PURPLE_TIBERCRETE_BRICKS.get()), blockTexture(ModBlocks.PURPLE_TIBERCRETE_BRICKS.get()));
        slabBlock((SlabBlock) ModBlocks.RED_TIBERCRETE_BRICK_SLAB.get(), blockTexture(ModBlocks.RED_TIBERCRETE_BRICKS.get()), blockTexture(ModBlocks.RED_TIBERCRETE_BRICKS.get()));
        slabBlock((SlabBlock) ModBlocks.WHITE_TIBERCRETE_BRICK_SLAB.get(), blockTexture(ModBlocks.WHITE_TIBERCRETE_BRICKS.get()), blockTexture(ModBlocks.WHITE_TIBERCRETE_BRICKS.get()));
        slabBlock((SlabBlock) ModBlocks.YELLOW_TIBERCRETE_BRICK_SLAB.get(), blockTexture(ModBlocks.YELLOW_TIBERCRETE_BRICKS.get()), blockTexture(ModBlocks.YELLOW_TIBERCRETE_BRICKS.get()));

        slabBlock((SlabBlock) ModBlocks.PLAGUED_ANDESITE_SLAB.get(), blockTexture(ModBlocks.INFESTED_ANDESITE.get()), blockTexture(ModBlocks.INFESTED_ANDESITE.get()));

        slabBlock((SlabBlock) ModBlocks.RIPARIUS_STONE_SLAB.get(), blockTexture(ModBlocks.RIPARIUS_STONE.get()), blockTexture(ModBlocks.RIPARIUS_STONE.get()));
        slabBlock((SlabBlock) ModBlocks.RIPARIUS_STONE_BRICK_SLAB.get(), blockTexture(ModBlocks.RIPARIUS_STONE_BRICKS.get()), blockTexture(ModBlocks.RIPARIUS_STONE_BRICKS.get()));

        slabBlock((SlabBlock) ModBlocks.ABOREUS_STONE_SLAB.get(), blockTexture(ModBlocks.ABOREUS_STONE.get()), blockTexture(ModBlocks.ABOREUS_STONE.get()));
        slabBlock((SlabBlock) ModBlocks.ABOREUS_STONE_BRICK_SLAB.get(), blockTexture(ModBlocks.ABOREUS_STONE_BRICKS.get()), blockTexture(ModBlocks.ABOREUS_STONE_BRICKS.get()));

        slabBlock((SlabBlock) ModBlocks.CRUENTUS_STONE_SLAB.get(), blockTexture(ModBlocks.CRUENTUS_STONE.get()), blockTexture(ModBlocks.CRUENTUS_STONE.get()));
        slabBlock((SlabBlock) ModBlocks.CRUENTUS_STONE_BRICK_SLAB.get(), blockTexture(ModBlocks.CRUENTUS_STONE_BRICKS.get()), blockTexture(ModBlocks.CRUENTUS_STONE_BRICKS.get()));

        slabBlock((SlabBlock) ModBlocks.VINIFERA_STONE_SLAB.get(), blockTexture(ModBlocks.VINIFERA_STONE.get()), blockTexture(ModBlocks.VINIFERA_STONE.get()));
        slabBlock((SlabBlock) ModBlocks.VINIFERA_STONE_BRICK_SLAB.get(), blockTexture(ModBlocks.VINIFERA_STONE_BRICKS.get()), blockTexture(ModBlocks.VINIFERA_STONE_BRICKS.get()));

        slabBlock((SlabBlock) ModBlocks.RIPARIUS_CRYSTAL_SLAB.get(), blockTexture(ModBlocks.RIPARIUS_CRYSTAL.get()), blockTexture(ModBlocks.RIPARIUS_CRYSTAL.get()));
        slabBlock((SlabBlock) ModBlocks.ABOREUS_CRYSTAL_SLAB.get(), blockTexture(ModBlocks.ABOREUS_CRYSTAL.get()), blockTexture(ModBlocks.ABOREUS_CRYSTAL.get()));
        slabBlock((SlabBlock) ModBlocks.CRUENTUS_CRYSTAL_SLAB.get(), blockTexture(ModBlocks.CRUENTUS_CRYSTAL.get()), blockTexture(ModBlocks.CRUENTUS_CRYSTAL.get()));
        slabBlock((SlabBlock) ModBlocks.VINIFERA_CRYSTAL_SLAB.get(), blockTexture(ModBlocks.VINIFERA_CRYSTAL.get()), blockTexture(ModBlocks.VINIFERA_CRYSTAL.get()));

        //Buttons and Pressure Plates:
        buttonBlock((ButtonBlock) ModBlocks.PLAGUED_BUTTON.get(), blockTexture(ModBlocks.PLAGUED_PLANKS.get()));
        pressurePlateBlock((PressurePlateBlock) ModBlocks.PLAGUED_PRESSURE_PLATE.get(), blockTexture(ModBlocks.PLAGUED_PLANKS.get()));
        buttonBlock((ButtonBlock) ModBlocks.EMBER_OAK_BUTTON.get(), blockTexture(ModBlocks.EMBER_OAK_PLANKS.get()));
        pressurePlateBlock((PressurePlateBlock) ModBlocks.EMBER_OAK_PRESSURE_PLATE.get(), blockTexture(ModBlocks.EMBER_OAK_PLANKS.get()));

        buttonBlock((ButtonBlock) ModBlocks.DEAD_BUTTON.get(), blockTexture(ModBlocks.DEAD_PLANKS.get()));
        pressurePlateBlock((PressurePlateBlock) ModBlocks.DEAD_PRESSURE_PLATE.get(), blockTexture(ModBlocks.DEAD_PLANKS.get()));

        buttonBlock((ButtonBlock) ModBlocks.MARIKA_OAK_BUTTON.get(), blockTexture(ModBlocks.MARIKA_OAK_PLANKS.get()));
        pressurePlateBlock((PressurePlateBlock) ModBlocks.MARIKA_OAK_PRESSURE_PLATE.get(), blockTexture(ModBlocks.MARIKA_OAK_PLANKS.get()));

        //Fences and Fence Gates:
        fenceBlock((FenceBlock) ModBlocks.PLAGUED_FENCE.get(), blockTexture(ModBlocks.PLAGUED_PLANKS.get()));
        fenceGateBlock((FenceGateBlock) ModBlocks.PLAGUED_FENCE_GATE.get(), blockTexture(ModBlocks.PLAGUED_PLANKS.get()));
        fenceBlock((FenceBlock) ModBlocks.EMBER_OAK_FENCE.get(), blockTexture(ModBlocks.EMBER_OAK_PLANKS.get()));
        fenceGateBlock((FenceGateBlock) ModBlocks.EMBER_OAK_FENCE_GATE.get(), blockTexture(ModBlocks.EMBER_OAK_PLANKS.get()));

        fenceBlock((FenceBlock) ModBlocks.DEAD_FENCE.get(), blockTexture(ModBlocks.DEAD_PLANKS.get()));
        fenceGateBlock((FenceGateBlock) ModBlocks.DEAD_FENCE_GATE.get(), blockTexture(ModBlocks.DEAD_PLANKS.get()));

        fenceBlock((FenceBlock) ModBlocks.MARIKA_OAK_FENCE.get(), blockTexture(ModBlocks.MARIKA_OAK_PLANKS.get()));
        fenceGateBlock((FenceGateBlock) ModBlocks.MARIKA_OAK_FENCE_GATE.get(), blockTexture(ModBlocks.MARIKA_OAK_PLANKS.get()));

        //Doors and Trapdoors:
        doorBlockWithRenderType((((DoorBlock) ModBlocks.PLAGUED_DOOR.get())), modLoc("block/plagued_door_bottom"), modLoc("block/plagued_door_top"), "cutout");
        trapdoorBlockWithRenderType((((TrapDoorBlock) ModBlocks.PLAGUED_TRAPDOOR.get())), modLoc("block/plagued_trapdoor"), true, "cutout");
        doorBlockWithRenderType((((DoorBlock) ModBlocks.EMBER_OAK_DOOR.get())), modLoc("block/ember_oak_door_bottom"), modLoc("block/ember_oak_door_top"), "cutout");
        trapdoorBlockWithRenderType((((TrapDoorBlock) ModBlocks.EMBER_OAK_TRAPDOOR.get())), modLoc("block/ember_oak_trapdoor"), true, "cutout");

        doorBlockWithRenderType((((DoorBlock) ModBlocks.DEAD_DOOR.get())), modLoc("block/dead_door_bottom"), modLoc("block/dead_door_top"), "cutout");
        trapdoorBlockWithRenderType((((TrapDoorBlock) ModBlocks.DEAD_TRAPDOOR.get())), modLoc("block/dead_trapdoor"), true, "cutout");

        doorBlockWithRenderType((((DoorBlock) ModBlocks.MARIKA_OAK_DOOR.get())), modLoc("block/marika_oak_door_bottom"), modLoc("block/marika_oak_door_top"), "cutout");
        trapdoorBlockWithRenderType((((TrapDoorBlock) ModBlocks.MARIKA_OAK_TRAPDOOR.get())), modLoc("block/marika_oak_trapdoor"), true, "cutout");

        //Walls:
        wallBlock((((WallBlock) ModBlocks.FIRESTONE_WALL.get())), blockTexture(( ModBlocks.FIRESTONE_BLOCK.get())));
        wallBlock((((WallBlock) ModBlocks.INFESTED_COBBLE_WALL.get())), blockTexture(( ModBlocks.INFESTED_COBBLE.get())));
        wallBlock((((WallBlock) ModBlocks.INFESTED_STONE_BRICK_WALL.get())), blockTexture(( ModBlocks.INFESTED_STONE_BRICKS.get())));
        wallBlock((((WallBlock) ModBlocks.PLAGUED_ANDESITE_WALL.get())), blockTexture(( ModBlocks.INFESTED_ANDESITE.get())));
        wallBlock((((WallBlock) ModBlocks.PLAGUED_STONE_WALL.get())), blockTexture(( ModBlocks.INFESTED_STONE.get())));
        wallBlock((((WallBlock) ModBlocks.PLAGUED_GRANITE_WALL.get())), blockTexture(( ModBlocks.INFESTED_GRANITE.get())));
        wallBlock((((WallBlock) ModBlocks.PLAGUED_DIORITE_WALL.get())), blockTexture(( ModBlocks.INFESTED_DIORITE.get())));

        wallBlock((((WallBlock) ModBlocks.RIPARIUS_STONE_WALL.get())), blockTexture(( ModBlocks.RIPARIUS_STONE.get())));
        wallBlock((((WallBlock) ModBlocks.RIPARIUS_STONE_BRICK_WALL.get())), blockTexture(( ModBlocks.RIPARIUS_STONE_BRICKS.get())));

        wallBlock((((WallBlock) ModBlocks.VINIFERA_STONE_WALL.get())), blockTexture(( ModBlocks.VINIFERA_STONE.get())));
        wallBlock((((WallBlock) ModBlocks.VINIFERA_STONE_BRICK_WALL.get())), blockTexture(( ModBlocks.VINIFERA_STONE_BRICKS.get())));

        wallBlock((((WallBlock) ModBlocks.CRUENTUS_STONE_WALL.get())), blockTexture(( ModBlocks.CRUENTUS_STONE.get())));
        wallBlock((((WallBlock) ModBlocks.CRUENTUS_STONE_BRICK_WALL.get())), blockTexture(( ModBlocks.CRUENTUS_STONE_BRICKS.get())));

        wallBlock((((WallBlock) ModBlocks.ABOREUS_STONE_WALL.get())), blockTexture(( ModBlocks.ABOREUS_STONE.get())));
        wallBlock((((WallBlock) ModBlocks.ABOREUS_STONE_BRICK_WALL.get())), blockTexture(( ModBlocks.ABOREUS_STONE_BRICKS.get())));

        wallBlock((((WallBlock) ModBlocks.RIPARIUS_CRYSTAL_WALL.get())), blockTexture(( ModBlocks.RIPARIUS_CRYSTAL.get())));
        wallBlock((((WallBlock) ModBlocks.VINIFERA_CRYSTAL_WALL.get())), blockTexture(( ModBlocks.VINIFERA_CRYSTAL.get())));
        wallBlock((((WallBlock) ModBlocks.CRUENTUS_CRYSTAL_WALL.get())), blockTexture(( ModBlocks.CRUENTUS_CRYSTAL.get())));
        wallBlock((((WallBlock) ModBlocks.ABOREUS_CRYSTAL_WALL.get())), blockTexture(( ModBlocks.ABOREUS_CRYSTAL.get())));

        wallBlock((((WallBlock) ModBlocks.BLACK_TIBERCRETE_WALL.get())), blockTexture(( ModBlocks.BLACK_TIBERCRETE.get())));
        wallBlock((((WallBlock) ModBlocks.BLUE_TIBERCRETE_WALL.get())), blockTexture(( ModBlocks.BLUE_TIBERCRETE.get())));
        wallBlock((((WallBlock) ModBlocks.BROWN_TIBERCRETE_WALL.get())), blockTexture(( ModBlocks.BROWN_TIBERCRETE.get())));
        wallBlock((((WallBlock) ModBlocks.CYAN_TIBERCRETE_WALL.get())), blockTexture(( ModBlocks.CYAN_TIBERCRETE.get())));
        wallBlock((((WallBlock) ModBlocks.GRAY_TIBERCRETE_WALL.get())), blockTexture(( ModBlocks.GRAY_TIBERCRETE.get())));
        wallBlock((((WallBlock) ModBlocks.GREEN_TIBERCRETE_WALL.get())), blockTexture(( ModBlocks.GREEN_TIBERCRETE.get())));
        wallBlock((((WallBlock) ModBlocks.LIGHT_BLUE_TIBERCRETE_WALL.get())), blockTexture(( ModBlocks.LIGHT_BLUE_TIBERCRETE.get())));
        wallBlock((((WallBlock) ModBlocks.LIGHT_GRAY_TIBERCRETE_WALL.get())), blockTexture(( ModBlocks.LIGHT_GRAY_TIBERCRETE.get())));
        wallBlock((((WallBlock) ModBlocks.LIME_TIBERCRETE_WALL.get())), blockTexture(( ModBlocks.LIME_TIBERCRETE.get())));
        wallBlock((((WallBlock) ModBlocks.MAGENTA_TIBERCRETE_WALL.get())), blockTexture(( ModBlocks.MAGENTA_TIBERCRETE.get())));
        wallBlock((((WallBlock) ModBlocks.ORANGE_TIBERCRETE_WALL.get())), blockTexture(( ModBlocks.ORANGE_TIBERCRETE.get())));
        wallBlock((((WallBlock) ModBlocks.PINK_TIBERCRETE_WALL.get())), blockTexture(( ModBlocks.PINK_TIBERCRETE.get())));
        wallBlock((((WallBlock) ModBlocks.PURPLE_TIBERCRETE_WALL.get())), blockTexture(( ModBlocks.PURPLE_TIBERCRETE.get())));
        wallBlock((((WallBlock) ModBlocks.RED_TIBERCRETE_WALL.get())), blockTexture(( ModBlocks.RED_TIBERCRETE.get())));
        wallBlock((((WallBlock) ModBlocks.WHITE_TIBERCRETE_WALL.get())), blockTexture(( ModBlocks.WHITE_TIBERCRETE.get())));
        wallBlock((((WallBlock) ModBlocks.YELLOW_TIBERCRETE_WALL.get())), blockTexture(( ModBlocks.YELLOW_TIBERCRETE.get())));

        wallBlock((((WallBlock) ModBlocks.BLACK_TIBERCRETE_BRICK_WALL.get())), blockTexture(( ModBlocks.BLACK_TIBERCRETE_BRICKS.get())));
        wallBlock((((WallBlock) ModBlocks.BLUE_TIBERCRETE_BRICK_WALL.get())), blockTexture(( ModBlocks.BLUE_TIBERCRETE_BRICKS.get())));
        wallBlock((((WallBlock) ModBlocks.BROWN_TIBERCRETE_BRICK_WALL.get())), blockTexture(( ModBlocks.BROWN_TIBERCRETE_BRICKS.get())));
        wallBlock((((WallBlock) ModBlocks.CYAN_TIBERCRETE_BRICK_WALL.get())), blockTexture(( ModBlocks.CYAN_TIBERCRETE_BRICKS.get())));
        wallBlock((((WallBlock) ModBlocks.GRAY_TIBERCRETE_BRICK_WALL.get())), blockTexture(( ModBlocks.GRAY_TIBERCRETE_BRICKS.get())));
        wallBlock((((WallBlock) ModBlocks.GREEN_TIBERCRETE_BRICK_WALL.get())), blockTexture(( ModBlocks.GREEN_TIBERCRETE_BRICKS.get())));
        wallBlock((((WallBlock) ModBlocks.LIGHT_BLUE_TIBERCRETE_BRICK_WALL.get())), blockTexture(( ModBlocks.LIGHT_BLUE_TIBERCRETE_BRICKS.get())));
        wallBlock((((WallBlock) ModBlocks.LIGHT_GRAY_TIBERCRETE_BRICK_WALL.get())), blockTexture(( ModBlocks.LIGHT_GRAY_TIBERCRETE_BRICKS.get())));
        wallBlock((((WallBlock) ModBlocks.LIME_TIBERCRETE_BRICK_WALL.get())), blockTexture(( ModBlocks.LIME_TIBERCRETE_BRICKS.get())));
        wallBlock((((WallBlock) ModBlocks.MAGENTA_TIBERCRETE_BRICK_WALL.get())), blockTexture(( ModBlocks.MAGENTA_TIBERCRETE_BRICKS.get())));
        wallBlock((((WallBlock) ModBlocks.ORANGE_TIBERCRETE_BRICK_WALL.get())), blockTexture(( ModBlocks.ORANGE_TIBERCRETE_BRICKS.get())));
        wallBlock((((WallBlock) ModBlocks.PINK_TIBERCRETE_BRICK_WALL.get())), blockTexture(( ModBlocks.PINK_TIBERCRETE_BRICKS.get())));
        wallBlock((((WallBlock) ModBlocks.PURPLE_TIBERCRETE_BRICK_WALL.get())), blockTexture(( ModBlocks.PURPLE_TIBERCRETE_BRICKS.get())));
        wallBlock((((WallBlock) ModBlocks.RED_TIBERCRETE_BRICK_WALL.get())), blockTexture(( ModBlocks.RED_TIBERCRETE_BRICKS.get())));
        wallBlock((((WallBlock) ModBlocks.WHITE_TIBERCRETE_BRICK_WALL.get())), blockTexture(( ModBlocks.WHITE_TIBERCRETE_BRICKS.get())));
        wallBlock((((WallBlock) ModBlocks.YELLOW_TIBERCRETE_BRICK_WALL.get())), blockTexture(( ModBlocks.YELLOW_TIBERCRETE_BRICKS.get())));


        //Crops and Plants:
        makeStrawberryCrop((CropBlock) ModBlocks.STRAWBERRY_CROP.get(), "strawberry_stage", "strawberry_stage");

        makeCornCrop((CropBlock) ModBlocks.CORN_CROP.get(), "corn_stage_", "corn_stage_");

        simpleBlockWithItem(ModBlocks.HYACINTH.get(), models().cross(blockTexture(ModBlocks.HYACINTH.get()).getPath(),
                blockTexture(ModBlocks.HYACINTH.get())).renderType("cutout"));

        simpleBlockWithItem(ModBlocks.FLOWER_OF_LIFE.get(), models().cross(blockTexture(ModBlocks.FLOWER_OF_LIFE.get()).getPath(),
                blockTexture(ModBlocks.FLOWER_OF_LIFE.get())).renderType("cutout"));

        simpleBlockWithItem(ModBlocks.DEVILS_BLOOD.get(), models().cross(blockTexture(ModBlocks.DEVILS_BLOOD.get()).getPath(),
                blockTexture(ModBlocks.DEVILS_BLOOD.get())).renderType("cutout"));

        simpleBlockWithItem(ModBlocks.SPITFIRE.get(), models().cross(blockTexture(ModBlocks.SPITFIRE.get()).getPath(),
                blockTexture(ModBlocks.SPITFIRE.get())).renderType("cutout"));

        simpleBlockWithItem(ModBlocks.FULGURBLOOM.get(), models().cross(blockTexture(ModBlocks.FULGURBLOOM.get()).getPath(),
                blockTexture(ModBlocks.FULGURBLOOM.get())).renderType("cutout"));

        simpleBlockWithItem(ModBlocks.POTTED_HYACINTH.get(), models().singleTexture("potted_hyacinth",
                new ResourceLocation("flower_pot_cross"), "plant",
                blockTexture(ModBlocks.HYACINTH.get())).renderType("cutout"));

        simpleBlockWithItem(ModBlocks.POTTED_FLOWER_OF_LIFE.get(), models().singleTexture("potted_flower_of_life",
                new ResourceLocation("flower_pot_cross"), "plant",
                blockTexture(ModBlocks.FLOWER_OF_LIFE.get())).renderType("cutout"));

        simpleBlockWithItem(ModBlocks.POTTED_DEVILS_BLOOD.get(), models().singleTexture("potted_devils_blood",
                new ResourceLocation("flower_pot_cross"), "plant",
                blockTexture(ModBlocks.DEVILS_BLOOD.get())).renderType("cutout"));

        simpleBlockWithItem(ModBlocks.POTTED_SPITFIRE.get(), models().singleTexture("potted_spitfire",
                new ResourceLocation("flower_pot_cross"), "plant",
                blockTexture(ModBlocks.SPITFIRE.get())).renderType("cutout"));

        simpleBlockWithItem(ModBlocks.POTTED_FULGURBLOOM.get(), models().singleTexture("potted_fulgurbloom",
                new ResourceLocation("flower_pot_cross"), "plant",
                blockTexture(ModBlocks.FULGURBLOOM.get())).renderType("cutout"));


        // Machines and other Block Entities:
        simpleBlockWithItem(ModBlocks.TIBERIUM_GRINDER.get(),
                new ModelFile.UncheckedModelFile(modLoc("block/tiberium_grinder")));


        //Lights, Lamps, and Torch-Likes:
        customLamp(ModBlocks.CRYSTAL_CORE_LAMP_G.get(), CrystalCoreLampBlock.LIT, "crystal_core_lamp_g");
        invertedCustomLamp(ModBlocks.INVERTED_CRYSTAL_CORE_LAMP_G.get(), CrystalCoreLampBlock.LIT, "inverted_crystal_core_lamp_g");
        customLamp(ModBlocks.CRYSTAL_CORE_LAMP_B.get(), CrystalCoreLampBlock.LIT, "crystal_core_lamp_b");
        invertedCustomLamp(ModBlocks.INVERTED_CRYSTAL_CORE_LAMP_B.get(), CrystalCoreLampBlock.LIT, "inverted_crystal_core_lamp_b");
        customLamp(ModBlocks.CRYSTAL_CORE_LAMP_R.get(), CrystalCoreLampBlock.LIT, "crystal_core_lamp_r");
        invertedCustomLamp(ModBlocks.INVERTED_CRYSTAL_CORE_LAMP_R.get(), CrystalCoreLampBlock.LIT, "inverted_crystal_core_lamp_r");
        customLamp(ModBlocks.CRYSTAL_CORE_LAMP_P.get(), CrystalCoreLampBlock.LIT, "crystal_core_lamp_p");
        invertedCustomLamp(ModBlocks.INVERTED_CRYSTAL_CORE_LAMP_P.get(), CrystalCoreLampBlock.LIT, "inverted_crystal_core_lamp_p");

        customLamp(ModBlocks.CRYSTAL_CORE_LIGHT.get(), CrystalCoreLampBlock.LIT, "crystal_core_light");
        invertedCustomLamp(ModBlocks.INVERTED_CRYSTAL_CORE_LIGHT.get(), CrystalCoreLampBlock.LIT, "inverted_crystal_core_light");


        //Horizontal Blocks:
        horizontalBlock(ModBlocks.TIBERIUM_INFUSER.get(),
                new ModelFile.UncheckedModelFile(modLoc("block/tiberium_infuser")));

    }

    // All-purpose Custom Lamp method by Hrodebert:
    // Creation example: customLamp(ModBlocks.TUNGSTEN_LAMP.get(),TungstenLamp.LIT,"tungsten_lamp");
    private void customLamp(Block block, BooleanProperty property, String name) {
        getVariantBuilder(block).forAllStates(state -> {
            String name_on = name + "_on";
            String name_off = name + "_off";
            if(state.getValue(property)) {

                return new ConfiguredModel[]{new ConfiguredModel(models().cubeAll(name_on,
                        new ResourceLocation(CrystalTech.MOD_ID, "block/" + name_on)))};
            } else {
                return new ConfiguredModel[]{new ConfiguredModel(models().cubeAll(name_off,
                        new ResourceLocation(CrystalTech.MOD_ID, "block/" + name)))};
            }
        });
        String name_off = name + "_off";
        simpleBlockItem(block, models().cubeAll(name,
                new ResourceLocation(CrystalTech.MOD_ID, "block/" + name_off)));
    }


    private void invertedCustomLamp(Block block, BooleanProperty property, String name) {
        getVariantBuilder(block).forAllStates(state -> {
            String name_off = name + "_off";
            String name_on = name + "_on";
            if(state.getValue(property)) {

                return new ConfiguredModel[]{new ConfiguredModel(models().cubeAll(name_off,
                        new ResourceLocation(CrystalTech.MOD_ID, "block/" + name_off)))};
            } else {
                return new ConfiguredModel[]{new ConfiguredModel(models().cubeAll(name_on,
                        new ResourceLocation(CrystalTech.MOD_ID, "block/" + name_on)))};
            }
        });
        String name_on = name + "_on";
        simpleBlockItem(block, models().cubeAll(name,
                new ResourceLocation(CrystalTech.MOD_ID, "block/" + name)));
    }


    //Kaupenjoes Custom Lamp Method:
//    private void customLamp() {
//        getVariantBuilder(ModBlocks.CRYSTAL_CORE_LAMP.get()).forAllStates(state -> {
//            if(state.getValue(CrystalCoreLampDemo.CLICKED)) {
//                return new ConfiguredModel[]{new ConfiguredModel(models().cubeAll("crystal_core_lamp_on",
//                        new ResourceLocation(CrystalTech.MOD_ID, "block/" + "crystal_core_lamp_on")))};
//            } else {
//                return new ConfiguredModel[]{new ConfiguredModel(models().cubeAll("crystal_core_lamp_off",
//                        new ResourceLocation(CrystalTech.MOD_ID, "block/" +"crystal_core_lamp_off")))};
//            }
//        });
//
//        simpleBlockItem(ModBlocks.CRYSTAL_CORE_LAMP.get(), models().cubeAll("crystal_core_lamp_on",
//                new ResourceLocation(CrystalTech.MOD_ID, "block/" +"crystal_core_lamp_on")));
//    }

    public void hangingSignBlock(Block signBlock, Block wallSignBlock, ResourceLocation texture) {
        ModelFile sign = models().sign(name(signBlock), texture);
        hangingSignBlock(signBlock, wallSignBlock, sign);
    }

    public void hangingSignBlock(Block signBlock, Block wallSignBlock, ModelFile sign) {
        simpleBlock(signBlock, sign);
        simpleBlock(wallSignBlock, sign);
    }

    private String name(Block block) {
        return key(block).getPath();
    }

    private ResourceLocation key(Block block) {
        return ForgeRegistries.BLOCKS.getKey(block);
    }

    private void leavesBlock(RegistryObject<Block> blockRegistryObject) {
        simpleBlockWithItem(blockRegistryObject.get(),
                models().singleTexture(ForgeRegistries.BLOCKS.getKey(blockRegistryObject.get()).getPath(), new ResourceLocation("minecraft:block/leaves"),
                        "all", blockTexture(blockRegistryObject.get())).renderType("cutout"));
    }

    private void blockItem(RegistryObject<Block> blockRegistryObject) {
        simpleBlockItem(blockRegistryObject.get(), new ModelFile.UncheckedModelFile(CrystalTech.MOD_ID +
                ":block/" + ForgeRegistries.BLOCKS.getKey(blockRegistryObject.get()).getPath()));
    }

    public void makeStrawberryCrop(CropBlock block, String modelName, String textureName) {
        Function<BlockState, ConfiguredModel[]> function = state -> strawberryStates(state, block, modelName, textureName);

        getVariantBuilder(block).forAllStates(function);
    }

    private ConfiguredModel[] strawberryStates(BlockState state, CropBlock block, String modelName, String textureName) {
        ConfiguredModel[] models = new ConfiguredModel[1];
        models[0] = new ConfiguredModel(models().crop(modelName + state.getValue(((StrawberryCropBlock) block).getAgeProperty()),
                new ResourceLocation(CrystalTech.MOD_ID, "block/" + textureName + state.getValue(((StrawberryCropBlock) block).getAgeProperty()))).renderType("cutout"));

        return models;
    }


    public void makeCornCrop(CropBlock block, String modelName, String textureName) {
        Function<BlockState, ConfiguredModel[]> function = state -> cornStates(state, block, modelName, textureName);

        getVariantBuilder(block).forAllStates(function);
    }

    private ConfiguredModel[] cornStates(BlockState state, CropBlock block, String modelName, String textureName) {
        ConfiguredModel[] models = new ConfiguredModel[1];
        models[0] = new ConfiguredModel(models().crop(modelName + state.getValue(((CornCropBlock) block).getAgeProperty()),
                new ResourceLocation(CrystalTech.MOD_ID, "block/" + textureName + state.getValue(((CornCropBlock) block).getAgeProperty()))).renderType("cutout"));

        return models;
    }



   private void blockWithItem(RegistryObject<Block> blockRegistryObject) {
        simpleBlockWithItem(blockRegistryObject.get(), cubeAll(blockRegistryObject.get()));
   }


}
