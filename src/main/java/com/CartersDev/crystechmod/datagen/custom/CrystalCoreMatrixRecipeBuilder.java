package com.CartersDev.crystechmod.datagen.custom;

import com.CartersDev.crystechmod.CrystalTech;
import com.CartersDev.crystechmod.recipe.CrystalCoreMatrixRecipe;
import com.CartersDev.crystechmod.util.crafting.CountedIngredient;
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
import net.minecraft.world.item.crafting.RecipeSerializer;

import javax.annotation.Nullable;
import java.util.List;
import java.util.function.Consumer;

public class CrystalCoreMatrixRecipeBuilder implements RecipeBuilder {
    private final List<CountedIngredient> coreCrystal;
    private final int coreDurability;
    private final int totalEnergy;



    private final Advancement.Builder advancement = Advancement.Builder.advancement();

    public CrystalCoreMatrixRecipeBuilder(List<CountedIngredient> coreCrystal, int coreDurability, int totalEnergy) {
        this.coreCrystal = coreCrystal;
        this.coreDurability = coreDurability;
        this.totalEnergy = totalEnergy;

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

        pFinishedRecipeConsumer.accept(new Result(pRecipeId, this.coreCrystal, this.advancement, new ResourceLocation(pRecipeId.getNamespace(), "recipes/"
                + pRecipeId.getPath()), coreDurability, totalEnergy));

    }

    public static class Result implements FinishedRecipe {
        private final ResourceLocation id;
        private final List<CountedIngredient> coreCrystal;
        private final int coreDurability;
        private final int totalEnergy;
        private final Advancement.Builder advancement;
        private final ResourceLocation advancementId;

        public Result(ResourceLocation pId, List<CountedIngredient> coreCrystal, Advancement.Builder pAdvancement,
                      ResourceLocation pAdvancementId, int coreDurability, int totalEnergy) {
            this.id = pId;

            this.coreCrystal = coreCrystal;
            this.coreDurability = coreDurability;
            this.totalEnergy = totalEnergy;

            this.advancement = pAdvancement;
            this.advancementId = pAdvancementId;
        }

        @Override
        public void serializeRecipeData(JsonObject pJson) {
            JsonArray jsonInputs = new JsonArray(coreCrystal.size());
            coreCrystal.forEach(ing -> jsonInputs.add(ing.toJson()));
            pJson.add("ingredients", jsonInputs);

            pJson.addProperty("coreDurability", this.coreDurability);
            pJson.addProperty("totalEnergy", this.totalEnergy);
        }

        @Override
        public ResourceLocation getId() {

            return new ResourceLocation(CrystalTech.MOD_ID,
                    "core_crystal_power_generation_using_" + coreCrystal.get(0).hashCode());
        }

        @Override
        public RecipeSerializer<?> getType() {
            return CrystalCoreMatrixRecipe.Serializer.INSTANCE;
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