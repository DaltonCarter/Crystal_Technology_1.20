package com.CartersDev.crystechmod.datagen;

import com.CartersDev.crystechmod.CrystalTech;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.PaintingVariantTagsProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.PaintingVariantTags;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModPaintingVariantTagProvider extends PaintingVariantTagsProvider {
    public ModPaintingVariantTagProvider(PackOutput pOutput, CompletableFuture<HolderLookup.Provider> pProvider , @Nullable ExistingFileHelper existingFileHelper) {
        super(pOutput, pProvider, CrystalTech.MOD_ID, existingFileHelper);
    }


    @Override
    protected void addTags(HolderLookup.Provider pProvider) {
//        this.tag(PaintingVariantTags.PLACEABLE)
//                .addOptional(new ResourceLocation(CrystalTech.MOD_ID, "saw_them"));
    }
}
