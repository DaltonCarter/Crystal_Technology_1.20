package com.CartersDev.crystechmod.recipe;

import com.CartersDev.crystechmod.CrystalTech;
import com.CartersDev.crystechmod.util.crafting.CountedIngredient;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import net.minecraft.core.NonNullList;
import net.minecraft.core.RegistryAccess;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.GsonHelper;
import net.minecraft.world.Container;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.*;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;

public class StirlingMatrixFuel implements Recipe<Container> {
    private final List<CountedIngredient> fuelItem;
    private final int burnTime;
    private final int totalEnergy;
    private final ResourceLocation id;

    public StirlingMatrixFuel(ResourceLocation id, List<CountedIngredient> fuelItem, int burnTime, int totalEnergy) {
        this.fuelItem = fuelItem;
        this.burnTime = burnTime;
        this.totalEnergy = totalEnergy;
        this.id = id;
    }

    @Override
    public boolean matches(Container pContainer, Level pLevel) {
        if(pLevel.isClientSide()){
            return false;
        }

        return fuelItem.get(0).test(pContainer.getItem(0));
    }

    public List<CountedIngredient> getFuelItems() {
        return fuelItem;
    }

    @Override
    public ItemStack assemble(Container pContainer, RegistryAccess pRegistryAccess) {
        return ItemStack.EMPTY;
    }

    @Override
    public boolean canCraftInDimensions(int pWidth, int pHeight) {
        return true;
    }

    @Override
    public ItemStack getResultItem(RegistryAccess pRegistryAccess) {
        return ItemStack.EMPTY;
    }


    @Override
    public NonNullList<Ingredient> getIngredients() {
        return NonNullList.of(Ingredient.EMPTY, fuelItem.stream().map(CountedIngredient::ingredient).toArray(Ingredient[]::new));
    }

    public int getBurnTime() {
        return burnTime;
    }

    public int getEnergyAmount() {
        return totalEnergy;
    }

    @Override
    public ResourceLocation getId() {
        return id;
    }

    @Override
    public RecipeSerializer<?> getSerializer() {
        return StirlingMatrixFuel.Serializer.INSTANCE;
    }

    @Override
    public RecipeType<?> getType() {
        return StirlingMatrixFuel.Type.INSTANCE;
    }

    public static class Type implements RecipeType<StirlingMatrixFuel> {
        private Type() { }
        public static final StirlingMatrixFuel.Type INSTANCE = new StirlingMatrixFuel.Type();
        public static final String ID = "stirling_power_generation";
    }

    public static class Serializer implements RecipeSerializer<StirlingMatrixFuel> {

        public static final StirlingMatrixFuel.Serializer INSTANCE  = new StirlingMatrixFuel.Serializer();
        public static final ResourceLocation ID = new ResourceLocation(CrystalTech.MOD_ID, "stirling_power_generation");

        @Override
        public StirlingMatrixFuel fromJson(ResourceLocation pRecipeId, JsonObject pSerializedRecipe) {

            JsonArray jsonInputs = pSerializedRecipe.getAsJsonArray("ingredients");
            List<CountedIngredient> fuel = new ArrayList<>(jsonInputs.size());
            for (int i = 0; i < jsonInputs.size(); i++) {
                fuel.add(i, CountedIngredient.fromJson(jsonInputs.get(i).getAsJsonObject()));
            }

            int burnTime = pSerializedRecipe.get("burnTime").getAsInt();
            int totalEnergy = pSerializedRecipe.get("totalEnergy").getAsInt();

            return new StirlingMatrixFuel(pRecipeId, fuel, burnTime, totalEnergy);
        }


        @Override
        public @Nullable StirlingMatrixFuel fromNetwork(ResourceLocation pRecipeId, FriendlyByteBuf pBuffer) {
            List<CountedIngredient> fuel = pBuffer.readList(CountedIngredient::fromNetwork);

            int burnTime = pBuffer.readInt();
            int totalEnergy = pBuffer.readInt();
            return new StirlingMatrixFuel(pRecipeId, fuel, burnTime, totalEnergy);
        }

        @Override
        public void toNetwork(FriendlyByteBuf pBuffer, StirlingMatrixFuel pRecipe) {

            pBuffer.writeCollection(pRecipe.fuelItem, (buf, ing) -> ing.toNetwork(buf));

            pBuffer.writeInt(pRecipe.burnTime);
            pBuffer.writeInt(pRecipe.totalEnergy);

        }
    }

}
