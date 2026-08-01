package com.CartersDev.crystechmod.item.CustomProperties;

import com.CartersDev.crystechmod.CrystalTech;
import com.CartersDev.crystechmod.item.ModItems;
import net.minecraft.client.renderer.item.ItemProperties;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.common.capabilities.ForgeCapabilities;

public class ModPowerCellProperties {

    public static void registerBatteryProperties() {

        ItemProperties.register(ModItems.POWER_CELL.get(), new ResourceLocation(CrystalTech.MOD_ID, "energy_level"),
                (itemStack, level, livingEntity, seed) -> {
                    return itemStack.getCapability(ForgeCapabilities.ENERGY).map(energy -> {
                        if (energy.getMaxEnergyStored() <= 0) return 0.0f;
                        float ratio = (float) energy.getEnergyStored() / (float) energy.getMaxEnergyStored();
                        return Math.max(0.0f, Math.min(1.0f, ratio));
                    }).orElse(0.0f);
                }
        );


        ItemProperties.register(ModItems.IMPROVED_POWER_CELL.get(), new ResourceLocation(CrystalTech.MOD_ID, "energy_level"),
                (itemStack, level, livingEntity, seed) -> {
                    return itemStack.getCapability(ForgeCapabilities.ENERGY).map(energy -> {
                        if (energy.getMaxEnergyStored() <= 0) return 0.0f;
                        float ratio = (float) energy.getEnergyStored() / (float) energy.getMaxEnergyStored();
                        return Math.max(0.0f, Math.min(1.0f, ratio));
                    }).orElse(0.0f);
                }
        );

        ItemProperties.register(ModItems.ADVANCED_POWER_CELL.get(), new ResourceLocation(CrystalTech.MOD_ID, "energy_level"),
                (itemStack, level, livingEntity, seed) -> {
                    return itemStack.getCapability(ForgeCapabilities.ENERGY).map(energy -> {
                        if (energy.getMaxEnergyStored() <= 0) return 0.0f;
                        float ratio = (float) energy.getEnergyStored() / (float) energy.getMaxEnergyStored();
                        return Math.max(0.0f, Math.min(1.0f, ratio));
                    }).orElse(0.0f);
                }
        );

        ItemProperties.register(ModItems.ULTIMATE_POWER_CELL.get(), new ResourceLocation(CrystalTech.MOD_ID, "energy_level"),
                (itemStack, level, livingEntity, seed) -> {
                    return itemStack.getCapability(ForgeCapabilities.ENERGY).map(energy -> {
                        if (energy.getMaxEnergyStored() <= 0) return 0.0f;
                        float ratio = (float) energy.getEnergyStored() / (float) energy.getMaxEnergyStored();
                        return Math.max(0.0f, Math.min(1.0f, ratio));
                    }).orElse(0.0f);
                }
        );
    }
}
