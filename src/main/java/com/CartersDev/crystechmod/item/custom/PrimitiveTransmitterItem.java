package com.CartersDev.crystechmod.item.custom;

import com.CartersDev.crystechmod.worldgen.dimension.ModDimensions;
import com.CartersDev.crystechmod.worldgen.portal.Teleporter.VitricTeleporter;
import com.CartersDev.crystechmod.worldgen.portal.TempTeleporter;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceKey;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.level.Level;

public class PrimitiveTransmitterItem extends Item {
    public PrimitiveTransmitterItem(Properties pProperties) {
        super(pProperties);
    }


    @Override
    public InteractionResultHolder<ItemStack> use(Level pLevel, Player pPlayer, InteractionHand pUsedHand) {
        if(!pLevel.isClientSide && pPlayer.canChangeDimensions()) {
            handleTransmission(pPlayer, pPlayer.getOnPos());
            pPlayer.getItemInHand(pUsedHand).hurtAndBreak(1, pPlayer, player ->  player.broadcastBreakEvent(InteractionHand.MAIN_HAND));
            return InteractionResultHolder.success(pPlayer.getItemInHand(pUsedHand));
        }

        return InteractionResultHolder.pass(pPlayer.getItemInHand(pUsedHand));
    }

    private void handleTransmission(Entity player, BlockPos pPos) {
        if (player.level() instanceof ServerLevel serverlevel) {
            MinecraftServer minecraftserver = serverlevel.getServer();
            ResourceKey<Level> destination = serverlevel.dimension() != ModDimensions.VITRIC_EXPANSE_LEVEL_KEY
                    ? ModDimensions.VITRIC_EXPANSE_LEVEL_KEY : Level.OVERWORLD;

            ServerLevel portalDimension = minecraftserver.getLevel(destination);
            if (portalDimension != null && !player.isPassenger()) {
                if(destination == ModDimensions.VITRIC_EXPANSE_LEVEL_KEY) {
                    player.changeDimension(portalDimension, new TempTeleporter(pPos, true));
                } else {
                    player.changeDimension(portalDimension, new TempTeleporter(pPos, false));
                }
            }
        }
    }

    @Override
    public boolean canApplyAtEnchantingTable(ItemStack stack, Enchantment enchantment) {
        return false;
    }

    @Override
    public boolean isBookEnchantable(ItemStack stack, ItemStack book) {
        return false;
    }
}
