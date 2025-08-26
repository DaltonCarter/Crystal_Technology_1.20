package com.CartersDev.crystechmod.entity.client;

import com.CartersDev.crystechmod.CrystalTech;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.resources.ResourceLocation;

public class ModModelLayers {
    public static final ModelLayerLocation RHINO_LAYER = new ModelLayerLocation(
            new ResourceLocation(CrystalTech.MOD_ID, "rhino_layer"), "main");

    public static final ModelLayerLocation VITRIC_SHEEP_LAYER = new ModelLayerLocation(
            new ResourceLocation(CrystalTech.MOD_ID, "vitric_sheep_layer"), "main");

    public static final ModelLayerLocation VITRIC_SHEEP_FUR_LAYER = new ModelLayerLocation(
            new ResourceLocation(CrystalTech.MOD_ID, "vitric_sheep_fur_layer"), "main");

}
