package com.CartersDev.crystechmod.enchantment;

import com.CartersDev.crystechmod.item.custom.Weapons.Bows.ThermalEnergyBow;
import net.minecraft.world.item.enchantment.EnchantmentCategory;

public class CTechEnchantCatagory {

   public static final EnchantmentCategory LASER_CROSSBOW =
            EnchantmentCategory.create("laser_crossbow", (item) -> item instanceof ThermalEnergyBow);
}
