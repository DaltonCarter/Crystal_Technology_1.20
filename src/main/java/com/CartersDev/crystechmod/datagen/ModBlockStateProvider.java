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
        blockWithItem(ModBlocks.TIBERIUM_BLOCK);

        blockWithItem(ModBlocks.GUNDANIUM_ORE);
//        blockWithItem(ModBlocks.DEEPSLATE_SAPPHIRE_ORE);
//        blockWithItem(ModBlocks.NETHER_SAPPHIRE_ORE);
//        blockWithItem(ModBlocks.END_SAPPHIRE_ORE);


        blockWithItem(ModBlocks.FIRESTONE_BLOCK);


    }


   private void blockWithItem(RegistryObject<Block> blockRegistryObject) {
        simpleBlockWithItem(blockRegistryObject.get(), cubeAll(blockRegistryObject.get()));
   }

}
