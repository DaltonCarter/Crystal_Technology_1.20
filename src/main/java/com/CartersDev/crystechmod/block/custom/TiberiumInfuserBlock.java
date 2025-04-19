package com.CartersDev.crystechmod.block.custom;

import com.CartersDev.crystechmod.block.entity.*;
import com.CartersDev.crystechmod.block.entity.infuser.AlythumTiberiumInfuserBlockEntity;
import com.CartersDev.crystechmod.block.entity.infuser.CrystalCoreTiberiumInfuserBlockEntity;
import com.CartersDev.crystechmod.block.entity.infuser.TiberiumInfuserBlockEntity;
import com.CartersDev.crystechmod.block.entity.infuser.VitricTiberiumInfuserBlockEntity;
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

public class TiberiumInfuserBlock extends BaseEntityBlock {
    public static final BooleanProperty WORKING = ModBlockstateProperties.WORKING;
    public static IntegerProperty MACHINE_CORE_LVL = ModBlockstateProperties.MACHINE_CORE_LVL;

    /* HORIZONTAL FACING AND VOXEL SHAPE */

    public static final DirectionProperty FACING = BlockStateProperties.HORIZONTAL_FACING;

    public TiberiumInfuserBlock(int machineCoreLvl, Properties pProperties) {super(pProperties);
        this.registerDefaultState(this.defaultBlockState().setValue(WORKING, false)
                .setValue(MACHINE_CORE_LVL, machineCoreLvl));}

    public static final VoxelShape SHAPE = Block.box(0, 0, 0, 16, 12, 16);

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
            if(blockEntity instanceof TiberiumInfuserBlockEntity) {
                ((TiberiumInfuserBlockEntity) blockEntity).drops();
            } else if (blockEntity instanceof AlythumTiberiumInfuserBlockEntity) {
                ((AlythumTiberiumInfuserBlockEntity) blockEntity).drops();
            }else if (blockEntity instanceof VitricTiberiumInfuserBlockEntity) {
                ((VitricTiberiumInfuserBlockEntity) blockEntity).drops();
            }else if (blockEntity instanceof CrystalCoreTiberiumInfuserBlockEntity) {
                ((CrystalCoreTiberiumInfuserBlockEntity) blockEntity).drops();

            }
        }

        super.onRemove(pState, pLevel, pPos, pNewState, pMovedByPiston);
    }

    @Override
    public InteractionResult use(BlockState pState, Level pLevel, BlockPos pPos, Player pPlayer, InteractionHand pHand, BlockHitResult pHit) {
        if(!pLevel.isClientSide()) {
            BlockEntity entity = pLevel.getBlockEntity(pPos);
            if(entity instanceof TiberiumInfuserBlockEntity) {
                NetworkHooks.openScreen(((ServerPlayer) pPlayer), (TiberiumInfuserBlockEntity) entity, pPos);
            } else if (entity instanceof AlythumTiberiumInfuserBlockEntity) {
//                System.out.println("WHAT");
                NetworkHooks.openScreen(((ServerPlayer) pPlayer), (AlythumTiberiumInfuserBlockEntity) entity, pPos);
            } else if (entity instanceof VitricTiberiumInfuserBlockEntity) {
//                System.out.println("THE");
                NetworkHooks.openScreen(((ServerPlayer) pPlayer), (VitricTiberiumInfuserBlockEntity) entity, pPos);
            } else if (entity instanceof CrystalCoreTiberiumInfuserBlockEntity) {
//                System.out.println("HECK");
                NetworkHooks.openScreen(((ServerPlayer) pPlayer), (CrystalCoreTiberiumInfuserBlockEntity) entity, pPos);
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
            case 1 -> new TiberiumInfuserBlockEntity(pPos, pState);
            case 2 -> new AlythumTiberiumInfuserBlockEntity(pPos, pState);
            case 3 -> new VitricTiberiumInfuserBlockEntity(pPos, pState);
            case 4 -> new CrystalCoreTiberiumInfuserBlockEntity(pPos, pState);
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
            case 1 -> createTickerHelper(pBlockEntityType, ModBlockEntities.TIBERIUM_INFUSER_BE.get(),
                    (pLevel1, pPos, pState1, pBlockEntity) -> pBlockEntity.tick(pLevel1, pPos, pState1));
            case 2 -> createTickerHelper(pBlockEntityType, ModBlockEntities.ALYTHUM_TIBERIUM_INFUSER_BE.get(),
                    (pLevel1, pPos, pState1, pBlockEntity) -> pBlockEntity.tick(pLevel1, pPos, pState1));
            case 3 -> createTickerHelper(pBlockEntityType, ModBlockEntities.VITRIC_TIBERIUM_INFUSER_BE.get(),
                    (pLevel1, pPos, pState1, pBlockEntity) -> pBlockEntity.tick(pLevel1, pPos, pState1));
            case 4 ->createTickerHelper(pBlockEntityType, ModBlockEntities.CRYSTAL_CORE_TIBERIUM_INFUSER_BE.get(),
                    (pLevel1, pPos, pState1, pBlockEntity) -> pBlockEntity.tick(pLevel1, pPos, pState1));
            default -> throw new IllegalStateException("Unexpected value: " + lvl);
        };
    }
}
