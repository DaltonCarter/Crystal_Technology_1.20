package com.CartersDev.crystechmod.item;

import com.CartersDev.crystechmod.CrystalTech;


import com.CartersDev.crystechmod.item.custom.Firestone;
import net.minecraft.world.item.*;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;


public class ModItems {

    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, CrystalTech.MOD_ID);

//Foods
public static final RegistryObject<Item> TIBERIUM_FRUIT = ITEMS.register("tiberium_fruit",
        () -> new Item(new Item.Properties().food(ModFoods.TIBERIUM_FRUIT)));
//End of Foods


//Minerals:

public static final RegistryObject<Item> TIBERIUM = ITEMS.register("tiberium",
        () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> TIBERIUM_BLUE = ITEMS.register("tiberium_blue",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> TIBERIUM_RED = ITEMS.register("tiberium_red",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> TIBERIUM_PURPLE = ITEMS.register("tiberium_purple",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> AERIES_CRYSTAL = ITEMS.register("aeries_crystal",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> ILLUMINA_CRYSTAL = ITEMS.register("illumina_crystal",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> KRYON_CRYSTAL = ITEMS.register("kryon_crystal",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> ENIGMA_CRYSTAL = ITEMS.register("enigma_crystal",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> RAW_QUALRITE = ITEMS.register("raw_qualrite",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> RAW_GUNDANIUM = ITEMS.register("raw_gundanium",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> RAW_ALYTHUM = ITEMS.register("raw_alythum",
            () -> new Item(new Item.Properties()));
//End of Minerals


//Dusts

//public static final RegistryObject<Item> GREEN_TIBERIUM_DUST = ITEMS.register("green_tiberium_dust",
//        () -> new BlockItem(ModBlocks.GREEN_TIBERIUM_CROP.get(), new Item.Properties()
//                .food(new Food.Builder().fastToEat().effect(() -> new EffectInstance(Effects.POISON, 100, 0), 1f)
//                        .build()).group(ModItemGroup.CRYS_TECH)));
//
//    public static final RegistryObject<Item> BLUE_TIBERIUM_DUST = ITEMS.register("blue_tiberium_dust",
//            () -> new BlockItem(ModBlocks.BLUE_TIBERIUM_CROP.get(), new Item.Properties()
//                    .food(new Food.Builder().fastToEat().effect(() -> new EffectInstance(Effects.POISON, 100, 2), 1f)
//                            .build()).group(ModItemGroup.CRYS_TECH)));
//
//    public static final RegistryObject<Item> RED_TIBERIUM_DUST = ITEMS.register("red_tiberium_dust",
//            () -> new BlockItem(ModBlocks.RED_TIBERIUM_CROP.get(), new Item.Properties()
//                    .food(new Food.Builder().fastToEat().effect(() -> new EffectInstance(Effects.POISON, 100, 0), 1f)
//                            .build()).group(ModItemGroup.CRYS_TECH)));
//
//    public static final RegistryObject<Item> PURPLE_TIBERIUM_DUST = ITEMS.register("purple_tiberium_dust",
//            () -> new BlockItem(ModBlocks.PURPLE_TIBERIUM_CROP.get(), new Item.Properties()
//                    .food(new Food.Builder().fastToEat().effect(() -> new EffectInstance(Effects.POISON, 100, 2), 1f)
//                            .build()).group(ModItemGroup.CRYS_TECH)));

    public static final RegistryObject<Item> QUALRIM_COMPOUND = ITEMS.register("qualrim_compound",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> GUNDANIUM_DUST = ITEMS.register("gundanium_dust",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> ALYTHUM_DUST = ITEMS.register("alythum_dust",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> ILLYRIM_BLEND = ITEMS.register("illyrim_blend",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> LG_CORE_BLEND = ITEMS.register("lg_core_blend",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> MG_CORE_BLEND = ITEMS.register("mg_core_blend",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> HG_CORE_BLEND = ITEMS.register("hg_core_blend",
            () -> new Item(new Item.Properties()));
//end of Dusts


//Metals & Raw Metals

public static final RegistryObject<Item> GUNDANIUM_INGOT = ITEMS.register("gundanium_ingot",
        () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> ALYTHUM_INGOT = ITEMS.register("alythum_ingot",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> ILLYRIM_INGOT = ITEMS.register("illyrim_ingot",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> LG_CORE_INGOT = ITEMS.register("lg_core_ingot",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> MG_CORE_INGOT = ITEMS.register("mg_core_ingot",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> HG_CORE_INGOT = ITEMS.register("hg_core_ingot",
            () -> new Item(new Item.Properties()));
//End of Metals & Raw Metals


    //Tools
    public static final RegistryObject<Item> PLAGUED_SWORD = ITEMS.register("plagued_sword",
            () -> new SwordItem(ModToolTiers.PLAGUED, 2, -1.5f,
                    new Item.Properties()));

    public static final RegistryObject<Item> PLAGUED_AXE = ITEMS.register("plagued_axe",
            () -> new AxeItem(ModToolTiers.PLAGUED, 6, -2.5f,
                    new Item.Properties()));

    public static final RegistryObject<Item> PLAGUED_PICKAXE = ITEMS.register("plagued_pickaxe",
            () -> new PickaxeItem(ModToolTiers.PLAGUED, 1, -1.8f,
                    new Item.Properties()));

    public static final RegistryObject<Item> PLAGUED_SHOVEL = ITEMS.register("plagued_shovel",
            () -> new ShovelItem(ModToolTiers.PLAGUED, 1.5f, -2f,
                    new Item.Properties()));

    public static final RegistryObject<Item> PLAGUED_HOE = ITEMS.register("plagued_hoe",
            () -> new HoeItem(ModToolTiers.PLAGUED, 0, -2f,
                    new Item.Properties()));

    public static final RegistryObject<Item> GUNDANIUM_SWORD = ITEMS.register("gundanium_sword",
            () -> new SwordItem(ModToolTiers.GUNDANIUM, 2, -2f,
                    new Item.Properties()));

    public static final RegistryObject<Item> GUNDANIUM_AXE = ITEMS.register("gundanium_axe",
            () -> new AxeItem(ModToolTiers.GUNDANIUM, 5, -2.5f,
                    new Item.Properties()));

    public static final RegistryObject<Item> GUNDANIUM_PICKAXE = ITEMS.register("gundanium_pickaxe",
            () -> new PickaxeItem(ModToolTiers.GUNDANIUM, 2, -2f,
                    new Item.Properties()));

    public static final RegistryObject<Item> GUNDANIUM_SHOVEL = ITEMS.register("gundanium_shovel",
            () -> new ShovelItem(ModToolTiers.GUNDANIUM, 2, -2f,
                    new Item.Properties()));

    public static final RegistryObject<Item> GUNDANIUM_HOE = ITEMS.register("gundanium_hoe",
            () -> new HoeItem(ModToolTiers.GUNDANIUM, -1, 0f,
                    new Item.Properties()));
    //End Tools


    //Armors

    public static final RegistryObject<Item> GUNDANIUM_HELMET = ITEMS.register("gundanium_helmet",
            () -> new ArmorItem(ModArmorMaterials.GUNDANIUM, ArmorItem.Type.HELMET,
                    new Item.Properties()));

    public static final RegistryObject<Item> GUNDANIUM_CHESTPLATE = ITEMS.register("gundanium_chestplate",
            () -> new ArmorItem(ModArmorMaterials.GUNDANIUM, ArmorItem.Type.CHESTPLATE,
                    new Item.Properties()));

    public static final RegistryObject<Item> GUNDANIUM_LEGGINGS = ITEMS.register("gundanium_leggings",
            () -> new ArmorItem(ModArmorMaterials.GUNDANIUM, ArmorItem.Type.LEGGINGS,
                    new Item.Properties()));

    public static final RegistryObject<Item> GUNDANIUM_BOOTS = ITEMS.register("gundanium_boots",
            () -> new ArmorItem(ModArmorMaterials.GUNDANIUM, ArmorItem.Type.BOOTS,
                    new Item.Properties()));

    public static final RegistryObject<Item> GUNDANIUM_HORSE_ARMOR = ITEMS.register("gundanium_horse_armor",
            () -> new HorseArmorItem(9, "gundanium",
                    new Item.Properties()));

    public static final RegistryObject<Item> ALYTHUM_HELMET = ITEMS.register("alythum_helmet",
            () -> new ArmorItem(ModArmorMaterials.ALYTHUM, ArmorItem.Type.HELMET,
                    new Item.Properties()));

    public static final RegistryObject<Item> ALYTHUM_CHESTPLATE = ITEMS.register("alythum_chestplate",
            () -> new ArmorItem(ModArmorMaterials.ALYTHUM, ArmorItem.Type.CHESTPLATE,
                    new Item.Properties()));

    public static final RegistryObject<Item> ALYTHUM_LEGGINGS = ITEMS.register("alythum_leggings",
            () -> new ArmorItem(ModArmorMaterials.ALYTHUM, ArmorItem.Type.LEGGINGS,
                    new Item.Properties()));

    public static final RegistryObject<Item> ALYTHUM_BOOTS = ITEMS.register("alythum_boots",
            () -> new ArmorItem(ModArmorMaterials.ALYTHUM, ArmorItem.Type.BOOTS,
                    new Item.Properties()));

    public static final RegistryObject<Item> HAZMAT_MK1_HELMET = ITEMS.register("hazmat_mk1_helmet",
            () -> new ArmorItem(ModArmorMaterials.HAZMAT_MK1, ArmorItem.Type.HELMET,
                    new Item.Properties()));

    public static final RegistryObject<Item> HAZMAT_MK1_CHESTPLATE = ITEMS.register("hazmat_mk1_chestplate",
            () -> new ArmorItem(ModArmorMaterials.HAZMAT_MK1, ArmorItem.Type.CHESTPLATE,
                    new Item.Properties()));

    public static final RegistryObject<Item> HAZMAT_MK1_LEGGINGS = ITEMS.register("hazmat_mk1_leggings",
            () -> new ArmorItem(ModArmorMaterials.HAZMAT_MK1, ArmorItem.Type.LEGGINGS,
                    new Item.Properties()));

    public static final RegistryObject<Item> HAZMAT_MK1_BOOTS = ITEMS.register("hazmat_mk1_boots",
            () -> new ArmorItem(ModArmorMaterials.HAZMAT_MK1, ArmorItem.Type.BOOTS,
                    new Item.Properties()));

    public static final RegistryObject<Item> HAZMAT_MK2_HELMET = ITEMS.register("hazmat_mk2_helmet",
            () -> new ArmorItem(ModArmorMaterials.HAZMAT_MK2, ArmorItem.Type.HELMET,
                    new Item.Properties()));

    public static final RegistryObject<Item> HAZMAT_MK2_CHESTPLATE = ITEMS.register("hazmat_mk2_chestplate",
            () -> new ArmorItem(ModArmorMaterials.HAZMAT_MK2, ArmorItem.Type.CHESTPLATE,
                    new Item.Properties()));

    public static final RegistryObject<Item> HAZMAT_MK2_LEGGINGS = ITEMS.register("hazmat_mk2_leggings",
            () -> new ArmorItem(ModArmorMaterials.HAZMAT_MK2, ArmorItem.Type.LEGGINGS,
                    new Item.Properties()));

    public static final RegistryObject<Item> HAZMAT_MK2_BOOTS = ITEMS.register("hazmat_mk2_boots",
            () -> new ArmorItem(ModArmorMaterials.HAZMAT_MK2, ArmorItem.Type.BOOTS,
                    new Item.Properties()));

    //End Armors



//Misc Items
    public static final RegistryObject<Item> FIRESTONE = ITEMS.register("firestone",
        () -> new Firestone(new Item.Properties().setNoRepair().durability(10)));

    public static final RegistryObject<Item> PLAGUED_STICK = ITEMS.register("plagued_stick",
        () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> TIBERIUM_LEATHER = ITEMS.register("tiberium_leather",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> ICHOR_LEATHER = ITEMS.register("ichor_leather",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> GDI_EMBLEM = ITEMS.register("gdi_emblem",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> NOD_EMBLEM = ITEMS.register("nod_emblem",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> WOLF_EMBLEM = ITEMS.register("wolf_emblem",
            () -> new Item(new Item.Properties()));
//End of Misc Items




    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
