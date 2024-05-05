package com.CartersDev.crystechmod.item;


import com.CartersDev.crystechmod.CrystalTech;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;

import net.minecraft.world.item.crafting.Ingredient;

import java.util.function.Supplier;

public enum ModArmorMaterials implements ArmorMaterial {
    HAZMAT_MK1("hazmat_mk1", 10, new int[] {1, 2, 3, 1}, 15,
            SoundEvents.ARMOR_EQUIP_LEATHER, 0.0f, 0.0f, () -> Ingredient.of(ModItems.TIBERIUM_LEATHER.get())),

    HAZMAT_MK2("hazmat_mk2", 13, new int[] {1, 4, 5, 2}, 15,
            SoundEvents.ARMOR_EQUIP_LEATHER, 0.1f, 0.0f, () -> Ingredient.of(ModItems.ICHOR_LEATHER.get())),

    GUNDANIUM("gundanium", 20, new int[] {3, 6, 6, 3}, 12,
            SoundEvents.ARMOR_EQUIP_IRON, 0.5f, 0.1f, () -> Ingredient.of(ModItems.GUNDANIUM_INGOT.get())),

    ALYTHUM("alythum", 35, new int[] {4, 7, 9, 4}, 12,
    SoundEvents.ARMOR_EQUIP_IRON, 2.0f, 0.2f, () -> Ingredient.of(ModItems.ALYTHUM_INGOT.get()));

    private final String name;
    private final int durabilityMultiplier;
    private final int[] protectionAmounts;
    private final int enchantmentValue;
    private final SoundEvent equipSound;
    private final float toughness;
    private final float knockbackResistance;
    private final Supplier<Ingredient> repairIngredient;

    private static final int[] BASE_DURABILITY = {11, 16, 15, 13};

    ModArmorMaterials(String name, int durabilityMultiplier, int[] protectionAmounts, int enchantmentValue,
                      SoundEvent equipSound, float toughness, float knockbackResistance, Supplier<Ingredient>
                              repairIngredient) {
        this.name = name;
        this.durabilityMultiplier = durabilityMultiplier;
        this.protectionAmounts = protectionAmounts;
        this.enchantmentValue = enchantmentValue;
        this.equipSound = equipSound;
        this.toughness = toughness;
        this.knockbackResistance = knockbackResistance;
        this.repairIngredient = repairIngredient;
    }


    @Override
    public int getDurabilityForType(ArmorItem.Type type) {
        return BASE_DURABILITY[type.ordinal()] * this.durabilityMultiplier;
    }

    @Override
    public int getDefenseForType(ArmorItem.Type type) {
        return this.protectionAmounts[type.ordinal()];
    }

    @Override
    public int getEnchantmentValue() {
        return enchantmentValue;
    }

    @Override
    public SoundEvent getEquipSound() {
        return this.equipSound;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return this.repairIngredient.get();
    }

    @Override
    public String getName() {
        return CrystalTech.MOD_ID + ":" + this.name;
    }

    @Override
    public float getToughness() {
        return this.toughness;
    }

    @Override
    public float getKnockbackResistance() {
        return this.knockbackResistance;
    }
}
