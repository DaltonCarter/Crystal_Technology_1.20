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
                ModBlocks.TIBERIUM_RED_BLOCK.get(),
                ModBlocks.TIBERIUM_PURPLE_BLOCK.get(),
                ModBlocks.GUNDANIUM_ORE.get(),
                ModBlocks.DEEPSLATE_GUNDANIUM_ORE.get(),
                ModBlocks.GUNDANIUM_BLOCK.get(),
                ModBlocks.AERIES_BLOCK.get(),
                ModBlocks.AERIES_ORE.get(),
                ModBlocks.DEEPSLATE_AERIES_ORE.get(),
                ModBlocks.NETHER_AERIES_ORE.get(),
                ModBlocks.ENIGMA_ORE.get(),
                ModBlocks.DEEPSLATE_ENIGMA_ORE.get(),
                ModBlocks.END_ENIGMA_ORE.get(),
                ModBlocks.ENIGMA_BLOCK.get(),
                ModBlocks.ILLUMINA_BLOCK.get(),
                ModBlocks.ILLUMINA_ORE.get(),
                ModBlocks.DEEPSLATE_ILLUMINA_ORE.get(),
                ModBlocks.KRYON_BLOCK.get(),
                ModBlocks.KRYON_ORE.get(),
                ModBlocks.DEEPSLATE_KRYON_ORE.get(),
                ModBlocks.NETHER_KRYON_ORE.get(),
                ModBlocks.END_KRYON_ORE.get(),
                ModBlocks.ALYTHUM_BLOCK.get(),
                ModBlocks.ALYTHUM_ORE.get(),
                ModBlocks.DEEPSLATE_ALYTHUM_ORE.get(),
                ModBlocks.NETHER_ALYTHUM_ORE.get(),
                ModBlocks.QUALRITE_ORE.get(),
                ModBlocks.DEEPSLATE_QUALRITE_ORE.get(),
                ModBlocks.NETHER_QUALRITE_ORE.get(),
                ModBlocks.RIPARIUS_CRYSTAL.get(),
                ModBlocks.ABOREUS_CRYSTAL.get(),
                ModBlocks.VINIFERA_CRYSTAL.get(),
                ModBlocks.CRUENTUS_CRYSTAL.get(),
                ModBlocks.RIPARIUS_STONE.get(),
                ModBlocks.VINIFERA_STONE.get(),
                ModBlocks.CRUENTUS_STONE.get(),
                ModBlocks.ABOREUS_STONE.get(),
                ModBlocks.INFESTED_STONE.get(),
                ModBlocks.INFESTED_ANDESITE.get(),
                ModBlocks.INFESTED_COBBLE.get(),
                ModBlocks.INFESTED_DIORITE.get(),
                ModBlocks.INFESTED_GRANITE.get(),
                ModBlocks.INFESTED_STONE_BRICKS.get(),
                ModBlocks.LG_CORE_BLOCK.get(),
                ModBlocks.MG_CORE_BLOCK.get(),
                ModBlocks.HG_CORE_BLOCK.get(),
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
                .add(ModBlocks.INFESTED_STONE.get(),
                        ModBlocks.INFESTED_STONE_BRICKS.get(),
                        ModBlocks.INFESTED_COBBLE.get(),
                        ModBlocks.INFESTED_DIORITE.get(),
                        ModBlocks.INFESTED_ANDESITE.get(),
                        ModBlocks.INFESTED_GRANITE.get()
                );

        this.tag(BlockTags.NEEDS_IRON_TOOL)
                .add(ModBlocks.GUNDANIUM_ORE.get(),
                ModBlocks.TIBERIUM_BLOCK.get(),
                ModBlocks.TIBERIUM_BLUE_BLOCK.get(),
                ModBlocks.RIPARIUS_STONE.get(),
                ModBlocks.VINIFERA_STONE.get(),
                ModBlocks.CRUENTUS_STONE.get(),
                ModBlocks.ABOREUS_STONE.get(),
                ModBlocks.FIRESTONE_BLOCK.get(),
                ModBlocks.AERIES_BLOCK.get(),
                ModBlocks.ENIGMA_BLOCK.get(),
                ModBlocks.ILLUMINA_BLOCK.get(),
                ModBlocks.KRYON_BLOCK.get(),
                ModBlocks.GUNDANIUM_BLOCK.get(),
                ModBlocks.ALYTHUM_BLOCK.get(),
                ModBlocks.ILLYRIM_BLOCK.get(),
                ModBlocks.DEEPSLATE_GUNDANIUM_ORE.get()
                );

        this.tag(BlockTags.NEEDS_DIAMOND_TOOL)
                .add(ModBlocks.LG_CORE_BLOCK.get(),
                 ModBlocks.MG_CORE_BLOCK.get(),
                 ModBlocks.HG_CORE_BLOCK.get(),
                 ModBlocks.TIBERIUM_RED_BLOCK.get(),
                 ModBlocks.AERIES_ORE.get(),
                 ModBlocks.DEEPSLATE_AERIES_ORE.get(),
                 ModBlocks.NETHER_AERIES_ORE.get(),
                 ModBlocks.ENIGMA_ORE.get(),
                 ModBlocks.DEEPSLATE_ENIGMA_ORE.get(),
                 ModBlocks.END_ENIGMA_ORE.get(),
                 ModBlocks.ILLUMINA_ORE.get(),
                 ModBlocks.DEEPSLATE_ILLUMINA_ORE.get(),
                 ModBlocks.KRYON_ORE.get(),
                 ModBlocks.DEEPSLATE_KRYON_ORE.get(),
                 ModBlocks.NETHER_KRYON_ORE.get(),
                 ModBlocks.END_KRYON_ORE.get(),
                 ModBlocks.ALYTHUM_ORE.get(),
                 ModBlocks.DEEPSLATE_ALYTHUM_ORE.get(),
                 ModBlocks.NETHER_ALYTHUM_ORE.get(),
                 ModBlocks.QUALRITE_ORE.get(),
                 ModBlocks.DEEPSLATE_QUALRITE_ORE.get(),
                 ModBlocks.NETHER_QUALRITE_ORE.get()
                );

        this.tag(Tags.Blocks.NEEDS_NETHERITE_TOOL)
                .add(ModBlocks.RIPARIUS_CRYSTAL.get(),
                ModBlocks.VINIFERA_CRYSTAL.get(),
                ModBlocks.CRUENTUS_CRYSTAL.get(),
                ModBlocks.ABOREUS_CRYSTAL.get()
                );


    }
}
