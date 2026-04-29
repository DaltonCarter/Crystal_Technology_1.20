package com.CartersDev.crystechmod.item.custom.Util;

import com.CartersDev.crystechmod.item.FocusTypes;
import net.minecraft.world.item.ItemStack;

public interface FocusContainer {


    void addFocus(ItemStack stack, FocusTypes focus);

    boolean hasFocus(ItemStack stack, FocusTypes focus);

    void removeFocus(ItemStack stack);

    int getDurabilityforFocus(FocusTypes focus);

    int getBaseDamageforFocus(FocusTypes focus);

    String getNameforFocus(FocusTypes focus);





}
