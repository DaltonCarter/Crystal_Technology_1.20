package com.CartersDev.crystechmod.block.custom.terrainBlocks;

import com.CartersDev.crystechmod.block.ModBlocks;
import com.CartersDev.crystechmod.particle.ModParticles;
import net.minecraft.core.BlockPos;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;

public class SeededBlock extends Block {

    public SeededBlock(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public void animateTick(BlockState pState, Level pLevel, BlockPos pPos, RandomSource pRandom) {
        BlockPos above = pPos.above();
        BlockState aboveState = pLevel.getBlockState(above);
        Block aboveBlock = aboveState.getBlock();
        if(aboveBlock == ModBlocks.GREEN_TIBERIUM_CROP.get() || aboveBlock == ModBlocks.BLUE_TIBERIUM_CROP.get() || aboveBlock == ModBlocks.RED_TIBERIUM_CROP.get() || aboveBlock == ModBlocks.PURPLE_TIBERIUM_CROP.get()) {

        }else {
            float chance = 0.95f;
            if (chance < pRandom.nextFloat()) {
                pLevel.addParticle(ModParticles.INFECTION_PARTICLES.get(), pPos.getX() + pRandom.nextDouble(),
                        pPos.getY() + 0.7D, pPos.getZ() + pRandom.nextDouble(),
                        0d, 0.05d, 0d);
            }
        }
        super.animateTick(pState, pLevel, pPos, pRandom);
    }

}
