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

        blockWithItem(ModBlocks.AERIES_BLOCK);
        blockWithItem(ModBlocks.ILLYRIM_BLOCK);
        blockWithItem(ModBlocks.ENIGMA_BLOCK);
        blockWithItem(ModBlocks.KRYON_BLOCK);

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


    }


   private void blockWithItem(RegistryObject<Block> blockRegistryObject) {
        simpleBlockWithItem(blockRegistryObject.get(), cubeAll(blockRegistryObject.get()));
   }

}