package com.CartersDev.crystechmod.block.custom;



import com.CartersDev.crystechmod.item.custom.Firestone;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.BlockParticleOption;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.network.chat.Component;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.WallBlock;
import net.minecraft.world.level.block.state.BlockState;

import javax.annotation.Nullable;
import java.util.List;
import java.util.Random;

public class FirestoneWallBlock extends WallBlock {

    public FirestoneWallBlock(Properties properties) {
        super(properties);
    }


    @Override
    public void animateTick(BlockState stateIn, Level worldIn, BlockPos pos, RandomSource rand) {
        float chance = 0.35f;
        if (chance < rand.nextFloat()) {
            worldIn.addParticle(ParticleTypes.FLAME, pos.getX() + rand.nextDouble(),
                    pos.getY() + 0.5D, pos.getZ() + rand.nextDouble(),
                    0d, 0.05d, 0d);

            worldIn.addParticle(new BlockParticleOption(ParticleTypes.BLOCK, stateIn), pos.getX() + rand.nextDouble(),
                    pos.getY() + 0.5D, pos.getZ() + rand.nextDouble(),
                    0.0D, 0.05D, 0.0D);
        }


        super.animateTick(stateIn, worldIn, pos, rand);
    }


    @Override
    public void stepOn(Level worldIn, BlockPos pos, BlockState pState, Entity entityIn) {
        Firestone.lightEntityOnFire(entityIn, 5);
        super.stepOn(worldIn, pos, pState, entityIn);
    }

    @Override
    public void entityInside(BlockState pState, Level pLevel, BlockPos pPos, Entity pEntity) {
        Firestone.lightEntityOnFire(pEntity, 5);
        super.entityInside(pState, pLevel, pPos, pEntity);
    }

    @Override
    public void appendHoverText(ItemStack pStack, @org.jetbrains.annotations.Nullable BlockGetter pLevel, List<Component> pTooltip, TooltipFlag pFlag) {
        pTooltip.add(Component.translatable("tootip.crystechmod.firestone_wall.tooltip"));
        super.appendHoverText(pStack, pLevel, pTooltip, pFlag);
    }


}
