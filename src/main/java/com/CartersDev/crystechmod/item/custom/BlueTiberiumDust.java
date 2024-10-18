package com.CartersDev.crystechmod.item.custom;

import com.CartersDev.crystechmod.block.ModBlocks;
import com.CartersDev.crystechmod.item.ModItems;
import com.CartersDev.crystechmod.util.ModTags;
import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.item.ItemNameBlockItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;


public class BlueTiberiumDust extends ItemNameBlockItem {
    public BlueTiberiumDust(Block pBlock, Properties pProperties) {
        super(pBlock, pProperties);
    }

    @Override
    public InteractionResult useOn(UseOnContext pContext) {
        InteractionHand pHand = pContext.getPlayer().getUsedItemHand();
        BlockPos pPos = pContext.getClickedPos();
        BlockState pState = pContext.getLevel().getBlockState(pPos);
        ItemStack itemstack = pContext.getItemInHand();
        Level pLevel = pContext.getLevel();
        RandomSource rand = RandomSource.create();

        if (!pLevel.isClientSide() && pHand == InteractionHand.MAIN_HAND) {


            if (itemstack.is(ModItems.BLUE_TIBERIUM_DUST.get())) {
                int SoilChance = rand.nextInt(10);
                if (SoilChance >= 5) {
                    if (pLevel.getBlockState(pPos).getBlock() == ModBlocks.YELLOW_ZONE_CRACKED_DIRT.get()) {
                        System.out.println("Yellow Zone Cracked Dirt has been Seeded!");
                        pLevel.setBlockAndUpdate(pPos, ModBlocks.SEEDED_YELLOW_ZONE_CRACKED_DIRT.get().defaultBlockState());
                        pLevel.playSound(null, pPos, SoundEvents.BONE_MEAL_USE, SoundSource.BLOCKS, 1f, 1f);
                        itemstack.shrink(1);
                        return InteractionResult.SUCCESS;

                    } else if (pLevel.getBlockState(pPos).getBlock() == ModBlocks.RED_ZONE_DIRT.get()) {
                        System.out.println("Red Zone Dirt has been Seeded!");
                        pLevel.setBlockAndUpdate(pPos, ModBlocks.SEEDED_RED_ZONE_DIRT.get().defaultBlockState());
                        pLevel.playSound(null, pPos, SoundEvents.BONE_MEAL_USE, SoundSource.BLOCKS, 1f, 1f);
                        itemstack.shrink(1);
                        return InteractionResult.SUCCESS;

                    } else if (pLevel.getBlockState(pPos).getBlock() == Blocks.DIRT) {
                        System.out.println("Dirt has been Seeded!");
                        pLevel.setBlockAndUpdate(pPos, ModBlocks.SEEDED_DIRT.get().defaultBlockState());
                        pLevel.playSound(null, pPos, SoundEvents.BONE_MEAL_USE, SoundSource.BLOCKS, 1f, 1f);
                        itemstack.shrink(1);
                        return InteractionResult.SUCCESS;

                    } else if (pLevel.getBlockState(pPos).getBlock() == Blocks.GRASS_BLOCK) {
                        System.out.println("Grass has been Seeded!");
                        pLevel.setBlockAndUpdate(pPos, ModBlocks.SEEDED_DIRT.get().defaultBlockState());
                        pLevel.playSound(null, pPos, SoundEvents.BONE_MEAL_USE, SoundSource.BLOCKS, 1f, 1f);
                        itemstack.shrink(1);
                        return InteractionResult.SUCCESS;

                    } else if (pLevel.getBlockState(pPos).getBlock() == Blocks.STONE) {
                        System.out.println("Stone has been Infested!");
                        pLevel.setBlockAndUpdate(pPos, ModBlocks.INFESTED_STONE.get().defaultBlockState());
                        pLevel.playSound(null, pPos, SoundEvents.BONE_MEAL_USE, SoundSource.BLOCKS, 1f, 1f);
                        itemstack.shrink(1);
                        return InteractionResult.SUCCESS;

                    } else if (pLevel.getBlockState(pPos).getBlock() == Blocks.STONE_BRICKS) {
                        System.out.println("Stone Bricks have been Infested!");
                        pLevel.setBlockAndUpdate(pPos, ModBlocks.INFESTED_STONE_BRICKS.get().defaultBlockState());
                        pLevel.playSound(null, pPos, SoundEvents.BONE_MEAL_USE, SoundSource.BLOCKS, 1f, 1f);
                        itemstack.shrink(1);
                        return InteractionResult.SUCCESS;

                    } else if (pLevel.getBlockState(pPos).getBlock() == Blocks.ANDESITE) {
                        System.out.println("Andesite has been Infested!");
                        pLevel.setBlockAndUpdate(pPos, ModBlocks.INFESTED_ANDESITE.get().defaultBlockState());
                        pLevel.playSound(null, pPos, SoundEvents.BONE_MEAL_USE, SoundSource.BLOCKS, 1f, 1f);
                        itemstack.shrink(1);
                        return InteractionResult.SUCCESS;

                    } else if (pLevel.getBlockState(pPos).getBlock() == Blocks.GRANITE) {
                        System.out.println("Granite has been Infested!");
                        pLevel.setBlockAndUpdate(pPos, ModBlocks.INFESTED_GRANITE.get().defaultBlockState());
                        pLevel.playSound(null, pPos, SoundEvents.BONE_MEAL_USE, SoundSource.BLOCKS, 1f, 1f);
                        itemstack.shrink(1);
                        return InteractionResult.SUCCESS;

                    } else if (pLevel.getBlockState(pPos).getBlock() == Blocks.DIORITE) {
                        System.out.println("Diorite has been Infested!");
                        pLevel.setBlockAndUpdate(pPos, ModBlocks.INFESTED_DIORITE.get().defaultBlockState());
                        pLevel.playSound(null, pPos, SoundEvents.BONE_MEAL_USE, SoundSource.BLOCKS, 1f, 1f);
                        itemstack.shrink(1);
                        return InteractionResult.SUCCESS;

                    } else if (pLevel.getBlockState(pPos).getBlock() == Blocks.COBBLESTONE) {
                        System.out.println("Cobblestone has been Infested!");
                        pLevel.setBlockAndUpdate(pPos, ModBlocks.INFESTED_COBBLE.get().defaultBlockState());
                        pLevel.playSound(null, pPos, SoundEvents.BONE_MEAL_USE, SoundSource.BLOCKS, 1f, 1f);
                        itemstack.shrink(1);
                        return InteractionResult.SUCCESS;

                    }
                } else if (pState.is(ModTags.Blocks.TIBERIUM_SEED_BLOCKS)) {
//             System.out.println("Seeded soil has been found!");
                    int SoilChance2 = rand.nextInt(10);
                    if (SoilChance2 >= 9) {
                        System.out.println("Ichor Soil has been created!");
                        pLevel.setBlockAndUpdate(pPos, ModBlocks.ICHOR_SOIL.get().defaultBlockState());
                        pLevel.playSound(null, pPos, SoundEvents.BONE_MEAL_USE, SoundSource.BLOCKS, 1f, 1f);
                        itemstack.shrink(1);
                        return InteractionResult.SUCCESS;

                    } else {
                        System.out.println("Tiberium Soil has been created!");
                        pLevel.setBlockAndUpdate(pPos, ModBlocks.TIBERIUM_SOIL.get().defaultBlockState());
                        pLevel.playSound(null, pPos, SoundEvents.BONE_MEAL_USE, SoundSource.BLOCKS, 1f, 1f);
                        itemstack.shrink(1);
                        return InteractionResult.SUCCESS;
                    }
                }else {
                    pLevel.playSound(null, pPos, SoundEvents.BONE_MEAL_USE, SoundSource.BLOCKS, 1f, 1f);
                    itemstack.shrink(1);
                    return InteractionResult.CONSUME;
                }

            } else {

                return InteractionResult.FAIL;
            }

        }
        return InteractionResult.SUCCESS;
    }
}


