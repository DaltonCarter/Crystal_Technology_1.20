package com.CartersDev.crystechmod.item.custom;

import com.CartersDev.crystechmod.item.FocusTypes;
import net.minecraft.world.item.Item;

public class FocusItem extends Item {

    public FocusItem(FocusTypes type, Properties pProperties) {
        super(pProperties.defaultDurability(type.getDurability()));
    }
}
