package com.CartersDev.crystechmod.block.custom;

import com.CartersDev.crystechmod.block.ModBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.minecraft.world.level.block.state.BlockState;

public class BlossomTreeBaseBlock extends RotatedPillarBlock {
    public BlossomTreeBaseBlock(Properties pProperties) {super(pProperties);}

    @Override
    public void onPlace(BlockState pState, Level pLevel, BlockPos pPos, BlockState pOldState, boolean pMovedByPiston) {
        super.onPlace(pState, pLevel, pPos, pOldState, pMovedByPiston);

        if(!pLevel.isClientSide()){
            BlockPos abovePos = pPos.above();
            BlockPos abovePos2 = pPos.above(2);
            BlockState aboveState = pLevel.getBlockState(abovePos);
            BlockState aboveState2 = pLevel.getBlockState(abovePos2);
            Block aboveBlock = aboveState.getBlock();
            Block aboveBlock2 = aboveState2.getBlock();

//            pLevel.setBlockAndUpdate(abovePos, ModBlocks.BLOSSOM_CENTER.get().defaultBlockState());
//            pLevel.setBlockAndUpdate(abovePos2, ModBlocks.BLOSSOM_SPOUT.get().defaultBlockState());

        }



    }

}


