package com.CartersDev.crystechmod.block.custom;



import com.CartersDev.crystechmod.block.ModBlocks;
import com.CartersDev.crystechmod.util.ModTags;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.minecraft.world.level.block.state.BlockState;

import java.util.Random;


public class BlossomTreeSpoutBlock extends RotatedPillarBlock {
    public BlossomTreeSpoutBlock(Properties properties) {
        super(properties);
    }


    @Override
    public void animateTick(BlockState state, Level world, BlockPos pos, RandomSource rand) {
        super.animateTick(state, world, pos, rand);

        double x = pos.getX();
        double y = pos.getY();
        double z = pos.getZ();
        float chance = 0.97f;

        if(chance < rand.nextFloat()) {
            world.playSound(null, x, y, z, SoundEvents.CREEPER_PRIMED, SoundSource.BLOCKS, 1.0f, 1.0f);

            world.addParticle(ParticleTypes.COMPOSTER, pos.getX() + rand.nextDouble(),
                    pos.getY() + 1.5D, pos.getZ() + rand.nextDouble(),
                    0d, 0.05d, 0d);

            world.addParticle(ParticleTypes.LARGE_SMOKE, pos.getX() + rand.nextDouble(),
                    pos.getY() + 1.0D, pos.getZ() + rand.nextDouble(),
                    0d, 0.05d, 0d);
        }
    }

    public void tick(BlockState state, ServerLevel worldIn, BlockPos pos, RandomSource rand){
        super.tick(state, worldIn, pos, rand);

        Random random = new Random();
        int x = random.nextInt(10) - random.nextInt(10);
        int y = random.nextInt(15) - random.nextInt(15);
        int z = random.nextInt(10) - random.nextInt(10);


        if(!worldIn.isClientSide()){
         BlockPos target = pos.offset(x, y - 4, z);
         BlockState block = worldIn.getBlockState(target);

//            System.out.println("Spread Statement reached!" + target);

         if (block.is(ModTags.Blocks.TIBERIUM_VIABLE_BLOCKS)) {
//             System.out.println("Found a Block that can host Tiberium!");
             if(worldIn.getBlockState(target).getBlock() == ModBlocks.YELLOW_ZONE_CRACKED_DIRT.get()) {
                 System.out.println("Yellow Zone Cracked Dirt has been Seeded!");
                 worldIn.setBlockAndUpdate(target, ModBlocks.SEEDED_YELLOW_ZONE_CRACKED_DIRT.get().defaultBlockState());
             } else if (worldIn.getBlockState(target).getBlock() == ModBlocks.RED_ZONE_DIRT.get()) {
                 System.out.println("Red Zone Dirt has been Seeded!");
                 worldIn.setBlockAndUpdate(target, ModBlocks.SEEDED_RED_ZONE_DIRT.get().defaultBlockState());
             }else if (worldIn.getBlockState(target).getBlock() == Blocks.DIRT) {
                 System.out.println("Dirt has been Seeded!");
                 worldIn.setBlockAndUpdate(target, ModBlocks.SEEDED_DIRT.get().defaultBlockState());
             }else if (worldIn.getBlockState(target).getBlock() == Blocks.STONE) {
                 System.out.println("Stone has been Infested!");
                 worldIn.setBlockAndUpdate(target, ModBlocks.INFESTED_STONE.get().defaultBlockState());
             }else if (worldIn.getBlockState(target).getBlock() == Blocks.STONE_BRICKS) {
                 System.out.println("Stone Bricks have been Infested!");
                 worldIn.setBlockAndUpdate(target, ModBlocks.INFESTED_STONE_BRICKS.get().defaultBlockState());
             }else if (worldIn.getBlockState(target).getBlock() == Blocks.ANDESITE) {
                 System.out.println("Andesite has been Infested!");
                 worldIn.setBlockAndUpdate(target, ModBlocks.INFESTED_ANDESITE.get().defaultBlockState());
             }else if (worldIn.getBlockState(target).getBlock() == Blocks.GRANITE) {
                 System.out.println("Granite has been Infested!");
                 worldIn.setBlockAndUpdate(target, ModBlocks.INFESTED_GRANITE.get().defaultBlockState());
             }else if (worldIn.getBlockState(target).getBlock() == Blocks.DIORITE) {
                 System.out.println("Diorite has been Infested!");
                 worldIn.setBlockAndUpdate(target, ModBlocks.INFESTED_DIORITE.get().defaultBlockState());
             }else if (worldIn.getBlockState(target).getBlock() == Blocks.COBBLESTONE) {
                 System.out.println("Cobblestone has been Infested!");
                 worldIn.setBlockAndUpdate(target, ModBlocks.INFESTED_COBBLE.get().defaultBlockState());
             }
         } else if (block.is(ModTags.Blocks.TIBERIUM_SEED_BLOCKS)) {
//             System.out.println("Seeded soil has been found!");
             int SoilChance = random.nextInt(10);
             if(SoilChance >= 9){
                 System.out.println("Ichor Soil has been created!");
                 worldIn.setBlockAndUpdate(target, ModBlocks.ICHOR_SOIL.get().defaultBlockState());
             }else {
                 System.out.println("Tiberium Soil has been created!");
                 worldIn.setBlockAndUpdate(target, ModBlocks.TIBERIUM_SOIL.get().defaultBlockState());
             }

         }
//         else if (worldIn.getBlockState(target).getBlock() == Blocks.WATER) {
//             System.out.println("Water has been infected with Tiberium!");
//             worldIn.setBlock(target, ModFluids.TIBERIUM_WATER_BLOCK.get().defaultBlockState(), 1);
//         }

        }

    }
}
