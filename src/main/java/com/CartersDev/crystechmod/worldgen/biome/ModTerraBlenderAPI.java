package com.CartersDev.crystechmod.worldgen.biome;

import com.CartersDev.crystechmod.CrystalTech;
import com.CartersDev.crystechmod.worldgen.biome.custom.ModOverworldRegion;
import net.minecraft.resources.ResourceLocation;
import terrablender.api.Regions;

public class ModTerraBlenderAPI {
    public static void registerRegions() {
        Regions.register(new ModOverworldRegion(new ResourceLocation(CrystalTech.MOD_ID, "overworld"), 5));

    }
}
