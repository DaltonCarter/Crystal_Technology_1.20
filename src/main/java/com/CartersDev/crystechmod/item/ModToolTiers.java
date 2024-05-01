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
            new ResourceLocation(CrystalTech.MOD_ID, "plagued"), List.of(Tiers.WOOD), List.of());


    public static final Tier GUNDANIUM = TierSortingRegistry.registerTier(
            new ForgeTier(2, 500, 6.5f, 3.5f, 10,
                    ModTags.Blocks.NEEDS_GUNDANIUM_TOOL, () -> Ingredient.of(ModItems.GUNDANIUM_INGOT.get())),
            new ResourceLocation(CrystalTech.MOD_ID, "gundanium"), List.of(Tiers.IRON), List.of());

}
