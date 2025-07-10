package com.CartersDev.crystechmod.block.custom;

import com.CartersDev.crystechmod.block.entity.ModBlockEntities;

import com.CartersDev.crystechmod.block.entity.refinery.AlythumVitriciumRefineryBlockEntity;
import com.CartersDev.crystechmod.block.entity.refinery.CrystalCoreVitriciumRefineryBlockEntity;
import com.CartersDev.crystechmod.block.entity.refinery.VitricVitriciumRefineryBlockEntity;
import com.CartersDev.crystechmod.block.entity.refinery.VitriciumRefineryBlockEntity;
import com.CartersDev.crystechmod.util.ModBlockstateProperties;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.minecraftforge.network.NetworkHooks;
import org.jetbrains.annotations.Nullable;

public class VitriciumRefineryBlock extends BaseEntityBlock {
    public static final BooleanProperty WORKING = ModBlockstateProperties.WORKING;
    public static IntegerProperty MACHINE_CORE_LVL = ModBlockstateProperties.MACHINE_CORE_LVL;

    /* HORIZONTAL FACING AND VOXEL SHAPE */

    public static final DirectionProperty FACING = BlockStateProperties.HORIZONTAL_FACING;

    public VitriciumRefineryBlock(int machineCoreLvl, Properties pProperties) {super(pProperties);
        this.registerDefaultState(this.defaultBlockState().setValue(WORKING, false)
                .setValue(MACHINE_CORE_LVL, machineCoreLvl));}

    public static final VoxelShape SHAPE = Block.box(0, 0, 0, 16, 16, 16);

    public BlockState rotate(BlockState pState, Rotation pRot) {
        return pState.setValue(FACING, pRot.rotate(pState.getValue(FACING)));
    }

    public BlockState mirror(BlockState pState, Mirror pMirror) {
        return pState.rotate(pMirror.getRotation(pState.getValue(FACING)));
    }

    @Override
    public VoxelShape getShape(BlockState pState, BlockGetter pLevel, BlockPos pPos, CollisionContext pContext) {
        return SHAPE;
    }

    @Override
    public @Nullable BlockState getStateForPlacement(BlockPlaceContext pContext) {
        return this.defaultBlockState().setValue(FACING, pContext.getHorizontalDirection().getOpposite())
                .setValue(WORKING, false);
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> pBuilder) {
        pBuilder.add(FACING);
        pBuilder.add(WORKING);
        pBuilder.add(MACHINE_CORE_LVL);
    }


    /* BLOCK ENTITY LOGIC */

    @Override
    public RenderShape getRenderShape(BlockState pState) {
        return RenderShape.MODEL;
    }

    @Override
    public void onRemove(BlockState pState, Level pLevel, BlockPos pPos, BlockState pNewState, boolean pMovedByPiston) {

        if(pState.getBlock() != pNewState.getBlock()){
            BlockEntity blockEntity = pLevel.getBlockEntity(pPos);
            if(blockEntity instanceof VitriciumRefineryBlockEntity) {
                ((VitriciumRefineryBlockEntity) blockEntity).drops();
            } else if (blockEntity instanceof AlythumVitriciumRefineryBlockEntity) {
                ((AlythumVitriciumRefineryBlockEntity) blockEntity).drops();
            }else if (blockEntity instanceof VitricVitriciumRefineryBlockEntity) {
                ((VitricVitriciumRefineryBlockEntity) blockEntity).drops();
            }else if (blockEntity instanceof CrystalCoreVitriciumRefineryBlockEntity) {
                ((CrystalCoreVitriciumRefineryBlockEntity) blockEntity).drops();

            }
        }

        super.onRemove(pState, pLevel, pPos, pNewState, pMovedByPiston);
    }

    @Override
    public InteractionResult use(BlockState pState, Level pLevel, BlockPos pPos, Player pPlayer, InteractionHand pHand, BlockHitResult pHit) {
        if(!pLevel.isClientSide()) {
            BlockEntity entity = pLevel.getBlockEntity(pPos);
            if(entity instanceof VitriciumRefineryBlockEntity) {
                NetworkHooks.openScreen(((ServerPlayer) pPlayer), (VitriciumRefineryBlockEntity) entity, pPos);
            } else if (entity instanceof AlythumVitriciumRefineryBlockEntity) {
//                System.out.println("WHAT");
                NetworkHooks.openScreen(((ServerPlayer) pPlayer), (AlythumVitriciumRefineryBlockEntity) entity, pPos);
            } else if (entity instanceof VitricVitriciumRefineryBlockEntity) {
//                System.out.println("THE");
                NetworkHooks.openScreen(((ServerPlayer) pPlayer), (VitricVitriciumRefineryBlockEntity) entity, pPos);
            } else if (entity instanceof CrystalCoreVitriciumRefineryBlockEntity) {
//                System.out.println("HECK");
                NetworkHooks.openScreen(((ServerPlayer) pPlayer), (CrystalCoreVitriciumRefineryBlockEntity) entity, pPos);
            } else {
                throw new IllegalStateException("The Container Provider is AWOL!");
            }
        }
        return InteractionResult.sidedSuccess(pLevel.isClientSide());
    }

    @Override
    public @Nullable BlockEntity newBlockEntity(BlockPos pPos, BlockState pState) {
        int lvl = pState.getValue(MACHINE_CORE_LVL);
        return switch (lvl) {
            case 1 -> new VitriciumRefineryBlockEntity(pPos, pState);
            case 2 -> new AlythumVitriciumRefineryBlockEntity(pPos, pState);
            case 3 -> new VitricVitriciumRefineryBlockEntity(pPos, pState);
            case 4 -> new CrystalCoreVitriciumRefineryBlockEntity(pPos, pState);
            default -> throw new IllegalStateException("Unexpected value: " + lvl);
        };




    }

    @Override
    public @Nullable <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level pLevel, BlockState pState, BlockEntityType<T> pBlockEntityType) {
        if(pLevel.isClientSide()) {
            return null;
        }
        int lvl = pState.getValue(MACHINE_CORE_LVL);
        return switch (lvl){
            case 1 -> createTickerHelper(pBlockEntityType, ModBlockEntities.VITRICIUM_REFINERY_BE.get(),
                    (pLevel1, pPos, pState1, pBlockEntity) -> pBlockEntity.tick(pLevel1, pPos, pState1));

            default -> throw new IllegalStateException("Unexpected value: " + lvl);
        };
    }
}
