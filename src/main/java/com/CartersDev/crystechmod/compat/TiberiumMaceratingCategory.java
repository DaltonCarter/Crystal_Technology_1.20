package com.CartersDev.crystechmod.compat;

import com.CartersDev.crystechmod.CrystalTech;
import com.CartersDev.crystechmod.block.ModBlocks;
import com.CartersDev.crystechmod.recipe.TiberiumMaceratorRecipe;
import com.CartersDev.crystechmod.screen.renderer.EnergyDisplayTooltipArea;
import com.CartersDev.crystechmod.util.MouseUtil;
import mezz.jei.api.constants.VanillaTypes;
import mezz.jei.api.gui.builder.IRecipeLayoutBuilder;
import mezz.jei.api.gui.drawable.IDrawable;
import mezz.jei.api.gui.drawable.IDrawableAnimated;
import mezz.jei.api.gui.drawable.IDrawableStatic;
import mezz.jei.api.gui.ingredient.IRecipeSlotsView;
import mezz.jei.api.helpers.IGuiHelper;
import mezz.jei.api.recipe.IFocusGroup;
import mezz.jei.api.recipe.RecipeIngredientRole;
import mezz.jei.api.recipe.RecipeType;
import mezz.jei.api.recipe.category.IRecipeCategory;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import org.jetbrains.annotations.Nullable;

import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.List;

public class TiberiumMaceratingCategory implements IRecipeCategory<TiberiumMaceratorRecipe> {
    public static final ResourceLocation UID = new ResourceLocation(CrystalTech.MOD_ID, "tiberium_macerating");
    public static final ResourceLocation TEXTURE = new ResourceLocation(CrystalTech.MOD_ID, "textures/gui/dummies/tiberium_macerator_gui.png");



public static final RecipeType<TiberiumMaceratorRecipe> TIBERIUM_MACERATING_TYPE =
new RecipeType<>(UID, TiberiumMaceratorRecipe.class);

private final IDrawable background;
private final IDrawable icon;


    public TiberiumMaceratingCategory(IGuiHelper helper) {

        this.background = helper.createDrawable(TEXTURE, 0, 0, 176, 78);
        this.icon = helper.createDrawableIngredient(VanillaTypes.ITEM_STACK, new ItemStack(ModBlocks.TIBERIUM_MACERATOR.get()));

    }

    @Override
    public RecipeType<TiberiumMaceratorRecipe> getRecipeType() {
        return TIBERIUM_MACERATING_TYPE;
    }

    @Override
    public Component getTitle() {
        return Component.literal("All Vitricium Macerators");
    }

    @Override
    public IDrawable getBackground() {
        return this.background;
    }

    @Override
    public @Nullable IDrawable getIcon() {
        return this.icon;
    }



    @Override
    public void setRecipe(IRecipeLayoutBuilder iRecipeLayoutBuilder, TiberiumMaceratorRecipe tiberiumMaceratorRecipe, IFocusGroup iFocusGroup) {

        iRecipeLayoutBuilder.addSlot(RecipeIngredientRole.INPUT, 80, 11).addIngredients(tiberiumMaceratorRecipe.getIngredients().get(0));
        iRecipeLayoutBuilder.addSlot(RecipeIngredientRole.OUTPUT, 80, 59).addItemStack(tiberiumMaceratorRecipe.getResultItem(null));

    }


    /*
     * BluSunrize
     * Copyright (c) 2017
     *
     * This code is licensed under "Blu's License of Common Sense"
     * https://github.com/BluSunrize/ImmersiveEngineering/blob/1.20.1/LICENSE
     */

    public static String formatDouble(double d, String s)
    {
        DecimalFormat df = new DecimalFormat(s);
        return df.format(d);
    }

    public List<Component> getTooltipStrings(TiberiumMaceratorRecipe recipe, IRecipeSlotsView recipeSlotsView, double mouseX, double mouseY)
    {
        int x = (176 - 86)/2;
        int y = 166 / 2;

        if(mouseX >= x + 110 && mouseX <= x + 120 && mouseY >= 10 && mouseY <= 76)
        {
            float time = recipe.getCraftTime();
            float energy = recipe.getEnergyAmount() * time;
            formatDouble(energy, "#.##");
            return Arrays.asList(
                    Component.literal("Total Energy: " + formatDouble(energy, "#.##") + " FE"),
                    Component.literal("Craft Time: " + formatDouble(time/20, "#.##") + "s")
            );
        }
        return IRecipeCategory.super.getTooltipStrings(recipe, recipeSlotsView, mouseX, mouseY);
    }

}
