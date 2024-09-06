package com.CartersDev.crystechmod.compat;

import com.CartersDev.crystechmod.CrystalTech;
import com.CartersDev.crystechmod.block.ModBlocks;
import com.CartersDev.crystechmod.recipe.TiberiumGrinderRecipe;
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

public class TiberiumGrindingCategory implements IRecipeCategory<TiberiumGrinderRecipe> {
    public static final ResourceLocation UID = new ResourceLocation(CrystalTech.MOD_ID, "tiberium_grinding");
    public static final ResourceLocation TEXTURE = new ResourceLocation(CrystalTech.MOD_ID, "textures/gui/tiberium_grinder.png");

public static final RecipeType<TiberiumGrinderRecipe> TIBERIUM_GRINDING_TYPE =
new RecipeType<>(UID, TiberiumGrinderRecipe.class);

private final IDrawable background;
private final IDrawable icon;

    public TiberiumGrindingCategory(IGuiHelper helper) {
        this.background = helper.createDrawable(TEXTURE, 0, 0, 176, 85);
        this.icon = helper.createDrawableIngredient(VanillaTypes.ITEM_STACK, new ItemStack(ModBlocks.TIBERIUM_GRINDER.get()));
    }


    @Override
    public RecipeType<TiberiumGrinderRecipe> getRecipeType() {
        return TIBERIUM_GRINDING_TYPE;
    }

    @Override
    public Component getTitle() {
        return Component.translatable("block.crystechmod.tiberium_grinder");
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
    public void setRecipe(IRecipeLayoutBuilder iRecipeLayoutBuilder, TiberiumGrinderRecipe tiberiumGrinderRecipe, IFocusGroup iFocusGroup) {
        iRecipeLayoutBuilder.addSlot(RecipeIngredientRole.INPUT, 80, 11).addIngredients(tiberiumGrinderRecipe.getIngredients().get(0));
        iRecipeLayoutBuilder.addSlot(RecipeIngredientRole.OUTPUT, 80, 59).addItemStack(tiberiumGrinderRecipe.getResultItem(null));
    }
}
