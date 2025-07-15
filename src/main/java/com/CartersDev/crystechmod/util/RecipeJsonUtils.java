package com.CartersDev.crystechmod.util;

import com.google.gson.*;
import com.mojang.logging.LogUtils;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.TagParser;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.GsonHelper;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;

import org.slf4j.Logger;

import java.util.List;


//All credit for this class goes to Team CoFH used under their "Don't be a Jerk License v2" ©2012-2021 Cult of the Full Hub / Team CoFH / CoFH

public abstract class RecipeJsonUtils {

    private static final Logger LOG = LogUtils.getLogger();
    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().disableHtmlEscaping().create();

    private RecipeJsonUtils() {

    }
    public static final String AMOUNT = "amount";
    public static final String COUNT = "count";
    public static final String VALUE = "value";

    public static Ingredient parseIngredient(JsonElement element) {

        if (element == null || element.isJsonNull()) {
            return Ingredient.of(ItemStack.EMPTY);
        }
        Ingredient ingredient;

        if (element.isJsonArray()) {
            try {
                ingredient = Ingredient.fromJson(element, true);
            } catch (Throwable t) {
                ingredient = Ingredient.of(ItemStack.EMPTY);
                LOG.debug("Invalid Ingredient - using EMPTY instead!", t);
            }
        } else {
            JsonElement subElement = element.getAsJsonObject();
            try {
                JsonObject object = subElement.getAsJsonObject();
                if (object.has(VALUE)) {
                    ingredient = Ingredient.fromJson(object.get(VALUE), true);
                } else {
                    ingredient = Ingredient.fromJson(subElement, true);
                }
                int count = 1;
                if (object.has(COUNT)) {
                    count = object.get(COUNT).getAsInt();
                } else if (object.has(AMOUNT)) {
                    count = object.get(AMOUNT).getAsInt();
                }
                if (count > 1) {
                    return new IngredientWithCount(ingredient, count);
                }
            } catch (Throwable t) {
                ingredient = Ingredient.of(ItemStack.EMPTY);
                LOG.debug("Invalid Ingredient - using EMPTY instead!", t);
            }
        }
        return ingredient;
    }
}
