package com.CartersDev.crystechmod.entity.client;

import com.CartersDev.crystechmod.CrystalTech;
import com.CartersDev.crystechmod.entity.custom.RhinoEntity;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class RhinoRenderer extends MobRenderer<RhinoEntity, RhinoModel<RhinoEntity>> {
    public RhinoRenderer(EntityRendererProvider.Context pContext) {
        super(pContext, new RhinoModel<>(pContext.bakeLayer(ModModelLayers.RHINO_LAYER)), 2F);
    }

    @Override
    public ResourceLocation getTextureLocation(RhinoEntity pEntity) {
        return new ResourceLocation(CrystalTech.MOD_ID, "textures/entity/rhino.png");
    }

    @Override
    public void render(RhinoEntity pEntity, float pEntityYaw, float pPartialTicks, PoseStack pPoseStack, MultiBufferSource pBuffer, int pPackedLight) {

        if(pEntity.isBaby()) {
            pPoseStack.scale(0.5F, 0.5F, 0.5F);
        }



        super.render(pEntity, pEntityYaw, pPartialTicks, pPoseStack, pBuffer, pPackedLight);
    }
}
