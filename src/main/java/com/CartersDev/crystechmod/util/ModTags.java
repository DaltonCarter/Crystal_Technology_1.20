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

        public static final TagKey<Block> NEEDS_PLAGUED_TOOL = tag("needs_plagued_tool");
        public static final TagKey<Block> NEEDS_GUNDANIUM_TOOL = tag("needs_gundanium_tool");
        public static final TagKey<Block> NEEDS_ALYTHUM_TOOL = tag("needs_alythum_tool");
        public static final TagKey<Block> PAXEL_MINEABLE = tag("mineable/paxel");
        public static final TagKey<Block> VULNERABLE_LEAVES = tag("vulnerable_leaves");
        public static final TagKey<Block> TIBERIUM_VULNERABLE_WOOD= tag("tiberium_vulnerable_wood");
        public static final TagKey<Block> TIBERCRETE_SANDS= tag("tibercrete_sands");
        public static final TagKey<Block> TIBERIUM_VIABLE_BLOCKS= tag("tiberium_viable_blocks");
        public static final TagKey<Block> TIBERIUM_SEED_BLOCKS= tag("tiberium_seed_block");
        public static final TagKey<Block> HAZMAT_GLASS_PANES= tag("hazmat_glass_panes");
        public static final TagKey<Block> HAZMAT_GLASS_PANES2= tag("hazmat_glass_panes2");
        public static final TagKey<Block> TIBERIUM_SOIL= tag("tiberium_soil");
        public static final TagKey<Block> EMBER_OAK_LOGS= tag("ember_oak_logs");
        public static final TagKey<Block> MARIKA_OAK_LOGS= tag("marika_oak_logs");
        public static final TagKey<Block> DEAD_LOGS= tag("dead_logs");
        public static final TagKey<Block> PLAGUED_LOGS= tag("plagued_logs");
        public static final TagKey<Block> MOD_PLANKS= tag("mod_planks");




        private static TagKey<Block> tag(String name) {
            return BlockTags.create(new ResourceLocation(CrystalTech.MOD_ID, name));
        }
    }

    public static class Items {
        public static final TagKey<Item> TIBERCRETE_SANDS= tag("tibercrete_sands");
        public static final TagKey<Item> STICKS= tag("sticks");
        public static final TagKey<Item> HAZMAT_GLASS_PANES= tag("hazmat_glass_panes");
        public static final TagKey<Item> HAZMAT_GLASS_PANES2= tag("hazmat_glass_panes2");
        public static final TagKey<Item> EMBER_OAK_LOGS= tag("ember_oak_logs");
        public static final TagKey<Item> MARIKA_OAK_LOGS= tag("marika_oak_logs");
        public static final TagKey<Item> DEAD_LOGS= tag("dead_logs");
        public static final TagKey<Item> PLAGUED_LOGS= tag("plagued_logs");
        public static final TagKey<Item> MOD_PLANKS= tag("mod_planks");






        private static TagKey<Item> tag(String name) {
            return ItemTags.create(new ResourceLocation(CrystalTech.MOD_ID, name));
        }
    }




}
