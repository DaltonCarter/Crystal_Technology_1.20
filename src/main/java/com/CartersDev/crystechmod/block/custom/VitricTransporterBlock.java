package com.CartersDev.crystechmod.block.custom;

import com.CartersDev.crystechmod.block.ModBlocks;
import com.CartersDev.crystechmod.item.ModItems;
import com.CartersDev.crystechmod.util.ModBlockstateProperties;
import com.google.common.base.Predicates;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
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
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.pathfinder.PathComputationType;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.apache.logging.log4j.core.Core;
import org.jetbrains.annotations.Nullable;

import static com.CartersDev.crystechmod.block.custom.machines.TiberiumInfuserBlock.WORKING;

public class VitricTransporterBlock extends Block {
    public static final BooleanProperty CORE = ModBlockstateProperties.HAS_CORE_CRYSTAL;
    public static final DirectionProperty FACING = BlockStateProperties.HORIZONTAL_FACING;
    public static final EnumProperty<Direction.Axis> AXIS = BlockStateProperties.HORIZONTAL_AXIS;
    private static BlockPattern portalShape;


    public VitricTransporterBlock(Properties pProperties) {
        super(pProperties);
        this.registerDefaultState(this.defaultBlockState()
                .setValue(CORE, false)
                );
    }



    @Override
    public InteractionResult use(BlockState pState, Level pLevel, BlockPos pPos, Player pPlayer, InteractionHand pHand, BlockHitResult pHit) {

        boolean hasCore = pState.getValue(VitricTransporterBlock.CORE);

        if(pPlayer.getOffhandItem().isEmpty() && hasCore){

            pLevel.addFreshEntity(
                    new ItemEntity(
                            pLevel,pPos.getX() + 0.5, pPos.getY() + 0.5, pPos.getZ() + 0.5,
                            new ItemStack(ModItems.RED_CORE_CRYSTAL.get())));

            pLevel.setBlockAndUpdate(pPos, pState.setValue(CORE, false));


        }

        return super.use(pState, pLevel, pPos, pPlayer, pHand, pHit);
    }


    @Override
    public boolean onDestroyedByPlayer(BlockState state, Level level, BlockPos pos, Player player, boolean willHarvest, FluidState fluid) {
                if(state.getValue(CORE)){
                    level.addFreshEntity(
                            new ItemEntity(
                                    level,pos.getX() + 0.5, pos.getY() + 0.5, pos.getZ() + 0.5,
                                    new ItemStack(ModItems.RED_CORE_CRYSTAL.get())));

                }

        return super.onDestroyedByPlayer(state, level, pos, player, willHarvest, fluid);
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


        public static BlockPattern getOrCreatePortalShape () {
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
