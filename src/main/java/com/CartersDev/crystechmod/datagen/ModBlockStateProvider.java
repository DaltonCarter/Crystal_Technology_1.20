package com.CartersDev.crystechmod.datagen;

import com.CartersDev.crystechmod.CrystalTech;

import com.CartersDev.crystechmod.block.ModBlocks;
import com.CartersDev.crystechmod.block.custom.HeimBerryCropBlock;
import com.CartersDev.crystechmod.block.custom.SaberCornCropBlock;
import com.CartersDev.crystechmod.block.custom.CrystalCoreLampBlock;
import com.CartersDev.crystechmod.block.custom.HelFruitCropBlock;
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
        blockWithItem(ModBlocks.GUNDANIUM_MACHINE_CORE);
        blockWithItem(ModBlocks.ALYTHUM_MACHINE_CORE);
        blockWithItem(ModBlocks.VITRIC_MACHINE_CORE);
        blockWithItem(ModBlocks.CRYSTAL_CORE_MACHINE_CORE);

        blockWithItem(ModBlocks.ALYTHUM_BLOCK);
        blockWithItem(ModBlocks.ILLYRIM_BLOCK);
        blockWithItem(ModBlocks.LG_CORE_BLOCK);
        blockWithItem(ModBlocks.MG_CORE_BLOCK);
        blockWithItem(ModBlocks.HG_CORE_BLOCK);
        blockWithItem(ModBlocks.CS_SCAFFOLD);
        blockWithItem(ModBlocks.CS_TILE_G);
        blockWithItem(ModBlocks.CS_TILE_G_BAND);
        blockWithItem(ModBlocks.CS_TILE_G_FRAME);
        blockWithItem(ModBlocks.CS_TILE_B_BAND);
        blockWithItem(ModBlocks.CS_TILE_B_FRAME);
        blockWithItem(ModBlocks.CS_TILE_R_BAND);
        blockWithItem(ModBlocks.CS_TILE_R_FRAME);
        blockWithItem(ModBlocks.CS_TILE_P_BAND);
        blockWithItem(ModBlocks.CS_TILE_P_FRAME);
        blockWithItem(ModBlocks.CS_TILE_LG_BAND);
        blockWithItem(ModBlocks.CS_TILE_LG_FRAME);
        blockWithItem(ModBlocks.CS_TILE_MG_BAND);
        blockWithItem(ModBlocks.CS_TILE_MG_FRAME);
        blockWithItem(ModBlocks.CS_TILE_HG_BAND);
        blockWithItem(ModBlocks.CS_TILE_HG_FRAME);
        blockWithItem(ModBlocks.CS_TILE_B);
        blockWithItem(ModBlocks.CS_TILE_R);
        blockWithItem(ModBlocks.CS_TILE_P);
        blockWithItem(ModBlocks.CS_TILE_LG);
        blockWithItem(ModBlocks.CS_TILE_MG);
        blockWithItem(ModBlocks.CS_TILE_HG);
        blockWithItem(ModBlocks.CS_TILE);
        blockWithItem(ModBlocks.CS_TILE_BR);
        blockWithItem(ModBlocks.CS_TILE_YB);

        blockWithItem(ModBlocks.CS_CATWALK_W);
        blockWithItem(ModBlocks.CS_CATWALK_BL);
        blockWithItem(ModBlocks.CS_CATWALK_G);
        blockWithItem(ModBlocks.CS_CATWALK_B);
        blockWithItem(ModBlocks.CS_CATWALK_R);
        blockWithItem(ModBlocks.CS_CATWALK_P);

        blockWithItem(ModBlocks.CT_PILLAR_TOP);
        blockWithItem(ModBlocks.CT_PILLAR_TOP_G);
        blockWithItem(ModBlocks.CT_PILLAR_TOP_B);
        blockWithItem(ModBlocks.CT_PILLAR_TOP_R);
        blockWithItem(ModBlocks.CT_PILLAR_TOP_P);

        blockWithItem(ModBlocks.CT_TILE_2);
        blockWithItem(ModBlocks.CT_TILE_G_2);
        blockWithItem(ModBlocks.CT_TILE_B_2);
        blockWithItem(ModBlocks.CT_TILE_R_2);
        blockWithItem(ModBlocks.CT_TILE_P_2);

        blockWithItem(ModBlocks.CT_TILE_3);
        blockWithItem(ModBlocks.CT_TILE_G_3);
        blockWithItem(ModBlocks.CT_TILE_B_3);
        blockWithItem(ModBlocks.CT_TILE_R_3);
        blockWithItem(ModBlocks.CT_TILE_P_3);

        blockWithItem(ModBlocks.TIBERIUM_BLOCK);
        blockWithItem(ModBlocks.TIBERIUM_BLUE_BLOCK);
        blockWithItem(ModBlocks.TIBERIUM_RED_BLOCK);
        blockWithItem(ModBlocks.TIBERIUM_PURPLE_BLOCK);

        blockWithItem((ModBlocks.AERIES_BLOCK));
        blockWithItem((ModBlocks.ENIGMA_BLOCK));
        blockWithItem((ModBlocks.ILLUMINA_BLOCK));
        blockWithItem((ModBlocks.KRYON_BLOCK));
        blockWithItem((ModBlocks.HARMONIUM_BLOCK));

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

        blockWithItem(ModBlocks.HARMONIUM_ORE);
        blockWithItem(ModBlocks.DEEPSLATE_HARMONIUM_ORE);
        blockWithItem(ModBlocks.NETHER_HARMONIUM_ORE);
        blockWithItem(ModBlocks.END_HARMONIUM_ORE);

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

        blockWithItem(ModBlocks.VITRIC_DEEPSLATE_BRICKS);
        blockWithItem(ModBlocks.VITRIC_DEEPSLATE_TILES);

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

        //Sapling Blocks:
        saplingBlock(ModBlocks.EMBER_OAK_SAPLING);
        saplingBlock(ModBlocks.MARIKA_OAK_SAPLING);
        saplingBlock(ModBlocks.PLAGUED_SAPLING);
        saplingBlock(ModBlocks.DYING_SAPLING);


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

        //Rotated Pillars:
        axisBlock(((RotatedPillarBlock) ModBlocks.VITRIC_DEEPSLATE.get()), new ResourceLocation(CrystalTech.MOD_ID, "block/vitric_deepslate"),
                new ResourceLocation(CrystalTech.MOD_ID, "block/vitric_deepslate_top"));
        blockItem(ModBlocks.VITRIC_DEEPSLATE);

        axisBlock(((RotatedPillarBlock) ModBlocks.CS_PILLAR.get()), new ResourceLocation(CrystalTech.MOD_ID, "block/cs_pillar"),
                new ResourceLocation(CrystalTech.MOD_ID, "block/lg_core_block"));
        blockItem(ModBlocks.CS_PILLAR);

        axisBlock(((RotatedPillarBlock) ModBlocks.CS_PILLAR_G.get()), new ResourceLocation(CrystalTech.MOD_ID, "block/cs_pillar_g"),
                new ResourceLocation(CrystalTech.MOD_ID, "block/cs_tile_g"));
        blockItem(ModBlocks.CS_PILLAR_G);

        axisBlock(((RotatedPillarBlock) ModBlocks.CS_PILLAR_G_2.get()), new ResourceLocation(CrystalTech.MOD_ID, "block/cs_pillar_g_2"),
                new ResourceLocation(CrystalTech.MOD_ID, "block/cs_tile_g"));
        blockItem(ModBlocks.CS_PILLAR_G_2);

        axisBlock(((RotatedPillarBlock) ModBlocks.CS_PILLAR_G_3.get()), new ResourceLocation(CrystalTech.MOD_ID, "block/cs_pillar_g_3"),
                new ResourceLocation(CrystalTech.MOD_ID, "block/cs_tile_g"));
        blockItem(ModBlocks.CS_PILLAR_G_3);

        axisBlock(((RotatedPillarBlock) ModBlocks.CS_PILLAR_G_4.get()), new ResourceLocation(CrystalTech.MOD_ID, "block/cs_pillar_g_4"),
                new ResourceLocation(CrystalTech.MOD_ID, "block/cs_tile_g"));
        blockItem(ModBlocks.CS_PILLAR_G_4);

        axisBlock(((RotatedPillarBlock) ModBlocks.CS_PILLAR_B.get()), new ResourceLocation(CrystalTech.MOD_ID, "block/cs_pillar_b"),
                new ResourceLocation(CrystalTech.MOD_ID, "block/cs_tile_b"));
        blockItem(ModBlocks.CS_PILLAR_B);

        axisBlock(((RotatedPillarBlock) ModBlocks.CS_PILLAR_B_2.get()), new ResourceLocation(CrystalTech.MOD_ID, "block/cs_pillar_b_2"),
                new ResourceLocation(CrystalTech.MOD_ID, "block/cs_tile_b"));
        blockItem(ModBlocks.CS_PILLAR_B_2);

        axisBlock(((RotatedPillarBlock) ModBlocks.CS_PILLAR_B_3.get()), new ResourceLocation(CrystalTech.MOD_ID, "block/cs_pillar_b_3"),
                new ResourceLocation(CrystalTech.MOD_ID, "block/cs_tile_b"));
        blockItem(ModBlocks.CS_PILLAR_B_3);

        axisBlock(((RotatedPillarBlock) ModBlocks.CS_PILLAR_B_4.get()), new ResourceLocation(CrystalTech.MOD_ID, "block/cs_pillar_b_4"),
                new ResourceLocation(CrystalTech.MOD_ID, "block/cs_tile_b"));
        blockItem(ModBlocks.CS_PILLAR_B_4);

        axisBlock(((RotatedPillarBlock) ModBlocks.CS_PILLAR_R.get()), new ResourceLocation(CrystalTech.MOD_ID, "block/cs_pillar_r"),
                new ResourceLocation(CrystalTech.MOD_ID, "block/cs_tile_r"));
        blockItem(ModBlocks.CS_PILLAR_R);

        axisBlock(((RotatedPillarBlock) ModBlocks.CS_PILLAR_R_2.get()), new ResourceLocation(CrystalTech.MOD_ID, "block/cs_pillar_r_2"),
                new ResourceLocation(CrystalTech.MOD_ID, "block/cs_tile_r"));
        blockItem(ModBlocks.CS_PILLAR_R_2);

        axisBlock(((RotatedPillarBlock) ModBlocks.CS_PILLAR_R_3.get()), new ResourceLocation(CrystalTech.MOD_ID, "block/cs_pillar_r_3"),
                new ResourceLocation(CrystalTech.MOD_ID, "block/cs_tile_r"));
        blockItem(ModBlocks.CS_PILLAR_R_3);

        axisBlock(((RotatedPillarBlock) ModBlocks.CS_PILLAR_R_4.get()), new ResourceLocation(CrystalTech.MOD_ID, "block/cs_pillar_r_4"),
                new ResourceLocation(CrystalTech.MOD_ID, "block/cs_tile_r"));
        blockItem(ModBlocks.CS_PILLAR_R_4);

        axisBlock(((RotatedPillarBlock) ModBlocks.CS_PILLAR_P.get()), new ResourceLocation(CrystalTech.MOD_ID, "block/cs_pillar_p"),
                new ResourceLocation(CrystalTech.MOD_ID, "block/cs_tile_p"));
        blockItem(ModBlocks.CS_PILLAR_P);

        axisBlock(((RotatedPillarBlock) ModBlocks.CS_PILLAR_P_2.get()), new ResourceLocation(CrystalTech.MOD_ID, "block/cs_pillar_p_2"),
                new ResourceLocation(CrystalTech.MOD_ID, "block/cs_tile_p"));
        blockItem(ModBlocks.CS_PILLAR_P_2);

        axisBlock(((RotatedPillarBlock) ModBlocks.CS_PILLAR_P_3.get()), new ResourceLocation(CrystalTech.MOD_ID, "block/cs_pillar_p_3"),
                new ResourceLocation(CrystalTech.MOD_ID, "block/cs_tile_p"));
        blockItem(ModBlocks.CS_PILLAR_P_3);

        axisBlock(((RotatedPillarBlock) ModBlocks.CS_PILLAR_P_4.get()), new ResourceLocation(CrystalTech.MOD_ID, "block/cs_pillar_p_4"),
                new ResourceLocation(CrystalTech.MOD_ID, "block/cs_tile_p"));
        blockItem(ModBlocks.CS_PILLAR_P_4);

        axisBlock(((RotatedPillarBlock) ModBlocks.CS_PILLAR_LG.get()), new ResourceLocation(CrystalTech.MOD_ID, "block/cs_pillar_lg"),
                new ResourceLocation(CrystalTech.MOD_ID, "block/cs_tile_lg"));
        blockItem(ModBlocks.CS_PILLAR_LG);

        axisBlock(((RotatedPillarBlock) ModBlocks.CS_PILLAR_LG_2.get()), new ResourceLocation(CrystalTech.MOD_ID, "block/cs_pillar_lg_2"),
                new ResourceLocation(CrystalTech.MOD_ID, "block/cs_tile_lg"));
        blockItem(ModBlocks.CS_PILLAR_LG_2);

        axisBlock(((RotatedPillarBlock) ModBlocks.CS_PILLAR_LG_3.get()), new ResourceLocation(CrystalTech.MOD_ID, "block/cs_pillar_lg_3"),
                new ResourceLocation(CrystalTech.MOD_ID, "block/cs_tile_lg"));
        blockItem(ModBlocks.CS_PILLAR_LG_3);

        axisBlock(((RotatedPillarBlock) ModBlocks.CS_PILLAR_LG_4.get()), new ResourceLocation(CrystalTech.MOD_ID, "block/cs_pillar_lg_4"),
                new ResourceLocation(CrystalTech.MOD_ID, "block/cs_tile_lg"));
        blockItem(ModBlocks.CS_PILLAR_LG_4);

        axisBlock(((RotatedPillarBlock) ModBlocks.CS_PILLAR_MG.get()), new ResourceLocation(CrystalTech.MOD_ID, "block/cs_pillar_mg"),
                new ResourceLocation(CrystalTech.MOD_ID, "block/cs_tile_mg"));
        blockItem(ModBlocks.CS_PILLAR_MG);

        axisBlock(((RotatedPillarBlock) ModBlocks.CS_PILLAR_MG_2.get()), new ResourceLocation(CrystalTech.MOD_ID, "block/cs_pillar_mg_2"),
                new ResourceLocation(CrystalTech.MOD_ID, "block/cs_tile_mg"));
        blockItem(ModBlocks.CS_PILLAR_MG_2);

        axisBlock(((RotatedPillarBlock) ModBlocks.CS_PILLAR_MG_3.get()), new ResourceLocation(CrystalTech.MOD_ID, "block/cs_pillar_mg_3"),
                new ResourceLocation(CrystalTech.MOD_ID, "block/cs_tile_mg"));
        blockItem(ModBlocks.CS_PILLAR_MG_3);

        axisBlock(((RotatedPillarBlock) ModBlocks.CS_PILLAR_MG_4.get()), new ResourceLocation(CrystalTech.MOD_ID, "block/cs_pillar_mg_4"),
                new ResourceLocation(CrystalTech.MOD_ID, "block/cs_tile_mg"));
        blockItem(ModBlocks.CS_PILLAR_MG_4);

        axisBlock(((RotatedPillarBlock) ModBlocks.CS_PILLAR_HG.get()), new ResourceLocation(CrystalTech.MOD_ID, "block/cs_pillar_hg"),
                new ResourceLocation(CrystalTech.MOD_ID, "block/cs_tile_hg"));
        blockItem(ModBlocks.CS_PILLAR_HG);

        axisBlock(((RotatedPillarBlock) ModBlocks.CS_PILLAR_HG_2.get()), new ResourceLocation(CrystalTech.MOD_ID, "block/cs_pillar_hg_2"),
                new ResourceLocation(CrystalTech.MOD_ID, "block/cs_tile_hg"));
        blockItem(ModBlocks.CS_PILLAR_HG_2);

        axisBlock(((RotatedPillarBlock) ModBlocks.CS_PILLAR_HG_3.get()), new ResourceLocation(CrystalTech.MOD_ID, "block/cs_pillar_hg_3"),
                new ResourceLocation(CrystalTech.MOD_ID, "block/cs_tile_hg"));
        blockItem(ModBlocks.CS_PILLAR_HG_3);

        axisBlock(((RotatedPillarBlock) ModBlocks.CS_PILLAR_HG_4.get()), new ResourceLocation(CrystalTech.MOD_ID, "block/cs_pillar_hg_4"),
                new ResourceLocation(CrystalTech.MOD_ID, "block/cs_tile_hg"));
        blockItem(ModBlocks.CS_PILLAR_HG_4);



        axisBlock(((RotatedPillarBlock) ModBlocks.CT_PILLAR.get()), new ResourceLocation(CrystalTech.MOD_ID, "block/ct_pillar"),
                new ResourceLocation(CrystalTech.MOD_ID, "block/ct_pillar_top"));
        blockItem(ModBlocks.CT_PILLAR);

        axisBlock(((RotatedPillarBlock) ModBlocks.CT_PILLAR_2.get()), new ResourceLocation(CrystalTech.MOD_ID, "block/ct_pillar_2"),
                new ResourceLocation(CrystalTech.MOD_ID, "block/ct_pillar_top"));
        blockItem(ModBlocks.CT_PILLAR_2);
        
        axisBlock(((RotatedPillarBlock) ModBlocks.CT_PILLAR_3.get()), new ResourceLocation(CrystalTech.MOD_ID, "block/ct_pillar_3"),
                new ResourceLocation(CrystalTech.MOD_ID, "block/ct_pillar_top"));
        blockItem(ModBlocks.CT_PILLAR_3);
        
        axisBlock(((RotatedPillarBlock) ModBlocks.CT_PILLAR_G.get()), new ResourceLocation(CrystalTech.MOD_ID, "block/ct_pillar_g"),
                new ResourceLocation(CrystalTech.MOD_ID, "block/ct_pillar_top_g"));
        blockItem(ModBlocks.CT_PILLAR_G);

        axisBlock(((RotatedPillarBlock) ModBlocks.CT_PILLAR_G_2.get()), new ResourceLocation(CrystalTech.MOD_ID, "block/ct_pillar_g_2"),
                new ResourceLocation(CrystalTech.MOD_ID, "block/ct_pillar_top_g"));
        blockItem(ModBlocks.CT_PILLAR_G_2);
        
        axisBlock(((RotatedPillarBlock) ModBlocks.CT_PILLAR_B.get()), new ResourceLocation(CrystalTech.MOD_ID, "block/ct_pillar_b"),
                new ResourceLocation(CrystalTech.MOD_ID, "block/ct_pillar_top_b"));
        blockItem(ModBlocks.CT_PILLAR_B);

        axisBlock(((RotatedPillarBlock) ModBlocks.CT_PILLAR_B_2.get()), new ResourceLocation(CrystalTech.MOD_ID, "block/ct_pillar_b_2"),
                new ResourceLocation(CrystalTech.MOD_ID, "block/ct_pillar_top_b"));
        blockItem(ModBlocks.CT_PILLAR_B_2);
        
        axisBlock(((RotatedPillarBlock) ModBlocks.CT_PILLAR_R.get()), new ResourceLocation(CrystalTech.MOD_ID, "block/ct_pillar_r"),
                new ResourceLocation(CrystalTech.MOD_ID, "block/ct_pillar_top_r"));
        blockItem(ModBlocks.CT_PILLAR_R);

        axisBlock(((RotatedPillarBlock) ModBlocks.CT_PILLAR_R_2.get()), new ResourceLocation(CrystalTech.MOD_ID, "block/ct_pillar_r_2"),
                new ResourceLocation(CrystalTech.MOD_ID, "block/ct_pillar_top_r"));
        blockItem(ModBlocks.CT_PILLAR_R_2);
        
        axisBlock(((RotatedPillarBlock) ModBlocks.CT_PILLAR_P.get()), new ResourceLocation(CrystalTech.MOD_ID, "block/ct_pillar_p"),
                new ResourceLocation(CrystalTech.MOD_ID, "block/ct_pillar_top_p"));
        blockItem(ModBlocks.CT_PILLAR_P);

        axisBlock(((RotatedPillarBlock) ModBlocks.CT_PILLAR_P_2.get()), new ResourceLocation(CrystalTech.MOD_ID, "block/ct_pillar_p_2"),
                new ResourceLocation(CrystalTech.MOD_ID, "block/ct_pillar_top_p"));
        blockItem(ModBlocks.CT_PILLAR_P_2);



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

        stairsBlock((StairBlock) ModBlocks.VITRIC_DEEPSLATE_BRICK_STAIRS.get(), blockTexture(ModBlocks.VITRIC_DEEPSLATE_BRICKS.get()));
        stairsBlock((StairBlock) ModBlocks.VITRIC_DEEPSLATE_TILE_STAIRS.get(), blockTexture(ModBlocks.VITRIC_DEEPSLATE_TILES.get()));

        stairsBlock((StairBlock) ModBlocks.RIPARIUS_CRYSTAL_STAIRS.get(), blockTexture(ModBlocks.RIPARIUS_CRYSTAL.get()));
        stairsBlock((StairBlock) ModBlocks.VINIFERA_CRYSTAL_STAIRS.get(), blockTexture(ModBlocks.VINIFERA_CRYSTAL.get()));
        stairsBlock((StairBlock) ModBlocks.CRUENTUS_CRYSTAL_STAIRS.get(), blockTexture(ModBlocks.CRUENTUS_CRYSTAL.get()));
        stairsBlock((StairBlock) ModBlocks.ABOREUS_CRYSTAL_STAIRS.get(), blockTexture(ModBlocks.ABOREUS_CRYSTAL.get()));

        stairsBlock((StairBlock) ModBlocks.CS_SCAFFOLD_STAIRS.get(), blockTexture(ModBlocks.CS_SCAFFOLD.get()));
        stairsBlock((StairBlock) ModBlocks.CS_CATWALK_W_STAIRS.get(), blockTexture(ModBlocks.CS_CATWALK_W.get()));
        stairsBlock((StairBlock) ModBlocks.CS_CATWALK_BL_STAIRS.get(), blockTexture(ModBlocks.CS_CATWALK_BL.get()));
        stairsBlock((StairBlock) ModBlocks.CS_CATWALK_G_STAIRS.get(), blockTexture(ModBlocks.CS_CATWALK_G.get()));
        stairsBlock((StairBlock) ModBlocks.CS_CATWALK_B_STAIRS.get(), blockTexture(ModBlocks.CS_CATWALK_B.get()));
        stairsBlock((StairBlock) ModBlocks.CS_CATWALK_R_STAIRS.get(), blockTexture(ModBlocks.CS_CATWALK_R.get()));
        stairsBlock((StairBlock) ModBlocks.CS_CATWALK_P_STAIRS.get(), blockTexture(ModBlocks.CS_CATWALK_P.get()));
        stairsBlock((StairBlock) ModBlocks.CS_TILE_STAIRS.get(), blockTexture(ModBlocks.CS_TILE.get()));
        stairsBlock((StairBlock) ModBlocks.CS_TILE_BR_STAIRS.get(), blockTexture(ModBlocks.CS_TILE_BR.get()));
        stairsBlock((StairBlock) ModBlocks.CS_TILE_YB_STAIRS.get(), blockTexture(ModBlocks.CS_TILE_YB.get()));
        stairsBlock((StairBlock) ModBlocks.CS_TILE_G_BAND_STAIRS.get(), blockTexture(ModBlocks.CS_TILE_G_BAND.get()));
        stairsBlock((StairBlock) ModBlocks.CS_TILE_G_FRAME_STAIRS.get(), blockTexture(ModBlocks.CS_TILE_G_FRAME.get()));
        stairsBlock((StairBlock) ModBlocks.CS_TILE_B_BAND_STAIRS.get(), blockTexture(ModBlocks.CS_TILE_B_BAND.get()));
        stairsBlock((StairBlock) ModBlocks.CS_TILE_B_FRAME_STAIRS.get(), blockTexture(ModBlocks.CS_TILE_B_FRAME.get()));
        stairsBlock((StairBlock) ModBlocks.CS_TILE_R_BAND_STAIRS.get(), blockTexture(ModBlocks.CS_TILE_R_BAND.get()));
        stairsBlock((StairBlock) ModBlocks.CS_TILE_R_FRAME_STAIRS.get(), blockTexture(ModBlocks.CS_TILE_R_FRAME.get()));
        stairsBlock((StairBlock) ModBlocks.CS_TILE_P_BAND_STAIRS.get(), blockTexture(ModBlocks.CS_TILE_P_BAND.get()));
        stairsBlock((StairBlock) ModBlocks.CS_TILE_P_FRAME_STAIRS.get(), blockTexture(ModBlocks.CS_TILE_P_FRAME.get()));
        stairsBlock((StairBlock) ModBlocks.CS_TILE_LG_BAND_STAIRS.get(), blockTexture(ModBlocks.CS_TILE_LG_BAND.get()));
        stairsBlock((StairBlock) ModBlocks.CS_TILE_LG_FRAME_STAIRS.get(), blockTexture(ModBlocks.CS_TILE_LG_FRAME.get()));
        stairsBlock((StairBlock) ModBlocks.CS_TILE_MG_BAND_STAIRS.get(), blockTexture(ModBlocks.CS_TILE_MG_BAND.get()));
        stairsBlock((StairBlock) ModBlocks.CS_TILE_MG_FRAME_STAIRS.get(), blockTexture(ModBlocks.CS_TILE_MG_FRAME.get()));
        stairsBlock((StairBlock) ModBlocks.CS_TILE_HG_BAND_STAIRS.get(), blockTexture(ModBlocks.CS_TILE_HG_BAND.get()));
        stairsBlock((StairBlock) ModBlocks.CS_TILE_HG_FRAME_STAIRS.get(), blockTexture(ModBlocks.CS_TILE_HG_FRAME.get()));
        stairsBlock((StairBlock) ModBlocks.CS_TILE_G_STAIRS.get(), blockTexture(ModBlocks.CS_TILE_G.get()));
        stairsBlock((StairBlock) ModBlocks.CS_TILE_B_STAIRS.get(), blockTexture(ModBlocks.CS_TILE_B.get()));
        stairsBlock((StairBlock) ModBlocks.CS_TILE_R_STAIRS.get(), blockTexture(ModBlocks.CS_TILE_R.get()));
        stairsBlock((StairBlock) ModBlocks.CS_TILE_P_STAIRS.get(), blockTexture(ModBlocks.CS_TILE_P.get()));
        stairsBlock((StairBlock) ModBlocks.CS_TILE_LG_STAIRS.get(), blockTexture(ModBlocks.CS_TILE_LG.get()));
        stairsBlock((StairBlock) ModBlocks.CS_TILE_MG_STAIRS.get(), blockTexture(ModBlocks.CS_TILE_MG.get()));
        stairsBlock((StairBlock) ModBlocks.CS_TILE_HG_STAIRS.get(), blockTexture(ModBlocks.CS_TILE_HG.get()));

        stairsBlock((StairBlock) ModBlocks.CT_TILE_STAIRS.get(), blockTexture(ModBlocks.CT_PILLAR_TOP.get()));
        stairsBlock((StairBlock) ModBlocks.CT_TILE_STAIRS_G.get(), blockTexture(ModBlocks.CT_PILLAR_TOP_G.get()));
        stairsBlock((StairBlock) ModBlocks.CT_TILE_STAIRS_B.get(), blockTexture(ModBlocks.CT_PILLAR_TOP_B.get()));
        stairsBlock((StairBlock) ModBlocks.CT_TILE_STAIRS_R.get(), blockTexture(ModBlocks.CT_PILLAR_TOP_R.get()));
        stairsBlock((StairBlock) ModBlocks.CT_TILE_STAIRS_P.get(), blockTexture(ModBlocks.CT_PILLAR_TOP_P.get()));

        stairsBlock((StairBlock) ModBlocks.CT_TILE_STAIRS_2.get(), blockTexture(ModBlocks.CT_TILE_2.get()));
        stairsBlock((StairBlock) ModBlocks.CT_TILE_STAIRS_G_2.get(), blockTexture(ModBlocks.CT_TILE_G_2.get()));
        stairsBlock((StairBlock) ModBlocks.CT_TILE_STAIRS_B_2.get(), blockTexture(ModBlocks.CT_TILE_B_2.get()));
        stairsBlock((StairBlock) ModBlocks.CT_TILE_STAIRS_R_2.get(), blockTexture(ModBlocks.CT_TILE_R_2.get()));
        stairsBlock((StairBlock) ModBlocks.CT_TILE_STAIRS_P_2.get(), blockTexture(ModBlocks.CT_TILE_P_2.get()));

        stairsBlock((StairBlock) ModBlocks.CT_TILE_STAIRS_3.get(), blockTexture(ModBlocks.CT_TILE_3.get()));
        stairsBlock((StairBlock) ModBlocks.CT_TILE_STAIRS_G_3.get(), blockTexture(ModBlocks.CT_TILE_G_3.get()));
        stairsBlock((StairBlock) ModBlocks.CT_TILE_STAIRS_B_3.get(), blockTexture(ModBlocks.CT_TILE_B_3.get()));
        stairsBlock((StairBlock) ModBlocks.CT_TILE_STAIRS_R_3.get(), blockTexture(ModBlocks.CT_TILE_R_3.get()));
        stairsBlock((StairBlock) ModBlocks.CT_TILE_STAIRS_P_3.get(), blockTexture(ModBlocks.CT_TILE_P_3.get()));

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

       slabBlock((SlabBlock) ModBlocks.VITRIC_DEEPSLATE_BRICK_SLAB.get(), blockTexture(ModBlocks.VITRIC_DEEPSLATE_BRICKS.get()), blockTexture(ModBlocks.VITRIC_DEEPSLATE_BRICKS.get()));
       slabBlock((SlabBlock) ModBlocks.VITRIC_DEEPSLATE_TILE_SLAB.get(), blockTexture(ModBlocks.VITRIC_DEEPSLATE_TILES.get()), blockTexture(ModBlocks.VITRIC_DEEPSLATE_TILES.get()));

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

        slabBlock((SlabBlock) ModBlocks.CS_SCAFFOLD_SLAB.get(), blockTexture(ModBlocks.CS_SCAFFOLD.get()), blockTexture(ModBlocks.CS_SCAFFOLD.get()));
        slabBlock((SlabBlock) ModBlocks.CS_CATWALK_W_SLAB.get(), blockTexture(ModBlocks.CS_CATWALK_W.get()), blockTexture(ModBlocks.CS_CATWALK_W.get()));
        slabBlock((SlabBlock) ModBlocks.CS_CATWALK_BL_SLAB.get(), blockTexture(ModBlocks.CS_CATWALK_BL.get()), blockTexture(ModBlocks.CS_CATWALK_BL.get()));
        slabBlock((SlabBlock) ModBlocks.CS_CATWALK_B_SLAB.get(), blockTexture(ModBlocks.CS_CATWALK_B.get()), blockTexture(ModBlocks.CS_CATWALK_B.get()));
        slabBlock((SlabBlock) ModBlocks.CS_CATWALK_G_SLAB.get(), blockTexture(ModBlocks.CS_CATWALK_G.get()), blockTexture(ModBlocks.CS_CATWALK_G.get()));
        slabBlock((SlabBlock) ModBlocks.CS_CATWALK_R_SLAB.get(), blockTexture(ModBlocks.CS_CATWALK_R.get()), blockTexture(ModBlocks.CS_CATWALK_R.get()));
        slabBlock((SlabBlock) ModBlocks.CS_CATWALK_P_SLAB.get(), blockTexture(ModBlocks.CS_CATWALK_P.get()), blockTexture(ModBlocks.CS_CATWALK_P.get()));
        slabBlock((SlabBlock) ModBlocks.CS_TILE_SLAB.get(), blockTexture(ModBlocks.CS_TILE.get()), blockTexture(ModBlocks.CS_TILE.get()));
        slabBlock((SlabBlock) ModBlocks.CS_TILE_BR_SLAB.get(), blockTexture(ModBlocks.CS_TILE_BR.get()), blockTexture(ModBlocks.CS_TILE_BR.get()));
        slabBlock((SlabBlock) ModBlocks.CS_TILE_YB_SLAB.get(), blockTexture(ModBlocks.CS_TILE_YB.get()), blockTexture(ModBlocks.CS_TILE_YB.get()));
        slabBlock((SlabBlock) ModBlocks.CS_TILE_G_SLAB.get(), blockTexture(ModBlocks.CS_TILE_G.get()), blockTexture(ModBlocks.CS_TILE_G.get()));
        slabBlock((SlabBlock) ModBlocks.CS_TILE_G_BAND_SLAB.get(), blockTexture(ModBlocks.CS_TILE_G_BAND.get()), blockTexture(ModBlocks.CS_TILE_G_BAND.get()));
        slabBlock((SlabBlock) ModBlocks.CS_TILE_G_FRAME_SLAB.get(), blockTexture(ModBlocks.CS_TILE_G_FRAME.get()), blockTexture(ModBlocks.CS_TILE_G_FRAME.get()));
        slabBlock((SlabBlock) ModBlocks.CS_TILE_B_BAND_SLAB.get(), blockTexture(ModBlocks.CS_TILE_B_BAND.get()), blockTexture(ModBlocks.CS_TILE_B_BAND.get()));
        slabBlock((SlabBlock) ModBlocks.CS_TILE_B_FRAME_SLAB.get(), blockTexture(ModBlocks.CS_TILE_B_FRAME.get()), blockTexture(ModBlocks.CS_TILE_B_FRAME.get()));
        slabBlock((SlabBlock) ModBlocks.CS_TILE_R_BAND_SLAB.get(), blockTexture(ModBlocks.CS_TILE_R_BAND.get()), blockTexture(ModBlocks.CS_TILE_R_BAND.get()));
        slabBlock((SlabBlock) ModBlocks.CS_TILE_R_FRAME_SLAB.get(), blockTexture(ModBlocks.CS_TILE_R_FRAME.get()), blockTexture(ModBlocks.CS_TILE_R_FRAME.get()));
        slabBlock((SlabBlock) ModBlocks.CS_TILE_P_BAND_SLAB.get(), blockTexture(ModBlocks.CS_TILE_P_BAND.get()), blockTexture(ModBlocks.CS_TILE_P_BAND.get()));
        slabBlock((SlabBlock) ModBlocks.CS_TILE_P_FRAME_SLAB.get(), blockTexture(ModBlocks.CS_TILE_P_FRAME.get()), blockTexture(ModBlocks.CS_TILE_P_FRAME.get()));
        slabBlock((SlabBlock) ModBlocks.CS_TILE_LG_BAND_SLAB.get(), blockTexture(ModBlocks.CS_TILE_LG_BAND.get()), blockTexture(ModBlocks.CS_TILE_LG_BAND.get()));
        slabBlock((SlabBlock) ModBlocks.CS_TILE_LG_FRAME_SLAB.get(), blockTexture(ModBlocks.CS_TILE_LG_FRAME.get()), blockTexture(ModBlocks.CS_TILE_LG_FRAME.get()));
        slabBlock((SlabBlock) ModBlocks.CS_TILE_MG_BAND_SLAB.get(), blockTexture(ModBlocks.CS_TILE_MG_BAND.get()), blockTexture(ModBlocks.CS_TILE_MG_BAND.get()));
        slabBlock((SlabBlock) ModBlocks.CS_TILE_MG_FRAME_SLAB.get(), blockTexture(ModBlocks.CS_TILE_MG_FRAME.get()), blockTexture(ModBlocks.CS_TILE_MG_FRAME.get()));
        slabBlock((SlabBlock) ModBlocks.CS_TILE_HG_BAND_SLAB.get(), blockTexture(ModBlocks.CS_TILE_HG_BAND.get()), blockTexture(ModBlocks.CS_TILE_HG_BAND.get()));
        slabBlock((SlabBlock) ModBlocks.CS_TILE_HG_FRAME_SLAB.get(), blockTexture(ModBlocks.CS_TILE_HG_FRAME.get()), blockTexture(ModBlocks.CS_TILE_HG_FRAME.get()));
        slabBlock((SlabBlock) ModBlocks.CS_TILE_B_SLAB.get(), blockTexture(ModBlocks.CS_TILE_B.get()), blockTexture(ModBlocks.CS_TILE_B.get()));
        slabBlock((SlabBlock) ModBlocks.CS_TILE_R_SLAB.get(), blockTexture(ModBlocks.CS_TILE_R.get()), blockTexture(ModBlocks.CS_TILE_R.get()));
        slabBlock((SlabBlock) ModBlocks.CS_TILE_P_SLAB.get(), blockTexture(ModBlocks.CS_TILE_P.get()), blockTexture(ModBlocks.CS_TILE_P.get()));
        slabBlock((SlabBlock) ModBlocks.CS_TILE_LG_SLAB.get(), blockTexture(ModBlocks.CS_TILE_LG.get()), blockTexture(ModBlocks.CS_TILE_LG.get()));
        slabBlock((SlabBlock) ModBlocks.CS_TILE_MG_SLAB.get(), blockTexture(ModBlocks.CS_TILE_MG.get()), blockTexture(ModBlocks.CS_TILE_MG.get()));
        slabBlock((SlabBlock) ModBlocks.CS_TILE_HG_SLAB.get(), blockTexture(ModBlocks.CS_TILE_HG.get()), blockTexture(ModBlocks.CS_TILE_HG.get()));

        slabBlock((SlabBlock) ModBlocks.CT_TILE_SLAB.get(), blockTexture(ModBlocks.CT_PILLAR_TOP.get()), blockTexture(ModBlocks.CT_PILLAR_TOP.get()));
        slabBlock((SlabBlock) ModBlocks.CT_TILE_SLAB_G.get(), blockTexture(ModBlocks.CT_PILLAR_TOP_G.get()), blockTexture(ModBlocks.CT_PILLAR_TOP_G.get()));
        slabBlock((SlabBlock) ModBlocks.CT_TILE_SLAB_B.get(), blockTexture(ModBlocks.CT_PILLAR_TOP_B.get()), blockTexture(ModBlocks.CT_PILLAR_TOP_B.get()));
        slabBlock((SlabBlock) ModBlocks.CT_TILE_SLAB_R.get(), blockTexture(ModBlocks.CT_PILLAR_TOP_R.get()), blockTexture(ModBlocks.CT_PILLAR_TOP_R.get()));
        slabBlock((SlabBlock) ModBlocks.CT_TILE_SLAB_P.get(), blockTexture(ModBlocks.CT_PILLAR_TOP_P.get()), blockTexture(ModBlocks.CT_PILLAR_TOP_P.get()));

        slabBlock((SlabBlock) ModBlocks.CT_TILE_SLAB_2.get(), blockTexture(ModBlocks.CT_TILE_2.get()), blockTexture(ModBlocks.CT_TILE_2.get()));
        slabBlock((SlabBlock) ModBlocks.CT_TILE_SLAB_G_2.get(), blockTexture(ModBlocks.CT_TILE_G_2.get()), blockTexture(ModBlocks.CT_TILE_G_2.get()));
        slabBlock((SlabBlock) ModBlocks.CT_TILE_SLAB_B_2.get(), blockTexture(ModBlocks.CT_TILE_B_2.get()), blockTexture(ModBlocks.CT_TILE_B_2.get()));
        slabBlock((SlabBlock) ModBlocks.CT_TILE_SLAB_R_2.get(), blockTexture(ModBlocks.CT_TILE_R_2.get()), blockTexture(ModBlocks.CT_TILE_R_2.get()));
        slabBlock((SlabBlock) ModBlocks.CT_TILE_SLAB_P_2.get(), blockTexture(ModBlocks.CT_TILE_P_2.get()), blockTexture(ModBlocks.CT_TILE_P_2.get()));

        slabBlock((SlabBlock) ModBlocks.CT_TILE_SLAB_3.get(), blockTexture(ModBlocks.CT_TILE_3.get()), blockTexture(ModBlocks.CT_TILE_3.get()));
        slabBlock((SlabBlock) ModBlocks.CT_TILE_SLAB_G_3.get(), blockTexture(ModBlocks.CT_TILE_G_3.get()), blockTexture(ModBlocks.CT_TILE_G_3.get()));
        slabBlock((SlabBlock) ModBlocks.CT_TILE_SLAB_B_3.get(), blockTexture(ModBlocks.CT_TILE_B_3.get()), blockTexture(ModBlocks.CT_TILE_B_3.get()));
        slabBlock((SlabBlock) ModBlocks.CT_TILE_SLAB_R_3.get(), blockTexture(ModBlocks.CT_TILE_R_3.get()), blockTexture(ModBlocks.CT_TILE_R_3.get()));
        slabBlock((SlabBlock) ModBlocks.CT_TILE_SLAB_P_3.get(), blockTexture(ModBlocks.CT_TILE_P_3.get()), blockTexture(ModBlocks.CT_TILE_P_3.get()));

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

        wallBlock((((WallBlock) ModBlocks.VITRIC_DEEPSLATE_BRICK_WALL.get())), blockTexture(( ModBlocks.VITRIC_DEEPSLATE_BRICKS.get())));
        wallBlock((((WallBlock) ModBlocks.VITRIC_DEEPSLATE_TILE_WALL.get())), blockTexture(( ModBlocks.VITRIC_DEEPSLATE_TILES.get())));

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

        wallBlock((((WallBlock) ModBlocks.CS_TILE_WALL.get())), blockTexture(( ModBlocks.CS_TILE.get())));
        wallBlock((((WallBlock) ModBlocks.CS_TILE_BR_WALL.get())), blockTexture(( ModBlocks.CS_TILE_BR.get())));
        wallBlock((((WallBlock) ModBlocks.CS_TILE_YB_WALL.get())), blockTexture(( ModBlocks.CS_TILE_YB.get())));
        wallBlock((((WallBlock) ModBlocks.CS_TILE_G_WALL.get())), blockTexture(( ModBlocks.CS_TILE_G.get())));
        wallBlock((((WallBlock) ModBlocks.CS_TILE_G_BAND_WALL.get())), blockTexture(( ModBlocks.CS_TILE_G_BAND.get())));
        wallBlock((((WallBlock) ModBlocks.CS_TILE_G_FRAME_WALL.get())), blockTexture(( ModBlocks.CS_TILE_G_FRAME.get())));
        wallBlock((((WallBlock) ModBlocks.CS_TILE_B_BAND_WALL.get())), blockTexture(( ModBlocks.CS_TILE_B_BAND.get())));
        wallBlock((((WallBlock) ModBlocks.CS_TILE_B_FRAME_WALL.get())), blockTexture(( ModBlocks.CS_TILE_B_FRAME.get())));
        wallBlock((((WallBlock) ModBlocks.CS_TILE_HG_BAND_WALL.get())), blockTexture(( ModBlocks.CS_TILE_HG_BAND.get())));
        wallBlock((((WallBlock) ModBlocks.CS_TILE_HG_FRAME_WALL.get())), blockTexture(( ModBlocks.CS_TILE_HG_FRAME.get())));
        wallBlock((((WallBlock) ModBlocks.CS_TILE_MG_BAND_WALL.get())), blockTexture(( ModBlocks.CS_TILE_MG_BAND.get())));
        wallBlock((((WallBlock) ModBlocks.CS_TILE_MG_FRAME_WALL.get())), blockTexture(( ModBlocks.CS_TILE_MG_FRAME.get())));
        wallBlock((((WallBlock) ModBlocks.CS_TILE_LG_BAND_WALL.get())), blockTexture(( ModBlocks.CS_TILE_LG_BAND.get())));
        wallBlock((((WallBlock) ModBlocks.CS_TILE_LG_FRAME_WALL.get())), blockTexture(( ModBlocks.CS_TILE_LG_FRAME.get())));
        wallBlock((((WallBlock) ModBlocks.CS_TILE_P_BAND_WALL.get())), blockTexture(( ModBlocks.CS_TILE_P_BAND.get())));
        wallBlock((((WallBlock) ModBlocks.CS_TILE_P_FRAME_WALL.get())), blockTexture(( ModBlocks.CS_TILE_P_FRAME.get())));
        wallBlock((((WallBlock) ModBlocks.CS_TILE_R_BAND_WALL.get())), blockTexture(( ModBlocks.CS_TILE_R_BAND.get())));
        wallBlock((((WallBlock) ModBlocks.CS_TILE_R_FRAME_WALL.get())), blockTexture(( ModBlocks.CS_TILE_R_FRAME.get())));
        wallBlock((((WallBlock) ModBlocks.CS_TILE_B_WALL.get())), blockTexture(( ModBlocks.CS_TILE_B.get())));
        wallBlock((((WallBlock) ModBlocks.CS_TILE_R_WALL.get())), blockTexture(( ModBlocks.CS_TILE_R.get())));
        wallBlock((((WallBlock) ModBlocks.CS_TILE_P_WALL.get())), blockTexture(( ModBlocks.CS_TILE_P.get())));
        wallBlock((((WallBlock) ModBlocks.CS_TILE_LG_WALL.get())), blockTexture(( ModBlocks.CS_TILE_LG.get())));
        wallBlock((((WallBlock) ModBlocks.CS_TILE_MG_WALL.get())), blockTexture(( ModBlocks.CS_TILE_MG.get())));
        wallBlock((((WallBlock) ModBlocks.CS_TILE_HG_WALL.get())), blockTexture(( ModBlocks.CS_TILE_HG.get())));

        wallBlock((((WallBlock) ModBlocks.CT_TILE_WALL.get())), blockTexture(( ModBlocks.CT_PILLAR_TOP.get())));
        wallBlock((((WallBlock) ModBlocks.CT_TILE_WALL_G.get())), blockTexture(( ModBlocks.CT_PILLAR_TOP_G.get())));
        wallBlock((((WallBlock) ModBlocks.CT_TILE_WALL_B.get())), blockTexture(( ModBlocks.CT_PILLAR_TOP_B.get())));
        wallBlock((((WallBlock) ModBlocks.CT_TILE_WALL_R.get())), blockTexture(( ModBlocks.CT_PILLAR_TOP_R.get())));
        wallBlock((((WallBlock) ModBlocks.CT_TILE_WALL_P.get())), blockTexture(( ModBlocks.CT_PILLAR_TOP_P.get())));

        wallBlock((((WallBlock) ModBlocks.CT_TILE_WALL_2.get())), blockTexture(( ModBlocks.CT_TILE_2.get())));
        wallBlock((((WallBlock) ModBlocks.CT_TILE_WALL_G_2.get())), blockTexture(( ModBlocks.CT_TILE_G_2.get())));
        wallBlock((((WallBlock) ModBlocks.CT_TILE_WALL_B_2.get())), blockTexture(( ModBlocks.CT_TILE_B_2.get())));
        wallBlock((((WallBlock) ModBlocks.CT_TILE_WALL_R_2.get())), blockTexture(( ModBlocks.CT_TILE_R_2.get())));
        wallBlock((((WallBlock) ModBlocks.CT_TILE_WALL_P_2.get())), blockTexture(( ModBlocks.CT_TILE_P_2.get())));

        wallBlock((((WallBlock) ModBlocks.CT_TILE_WALL_3.get())), blockTexture(( ModBlocks.CT_TILE_3.get())));
        wallBlock((((WallBlock) ModBlocks.CT_TILE_WALL_G_3.get())), blockTexture(( ModBlocks.CT_TILE_G_3.get())));
        wallBlock((((WallBlock) ModBlocks.CT_TILE_WALL_B_3.get())), blockTexture(( ModBlocks.CT_TILE_B_3.get())));
        wallBlock((((WallBlock) ModBlocks.CT_TILE_WALL_R_3.get())), blockTexture(( ModBlocks.CT_TILE_R_3.get())));
        wallBlock((((WallBlock) ModBlocks.CT_TILE_WALL_P_3.get())), blockTexture(( ModBlocks.CT_TILE_P_3.get())));


        //Crops and Plants:
        makeHelFruitCrop((CropBlock) ModBlocks.HEL_FRUIT_CROP.get(), "hel_fruit_stage", "hel_fruit_stage");
        makeHeimBerryCrop((CropBlock) ModBlocks.HEIM_BERRY_CROP.get(), "heim_berry_stage", "heim_berry_stage");

        makeCornCrop((CropBlock) ModBlocks.SABER_CORN_CROP.get(), "saber_corn_stage_", "saber_corn_stage_");

        simpleBlockWithItem(ModBlocks.HYACINTH.get(), models().cross(blockTexture(ModBlocks.HYACINTH.get()).getPath(),
                blockTexture(ModBlocks.HYACINTH.get())).renderType("cutout"));

        simpleBlockWithItem(ModBlocks.VITRIC_BLOOM.get(), models().cross(blockTexture(ModBlocks.VITRIC_BLOOM.get()).getPath(),
                blockTexture(ModBlocks.VITRIC_BLOOM.get())).renderType("cutout"));

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

        simpleBlockWithItem(ModBlocks.POTTED_VITRIC_BLOOM.get(), models().singleTexture("potted_vitric_bloom",
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
        customLamp(ModBlocks.VERT_CRYSTAL_CORE_LIGHT.get(), CrystalCoreLampBlock.LIT, "vert_crystal_core_light");
        invertedCustomLamp(ModBlocks.INVERTED_VERT_CRYSTAL_CORE_LIGHT.get(), CrystalCoreLampBlock.LIT, "inverted_vert_crystal_core_light");

        customLamp(ModBlocks.BLACK_CRYSTAL_CORE_LIGHT.get(), CrystalCoreLampBlock.LIT, "black_crystal_core_light");
        invertedCustomLamp(ModBlocks.INVERTED_BLACK_CRYSTAL_CORE_LIGHT.get(), CrystalCoreLampBlock.LIT, "inverted_black_crystal_core_light");
        customLamp(ModBlocks.BLACK_VERT_CRYSTAL_CORE_LIGHT.get(), CrystalCoreLampBlock.LIT, "black_vert_crystal_core_light");
        invertedCustomLamp(ModBlocks.INVERTED_BLACK_VERT_CRYSTAL_CORE_LIGHT.get(), CrystalCoreLampBlock.LIT, "inverted_black_vert_crystal_core_light");

        customLamp(ModBlocks.BLUE_CRYSTAL_CORE_LIGHT.get(), CrystalCoreLampBlock.LIT, "blue_crystal_core_light");
        invertedCustomLamp(ModBlocks.INVERTED_BLUE_CRYSTAL_CORE_LIGHT.get(), CrystalCoreLampBlock.LIT, "inverted_blue_crystal_core_light");
        customLamp(ModBlocks.BLUE_VERT_CRYSTAL_CORE_LIGHT.get(), CrystalCoreLampBlock.LIT, "blue_vert_crystal_core_light");
        invertedCustomLamp(ModBlocks.INVERTED_BLUE_VERT_CRYSTAL_CORE_LIGHT.get(), CrystalCoreLampBlock.LIT, "inverted_blue_vert_crystal_core_light");

        customLamp(ModBlocks.BROWN_CRYSTAL_CORE_LIGHT.get(), CrystalCoreLampBlock.LIT, "brown_crystal_core_light");
        invertedCustomLamp(ModBlocks.INVERTED_BROWN_CRYSTAL_CORE_LIGHT.get(), CrystalCoreLampBlock.LIT, "inverted_brown_crystal_core_light");
        customLamp(ModBlocks.BROWN_VERT_CRYSTAL_CORE_LIGHT.get(), CrystalCoreLampBlock.LIT, "brown_vert_crystal_core_light");
        invertedCustomLamp(ModBlocks.INVERTED_BROWN_VERT_CRYSTAL_CORE_LIGHT.get(), CrystalCoreLampBlock.LIT, "inverted_brown_vert_crystal_core_light");

        customLamp(ModBlocks.CYAN_CRYSTAL_CORE_LIGHT.get(), CrystalCoreLampBlock.LIT, "cyan_crystal_core_light");
        invertedCustomLamp(ModBlocks.INVERTED_CYAN_CRYSTAL_CORE_LIGHT.get(), CrystalCoreLampBlock.LIT, "inverted_cyan_crystal_core_light");
        customLamp(ModBlocks.CYAN_VERT_CRYSTAL_CORE_LIGHT.get(), CrystalCoreLampBlock.LIT, "cyan_vert_crystal_core_light");
        invertedCustomLamp(ModBlocks.INVERTED_CYAN_VERT_CRYSTAL_CORE_LIGHT.get(), CrystalCoreLampBlock.LIT, "inverted_cyan_vert_crystal_core_light");

        customLamp(ModBlocks.FLAME_CRYSTAL_CORE_LIGHT.get(), CrystalCoreLampBlock.LIT, "flame_crystal_core_light");
        invertedCustomLamp(ModBlocks.INVERTED_FLAME_CRYSTAL_CORE_LIGHT.get(), CrystalCoreLampBlock.LIT, "inverted_flame_crystal_core_light");
        customLamp(ModBlocks.FLAME_VERT_CRYSTAL_CORE_LIGHT.get(), CrystalCoreLampBlock.LIT, "flame_vert_crystal_core_light");
        invertedCustomLamp(ModBlocks.INVERTED_FLAME_VERT_CRYSTAL_CORE_LIGHT.get(), CrystalCoreLampBlock.LIT, "inverted_flame_vert_crystal_core_light");

        customLamp(ModBlocks.GREEN_CRYSTAL_CORE_LIGHT.get(), CrystalCoreLampBlock.LIT, "green_crystal_core_light");
        invertedCustomLamp(ModBlocks.INVERTED_GREEN_CRYSTAL_CORE_LIGHT.get(), CrystalCoreLampBlock.LIT, "inverted_green_crystal_core_light");
        customLamp(ModBlocks.GREEN_VERT_CRYSTAL_CORE_LIGHT.get(), CrystalCoreLampBlock.LIT, "green_vert_crystal_core_light");
        invertedCustomLamp(ModBlocks.INVERTED_GREEN_VERT_CRYSTAL_CORE_LIGHT.get(), CrystalCoreLampBlock.LIT, "inverted_green_vert_crystal_core_light");

        customLamp(ModBlocks.GREY_CRYSTAL_CORE_LIGHT.get(), CrystalCoreLampBlock.LIT, "grey_crystal_core_light");
        invertedCustomLamp(ModBlocks.INVERTED_GREY_CRYSTAL_CORE_LIGHT.get(), CrystalCoreLampBlock.LIT, "inverted_grey_crystal_core_light");
        customLamp(ModBlocks.GREY_VERT_CRYSTAL_CORE_LIGHT.get(), CrystalCoreLampBlock.LIT, "grey_vert_crystal_core_light");
        invertedCustomLamp(ModBlocks.INVERTED_GREY_VERT_CRYSTAL_CORE_LIGHT.get(), CrystalCoreLampBlock.LIT, "inverted_grey_vert_crystal_core_light");

        customLamp(ModBlocks.LIGHT_BLUE_CRYSTAL_CORE_LIGHT.get(), CrystalCoreLampBlock.LIT, "light_blue_crystal_core_light");
        invertedCustomLamp(ModBlocks.INVERTED_LIGHT_BLUE_CRYSTAL_CORE_LIGHT.get(), CrystalCoreLampBlock.LIT, "inverted_light_blue_crystal_core_light");
        customLamp(ModBlocks.LIGHT_BLUE_VERT_CRYSTAL_CORE_LIGHT.get(), CrystalCoreLampBlock.LIT, "light_blue_vert_crystal_core_light");
        invertedCustomLamp(ModBlocks.INVERTED_LIGHT_BLUE_VERT_CRYSTAL_CORE_LIGHT.get(), CrystalCoreLampBlock.LIT, "inverted_light_blue_vert_crystal_core_light");

        customLamp(ModBlocks.LIGHT_GREY_CRYSTAL_CORE_LIGHT.get(), CrystalCoreLampBlock.LIT, "light_grey_crystal_core_light");
        invertedCustomLamp(ModBlocks.INVERTED_LIGHT_GREY_CRYSTAL_CORE_LIGHT.get(), CrystalCoreLampBlock.LIT, "inverted_light_grey_crystal_core_light");
        customLamp(ModBlocks.LIGHT_GREY_VERT_CRYSTAL_CORE_LIGHT.get(), CrystalCoreLampBlock.LIT, "light_grey_vert_crystal_core_light");
        invertedCustomLamp(ModBlocks.INVERTED_LIGHT_GREY_VERT_CRYSTAL_CORE_LIGHT.get(), CrystalCoreLampBlock.LIT, "inverted_light_grey_vert_crystal_core_light");

        customLamp(ModBlocks.LIME_CRYSTAL_CORE_LIGHT.get(), CrystalCoreLampBlock.LIT, "lime_crystal_core_light");
        invertedCustomLamp(ModBlocks.INVERTED_LIME_CRYSTAL_CORE_LIGHT.get(), CrystalCoreLampBlock.LIT, "inverted_lime_crystal_core_light");
        customLamp(ModBlocks.LIME_VERT_CRYSTAL_CORE_LIGHT.get(), CrystalCoreLampBlock.LIT, "lime_vert_crystal_core_light");
        invertedCustomLamp(ModBlocks.INVERTED_LIME_VERT_CRYSTAL_CORE_LIGHT.get(), CrystalCoreLampBlock.LIT, "inverted_lime_vert_crystal_core_light");

        customLamp(ModBlocks.MAGENTA_CRYSTAL_CORE_LIGHT.get(), CrystalCoreLampBlock.LIT, "magenta_crystal_core_light");
        invertedCustomLamp(ModBlocks.INVERTED_MAGENTA_CRYSTAL_CORE_LIGHT.get(), CrystalCoreLampBlock.LIT, "inverted_magenta_crystal_core_light");
        customLamp(ModBlocks.MAGENTA_VERT_CRYSTAL_CORE_LIGHT.get(), CrystalCoreLampBlock.LIT, "magenta_vert_crystal_core_light");
        invertedCustomLamp(ModBlocks.INVERTED_MAGENTA_VERT_CRYSTAL_CORE_LIGHT.get(), CrystalCoreLampBlock.LIT, "inverted_magenta_vert_crystal_core_light");

        customLamp(ModBlocks.ORANGE_CRYSTAL_CORE_LIGHT.get(), CrystalCoreLampBlock.LIT, "orange_crystal_core_light");
        invertedCustomLamp(ModBlocks.INVERTED_ORANGE_CRYSTAL_CORE_LIGHT.get(), CrystalCoreLampBlock.LIT, "inverted_orange_crystal_core_light");
        customLamp(ModBlocks.ORANGE_VERT_CRYSTAL_CORE_LIGHT.get(), CrystalCoreLampBlock.LIT, "orange_vert_crystal_core_light");
        invertedCustomLamp(ModBlocks.INVERTED_ORANGE_VERT_CRYSTAL_CORE_LIGHT.get(), CrystalCoreLampBlock.LIT, "inverted_orange_vert_crystal_core_light");

        customLamp(ModBlocks.PINK_CRYSTAL_CORE_LIGHT.get(), CrystalCoreLampBlock.LIT, "pink_crystal_core_light");
        invertedCustomLamp(ModBlocks.INVERTED_PINK_CRYSTAL_CORE_LIGHT.get(), CrystalCoreLampBlock.LIT, "inverted_pink_crystal_core_light");
        customLamp(ModBlocks.PINK_VERT_CRYSTAL_CORE_LIGHT.get(), CrystalCoreLampBlock.LIT, "pink_vert_crystal_core_light");
        invertedCustomLamp(ModBlocks.INVERTED_PINK_VERT_CRYSTAL_CORE_LIGHT.get(), CrystalCoreLampBlock.LIT, "inverted_pink_vert_crystal_core_light");

        customLamp(ModBlocks.PURPLE_CRYSTAL_CORE_LIGHT.get(), CrystalCoreLampBlock.LIT, "purple_crystal_core_light");
        invertedCustomLamp(ModBlocks.INVERTED_PURPLE_CRYSTAL_CORE_LIGHT.get(), CrystalCoreLampBlock.LIT, "inverted_purple_crystal_core_light");
        customLamp(ModBlocks.PURPLE_VERT_CRYSTAL_CORE_LIGHT.get(), CrystalCoreLampBlock.LIT, "purple_vert_crystal_core_light");
        invertedCustomLamp(ModBlocks.INVERTED_PURPLE_VERT_CRYSTAL_CORE_LIGHT.get(), CrystalCoreLampBlock.LIT, "inverted_purple_vert_crystal_core_light");

        customLamp(ModBlocks.RED_CRYSTAL_CORE_LIGHT.get(), CrystalCoreLampBlock.LIT, "red_crystal_core_light");
        invertedCustomLamp(ModBlocks.INVERTED_RED_CRYSTAL_CORE_LIGHT.get(), CrystalCoreLampBlock.LIT, "inverted_red_crystal_core_light");
        customLamp(ModBlocks.RED_VERT_CRYSTAL_CORE_LIGHT.get(), CrystalCoreLampBlock.LIT, "red_vert_crystal_core_light");
        invertedCustomLamp(ModBlocks.INVERTED_RED_VERT_CRYSTAL_CORE_LIGHT.get(), CrystalCoreLampBlock.LIT, "inverted_red_vert_crystal_core_light");

        customLamp(ModBlocks.WHITE_CRYSTAL_CORE_LIGHT.get(), CrystalCoreLampBlock.LIT, "white_crystal_core_light");
        invertedCustomLamp(ModBlocks.INVERTED_WHITE_CRYSTAL_CORE_LIGHT.get(), CrystalCoreLampBlock.LIT, "inverted_white_crystal_core_light");
        customLamp(ModBlocks.WHITE_VERT_CRYSTAL_CORE_LIGHT.get(), CrystalCoreLampBlock.LIT, "white_vert_crystal_core_light");
        invertedCustomLamp(ModBlocks.INVERTED_WHITE_VERT_CRYSTAL_CORE_LIGHT.get(), CrystalCoreLampBlock.LIT, "inverted_white_vert_crystal_core_light");


        //Horizontal Blocks:
        horizontalBlock(ModBlocks.TIBERIUM_INFUSER.get(),
                new ModelFile.UncheckedModelFile(modLoc("block/tiberium_infuser")));

    }

    private void saplingBlock(RegistryObject<Block> blockRegistryObject) {
        simpleBlock(blockRegistryObject.get(),
                models().cross(ForgeRegistries.BLOCKS.getKey(blockRegistryObject.get()).getPath(), blockTexture(blockRegistryObject.get())).renderType("cutout"));
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

    public void makeHeimBerryCrop(CropBlock block, String modelName, String textureName) {
        Function<BlockState, ConfiguredModel[]> function = state -> heimBerryStates(state, block, modelName, textureName);

        getVariantBuilder(block).forAllStates(function);
    }

    private ConfiguredModel[] heimBerryStates(BlockState state, CropBlock block, String modelName, String textureName) {
        ConfiguredModel[] models = new ConfiguredModel[1];
        models[0] = new ConfiguredModel(models().crop(modelName + state.getValue(((HeimBerryCropBlock) block).getAgeProperty()),
                new ResourceLocation(CrystalTech.MOD_ID, "block/" + textureName + state.getValue(((HeimBerryCropBlock) block).getAgeProperty()))).renderType("cutout"));

        return models;
    }

    public void makeHelFruitCrop(CropBlock block, String modelName, String textureName) {
        Function<BlockState, ConfiguredModel[]> function = state -> helFruitStates(state, block, modelName, textureName);

        getVariantBuilder(block).forAllStates(function);
    }

    private ConfiguredModel[] helFruitStates(BlockState state, CropBlock block, String modelName, String textureName) {
        ConfiguredModel[] models = new ConfiguredModel[1];
        models[0] = new ConfiguredModel(models().crop(modelName + state.getValue(((HelFruitCropBlock) block).getAgeProperty()),
                new ResourceLocation(CrystalTech.MOD_ID, "block/" + textureName + state.getValue(((HelFruitCropBlock) block).getAgeProperty()))).renderType("cutout"));

        return models;
    }


    public void makeCornCrop(CropBlock block, String modelName, String textureName) {
        Function<BlockState, ConfiguredModel[]> function = state -> cornStates(state, block, modelName, textureName);

        getVariantBuilder(block).forAllStates(function);
    }

    private ConfiguredModel[] cornStates(BlockState state, CropBlock block, String modelName, String textureName) {
        ConfiguredModel[] models = new ConfiguredModel[1];
        models[0] = new ConfiguredModel(models().crop(modelName + state.getValue(((SaberCornCropBlock) block).getAgeProperty()),
                new ResourceLocation(CrystalTech.MOD_ID, "block/" + textureName + state.getValue(((SaberCornCropBlock) block).getAgeProperty()))).renderType("cutout"));

        return models;
    }



   private void blockWithItem(RegistryObject<Block> blockRegistryObject) {
        simpleBlockWithItem(blockRegistryObject.get(), cubeAll(blockRegistryObject.get()));
   }


}
