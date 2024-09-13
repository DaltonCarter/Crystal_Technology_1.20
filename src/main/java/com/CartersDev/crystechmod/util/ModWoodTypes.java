package com.CartersDev.crystechmod.util;

import com.CartersDev.crystechmod.CrystalTech;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.block.state.properties.WoodType;

public class ModWoodTypes {

    public static final WoodType PLAGUED = WoodType.register(new WoodType(CrystalTech.MOD_ID + ":plagued", BlockSetType.OAK));
    public static final WoodType EMBER_OAK = WoodType.register(new WoodType(CrystalTech.MOD_ID + ":ember_oak", BlockSetType.OAK));
    public static final WoodType DEAD = WoodType.register(new WoodType(CrystalTech.MOD_ID + ":dead", BlockSetType.OAK));
    public static final WoodType MARIKA_OAK = WoodType.register(new WoodType(CrystalTech.MOD_ID + ":marika_oak", BlockSetType.OAK));

}
