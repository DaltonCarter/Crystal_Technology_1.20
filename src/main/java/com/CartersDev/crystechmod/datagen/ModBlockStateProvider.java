package com.CartersDev.crystechmod.datagen;

import com.CartersDev.crystechmod.CrystalTech;

import com.CartersDev.crystechmod.block.ModBlocks;
import net.minecraft.data.PackOutput;
import net.minecraft.world.level.block.Block;
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

        blockWithItem(ModBlocks.TIBERIUM_SOIL);
        blockWithItem(ModBlocks.ICHOR_SOIL);



    }


   private void blockWithItem(RegistryObject<Block> blockRegistryObject) {
        simpleBlockWithItem(blockRegistryObject.get(), cubeAll(blockRegistryObject.get()));
   }


}
