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

public class EmptyCanisterIngredient extends Ingredient {
    private final Ingredient ingredient;

    public EmptyCanisterIngredient(Ingredient ingredient) {
        super(Stream.of(new Ingredient.Value() {
            @Override
            public Collection<ItemStack> getItems() {
                return Arrays.asList(ingredient.getItems());
            }

            @Override
            public JsonObject serialize() {
                JsonObject json = new JsonObject();
                json.addProperty("type", "crystechmod:empty_canister_filter");
                json.add("base", ingredient.toJson());
                return json;
            }
        }));

this.ingredient = ingredient;

    }

    @Override
    public boolean test(@Nullable ItemStack pStack) {

        if(pStack == null || pStack.isEmpty()){
            return false;
        }

        if(!this.ingredient.test(pStack)){
            return false;
        }

        return pStack.getCapability(ForgeCapabilities.FLUID_HANDLER_ITEM).map(handler -> {
           return handler.getFluidInTank(0).isEmpty();
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

    public static class Serializer implements IIngredientSerializer<EmptyCanisterIngredient>{
        public static final Serializer INSTANCE = new Serializer();


        @Override
        public EmptyCanisterIngredient parse(JsonObject json) {
            Ingredient canister = Ingredient.fromJson(json.get("base"));
            return new EmptyCanisterIngredient(canister);
        }


        @Override
        public EmptyCanisterIngredient parse(FriendlyByteBuf buffer) {
            Ingredient canister = Ingredient.fromNetwork(buffer);
            return new EmptyCanisterIngredient(canister);
        }


        @Override
        public void write(FriendlyByteBuf buffer, EmptyCanisterIngredient pIngredient) {
            pIngredient.ingredient.toNetwork(buffer);
        }
    }

}
