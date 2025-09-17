package com.CartersDev.crystechmod.entity.client.renderer.vitricCow;

import com.CartersDev.crystechmod.CrystalTech;
import net.minecraft.client.model.CowModel;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.SheepModel;
import net.minecraft.client.renderer.entity.CowRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.animal.Cow;
import net.minecraft.world.entity.animal.Sheep;

public class VitricCowRenderer extends CowRenderer {
    private static final ResourceLocation VITRIC_COW_LOCATION = new ResourceLocation(CrystalTech.MOD_ID,"textures/entity/vitric_cow/vitric_cow.png");

    public VitricCowRenderer(EntityRendererProvider.Context context, CowModel<? extends Cow> baseModel, float shadowSize) {
        super(context);
        this.shadowRadius = shadowSize;
        this.model = (CowModel<Cow>) baseModel;
    }


    @Override
    public ResourceLocation getTextureLocation(Cow ent) {
        return VITRIC_COW_LOCATION;
    }
}
