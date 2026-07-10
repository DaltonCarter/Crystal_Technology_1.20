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
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.material.Fluid;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.registries.ForgeRegistries;
import org.jetbrains.annotations.Nullable;

public class VitriciumMatrixRecipe implements Recipe<SimpleContainer> {

    private final ResourceLocation id;
    private final int craftTime;
    private final int energyAmount;
    private final FluidStack fluidStack;

    public VitriciumMatrixRecipe(ResourceLocation id, int craftTime, int energyAmount, FluidStack fluidStack) {
        this.id = id;
        this.craftTime = craftTime;
        this.energyAmount = energyAmount;
        this.fluidStack = fluidStack;
    }

    @Override
    public boolean matches(SimpleContainer pContainer, Level pLevel) {
        if (pLevel.isClientSide()) {
            return false;
        }
        return true;
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

    public int getCraftTime() {
        return craftTime;
    }

    public int getEnergyAmount() {
        return energyAmount;
    }

    public FluidStack getFluidStack() {
        return fluidStack;
    }

    @Override
    public ResourceLocation getId() {
        return id;
    }

    @Override
    public RecipeSerializer<?> getSerializer() {
        return Serializer.INSTANCE;
    }

    @Override
    public RecipeType<?> getType() {
        return Type.INSTANCE;
    }

    public static class Type implements RecipeType<VitriciumMatrixRecipe> {
        public static final Type INSTANCE = new Type();
        public static final String ID = "vitricium_power_generation";
    }

    public static class Serializer implements RecipeSerializer<VitriciumMatrixRecipe> {
        public static final Serializer INSTANCE = new Serializer();
        public static final ResourceLocation ID = new ResourceLocation(CrystalTech.MOD_ID, "vitricium_power_generation");

        @Override
        public VitriciumMatrixRecipe fromJson(ResourceLocation pRecipeId, JsonObject pSerializedRecipe) {

            String fuel = GsonHelper.getAsString(pSerializedRecipe, "fluidType");
            ResourceLocation fluidKey = new ResourceLocation(fuel);

            if (!ForgeRegistries.FLUIDS.containsKey(fluidKey)) {
                throw new com.google.gson.JsonSyntaxException("I have no idea what to do with this: " + fuel);
            }

            Fluid fluid = ForgeRegistries.FLUIDS.getValue(fluidKey);
            int fluidAmount = GsonHelper.getAsInt(pSerializedRecipe, "fluidAmount");
            FluidStack fluidStack = new FluidStack(fluid, fluidAmount);

            int craftTime = GsonHelper.getAsInt(pSerializedRecipe, "craftTime");
            int energyAmount = GsonHelper.getAsInt(pSerializedRecipe, "energyAmount");

            return new VitriciumMatrixRecipe(pRecipeId, craftTime, energyAmount, fluidStack);
        }

        @Override
        public @Nullable VitriciumMatrixRecipe fromNetwork(ResourceLocation pRecipeId, FriendlyByteBuf pBuffer) {
            FluidStack fluidStack = pBuffer.readFluidStack();
            int craftTime = pBuffer.readInt();
            int energyAmount = pBuffer.readInt();

            return new VitriciumMatrixRecipe(pRecipeId, craftTime, energyAmount, fluidStack);
        }

        @Override
        public void toNetwork(FriendlyByteBuf pBuffer, VitriciumMatrixRecipe pRecipe) {
            pBuffer.writeFluidStack(pRecipe.fluidStack);

            pBuffer.writeInt(pRecipe.craftTime);
            pBuffer.writeInt(pRecipe.energyAmount);
        }
    }
}
