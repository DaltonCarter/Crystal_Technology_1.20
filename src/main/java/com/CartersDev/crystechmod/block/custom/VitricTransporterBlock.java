package com.CartersDev.crystechmod.block.custom;

import com.CartersDev.crystechmod.block.ModBlocks;
import com.CartersDev.crystechmod.util.ModBlockstateProperties;
import com.google.common.base.Predicates;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.pattern.BlockInWorld;
import net.minecraft.world.level.block.state.pattern.BlockPattern;
import net.minecraft.world.level.block.state.pattern.BlockPatternBuilder;
import net.minecraft.world.level.block.state.predicate.BlockStatePredicate;
import net.minecraft.world.level.block.state.properties.*;
import net.minecraft.world.level.pathfinder.PathComputationType;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.Nullable;

public class VitricTransporterBlock extends Block {
    public static final BooleanProperty CORE = ModBlockstateProperties.HAS_CORE_CRYSTAL;
    public static final DirectionProperty FACING = BlockStateProperties.HORIZONTAL_FACING;
    public static final EnumProperty<Direction.Axis> AXIS = BlockStateProperties.HORIZONTAL_AXIS;
    private static BlockPattern portalShape;


    public VitricTransporterBlock(Properties pProperties) {
        super(pProperties);
        this.registerDefaultState(this.defaultBlockState().setValue(CORE, false));
    }

    public static final VoxelShape SHAPE = Block.box(0, 0, 0, 16, 16, 16);



    public BlockState rotate(BlockState pState, Rotation pRotation) {
        return pState.setValue(FACING, pRotation.rotate(pState.getValue(FACING)));
    }


    public BlockState mirror(BlockState pState, Mirror pMirror) {
        return pState.rotate(pMirror.getRotation(pState.getValue(FACING)));
    }

    @Override
    public VoxelShape getShape(BlockState pState, BlockGetter pLevel, BlockPos pPos, CollisionContext pContext) {
        return SHAPE;
    }

    public boolean hasAnalogOutputSignal(BlockState pState) {
        return true;
    }


    public int getAnalogOutputSignal(BlockState pBlockState, Level pLevel, BlockPos pPos) {
        return pBlockState.getValue(CORE) ? 15 : 0;
    }

    @Override
    public @Nullable BlockState getStateForPlacement(BlockPlaceContext pContext) {
        return this.defaultBlockState().setValue(CORE, false).setValue(AXIS, pContext.getHorizontalDirection().getAxis())
                .setValue(FACING, pContext.getHorizontalDirection().getOpposite());
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> pBuilder) {
        pBuilder.add(FACING);
        pBuilder.add(CORE);
        pBuilder.add(AXIS);

    }


    public static BlockPattern getOrCreatePortalShape() {
        if (portalShape == null) {
            portalShape = BlockPatternBuilder.start().aisle("?vvv?", ">???<", ">???<", ">???<", "?^^^?")
                    .where('?', BlockInWorld.hasState(BlockStatePredicate.ANY))
                    .where('^', BlockInWorld.hasState(BlockStatePredicate.forBlock(ModBlocks.VITRIC_TRANSPORTER.get())
                            .where(CORE, Predicates.equalTo(true))))

                    .where('>', BlockInWorld.hasState(BlockStatePredicate.forBlock(ModBlocks.VITRIC_TRANSPORTER_SIDE1.get())
                            .where(CORE, Predicates.equalTo(true))))

                    .where('v', BlockInWorld.hasState(BlockStatePredicate.forBlock(ModBlocks.VITRIC_TRANSPORTER.get())
                            .where(CORE, Predicates.equalTo(true))))

                    .where('<', BlockInWorld.hasState(BlockStatePredicate.forBlock(ModBlocks.VITRIC_TRANSPORTER_SIDE2.get())
                            .where(CORE, Predicates.equalTo(true)))).build();
        }

        return portalShape;
    }



    public boolean isPathfindable(BlockState pState, BlockGetter pLevel, BlockPos pPos, PathComputationType pType) {
        return false;
    }
}
