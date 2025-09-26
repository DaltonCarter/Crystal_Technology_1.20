package com.CartersDev.crystechmod.compat;

import com.CartersDev.crystechmod.CrystalTech;
import com.CartersDev.crystechmod.block.ModBlocks;
import com.CartersDev.crystechmod.datagen.custom.AlloyKilnRecipeBuilder;
import com.CartersDev.crystechmod.recipe.AlloyKilnRecipe;
import com.CartersDev.crystechmod.recipe.PoweredKilnRecipe;
import com.CartersDev.crystechmod.recipe.TiberiumMaceratorRecipe;
import com.CartersDev.crystechmod.util.crafting.CountedIngredient;
import mezz.jei.api.constants.VanillaTypes;
import mezz.jei.api.gui.builder.IRecipeLayoutBuilder;
import mezz.jei.api.gui.drawable.IDrawable;
import mezz.jei.api.gui.drawable.IDrawableStatic;
import mezz.jei.api.gui.ingredient.IRecipeSlotsView;
import mezz.jei.api.helpers.IGuiHelper;
import mezz.jei.api.recipe.IFocusGroup;
import mezz.jei.api.recipe.RecipeIngredientRole;
import mezz.jei.api.recipe.RecipeType;
import mezz.jei.api.recipe.category.IRecipeCategory;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import org.jetbrains.annotations.Nullable;

import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.List;

public class AlloyKilnCategory implements IRecipeCategory<AlloyKilnRecipe> {
    public static final ResourceLocation UID = new ResourceLocation(CrystalTech.MOD_ID, "alloy_smelting");
    public static final ResourceLocation TEXTURE = new ResourceLocation(CrystalTech.MOD_ID, "textures/gui/dummies/alloy_kiln_gui.png");

public static final RecipeType<AlloyKilnRecipe> ALLOY_KILN_TYPE =
new RecipeType<>(UID, AlloyKilnRecipe.class);

private final IDrawable background;
private final IDrawable icon;


    public AlloyKilnCategory(IGuiHelper helper) {
        this.background = helper.createDrawable(TEXTURE, 0, 0, 176, 83);
        this.icon = helper.createDrawableIngredient(VanillaTypes.ITEM_STACK, new ItemStack(ModBlocks.ALLOY_KILN.get()));

    }


    @Override
    public RecipeType<AlloyKilnRecipe> getRecipeType() {
        return ALLOY_KILN_TYPE;
    }

    @Override
    public Component getTitle() {
        return Component.literal("All Alloy Kilns");
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
    public void setRecipe(IRecipeLayoutBuilder iRecipeLayoutBuilder, AlloyKilnRecipe alloyKilnRecipe, IFocusGroup iFocusGroup) {
        List<CountedIngredient> inputs = alloyKilnRecipe.getInputItems();

        iRecipeLayoutBuilder.addSlot(RecipeIngredientRole.INPUT, 33, 11).addItemStacks(inputs.get(0).getItems());
        iRecipeLayoutBuilder.addSlot(RecipeIngredientRole.INPUT, 56, 11).addItemStacks(inputs.get(1).getItems());
        iRecipeLayoutBuilder.addSlot(RecipeIngredientRole.INPUT, 79, 11).addItemStacks(inputs.get(2).getItems());
        iRecipeLayoutBuilder.addSlot(RecipeIngredientRole.OUTPUT, 116, 35).addItemStack(alloyKilnRecipe.getResultItem(null));
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


    public List<Component> getTooltipStrings(AlloyKilnRecipe recipe, IRecipeSlotsView recipeSlotsView, double mouseX, double mouseY)
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
