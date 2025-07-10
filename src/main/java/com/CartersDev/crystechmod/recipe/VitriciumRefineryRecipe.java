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

public class VitriciumRefineryRecipe implements Recipe<SimpleContainer> {
    private final NonNullList<Ingredient> inputItems;
    private final FluidStack output;
    private final ResourceLocation id;
    private final int craftTime;
    private final int energyAmount;
    private final FluidStack fluidStack;

    public VitriciumRefineryRecipe(NonNullList<Ingredient> inputItems, FluidStack output, ResourceLocation id, int craftTime, int energyAmount, FluidStack fluidStack) {
        this.inputItems = inputItems;
        this.output = output;
        this.id = id;
        this.craftTime = craftTime;
        this.energyAmount = energyAmount;
        this.fluidStack = fluidStack;
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
        return this.inputItems;
    }

    public int getCraftTime() {
        return craftTime;
    }

    public int getEnergyAmount() {
        return energyAmount;
    }

    public FluidStack getFluidStack() {
        return fluidStack;
    }

    public FluidStack getOutputFluidStack() {
        return output;
    }

    @Override
    public ResourceLocation getId() {
        return id;
    }

    @Override
    public RecipeSerializer<?> getSerializer() {
        return VitriciumRefineryRecipe.Serializer.INSTANCE;
    }

    @Override
    public RecipeType<?> getType() {
        return Type.INSTANCE;
    }

    public static class Type implements RecipeType<VitriciumRefineryRecipe> {
        public static final VitriciumRefineryRecipe.Type INSTANCE = new VitriciumRefineryRecipe.Type();
        public static final String ID = "vitric_refining";
    }

    public static class Serializer implements RecipeSerializer<VitriciumRefineryRecipe> {

        public static final VitriciumRefineryRecipe.Serializer INSTANCE  = new Serializer();
        public static final ResourceLocation ID = new ResourceLocation(CrystalTech.MOD_ID, "vitric_refining");



        @Override
        public VitriciumRefineryRecipe fromJson(ResourceLocation pRecipeId, JsonObject pSerializedRecipe) {


            FluidStack fluidStack = new FluidStack(ForgeRegistries.FLUIDS.getValue(new ResourceLocation(pSerializedRecipe.get("fluidType").getAsString())),
                    pSerializedRecipe.get("fluidAmount").getAsInt());

            FluidStack outputFluidStack = new FluidStack(ForgeRegistries.FLUIDS.getValue(new ResourceLocation(pSerializedRecipe.get("outputFluidType").getAsString())),
                    pSerializedRecipe.get("outputFluidAmount").getAsInt());

            JsonArray ingredients = GsonHelper.getAsJsonArray(pSerializedRecipe, "ingredients");

            NonNullList<Ingredient> inputs = NonNullList.withSize(1, Ingredient.EMPTY);

            for(int i = 0; i < inputs.size(); i++) {
                inputs.set(i, Ingredient.fromJson(ingredients.get(i)));
            }
            int craftTime = pSerializedRecipe.get("craftTime").getAsInt();
            int energyAmount = pSerializedRecipe.get("energyAmount").getAsInt();

            return new VitriciumRefineryRecipe(inputs, outputFluidStack, pRecipeId, craftTime, energyAmount, fluidStack);
        }


    @Override
    public @Nullable VitriciumRefineryRecipe fromNetwork(ResourceLocation pRecipeId, FriendlyByteBuf pBuffer) {
        NonNullList<Ingredient> inputs = NonNullList.withSize(pBuffer.readInt(), Ingredient.EMPTY);
        FluidStack fluidStack = pBuffer.readFluidStack();
        FluidStack outputFluidStack = pBuffer.readFluidStack();

        for(int i = 0; i < inputs.size(); i++) {
            inputs.set(i, Ingredient.fromNetwork(pBuffer));
        }

        int craftTime = pBuffer.readInt();
        int energyAmount = pBuffer.readInt();

        return new VitriciumRefineryRecipe(inputs, outputFluidStack, pRecipeId, craftTime, energyAmount, fluidStack );
    }

    @Override
    public void toNetwork(FriendlyByteBuf pBuffer, VitriciumRefineryRecipe pRecipe) {

        pBuffer.writeInt(pRecipe.inputItems.size());

        pBuffer.writeFluidStack(pRecipe.fluidStack);
        pBuffer.writeFluidStack(pRecipe.output);

        for(Ingredient ingredient : pRecipe.getIngredients()) {
            ingredient.toNetwork(pBuffer);
        }

        pBuffer.writeInt(pRecipe.craftTime);
        pBuffer.writeInt(pRecipe.energyAmount);


    }
}

}
