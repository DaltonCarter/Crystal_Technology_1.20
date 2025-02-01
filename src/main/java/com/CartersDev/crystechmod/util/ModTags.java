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
        public static final TagKey<Block> TIBERIUM_VULNERABLE_SAPLINGS= tag("tiberium_vulnerable_saplings");
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
        public static final TagKey<Block> CONCRETES= tag("concretes");
        public static final TagKey<Block> TIBERIUM_FLOWERS= tag("tiberium_flowers");


        //Worldgen & Carvers
        public static final TagKey<Block> VITRIC_EXPANSE_STONES= tag("vitric_expanse_stones");

        public static final TagKey<Block> VITRIC_EXPANSE_YZ_CARVER= tag("vitric_expanse_yz_carver");
        public static final TagKey<Block> VITRIC_EXPANSE_RZ_CARVER= tag("vitric_expanse_rz_carver");

        //Ores:
        public static final TagKey<Block> GUNDANIUM_ORES= tag("gundanium_ores");
        public static final TagKey<Block> ALYTHUM_ORES= tag("alythum_ores");
        public static final TagKey<Block> AERIES_ORES= tag("aeries_ores");
        public static final TagKey<Block> ILLUMINA_ORES= tag("illumina_ores");
        public static final TagKey<Block> KRYON_ORES= tag("kryon_ores");
        public static final TagKey<Block> ENIGMA_ORES= tag("enigma_ores");
        public static final TagKey<Block> QUALRITE_ORES= tag("enigma_ores");




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
        public static final TagKey<Item> CONCRETES= tag("concretes");

        public static final TagKey<Item> GUNDANIUM_ORES= tag("gundanium_ores");
        public static final TagKey<Item> ALYTHUM_ORES= tag("alythum_ores");
        public static final TagKey<Item> AERIES_ORES= tag("aeries_ores");
        public static final TagKey<Item> ILLUMINA_ORES= tag("illumina_ores");
        public static final TagKey<Item> KRYON_ORES= tag("kryon_ores");
        public static final TagKey<Item> ENIGMA_ORES= tag("enigma_ores");
        public static final TagKey<Item> QUALRITE_ORES= tag("enigma_ores");






        private static TagKey<Item> tag(String name) {
            return ItemTags.create(new ResourceLocation(CrystalTech.MOD_ID, name));
        }
    }




}
