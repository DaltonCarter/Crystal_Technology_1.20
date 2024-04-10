package com.CartersDev.crystechmod.datagen;


import com.CartersDev.crystechmod.CrystalTech;
import com.CartersDev.crystechmod.block.ModBlocks;
import com.CartersDev.crystechmod.item.ModItems;
import com.CartersDev.crystechmod.util.ModTags;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.AbstractCookingRecipe;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.StonecutterRecipe;
import net.minecraft.world.level.ItemLike;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;

import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;

public class ModRecipeProvider  extends RecipeProvider implements IConditionBuilder {

    private static final List<ItemLike> GUNDANIUM_SMELTABLES = List.of(ModItems.RAW_GUNDANIUM.get(),
            ModItems.GUNDANIUM_DUST.get(), ModBlocks.GUNDANIUM_ORE.get(), ModBlocks.DEEPSLATE_GUNDANIUM_ORE.get());

    private static final List<ItemLike> ALYTHUM_SMELTABLES = List.of(ModItems.RAW_ALYTHUM.get(),
            ModItems.ALYTHUM_DUST.get(), ModBlocks.ALYTHUM_ORE.get(), ModBlocks.DEEPSLATE_ALYTHUM_ORE.get(), ModBlocks.NETHER_ALYTHUM_ORE.get());

    private static final List<ItemLike> LG_CORE_STEEL = List.of(ModItems.LG_CORE_BLEND.get());
    private static final List<ItemLike> MG_CORE_STEEL = List.of(ModItems.MG_CORE_BLEND.get());
    private static final List<ItemLike> HG_CORE_STEEL = List.of(ModItems.HG_CORE_BLEND.get());
    private static final List<ItemLike> ILLYRIM_ALLOY = List.of(ModItems.ILLYRIM_BLEND.get());
    private static final List<ItemLike> TIBERGLASS_SMELTABLES = List.of(ModBlocks.YELLOW_ZONE_SAND.get(),
            ModBlocks.RED_ZONE_SAND.get());



    public ModRecipeProvider(PackOutput pOutput) {
        super(pOutput);
    }

    @Override
    protected void buildRecipes(Consumer<FinishedRecipe> consumer) {

//      Blasting and Smelting:
        oreSmelting(consumer, GUNDANIUM_SMELTABLES, RecipeCategory.MISC, ModItems.GUNDANIUM_INGOT.get(), 0.25f, 200, "gundanium");
        oreBlasting(consumer, GUNDANIUM_SMELTABLES, RecipeCategory.MISC, ModItems.GUNDANIUM_INGOT.get(), 0.25f, 100, "gundanium");

        oreSmelting(consumer, ALYTHUM_SMELTABLES, RecipeCategory.MISC, ModItems.ALYTHUM_INGOT.get(), 0.25f, 200, "alythum");
        oreBlasting(consumer, ALYTHUM_SMELTABLES, RecipeCategory.MISC, ModItems.ALYTHUM_INGOT.get(), 0.25f, 100, "alythum");

        oreSmelting(consumer, ILLYRIM_ALLOY, RecipeCategory.MISC, ModItems.ILLYRIM_INGOT.get(), 0.25f, 200, "illyrim");
        oreBlasting(consumer, ILLYRIM_ALLOY, RecipeCategory.MISC, ModItems.ILLYRIM_INGOT.get(), 0.25f, 100, "illyrim");

        oreSmelting(consumer, LG_CORE_STEEL, RecipeCategory.MISC, ModItems.LG_CORE_INGOT.get(), 0.25f, 200, "core_steel");
        oreBlasting(consumer, LG_CORE_STEEL, RecipeCategory.MISC, ModItems.LG_CORE_INGOT.get(), 0.25f, 100, "core_steel");

        oreSmelting(consumer, MG_CORE_STEEL, RecipeCategory.MISC, ModItems.MG_CORE_INGOT.get(), 0.25f, 200, "core_steel");
        oreBlasting(consumer, MG_CORE_STEEL, RecipeCategory.MISC, ModItems.MG_CORE_INGOT.get(), 0.25f, 100, "core_steel");

        oreSmelting(consumer, HG_CORE_STEEL, RecipeCategory.MISC, ModItems.HG_CORE_INGOT.get(), 0.25f, 200, "core_steel");
        oreBlasting(consumer, HG_CORE_STEEL, RecipeCategory.MISC, ModItems.HG_CORE_INGOT.get(), 0.25f, 100, "core_steel");



        //Shaped Crafting:
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.TIBERIUM_BLOCK.get())
                .pattern("TTT")
                .pattern("TTT")
                .pattern("TTT")
                .define('T', ModItems.TIBERIUM.get())
                .unlockedBy(getHasName(ModItems.TIBERIUM.get()), has(ModItems.TIBERIUM.get()))
                .save(consumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.TIBERIUM_BLUE_BLOCK.get())
                .pattern("TTT")
                .pattern("TTT")
                .pattern("TTT")
                .define('T', ModItems.TIBERIUM_BLUE.get())
                .unlockedBy(getHasName(ModItems.TIBERIUM_BLUE.get()), has(ModItems.TIBERIUM_BLUE.get()))
                .save(consumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.TIBERIUM_RED_BLOCK.get())
                .pattern("TTT")
                .pattern("TTT")
                .pattern("TTT")
                .define('T', ModItems.TIBERIUM_RED.get())
                .unlockedBy(getHasName(ModItems.TIBERIUM_RED.get()), has(ModItems.TIBERIUM_RED.get()))
                .save(consumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.TIBERIUM_PURPLE_BLOCK.get())
                .pattern("TTT")
                .pattern("TTT")
                .pattern("TTT")
                .define('T', ModItems.TIBERIUM_PURPLE.get())
                .unlockedBy(getHasName(ModItems.TIBERIUM_PURPLE.get()), has(ModItems.TIBERIUM_PURPLE.get()))
                .save(consumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.AERIES_BLOCK.get())
                .pattern("AAA")
                .pattern("AAA")
                .pattern("AAA")
                .define('A', ModItems.AERIES_CRYSTAL.get())
                .unlockedBy(getHasName(ModItems.AERIES_CRYSTAL.get()), has(ModItems.AERIES_CRYSTAL.get()))
                .save(consumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.ENIGMA_BLOCK.get())
                .pattern("EEE")
                .pattern("EEE")
                .pattern("EEE")
                .define('E', ModItems.ENIGMA_CRYSTAL.get())
                .unlockedBy(getHasName(ModItems.ENIGMA_CRYSTAL.get()), has(ModItems.ENIGMA_CRYSTAL.get()))
                .save(consumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.ILLUMINA_BLOCK.get())
                .pattern("III")
                .pattern("III")
                .pattern("III")
                .define('I', ModItems.ILLUMINA_CRYSTAL.get())
                .unlockedBy(getHasName(ModItems.ILLUMINA_CRYSTAL.get()), has(ModItems.ILLUMINA_CRYSTAL.get()))
                .save(consumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.KRYON_BLOCK.get())
                .pattern("KKK")
                .pattern("KKK")
                .pattern("KKK")
                .define('K', ModItems.KRYON_CRYSTAL.get())
                .unlockedBy(getHasName(ModItems.KRYON_CRYSTAL.get()), has(ModItems.KRYON_CRYSTAL.get()))
                .save(consumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.GUNDANIUM_BLOCK.get())
                .pattern("GGG")
                .pattern("GGG")
                .pattern("GGG")
                .define('G', ModItems.GUNDANIUM_INGOT.get())
                .unlockedBy(getHasName(ModItems.GUNDANIUM_INGOT.get()), has(ModItems.GUNDANIUM_INGOT.get()))
                .save(consumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.ALYTHUM_BLOCK.get())
                .pattern("AAA")
                .pattern("AAA")
                .pattern("AAA")
                .define('A', ModItems.ALYTHUM_INGOT.get())
                .unlockedBy(getHasName(ModItems.ALYTHUM_INGOT.get()), has(ModItems.ALYTHUM_INGOT.get()))
                .save(consumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.ILLYRIM_BLOCK.get())
                .pattern("III")
                .pattern("III")
                .pattern("III")
                .define('I', ModItems.ILLYRIM_INGOT.get())
                .unlockedBy(getHasName(ModItems.ILLYRIM_INGOT.get()), has(ModItems.ILLYRIM_INGOT.get()))
                .save(consumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.LG_CORE_BLOCK.get())
                .pattern("LLL")
                .pattern("LLL")
                .pattern("LLL")
                .define('L', ModItems.LG_CORE_INGOT.get())
                .unlockedBy(getHasName(ModItems.LG_CORE_INGOT.get()), has(ModItems.LG_CORE_INGOT.get()))
                .save(consumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.MG_CORE_BLOCK.get())
                .pattern("MMM")
                .pattern("MMM")
                .pattern("MMM")
                .define('M', ModItems.MG_CORE_INGOT.get())
                .unlockedBy(getHasName(ModItems.MG_CORE_INGOT.get()), has(ModItems.MG_CORE_INGOT.get()))
                .save(consumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.HG_CORE_BLOCK.get())
                .pattern("HHH")
                .pattern("HHH")
                .pattern("HHH")
                .define('H', ModItems.HG_CORE_INGOT.get())
                .unlockedBy(getHasName(ModItems.HG_CORE_INGOT.get()), has(ModItems.HG_CORE_INGOT.get()))
                .save(consumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.FIRESTONE_BLOCK.get())
                .pattern("FFF")
                .pattern("FFF")
                .pattern("FFF")
                .define('F', ModItems.FIRESTONE.get())
                .unlockedBy(getHasName(ModItems.FIRESTONE.get()), has(ModItems.FIRESTONE.get()))
                .save(consumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.INFESTED_STONE_BRICKS.get(), 4)
                .pattern("   ")
                .pattern(" SS")
                .pattern(" SS")
                .define('S', ModBlocks.INFESTED_STONE.get())
                .unlockedBy(getHasName(ModBlocks.INFESTED_STONE.get()), has(ModBlocks.INFESTED_STONE.get()))
                .save(consumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.MOSAIC_TIBERGLASS.get(), 5)
                .pattern("TGB")
                .pattern("GGG")
                .pattern("RGP")
                .define('G', ModBlocks.CLEAR_TIBERGLASS.get())
                .define('T', ModItems.TIBERIUM.get())
                .define('B', ModItems.TIBERIUM_BLUE.get())
                .define('R', ModItems.TIBERIUM_RED.get())
                .define('P', ModItems.TIBERIUM_PURPLE.get())
                .unlockedBy(getHasName(ModBlocks.MOSAIC_TIBERGLASS.get()), has(ModBlocks.MOSAIC_TIBERGLASS.get()))
                .save(consumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.GDI_TIBERGLASS.get(), 8)
                .pattern("GGG")
                .pattern("GEG")
                .pattern("GGG")
                .define('G', ModBlocks.YELLOW_TIBERGLASS.get())
                .define('E', ModItems.GDI_EMBLEM.get())
                .unlockedBy(getHasName(ModBlocks.GDI_TIBERGLASS.get()), has(ModBlocks.GDI_TIBERGLASS.get()))
                .save(consumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.NOD_TIBERGLASS.get(), 8)
                .pattern("GGG")
                .pattern("GEG")
                .pattern("GGG")
                .define('G', ModBlocks.RED_TIBERGLASS.get())
                .define('E', ModItems.NOD_EMBLEM.get())
                .unlockedBy(getHasName(ModBlocks.NOD_TIBERGLASS.get()), has(ModBlocks.NOD_TIBERGLASS.get()))
                .save(consumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.WOLF_TIBERGLASS.get(), 8)
                .pattern("GGG")
                .pattern("GEG")
                .pattern("GGG")
                .define('G', ModBlocks.BLACK_TIBERGLASS.get())
                .define('E', ModItems.WOLF_EMBLEM.get())
                .unlockedBy(getHasName(ModBlocks.WOLF_TIBERGLASS.get()), has(ModBlocks.WOLF_TIBERGLASS.get()))
                .save(consumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.BLACK_TIBERGLASS.get(), 8)
                .pattern("GGG")
                .pattern("GDG")
                .pattern("GGG")
                .define('G', ModBlocks.CLEAR_TIBERGLASS.get())
                .define('D', Items.BLACK_DYE)
                .unlockedBy(getHasName(ModBlocks.BLACK_TIBERGLASS.get()), has(ModBlocks.BLACK_TIBERGLASS.get()))
                .save(consumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.BLUE_TIBERGLASS.get(), 8)
                .pattern("GGG")
                .pattern("GDG")
                .pattern("GGG")
                .define('G', ModBlocks.CLEAR_TIBERGLASS.get())
                .define('D', Items.BLUE_DYE)
                .unlockedBy(getHasName(ModBlocks.BLUE_TIBERGLASS.get()), has(ModBlocks.BLUE_TIBERGLASS.get()))
                .save(consumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.BROWN_TIBERGLASS.get(), 8)
                .pattern("GGG")
                .pattern("GDG")
                .pattern("GGG")
                .define('G', ModBlocks.CLEAR_TIBERGLASS.get())
                .define('D', Items.BROWN_DYE)
                .unlockedBy(getHasName(ModBlocks.BROWN_TIBERGLASS.get()), has(ModBlocks.BROWN_TIBERGLASS.get()))
                .save(consumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.CYAN_TIBERGLASS.get(), 8)
                .pattern("GGG")
                .pattern("GDG")
                .pattern("GGG")
                .define('G', ModBlocks.CLEAR_TIBERGLASS.get())
                .define('D', Items.CYAN_DYE)
                .unlockedBy(getHasName(ModBlocks.CYAN_TIBERGLASS.get()), has(ModBlocks.CYAN_TIBERGLASS.get()))
                .save(consumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.GRAY_TIBERGLASS.get(), 8)
                .pattern("GGG")
                .pattern("GDG")
                .pattern("GGG")
                .define('G', ModBlocks.CLEAR_TIBERGLASS.get())
                .define('D', Items.GRAY_DYE)
                .unlockedBy(getHasName(ModBlocks.GRAY_TIBERGLASS.get()), has(ModBlocks.GRAY_TIBERGLASS.get()))
                .save(consumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.LIGHT_BLUE_TIBERGLASS.get(), 8)
                .pattern("GGG")
                .pattern("GDG")
                .pattern("GGG")
                .define('G', ModBlocks.CLEAR_TIBERGLASS.get())
                .define('D', Items.LIGHT_BLUE_DYE)
                .unlockedBy(getHasName(ModBlocks.LIGHT_BLUE_TIBERGLASS.get()), has(ModBlocks.LIGHT_BLUE_TIBERGLASS.get()))
                .save(consumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.LIGHT_GRAY_TIBERGLASS.get(), 8)
                .pattern("GGG")
                .pattern("GDG")
                .pattern("GGG")
                .define('G', ModBlocks.CLEAR_TIBERGLASS.get())
                .define('D', Items.LIGHT_GRAY_DYE)
                .unlockedBy(getHasName(ModBlocks.LIGHT_GRAY_TIBERGLASS.get()), has(ModBlocks.LIGHT_GRAY_TIBERGLASS.get()))
                .save(consumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.LIME_TIBERGLASS.get(), 8)
                .pattern("GGG")
                .pattern("GDG")
                .pattern("GGG")
                .define('G', ModBlocks.CLEAR_TIBERGLASS.get())
                .define('D', Items.LIME_DYE)
                .unlockedBy(getHasName(ModBlocks.LIME_TIBERGLASS.get()), has(ModBlocks.LIME_TIBERGLASS.get()))
                .save(consumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.MAGENTA_TIBERGLASS.get(), 8)
                .pattern("GGG")
                .pattern("GDG")
                .pattern("GGG")
                .define('G', ModBlocks.CLEAR_TIBERGLASS.get())
                .define('D', Items.MAGENTA_DYE)
                .unlockedBy(getHasName(ModBlocks.MAGENTA_TIBERGLASS.get()), has(ModBlocks.MAGENTA_TIBERGLASS.get()))
                .save(consumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.ORANGE_TIBERGLASS.get(), 8)
                .pattern("GGG")
                .pattern("GDG")
                .pattern("GGG")
                .define('G', ModBlocks.CLEAR_TIBERGLASS.get())
                .define('D', Items.ORANGE_DYE)
                .unlockedBy(getHasName(ModBlocks.ORANGE_TIBERGLASS.get()), has(ModBlocks.ORANGE_TIBERGLASS.get()))
                .save(consumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.PINK_TIBERGLASS.get(), 8)
                .pattern("GGG")
                .pattern("GDG")
                .pattern("GGG")
                .define('G', ModBlocks.CLEAR_TIBERGLASS.get())
                .define('D', Items.PINK_DYE)
                .unlockedBy(getHasName(ModBlocks.PINK_TIBERGLASS.get()), has(ModBlocks.PINK_TIBERGLASS.get()))
                .save(consumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.PURPLE_TIBERGLASS.get(), 8)
                .pattern("GGG")
                .pattern("GDG")
                .pattern("GGG")
                .define('G', ModBlocks.CLEAR_TIBERGLASS.get())
                .define('D', Items.PURPLE_DYE)
                .unlockedBy(getHasName(ModBlocks.PURPLE_TIBERGLASS.get()), has(ModBlocks.PURPLE_TIBERGLASS.get()))
                .save(consumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.RED_TIBERGLASS.get(), 8)
                .pattern("GGG")
                .pattern("GDG")
                .pattern("GGG")
                .define('G', ModBlocks.CLEAR_TIBERGLASS.get())
                .define('D', Items.RED_DYE)
                .unlockedBy(getHasName(ModBlocks.RED_TIBERGLASS.get()), has(ModBlocks.RED_TIBERGLASS.get()))
                .save(consumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.GREEN_TIBERGLASS.get(), 8)
                .pattern("GGG")
                .pattern("GDG")
                .pattern("GGG")
                .define('G', ModBlocks.CLEAR_TIBERGLASS.get())
                .define('D', Items.GREEN_DYE)
                .unlockedBy(getHasName(ModBlocks.GREEN_TIBERGLASS.get()), has(ModBlocks.GREEN_TIBERGLASS.get()))
                .save(consumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.WHITE_TIBERGLASS.get(), 8)
                .pattern("GGG")
                .pattern("GDG")
                .pattern("GGG")
                .define('G', ModBlocks.CLEAR_TIBERGLASS.get())
                .define('D', Items.WHITE_DYE)
                .unlockedBy(getHasName(ModBlocks.WHITE_TIBERGLASS.get()), has(ModBlocks.WHITE_TIBERGLASS.get()))
                .save(consumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.YELLOW_TIBERGLASS.get(), 8)
                .pattern("GGG")
                .pattern("GDG")
                .pattern("GGG")
                .define('G', ModBlocks.CLEAR_TIBERGLASS.get())
                .define('D', Items.YELLOW_DYE)
                .unlockedBy(getHasName(ModBlocks.YELLOW_TIBERGLASS.get()), has(ModBlocks.YELLOW_TIBERGLASS.get()))
                .save(consumer);

        //Shapeless Crafting:
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.TIBERIUM.get(), 9)
                .requires(ModBlocks.TIBERIUM_BLOCK.get())
                .unlockedBy(getHasName(ModBlocks.TIBERIUM_BLOCK.get()), has(ModBlocks.TIBERIUM_BLOCK.get()))
                .save(consumer);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.TIBERIUM_BLUE.get(), 9)
                .requires(ModBlocks.TIBERIUM_BLUE_BLOCK.get())
                .unlockedBy(getHasName(ModBlocks.TIBERIUM_BLUE_BLOCK.get()), has(ModBlocks.TIBERIUM_BLUE_BLOCK.get()))
                .save(consumer);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.TIBERIUM_RED.get(), 9)
                .requires(ModBlocks.TIBERIUM_RED_BLOCK.get())
                .unlockedBy(getHasName(ModBlocks.TIBERIUM_RED_BLOCK.get()), has(ModBlocks.TIBERIUM_RED_BLOCK.get()))
                .save(consumer);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.TIBERIUM_PURPLE.get(), 9)
                .requires(ModBlocks.TIBERIUM_PURPLE_BLOCK.get())
                .unlockedBy(getHasName(ModBlocks.TIBERIUM_PURPLE_BLOCK.get()), has(ModBlocks.TIBERIUM_PURPLE_BLOCK.get()))
                .save(consumer);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.AERIES_CRYSTAL.get(), 9)
                .requires(ModBlocks.AERIES_BLOCK.get())
                .unlockedBy(getHasName(ModBlocks.AERIES_BLOCK.get()), has(ModBlocks.AERIES_BLOCK.get()))
                .save(consumer);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.ENIGMA_CRYSTAL.get(), 9)
                .requires(ModBlocks.ENIGMA_BLOCK.get())
                .unlockedBy(getHasName(ModBlocks.ENIGMA_BLOCK.get()), has(ModBlocks.ENIGMA_BLOCK.get()))
                .save(consumer);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.ILLUMINA_CRYSTAL.get(), 9)
                .requires(ModBlocks.ILLUMINA_BLOCK.get())
                .unlockedBy(getHasName(ModBlocks.ILLUMINA_BLOCK.get()), has(ModBlocks.ILLUMINA_BLOCK.get()))
                .save(consumer);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.KRYON_CRYSTAL.get(), 9)
                .requires(ModBlocks.KRYON_BLOCK.get())
                .unlockedBy(getHasName(ModBlocks.KRYON_BLOCK.get()), has(ModBlocks.KRYON_BLOCK.get()))
                .save(consumer);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.GUNDANIUM_INGOT.get(), 9)
                .requires(ModBlocks.GUNDANIUM_BLOCK.get())
                .unlockedBy(getHasName(ModBlocks.GUNDANIUM_BLOCK.get()), has(ModBlocks.GUNDANIUM_BLOCK.get()))
                .save(consumer);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.ALYTHUM_INGOT.get(), 9)
                .requires(ModBlocks.ALYTHUM_BLOCK.get())
                .unlockedBy(getHasName(ModBlocks.ALYTHUM_BLOCK.get()), has(ModBlocks.ALYTHUM_BLOCK.get()))
                .save(consumer);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.ILLYRIM_INGOT.get(), 9)
                .requires(ModBlocks.ILLYRIM_BLOCK.get())
                .unlockedBy(getHasName(ModBlocks.ILLYRIM_BLOCK.get()), has(ModBlocks.ILLYRIM_BLOCK.get()))
                .save(consumer);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.LG_CORE_INGOT.get(), 9)
                .requires(ModBlocks.LG_CORE_BLOCK.get())
                .unlockedBy(getHasName(ModBlocks.LG_CORE_BLOCK.get()), has(ModBlocks.LG_CORE_BLOCK.get()))
                .save(consumer);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.MG_CORE_INGOT.get(), 9)
                .requires(ModBlocks.MG_CORE_BLOCK.get())
                .unlockedBy(getHasName(ModBlocks.MG_CORE_BLOCK.get()), has(ModBlocks.MG_CORE_BLOCK.get()))
                .save(consumer);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.HG_CORE_INGOT.get(), 9)
                .requires(ModBlocks.HG_CORE_BLOCK.get())
                .unlockedBy(getHasName(ModBlocks.HG_CORE_BLOCK.get()), has(ModBlocks.HG_CORE_BLOCK.get()))
                .save(consumer);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.FIRESTONE.get(), 9)
                .requires(ModBlocks.FIRESTONE_BLOCK.get())
                .unlockedBy(getHasName(ModBlocks.FIRESTONE_BLOCK.get()), has(ModBlocks.FIRESTONE_BLOCK.get()))
                .save(consumer);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModBlocks.BLACK_TIBERCRETE_POWDER.get(), 8)
                .requires(ModItems.TIBERIUM.get(), 4)
                .requires(Items.BLACK_DYE, 1)
                .requires(ModTags.Items.TIBERCRETE_SANDS)
                .requires(ModTags.Items.TIBERCRETE_SANDS)
                .requires(Items.GRAVEL, 2)
                .unlockedBy(getHasName(ModBlocks.BLACK_TIBERCRETE_POWDER.get()), has(ModBlocks.BLACK_TIBERCRETE_POWDER.get()))
                .save(consumer);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModBlocks.BLUE_TIBERCRETE_POWDER.get(), 8)
                .requires(ModItems.TIBERIUM.get(), 4)
                .requires(Items.BLUE_DYE, 1)
                .requires(ModTags.Items.TIBERCRETE_SANDS)
                .requires(ModTags.Items.TIBERCRETE_SANDS)
                .requires(Items.GRAVEL, 2)
                .unlockedBy(getHasName(ModBlocks.BLUE_TIBERCRETE_POWDER.get()), has(ModBlocks.BLUE_TIBERCRETE_POWDER.get()))
                .save(consumer);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModBlocks.BROWN_TIBERCRETE_POWDER.get(), 8)
                .requires(ModItems.TIBERIUM.get(), 4)
                .requires(Items.BROWN_DYE, 1)
                .requires(ModTags.Items.TIBERCRETE_SANDS)
                .requires(ModTags.Items.TIBERCRETE_SANDS)
                .requires(Items.GRAVEL, 2)
                .unlockedBy(getHasName(ModBlocks.BROWN_TIBERCRETE_POWDER.get()), has(ModBlocks.BROWN_TIBERCRETE_POWDER.get()))
                .save(consumer);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModBlocks.CYAN_TIBERCRETE_POWDER.get(), 8)
                .requires(ModItems.TIBERIUM.get(), 4)
                .requires(Items.CYAN_DYE, 1)
                .requires(ModTags.Items.TIBERCRETE_SANDS)
                .requires(ModTags.Items.TIBERCRETE_SANDS)
                .requires(Items.GRAVEL, 2)
                .unlockedBy(getHasName(ModBlocks.CYAN_TIBERCRETE_POWDER.get()), has(ModBlocks.CYAN_TIBERCRETE_POWDER.get()))
                .save(consumer);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModBlocks.GRAY_TIBERCRETE_POWDER.get(), 8)
                .requires(ModItems.TIBERIUM.get(), 4)
                .requires(Items.GRAY_DYE, 1)
                .requires(ModTags.Items.TIBERCRETE_SANDS)
                .requires(ModTags.Items.TIBERCRETE_SANDS)
                .requires(Items.GRAVEL, 2)
                .unlockedBy(getHasName(ModBlocks.GRAY_TIBERCRETE_POWDER.get()), has(ModBlocks.GRAY_TIBERCRETE_POWDER.get()))
                .save(consumer);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModBlocks.GREEN_TIBERCRETE_POWDER.get(), 8)
                .requires(ModItems.TIBERIUM.get(), 4)
                .requires(Items.GREEN_DYE, 1)
                .requires(ModTags.Items.TIBERCRETE_SANDS)
                .requires(ModTags.Items.TIBERCRETE_SANDS)
                .requires(Items.GRAVEL, 2)
                .unlockedBy(getHasName(ModBlocks.GREEN_TIBERCRETE_POWDER.get()), has(ModBlocks.GREEN_TIBERCRETE_POWDER.get()))
                .save(consumer);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModBlocks.LIGHT_BLUE_TIBERCRETE_POWDER.get(), 8)
                .requires(ModItems.TIBERIUM.get(), 4)
                .requires(Items.LIGHT_BLUE_DYE, 1)
                .requires(ModTags.Items.TIBERCRETE_SANDS)
                .requires(ModTags.Items.TIBERCRETE_SANDS)
                .requires(Items.GRAVEL, 2)
                .unlockedBy(getHasName(ModBlocks.LIGHT_BLUE_TIBERCRETE_POWDER.get()), has(ModBlocks.LIGHT_BLUE_TIBERCRETE_POWDER.get()))
                .save(consumer);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModBlocks.LIGHT_GRAY_TIBERCRETE_POWDER.get(), 8)
                .requires(ModItems.TIBERIUM.get(), 4)
                .requires(Items.LIGHT_GRAY_DYE, 1)
                .requires(ModTags.Items.TIBERCRETE_SANDS)
                .requires(ModTags.Items.TIBERCRETE_SANDS)
                .requires(Items.GRAVEL, 2)
                .unlockedBy(getHasName(ModBlocks.LIGHT_GRAY_TIBERCRETE_POWDER.get()), has(ModBlocks.LIGHT_GRAY_TIBERCRETE_POWDER.get()))
                .save(consumer);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModBlocks.LIME_TIBERCRETE_POWDER.get(), 8)
                .requires(ModItems.TIBERIUM.get(), 4)
                .requires(Items.LIME_DYE, 1)
                .requires(ModTags.Items.TIBERCRETE_SANDS)
                .requires(ModTags.Items.TIBERCRETE_SANDS)
                .requires(Items.GRAVEL, 2)
                .unlockedBy(getHasName(ModBlocks.LIME_TIBERCRETE_POWDER.get()), has(ModBlocks.LIME_TIBERCRETE_POWDER.get()))
                .save(consumer);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModBlocks.MAGENTA_TIBERCRETE_POWDER.get(), 8)
                .requires(ModItems.TIBERIUM.get(), 4)
                .requires(Items.MAGENTA_DYE, 1)
                .requires(ModTags.Items.TIBERCRETE_SANDS)
                .requires(ModTags.Items.TIBERCRETE_SANDS)
                .requires(Items.GRAVEL, 2)
                .unlockedBy(getHasName(ModBlocks.MAGENTA_TIBERCRETE_POWDER.get()), has(ModBlocks.MAGENTA_TIBERCRETE_POWDER.get()))
                .save(consumer);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModBlocks.ORANGE_TIBERCRETE_POWDER.get(), 8)
                .requires(ModItems.TIBERIUM.get(), 4)
                .requires(Items.ORANGE_DYE, 1)
                .requires(ModTags.Items.TIBERCRETE_SANDS)
                .requires(ModTags.Items.TIBERCRETE_SANDS)
                .requires(Items.GRAVEL, 2)
                .unlockedBy(getHasName(ModBlocks.ORANGE_TIBERCRETE_POWDER.get()), has(ModBlocks.ORANGE_TIBERCRETE_POWDER.get()))
                .save(consumer);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModBlocks.PINK_TIBERCRETE_POWDER.get(), 8)
                .requires(ModItems.TIBERIUM.get(), 4)
                .requires(Items.PINK_DYE, 1)
                .requires(ModTags.Items.TIBERCRETE_SANDS)
                .requires(ModTags.Items.TIBERCRETE_SANDS)
                .requires(Items.GRAVEL, 2)
                .unlockedBy(getHasName(ModBlocks.PINK_TIBERCRETE_POWDER.get()), has(ModBlocks.PINK_TIBERCRETE_POWDER.get()))
                .save(consumer);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModBlocks.PURPLE_TIBERCRETE_POWDER.get(), 8)
                .requires(ModItems.TIBERIUM.get(), 4)
                .requires(Items.PURPLE_DYE, 1)
                .requires(ModTags.Items.TIBERCRETE_SANDS)
                .requires(ModTags.Items.TIBERCRETE_SANDS)
                .requires(Items.GRAVEL, 2)
                .unlockedBy(getHasName(ModBlocks.PURPLE_TIBERCRETE_POWDER.get()), has(ModBlocks.PURPLE_TIBERCRETE_POWDER.get()))
                .save(consumer);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModBlocks.RED_TIBERCRETE_POWDER.get(), 8)
                .requires(ModItems.TIBERIUM.get(), 4)
                .requires(Items.RED_DYE, 1)
                .requires(ModTags.Items.TIBERCRETE_SANDS)
                .requires(ModTags.Items.TIBERCRETE_SANDS)
                .requires(Items.GRAVEL, 2)
                .unlockedBy(getHasName(ModBlocks.RED_TIBERCRETE_POWDER.get()), has(ModBlocks.RED_TIBERCRETE_POWDER.get()))
                .save(consumer);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModBlocks.WHITE_TIBERCRETE_POWDER.get(), 8)
                .requires(ModItems.TIBERIUM.get(), 4)
                .requires(Items.WHITE_DYE, 1)
                .requires(ModTags.Items.TIBERCRETE_SANDS)
                .requires(ModTags.Items.TIBERCRETE_SANDS)
                .requires(Items.GRAVEL, 2)
                .unlockedBy(getHasName(ModBlocks.WHITE_TIBERCRETE_POWDER.get()), has(ModBlocks.WHITE_TIBERCRETE_POWDER.get()))
                .save(consumer);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModBlocks.YELLOW_TIBERCRETE_POWDER.get(), 8)
                .requires(ModItems.TIBERIUM.get(), 4)
                .requires(Items.YELLOW_DYE, 1)
                .requires(ModTags.Items.TIBERCRETE_SANDS)
                .requires(ModTags.Items.TIBERCRETE_SANDS)
                .requires(Items.GRAVEL, 2)
                .unlockedBy(getHasName(ModBlocks.YELLOW_TIBERCRETE_POWDER.get()), has(ModBlocks.YELLOW_TIBERCRETE_POWDER.get()))
                .save(consumer);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModBlocks.BLACK_TIBERCRETE.get(), 8)
                .requires(ModBlocks.BLACK_TIBERCRETE_POWDER.get(), 8)
                .requires(Items.WATER_BUCKET, 1)
                .unlockedBy(getHasName(ModBlocks.BLACK_TIBERCRETE_POWDER.get()), has(ModBlocks.BLACK_TIBERCRETE_POWDER.get()))
                .save(consumer);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModBlocks.BLUE_TIBERCRETE.get(), 8)
                .requires(ModBlocks.BLUE_TIBERCRETE_POWDER.get(), 8)
                .requires(Items.WATER_BUCKET, 1)
                .unlockedBy(getHasName(ModBlocks.BLUE_TIBERCRETE_POWDER.get()), has(ModBlocks.BLUE_TIBERCRETE_POWDER.get()))
                .save(consumer);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModBlocks.BROWN_TIBERCRETE.get(), 8)
                .requires(ModBlocks.BROWN_TIBERCRETE_POWDER.get(), 8)
                .requires(Items.WATER_BUCKET, 1)
                .unlockedBy(getHasName(ModBlocks.BROWN_TIBERCRETE_POWDER.get()), has(ModBlocks.BROWN_TIBERCRETE_POWDER.get()))
                .save(consumer);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModBlocks.CYAN_TIBERCRETE.get(), 8)
                .requires(ModBlocks.CYAN_TIBERCRETE_POWDER.get(), 8)
                .requires(Items.WATER_BUCKET, 1)
                .unlockedBy(getHasName(ModBlocks.CYAN_TIBERCRETE_POWDER.get()), has(ModBlocks.CYAN_TIBERCRETE_POWDER.get()))
                .save(consumer);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModBlocks.GRAY_TIBERCRETE.get(), 8)
                .requires(ModBlocks.GRAY_TIBERCRETE_POWDER.get(), 8)
                .requires(Items.WATER_BUCKET, 1)
                .unlockedBy(getHasName(ModBlocks.GRAY_TIBERCRETE_POWDER.get()), has(ModBlocks.GRAY_TIBERCRETE_POWDER.get()))
                .save(consumer);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModBlocks.GREEN_TIBERCRETE.get(), 8)
                .requires(ModBlocks.GREEN_TIBERCRETE_POWDER.get(), 8)
                .requires(Items.WATER_BUCKET, 1)
                .unlockedBy(getHasName(ModBlocks.GREEN_TIBERCRETE_POWDER.get()), has(ModBlocks.GREEN_TIBERCRETE_POWDER.get()))
                .save(consumer);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModBlocks.LIGHT_BLUE_TIBERCRETE.get(), 8)
                .requires(ModBlocks.LIGHT_BLUE_TIBERCRETE_POWDER.get(), 8)
                .requires(Items.WATER_BUCKET, 1)
                .unlockedBy(getHasName(ModBlocks.LIGHT_BLUE_TIBERCRETE_POWDER.get()), has(ModBlocks.LIGHT_BLUE_TIBERCRETE_POWDER.get()))
                .save(consumer);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModBlocks.LIGHT_GRAY_TIBERCRETE.get(), 8)
                .requires(ModBlocks.LIGHT_GRAY_TIBERCRETE_POWDER.get(), 8)
                .requires(Items.WATER_BUCKET, 1)
                .unlockedBy(getHasName(ModBlocks.LIGHT_GRAY_TIBERCRETE_POWDER.get()), has(ModBlocks.LIGHT_GRAY_TIBERCRETE_POWDER.get()))
                .save(consumer);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModBlocks.LIME_TIBERCRETE.get(), 8)
                .requires(ModBlocks.LIME_TIBERCRETE_POWDER.get(), 8)
                .requires(Items.WATER_BUCKET, 1)
                .unlockedBy(getHasName(ModBlocks.LIME_TIBERCRETE_POWDER.get()), has(ModBlocks.LIME_TIBERCRETE_POWDER.get()))
                .save(consumer);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModBlocks.MAGENTA_TIBERCRETE.get(), 8)
                .requires(ModBlocks.MAGENTA_TIBERCRETE_POWDER.get(), 8)
                .requires(Items.WATER_BUCKET, 1)
                .unlockedBy(getHasName(ModBlocks.MAGENTA_TIBERCRETE_POWDER.get()), has(ModBlocks.MAGENTA_TIBERCRETE_POWDER.get()))
                .save(consumer);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModBlocks.ORANGE_TIBERCRETE.get(), 8)
                .requires(ModBlocks.ORANGE_TIBERCRETE_POWDER.get(), 8)
                .requires(Items.WATER_BUCKET, 1)
                .unlockedBy(getHasName(ModBlocks.ORANGE_TIBERCRETE_POWDER.get()), has(ModBlocks.ORANGE_TIBERCRETE_POWDER.get()))
                .save(consumer);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModBlocks.PINK_TIBERCRETE.get(), 8)
                .requires(ModBlocks.PINK_TIBERCRETE_POWDER.get(), 8)
                .requires(Items.WATER_BUCKET, 1)
                .unlockedBy(getHasName(ModBlocks.PINK_TIBERCRETE_POWDER.get()), has(ModBlocks.PINK_TIBERCRETE_POWDER.get()))
                .save(consumer);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModBlocks.PURPLE_TIBERCRETE.get(), 8)
                .requires(ModBlocks.PURPLE_TIBERCRETE_POWDER.get(), 8)
                .requires(Items.WATER_BUCKET, 1)
                .unlockedBy(getHasName(ModBlocks.PURPLE_TIBERCRETE_POWDER.get()), has(ModBlocks.PURPLE_TIBERCRETE_POWDER.get()))
                .save(consumer);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModBlocks.RED_TIBERCRETE.get(), 8)
                .requires(ModBlocks.RED_TIBERCRETE_POWDER.get(), 8)
                .requires(Items.WATER_BUCKET, 1)
                .unlockedBy(getHasName(ModBlocks.RED_TIBERCRETE_POWDER.get()), has(ModBlocks.RED_TIBERCRETE_POWDER.get()))
                .save(consumer);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModBlocks.WHITE_TIBERCRETE.get(), 8)
                .requires(ModBlocks.WHITE_TIBERCRETE_POWDER.get(), 8)
                .requires(Items.WATER_BUCKET, 1)
                .unlockedBy(getHasName(ModBlocks.WHITE_TIBERCRETE_POWDER.get()), has(ModBlocks.WHITE_TIBERCRETE_POWDER.get()))
                .save(consumer);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModBlocks.YELLOW_TIBERCRETE.get(), 8)
                .requires(ModBlocks.YELLOW_TIBERCRETE_POWDER.get(), 8)
                .requires(Items.WATER_BUCKET, 1)
                .unlockedBy(getHasName(ModBlocks.YELLOW_TIBERCRETE_POWDER.get()), has(ModBlocks.YELLOW_TIBERCRETE_POWDER.get()))
                .save(consumer);




    //Stonecutter:


    }

    protected static void oreSmelting(Consumer<FinishedRecipe> pFinishedRecipeConsumer, List<ItemLike> pIngredients,
                                      RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTIme,
                                      String pGroup) {
        oreCooking(pFinishedRecipeConsumer, RecipeSerializer.SMELTING_RECIPE, pIngredients, pCategory, pResult,
                pExperience, pCookingTIme, pGroup, "_from_smelting");
    }

    protected static void oreBlasting(Consumer<FinishedRecipe> pFinishedRecipeConsumer, List<ItemLike> pIngredients,
                                      RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTime,
                                      String pGroup) {
        oreCooking(pFinishedRecipeConsumer, RecipeSerializer.BLASTING_RECIPE, pIngredients, pCategory, pResult,
                pExperience, pCookingTime, pGroup, "_from_blasting");
    }

    protected static void oreCooking(Consumer<FinishedRecipe> pFinishedRecipeConsumer, RecipeSerializer<? extends
            AbstractCookingRecipe> pCookingSerializer, List<ItemLike> pIngredients, RecipeCategory pCategory,
                                     ItemLike pResult, float pExperience, int pCookingTime, String pGroup,
                                     String pRecipeName) {

        Iterator var9 = pIngredients.iterator();

        while(var9.hasNext()) {
            ItemLike itemlike = (ItemLike)var9.next();
            SimpleCookingRecipeBuilder.generic(Ingredient.of(new ItemLike[]{itemlike}), pCategory, pResult,
                    pExperience, pCookingTime, pCookingSerializer)
                    .group(pGroup).unlockedBy(getHasName(itemlike), has(itemlike))
                    .save(pFinishedRecipeConsumer, CrystalTech.MOD_ID + ":" + (pResult) + pRecipeName + "_" + getItemName(itemlike));
        }

    }


}
