package com.CartersDev.crystechmod.util;

import com.CartersDev.crystechmod.CrystalTech;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

public class ModTags {

    public static class Blocks {

        public static final TagKey<Block> METAL_DETECTOR_VALUABLES = tag("metal_detector_valuables");
        public static final TagKey<Block> VULNERABLE_LEAVES = tag("vulnerable_leaves");
        public static final TagKey<Block> TIBERIUM_VULNERABLE_WOOD= tag("tiberium_vulnerable_wood");
        public static final TagKey<Block> TIBERCRETE_SANDS= tag("tibercrete_sands");



        private static TagKey<Block> tag(String name) {
            return BlockTags.create(new ResourceLocation(CrystalTech.MOD_ID, name));
        }
    }

    public static class Items {
        public static final TagKey<Item> TIBERCRETE_SANDS= tag("tibercrete_sands");




        private static TagKey<Item> tag(String name) {
            return ItemTags.create(new ResourceLocation(CrystalTech.MOD_ID, name));
        }
    }




}
