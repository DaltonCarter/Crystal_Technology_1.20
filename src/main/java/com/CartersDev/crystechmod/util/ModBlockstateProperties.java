package com.CartersDev.crystechmod.util;

import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.IntegerProperty;


public class ModBlockstateProperties {

    public static final BooleanProperty WORKING = BooleanProperty.create("working");
    public static final IntegerProperty MACHINE_CORE_LVL = IntegerProperty.create("machine_core_lvl", 1, 4);



}
