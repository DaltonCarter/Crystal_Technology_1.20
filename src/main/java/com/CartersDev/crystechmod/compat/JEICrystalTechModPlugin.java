package com.CartersDev.crystechmod.compat;


import com.CartersDev.crystechmod.CrystalTech;
import com.CartersDev.crystechmod.recipe.*;
import com.CartersDev.crystechmod.screen.alloyKilnScreen.AlloyKilnScreen;
import com.CartersDev.crystechmod.screen.alloyKilnScreen.AlythumAlloyKilnScreen;
import com.CartersDev.crystechmod.screen.alloyKilnScreen.CrystalCoreAlloyKilnScreen;
import com.CartersDev.crystechmod.screen.alloyKilnScreen.VitricAlloyKilnScreen;
import com.CartersDev.crystechmod.screen.grinderScreen.TiberiumGrinderScreen;
import com.CartersDev.crystechmod.screen.infuserScreen.AlythumTiberiumInfuserScreen;
import com.CartersDev.crystechmod.screen.infuserScreen.CrystalCoreTiberiumInfuserScreen;
import com.CartersDev.crystechmod.screen.infuserScreen.TiberiumInfuserScreen;
import com.CartersDev.crystechmod.screen.infuserScreen.VitricTiberiumInfuserScreen;
import com.CartersDev.crystechmod.screen.maceratorScreen.AlythumTiberiumMaceratorScreen;
import com.CartersDev.crystechmod.screen.maceratorScreen.CrystalCoreTiberiumMaceratorScreen;
import com.CartersDev.crystechmod.screen.maceratorScreen.TiberiumMaceratorScreen;
import com.CartersDev.crystechmod.screen.maceratorScreen.VitricTiberiumMaceratorScreen;
import com.CartersDev.crystechmod.screen.poweredKilnScreen.AlythumKilnScreen;
import com.CartersDev.crystechmod.screen.poweredKilnScreen.CrystalCoreKilnScreen;
import com.CartersDev.crystechmod.screen.poweredKilnScreen.PoweredKilnScreen;
import com.CartersDev.crystechmod.screen.poweredKilnScreen.VitricKilnScreen;
import com.CartersDev.crystechmod.screen.vitriciumRefineryScreen.AlythumVitriciumRefineryScreen;
import com.CartersDev.crystechmod.screen.vitriciumRefineryScreen.CrystalCoreVitriciumRefineryScreen;
import com.CartersDev.crystechmod.screen.vitriciumRefineryScreen.VitricVitriciumRefineryScreen;
import com.CartersDev.crystechmod.screen.vitriciumRefineryScreen.VitriciumRefineryScreen;
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
        registration.addRecipeCategories(new TiberiumMaceratingCategory(registration.getJeiHelpers().getGuiHelper()));
        registration.addRecipeCategories(new TiberiumInfuserCategory(registration.getJeiHelpers().getGuiHelper()));
        registration.addRecipeCategories(new PoweredKilnCategory(registration.getJeiHelpers().getGuiHelper()));
        registration.addRecipeCategories(new AlloyKilnCategory(registration.getJeiHelpers().getGuiHelper()));
        registration.addRecipeCategories(new VitriciumRefineryCategory(registration.getJeiHelpers().getGuiHelper()));
    }

    @Override
    public void registerRecipes(IRecipeRegistration registration) {

        RecipeManager recipeManager = Minecraft.getInstance().level.getRecipeManager();
        List<TiberiumGrinderRecipe> grindingRecipes = recipeManager.getAllRecipesFor(TiberiumGrinderRecipe.Type.INSTANCE);
        registration.addRecipes(TiberiumGrindingCategory.TIBERIUM_GRINDING_TYPE, grindingRecipes);

        RecipeManager maceratorRecipeManager = Minecraft.getInstance().level.getRecipeManager();
        List<TiberiumMaceratorRecipe> maceratingRecipes = maceratorRecipeManager.getAllRecipesFor(TiberiumMaceratorRecipe.Type.INSTANCE);
        registration.addRecipes(TiberiumMaceratingCategory.TIBERIUM_MACERATING_TYPE, maceratingRecipes);

        RecipeManager infuserRecipeManager = Minecraft.getInstance().level.getRecipeManager();
        List<TiberiumInfuserRecipe> infuseingRecipes = infuserRecipeManager.getAllRecipesFor(TiberiumInfuserRecipe.Type.INSTANCE);
        registration.addRecipes(TiberiumInfuserCategory.TIBERIUM_INFUSING_TYPE, infuseingRecipes);

        RecipeManager poweredKilnRecipeManager = Minecraft.getInstance().level.getRecipeManager();
        List<PoweredKilnRecipe> poweredKilnRecipes = poweredKilnRecipeManager.getAllRecipesFor(PoweredKilnRecipe.Type.INSTANCE);
        registration.addRecipes(PoweredKilnCategory.POWERED_KILN_TYPE, poweredKilnRecipes);

        RecipeManager alloyKilnRecipeManager = Minecraft.getInstance().level.getRecipeManager();
        List<AlloyKilnRecipe> alloyKilnRecipes = alloyKilnRecipeManager.getAllRecipesFor(AlloyKilnRecipe.Type.INSTANCE);
        registration.addRecipes(AlloyKilnCategory.ALLOY_KILN_TYPE, alloyKilnRecipes);

        RecipeManager vitricRefineryRecipeManager = Minecraft.getInstance().level.getRecipeManager();
        List<VitriciumRefineryRecipe> refineryRecipes = vitricRefineryRecipeManager.getAllRecipesFor(VitriciumRefineryRecipe.Type.INSTANCE);
        registration.addRecipes(VitriciumRefineryCategory.VITRIC_REFINING_TYPE, refineryRecipes);
    }

    @Override
    public void registerGuiHandlers(IGuiHandlerRegistration registration) {
        registration.addRecipeClickArea(TiberiumGrinderScreen.class, 70, 35, 20, 30,
                TiberiumGrindingCategory.TIBERIUM_GRINDING_TYPE);



        registration.addRecipeClickArea(TiberiumMaceratorScreen.class, 70, 35, 20, 30,
                TiberiumMaceratingCategory.TIBERIUM_MACERATING_TYPE);

        registration.addRecipeClickArea(AlythumTiberiumMaceratorScreen.class, 70, 35, 20, 30,
                TiberiumMaceratingCategory.TIBERIUM_MACERATING_TYPE);

        registration.addRecipeClickArea(VitricTiberiumMaceratorScreen.class, 70, 35, 20, 30,
                TiberiumMaceratingCategory.TIBERIUM_MACERATING_TYPE);

        registration.addRecipeClickArea(CrystalCoreTiberiumMaceratorScreen.class, 70, 35, 20, 30,
                TiberiumMaceratingCategory.TIBERIUM_MACERATING_TYPE);



        registration.addRecipeClickArea(TiberiumInfuserScreen.class, 70, 35, 20, 30,
                TiberiumInfuserCategory.TIBERIUM_INFUSING_TYPE);

        registration.addRecipeClickArea(AlythumTiberiumInfuserScreen.class, 70, 35, 20, 30,
                TiberiumInfuserCategory.TIBERIUM_INFUSING_TYPE);

        registration.addRecipeClickArea(VitricTiberiumInfuserScreen.class, 70, 35, 20, 30,
                TiberiumInfuserCategory.TIBERIUM_INFUSING_TYPE);

        registration.addRecipeClickArea(CrystalCoreTiberiumInfuserScreen.class, 70, 35, 20, 30,
                TiberiumInfuserCategory.TIBERIUM_INFUSING_TYPE);



        registration.addRecipeClickArea(PoweredKilnScreen.class, 80, 35, 20, 30,
                PoweredKilnCategory.POWERED_KILN_TYPE);

        registration.addRecipeClickArea(AlythumKilnScreen.class, 80, 35, 20, 30,
                PoweredKilnCategory.POWERED_KILN_TYPE);

        registration.addRecipeClickArea(VitricKilnScreen.class, 80, 35, 20, 30,
                PoweredKilnCategory.POWERED_KILN_TYPE);

        registration.addRecipeClickArea(CrystalCoreKilnScreen.class, 80, 35, 20, 30,
                PoweredKilnCategory.POWERED_KILN_TYPE);



        registration.addRecipeClickArea(AlloyKilnScreen.class, 80, 35, 20, 30,
                AlloyKilnCategory.ALLOY_KILN_TYPE);

        registration.addRecipeClickArea(AlythumAlloyKilnScreen.class, 80, 35, 20, 30,
                AlloyKilnCategory.ALLOY_KILN_TYPE);

        registration.addRecipeClickArea(VitricAlloyKilnScreen.class, 80, 35, 20, 30,
                AlloyKilnCategory.ALLOY_KILN_TYPE);

        registration.addRecipeClickArea(CrystalCoreAlloyKilnScreen.class, 80, 35, 20, 30,
                AlloyKilnCategory.ALLOY_KILN_TYPE);



        registration.addRecipeClickArea(VitriciumRefineryScreen.class, 75, 25, 30, 10,
                VitriciumRefineryCategory.VITRIC_REFINING_TYPE);

        registration.addRecipeClickArea(AlythumVitriciumRefineryScreen.class, 75, 25, 30, 10,
                VitriciumRefineryCategory.VITRIC_REFINING_TYPE);

        registration.addRecipeClickArea(VitricVitriciumRefineryScreen.class, 75, 25, 30, 10,
                VitriciumRefineryCategory.VITRIC_REFINING_TYPE);

        registration.addRecipeClickArea(CrystalCoreVitriciumRefineryScreen.class, 75, 25, 30, 10,
                VitriciumRefineryCategory.VITRIC_REFINING_TYPE);
    }

}
