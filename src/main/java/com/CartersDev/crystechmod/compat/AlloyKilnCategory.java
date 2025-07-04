package com.CartersDev.crystechmod.compat;

import com.CartersDev.crystechmod.CrystalTech;
import com.CartersDev.crystechmod.block.ModBlocks;
import com.CartersDev.crystechmod.datagen.custom.AlloyKilnRecipeBuilder;
import com.CartersDev.crystechmod.recipe.AlloyKilnRecipe;
import com.CartersDev.crystechmod.recipe.PoweredKilnRecipe;
import mezz.jei.api.constants.VanillaTypes;
import mezz.jei.api.gui.builder.IRecipeLayoutBuilder;
import mezz.jei.api.gui.drawable.IDrawable;
import mezz.jei.api.helpers.IGuiHelper;
import mezz.jei.api.recipe.IFocusGroup;
import mezz.jei.api.recipe.RecipeIngredientRole;
import mezz.jei.api.recipe.RecipeType;
import mezz.jei.api.recipe.category.IRecipeCategory;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import org.jetbrains.annotations.Nullable;

public class AlloyKilnCategory implements IRecipeCategory<AlloyKilnRecipe> {
    public static final ResourceLocation UID = new ResourceLocation(CrystalTech.MOD_ID, "alloy_smelting");
    public static final ResourceLocation TEXTURE = new ResourceLocation(CrystalTech.MOD_ID, "textures/gui/alloy_kiln_gui.png");

public static final RecipeType<AlloyKilnRecipe> ALLOY_KILN_TYPE =
new RecipeType<>(UID, AlloyKilnRecipe.class);

private final IDrawable background;
private final IDrawable icon;

    public AlloyKilnCategory(IGuiHelper helper) {
        this.background = helper.createDrawable(TEXTURE, 0, 0, 176, 85);
        this.icon = helper.createDrawableIngredient(VanillaTypes.ITEM_STACK, new ItemStack(ModBlocks.ALLOY_KILN.get()));
    }


    @Override
    public RecipeType<AlloyKilnRecipe> getRecipeType() {
        return ALLOY_KILN_TYPE;
    }

    @Override
    public Component getTitle() {
        return Component.literal("Alloy Kiln");
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
        iRecipeLayoutBuilder.addSlot(RecipeIngredientRole.INPUT, 33, 11).addIngredients(alloyKilnRecipe.getIngredients().get(0));
        iRecipeLayoutBuilder.addSlot(RecipeIngredientRole.INPUT, 56, 11).addIngredients(alloyKilnRecipe.getIngredients().get(1));
        iRecipeLayoutBuilder.addSlot(RecipeIngredientRole.INPUT, 79, 11).addIngredients(alloyKilnRecipe.getIngredients().get(2));
        iRecipeLayoutBuilder.addSlot(RecipeIngredientRole.OUTPUT, 116, 35).addItemStack(alloyKilnRecipe.getResultItem(null));
    }
}
