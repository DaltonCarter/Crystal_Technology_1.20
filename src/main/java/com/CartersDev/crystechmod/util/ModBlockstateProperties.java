package com.CartersDev.crystechmod.util;

import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.IntegerProperty;


public class ModBlockstateProperties {

    public static final BooleanProperty WORKING = BooleanProperty.create("working");
    public static final BooleanProperty HAS_CORE_CRYSTAL = BooleanProperty.create("has_core_crystal");
    public static final IntegerProperty MACHINE_CORE_LVL = IntegerProperty.create("machine_core_lvl", 1, 4);
    public static final IntegerProperty TRAVEL_SPEED_MULTIPLIER = IntegerProperty.create("travel_speed_multiplier", 1, 4);



}
