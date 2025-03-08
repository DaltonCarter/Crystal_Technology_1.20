package com.CartersDev.crystechmod.datagen;


import com.CartersDev.crystechmod.CrystalTech;
import com.CartersDev.crystechmod.block.ModBlocks;
import com.CartersDev.crystechmod.datagen.custom.TiberiumGrinderRecipeBuilder;
import com.CartersDev.crystechmod.datagen.custom.TiberiumInfuserRecipeBuilder;
import com.CartersDev.crystechmod.fluid.ModFluidTypes;
import com.CartersDev.crystechmod.fluid.ModFluids;
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
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;
import net.minecraftforge.fluids.FluidStack;
import org.jetbrains.annotations.NotNull;

import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;

public class ModRecipeProvider  extends RecipeProvider implements IConditionBuilder {

    private static final List<ItemLike> GUNDANIUM_SMELTABLES = List.of(ModItems.RAW_GUNDANIUM.get(),
            ModItems.GUNDANIUM_DUST.get(), ModBlocks.GUNDANIUM_ORE.get(), ModBlocks.DEEPSLATE_GUNDANIUM_ORE.get());

    private static final List<ItemLike> ALYTHUM_SMELTABLES = List.of(ModItems.RAW_ALYTHUM.get(),
            ModItems.ALYTHUM_DUST.get(), ModBlocks.ALYTHUM_ORE.get(), ModBlocks.DEEPSLATE_ALYTHUM_ORE.get(), ModBlocks.NETHER_ALYTHUM_ORE.get());

    private static final List<ItemLike> IRON_DUST_SMELTABLES = List.of(ModItems.IRON_DUST.get());
    private static final List<ItemLike> COPPER_DUST_SMELTABLES = List.of(ModItems.COPPER_DUST.get());
    private static final List<ItemLike> GOLD_DUST_SMELTABLES = List.of(ModItems.GOLD_DUST.get());
    private static final List<ItemLike> INFECTED_MEAT_SMELTABLES = List.of(ModItems.RAW_INFECTED_MEAT.get());


    private static final List<ItemLike> LG_CORE_STEEL = List.of(ModItems.LG_CORE_BLEND.get());
    private static final List<ItemLike> MG_CORE_STEEL = List.of(ModItems.MG_CORE_BLEND.get());
    private static final List<ItemLike> HG_CORE_STEEL = List.of(ModItems.HG_CORE_BLEND.get());
    private static final List<ItemLike> ILLYRIM_ALLOY = List.of(ModItems.ILLYRIM_BLEND.get());




    public ModRecipeProvider(PackOutput pOutput) {
        super(pOutput);
    }

    @Override
    protected void buildRecipes(Consumer<FinishedRecipe> consumer) {

//      Blasting and Smelting:
        oreSmelting(consumer, INFECTED_MEAT_SMELTABLES, RecipeCategory.MISC, ModItems.COOKED_INFECTED_MEAT.get(), 0.25f, 200, "cooked_infected_meat");

        oreSmelting(consumer, COPPER_DUST_SMELTABLES, RecipeCategory.MISC, Items.COPPER_INGOT, 0.25f, 200, "copper");
        oreBlasting(consumer, COPPER_DUST_SMELTABLES, RecipeCategory.MISC, Items.COPPER_INGOT, 0.25f, 100, "copper");

        oreSmelting(consumer, IRON_DUST_SMELTABLES, RecipeCategory.MISC, Items.IRON_INGOT, 0.25f, 200, "iron");
        oreBlasting(consumer, IRON_DUST_SMELTABLES, RecipeCategory.MISC, Items.IRON_INGOT, 0.25f, 100, "iron");

        oreSmelting(consumer, GOLD_DUST_SMELTABLES, RecipeCategory.MISC, Items.GOLD_INGOT, 0.25f, 200, "gold");
        oreBlasting(consumer, GOLD_DUST_SMELTABLES, RecipeCategory.MISC, Items.GOLD_INGOT, 0.25f, 100, "gold");

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
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.TIBERIUM_GRINDER.get())
                .pattern("GGG")
                .pattern("GAG")
                .pattern("CCC")
                .define('A', ModItems.GRINDER_GEAR.get())
                .define('G', ModItems.GUNDANIUM_INGOT.get())
                .define('C', ModTags.Items.CONCRETES)
                .unlockedBy(getHasName(ModItems.GUNDANIUM_INGOT.get()), has(ModItems.GUNDANIUM_INGOT.get()))
                .save(consumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.SABER_BREAD.get())
                .pattern("   ")
                .pattern("   ")
                .pattern("CCC")
                .define('C', ModItems.SABER_CORN.get())
                .unlockedBy(getHasName(ModItems.SABER_CORN.get()), has(ModItems.SABER_CORN.get()))
                .save(consumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.ZAIRAN_FRUIT_SALAD.get())
                .pattern("GGG")
                .pattern("ABA")
                .pattern("LLL")
                .define('A', ModItems.HEIM_BERRY.get())
                .define('G', ModItems.HEL_FRUIT.get())
                .define('L', ModItems.LAI_MELON_SLICE.get())
                .define('B', Items.BOWL)
                .unlockedBy(getHasName(ModItems.HEIM_BERRY.get()), has(ModItems.HEIM_BERRY.get()))
                .save(consumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.GRINDER_GEAR.get())
                .pattern("NTN")
                .pattern("TNT")
                .pattern("NTN")
                .define('N', Items.IRON_NUGGET)
                .define('T', Items.IRON_INGOT)
                .unlockedBy(getHasName(Items.IRON_INGOT), has(Items.IRON_INGOT))
                .save(consumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.ILLYRIM_GRINDER_GEAR.get())
                .pattern("NTN")
                .pattern("TNT")
                .pattern("NTN")
                .define('N', ModItems.GRINDER_GEAR.get())
                .define('T', ModItems.ILLYRIM_INGOT.get())
                .unlockedBy(getHasName(ModItems.ILLYRIM_INGOT.get()), has(ModItems.ILLYRIM_INGOT.get()))
                .save(consumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.LAI_MELON.get())
                .pattern("TTT")
                .pattern("TTT")
                .pattern("TTT")
                .define('T', ModItems.LAI_MELON_SLICE.get())
                .unlockedBy(getHasName(ModItems.LAI_MELON_SLICE.get()), has(ModItems.LAI_MELON_SLICE.get()))
                .save(consumer);

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

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.INFESTED_STONE_BRICK_STAIRS.get(), 4)
                .pattern("S  ")
                .pattern("SS ")
                .pattern("SSS")
                .define('S', ModBlocks.INFESTED_STONE_BRICKS.get())
                .unlockedBy(getHasName(ModBlocks.INFESTED_STONE_BRICKS.get()), has(ModBlocks.INFESTED_STONE_BRICKS.get()))
                .save(consumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.INFESTED_COBBLE_STAIRS.get(), 4)
                .pattern("S  ")
                .pattern("SS ")
                .pattern("SSS")
                .define('S', ModBlocks.INFESTED_COBBLE.get())
                .unlockedBy(getHasName(ModBlocks.INFESTED_COBBLE.get()), has(ModBlocks.INFESTED_COBBLE.get()))
                .save(consumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.INFESTED_COBBLE_SLAB.get(), 6)
                .pattern("   ")
                .pattern("   ")
                .pattern("SSS")
                .define('S', ModBlocks.INFESTED_COBBLE.get())
                .unlockedBy(getHasName(ModBlocks.INFESTED_COBBLE.get()), has(ModBlocks.INFESTED_COBBLE.get()))
                .save(consumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.INFESTED_STONE_BRICK_SLAB.get(), 6)
                .pattern("   ")
                .pattern("   ")
                .pattern("SSS")
                .define('S', ModBlocks.INFESTED_STONE_BRICKS.get())
                .unlockedBy(getHasName(ModBlocks.INFESTED_STONE_BRICKS.get()), has(ModBlocks.INFESTED_STONE_BRICKS.get()))
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


        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.CLEAR_TIBERGLASS_PANE.get(), 16)
                .pattern("   ")
                .pattern("GGG")
                .pattern("GGG")
                .define('G', ModBlocks.CLEAR_TIBERGLASS.get())
                .unlockedBy(getHasName(ModBlocks.CLEAR_TIBERGLASS.get()), has(ModBlocks.CLEAR_TIBERGLASS.get()))
                .save(consumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.MOSAIC_TIBERGLASS_PANE.get(), 16)
                .pattern("   ")
                .pattern("GGG")
                .pattern("GGG")
                .define('G', ModBlocks.MOSAIC_TIBERGLASS.get())
                .unlockedBy(getHasName(ModBlocks.MOSAIC_TIBERGLASS.get()), has(ModBlocks.MOSAIC_TIBERGLASS.get()))
                .save(consumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.GDI_TIBERGLASS_PANE.get(), 16)
                .pattern("   ")
                .pattern("GGG")
                .pattern("GGG")
                .define('G', ModBlocks.GDI_TIBERGLASS.get())
                .unlockedBy(getHasName(ModBlocks.GDI_TIBERGLASS.get()), has(ModBlocks.GDI_TIBERGLASS.get()))
                .save(consumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.NOD_TIBERGLASS_PANE.get(), 16)
                .pattern("   ")
                .pattern("GGG")
                .pattern("GGG")
                .define('G', ModBlocks.NOD_TIBERGLASS.get())
                .unlockedBy(getHasName(ModBlocks.NOD_TIBERGLASS.get()), has(ModBlocks.NOD_TIBERGLASS.get()))
                .save(consumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.WOLF_TIBERGLASS_PANE.get(), 16)
                .pattern("   ")
                .pattern("GGG")
                .pattern("GGG")
                .define('G', ModBlocks.WOLF_TIBERGLASS.get())
                .unlockedBy(getHasName(ModBlocks.WOLF_TIBERGLASS.get()), has(ModBlocks.WOLF_TIBERGLASS.get()))
                .save(consumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.BLACK_TIBERGLASS_PANE.get(), 16)
                .pattern("   ")
                .pattern("GGG")
                .pattern("GGG")
                .define('G', ModBlocks.BLACK_TIBERGLASS.get())
                .unlockedBy(getHasName(ModBlocks.BLACK_TIBERGLASS.get()), has(ModBlocks.BLACK_TIBERGLASS.get()))
                .save(consumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.BLUE_TIBERGLASS_PANE.get(), 16)
                .pattern("   ")
                .pattern("GGG")
                .pattern("GGG")
                .define('G', ModBlocks.BLUE_TIBERGLASS.get())
                .unlockedBy(getHasName(ModBlocks.BLUE_TIBERGLASS.get()), has(ModBlocks.BLUE_TIBERGLASS.get()))
                .save(consumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.BROWN_TIBERGLASS_PANE.get(), 16)
                .pattern("   ")
                .pattern("GGG")
                .pattern("GGG")
                .define('G', ModBlocks.BROWN_TIBERGLASS.get())
                .unlockedBy(getHasName(ModBlocks.BROWN_TIBERGLASS.get()), has(ModBlocks.BROWN_TIBERGLASS.get()))
                .save(consumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.CYAN_TIBERGLASS_PANE.get(), 16)
                .pattern("   ")
                .pattern("GGG")
                .pattern("GGG")
                .define('G', ModBlocks.CYAN_TIBERGLASS.get())
                .unlockedBy(getHasName(ModBlocks.CYAN_TIBERGLASS.get()), has(ModBlocks.CYAN_TIBERGLASS.get()))
                .save(consumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.GRAY_TIBERGLASS_PANE.get(), 16)
                .pattern("   ")
                .pattern("GGG")
                .pattern("GGG")
                .define('G', ModBlocks.GRAY_TIBERGLASS.get())
                .unlockedBy(getHasName(ModBlocks.GRAY_TIBERGLASS.get()), has(ModBlocks.GRAY_TIBERGLASS.get()))
                .save(consumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.LIGHT_BLUE_TIBERGLASS_PANE.get(), 16)
                .pattern("   ")
                .pattern("GGG")
                .pattern("GGG")
                .define('G', ModBlocks.LIGHT_BLUE_TIBERGLASS.get())
                .unlockedBy(getHasName(ModBlocks.LIGHT_BLUE_TIBERGLASS.get()), has(ModBlocks.LIGHT_BLUE_TIBERGLASS.get()))
                .save(consumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.LIGHT_GRAY_TIBERGLASS_PANE.get(), 16)
                .pattern("   ")
                .pattern("GGG")
                .pattern("GGG")
                .define('G', ModBlocks.LIGHT_GRAY_TIBERGLASS.get())
                .unlockedBy(getHasName(ModBlocks.LIGHT_GRAY_TIBERGLASS.get()), has(ModBlocks.LIGHT_GRAY_TIBERGLASS.get()))
                .save(consumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.LIME_TIBERGLASS_PANE.get(), 16)
                .pattern("   ")
                .pattern("GGG")
                .pattern("GGG")
                .define('G', ModBlocks.LIME_TIBERGLASS.get())
                .unlockedBy(getHasName(ModBlocks.LIME_TIBERGLASS.get()), has(ModBlocks.LIME_TIBERGLASS.get()))
                .save(consumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.MAGENTA_TIBERGLASS_PANE.get(), 16)
                .pattern("   ")
                .pattern("GGG")
                .pattern("GGG")
                .define('G', ModBlocks.MAGENTA_TIBERGLASS.get())
                .unlockedBy(getHasName(ModBlocks.MAGENTA_TIBERGLASS.get()), has(ModBlocks.MAGENTA_TIBERGLASS.get()))
                .save(consumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.ORANGE_TIBERGLASS_PANE.get(), 16)
                .pattern("   ")
                .pattern("GGG")
                .pattern("GGG")
                .define('G', ModBlocks.ORANGE_TIBERGLASS.get())
                .unlockedBy(getHasName(ModBlocks.ORANGE_TIBERGLASS.get()), has(ModBlocks.ORANGE_TIBERGLASS.get()))
                .save(consumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.PINK_TIBERGLASS_PANE.get(), 16)
                .pattern("   ")
                .pattern("GGG")
                .pattern("GGG")
                .define('G', ModBlocks.PINK_TIBERGLASS.get())
                .unlockedBy(getHasName(ModBlocks.PINK_TIBERGLASS.get()), has(ModBlocks.PINK_TIBERGLASS.get()))
                .save(consumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.PURPLE_TIBERGLASS_PANE.get(), 16)
                .pattern("   ")
                .pattern("GGG")
                .pattern("GGG")
                .define('G', ModBlocks.PURPLE_TIBERGLASS.get())
                .unlockedBy(getHasName(ModBlocks.PURPLE_TIBERGLASS.get()), has(ModBlocks.PURPLE_TIBERGLASS.get()))
                .save(consumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.RED_TIBERGLASS_PANE.get(), 16)
                .pattern("   ")
                .pattern("GGG")
                .pattern("GGG")
                .define('G', ModBlocks.RED_TIBERGLASS.get())
                .unlockedBy(getHasName(ModBlocks.RED_TIBERGLASS.get()), has(ModBlocks.RED_TIBERGLASS.get()))
                .save(consumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.GREEN_TIBERGLASS_PANE.get(), 16)
                .pattern("   ")
                .pattern("GGG")
                .pattern("GGG")
                .define('G', ModBlocks.GREEN_TIBERGLASS.get())
                .unlockedBy(getHasName(ModBlocks.GREEN_TIBERGLASS.get()), has(ModBlocks.GREEN_TIBERGLASS.get()))
                .save(consumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.WHITE_TIBERGLASS_PANE.get(), 16)
                .pattern("   ")
                .pattern("GGG")
                .pattern("GGG")
                .define('G', ModBlocks.WHITE_TIBERGLASS.get())
                .unlockedBy(getHasName(ModBlocks.WHITE_TIBERGLASS.get()), has(ModBlocks.WHITE_TIBERGLASS.get()))
                .save(consumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.YELLOW_TIBERGLASS_PANE.get(), 16)
                .pattern("   ")
                .pattern("GGG")
                .pattern("GGG")
                .define('G', ModBlocks.YELLOW_TIBERGLASS.get())
                .unlockedBy(getHasName(ModBlocks.YELLOW_TIBERGLASS.get()), has(ModBlocks.YELLOW_TIBERGLASS.get()))
                .save(consumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.PLAGUED_STICK.get(), 4)
                .pattern("   ")
                .pattern("  P")
                .pattern("  P")
                .define('P', ModBlocks.PLAGUED_PLANKS.get())
                .unlockedBy(getHasName(ModBlocks.PLAGUED_PLANKS.get()), has(ModBlocks.PLAGUED_PLANKS.get()))
                .save(consumer);


        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.PLAGUED_STAIRS.get(), 4)
                .pattern("P  ")
                .pattern("PP ")
                .pattern("PPP")
                .define('P', ModBlocks.PLAGUED_PLANKS.get())
                .unlockedBy(getHasName(ModBlocks.PLAGUED_PLANKS.get()), has(ModBlocks.PLAGUED_PLANKS.get()))
                .save(consumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.PLAGUED_SLAB.get(), 6)
                .pattern("   ")
                .pattern("   ")
                .pattern("PPP")
                .define('P', ModBlocks.PLAGUED_PLANKS.get())
                .unlockedBy(getHasName(ModBlocks.PLAGUED_PLANKS.get()), has(ModBlocks.PLAGUED_PLANKS.get()))
                .save(consumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.PLAGUED_PRESSURE_PLATE.get(), 1)
                .pattern("   ")
                .pattern("   ")
                .pattern(" PP")
                .define('P', ModBlocks.PLAGUED_PLANKS.get())
                .unlockedBy(getHasName(ModBlocks.PLAGUED_PLANKS.get()), has(ModBlocks.PLAGUED_PLANKS.get()))
                .save(consumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.PLAGUED_TRAPDOOR.get(), 2)
                .pattern("   ")
                .pattern("PPP")
                .pattern("PPP")
                .define('P', ModBlocks.PLAGUED_PLANKS.get())
                .unlockedBy(getHasName(ModBlocks.PLAGUED_PLANKS.get()), has(ModBlocks.PLAGUED_PLANKS.get()))
                .save(consumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.PLAGUED_DOOR.get(), 3)
                .pattern(" PP")
                .pattern(" PP")
                .pattern(" PP")
                .define('P', ModBlocks.PLAGUED_PLANKS.get())
                .unlockedBy(getHasName(ModBlocks.PLAGUED_PLANKS.get()), has(ModBlocks.PLAGUED_PLANKS.get()))
                .save(consumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.PLAGUED_FENCE.get(), 3)
                .pattern("   ")
                .pattern("PSP")
                .pattern("PSP")
                .define('P', ModBlocks.PLAGUED_PLANKS.get())
                .define('S', ModItems.PLAGUED_STICK.get())
                .unlockedBy(getHasName(ModBlocks.PLAGUED_PLANKS.get()), has(ModBlocks.PLAGUED_PLANKS.get()))
                .save(consumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.PLAGUED_FENCE_GATE.get(), 1)
                .pattern("   ")
                .pattern("SPS")
                .pattern("SPS")
                .define('P', ModBlocks.PLAGUED_PLANKS.get())
                .define('S', ModItems.PLAGUED_STICK.get())
                .unlockedBy(getHasName(ModBlocks.PLAGUED_PLANKS.get()), has(ModBlocks.PLAGUED_PLANKS.get()))
                .save(consumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.EMBER_OAK_STAIRS.get(), 4)
                .pattern("E  ")
                .pattern("EE ")
                .pattern("EEE")
                .define('E', ModBlocks.EMBER_OAK_PLANKS.get())
                .unlockedBy(getHasName(ModBlocks.EMBER_OAK_PLANKS.get()), has(ModBlocks.EMBER_OAK_PLANKS.get()))
                .save(consumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.EMBER_OAK_SLAB.get(), 6)
                .pattern("   ")
                .pattern("   ")
                .pattern("EEE")
                .define('E', ModBlocks.EMBER_OAK_PLANKS.get())
                .unlockedBy(getHasName(ModBlocks.EMBER_OAK_PLANKS.get()), has(ModBlocks.EMBER_OAK_PLANKS.get()))
                .save(consumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.EMBER_OAK_PRESSURE_PLATE.get(), 1)
                .pattern("   ")
                .pattern("   ")
                .pattern(" EE")
                .define('E', ModBlocks.EMBER_OAK_PLANKS.get())
                .unlockedBy(getHasName(ModBlocks.EMBER_OAK_PLANKS.get()), has(ModBlocks.EMBER_OAK_PLANKS.get()))
                .save(consumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.EMBER_OAK_TRAPDOOR.get(), 2)
                .pattern("   ")
                .pattern("EEE")
                .pattern("EEE")
                .define('E', ModBlocks.EMBER_OAK_PLANKS.get())
                .unlockedBy(getHasName(ModBlocks.EMBER_OAK_PLANKS.get()), has(ModBlocks.EMBER_OAK_PLANKS.get()))
                .save(consumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.EMBER_OAK_DOOR.get(), 3)
                .pattern(" EE")
                .pattern(" EE")
                .pattern(" EE")
                .define('E', ModBlocks.EMBER_OAK_PLANKS.get())
                .unlockedBy(getHasName(ModBlocks.EMBER_OAK_PLANKS.get()), has(ModBlocks.EMBER_OAK_PLANKS.get()))
                .save(consumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.EMBER_OAK_FENCE.get(), 3)
                .pattern("   ")
                .pattern("ESE")
                .pattern("ESE")
                .define('E', ModBlocks.EMBER_OAK_PLANKS.get())
                .define('S', Items.STICK)
                .unlockedBy(getHasName(ModBlocks.EMBER_OAK_PLANKS.get()), has(ModBlocks.EMBER_OAK_PLANKS.get()))
                .save(consumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.DEAD_FENCE_GATE.get(), 1)
                .pattern("   ")
                .pattern("SES")
                .pattern("SES")
                .define('E', ModBlocks.DEAD_PLANKS.get())
                .define('S', Items.STICK)
                .unlockedBy(getHasName(ModBlocks.DEAD_PLANKS.get()), has(ModBlocks.DEAD_PLANKS.get()))
                .save(consumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.DEAD_STAIRS.get(), 4)
                .pattern("E  ")
                .pattern("EE ")
                .pattern("EEE")
                .define('E', ModBlocks.DEAD_PLANKS.get())
                .unlockedBy(getHasName(ModBlocks.DEAD_PLANKS.get()), has(ModBlocks.DEAD_PLANKS.get()))
                .save(consumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.DEAD_SLAB.get(), 6)
                .pattern("   ")
                .pattern("   ")
                .pattern("EEE")
                .define('E', ModBlocks.DEAD_PLANKS.get())
                .unlockedBy(getHasName(ModBlocks.DEAD_PLANKS.get()), has(ModBlocks.DEAD_PLANKS.get()))
                .save(consumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.DEAD_PRESSURE_PLATE.get(), 1)
                .pattern("   ")
                .pattern("   ")
                .pattern(" EE")
                .define('E', ModBlocks.DEAD_PLANKS.get())
                .unlockedBy(getHasName(ModBlocks.DEAD_PLANKS.get()), has(ModBlocks.DEAD_PLANKS.get()))
                .save(consumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.DEAD_TRAPDOOR.get(), 2)
                .pattern("   ")
                .pattern("EEE")
                .pattern("EEE")
                .define('E', ModBlocks.DEAD_PLANKS.get())
                .unlockedBy(getHasName(ModBlocks.DEAD_PLANKS.get()), has(ModBlocks.DEAD_PLANKS.get()))
                .save(consumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.DEAD_DOOR.get(), 3)
                .pattern(" EE")
                .pattern(" EE")
                .pattern(" EE")
                .define('E', ModBlocks.DEAD_PLANKS.get())
                .unlockedBy(getHasName(ModBlocks.DEAD_PLANKS.get()), has(ModBlocks.DEAD_PLANKS.get()))
                .save(consumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.DEAD_FENCE.get(), 3)
                .pattern("   ")
                .pattern("ESE")
                .pattern("ESE")
                .define('E', ModBlocks.DEAD_PLANKS.get())
                .define('S', Items.STICK)
                .unlockedBy(getHasName(ModBlocks.DEAD_PLANKS.get()), has(ModBlocks.DEAD_PLANKS.get()))
                .save(consumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.MARIKA_OAK_FENCE_GATE.get(), 1)
                .pattern("   ")
                .pattern("SES")
                .pattern("SES")
                .define('E', ModBlocks.MARIKA_OAK_PLANKS.get())
                .define('S', Items.STICK)
                .unlockedBy(getHasName(ModBlocks.MARIKA_OAK_PLANKS.get()), has(ModBlocks.MARIKA_OAK_PLANKS.get()))
                .save(consumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.MARIKA_OAK_STAIRS.get(), 4)
                .pattern("E  ")
                .pattern("EE ")
                .pattern("EEE")
                .define('E', ModBlocks.MARIKA_OAK_PLANKS.get())
                .unlockedBy(getHasName(ModBlocks.MARIKA_OAK_PLANKS.get()), has(ModBlocks.MARIKA_OAK_PLANKS.get()))
                .save(consumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.MARIKA_OAK_SLAB.get(), 6)
                .pattern("   ")
                .pattern("   ")
                .pattern("EEE")
                .define('E', ModBlocks.MARIKA_OAK_PLANKS.get())
                .unlockedBy(getHasName(ModBlocks.MARIKA_OAK_PLANKS.get()), has(ModBlocks.MARIKA_OAK_PLANKS.get()))
                .save(consumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.MARIKA_OAK_PRESSURE_PLATE.get(), 1)
                .pattern("   ")
                .pattern("   ")
                .pattern(" EE")
                .define('E', ModBlocks.MARIKA_OAK_PLANKS.get())
                .unlockedBy(getHasName(ModBlocks.MARIKA_OAK_PLANKS.get()), has(ModBlocks.MARIKA_OAK_PLANKS.get()))
                .save(consumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.MARIKA_OAK_TRAPDOOR.get(), 2)
                .pattern("   ")
                .pattern("EEE")
                .pattern("EEE")
                .define('E', ModBlocks.MARIKA_OAK_PLANKS.get())
                .unlockedBy(getHasName(ModBlocks.MARIKA_OAK_PLANKS.get()), has(ModBlocks.MARIKA_OAK_PLANKS.get()))
                .save(consumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.MARIKA_OAK_DOOR.get(), 3)
                .pattern(" EE")
                .pattern(" EE")
                .pattern(" EE")
                .define('E', ModBlocks.MARIKA_OAK_PLANKS.get())
                .unlockedBy(getHasName(ModBlocks.MARIKA_OAK_PLANKS.get()), has(ModBlocks.MARIKA_OAK_PLANKS.get()))
                .save(consumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.MARIKA_OAK_FENCE.get(), 3)
                .pattern("   ")
                .pattern("ESE")
                .pattern("ESE")
                .define('E', ModBlocks.MARIKA_OAK_PLANKS.get())
                .define('S', Items.STICK)
                .unlockedBy(getHasName(ModBlocks.MARIKA_OAK_PLANKS.get()), has(ModBlocks.MARIKA_OAK_PLANKS.get()))
                .save(consumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.EMBER_OAK_FENCE_GATE.get(), 1)
                .pattern("   ")
                .pattern("SES")
                .pattern("SES")
                .define('E', ModBlocks.EMBER_OAK_PLANKS.get())
                .define('S', Items.STICK)
                .unlockedBy(getHasName(ModBlocks.EMBER_OAK_PLANKS.get()), has(ModBlocks.EMBER_OAK_PLANKS.get()))
                .save(consumer);


        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.FIRESTONE_WALL.get(), 6)
                .pattern("   ")
                .pattern("FFF")
                .pattern("FFF")
                .define('F', ModBlocks.FIRESTONE_BLOCK.get())
                .unlockedBy(getHasName(ModBlocks.FIRESTONE_BLOCK.get()), has(ModBlocks.FIRESTONE_BLOCK.get()))
                .save(consumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.INFESTED_COBBLE_WALL.get(), 6)
                .pattern("   ")
                .pattern("III")
                .pattern("III")
                .define('I', ModBlocks.INFESTED_COBBLE.get())
                .unlockedBy(getHasName(ModBlocks.INFESTED_COBBLE.get()), has(ModBlocks.INFESTED_COBBLE.get()))
                .save(consumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.INFESTED_STONE_BRICK_WALL.get(), 6)
                .pattern("   ")
                .pattern("III")
                .pattern("III")
                .define('I', ModBlocks.INFESTED_STONE_BRICKS.get())
                .unlockedBy(getHasName(ModBlocks.INFESTED_STONE_BRICKS.get()), has(ModBlocks.INFESTED_STONE_BRICKS.get()))
                .save(consumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.BLACK_TIBERCRETE_STAIRS.get(), 4)
                .pattern("T  ")
                .pattern("TT ")
                .pattern("TTT")
                .define('T', ModBlocks.BLACK_TIBERCRETE.get())
                .unlockedBy(getHasName(ModBlocks.BLACK_TIBERCRETE.get()), has(ModBlocks.BLACK_TIBERCRETE.get()))
                .save(consumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.BLUE_TIBERCRETE_STAIRS.get(), 4)
                .pattern("T  ")
                .pattern("TT ")
                .pattern("TTT")
                .define('T', ModBlocks.BLUE_TIBERCRETE.get())
                .unlockedBy(getHasName(ModBlocks.BLUE_TIBERCRETE.get()), has(ModBlocks.BLUE_TIBERCRETE.get()))
                .save(consumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.BROWN_TIBERCRETE_STAIRS.get(), 4)
                .pattern("T  ")
                .pattern("TT ")
                .pattern("TTT")
                .define('T', ModBlocks.BROWN_TIBERCRETE.get())
                .unlockedBy(getHasName(ModBlocks.BROWN_TIBERCRETE.get()), has(ModBlocks.BROWN_TIBERCRETE.get()))
                .save(consumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.CYAN_TIBERCRETE_STAIRS.get(), 4)
                .pattern("T  ")
                .pattern("TT ")
                .pattern("TTT")
                .define('T', ModBlocks.CYAN_TIBERCRETE.get())
                .unlockedBy(getHasName(ModBlocks.CYAN_TIBERCRETE.get()), has(ModBlocks.CYAN_TIBERCRETE.get()))
                .save(consumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.GRAY_TIBERCRETE_STAIRS.get(), 4)
                .pattern("T  ")
                .pattern("TT ")
                .pattern("TTT")
                .define('T', ModBlocks.GRAY_TIBERCRETE.get())
                .unlockedBy(getHasName(ModBlocks.GRAY_TIBERCRETE.get()), has(ModBlocks.GRAY_TIBERCRETE.get()))
                .save(consumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.GREEN_TIBERCRETE_STAIRS.get(), 4)
                .pattern("T  ")
                .pattern("TT ")
                .pattern("TTT")
                .define('T', ModBlocks.GREEN_TIBERCRETE.get())
                .unlockedBy(getHasName(ModBlocks.GREEN_TIBERCRETE.get()), has(ModBlocks.GREEN_TIBERCRETE.get()))
                .save(consumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.LIGHT_BLUE_TIBERCRETE_STAIRS.get(), 4)
                .pattern("T  ")
                .pattern("TT ")
                .pattern("TTT")
                .define('T', ModBlocks.LIGHT_BLUE_TIBERCRETE.get())
                .unlockedBy(getHasName(ModBlocks.LIGHT_BLUE_TIBERCRETE.get()), has(ModBlocks.LIGHT_BLUE_TIBERCRETE.get()))
                .save(consumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.LIGHT_GRAY_TIBERCRETE_STAIRS.get(), 4)
                .pattern("T  ")
                .pattern("TT ")
                .pattern("TTT")
                .define('T', ModBlocks.LIGHT_GRAY_TIBERCRETE.get())
                .unlockedBy(getHasName(ModBlocks.LIGHT_GRAY_TIBERCRETE.get()), has(ModBlocks.LIGHT_GRAY_TIBERCRETE.get()))
                .save(consumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.LIME_TIBERCRETE_STAIRS.get(), 4)
                .pattern("T  ")
                .pattern("TT ")
                .pattern("TTT")
                .define('T', ModBlocks.LIME_TIBERCRETE.get())
                .unlockedBy(getHasName(ModBlocks.LIME_TIBERCRETE.get()), has(ModBlocks.LIME_TIBERCRETE.get()))
                .save(consumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.MAGENTA_TIBERCRETE_STAIRS.get(), 4)
                .pattern("T  ")
                .pattern("TT ")
                .pattern("TTT")
                .define('T', ModBlocks.MAGENTA_TIBERCRETE.get())
                .unlockedBy(getHasName(ModBlocks.MAGENTA_TIBERCRETE.get()), has(ModBlocks.MAGENTA_TIBERCRETE.get()))
                .save(consumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.ORANGE_TIBERCRETE_STAIRS.get(), 4)
                .pattern("T  ")
                .pattern("TT ")
                .pattern("TTT")
                .define('T', ModBlocks.ORANGE_TIBERCRETE.get())
                .unlockedBy(getHasName(ModBlocks.ORANGE_TIBERCRETE.get()), has(ModBlocks.ORANGE_TIBERCRETE.get()))
                .save(consumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.PINK_TIBERCRETE_STAIRS.get(), 4)
                .pattern("T  ")
                .pattern("TT ")
                .pattern("TTT")
                .define('T', ModBlocks.PINK_TIBERCRETE.get())
                .unlockedBy(getHasName(ModBlocks.PINK_TIBERCRETE.get()), has(ModBlocks.PINK_TIBERCRETE.get()))
                .save(consumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.PURPLE_TIBERCRETE_STAIRS.get(), 4)
                .pattern("T  ")
                .pattern("TT ")
                .pattern("TTT")
                .define('T', ModBlocks.PURPLE_TIBERCRETE.get())
                .unlockedBy(getHasName(ModBlocks.PURPLE_TIBERCRETE.get()), has(ModBlocks.PURPLE_TIBERCRETE.get()))
                .save(consumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.RED_TIBERCRETE_STAIRS.get(), 4)
                .pattern("T  ")
                .pattern("TT ")
                .pattern("TTT")
                .define('T', ModBlocks.RED_TIBERCRETE.get())
                .unlockedBy(getHasName(ModBlocks.RED_TIBERCRETE.get()), has(ModBlocks.RED_TIBERCRETE.get()))
                .save(consumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.WHITE_TIBERCRETE_STAIRS.get(), 4)
                .pattern("T  ")
                .pattern("TT ")
                .pattern("TTT")
                .define('T', ModBlocks.WHITE_TIBERCRETE.get())
                .unlockedBy(getHasName(ModBlocks.WHITE_TIBERCRETE.get()), has(ModBlocks.WHITE_TIBERCRETE.get()))
                .save(consumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.YELLOW_TIBERCRETE_STAIRS.get(), 4)
                .pattern("T  ")
                .pattern("TT ")
                .pattern("TTT")
                .define('T', ModBlocks.YELLOW_TIBERCRETE.get())
                .unlockedBy(getHasName(ModBlocks.YELLOW_TIBERCRETE.get()), has(ModBlocks.YELLOW_TIBERCRETE.get()))
                .save(consumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.BLACK_TIBERCRETE_SLAB.get(), 6)
                .pattern("   ")
                .pattern("   ")
                .pattern("TTT")
                .define('T', ModBlocks.BLACK_TIBERCRETE.get())
                .unlockedBy(getHasName(ModBlocks.BLACK_TIBERCRETE.get()), has(ModBlocks.BLACK_TIBERCRETE.get()))
                .save(consumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.BLUE_TIBERCRETE_SLAB.get(), 6)
                .pattern("   ")
                .pattern("   ")
                .pattern("TTT")
                .define('T', ModBlocks.BLUE_TIBERCRETE.get())
                .unlockedBy(getHasName(ModBlocks.BLUE_TIBERCRETE.get()), has(ModBlocks.BLUE_TIBERCRETE.get()))
                .save(consumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.BROWN_TIBERCRETE_SLAB.get(), 6)
                .pattern("   ")
                .pattern("   ")
                .pattern("TTT")
                .define('T', ModBlocks.BROWN_TIBERCRETE.get())
                .unlockedBy(getHasName(ModBlocks.BROWN_TIBERCRETE.get()), has(ModBlocks.BROWN_TIBERCRETE.get()))
                .save(consumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.CYAN_TIBERCRETE_SLAB.get(), 6)
                .pattern("   ")
                .pattern("   ")
                .pattern("TTT")
                .define('T', ModBlocks.CYAN_TIBERCRETE.get())
                .unlockedBy(getHasName(ModBlocks.CYAN_TIBERCRETE.get()), has(ModBlocks.CYAN_TIBERCRETE.get()))
                .save(consumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.GRAY_TIBERCRETE_SLAB.get(), 6)
                .pattern("   ")
                .pattern("   ")
                .pattern("TTT")
                .define('T', ModBlocks.GRAY_TIBERCRETE.get())
                .unlockedBy(getHasName(ModBlocks.GRAY_TIBERCRETE.get()), has(ModBlocks.GRAY_TIBERCRETE.get()))
                .save(consumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.GREEN_TIBERCRETE_SLAB.get(), 6)
                .pattern("   ")
                .pattern("   ")
                .pattern("TTT")
                .define('T', ModBlocks.GREEN_TIBERCRETE.get())
                .unlockedBy(getHasName(ModBlocks.GREEN_TIBERCRETE.get()), has(ModBlocks.GREEN_TIBERCRETE.get()))
                .save(consumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.LIGHT_BLUE_TIBERCRETE_SLAB.get(), 6)
                .pattern("   ")
                .pattern("   ")
                .pattern("TTT")
                .define('T', ModBlocks.LIGHT_BLUE_TIBERCRETE.get())
                .unlockedBy(getHasName(ModBlocks.LIGHT_BLUE_TIBERCRETE.get()), has(ModBlocks.LIGHT_BLUE_TIBERCRETE.get()))
                .save(consumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.LIGHT_GRAY_TIBERCRETE_SLAB.get(), 6)
                .pattern("   ")
                .pattern("   ")
                .pattern("TTT")
                .define('T', ModBlocks.LIGHT_GRAY_TIBERCRETE.get())
                .unlockedBy(getHasName(ModBlocks.LIGHT_GRAY_TIBERCRETE.get()), has(ModBlocks.LIGHT_GRAY_TIBERCRETE.get()))
                .save(consumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.LIME_TIBERCRETE_SLAB.get(), 6)
                .pattern("   ")
                .pattern("   ")
                .pattern("TTT")
                .define('T', ModBlocks.LIME_TIBERCRETE.get())
                .unlockedBy(getHasName(ModBlocks.LIME_TIBERCRETE.get()), has(ModBlocks.LIME_TIBERCRETE.get()))
                .save(consumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.MAGENTA_TIBERCRETE_SLAB.get(), 6)
                .pattern("   ")
                .pattern("   ")
                .pattern("TTT")
                .define('T', ModBlocks.MAGENTA_TIBERCRETE.get())
                .unlockedBy(getHasName(ModBlocks.MAGENTA_TIBERCRETE.get()), has(ModBlocks.MAGENTA_TIBERCRETE.get()))
                .save(consumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.ORANGE_TIBERCRETE_SLAB.get(), 6)
                .pattern("   ")
                .pattern("   ")
                .pattern("TTT")
                .define('T', ModBlocks.ORANGE_TIBERCRETE.get())
                .unlockedBy(getHasName(ModBlocks.ORANGE_TIBERCRETE.get()), has(ModBlocks.ORANGE_TIBERCRETE.get()))
                .save(consumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.PINK_TIBERCRETE_SLAB.get(), 6)
                .pattern("   ")
                .pattern("   ")
                .pattern("TTT")
                .define('T', ModBlocks.PINK_TIBERCRETE.get())
                .unlockedBy(getHasName(ModBlocks.PINK_TIBERCRETE.get()), has(ModBlocks.PINK_TIBERCRETE.get()))
                .save(consumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.PURPLE_TIBERCRETE_SLAB.get(), 6)
                .pattern("   ")
                .pattern("   ")
                .pattern("TTT")
                .define('T', ModBlocks.PURPLE_TIBERCRETE.get())
                .unlockedBy(getHasName(ModBlocks.PURPLE_TIBERCRETE.get()), has(ModBlocks.PURPLE_TIBERCRETE.get()))
                .save(consumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.RED_TIBERCRETE_SLAB.get(), 6)
                .pattern("   ")
                .pattern("   ")
                .pattern("TTT")
                .define('T', ModBlocks.RED_TIBERCRETE.get())
                .unlockedBy(getHasName(ModBlocks.RED_TIBERCRETE.get()), has(ModBlocks.RED_TIBERCRETE.get()))
                .save(consumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.WHITE_TIBERCRETE_SLAB.get(), 6)
                .pattern("   ")
                .pattern("   ")
                .pattern("TTT")
                .define('T', ModBlocks.WHITE_TIBERCRETE.get())
                .unlockedBy(getHasName(ModBlocks.WHITE_TIBERCRETE.get()), has(ModBlocks.WHITE_TIBERCRETE.get()))
                .save(consumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.YELLOW_TIBERCRETE_SLAB.get(), 6)
                .pattern("   ")
                .pattern("   ")
                .pattern("TTT")
                .define('T', ModBlocks.YELLOW_TIBERCRETE.get())
                .unlockedBy(getHasName(ModBlocks.YELLOW_TIBERCRETE.get()), has(ModBlocks.YELLOW_TIBERCRETE.get()))
                .save(consumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.BLACK_TIBERCRETE_BRICKS.get(), 4)
                .pattern("   ")
                .pattern(" TT")
                .pattern(" TT")
                .define('T', ModBlocks.BLACK_TIBERCRETE.get())
                .unlockedBy(getHasName(ModBlocks.BLACK_TIBERCRETE.get()), has(ModBlocks.BLACK_TIBERCRETE.get()))
                .save(consumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.BLUE_TIBERCRETE_BRICKS.get(), 4)
                .pattern("   ")
                .pattern(" TT")
                .pattern(" TT")
                .define('T', ModBlocks.BLUE_TIBERCRETE.get())
                .unlockedBy(getHasName(ModBlocks.BLUE_TIBERCRETE.get()), has(ModBlocks.BLUE_TIBERCRETE.get()))
                .save(consumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.BROWN_TIBERCRETE_BRICKS.get(), 4)
                .pattern("   ")
                .pattern(" TT")
                .pattern(" TT")
                .define('T', ModBlocks.BROWN_TIBERCRETE.get())
                .unlockedBy(getHasName(ModBlocks.BROWN_TIBERCRETE.get()), has(ModBlocks.BROWN_TIBERCRETE.get()))
                .save(consumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.CYAN_TIBERCRETE_BRICKS.get(), 4)
                .pattern("   ")
                .pattern(" TT")
                .pattern(" TT")
                .define('T', ModBlocks.CYAN_TIBERCRETE.get())
                .unlockedBy(getHasName(ModBlocks.CYAN_TIBERCRETE.get()), has(ModBlocks.CYAN_TIBERCRETE.get()))
                .save(consumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.GRAY_TIBERCRETE_BRICKS.get(), 4)
                .pattern("   ")
                .pattern(" TT")
                .pattern(" TT")
                .define('T', ModBlocks.GRAY_TIBERCRETE.get())
                .unlockedBy(getHasName(ModBlocks.GRAY_TIBERCRETE.get()), has(ModBlocks.GRAY_TIBERCRETE.get()))
                .save(consumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.GREEN_TIBERCRETE_BRICKS.get(), 4)
                .pattern("   ")
                .pattern(" TT")
                .pattern(" TT")
                .define('T', ModBlocks.GREEN_TIBERCRETE.get())
                .unlockedBy(getHasName(ModBlocks.GREEN_TIBERCRETE.get()), has(ModBlocks.GREEN_TIBERCRETE.get()))
                .save(consumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.LIGHT_BLUE_TIBERCRETE_BRICKS.get(), 4)
                .pattern("   ")
                .pattern(" TT")
                .pattern(" TT")
                .define('T', ModBlocks.LIGHT_BLUE_TIBERCRETE.get())
                .unlockedBy(getHasName(ModBlocks.LIGHT_BLUE_TIBERCRETE.get()), has(ModBlocks.LIGHT_BLUE_TIBERCRETE.get()))
                .save(consumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.LIGHT_GRAY_TIBERCRETE_BRICKS.get(), 4)
                .pattern("   ")
                .pattern(" TT")
                .pattern(" TT")
                .define('T', ModBlocks.LIGHT_GRAY_TIBERCRETE.get())
                .unlockedBy(getHasName(ModBlocks.LIGHT_GRAY_TIBERCRETE.get()), has(ModBlocks.LIGHT_GRAY_TIBERCRETE.get()))
                .save(consumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.LIME_TIBERCRETE_BRICKS.get(), 4)
                .pattern("   ")
                .pattern(" TT")
                .pattern(" TT")
                .define('T', ModBlocks.LIME_TIBERCRETE.get())
                .unlockedBy(getHasName(ModBlocks.LIME_TIBERCRETE.get()), has(ModBlocks.LIME_TIBERCRETE.get()))
                .save(consumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.MAGENTA_TIBERCRETE_BRICKS.get(), 4)
                .pattern("   ")
                .pattern(" TT")
                .pattern(" TT")
                .define('T', ModBlocks.MAGENTA_TIBERCRETE.get())
                .unlockedBy(getHasName(ModBlocks.MAGENTA_TIBERCRETE.get()), has(ModBlocks.MAGENTA_TIBERCRETE.get()))
                .save(consumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.ORANGE_TIBERCRETE_BRICKS.get(), 4)
                .pattern("   ")
                .pattern(" TT")
                .pattern(" TT")
                .define('T', ModBlocks.ORANGE_TIBERCRETE.get())
                .unlockedBy(getHasName(ModBlocks.ORANGE_TIBERCRETE.get()), has(ModBlocks.ORANGE_TIBERCRETE.get()))
                .save(consumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.PINK_TIBERCRETE_BRICKS.get(), 4)
                .pattern("   ")
                .pattern(" TT")
                .pattern(" TT")
                .define('T', ModBlocks.PINK_TIBERCRETE.get())
                .unlockedBy(getHasName(ModBlocks.PINK_TIBERCRETE.get()), has(ModBlocks.PINK_TIBERCRETE.get()))
                .save(consumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.PURPLE_TIBERCRETE_BRICKS.get(), 4)
                .pattern("   ")
                .pattern(" TT")
                .pattern(" TT")
                .define('T', ModBlocks.PURPLE_TIBERCRETE.get())
                .unlockedBy(getHasName(ModBlocks.PURPLE_TIBERCRETE.get()), has(ModBlocks.PURPLE_TIBERCRETE.get()))
                .save(consumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.RED_TIBERCRETE_BRICKS.get(), 4)
                .pattern("   ")
                .pattern(" TT")
                .pattern(" TT")
                .define('T', ModBlocks.RED_TIBERCRETE.get())
                .unlockedBy(getHasName(ModBlocks.RED_TIBERCRETE.get()), has(ModBlocks.RED_TIBERCRETE.get()))
                .save(consumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.WHITE_TIBERCRETE_BRICKS.get(), 4)
                .pattern("   ")
                .pattern(" TT")
                .pattern(" TT")
                .define('T', ModBlocks.WHITE_TIBERCRETE.get())
                .unlockedBy(getHasName(ModBlocks.WHITE_TIBERCRETE.get()), has(ModBlocks.WHITE_TIBERCRETE.get()))
                .save(consumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.YELLOW_TIBERCRETE_BRICKS.get(), 4)
                .pattern("   ")
                .pattern(" TT")
                .pattern(" TT")
                .define('T', ModBlocks.YELLOW_TIBERCRETE.get())
                .unlockedBy(getHasName(ModBlocks.YELLOW_TIBERCRETE.get()), has(ModBlocks.YELLOW_TIBERCRETE.get()))
                .save(consumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.BLACK_TIBERCRETE_WALL.get(), 6)
                .pattern("   ")
                .pattern("TTT")
                .pattern("TTT")
                .define('T', ModBlocks.BLACK_TIBERCRETE.get())
                .unlockedBy(getHasName(ModBlocks.BLACK_TIBERCRETE.get()), has(ModBlocks.BLACK_TIBERCRETE.get()))
                .save(consumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.BLUE_TIBERCRETE_WALL.get(), 6)
                .pattern("   ")
                .pattern("TTT")
                .pattern("TTT")
                .define('T', ModBlocks.BLUE_TIBERCRETE.get())
                .unlockedBy(getHasName(ModBlocks.BLUE_TIBERCRETE.get()), has(ModBlocks.BLUE_TIBERCRETE.get()))
                .save(consumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.BROWN_TIBERCRETE_WALL.get(), 6)
                .pattern("   ")
                .pattern("TTT")
                .pattern("TTT")
                .define('T', ModBlocks.BROWN_TIBERCRETE.get())
                .unlockedBy(getHasName(ModBlocks.BROWN_TIBERCRETE.get()), has(ModBlocks.BROWN_TIBERCRETE.get()))
                .save(consumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.CYAN_TIBERCRETE_WALL.get(), 6)
                .pattern("   ")
                .pattern("TTT")
                .pattern("TTT")
                .define('T', ModBlocks.CYAN_TIBERCRETE.get())
                .unlockedBy(getHasName(ModBlocks.CYAN_TIBERCRETE.get()), has(ModBlocks.CYAN_TIBERCRETE.get()))
                .save(consumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.GRAY_TIBERCRETE_WALL.get(), 6)
                .pattern("   ")
                .pattern("TTT")
                .pattern("TTT")
                .define('T', ModBlocks.GRAY_TIBERCRETE.get())
                .unlockedBy(getHasName(ModBlocks.GRAY_TIBERCRETE.get()), has(ModBlocks.GRAY_TIBERCRETE.get()))
                .save(consumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.GREEN_TIBERCRETE_WALL.get(), 6)
                .pattern("   ")
                .pattern("TTT")
                .pattern("TTT")
                .define('T', ModBlocks.GREEN_TIBERCRETE.get())
                .unlockedBy(getHasName(ModBlocks.GREEN_TIBERCRETE.get()), has(ModBlocks.GREEN_TIBERCRETE.get()))
                .save(consumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.LIGHT_BLUE_TIBERCRETE_WALL.get(), 6)
                .pattern("   ")
                .pattern("TTT")
                .pattern("TTT")
                .define('T', ModBlocks.LIGHT_BLUE_TIBERCRETE.get())
                .unlockedBy(getHasName(ModBlocks.LIGHT_BLUE_TIBERCRETE.get()), has(ModBlocks.LIGHT_BLUE_TIBERCRETE.get()))
                .save(consumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.LIGHT_GRAY_TIBERCRETE_WALL.get(), 6)
                .pattern("   ")
                .pattern("TTT")
                .pattern("TTT")
                .define('T', ModBlocks.LIGHT_GRAY_TIBERCRETE.get())
                .unlockedBy(getHasName(ModBlocks.LIGHT_GRAY_TIBERCRETE.get()), has(ModBlocks.LIGHT_GRAY_TIBERCRETE.get()))
                .save(consumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.LIME_TIBERCRETE_WALL.get(), 6)
                .pattern("   ")
                .pattern("TTT")
                .pattern("TTT")
                .define('T', ModBlocks.LIME_TIBERCRETE.get())
                .unlockedBy(getHasName(ModBlocks.LIME_TIBERCRETE.get()), has(ModBlocks.LIME_TIBERCRETE.get()))
                .save(consumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.MAGENTA_TIBERCRETE_WALL.get(), 6)
                .pattern("   ")
                .pattern("TTT")
                .pattern("TTT")
                .define('T', ModBlocks.MAGENTA_TIBERCRETE.get())
                .unlockedBy(getHasName(ModBlocks.MAGENTA_TIBERCRETE.get()), has(ModBlocks.MAGENTA_TIBERCRETE.get()))
                .save(consumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.ORANGE_TIBERCRETE_WALL.get(), 6)
                .pattern("   ")
                .pattern("TTT")
                .pattern("TTT")
                .define('T', ModBlocks.ORANGE_TIBERCRETE.get())
                .unlockedBy(getHasName(ModBlocks.ORANGE_TIBERCRETE.get()), has(ModBlocks.ORANGE_TIBERCRETE.get()))
                .save(consumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.PINK_TIBERCRETE_WALL.get(), 6)
                .pattern("   ")
                .pattern("TTT")
                .pattern("TTT")
                .define('T', ModBlocks.PINK_TIBERCRETE.get())
                .unlockedBy(getHasName(ModBlocks.PINK_TIBERCRETE.get()), has(ModBlocks.PINK_TIBERCRETE.get()))
                .save(consumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.PURPLE_TIBERCRETE_WALL.get(), 6)
                .pattern("   ")
                .pattern("TTT")
                .pattern("TTT")
                .define('T', ModBlocks.PURPLE_TIBERCRETE.get())
                .unlockedBy(getHasName(ModBlocks.PURPLE_TIBERCRETE.get()), has(ModBlocks.PURPLE_TIBERCRETE.get()))
                .save(consumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.RED_TIBERCRETE_WALL.get(), 6)
                .pattern("   ")
                .pattern("TTT")
                .pattern("TTT")
                .define('T', ModBlocks.RED_TIBERCRETE.get())
                .unlockedBy(getHasName(ModBlocks.RED_TIBERCRETE.get()), has(ModBlocks.RED_TIBERCRETE.get()))
                .save(consumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.WHITE_TIBERCRETE_WALL.get(), 6)
                .pattern("   ")
                .pattern("TTT")
                .pattern("TTT")
                .define('T', ModBlocks.WHITE_TIBERCRETE.get())
                .unlockedBy(getHasName(ModBlocks.WHITE_TIBERCRETE.get()), has(ModBlocks.WHITE_TIBERCRETE.get()))
                .save(consumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.YELLOW_TIBERCRETE_WALL.get(), 6)
                .pattern("   ")
                .pattern("TTT")
                .pattern("TTT")
                .define('T', ModBlocks.YELLOW_TIBERCRETE.get())
                .unlockedBy(getHasName(ModBlocks.YELLOW_TIBERCRETE.get()), has(ModBlocks.YELLOW_TIBERCRETE.get()))
                .save(consumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.BLACK_TIBERCRETE_BRICK_SLAB.get(), 6)
                .pattern("   ")
                .pattern("   ")
                .pattern("TTT")
                .define('T', ModBlocks.BLACK_TIBERCRETE_BRICKS.get())
                .unlockedBy(getHasName(ModBlocks.BLACK_TIBERCRETE.get()), has(ModBlocks.BLACK_TIBERCRETE.get()))
                .save(consumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.BLUE_TIBERCRETE_BRICK_SLAB.get(), 6)
                .pattern("   ")
                .pattern("   ")
                .pattern("TTT")
                .define('T', ModBlocks.BLUE_TIBERCRETE_BRICKS.get())
                .unlockedBy(getHasName(ModBlocks.BLUE_TIBERCRETE.get()), has(ModBlocks.BLUE_TIBERCRETE.get()))
                .save(consumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.BROWN_TIBERCRETE_BRICK_SLAB.get(), 6)
                .pattern("   ")
                .pattern("   ")
                .pattern("TTT")
                .define('T', ModBlocks.BROWN_TIBERCRETE_BRICKS.get())
                .unlockedBy(getHasName(ModBlocks.BROWN_TIBERCRETE.get()), has(ModBlocks.BROWN_TIBERCRETE.get()))
                .save(consumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.CYAN_TIBERCRETE_BRICK_SLAB.get(), 6)
                .pattern("   ")
                .pattern("   ")
                .pattern("TTT")
                .define('T', ModBlocks.CYAN_TIBERCRETE_BRICKS.get())
                .unlockedBy(getHasName(ModBlocks.CYAN_TIBERCRETE.get()), has(ModBlocks.CYAN_TIBERCRETE.get()))
                .save(consumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.GRAY_TIBERCRETE_BRICK_SLAB.get(), 6)
                .pattern("   ")
                .pattern("   ")
                .pattern("TTT")
                .define('T', ModBlocks.GRAY_TIBERCRETE_BRICKS.get())
                .unlockedBy(getHasName(ModBlocks.GRAY_TIBERCRETE.get()), has(ModBlocks.GRAY_TIBERCRETE.get()))
                .save(consumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.GREEN_TIBERCRETE_BRICK_SLAB.get(), 6)
                .pattern("   ")
                .pattern("   ")
                .pattern("TTT")
                .define('T', ModBlocks.GREEN_TIBERCRETE_BRICKS.get())
                .unlockedBy(getHasName(ModBlocks.GREEN_TIBERCRETE.get()), has(ModBlocks.GREEN_TIBERCRETE.get()))
                .save(consumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.LIGHT_BLUE_TIBERCRETE_BRICK_SLAB.get(), 6)
                .pattern("   ")
                .pattern("   ")
                .pattern("TTT")
                .define('T', ModBlocks.LIGHT_BLUE_TIBERCRETE_BRICKS.get())
                .unlockedBy(getHasName(ModBlocks.LIGHT_BLUE_TIBERCRETE.get()), has(ModBlocks.LIGHT_BLUE_TIBERCRETE.get()))
                .save(consumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.LIGHT_GRAY_TIBERCRETE_BRICK_SLAB.get(), 6)
                .pattern("   ")
                .pattern("   ")
                .pattern("TTT")
                .define('T', ModBlocks.LIGHT_GRAY_TIBERCRETE_BRICKS.get())
                .unlockedBy(getHasName(ModBlocks.LIGHT_GRAY_TIBERCRETE.get()), has(ModBlocks.LIGHT_GRAY_TIBERCRETE.get()))
                .save(consumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.LIME_TIBERCRETE_BRICK_SLAB.get(), 6)
                .pattern("   ")
                .pattern("   ")
                .pattern("TTT")
                .define('T', ModBlocks.LIME_TIBERCRETE_BRICKS.get())
                .unlockedBy(getHasName(ModBlocks.LIME_TIBERCRETE.get()), has(ModBlocks.LIME_TIBERCRETE.get()))
                .save(consumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.MAGENTA_TIBERCRETE_BRICK_SLAB.get(), 6)
                .pattern("   ")
                .pattern("   ")
                .pattern("TTT")
                .define('T', ModBlocks.MAGENTA_TIBERCRETE_BRICKS.get())
                .unlockedBy(getHasName(ModBlocks.MAGENTA_TIBERCRETE.get()), has(ModBlocks.MAGENTA_TIBERCRETE.get()))
                .save(consumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.ORANGE_TIBERCRETE_BRICK_SLAB.get(), 6)
                .pattern("   ")
                .pattern("   ")
                .pattern("TTT")
                .define('T', ModBlocks.ORANGE_TIBERCRETE_BRICKS.get())
                .unlockedBy(getHasName(ModBlocks.ORANGE_TIBERCRETE.get()), has(ModBlocks.ORANGE_TIBERCRETE.get()))
                .save(consumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.PINK_TIBERCRETE_BRICK_SLAB.get(), 6)
                .pattern("   ")
                .pattern("   ")
                .pattern("TTT")
                .define('T', ModBlocks.PINK_TIBERCRETE_BRICKS.get())
                .unlockedBy(getHasName(ModBlocks.PINK_TIBERCRETE.get()), has(ModBlocks.PINK_TIBERCRETE.get()))
                .save(consumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.PURPLE_TIBERCRETE_BRICK_SLAB.get(), 6)
                .pattern("   ")
                .pattern("   ")
                .pattern("TTT")
                .define('T', ModBlocks.PURPLE_TIBERCRETE_BRICKS.get())
                .unlockedBy(getHasName(ModBlocks.PURPLE_TIBERCRETE.get()), has(ModBlocks.PURPLE_TIBERCRETE.get()))
                .save(consumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.RED_TIBERCRETE_BRICK_SLAB.get(), 6)
                .pattern("   ")
                .pattern("   ")
                .pattern("TTT")
                .define('T', ModBlocks.RED_TIBERCRETE_BRICKS.get())
                .unlockedBy(getHasName(ModBlocks.RED_TIBERCRETE.get()), has(ModBlocks.RED_TIBERCRETE.get()))
                .save(consumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.WHITE_TIBERCRETE_BRICK_SLAB.get(), 6)
                .pattern("   ")
                .pattern("   ")
                .pattern("TTT")
                .define('T', ModBlocks.WHITE_TIBERCRETE_BRICKS.get())
                .unlockedBy(getHasName(ModBlocks.WHITE_TIBERCRETE.get()), has(ModBlocks.WHITE_TIBERCRETE.get()))
                .save(consumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.YELLOW_TIBERCRETE_BRICK_SLAB.get(), 6)
                .pattern("   ")
                .pattern("   ")
                .pattern("TTT")
                .define('T', ModBlocks.YELLOW_TIBERCRETE_BRICKS.get())
                .unlockedBy(getHasName(ModBlocks.YELLOW_TIBERCRETE.get()), has(ModBlocks.YELLOW_TIBERCRETE.get()))
                .save(consumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.BLACK_TIBERCRETE_BRICK_STAIRS.get(), 4)
                .pattern("T  ")
                .pattern("TT ")
                .pattern("TTT")
                .define('T', ModBlocks.BLACK_TIBERCRETE_BRICKS.get())
                .unlockedBy(getHasName(ModBlocks.BLACK_TIBERCRETE.get()), has(ModBlocks.BLACK_TIBERCRETE.get()))
                .save(consumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.BLUE_TIBERCRETE_BRICK_STAIRS.get(), 4)
                .pattern("T  ")
                .pattern("TT ")
                .pattern("TTT")
                .define('T', ModBlocks.BLUE_TIBERCRETE_BRICKS.get())
                .unlockedBy(getHasName(ModBlocks.BLUE_TIBERCRETE.get()), has(ModBlocks.BLUE_TIBERCRETE.get()))
                .save(consumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.BROWN_TIBERCRETE_BRICK_STAIRS.get(), 4)
                .pattern("T  ")
                .pattern("TT ")
                .pattern("TTT")
                .define('T', ModBlocks.BROWN_TIBERCRETE_BRICKS.get())
                .unlockedBy(getHasName(ModBlocks.BROWN_TIBERCRETE.get()), has(ModBlocks.BROWN_TIBERCRETE.get()))
                .save(consumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.CYAN_TIBERCRETE_BRICK_STAIRS.get(), 4)
                .pattern("T  ")
                .pattern("TT ")
                .pattern("TTT")
                .define('T', ModBlocks.CYAN_TIBERCRETE_BRICKS.get())
                .unlockedBy(getHasName(ModBlocks.CYAN_TIBERCRETE.get()), has(ModBlocks.CYAN_TIBERCRETE.get()))
                .save(consumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.GRAY_TIBERCRETE_BRICK_STAIRS.get(), 4)
                .pattern("T  ")
                .pattern("TT ")
                .pattern("TTT")
                .define('T', ModBlocks.GRAY_TIBERCRETE_BRICKS.get())
                .unlockedBy(getHasName(ModBlocks.GRAY_TIBERCRETE.get()), has(ModBlocks.GRAY_TIBERCRETE.get()))
                .save(consumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.GREEN_TIBERCRETE_BRICK_STAIRS.get(), 4)
                .pattern("T  ")
                .pattern("TT ")
                .pattern("TTT")
                .define('T', ModBlocks.GREEN_TIBERCRETE_BRICKS.get())
                .unlockedBy(getHasName(ModBlocks.GREEN_TIBERCRETE.get()), has(ModBlocks.GREEN_TIBERCRETE.get()))
                .save(consumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.LIGHT_BLUE_TIBERCRETE_BRICK_STAIRS.get(), 4)
                .pattern("T  ")
                .pattern("TT ")
                .pattern("TTT")
                .define('T', ModBlocks.LIGHT_BLUE_TIBERCRETE_BRICKS.get())
                .unlockedBy(getHasName(ModBlocks.LIGHT_BLUE_TIBERCRETE.get()), has(ModBlocks.LIGHT_BLUE_TIBERCRETE.get()))
                .save(consumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.LIGHT_GRAY_TIBERCRETE_BRICK_STAIRS.get(), 4)
                .pattern("T  ")
                .pattern("TT ")
                .pattern("TTT")
                .define('T', ModBlocks.LIGHT_GRAY_TIBERCRETE_BRICKS.get())
                .unlockedBy(getHasName(ModBlocks.LIGHT_GRAY_TIBERCRETE.get()), has(ModBlocks.LIGHT_GRAY_TIBERCRETE.get()))
                .save(consumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.LIME_TIBERCRETE_BRICK_STAIRS.get(), 4)
                .pattern("T  ")
                .pattern("TT ")
                .pattern("TTT")
                .define('T', ModBlocks.LIME_TIBERCRETE_BRICKS.get())
                .unlockedBy(getHasName(ModBlocks.LIME_TIBERCRETE.get()), has(ModBlocks.LIME_TIBERCRETE.get()))
                .save(consumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.MAGENTA_TIBERCRETE_BRICK_STAIRS.get(), 4)
                .pattern("T  ")
                .pattern("TT ")
                .pattern("TTT")
                .define('T', ModBlocks.MAGENTA_TIBERCRETE_BRICKS.get())
                .unlockedBy(getHasName(ModBlocks.MAGENTA_TIBERCRETE.get()), has(ModBlocks.MAGENTA_TIBERCRETE.get()))
                .save(consumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.ORANGE_TIBERCRETE_BRICK_STAIRS.get(), 4)
                .pattern("T  ")
                .pattern("TT ")
                .pattern("TTT")
                .define('T', ModBlocks.ORANGE_TIBERCRETE_BRICKS.get())
                .unlockedBy(getHasName(ModBlocks.ORANGE_TIBERCRETE.get()), has(ModBlocks.ORANGE_TIBERCRETE.get()))
                .save(consumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.PINK_TIBERCRETE_BRICK_STAIRS.get(), 4)
                .pattern("T  ")
                .pattern("TT ")
                .pattern("TTT")
                .define('T', ModBlocks.PINK_TIBERCRETE_BRICKS.get())
                .unlockedBy(getHasName(ModBlocks.PINK_TIBERCRETE.get()), has(ModBlocks.PINK_TIBERCRETE.get()))
                .save(consumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.PURPLE_TIBERCRETE_BRICK_STAIRS.get(), 4)
                .pattern("T  ")
                .pattern("TT ")
                .pattern("TTT")
                .define('T', ModBlocks.PURPLE_TIBERCRETE_BRICKS.get())
                .unlockedBy(getHasName(ModBlocks.PURPLE_TIBERCRETE.get()), has(ModBlocks.PURPLE_TIBERCRETE.get()))
                .save(consumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.RED_TIBERCRETE_BRICK_STAIRS.get(), 4)
                .pattern("T  ")
                .pattern("TT ")
                .pattern("TTT")
                .define('T', ModBlocks.RED_TIBERCRETE_BRICKS.get())
                .unlockedBy(getHasName(ModBlocks.RED_TIBERCRETE.get()), has(ModBlocks.RED_TIBERCRETE.get()))
                .save(consumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.WHITE_TIBERCRETE_BRICK_STAIRS.get(), 4)
                .pattern("T  ")
                .pattern("TT ")
                .pattern("TTT")
                .define('T', ModBlocks.WHITE_TIBERCRETE_BRICKS.get())
                .unlockedBy(getHasName(ModBlocks.WHITE_TIBERCRETE.get()), has(ModBlocks.WHITE_TIBERCRETE.get()))
                .save(consumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.YELLOW_TIBERCRETE_BRICK_STAIRS.get(), 4)
                .pattern("   ")
                .pattern("TT ")
                .pattern("TTT")
                .define('T', ModBlocks.YELLOW_TIBERCRETE_BRICKS.get())
                .unlockedBy(getHasName(ModBlocks.YELLOW_TIBERCRETE.get()), has(ModBlocks.YELLOW_TIBERCRETE.get()))
                .save(consumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.BLACK_TIBERCRETE_BRICK_WALL.get(), 6)
                .pattern("   ")
                .pattern("TTT")
                .pattern("TTT")
                .define('T', ModBlocks.BLACK_TIBERCRETE_BRICKS.get())
                .unlockedBy(getHasName(ModBlocks.BLACK_TIBERCRETE.get()), has(ModBlocks.BLACK_TIBERCRETE.get()))
                .save(consumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.BLUE_TIBERCRETE_BRICK_WALL.get(), 6)
                .pattern("   ")
                .pattern("TTT")
                .pattern("TTT")
                .define('T', ModBlocks.BLUE_TIBERCRETE_BRICKS.get())
                .unlockedBy(getHasName(ModBlocks.BLUE_TIBERCRETE.get()), has(ModBlocks.BLUE_TIBERCRETE.get()))
                .save(consumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.BROWN_TIBERCRETE_BRICK_WALL.get(), 6)
                .pattern("   ")
                .pattern("TTT")
                .pattern("TTT")
                .define('T', ModBlocks.BROWN_TIBERCRETE_BRICKS.get())
                .unlockedBy(getHasName(ModBlocks.BROWN_TIBERCRETE.get()), has(ModBlocks.BROWN_TIBERCRETE.get()))
                .save(consumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.CYAN_TIBERCRETE_BRICK_WALL.get(), 6)
                .pattern("   ")
                .pattern("TTT")
                .pattern("TTT")
                .define('T', ModBlocks.CYAN_TIBERCRETE_BRICKS.get())
                .unlockedBy(getHasName(ModBlocks.CYAN_TIBERCRETE.get()), has(ModBlocks.CYAN_TIBERCRETE.get()))
                .save(consumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.GRAY_TIBERCRETE_BRICK_WALL.get(), 6)
                .pattern("   ")
                .pattern("TTT")
                .pattern("TTT")
                .define('T', ModBlocks.GRAY_TIBERCRETE_BRICKS.get())
                .unlockedBy(getHasName(ModBlocks.GRAY_TIBERCRETE.get()), has(ModBlocks.GRAY_TIBERCRETE.get()))
                .save(consumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.GREEN_TIBERCRETE_BRICK_WALL.get(), 6)
                .pattern("   ")
                .pattern("TTT")
                .pattern("TTT")
                .define('T', ModBlocks.GREEN_TIBERCRETE_BRICKS.get())
                .unlockedBy(getHasName(ModBlocks.GREEN_TIBERCRETE.get()), has(ModBlocks.GREEN_TIBERCRETE.get()))
                .save(consumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.LIGHT_BLUE_TIBERCRETE_BRICK_WALL.get(), 6)
                .pattern("   ")
                .pattern("TTT")
                .pattern("TTT")
                .define('T', ModBlocks.LIGHT_BLUE_TIBERCRETE_BRICKS.get())
                .unlockedBy(getHasName(ModBlocks.LIGHT_BLUE_TIBERCRETE.get()), has(ModBlocks.LIGHT_BLUE_TIBERCRETE.get()))
                .save(consumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.LIGHT_GRAY_TIBERCRETE_BRICK_WALL.get(), 6)
                .pattern("   ")
                .pattern("TTT")
                .pattern("TTT")
                .define('T', ModBlocks.LIGHT_GRAY_TIBERCRETE_BRICKS.get())
                .unlockedBy(getHasName(ModBlocks.LIGHT_GRAY_TIBERCRETE.get()), has(ModBlocks.LIGHT_GRAY_TIBERCRETE.get()))
                .save(consumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.LIME_TIBERCRETE_BRICK_WALL.get(), 6)
                .pattern("   ")
                .pattern("TTT")
                .pattern("TTT")
                .define('T', ModBlocks.LIME_TIBERCRETE_BRICKS.get())
                .unlockedBy(getHasName(ModBlocks.LIME_TIBERCRETE.get()), has(ModBlocks.LIME_TIBERCRETE.get()))
                .save(consumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.MAGENTA_TIBERCRETE_BRICK_WALL.get(), 6)
                .pattern("   ")
                .pattern("TTT")
                .pattern("TTT")
                .define('T', ModBlocks.MAGENTA_TIBERCRETE_BRICKS.get())
                .unlockedBy(getHasName(ModBlocks.MAGENTA_TIBERCRETE.get()), has(ModBlocks.MAGENTA_TIBERCRETE.get()))
                .save(consumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.ORANGE_TIBERCRETE_BRICK_WALL.get(), 6)
                .pattern("   ")
                .pattern("TTT")
                .pattern("TTT")
                .define('T', ModBlocks.ORANGE_TIBERCRETE_BRICKS.get())
                .unlockedBy(getHasName(ModBlocks.ORANGE_TIBERCRETE.get()), has(ModBlocks.ORANGE_TIBERCRETE.get()))
                .save(consumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.PINK_TIBERCRETE_BRICK_WALL.get(), 6)
                .pattern("   ")
                .pattern("TTT")
                .pattern("TTT")
                .define('T', ModBlocks.PINK_TIBERCRETE_BRICKS.get())
                .unlockedBy(getHasName(ModBlocks.PINK_TIBERCRETE.get()), has(ModBlocks.PINK_TIBERCRETE.get()))
                .save(consumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.PURPLE_TIBERCRETE_BRICK_WALL.get(), 6)
                .pattern("   ")
                .pattern("TTT")
                .pattern("TTT")
                .define('T', ModBlocks.PURPLE_TIBERCRETE_BRICKS.get())
                .unlockedBy(getHasName(ModBlocks.PURPLE_TIBERCRETE.get()), has(ModBlocks.PURPLE_TIBERCRETE.get()))
                .save(consumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.RED_TIBERCRETE_BRICK_WALL.get(), 6)
                .pattern("   ")
                .pattern("TTT")
                .pattern("TTT")
                .define('T', ModBlocks.RED_TIBERCRETE_BRICKS.get())
                .unlockedBy(getHasName(ModBlocks.RED_TIBERCRETE.get()), has(ModBlocks.RED_TIBERCRETE.get()))
                .save(consumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.WHITE_TIBERCRETE_BRICK_WALL.get(), 6)
                .pattern("   ")
                .pattern("TTT")
                .pattern("TTT")
                .define('T', ModBlocks.WHITE_TIBERCRETE_BRICKS.get())
                .unlockedBy(getHasName(ModBlocks.WHITE_TIBERCRETE.get()), has(ModBlocks.WHITE_TIBERCRETE.get()))
                .save(consumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.YELLOW_TIBERCRETE_BRICK_WALL.get(), 6)
                .pattern("   ")
                .pattern("TTT")
                .pattern("TTT")
                .define('T', ModBlocks.YELLOW_TIBERCRETE_BRICKS.get())
                .unlockedBy(getHasName(ModBlocks.YELLOW_TIBERCRETE.get()), has(ModBlocks.YELLOW_TIBERCRETE.get()))
                .save(consumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.PLAGUED_ANDESITE_WALL.get(), 6)
                .pattern("   ")
                .pattern("TTT")
                .pattern("TTT")
                .define('T', ModBlocks.INFESTED_ANDESITE.get())
                .unlockedBy(getHasName(ModBlocks.INFESTED_ANDESITE.get()), has(ModBlocks.INFESTED_ANDESITE.get()))
                .save(consumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.PLAGUED_ANDESITE_STAIRS.get(), 4)
                .pattern("T  ")
                .pattern("TT ")
                .pattern("TTT")
                .define('T', ModBlocks.INFESTED_ANDESITE.get())
                .unlockedBy(getHasName(ModBlocks.INFESTED_ANDESITE.get()), has(ModBlocks.INFESTED_ANDESITE.get()))
                .save(consumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.PLAGUED_ANDESITE_SLAB.get(), 6)
                .pattern("   ")
                .pattern("   ")
                .pattern("TTT")
                .define('T', ModBlocks.INFESTED_ANDESITE.get())
                .unlockedBy(getHasName(ModBlocks.INFESTED_ANDESITE.get()), has(ModBlocks.INFESTED_ANDESITE.get()))
                .save(consumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.PLAGUED_STONE_WALL.get(), 6)
                .pattern("   ")
                .pattern("TTT")
                .pattern("TTT")
                .define('T', ModBlocks.INFESTED_STONE.get())
                .unlockedBy(getHasName(ModBlocks.INFESTED_STONE.get()), has(ModBlocks.INFESTED_STONE.get()))
                .save(consumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.PLAGUED_STONE_STAIRS.get(), 4)
                .pattern("T  ")
                .pattern("TT ")
                .pattern("TTT")
                .define('T', ModBlocks.INFESTED_STONE.get())
                .unlockedBy(getHasName(ModBlocks.INFESTED_STONE.get()), has(ModBlocks.INFESTED_STONE.get()))
                .save(consumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.PLAGUED_STONE_SLAB.get(), 6)
                .pattern("   ")
                .pattern("   ")
                .pattern("TTT")
                .define('T', ModBlocks.INFESTED_STONE.get())
                .unlockedBy(getHasName(ModBlocks.INFESTED_STONE.get()), has(ModBlocks.INFESTED_STONE.get()))
                .save(consumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.PLAGUED_GRANITE_WALL.get(), 6)
                .pattern("   ")
                .pattern("TTT")
                .pattern("TTT")
                .define('T', ModBlocks.INFESTED_GRANITE.get())
                .unlockedBy(getHasName(ModBlocks.INFESTED_GRANITE.get()), has(ModBlocks.INFESTED_GRANITE.get()))
                .save(consumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.PLAGUED_GRANITE_STAIRS.get(), 4)
                .pattern("T  ")
                .pattern("TT ")
                .pattern("TTT")
                .define('T', ModBlocks.INFESTED_GRANITE.get())
                .unlockedBy(getHasName(ModBlocks.INFESTED_GRANITE.get()), has(ModBlocks.INFESTED_GRANITE.get()))
                .save(consumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.PLAGUED_GRANITE_SLAB.get(), 6)
                .pattern("   ")
                .pattern("   ")
                .pattern("TTT")
                .define('T', ModBlocks.INFESTED_GRANITE.get())
                .unlockedBy(getHasName(ModBlocks.INFESTED_GRANITE.get()), has(ModBlocks.INFESTED_GRANITE.get()))
                .save(consumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.PLAGUED_DIORITE_WALL.get(), 6)
                .pattern("   ")
                .pattern("TTT")
                .pattern("TTT")
                .define('T', ModBlocks.INFESTED_DIORITE.get())
                .unlockedBy(getHasName(ModBlocks.INFESTED_DIORITE.get()), has(ModBlocks.INFESTED_DIORITE.get()))
                .save(consumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.PLAGUED_DIORITE_STAIRS.get(), 4)
                .pattern("T  ")
                .pattern("TT ")
                .pattern("TTT")
                .define('T', ModBlocks.INFESTED_DIORITE.get())
                .unlockedBy(getHasName(ModBlocks.INFESTED_DIORITE.get()), has(ModBlocks.INFESTED_DIORITE.get()))
                .save(consumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.PLAGUED_DIORITE_SLAB.get(), 6)
                .pattern("   ")
                .pattern("   ")
                .pattern("TTT")
                .define('T', ModBlocks.INFESTED_DIORITE.get())
                .unlockedBy(getHasName(ModBlocks.INFESTED_DIORITE.get()), has(ModBlocks.INFESTED_DIORITE.get()))
                .save(consumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.RIPARIUS_STONE_WALL.get(), 6)
                .pattern("   ")
                .pattern("TTT")
                .pattern("TTT")
                .define('T', ModBlocks.RIPARIUS_STONE.get())
                .unlockedBy(getHasName(ModBlocks.RIPARIUS_STONE.get()), has(ModBlocks.RIPARIUS_STONE.get()))
                .save(consumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.RIPARIUS_STONE_STAIRS.get(), 4)
                .pattern("T  ")
                .pattern("TT ")
                .pattern("TTT")
                .define('T', ModBlocks.RIPARIUS_STONE.get())
                .unlockedBy(getHasName(ModBlocks.RIPARIUS_STONE.get()), has(ModBlocks.RIPARIUS_STONE.get()))
                .save(consumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.RIPARIUS_STONE_SLAB.get(), 6)
                .pattern("   ")
                .pattern("   ")
                .pattern("TTT")
                .define('T', ModBlocks.RIPARIUS_STONE.get())
                .unlockedBy(getHasName(ModBlocks.RIPARIUS_STONE.get()), has(ModBlocks.RIPARIUS_STONE.get()))
                .save(consumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.VINIFERA_STONE_WALL.get(), 6)
                .pattern("   ")
                .pattern("TTT")
                .pattern("TTT")
                .define('T', ModBlocks.VINIFERA_STONE.get())
                .unlockedBy(getHasName(ModBlocks.VINIFERA_STONE.get()), has(ModBlocks.VINIFERA_STONE.get()))
                .save(consumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.VINIFERA_STONE_STAIRS.get(), 4)
                .pattern("T  ")
                .pattern("TT ")
                .pattern("TTT")
                .define('T', ModBlocks.VINIFERA_STONE.get())
                .unlockedBy(getHasName(ModBlocks.VINIFERA_STONE.get()), has(ModBlocks.VINIFERA_STONE.get()))
                .save(consumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.VINIFERA_STONE_SLAB.get(), 6)
                .pattern("   ")
                .pattern("   ")
                .pattern("TTT")
                .define('T', ModBlocks.VINIFERA_STONE.get())
                .unlockedBy(getHasName(ModBlocks.VINIFERA_STONE.get()), has(ModBlocks.VINIFERA_STONE.get()))
                .save(consumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.CRUENTUS_STONE_WALL.get(), 6)
                .pattern("   ")
                .pattern("TTT")
                .pattern("TTT")
                .define('T', ModBlocks.CRUENTUS_STONE.get())
                .unlockedBy(getHasName(ModBlocks.CRUENTUS_STONE.get()), has(ModBlocks.CRUENTUS_STONE.get()))
                .save(consumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.CRUENTUS_STONE_STAIRS.get(), 4)
                .pattern("T  ")
                .pattern("TT ")
                .pattern("TTT")
                .define('T', ModBlocks.CRUENTUS_STONE.get())
                .unlockedBy(getHasName(ModBlocks.CRUENTUS_STONE.get()), has(ModBlocks.CRUENTUS_STONE.get()))
                .save(consumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.CRUENTUS_STONE_SLAB.get(), 6)
                .pattern("   ")
                .pattern("   ")
                .pattern("TTT")
                .define('T', ModBlocks.CRUENTUS_STONE.get())
                .unlockedBy(getHasName(ModBlocks.CRUENTUS_STONE.get()), has(ModBlocks.CRUENTUS_STONE.get()))
                .save(consumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.ABOREUS_STONE_WALL.get(), 6)
                .pattern("   ")
                .pattern("TTT")
                .pattern("TTT")
                .define('T', ModBlocks.ABOREUS_STONE.get())
                .unlockedBy(getHasName(ModBlocks.ABOREUS_STONE.get()), has(ModBlocks.ABOREUS_STONE.get()))
                .save(consumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.ABOREUS_STONE_STAIRS.get(), 4)
                .pattern("T  ")
                .pattern("TT ")
                .pattern("TTT")
                .define('T', ModBlocks.ABOREUS_STONE.get())
                .unlockedBy(getHasName(ModBlocks.ABOREUS_STONE.get()), has(ModBlocks.ABOREUS_STONE.get()))
                .save(consumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.ABOREUS_STONE_SLAB.get(), 6)
                .pattern("   ")
                .pattern("   ")
                .pattern("TTT")
                .define('T', ModBlocks.ABOREUS_STONE.get())
                .unlockedBy(getHasName(ModBlocks.ABOREUS_STONE.get()), has(ModBlocks.ABOREUS_STONE.get()))
                .save(consumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.RIPARIUS_CRYSTAL_WALL.get(), 6)
                .pattern("   ")
                .pattern("TTT")
                .pattern("TTT")
                .define('T', ModBlocks.RIPARIUS_CRYSTAL.get())
                .unlockedBy(getHasName(ModBlocks.RIPARIUS_CRYSTAL.get()), has(ModBlocks.RIPARIUS_CRYSTAL.get()))
                .save(consumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.RIPARIUS_CRYSTAL_STAIRS.get(), 4)
                .pattern("T  ")
                .pattern("TT ")
                .pattern("TTT")
                .define('T', ModBlocks.RIPARIUS_CRYSTAL.get())
                .unlockedBy(getHasName(ModBlocks.RIPARIUS_CRYSTAL.get()), has(ModBlocks.RIPARIUS_CRYSTAL.get()))
                .save(consumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.RIPARIUS_CRYSTAL_SLAB.get(), 6)
                .pattern("   ")
                .pattern("   ")
                .pattern("TTT")
                .define('T', ModBlocks.RIPARIUS_CRYSTAL.get())
                .unlockedBy(getHasName(ModBlocks.RIPARIUS_CRYSTAL.get()), has(ModBlocks.RIPARIUS_CRYSTAL.get()))
                .save(consumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.VINIFERA_CRYSTAL_WALL.get(), 6)
                .pattern("   ")
                .pattern("TTT")
                .pattern("TTT")
                .define('T', ModBlocks.VINIFERA_CRYSTAL.get())
                .unlockedBy(getHasName(ModBlocks.VINIFERA_CRYSTAL.get()), has(ModBlocks.VINIFERA_CRYSTAL.get()))
                .save(consumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.VINIFERA_CRYSTAL_STAIRS.get(), 4)
                .pattern("T  ")
                .pattern("TT ")
                .pattern("TTT")
                .define('T', ModBlocks.VINIFERA_CRYSTAL.get())
                .unlockedBy(getHasName(ModBlocks.VINIFERA_CRYSTAL.get()), has(ModBlocks.VINIFERA_CRYSTAL.get()))
                .save(consumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.VINIFERA_CRYSTAL_SLAB.get(), 6)
                .pattern("   ")
                .pattern("   ")
                .pattern("TTT")
                .define('T', ModBlocks.VINIFERA_CRYSTAL.get())
                .unlockedBy(getHasName(ModBlocks.VINIFERA_CRYSTAL.get()), has(ModBlocks.VINIFERA_CRYSTAL.get()))
                .save(consumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.CRUENTUS_CRYSTAL_WALL.get(), 6)
                .pattern("   ")
                .pattern("TTT")
                .pattern("TTT")
                .define('T', ModBlocks.CRUENTUS_CRYSTAL.get())
                .unlockedBy(getHasName(ModBlocks.CRUENTUS_CRYSTAL.get()), has(ModBlocks.CRUENTUS_CRYSTAL.get()))
                .save(consumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.YZ_SANDSTONE_WALL.get(), 6)
                .pattern("   ")
                .pattern("TTT")
                .pattern("TTT")
                .define('T', ModBlocks.YZ_SANDSTONE.get())
                .unlockedBy(getHasName(ModBlocks.YZ_SANDSTONE.get()), has(ModBlocks.YZ_SANDSTONE.get()))
                .save(consumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.YZ_SANDSTONE_STAIRS.get(), 4)
                .pattern("T  ")
                .pattern("TT ")
                .pattern("TTT")
                .define('T', ModBlocks.YZ_SANDSTONE.get())
                .unlockedBy(getHasName(ModBlocks.YZ_SANDSTONE.get()), has(ModBlocks.YZ_SANDSTONE.get()))
                .save(consumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.YZ_SANDSTONE_SLAB.get(), 6)
                .pattern("   ")
                .pattern("   ")
                .pattern("TTT")
                .define('T', ModBlocks.YZ_SANDSTONE.get())
                .unlockedBy(getHasName(ModBlocks.YZ_SANDSTONE.get()), has(ModBlocks.YZ_SANDSTONE.get()))
                .save(consumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.SMOOTH_YZ_SANDSTONE_STAIRS.get(), 4)
                .pattern("T  ")
                .pattern("TT ")
                .pattern("TTT")
                .define('T', ModBlocks.SMOOTH_YZ_SANDSTONE.get())
                .unlockedBy(getHasName(ModBlocks.SMOOTH_YZ_SANDSTONE.get()), has(ModBlocks.SMOOTH_YZ_SANDSTONE.get()))
                .save(consumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.SMOOTH_YZ_SANDSTONE_SLAB.get(), 6)
                .pattern("   ")
                .pattern("   ")
                .pattern("TTT")
                .define('T', ModBlocks.SMOOTH_YZ_SANDSTONE.get())
                .unlockedBy(getHasName(ModBlocks.SMOOTH_YZ_SANDSTONE.get()), has(ModBlocks.SMOOTH_YZ_SANDSTONE.get()))
                .save(consumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.SMOOTH_RZ_SANDSTONE_STAIRS.get(), 4)
                .pattern("T  ")
                .pattern("TT ")
                .pattern("TTT")
                .define('T', ModBlocks.SMOOTH_RZ_SANDSTONE.get())
                .unlockedBy(getHasName(ModBlocks.SMOOTH_RZ_SANDSTONE.get()), has(ModBlocks.SMOOTH_RZ_SANDSTONE.get()))
                .save(consumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.SMOOTH_RZ_SANDSTONE_SLAB.get(), 6)
                .pattern("   ")
                .pattern("   ")
                .pattern("TTT")
                .define('T', ModBlocks.SMOOTH_RZ_SANDSTONE.get())
                .unlockedBy(getHasName(ModBlocks.SMOOTH_RZ_SANDSTONE.get()), has(ModBlocks.SMOOTH_RZ_SANDSTONE.get()))
                .save(consumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.YZ_SANDSTONE.get(), 1)
                .pattern("   ")
                .pattern(" TT")
                .pattern(" TT")
                .define('T', ModBlocks.YELLOW_ZONE_SAND.get())
                .unlockedBy(getHasName(ModBlocks.YELLOW_ZONE_SAND.get()), has(ModBlocks.YELLOW_ZONE_SAND.get()))
                .save(consumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.RZ_SANDSTONE_STAIRS.get(), 4)
                .pattern("T  ")
                .pattern("TT ")
                .pattern("TTT")
                .define('T', ModBlocks.RZ_SANDSTONE.get())
                .unlockedBy(getHasName(ModBlocks.RZ_SANDSTONE.get()), has(ModBlocks.RZ_SANDSTONE.get()))
                .save(consumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.RZ_SANDSTONE_SLAB.get(), 6)
                .pattern("   ")
                .pattern("   ")
                .pattern("TTT")
                .define('T', ModBlocks.RZ_SANDSTONE.get())
                .unlockedBy(getHasName(ModBlocks.RZ_SANDSTONE.get()), has(ModBlocks.RZ_SANDSTONE.get()))
                .save(consumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.RZ_SANDSTONE.get(), 1)
                .pattern("   ")
                .pattern(" TT")
                .pattern(" TT")
                .define('T', ModBlocks.RED_ZONE_SAND.get())
                .unlockedBy(getHasName(ModBlocks.RED_ZONE_SAND.get()), has(ModBlocks.RED_ZONE_SAND.get()))
                .save(consumer);


        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.CRUENTUS_CRYSTAL_STAIRS.get(), 4)
                .pattern("T  ")
                .pattern("TT ")
                .pattern("TTT")
                .define('T', ModBlocks.CRUENTUS_CRYSTAL.get())
                .unlockedBy(getHasName(ModBlocks.CRUENTUS_CRYSTAL.get()), has(ModBlocks.CRUENTUS_CRYSTAL.get()))
                .save(consumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.CRUENTUS_CRYSTAL_SLAB.get(), 6)
                .pattern("   ")
                .pattern("   ")
                .pattern("TTT")
                .define('T', ModBlocks.CRUENTUS_CRYSTAL.get())
                .unlockedBy(getHasName(ModBlocks.CRUENTUS_CRYSTAL.get()), has(ModBlocks.CRUENTUS_CRYSTAL.get()))
                .save(consumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.ABOREUS_CRYSTAL_WALL.get(), 6)
                .pattern("   ")
                .pattern("TTT")
                .pattern("TTT")
                .define('T', ModBlocks.ABOREUS_CRYSTAL.get())
                .unlockedBy(getHasName(ModBlocks.ABOREUS_CRYSTAL.get()), has(ModBlocks.ABOREUS_CRYSTAL.get()))
                .save(consumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.ABOREUS_CRYSTAL_STAIRS.get(), 4)
                .pattern("T  ")
                .pattern("TT ")
                .pattern("TTT")
                .define('T', ModBlocks.ABOREUS_CRYSTAL.get())
                .unlockedBy(getHasName(ModBlocks.ABOREUS_CRYSTAL.get()), has(ModBlocks.ABOREUS_CRYSTAL.get()))
                .save(consumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.ABOREUS_CRYSTAL_SLAB.get(), 6)
                .pattern("   ")
                .pattern("   ")
                .pattern("TTT")
                .define('T', ModBlocks.ABOREUS_CRYSTAL.get())
                .unlockedBy(getHasName(ModBlocks.ABOREUS_CRYSTAL.get()), has(ModBlocks.ABOREUS_CRYSTAL.get()))
                .save(consumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.PLAGUED_SWORD.get())
                .pattern(" P ")
                .pattern(" P ")
                .pattern(" S ")
                .define('P', ModBlocks.PLAGUED_PLANKS.get())
                .define('S', ModTags.Items.STICKS)
                .unlockedBy(getHasName(ModBlocks.PLAGUED_PLANKS.get()), has(ModBlocks.PLAGUED_PLANKS.get()))
                .save(consumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.PLAGUED_PICKAXE.get())
                .pattern("PPP")
                .pattern(" S ")
                .pattern(" S ")
                .define('P', ModBlocks.PLAGUED_PLANKS.get())
                .define('S', ModTags.Items.STICKS)
                .unlockedBy(getHasName(ModBlocks.PLAGUED_PLANKS.get()), has(ModBlocks.PLAGUED_PLANKS.get()))
                .save(consumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.PLAGUED_AXE.get())
                .pattern(" PP")
                .pattern(" SP")
                .pattern(" S ")
                .define('P', ModBlocks.PLAGUED_PLANKS.get())
                .define('S', ModTags.Items.STICKS)
                .unlockedBy(getHasName(ModBlocks.PLAGUED_PLANKS.get()), has(ModBlocks.PLAGUED_PLANKS.get()))
                .save(consumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.PLAGUED_SHOVEL.get())
                .pattern(" P ")
                .pattern(" S ")
                .pattern(" S ")
                .define('P', ModBlocks.PLAGUED_PLANKS.get())
                .define('S', ModTags.Items.STICKS)
                .unlockedBy(getHasName(ModBlocks.PLAGUED_PLANKS.get()), has(ModBlocks.PLAGUED_PLANKS.get()))
                .save(consumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.PLAGUED_HOE.get())
                .pattern(" PP")
                .pattern(" S ")
                .pattern(" S ")
                .define('P', ModBlocks.PLAGUED_PLANKS.get())
                .define('S', ModTags.Items.STICKS)
                .unlockedBy(getHasName(ModBlocks.PLAGUED_PLANKS.get()), has(ModBlocks.PLAGUED_PLANKS.get()))
                .save(consumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.GUNDANIUM_HELMET.get())
                .pattern("GGG")
                .pattern("G G")
                .pattern("   ")
                .define('G', ModItems.GUNDANIUM_INGOT.get())
                .unlockedBy(getHasName(ModItems.GUNDANIUM_INGOT.get()), has(ModItems.GUNDANIUM_INGOT.get()))
                .save(consumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.GUNDANIUM_CHESTPLATE.get())
                .pattern("G G")
                .pattern("GGG")
                .pattern("GGG")
                .define('G', ModItems.GUNDANIUM_INGOT.get())
                .unlockedBy(getHasName(ModItems.GUNDANIUM_INGOT.get()), has(ModItems.GUNDANIUM_INGOT.get()))
                .save(consumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.GUNDANIUM_LEGGINGS.get())
                .pattern("GGG")
                .pattern("G G")
                .pattern("G G")
                .define('G', ModItems.GUNDANIUM_INGOT.get())
                .unlockedBy(getHasName(ModItems.GUNDANIUM_INGOT.get()), has(ModItems.GUNDANIUM_INGOT.get()))
                .save(consumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.GUNDANIUM_BOOTS.get())
                .pattern("   ")
                .pattern("G G")
                .pattern("G G")
                .define('G', ModItems.GUNDANIUM_INGOT.get())
                .unlockedBy(getHasName(ModItems.GUNDANIUM_INGOT.get()), has(ModItems.GUNDANIUM_INGOT.get()))
                .save(consumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.GUNDANIUM_HORSE_ARMOR.get())
                .pattern("GGG")
                .pattern("GIG")
                .pattern("GGG")
                .define('G', ModItems.GUNDANIUM_INGOT.get())
                .define('I', Items.IRON_HORSE_ARMOR)
                .unlockedBy(getHasName(ModItems.GUNDANIUM_INGOT.get()), has(ModItems.GUNDANIUM_INGOT.get()))
                .save(consumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.GUNDANIUM_SWORD.get())
                .pattern(" G ")
                .pattern(" G ")
                .pattern(" S ")
                .define('G', ModItems.GUNDANIUM_INGOT.get())
                .define('S', ModTags.Items.STICKS)
                .unlockedBy(getHasName(ModItems.GUNDANIUM_INGOT.get()), has(ModItems.GUNDANIUM_INGOT.get()))
                .save(consumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.GUNDANIUM_PICKAXE.get())
                .pattern("GGG")
                .pattern(" S ")
                .pattern(" S ")
                .define('G', ModItems.GUNDANIUM_INGOT.get())
                .define('S', ModTags.Items.STICKS)
                .unlockedBy(getHasName(ModItems.GUNDANIUM_INGOT.get()), has(ModItems.GUNDANIUM_INGOT.get()))
                .save(consumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.GUNDANIUM_AXE.get())
                .pattern(" GG")
                .pattern(" SG")
                .pattern(" S ")
                .define('G', ModItems.GUNDANIUM_INGOT.get())
                .define('S', ModTags.Items.STICKS)
                .unlockedBy(getHasName(ModItems.GUNDANIUM_INGOT.get()), has(ModItems.GUNDANIUM_INGOT.get()))
                .save(consumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.GUNDANIUM_SHOVEL.get())
                .pattern(" G ")
                .pattern(" S ")
                .pattern(" S ")
                .define('G', ModItems.GUNDANIUM_INGOT.get())
                .define('S', ModTags.Items.STICKS)
                .unlockedBy(getHasName(ModItems.GUNDANIUM_INGOT.get()), has(ModItems.GUNDANIUM_INGOT.get()))
                .save(consumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.GUNDANIUM_HOE.get())
                .pattern(" GG")
                .pattern(" S ")
                .pattern(" S ")
                .define('G', ModItems.GUNDANIUM_INGOT.get())
                .define('S', ModTags.Items.STICKS)
                .unlockedBy(getHasName(ModItems.GUNDANIUM_INGOT.get()), has(ModItems.GUNDANIUM_INGOT.get()))
                .save(consumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.GUNDANIUM_EXCAVATOR.get())
                .pattern(" II")
                .pattern(" GI")
                .pattern("S  ")
                .define('I', ModItems.GUNDANIUM_INGOT.get())
                .define('G', ModItems.GUNDANIUM_SHOVEL.get())
                .define('S', ModTags.Items.STICKS)
                .unlockedBy(getHasName(ModItems.GUNDANIUM_SHOVEL.get()), has(ModItems.GUNDANIUM_SHOVEL.get()))
                .save(consumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.ALYTHUM_HELMET.get())
                .pattern("AAA")
                .pattern("A A")
                .pattern("   ")
                .define('A', ModItems.ALYTHUM_INGOT.get())
                .unlockedBy(getHasName(ModItems.ALYTHUM_INGOT.get()), has(ModItems.ALYTHUM_INGOT.get()))
                .save(consumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.ALYTHUM_CHESTPLATE.get())
                .pattern("A A")
                .pattern("AAA")
                .pattern("AAA")
                .define('A', ModItems.ALYTHUM_INGOT.get())
                .unlockedBy(getHasName(ModItems.ALYTHUM_INGOT.get()), has(ModItems.ALYTHUM_INGOT.get()))
                .save(consumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.ALYTHUM_LEGGINGS.get())
                .pattern("AAA")
                .pattern("A A")
                .pattern("A A")
                .define('A', ModItems.ALYTHUM_INGOT.get())
                .unlockedBy(getHasName(ModItems.ALYTHUM_INGOT.get()), has(ModItems.ALYTHUM_INGOT.get()))
                .save(consumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.ALYTHUM_BOOTS.get())
                .pattern("   ")
                .pattern("A A")
                .pattern("A A")
                .define('A', ModItems.ALYTHUM_INGOT.get())
                .unlockedBy(getHasName(ModItems.ALYTHUM_INGOT.get()), has(ModItems.ALYTHUM_INGOT.get()))
                .save(consumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.HAZMAT_MK1_HELMET.get())
                .pattern("LLL")
                .pattern("LGL")
                .pattern("   ")
                .define('L', ModItems.TIBERIUM_LEATHER.get())
                .define('G', ModTags.Items.HAZMAT_GLASS_PANES)
                .unlockedBy(getHasName(ModItems.TIBERIUM_LEATHER.get()), has(ModItems.TIBERIUM_LEATHER.get()))
                .save(consumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.HAZMAT_MK1_CHESTPLATE.get())
                .pattern("L L")
                .pattern("LLL")
                .pattern("LLL")
                .define('L', ModItems.TIBERIUM_LEATHER.get())
                .unlockedBy(getHasName(ModItems.TIBERIUM_LEATHER.get()), has(ModItems.TIBERIUM_LEATHER.get()))
                .save(consumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.HAZMAT_MK1_LEGGINGS.get())
                .pattern("LLL")
                .pattern("L L")
                .pattern("L L")
                .define('L', ModItems.TIBERIUM_LEATHER.get())
                .unlockedBy(getHasName(ModItems.TIBERIUM_LEATHER.get()), has(ModItems.TIBERIUM_LEATHER.get()))
                .save(consumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.HAZMAT_MK1_BOOTS.get())
                .pattern("   ")
                .pattern("L L")
                .pattern("L L")
                .define('L', ModItems.TIBERIUM_LEATHER.get())
                .unlockedBy(getHasName(ModItems.TIBERIUM_LEATHER.get()), has(ModItems.TIBERIUM_LEATHER.get()))
                .save(consumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.ALYTHUM_SWORD.get())
                .pattern(" A ")
                .pattern(" A ")
                .pattern(" S ")
                .define('A', ModItems.ALYTHUM_INGOT.get())
                .define('S', ModTags.Items.STICKS)
                .unlockedBy(getHasName(ModItems.ALYTHUM_INGOT.get()), has(ModItems.ALYTHUM_INGOT.get()))
                .save(consumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.ALYTHUM_PICKAXE.get())
                .pattern("AAA")
                .pattern(" S ")
                .pattern(" S ")
                .define('A', ModItems.ALYTHUM_INGOT.get())
                .define('S', ModTags.Items.STICKS)
                .unlockedBy(getHasName(ModItems.ALYTHUM_INGOT.get()), has(ModItems.ALYTHUM_INGOT.get()))
                .save(consumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.ALYTHUM_AXE.get())
                .pattern(" AA")
                .pattern(" SA")
                .pattern(" S ")
                .define('A', ModItems.ALYTHUM_INGOT.get())
                .define('S', ModTags.Items.STICKS)
                .unlockedBy(getHasName(ModItems.ALYTHUM_INGOT.get()), has(ModItems.ALYTHUM_INGOT.get()))
                .save(consumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.ALYTHUM_SHOVEL.get())
                .pattern(" A ")
                .pattern(" S ")
                .pattern(" S ")
                .define('A', ModItems.ALYTHUM_INGOT.get())
                .define('S', ModTags.Items.STICKS)
                .unlockedBy(getHasName(ModItems.ALYTHUM_INGOT.get()), has(ModItems.ALYTHUM_INGOT.get()))
                .save(consumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.ALYTHUM_HOE.get())
                .pattern(" AA")
                .pattern(" S ")
                .pattern(" S ")
                .define('A', ModItems.ALYTHUM_INGOT.get())
                .define('S', ModTags.Items.STICKS)
                .unlockedBy(getHasName(ModItems.ALYTHUM_INGOT.get()), has(ModItems.ALYTHUM_INGOT.get()))
                .save(consumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.ALYTHUM_HAMMER.get())
                .pattern("ABA")
                .pattern("ASA")
                .pattern(" S ")
                .define('A', ModItems.ALYTHUM_INGOT.get())
                .define('B', ModBlocks.ALYTHUM_BLOCK.get())
                .define('S', ModTags.Items.STICKS)
                .unlockedBy(getHasName(ModItems.ALYTHUM_INGOT.get()), has(ModItems.ALYTHUM_INGOT.get()))
                .save(consumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.ALYTHUM_EXCAVATOR.get())
                .pattern(" II")
                .pattern(" GI")
                .pattern("S  ")
                .define('I', ModItems.ALYTHUM_INGOT.get())
                .define('G', ModItems.ALYTHUM_SHOVEL.get())
                .define('S', ModTags.Items.STICKS)
                .unlockedBy(getHasName(ModItems.ALYTHUM_SHOVEL.get()), has(ModItems.ALYTHUM_SHOVEL.get()))
                .save(consumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.ILLYRIM_EXCAVATOR.get())
                .pattern(" II")
                .pattern(" GI")
                .pattern("S  ")
                .define('I', ModItems.ILLYRIM_INGOT.get())
                .define('G', ModItems.ILLYRIM_SHOVEL.get())
                .define('S', ModTags.Items.STICKS)
                .unlockedBy(getHasName(ModItems.ILLYRIM_SHOVEL.get()), has(ModItems.ILLYRIM_SHOVEL.get()))
                .save(consumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.GUNDANIUM_HAMMER.get())
                .pattern("ABA")
                .pattern("ASA")
                .pattern(" S ")
                .define('A', ModItems.GUNDANIUM_INGOT.get())
                .define('B', ModBlocks.GUNDANIUM_BLOCK.get())
                .define('S', ModTags.Items.STICKS)
                .unlockedBy(getHasName(ModItems.GUNDANIUM_INGOT.get()), has(ModItems.GUNDANIUM_INGOT.get()))
                .save(consumer);


        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.ALYTHUM_PAXEL.get())
                .pattern("CSC")
                .pattern("AHP")
                .pattern(" H ")
                .define('P', ModItems.ALYTHUM_PICKAXE.get())
                .define('A', ModItems.ALYTHUM_AXE.get())
                .define('S', ModItems.ALYTHUM_SHOVEL.get())
                .define('C', ModItems.LG_CORE_INGOT.get())
                .define('H', ModTags.Items.STICKS)
                .unlockedBy(getHasName(ModItems.ALYTHUM_INGOT.get()), has(ModItems.ALYTHUM_INGOT.get()))
                .save(consumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.GUNDANIUM_PAXEL.get())
                .pattern("GSG")
                .pattern("AHP")
                .pattern(" H ")
                .define('P', ModItems.GUNDANIUM_PICKAXE.get())
                .define('A', ModItems.GUNDANIUM_AXE.get())
                .define('S', ModItems.GUNDANIUM_SHOVEL.get())
                .define('G', ModBlocks.GUNDANIUM_BLOCK.get())
                .define('H', ModTags.Items.STICKS)
                .unlockedBy(getHasName(ModItems.ALYTHUM_INGOT.get()), has(ModItems.ALYTHUM_INGOT.get()))
                .save(consumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.ILLYRIM_SWORD.get())
                .pattern(" I ")
                .pattern(" I ")
                .pattern(" S ")
                .define('I', ModItems.ILLYRIM_INGOT.get())
                .define('S', ModTags.Items.STICKS)
                .unlockedBy(getHasName(ModItems.ILLYRIM_INGOT.get()), has(ModItems.ILLYRIM_INGOT.get()))
                .save(consumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.ILLYRIM_PICKAXE.get())
                .pattern("III")
                .pattern(" S ")
                .pattern(" S ")
                .define('I', ModItems.ILLYRIM_INGOT.get())
                .define('S', ModTags.Items.STICKS)
                .unlockedBy(getHasName(ModItems.ILLYRIM_INGOT.get()), has(ModItems.ILLYRIM_INGOT.get()))
                .save(consumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.ILLYRIM_AXE.get())
                .pattern(" II")
                .pattern(" SI")
                .pattern(" S ")
                .define('I', ModItems.ILLYRIM_INGOT.get())
                .define('S', ModTags.Items.STICKS)
                .unlockedBy(getHasName(ModItems.ILLYRIM_INGOT.get()), has(ModItems.ILLYRIM_INGOT.get()))
                .save(consumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.ILLYRIM_SHOVEL.get())
                .pattern(" I ")
                .pattern(" S ")
                .pattern(" S ")
                .define('I', ModItems.ILLYRIM_INGOT.get())
                .define('S', ModTags.Items.STICKS)
                .unlockedBy(getHasName(ModItems.ILLYRIM_INGOT.get()), has(ModItems.ILLYRIM_INGOT.get()))
                .save(consumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.ILLYRIM_HOE.get())
                .pattern(" II")
                .pattern(" S ")
                .pattern(" S ")
                .define('I', ModItems.ILLYRIM_INGOT.get())
                .define('S', ModTags.Items.STICKS)
                .unlockedBy(getHasName(ModItems.ILLYRIM_INGOT.get()), has(ModItems.ILLYRIM_INGOT.get()))
                .save(consumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.ILLYRIM_HAMMER.get())
                .pattern("IBI")
                .pattern("ISI")
                .pattern(" S ")
                .define('I', ModItems.ILLYRIM_INGOT.get())
                .define('B', ModBlocks.ILLYRIM_BLOCK.get())
                .define('S', ModTags.Items.STICKS)
                .unlockedBy(getHasName(ModItems.ILLYRIM_INGOT.get()), has(ModItems.ILLYRIM_INGOT.get()))
                .save(consumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.ILLYRIM_PAXEL.get())
                .pattern("CSC")
                .pattern("IHP")
                .pattern(" H ")
                .define('P', ModItems.ILLYRIM_PICKAXE.get())
                .define('I', ModItems.ILLYRIM_AXE.get())
                .define('S', ModItems.ILLYRIM_SHOVEL.get())
                .define('C', ModItems.MG_CORE_INGOT.get())
                .define('H', ModTags.Items.STICKS)
                .unlockedBy(getHasName(ModItems.ILLYRIM_INGOT.get()), has(ModItems.ILLYRIM_INGOT.get()))
                .save(consumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.ILLYRIM_HELMET.get())
                .pattern("III")
                .pattern("I I")
                .pattern("   ")
                .define('I', ModItems.ILLYRIM_INGOT.get())
                .unlockedBy(getHasName(ModItems.ILLYRIM_INGOT.get()), has(ModItems.ILLYRIM_INGOT.get()))
                .save(consumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.ILLYRIM_CHESTPLATE.get())
                .pattern("I I")
                .pattern("III")
                .pattern("III")
                .define('I', ModItems.ILLYRIM_INGOT.get())
                .unlockedBy(getHasName(ModItems.ILLYRIM_INGOT.get()), has(ModItems.ILLYRIM_INGOT.get()))
                .save(consumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.ILLYRIM_LEGGINGS.get())
                .pattern("III")
                .pattern("I I")
                .pattern("I I")
                .define('I', ModItems.ILLYRIM_INGOT.get())
                .unlockedBy(getHasName(ModItems.ILLYRIM_INGOT.get()), has(ModItems.ILLYRIM_INGOT.get()))
                .save(consumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.ILLYRIM_BOOTS.get())
                .pattern("   ")
                .pattern("I I")
                .pattern("I I")
                .define('I', ModItems.ILLYRIM_INGOT.get())
                .unlockedBy(getHasName(ModItems.ILLYRIM_INGOT.get()), has(ModItems.ILLYRIM_INGOT.get()))
                .save(consumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.HAZMAT_MK2_HELMET.get())
                .pattern("TTT")
                .pattern("IHI")
                .pattern("   ")
                .define('I', ModItems.ICHOR_LEATHER.get())
                .define('H', ModItems.HAZMAT_MK1_HELMET.get())
                .define('T', ModItems.TIBERIUM_COMPOSITE_INGOT.get())
                .unlockedBy(getHasName(ModItems.HAZMAT_MK1_HELMET.get()), has(ModItems.HAZMAT_MK1_HELMET.get()))
                .save(consumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.HAZMAT_MK2_CHESTPLATE.get())
                .pattern("I I")
                .pattern("THT")
                .pattern("TTT")
                .define('I', ModItems.ICHOR_LEATHER.get())
                .define('H', ModItems.HAZMAT_MK1_CHESTPLATE.get())
                .define('T', ModItems.TIBERIUM_COMPOSITE_INGOT.get())
                .unlockedBy(getHasName(ModItems.HAZMAT_MK1_CHESTPLATE.get()), has(ModItems.HAZMAT_MK1_CHESTPLATE.get()))
                .save(consumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.HAZMAT_MK2_LEGGINGS.get())
                .pattern("THT")
                .pattern("T T")
                .pattern("I I")
                .define('I', ModItems.ICHOR_LEATHER.get())
                .define('H', ModItems.HAZMAT_MK1_LEGGINGS.get())
                .define('T', ModItems.TIBERIUM_COMPOSITE_INGOT.get())
                .unlockedBy(getHasName(ModItems.HAZMAT_MK1_LEGGINGS.get()), has(ModItems.HAZMAT_MK1_LEGGINGS.get()))
                .save(consumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.HAZMAT_MK2_BOOTS.get())
                .pattern("   ")
                .pattern("THT")
                .pattern("I I")
                .define('I', ModItems.ICHOR_LEATHER.get())
                .define('H', ModItems.HAZMAT_MK1_BOOTS.get())
                .define('T', ModItems.TIBERIUM_COMPOSITE_INGOT.get())
                .unlockedBy(getHasName(ModItems.HAZMAT_MK1_BOOTS.get()), has(ModItems.HAZMAT_MK1_BOOTS.get()))
                .save(consumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.PLAGUED_HANGING_SIGN.get())
                .pattern("C C")
                .pattern("SSS")
                .pattern("SSS")
                .define('S', ModBlocks.STRIPPED_PLAGUED_LOG.get())
                .define('C', Items.CHAIN)
                .unlockedBy(getHasName(ModBlocks.PLAGUED_LOG.get()), has(ModBlocks.PLAGUED_LOG.get()))
                .save(consumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.MARIKA_OAK_HANGING_SIGN.get())
                .pattern("C C")
                .pattern("SSS")
                .pattern("SSS")
                .define('S', ModBlocks.STRIPPED_MARIKA_OAK_LOG.get())
                .define('C', Items.CHAIN)
                .unlockedBy(getHasName(ModBlocks.MARIKA_OAK_LOG.get()), has(ModBlocks.MARIKA_OAK_LOG.get()))
                .save(consumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.EMBER_OAK_HANGING_SIGN.get())
                .pattern("C C")
                .pattern("SSS")
                .pattern("SSS")
                .define('S', ModBlocks.STRIPPED_EMBER_OAK_LOG.get())
                .define('C', Items.CHAIN)
                .unlockedBy(getHasName(ModBlocks.EMBER_OAK_LOG.get()), has(ModBlocks.EMBER_OAK_LOG.get()))
                .save(consumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.DEAD_HANGING_SIGN.get())
                .pattern("C C")
                .pattern("SSS")
                .pattern("SSS")
                .define('S', ModBlocks.STRIPPED_DEAD_LOG.get())
                .define('C', Items.CHAIN)
                .unlockedBy(getHasName(ModBlocks.DEAD_LOG.get()), has(ModBlocks.DEAD_LOG.get()))
                .save(consumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.DEAD_SIGN.get())
                .pattern("SSS")
                .pattern("SSS")
                .pattern(" P ")
                .define('S', ModBlocks.DEAD_PLANKS.get())
                .define('P', ModTags.Items.STICKS)
                .unlockedBy(getHasName(ModBlocks.DEAD_LOG.get()), has(ModBlocks.DEAD_LOG.get()))
                .save(consumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.PLAGUED_SIGN.get())
                .pattern("SSS")
                .pattern("SSS")
                .pattern(" P ")
                .define('S', ModBlocks.PLAGUED_PLANKS.get())
                .define('P', ModTags.Items.STICKS)
                .unlockedBy(getHasName(ModBlocks.PLAGUED_LOG.get()), has(ModBlocks.PLAGUED_LOG.get()))
                .save(consumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.EMBER_OAK_SIGN.get())
                .pattern("SSS")
                .pattern("SSS")
                .pattern(" P ")
                .define('S', ModBlocks.EMBER_OAK_PLANKS.get())
                .define('P', ModTags.Items.STICKS)
                .unlockedBy(getHasName(ModBlocks.EMBER_OAK_LOG.get()), has(ModBlocks.EMBER_OAK_LOG.get()))
                .save(consumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.MARIKA_OAK_SIGN.get())
                .pattern("SSS")
                .pattern("SSS")
                .pattern(" P ")
                .define('S', ModBlocks.MARIKA_OAK_PLANKS.get())
                .define('P', ModTags.Items.STICKS)
                .unlockedBy(getHasName(ModBlocks.MARIKA_OAK_LOG.get()), has(ModBlocks.MARIKA_OAK_LOG.get()))
                .save(consumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.CRYSTAL_CORE_LAMP_G.get())
                .pattern("TTT")
                .pattern("IRI")
                .pattern("TTT")
                .define('R', Blocks.REDSTONE_LAMP)
                .define('T', ModItems.TIBERIUM.get())
                .define('I', ModItems.ILLUMINA_CRYSTAL.get())
                .unlockedBy(getHasName(ModItems.TIBERIUM.get()), has(ModItems.TIBERIUM.get()))
                .save(consumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.TIBERIUM_INFUSER.get())
                .pattern("AIA")
                .pattern("KRK")
                .pattern("GKG")
                .define('R', Blocks.REDSTONE_BLOCK)
                .define('G', ModBlocks.GUNDANIUM_BLOCK.get())
                .define('A', ModItems.ALYTHUM_INGOT.get())
                .define('I', ModItems.ILLUMINA_CRYSTAL.get())
                .define('K', ModItems.KRYON_CRYSTAL.get())
                .unlockedBy(getHasName(ModItems.TIBERIUM.get()), has(ModItems.TIBERIUM.get()))
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

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModBlocks.PLAGUED_BUTTON.get(), 1)
                .requires(ModBlocks.PLAGUED_PLANKS.get())
                .unlockedBy(getHasName(ModBlocks.PLAGUED_PLANKS.get()), has(ModBlocks.PLAGUED_PLANKS.get()))
                .save(consumer);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModBlocks.DEAD_BUTTON.get(), 1)
                .requires(ModBlocks.DEAD_PLANKS.get())
                .unlockedBy(getHasName(ModBlocks.DEAD_PLANKS.get()), has(ModBlocks.DEAD_PLANKS.get()))
                .save(consumer);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModBlocks.EMBER_OAK_BUTTON.get(), 1)
                .requires(ModBlocks.EMBER_OAK_PLANKS.get())
                .unlockedBy(getHasName(ModBlocks.EMBER_OAK_PLANKS.get()), has(ModBlocks.EMBER_OAK_PLANKS.get()))
                .save(consumer);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModBlocks.MARIKA_OAK_BUTTON.get(), 1)
                .requires(ModBlocks.MARIKA_OAK_PLANKS.get())
                .unlockedBy(getHasName(ModBlocks.MARIKA_OAK_PLANKS.get()), has(ModBlocks.MARIKA_OAK_PLANKS.get()))
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

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModBlocks.PLAGUED_PLANKS.get(), 4)
                .requires(ModTags.Items.PLAGUED_LOGS)
                .unlockedBy(getHasName(ModBlocks.PLAGUED_LOG.get()), has(ModBlocks.PLAGUED_LOG.get()))
                .save(consumer);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModBlocks.EMBER_OAK_PLANKS.get(), 4)
                .requires(ModTags.Items.EMBER_OAK_LOGS)
                .unlockedBy(getHasName(ModBlocks.EMBER_OAK_LOG.get()), has(ModBlocks.EMBER_OAK_LOG.get()))
                .save(consumer);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModBlocks.DEAD_PLANKS.get(), 4)
                .requires(ModTags.Items.DEAD_LOGS)
                .unlockedBy(getHasName(ModBlocks.DEAD_LOG.get()), has(ModBlocks.DEAD_LOG.get()))
                .save(consumer);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModBlocks.MARIKA_OAK_PLANKS.get(), 4)
                .requires(ModTags.Items.MARIKA_OAK_LOGS)
                .unlockedBy(getHasName(ModBlocks.MARIKA_OAK_LOG.get()), has(ModBlocks.MARIKA_OAK_LOG.get()))
                .save(consumer);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.LAI_MELON_SLICE.get(), 9)
                .requires(ModBlocks.LAI_MELON.get())
                .unlockedBy(getHasName(ModBlocks.LAI_MELON.get()), has(ModBlocks.LAI_MELON.get()))
                .save(consumer);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.LAI_MELON_SEEDS.get(), 1)
                .requires(ModItems.LAI_MELON_SLICE.get())
                .unlockedBy(getHasName(ModBlocks.LAI_MELON.get()), has(ModBlocks.LAI_MELON.get()))
                .save(consumer);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.SABER_CORN_SEEDS.get(), 1)
                .requires(ModItems.SABER_CORN.get())
                .unlockedBy(getHasName(ModItems.SABER_CORN.get()), has(ModItems.SABER_CORN.get()))
                .save(consumer);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.HEIM_BERRY_SEEDS.get(), 1)
                .requires(ModItems.HEIM_BERRY.get())
                .unlockedBy(getHasName(ModItems.HEIM_BERRY.get()), has(ModItems.HEIM_BERRY.get()))
                .save(consumer);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.HEL_FRUIT_SEEDS.get(), 1)
                .requires(ModItems.HEL_FRUIT.get())
                .unlockedBy(getHasName(ModItems.HEL_FRUIT.get()), has(ModItems.HEL_FRUIT.get()))
                .save(consumer);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.ILLYRIM_BLEND.get(), 1)
                .requires(ModItems.GUNDANIUM_DUST.get(),2)
                .requires(ModItems.ALYTHUM_DUST.get(),2)
                .requires(ModItems.QUALRIM_COMPOUND.get())
                .unlockedBy(getHasName(ModItems.QUALRIM_COMPOUND.get()), has(ModItems.QUALRIM_COMPOUND.get()))
                .save(consumer);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.LG_CORE_BLEND.get(), 1)
                .requires(ModItems.GUNDANIUM_DUST.get())
                .requires(ModItems.ILLYRIM_BLEND.get())
                .requires(ModItems.ALYTHUM_DUST.get())
                .requires(ModItems.GREEN_TIBERIUM_DUST.get())
                .requires(ModItems.BLUE_TIBERIUM_DUST.get())
                .unlockedBy(getHasName(ModItems.ILLYRIM_BLEND.get()), has(ModItems.ILLYRIM_BLEND.get()))
                .save(consumer);


    //Stonecutter:

        stonecutterResultFromBase(consumer, RecipeCategory.MISC, ModBlocks.PLAGUED_ANDESITE_SLAB.get(), ModBlocks.INFESTED_ANDESITE.get(), 2);
        stonecutterResultFromBase(consumer, RecipeCategory.MISC, ModBlocks.PLAGUED_ANDESITE_STAIRS.get(), ModBlocks.INFESTED_ANDESITE.get());
        stonecutterResultFromBase(consumer, RecipeCategory.MISC, ModBlocks.PLAGUED_ANDESITE_WALL.get(), ModBlocks.INFESTED_ANDESITE.get());
        stonecutterResultFromBase(consumer, RecipeCategory.MISC, ModBlocks.PLAGUED_STONE_SLAB.get(), ModBlocks.INFESTED_STONE.get(), 2);
        stonecutterResultFromBase(consumer, RecipeCategory.MISC, ModBlocks.PLAGUED_STONE_STAIRS.get(), ModBlocks.INFESTED_STONE.get());
        stonecutterResultFromBase(consumer, RecipeCategory.MISC, ModBlocks.PLAGUED_STONE_WALL.get(), ModBlocks.INFESTED_STONE.get());
        stonecutterResultFromBase(consumer, RecipeCategory.MISC, ModBlocks.PLAGUED_GRANITE_SLAB.get(), ModBlocks.INFESTED_GRANITE.get(), 2);
        stonecutterResultFromBase(consumer, RecipeCategory.MISC, ModBlocks.PLAGUED_GRANITE_STAIRS.get(), ModBlocks.INFESTED_GRANITE.get());
        stonecutterResultFromBase(consumer, RecipeCategory.MISC, ModBlocks.PLAGUED_GRANITE_WALL.get(), ModBlocks.INFESTED_GRANITE.get());
        stonecutterResultFromBase(consumer, RecipeCategory.MISC, ModBlocks.PLAGUED_DIORITE_SLAB.get(), ModBlocks.INFESTED_DIORITE.get(), 2);
        stonecutterResultFromBase(consumer, RecipeCategory.MISC, ModBlocks.PLAGUED_DIORITE_STAIRS.get(), ModBlocks.INFESTED_DIORITE.get());
        stonecutterResultFromBase(consumer, RecipeCategory.MISC, ModBlocks.PLAGUED_DIORITE_WALL.get(), ModBlocks.INFESTED_DIORITE.get());

        stonecutterResultFromBase(consumer, RecipeCategory.MISC, ModBlocks.RIPARIUS_STONE_SLAB.get(), ModBlocks.RIPARIUS_STONE.get(), 2);
        stonecutterResultFromBase(consumer, RecipeCategory.MISC, ModBlocks.RIPARIUS_STONE_STAIRS.get(), ModBlocks.RIPARIUS_STONE.get());
        stonecutterResultFromBase(consumer, RecipeCategory.MISC, ModBlocks.RIPARIUS_STONE_WALL.get(), ModBlocks.RIPARIUS_STONE.get());
        stonecutterResultFromBase(consumer, RecipeCategory.MISC, ModBlocks.RIPARIUS_STONE_BRICKS.get(), ModBlocks.RIPARIUS_STONE.get());
        stonecutterResultFromBase(consumer, RecipeCategory.MISC, ModBlocks.RIPARIUS_STONE.get(), ModBlocks.RIPARIUS_STONE_BRICKS.get());
        stonecutterResultFromBase(consumer, RecipeCategory.MISC, ModBlocks.RIPARIUS_STONE_BRICK_SLAB.get(), ModBlocks.RIPARIUS_STONE.get(), 2);
        stonecutterResultFromBase(consumer, RecipeCategory.MISC, ModBlocks.RIPARIUS_STONE_BRICK_STAIRS.get(), ModBlocks.RIPARIUS_STONE.get());
        stonecutterResultFromBase(consumer, RecipeCategory.MISC, ModBlocks.RIPARIUS_STONE_BRICK_WALL.get(), ModBlocks.RIPARIUS_STONE.get());
        stonecutterResultFromBase(consumer, RecipeCategory.MISC, ModBlocks.RIPARIUS_STONE_BRICK_SLAB.get(), ModBlocks.RIPARIUS_STONE_BRICKS.get(), 2);
        stonecutterResultFromBase(consumer, RecipeCategory.MISC, ModBlocks.RIPARIUS_STONE_BRICK_STAIRS.get(), ModBlocks.RIPARIUS_STONE_BRICKS.get());
        stonecutterResultFromBase(consumer, RecipeCategory.MISC, ModBlocks.RIPARIUS_STONE_BRICK_WALL.get(), ModBlocks.RIPARIUS_STONE_BRICKS.get());

        stonecutterResultFromBase(consumer, RecipeCategory.MISC, ModBlocks.VINIFERA_STONE_SLAB.get(), ModBlocks.VINIFERA_STONE.get(), 2);
        stonecutterResultFromBase(consumer, RecipeCategory.MISC, ModBlocks.VINIFERA_STONE_STAIRS.get(), ModBlocks.VINIFERA_STONE.get());
        stonecutterResultFromBase(consumer, RecipeCategory.MISC, ModBlocks.VINIFERA_STONE_WALL.get(), ModBlocks.VINIFERA_STONE.get());
        stonecutterResultFromBase(consumer, RecipeCategory.MISC, ModBlocks.VINIFERA_STONE_BRICKS.get(), ModBlocks.VINIFERA_STONE.get());
        stonecutterResultFromBase(consumer, RecipeCategory.MISC, ModBlocks.VINIFERA_STONE.get(), ModBlocks.VINIFERA_STONE_BRICKS.get());
        stonecutterResultFromBase(consumer, RecipeCategory.MISC, ModBlocks.VINIFERA_STONE_BRICK_SLAB.get(), ModBlocks.VINIFERA_STONE.get(), 2);
        stonecutterResultFromBase(consumer, RecipeCategory.MISC, ModBlocks.VINIFERA_STONE_BRICK_STAIRS.get(), ModBlocks.VINIFERA_STONE.get());
        stonecutterResultFromBase(consumer, RecipeCategory.MISC, ModBlocks.VINIFERA_STONE_BRICK_WALL.get(), ModBlocks.VINIFERA_STONE.get());
        stonecutterResultFromBase(consumer, RecipeCategory.MISC, ModBlocks.VINIFERA_STONE_BRICK_SLAB.get(), ModBlocks.VINIFERA_STONE_BRICKS.get(), 2);
        stonecutterResultFromBase(consumer, RecipeCategory.MISC, ModBlocks.VINIFERA_STONE_BRICK_STAIRS.get(), ModBlocks.VINIFERA_STONE_BRICKS.get());
        stonecutterResultFromBase(consumer, RecipeCategory.MISC, ModBlocks.VINIFERA_STONE_BRICK_WALL.get(), ModBlocks.VINIFERA_STONE_BRICKS.get());

        stonecutterResultFromBase(consumer, RecipeCategory.MISC, ModBlocks.CRUENTUS_STONE_SLAB.get(), ModBlocks.CRUENTUS_STONE.get(), 2);
        stonecutterResultFromBase(consumer, RecipeCategory.MISC, ModBlocks.CRUENTUS_STONE_STAIRS.get(), ModBlocks.CRUENTUS_STONE.get());
        stonecutterResultFromBase(consumer, RecipeCategory.MISC, ModBlocks.CRUENTUS_STONE_WALL.get(), ModBlocks.CRUENTUS_STONE.get());
        stonecutterResultFromBase(consumer, RecipeCategory.MISC, ModBlocks.CRUENTUS_STONE_BRICKS.get(), ModBlocks.CRUENTUS_STONE.get());
        stonecutterResultFromBase(consumer, RecipeCategory.MISC, ModBlocks.CRUENTUS_STONE.get(), ModBlocks.CRUENTUS_STONE_BRICKS.get());
        stonecutterResultFromBase(consumer, RecipeCategory.MISC, ModBlocks.CRUENTUS_STONE_BRICK_SLAB.get(), ModBlocks.CRUENTUS_STONE.get(), 2);
        stonecutterResultFromBase(consumer, RecipeCategory.MISC, ModBlocks.CRUENTUS_STONE_BRICK_STAIRS.get(), ModBlocks.CRUENTUS_STONE.get());
        stonecutterResultFromBase(consumer, RecipeCategory.MISC, ModBlocks.CRUENTUS_STONE_BRICK_WALL.get(), ModBlocks.CRUENTUS_STONE.get());
        stonecutterResultFromBase(consumer, RecipeCategory.MISC, ModBlocks.CRUENTUS_STONE_BRICK_SLAB.get(), ModBlocks.CRUENTUS_STONE_BRICKS.get(), 2);
        stonecutterResultFromBase(consumer, RecipeCategory.MISC, ModBlocks.CRUENTUS_STONE_BRICK_STAIRS.get(), ModBlocks.CRUENTUS_STONE_BRICKS.get());
        stonecutterResultFromBase(consumer, RecipeCategory.MISC, ModBlocks.CRUENTUS_STONE_BRICK_WALL.get(), ModBlocks.CRUENTUS_STONE_BRICKS.get());

        stonecutterResultFromBase(consumer, RecipeCategory.MISC, ModBlocks.ABOREUS_STONE_SLAB.get(), ModBlocks.ABOREUS_STONE.get(), 2);
        stonecutterResultFromBase(consumer, RecipeCategory.MISC, ModBlocks.ABOREUS_STONE_STAIRS.get(), ModBlocks.ABOREUS_STONE.get());
        stonecutterResultFromBase(consumer, RecipeCategory.MISC, ModBlocks.ABOREUS_STONE_WALL.get(), ModBlocks.ABOREUS_STONE.get());
        stonecutterResultFromBase(consumer, RecipeCategory.MISC, ModBlocks.ABOREUS_STONE_BRICKS.get(), ModBlocks.ABOREUS_STONE.get());
        stonecutterResultFromBase(consumer, RecipeCategory.MISC, ModBlocks.ABOREUS_STONE.get(), ModBlocks.ABOREUS_STONE_BRICKS.get());
        stonecutterResultFromBase(consumer, RecipeCategory.MISC, ModBlocks.ABOREUS_STONE_BRICK_SLAB.get(), ModBlocks.ABOREUS_STONE.get(), 2);
        stonecutterResultFromBase(consumer, RecipeCategory.MISC, ModBlocks.ABOREUS_STONE_BRICK_STAIRS.get(), ModBlocks.ABOREUS_STONE.get());
        stonecutterResultFromBase(consumer, RecipeCategory.MISC, ModBlocks.ABOREUS_STONE_BRICK_WALL.get(), ModBlocks.ABOREUS_STONE.get());
        stonecutterResultFromBase(consumer, RecipeCategory.MISC, ModBlocks.ABOREUS_STONE_BRICK_SLAB.get(), ModBlocks.ABOREUS_STONE_BRICKS.get(), 2);
        stonecutterResultFromBase(consumer, RecipeCategory.MISC, ModBlocks.ABOREUS_STONE_BRICK_STAIRS.get(), ModBlocks.ABOREUS_STONE_BRICKS.get());
        stonecutterResultFromBase(consumer, RecipeCategory.MISC, ModBlocks.ABOREUS_STONE_BRICK_WALL.get(), ModBlocks.ABOREUS_STONE_BRICKS.get());

        stonecutterResultFromBase(consumer, RecipeCategory.MISC, ModBlocks.RIPARIUS_CRYSTAL_SLAB.get(), ModBlocks.RIPARIUS_CRYSTAL.get(), 2);
        stonecutterResultFromBase(consumer, RecipeCategory.MISC, ModBlocks.RIPARIUS_CRYSTAL_STAIRS.get(), ModBlocks.RIPARIUS_CRYSTAL.get());
        stonecutterResultFromBase(consumer, RecipeCategory.MISC, ModBlocks.RIPARIUS_CRYSTAL_WALL.get(), ModBlocks.RIPARIUS_CRYSTAL.get());
        stonecutterResultFromBase(consumer, RecipeCategory.MISC, ModBlocks.VINIFERA_CRYSTAL_SLAB.get(), ModBlocks.VINIFERA_CRYSTAL.get(), 2);
        stonecutterResultFromBase(consumer, RecipeCategory.MISC, ModBlocks.VINIFERA_CRYSTAL_STAIRS.get(), ModBlocks.VINIFERA_CRYSTAL.get());
        stonecutterResultFromBase(consumer, RecipeCategory.MISC, ModBlocks.VINIFERA_CRYSTAL_WALL.get(), ModBlocks.VINIFERA_CRYSTAL.get());
        stonecutterResultFromBase(consumer, RecipeCategory.MISC, ModBlocks.CRUENTUS_CRYSTAL_SLAB.get(), ModBlocks.CRUENTUS_CRYSTAL.get(), 2);
        stonecutterResultFromBase(consumer, RecipeCategory.MISC, ModBlocks.CRUENTUS_CRYSTAL_STAIRS.get(), ModBlocks.CRUENTUS_CRYSTAL.get());
        stonecutterResultFromBase(consumer, RecipeCategory.MISC, ModBlocks.CRUENTUS_CRYSTAL_WALL.get(), ModBlocks.CRUENTUS_CRYSTAL.get());
        stonecutterResultFromBase(consumer, RecipeCategory.MISC, ModBlocks.ABOREUS_CRYSTAL_SLAB.get(), ModBlocks.ABOREUS_CRYSTAL.get(), 2);
        stonecutterResultFromBase(consumer, RecipeCategory.MISC, ModBlocks.ABOREUS_CRYSTAL_STAIRS.get(), ModBlocks.ABOREUS_CRYSTAL.get());
        stonecutterResultFromBase(consumer, RecipeCategory.MISC, ModBlocks.ABOREUS_CRYSTAL_WALL.get(), ModBlocks.ABOREUS_CRYSTAL.get());

        stonecutterResultFromBase(consumer, RecipeCategory.MISC, ModBlocks.INFESTED_STONE_BRICKS.get(), ModBlocks.INFESTED_COBBLE.get());
        stonecutterResultFromBase(consumer, RecipeCategory.MISC, ModBlocks.INFESTED_STONE_BRICKS.get(), ModBlocks.INFESTED_STONE.get());
        stonecutterResultFromBase(consumer, RecipeCategory.MISC, ModBlocks.INFESTED_STONE.get(), ModBlocks.INFESTED_COBBLE.get());
        stonecutterResultFromBase(consumer, RecipeCategory.MISC, ModBlocks.INFESTED_STONE.get(), ModBlocks.INFESTED_STONE_BRICKS.get());
        stonecutterResultFromBase(consumer, RecipeCategory.MISC, ModBlocks.INFESTED_COBBLE.get(), ModBlocks.INFESTED_STONE_BRICKS.get());
        stonecutterResultFromBase(consumer, RecipeCategory.MISC, ModBlocks.INFESTED_COBBLE.get(), ModBlocks.INFESTED_STONE.get());
        stonecutterResultFromBase(consumer, RecipeCategory.MISC, ModBlocks.INFESTED_COBBLE_SLAB.get(), ModBlocks.INFESTED_STONE.get(),2);
        stonecutterResultFromBase(consumer, RecipeCategory.MISC, ModBlocks.INFESTED_COBBLE_SLAB.get(), ModBlocks.INFESTED_COBBLE.get(),2);
        stonecutterResultFromBase(consumer, RecipeCategory.MISC, ModBlocks.INFESTED_COBBLE_SLAB.get(), ModBlocks.INFESTED_STONE_BRICKS.get(),2);
        stonecutterResultFromBase(consumer, RecipeCategory.MISC, ModBlocks.INFESTED_STONE_BRICK_SLAB.get(), ModBlocks.INFESTED_STONE.get(), 2);
        stonecutterResultFromBase(consumer, RecipeCategory.MISC, ModBlocks.INFESTED_STONE_BRICK_SLAB.get(), ModBlocks.INFESTED_COBBLE.get(), 2);
        stonecutterResultFromBase(consumer, RecipeCategory.MISC, ModBlocks.INFESTED_STONE_BRICK_SLAB.get(), ModBlocks.INFESTED_STONE_BRICKS.get(), 2);
        stonecutterResultFromBase(consumer, RecipeCategory.MISC, ModBlocks.INFESTED_COBBLE_STAIRS.get(), ModBlocks.INFESTED_STONE.get());
        stonecutterResultFromBase(consumer, RecipeCategory.MISC, ModBlocks.INFESTED_COBBLE_STAIRS.get(), ModBlocks.INFESTED_COBBLE.get());
        stonecutterResultFromBase(consumer, RecipeCategory.MISC, ModBlocks.INFESTED_COBBLE_STAIRS.get(), ModBlocks.INFESTED_STONE_BRICKS.get());
        stonecutterResultFromBase(consumer, RecipeCategory.MISC, ModBlocks.INFESTED_STONE_BRICK_STAIRS.get(), ModBlocks.INFESTED_STONE.get());
        stonecutterResultFromBase(consumer, RecipeCategory.MISC, ModBlocks.INFESTED_STONE_BRICK_STAIRS.get(), ModBlocks.INFESTED_COBBLE.get());
        stonecutterResultFromBase(consumer, RecipeCategory.MISC, ModBlocks.INFESTED_STONE_BRICK_STAIRS.get(), ModBlocks.INFESTED_STONE_BRICKS.get());
        stonecutterResultFromBase(consumer, RecipeCategory.MISC, ModBlocks.INFESTED_STONE_BRICK_WALL.get(), ModBlocks.INFESTED_STONE.get());
        stonecutterResultFromBase(consumer, RecipeCategory.MISC, ModBlocks.INFESTED_STONE_BRICK_WALL.get(), ModBlocks.INFESTED_COBBLE.get());
        stonecutterResultFromBase(consumer, RecipeCategory.MISC, ModBlocks.INFESTED_STONE_BRICK_WALL.get(), ModBlocks.INFESTED_STONE_BRICKS.get());
        stonecutterResultFromBase(consumer, RecipeCategory.MISC, ModBlocks.INFESTED_COBBLE_WALL.get(), ModBlocks.INFESTED_STONE.get());
        stonecutterResultFromBase(consumer, RecipeCategory.MISC, ModBlocks.INFESTED_COBBLE_WALL.get(), ModBlocks.INFESTED_COBBLE.get());
        stonecutterResultFromBase(consumer, RecipeCategory.MISC, ModBlocks.INFESTED_COBBLE_WALL.get(), ModBlocks.INFESTED_STONE_BRICKS.get());

        stonecutterResultFromBase(consumer, RecipeCategory.MISC, ModBlocks.BLACK_TIBERCRETE_STAIRS.get(), ModBlocks.BLACK_TIBERCRETE.get());
        stonecutterResultFromBase(consumer, RecipeCategory.MISC, ModBlocks.BLUE_TIBERCRETE_STAIRS.get(), ModBlocks.BLUE_TIBERCRETE.get());
        stonecutterResultFromBase(consumer, RecipeCategory.MISC, ModBlocks.BROWN_TIBERCRETE_STAIRS.get(), ModBlocks.BROWN_TIBERCRETE.get());
        stonecutterResultFromBase(consumer, RecipeCategory.MISC, ModBlocks.CYAN_TIBERCRETE_STAIRS.get(), ModBlocks.CYAN_TIBERCRETE.get());
        stonecutterResultFromBase(consumer, RecipeCategory.MISC, ModBlocks.GRAY_TIBERCRETE_STAIRS.get(), ModBlocks.GRAY_TIBERCRETE.get());
        stonecutterResultFromBase(consumer, RecipeCategory.MISC, ModBlocks.GREEN_TIBERCRETE_STAIRS.get(), ModBlocks.GREEN_TIBERCRETE.get());
        stonecutterResultFromBase(consumer, RecipeCategory.MISC, ModBlocks.LIGHT_BLUE_TIBERCRETE_STAIRS.get(), ModBlocks.LIGHT_BLUE_TIBERCRETE.get());
        stonecutterResultFromBase(consumer, RecipeCategory.MISC, ModBlocks.LIGHT_GRAY_TIBERCRETE_STAIRS.get(), ModBlocks.LIGHT_GRAY_TIBERCRETE.get());
        stonecutterResultFromBase(consumer, RecipeCategory.MISC, ModBlocks.LIME_TIBERCRETE_STAIRS.get(), ModBlocks.LIME_TIBERCRETE.get());
        stonecutterResultFromBase(consumer, RecipeCategory.MISC, ModBlocks.MAGENTA_TIBERCRETE_STAIRS.get(), ModBlocks.MAGENTA_TIBERCRETE.get());
        stonecutterResultFromBase(consumer, RecipeCategory.MISC, ModBlocks.ORANGE_TIBERCRETE_STAIRS.get(), ModBlocks.ORANGE_TIBERCRETE.get());
        stonecutterResultFromBase(consumer, RecipeCategory.MISC, ModBlocks.PINK_TIBERCRETE_STAIRS.get(), ModBlocks.PINK_TIBERCRETE.get());
        stonecutterResultFromBase(consumer, RecipeCategory.MISC, ModBlocks.PURPLE_TIBERCRETE_STAIRS.get(), ModBlocks.PURPLE_TIBERCRETE.get());
        stonecutterResultFromBase(consumer, RecipeCategory.MISC, ModBlocks.RED_TIBERCRETE_STAIRS.get(), ModBlocks.RED_TIBERCRETE.get());
        stonecutterResultFromBase(consumer, RecipeCategory.MISC, ModBlocks.WHITE_TIBERCRETE_STAIRS.get(), ModBlocks.WHITE_TIBERCRETE.get());
        stonecutterResultFromBase(consumer, RecipeCategory.MISC, ModBlocks.YELLOW_TIBERCRETE_STAIRS.get(), ModBlocks.YELLOW_TIBERCRETE.get());
        stonecutterResultFromBase(consumer, RecipeCategory.MISC, ModBlocks.BLACK_TIBERCRETE.get(), ModBlocks.BLACK_TIBERCRETE_BRICKS.get());
        stonecutterResultFromBase(consumer, RecipeCategory.MISC, ModBlocks.BLUE_TIBERCRETE.get(), ModBlocks.BLUE_TIBERCRETE_BRICKS.get());
        stonecutterResultFromBase(consumer, RecipeCategory.MISC, ModBlocks.BROWN_TIBERCRETE.get(), ModBlocks.BROWN_TIBERCRETE_BRICKS.get());
        stonecutterResultFromBase(consumer, RecipeCategory.MISC, ModBlocks.CYAN_TIBERCRETE.get(), ModBlocks.CYAN_TIBERCRETE_BRICKS.get());
        stonecutterResultFromBase(consumer, RecipeCategory.MISC, ModBlocks.GRAY_TIBERCRETE.get(), ModBlocks.GRAY_TIBERCRETE_BRICKS.get());
        stonecutterResultFromBase(consumer, RecipeCategory.MISC, ModBlocks.GREEN_TIBERCRETE.get(), ModBlocks.GREEN_TIBERCRETE_BRICKS.get());
        stonecutterResultFromBase(consumer, RecipeCategory.MISC, ModBlocks.LIGHT_BLUE_TIBERCRETE.get(), ModBlocks.LIGHT_BLUE_TIBERCRETE_BRICKS.get());
        stonecutterResultFromBase(consumer, RecipeCategory.MISC, ModBlocks.LIGHT_GRAY_TIBERCRETE.get(), ModBlocks.LIGHT_GRAY_TIBERCRETE_BRICKS.get());
        stonecutterResultFromBase(consumer, RecipeCategory.MISC, ModBlocks.LIME_TIBERCRETE.get(), ModBlocks.LIME_TIBERCRETE_BRICKS.get());
        stonecutterResultFromBase(consumer, RecipeCategory.MISC, ModBlocks.MAGENTA_TIBERCRETE.get(), ModBlocks.MAGENTA_TIBERCRETE_BRICKS.get());
        stonecutterResultFromBase(consumer, RecipeCategory.MISC, ModBlocks.ORANGE_TIBERCRETE.get(), ModBlocks.ORANGE_TIBERCRETE_BRICKS.get());
        stonecutterResultFromBase(consumer, RecipeCategory.MISC, ModBlocks.PINK_TIBERCRETE.get(), ModBlocks.PINK_TIBERCRETE_BRICKS.get());
        stonecutterResultFromBase(consumer, RecipeCategory.MISC, ModBlocks.PURPLE_TIBERCRETE.get(), ModBlocks.PURPLE_TIBERCRETE_BRICKS.get());
        stonecutterResultFromBase(consumer, RecipeCategory.MISC, ModBlocks.RED_TIBERCRETE.get(), ModBlocks.RED_TIBERCRETE_BRICKS.get());
        stonecutterResultFromBase(consumer, RecipeCategory.MISC, ModBlocks.WHITE_TIBERCRETE.get(), ModBlocks.WHITE_TIBERCRETE_BRICKS.get());
        stonecutterResultFromBase(consumer, RecipeCategory.MISC, ModBlocks.YELLOW_TIBERCRETE.get(), ModBlocks.YELLOW_TIBERCRETE_BRICKS.get());
        stonecutterResultFromBase(consumer, RecipeCategory.MISC, ModBlocks.BLACK_TIBERCRETE_STAIRS.get(), ModBlocks.BLACK_TIBERCRETE_BRICKS.get());
        stonecutterResultFromBase(consumer, RecipeCategory.MISC, ModBlocks.BLUE_TIBERCRETE_STAIRS.get(), ModBlocks.BLUE_TIBERCRETE_BRICKS.get());
        stonecutterResultFromBase(consumer, RecipeCategory.MISC, ModBlocks.BROWN_TIBERCRETE_STAIRS.get(), ModBlocks.BROWN_TIBERCRETE_BRICKS.get());
        stonecutterResultFromBase(consumer, RecipeCategory.MISC, ModBlocks.CYAN_TIBERCRETE_STAIRS.get(), ModBlocks.CYAN_TIBERCRETE_BRICKS.get());
        stonecutterResultFromBase(consumer, RecipeCategory.MISC, ModBlocks.GRAY_TIBERCRETE_STAIRS.get(), ModBlocks.GRAY_TIBERCRETE_BRICKS.get());
        stonecutterResultFromBase(consumer, RecipeCategory.MISC, ModBlocks.GREEN_TIBERCRETE_STAIRS.get(), ModBlocks.GREEN_TIBERCRETE_BRICKS.get());
        stonecutterResultFromBase(consumer, RecipeCategory.MISC, ModBlocks.LIGHT_BLUE_TIBERCRETE_STAIRS.get(), ModBlocks.LIGHT_BLUE_TIBERCRETE_BRICKS.get());
        stonecutterResultFromBase(consumer, RecipeCategory.MISC, ModBlocks.LIGHT_GRAY_TIBERCRETE_STAIRS.get(), ModBlocks.LIGHT_GRAY_TIBERCRETE_BRICKS.get());
        stonecutterResultFromBase(consumer, RecipeCategory.MISC, ModBlocks.LIME_TIBERCRETE_STAIRS.get(), ModBlocks.LIME_TIBERCRETE_BRICKS.get());
        stonecutterResultFromBase(consumer, RecipeCategory.MISC, ModBlocks.MAGENTA_TIBERCRETE_STAIRS.get(), ModBlocks.MAGENTA_TIBERCRETE_BRICKS.get());
        stonecutterResultFromBase(consumer, RecipeCategory.MISC, ModBlocks.ORANGE_TIBERCRETE_STAIRS.get(), ModBlocks.ORANGE_TIBERCRETE_BRICKS.get());
        stonecutterResultFromBase(consumer, RecipeCategory.MISC, ModBlocks.PINK_TIBERCRETE_STAIRS.get(), ModBlocks.PINK_TIBERCRETE_BRICKS.get());
        stonecutterResultFromBase(consumer, RecipeCategory.MISC, ModBlocks.PURPLE_TIBERCRETE_STAIRS.get(), ModBlocks.PURPLE_TIBERCRETE_BRICKS.get());
        stonecutterResultFromBase(consumer, RecipeCategory.MISC, ModBlocks.RED_TIBERCRETE_STAIRS.get(), ModBlocks.RED_TIBERCRETE_BRICKS.get());
        stonecutterResultFromBase(consumer, RecipeCategory.MISC, ModBlocks.WHITE_TIBERCRETE_STAIRS.get(), ModBlocks.WHITE_TIBERCRETE_BRICKS.get());
        stonecutterResultFromBase(consumer, RecipeCategory.MISC, ModBlocks.YELLOW_TIBERCRETE_STAIRS.get(), ModBlocks.YELLOW_TIBERCRETE_BRICKS.get());
        stonecutterResultFromBase(consumer, RecipeCategory.MISC, ModBlocks.BLACK_TIBERCRETE_BRICK_STAIRS.get(), ModBlocks.BLACK_TIBERCRETE_BRICKS.get());
        stonecutterResultFromBase(consumer, RecipeCategory.MISC, ModBlocks.BLUE_TIBERCRETE_BRICK_STAIRS.get(), ModBlocks.BLUE_TIBERCRETE_BRICKS.get());
        stonecutterResultFromBase(consumer, RecipeCategory.MISC, ModBlocks.BROWN_TIBERCRETE_BRICK_STAIRS.get(), ModBlocks.BROWN_TIBERCRETE_BRICKS.get());
        stonecutterResultFromBase(consumer, RecipeCategory.MISC, ModBlocks.CYAN_TIBERCRETE_BRICK_STAIRS.get(), ModBlocks.CYAN_TIBERCRETE_BRICKS.get());
        stonecutterResultFromBase(consumer, RecipeCategory.MISC, ModBlocks.GRAY_TIBERCRETE_BRICK_STAIRS.get(), ModBlocks.GRAY_TIBERCRETE_BRICKS.get());
        stonecutterResultFromBase(consumer, RecipeCategory.MISC, ModBlocks.GREEN_TIBERCRETE_BRICK_STAIRS.get(), ModBlocks.GREEN_TIBERCRETE_BRICKS.get());
        stonecutterResultFromBase(consumer, RecipeCategory.MISC, ModBlocks.LIGHT_BLUE_TIBERCRETE_BRICK_STAIRS.get(), ModBlocks.LIGHT_BLUE_TIBERCRETE_BRICKS.get());
        stonecutterResultFromBase(consumer, RecipeCategory.MISC, ModBlocks.LIGHT_GRAY_TIBERCRETE_BRICK_STAIRS.get(), ModBlocks.LIGHT_GRAY_TIBERCRETE_BRICKS.get());
        stonecutterResultFromBase(consumer, RecipeCategory.MISC, ModBlocks.LIME_TIBERCRETE_BRICK_STAIRS.get(), ModBlocks.LIME_TIBERCRETE_BRICKS.get());
        stonecutterResultFromBase(consumer, RecipeCategory.MISC, ModBlocks.MAGENTA_TIBERCRETE_BRICK_STAIRS.get(), ModBlocks.MAGENTA_TIBERCRETE_BRICKS.get());
        stonecutterResultFromBase(consumer, RecipeCategory.MISC, ModBlocks.ORANGE_TIBERCRETE_BRICK_STAIRS.get(), ModBlocks.ORANGE_TIBERCRETE_BRICKS.get());
        stonecutterResultFromBase(consumer, RecipeCategory.MISC, ModBlocks.PINK_TIBERCRETE_BRICK_STAIRS.get(), ModBlocks.PINK_TIBERCRETE_BRICKS.get());
        stonecutterResultFromBase(consumer, RecipeCategory.MISC, ModBlocks.PURPLE_TIBERCRETE_BRICK_STAIRS.get(), ModBlocks.PURPLE_TIBERCRETE_BRICKS.get());
        stonecutterResultFromBase(consumer, RecipeCategory.MISC, ModBlocks.RED_TIBERCRETE_BRICK_STAIRS.get(), ModBlocks.RED_TIBERCRETE_BRICKS.get());
        stonecutterResultFromBase(consumer, RecipeCategory.MISC, ModBlocks.WHITE_TIBERCRETE_BRICK_STAIRS.get(), ModBlocks.WHITE_TIBERCRETE_BRICKS.get());
        stonecutterResultFromBase(consumer, RecipeCategory.MISC, ModBlocks.YELLOW_TIBERCRETE_BRICK_STAIRS.get(), ModBlocks.YELLOW_TIBERCRETE_BRICKS.get());
        stonecutterResultFromBase(consumer, RecipeCategory.MISC, ModBlocks.BLACK_TIBERCRETE_BRICK_STAIRS.get(), ModBlocks.BLACK_TIBERCRETE.get());
        stonecutterResultFromBase(consumer, RecipeCategory.MISC, ModBlocks.BLUE_TIBERCRETE_BRICK_STAIRS.get(), ModBlocks.BLUE_TIBERCRETE.get());
        stonecutterResultFromBase(consumer, RecipeCategory.MISC, ModBlocks.BROWN_TIBERCRETE_BRICK_STAIRS.get(), ModBlocks.BROWN_TIBERCRETE.get());
        stonecutterResultFromBase(consumer, RecipeCategory.MISC, ModBlocks.CYAN_TIBERCRETE_BRICK_STAIRS.get(), ModBlocks.CYAN_TIBERCRETE.get());
        stonecutterResultFromBase(consumer, RecipeCategory.MISC, ModBlocks.GRAY_TIBERCRETE_BRICK_STAIRS.get(), ModBlocks.GRAY_TIBERCRETE.get());
        stonecutterResultFromBase(consumer, RecipeCategory.MISC, ModBlocks.GREEN_TIBERCRETE_BRICK_STAIRS.get(), ModBlocks.GREEN_TIBERCRETE.get());
        stonecutterResultFromBase(consumer, RecipeCategory.MISC, ModBlocks.LIGHT_BLUE_TIBERCRETE_BRICK_STAIRS.get(), ModBlocks.LIGHT_BLUE_TIBERCRETE.get());
        stonecutterResultFromBase(consumer, RecipeCategory.MISC, ModBlocks.LIGHT_GRAY_TIBERCRETE_BRICK_STAIRS.get(), ModBlocks.LIGHT_GRAY_TIBERCRETE.get());
        stonecutterResultFromBase(consumer, RecipeCategory.MISC, ModBlocks.LIME_TIBERCRETE_BRICK_STAIRS.get(), ModBlocks.LIME_TIBERCRETE.get());
        stonecutterResultFromBase(consumer, RecipeCategory.MISC, ModBlocks.MAGENTA_TIBERCRETE_BRICK_STAIRS.get(), ModBlocks.MAGENTA_TIBERCRETE.get());
        stonecutterResultFromBase(consumer, RecipeCategory.MISC, ModBlocks.ORANGE_TIBERCRETE_BRICK_STAIRS.get(), ModBlocks.ORANGE_TIBERCRETE.get());
        stonecutterResultFromBase(consumer, RecipeCategory.MISC, ModBlocks.PINK_TIBERCRETE_BRICK_STAIRS.get(), ModBlocks.PINK_TIBERCRETE.get());
        stonecutterResultFromBase(consumer, RecipeCategory.MISC, ModBlocks.PURPLE_TIBERCRETE_BRICK_STAIRS.get(), ModBlocks.PURPLE_TIBERCRETE.get());
        stonecutterResultFromBase(consumer, RecipeCategory.MISC, ModBlocks.RED_TIBERCRETE_BRICK_STAIRS.get(), ModBlocks.RED_TIBERCRETE.get());
        stonecutterResultFromBase(consumer, RecipeCategory.MISC, ModBlocks.WHITE_TIBERCRETE_BRICK_STAIRS.get(), ModBlocks.WHITE_TIBERCRETE.get());
        stonecutterResultFromBase(consumer, RecipeCategory.MISC, ModBlocks.YELLOW_TIBERCRETE_BRICK_STAIRS.get(), ModBlocks.YELLOW_TIBERCRETE.get());
        stonecutterResultFromBase(consumer, RecipeCategory.MISC, ModBlocks.BLACK_TIBERCRETE_WALL.get(), ModBlocks.BLACK_TIBERCRETE.get());
        stonecutterResultFromBase(consumer, RecipeCategory.MISC, ModBlocks.BLUE_TIBERCRETE_WALL.get(), ModBlocks.BLUE_TIBERCRETE.get());
        stonecutterResultFromBase(consumer, RecipeCategory.MISC, ModBlocks.BROWN_TIBERCRETE_WALL.get(), ModBlocks.BROWN_TIBERCRETE.get());
        stonecutterResultFromBase(consumer, RecipeCategory.MISC, ModBlocks.CYAN_TIBERCRETE_WALL.get(), ModBlocks.CYAN_TIBERCRETE.get());
        stonecutterResultFromBase(consumer, RecipeCategory.MISC, ModBlocks.GRAY_TIBERCRETE_WALL.get(), ModBlocks.GRAY_TIBERCRETE.get());
        stonecutterResultFromBase(consumer, RecipeCategory.MISC, ModBlocks.GREEN_TIBERCRETE_WALL.get(), ModBlocks.GREEN_TIBERCRETE.get());
        stonecutterResultFromBase(consumer, RecipeCategory.MISC, ModBlocks.LIGHT_BLUE_TIBERCRETE_WALL.get(), ModBlocks.LIGHT_BLUE_TIBERCRETE.get());
        stonecutterResultFromBase(consumer, RecipeCategory.MISC, ModBlocks.LIGHT_GRAY_TIBERCRETE_WALL.get(), ModBlocks.LIGHT_GRAY_TIBERCRETE.get());
        stonecutterResultFromBase(consumer, RecipeCategory.MISC, ModBlocks.LIME_TIBERCRETE_WALL.get(), ModBlocks.LIME_TIBERCRETE.get());
        stonecutterResultFromBase(consumer, RecipeCategory.MISC, ModBlocks.MAGENTA_TIBERCRETE_WALL.get(), ModBlocks.MAGENTA_TIBERCRETE.get());
        stonecutterResultFromBase(consumer, RecipeCategory.MISC, ModBlocks.ORANGE_TIBERCRETE_WALL.get(), ModBlocks.ORANGE_TIBERCRETE.get());
        stonecutterResultFromBase(consumer, RecipeCategory.MISC, ModBlocks.PINK_TIBERCRETE_WALL.get(), ModBlocks.PINK_TIBERCRETE.get());
        stonecutterResultFromBase(consumer, RecipeCategory.MISC, ModBlocks.PURPLE_TIBERCRETE_WALL.get(), ModBlocks.PURPLE_TIBERCRETE.get());
        stonecutterResultFromBase(consumer, RecipeCategory.MISC, ModBlocks.RED_TIBERCRETE_WALL.get(), ModBlocks.RED_TIBERCRETE.get());
        stonecutterResultFromBase(consumer, RecipeCategory.MISC, ModBlocks.WHITE_TIBERCRETE_WALL.get(), ModBlocks.WHITE_TIBERCRETE.get());
        stonecutterResultFromBase(consumer, RecipeCategory.MISC, ModBlocks.YELLOW_TIBERCRETE_WALL.get(), ModBlocks.YELLOW_TIBERCRETE.get());
        stonecutterResultFromBase(consumer, RecipeCategory.MISC, ModBlocks.BLACK_TIBERCRETE_WALL.get(), ModBlocks.BLACK_TIBERCRETE_BRICKS.get());
        stonecutterResultFromBase(consumer, RecipeCategory.MISC, ModBlocks.BLUE_TIBERCRETE_WALL.get(), ModBlocks.BLUE_TIBERCRETE_BRICKS.get());
        stonecutterResultFromBase(consumer, RecipeCategory.MISC, ModBlocks.BROWN_TIBERCRETE_WALL.get(), ModBlocks.BROWN_TIBERCRETE_BRICKS.get());
        stonecutterResultFromBase(consumer, RecipeCategory.MISC, ModBlocks.CYAN_TIBERCRETE_WALL.get(), ModBlocks.CYAN_TIBERCRETE_BRICKS.get());
        stonecutterResultFromBase(consumer, RecipeCategory.MISC, ModBlocks.GRAY_TIBERCRETE_WALL.get(), ModBlocks.GRAY_TIBERCRETE_BRICKS.get());
        stonecutterResultFromBase(consumer, RecipeCategory.MISC, ModBlocks.GREEN_TIBERCRETE_WALL.get(), ModBlocks.GREEN_TIBERCRETE_BRICKS.get());
        stonecutterResultFromBase(consumer, RecipeCategory.MISC, ModBlocks.LIGHT_BLUE_TIBERCRETE_WALL.get(), ModBlocks.LIGHT_BLUE_TIBERCRETE_BRICKS.get());
        stonecutterResultFromBase(consumer, RecipeCategory.MISC, ModBlocks.LIGHT_GRAY_TIBERCRETE_WALL.get(), ModBlocks.LIGHT_GRAY_TIBERCRETE_BRICKS.get());
        stonecutterResultFromBase(consumer, RecipeCategory.MISC, ModBlocks.LIME_TIBERCRETE_WALL.get(), ModBlocks.LIME_TIBERCRETE_BRICKS.get());
        stonecutterResultFromBase(consumer, RecipeCategory.MISC, ModBlocks.MAGENTA_TIBERCRETE_WALL.get(), ModBlocks.MAGENTA_TIBERCRETE_BRICKS.get());
        stonecutterResultFromBase(consumer, RecipeCategory.MISC, ModBlocks.ORANGE_TIBERCRETE_WALL.get(), ModBlocks.ORANGE_TIBERCRETE_BRICKS.get());
        stonecutterResultFromBase(consumer, RecipeCategory.MISC, ModBlocks.PINK_TIBERCRETE_WALL.get(), ModBlocks.PINK_TIBERCRETE_BRICKS.get());
        stonecutterResultFromBase(consumer, RecipeCategory.MISC, ModBlocks.PURPLE_TIBERCRETE_WALL.get(), ModBlocks.PURPLE_TIBERCRETE_BRICKS.get());
        stonecutterResultFromBase(consumer, RecipeCategory.MISC, ModBlocks.RED_TIBERCRETE_WALL.get(), ModBlocks.RED_TIBERCRETE_BRICKS.get());
        stonecutterResultFromBase(consumer, RecipeCategory.MISC, ModBlocks.WHITE_TIBERCRETE_WALL.get(), ModBlocks.WHITE_TIBERCRETE_BRICKS.get());
        stonecutterResultFromBase(consumer, RecipeCategory.MISC, ModBlocks.YELLOW_TIBERCRETE_WALL.get(), ModBlocks.YELLOW_TIBERCRETE_BRICKS.get());
        stonecutterResultFromBase(consumer, RecipeCategory.MISC, ModBlocks.BLACK_TIBERCRETE_BRICKS.get(), ModBlocks.BLACK_TIBERCRETE.get());
        stonecutterResultFromBase(consumer, RecipeCategory.MISC, ModBlocks.BLUE_TIBERCRETE_BRICKS.get(), ModBlocks.BLUE_TIBERCRETE.get());
        stonecutterResultFromBase(consumer, RecipeCategory.MISC, ModBlocks.BROWN_TIBERCRETE_BRICKS.get(), ModBlocks.BROWN_TIBERCRETE.get());
        stonecutterResultFromBase(consumer, RecipeCategory.MISC, ModBlocks.CYAN_TIBERCRETE_BRICKS.get(), ModBlocks.CYAN_TIBERCRETE.get());
        stonecutterResultFromBase(consumer, RecipeCategory.MISC, ModBlocks.GRAY_TIBERCRETE_BRICKS.get(), ModBlocks.GRAY_TIBERCRETE.get());
        stonecutterResultFromBase(consumer, RecipeCategory.MISC, ModBlocks.GREEN_TIBERCRETE_BRICKS.get(), ModBlocks.GREEN_TIBERCRETE.get());
        stonecutterResultFromBase(consumer, RecipeCategory.MISC, ModBlocks.LIGHT_BLUE_TIBERCRETE_BRICKS.get(), ModBlocks.LIGHT_BLUE_TIBERCRETE.get());
        stonecutterResultFromBase(consumer, RecipeCategory.MISC, ModBlocks.LIGHT_GRAY_TIBERCRETE_BRICKS.get(), ModBlocks.LIGHT_GRAY_TIBERCRETE.get());
        stonecutterResultFromBase(consumer, RecipeCategory.MISC, ModBlocks.LIME_TIBERCRETE_BRICKS.get(), ModBlocks.LIME_TIBERCRETE.get());
        stonecutterResultFromBase(consumer, RecipeCategory.MISC, ModBlocks.MAGENTA_TIBERCRETE_BRICKS.get(), ModBlocks.MAGENTA_TIBERCRETE.get());
        stonecutterResultFromBase(consumer, RecipeCategory.MISC, ModBlocks.ORANGE_TIBERCRETE_BRICKS.get(), ModBlocks.ORANGE_TIBERCRETE.get());
        stonecutterResultFromBase(consumer, RecipeCategory.MISC, ModBlocks.PINK_TIBERCRETE_BRICKS.get(), ModBlocks.PINK_TIBERCRETE.get());
        stonecutterResultFromBase(consumer, RecipeCategory.MISC, ModBlocks.PURPLE_TIBERCRETE_BRICKS.get(), ModBlocks.PURPLE_TIBERCRETE.get());
        stonecutterResultFromBase(consumer, RecipeCategory.MISC, ModBlocks.RED_TIBERCRETE_BRICKS.get(), ModBlocks.RED_TIBERCRETE.get());
        stonecutterResultFromBase(consumer, RecipeCategory.MISC, ModBlocks.WHITE_TIBERCRETE_BRICKS.get(), ModBlocks.WHITE_TIBERCRETE.get());
        stonecutterResultFromBase(consumer, RecipeCategory.MISC, ModBlocks.YELLOW_TIBERCRETE_BRICKS.get(), ModBlocks.YELLOW_TIBERCRETE.get());
        stonecutterResultFromBase(consumer, RecipeCategory.MISC, ModBlocks.BLACK_TIBERCRETE_SLAB.get(), ModBlocks.BLACK_TIBERCRETE.get(), 2);
        stonecutterResultFromBase(consumer, RecipeCategory.MISC, ModBlocks.BLUE_TIBERCRETE_SLAB.get(), ModBlocks.BLUE_TIBERCRETE.get(), 2);
        stonecutterResultFromBase(consumer, RecipeCategory.MISC, ModBlocks.BROWN_TIBERCRETE_SLAB.get(), ModBlocks.BROWN_TIBERCRETE.get(), 2);
        stonecutterResultFromBase(consumer, RecipeCategory.MISC, ModBlocks.CYAN_TIBERCRETE_SLAB.get(), ModBlocks.CYAN_TIBERCRETE.get(), 2);
        stonecutterResultFromBase(consumer, RecipeCategory.MISC, ModBlocks.GRAY_TIBERCRETE_SLAB.get(), ModBlocks.GRAY_TIBERCRETE.get(), 2);
        stonecutterResultFromBase(consumer, RecipeCategory.MISC, ModBlocks.GREEN_TIBERCRETE_SLAB.get(), ModBlocks.GREEN_TIBERCRETE.get(), 2);
        stonecutterResultFromBase(consumer, RecipeCategory.MISC, ModBlocks.LIGHT_BLUE_TIBERCRETE_SLAB.get(), ModBlocks.LIGHT_BLUE_TIBERCRETE.get(), 2);
        stonecutterResultFromBase(consumer, RecipeCategory.MISC, ModBlocks.LIGHT_GRAY_TIBERCRETE_SLAB.get(), ModBlocks.LIGHT_GRAY_TIBERCRETE.get(), 2);
        stonecutterResultFromBase(consumer, RecipeCategory.MISC, ModBlocks.LIME_TIBERCRETE_SLAB.get(), ModBlocks.LIME_TIBERCRETE.get(), 2);
        stonecutterResultFromBase(consumer, RecipeCategory.MISC, ModBlocks.MAGENTA_TIBERCRETE_SLAB.get(), ModBlocks.MAGENTA_TIBERCRETE.get(), 2);
        stonecutterResultFromBase(consumer, RecipeCategory.MISC, ModBlocks.ORANGE_TIBERCRETE_SLAB.get(), ModBlocks.ORANGE_TIBERCRETE.get(), 2);
        stonecutterResultFromBase(consumer, RecipeCategory.MISC, ModBlocks.PINK_TIBERCRETE_SLAB.get(), ModBlocks.PINK_TIBERCRETE.get(), 2);
        stonecutterResultFromBase(consumer, RecipeCategory.MISC, ModBlocks.PURPLE_TIBERCRETE_SLAB.get(), ModBlocks.PURPLE_TIBERCRETE.get(), 2);
        stonecutterResultFromBase(consumer, RecipeCategory.MISC, ModBlocks.RED_TIBERCRETE_SLAB.get(), ModBlocks.RED_TIBERCRETE.get(), 2);
        stonecutterResultFromBase(consumer, RecipeCategory.MISC, ModBlocks.WHITE_TIBERCRETE_SLAB.get(), ModBlocks.WHITE_TIBERCRETE.get(), 2);
        stonecutterResultFromBase(consumer, RecipeCategory.MISC, ModBlocks.YELLOW_TIBERCRETE_SLAB.get(), ModBlocks.YELLOW_TIBERCRETE.get(), 2);
        stonecutterResultFromBase(consumer, RecipeCategory.MISC, ModBlocks.BLACK_TIBERCRETE_SLAB.get(), ModBlocks.BLACK_TIBERCRETE_BRICKS.get(), 2);
        stonecutterResultFromBase(consumer, RecipeCategory.MISC, ModBlocks.BLUE_TIBERCRETE_SLAB.get(), ModBlocks.BLUE_TIBERCRETE_BRICKS.get(), 2);
        stonecutterResultFromBase(consumer, RecipeCategory.MISC, ModBlocks.BROWN_TIBERCRETE_SLAB.get(), ModBlocks.BROWN_TIBERCRETE_BRICKS.get(), 2);
        stonecutterResultFromBase(consumer, RecipeCategory.MISC, ModBlocks.CYAN_TIBERCRETE_SLAB.get(), ModBlocks.CYAN_TIBERCRETE_BRICKS.get(), 2);
        stonecutterResultFromBase(consumer, RecipeCategory.MISC, ModBlocks.GRAY_TIBERCRETE_SLAB.get(), ModBlocks.GRAY_TIBERCRETE_BRICKS.get(), 2);
        stonecutterResultFromBase(consumer, RecipeCategory.MISC, ModBlocks.GREEN_TIBERCRETE_SLAB.get(), ModBlocks.GREEN_TIBERCRETE_BRICKS.get(), 2);
        stonecutterResultFromBase(consumer, RecipeCategory.MISC, ModBlocks.LIGHT_BLUE_TIBERCRETE_SLAB.get(), ModBlocks.LIGHT_BLUE_TIBERCRETE_BRICKS.get(), 2);
        stonecutterResultFromBase(consumer, RecipeCategory.MISC, ModBlocks.LIGHT_GRAY_TIBERCRETE_SLAB.get(), ModBlocks.LIGHT_GRAY_TIBERCRETE_BRICKS.get(), 2);
        stonecutterResultFromBase(consumer, RecipeCategory.MISC, ModBlocks.LIME_TIBERCRETE_SLAB.get(), ModBlocks.LIME_TIBERCRETE_BRICKS.get(), 2);
        stonecutterResultFromBase(consumer, RecipeCategory.MISC, ModBlocks.MAGENTA_TIBERCRETE_SLAB.get(), ModBlocks.MAGENTA_TIBERCRETE_BRICKS.get(), 2);
        stonecutterResultFromBase(consumer, RecipeCategory.MISC, ModBlocks.ORANGE_TIBERCRETE_SLAB.get(), ModBlocks.ORANGE_TIBERCRETE_BRICKS.get(), 2);
        stonecutterResultFromBase(consumer, RecipeCategory.MISC, ModBlocks.PINK_TIBERCRETE_SLAB.get(), ModBlocks.PINK_TIBERCRETE_BRICKS.get(), 2);
        stonecutterResultFromBase(consumer, RecipeCategory.MISC, ModBlocks.PURPLE_TIBERCRETE_SLAB.get(), ModBlocks.PURPLE_TIBERCRETE_BRICKS.get(), 2);
        stonecutterResultFromBase(consumer, RecipeCategory.MISC, ModBlocks.RED_TIBERCRETE_SLAB.get(), ModBlocks.RED_TIBERCRETE_BRICKS.get(), 2);
        stonecutterResultFromBase(consumer, RecipeCategory.MISC, ModBlocks.WHITE_TIBERCRETE_SLAB.get(), ModBlocks.WHITE_TIBERCRETE_BRICKS.get(), 2);
        stonecutterResultFromBase(consumer, RecipeCategory.MISC, ModBlocks.YELLOW_TIBERCRETE_SLAB.get(), ModBlocks.YELLOW_TIBERCRETE_BRICKS.get(), 2);
        stonecutterResultFromBase(consumer, RecipeCategory.MISC, ModBlocks.BLACK_TIBERCRETE_BRICK_SLAB.get(), ModBlocks.BLACK_TIBERCRETE.get(), 2);
        stonecutterResultFromBase(consumer, RecipeCategory.MISC, ModBlocks.BLUE_TIBERCRETE_BRICK_SLAB.get(), ModBlocks.BLUE_TIBERCRETE.get(), 2);
        stonecutterResultFromBase(consumer, RecipeCategory.MISC, ModBlocks.BROWN_TIBERCRETE_BRICK_SLAB.get(), ModBlocks.BROWN_TIBERCRETE.get(), 2);
        stonecutterResultFromBase(consumer, RecipeCategory.MISC, ModBlocks.CYAN_TIBERCRETE_BRICK_SLAB.get(), ModBlocks.CYAN_TIBERCRETE.get(), 2);
        stonecutterResultFromBase(consumer, RecipeCategory.MISC, ModBlocks.GRAY_TIBERCRETE_BRICK_SLAB.get(), ModBlocks.GRAY_TIBERCRETE.get(), 2);
        stonecutterResultFromBase(consumer, RecipeCategory.MISC, ModBlocks.GREEN_TIBERCRETE_BRICK_SLAB.get(), ModBlocks.GREEN_TIBERCRETE.get(), 2);
        stonecutterResultFromBase(consumer, RecipeCategory.MISC, ModBlocks.LIGHT_BLUE_TIBERCRETE_BRICK_SLAB.get(), ModBlocks.LIGHT_BLUE_TIBERCRETE.get(), 2);
        stonecutterResultFromBase(consumer, RecipeCategory.MISC, ModBlocks.LIGHT_GRAY_TIBERCRETE_BRICK_SLAB.get(), ModBlocks.LIGHT_GRAY_TIBERCRETE.get(), 2);
        stonecutterResultFromBase(consumer, RecipeCategory.MISC, ModBlocks.LIME_TIBERCRETE_BRICK_SLAB.get(), ModBlocks.LIME_TIBERCRETE.get(), 2);
        stonecutterResultFromBase(consumer, RecipeCategory.MISC, ModBlocks.MAGENTA_TIBERCRETE_BRICK_SLAB.get(), ModBlocks.MAGENTA_TIBERCRETE.get(), 2);
        stonecutterResultFromBase(consumer, RecipeCategory.MISC, ModBlocks.ORANGE_TIBERCRETE_BRICK_SLAB.get(), ModBlocks.ORANGE_TIBERCRETE.get(), 2);
        stonecutterResultFromBase(consumer, RecipeCategory.MISC, ModBlocks.PINK_TIBERCRETE_BRICK_SLAB.get(), ModBlocks.PINK_TIBERCRETE.get(), 2);
        stonecutterResultFromBase(consumer, RecipeCategory.MISC, ModBlocks.PURPLE_TIBERCRETE_BRICK_SLAB.get(), ModBlocks.PURPLE_TIBERCRETE.get(), 2);
        stonecutterResultFromBase(consumer, RecipeCategory.MISC, ModBlocks.RED_TIBERCRETE_BRICK_SLAB.get(), ModBlocks.RED_TIBERCRETE.get(), 2);
        stonecutterResultFromBase(consumer, RecipeCategory.MISC, ModBlocks.WHITE_TIBERCRETE_BRICK_SLAB.get(), ModBlocks.WHITE_TIBERCRETE.get(), 2);
        stonecutterResultFromBase(consumer, RecipeCategory.MISC, ModBlocks.YELLOW_TIBERCRETE_BRICK_SLAB.get(), ModBlocks.YELLOW_TIBERCRETE.get(), 2);
        stonecutterResultFromBase(consumer, RecipeCategory.MISC, ModBlocks.BLACK_TIBERCRETE_BRICK_SLAB.get(), ModBlocks.BLACK_TIBERCRETE_BRICKS.get(), 2);
        stonecutterResultFromBase(consumer, RecipeCategory.MISC, ModBlocks.BLUE_TIBERCRETE_BRICK_SLAB.get(), ModBlocks.BLUE_TIBERCRETE_BRICKS.get(), 2);
        stonecutterResultFromBase(consumer, RecipeCategory.MISC, ModBlocks.BROWN_TIBERCRETE_BRICK_SLAB.get(), ModBlocks.BROWN_TIBERCRETE_BRICKS.get(), 2);
        stonecutterResultFromBase(consumer, RecipeCategory.MISC, ModBlocks.CYAN_TIBERCRETE_BRICK_SLAB.get(), ModBlocks.CYAN_TIBERCRETE_BRICKS.get(), 2);
        stonecutterResultFromBase(consumer, RecipeCategory.MISC, ModBlocks.GRAY_TIBERCRETE_BRICK_SLAB.get(), ModBlocks.GRAY_TIBERCRETE_BRICKS.get(), 2);
        stonecutterResultFromBase(consumer, RecipeCategory.MISC, ModBlocks.GREEN_TIBERCRETE_BRICK_SLAB.get(), ModBlocks.GREEN_TIBERCRETE_BRICKS.get(), 2);
        stonecutterResultFromBase(consumer, RecipeCategory.MISC, ModBlocks.LIGHT_BLUE_TIBERCRETE_BRICK_SLAB.get(), ModBlocks.LIGHT_BLUE_TIBERCRETE_BRICKS.get(), 2);
        stonecutterResultFromBase(consumer, RecipeCategory.MISC, ModBlocks.LIGHT_GRAY_TIBERCRETE_BRICK_SLAB.get(), ModBlocks.LIGHT_GRAY_TIBERCRETE_BRICKS.get(), 2);
        stonecutterResultFromBase(consumer, RecipeCategory.MISC, ModBlocks.LIME_TIBERCRETE_BRICK_SLAB.get(), ModBlocks.LIME_TIBERCRETE_BRICKS.get(), 2);
        stonecutterResultFromBase(consumer, RecipeCategory.MISC, ModBlocks.MAGENTA_TIBERCRETE_BRICK_SLAB.get(), ModBlocks.MAGENTA_TIBERCRETE_BRICKS.get(), 2);
        stonecutterResultFromBase(consumer, RecipeCategory.MISC, ModBlocks.ORANGE_TIBERCRETE_BRICK_SLAB.get(), ModBlocks.ORANGE_TIBERCRETE_BRICKS.get(), 2);
        stonecutterResultFromBase(consumer, RecipeCategory.MISC, ModBlocks.PINK_TIBERCRETE_BRICK_SLAB.get(), ModBlocks.PINK_TIBERCRETE_BRICKS.get(), 2);
        stonecutterResultFromBase(consumer, RecipeCategory.MISC, ModBlocks.PURPLE_TIBERCRETE_BRICK_SLAB.get(), ModBlocks.PURPLE_TIBERCRETE_BRICKS.get(), 2);
        stonecutterResultFromBase(consumer, RecipeCategory.MISC, ModBlocks.RED_TIBERCRETE_BRICK_SLAB.get(), ModBlocks.RED_TIBERCRETE_BRICKS.get(), 2);
        stonecutterResultFromBase(consumer, RecipeCategory.MISC, ModBlocks.WHITE_TIBERCRETE_BRICK_SLAB.get(), ModBlocks.WHITE_TIBERCRETE_BRICKS.get(), 2);
        stonecutterResultFromBase(consumer, RecipeCategory.MISC, ModBlocks.YELLOW_TIBERCRETE_BRICK_SLAB.get(), ModBlocks.YELLOW_TIBERCRETE_BRICKS.get(), 2);
        stonecutterResultFromBase(consumer, RecipeCategory.MISC, ModBlocks.BLACK_TIBERCRETE_BRICK_WALL.get(), ModBlocks.BLACK_TIBERCRETE.get());
        stonecutterResultFromBase(consumer, RecipeCategory.MISC, ModBlocks.BLUE_TIBERCRETE_BRICK_WALL.get(), ModBlocks.BLUE_TIBERCRETE.get());
        stonecutterResultFromBase(consumer, RecipeCategory.MISC, ModBlocks.BROWN_TIBERCRETE_BRICK_WALL.get(), ModBlocks.BROWN_TIBERCRETE.get());
        stonecutterResultFromBase(consumer, RecipeCategory.MISC, ModBlocks.CYAN_TIBERCRETE_BRICK_WALL.get(), ModBlocks.CYAN_TIBERCRETE.get());
        stonecutterResultFromBase(consumer, RecipeCategory.MISC, ModBlocks.GRAY_TIBERCRETE_BRICK_WALL.get(), ModBlocks.GRAY_TIBERCRETE.get());
        stonecutterResultFromBase(consumer, RecipeCategory.MISC, ModBlocks.GREEN_TIBERCRETE_BRICK_WALL.get(), ModBlocks.GREEN_TIBERCRETE.get());
        stonecutterResultFromBase(consumer, RecipeCategory.MISC, ModBlocks.LIGHT_BLUE_TIBERCRETE_BRICK_WALL.get(), ModBlocks.LIGHT_BLUE_TIBERCRETE.get());
        stonecutterResultFromBase(consumer, RecipeCategory.MISC, ModBlocks.LIGHT_GRAY_TIBERCRETE_BRICK_WALL.get(), ModBlocks.LIGHT_GRAY_TIBERCRETE.get());
        stonecutterResultFromBase(consumer, RecipeCategory.MISC, ModBlocks.LIME_TIBERCRETE_BRICK_WALL.get(), ModBlocks.LIME_TIBERCRETE.get());
        stonecutterResultFromBase(consumer, RecipeCategory.MISC, ModBlocks.MAGENTA_TIBERCRETE_BRICK_WALL.get(), ModBlocks.MAGENTA_TIBERCRETE.get());
        stonecutterResultFromBase(consumer, RecipeCategory.MISC, ModBlocks.ORANGE_TIBERCRETE_BRICK_WALL.get(), ModBlocks.ORANGE_TIBERCRETE.get());
        stonecutterResultFromBase(consumer, RecipeCategory.MISC, ModBlocks.PINK_TIBERCRETE_BRICK_WALL.get(), ModBlocks.PINK_TIBERCRETE.get());
        stonecutterResultFromBase(consumer, RecipeCategory.MISC, ModBlocks.PURPLE_TIBERCRETE_BRICK_WALL.get(), ModBlocks.PURPLE_TIBERCRETE.get());
        stonecutterResultFromBase(consumer, RecipeCategory.MISC, ModBlocks.RED_TIBERCRETE_BRICK_WALL.get(), ModBlocks.RED_TIBERCRETE.get());
        stonecutterResultFromBase(consumer, RecipeCategory.MISC, ModBlocks.WHITE_TIBERCRETE_BRICK_WALL.get(), ModBlocks.WHITE_TIBERCRETE.get());
        stonecutterResultFromBase(consumer, RecipeCategory.MISC, ModBlocks.YELLOW_TIBERCRETE_BRICK_WALL.get(), ModBlocks.YELLOW_TIBERCRETE.get());
        stonecutterResultFromBase(consumer, RecipeCategory.MISC, ModBlocks.BLACK_TIBERCRETE_BRICK_WALL.get(), ModBlocks.BLACK_TIBERCRETE_BRICKS.get());
        stonecutterResultFromBase(consumer, RecipeCategory.MISC, ModBlocks.BLUE_TIBERCRETE_BRICK_WALL.get(), ModBlocks.BLUE_TIBERCRETE_BRICKS.get());
        stonecutterResultFromBase(consumer, RecipeCategory.MISC, ModBlocks.BROWN_TIBERCRETE_BRICK_WALL.get(), ModBlocks.BROWN_TIBERCRETE_BRICKS.get());
        stonecutterResultFromBase(consumer, RecipeCategory.MISC, ModBlocks.CYAN_TIBERCRETE_BRICK_WALL.get(), ModBlocks.CYAN_TIBERCRETE_BRICKS.get());
        stonecutterResultFromBase(consumer, RecipeCategory.MISC, ModBlocks.GRAY_TIBERCRETE_BRICK_WALL.get(), ModBlocks.GRAY_TIBERCRETE_BRICKS.get());
        stonecutterResultFromBase(consumer, RecipeCategory.MISC, ModBlocks.GREEN_TIBERCRETE_BRICK_WALL.get(), ModBlocks.GREEN_TIBERCRETE_BRICKS.get());
        stonecutterResultFromBase(consumer, RecipeCategory.MISC, ModBlocks.LIGHT_BLUE_TIBERCRETE_BRICK_WALL.get(), ModBlocks.LIGHT_BLUE_TIBERCRETE_BRICKS.get());
        stonecutterResultFromBase(consumer, RecipeCategory.MISC, ModBlocks.LIGHT_GRAY_TIBERCRETE_BRICK_WALL.get(), ModBlocks.LIGHT_GRAY_TIBERCRETE_BRICKS.get());
        stonecutterResultFromBase(consumer, RecipeCategory.MISC, ModBlocks.LIME_TIBERCRETE_BRICK_WALL.get(), ModBlocks.LIME_TIBERCRETE_BRICKS.get());
        stonecutterResultFromBase(consumer, RecipeCategory.MISC, ModBlocks.MAGENTA_TIBERCRETE_BRICK_WALL.get(), ModBlocks.MAGENTA_TIBERCRETE_BRICKS.get());
        stonecutterResultFromBase(consumer, RecipeCategory.MISC, ModBlocks.ORANGE_TIBERCRETE_BRICK_WALL.get(), ModBlocks.ORANGE_TIBERCRETE_BRICKS.get());
        stonecutterResultFromBase(consumer, RecipeCategory.MISC, ModBlocks.PINK_TIBERCRETE_BRICK_WALL.get(), ModBlocks.PINK_TIBERCRETE_BRICKS.get());
        stonecutterResultFromBase(consumer, RecipeCategory.MISC, ModBlocks.PURPLE_TIBERCRETE_BRICK_WALL.get(), ModBlocks.PURPLE_TIBERCRETE_BRICKS.get());
        stonecutterResultFromBase(consumer, RecipeCategory.MISC, ModBlocks.RED_TIBERCRETE_BRICK_WALL.get(), ModBlocks.RED_TIBERCRETE_BRICKS.get());
        stonecutterResultFromBase(consumer, RecipeCategory.MISC, ModBlocks.WHITE_TIBERCRETE_BRICK_WALL.get(), ModBlocks.WHITE_TIBERCRETE_BRICKS.get());
        stonecutterResultFromBase(consumer, RecipeCategory.MISC, ModBlocks.YELLOW_TIBERCRETE_BRICK_WALL.get(), ModBlocks.YELLOW_TIBERCRETE_BRICKS.get());

        stonecutterResultFromBase(consumer, RecipeCategory.MISC, ModBlocks.CRYSTAL_CORE_LAMP_B.get(), ModBlocks.CRYSTAL_CORE_LAMP_G.get());
        stonecutterResultFromBase(consumer, RecipeCategory.MISC, ModBlocks.CRYSTAL_CORE_LAMP_R.get(), ModBlocks.CRYSTAL_CORE_LAMP_G.get());
        stonecutterResultFromBase(consumer, RecipeCategory.MISC, ModBlocks.CRYSTAL_CORE_LAMP_P.get(), ModBlocks.CRYSTAL_CORE_LAMP_G.get());
        stonecutterResultFromBase(consumer, RecipeCategory.MISC, ModBlocks.CRYSTAL_CORE_LIGHT.get(), ModBlocks.CRYSTAL_CORE_LAMP_G.get());
        stonecutterResultFromBase(consumer, RecipeCategory.MISC, ModBlocks.INVERTED_CRYSTAL_CORE_LAMP_B.get(), ModBlocks.CRYSTAL_CORE_LAMP_G.get());
        stonecutterResultFromBase(consumer, RecipeCategory.MISC, ModBlocks.INVERTED_CRYSTAL_CORE_LAMP_G.get(), ModBlocks.CRYSTAL_CORE_LAMP_G.get());
        stonecutterResultFromBase(consumer, RecipeCategory.MISC, ModBlocks.INVERTED_CRYSTAL_CORE_LAMP_R.get(), ModBlocks.CRYSTAL_CORE_LAMP_G.get());
        stonecutterResultFromBase(consumer, RecipeCategory.MISC, ModBlocks.INVERTED_CRYSTAL_CORE_LAMP_P.get(), ModBlocks.CRYSTAL_CORE_LAMP_G.get());
        stonecutterResultFromBase(consumer, RecipeCategory.MISC, ModBlocks.INVERTED_CRYSTAL_CORE_LIGHT.get(), ModBlocks.CRYSTAL_CORE_LAMP_G.get());

        stonecutterResultFromBase(consumer, RecipeCategory.MISC, ModBlocks.CRYSTAL_CORE_LAMP_G.get(), ModBlocks.CRYSTAL_CORE_LAMP_B.get());
        stonecutterResultFromBase(consumer, RecipeCategory.MISC, ModBlocks.CRYSTAL_CORE_LAMP_R.get(), ModBlocks.CRYSTAL_CORE_LAMP_B.get());
        stonecutterResultFromBase(consumer, RecipeCategory.MISC, ModBlocks.CRYSTAL_CORE_LAMP_P.get(), ModBlocks.CRYSTAL_CORE_LAMP_B.get());
        stonecutterResultFromBase(consumer, RecipeCategory.MISC, ModBlocks.CRYSTAL_CORE_LIGHT.get(), ModBlocks.CRYSTAL_CORE_LAMP_B.get());
        stonecutterResultFromBase(consumer, RecipeCategory.MISC, ModBlocks.INVERTED_CRYSTAL_CORE_LAMP_G.get(), ModBlocks.CRYSTAL_CORE_LAMP_B.get());
        stonecutterResultFromBase(consumer, RecipeCategory.MISC, ModBlocks.INVERTED_CRYSTAL_CORE_LAMP_B.get(), ModBlocks.CRYSTAL_CORE_LAMP_B.get());
        stonecutterResultFromBase(consumer, RecipeCategory.MISC, ModBlocks.INVERTED_CRYSTAL_CORE_LAMP_R.get(), ModBlocks.CRYSTAL_CORE_LAMP_B.get());
        stonecutterResultFromBase(consumer, RecipeCategory.MISC, ModBlocks.INVERTED_CRYSTAL_CORE_LAMP_P.get(), ModBlocks.CRYSTAL_CORE_LAMP_B.get());
        stonecutterResultFromBase(consumer, RecipeCategory.MISC, ModBlocks.INVERTED_CRYSTAL_CORE_LIGHT.get(), ModBlocks.CRYSTAL_CORE_LAMP_B.get());

        stonecutterResultFromBase(consumer, RecipeCategory.MISC, ModBlocks.CRYSTAL_CORE_LAMP_G.get(), ModBlocks.CRYSTAL_CORE_LAMP_R.get());
        stonecutterResultFromBase(consumer, RecipeCategory.MISC, ModBlocks.CRYSTAL_CORE_LAMP_B.get(), ModBlocks.CRYSTAL_CORE_LAMP_R.get());
        stonecutterResultFromBase(consumer, RecipeCategory.MISC, ModBlocks.CRYSTAL_CORE_LAMP_P.get(), ModBlocks.CRYSTAL_CORE_LAMP_R.get());
        stonecutterResultFromBase(consumer, RecipeCategory.MISC, ModBlocks.CRYSTAL_CORE_LIGHT.get(), ModBlocks.CRYSTAL_CORE_LAMP_R.get());
        stonecutterResultFromBase(consumer, RecipeCategory.MISC, ModBlocks.INVERTED_CRYSTAL_CORE_LAMP_G.get(), ModBlocks.CRYSTAL_CORE_LAMP_R.get());
        stonecutterResultFromBase(consumer, RecipeCategory.MISC, ModBlocks.INVERTED_CRYSTAL_CORE_LAMP_B.get(), ModBlocks.CRYSTAL_CORE_LAMP_R.get());
        stonecutterResultFromBase(consumer, RecipeCategory.MISC, ModBlocks.INVERTED_CRYSTAL_CORE_LAMP_R.get(), ModBlocks.CRYSTAL_CORE_LAMP_R.get());
        stonecutterResultFromBase(consumer, RecipeCategory.MISC, ModBlocks.INVERTED_CRYSTAL_CORE_LAMP_P.get(), ModBlocks.CRYSTAL_CORE_LAMP_R.get());
        stonecutterResultFromBase(consumer, RecipeCategory.MISC, ModBlocks.INVERTED_CRYSTAL_CORE_LIGHT.get(), ModBlocks.CRYSTAL_CORE_LAMP_R.get());

        stonecutterResultFromBase(consumer, RecipeCategory.MISC, ModBlocks.CRYSTAL_CORE_LAMP_G.get(), ModBlocks.CRYSTAL_CORE_LAMP_P.get());
        stonecutterResultFromBase(consumer, RecipeCategory.MISC, ModBlocks.CRYSTAL_CORE_LAMP_R.get(), ModBlocks.CRYSTAL_CORE_LAMP_P.get());
        stonecutterResultFromBase(consumer, RecipeCategory.MISC, ModBlocks.CRYSTAL_CORE_LAMP_B.get(), ModBlocks.CRYSTAL_CORE_LAMP_P.get());
        stonecutterResultFromBase(consumer, RecipeCategory.MISC, ModBlocks.CRYSTAL_CORE_LIGHT.get(), ModBlocks.CRYSTAL_CORE_LAMP_P.get());
        stonecutterResultFromBase(consumer, RecipeCategory.MISC, ModBlocks.INVERTED_CRYSTAL_CORE_LAMP_G.get(), ModBlocks.CRYSTAL_CORE_LAMP_P.get());
        stonecutterResultFromBase(consumer, RecipeCategory.MISC, ModBlocks.INVERTED_CRYSTAL_CORE_LAMP_R.get(), ModBlocks.CRYSTAL_CORE_LAMP_P.get());
        stonecutterResultFromBase(consumer, RecipeCategory.MISC, ModBlocks.INVERTED_CRYSTAL_CORE_LAMP_B.get(), ModBlocks.CRYSTAL_CORE_LAMP_P.get());
        stonecutterResultFromBase(consumer, RecipeCategory.MISC, ModBlocks.INVERTED_CRYSTAL_CORE_LAMP_P.get(), ModBlocks.CRYSTAL_CORE_LAMP_P.get());
        stonecutterResultFromBase(consumer, RecipeCategory.MISC, ModBlocks.INVERTED_CRYSTAL_CORE_LIGHT.get(), ModBlocks.CRYSTAL_CORE_LAMP_P.get());

        stonecutterResultFromBase(consumer, RecipeCategory.MISC, ModBlocks.CRYSTAL_CORE_LAMP_B.get(), ModBlocks.INVERTED_CRYSTAL_CORE_LAMP_G.get());
        stonecutterResultFromBase(consumer, RecipeCategory.MISC, ModBlocks.CRYSTAL_CORE_LAMP_R.get(), ModBlocks.INVERTED_CRYSTAL_CORE_LAMP_G.get());
        stonecutterResultFromBase(consumer, RecipeCategory.MISC, ModBlocks.CRYSTAL_CORE_LAMP_P.get(), ModBlocks.INVERTED_CRYSTAL_CORE_LAMP_G.get());
        stonecutterResultFromBase(consumer, RecipeCategory.MISC, ModBlocks.CRYSTAL_CORE_LAMP_G.get(), ModBlocks.INVERTED_CRYSTAL_CORE_LAMP_G.get());
        stonecutterResultFromBase(consumer, RecipeCategory.MISC, ModBlocks.CRYSTAL_CORE_LIGHT.get(), ModBlocks.INVERTED_CRYSTAL_CORE_LAMP_G.get());
        stonecutterResultFromBase(consumer, RecipeCategory.MISC, ModBlocks.INVERTED_CRYSTAL_CORE_LAMP_B.get(), ModBlocks.INVERTED_CRYSTAL_CORE_LAMP_G.get());
        stonecutterResultFromBase(consumer, RecipeCategory.MISC, ModBlocks.INVERTED_CRYSTAL_CORE_LAMP_R.get(), ModBlocks.INVERTED_CRYSTAL_CORE_LAMP_G.get());
        stonecutterResultFromBase(consumer, RecipeCategory.MISC, ModBlocks.INVERTED_CRYSTAL_CORE_LAMP_P.get(), ModBlocks.INVERTED_CRYSTAL_CORE_LAMP_G.get());
        stonecutterResultFromBase(consumer, RecipeCategory.MISC, ModBlocks.INVERTED_CRYSTAL_CORE_LIGHT.get(), ModBlocks.INVERTED_CRYSTAL_CORE_LAMP_G.get());

        stonecutterResultFromBase(consumer, RecipeCategory.MISC, ModBlocks.CRYSTAL_CORE_LAMP_G.get(), ModBlocks.INVERTED_CRYSTAL_CORE_LAMP_B.get());
        stonecutterResultFromBase(consumer, RecipeCategory.MISC, ModBlocks.CRYSTAL_CORE_LAMP_R.get(), ModBlocks.INVERTED_CRYSTAL_CORE_LAMP_B.get());
        stonecutterResultFromBase(consumer, RecipeCategory.MISC, ModBlocks.CRYSTAL_CORE_LAMP_B.get(), ModBlocks.INVERTED_CRYSTAL_CORE_LAMP_B.get());
        stonecutterResultFromBase(consumer, RecipeCategory.MISC, ModBlocks.CRYSTAL_CORE_LAMP_P.get(), ModBlocks.INVERTED_CRYSTAL_CORE_LAMP_B.get());
        stonecutterResultFromBase(consumer, RecipeCategory.MISC, ModBlocks.CRYSTAL_CORE_LIGHT.get(), ModBlocks.INVERTED_CRYSTAL_CORE_LAMP_B.get());
        stonecutterResultFromBase(consumer, RecipeCategory.MISC, ModBlocks.INVERTED_CRYSTAL_CORE_LAMP_G.get(), ModBlocks.INVERTED_CRYSTAL_CORE_LAMP_B.get());
        stonecutterResultFromBase(consumer, RecipeCategory.MISC, ModBlocks.INVERTED_CRYSTAL_CORE_LAMP_R.get(), ModBlocks.INVERTED_CRYSTAL_CORE_LAMP_B.get());
        stonecutterResultFromBase(consumer, RecipeCategory.MISC, ModBlocks.INVERTED_CRYSTAL_CORE_LAMP_P.get(), ModBlocks.INVERTED_CRYSTAL_CORE_LAMP_B.get());
        stonecutterResultFromBase(consumer, RecipeCategory.MISC, ModBlocks.INVERTED_CRYSTAL_CORE_LIGHT.get(), ModBlocks.INVERTED_CRYSTAL_CORE_LAMP_B.get());

        stonecutterResultFromBase(consumer, RecipeCategory.MISC, ModBlocks.CRYSTAL_CORE_LAMP_G.get(), ModBlocks.INVERTED_CRYSTAL_CORE_LAMP_R.get());
        stonecutterResultFromBase(consumer, RecipeCategory.MISC, ModBlocks.CRYSTAL_CORE_LAMP_B.get(), ModBlocks.INVERTED_CRYSTAL_CORE_LAMP_R.get());
        stonecutterResultFromBase(consumer, RecipeCategory.MISC, ModBlocks.CRYSTAL_CORE_LAMP_P.get(), ModBlocks.INVERTED_CRYSTAL_CORE_LAMP_R.get());
        stonecutterResultFromBase(consumer, RecipeCategory.MISC, ModBlocks.CRYSTAL_CORE_LAMP_R.get(), ModBlocks.INVERTED_CRYSTAL_CORE_LAMP_R.get());
        stonecutterResultFromBase(consumer, RecipeCategory.MISC, ModBlocks.CRYSTAL_CORE_LIGHT.get(), ModBlocks.INVERTED_CRYSTAL_CORE_LAMP_R.get());
        stonecutterResultFromBase(consumer, RecipeCategory.MISC, ModBlocks.INVERTED_CRYSTAL_CORE_LAMP_G.get(), ModBlocks.INVERTED_CRYSTAL_CORE_LAMP_R.get());
        stonecutterResultFromBase(consumer, RecipeCategory.MISC, ModBlocks.INVERTED_CRYSTAL_CORE_LAMP_B.get(), ModBlocks.INVERTED_CRYSTAL_CORE_LAMP_R.get());
        stonecutterResultFromBase(consumer, RecipeCategory.MISC, ModBlocks.INVERTED_CRYSTAL_CORE_LAMP_P.get(), ModBlocks.INVERTED_CRYSTAL_CORE_LAMP_R.get());
        stonecutterResultFromBase(consumer, RecipeCategory.MISC, ModBlocks.INVERTED_CRYSTAL_CORE_LIGHT.get(), ModBlocks.INVERTED_CRYSTAL_CORE_LAMP_R.get());

        stonecutterResultFromBase(consumer, RecipeCategory.MISC, ModBlocks.CRYSTAL_CORE_LAMP_G.get(), ModBlocks.INVERTED_CRYSTAL_CORE_LAMP_P.get());
        stonecutterResultFromBase(consumer, RecipeCategory.MISC, ModBlocks.CRYSTAL_CORE_LAMP_R.get(), ModBlocks.INVERTED_CRYSTAL_CORE_LAMP_P.get());
        stonecutterResultFromBase(consumer, RecipeCategory.MISC, ModBlocks.CRYSTAL_CORE_LAMP_B.get(), ModBlocks.INVERTED_CRYSTAL_CORE_LAMP_P.get());
        stonecutterResultFromBase(consumer, RecipeCategory.MISC, ModBlocks.CRYSTAL_CORE_LAMP_P.get(), ModBlocks.INVERTED_CRYSTAL_CORE_LAMP_P.get());
        stonecutterResultFromBase(consumer, RecipeCategory.MISC, ModBlocks.CRYSTAL_CORE_LIGHT.get(), ModBlocks.INVERTED_CRYSTAL_CORE_LAMP_P.get());
        stonecutterResultFromBase(consumer, RecipeCategory.MISC, ModBlocks.INVERTED_CRYSTAL_CORE_LAMP_G.get(), ModBlocks.INVERTED_CRYSTAL_CORE_LAMP_P.get());
        stonecutterResultFromBase(consumer, RecipeCategory.MISC, ModBlocks.INVERTED_CRYSTAL_CORE_LAMP_R.get(), ModBlocks.INVERTED_CRYSTAL_CORE_LAMP_P.get());
        stonecutterResultFromBase(consumer, RecipeCategory.MISC, ModBlocks.INVERTED_CRYSTAL_CORE_LAMP_B.get(), ModBlocks.INVERTED_CRYSTAL_CORE_LAMP_P.get());
        stonecutterResultFromBase(consumer, RecipeCategory.MISC, ModBlocks.INVERTED_CRYSTAL_CORE_LIGHT.get(), ModBlocks.INVERTED_CRYSTAL_CORE_LAMP_P.get());

        stonecutterResultFromBase(consumer, RecipeCategory.MISC, ModBlocks.CRYSTAL_CORE_LAMP_G.get(), ModBlocks.CRYSTAL_CORE_LIGHT.get());
        stonecutterResultFromBase(consumer, RecipeCategory.MISC, ModBlocks.CRYSTAL_CORE_LAMP_R.get(), ModBlocks.CRYSTAL_CORE_LIGHT.get());
        stonecutterResultFromBase(consumer, RecipeCategory.MISC, ModBlocks.CRYSTAL_CORE_LAMP_B.get(), ModBlocks.CRYSTAL_CORE_LIGHT.get());
        stonecutterResultFromBase(consumer, RecipeCategory.MISC, ModBlocks.CRYSTAL_CORE_LAMP_P.get(), ModBlocks.CRYSTAL_CORE_LIGHT.get());
        stonecutterResultFromBase(consumer, RecipeCategory.MISC, ModBlocks.INVERTED_CRYSTAL_CORE_LAMP_G.get(), ModBlocks.CRYSTAL_CORE_LIGHT.get());
        stonecutterResultFromBase(consumer, RecipeCategory.MISC, ModBlocks.INVERTED_CRYSTAL_CORE_LAMP_R.get(), ModBlocks.CRYSTAL_CORE_LIGHT.get());
        stonecutterResultFromBase(consumer, RecipeCategory.MISC, ModBlocks.INVERTED_CRYSTAL_CORE_LAMP_B.get(), ModBlocks.CRYSTAL_CORE_LIGHT.get());
        stonecutterResultFromBase(consumer, RecipeCategory.MISC, ModBlocks.INVERTED_CRYSTAL_CORE_LAMP_P.get(), ModBlocks.CRYSTAL_CORE_LIGHT.get());
        stonecutterResultFromBase(consumer, RecipeCategory.MISC, ModBlocks.INVERTED_CRYSTAL_CORE_LIGHT.get(), ModBlocks.CRYSTAL_CORE_LIGHT.get());

        stonecutterResultFromBase(consumer, RecipeCategory.MISC, ModBlocks.CRYSTAL_CORE_LAMP_G.get(), ModBlocks.INVERTED_CRYSTAL_CORE_LIGHT.get());
        stonecutterResultFromBase(consumer, RecipeCategory.MISC, ModBlocks.CRYSTAL_CORE_LAMP_R.get(), ModBlocks.INVERTED_CRYSTAL_CORE_LIGHT.get());
        stonecutterResultFromBase(consumer, RecipeCategory.MISC, ModBlocks.CRYSTAL_CORE_LAMP_B.get(), ModBlocks.INVERTED_CRYSTAL_CORE_LIGHT.get());
        stonecutterResultFromBase(consumer, RecipeCategory.MISC, ModBlocks.CRYSTAL_CORE_LAMP_P.get(), ModBlocks.INVERTED_CRYSTAL_CORE_LIGHT.get());
        stonecutterResultFromBase(consumer, RecipeCategory.MISC, ModBlocks.INVERTED_CRYSTAL_CORE_LAMP_G.get(), ModBlocks.INVERTED_CRYSTAL_CORE_LIGHT.get());
        stonecutterResultFromBase(consumer, RecipeCategory.MISC, ModBlocks.INVERTED_CRYSTAL_CORE_LAMP_R.get(), ModBlocks.INVERTED_CRYSTAL_CORE_LIGHT.get());
        stonecutterResultFromBase(consumer, RecipeCategory.MISC, ModBlocks.INVERTED_CRYSTAL_CORE_LAMP_B.get(), ModBlocks.INVERTED_CRYSTAL_CORE_LIGHT.get());
        stonecutterResultFromBase(consumer, RecipeCategory.MISC, ModBlocks.INVERTED_CRYSTAL_CORE_LAMP_P.get(), ModBlocks.INVERTED_CRYSTAL_CORE_LIGHT.get());

        stonecutterResultFromBase(consumer, RecipeCategory.MISC, ModBlocks.YZ_SANDSTONE_SLAB.get(), ModBlocks.YZ_SANDSTONE.get(), 2);
        stonecutterResultFromBase(consumer, RecipeCategory.MISC, ModBlocks.CUT_YZ_SANDSTONE_SLAB.get(), ModBlocks.YZ_SANDSTONE.get(), 2);
        stonecutterResultFromBase(consumer, RecipeCategory.MISC, ModBlocks.SMOOTH_YZ_SANDSTONE_SLAB.get(), ModBlocks.YZ_SANDSTONE.get(), 2);
        stonecutterResultFromBase(consumer, RecipeCategory.MISC, ModBlocks.YZ_SANDSTONE_STAIRS.get(), ModBlocks.YZ_SANDSTONE.get());
        stonecutterResultFromBase(consumer, RecipeCategory.MISC, ModBlocks.SMOOTH_YZ_SANDSTONE_STAIRS.get(), ModBlocks.YZ_SANDSTONE.get());
        stonecutterResultFromBase(consumer, RecipeCategory.MISC, ModBlocks.YZ_SANDSTONE_WALL.get(), ModBlocks.YZ_SANDSTONE.get());
        stonecutterResultFromBase(consumer, RecipeCategory.MISC, ModBlocks.CUT_YZ_SANDSTONE.get(), ModBlocks.YZ_SANDSTONE.get());
        stonecutterResultFromBase(consumer, RecipeCategory.MISC, ModBlocks.CHISELED_YZ_SANDSTONE.get(), ModBlocks.YZ_SANDSTONE.get());
        stonecutterResultFromBase(consumer, RecipeCategory.MISC, ModBlocks.SMOOTH_YZ_SANDSTONE.get(), ModBlocks.YZ_SANDSTONE.get());

        stonecutterResultFromBase(consumer, RecipeCategory.MISC, ModBlocks.YZ_SANDSTONE_SLAB.get(), ModBlocks.CUT_YZ_SANDSTONE.get(), 2);
        stonecutterResultFromBase(consumer, RecipeCategory.MISC, ModBlocks.CUT_YZ_SANDSTONE_SLAB.get(), ModBlocks.CUT_YZ_SANDSTONE.get(), 2);
        stonecutterResultFromBase(consumer, RecipeCategory.MISC, ModBlocks.SMOOTH_YZ_SANDSTONE_SLAB.get(), ModBlocks.CUT_YZ_SANDSTONE.get(), 2);
        stonecutterResultFromBase(consumer, RecipeCategory.MISC, ModBlocks.YZ_SANDSTONE_STAIRS.get(), ModBlocks.CUT_YZ_SANDSTONE.get());
        stonecutterResultFromBase(consumer, RecipeCategory.MISC, ModBlocks.SMOOTH_YZ_SANDSTONE_STAIRS.get(), ModBlocks.CUT_YZ_SANDSTONE.get());
        stonecutterResultFromBase(consumer, RecipeCategory.MISC, ModBlocks.YZ_SANDSTONE_WALL.get(), ModBlocks.CUT_YZ_SANDSTONE.get());
        stonecutterResultFromBase(consumer, RecipeCategory.MISC, ModBlocks.YZ_SANDSTONE.get(), ModBlocks.CUT_YZ_SANDSTONE.get());
        stonecutterResultFromBase(consumer, RecipeCategory.MISC, ModBlocks.CHISELED_YZ_SANDSTONE.get(), ModBlocks.CUT_YZ_SANDSTONE.get());
        stonecutterResultFromBase(consumer, RecipeCategory.MISC, ModBlocks.SMOOTH_YZ_SANDSTONE.get(), ModBlocks.CUT_YZ_SANDSTONE.get());

        stonecutterResultFromBase(consumer, RecipeCategory.MISC, ModBlocks.YZ_SANDSTONE_SLAB.get(), ModBlocks.CHISELED_YZ_SANDSTONE.get(), 2);
        stonecutterResultFromBase(consumer, RecipeCategory.MISC, ModBlocks.CUT_YZ_SANDSTONE_SLAB.get(), ModBlocks.CHISELED_YZ_SANDSTONE.get(), 2);
        stonecutterResultFromBase(consumer, RecipeCategory.MISC, ModBlocks.SMOOTH_YZ_SANDSTONE_SLAB.get(), ModBlocks.CHISELED_YZ_SANDSTONE.get(), 2);
        stonecutterResultFromBase(consumer, RecipeCategory.MISC, ModBlocks.YZ_SANDSTONE_STAIRS.get(), ModBlocks.CHISELED_YZ_SANDSTONE.get());
        stonecutterResultFromBase(consumer, RecipeCategory.MISC, ModBlocks.SMOOTH_YZ_SANDSTONE_STAIRS.get(), ModBlocks.CHISELED_YZ_SANDSTONE.get());
        stonecutterResultFromBase(consumer, RecipeCategory.MISC, ModBlocks.YZ_SANDSTONE_WALL.get(), ModBlocks.CHISELED_YZ_SANDSTONE.get());
        stonecutterResultFromBase(consumer, RecipeCategory.MISC, ModBlocks.CUT_YZ_SANDSTONE.get(), ModBlocks.CHISELED_YZ_SANDSTONE.get());
        stonecutterResultFromBase(consumer, RecipeCategory.MISC, ModBlocks.YZ_SANDSTONE.get(), ModBlocks.CHISELED_YZ_SANDSTONE.get());
        stonecutterResultFromBase(consumer, RecipeCategory.MISC, ModBlocks.SMOOTH_YZ_SANDSTONE.get(), ModBlocks.CHISELED_YZ_SANDSTONE.get());

        stonecutterResultFromBase(consumer, RecipeCategory.MISC, ModBlocks.YZ_SANDSTONE_SLAB.get(), ModBlocks.SMOOTH_YZ_SANDSTONE.get(), 2);
        stonecutterResultFromBase(consumer, RecipeCategory.MISC, ModBlocks.CUT_YZ_SANDSTONE_SLAB.get(), ModBlocks.SMOOTH_YZ_SANDSTONE.get(), 2);
        stonecutterResultFromBase(consumer, RecipeCategory.MISC, ModBlocks.SMOOTH_YZ_SANDSTONE_SLAB.get(), ModBlocks.SMOOTH_YZ_SANDSTONE.get(), 2);
        stonecutterResultFromBase(consumer, RecipeCategory.MISC, ModBlocks.YZ_SANDSTONE_STAIRS.get(), ModBlocks.SMOOTH_YZ_SANDSTONE.get());
        stonecutterResultFromBase(consumer, RecipeCategory.MISC, ModBlocks.SMOOTH_YZ_SANDSTONE_STAIRS.get(), ModBlocks.SMOOTH_YZ_SANDSTONE.get());
        stonecutterResultFromBase(consumer, RecipeCategory.MISC, ModBlocks.YZ_SANDSTONE_WALL.get(), ModBlocks.SMOOTH_YZ_SANDSTONE.get());
        stonecutterResultFromBase(consumer, RecipeCategory.MISC, ModBlocks.CUT_YZ_SANDSTONE.get(), ModBlocks.SMOOTH_YZ_SANDSTONE.get());
        stonecutterResultFromBase(consumer, RecipeCategory.MISC, ModBlocks.YZ_SANDSTONE.get(), ModBlocks.SMOOTH_YZ_SANDSTONE.get());
        stonecutterResultFromBase(consumer, RecipeCategory.MISC, ModBlocks.CHISELED_YZ_SANDSTONE.get(), ModBlocks.SMOOTH_YZ_SANDSTONE.get());

        stonecutterResultFromBase(consumer, RecipeCategory.MISC, ModBlocks.RZ_SANDSTONE_SLAB.get(), ModBlocks.SMOOTH_RZ_SANDSTONE.get(), 2);
        stonecutterResultFromBase(consumer, RecipeCategory.MISC, ModBlocks.CUT_RZ_SANDSTONE_SLAB.get(), ModBlocks.SMOOTH_RZ_SANDSTONE.get(), 2);
        stonecutterResultFromBase(consumer, RecipeCategory.MISC, ModBlocks.SMOOTH_RZ_SANDSTONE_SLAB.get(), ModBlocks.SMOOTH_RZ_SANDSTONE.get(), 2);
        stonecutterResultFromBase(consumer, RecipeCategory.MISC, ModBlocks.RZ_SANDSTONE_STAIRS.get(), ModBlocks.SMOOTH_RZ_SANDSTONE.get());
        stonecutterResultFromBase(consumer, RecipeCategory.MISC, ModBlocks.SMOOTH_RZ_SANDSTONE_STAIRS.get(), ModBlocks.SMOOTH_RZ_SANDSTONE.get());
        stonecutterResultFromBase(consumer, RecipeCategory.MISC, ModBlocks.RZ_SANDSTONE_WALL.get(), ModBlocks.SMOOTH_RZ_SANDSTONE.get());
        stonecutterResultFromBase(consumer, RecipeCategory.MISC, ModBlocks.CUT_RZ_SANDSTONE.get(), ModBlocks.SMOOTH_RZ_SANDSTONE.get());
        stonecutterResultFromBase(consumer, RecipeCategory.MISC, ModBlocks.RZ_SANDSTONE.get(), ModBlocks.SMOOTH_RZ_SANDSTONE.get());
        stonecutterResultFromBase(consumer, RecipeCategory.MISC, ModBlocks.CHISELED_YZ_SANDSTONE.get(), ModBlocks.SMOOTH_RZ_SANDSTONE.get());

        stonecutterResultFromBase(consumer, RecipeCategory.MISC, ModBlocks.RZ_SANDSTONE_SLAB.get(), ModBlocks.RZ_SANDSTONE.get(), 2);
        stonecutterResultFromBase(consumer, RecipeCategory.MISC, ModBlocks.CUT_RZ_SANDSTONE_SLAB.get(), ModBlocks.RZ_SANDSTONE.get(), 2);
        stonecutterResultFromBase(consumer, RecipeCategory.MISC, ModBlocks.SMOOTH_RZ_SANDSTONE_SLAB.get(), ModBlocks.RZ_SANDSTONE.get(), 2);
        stonecutterResultFromBase(consumer, RecipeCategory.MISC, ModBlocks.RZ_SANDSTONE_STAIRS.get(), ModBlocks.RZ_SANDSTONE.get());
        stonecutterResultFromBase(consumer, RecipeCategory.MISC, ModBlocks.SMOOTH_RZ_SANDSTONE_STAIRS.get(), ModBlocks.RZ_SANDSTONE.get());
        stonecutterResultFromBase(consumer, RecipeCategory.MISC, ModBlocks.RZ_SANDSTONE_WALL.get(), ModBlocks.RZ_SANDSTONE.get());
        stonecutterResultFromBase(consumer, RecipeCategory.MISC, ModBlocks.CUT_RZ_SANDSTONE.get(), ModBlocks.RZ_SANDSTONE.get());
        stonecutterResultFromBase(consumer, RecipeCategory.MISC, ModBlocks.CHISELED_RZ_SANDSTONE.get(), ModBlocks.RZ_SANDSTONE.get());
        stonecutterResultFromBase(consumer, RecipeCategory.MISC, ModBlocks.SMOOTH_RZ_SANDSTONE.get(), ModBlocks.RZ_SANDSTONE.get());

        stonecutterResultFromBase(consumer, RecipeCategory.MISC, ModBlocks.RZ_SANDSTONE_SLAB.get(), ModBlocks.CUT_RZ_SANDSTONE.get(), 2);
        stonecutterResultFromBase(consumer, RecipeCategory.MISC, ModBlocks.CUT_RZ_SANDSTONE_SLAB.get(), ModBlocks.CUT_RZ_SANDSTONE.get(), 2);
        stonecutterResultFromBase(consumer, RecipeCategory.MISC, ModBlocks.SMOOTH_RZ_SANDSTONE_SLAB.get(), ModBlocks.CUT_RZ_SANDSTONE.get(), 2);
        stonecutterResultFromBase(consumer, RecipeCategory.MISC, ModBlocks.RZ_SANDSTONE_STAIRS.get(), ModBlocks.CUT_RZ_SANDSTONE.get());
        stonecutterResultFromBase(consumer, RecipeCategory.MISC, ModBlocks.SMOOTH_RZ_SANDSTONE_STAIRS.get(), ModBlocks.CUT_RZ_SANDSTONE.get());
        stonecutterResultFromBase(consumer, RecipeCategory.MISC, ModBlocks.RZ_SANDSTONE_WALL.get(), ModBlocks.CUT_RZ_SANDSTONE.get());
        stonecutterResultFromBase(consumer, RecipeCategory.MISC, ModBlocks.RZ_SANDSTONE.get(), ModBlocks.CUT_RZ_SANDSTONE.get());
        stonecutterResultFromBase(consumer, RecipeCategory.MISC, ModBlocks.CHISELED_RZ_SANDSTONE.get(), ModBlocks.CUT_RZ_SANDSTONE.get());
        stonecutterResultFromBase(consumer, RecipeCategory.MISC, ModBlocks.SMOOTH_RZ_SANDSTONE.get(), ModBlocks.CUT_RZ_SANDSTONE.get());

        stonecutterResultFromBase(consumer, RecipeCategory.MISC, ModBlocks.RZ_SANDSTONE_SLAB.get(), ModBlocks.CHISELED_RZ_SANDSTONE.get(), 2);
        stonecutterResultFromBase(consumer, RecipeCategory.MISC, ModBlocks.CUT_RZ_SANDSTONE_SLAB.get(), ModBlocks.CHISELED_RZ_SANDSTONE.get(), 2);
        stonecutterResultFromBase(consumer, RecipeCategory.MISC, ModBlocks.SMOOTH_RZ_SANDSTONE_SLAB.get(), ModBlocks.CHISELED_RZ_SANDSTONE.get(), 2);
        stonecutterResultFromBase(consumer, RecipeCategory.MISC, ModBlocks.RZ_SANDSTONE_STAIRS.get(), ModBlocks.CHISELED_RZ_SANDSTONE.get());
        stonecutterResultFromBase(consumer, RecipeCategory.MISC, ModBlocks.SMOOTH_RZ_SANDSTONE_STAIRS.get(), ModBlocks.CHISELED_RZ_SANDSTONE.get());
        stonecutterResultFromBase(consumer, RecipeCategory.MISC, ModBlocks.RZ_SANDSTONE_WALL.get(), ModBlocks.CHISELED_RZ_SANDSTONE.get());
        stonecutterResultFromBase(consumer, RecipeCategory.MISC, ModBlocks.CUT_RZ_SANDSTONE.get(), ModBlocks.CHISELED_RZ_SANDSTONE.get());
        stonecutterResultFromBase(consumer, RecipeCategory.MISC, ModBlocks.RZ_SANDSTONE.get(), ModBlocks.CHISELED_RZ_SANDSTONE.get());
        stonecutterResultFromBase(consumer, RecipeCategory.MISC, ModBlocks.SMOOTH_RZ_SANDSTONE.get(), ModBlocks.CHISELED_RZ_SANDSTONE.get());

        stonecutterResultFromBase(consumer, RecipeCategory.MISC, ModBlocks.VITRIC_DEEPSLATE_BRICKS.get(), ModBlocks.VITRIC_DEEPSLATE.get());
        stonecutterResultFromBase(consumer, RecipeCategory.MISC, ModBlocks.VITRIC_DEEPSLATE_TILES.get(), ModBlocks.VITRIC_DEEPSLATE.get());

        stonecutterResultFromBase(consumer, RecipeCategory.MISC, ModBlocks.VITRIC_DEEPSLATE.get(), ModBlocks.VITRIC_DEEPSLATE_BRICKS.get());
        stonecutterResultFromBase(consumer, RecipeCategory.MISC, ModBlocks.VITRIC_DEEPSLATE_TILES.get(), ModBlocks.VITRIC_DEEPSLATE_BRICKS.get());

        stonecutterResultFromBase(consumer, RecipeCategory.MISC, ModBlocks.VITRIC_DEEPSLATE_BRICKS.get(), ModBlocks.VITRIC_DEEPSLATE_TILES.get());
        stonecutterResultFromBase(consumer, RecipeCategory.MISC, ModBlocks.VITRIC_DEEPSLATE.get(), ModBlocks.VITRIC_DEEPSLATE_TILES.get());


        stonecutterResultFromBase(consumer, RecipeCategory.MISC, ModBlocks.VITRIC_DEEPSLATE_BRICK_WALL.get(), ModBlocks.VITRIC_DEEPSLATE_BRICKS.get());
        stonecutterResultFromBase(consumer, RecipeCategory.MISC, ModBlocks.VITRIC_DEEPSLATE_BRICK_SLAB.get(), ModBlocks.VITRIC_DEEPSLATE_BRICKS.get(), 2);
        stonecutterResultFromBase(consumer, RecipeCategory.MISC, ModBlocks.VITRIC_DEEPSLATE_BRICK_STAIRS.get(), ModBlocks.VITRIC_DEEPSLATE_BRICKS.get());

        stonecutterResultFromBase(consumer, RecipeCategory.MISC, ModBlocks.VITRIC_DEEPSLATE_TILE_WALL.get(), ModBlocks.VITRIC_DEEPSLATE_TILES.get());
        stonecutterResultFromBase(consumer, RecipeCategory.MISC, ModBlocks.VITRIC_DEEPSLATE_TILE_SLAB.get(), ModBlocks.VITRIC_DEEPSLATE_TILES.get(), 2);
        stonecutterResultFromBase(consumer, RecipeCategory.MISC, ModBlocks.VITRIC_DEEPSLATE_TILE_STAIRS.get(), ModBlocks.VITRIC_DEEPSLATE_TILES.get());


       

//Tiberium Grinder:

        //Vanilla:

        new TiberiumGrinderRecipeBuilder(Items.RAW_IRON, ModItems.IRON_DUST.get(), 2)
                .unlockedBy("has_iron_ore", has(Blocks.IRON_ORE)).save(consumer);

        new TiberiumGrinderRecipeBuilder(Items.RAW_COPPER, ModItems.COPPER_DUST.get(),2)
                .unlockedBy("has_copper_ore", has(Blocks.COPPER_ORE)).save(consumer);

        new TiberiumGrinderRecipeBuilder(Items.RAW_GOLD, ModItems.GOLD_DUST.get(), 2)
                .unlockedBy("has_gold_ore", has(Blocks.GOLD_ORE)).save(consumer);

        new TiberiumGrinderRecipeBuilder(Blocks.ANCIENT_DEBRIS, Items.NETHERITE_SCRAP, 2)
                .unlockedBy("has_ancient_debris", has(Blocks.ANCIENT_DEBRIS)).save(consumer);

        //Gundanium:

        new TiberiumGrinderRecipeBuilder(ModItems.RAW_GUNDANIUM.get(), ModItems.GUNDANIUM_DUST.get(), 2)
                .unlockedBy("has_gundanium_ore", has(ModBlocks.GUNDANIUM_ORE.get())).save(consumer);


        //Alythum:

        new TiberiumGrinderRecipeBuilder(ModItems.RAW_ALYTHUM.get(), ModItems.ALYTHUM_DUST.get(), 2)
                .unlockedBy("has_alythum_ore", has(ModBlocks.ALYTHUM_ORE.get())).save(consumer);

        //Illyrim:

        new TiberiumGrinderRecipeBuilder(ModItems.ILLYRIM_INGOT.get(), ModItems.ILLYRIM_BLEND.get(), 1)
                .unlockedBy("has_illyrim_blend", has(ModItems.ILLYRIM_BLEND.get())).save(consumer);

        //Core Steel:

        new TiberiumGrinderRecipeBuilder(ModItems.LG_CORE_INGOT.get(), ModItems.LG_CORE_BLEND.get(), 1)
                .unlockedBy("has_lg_core_blend", has(ModItems.LG_CORE_BLEND.get())).save(consumer);

        new TiberiumGrinderRecipeBuilder(ModItems.MG_CORE_INGOT.get(), ModItems.MG_CORE_BLEND.get(), 1)
                .unlockedBy("has_mg_core_blend", has(ModItems.MG_CORE_BLEND.get())).save(consumer);

        new TiberiumGrinderRecipeBuilder(ModItems.HG_CORE_INGOT.get(), ModItems.HG_CORE_BLEND.get(), 1)
                .unlockedBy("has_hg_core_blend", has(ModItems.HG_CORE_BLEND.get())).save(consumer);


        //Tiberium:

        new TiberiumGrinderRecipeBuilder(ModItems.TIBERIUM.get(), ModItems.GREEN_TIBERIUM_DUST.get(), 1)
                .unlockedBy("has_tiberium", has(ModItems.TIBERIUM.get())).save(consumer);

        new TiberiumGrinderRecipeBuilder(ModItems.TIBERIUM_BLUE.get(), ModItems.BLUE_TIBERIUM_DUST.get(), 1)
                .unlockedBy("has_blue_tiberium", has(ModItems.TIBERIUM_BLUE.get())).save(consumer);

        new TiberiumGrinderRecipeBuilder(ModItems.TIBERIUM_RED.get(), ModItems.RED_TIBERIUM_DUST.get(), 1)
                .unlockedBy("has_red_tiberium", has(ModItems.TIBERIUM_RED.get())).save(consumer);

        new TiberiumGrinderRecipeBuilder(ModItems.TIBERIUM_PURPLE.get(), ModItems.PURPLE_TIBERIUM_DUST.get(), 1)
                .unlockedBy("has_purple_tiberium", has(ModItems.TIBERIUM_PURPLE.get())).save(consumer);

        //Misc:

        new TiberiumGrinderRecipeBuilder(ModBlocks.DEVILS_BLOOD.get(), ModItems.DEVILS_BLOOD_POWDER.get(), 1)
                .unlockedBy("has_devils_blood", has(ModBlocks.DEVILS_BLOOD.get())).save(consumer);

        new TiberiumGrinderRecipeBuilder(ModBlocks.YOKARAN_BLOOM.get(), ModItems.YOKARAN_BLOOM_POWDER.get(), 1)
                .unlockedBy("has_yokaran_bloom", has(ModBlocks.YOKARAN_BLOOM.get())).save(consumer);


//Tiberium Infuser:
        new TiberiumInfuserRecipeBuilder(Items.LEATHER, ModItems.TIBERIUM_LEATHER.get(), 1, 100, 10,
                new FluidStack(ModFluids.SOURCE_MOLTEN_TIBERIUM.get(), 500))
                .unlockedBy("has_tiberium_bucket", has(ModItems.MOLTEN_TIBERIUM_BUCKET.get())).save(consumer);

        new TiberiumInfuserRecipeBuilder(ModItems.TIBERIUM_LEATHER.get(), ModItems.ICHOR_LEATHER.get(), 1, 300, 30,
                new FluidStack(ModFluids.SOURCE_MOLTEN_RED_TIBERIUM.get(), 1000))
                .unlockedBy("has_red_tiberium_bucket", has(ModItems.MOLTEN_RED_TIBERIUM_BUCKET.get())).save(consumer);

    new TiberiumInfuserRecipeBuilder(ModItems.RAW_QUALRITE.get(), ModItems.QUALRIM_COMPOUND.get(), 1, 250, 20,
            new FluidStack(ModFluids.SOURCE_MOLTEN_BLUE_TIBERIUM.get(), 1000))
            .unlockedBy("has_qualrite", has(ModItems.RAW_QUALRITE.get())).save(consumer);

        new TiberiumInfuserRecipeBuilder(ModItems.GUNDANIUM_INGOT.get(), ModItems.TIBERIUM_COMPOSITE_INGOT.get(), 1, 500, 25,
                new FluidStack(ModFluids.SOURCE_MOLTEN_TIBERIUM.get(), 1000))
                .unlockedBy("has_tiberium_bucket", has(ModItems.MOLTEN_TIBERIUM_BUCKET.get())).save(consumer);

        new TiberiumInfuserRecipeBuilder(ModItems.TIBERIUM_COMPOSITE_INGOT.get(), ModItems.ICHOR_COMPOSITE_INGOT.get(), 1, 750, 20,
                new FluidStack(ModFluids.SOURCE_MOLTEN_PURPLE_TIBERIUM.get(), 1000))
                .unlockedBy("has_purple_tiberium_bucket", has(ModItems.MOLTEN_PURPLE_TIBERIUM_BUCKET.get())).save(consumer);

        new TiberiumInfuserRecipeBuilder(Blocks.SAND, ModBlocks.YELLOW_ZONE_SAND.get(), 1, 100, 1,
                new FluidStack(ModFluids.SOURCE_MOLTEN_TIBERIUM.get(), 100))
                .unlockedBy("has_tiberium_bucket", has(ModItems.MOLTEN_TIBERIUM_BUCKET.get())).save(consumer);

        new TiberiumInfuserRecipeBuilder(Blocks.RED_SAND, ModBlocks.RED_ZONE_SAND.get(), 1, 100, 1,
                new FluidStack(ModFluids.SOURCE_MOLTEN_RED_TIBERIUM.get(), 100))
                .unlockedBy("has_red_tiberium_bucket", has(ModItems.MOLTEN_RED_TIBERIUM_BUCKET.get())).save(consumer);

        new TiberiumInfuserRecipeBuilder(Blocks.STONE, ModBlocks.INFESTED_STONE.get(), 1, 100, 1,
                new FluidStack(ModFluids.SOURCE_MOLTEN_TIBERIUM.get(), 100))
                .unlockedBy("has_tiberium_bucket", has(ModItems.MOLTEN_TIBERIUM_BUCKET.get())).save(consumer);

        new TiberiumInfuserRecipeBuilder(Blocks.GRANITE, ModBlocks.INFESTED_GRANITE.get(), 1, 100, 1,
                new FluidStack(ModFluids.SOURCE_MOLTEN_TIBERIUM.get(), 100))
                .unlockedBy("has_tiberium_bucket", has(ModItems.MOLTEN_TIBERIUM_BUCKET.get())).save(consumer);

        new TiberiumInfuserRecipeBuilder(Blocks.DIORITE, ModBlocks.INFESTED_DIORITE.get(), 1, 100, 1,
                new FluidStack(ModFluids.SOURCE_MOLTEN_TIBERIUM.get(), 100))
                .unlockedBy("has_tiberium_bucket", has(ModItems.MOLTEN_TIBERIUM_BUCKET.get())).save(consumer);

        new TiberiumInfuserRecipeBuilder(Blocks.ANDESITE, ModBlocks.INFESTED_ANDESITE.get(), 1, 100, 1,
                new FluidStack(ModFluids.SOURCE_MOLTEN_TIBERIUM.get(), 100))
                .unlockedBy("has_tiberium_bucket", has(ModItems.MOLTEN_TIBERIUM_BUCKET.get())).save(consumer);

        new TiberiumInfuserRecipeBuilder(ModBlocks.YELLOW_ZONE_CRACKED_DIRT.get(), ModBlocks.TIBERIUM_SOIL.get(), 1, 300, 4,
                new FluidStack(ModFluids.SOURCE_MOLTEN_BLUE_TIBERIUM.get(), 200))
                .unlockedBy("has_blue_tiberium_bucket", has(ModItems.MOLTEN_BLUE_TIBERIUM_BUCKET.get())).save(consumer);

        new TiberiumInfuserRecipeBuilder(ModBlocks.RED_ZONE_DIRT.get(), ModBlocks.ICHOR_SOIL.get(), 1, 500, 10,
                new FluidStack(ModFluids.SOURCE_MOLTEN_PURPLE_TIBERIUM.get(), 500))
                .unlockedBy("has_purple_tiberium_bucket", has(ModItems.MOLTEN_PURPLE_TIBERIUM_BUCKET.get())).save(consumer);

        new TiberiumInfuserRecipeBuilder(ModBlocks.SEEDED_YELLOW_ZONE_CRACKED_DIRT.get(), ModBlocks.RED_ZONE_DIRT.get(), 1, 200, 2,
                new FluidStack(ModFluids.SOURCE_MOLTEN_TIBERIUM.get(), 100))
                .unlockedBy("has_tiberium_bucket", has(ModItems.MOLTEN_TIBERIUM_BUCKET.get())).save(consumer);

        new TiberiumInfuserRecipeBuilder(ModBlocks.SEEDED_DIRT.get(), ModBlocks.YELLOW_ZONE_CRACKED_DIRT.get(), 1, 100, 1,
                new FluidStack(ModFluids.SOURCE_MOLTEN_TIBERIUM.get(), 100))
                .unlockedBy("has_tiberium_bucket", has(ModItems.MOLTEN_TIBERIUM_BUCKET.get())).save(consumer);



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

    protected static void stonecutterResultFromBase(Consumer<FinishedRecipe> pFinishedRecipeConsumer,
                                                    RecipeCategory pCategory, ItemLike pResult, ItemLike pMaterial) {
        stonecutterResultFromBase(pFinishedRecipeConsumer, pCategory, pResult, pMaterial, 1);
    }

    protected static void stonecutterResultFromBase(Consumer<FinishedRecipe> pFinishedRecipeConsumer, RecipeCategory pCategory,
                                                    ItemLike pResult, ItemLike pMaterial, int pResultCount) {
        SingleItemRecipeBuilder var10000 = SingleItemRecipeBuilder.stonecutting(Ingredient.of(new ItemLike[]{pMaterial}),
                pCategory, pResult, pResultCount).unlockedBy(getHasName(pMaterial), has(pMaterial));
        String var10002 = getConversionRecipeName(pResult, pMaterial);
        var10000.save(pFinishedRecipeConsumer, var10002 + "_stonecutting");
    }


}
