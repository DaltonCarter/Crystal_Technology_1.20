package com.CartersDev.crystechmod.compat;

import com.CartersDev.crystechmod.CrystalTech;
import com.CartersDev.crystechmod.block.ModBlocks;
import com.CartersDev.crystechmod.recipe.TiberiumInfuserRecipe;
import com.CartersDev.crystechmod.recipe.TiberiumMaceratorRecipe;
import com.CartersDev.crystechmod.recipe.VitriciumRefineryRecipe;
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
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import org.jetbrains.annotations.Nullable;

import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.List;

import static com.CartersDev.crystechmod.compat.TiberiumInfuserCategory.TIBERIUM_INFUSING_TYPE;

public class VitriciumRefineryCategory implements IRecipeCategory<VitriciumRefineryRecipe> {
    public static final ResourceLocation UID = new ResourceLocation(CrystalTech.MOD_ID, "vitric_refining");
    public static final ResourceLocation TEXTURE = new ResourceLocation(CrystalTech.MOD_ID, "textures/gui/dummies/vitricium_refinery_gui.png");

public static final RecipeType<VitriciumRefineryRecipe> VITRIC_REFINING_TYPE =
new RecipeType<>(UID, VitriciumRefineryRecipe.class);

private final IDrawable background;
private final IDrawable icon;

    public VitriciumRefineryCategory(IGuiHelper helper) {
        this.background = helper.createDrawable(TEXTURE, 0, 0, 176, 78);
        this.icon = helper.createDrawableIngredient(VanillaTypes.ITEM_STACK, new ItemStack(ModBlocks.VITRICIUM_REFINERY.get()));
    }


    @Override
    public RecipeType<VitriciumRefineryRecipe> getRecipeType() {
        return VITRIC_REFINING_TYPE;
    }

    @Override
    public Component getTitle() {
        return Component.literal("All Vitricium Refineries");
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
    public void setRecipe(IRecipeLayoutBuilder iRecipeLayoutBuilder, VitriciumRefineryRecipe vitriciumRefineryRecipe, IFocusGroup iFocusGroup) {
        iRecipeLayoutBuilder.addSlot(RecipeIngredientRole.INPUT, 50, 24).addIngredients(vitriciumRefineryRecipe.getIngredients().get(0));
        iRecipeLayoutBuilder.addSlot(RecipeIngredientRole.INPUT, 26, 11)
                .addIngredients(ForgeTypes.FLUID_STACK, List.of(vitriciumRefineryRecipe.getFluidStack()))
                .setFluidRenderer(8000, false, 16, 39);
        iRecipeLayoutBuilder.addSlot(RecipeIngredientRole.OUTPUT, 107, 11)
                .addIngredients(ForgeTypes.FLUID_STACK, List.of(vitriciumRefineryRecipe.getOutputFluidStack()))
                .setFluidRenderer(8000, false, 16, 39);
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


    public List<Component> getTooltipStrings(VitriciumRefineryRecipe recipe, IRecipeSlotsView recipeSlotsView, double mouseX, double mouseY)
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
