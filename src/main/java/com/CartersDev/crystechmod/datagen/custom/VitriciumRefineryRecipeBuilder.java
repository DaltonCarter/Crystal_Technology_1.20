package com.CartersDev.crystechmod.datagen.custom;

import com.CartersDev.crystechmod.CrystalTech;
import com.CartersDev.crystechmod.recipe.TiberiumInfuserRecipe;
import com.CartersDev.crystechmod.recipe.VitriciumRefineryRecipe;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import net.minecraft.advancements.Advancement;
import net.minecraft.advancements.AdvancementRewards;
import net.minecraft.advancements.CriterionTriggerInstance;
import net.minecraft.advancements.RequirementsStrategy;
import net.minecraft.advancements.critereon.RecipeUnlockedTrigger;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.RecipeBuilder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.level.ItemLike;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.registries.ForgeRegistries;

import javax.annotation.Nullable;
import java.util.function.Consumer;

public class VitriciumRefineryRecipeBuilder implements RecipeBuilder {
    private final FluidStack result;
    private final Ingredient ingredient;

    private final int craftTime;
    private final int energyAmount;
    private final FluidStack fluidStack;
    private final Advancement.Builder advancement = Advancement.Builder.advancement();

    public VitriciumRefineryRecipeBuilder(ItemLike ingredient, FluidStack result, int craftTime, int energyAmount, FluidStack fluidStack) {
        this.ingredient = Ingredient.of(ingredient);
        this.result = result;

        this.craftTime = craftTime;
        this.energyAmount = energyAmount;
        this.fluidStack = fluidStack;
    }

    @Override
    public RecipeBuilder unlockedBy(String pCriterionName, CriterionTriggerInstance pCriterionTrigger) {
        this.advancement.addCriterion(pCriterionName, pCriterionTrigger);
        return this;
    }

    @Override
    public RecipeBuilder group(@Nullable String pGroupName) {
        return this;
    }

    @Override
    public Item getResult() {
        return ItemStack.EMPTY.getItem();
    }


    @Override
    public void save(Consumer<FinishedRecipe> pFinishedRecipeConsumer, ResourceLocation pRecipeId) {
        this.advancement.parent(new ResourceLocation("recipes/root"))
                .addCriterion("has_the_recipe", RecipeUnlockedTrigger.unlocked(pRecipeId))
                .rewards(AdvancementRewards.Builder.recipe(pRecipeId)).requirements(RequirementsStrategy.OR);

        pFinishedRecipeConsumer.accept(new Result(pRecipeId, this.result, this.ingredient,
                this.advancement, new ResourceLocation(pRecipeId.getNamespace(), "recipes/"
                + pRecipeId.getPath()), this.craftTime, this.energyAmount, this.fluidStack));

    }

    public static class Result implements FinishedRecipe {
        private final ResourceLocation id;
        private final FluidStack result;
        private final Ingredient ingredient;

        private final int craftTime;
        private final int energyAmount;
        private final FluidStack fluidStack;
        private final Advancement.Builder advancement;
        private final ResourceLocation advancementId;

        public Result(ResourceLocation pId, FluidStack pResult, Ingredient ingredient, Advancement.Builder pAdvancement,
                      ResourceLocation pAdvancementId, int craftTime, int energyAmount, FluidStack fluidStack) {
            this.id = pId;
            this.result = pResult;

            this.craftTime = craftTime;
            this.energyAmount = energyAmount;
            this.fluidStack = fluidStack;
            this.ingredient = ingredient;
            this.advancement = pAdvancement;
            this.advancementId = pAdvancementId;
        }

        @Override
        public void serializeRecipeData(JsonObject pJson) {
            JsonArray jsonarray = new JsonArray();
            jsonarray.add(ingredient.toJson());

            pJson.add("ingredients", jsonarray);
            JsonObject jsonobject = new JsonObject();
            pJson.addProperty("outputFluidType", ForgeRegistries.FLUIDS.getKey(this.result.getFluid()).toString());
            pJson.addProperty("outputFluidAmount", this.result.getAmount());

            pJson.addProperty("fluidType", ForgeRegistries.FLUIDS.getKey(this.fluidStack.getFluid()).toString());
            pJson.addProperty("fluidAmount", this.fluidStack.getAmount());



            pJson.addProperty("craftTime", this.craftTime);
            pJson.addProperty("energyAmount", this.energyAmount);

            pJson.add("output", jsonobject);
        }

        @Override
        public ResourceLocation getId() {
            return new ResourceLocation(CrystalTech.MOD_ID,
                    ForgeRegistries.FLUIDS.getKey(this.result.getFluid()).getPath() + "_from_vitric_refining");
        }

        @Override
        public RecipeSerializer<?> getType() {
            return VitriciumRefineryRecipe.Serializer.INSTANCE;
        }

        @Nullable
        public JsonObject serializeAdvancement() {
            return this.advancement.serializeToJson();
        }

        @Nullable
        public ResourceLocation getAdvancementId() {
            return this.advancementId;
        }
    }
}