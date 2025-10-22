package com.CartersDev.crystechmod.util.item;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraftforge.items.IItemHandler;

import java.util.function.Supplier;

/*
This Code was written based on Code by BluSunrize, and will look very similar to it's source with some omissions,
and variations based on what I am trying to accomplish.

That being said:

All pieces of Blu's code contained herein are licensed under "Blu's License of Common Sense"
https://github.com/BluSunrize/ImmersiveEngineering/blob/1.20.1/LICENSE

Upgradeable Items like the Core Bow and Beam Sabre implement this.

 Since this is an interface, upgrade- and inventory-management need to be handled by the item implementing this

 */

public interface IUpgradeableItem {

    CompoundTag getUpgrades(ItemStack stack);

    void clearUpgrades(ItemStack stack);

    void finishUpgradeRefresh(ItemStack stack);

    void refreshUpgrades (ItemStack stack, Level level, Player player);

    default ItemStack returnUpgrade(ItemStack stack, ItemStack upgrade){
        return upgrade;
    }

default void removeupgrade(ItemStack stack, Player player, ItemStack upgrade) {}

    boolean canTakeFromWeaponStation(ItemStack stack);

    void removeFromWeaponStation(Player player, ItemStack stack);

    boolean canModify(ItemStack stack);

    Slot[] getWeaponStationSlots(AbstractContainerMenu container, ItemStack stack, Level level, Supplier<Player> getPlayer, IItemHandler itemInventory);



}
