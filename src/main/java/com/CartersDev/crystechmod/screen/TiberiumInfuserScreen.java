package com.CartersDev.crystechmod.screen;

import com.CartersDev.crystechmod.CrystalTech;
import com.CartersDev.crystechmod.screen.renderer.EnergyDisplayTooltipArea;
import com.CartersDev.crystechmod.screen.renderer.FluidTankRenderer;
import com.CartersDev.crystechmod.util.MouseUtil;
import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.item.TooltipFlag;
import net.minecraftforge.fluids.FluidStack;

import java.util.Optional;

public class TiberiumInfuserScreen extends AbstractContainerScreen<TiberiumInfuserMenu> {

    private static final ResourceLocation TEXTURE =
            new ResourceLocation(CrystalTech.MOD_ID, "textures/gui/tiberium_infuser_gui.png");

    private EnergyDisplayTooltipArea energyInfoArea;
    private FluidTankRenderer fluidrenderer;


    public TiberiumInfuserScreen(TiberiumInfuserMenu pMenu, Inventory pPlayerInventory, Component pTitle) {
        super(pMenu, pPlayerInventory, pTitle);
    }

    @Override
    protected void init() {
        super.init();
        this.inventoryLabelY = 10000;
        this.titleLabelY = 10000;

        assignEnergyInfoArea();
        assignFluidRenderer();
    }

    private void assignFluidRenderer() {
        fluidrenderer = new FluidTankRenderer(64000, true, 16, 39);
    }

    @Override
    protected void renderLabels(GuiGraphics pGuiGraphics, int pMouseX, int pMouseY) {
        int x = (width - imageWidth) / 2;
        int y = (height - imageHeight) / 2;


        renderEnergyAreaTooltip(pGuiGraphics, pMouseX, pMouseY, x, y);
        renderFluidTooltipArea(pGuiGraphics, pMouseX, pMouseY, x, y, menu.blockEntity.getFluid(), 26, 11, fluidrenderer);
    }

    private void renderFluidTooltipArea(GuiGraphics pGuiGraphics, int pMouseX, int pMouseY, int x, int y,
                                        FluidStack stack, int offsetX, int offsetY, FluidTankRenderer renderer) {
        if(isMouseAboveArea(pMouseX, pMouseY, x, y, offsetX, offsetY, renderer)) {
            pGuiGraphics.renderTooltip(this.font, renderer.getTooltip(stack, TooltipFlag.Default.NORMAL),
                    Optional.empty(), pMouseX - x, pMouseY - y);
        }
    }

    private void renderEnergyAreaTooltip(GuiGraphics pGuiGraphics, int pMouseX, int pMouseY, int x, int y) {
        if(isMouseAboveArea(pMouseX, pMouseY, x, y, 156, 11, 8, 64)) {
            pGuiGraphics.renderTooltip(this.font, energyInfoArea.getTooltips(),
                    Optional.empty(), pMouseX - x, pMouseY - y);
        }
    }

    private void assignEnergyInfoArea() {
        energyInfoArea = new EnergyDisplayTooltipArea(((width - imageWidth) / 2) + 156,
                ((height - imageHeight) / 2) + 11, menu.blockEntity.getEnergyStorage());
    }

    @Override
    protected void renderBg(GuiGraphics pGuiGraphics, float pPartialTick, int pMouseX, int pMouseY) {
        RenderSystem.setShader(GameRenderer::getPositionTexShader);
        RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
        RenderSystem.setShaderTexture(0, TEXTURE);
        int x = (width - imageWidth) / 2;
        int y = (height - imageHeight) / 2;

        pGuiGraphics.blit(TEXTURE, x, y, 0, 0, imageWidth, imageHeight);

        renderProgressArrow(pGuiGraphics, x, y);

        energyInfoArea.render(pGuiGraphics);
        fluidrenderer.render(pGuiGraphics, x + 26, y + 11, menu.blockEntity.getFluid());
    }

    private void renderProgressArrow(GuiGraphics guiGraphics, int x, int y) {
        if(menu.isCrafting()) {
            guiGraphics.blit(TEXTURE, x + 85, y + 30, 176, 0, 8, menu.getScaledProgress());
        }
    }

    @Override
    public void render(GuiGraphics guiGraphics, int mouseX, int mouseY, float delta) {
        renderBackground(guiGraphics);
        super.render(guiGraphics, mouseX, mouseY, delta);
        renderTooltip(guiGraphics, mouseX, mouseY);
    }

    private boolean isMouseAboveArea(int pMouseX, int pMouseY, int x, int y, int offsetX, int offsetY, FluidTankRenderer renderer) {
        return MouseUtil.isMouseOver(pMouseX, pMouseY, x + offsetX, y + offsetY, renderer.getWidth(), renderer.getHeight());
    }

    private boolean isMouseAboveArea(int pMouseX, int pMouseY, int x, int y, int offsetX, int offsetY, int width, int height) {
        return MouseUtil.isMouseOver(pMouseX, pMouseY, x + offsetX, y + offsetY, width, height);
    }
}
