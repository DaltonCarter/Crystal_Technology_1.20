package com.CartersDev.crystechmod.recipe;

import com.CartersDev.crystechmod.CrystalTech;
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
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.registries.ForgeRegistries;
import org.jetbrains.annotations.Nullable;

public class TiberiumGrinderRecipe implements Recipe<SimpleContainer> {
    private final NonNullList<Ingredient> inputItems;
    private final ItemStack output;
    private final ResourceLocation id;



    public TiberiumGrinderRecipe(NonNullList<Ingredient> inputItems, ItemStack output, ResourceLocation id) {
        this.inputItems = inputItems;
        this.output = output;
        this.id = id;


    }


    @Override
    public boolean matches(SimpleContainer pContainer, Level pLevel) {
        if(pLevel.isClientSide()){
            return false;
        }


        return inputItems.get(0).test(pContainer.getItem(0));
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
        return this.inputItems;
    }


    @Override
    public ResourceLocation getId() {
        return id;
    }

    @Override
    public RecipeSerializer<?> getSerializer() {
        return TiberiumGrinderRecipe.Serializer.INSTANCE;
    }

    @Override
    public RecipeType<?> getType() {
        return Type.INSTANCE;
    }

    public static class Type implements RecipeType<TiberiumGrinderRecipe> {
        public static final TiberiumGrinderRecipe.Type INSTANCE = new TiberiumGrinderRecipe.Type();
        public static final String ID = "tiberium_grinding";
    }

    public static class Serializer implements RecipeSerializer<TiberiumGrinderRecipe> {

        public static final TiberiumGrinderRecipe.Serializer INSTANCE  = new Serializer();
        public static final ResourceLocation ID = new ResourceLocation(CrystalTech.MOD_ID, "tiberium_grinding");



        @Override
        public TiberiumGrinderRecipe fromJson(ResourceLocation pRecipeId, JsonObject pSerializedRecipe) {
            ItemStack output = ShapedRecipe.itemStackFromJson(GsonHelper.getAsJsonObject(pSerializedRecipe, "output"));


            JsonArray ingredients = GsonHelper.getAsJsonArray(pSerializedRecipe, "ingredients");

            NonNullList<Ingredient> inputs = NonNullList.withSize(1, Ingredient.EMPTY);

            for(int i = 0; i < inputs.size(); i++) {
                inputs.set(i, Ingredient.fromJson(ingredients.get(i)));
            }



            return new TiberiumGrinderRecipe(inputs, output, pRecipeId);
        }


        @Override
        public @Nullable TiberiumGrinderRecipe fromNetwork(ResourceLocation pRecipeId, FriendlyByteBuf pBuffer) {
            NonNullList<Ingredient> inputs = NonNullList.withSize(pBuffer.readInt(), Ingredient.EMPTY);


            for(int i = 0; i < inputs.size(); i++) {
                inputs.set(i, Ingredient.fromNetwork(pBuffer));
            }

            int craftTime = pBuffer.readInt();


            ItemStack output = pBuffer.readItem();
            return new TiberiumGrinderRecipe( inputs, output, pRecipeId);
        }

        @Override
        public void toNetwork(FriendlyByteBuf pBuffer, TiberiumGrinderRecipe pRecipe) {

            pBuffer.writeInt(pRecipe.inputItems.size());



            for(Ingredient ingredient : pRecipe.getIngredients()) {
                ingredient.toNetwork(pBuffer);
            }




            pBuffer.writeItemStack(pRecipe.getResultItem(null), false);

        }
    }

}
