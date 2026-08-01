package com.CartersDev.crystechmod.block.custom.machines;

import com.CartersDev.crystechmod.block.entity.ModBlockEntities;
import com.CartersDev.crystechmod.block.entity.powermatricies.ProtocultureMatrixBlockEntity;
import com.CartersDev.crystechmod.util.ModBlockstateProperties;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraftforge.network.NetworkHooks;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class ProtocultureMatrixBlock extends PowerMatrixBlock {

    public static final BooleanProperty HAS_CANISTER = ModBlockstateProperties.HAS_CANISTER;

    public ProtocultureMatrixBlock(Properties properties) {
        super(3, properties);
        this.registerDefaultState(this.stateDefinition.any().setValue(HAS_CANISTER, false).setValue(MACHINE_CORE_LVL, 3));
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> pBuilder) {
        super.createBlockStateDefinition(pBuilder);
        pBuilder.add(HAS_CANISTER);
    }


    //Entity Logic:

    @Override
    public void onRemove(BlockState pState, Level pLevel, BlockPos pPos, BlockState pNewState, boolean pMovedByPiston) {
        if(pState.getBlock() != pNewState.getBlock()) {
            BlockEntity blockEntity = pLevel.getBlockEntity(pPos);

            if (!pLevel.isClientSide()) {
                for (Direction direction : Direction.values()) {
                    BlockPos neighborPos = pPos.relative(direction);
                    pLevel.neighborChanged(neighborPos, this, pPos);
                }
            }

            if(blockEntity instanceof ProtocultureMatrixBlockEntity) {
                ((ProtocultureMatrixBlockEntity) blockEntity).drops();
            }
            super.onRemove(pState, pLevel, pPos, pNewState, pMovedByPiston);
        }else {
            super.onRemove(pState, pLevel, pPos, pNewState, pMovedByPiston);
        }
    }

    @Override
    public RenderShape getRenderShape(BlockState pState) {
        return RenderShape.MODEL;
    }

    @Override
    public InteractionResult use(BlockState pState, Level pLevel, BlockPos pPos, Player pPlayer, InteractionHand pHand, BlockHitResult pHit) {
        if (!pLevel.isClientSide()) {
            BlockEntity entity = pLevel.getBlockEntity(pPos);
            if(entity instanceof ProtocultureMatrixBlockEntity) {
                NetworkHooks.openScreen(((ServerPlayer)pPlayer), (ProtocultureMatrixBlockEntity)entity, pPos);
                return InteractionResult.CONSUME;
            } else {
                throw new IllegalStateException("Our Container provider is missing!");
            }
        }

        return InteractionResult.CONSUME;
    }

    @Override
    public @Nullable BlockEntity newBlockEntity(BlockPos pPos, BlockState pState) {
        return new ProtocultureMatrixBlockEntity(pPos, pState);
    }

    @Override
    public @Nullable <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level pLevel, BlockState pState, BlockEntityType<T> pBlockEntityType) {
        if(pLevel.isClientSide()){
            return null;
        }

        return createTickerHelper(pBlockEntityType, ModBlockEntities.PROTOCULTURE_MATRIX_BE.get(),
                (pLevel1, pPos, pState1, pBlockEntity) -> pBlockEntity.tick(pLevel1, pPos, pState1));
    }

    @Override
    public void appendHoverText(ItemStack pStack, @Nullable BlockGetter pLevel, List<Component> pTooltip, TooltipFlag pFlag) {
        pTooltip.add(Component.literal("§7Tick Rate: § 800 FE"));
        pTooltip.add(Component.literal("§7Total Fe: § 2,000,000 FE"));
        pTooltip.add(Component.literal("§eRequires: §bFluid Canisters with at least 1000mb of Liquid Protoculture."));
        super.appendHoverText(pStack, pLevel, pTooltip, pFlag);
    }
}
