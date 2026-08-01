package com.CartersDev.crystechmod.block.entity.renderer.fluidSilo;

import com.CartersDev.crystechmod.block.entity.fluidsilo.FluidSiloBlockEntity;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.world.inventory.InventoryMenu;
import net.minecraft.world.level.material.Fluid;
import net.minecraftforge.client.extensions.common.IClientFluidTypeExtensions;
import net.minecraftforge.fluids.FluidStack;
import org.joml.Matrix4f;

public class FluidSiloRenderer implements BlockEntityRenderer<FluidSiloBlockEntity> {

    public FluidSiloRenderer(BlockEntityRendererProvider.Context context) {
    }

    @Override
    public void render(FluidSiloBlockEntity pBlockEntity, float pPartialTick, PoseStack pPoseStack,
                       MultiBufferSource pBufferSource, int pCombinedLight, int pCombinedOverlay) {

        FluidStack fluidStack = pBlockEntity.getCapability(net.minecraftforge.common.capabilities.ForgeCapabilities.FLUID_HANDLER, null)
                .map(handler -> handler.getFluidInTank(0))
                .orElse(FluidStack.EMPTY);

        if (fluidStack.isEmpty() || fluidStack.getAmount() <= 0) {
            return;
        }

        Fluid fluid = fluidStack.getFluid();
        int maxCapacity = pBlockEntity.getCapability(net.minecraftforge.common.capabilities.ForgeCapabilities.FLUID_HANDLER, null)
                .map(handler -> handler.getTankCapacity(0))
                .orElse(16000);

        float fluidRatio = (float) fluidStack.getAmount() / (float) maxCapacity;

        float minX = 0.15f;
        float maxX = 0.85f;
        float minZ = 0.15f;
        float maxZ = 0.85f;

        float minY = 0.1875f;
        float maxY = 0.8125f;


        float currentFluidHeight = minY + ((maxY - minY) * fluidRatio);

        IClientFluidTypeExtensions fluidProperties = IClientFluidTypeExtensions.of(fluid);
        int tintColor = fluidProperties.getTintColor(fluidStack);

        int a = (tintColor >> 24) & 0xFF;
        int r = (tintColor >> 16) & 0xFF;
        int g = (tintColor >> 8) & 0xFF;
        int b = tintColor & 0xFF;

        TextureAtlasSprite stillSprite = Minecraft.getInstance()
                .getTextureAtlas(InventoryMenu.BLOCK_ATLAS)
                .apply(fluidProperties.getStillTexture(fluidStack));

        float minU = stillSprite.getU0();
        float maxU = stillSprite.getU1();
        float minV = stillSprite.getV0();
        float maxV = stillSprite.getV1();

        VertexConsumer vertexConsumer = pBufferSource.getBuffer(RenderType.translucent());
        Matrix4f matrix4f = pPoseStack.last().pose();

        // TOP FACE
        vertexConsumer.vertex(matrix4f, minX, currentFluidHeight, minZ).color(r, g, b, a).uv(minU, minV).overlayCoords(pCombinedOverlay).uv2(pCombinedLight).normal(0, 1, 0).endVertex();
        vertexConsumer.vertex(matrix4f, minX, currentFluidHeight, maxZ).color(r, g, b, a).uv(minU, maxV).overlayCoords(pCombinedOverlay).uv2(pCombinedLight).normal(0, 1, 0).endVertex();
        vertexConsumer.vertex(matrix4f, maxX, currentFluidHeight, maxZ).color(r, g, b, a).uv(maxU, maxV).overlayCoords(pCombinedOverlay).uv2(pCombinedLight).normal(0, 1, 0).endVertex();
        vertexConsumer.vertex(matrix4f, maxX, currentFluidHeight, minZ).color(r, g, b, a).uv(maxU, minV).overlayCoords(pCombinedOverlay).uv2(pCombinedLight).normal(0, 1, 0).endVertex();

        //NORTH FACE
        vertexConsumer.vertex(matrix4f, minX, currentFluidHeight, minZ).color(r, g, b, a).uv(minU, minV).overlayCoords(pCombinedOverlay).uv2(pCombinedLight).normal(0, 0, -1).endVertex();
        vertexConsumer.vertex(matrix4f, maxX, currentFluidHeight, minZ).color(r, g, b, a).uv(maxU, minV).overlayCoords(pCombinedOverlay).uv2(pCombinedLight).normal(0, 0, -1).endVertex();
        vertexConsumer.vertex(matrix4f, maxX, minY, minZ).color(r, g, b, a).uv(maxU, maxV).overlayCoords(pCombinedOverlay).uv2(pCombinedLight).normal(0, 0, -1).endVertex();
        vertexConsumer.vertex(matrix4f, minX, minY, minZ).color(r, g, b, a).uv(minU, maxV).overlayCoords(pCombinedOverlay).uv2(pCombinedLight).normal(0, 0, -1).endVertex();

        //SOUTH FACE
        vertexConsumer.vertex(matrix4f, minX, minY, maxZ).color(r, g, b, a).uv(minU, maxV).overlayCoords(pCombinedOverlay).uv2(pCombinedLight).normal(0, 0, 1).endVertex();
        vertexConsumer.vertex(matrix4f, maxX, minY, maxZ).color(r, g, b, a).uv(maxU, maxV).overlayCoords(pCombinedOverlay).uv2(pCombinedLight).normal(0, 0, 1).endVertex();
        vertexConsumer.vertex(matrix4f, maxX, currentFluidHeight, maxZ).color(r, g, b, a).uv(maxU, minV).overlayCoords(pCombinedOverlay).uv2(pCombinedLight).normal(0, 0, 1).endVertex();
        vertexConsumer.vertex(matrix4f, minX, currentFluidHeight, maxZ).color(r, g, b, a).uv(minU, minV).overlayCoords(pCombinedOverlay).uv2(pCombinedLight).normal(0, 0, 1).endVertex();

        //EAST FACE
        vertexConsumer.vertex(matrix4f, maxX, currentFluidHeight, minZ).color(r, g, b, a).uv(maxU, minV).overlayCoords(pCombinedOverlay).uv2(pCombinedLight).normal(1, 0, 0).endVertex();
        vertexConsumer.vertex(matrix4f, maxX, currentFluidHeight, maxZ).color(r, g, b, a).uv(minU, minV).overlayCoords(pCombinedOverlay).uv2(pCombinedLight).normal(1, 0, 0).endVertex();
        vertexConsumer.vertex(matrix4f, maxX, minY, maxZ).color(r, g, b, a).uv(minU, maxV).overlayCoords(pCombinedOverlay).uv2(pCombinedLight).normal(1, 0, 0).endVertex();
        vertexConsumer.vertex(matrix4f, maxX, minY, minZ).color(r, g, b, a).uv(maxU, maxV).overlayCoords(pCombinedOverlay).uv2(pCombinedLight).normal(1, 0, 0).endVertex();

        //WEST FACE
        vertexConsumer.vertex(matrix4f, minX, minY, minZ).color(r, g, b, a).uv(minU, maxV).overlayCoords(pCombinedOverlay).uv2(pCombinedLight).normal(-1, 0, 0).endVertex();
        vertexConsumer.vertex(matrix4f, minX, minY, maxZ).color(r, g, b, a).uv(maxU, maxV).overlayCoords(pCombinedOverlay).uv2(pCombinedLight).normal(-1, 0, 0).endVertex();
        vertexConsumer.vertex(matrix4f, minX, currentFluidHeight, maxZ).color(r, g, b, a).uv(maxU, minV).overlayCoords(pCombinedOverlay).uv2(pCombinedLight).normal(-1, 0, 0).endVertex();
        vertexConsumer.vertex(matrix4f, minX, currentFluidHeight, minZ).color(r, g, b, a).uv(minU, minV).overlayCoords(pCombinedOverlay).uv2(pCombinedLight).normal(-1, 0, 0).endVertex();

        //BOTTOM FACE
        vertexConsumer.vertex(matrix4f, minX, minY, maxZ).color(r, g, b, a).uv(minU, maxV).overlayCoords(pCombinedOverlay).uv2(pCombinedLight).normal(0, -1, 0).endVertex();
        vertexConsumer.vertex(matrix4f, minX, minY, minZ).color(r, g, b, a).uv(minU, minV).overlayCoords(pCombinedOverlay).uv2(pCombinedLight).normal(0, -1, 0).endVertex();
        vertexConsumer.vertex(matrix4f, maxX, minY, minZ).color(r, g, b, a).uv(maxU, minV).overlayCoords(pCombinedOverlay).uv2(pCombinedLight).normal(0, -1, 0).endVertex();
        vertexConsumer.vertex(matrix4f, maxX, minY, maxZ).color(r, g, b, a).uv(maxU, maxV).overlayCoords(pCombinedOverlay).uv2(pCombinedLight).normal(0, -1, 0).endVertex();
    }
}
