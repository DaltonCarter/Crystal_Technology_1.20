package com.CartersDev.crystechmod.item;

import com.CartersDev.crystechmod.CrystalTech;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.item.crafting.Ingredient;

import java.util.function.Supplier;

public enum FocusTypes {

        BASIC("basic", 160, 160,6.0F),
        IMPROVED("improved", 320, 320,12.0F),
        ADVANCED("advanced", 640, 640,24.0F),
        OVERCHARGED("overcharged", 250, 250,30.0F),
        POISON("irradiated", 250, 250,16.0F),
        PROTOCULTURE("protoculture", 640, 640,40.0F);

    private final String name;
    private final int durability;
    private final int maxDurability;
    private final float baseDamage;


    FocusTypes(String name, int durability, int maxDurability, float baseDamage) {
        this.name = name;
        this.durability = durability;
        this.maxDurability = maxDurability;
        this.baseDamage = baseDamage;

    }

    public String getName() {
        return CrystalTech.MOD_ID + ":" + this.name;
    }

    public int getDurability() {return this.durability;}

    public int getMaxDurability() {return this.maxDurability;}

    public float getBaseDamage() {return this.baseDamage;}
}
