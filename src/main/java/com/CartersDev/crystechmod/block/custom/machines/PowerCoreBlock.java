package com.CartersDev.crystechmod.block.custom.machines;

import com.CartersDev.crystechmod.block.entity.ModBlockEntities;
import com.CartersDev.crystechmod.block.entity.alloykiln.AlloyKilnBlockEntity;
import com.CartersDev.crystechmod.block.entity.fluidsilo.FluidSiloBlockEntity;
import com.CartersDev.crystechmod.block.entity.powercore.PowerCoreBlockEntity;
import com.CartersDev.crystechmod.util.ModBlockstateProperties;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
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

import java.text.NumberFormat;

public class PowerCoreBlock extends BaseEntityBlock {
    public static final DirectionProperty FACING = BlockStateProperties.HORIZONTAL_FACING;
    public static IntegerProperty MACHINE_CORE_LVL = ModBlockstateProperties.MACHINE_CORE_LVL;
    public static BooleanProperty HAS_CHARGE =  ModBlockstateProperties.HAS_CHARGE;

    public PowerCoreBlock(int machineCoreLvl, Properties pProperties) {
        super(pProperties);
        this.registerDefaultState(this.defaultBlockState()
                .setValue(MACHINE_CORE_LVL, machineCoreLvl).setValue(HAS_CHARGE, false));
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
        return this.defaultBlockState().setValue(FACING, pContext.getHorizontalDirection().getOpposite()).setValue(HAS_CHARGE, false);
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> pBuilder) {
        pBuilder.add(FACING);
        pBuilder.add(MACHINE_CORE_LVL);
        pBuilder.add(HAS_CHARGE);
    }



    //Entity Logic:
    @Override
    public RenderShape getRenderShape(BlockState pState) {
        return RenderShape.MODEL;
    }

    @Override
    public void onRemove(BlockState pState, Level pLevel, BlockPos pPos, BlockState pNewState, boolean pMovedByPiston) {

        if(pState.getBlock() != pNewState.getBlock()) {
            BlockEntity blockEntity = pLevel.getBlockEntity(pPos);

            if (!pLevel.isClientSide) {
                for (Direction direction : Direction.values()) {
                    BlockPos neighborPos = pPos.relative(direction);
                    pLevel.neighborChanged(neighborPos, pState.getBlock(), pPos);
                }
            }


            if(blockEntity instanceof PowerCoreBlockEntity) {
                ((PowerCoreBlockEntity) blockEntity).drops();
            }
            super.onRemove(pState, pLevel, pPos, pNewState, pMovedByPiston);
        }else {
            super.onRemove(pState, pLevel, pPos, pNewState, pMovedByPiston);
        }


    }

    @Override
    public InteractionResult use(BlockState pState, Level pLevel, BlockPos pPos, Player pPlayer, InteractionHand pHand, BlockHitResult pHit) {
        if (!pLevel.isClientSide()) {
            BlockEntity entity = pLevel.getBlockEntity(pPos);
            if(entity instanceof MenuProvider menuProvider) {
                NetworkHooks.openScreen(((ServerPlayer) pPlayer), menuProvider,
                        buf -> {
                            buf.writeBlockPos(pPos);
                            buf.writeInt(pState.getValue(MACHINE_CORE_LVL));
                        }
                );
                return InteractionResult.CONSUME;
            }else {
                throw new IllegalStateException("The Container Provider is AWOL!");
            }
        }
        return InteractionResult.CONSUME;
    }

    @Override
    public @Nullable BlockEntity newBlockEntity(BlockPos pPos, BlockState pState) {
        return new PowerCoreBlockEntity(pPos, pState);
    }

    @Override
    public @Nullable <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level pLevel, BlockState pState, BlockEntityType<T> pBlockEntityType) {
        if(pLevel.isClientSide()){
            return null;
        }

        return createTickerHelper(pBlockEntityType, ModBlockEntities.POWER_CORE_BE.get(),
                ((pLevel1, pPos, pState1, pBlockEntity) -> pBlockEntity.tick(pLevel1, pPos, pState1)));
    }

    @Override
    public void playerDestroy(Level pLevel, Player pPlayer, BlockPos pPos, BlockState pState, @Nullable BlockEntity pBlockEntity, ItemStack pTool) {
        if (pBlockEntity instanceof PowerCoreBlockEntity coreBe && !pLevel.isClientSide) {
            ItemStack dropItem = new ItemStack(this.asItem());


            int energyStored = coreBe.getEnergyStorage().getEnergyStored();

            boolean inventoryHasItems = false;
            if (coreBe.getItemHandler() != null) {
                for (int i = 0; i < coreBe.getItemHandler().getSlots(); i++) {
                    if (!coreBe.getItemHandler().getStackInSlot(i).isEmpty()) {
                        inventoryHasItems = true;
                        break;
                    }
                }
            }

            if (energyStored > 0 || inventoryHasItems) {
                net.minecraft.nbt.CompoundTag serverNbt = coreBe.saveWithFullMetadata();
                dropItem.getOrCreateTag().put("BlockEntityTag", serverNbt);
            }

            ItemEntity dropEntity = new net.minecraft.world.entity.item.ItemEntity(
                    pLevel, pPos.getX() + 0.5, pPos.getY() + 0.5, pPos.getZ() + 0.5, dropItem
            );
            pLevel.addFreshEntity(dropEntity);
            return;
        }
        super.playerDestroy(pLevel, pPlayer, pPos, pState, pBlockEntity, pTool);
    }

    @Override
    public void appendHoverText(ItemStack pStack, @Nullable BlockGetter pLevel,
                                java.util.List<Component> pTooltip, TooltipFlag pFlag) {

        if (pStack.hasTag() && pStack.getTag().contains("BlockEntityTag")) {
            CompoundTag blockEntityTag = pStack.getTag().getCompound("BlockEntityTag");

            if (blockEntityTag.contains("energy")) {
                int savedEnergy = blockEntityTag.getInt("energy");

                if (savedEnergy > 0) {
                    NumberFormat formatter = NumberFormat.getInstance();

                    pTooltip.add(Component.literal("§7Contents: §a" + formatter.format(savedEnergy) + " FE"));
                    return;
                }
            }
        }
        pTooltip.add(Component.literal("§7Contents: §80 FE"));
        super.appendHoverText(pStack, pLevel, pTooltip, pFlag);
    }

}
