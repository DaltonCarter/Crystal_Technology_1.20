package com.CartersDev.crystechmod.util.item;


/*
 * BluSunrize
 * Copyright (c) 2017
 *
 * This code is licensed under "Blu's License of Common Sense"
 https://github.com/BluSunrize/ImmersiveEngineering/blob/1.20.1/LICENSE
 */

import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.item.ItemStack;


public class NBTHelper {

    public static boolean hasTag(ItemStack stack)
    {
        return stack.hasTag();
    }


    public static CompoundTag getTagCompound(ItemStack stack, String key)
    {
        return hasTag(stack)?stack.getOrCreateTag().getCompound(key): new CompoundTag();
    }

    public static void remove(ItemStack stack, String key)
    {
        removeTag(stack, key);
    }


    public static void removeTag(ItemStack stack, String key)
    {
        if(stack.hasTag())
        {
            CompoundTag tag = stack.getOrCreateTag();
            tag.remove(key);
            if(tag.isEmpty())
                stack.setTag(null);
        }
    }

    public static void setCompoundTag(ItemStack stack, String key, CompoundTag val)
    {
        stack.getOrCreateTag().put(key, val);
    }




}
