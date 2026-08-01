package com.CartersDev.crystechmod.item.CustomProperties;

import com.CartersDev.crystechmod.item.ModItems;
import com.CartersDev.crystechmod.item.custom.Weapons.Bows.ThermalEnergyBow;
import net.minecraft.client.renderer.item.ItemProperties;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;


public class ModItemProperties {


    public static void addCustomItemProperties() {
        makeBow(ModItems.PLAGUED_BOW.get());
        makeCrossbow(ModItems.BEAM_CASTER.get());
        makeLargeSword(ModItems.ILLYRIM_SWORD.get());
        makeLargeSword(ModItems.MK1_CORE_STEEL_SWORD.get());
        makeLargeSword(ModItems.MK2_CORE_STEEL_SWORD.get());
        makeLargeSword(ModItems.MK3_CORE_STEEL_SWORD.get());
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

    private static void makeCrossbow(Item item){
        ItemProperties.register(item, new ResourceLocation("pull"), (stack, level, entity, number) -> {
            if (entity == null) {
                return 0.0F;
            } else {
                return ThermalEnergyBow.isCharged(stack) ? 0.0F : (float)(stack.getUseDuration() - entity.getUseItemRemainingTicks()) / (float)ThermalEnergyBow.getChargeDuration(stack);
            }
        });
        
        ItemProperties.register(item, new ResourceLocation("pulling"), (stack, level, entity, number) -> {
            return entity != null && entity.isUsingItem() && entity.getUseItem() == stack && !ThermalEnergyBow.isCharged(stack) ? 1.0F : 0.0F;
        });
        
        ItemProperties.register(item, new ResourceLocation("charged"), (stack, level, entity, number) -> {
            return ThermalEnergyBow.isCharged(stack) ? 1.0F : 0.0F;
        });
        
        ItemProperties. register(item, new ResourceLocation("loaded_focus"), (stack, level, entity, number) -> {
            return ThermalEnergyBow.isCharged(stack) && ThermalEnergyBow.isOverchargedOrProtoculture(stack) ? 1.0F : 0.0F;
        });
    }
    
    private static void makeLargeSword(Item item){
        ItemProperties.register(item, new ResourceLocation("blocking"), (stack, level, entity, number) -> {
            return entity != null && entity.isUsingItem() && entity.getUseItem() == stack ? 1.0F : 0.0F;
        });
    }

    


}
