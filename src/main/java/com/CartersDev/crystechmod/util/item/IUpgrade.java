package com.CartersDev.crystechmod.util.item;


/*
 * BluSunrize
 * Copyright (c) 2017
 *
 * This code is licensed under "Blu's License of Common Sense"
 * https://github.com/BluSunrize/ImmersiveEngineering/blob/1.20.1/LICENSE
 */

import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.item.ItemStack;

import java.util.Set;

public interface IUpgrade {

    Set<String> getUpgradeTypes(ItemStack upgrade);

    boolean canApplyUpgrades(ItemStack target, ItemStack upgrade);

    void applyUpgrades(ItemStack target, ItemStack upgrade, CompoundTag modifications);

}
