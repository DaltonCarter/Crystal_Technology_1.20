package com.CartersDev.crystechmod.block.custom;

import com.CartersDev.crystechmod.particle.ModParticles;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.TorchBlock;
import net.minecraft.world.level.block.WallTorchBlock;
import net.minecraft.world.level.block.state.BlockState;

public class CrystalWallTorchBlock extends WallTorchBlock {
    protected final String tiberium;

    public CrystalWallTorchBlock(Properties pProperties, ParticleOptions pFlameParticle, String tiberium) {
        super(pProperties, pFlameParticle);
        this.tiberium = tiberium;
    }

    @Override
    public void animateTick(BlockState pState, Level pLevel, BlockPos pPos, RandomSource pRandom) {
        Direction direction = pState.getValue(FACING);
        double d0 = (double)pPos.getX() + 0.5D;
        double d1 = (double)pPos.getY() + 0.7D;
        double d2 = (double)pPos.getZ() + 0.5D;
        double d3 = 0.22D;
        double d4 = 0.27D;
        Direction direction1 = direction.getOpposite();

        switch (this.tiberium) {
            case "green":
                pLevel.addParticle(ModParticles.RIPARIUS_PARTICLES.get(),d0 + 0.27D * (double)direction1.getStepX(), d1 + 0.22D, d2 + 0.27D * (double)direction1.getStepZ(), 0.0D, 0.0D, 0.0D);
                break;

            case "blue":
                pLevel.addParticle(ModParticles.VINIFERA_PARTICLES.get(), d0 + 0.27D * (double)direction1.getStepX(), d1 + 0.22D, d2 + 0.27D * (double)direction1.getStepZ(), 0.0D, 0.0D, 0.0D);
                break;

            case "red":
                pLevel.addParticle(ModParticles.CRUENTUS_PARTICLES.get(), d0 + 0.27D * (double)direction1.getStepX(), d1 + 0.22D, d2 + 0.27D * (double)direction1.getStepZ(), 0.0D, 0.0D, 0.0D);
                break;

            case "purple":
                pLevel.addParticle(ModParticles.ABOREUS_PARTICLES.get(), d0 + 0.27D * (double)direction1.getStepX(), d1 + 0.22D, d2 + 0.27D * (double)direction1.getStepZ(), 0.0D, 0.0D, 0.0D);
                break;

            default: break;
        }


    }



}
