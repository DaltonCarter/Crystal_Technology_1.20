package com.CartersDev.crystechmod.compat;

import com.CartersDev.crystechmod.CrystalTech;
import com.CartersDev.crystechmod.block.ModBlocks;
import com.CartersDev.crystechmod.recipe.PoweredKilnRecipe;
import com.CartersDev.crystechmod.recipe.TiberiumMaceratorRecipe;
import mezz.jei.api.constants.VanillaTypes;
import mezz.jei.api.gui.builder.IRecipeLayoutBuilder;
import mezz.jei.api.gui.drawable.IDrawable;
import mezz.jei.api.gui.ingredient.IRecipeSlotsView;
import mezz.jei.api.helpers.IGuiHelper;
import mezz.jei.api.recipe.IFocusGroup;
import mezz.jei.api.recipe.RecipeIngredientRole;
import mezz.jei.api.recipe.RecipeType;
import mezz.jei.api.recipe.category.IRecipeCategory;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import org.jetbrains.annotations.Nullable;

import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.List;

public class PoweredKilnCategory implements IRecipeCategory<PoweredKilnRecipe> {
    public static final ResourceLocation UID = new ResourceLocation(CrystalTech.MOD_ID, "powered_smelting");
    public static final ResourceLocation TEXTURE = new ResourceLocation(CrystalTech.MOD_ID, "textures/gui/dummies/powered_kiln_gui.png");

public static final RecipeType<PoweredKilnRecipe> POWERED_KILN_TYPE =
new RecipeType<>(UID, PoweredKilnRecipe.class);

private final IDrawable background;
private final IDrawable icon;

    public PoweredKilnCategory(IGuiHelper helper) {
        this.background = helper.createDrawable(TEXTURE, 0, 0, 176, 78);
        this.icon = helper.createDrawableIngredient(VanillaTypes.ITEM_STACK, new ItemStack(ModBlocks.POWERED_KILN.get()));
    }


    @Override
    public RecipeType<PoweredKilnRecipe> getRecipeType() {
        return POWERED_KILN_TYPE;
    }

    @Override
    public Component getTitle() {
        return Component.literal("All Powered Kilns");
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
    public void setRecipe(IRecipeLayoutBuilder iRecipeLayoutBuilder, PoweredKilnRecipe poweredKilnRecipe, IFocusGroup iFocusGroup) {
        if (!poweredKilnRecipe.getIngredients().isEmpty()) {
            iRecipeLayoutBuilder.addSlot(RecipeIngredientRole.INPUT, 56, 17).addIngredients(poweredKilnRecipe.getIngredients().get(0));
        }
        iRecipeLayoutBuilder.addSlot(RecipeIngredientRole.OUTPUT, 116, 35).addItemStack(poweredKilnRecipe.getResultItem(Minecraft.getInstance().level.registryAccess()));
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


    public List<Component> getTooltipStrings(PoweredKilnRecipe recipe, IRecipeSlotsView recipeSlotsView, double mouseX, double mouseY)
    {
        int x = (176 - 86)/2;
        int y = 166 / 2;

        if(mouseX >= x + 110 && mouseX <= x + 120 && mouseY >= 10 && mouseY <= 76)
        {
            float time = recipe.getCraftTime();
            float energy = recipe.getEnergyAmount();
            float totalEnergy = energy * time;

            return Arrays.asList(
                    Component.literal("Total Cost: " + formatDouble(totalEnergy, "#.##") + " FE"),
                    Component.literal("Craft Time: " + formatDouble(time / 20.0, "#.##") + "s")
            );
        }
        return IRecipeCategory.super.getTooltipStrings(recipe, recipeSlotsView, mouseX, mouseY);
    }

}
