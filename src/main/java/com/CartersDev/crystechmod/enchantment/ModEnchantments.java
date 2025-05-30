package com.CartersDev.crystechmod.enchantment;

import com.CartersDev.crystechmod.CrystalTech;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentCategory;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModEnchantments {

    public static final DeferredRegister<Enchantment> ENCHANTMENTS =
            DeferredRegister.create(ForgeRegistries.ENCHANTMENTS, CrystalTech.MOD_ID);


public static RegistryObject<Enchantment> LIGHTNING_STRIKER =
        ENCHANTMENTS.register("lightning_striker", () ->
                new LightningStrikerEnchantment(Enchantment.Rarity.UNCOMMON, EnchantmentCategory.WEAPON,
                        EquipmentSlot.MAINHAND));

    public static RegistryObject<Enchantment> VITRIC_HARVESTER =
            ENCHANTMENTS.register("vitric_harvester", () ->
                    new VitricHarvesterEnchantment(Enchantment.Rarity.VERY_RARE, EnchantmentCategory.DIGGER,
                            EquipmentSlot.MAINHAND));


    public static void register(IEventBus eventBus) {
        ENCHANTMENTS.register(eventBus);
    }

}
