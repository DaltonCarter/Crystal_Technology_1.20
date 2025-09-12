package com.CartersDev.crystechmod.block.entity.portal;

import com.CartersDev.crystechmod.block.entity.ModBlockEntities;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;

public class VitricPortalBlockEntity extends BlockEntity {
    protected VitricPortalBlockEntity(BlockEntityType<?> pType, BlockPos pPos, BlockState pBlockState) {
        super(pType, pPos, pBlockState);
    }

    public VitricPortalBlockEntity(BlockPos pPos, BlockState pBlockState) {
        this(ModBlockEntities.VITRIC_PORTAL_BE.get(), pPos, pBlockState);
    }

    public boolean shouldRenderFace(Direction pFace) {
        return pFace.getAxis() == Direction.Axis.X || pFace.getAxis() == Direction.Axis.Z;
    }
}
