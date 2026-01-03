package com.CartersDev.crystechmod.util;

import net.minecraft.nbt.Tag;
import net.minecraft.world.item.ItemStack;

public class NBTHelper {

    public static void setBoolean(ItemStack stack, String tag, boolean b) {
        stack.getOrCreateTag().putBoolean(tag, b);
    }

    public static boolean getBoolean(ItemStack stack, String tag, boolean defaultExpected) {
        return verifyExistance(stack, tag) ? stack.getOrCreateTag().getBoolean(tag) : defaultExpected;
    }




    public static boolean verifyExistance(ItemStack stack, String tag) {
        return !stack.isEmpty() && stack.hasTag() && stack.getOrCreateTag().contains(tag);
    }

    public static boolean verifyType(ItemStack stack, String tag, Class<? extends Tag> tagClass) {
        return !stack.isEmpty() && stack.hasTag() && tagClass.isInstance(stack.getOrCreateTag().get(tag));
    }
}
