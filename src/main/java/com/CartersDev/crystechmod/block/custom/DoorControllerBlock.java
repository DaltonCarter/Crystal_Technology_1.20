package com.CartersDev.crystechmod.block.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.LeverBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.AttachFace;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;



public class DoorControllerBlock extends LeverBlock {

    protected static final VoxelShape CEILING_AABB_X = Block.box(0.25, 1, 0.3125, 0.75, 1.0625, 0.6875);
    protected static final VoxelShape CEILING_AABB_Z = Block.box(0.3125, 1, 0.25, 0.6875, 1.0625, 0.75);
    protected static final VoxelShape FLOOR_AABB_X = Block.box(0.25, 0, 0.3125, 0.75, 0.0625, 0.6875);
    protected static final VoxelShape FLOOR_AABB_Z = Block.box(0.3125, 0, 0.25, 0.6875, 0.0625, 0.75);
    protected static final VoxelShape NORTH_AABB = Block.box(0.3125, 0.25, 0, 0.6875, 0.75, 0.0625);
    protected static final VoxelShape SOUTH_AABB = Block.box(0.3125, 0.25, 0.9375, 0.6875, 0.75, 1);
    protected static final VoxelShape WEST_AABB = Block.box(0, 0.25, 0.3125, 0.0625, 0.75, 0.6875);
    protected static final VoxelShape EAST_AABB = Block.box(0.9375, 0.25, 0.3125, 1, 0.75, 0.6875);


    public DoorControllerBlock(Properties pProperties) {
        super(pProperties);
        this.registerDefaultState(this.stateDefinition.any().setValue(FACING, Direction.NORTH).setValue(POWERED, Boolean.valueOf(false)).setValue(FACE, AttachFace.WALL));
    }

    public VoxelShape getShape(BlockState pState, BlockGetter pLevel, BlockPos pPos, CollisionContext pContext) {
        switch ((AttachFace)pState.getValue(FACE)) {
            case FLOOR:
                switch (pState.getValue(FACING).getAxis()) {
                    case X:
                        return FLOOR_AABB_X;
                    case Z:
                    default:
                        return FLOOR_AABB_Z;
                }
            case WALL:
                switch ((Direction)pState.getValue(FACING)) {
                    case EAST:
                        return EAST_AABB;
                    case WEST:
                        return WEST_AABB;
                    case SOUTH:
                        return SOUTH_AABB;
                    case NORTH:
                    default:
                        return NORTH_AABB;
                }
            case CEILING:
            default:
                switch (pState.getValue(FACING).getAxis()) {
                    case X:
                        return CEILING_AABB_X;
                    case Z:
                    default:
                        return CEILING_AABB_Z;
                }
        }
    }

    public InteractionResult use(BlockState pState, Level pLevel, BlockPos pPos, Player pPlayer, InteractionHand pHand, BlockHitResult pHit) {
        if (pLevel.isClientSide) {
            BlockState blockstate1 = pState.cycle(POWERED);
            if (blockstate1.getValue(POWERED)) {

            }

            return InteractionResult.SUCCESS;
        } else {
            BlockState blockstate = this.pull(pState, pLevel, pPos);
            float f = blockstate.getValue(POWERED) ? 0.6F : 0.5F;
            pLevel.playSound((Player)null, pPos, SoundEvents.LEVER_CLICK, SoundSource.BLOCKS, 0.3F, f);
            pLevel.gameEvent(pPlayer, blockstate.getValue(POWERED) ? GameEvent.BLOCK_ACTIVATE : GameEvent.BLOCK_DEACTIVATE, pPos);
            return InteractionResult.CONSUME;
        }
    }

    public BlockState pull(BlockState pState, Level pLevel, BlockPos pPos) {
        pState = pState.cycle(POWERED);
        pLevel.setBlock(pPos, pState, 3);
        this.updateNeighbours(pState, pLevel, pPos);
        return pState;
    }

    public void onRemove(BlockState pState, Level pLevel, BlockPos pPos, BlockState pNewState, boolean pIsMoving) {
        if (!pIsMoving && !pState.is(pNewState.getBlock())) {
            if (pState.getValue(POWERED)) {
                this.updateNeighbours(pState, pLevel, pPos);
            }

            super.onRemove(pState, pLevel, pPos, pNewState, pIsMoving);
        }
    }

    @Override
    public int getSignal(BlockState pBlockState, BlockGetter pBlockAccess, BlockPos pPos, Direction pSide) {
        return pBlockState.getValue(POWERED) ? 15 : 0;
    }

    @Override
    public int getDirectSignal(BlockState pBlockState, BlockGetter pBlockAccess, BlockPos pPos, Direction pSide) {
        return pBlockState.getValue(POWERED) && getConnectedDirection(pBlockState) == pSide ? 15 : 0;
    }

    @Override
    public boolean isSignalSource(BlockState pState) {
        return true;
    }


    private void updateNeighbours(BlockState pState, Level pLevel, BlockPos pPos) {
        pLevel.updateNeighborsAt(pPos, this);
        pLevel.updateNeighborsAt(pPos.relative(getConnectedDirection(pState).getOpposite()), this);
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> pBuilder) {
        pBuilder.add(FACE, FACING, POWERED);
    }

}
