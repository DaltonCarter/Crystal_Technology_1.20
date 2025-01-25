package com.CartersDev.crystechmod.block.custom;

import com.CartersDev.crystechmod.block.ModBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;

import java.util.Random;

public class BlossomTreeBaseBlock extends Block {
    public BlossomTreeBaseBlock(Properties pProperties) {

        super(pProperties);
        this.registerDefaultState(this.defaultBlockState().setValue(CANGROW, true));
    }

  public static final BooleanProperty CANGROW = BlockStateProperties.TRIGGERED;


    public void tick(BlockState state, ServerLevel worldIn, BlockPos pos, RandomSource rand){
        super.tick(state, worldIn, pos, rand);

        Random random = new Random();
        int growth = random.nextInt(10);
        BlockPos abovePos = pos.above();
        BlockPos abovePos2 = pos.above(2);

        boolean flag = state.getValue(CANGROW);

        if(!worldIn.isClientSide() && flag) {
         if (growth >= 7) {
           growBlossomTree(abovePos, abovePos2, worldIn);
             worldIn.setBlock(pos, state.setValue(CANGROW, false), 2);
         }

            }
        }

    public void growBlossomTree(BlockPos pos1, BlockPos pos2, ServerLevel worldIn) {


        System.out.println("A Blossom Tree has Matured!");
        worldIn.setBlockAndUpdate(pos1, ModBlocks.BLOSSOM_CENTER.get().defaultBlockState());
        worldIn.setBlockAndUpdate(pos2, ModBlocks.BLOSSOM_SPOUT.get().defaultBlockState());

    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> pBuilder) {
        pBuilder.add(CANGROW);
    }

}


