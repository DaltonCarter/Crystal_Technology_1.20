package com.CartersDev.crystechmod.block.custom;

import com.CartersDev.crystechmod.fluid.ModFluids;
import com.CartersDev.crystechmod.particle.ModParticles;
import com.CartersDev.crystechmod.util.RelativeSide;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.util.RandomSource;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SimpleWaterloggedBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition.Builder;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import javax.annotation.Nullable;
import java.util.EnumMap;
import java.util.Map;

import static java.awt.ComponentOrientation.getOrientation;

public class CrystalFixtureBlock extends Block implements SimpleWaterloggedBlock {

    // Cache VoxelShapes for each facing
    private static final Map<Direction, VoxelShape> SHAPES;

    static {
        SHAPES = new EnumMap<>(Direction.class);

        for (Direction facing : Direction.values()) {
            final double xOff = -0.3 * facing.getStepX();
            final double yOff = -0.1 * facing.getStepY();
            final double zOff = -0.3 * facing.getStepZ();
            VoxelShape shape = Shapes
                    .create(new AABB(xOff + 0.1, yOff + 0.1, zOff + 0.1, xOff + 0.9, yOff + 1.0, zOff + 0.9));
            SHAPES.put(facing, shape);
        }
    }

    public static final DirectionProperty FACING = BlockStateProperties.FACING;

    public static final BooleanProperty WATERLOGGED = BlockStateProperties.WATERLOGGED;

    protected final String particleTexture;

    public CrystalFixtureBlock(Properties pProperties, String particleTexture) {
        super(pProperties);
        this.particleTexture = particleTexture;

        this.registerDefaultState(
                defaultBlockState().setValue(FACING, Direction.DOWN).setValue(WATERLOGGED, false));
    }

    @Override
    protected void createBlockStateDefinition(Builder<Block, BlockState> builder) {
        builder.add(FACING, WATERLOGGED);
    }

    @Override
    @Nullable
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        BlockState state = super.getStateForPlacement(context);
        BlockPos pos = context.getClickedPos();
        FluidState fluidState = context.getLevel().getFluidState(pos);

        state = state.setValue(WATERLOGGED, fluidState.getType() == Fluids.WATER || fluidState.getType() == ModFluids.SOURCE_TIBERIUM_WATER.get());

        var levelReader = context.getLevel();
        var adirection = context.getNearestLookingDirections();

        for (var direction : adirection) {
            var placedState = state.setValue(FACING, direction.getOpposite());
            if (canSurvive(placedState, levelReader, pos)) {
                return placedState;
            }
        }

        return null;
    }

    @Override
    public BlockState updateShape(BlockState state, Direction direction, BlockState facingState, LevelAccessor level,
                                  BlockPos currentPos, BlockPos facingPos) {
        if (state.getValue(WATERLOGGED).booleanValue()) {
            level.scheduleTick(currentPos, Fluids.WATER, Fluids.WATER.getTickDelay(level));
        }

        if (direction.getOpposite() == state.getValue(FACING) && !state.canSurvive(level, currentPos)) {
            return Blocks.AIR.defaultBlockState();
        }

        return state;
    }

    @Override
    public VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
        Direction facing = state.getValue(FACING);
        return SHAPES.get(facing);
    }

    @Override
    @OnlyIn(Dist.CLIENT)
    public void animateTick(BlockState state, Level level, BlockPos pos, RandomSource r) {



        if(state.getValue(FACING) == Direction.DOWN) {
            double d0 = (double)pos.getX() + 0.5D;
            double d1 = (double)pos.getY() + 0.0D;
            double d2 = (double)pos.getZ() + 0.5D;

            switch (this.particleTexture) {
                case "green":
                    level.addParticle(ModParticles.RIPARIUS_PARTICLES.get(), d0,
                            d1 , d2,
                            0d, -0.05d, 0d);
                    break;

                case "blue":
                    level.addParticle(ModParticles.VINIFERA_PARTICLES.get(), d0,
                            d1 , d2,
                            0d, -0.05d, 0d);
                    break;

                case "red":
                    level.addParticle(ModParticles.CRUENTUS_PARTICLES.get(), d0,
                            d1 , d2,
                            0d, -0.05d, 0d);
                    break;

                case "purple":
                    level.addParticle(ModParticles.ABOREUS_PARTICLES.get(), d0,
                            d1, d2,
                            0d, -0.05d, 0d);
                    break;

                default: break;
            }

        } else {
            double d0 = (double) pos.getX();
            double d1 = (double) pos.getY();
            double d2 = (double) pos.getZ();

            switch (this.particleTexture) {
                case "green":
                    level.addParticle(ModParticles.RIPARIUS_PARTICLES.get(), d0 + r.nextDouble(),
                            d1 + 0.7D, d2 + r.nextDouble(),
                            0d, 0.05d, 0d);
                    break;

                case "blue":
                    level.addParticle(ModParticles.VINIFERA_PARTICLES.get(), d0 + r.nextDouble(),
                            d1 + 0.7D, d2 + r.nextDouble(),
                            0d, 0.05d, 0d);
                    break;

                case "red":
                    level.addParticle(ModParticles.CRUENTUS_PARTICLES.get(), d0 + r.nextDouble(),
                            d1 + 0.7D, d2 + r.nextDouble(),
                            0d, 0.05d, 0d);
                    break;

                case "purple":
                    level.addParticle(ModParticles.ABOREUS_PARTICLES.get(), d0 + r.nextDouble(),
                            d1 + 0.7D, d2 + r.nextDouble(),
                            0d, 0.05d, 0d);
                    break;

                default:
                    break;
            }
        }


    }

    @Override
    public boolean canSurvive(BlockState state, LevelReader level, BlockPos pos) {
        var facing = state.getValue(FACING);
        var blockPos = pos.relative(facing.getOpposite());
        return canSupportCenter(level, blockPos, facing);
    }

    @Override
    public FluidState getFluidState(BlockState blockState) {
        return blockState.getValue(WATERLOGGED).booleanValue()
                ? Fluids.WATER.getSource(false)
                : super.getFluidState(blockState);
    }






}
