package com.CartersDev.crystechmod.block.custom;

import com.CartersDev.crystechmod.block.entity.ModBlockEntities;
import com.CartersDev.crystechmod.block.entity.poweredkiln.AlythumKilnBlockEntity;
import com.CartersDev.crystechmod.block.entity.poweredkiln.CrystalCoreKilnBlockEntity;
import com.CartersDev.crystechmod.block.entity.poweredkiln.PoweredKilnBlockEntity;
import com.CartersDev.crystechmod.block.entity.poweredkiln.VitricKilnBlockEntity;
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

public class PoweredKilnBlock extends BaseEntityBlock {
    public static final BooleanProperty WORKING = ModBlockstateProperties.WORKING;
    public static IntegerProperty MACHINE_CORE_LVL = ModBlockstateProperties.MACHINE_CORE_LVL;
    public static final DirectionProperty FACING = BlockStateProperties.HORIZONTAL_FACING;

    public PoweredKilnBlock(int machineCoreLvl, Properties pProperties) {
        super(pProperties);
        this.registerDefaultState(this.defaultBlockState().setValue(WORKING, false)
                .setValue(MACHINE_CORE_LVL, machineCoreLvl));
    }

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


//    //Block Entity Logic


    @Override
    public RenderShape getRenderShape(BlockState pState) {
        return RenderShape.MODEL;
    }

    @Override
    public void onRemove(BlockState pState, Level pLevel, BlockPos pPos, BlockState pNewState, boolean pMovedByPiston) {
        if(pState.getBlock() != pNewState.getBlock()) {
            BlockEntity blockEntity = pLevel.getBlockEntity(pPos);
            if(blockEntity instanceof PoweredKilnBlockEntity) {
                ((PoweredKilnBlockEntity) blockEntity).drops();
            } else if (blockEntity instanceof AlythumKilnBlockEntity) {
                ((AlythumKilnBlockEntity) blockEntity).drops();
            }else if (blockEntity instanceof VitricKilnBlockEntity) {
                ((VitricKilnBlockEntity) blockEntity).drops();
            }else if (blockEntity instanceof CrystalCoreKilnBlockEntity) {
                ((CrystalCoreKilnBlockEntity) blockEntity).drops();
            }
        }
        super.onRemove(pState, pLevel, pPos, pNewState, pMovedByPiston);
    }

    @Override
    public InteractionResult use(BlockState pState, Level pLevel, BlockPos pPos, Player pPlayer, InteractionHand pHand, BlockHitResult pHit) {

        if(!pLevel.isClientSide()) {
            BlockEntity entity = pLevel.getBlockEntity(pPos);
            if(entity instanceof PoweredKilnBlockEntity) {
                NetworkHooks.openScreen(((ServerPlayer) pPlayer), (PoweredKilnBlockEntity) entity, pPos);
            } else if (entity instanceof AlythumKilnBlockEntity) {
                NetworkHooks.openScreen(((ServerPlayer) pPlayer), (AlythumKilnBlockEntity) entity, pPos);
            } else if (entity instanceof VitricKilnBlockEntity) {
                NetworkHooks.openScreen(((ServerPlayer) pPlayer), (VitricKilnBlockEntity) entity, pPos);
            } else if (entity instanceof CrystalCoreKilnBlockEntity) {
                NetworkHooks.openScreen(((ServerPlayer) pPlayer), (CrystalCoreKilnBlockEntity) entity, pPos);
            } else {
                throw new IllegalStateException("The Container Provider is AWOL!");
            }
        }

        return super.use(pState, pLevel, pPos, pPlayer, pHand, pHit);
    }




    @Override
    public @Nullable BlockEntity newBlockEntity(BlockPos pPos, BlockState pState) {
         int lvl = pState.getValue(MACHINE_CORE_LVL);
        return switch (lvl) {
            case 1 -> new PoweredKilnBlockEntity(pPos, pState);
            case 2 -> new AlythumKilnBlockEntity(pPos, pState);
            case 3 -> new VitricKilnBlockEntity(pPos, pState);
            case 4 -> new CrystalCoreKilnBlockEntity(pPos, pState);
            default -> throw new IllegalStateException("Unexpected value: " + lvl);
        };
    }

    @Override
    public @Nullable <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level pLevel, BlockState pState, BlockEntityType<T> pBlockEntityType) {
        if(pLevel.isClientSide()){
            return null;
        }
        int lvl = pState.getValue(MACHINE_CORE_LVL);
        return switch (lvl){
            case 1 -> createTickerHelper(pBlockEntityType, ModBlockEntities.POWERED_KILN_BE.get(),
                    ((pLevel1, pPos, pState1, pBlockEntity) -> pBlockEntity.tick(pLevel1, pPos, pState1)));
            case 2 -> createTickerHelper(pBlockEntityType, ModBlockEntities.ALYTHUM_KILN_BE.get(),
                    (pLevel1, pPos, pState1, pBlockEntity) -> pBlockEntity.tick(pLevel1, pPos, pState1));
            case 3 -> createTickerHelper(pBlockEntityType, ModBlockEntities.VITRIC_KILN_BE.get(),
                    (pLevel1, pPos, pState1, pBlockEntity) -> pBlockEntity.tick(pLevel1, pPos, pState1));
            case 4 ->createTickerHelper(pBlockEntityType, ModBlockEntities.CRYSTAL_CORE_KILN_BE.get(),
                    (pLevel1, pPos, pState1, pBlockEntity) -> pBlockEntity.tick(pLevel1, pPos, pState1));
            default -> throw new IllegalStateException("Unexpected value: " + lvl);
        };

    }
}
