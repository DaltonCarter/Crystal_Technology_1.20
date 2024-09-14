package com.CartersDev.crystechmod.block.custom;

import com.CartersDev.crystechmod.particle.ModParticles;
import net.minecraft.core.BlockPos;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.Level;

import net.minecraft.world.level.block.state.BlockState;

public class MarikaLeaves extends ModLeavesBlock {
    public MarikaLeaves(Properties properties) {
        super(properties);
    }


    @Override
    public void animateTick(BlockState pState, Level pLevel, BlockPos pPos, RandomSource pRandom) {
        float chance = 0.35f;
        if(chance < pRandom.nextFloat()) {
            pLevel.addParticle(ModParticles.MARIKA_PARTICLES.get(), pPos.getX() + pRandom.nextDouble(),
                    pPos.getY() + -0.4D, pPos.getZ() + pRandom.nextDouble(), 0d, 0.05d, 0d);

        }




        }
}