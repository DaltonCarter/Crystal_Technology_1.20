package com.CartersDev.crystechmod.entity.client.renderer.rhino;

import com.CartersDev.crystechmod.CrystalTech;
import com.CartersDev.crystechmod.entity.Variant.ImpalerRhino.RhinoVariant;
import com.CartersDev.crystechmod.entity.client.ModModelLayers;
import com.CartersDev.crystechmod.entity.client.rhino.RhinoModel;
import com.CartersDev.crystechmod.entity.custom.RhinoEntity;
import com.google.common.collect.Maps;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.Util;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

import java.util.Map;

public class RhinoRenderer extends MobRenderer<RhinoEntity, RhinoModel<RhinoEntity>> {
    public RhinoRenderer(EntityRendererProvider.Context pContext) {
        super(pContext, new RhinoModel<>(pContext.bakeLayer(ModModelLayers.RHINO_LAYER)), 2F);

    }

    public static final Map<RhinoVariant, ResourceLocation> LOCATION_BY_VARIANT =
            Util.make(Maps.newEnumMap(RhinoVariant.class), map -> {
               map.put(RhinoVariant.DEFAULT,
                       new ResourceLocation(CrystalTech.MOD_ID, "textures/entity/rhino/rhino.png"));
                map.put(RhinoVariant.BLUE,
                        new ResourceLocation(CrystalTech.MOD_ID, "textures/entity/rhino/rhino_blue_horn.png"));
                map.put(RhinoVariant.RED,
                        new ResourceLocation(CrystalTech.MOD_ID, "textures/entity/rhino/rhino_red_horn.png"));
                map.put(RhinoVariant.PURPLE,
                        new ResourceLocation(CrystalTech.MOD_ID, "textures/entity/rhino/rhino_purple_horn.png"));
            });

    @Override
    public ResourceLocation getTextureLocation(RhinoEntity pEntity) {
        return LOCATION_BY_VARIANT.get(pEntity.getVariant());
    }

    @Override
    public void render(RhinoEntity pEntity, float pEntityYaw, float pPartialTicks, PoseStack pPoseStack, MultiBufferSource pBuffer, int pPackedLight) {

        if(pEntity.isBaby()) {
            pPoseStack.scale(0.5F, 0.5F, 0.5F);

        }



        super.render(pEntity, pEntityYaw, pPartialTicks, pPoseStack, pBuffer, pPackedLight);
    }
}
