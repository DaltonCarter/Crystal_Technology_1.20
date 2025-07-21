package com.CartersDev.crystechmod.block.custom;

import com.CartersDev.crystechmod.worldgen.dimension.ModDimensions;
import com.CartersDev.crystechmod.worldgen.portal.TempTeleporter;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceKey;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;

public class TempPortalBlock extends Block{
    public TempPortalBlock(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public InteractionResult use(BlockState pState, Level pLevel, BlockPos pPos, Player pPlayer, InteractionHand pHand, BlockHitResult pHit) {
        if (pPlayer.canChangeDimensions()){
            teleport(pPlayer, pPos);
            return InteractionResult.SUCCESS;
        }else {
            return InteractionResult.CONSUME;
        }
    }

    private void teleport(Player pPlayer, BlockPos pPos) {
        if(pPlayer.level() instanceof ServerLevel serverLevel){
            MinecraftServer minecraftServer = serverLevel.getServer();
            ResourceKey<Level> resourceKey = pPlayer.level().dimension() == ModDimensions.VITRIC_EXPANSE_LEVEL_KEY ?
                    Level.OVERWORLD : ModDimensions.VITRIC_EXPANSE_LEVEL_KEY;

            ServerLevel portalDimension = minecraftServer.getLevel(resourceKey);
            if(portalDimension != null && !pPlayer.isPassenger()) {
                if(resourceKey == ModDimensions.VITRIC_EXPANSE_LEVEL_KEY){
                    pPlayer.changeDimension(portalDimension, new TempTeleporter(pPos, true));
                }else {
                    pPlayer.changeDimension(portalDimension, new TempTeleporter(pPos, false));
                }
            }
        }



    }
}
