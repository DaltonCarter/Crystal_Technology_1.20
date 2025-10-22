package com.CartersDev.crystechmod.item.custom.Medicine;

import com.CartersDev.crystechmod.effect.ModEffects;
import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.gameevent.GameEvent;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class CompleteVaccineItem extends Item {
    public CompleteVaccineItem(Properties pProperties) {
        super(pProperties);
    }

    public ItemStack finishUsingItem(ItemStack pStack, Level pLevel, LivingEntity pEntityLiving) {
        Player player = pEntityLiving instanceof Player ? (Player) pEntityLiving : null;
        if (player instanceof ServerPlayer) {
            CriteriaTriggers.CONSUME_ITEM.trigger((ServerPlayer) player, pStack);
        }

        if (!pLevel.isClientSide) {
            if(pEntityLiving.hasEffect(ModEffects.INITIAL_VITRICIUM_INFECTION_EFFECT.get()) || pEntityLiving.hasEffect(ModEffects.SERIOUS_VITRICIUM_INFECTION_EFFECT.get())
            || pEntityLiving.hasEffect(ModEffects.CRITICAL_VITRICIUM_INFECTION_EFFECT.get()) || pEntityLiving.hasEffect(ModEffects.TERMINAL_VITRICIUM_INFECTION_EFFECT.get())) {

                pEntityLiving.removeEffect(ModEffects.INITIAL_VITRICIUM_INFECTION_EFFECT.get());
                pEntityLiving.removeEffect(ModEffects.SERIOUS_VITRICIUM_INFECTION_EFFECT.get());
                pEntityLiving.removeEffect(ModEffects.CRITICAL_VITRICIUM_INFECTION_EFFECT.get());
                pEntityLiving.removeEffect(ModEffects.TERMINAL_VITRICIUM_INFECTION_EFFECT.get());

            }
        }

        if (player != null) {
            player.awardStat(Stats.ITEM_USED.get(this));
            if (!player.getAbilities().instabuild) {
                pStack.shrink(1);
            }
        }

        pEntityLiving.gameEvent(GameEvent.DRINK);
        return pStack;
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level pLevel, Player pPlayer, InteractionHand pHand) {
        return ItemUtils.startUsingInstantly(pLevel, pPlayer, pHand);
    }

    @Override
    public boolean isFoil(ItemStack pStack) {
        return true;
    }

    @Override
    public int getUseDuration(ItemStack pStack) {
        return 32;
    }

    @Override
    public UseAnim getUseAnimation(ItemStack pStack) {
        return UseAnim.DRINK;
    }

    @Override
    public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> pTooltipComponents, TooltipFlag pIsAdvanced) {
        Component.literal("Cures Vitricium Infection.");

    }

}
