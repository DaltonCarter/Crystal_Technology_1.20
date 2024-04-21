package com.CartersDev.crystechmod.block.custom;



import com.CartersDev.crystechmod.block.ModBlocks;
import com.CartersDev.crystechmod.util.ModTags;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Explosion;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.FlowerBlock;
import net.minecraft.world.level.block.SaplingBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.common.IPlantable;

import java.util.Random;

public class TiberiumSoilBlock extends Block {
    public TiberiumSoilBlock(Properties properties) { super(properties);}


    public void tick(BlockState state, ServerLevel worldIn, BlockPos pos, RandomSource rand){
        super.tick(state, worldIn, pos, rand);

        if (!worldIn.isClientSide()) {
            BlockPos abovePos = pos.above();
            BlockState aboveState = worldIn.getBlockState(abovePos);
            Block aboveBlock = aboveState.getBlock();


            if (aboveBlock == Blocks.AIR) {
                Random random = new Random();
                int number = random.nextInt(10);

                if(number > 7){

                    System.out.println("A patch of Vinifera Tiberium has sprouted!.");
//                    worldIn.setBlockAndUpdate(abovePos, ModBlocks.BLUE_TIBERIUM_CROP.get().getDefaultState());
                }else {
                    System.out.println("A patch of Riparius Tiberium has sprouted!.");
//                    worldIn.setBlockAndUpdate(abovePos, ModBlocks.GREEN_TIBERIUM_CROP.get().getDefaultState());
                }

            } else if (aboveState.is(ModTags.Blocks.TIBERIUM_VULNERABLE_WOOD)) {
                Random random = new Random();
                int number = random.nextInt(10);

                if(number > 7){

                    System.out.println("A Tree has contracted Tiberium Plague!.");
//                    worldIn.setBlockAndUpdate(abovePos, ModBlocks.PLAGUED_LOG.get().getDefaultState());
                }
            } else if (aboveState.is(ModTags.Blocks.VULNERABLE_LEAVES) ) {
                Random random = new Random();
                int number = random.nextInt(10);

                if(number > 7){

                    System.out.println("Tree Leaves have contracted Tiberium Plague!.");
//                    worldIn.setBlockAndUpdate(abovePos, ModBlocks.PLAGUED_LEAVES.get().getDefaultState());
                }
            }


            //tree and plant corruption

        }
    }

    @Override
    public boolean canDropFromExplosion(BlockState state, BlockGetter level, BlockPos pos, Explosion explosion) {
        return true;
    }

//    @Override
//    public boolean canSustainPlant(BlockState state, BlockGetter world, BlockPos pos, Direction facing, IPlantable plantable) {
//        Block plant = plantable.getPlant(world, pos.relative(facing)).getBlock();

//        if (plant == ModBlocks.GREEN_TIBERIUM_CROP.get()){
//            return true;
//        } else if (plant == ModBlocks.BLUE_TIBERIUM_CROP.get()) {
//            return true;
//        } else if (plant instanceof SaplingBlock) {
//            return true;
//        } else if (plant instanceof FlowerBlock) {
//            return true;
//        } else {
//            return super.canSustainPlant(state, world, pos, facing, plantable);
//        }
//    }

}
