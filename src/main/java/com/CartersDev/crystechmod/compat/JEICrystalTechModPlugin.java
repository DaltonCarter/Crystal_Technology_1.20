package com.CartersDev.crystechmod.compat;


import com.CartersDev.crystechmod.CrystalTech;
import com.CartersDev.crystechmod.block.ModBlocks;
import com.CartersDev.crystechmod.fluid.ModFluids;
import com.CartersDev.crystechmod.item.ModItems;
import com.CartersDev.crystechmod.item.custom.FluidCanisterItem;
import com.CartersDev.crystechmod.recipe.*;
import com.CartersDev.crystechmod.screen.AlloyKiln.alloyKilnScreen.AlloyKilnScreen;
import com.CartersDev.crystechmod.screen.AlloyKiln.alloyKilnScreen.AlythumAlloyKilnScreen;
import com.CartersDev.crystechmod.screen.AlloyKiln.alloyKilnScreen.CrystalCoreAlloyKilnScreen;
import com.CartersDev.crystechmod.screen.AlloyKiln.alloyKilnScreen.VitricAlloyKilnScreen;
import com.CartersDev.crystechmod.screen.Grinder.grinderScreen.TiberiumGrinderScreen;
import com.CartersDev.crystechmod.screen.Infuser.infuserScreen.AlythumTiberiumInfuserScreen;
import com.CartersDev.crystechmod.screen.Infuser.infuserScreen.CrystalCoreTiberiumInfuserScreen;
import com.CartersDev.crystechmod.screen.Infuser.infuserScreen.TiberiumInfuserScreen;
import com.CartersDev.crystechmod.screen.Infuser.infuserScreen.VitricTiberiumInfuserScreen;
import com.CartersDev.crystechmod.screen.Macerator.maceratorScreen.AlythumTiberiumMaceratorScreen;
import com.CartersDev.crystechmod.screen.Macerator.maceratorScreen.CrystalCoreTiberiumMaceratorScreen;
import com.CartersDev.crystechmod.screen.Macerator.maceratorScreen.TiberiumMaceratorScreen;
import com.CartersDev.crystechmod.screen.Macerator.maceratorScreen.VitricTiberiumMaceratorScreen;
import com.CartersDev.crystechmod.screen.PoweredKiln.poweredKilnScreen.AlythumKilnScreen;
import com.CartersDev.crystechmod.screen.PoweredKiln.poweredKilnScreen.CrystalCoreKilnScreen;
import com.CartersDev.crystechmod.screen.PoweredKiln.poweredKilnScreen.PoweredKilnScreen;
import com.CartersDev.crystechmod.screen.PoweredKiln.poweredKilnScreen.VitricKilnScreen;
import com.CartersDev.crystechmod.screen.StirlingMatrix.stirlingMatrixScreen.StirlingMatrixScreen;
import com.CartersDev.crystechmod.screen.VitriciumMatrix.vitriciumMatrixScreen.VitriciumMatrixScreen;
import com.CartersDev.crystechmod.screen.VitriciumRefinery.vitriciumRefineryScreen.AlythumVitriciumRefineryScreen;
import com.CartersDev.crystechmod.screen.VitriciumRefinery.vitriciumRefineryScreen.CrystalCoreVitriciumRefineryScreen;
import com.CartersDev.crystechmod.screen.VitriciumRefinery.vitriciumRefineryScreen.VitricVitriciumRefineryScreen;
import com.CartersDev.crystechmod.screen.VitriciumRefinery.vitriciumRefineryScreen.VitriciumRefineryScreen;
import com.CartersDev.crystechmod.util.crafting.CountedIngredient;
import mezz.jei.api.IModPlugin;
import mezz.jei.api.JeiPlugin;
import mezz.jei.api.constants.VanillaTypes;
import mezz.jei.api.ingredients.subtypes.IIngredientSubtypeInterpreter;
import mezz.jei.api.ingredients.subtypes.UidContext;
import mezz.jei.api.registration.*;
import mezz.jei.api.runtime.IIngredientManager;
import net.minecraft.client.Minecraft;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.*;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.material.Fluids;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fluids.FluidUtil;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.ArrayList;
import java.util.Collections;
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
        registration.addRecipeCategories(new VitriciumMatrixCategory(registration.getJeiHelpers().getGuiHelper()));
        registration.addRecipeCategories(new FluidCanisterCraftingCategory(registration.getJeiHelpers().getGuiHelper()));
        registration.addRecipeCategories(new StirlingMatrixFuelCategory(registration.getJeiHelpers().getGuiHelper()));
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
        List<PoweredKilnRecipe> kilnRecipes = new ArrayList<>(poweredKilnRecipes);
        List<BlastingRecipe> blastingRecipes = poweredKilnRecipeManager.getAllRecipesFor(RecipeType.BLASTING);
        for (BlastingRecipe recipe : blastingRecipes) {
            kilnRecipes.add(wrapVanillaRecipe(recipe, 45));
        }
        List<SmeltingRecipe> smeltingRecipes = poweredKilnRecipeManager.getAllRecipesFor(RecipeType.SMELTING);
        for (SmeltingRecipe recipe : smeltingRecipes) {
            kilnRecipes.add(wrapVanillaRecipe(recipe, 20));
        }

        registration.addRecipes(PoweredKilnCategory.POWERED_KILN_TYPE, kilnRecipes);

        RecipeManager alloyKilnRecipeManager = Minecraft.getInstance().level.getRecipeManager();
        List<AlloyKilnRecipe> alloyKilnRecipes = alloyKilnRecipeManager.getAllRecipesFor(AlloyKilnRecipe.Type.INSTANCE);
        registration.addRecipes(AlloyKilnCategory.ALLOY_KILN_TYPE, alloyKilnRecipes);

        RecipeManager vitricRefineryRecipeManager = Minecraft.getInstance().level.getRecipeManager();
        List<VitriciumRefineryRecipe> refineryRecipes = vitricRefineryRecipeManager.getAllRecipesFor(VitriciumRefineryRecipe.Type.INSTANCE);
        registration.addRecipes(VitriciumRefineryCategory.VITRIC_REFINING_TYPE, refineryRecipes);

        RecipeManager vitriciumMatrixRecipeManager = Minecraft.getInstance().level.getRecipeManager();
        List<VitriciumMatrixRecipe> matrixRecipes = vitriciumMatrixRecipeManager.getAllRecipesFor(VitriciumMatrixRecipe.Type.INSTANCE);
        registration.addRecipes(VitriciumMatrixCategory.VITRICIUM_MATRIX_TYPE, matrixRecipes);

        RecipeManager FluidCanisterRecipeManager = Minecraft.getInstance().level.getRecipeManager();
        List<FluidCanisterCraftingRecipe> canisterRecipes = FluidCanisterRecipeManager.getAllRecipesFor(FluidCanisterCraftingRecipe.Type.INSTANCE);
        registration.addRecipes(FluidCanisterCraftingCategory.FLUID_CANISTER_TYPE, canisterRecipes);

        RecipeManager stirlingMatrixFuelManager = Minecraft.getInstance().level.getRecipeManager();
        List<StirlingMatrixFuel> matrixFuel = stirlingMatrixFuelManager.getAllRecipesFor(StirlingMatrixFuel.Type.INSTANCE);
        registration.addRecipes(StirlingMatrixFuelCategory.STIRLING_MATRIX_TYPE, matrixFuel);

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

        registration.addRecipeClickArea(VitriciumMatrixScreen.class, 115, 30, 30, 10,
                VitriciumMatrixCategory.VITRICIUM_MATRIX_TYPE);

        registration.addRecipeClickArea(StirlingMatrixScreen.class, 115, 20, 30, 10,
                StirlingMatrixFuelCategory.STIRLING_MATRIX_TYPE);
    }

    private PoweredKilnRecipe wrapVanillaRecipe(AbstractCookingRecipe vanillaRecipe, int fePerTick) {
        Ingredient vanillaIngredient = vanillaRecipe.getIngredients().isEmpty()
                ? net.minecraft.world.item.crafting.Ingredient.of()
                : vanillaRecipe.getIngredients().get(0);
        CountedIngredient wrappedInput = CountedIngredient.of(vanillaIngredient);
        List<CountedIngredient> inputItems = Collections.singletonList(wrappedInput);

        return new PoweredKilnRecipe(
                vanillaRecipe.getId(),
                vanillaRecipe.getResultItem(Minecraft.getInstance().level.registryAccess()),
                inputItems,
                vanillaRecipe.getCookingTime(),
                fePerTick
        );
    }

    @Override
    public void registerRuntime(IRuntimeRegistration registration) {
        IIngredientManager ingredientManager = registration.getIngredientManager();

        List<ItemStack> canisterVariants = new ArrayList<>();

        Item canister = ModItems.EMPTY_CANISTER.get();
        canisterVariants.add(FluidCanisterItem.getFilledVariant(canister, Fluids.LAVA, 1000));
        canisterVariants.add(FluidCanisterItem.getFilledVariant(canister, ModFluids.SOURCE_MOLTEN_TIBERIUM.get(), 1000));
        canisterVariants.add(FluidCanisterItem.getFilledVariant(canister, ModFluids.SOURCE_MOLTEN_BLUE_TIBERIUM.get(), 1000));
        canisterVariants.add(FluidCanisterItem.getFilledVariant(canister, ModFluids.SOURCE_MOLTEN_RED_TIBERIUM.get(), 1000));
        canisterVariants.add(FluidCanisterItem.getFilledVariant(canister, ModFluids.SOURCE_MOLTEN_PURPLE_TIBERIUM.get(), 1000));
        canisterVariants.add(FluidCanisterItem.getFilledVariant(canister, ModFluids.SOURCE_LIQUID_PROTOCULTURE.get(), 1000));

        Item improvedCanister = ModItems.IMPROVED_EMPTY_CANISTER.get();
        canisterVariants.add(FluidCanisterItem.getFilledVariant(improvedCanister, Fluids.LAVA, 2500));
        canisterVariants.add(FluidCanisterItem.getFilledVariant(improvedCanister, ModFluids.SOURCE_MOLTEN_TIBERIUM.get(), 2500));
        canisterVariants.add(FluidCanisterItem.getFilledVariant(improvedCanister, ModFluids.SOURCE_MOLTEN_BLUE_TIBERIUM.get(), 2500));
        canisterVariants.add(FluidCanisterItem.getFilledVariant(improvedCanister, ModFluids.SOURCE_MOLTEN_RED_TIBERIUM.get(), 2500));
        canisterVariants.add(FluidCanisterItem.getFilledVariant(improvedCanister, ModFluids.SOURCE_MOLTEN_PURPLE_TIBERIUM.get(), 2500));
        canisterVariants.add(FluidCanisterItem.getFilledVariant(improvedCanister, ModFluids.SOURCE_LIQUID_PROTOCULTURE.get(), 2500));

        Item advancedCanister = ModItems.ADVANCED_EMPTY_CANISTER.get();
        canisterVariants.add(FluidCanisterItem.getFilledVariant(advancedCanister, Fluids.LAVA, 5000));
        canisterVariants.add(FluidCanisterItem.getFilledVariant(advancedCanister, ModFluids.SOURCE_MOLTEN_TIBERIUM.get(), 5000));
        canisterVariants.add(FluidCanisterItem.getFilledVariant(advancedCanister, ModFluids.SOURCE_MOLTEN_BLUE_TIBERIUM.get(), 5000));
        canisterVariants.add(FluidCanisterItem.getFilledVariant(advancedCanister, ModFluids.SOURCE_MOLTEN_RED_TIBERIUM.get(), 5000));
        canisterVariants.add(FluidCanisterItem.getFilledVariant(advancedCanister, ModFluids.SOURCE_MOLTEN_PURPLE_TIBERIUM.get(), 5000));
        canisterVariants.add(FluidCanisterItem.getFilledVariant(advancedCanister, ModFluids.SOURCE_LIQUID_PROTOCULTURE.get(), 5000));

        Item ultimateCanister = ModItems.ULTIMATE_EMPTY_CANISTER.get();
        canisterVariants.add(FluidCanisterItem.getFilledVariant(ultimateCanister, Fluids.LAVA, 10000));
        canisterVariants.add(FluidCanisterItem.getFilledVariant(ultimateCanister, ModFluids.SOURCE_MOLTEN_TIBERIUM.get(), 10000));
        canisterVariants.add(FluidCanisterItem.getFilledVariant(ultimateCanister, ModFluids.SOURCE_MOLTEN_BLUE_TIBERIUM.get(), 10000));
        canisterVariants.add(FluidCanisterItem.getFilledVariant(ultimateCanister, ModFluids.SOURCE_MOLTEN_RED_TIBERIUM.get(), 10000));
        canisterVariants.add(FluidCanisterItem.getFilledVariant(ultimateCanister, ModFluids.SOURCE_MOLTEN_PURPLE_TIBERIUM.get(), 10000));
        canisterVariants.add(FluidCanisterItem.getFilledVariant(ultimateCanister, ModFluids.SOURCE_LIQUID_PROTOCULTURE.get(), 10000));

        ingredientManager.addIngredientsAtRuntime(VanillaTypes.ITEM_STACK, canisterVariants);
    }

    @Override
    public void registerItemSubtypes(ISubtypeRegistration registration) {

        IIngredientSubtypeInterpreter<ItemStack> canisterInterpreter =
                (ItemStack itemStack, UidContext uidContext) -> {

                    if (!itemStack.hasTag()) {
                        return "empty";
                    }

                    return FluidUtil.getFluidHandler(itemStack).map(handler -> {
                        FluidStack fluid = handler.getFluidInTank(0);
                        if (fluid.isEmpty()) {
                            return "empty";
                        }

                        return ForgeRegistries.FLUIDS.getKey(fluid.getFluid()).toString() + "_" + fluid.getAmount();
                    }).orElse("empty");
                };

        registration.registerSubtypeInterpreter(
                ModItems.EMPTY_CANISTER.get(),
                canisterInterpreter
        );

        registration.registerSubtypeInterpreter(
                ModItems.IMPROVED_EMPTY_CANISTER.get(),
                canisterInterpreter
        );

        registration.registerSubtypeInterpreter(
                ModItems.ADVANCED_EMPTY_CANISTER.get(),
                canisterInterpreter
        );

        registration.registerSubtypeInterpreter(
                ModItems.ULTIMATE_EMPTY_CANISTER.get(),
                canisterInterpreter
        );


        IIngredientSubtypeInterpreter<ItemStack> batteryInterpreter =
                (ItemStack itemStack, UidContext uidContext) -> {

                    if (!itemStack.hasTag() || !itemStack.getTag().contains("Energy")) {
                        return "empty";
                    }
                    return "energy_" + itemStack.getTag().getInt("Energy");
                };

        registration.registerSubtypeInterpreter(ModItems.POWER_CELL.get(), batteryInterpreter);
        registration.registerSubtypeInterpreter(ModItems.IMPROVED_POWER_CELL.get(), batteryInterpreter);
        registration.registerSubtypeInterpreter(ModItems.ADVANCED_POWER_CELL.get(), batteryInterpreter);
        registration.registerSubtypeInterpreter(ModItems.ULTIMATE_POWER_CELL.get(), batteryInterpreter);
    }

    @Override
    public void registerRecipeCatalysts(mezz.jei.api.registration.IRecipeCatalystRegistration registration) {
        mezz.jei.api.recipe.RecipeType<StirlingMatrixFuel> fuelType =
                mezz.jei.api.recipe.RecipeType.create(CrystalTech.MOD_ID, "stirling_power_generation", StirlingMatrixFuel.class);

        registration.addRecipeCatalyst(
                new ItemStack(ModBlocks.COAL_MATRIX.get()),
                fuelType
        );
    }

}
