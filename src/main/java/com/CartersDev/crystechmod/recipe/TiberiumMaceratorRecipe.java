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
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.*;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;

public class TiberiumMaceratorRecipe implements Recipe<SimpleContainer> {

    private final List<CountedIngredient> inputItems;
    private final ItemStack output;
    private final ResourceLocation id;
    private final int craftTime;
    private final int energyAmount;
    private final boolean multiply;

    public TiberiumMaceratorRecipe(ResourceLocation id, ItemStack output, List<CountedIngredient> inputItems, int craftTime, int energyAmount, boolean multiply) {
        this.inputItems = inputItems;
        this.output = output;
        this.id = id;
        this.craftTime = craftTime;
        this.energyAmount = energyAmount;
        this.multiply = multiply;
    }


    @Override
    public boolean matches(SimpleContainer pContainer, Level pLevel) {
        if(pLevel.isClientSide()){
            return false;
        }

        return inputItems.get(0).test(pContainer.getItem(0));
    }

    public List<CountedIngredient> getInputItems() {
        return inputItems;
    }

    @Override
    public ItemStack assemble(SimpleContainer pContainer, RegistryAccess pRegistryAccess) {
        return output.copy();
    }

    @Override
    public boolean canCraftInDimensions(int pWidth, int pHeight) {
        return true;
    }

    @Override
    public ItemStack getResultItem(RegistryAccess pRegistryAccess) {
        return output.copy();
    }

    @Override
    public NonNullList<Ingredient> getIngredients() {
      return  NonNullList.of(Ingredient.EMPTY, inputItems.stream().map(CountedIngredient::ingredient).toArray(Ingredient[]::new));
    }

    public int getCraftTime() {
        return craftTime;
    }

    public int getEnergyAmount() {
        return energyAmount;
    }

    public boolean isMultiply() {
        return multiply;
    }

    @Override
    public ResourceLocation getId() {
        return id;
    }

    @Override
    public RecipeSerializer<?> getSerializer() {
        return TiberiumMaceratorRecipe.Serializer.INSTANCE;
    }

    @Override
    public RecipeType<?> getType() {
        return Type.INSTANCE;
    }

    public static class Type implements RecipeType<TiberiumMaceratorRecipe> {
        private Type() { }
        public static final Type INSTANCE = new Type();
        public static final String ID = "tiberium_macerating";
    }

    public static class Serializer implements RecipeSerializer<TiberiumMaceratorRecipe> {

        public static final TiberiumMaceratorRecipe.Serializer INSTANCE  = new TiberiumMaceratorRecipe.Serializer();
        public static final ResourceLocation ID = new ResourceLocation(CrystalTech.MOD_ID, "tiberium_macerating");



        @Override
        public TiberiumMaceratorRecipe fromJson(ResourceLocation pRecipeId, JsonObject pSerializedRecipe) {
            ItemStack output = ShapedRecipe.itemStackFromJson(GsonHelper.getAsJsonObject(pSerializedRecipe, "output"));



            JsonArray jsonInputs = pSerializedRecipe.getAsJsonArray("ingredients");
            List<CountedIngredient> inputs = new ArrayList<>(jsonInputs.size());
            for (int i = 0; i < jsonInputs.size(); i++) {
                inputs.add(i, CountedIngredient.fromJson(jsonInputs.get(i).getAsJsonObject()));
            }


            int craftTime = pSerializedRecipe.get("craftTime").getAsInt();
            int energyAmount = pSerializedRecipe.get("energyAmount").getAsInt();
            boolean multiply = pSerializedRecipe.get("multiply").getAsBoolean();


            return new TiberiumMaceratorRecipe(pRecipeId, output, inputs, craftTime, energyAmount, multiply);
        }


        @Override
        public @Nullable TiberiumMaceratorRecipe fromNetwork(ResourceLocation pRecipeId, FriendlyByteBuf pBuffer) {
            List<CountedIngredient> inputs = pBuffer.readList(CountedIngredient::fromNetwork);

            int craftTime = pBuffer.readInt();
            int energyAmount = pBuffer.readInt();
            boolean multiply = pBuffer.readBoolean();
            ItemStack output = pBuffer.readItem();
            return new TiberiumMaceratorRecipe(pRecipeId, output, inputs, craftTime, energyAmount, multiply);
        }

        @Override
        public void toNetwork(FriendlyByteBuf pBuffer, TiberiumMaceratorRecipe pRecipe) {

            pBuffer.writeCollection(pRecipe.inputItems, (buf, ing) -> ing.toNetwork(buf));

            pBuffer.writeInt(pRecipe.craftTime);
            pBuffer.writeInt(pRecipe.energyAmount);
            pBuffer.writeBoolean(pRecipe.multiply);
            pBuffer.writeItemStack(pRecipe.getResultItem(null), false);

        }
    }
}
