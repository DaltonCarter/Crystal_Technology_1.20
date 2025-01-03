package com.CartersDev.crystechmod.block.custom;

import com.CartersDev.crystechmod.block.ModBlocks;
import net.minecraft.world.level.block.AttachedStemBlock;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.MelonBlock;
import net.minecraft.world.level.block.StemBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;

public class LaiMelonBlock extends MelonBlock {
    public LaiMelonBlock(BlockBehaviour.Properties properties) {
        super(properties);
    }

    public StemBlock getStem() {
        return (StemBlock) ModBlocks.LAI_MELON_STEM.get();
    }

    public AttachedStemBlock getAttachedStem() {
        return (AttachedStemBlock)ModBlocks.ATTACHED_LAI_MELON_STEM.get();
    }
}
