package com.CartersDev.crystechmod.datagen;

import com.CartersDev.crystechmod.CrystalTech;
import com.CartersDev.crystechmod.item.ModItems;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
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

        simpleItem(ModItems.TIBERIUM_FRUIT);

    }



    private ItemModelBuilder simpleItem(RegistryObject<Item> item) {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/generated")).texture("layer0",
                new ResourceLocation(CrystalTech.MOD_ID, "item/" + item.getId().getPath()));
    }

}
