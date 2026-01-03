package com.CartersDev.crystechmod.block.custom.machines.portal;

import com.CartersDev.crystechmod.block.custom.VitricTransporterBlock;
import com.CartersDev.crystechmod.block.entity.portal.VitricPortalBlockEntity;
import com.CartersDev.crystechmod.sound.ModSounds;
import com.CartersDev.crystechmod.worldgen.dimension.ModDimensions;
import com.CartersDev.crystechmod.worldgen.portal.Teleporter.VitricTeleporter;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.resources.ResourceKey;

import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.BaseEntityBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.phys.shapes.CollisionContext;

import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.Nullable;

public class VitricPortalBlock extends BaseEntityBlock {

    protected static final VoxelShape SHAPE = Block.box(0.0D, 6.0D, 0.0D, 14.0D, 16.0D, 14.0D);

    public VitricPortalBlock(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public @Nullable BlockEntity newBlockEntity(BlockPos pPos, BlockState pState) {
        return new VitricPortalBlockEntity(pPos, pState);
    }

    public VoxelShape getShape(BlockState pState, BlockGetter pLevel, BlockPos pPos, CollisionContext pContext) {
        return SHAPE;
    }

    public void entityInside(BlockState pState, Level pLevel, BlockPos pPos, Entity pEntity) {
        if (pEntity.canChangeDimensions() && !pEntity.level().isClientSide()) {
            if (pEntity.isOnPortalCooldown()) {
                pEntity.setPortalCooldown();
                pEntity.getPersistentData().putInt("VitricPortalTime", 0);
                return;
            }

            int time = pEntity.getPersistentData().getInt("VitricPortalTime");
            if (time >= 300) {
                pEntity.getPersistentData().putInt("VitricPortalTime", 0);
                pEntity.setPortalCooldown();
                ResourceKey<Level> destination = pLevel.dimension() != ModDimensions.VITRIC_EXPANSE_LEVEL_KEY
                        ? ModDimensions.VITRIC_EXPANSE_LEVEL_KEY : Level.OVERWORLD;
                teleportToDimension(pEntity, pPos, destination);
            } else {
                pEntity.getPersistentData().putInt("VitricPortalTime", time + 1);
            }
        } else {
            pEntity.getPersistentData().putInt("VitricPortalTime", 0);
        }

    }

    private void teleportToDimension(Entity entity, BlockPos pos, ResourceKey<Level> destinationType) {
        entity.changeDimension(entity.getServer().getLevel(destinationType), new VitricTeleporter(entity.getServer().getLevel(destinationType), pos));
    }

    public void animateTick(BlockState pState, Level pLevel, BlockPos pPos, RandomSource pRandom) {
        if (pRandom.nextInt(100) == 0) {
            pLevel.playLocalSound((double)pPos.getX() + 0.5D, (double)pPos.getY() + 0.5D, (double)pPos.getZ() + 0.5D,
                    ModSounds.PORTAL.get(), SoundSource.BLOCKS, 0.2F, pRandom.nextFloat() * 0.4F + 0.8F, false);
        }

        for(int i = 0; i < 4; ++i) {
            double d0 = (double)pPos.getX() + pRandom.nextDouble();
            double d1 = (double)pPos.getY() + pRandom.nextDouble();
            double d2 = (double)pPos.getZ() + pRandom.nextDouble();
            double d3 = ((double)pRandom.nextFloat() - 0.5D) * 0.5D;
            double d4 = ((double)pRandom.nextFloat() - 0.5D) * 0.5D;
            double d5 = ((double)pRandom.nextFloat() - 0.5D) * 0.5D;
            int j = pRandom.nextInt(2) * 2 - 1;
            if (!pLevel.getBlockState(pPos.west()).is(this) && !pLevel.getBlockState(pPos.east()).is(this)) {
                d0 = (double)pPos.getX() + 0.5D + 0.25D * (double)j;
                d3 = (double)(pRandom.nextFloat() * 2.0F * (float)j);
            } else {
                d2 = (double)pPos.getZ() + 0.5D + 0.25D * (double)j;
                d5 = (double)(pRandom.nextFloat() * 2.0F * (float)j);
            }

            pLevel.addParticle(ParticleTypes.PORTAL, d0, d1, d2, d3, d4, d5);
        }

    }


    public ItemStack getCloneItemStack(BlockGetter pLevel, BlockPos pPos, BlockState pState) {
        return ItemStack.EMPTY;
    }

    public boolean canBeReplaced(BlockState pState, Fluid pFluid) {
        return false;
    }
}
