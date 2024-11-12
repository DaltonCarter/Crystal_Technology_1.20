package com.CartersDev.crystechmod.compat;


import com.CartersDev.crystechmod.CrystalTech;
import com.CartersDev.crystechmod.recipe.TiberiumGrinderRecipe;
import com.CartersDev.crystechmod.recipe.TiberiumInfuserRecipe;
import com.CartersDev.crystechmod.screen.TiberiumGrinderScreen;
import com.CartersDev.crystechmod.screen.TiberiumInfuserScreen;
import mezz.jei.api.IModPlugin;
import mezz.jei.api.JeiPlugin;
import mezz.jei.api.registration.IGuiHandlerRegistration;
import mezz.jei.api.registration.IRecipeCategoryRegistration;
import mezz.jei.api.registration.IRecipeRegistration;
import net.minecraft.client.Minecraft;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.crafting.RecipeManager;

import java.util.List;

@JeiPlugin
public class JEICrystalTechModPlugin implements IModPlugin {
    @Override
    public ResourceLocation getPluginUid() {
        return new ResourceLocation(CrystalTech.MOD_ID, "jei_plugin");
    }

    @Override
    public void registerCategories(IRecipeCategoryRegistration registration) {
        registration.addRecipeCategories(new TiberiumGrindingCategory(registration.getJeiHelpers().getGuiHelper()));
        registration.addRecipeCategories(new TiberiumInfuserCategory(registration.getJeiHelpers().getGuiHelper()));
    }

    @Override
    public void registerRecipes(IRecipeRegistration registration) {
        RecipeManager recipeManager = Minecraft.getInstance().level.getRecipeManager();
        List<TiberiumGrinderRecipe> grindingRecipes = recipeManager.getAllRecipesFor(TiberiumGrinderRecipe.Type.INSTANCE);
        registration.addRecipes(TiberiumGrindingCategory.TIBERIUM_GRINDING_TYPE, grindingRecipes);

        RecipeManager infuserRecipeManager = Minecraft.getInstance().level.getRecipeManager();
        List<TiberiumInfuserRecipe> infuseingRecipes = recipeManager.getAllRecipesFor(TiberiumInfuserRecipe.Type.INSTANCE);
        registration.addRecipes(TiberiumInfuserCategory.TIBERIUM_INFUSING_TYPE, infuseingRecipes);
    }

    @Override
    public void registerGuiHandlers(IGuiHandlerRegistration registration) {
        registration.addRecipeClickArea(TiberiumGrinderScreen.class, 70, 35, 20, 30,
                TiberiumGrindingCategory.TIBERIUM_GRINDING_TYPE);

        registration.addRecipeClickArea(TiberiumInfuserScreen.class, 70, 35, 20, 30,
                TiberiumInfuserCategory.TIBERIUM_INFUSING_TYPE);
    }
}
