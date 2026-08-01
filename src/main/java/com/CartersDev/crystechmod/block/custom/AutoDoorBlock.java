package com.CartersDev.crystechmod.block.custom;

import com.CartersDev.crystechmod.sound.ModSounds;
import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.DoorBlock;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

import javax.annotation.Nullable;

public class AutoDoorBlock extends DoorBlock {
    protected static final VoxelShape NORTH_AABB = Block.box(0.0D, 0.0D, 7.0D, 16.0D, 16.0D, 9.0D);
    protected static final VoxelShape SOUTH_AABB = Block.box(0.0D, 0.0D, 7.0D, 16.0D, 16.0D, 9.0D);
    protected static final VoxelShape WEST_AABB   = Block.box(7.0D, 0.0D, 0.0D, 9.0D, 16.0D, 16.0D);
    protected static final VoxelShape EAST_AABB   = Block.box(7.0D, 0.0D, 0.0D, 9.0D, 16.0D, 16.0D);

    public AutoDoorBlock(Properties pProperties, BlockSetType pType) {
        super(pProperties, pType);
    }

    public VoxelShape getShape(BlockState pState, BlockGetter pLevel, BlockPos pPos, CollisionContext pContext) {

        return switch (pState.getValue(FACING)) {
            case SOUTH -> SOUTH_AABB;
            case WEST -> WEST_AABB;
            case EAST -> EAST_AABB;
            default -> NORTH_AABB;
        };
    }

    @Override
    public VoxelShape getCollisionShape(BlockState pState, BlockGetter pLevel, BlockPos pPos, CollisionContext pContext) {
        if (!pState.getValue(OPEN)) {
            return switch (pState.getValue(FACING)) {
                case SOUTH -> SOUTH_AABB;
                case WEST -> WEST_AABB;
                case EAST -> EAST_AABB;
                default -> NORTH_AABB;
            };
        }

        return Shapes.empty();
    }


    @Override
    public RenderShape getRenderShape(BlockState pState) {
        return RenderShape.MODEL;
    }
}
