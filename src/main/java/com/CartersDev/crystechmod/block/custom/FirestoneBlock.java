package com.CartersDev.crystechmod.block.custom;

import com.CartersDev.crystechmod.item.custom.Firestone;
import com.CartersDev.crystechmod.particle.ModParticles;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.BlockParticleOption;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;


public class FirestoneBlock extends Block {

    public FirestoneBlock(Properties properties) {
        super(properties);
    }


    @Override
    public InteractionResult use(BlockState pState, Level pLevel, BlockPos pPos, Player pPlayer, InteractionHand pHand, BlockHitResult pHit) {
        if(pLevel.isClientSide()){

            int x = pPos.getX();
            int y = pPos.getY();
            int z = pPos.getZ();

                spawnTouchParticles(pLevel, pPos);
                pLevel.playSound(null,x, y, z, SoundEvents.FIRE_EXTINGUISH, SoundSource.BLOCKS, 1f, 1f);
                pPlayer.sendSystemMessage(Component.literal("OW! That's hot!. Probably shouldn't try to touch that..."));

        }

        return super.use(pState, pLevel, pPos, pPlayer, pHand, pHit);
    }

    private void spawnTouchParticles(Level pLevel, BlockPos positionClicked) {
        for (int i = 0; i < 360; i++) {
            if(i % 20 == 0) {
                pLevel.addParticle(ModParticles.YOKARITE_PARTICLES.get(),
                        positionClicked.getX() + 0.5D, positionClicked.getY() + 1, positionClicked.getZ() +  0.5D,
                        Math.cos(i) * 0.25d, 0.15d, Math.sin(i) * 0.25d);
            }
        }
    }

    @Override
    public void animateTick(BlockState pState, Level pLevel, BlockPos pPos, RandomSource pRandom) {
        float chance = 0.35f;
        if(chance < pRandom.nextFloat()) {
            pLevel.addParticle(ParticleTypes.FLAME, pPos.getX() + pRandom.nextDouble(),
                    pPos.getY() + 0.5D, pPos.getZ() + pRandom.nextDouble(),
                    0d, 0.05d, 0d);

            pLevel.addParticle(new BlockParticleOption(ParticleTypes.BLOCK, pState), pPos.getX() + pRandom.nextDouble(),
                    pPos.getY() + 0.5D, pPos.getZ() + pRandom.nextDouble(),
                    0.0D, 0.05D, 0.0D);
        }



        super.animateTick(pState, pLevel, pPos, pRandom);
    }

    @Override
    public void stepOn(Level pLevel, BlockPos pPos, BlockState pState, Entity pEntity) {
        Firestone.lightEntityOnFire(pEntity, 5);
        super.stepOn(pLevel, pPos, pState, pEntity);
    }
}
