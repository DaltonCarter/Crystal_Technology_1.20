package com.CartersDev.crystechmod.util;

import net.minecraft.util.StringRepresentable;

public enum VitriciumMatrixFluids implements StringRepresentable {

    EMPTY("empty"),
    VIRIDE("viride"),
    CAERULEUM("caeruleum"),
    SANGUINEUM("sanguineum"),
    VIOLACEUM("violaceum"),;

    public final String name;

    VitriciumMatrixFluids(String name) {
        this.name = name;
    }

    @Override
    public String getSerializedName() {
        return this.name;
    }
}
