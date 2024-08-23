package com.CartersDev.crystechmod.item.custom;

import com.CartersDev.crystechmod.block.ModBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;

import java.util.Objects;
import java.util.Random;

public class Firestone extends Item {
Random random = new Random();

    @Override
    public InteractionResult onItemUseFirst(ItemStack stack, UseOnContext context) {
        Level level = context.getLevel();
        if (!level.isClientSide) {
            Player playerEntity = Objects.requireNonNull(context.getPlayer());
            BlockState clickedBlock = level.getBlockState(context.getClickedPos());

            rightClickOnCertainBlockState(clickedBlock, context, playerEntity);
            context.getItemInHand().hurtAndBreak(1, context.getPlayer(), player ->
                    player.broadcastBreakEvent(player.getUsedItemHand()));


        }

        return super.onItemUseFirst(stack, context);
    }

    private void rightClickOnCertainBlockState(BlockState clickedBlock, UseOnContext context, Player playerEntity) {
        boolean playerIsNotOnFire = !playerEntity.isOnFire();


        if (random.nextFloat() > 0.5f) {
            lightEntityOnFire(playerEntity, 6);

        } else if (playerIsNotOnFire && blockIsValidForResistance(clickedBlock)) {
            gainFireResistanceAndDestroyBlock(playerEntity, context.getLevel(), context.getClickedPos());

        }
    }

    private boolean blockIsValidForResistance(BlockState clickedBlock) {
        return clickedBlock.is(Blocks.OBSIDIAN) || clickedBlock.is(ModBlocks.FIRESTONE_BLOCK.get());

    }

    public static void lightEntityOnFire(Entity entity, int second) {
        entity.setSecondsOnFire(second);
    }

    private void gainFireResistanceAndDestroyBlock(Player playerEntity, Level world, BlockPos pos) {
        gainFireResistance(playerEntity);
        world.destroyBlock(pos,false, null);
    }

    public static void gainFireResistance(Player playerEntity) {
        playerEntity.addEffect(new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 200));
    }


    public Firestone(Properties pProperties) {
        super(pProperties);
    }
}
