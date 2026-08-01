package com.CartersDev.crystechmod.compat;

import com.CartersDev.crystechmod.CrystalTech;
import com.CartersDev.crystechmod.block.ModBlocks;
import com.CartersDev.crystechmod.recipe.PoweredKilnRecipe;
import com.CartersDev.crystechmod.recipe.StirlingMatrixFuel;
import com.CartersDev.crystechmod.recipe.VitriciumMatrixRecipe;
import mezz.jei.api.constants.VanillaTypes;
import mezz.jei.api.forge.ForgeTypes;
import mezz.jei.api.gui.builder.IRecipeLayoutBuilder;
import mezz.jei.api.gui.drawable.IDrawable;
import mezz.jei.api.gui.ingredient.IRecipeSlotsView;
import mezz.jei.api.helpers.IGuiHelper;
import mezz.jei.api.recipe.IFocusGroup;
import mezz.jei.api.recipe.RecipeIngredientRole;
import mezz.jei.api.recipe.RecipeType;
import mezz.jei.api.recipe.category.IRecipeCategory;
import net.minecraft.client.Minecraft;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import org.jetbrains.annotations.Nullable;

import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.List;

public class StirlingMatrixFuelCategory implements IRecipeCategory<StirlingMatrixFuel> {
    public static final ResourceLocation UID = new ResourceLocation(CrystalTech.MOD_ID, "stirling_power_generation");
    public static final ResourceLocation TEXTURE = new ResourceLocation(CrystalTech.MOD_ID, "textures/gui/dummies/coal_matrix_gui.png");

    public static final RecipeType<StirlingMatrixFuel> STIRLING_MATRIX_TYPE =
            new RecipeType<>(UID, StirlingMatrixFuel.class);

    private final IDrawable background;
    private final IDrawable icon;

    public StirlingMatrixFuelCategory(IGuiHelper helper) {
        this.background = helper.createDrawable(TEXTURE, 0, 0, 176, 78);
        this.icon = helper.createDrawableIngredient(VanillaTypes.ITEM_STACK, new ItemStack(ModBlocks.COAL_MATRIX.get()));
    }


    @Override
    public RecipeType<StirlingMatrixFuel> getRecipeType() {
        return STIRLING_MATRIX_TYPE;
    }

    @Override
    public Component getTitle() {
        return Component.literal("Stirling Matrix");
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
    public void setRecipe(IRecipeLayoutBuilder iRecipeLayoutBuilder, StirlingMatrixFuel stirlingMatrixFuel, IFocusGroup iFocusGroup) {

        if (!stirlingMatrixFuel.getFuelItems().isEmpty()) {
            iRecipeLayoutBuilder.addSlot(RecipeIngredientRole.INPUT, 77, 17).addIngredients(stirlingMatrixFuel.getIngredients().get(0));
        }
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


    public List<Component> getTooltipStrings(StirlingMatrixFuel fuel, IRecipeSlotsView recipeSlotsView, double mouseX, double mouseY)
    {
        int x = (176 - 86)/2;
        int y = 166 / 2;

        if(mouseX >= x + 110 && mouseX <= x + 120 && mouseY >= 10 && mouseY <= 76)
        {
            float time = fuel.getBurnTime();
            float energy = fuel.getEnergyAmount();
            float energyPerTick = (float) fuel.getEnergyAmount() / fuel.getBurnTime();
            formatDouble(energy, "#.##");
            formatDouble(energyPerTick, "#.##");
            return Arrays.asList(
                    Component.literal("Energy Yield/Tick: " + formatDouble(energyPerTick, "#.##") + " FE"),
                    Component.literal("Craft Time: " + formatDouble(time/20, "#.##") + "s"),
                    Component.literal("Total Energy Yield: " + formatDouble(energy, "#.##") + " FE")
            );
        }
        return IRecipeCategory.super.getTooltipStrings(fuel, recipeSlotsView, mouseX, mouseY);
    }
}
