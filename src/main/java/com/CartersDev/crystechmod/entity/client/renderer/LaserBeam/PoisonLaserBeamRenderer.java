package com.CartersDev.crystechmod.entity.client.renderer.LaserBeam;

import com.CartersDev.crystechmod.CrystalTech;
import com.CartersDev.crystechmod.entity.client.LaserBeam.PoisonLaserBeamModel;
import com.CartersDev.crystechmod.entity.client.ModModelLayers;
import com.CartersDev.crystechmod.entity.custom.PoisonLaserBeamEntity;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.math.Axis;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.ItemRenderer;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import org.joml.Matrix3f;
import org.joml.Matrix4f;

public class PoisonLaserBeamRenderer extends EntityRenderer<PoisonLaserBeamEntity> {

    public static final ResourceLocation TEXTURE = new ResourceLocation(CrystalTech.MOD_ID, "textures/entity/laser_beam.png");
    protected PoisonLaserBeamModel model;

    public PoisonLaserBeamRenderer(EntityRendererProvider.Context pContext) {
        super(pContext);
        model = new PoisonLaserBeamModel(pContext.bakeLayer(ModModelLayers.POISON_LASER_BEAM_LAYER));
        this.shadowRadius = 0.5F;
    }

    public void render(PoisonLaserBeamEntity entity, float pEntityYaw, float pPartialTick, PoseStack pPoseStack, MultiBufferSource pBuffer, int pPackedLight) {

        pPoseStack.pushPose();


        pPoseStack.mulPose(Axis.YP.rotationDegrees(Mth.lerp(pPartialTick, entity.yRotO, entity.getYRot()) - 90.0F));
        pPoseStack.mulPose(Axis.ZP.rotationDegrees(Mth.lerp(pPartialTick, entity.xRotO, entity.getXRot())));

//        pPoseStack.mulPose(Axis.XP.rotationDegrees(90.0F));

//        pPoseStack.translate(0.0F, 0.F, 0.0F);
        VertexConsumer vertexconsumer = ItemRenderer.getFoilBufferDirect(pBuffer, this.model.renderType(this.getTextureLocation(entity)), false, false);




        this.model.renderToBuffer(pPoseStack, vertexconsumer, pPackedLight, OverlayTexture.NO_OVERLAY, 0f, 1.0f, 0.0f, 1f);
        pPoseStack.popPose();
        super.render(entity, pEntityYaw, pPartialTick, pPoseStack, pBuffer, pPackedLight);
    }


    @Override
    public ResourceLocation getTextureLocation(PoisonLaserBeamEntity pEntity) {
        return TEXTURE;
    }

    public void vertex(Matrix4f pMatrix, Matrix3f pNormal, VertexConsumer pConsumer, int pX, int pY, int pZ, float pU, float pV, int pNormalX, int pNormalZ, int pNormalY, int pPackedLight) {
        pConsumer.vertex(pMatrix, (float) pX, (float) pY, (float) pZ).color(255, 255, 255, 255).uv(pU, pV).overlayCoords(OverlayTexture.NO_OVERLAY).uv2(pPackedLight).normal(pNormal, (float) pNormalX, (float) pNormalY, (float) pNormalZ).endVertex();
    }
}
