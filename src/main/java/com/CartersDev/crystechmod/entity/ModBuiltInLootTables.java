package com.CartersDev.crystechmod.entity;

import com.CartersDev.crystechmod.CrystalTech;
import com.google.common.collect.Sets;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.storage.loot.LootTable;

import java.util.Collections;
import java.util.Set;

public class ModBuiltInLootTables {
    private static final Set<ResourceLocation> CT_LOOT_TABLES = Sets.newHashSet();
    private static final Set<ResourceLocation> CT_IMMUTABLE_LOCATIONS = Collections.unmodifiableSet(CT_LOOT_TABLES);

    public static final ResourceLocation VITRIC_SHEEP_WHITE = register("entities/vitric_sheep/white");
    public static final ResourceLocation VITRIC_SHEEP_ORANGE = register("entities/vitric_sheep/orange");
    public static final ResourceLocation VITRIC_SHEEP_MAGENTA = register("entities/vitric_sheep/magenta");
    public static final ResourceLocation VITRIC_SHEEP_LIGHT_BLUE = register("entities/vitric_sheep/light_blue");
    public static final ResourceLocation VITRIC_SHEEP_YELLOW = register("entities/vitric_sheep/yellow");
    public static final ResourceLocation VITRIC_SHEEP_LIME = register("entities/vitric_vitric_sheep/lime");
    public static final ResourceLocation VITRIC_SHEEP_PINK = register("entities/vitric_sheep/pink");
    public static final ResourceLocation VITRIC_SHEEP_GRAY = register("entities/vitric_sheep/gray");
    public static final ResourceLocation VITRIC_SHEEP_LIGHT_GRAY = register("entities/vitric_sheep/light_gray");
    public static final ResourceLocation VITRIC_SHEEP_CYAN = register("entities/vitric_sheep/cyan");
    public static final ResourceLocation VITRIC_SHEEP_PURPLE = register("entities/vitric_sheep/purple");
    public static final ResourceLocation VITRIC_SHEEP_BLUE = register("entities/vitric_sheep/blue");
    public static final ResourceLocation VITRIC_SHEEP_BROWN = register("entities/vitric_sheep/brown");
    public static final ResourceLocation VITRIC_SHEEP_GREEN = register("entities/vitric_sheep/green");
    public static final ResourceLocation VITRIC_SHEEP_RED = register("entities/vitric_sheep/red");
    public static final ResourceLocation VITRIC_SHEEP_BLACK = register("entities/vitric_sheep/black");



    private static ResourceLocation register(String id) {
        return register(CrystalTech.MOD_ID);
    }

    private static ResourceLocation register(ResourceLocation pId) {
        if (CT_LOOT_TABLES.add(pId)) {
            return pId;
        } else {
            throw new IllegalArgumentException(pId + " is already a registered built-in loot table");
        }
    }

    public static Set<ResourceLocation> all() {
        return CT_LOOT_TABLES;
    }
}
