package com.CartersDev.crystechmod.compat;

import com.CartersDev.crystechmod.CrystalTech;
import com.CartersDev.crystechmod.block.ModBlocks;
import com.CartersDev.crystechmod.recipe.TiberiumGrinderRecipe;
import com.CartersDev.crystechmod.recipe.TiberiumMaceratorRecipe;
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

public class TiberiumMaceratingCategory implements IRecipeCategory<TiberiumMaceratorRecipe> {
    public static final ResourceLocation UID = new ResourceLocation(CrystalTech.MOD_ID, "tiberium_macerating");
    public static final ResourceLocation TEXTURE = new ResourceLocation(CrystalTech.MOD_ID, "textures/gui/tiberium_macerator_gui.png");

public static final RecipeType<TiberiumMaceratorRecipe> TIBERIUM_MACERATING_TYPE =
new RecipeType<>(UID, TiberiumMaceratorRecipe.class);

private final IDrawable background;
private final IDrawable icon;

    public TiberiumMaceratingCategory(IGuiHelper helper) {
        this.background = helper.createDrawable(TEXTURE, 0, 0, 176, 85);
        this.icon = helper.createDrawableIngredient(VanillaTypes.ITEM_STACK, new ItemStack(ModBlocks.TIBERIUM_MACERATOR.get()));
    }


    @Override
    public RecipeType<TiberiumMaceratorRecipe> getRecipeType() {
        return TIBERIUM_MACERATING_TYPE;
    }

    @Override
    public Component getTitle() {
        return Component.translatable("block.crystechmod.tiberium_macerator");
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
}
