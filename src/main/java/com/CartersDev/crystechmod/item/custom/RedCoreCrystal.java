package com.CartersDev.crystechmod.item.custom;

import com.CartersDev.crystechmod.block.ModBlocks;
import com.CartersDev.crystechmod.block.custom.VitricTransporterBlock;
import net.minecraft.client.gui.screens.DirectJoinServerScreen;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.util.datafix.fixes.ChunkPalettedStorageFix;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.EndPortalFrameBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.pattern.BlockPattern;

public class RedCoreCrystal extends Item {

    public RedCoreCrystal(Properties pProperties) {
        super(pProperties);
    }

    public InteractionResult useOn(UseOnContext pContext) {
        Level level = pContext.getLevel();
        BlockPos blockpos = pContext.getClickedPos();
        BlockState blockstate = level.getBlockState(blockpos);
        Direction direction = pContext.getHorizontalDirection();



        if (blockstate.is(ModBlocks.VITRIC_TRANSPORTER.get()) && !blockstate.getValue(VitricTransporterBlock.CORE) ||
                blockstate.is(ModBlocks.VITRIC_TRANSPORTER_SIDE1.get()) && !blockstate.getValue(VitricTransporterBlock.CORE) ||
                blockstate.is(ModBlocks.VITRIC_TRANSPORTER_SIDE2.get()) && !blockstate.getValue(VitricTransporterBlock.CORE)) {

            if (level.isClientSide) {
                return InteractionResult.SUCCESS;
            } else {

                BlockState blockstate1 = blockstate.setValue(VitricTransporterBlock.CORE, Boolean.valueOf(true));
                Block.pushEntitiesUp(blockstate, blockstate1, level, blockpos);
                level.setBlock(blockpos, blockstate1, 2);
                level.updateNeighbourForOutputSignal(blockpos, ModBlocks.VITRIC_TRANSPORTER.get());
                level.updateNeighbourForOutputSignal(blockpos, ModBlocks.VITRIC_TRANSPORTER_SIDE1.get());
                level.updateNeighbourForOutputSignal(blockpos, ModBlocks.VITRIC_TRANSPORTER_SIDE2.get());
                pContext.getItemInHand().shrink(1);
                level.levelEvent(1503, blockpos, 0);
                BlockPattern.BlockPatternMatch blockpattern$blockpatternmatch = VitricTransporterBlock.getOrCreatePortalShape().find(level, blockpos);
                if (blockpattern$blockpatternmatch != null) {
                    BlockPos blockpos1 = blockpattern$blockpatternmatch.getFrontTopLeft().offset(0, -1, -3);
                    BlockPos blockpos2 = blockpattern$blockpatternmatch.getFrontTopLeft().offset(0, -1, 1);

                    BlockPos blockpos3 = blockpattern$blockpatternmatch.getFrontTopLeft().offset(-3, -1, 0);
                    BlockPos blockpos4 = blockpattern$blockpatternmatch.getFrontTopLeft().offset(1, -1, 0);

                    if(direction == Direction.WEST) {
                        for (int i = 0; i < 1; ++i) {
                            for (int j = 0; j < 3; ++j) {
                                level.setBlock(blockpos1.offset(i, 0, j), ModBlocks.VITRIC_PORTAL.get().defaultBlockState(), 2);
                                level.setBlock(blockpos1.offset(i, -1, j), ModBlocks.VITRIC_PORTAL.get().defaultBlockState(), 2);
                                level.setBlock(blockpos1.offset(i, -2, j), ModBlocks.VITRIC_PORTAL.get().defaultBlockState(), 2);
                            }
                        }

                        level.globalLevelEvent(1038, blockpos1.offset(1, 0, 1), 0);

                    } else if (direction == Direction.EAST) {
                        for (int i = 0; i < 1; ++i) {
                            for (int j = 0; j < 3; ++j) {
                                level.setBlock(blockpos2.offset(i, 0, j), ModBlocks.VITRIC_PORTAL.get().defaultBlockState(), 2);
                                level.setBlock(blockpos2.offset(i, -1, j), ModBlocks.VITRIC_PORTAL.get().defaultBlockState(), 2);
                                level.setBlock(blockpos2.offset(i, -2, j), ModBlocks.VITRIC_PORTAL.get().defaultBlockState(), 2);
                            }
                        }

                        level.globalLevelEvent(1038, blockpos2.offset(1, 0, 1), 0);

                    }else if (direction == Direction.SOUTH) {
                        for (int i = 0; i < 3; ++i) {
                            for (int j = 0; j < 1; ++j) {
                                level.setBlock(blockpos3.offset(i, 0, j), ModBlocks.VITRIC_PORTAL.get().defaultBlockState(), 2);
                                level.setBlock(blockpos3.offset(i, -1, j), ModBlocks.VITRIC_PORTAL.get().defaultBlockState(), 2);
                                level.setBlock(blockpos3.offset(i, -2, j), ModBlocks.VITRIC_PORTAL.get().defaultBlockState(), 2);
                            }
                        }

                        level.globalLevelEvent(1038, blockpos2.offset(1, 0, 1), 0);

                    }else if (direction == Direction.NORTH) {
                        for (int i = 0; i < 3; ++i) {
                            for (int j = 0; j < 1; ++j) {
                                level.setBlock(blockpos4.offset(i, 0, j), ModBlocks.VITRIC_PORTAL.get().defaultBlockState(), 2);
                                level.setBlock(blockpos4.offset(i, -1, j), ModBlocks.VITRIC_PORTAL.get().defaultBlockState(), 2);
                                level.setBlock(blockpos4.offset(i, -2, j), ModBlocks.VITRIC_PORTAL.get().defaultBlockState(), 2);
                            }
                        }

                        level.globalLevelEvent(1038, blockpos2.offset(1, 0, 1), 0);
                    }
                }

                return InteractionResult.CONSUME;
            }
        } else {
            return InteractionResult.PASS;
        }
    }
}
