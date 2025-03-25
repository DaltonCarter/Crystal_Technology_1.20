package com.CartersDev.crystechmod.datagen;


import com.CartersDev.crystechmod.CrystalTech;
import com.CartersDev.crystechmod.block.ModBlocks;
import com.CartersDev.crystechmod.fluid.ModFluids;
import com.CartersDev.crystechmod.util.ModTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.FluidTagsProvider;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.data.BlockTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModFluidTagGenerator extends FluidTagsProvider {
    public ModFluidTagGenerator(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider , @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, CrystalTech.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {

        this.tag(ModTags.Fluids.MOLTEN_GREEN_TIBERIUM)
                .add(ModFluids.SOURCE_MOLTEN_TIBERIUM.get()
                );

        this.tag(ModTags.Fluids.MOLTEN_BLUE_TIBERIUM)
                .add(ModFluids.SOURCE_MOLTEN_BLUE_TIBERIUM.get()
                );

        this.tag(ModTags.Fluids.MOLTEN_RED_TIBERIUM)
                .add(ModFluids.SOURCE_MOLTEN_RED_TIBERIUM.get()
                );

        this.tag(ModTags.Fluids.MOLTEN_PURPLE_TIBERIUM)
                .add(ModFluids.SOURCE_MOLTEN_PURPLE_TIBERIUM.get()
                );

        this.tag(ModTags.Fluids.TIBERIUM_WATER)
                .add(ModFluids.SOURCE_TIBERIUM_WATER.get()
                );

        this.tag(ModTags.Fluids.INFUSER_FLUIDS)
                .addTags(ModTags.Fluids.MOLTEN_GREEN_TIBERIUM,
                ModTags.Fluids.MOLTEN_BLUE_TIBERIUM,
                ModTags.Fluids.MOLTEN_RED_TIBERIUM,
                ModTags.Fluids.MOLTEN_PURPLE_TIBERIUM
                );




    }
}
