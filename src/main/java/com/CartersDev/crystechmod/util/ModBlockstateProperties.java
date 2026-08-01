package com.CartersDev.crystechmod.util;

import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.level.block.state.properties.IntegerProperty;


public class ModBlockstateProperties {

    //Booleans:
    public static final BooleanProperty WORKING = BooleanProperty.create("working");
    public static final BooleanProperty HAS_CORE_CRYSTAL = BooleanProperty.create("has_core_crystal");
    public static final BooleanProperty HAS_CANISTER = BooleanProperty.create("has_canister");
    public static final BooleanProperty HAS_CHARGE = BooleanProperty.create("has_charge");

    //Integers:
    public static final IntegerProperty MACHINE_CORE_LVL = IntegerProperty.create("machine_core_lvl", 1, 4);
    public static final IntegerProperty TRAVEL_SPEED_MULTIPLIER = IntegerProperty.create("travel_speed_multiplier", 1, 4);

    //Enums:
    public static final EnumProperty<VitriciumMatrixFluids> FUEL = EnumProperty.create("fuel", VitriciumMatrixFluids.class);
    public static final EnumProperty<CoreCrystals> CORE_CRYSTALS = EnumProperty.create("core_crystal", CoreCrystals.class);



}
