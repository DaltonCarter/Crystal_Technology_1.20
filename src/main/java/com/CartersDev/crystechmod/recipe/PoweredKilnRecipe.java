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

public class PoweredKilnRecipe implements Recipe<SimpleContainer> {

    private final List<CountedIngredient> inputItems;
    private final ItemStack output;
    private final ResourceLocation id;
    private final int craftTime;
    private final int energyAmount;

    public PoweredKilnRecipe(ResourceLocation id, ItemStack output, List<CountedIngredient> inputItems, int craftTime, int energyAmount) {
        this.inputItems = inputItems;
        this.output = output;
        this.id = id;
        this.craftTime = craftTime;
        this.energyAmount = energyAmount;
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
        return NonNullList.of(Ingredient.EMPTY, inputItems.stream().map(CountedIngredient::ingredient).toArray(Ingredient[]::new));
    }

    public int getCraftTime() {
        return craftTime;
    }

    public int getEnergyAmount() {
        return energyAmount;
    }

    @Override
    public ResourceLocation getId() {
        return id;
    }

    @Override
    public RecipeSerializer<?> getSerializer() {
        return PoweredKilnRecipe.Serializer.INSTANCE;
    }

    @Override
    public RecipeType<?> getType() {
        return Type.INSTANCE;
    }

    public static class Type implements RecipeType<PoweredKilnRecipe> {
        private Type() { }
        public static final Type INSTANCE = new Type();
        public static final String ID = "powered_smelting";
    }

    public static class Serializer implements RecipeSerializer<PoweredKilnRecipe> {

        public static final PoweredKilnRecipe.Serializer INSTANCE  = new PoweredKilnRecipe.Serializer();
        public static final ResourceLocation ID = new ResourceLocation(CrystalTech.MOD_ID, "powered_smelting");



        @Override
        public PoweredKilnRecipe fromJson(ResourceLocation pRecipeId, JsonObject pSerializedRecipe) {
            ItemStack output = ShapedRecipe.itemStackFromJson(GsonHelper.getAsJsonObject(pSerializedRecipe, "output"));



            JsonArray jsonInputs = pSerializedRecipe.getAsJsonArray("ingredients");
            List<CountedIngredient> inputs = new ArrayList<>(jsonInputs.size());
            for (int i = 0; i < jsonInputs.size(); i++) {
                inputs.add(i, CountedIngredient.fromJson(jsonInputs.get(i).getAsJsonObject()));
            }

            int craftTime = pSerializedRecipe.get("craftTime").getAsInt();
            int energyAmount = pSerializedRecipe.get("energyAmount").getAsInt();


            return new PoweredKilnRecipe(pRecipeId, output, inputs, craftTime, energyAmount);
        }


        @Override
        public @Nullable PoweredKilnRecipe fromNetwork(ResourceLocation pRecipeId, FriendlyByteBuf pBuffer) {
            List<CountedIngredient> inputs = pBuffer.readList(CountedIngredient::fromNetwork);

            int craftTime = pBuffer.readInt();
            int energyAmount = pBuffer.readInt();
            ItemStack output = pBuffer.readItem();
            return new PoweredKilnRecipe(pRecipeId, output, inputs, craftTime, energyAmount);
        }

        @Override
        public void toNetwork(FriendlyByteBuf pBuffer, PoweredKilnRecipe pRecipe) {

            pBuffer.writeCollection(pRecipe.inputItems, (buf, ing) -> ing.toNetwork(buf));

            pBuffer.writeInt(pRecipe.craftTime);
            pBuffer.writeInt(pRecipe.energyAmount);
            pBuffer.writeItemStack(pRecipe.getResultItem(null), false);

        }
    }
}
