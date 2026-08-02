package com.CartersDev.crystechmod.recipe;


import com.CartersDev.crystechmod.CrystalTech;
import com.CartersDev.crystechmod.item.custom.FluidCanisterItem;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.core.NonNullList;
import net.minecraft.core.RegistryAccess;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.inventory.CraftingContainer;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.*;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.material.Fluid;
import net.minecraftforge.common.capabilities.ForgeCapabilities;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fluids.capability.IFluidHandler;
import net.minecraftforge.registries.ForgeRegistries;


import javax.annotation.Nullable;


public class FluidCanisterCraftingRecipe extends ShapedRecipe {
    private final Fluid requiredFluid;
    private final int requiredAmount;
    private final ItemStack output;

    public FluidCanisterCraftingRecipe(ResourceLocation id, String group, CraftingBookCategory category,
                                       int width, int height, NonNullList<Ingredient> ingredients,
                                       Fluid requiredFluid, int requiredAmount, ItemStack output) {
        super(id, group, category, width, height, ingredients, output);
        this.requiredFluid = requiredFluid;
        this.requiredAmount = requiredAmount;
        this.output = output;
    }

    @Override
    public boolean matches(CraftingContainer pContainer, Level pLevel) {
        if (!super.matches(pContainer, pLevel)) {
            return false;
        }

        boolean hasValidCanister = false;

        for (int i = 0; i < pContainer.getContainerSize(); i++) {
            ItemStack stack = pContainer.getItem(i);

            if (stack.isEmpty()) {
                continue;
            }


            var fluidCap = stack.getCapability(ForgeCapabilities.FLUID_HANDLER_ITEM);

            if (fluidCap.isPresent()) {
                IFluidHandler handler = fluidCap.resolve().get();
                FluidStack fluidPresent = handler.getFluidInTank(0);

                if (fluidPresent.isEmpty()) {
                    return false;
                }

                if (fluidPresent.getFluid() == this.requiredFluid) {
                    if (fluidPresent.getAmount() >= this.requiredAmount) {
                        if (hasValidCanister) return false;
                        hasValidCanister = true;
                    } else {
                        return false;
                    }
                } else {
                    return false;
                }
            }

            else if (pLevel.isClientSide() && stack.getItem() instanceof FluidCanisterItem) {
                net.minecraft.nbt.CompoundTag tag = stack.getTag();

                if (tag != null && tag.contains("FluidData")) {
                    net.minecraft.nbt.CompoundTag fluidData = tag.getCompound("FluidData");
                    String fluidName = fluidData.getString("FluidName");
                    int fluidAmount = fluidData.getInt("Amount");

                    String reqPath = net.minecraftforge.registries.ForgeRegistries.FLUIDS.getKey(this.requiredFluid).toString();

                    if (fluidName.equals(reqPath)) {
                        if (fluidAmount >= this.requiredAmount) {
                            if (hasValidCanister) return false;
                            hasValidCanister = true;
                        } else {
                            return false;
                        }
                    } else {
                        return false;
                    }
                }
            }
        }

        return hasValidCanister;
    }

    public Fluid getRequiredFluid() {
        return requiredFluid;
    }

    public int getRequiredAmount() {
        return requiredAmount;
    }

    @Override
    public ItemStack assemble(CraftingContainer pContainer, RegistryAccess pRegistryAccess) {
        return this.output.copy();
    }


    @Override
    public boolean canCraftInDimensions(int pWidth, int pHeight) {
        return pWidth * pHeight >= 2;
    }

    @Override
    public RecipeType<?> getType() {
        return FluidCanisterCraftingRecipe.Type.INSTANCE;
    }

    public static class Type implements RecipeType<FluidCanisterCraftingRecipe> {
        public static final FluidCanisterCraftingRecipe.Type INSTANCE = new FluidCanisterCraftingRecipe.Type();
        public static final String ID = "fluid_canister_crafting";
    }

    @Override
    public NonNullList<ItemStack> getRemainingItems(CraftingContainer container) {
        NonNullList<ItemStack> remaining = NonNullList.withSize(container.getContainerSize(), ItemStack.EMPTY);

        for (int i = 0; i < container.getContainerSize(); i++) {
            ItemStack stack = container.getItem(i);
            if (stack.isEmpty()) continue;

            var fluidCap = stack.getCapability(ForgeCapabilities.FLUID_HANDLER_ITEM);
            if (fluidCap.isPresent()) {
                ItemStack canisterRemainder = stack.copy();
                canisterRemainder.setCount(1);

                canisterRemainder.getCapability(ForgeCapabilities.FLUID_HANDLER_ITEM).ifPresent(handler -> {
                    handler.drain(this.requiredAmount, IFluidHandler.FluidAction.EXECUTE);
                });

                remaining.set(i, canisterRemainder);
            } else {
                remaining.set(i, stack.getCraftingRemainingItem());
            }
        }
        return remaining;
    }


    public static class Serializer implements RecipeSerializer<FluidCanisterCraftingRecipe> {

        public static final FluidCanisterCraftingRecipe.Serializer INSTANCE  = new FluidCanisterCraftingRecipe.Serializer();
        public static final ResourceLocation ID = new ResourceLocation(CrystalTech.MOD_ID, "fluid_canister_crafting");

        @Override
        public FluidCanisterCraftingRecipe fromJson(ResourceLocation pRecipeId, com.google.gson.JsonObject pSerializedJson) {

            ShapedRecipe recipe = RecipeSerializer.SHAPED_RECIPE.fromJson(pRecipeId, pSerializedJson);

            Fluid fluid = net.minecraft.world.level.material.Fluids.WATER;
            int amount = 0;

            if (pSerializedJson.has("fluid_requirement")) {
                com.google.gson.JsonObject fluidBlock = pSerializedJson.getAsJsonObject("fluid_requirement");
                if (fluidBlock.has("fluid")) {
                    ResourceLocation fluidId = new ResourceLocation(fluidBlock.get("fluid").getAsString());
                    fluid = net.minecraftforge.registries.ForgeRegistries.FLUIDS.getValue(fluidId);
                }
                if (fluidBlock.has("amount")) {
                    amount = fluidBlock.get("amount").getAsInt();
                }
            }

            return new FluidCanisterCraftingRecipe(pRecipeId, recipe.getGroup(), recipe.category(), recipe.getRecipeWidth(),
                    recipe.getRecipeHeight(), recipe.getIngredients(), fluid, amount, recipe.getResultItem(RegistryAccess.EMPTY));
        }

        @Override
        public @Nullable FluidCanisterCraftingRecipe fromNetwork(ResourceLocation pRecipeId, FriendlyByteBuf pBuffer) {
            ShapedRecipe recipe = RecipeSerializer.SHAPED_RECIPE.fromNetwork(pRecipeId, pBuffer);
            ResourceLocation fluidId = pBuffer.readResourceLocation();
            Fluid fluid = ForgeRegistries.FLUIDS.getValue(fluidId);
            int amount = pBuffer.readInt();

            return new FluidCanisterCraftingRecipe(pRecipeId, recipe.getGroup(), recipe.category(), recipe.getRecipeWidth(),
                    recipe.getRecipeHeight(), recipe.getIngredients(), fluid, amount, recipe.getResultItem(RegistryAccess.EMPTY));
        }

        @Override
        public void toNetwork(FriendlyByteBuf pBuffer, FluidCanisterCraftingRecipe pRecipe) {
            RecipeSerializer.SHAPED_RECIPE.toNetwork(pBuffer, pRecipe);
            ResourceLocation fluidKey = net.minecraftforge.registries.ForgeRegistries.FLUIDS.getKey(pRecipe.requiredFluid);
            pBuffer.writeResourceLocation(fluidKey != null ? fluidKey : new ResourceLocation("minecraft", "water"));
            pBuffer.writeInt(pRecipe.requiredAmount);

        }
    }
}
