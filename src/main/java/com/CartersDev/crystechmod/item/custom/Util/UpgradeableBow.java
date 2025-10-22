package com.CartersDev.crystechmod.item.custom.Util;


import com.CartersDev.crystechmod.util.item.IUpgrade;
import com.CartersDev.crystechmod.util.item.IUpgradeableItem;
import com.CartersDev.crystechmod.util.item.NBTHelper;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.BowItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraftforge.common.capabilities.ForgeCapabilities;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.items.IItemHandler;


/*
This Code was written based on Code by BluSunrize, and will look very similar to it's source with some omissions,
and variations based on what I am trying to accomplish.

That being said:

All pieces of Blu's code contained herein are licensed under "Blu's License of Common Sense"
https://github.com/BluSunrize/ImmersiveEngineering/blob/1.20.1/LICENSE

 */

/*
If I am Correct this class handles the number, and type of upgrades as well as functionality for it's side of the Weapons Station.
I.E Telling the station that this is a Bow and should have Slots for a : Focus Lens, A Capacitor Upgrade, A Damage Upgrade, and a Draw Speed upgrade

I should also be able to define in this class a Limit on what upgrades can be used on a given instance of the Weapon.
Like the Mk.1 Core bow can only have say Lvl. 1 Upgrades,
While the MK.2 can have up to lvl 3 as an example.

It's also going to have to establish the Inventory and Item Stack Handling.
 */

public abstract class UpgradeableBow extends BowItem implements IUpgradeableItem {

    private String upgradeType;


    public UpgradeableBow(Properties pProperties, String upgradeType) {
        super(pProperties);
        this.upgradeType = upgradeType;
    }


    @Override
    public CompoundTag getUpgrades(ItemStack stack) {
        return getUpgradesStatic(stack);
    }

    private CompoundTag getUpgradesStatic(ItemStack stack) {
        return NBTHelper.getTagCompound(stack, "upgrades");
    }

    @Override
    public void clearUpgrades(ItemStack stack) {
        NBTHelper.remove(stack, "upgrades");
    }

    @Override
    public void refreshUpgrades(ItemStack stack, Level level, Player player) {
        if(level.isClientSide){
            return;
        }

        clearUpgrades(stack);
        LazyOptional<IItemHandler> inv = stack.getCapability(ForgeCapabilities.ITEM_HANDLER, null);
        inv.ifPresent(inventory -> {
            CompoundTag upgradeTag = getUpgradeBase(stack).copy();
            for(int i = 0; i < inventory.getSlots(); i++){
            ItemStack item = inventory.getStackInSlot(i);
            if(!item.isEmpty() && item.getItem() instanceof IUpgrade){
                IUpgrade upg = (IUpgrade) item.getItem();
                if(upg.getUpgradeTypes(item).contains(upgradeType) && upg.canApplyUpgrades(stack, item)){
                    upg.applyUpgrades(stack, item, upgradeTag);
                }
            }

            NBTHelper.setCompoundTag(stack, "upgrades", upgradeTag);
            finishUpgradeRefresh(stack);

            }

        });

    }

    public CompoundTag getUpgradeBase(ItemStack stack) {
        return new CompoundTag();
    }

    @Override
    public boolean canTakeFromWeaponStation(ItemStack stack) {
        return true;
    }

    @Override
    public void removeFromWeaponStation(Player player, ItemStack stack) {

    }

    public abstract int getSlotCount();
}
