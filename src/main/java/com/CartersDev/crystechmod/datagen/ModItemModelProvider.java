package com.CartersDev.crystechmod.datagen;

import com.CartersDev.crystechmod.CrystalTech;
import com.CartersDev.crystechmod.block.ModBlocks;
import com.CartersDev.crystechmod.item.ModItems;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItemModelProvider extends ItemModelProvider {
    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, CrystalTech.MOD_ID, existingFileHelper);
    }


    @Override
    protected void registerModels() {

        simpleItem(ModItems.TIBERIUM);
        simpleItem(ModItems.TIBERIUM_BLUE);
        simpleItem(ModItems.TIBERIUM_RED);
        simpleItem(ModItems.TIBERIUM_PURPLE);

        simpleItem(ModItems.AERIES_CRYSTAL);
        simpleItem(ModItems.ILLUMINA_CRYSTAL);
        simpleItem(ModItems.ENIGMA_CRYSTAL);
        simpleItem(ModItems.KRYON_CRYSTAL);

        simpleItem(ModItems.GUNDANIUM_DUST);
        simpleItem(ModItems.GUNDANIUM_INGOT);
        simpleItem(ModItems.ALYTHUM_DUST);
        simpleItem(ModItems.ALYTHUM_INGOT);
        simpleItem(ModItems.LG_CORE_BLEND);
        simpleItem(ModItems.LG_CORE_INGOT);
        simpleItem(ModItems.MG_CORE_BLEND);
        simpleItem(ModItems.MG_CORE_INGOT);
        simpleItem(ModItems.HG_CORE_BLEND);
        simpleItem(ModItems.HG_CORE_INGOT);
        simpleItem(ModItems.ILLYRIM_BLEND);
        simpleItem(ModItems.ILLYRIM_INGOT);
        simpleItem(ModItems.RAW_QUALRITE);
        simpleItem(ModItems.RAW_ALYTHUM);
        simpleItem(ModItems.RAW_GUNDANIUM);
        simpleItem(ModItems.QUALRIM_COMPOUND);
        simpleItem(ModItems.GDI_EMBLEM);
        simpleItem(ModItems.NOD_EMBLEM);
        simpleItem(ModItems.WOLF_EMBLEM);
        simpleItem(ModItems.PLAGUED_STICK);
        simpleItem(ModItems.FIRESTONE);

        simpleItem(ModItems.TIBERIUM_FRUIT);

        paneItem(ModBlocks.CLEAR_TIBERGLASS_PANE, ModBlocks.CLEAR_TIBERGLASS);
        paneItem(ModBlocks.MOSAIC_TIBERGLASS_PANE, ModBlocks.MOSAIC_TIBERGLASS);
        paneItem(ModBlocks.GDI_TIBERGLASS_PANE, ModBlocks.GDI_TIBERGLASS);
        paneItem(ModBlocks.NOD_TIBERGLASS_PANE, ModBlocks.NOD_TIBERGLASS);
        paneItem(ModBlocks.WOLF_TIBERGLASS_PANE, ModBlocks.WOLF_TIBERGLASS);
        paneItem(ModBlocks.BLACK_TIBERGLASS_PANE, ModBlocks.BLACK_TIBERGLASS);
        paneItem(ModBlocks.BLUE_TIBERGLASS_PANE, ModBlocks.BLUE_TIBERGLASS);
        paneItem(ModBlocks.BROWN_TIBERGLASS_PANE, ModBlocks.BROWN_TIBERGLASS);
        paneItem(ModBlocks.CYAN_TIBERGLASS_PANE, ModBlocks.CYAN_TIBERGLASS);
        paneItem(ModBlocks.GRAY_TIBERGLASS_PANE, ModBlocks.GRAY_TIBERGLASS);
        paneItem(ModBlocks.GREEN_TIBERGLASS_PANE, ModBlocks.GREEN_TIBERGLASS);
        paneItem(ModBlocks.LIGHT_BLUE_TIBERGLASS_PANE, ModBlocks.LIGHT_BLUE_TIBERGLASS);
        paneItem(ModBlocks.LIGHT_GRAY_TIBERGLASS_PANE, ModBlocks.LIGHT_GRAY_TIBERGLASS);
        paneItem(ModBlocks.LIME_TIBERGLASS_PANE, ModBlocks.LIME_TIBERGLASS);
        paneItem(ModBlocks.MAGENTA_TIBERGLASS_PANE, ModBlocks.MAGENTA_TIBERGLASS);
        paneItem(ModBlocks.ORANGE_TIBERGLASS_PANE, ModBlocks.ORANGE_TIBERGLASS);
        paneItem(ModBlocks.PINK_TIBERGLASS_PANE, ModBlocks.PINK_TIBERGLASS);
        paneItem(ModBlocks.PURPLE_TIBERGLASS_PANE, ModBlocks.PURPLE_TIBERGLASS);
        paneItem(ModBlocks.RED_TIBERGLASS_PANE, ModBlocks.RED_TIBERGLASS);
        paneItem(ModBlocks.WHITE_TIBERGLASS_PANE, ModBlocks.WHITE_TIBERGLASS);
        paneItem(ModBlocks.YELLOW_TIBERGLASS_PANE, ModBlocks.YELLOW_TIBERGLASS);

        simpleBlockItem(ModBlocks.PLAGUED_DOOR);

        fenceItem(ModBlocks.PLAGUED_FENCE, ModBlocks.PLAGUED_PLANKS);
        buttonItem(ModBlocks.PLAGUED_BUTTON, ModBlocks.PLAGUED_PLANKS);

        evenSimplerBlockItem(ModBlocks.PLAGUED_STAIRS);
        evenSimplerBlockItem(ModBlocks.INFESTED_COBBLE_STAIRS);
        evenSimplerBlockItem(ModBlocks.INFESTED_STONE_BRICK_STAIRS);
        evenSimplerBlockItem(ModBlocks.BLACK_TIBERCRETE_STAIRS);
        evenSimplerBlockItem(ModBlocks.BLUE_TIBERCRETE_STAIRS);
        evenSimplerBlockItem(ModBlocks.BROWN_TIBERCRETE_STAIRS);
        evenSimplerBlockItem(ModBlocks.CYAN_TIBERCRETE_STAIRS);
        evenSimplerBlockItem(ModBlocks.GRAY_TIBERCRETE_STAIRS);
        evenSimplerBlockItem(ModBlocks.GREEN_TIBERCRETE_STAIRS);
        evenSimplerBlockItem(ModBlocks.LIGHT_BLUE_TIBERCRETE_STAIRS);
        evenSimplerBlockItem(ModBlocks.LIGHT_GRAY_TIBERCRETE_STAIRS);
        evenSimplerBlockItem(ModBlocks.LIME_TIBERCRETE_STAIRS);
        evenSimplerBlockItem(ModBlocks.MAGENTA_TIBERCRETE_STAIRS);
        evenSimplerBlockItem(ModBlocks.ORANGE_TIBERCRETE_STAIRS);
        evenSimplerBlockItem(ModBlocks.PINK_TIBERCRETE_STAIRS);
        evenSimplerBlockItem(ModBlocks.PURPLE_TIBERCRETE_STAIRS);
        evenSimplerBlockItem(ModBlocks.RED_TIBERCRETE_STAIRS);
        evenSimplerBlockItem(ModBlocks.WHITE_TIBERCRETE_STAIRS);
        evenSimplerBlockItem(ModBlocks.YELLOW_TIBERCRETE_STAIRS);
        evenSimplerBlockItem(ModBlocks.PLAGUED_SLAB);
        evenSimplerBlockItem(ModBlocks.INFESTED_COBBLE_SLAB);
        evenSimplerBlockItem(ModBlocks.INFESTED_STONE_BRICK_SLAB);
        evenSimplerBlockItem(ModBlocks.PLAGUED_PRESSURE_PLATE);
        evenSimplerBlockItem(ModBlocks.PLAGUED_FENCE_GATE);

        trapdoorItem((ModBlocks.PLAGUED_TRAPDOOR));
        wallItem((ModBlocks.FIRESTONE_WALL), ModBlocks.FIRESTONE_BLOCK);

    }



    private ItemModelBuilder simpleItem(RegistryObject<Item> item) {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/generated")).texture("layer0",
                new ResourceLocation(CrystalTech.MOD_ID, "item/" + item.getId().getPath()));
    }

    public void evenSimplerBlockItem(RegistryObject<Block> block) {
        this.withExistingParent(CrystalTech.MOD_ID + ":" + ForgeRegistries.BLOCKS.getKey(block.get()).getPath(),
                modLoc("block/" + ForgeRegistries.BLOCKS.getKey(block.get()).getPath()));
    }

    private ItemModelBuilder paneItem(RegistryObject<Block> item, RegistryObject<Block> baseBlock) {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/generated")).texture("layer0",
                new ResourceLocation(CrystalTech.MOD_ID,"block/" + baseBlock.getId().getPath()));
    }

    public void trapdoorItem(RegistryObject<Block> block) {
        this.withExistingParent(ForgeRegistries.BLOCKS.getKey(block.get()).getPath(),
                modLoc("block/" + ForgeRegistries.BLOCKS.getKey(block.get()).getPath() + "_bottom"));
    }

    public void fenceItem(RegistryObject<Block> block, RegistryObject<Block> baseBlock) {
        this.withExistingParent(ForgeRegistries.BLOCKS.getKey(block.get()).getPath(), mcLoc("block/fence_inventory"))
                .texture("texture",  new ResourceLocation(CrystalTech.MOD_ID, "block/" + ForgeRegistries.BLOCKS.getKey(baseBlock.get()).getPath()));
    }

    public void buttonItem(RegistryObject<Block> block, RegistryObject<Block> baseBlock) {
        this.withExistingParent(ForgeRegistries.BLOCKS.getKey(block.get()).getPath(), mcLoc("block/button_inventory"))
                .texture("texture",  new ResourceLocation(CrystalTech.MOD_ID, "block/" + ForgeRegistries.BLOCKS.getKey(baseBlock.get()).getPath()));
    }

    public void wallItem(RegistryObject<Block> block, RegistryObject<Block> baseBlock) {
        this.withExistingParent(ForgeRegistries.BLOCKS.getKey(block.get()).getPath(), mcLoc("block/wall_inventory"))
                .texture("wall",  new ResourceLocation(CrystalTech.MOD_ID, "block/" + ForgeRegistries.BLOCKS.getKey(baseBlock.get()).getPath()));
    }

    private ItemModelBuilder simpleBlockItem(RegistryObject<Block> item) {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/generated")).texture("layer0",
                new ResourceLocation(CrystalTech.MOD_ID,"item/" + item.getId().getPath()));
    }

}
