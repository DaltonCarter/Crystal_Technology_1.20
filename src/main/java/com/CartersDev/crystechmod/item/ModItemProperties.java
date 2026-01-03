package com.CartersDev.crystechmod.item;

import net.minecraft.client.renderer.item.ItemProperties;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;

public class ModItemProperties {


    public static void addCustomItemProperties() {
        makeBow(ModItems.PLAGUED_BOW.get());
        makeBow(ModItems.BEAM_CASTER.get());
    }



    private static void makeBow(Item item){
        ItemProperties.register(item, new ResourceLocation("pull"), (pItem, pLevel, pEntity, number) -> {
            if (pEntity == null) {
                return 0.0F;
            } else {
                return pEntity.getUseItem() != pItem ? 0.0F : (float)(pItem.getUseDuration() - pEntity.getUseItemRemainingTicks()) / 20.0F;
            }
        });

        ItemProperties.register(item, new ResourceLocation("pulling"), (stack, level, livingentity, number) -> {
            return livingentity != null && livingentity.isUsingItem() && livingentity.getUseItem() == stack ? 1.0F : 0.0F;
        });
    }
}
