package com.CartersDev.crystechmod.datagen;

import com.CartersDev.crystechmod.CrystalTech;
import com.CartersDev.crystechmod.item.ModItems;
import com.CartersDev.crystechmod.util.ModTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;



public class ModItemTagGenerator extends ItemTagsProvider {
    public ModItemTagGenerator(PackOutput p_275343_, CompletableFuture<HolderLookup.Provider> p_275729_,
                               CompletableFuture<TagLookup<Block>> p_275322_, @Nullable ExistingFileHelper existingFileHelper) {
        super(p_275343_, p_275729_, p_275322_, CrystalTech.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {

    this.copy(ModTags.Blocks.TIBERCRETE_SANDS, ModTags.Items.TIBERCRETE_SANDS);

        this.tag(ItemTags.TRIMMABLE_ARMOR)
                .add(ModItems.GUNDANIUM_HELMET.get(),
                        ModItems.GUNDANIUM_CHESTPLATE.get(),
                        ModItems.GUNDANIUM_LEGGINGS.get(),
                        ModItems.GUNDANIUM_BOOTS.get());

        this.tag(ModTags.Items.STICKS)
                .add(ModItems.PLAGUED_STICK.get(),
                        Items.STICK);

    }
}
