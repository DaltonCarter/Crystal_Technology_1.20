package com.CartersDev.crystechmod.util.crafting;

import com.google.gson.JsonObject;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.common.capabilities.ForgeCapabilities;
import net.minecraftforge.common.crafting.IIngredientSerializer;
import org.jetbrains.annotations.Nullable;
import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Stream;

public class EmptyPowerCellIngredient extends Ingredient {
    private final Ingredient ingredient;

    public EmptyPowerCellIngredient(Ingredient ingredient) {
        super(Stream.of(new Ingredient.Value() {

            @Override
            public Collection<ItemStack> getItems() {
                return Arrays.asList(ingredient.getItems());
            }

            @Override
            public JsonObject serialize() {
                JsonObject json = new JsonObject();
                json.addProperty("type", "crystechmod:empty_power_cell_filter");
                json.add("base", ingredient.toJson());
                return json;
            }
        }));
        this.ingredient = ingredient;
    }

    @Override
    public boolean test(@Nullable ItemStack pStack) {
        if (pStack == null){
            return false;
        }

        if (!this.ingredient.test(pStack)) {
            return false;
        }

        return pStack.getCapability(ForgeCapabilities.ENERGY).map(handler -> {
            return handler.getEnergyStored() <= 0;
        }).orElse(true);
    }

    @Override
    public boolean isSimple() {
        return false;
    }

    @Override
    public IIngredientSerializer<? extends Ingredient> getSerializer() {
        return Serializer.INSTANCE;
    }

    public static class Serializer implements IIngredientSerializer<EmptyPowerCellIngredient>{
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public EmptyPowerCellIngredient parse(JsonObject json) {
            Ingredient powercell = Ingredient.fromJson(json.get("base"));
            return new EmptyPowerCellIngredient(powercell);
        }

        @Override
        public EmptyPowerCellIngredient parse(FriendlyByteBuf buffer) {
            Ingredient powercell = Ingredient.fromNetwork(buffer);
            return new EmptyPowerCellIngredient(powercell);
        }

        @Override
        public void write(FriendlyByteBuf buffer, EmptyPowerCellIngredient ingredient) {
            ingredient.ingredient.toNetwork(buffer);
        }
    }
}
