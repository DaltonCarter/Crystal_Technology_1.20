package com.CartersDev.crystechmod.block.custom;

import com.CartersDev.crystechmod.CrystalTech;
import com.CartersDev.crystechmod.particle.ModParticles;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.util.RandomSource;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.TorchBlock;
import net.minecraft.world.level.block.state.BlockState;

public class CrystalTorchBlock extends TorchBlock {

protected final String tiberium;

    public CrystalTorchBlock(Properties pProperties, ParticleOptions pFlameParticle, String tiberium) {
        super(pProperties, pFlameParticle);

        this.tiberium = tiberium;
    }

    @Override
    public void animateTick(BlockState pState, Level pLevel, BlockPos pPos, RandomSource pRandom) {

        double d0 = (double)pPos.getX() + 0.5D;
        double d1 = (double)pPos.getY() + 0.7D;
        double d2 = (double)pPos.getZ() + 0.5D;

        switch (this.tiberium) {
            case "green":
                pLevel.addParticle(ModParticles.RIPARIUS_PARTICLES.get(), d0, d1, d2, 0.0D, 0.0D, 0.0D);
                break;

            case "blue":
                pLevel.addParticle(ModParticles.VINIFERA_PARTICLES.get(), d0, d1, d2, 0.0D, 0.0D, 0.0D);
                break;

            case "red":
                pLevel.addParticle(ModParticles.CRUENTUS_PARTICLES.get(), d0, d1, d2, 0.0D, 0.0D, 0.0D);
                break;

            case "purple":
                pLevel.addParticle(ModParticles.ABOREUS_PARTICLES.get(), d0, d1, d2, 0.0D, 0.0D, 0.0D);
                break;

            default: break;
        }


    }



}
