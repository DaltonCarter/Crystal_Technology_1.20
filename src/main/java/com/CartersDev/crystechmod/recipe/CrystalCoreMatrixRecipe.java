package com.CartersDev.crystechmod.recipe;

import com.CartersDev.crystechmod.CrystalTech;
import com.CartersDev.crystechmod.util.crafting.CountedIngredient;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import net.minecraft.core.NonNullList;
import net.minecraft.core.RegistryAccess;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.Container;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;

public class CrystalCoreMatrixRecipe implements Recipe<Container> {
    private final List<CountedIngredient> coreCrystal;
    private final int coreDurability;
    private final int totalEnergy;
    private final ResourceLocation id;

    public CrystalCoreMatrixRecipe(ResourceLocation id, List<CountedIngredient> coreCrystal, int coreDurability, int totalEnergy) {
        this.coreCrystal = coreCrystal;
        this.coreDurability = coreDurability;
        this.totalEnergy = totalEnergy;
        this.id = id;
    }

    @Override
    public boolean matches(Container pContainer, Level pLevel) {
        if(pLevel.isClientSide()){
            return false;
        }

        return coreCrystal.get(0).test(pContainer.getItem(0));
    }

    public List<CountedIngredient> getCoreCrystal() {
        return coreCrystal;
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
        return NonNullList.of(Ingredient.EMPTY, coreCrystal.stream().map(CountedIngredient::ingredient).toArray(Ingredient[]::new));
    }

    public int getCoreDurability() {
        return coreDurability;
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
        return CrystalCoreMatrixRecipe.Serializer.INSTANCE;
    }

    @Override
    public RecipeType<?> getType() {
        return CrystalCoreMatrixRecipe.Type.INSTANCE;
    }

    public static class Type implements RecipeType<CrystalCoreMatrixRecipe> {
        private Type() { }
        public static final CrystalCoreMatrixRecipe.Type INSTANCE = new CrystalCoreMatrixRecipe.Type();
        public static final String ID = "core_crystal_power_generation";
    }

    public static class Serializer implements RecipeSerializer<CrystalCoreMatrixRecipe> {

        public static final CrystalCoreMatrixRecipe.Serializer INSTANCE  = new CrystalCoreMatrixRecipe.Serializer();
        public static final ResourceLocation ID = new ResourceLocation(CrystalTech.MOD_ID, "core_crystal_power_generation");

        @Override
        public CrystalCoreMatrixRecipe fromJson(ResourceLocation pRecipeId, JsonObject pSerializedRecipe) {

            JsonArray jsonInputs = pSerializedRecipe.getAsJsonArray("ingredients");
            List<CountedIngredient> fuel = new ArrayList<>(jsonInputs.size());
            for (int i = 0; i < jsonInputs.size(); i++) {
                fuel.add(i, CountedIngredient.fromJson(jsonInputs.get(i).getAsJsonObject()));
            }

            int coreDurability = pSerializedRecipe.get("coreDurability").getAsInt();
            int totalEnergy = pSerializedRecipe.get("totalEnergy").getAsInt();

            return new CrystalCoreMatrixRecipe(pRecipeId, fuel, coreDurability, totalEnergy);
        }


        @Override
        public @Nullable CrystalCoreMatrixRecipe fromNetwork(ResourceLocation pRecipeId, FriendlyByteBuf pBuffer) {
            List<CountedIngredient> fuel = pBuffer.readList(CountedIngredient::fromNetwork);

            int coreDurability = pBuffer.readInt();
            int totalEnergy = pBuffer.readInt();
            return new CrystalCoreMatrixRecipe(pRecipeId, fuel, coreDurability, totalEnergy);
        }

        @Override
        public void toNetwork(FriendlyByteBuf pBuffer, CrystalCoreMatrixRecipe pRecipe) {

            pBuffer.writeCollection(pRecipe.coreCrystal, (buf, ing) -> ing.toNetwork(buf));

            pBuffer.writeInt(pRecipe.coreDurability);
            pBuffer.writeInt(pRecipe.totalEnergy);

        }
    }
}
