package com.CartersDev.crystechmod.block.custom;


import com.CartersDev.crystechmod.item.ModItems;
import com.CartersDev.crystechmod.util.ModTags;
import net.minecraft.core.BlockPos;
import net.minecraft.world.Difficulty;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.level.*;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.CropBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.phys.shapes.CollisionContext;
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
    public VoxelShape getShape(BlockState pState, BlockGetter pLevel, BlockPos pPos, CollisionContext pContext) {
        return SHAPE_BY_AGE[this.getAge(pState)];
    }


    @Override
    public boolean canSurvive(BlockState pState, LevelReader pLevel, BlockPos pPos) {
        BlockPos blockpos = pPos.below();
        BlockState blockstate = pLevel.getBlockState(blockpos);
        if (blockstate.is(ModTags.Blocks.TIBERIUM_SOIL)) {
            return true;
        } else {
            return pLevel.getRawBrightness(pPos, 0) <= 15 && blockstate.canSustainPlant(pLevel, blockpos, net.minecraft.core.Direction.UP, this);
        }
    }

    @Override
    protected ItemLike getBaseSeedId() {
        return ModItems.BLUE_TIBERIUM_DUST.get();
    }


    @Override
    public void entityInside(BlockState pState, Level pLevel, BlockPos pPos, Entity pEntity) {
        if (!pLevel.isClientSide && pLevel.getDifficulty() != Difficulty.PEACEFUL) {
            if (pEntity instanceof LivingEntity) {
                LivingEntity livingentity = (LivingEntity)pEntity;
                if (!livingentity.isInvulnerableTo(pLevel.damageSources().wither())) {
                    livingentity.addEffect(new MobEffectInstance(MobEffects.POISON, 160));
                }
            }

        }
    }

    @Override
    public void playerWillDestroy(Level pLevel, BlockPos pPos, BlockState pState, Player pPlayer) {
        super.playerWillDestroy(pLevel, pPos, pState, pPlayer);

        String Enchantments = EnchantmentHelper.getEnchantments(pPlayer.getMainHandItem()).toString();

        System.out.println(Enchantments);

        if (!pLevel.isClientSide() && !Enchantments.contains("net.minecraft.world.item.enchantment.UntouchingEnchantment") && !pPlayer.isCreative()) {
            float f = 4.0F;
            pLevel.explode(null, pPos.getX(), pPos.getY(), pPos.getZ(), 4.0F, Level.ExplosionInteraction.TNT);
        }

    }


    @Override
    public boolean canDropFromExplosion(BlockState state, BlockGetter level, BlockPos pos, Explosion explosion) {
        return true;
    }

    @Override
    public void wasExploded(Level pLevel, BlockPos pPos, Explosion pExplosion) {
        if (!pLevel.isClientSide()) {
            float f = 4.0F;
            pLevel.explode(null, pPos.getX(), pPos.getY(), pPos.getZ(), 2.0F, Level.ExplosionInteraction.TNT);
        }
        super.wasExploded(pLevel, pPos, pExplosion);
    }
}
