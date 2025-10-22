package com.CartersDev.crystechmod.item.custom.Medicine;

import com.CartersDev.crystechmod.effect.ModEffects;
import com.CartersDev.crystechmod.item.ModItems;
import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.gameevent.GameEvent;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class AdvMedKitItem extends Item {
    public AdvMedKitItem(Properties pProperties) {
        super(pProperties);
    }

    public ItemStack finishUsingItem(ItemStack pStack, Level pLevel, LivingEntity pEntityLiving) {
        Player player = pEntityLiving instanceof Player ? (Player) pEntityLiving : null;
        if (player instanceof ServerPlayer) {
            CriteriaTriggers.CONSUME_ITEM.trigger((ServerPlayer) player, pStack);
        }

        if (!pLevel.isClientSide) {
            if(player.getHealth() < player.getMaxHealth()) {
                player.setHealth(player.getMaxHealth());
                player.getCooldowns().addCooldown(ModItems.ADV_MED_KIT.get(), 100);
            }

            if(player.hasEffect(MobEffects.POISON)) {
                player.removeEffect(MobEffects.POISON);
            }

            if(player.hasEffect(MobEffects.WITHER)) {
                player.removeEffect(MobEffects.WITHER);
            }

            if(player.hasEffect(ModEffects.INITIAL_VITRICIUM_INFECTION_EFFECT.get())) {
                player.removeEffect(ModEffects.INITIAL_VITRICIUM_INFECTION_EFFECT.get());
            }

            if(player.hasEffect(ModEffects.SERIOUS_VITRICIUM_INFECTION_EFFECT.get())) {
                player.removeEffect(ModEffects.SERIOUS_VITRICIUM_INFECTION_EFFECT.get());
            }

            if(player.hasEffect(ModEffects.CRITICAL_VITRICIUM_INFECTION_EFFECT.get())) {
                player.removeEffect(ModEffects.CRITICAL_VITRICIUM_INFECTION_EFFECT.get());
            }

            if(player.hasEffect(ModEffects.TERMINAL_VITRICIUM_INFECTION_EFFECT.get())) {
                player.removeEffect(ModEffects.TERMINAL_VITRICIUM_INFECTION_EFFECT.get());
            }


        }

        if (player != null) {
            player.awardStat(Stats.ITEM_USED.get(this));
            if (!player.getAbilities().instabuild) {
                pStack.shrink(1);
            }
        }

        pEntityLiving.gameEvent(GameEvent.EAT);
        return pStack;
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level pLevel, Player pPlayer, InteractionHand pHand) {
        return ItemUtils.startUsingInstantly(pLevel, pPlayer, pHand);
    }


    @Override
    public int getUseDuration(ItemStack pStack) {
        return 32;
    }

    @Override
    public UseAnim getUseAnimation(ItemStack pStack) {
        return UseAnim.BOW;
    }

    @Override
    public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> pTooltipComponents, TooltipFlag pIsAdvanced) {
        Component.literal("Full Heal, Cures Poison, Wither, and Vitricium Infection. 5s Cooldown.");

    }


    @Override
    public boolean isFoil(ItemStack pStack) {
        return true;
    }

}
