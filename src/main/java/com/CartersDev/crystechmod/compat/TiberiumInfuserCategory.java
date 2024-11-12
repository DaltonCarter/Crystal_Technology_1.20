package com.CartersDev.crystechmod.compat;

import com.CartersDev.crystechmod.CrystalTech;
import com.CartersDev.crystechmod.block.ModBlocks;
import com.CartersDev.crystechmod.recipe.TiberiumGrinderRecipe;
import com.CartersDev.crystechmod.recipe.TiberiumInfuserRecipe;
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

public class TiberiumInfuserCategory implements IRecipeCategory<TiberiumInfuserRecipe> {
    public static final ResourceLocation UID = new ResourceLocation(CrystalTech.MOD_ID, "tiberium_infusing");
    public static final ResourceLocation TEXTURE = new ResourceLocation(CrystalTech.MOD_ID, "textures/gui/tiberium_infuser_gui.png");

public static final RecipeType<TiberiumInfuserRecipe> TIBERIUM_INFUSING_TYPE =
new RecipeType<>(UID, TiberiumInfuserRecipe.class);

private final IDrawable background;
private final IDrawable icon;

    public TiberiumInfuserCategory(IGuiHelper helper) {
        this.background = helper.createDrawable(TEXTURE, 0, 0, 176, 85);
        this.icon = helper.createDrawableIngredient(VanillaTypes.ITEM_STACK, new ItemStack(ModBlocks.TIBERIUM_INFUSER.get()));
    }


    @Override
    public RecipeType<TiberiumInfuserRecipe> getRecipeType() {
        return TIBERIUM_INFUSING_TYPE;
    }

    @Override
    public Component getTitle() {
        return Component.translatable("block.crystechmod.tiberium_infuser");
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
    public void setRecipe(IRecipeLayoutBuilder iRecipeLayoutBuilder, TiberiumInfuserRecipe tiberiumInfuserRecipe, IFocusGroup iFocusGroup) {
        iRecipeLayoutBuilder.addSlot(RecipeIngredientRole.INPUT, 80, 11).addIngredients(tiberiumInfuserRecipe.getIngredients().get(0));
        iRecipeLayoutBuilder.addSlot(RecipeIngredientRole.OUTPUT, 80, 59).addItemStack(tiberiumInfuserRecipe.getResultItem(null));
    }
}
