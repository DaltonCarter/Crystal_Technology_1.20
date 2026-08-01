package com.CartersDev.crystechmod.block.custom.machines;

import com.CartersDev.crystechmod.block.entity.ModBlockEntities;

import com.CartersDev.crystechmod.block.entity.refinery.AlythumVitriciumRefineryBlockEntity;
import com.CartersDev.crystechmod.block.entity.refinery.CrystalCoreVitriciumRefineryBlockEntity;
import com.CartersDev.crystechmod.block.entity.refinery.VitricVitriciumRefineryBlockEntity;
import com.CartersDev.crystechmod.block.entity.refinery.VitriciumRefineryBlockEntity;
import com.CartersDev.crystechmod.util.ModBlockstateProperties;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
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

    public void animateTick(BlockState pState, Level pLevel, BlockPos pPos, RandomSource pRandom) {
        if (pState.getValue(WORKING)) {
            double d0 = (double)pPos.getX() + 0.5D;
            double d1 = (double)pPos.getY();
            double d2 = (double)pPos.getZ() + 0.5D;
            if (pRandom.nextDouble() < 0.05D) {
                pLevel.playLocalSound(d0, d1, d2, SoundEvents.LAVA_AMBIENT, SoundSource.BLOCKS, 1.0F, 1.0F, false);
            }

            Direction direction = pState.getValue(FACING);
            Direction.Axis direction$axis = direction.getAxis();
            double d3 = 0.52D;
            double d4 = pRandom.nextDouble() * 0.6D - 0.3D;
            double d5 = direction$axis == Direction.Axis.X ? (double)direction.getStepX() * 0.52D : d4;
            double d6 = pRandom.nextDouble() * 6.0D / 16.0D;
            double d7 = direction$axis == Direction.Axis.Z ? (double)direction.getStepZ() * 0.52D : d4;

            pLevel.addParticle(ParticleTypes.SMOKE,  pPos.getX() + pRandom.nextDouble(),
                    pPos.getY() + 1.5D, pPos.getZ() + pRandom.nextDouble(),
                    0d, 0.05d, 0d);

            pLevel.addParticle(ParticleTypes.FLAME,  pPos.getX() + pRandom.nextDouble(),
                    pPos.getY() + 1.0D, pPos.getZ() + pRandom.nextDouble(),
                    0d, 0.05d, 0d);

        }
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

            if (!pLevel.isClientSide()) {
                for (Direction direction : Direction.values()) {
                    BlockPos neighborPos = pPos.relative(direction);
                    pLevel.neighborChanged(neighborPos, this, pPos);
                }

            }

            if(blockEntity instanceof VitriciumRefineryBlockEntity) {
                ((VitriciumRefineryBlockEntity) blockEntity).drops();
            } else if (blockEntity instanceof AlythumVitriciumRefineryBlockEntity) {
                ((AlythumVitriciumRefineryBlockEntity) blockEntity).drops();
            }else if (blockEntity instanceof VitricVitriciumRefineryBlockEntity) {
                ((VitricVitriciumRefineryBlockEntity) blockEntity).drops();
            }else if (blockEntity instanceof CrystalCoreVitriciumRefineryBlockEntity) {
                ((CrystalCoreVitriciumRefineryBlockEntity) blockEntity).drops();

            }
            super.onRemove(pState, pLevel, pPos, pNewState, pMovedByPiston);
        }else {
            super.onRemove(pState, pLevel, pPos, pNewState, pMovedByPiston);
        }
    }

    @Override
    public InteractionResult use(BlockState pState, Level pLevel, BlockPos pPos, Player pPlayer, InteractionHand pHand, BlockHitResult pHit) {
        if(!pLevel.isClientSide()) {
            BlockEntity entity = pLevel.getBlockEntity(pPos);
            if(entity instanceof VitriciumRefineryBlockEntity) {
                NetworkHooks.openScreen(((ServerPlayer) pPlayer), (VitriciumRefineryBlockEntity) entity, pPos);
                return InteractionResult.CONSUME;
            } else if (entity instanceof AlythumVitriciumRefineryBlockEntity) {
//                System.out.println("WHAT");
                NetworkHooks.openScreen(((ServerPlayer) pPlayer), (AlythumVitriciumRefineryBlockEntity) entity, pPos);
                return InteractionResult.CONSUME;
            } else if (entity instanceof VitricVitriciumRefineryBlockEntity) {
//                System.out.println("THE");
                NetworkHooks.openScreen(((ServerPlayer) pPlayer), (VitricVitriciumRefineryBlockEntity) entity, pPos);
                return InteractionResult.CONSUME;
            } else if (entity instanceof CrystalCoreVitriciumRefineryBlockEntity) {
//                System.out.println("HECK");
                NetworkHooks.openScreen(((ServerPlayer) pPlayer), (CrystalCoreVitriciumRefineryBlockEntity) entity, pPos);
                return InteractionResult.CONSUME;
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
            case 2 -> createTickerHelper(pBlockEntityType, ModBlockEntities.ALYTHUM_VITRICIUM_REFINERY_BE.get(),
                    (pLevel1, pPos, pState1, pBlockEntity) -> pBlockEntity.tick(pLevel1, pPos, pState1));
            case 3 -> createTickerHelper(pBlockEntityType, ModBlockEntities.VITRIC_VITRICIUM_REFINERY_BE.get(),
                    (pLevel1, pPos, pState1, pBlockEntity) -> pBlockEntity.tick(pLevel1, pPos, pState1));
            case 4 -> createTickerHelper(pBlockEntityType, ModBlockEntities.CRYSTAL_CORE_VITRICIUM_REFINERY_BE.get(),
                    (pLevel1, pPos, pState1, pBlockEntity) -> pBlockEntity.tick(pLevel1, pPos, pState1));

            default -> throw new IllegalStateException("Unexpected value: " + lvl);
        };
    }
}
