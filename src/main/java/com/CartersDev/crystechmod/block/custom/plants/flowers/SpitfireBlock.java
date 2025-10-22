package com.CartersDev.crystechmod.block.custom.plants.flowers;


import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.Difficulty;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.BonemealableBlock;
import net.minecraft.world.level.block.FlowerBlock;
import net.minecraft.world.level.block.state.BlockState;

public class SpitfireBlock extends FlowerBlock implements BonemealableBlock {
    public SpitfireBlock(MobEffect effect, int num, Properties properties) {

        super(effect, num, properties);
    }

    @Override
    public void animateTick(BlockState pState, Level pLevel, BlockPos pPos, RandomSource pRandom) {
        float chance = 0.35f;
        if (chance < pRandom.nextFloat()) {
            pLevel.addParticle(ParticleTypes.FLAME, pPos.getX() + pRandom.nextDouble(),
                    pPos.getY() + 0.7D, pPos.getZ() + pRandom.nextDouble(),
                    0d, 0.05d, 0d);

        }

        super.animateTick(pState, pLevel, pPos, pRandom);
    }


    @Override
    public void entityInside(BlockState pState, Level pLevel, BlockPos pPos, Entity pEntity) {
        if (!pLevel.isClientSide() && pLevel.getDifficulty() != Difficulty.PEACEFUL) {
            if (pEntity instanceof LivingEntity) {
                LivingEntity target = (LivingEntity) pEntity;
                target.addEffect(new MobEffectInstance(MobEffects.GLOWING, 200));
            }
        }

    }

    public boolean isValidBonemealTarget(LevelReader p_256234_, BlockPos p_57304_, BlockState p_57305_, boolean p_57306_) {
        return true;
    }

    public boolean isBonemealSuccess(Level p_222573_, RandomSource p_222574_, BlockPos p_222575_, BlockState p_222576_) {
        return true;
    }

    public void performBonemeal(ServerLevel p_222568_, RandomSource p_222569_, BlockPos p_222570_, BlockState p_222571_) {
        popResource(p_222568_, p_222570_, new ItemStack(this));
    }

}
