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

            if(aboveBlock == Blocks.POWDER_SNOW || aboveBlock == Blocks.SNOW|| aboveBlock == Blocks.SNOW_BLOCK){
                worldIn.setBlockAndUpdate(abovePos, Blocks.AIR.defaultBlockState());
            }

            if(aboveBlock == Blocks.WATER){
                worldIn.setBlockAndUpdate(abovePos, ModBlocks.TIBERIUM_WATER_BLOCK.get().defaultBlockState());
            }

            if (aboveBlock == Blocks.AIR || aboveBlock == Blocks.TALL_GRASS || aboveBlock == Blocks.GRASS || aboveBlock == Blocks.DEAD_BUSH) {
                Random random = new Random();
                int number = random.nextInt(10);

                if(number > 7){

//                    System.out.println("A patch of Vinifera Tiberium has sprouted!.");
                    worldIn.setBlockAndUpdate(abovePos, ModBlocks.BLUE_TIBERIUM_CROP.get().defaultBlockState());
                }else {
//                    System.out.println("A patch of Riparius Tiberium has sprouted!.");
                    worldIn.setBlockAndUpdate(abovePos, ModBlocks.GREEN_TIBERIUM_CROP.get().defaultBlockState());
                }

            } else if (aboveState.is(ModTags.Blocks.TIBERIUM_VULNERABLE_SAPLINGS)  && !worldIn.getBlockState(abovePos).is(ModBlocks.PLAGUED_SAPLING.get()) ) {
                Random random = new Random();
                int number = random.nextInt(10);

                if (number > 7) {

//                    System.out.println("A sapling has contracted Tiberium Plague!.");
                    worldIn.setBlockAndUpdate(abovePos, ModBlocks.PLAGUED_SAPLING.get().defaultBlockState());
                }

            }else if (aboveState.is(ModTags.Blocks.TIBERIUM_FLOWERS) && !worldIn.getBlockState(abovePos).is(ModBlocks.VITRIC_ROSE.get()) && !worldIn.getBlockState(abovePos).is(ModBlocks.VITRIC_BLOOM.get()) ) {
                Random random = new Random();
                int number = random.nextInt(10);

                if (number <= 7) {

//                    System.out.println("A flower has contracted Tiberium Plague!.");
                    worldIn.setBlockAndUpdate(abovePos, ModBlocks.VITRIC_BLOOM.get().defaultBlockState());
                }else {

//                    System.out.println("A flower has contracted Tiberium Plague!.");
                    worldIn.setBlockAndUpdate(abovePos, ModBlocks.VITRIC_ROSE.get().defaultBlockState());
                }

            }
        }}






    @Override
    public boolean canDropFromExplosion(BlockState state, BlockGetter level, BlockPos pos, Explosion explosion) {
        return true;
    }

    @Override
    public boolean canSustainPlant(BlockState state, BlockGetter world, BlockPos pos, Direction facing, IPlantable plantable) {
        Block plant = plantable.getPlant(world, pos.relative(facing)).getBlock();

        if (plant == ModBlocks.GREEN_TIBERIUM_CROP.get()){
            return true;
        } else if (plant == ModBlocks.BLUE_TIBERIUM_CROP.get()) {
            return true;
        } else if (plant instanceof SaplingBlock) {
            return true;
        } else if (plant instanceof FlowerBlock) {
            return true;
        } else {
            return super.canSustainPlant(state, world, pos, facing, plantable);
        }
    }

}
