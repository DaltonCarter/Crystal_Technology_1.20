package com.CartersDev.crystechmod.datagen.custom;

import com.CartersDev.crystechmod.CrystalTech;
import com.CartersDev.crystechmod.recipe.AlloyKilnRecipe;
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
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.level.ItemLike;
import net.minecraftforge.registries.ForgeRegistries;

import javax.annotation.Nullable;
import java.util.function.Consumer;

public class AlloyKilnRecipeBuilder implements RecipeBuilder {
    private final Item result;
    private final Ingredient ingredient;
//    private final int inputCount1;
    private final Ingredient ingredient2;
//    private final int inputCount2;
    private final Ingredient ingredient3;
//    private final int inputCount3;
    private final int count;
    private final int craftTime;
    private final int energyAmount;

    private final Advancement.Builder advancement = Advancement.Builder.advancement();

    public AlloyKilnRecipeBuilder(ItemLike ingredient, ItemLike ingredient2, ItemLike ingredient3, ItemLike result, int count, int craftTime, int energyAmount) {
        this.ingredient = Ingredient.of(ingredient);
//        this.inputCount1 = inputCount1;
        this.ingredient2 = Ingredient.of(ingredient2);
//        this.inputCount2 = inputCount2;
        this.ingredient3 = Ingredient.of(ingredient3);
//        this.inputCount3 = inputCount3;
        this.result = result.asItem();
        this.count = count;
        this.craftTime = craftTime;
        this.energyAmount = energyAmount;
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
        return result;
    }

    @Override
    public void save(Consumer<FinishedRecipe> pFinishedRecipeConsumer, ResourceLocation pRecipeId) {
        this.advancement.parent(new ResourceLocation("recipes/root"))
                .addCriterion("has_the_recipe", RecipeUnlockedTrigger.unlocked(pRecipeId))
                .rewards(AdvancementRewards.Builder.recipe(pRecipeId)).requirements(RequirementsStrategy.OR);

        pFinishedRecipeConsumer.accept(new Result(pRecipeId, this.result, this.count, this.ingredient, this.ingredient2,
                this.ingredient3 , this.advancement, new ResourceLocation(pRecipeId.getNamespace(), "recipes/"
                + pRecipeId.getPath()), craftTime, energyAmount));

    }

    public static class Result implements FinishedRecipe {
        private final ResourceLocation id;
        private final Item result;
        private final Ingredient ingredient;
//        private final int inputCount1;
        private final Ingredient ingredient2;
//        private final int inputCount2;
        private final Ingredient ingredient3;
//        private final int inputCount3;

        private final int count;
        private final int craftTime;
        private final int energyAmount;

        private final Advancement.Builder advancement;
        private final ResourceLocation advancementId;

        public Result(ResourceLocation pId, Item pResult, int pCount, Ingredient ingredient, Ingredient ingredient2,
                      Ingredient ingredient3, Advancement.Builder pAdvancement, ResourceLocation pAdvancementId, int craftTime, int energyAmount) {
            this.id = pId;
            this.result = pResult;
            this.count = pCount;

            this.ingredient = ingredient;
//            this.inputCount1 = inputCount1;
            this.ingredient2 = ingredient2;
//            this.inputCount2 = inputCount2;
            this.ingredient3 = ingredient3;
//            this.inputCount3 = inputCount3;
            this.craftTime = craftTime;
            this.energyAmount = energyAmount;
            this.advancement = pAdvancement;
            this.advancementId = pAdvancementId;
        }

        @Override
        public void serializeRecipeData(JsonObject pJson) {
            JsonArray jsonarray = new JsonArray();
            jsonarray.add(ingredient.toJson());
            jsonarray.add(ingredient2.toJson());
            jsonarray.add(ingredient3.toJson());

            pJson.add("ingredients", jsonarray);
            JsonObject jsonobject = new JsonObject();
            jsonobject.addProperty("item", ForgeRegistries.ITEMS.getKey(this.result).toString());

//
//            if (this.inputCount1 > 1) {
//                jsonobject.addProperty("inputCount1", this.inputCount1);
//            }
//
//            if (this.inputCount2 > 1) {
//                jsonobject.addProperty("inputCount2", this.inputCount2);
//            }
//
//            if (this.inputCount3 > 1) {
//                jsonobject.addProperty("inputCount3", this.inputCount3);
//            }


            if (this.count > 1) {
                jsonobject.addProperty("count", this.count);
            }

            pJson.addProperty("craftTime", this.craftTime);
            pJson.addProperty("energyAmount", this.energyAmount);
            pJson.add("output", jsonobject);
        }

        @Override
        public ResourceLocation getId() {

            return new ResourceLocation(CrystalTech.MOD_ID,
                    ForgeRegistries.ITEMS.getKey(this.result).getPath() + "_from_alloy_smelting");
        }

        @Override
        public RecipeSerializer<?> getType() {
            return AlloyKilnRecipe.Serializer.INSTANCE;
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