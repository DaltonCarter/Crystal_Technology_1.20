package com.CartersDev.crystechmod.compat;

import com.CartersDev.crystechmod.CrystalTech;
import com.CartersDev.crystechmod.block.ModBlocks;
import com.CartersDev.crystechmod.recipe.FluidCanisterCraftingRecipe;
import com.CartersDev.crystechmod.recipe.FluidCanisterCraftingRecipe;
import com.CartersDev.crystechmod.recipe.TiberiumInfuserRecipe;
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
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.fluids.FluidStack;
import org.jetbrains.annotations.Nullable;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class FluidCanisterCraftingCategory implements IRecipeCategory<FluidCanisterCraftingRecipe> {
    public static final ResourceLocation UID = new ResourceLocation(CrystalTech.MOD_ID, "fluid_canister_crafting");
    public static final ResourceLocation TEXTURE = new ResourceLocation(CrystalTech.MOD_ID, "textures/gui/dummies/crafting_table_with_fluid_gui.png");

public static final RecipeType<FluidCanisterCraftingRecipe> FLUID_CANISTER_TYPE =
new RecipeType<>(UID, FluidCanisterCraftingRecipe.class);

private final IDrawable background;
private final IDrawable icon;

    public FluidCanisterCraftingCategory(IGuiHelper helper) {
        this.background = helper.createDrawable(TEXTURE,  0, 0, 176, 83);
        this.icon = helper.createDrawableIngredient(VanillaTypes.ITEM_STACK, new ItemStack(Blocks.CRAFTING_TABLE));
    }


    @Override
    public RecipeType<FluidCanisterCraftingRecipe> getRecipeType() {
        return FLUID_CANISTER_TYPE;
    }

    @Override
    public Component getTitle() {
        return Component.literal("Crafting w/ Fluid Canisters");
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
    public void setRecipe(IRecipeLayoutBuilder iRecipeLayoutBuilder, FluidCanisterCraftingRecipe FluidCanisterCraftingRecipe, IFocusGroup iFocusGroup) {
       iRecipeLayoutBuilder.addSlot(RecipeIngredientRole.INPUT, 8, 17)
               .addTooltipCallback((recipeSlotView, tooltip) -> {
                   tooltip.add(Component.literal("§4Fluid Canister must contain this liquid, and minimum amount."));
               })
               .addIngredient(ForgeTypes.FLUID_STACK, new FluidStack(FluidCanisterCraftingRecipe.getRequiredFluid(), FluidCanisterCraftingRecipe.getRequiredAmount()))
               .setFluidRenderer(FluidCanisterCraftingRecipe.getRequiredAmount(), false, 16, 39);

        int index = 0;
        for (int y = 0; y < FluidCanisterCraftingRecipe.getRecipeHeight(); y++) {
            for (int x = 0; x < FluidCanisterCraftingRecipe.getRecipeWidth(); x++) {
                Ingredient ingredient = FluidCanisterCraftingRecipe.getIngredients().get(index);
                iRecipeLayoutBuilder.addSlot(RecipeIngredientRole.INPUT, 30 + (x * 18), 17 + (y * 18))
                        .addIngredients(ingredient);
                index++;
            }
        }

        iRecipeLayoutBuilder.addSlot(RecipeIngredientRole.OUTPUT, 124, 35)
                .addItemStack(FluidCanisterCraftingRecipe.getResultItem(net.minecraft.core.RegistryAccess.EMPTY));
    }


}
