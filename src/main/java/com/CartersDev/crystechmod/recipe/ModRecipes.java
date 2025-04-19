package com.CartersDev.crystechmod.recipe;

import com.CartersDev.crystechmod.CrystalTech;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModRecipes {
    public static final DeferredRegister<RecipeSerializer<?>> SERIALIZERS =
            DeferredRegister.create(ForgeRegistries.RECIPE_SERIALIZERS, CrystalTech.MOD_ID);

public static final RegistryObject<RecipeSerializer<TiberiumGrinderRecipe>> TIBERIUM_GRINDER_SERIALIZER =
        SERIALIZERS.register("tiberium_grinding", () -> TiberiumGrinderRecipe.Serializer.INSTANCE);

    public static final RegistryObject<RecipeSerializer<TiberiumMaceratorRecipe>> TIBERIUM_MACERATOR_SERIALIZER =
            SERIALIZERS.register("tiberium_macerating", () -> TiberiumMaceratorRecipe.Serializer.INSTANCE);

    public static final RegistryObject<RecipeSerializer<TiberiumInfuserRecipe>> TIBERIUM_INFUSER_SERIALIZER =
            SERIALIZERS.register("tiberium_infusing", () -> TiberiumInfuserRecipe.Serializer.INSTANCE);


    public static void register(IEventBus eventBus) {
        SERIALIZERS.register(eventBus);
    }
}
