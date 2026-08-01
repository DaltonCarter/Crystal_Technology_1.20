package com.CartersDev.crystechmod.screen.FluidSilo.fluidSiloScreen;

import com.CartersDev.crystechmod.CrystalTech;
import com.CartersDev.crystechmod.screen.FluidSilo.fluidSiloMenu.FluidSiloMenu;
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

public class FluidSiloScreen extends AbstractContainerScreen<FluidSiloMenu> {

    private static final ResourceLocation TEXTURE =
            new ResourceLocation(CrystalTech.MOD_ID, "textures/gui/fluid_silo_gui.png");

    private FluidTankRenderer fluidrenderer;


    public FluidSiloScreen(FluidSiloMenu pMenu, Inventory pPlayerInventory, Component pTitle) {
        super(pMenu, pPlayerInventory, pTitle);
    }

    @Override
    protected void init() {
        super.init();
        this.inventoryLabelY = 10000;
        this.titleLabelY = 10000;

        assignFluidRenderer();
    }


    private void assignFluidRenderer() {
        int machineCoreLvl = menu.machineCoreLvl;

        int capacity = switch (machineCoreLvl){
            case 1 -> 16000;
            case 2 -> 32000;
            case 3 -> 64000;
            case 4 -> 128000;
            default -> 1;
        };

        fluidrenderer = new FluidTankRenderer(capacity, true, 16, 39);
    }

    @Override
    protected void renderLabels(GuiGraphics pGuiGraphics, int pMouseX, int pMouseY) {
        int x = (width - imageWidth) / 2;
        int y = (height - imageHeight) / 2;

        renderFluidTooltipArea(pGuiGraphics, pMouseX, pMouseY, x, y, menu.blockEntity.getFluid(), 80, 11, fluidrenderer);
    }

    private void renderFluidTooltipArea(GuiGraphics pGuiGraphics, int pMouseX, int pMouseY, int x, int y,
                                        FluidStack stack, int offsetX, int offsetY, FluidTankRenderer renderer) {
        if(isMouseAboveArea(pMouseX, pMouseY, x, y, offsetX, offsetY, renderer)) {
            pGuiGraphics.renderTooltip(this.font, renderer.getTooltip(stack, TooltipFlag.Default.NORMAL),
                    Optional.empty(), pMouseX - x, pMouseY - y);
        }
    }

    @Override
    protected void renderBg(GuiGraphics pGuiGraphics, float pPartialTick, int pMouseX, int pMouseY) {
        RenderSystem.setShader(GameRenderer::getPositionTexShader);
        RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
        RenderSystem.setShaderTexture(0, TEXTURE);
        int x = (width - imageWidth) / 2;
        int y = (height - imageHeight) / 2;

        pGuiGraphics.blit(TEXTURE, x, y, 0, 0, imageWidth, imageHeight);

        fluidrenderer.render(pGuiGraphics, x + 80, y + 11, menu.blockEntity.getFluid());
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
