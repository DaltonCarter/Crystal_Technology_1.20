package com.CartersDev.crystechmod.item.custom;

import com.CartersDev.crystechmod.block.ModBlocks;
import com.CartersDev.crystechmod.block.custom.SaberCornCropBlock;
import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.item.ItemNameBlockItem;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;

public class SaberCornSeeds extends ItemNameBlockItem {
    public SaberCornSeeds(Block pBlock, Properties pProperties) {
        super(pBlock, pProperties);
    }

    @Override
    public InteractionResult useOn(UseOnContext pContext) {
        BlockPos pPos = pContext.getClickedPos();
        BlockState pState = pContext.getLevel().getBlockState(pPos);
        InteractionResult interactionresult = this.place(new BlockPlaceContext(pContext));
        Integer target = pState.getValue(SaberCornCropBlock.AGE);
        if (target >= 7) {
            System.out.println("POIT!");
            return InteractionResult.FAIL;

        }else {
            if(!interactionresult.consumesAction() && this.isEdible()) {
                System.out.println("ZOT!");
            InteractionResult interactionresult1 = this.use(pContext.getLevel(), pContext.getPlayer(), pContext.getHand()).getResult();
            return interactionresult1 == InteractionResult.CONSUME ? InteractionResult.CONSUME_PARTIAL : interactionresult1;
        } else {
                System.out.println("NARF!");
            return interactionresult;

        }
        }
    }
}
