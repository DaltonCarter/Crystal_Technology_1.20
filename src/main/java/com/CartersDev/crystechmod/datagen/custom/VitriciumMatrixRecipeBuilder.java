package com.CartersDev.crystechmod.datagen.custom;

import com.CartersDev.crystechmod.recipe.VitriciumMatrixRecipe;
import com.google.gson.JsonObject;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.registries.ForgeRegistries;
import org.jetbrains.annotations.Nullable;

import java.util.function.Consumer;

public class VitriciumMatrixRecipeBuilder {
    private final FluidStack fluidStack;
    private int craftTime = 100;
    private int energyAmount = 1000;


    private VitriciumMatrixRecipeBuilder(FluidStack fluidStack) {
        this.fluidStack = fluidStack;
    }

    public static VitriciumMatrixRecipeBuilder generateWith(FluidStack fluidStack) {
        return new VitriciumMatrixRecipeBuilder(fluidStack);
    }

    public VitriciumMatrixRecipeBuilder craftTime(int ticks) {
        this.craftTime = ticks;
        return this;
    }

    public VitriciumMatrixRecipeBuilder energy(int feAmount) {
        this.energyAmount = feAmount;
        return this;
    }


    public void save(Consumer<FinishedRecipe> consumer, ResourceLocation id) {
        consumer.accept(new Result(id, this.fluidStack, this.craftTime, this.energyAmount));
    }


    private static class Result implements FinishedRecipe {
        private final ResourceLocation id;
        private final FluidStack fluidStack;
        private final int craftTime;
        private final int energyAmount;

        public Result(ResourceLocation id, FluidStack fluidStack, int craftTime, int energyAmount) {
            this.id = id;
            this.fluidStack = fluidStack;
            this.craftTime = craftTime;
            this.energyAmount = energyAmount;
        }

        @Override
        public void serializeRecipeData(JsonObject json) {
            ResourceLocation fluidKey = ForgeRegistries.FLUIDS.getKey(this.fluidStack.getFluid());
            json.addProperty("fluidType", fluidKey != null ? fluidKey.toString() : "minecraft:empty");
            json.addProperty("fluidAmount", this.fluidStack.getAmount());
            json.addProperty("craftTime", this.craftTime);
            json.addProperty("energyAmount", this.energyAmount);
        }

        @Override
        public ResourceLocation getId() {
            return this.id;
        }

        @Override
        public RecipeSerializer<?> getType() {

            return VitriciumMatrixRecipe.Serializer.INSTANCE;
        }

        @Nullable
        @Override
        public JsonObject serializeAdvancement() {
            return null;
        }

        @Nullable
        @Override
        public ResourceLocation getAdvancementId() {
            return null;
        }
    }
}