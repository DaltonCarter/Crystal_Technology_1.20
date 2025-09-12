package com.CartersDev.crystechmod.entity.client.renderer.vitricSheep;

import com.CartersDev.crystechmod.CrystalTech;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.SheepModel;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.SheepRenderer;
import net.minecraft.client.renderer.entity.layers.SheepFurLayer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.animal.Sheep;


public class VitricSheepRenderer extends SheepRenderer {
    private static final ResourceLocation VITRIC_SHEEP_LOCATION = new ResourceLocation(CrystalTech.MOD_ID,"textures/entity/vitric_sheep/vitric_sheep.png");

    public VitricSheepRenderer(EntityRendererProvider.Context manager, SheepModel<? extends Sheep> baseModel, EntityModel<?> coatModel, float shadowSize) {
        super(manager);
        this.shadowRadius = shadowSize;
        this.model = (SheepModel<Sheep>) baseModel;
        this.addLayer(new SheepFurLayer(this, manager.getModelSet()));
    }

    @Override
    public ResourceLocation getTextureLocation(Sheep ent) {
        return VITRIC_SHEEP_LOCATION;
    }

}
