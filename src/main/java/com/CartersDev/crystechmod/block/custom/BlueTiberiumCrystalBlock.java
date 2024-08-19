package com.CartersDev.crystechmod.block.custom;


import com.CartersDev.crystechmod.item.ModItems;
import net.minecraft.core.BlockPos;
import net.minecraft.world.Difficulty;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Explosion;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.CropBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.minecraftforge.event.level.ExplosionEvent;

public class BlueTiberiumCrystalBlock extends CropBlock {
    public static final int MAX_AGE = 7;
    public static final IntegerProperty AGE = BlockStateProperties.AGE_7;
    private static final VoxelShape[] SHAPE_BY_AGE = new VoxelShape[]{

            Block.box(0.0D, 0.0D, 0.0D, 16.0D, 2.0D, 16.0D),
            Block.box(0.0D, 0.0D, 0.0D, 16.0D, 4.0D, 16.0D),
            Block.box(0.0D, 0.0D, 0.0D, 16.0D, 6.0D, 16.0D),
            Block.box(0.0D, 0.0D, 0.0D, 16.0D, 8.0D, 16.0D),
            Block.box(0.0D, 0.0D, 0.0D, 16.0D, 10.0D, 16.0D),
            Block.box(0.0D, 0.0D, 0.0D, 16.0D, 12.0D, 16.0D),
            Block.box(0.0D, 0.0D, 0.0D, 16.0D, 14.0D, 16.0D),
            Block.box(0.0D, 0.0D, 0.0D, 16.0D, 16.0D, 16.0D)};

    public BlueTiberiumCrystalBlock(Properties properties) {
        super(properties);

    }

    @Override
    public IntegerProperty getAgeProperty() {
        return AGE;
    }

    @Override
    public int getMaxAge() {
        return MAX_AGE;
    }


    @Override
    protected ItemLike getBaseSeedId() {
        return ModItems.BLUE_TIBERIUM_DUST.get();
    }


    @Override
    public void stepOn(Level pLevel, BlockPos pPos, BlockState pState, Entity pEntity) {
        if(!pLevel.isClientSide() && pLevel.getDifficulty() != Difficulty.PEACEFUL) {
            LivingEntity target = (LivingEntity) pEntity;
            target.addEffect(new MobEffectInstance(MobEffects.POISON, 160));
        }
        super.stepOn(pLevel, pPos, pState, pEntity);
    }


//    @Override
//    public boolean onDestroyedByPlayer(BlockState state, Level level, BlockPos pos, Player player, boolean willHarvest, FluidState fluid) {
//
//        String Enchantments = EnchantmentHelper.getEnchantments(player.getMainHandItem()).toString();
//
//        if (willHarvest) {
//            if (!Enchantments.contains("net.minecraft.enchantment.SilkTouchEnchantment") && !player.isCreative()) {
//                level.explode(null, pos.getX(), pos.getY(), pos.getZ()
//                        , 4w.0f, Level.ExplosionInteraction.TNT);
//            }
//        }
//
//        return super.onDestroyedByPlayer(state, level, pos, player, willHarvest, fluid);
//
//
//    }
//
//    @Override
//    public boolean canDropFromExplosion(BlockState state, BlockGetter level, BlockPos pos, Explosion explosion) {
//        return true;
//    }
//
//    @Override
//    public void onBlockExploded(BlockState state, Level level, BlockPos pos, Explosion explosion) {
//        level.explode(null, pos.getX(), pos.getY(), pos.getZ(), 4.0f, Level.ExplosionInteraction.BLOCK);
//        super.onBlockExploded(state, level, pos, explosion);
//    }


}
