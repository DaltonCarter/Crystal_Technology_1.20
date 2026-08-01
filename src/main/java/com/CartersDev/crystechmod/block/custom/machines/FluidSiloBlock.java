package com.CartersDev.crystechmod.block.custom.machines;

import com.CartersDev.crystechmod.block.entity.ModBlockEntities;
import com.CartersDev.crystechmod.block.entity.alloykiln.AlloyKilnBlockEntity;
import com.CartersDev.crystechmod.block.entity.alloykiln.AlythumAlloyKilnBlockEntity;
import com.CartersDev.crystechmod.block.entity.alloykiln.CrystalCoreAlloyKilnBlockEntity;
import com.CartersDev.crystechmod.block.entity.alloykiln.VitricAlloyKilnBlockEntity;
import com.CartersDev.crystechmod.block.entity.fluidsilo.FluidSiloBlockEntity;
import com.CartersDev.crystechmod.block.entity.infuser.TiberiumInfuserBlockEntity;
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
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.minecraftforge.common.capabilities.ForgeCapabilities;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fluids.FluidUtil;
import net.minecraftforge.fluids.capability.templates.FluidTank;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.network.NetworkHooks;
import org.jetbrains.annotations.Nullable;

public class FluidSiloBlock extends BaseEntityBlock {
    public static final DirectionProperty FACING = BlockStateProperties.HORIZONTAL_FACING;
    public static IntegerProperty MACHINE_CORE_LVL = ModBlockstateProperties.MACHINE_CORE_LVL;

    public FluidSiloBlock(int machineCoreLvl, Properties pProperties) {
        super(pProperties);
        this.registerDefaultState(this.defaultBlockState()
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
        return this.defaultBlockState().setValue(FACING, pContext.getHorizontalDirection().getOpposite());
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> pBuilder) {
        pBuilder.add(FACING);
        pBuilder.add(MACHINE_CORE_LVL);
    }



    //Entity Logic

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

            if(blockEntity instanceof FluidSiloBlockEntity) {
                ((FluidSiloBlockEntity) blockEntity).drops();
            }
            super.onRemove(pState, pLevel, pPos, pNewState, pMovedByPiston);
        }else {
            super.onRemove(pState, pLevel, pPos, pNewState, pMovedByPiston);
        }

    }

    @Override
    public InteractionResult use(BlockState pState, Level pLevel, BlockPos pPos, Player pPlayer, InteractionHand pHand, BlockHitResult pHit) {

            BlockEntity entity = pLevel.getBlockEntity(pPos);
            if(entity instanceof FluidSiloBlockEntity) {

                boolean interaction = FluidUtil.interactWithFluidHandler(pPlayer, pHand,
                        entity.getCapability(ForgeCapabilities.FLUID_HANDLER, null).orElse(null));

                if (interaction) {
                    return InteractionResult.sidedSuccess(pLevel.isClientSide());
                }

                if (!pLevel.isClientSide()) {
                    if(entity instanceof MenuProvider menuProvider) {
                        NetworkHooks.openScreen(((ServerPlayer) pPlayer), menuProvider,
                                buf -> {
                            buf.writeBlockPos(pPos);
                            buf.writeInt(pState.getValue(MACHINE_CORE_LVL));
                                }
                                );
                    }else {
                        throw new IllegalStateException("The Container Provider is AWOL!");
                    }


                }
                return  InteractionResult.sidedSuccess(pLevel.isClientSide());
            }


        return InteractionResult.PASS;
    }

    @Override
    public @Nullable BlockEntity newBlockEntity(BlockPos pPos, BlockState pState) {
        return new FluidSiloBlockEntity(pPos, pState);
    }

    @Override
    public @Nullable <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level pLevel, BlockState pState, BlockEntityType<T> pBlockEntityType) {
        if(pLevel.isClientSide()){
            return null;
        }

       return createTickerHelper(pBlockEntityType, ModBlockEntities.FLUID_SILO_BE.get(),
                ((pLevel1, pPos, pState1, pBlockEntity) -> pBlockEntity.tick(pLevel1, pPos, pState1)));
    }

    @Override
    public void playerDestroy(Level pLevel, Player pPlayer, BlockPos pPos, BlockState pState, @Nullable BlockEntity pBlockEntity, ItemStack pTool) {
        if (pBlockEntity instanceof FluidSiloBlockEntity siloBe && !pLevel.isClientSide) {
            ItemStack dropItem = new ItemStack(this.asItem());

            FluidStack fluidInTank = siloBe.getFluid();

            boolean tankHasFluid = !fluidInTank.isEmpty() && fluidInTank.getAmount() > 0;

            boolean inventoryHasItems = false;

            if (siloBe.getItemHandler() != null) {
                for (int i = 0; i < siloBe.getItemHandler().getSlots(); i++) {
                    if (!siloBe.getItemHandler().getStackInSlot(i).isEmpty()) {
                        inventoryHasItems = true;
                        break;
                    }
                }
            }

            if (tankHasFluid || inventoryHasItems) {
                CompoundTag serverNbt = siloBe.saveWithFullMetadata();
                dropItem.getOrCreateTag().put("BlockEntityTag", serverNbt);
            }

            ItemEntity dropEntity = new ItemEntity(
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

            if (blockEntityTag.contains("SiloTank")) {
                CompoundTag tankTag = blockEntityTag.getCompound("SiloTank");

                FluidStack storedFluid = FluidStack.loadFluidStackFromNBT(tankTag);

                if (!storedFluid.isEmpty() && storedFluid.getAmount() > 0) {

                    Component fluidName = storedFluid.getDisplayName();


                    pTooltip.add(Component.literal("§7Contents: §b").append(fluidName));
                    return;
                }
            }
        }

        pTooltip.add(Component.literal("§7Contents: §8Empty"));
        super.appendHoverText(pStack, pLevel, pTooltip, pFlag);
    }

}
