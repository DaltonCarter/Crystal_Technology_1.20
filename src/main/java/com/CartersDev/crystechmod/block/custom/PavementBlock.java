package com.CartersDev.crystechmod.block.custom;

import com.CartersDev.crystechmod.block.entity.alloykiln.AlloyKilnBlockEntity;
import com.CartersDev.crystechmod.block.entity.alloykiln.AlythumAlloyKilnBlockEntity;
import com.CartersDev.crystechmod.block.entity.alloykiln.CrystalCoreAlloyKilnBlockEntity;
import com.CartersDev.crystechmod.block.entity.alloykiln.VitricAlloyKilnBlockEntity;
import com.CartersDev.crystechmod.item.custom.Curios.FireHeart;
import com.CartersDev.crystechmod.util.ModBlockstateProperties;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.AttributeInstance;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import org.jetbrains.annotations.Nullable;

import java.util.List;

/*
 Travel Speed Multiplier lvls:
 1 = x1.25
 2 = x1.5
 3 = x1.75
 4 = x2

 */

public class PavementBlock extends Block {

    public static IntegerProperty TRAVEL_SPEED_LEVEL = ModBlockstateProperties.TRAVEL_SPEED_MULTIPLIER;

    public PavementBlock(int travelSpeed, Properties pProperties) {
        super(pProperties);
        this.registerDefaultState(this.defaultBlockState().setValue(TRAVEL_SPEED_LEVEL, travelSpeed));
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> pBuilder) {
        pBuilder.add(TRAVEL_SPEED_LEVEL);
    }


    @Override
    public void stepOn(Level pLevel, BlockPos pPos, BlockState pState, Entity pEntity) {

        if(pEntity instanceof LivingEntity livingEntity) {
            AttributeInstance attributeinstance = livingEntity.getAttribute(Attributes.MOVEMENT_SPEED);

            int lvl = pState.getValue(TRAVEL_SPEED_LEVEL);

            if(lvl == 4) {
                attributeinstance.addTransientModifier(new AttributeModifier("Travel Speed Boost", attributeinstance.getValue() * 2, AttributeModifier.Operation.ADDITION));
            } else if (lvl == 3) {
                attributeinstance.addTransientModifier(new AttributeModifier("Travel Speed Boost", attributeinstance.getValue() * 1.75, AttributeModifier.Operation.ADDITION));
            } else if (lvl == 2) {
                attributeinstance.addTransientModifier(new AttributeModifier("Travel Speed Boost", attributeinstance.getValue() * 1.5, AttributeModifier.Operation.ADDITION));
            }else {
                attributeinstance.addTransientModifier(new AttributeModifier("Travel Speed Boost", attributeinstance.getValue() * 1.25, AttributeModifier.Operation.ADDITION));
            }

        }

        super.stepOn(pLevel, pPos, pState, pEntity);
    }

    @Override
    public void appendHoverText(ItemStack pStack, @Nullable BlockGetter pLevel, List<Component> pTooltip, TooltipFlag pFlag) {

        pTooltip.add(Component.literal("Increases your movement speed dwhen walked on."));
        super.appendHoverText(pStack, pLevel, pTooltip, pFlag);
    }

    //    protected void tryAddSoulSpeed() {
//        if (!this.getBlockStateOnLegacy().isAir()) {
//            int i = EnchantmentHelper.getEnchantmentLevel(Enchantments.SOUL_SPEED, this);
//            if (i > 0 && this.onSoulSpeedBlock()) {
//                AttributeInstance attributeinstance = this.getAttribute(Attributes.MOVEMENT_SPEED);
//                if (attributeinstance == null) {
//                    return;
//                }
//
//                attributeinstance.addTransientModifier(new AttributeModifier(SPEED_MODIFIER_SOUL_SPEED_UUID, "Soul speed boost", (double)(0.03F * (1.0F + (float)i * 0.35F)), AttributeModifier.Operation.ADDITION));
//                if (this.getRandom().nextFloat() < 0.04F) {
//                    ItemStack itemstack = this.getItemBySlot(EquipmentSlot.FEET);
//                    itemstack.hurtAndBreak(1, this, (p_21301_) -> {
//                        p_21301_.broadcastBreakEvent(EquipmentSlot.FEET);
//                    });
//                }
//            }
//        }
//
//    }
}
