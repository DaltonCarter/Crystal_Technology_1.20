package com.CartersDev.crystechmod.enchantment;

import com.CartersDev.crystechmod.CrystalTech;
import com.CartersDev.crystechmod.enchantment.BeamCaster.BeamIntensityEnchantment;
import com.CartersDev.crystechmod.enchantment.BeamCaster.EfficientCellsEnchantment;
import com.CartersDev.crystechmod.enchantment.BeamCaster.SearingLaserEnchantment;
import com.CartersDev.crystechmod.enchantment.BeamCaster.VolatileLaserEnchantment;
import com.CartersDev.crystechmod.enchantment.LargeSword.MortalStrikeEnchantment;
import com.CartersDev.crystechmod.enchantment.LargeSword.PowerStrikeEnchantment;
import com.CartersDev.crystechmod.enchantment.Vanilla.VitricHarvesterEnchantment;
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

//Large Sword Enchants:
public static RegistryObject<Enchantment> POWER_STRIKE =
        ENCHANTMENTS.register("power_strike", () ->
                new PowerStrikeEnchantment(Enchantment.Rarity.COMMON, CTechEnchantCatagory.LARGE_SWORD,
                        EquipmentSlot.MAINHAND));

    public static RegistryObject<Enchantment> MORTAL_STRIKE =
            ENCHANTMENTS.register("mortal_strike", () ->
                    new MortalStrikeEnchantment(Enchantment.Rarity.VERY_RARE, CTechEnchantCatagory.LARGE_SWORD,
                            EquipmentSlot.MAINHAND));



    //Beam Caster Enchants:
    public static RegistryObject<Enchantment> EFFICIENT_CELLS =
            ENCHANTMENTS.register("efficient_cells", () ->
                    new EfficientCellsEnchantment(Enchantment.Rarity.UNCOMMON, CTechEnchantCatagory.LASER_CROSSBOW,
                            EquipmentSlot.MAINHAND));

    public static RegistryObject<Enchantment> BEAM_INTENSITY =
            ENCHANTMENTS.register("beam_intensity", () ->
                    new BeamIntensityEnchantment(Enchantment.Rarity.COMMON, CTechEnchantCatagory.LASER_CROSSBOW,
                            EquipmentSlot.MAINHAND));

    public static RegistryObject<Enchantment> SEARING_LASER =
            ENCHANTMENTS.register("searing_laser", () ->
                    new SearingLaserEnchantment(Enchantment.Rarity.RARE, CTechEnchantCatagory.LASER_CROSSBOW,
                            EquipmentSlot.MAINHAND));

    public static RegistryObject<Enchantment> VOLATILE_LASER =
            ENCHANTMENTS.register("volatile_laser", () ->
                    new VolatileLaserEnchantment(Enchantment.Rarity.RARE, CTechEnchantCatagory.LASER_CROSSBOW,
                            EquipmentSlot.MAINHAND));


//Digging Enchants:
    public static RegistryObject<Enchantment> VITRIC_HARVESTER =
            ENCHANTMENTS.register("vitric_harvester", () ->
                    new VitricHarvesterEnchantment(Enchantment.Rarity.VERY_RARE, EnchantmentCategory.DIGGER,
                            EquipmentSlot.MAINHAND));


    public static void register(IEventBus eventBus) {
        ENCHANTMENTS.register(eventBus);
    }

}
