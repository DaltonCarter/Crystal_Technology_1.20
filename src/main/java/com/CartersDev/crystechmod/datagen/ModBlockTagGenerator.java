package com.CartersDev.crystechmod.datagen;


import com.CartersDev.crystechmod.CrystalTech;
import com.CartersDev.crystechmod.block.ModBlocks;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.data.BlockTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagGenerator extends BlockTagsProvider {
    public ModBlockTagGenerator(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider , @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, CrystalTech.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {



        this.tag(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(ModBlocks.TIBERIUM_BLOCK.get(),
                ModBlocks.TIBERIUM_BLUE_BLOCK.get(),
                ModBlocks.GUNDANIUM_ORE.get(),
                ModBlocks.FIRESTONE_BLOCK.get()
                );

        this.tag(BlockTags.MINEABLE_WITH_SHOVEL)
                .add(ModBlocks.YELLOW_ZONE_SAND.get(),
                        ModBlocks.RED_ZONE_SAND.get(),
                        ModBlocks.RED_ZONE_DIRT.get(),
                        ModBlocks.YELLOW_ZONE_CRACKED_DIRT.get(),
                        ModBlocks.SEEDED_YELLOW_ZONE_CRACKED_DIRT.get(),
                        ModBlocks.SEEDED_RED_ZONE_DIRT.get(),
                        ModBlocks.SEEDED_DIRT.get()
                );

        this.tag(BlockTags.NEEDS_STONE_TOOL)
                .add(ModBlocks.INFESTED_STONE.get()
                );

        this.tag(BlockTags.NEEDS_IRON_TOOL)
                .add(ModBlocks.GUNDANIUM_ORE.get(),
                ModBlocks.TIBERIUM_BLOCK.get(),
                ModBlocks.TIBERIUM_BLUE_BLOCK.get()
                );

        this.tag(BlockTags.NEEDS_DIAMOND_TOOL)
                .add(ModBlocks.LG_CORE_BLOCK.get()
                );

        this.tag(Tags.Blocks.NEEDS_NETHERITE_TOOL)
                .add(ModBlocks.RIPARIUS_CRYSTAL.get(),
                ModBlocks.VINIFERA_CRYSTAL.get(),
                ModBlocks.CRUENTUS_CRYSTAL.get(),
                ModBlocks.ABOREUS_CRYSTAL.get()
                );


    }
}
