package com.CartersDev.crystechmod.datagen.custom;

import com.CartersDev.crystechmod.CrystalTech;
import com.CartersDev.crystechmod.recipe.PoweredKilnRecipe;
import com.CartersDev.crystechmod.recipe.StirlingMatrixFuel;
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
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.level.ItemLike;
import net.minecraftforge.registries.ForgeRegistries;

import javax.annotation.Nullable;
import java.util.List;
import java.util.function.Consumer;

public class StirlingMatrixFuelBuilder implements RecipeBuilder {
    private final List<CountedIngredient> fuel;
    private final int burnTime;
    private final int totalEnergy;



    private final Advancement.Builder advancement = Advancement.Builder.advancement();

    public StirlingMatrixFuelBuilder(List<CountedIngredient> fuel, int burnTime, int totalEnergy) {
        this.fuel = fuel;
        this.burnTime = burnTime;
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

        pFinishedRecipeConsumer.accept(new Result(pRecipeId, this.fuel, this.advancement, new ResourceLocation(pRecipeId.getNamespace(), "recipes/"
                + pRecipeId.getPath()), burnTime, totalEnergy));

    }

    public static class Result implements FinishedRecipe {
        private final ResourceLocation id;
        private final List<CountedIngredient> fuel;
        private final int burnTime;
        private final int totalEnergy;
        private final Advancement.Builder advancement;
        private final ResourceLocation advancementId;

        public Result(ResourceLocation pId, List<CountedIngredient> fuel, Advancement.Builder pAdvancement,
                      ResourceLocation pAdvancementId, int burnTime, int totalEnergy) {
            this.id = pId;

            this.fuel = fuel;
            this.burnTime = burnTime;
            this.totalEnergy = totalEnergy;

            this.advancement = pAdvancement;
            this.advancementId = pAdvancementId;
        }

        @Override
        public void serializeRecipeData(JsonObject pJson) {
            JsonArray jsonInputs = new JsonArray(fuel.size());
            fuel.forEach(ing -> jsonInputs.add(ing.toJson()));
            pJson.add("ingredients", jsonInputs);

            pJson.addProperty("burnTime", this.burnTime);
            pJson.addProperty("totalEnergy", this.totalEnergy);
        }

        @Override
        public ResourceLocation getId() {

            return new ResourceLocation(CrystalTech.MOD_ID,
                    "stirling_power_generation_using_" + fuel.get(0).hashCode());
        }

        @Override
        public RecipeSerializer<?> getType() {
            return StirlingMatrixFuel.Serializer.INSTANCE;
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