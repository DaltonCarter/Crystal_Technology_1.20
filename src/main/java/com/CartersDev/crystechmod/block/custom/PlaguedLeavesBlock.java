package com.CartersDev.crystechmod.block.custom;



import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.LeavesBlock;
import net.minecraft.world.level.block.state.BlockState;



public class PlaguedLeavesBlock extends ModLeavesBlock {
    public PlaguedLeavesBlock(Properties properties) {
        super(properties);
    }

    @Override
    public void animateTick(BlockState stateIn, Level worldIn, BlockPos pos, RandomSource rand) {
        float chance = 0.35f;
        if (chance < rand.nextFloat()) {
            worldIn.addParticle(ParticleTypes.DRIPPING_OBSIDIAN_TEAR, pos.getX() + rand.nextDouble(),
                    pos.getY() + 0.0D, pos.getZ() + rand.nextDouble(),
                    0d, 0.05d, 0d);

        }


        super.animateTick(stateIn, worldIn, pos, rand);
    }

}
