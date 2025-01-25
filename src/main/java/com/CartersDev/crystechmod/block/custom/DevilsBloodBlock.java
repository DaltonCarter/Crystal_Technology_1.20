package com.CartersDev.crystechmod.block.custom;


import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.RandomSource;
import net.minecraft.world.Difficulty;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.FlowerBlock;
import net.minecraft.world.level.block.state.BlockState;

public class DevilsBloodBlock extends FlowerBlock {
    public DevilsBloodBlock(MobEffect effect, int num, Properties properties) {

        super(effect, num, properties);
    }

    @Override
    public void animateTick(BlockState pState, Level pLevel, BlockPos pPos, RandomSource pRandom) {
        float chance = 0.35f;
        if (chance < pRandom.nextFloat()) {
            pLevel.addParticle(ParticleTypes.CRIMSON_SPORE, pPos.getX() + pRandom.nextDouble(),
                    pPos.getY() + 0.7D, pPos.getZ() + pRandom.nextDouble(),
                    0d, 0.05d, 0d);

        }

        super.animateTick(pState, pLevel, pPos, pRandom);
    }

    protected boolean mayPlaceOn(BlockState pState, BlockGetter pLevel, BlockPos pPos) {
        return pState.is(BlockTags.DIRT) || pState.is(Blocks.FARMLAND) || pState.is(Blocks.NETHERRACK ) || pState.is(Blocks.CRIMSON_NYLIUM) || pState.is(Blocks.WARPED_NYLIUM);
    }

    @Override
    public void entityInside(BlockState pState, Level pLevel, BlockPos pPos, Entity pEntity) {
        if (!pLevel.isClientSide() && pLevel.getDifficulty() != Difficulty.PEACEFUL) {
            if (pEntity instanceof LivingEntity) {
                LivingEntity target = (LivingEntity) pEntity;
                target.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 200));
            }
        }

    }

}
