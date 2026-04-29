package com.CartersDev.crystechmod.enchantment;

import com.CartersDev.crystechmod.item.custom.Weapons.Bows.ThermalEnergyBow;
import com.CartersDev.crystechmod.item.custom.Weapons.LargeSword;
import net.minecraft.world.item.enchantment.EnchantmentCategory;

public class CTechEnchantCatagory {

   public static final EnchantmentCategory LASER_CROSSBOW =
            EnchantmentCategory.create("laser_crossbow", (item) -> item instanceof ThermalEnergyBow);

   public static final EnchantmentCategory LARGE_SWORD =
           EnchantmentCategory.create("large_sword", (item) -> item instanceof LargeSword);
}
