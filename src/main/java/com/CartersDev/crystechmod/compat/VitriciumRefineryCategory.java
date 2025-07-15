package com.CartersDev.crystechmod.compat;

import com.CartersDev.crystechmod.CrystalTech;
import com.CartersDev.crystechmod.block.ModBlocks;
import com.CartersDev.crystechmod.recipe.TiberiumInfuserRecipe;
import com.CartersDev.crystechmod.recipe.VitriciumRefineryRecipe;
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

import static com.CartersDev.crystechmod.compat.TiberiumInfuserCategory.TIBERIUM_INFUSING_TYPE;

public class VitriciumRefineryCategory implements IRecipeCategory<VitriciumRefineryRecipe> {
    public static final ResourceLocation UID = new ResourceLocation(CrystalTech.MOD_ID, "vitric_refining");
    public static final ResourceLocation TEXTURE = new ResourceLocation(CrystalTech.MOD_ID, "textures/gui/vitricium_refinery_gui.png");

public static final RecipeType<VitriciumRefineryRecipe> VITRIC_REFINING_TYPE =
new RecipeType<>(UID, VitriciumRefineryRecipe.class);

private final IDrawable background;
private final IDrawable icon;

    public VitriciumRefineryCategory(IGuiHelper helper) {
        this.background = helper.createDrawable(TEXTURE, 0, 0, 176, 85);
        this.icon = helper.createDrawableIngredient(VanillaTypes.ITEM_STACK, new ItemStack(ModBlocks.VITRICIUM_REFINERY.get()));
    }


    @Override
    public RecipeType<VitriciumRefineryRecipe> getRecipeType() {
        return VITRIC_REFINING_TYPE;
    }

    @Override
    public Component getTitle() {
        return Component.literal("Vitricium Refinery");
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
        iRecipeLayoutBuilder.addSlot(RecipeIngredientRole.INPUT, 80, 11).addIngredients(vitriciumRefineryRecipe.getIngredients().get(0));

    }
}
