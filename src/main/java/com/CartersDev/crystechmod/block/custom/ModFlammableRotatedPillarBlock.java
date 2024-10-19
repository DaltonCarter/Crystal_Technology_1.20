package com.CartersDev.crystechmod.block.custom;

import com.CartersDev.crystechmod.block.ModBlocks;
import com.CartersDev.crystechmod.item.custom.PaxelItem;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.item.AxeItem;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.common.ToolAction;
import org.jetbrains.annotations.Nullable;

import java.util.Map;

public class ModFlammableRotatedPillarBlock extends RotatedPillarBlock {
    public ModFlammableRotatedPillarBlock(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public boolean isFlammable(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
        return true;
    }

    @Override
    public int getFlammability(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
        return 5;
    }

    @Override
    public int getFireSpreadSpeed(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
        return 5;
    }

    @Override
    public @Nullable BlockState getToolModifiedState(BlockState state, UseOnContext context, ToolAction toolAction, boolean simulate) {
        if(context.getItemInHand().getItem() instanceof AxeItem || context.getItemInHand().getItem() instanceof PaxelItem) {
            if(state.is(ModBlocks.PLAGUED_LOG.get())){
                return ModBlocks.STRIPPED_PLAGUED_LOG.get().defaultBlockState().setValue(AXIS, state.getValue(AXIS));
            }

            if(state.is(ModBlocks.PLAGUED_WOOD.get())){
                return ModBlocks.STRIPPED_PLAGUED_WOOD.get().defaultBlockState().setValue(AXIS, state.getValue(AXIS));
            }

            if(state.is(ModBlocks.EMBER_OAK_LOG.get())){
                return ModBlocks.STRIPPED_EMBER_OAK_LOG.get().defaultBlockState().setValue(AXIS, state.getValue(AXIS));
            }
            if(state.is(ModBlocks.EMBER_OAK_WOOD.get())){
                return ModBlocks.STRIPPED_EMBER_OAK_WOOD.get().defaultBlockState().setValue(AXIS, state.getValue(AXIS));
            }
            if(state.is(ModBlocks.DEAD_LOG.get())){
                return ModBlocks.STRIPPED_DEAD_LOG.get().defaultBlockState().setValue(AXIS, state.getValue(AXIS));
            }
            if(state.is(ModBlocks.DEAD_WOOD.get())){
                return ModBlocks.STRIPPED_DEAD_WOOD.get().defaultBlockState().setValue(AXIS, state.getValue(AXIS));
            }
            if(state.is(ModBlocks.MARIKA_OAK_LOG.get())){
                return ModBlocks.STRIPPED_MARIKA_OAK_LOG.get().defaultBlockState().setValue(AXIS, state.getValue(AXIS));
            }
            if(state.is(ModBlocks.MARIKA_OAK_WOOD.get())){
                return ModBlocks.STRIPPED_MARIKA_OAK_WOOD.get().defaultBlockState().setValue(AXIS, state.getValue(AXIS));
            }
        }
        return super.getToolModifiedState(state, context, toolAction, simulate);
    }



}
