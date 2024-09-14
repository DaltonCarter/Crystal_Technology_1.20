package com.CartersDev.crystechmod.block.custom;



import com.CartersDev.crystechmod.particle.ModParticles;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.LeavesBlock;
import net.minecraft.world.level.block.state.BlockState;


public class EmberLeavesBlock extends LeavesBlock {
    public EmberLeavesBlock(Properties properties) {
        super(properties);
    }

    @Override
    public void animateTick(BlockState stateIn, Level worldIn, BlockPos pos, RandomSource rand) {
        float chance = 0.35f;
        if (chance < rand.nextFloat()) {
            worldIn.addParticle(ModParticles.EMBER_PARTICLES.get(), pos.getX() + rand.nextDouble(),
                    pos.getY() + 0.0D, pos.getZ() + rand.nextDouble(),
                    0d, 0.05d, 0d);

        }


        super.animateTick(stateIn, worldIn, pos, rand);
    }

    @Override
    public boolean isFlammable(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
        return false;
    }

    @Override
    public int getFlammability(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
        return 0;
    }

    @Override
    public int getFireSpreadSpeed(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
        return 0;
    }
}
