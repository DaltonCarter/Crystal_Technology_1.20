package com.CartersDev.crystechmod.item;

import com.CartersDev.crystechmod.CrystalTech;


import com.CartersDev.crystechmod.item.custom.Firestone;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
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


//Misc Items
    public static final RegistryObject<Item> FIRESTONE = ITEMS.register("firestone",
        () -> new Firestone(new Item.Properties().setNoRepair().durability(10)));

    public static final RegistryObject<Item> PLAGUED_STICK = ITEMS.register("plagued_stick",
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
