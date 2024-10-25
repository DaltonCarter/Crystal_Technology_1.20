package com.CartersDev.crystechmod.item.custom;


import com.CartersDev.crystechmod.util.ModTags;
import com.mojang.datafixers.util.Pair;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.CampfireBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraftforge.common.TierSortingRegistry;
import net.minecraftforge.common.ToolActions;
import org.jetbrains.annotations.NotNull;

import java.util.function.Consumer;
import java.util.function.Predicate;

import static net.minecraft.world.item.HoeItem.changeIntoState;


//The Below Class is all thanks to Kaupenjoe and Mekanism Tools!!!  The Code was edited by me to work together, but the parts themselves ARE NOT MY WORK!!!

public class PaxelItem extends AxeItem implements Vanishable {
    public PaxelItem(Tier pTier, float pAttackDamageModifier, float pAttackSpeedModifier, Properties pProperties) {
        super(pTier, pAttackDamageModifier, pAttackSpeedModifier, pProperties);
    }

    @Override
    public float getDestroySpeed(@NotNull ItemStack stack, @NotNull BlockState state) {
        return state.is(ModTags.Blocks.PAXEL_MINEABLE) ?  this.speed: 1;
    }

    public InteractionResult useOn(UseOnContext pContext) {
        Level level = pContext.getLevel();
        BlockPos blockpos = pContext.getClickedPos();
        Player player = pContext.getPlayer();
        BlockState blockstate = level.getBlockState(blockpos);


        // Attempt to use the paxel as an axe
        InteractionResult axeResult = super.useOn(pContext);
        if (axeResult != InteractionResult.PASS) {
            return axeResult;

        } else {
            if (pContext.getClickedFace() == Direction.DOWN) {
                return InteractionResult.PASS;
            } else if (player != null && !player.isCrouching()){
                BlockState blockstate1 = blockstate.getToolModifiedState(pContext, net.minecraftforge.common.ToolActions.SHOVEL_FLATTEN, false);
                BlockState blockstate2 = null;
                if (blockstate1 != null && level.isEmptyBlock(blockpos.above())) {
                    level.playSound(player, blockpos, SoundEvents.SHOVEL_FLATTEN, SoundSource.BLOCKS, 1.0F, 1.0F);
                    blockstate2 = blockstate1;
                } else if (blockstate.getBlock() instanceof CampfireBlock && blockstate.getValue(CampfireBlock.LIT)) {
                    if (!level.isClientSide()) {
                        level.levelEvent((Player)null, 1009, blockpos, 0);
                   }

                    CampfireBlock.dowse(pContext.getPlayer(), level, blockpos, blockstate);
                    blockstate2 = blockstate.setValue(CampfireBlock.LIT, Boolean.valueOf(false));
                }

                if (blockstate2 != null) {
                    if (!level.isClientSide) {
                        level.setBlock(blockpos, blockstate2, 11);
                        level.gameEvent(GameEvent.BLOCK_CHANGE, blockpos, GameEvent.Context.of(player, blockstate2));
                        pContext.getItemInHand().hurtAndBreak(1, player, (p_43122_) -> {
                            p_43122_.broadcastBreakEvent(pContext.getHand());
                        });
                    }

                    return InteractionResult.sidedSuccess(level.isClientSide);
                } else {
                    return InteractionResult.PASS;
                }
            } else {
                BlockState toolModifiedState = level.getBlockState(blockpos).getToolModifiedState(pContext, net.minecraftforge.common.ToolActions.HOE_TILL, false);
                Pair<Predicate<UseOnContext>, Consumer<UseOnContext>> pair = toolModifiedState == null ? null : Pair.of(ctx -> true, changeIntoState(toolModifiedState));
                if (pair == null) {
                    return InteractionResult.PASS;
                } else {
                    Predicate<UseOnContext> predicate = pair.getFirst();
                    Consumer<UseOnContext> consumer = pair.getSecond();
                    if (predicate.test(pContext)) {
                        level.playSound(player, blockpos, SoundEvents.HOE_TILL, SoundSource.BLOCKS, 1.0F, 1.0F);
                        if (!level.isClientSide) {
                            consumer.accept(pContext);
                            if (player != null) {
                                pContext.getItemInHand().hurtAndBreak(1, player, (p_150845_) -> {
                                    p_150845_.broadcastBreakEvent(pContext.getHand());
                                });
                            }
                        }

                        return InteractionResult.sidedSuccess(level.isClientSide);
                    } else {
                        return InteractionResult.PASS;
                    }
                }
            }
        }
    }

    @Override
    public boolean canPerformAction(ItemStack stack, net.minecraftforge.common.ToolAction toolAction) {
        return ToolActions.DEFAULT_AXE_ACTIONS.contains(toolAction) || ToolActions.DEFAULT_HOE_ACTIONS.contains(toolAction) || ToolActions.DEFAULT_SHOVEL_ACTIONS.contains(toolAction);
    }

    @Override
    public boolean isCorrectToolForDrops(BlockState state) {
        return state.is(ModTags.Blocks.PAXEL_MINEABLE) && TierSortingRegistry.isCorrectTierForDrops(getTier(), state);
    }

    @Override
    public boolean isCorrectToolForDrops(ItemStack stack, BlockState state) {
        return this.isCorrectToolForDrops(state);
    }
}

//BELOW IS TRIMMED CODE THAT IS BEING KEPT IN CASE REGRESSION IS NECESSARY, DO NOT UNCOMMENT!

//    public PaxelItem(Tier pTier, float pAttackDamageModifier, float pAttackSpeedModifier, Properties pProperties) {
//        super(pAttackDamageModifier, pAttackSpeedModifier, pTier, ModTags.Blocks.PAXEL_MINEABLE, pProperties);
//    }

//        Optional<BlockState> optional = Optional.ofNullable(blockstate.getToolModifiedState(pContext, net.minecraftforge.common.ToolActions.AXE_STRIP, false));
//        Optional<BlockState> optional1 = optional.isPresent() ? Optional.empty() : Optional.ofNullable(blockstate.getToolModifiedState(pContext, net.minecraftforge.common.ToolActions.AXE_SCRAPE, false));
//        Optional<BlockState> optional2 = optional.isPresent() || optional1.isPresent() ? Optional.empty() : Optional.ofNullable(blockstate.getToolModifiedState(pContext, net.minecraftforge.common.ToolActions.AXE_WAX_OFF, false));
//        ItemStack itemstack = pContext.getItemInHand();
//        Optional<BlockState> optional3 = Optional.empty();
//        if (optional.isPresent()) {
//            level.playSound(player, blockpos, SoundEvents.AXE_STRIP, SoundSource.BLOCKS, 1.0F, 1.0F);
//            optional3 = optional;
//        } else if (optional1.isPresent()) {
//            level.playSound(player, blockpos, SoundEvents.AXE_SCRAPE, SoundSource.BLOCKS, 1.0F, 1.0F);
//            level.levelEvent(player, 3005, blockpos, 0);
//            optional3 = optional1;
//        } else if (optional2.isPresent()) {
//            level.playSound(player, blockpos, SoundEvents.AXE_WAX_OFF, SoundSource.BLOCKS, 1.0F, 1.0F);
//            level.levelEvent(player, 3004, blockpos, 0);
//            optional3 = optional2;
//        }
//
//        if (optional3.isPresent()) {
//            if (player instanceof ServerPlayer) {
//                CriteriaTriggers.ITEM_USED_ON_BLOCK.trigger((ServerPlayer)player, blockpos, itemstack);
//            }
//
//            level.setBlock(blockpos, optional3.get(), 11);
//            level.gameEvent(GameEvent.BLOCK_CHANGE, blockpos, GameEvent.Context.of(player, optional3.get()));
//            if (player != null) {
//                itemstack.hurtAndBreak(1, player, (p_150686_) -> {
//                    p_150686_.broadcastBreakEvent(pContext.getHand());
//                });
//            }
//
//            return InteractionResult.sidedSuccess(level.isClientSide);

//        Level world = pContext.getLevel();
//        BlockPos blockpos = pContext.getClickedPos();
//        Player player = pContext.getPlayer();
//        BlockState blockstate = world.getBlockState(blockpos);
//        BlockState resultToSet = null;
