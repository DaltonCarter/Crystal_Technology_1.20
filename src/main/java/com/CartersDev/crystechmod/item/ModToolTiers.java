package com.CartersDev.crystechmod.item;


import com.CartersDev.crystechmod.CrystalTech;
import com.CartersDev.crystechmod.block.ModBlocks;
import com.CartersDev.crystechmod.util.ModTags;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.Tiers;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.common.ForgeTier;
import net.minecraftforge.common.TierSortingRegistry;

import java.util.List;

public class ModToolTiers {
    public static final Tier PLAGUED = TierSortingRegistry.registerTier(
            new ForgeTier(1, 150, 4f, 1.5f, 7,
                    ModTags.Blocks.NEEDS_PLAGUED_TOOL, () -> Ingredient.of(ModBlocks.PLAGUED_PLANKS.get())),
            new ResourceLocation(CrystalTech.MOD_ID, "plagued"), List.of(Tiers.STONE), List.of());


    public static final Tier GUNDANIUM = TierSortingRegistry.registerTier(
            new ForgeTier(2, 500, 6.5f, 2.5f, 10,
                    ModTags.Blocks.NEEDS_GUNDANIUM_TOOL, () -> Ingredient.of(ModItems.GUNDANIUM_INGOT.get())),
            new ResourceLocation(CrystalTech.MOD_ID, "gundanium"), List.of(Tiers.IRON), List.of());


    public static final Tier ALYTHUM = TierSortingRegistry.registerTier(
            new ForgeTier(3, 1761, 9.0f, 3.5f, 13,
                    ModTags.Blocks.NEEDS_ALYTHUM_TOOL, () -> Ingredient.of(ModItems.ALYTHUM_INGOT.get())),
            new ResourceLocation(CrystalTech.MOD_ID, "alythum"), List.of(Tiers.DIAMOND), List.of());


    public static final Tier ILLYRIM = TierSortingRegistry.registerTier(
            new ForgeTier(4, 2500, 9.0f, 5f, 15,
                    ModTags.Blocks.NEEDS_ILLYRIM_TOOL, () -> Ingredient.of(ModItems.ILLYRIM_INGOT.get())),
            new ResourceLocation(CrystalTech.MOD_ID, "illyrim"), List.of(Tiers.NETHERITE), List.of());
}
