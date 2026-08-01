package com.CartersDev.crystechmod.util;

import net.minecraft.util.StringRepresentable;
import org.jetbrains.annotations.NotNull;

public enum CoreCrystals implements StringRepresentable {
    NONE("none"),
    GREEN("green"),
    BLUE("blue"),
    YELLOW("yellow"),
    ORANGE("orange"),
    RED("red"),
    PURPLE("purple"),
    PERFECTED("perfected");

    private final String name;

    CoreCrystals(String name) {
        this.name = name;
    }

    @Override
    public @NotNull String getSerializedName() {
        return this.name;
    }

}
