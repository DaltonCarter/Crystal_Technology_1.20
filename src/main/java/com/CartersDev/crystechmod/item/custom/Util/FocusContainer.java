package com.CartersDev.crystechmod.item.custom.Util;

import net.minecraft.world.item.ItemStack;

public interface FocusContainer {

    enum FocusType{
        BASIC,
        IMPROVED,
        ADVANCED,
        OVERCHARGED,
        POISON,
        PROTOCULTURE
    }


    void addFocus(ItemStack stack, FocusType focus);

    boolean hasFocus(ItemStack stack, FocusType focus);

    void removeFocus(ItemStack stack);
}
