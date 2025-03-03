package com.CartersDev.crystechmod.item;

import com.CartersDev.crystechmod.CrystalTech;


import com.CartersDev.crystechmod.block.ModBlocks;
import com.CartersDev.crystechmod.entity.ModEntities;
import com.CartersDev.crystechmod.fluid.ModFluids;
import com.CartersDev.crystechmod.item.custom.*;
import com.CartersDev.crystechmod.sound.ModSounds;
import net.minecraft.world.item.*;
import net.minecraftforge.common.ForgeSpawnEggItem;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;


public class ModItems {

    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, CrystalTech.MOD_ID);

//Foods & Seeds
public static final RegistryObject<Item> TIBERIUM_FRUIT = ITEMS.register("tiberium_fruit",
        () -> new Item(new Item.Properties().food(ModFoods.TIBERIUM_FRUIT)));

    public static final RegistryObject<Item> HEIM_BERRY = ITEMS.register("heim_berry",
            () -> new Item(new Item.Properties().food(ModFoods.HEIM_BERRY)));

    public static final RegistryObject<Item> LAI_MELON_SLICE = ITEMS.register("lai_melon_slice",
            () -> new Item(new Item.Properties().food(ModFoods.LAI_MELON_SLICE)));

    public static final RegistryObject<Item> HEL_FRUIT = ITEMS.register("hel_fruit",
            () -> new Item(new Item.Properties().food(ModFoods.HEL_FRUIT)));

    public static final RegistryObject<Item> SABER_CORN = ITEMS.register("saber_corn",
            () -> new Item(new Item.Properties().food(ModFoods.SABER_CORN)));

    public static final RegistryObject<Item> HEL_FRUIT_SEEDS = ITEMS.register("hel_fruit_seeds",
            () -> new ItemNameBlockItem(ModBlocks.HEL_FRUIT_CROP.get(), new Item.Properties()));

    public static final RegistryObject<Item> LAI_MELON_SEEDS = ITEMS.register("lai_melon_seeds",
            () -> new ItemNameBlockItem(ModBlocks.LAI_MELON_STEM.get(), new Item.Properties()));

    public static final RegistryObject<Item> HEIM_BERRY_SEEDS = ITEMS.register("heim_berry_seeds",
            () -> new ItemNameBlockItem(ModBlocks.HEIM_BERRY_CROP.get(), new Item.Properties()));

    public static final RegistryObject<Item> SABER_CORN_SEEDS = ITEMS.register("saber_corn_seeds",
            () -> new ItemNameBlockItem(ModBlocks.SABER_CORN_CROP.get(), new Item.Properties()));

    public static final RegistryObject<Item> RAW_INFECTED_MEAT = ITEMS.register("raw_infected_meat",
            () -> new Item(new Item.Properties().food(ModFoods.RAW_INFECTED_MEAT)));

    public static final RegistryObject<Item> COOKED_INFECTED_MEAT = ITEMS.register("cooked_infected_meat",
            () -> new Item(new Item.Properties().food(ModFoods.COOKED_INFECTED_MEAT)));

    public static final RegistryObject<Item> ZAIRAN_FRUIT_SALAD = ITEMS.register("zairan_fruit_salad",
            () -> new Item(new Item.Properties().food(ModFoods.ZAIRAN_FRUIT_SALAD)));

    public static final RegistryObject<Item> SABER_BREAD = ITEMS.register("saber_bread",
            () -> new Item(new Item.Properties().food(ModFoods.SABER_BREAD)));



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


//End of Minerals


//Dusts

public static final RegistryObject<Item> GREEN_TIBERIUM_DUST = ITEMS.register("green_tiberium_dust",
        () -> new TiberiumDust(ModBlocks.GREEN_TIBERIUM_CROP.get(), new Item.Properties()));

    public static final RegistryObject<Item> BLUE_TIBERIUM_DUST = ITEMS.register("blue_tiberium_dust",
            () -> new BlueTiberiumDust(ModBlocks.BLUE_TIBERIUM_CROP.get(), new Item.Properties()));

    public static final RegistryObject<Item> RED_TIBERIUM_DUST = ITEMS.register("red_tiberium_dust",
            () -> new RedTiberiumDust(ModBlocks.RED_TIBERIUM_CROP.get(), new Item.Properties()));

    public static final RegistryObject<Item> PURPLE_TIBERIUM_DUST = ITEMS.register("purple_tiberium_dust",
            () -> new PurpleTiberiumDust(ModBlocks.PURPLE_TIBERIUM_CROP.get(), new Item.Properties()));

    public static final RegistryObject<Item> QUALRIM_COMPOUND = ITEMS.register("qualrim_compound",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> GUNDANIUM_DUST = ITEMS.register("gundanium_dust",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> COPPER_DUST = ITEMS.register("copper_dust",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> IRON_DUST = ITEMS.register("iron_dust",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> GOLD_DUST = ITEMS.register("gold_dust",
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

    public static final RegistryObject<Item> YOKARAN_BLOOM_POWDER = ITEMS.register("yokaran_bloom_powder",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> DEVILS_BLOOD_POWDER = ITEMS.register("devils_blood_powder",
            () -> new Item(new Item.Properties()));
//end of Dusts


//Metals & Raw Metals

    public static final RegistryObject<Item> RAW_QUALRITE = ITEMS.register("raw_qualrite",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> RAW_GUNDANIUM = ITEMS.register("raw_gundanium",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> RAW_ALYTHUM = ITEMS.register("raw_alythum",
            () -> new Item(new Item.Properties()));

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
            () -> new SwordItem(ModToolTiers.GUNDANIUM, 3, -2f,
                    new Item.Properties()));

    public static final RegistryObject<Item> GUNDANIUM_AXE = ITEMS.register("gundanium_axe",
            () -> new AxeItem(ModToolTiers.GUNDANIUM, 6, -2.5f,
                    new Item.Properties()));

    public static final RegistryObject<Item> GUNDANIUM_PICKAXE = ITEMS.register("gundanium_pickaxe",
            () -> new PickaxeItem(ModToolTiers.GUNDANIUM, 3, -2f,
                    new Item.Properties()));

    public static final RegistryObject<Item> GUNDANIUM_SHOVEL = ITEMS.register("gundanium_shovel",
            () -> new ShovelItem(ModToolTiers.GUNDANIUM, 2, -2f,
                    new Item.Properties()));

    public static final RegistryObject<Item> GUNDANIUM_HOE = ITEMS.register("gundanium_hoe",
            () -> new HoeItem(ModToolTiers.GUNDANIUM, -1, 0f,
                    new Item.Properties()));

    public static final RegistryObject<Item> GUNDANIUM_PAXEL = ITEMS.register("gundanium_paxel",
            () -> new PaxelItem(ModToolTiers.GUNDANIUM, 1, 1f,
                    new Item.Properties()));

    public static final RegistryObject<Item> GUNDANIUM_HAMMER = ITEMS.register("gundanium_hammer",
            () -> new HammerItem(ModToolTiers.GUNDANIUM, 1, -1f,
                    new Item.Properties().durability(1500)));

    public static final RegistryObject<Item> ALYTHUM_SWORD = ITEMS.register("alythum_sword",
            () -> new SwordItem(ModToolTiers.ALYTHUM, 4, -1.5f,
                    new Item.Properties()));

    public static final RegistryObject<Item> ALYTHUM_AXE = ITEMS.register("alythum_axe",
            () -> new AxeItem(ModToolTiers.ALYTHUM, 7, -2.0f,
                    new Item.Properties()));

    public static final RegistryObject<Item> ALYTHUM_PICKAXE = ITEMS.register("alythum_pickaxe",
            () -> new PickaxeItem(ModToolTiers.ALYTHUM, 3, -1.5f,
                    new Item.Properties()));

    public static final RegistryObject<Item> ALYTHUM_SHOVEL = ITEMS.register("alythum_shovel",
            () -> new ShovelItem(ModToolTiers.ALYTHUM, 2, -1f,
                    new Item.Properties()));

    public static final RegistryObject<Item> ALYTHUM_HOE = ITEMS.register("alythum_hoe",
            () -> new HoeItem(ModToolTiers.ALYTHUM, -1, 1f,
                    new Item.Properties()));

    public static final RegistryObject<Item> ALYTHUM_PAXEL = ITEMS.register("alythum_paxel",
            () -> new PaxelItem(ModToolTiers.ALYTHUM, 3, 2f,
                    new Item.Properties()));

    public static final RegistryObject<Item> ALYTHUM_HAMMER = ITEMS.register("alythum_hammer",
            () -> new HammerItem(ModToolTiers.ALYTHUM, 3, -2f,
                    new Item.Properties().durability(5000)));

    public static final RegistryObject<Item> PLAGUED_BOW = ITEMS.register("plagued_bow",
            () -> new BowItem(new Item.Properties().durability(684)));

    public static final RegistryObject<Item> ILLYRIM_SWORD = ITEMS.register("illyrim_sword",
            () -> new SwordItem(ModToolTiers.ILLYRIM, 6, -1.0f,
                    new Item.Properties()));




    public static final RegistryObject<Item> ILLYRIM_AXE = ITEMS.register("illyrim_axe",
            () -> new AxeItem(ModToolTiers.ILLYRIM, 9, -1.5f,
                    new Item.Properties()));

    public static final RegistryObject<Item> ILLYRIM_PICKAXE = ITEMS.register("illyrim_pickaxe",
            () -> new PickaxeItem(ModToolTiers.ILLYRIM, 5, -1.5f,
                    new Item.Properties()));

    public static final RegistryObject<Item> ILLYRIM_SHOVEL = ITEMS.register("illyrim_shovel",
            () -> new ShovelItem(ModToolTiers.ILLYRIM, 4, -1f,
                    new Item.Properties()));

    public static final RegistryObject<Item> ILLYRIM_HOE = ITEMS.register("illyrim_hoe",
            () -> new HoeItem(ModToolTiers.ILLYRIM, 0, 1f,
                    new Item.Properties()));

    public static final RegistryObject<Item> ILLYRIM_PAXEL = ITEMS.register("illyrim_paxel",
            () -> new PaxelItem(ModToolTiers.ILLYRIM, 5, 2f,
                    new Item.Properties()));

    public static final RegistryObject<Item> ILLYRIM_HAMMER = ITEMS.register("illyrim_hammer",
            () -> new HammerItem(ModToolTiers.ILLYRIM, 5, -2f,
                    new Item.Properties().durability(10000)));
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

    public static final RegistryObject<Item> ILLYRIM_HELMET = ITEMS.register("illyrim_helmet",
            () -> new ArmorItem(ModArmorMaterials.ILLYRIM, ArmorItem.Type.HELMET,
                    new Item.Properties()));

    public static final RegistryObject<Item> ILLYRIM_CHESTPLATE = ITEMS.register("illyrim_chestplate",
            () -> new ArmorItem(ModArmorMaterials.ILLYRIM, ArmorItem.Type.CHESTPLATE,
                    new Item.Properties()));

    public static final RegistryObject<Item> ILLYRIM_LEGGINGS = ITEMS.register("illyrim_leggings",
            () -> new ArmorItem(ModArmorMaterials.ILLYRIM, ArmorItem.Type.LEGGINGS,
                    new Item.Properties()));

    public static final RegistryObject<Item> ILLYRIM_BOOTS = ITEMS.register("illyrim_boots",
            () -> new ArmorItem(ModArmorMaterials.ILLYRIM, ArmorItem.Type.BOOTS,
                    new Item.Properties()));


    //End Armors


    //Spawn Eggs
    public static final RegistryObject<Item> RHINO_SPAWN_EGG = ITEMS.register("rhino_spawn_egg",
            () -> new ForgeSpawnEggItem(ModEntities.RHINO, 0x7e9680, 0xc5d1c5,
                    new Item.Properties()));


    //End of Spawn Eggs


    //Music Discs
    public static final RegistryObject<Item> STILL_ALONE_MUSIC_DISC = ITEMS.register("still_alone_music_disc",
            () -> new RecordItem(6, ModSounds.STILL_ALONE,
                    new Item.Properties().stacksTo(1), 5140));

    public static final RegistryObject<Item> HYOUHAKU_WANDERING_MUSIC_DISC = ITEMS.register("hyouhaku_wandering_music_disc",
            () -> new RecordItem(6, ModSounds.HYOUHAKU_WANDERING,
                    new Item.Properties().stacksTo(1), 2780));

    public static final RegistryObject<Item> CORRODED_VALVES_MUSIC_DISC = ITEMS.register("corroded_valves_music_disc",
            () -> new RecordItem(6, ModSounds.CORRODED_VALVES,
                    new Item.Properties().stacksTo(1), 5720));

    public static final RegistryObject<Item> DARK_MACHINATIONS_MUSIC_DISC = ITEMS.register("dark_machinations_music_disc",
            () -> new RecordItem(6, ModSounds.DARK_MACHINATIONS,
                    new Item.Properties().stacksTo(1), 7060));

    public static final RegistryObject<Item> DARK_VALLEY_MUSIC_DISC = ITEMS.register("dark_valley_music_disc",
            () -> new RecordItem(6, ModSounds.DARK_VALLEY,
                    new Item.Properties().stacksTo(1), 6940));

    public static final RegistryObject<Item> EAGLES_DAWN_MUSIC_DISC = ITEMS.register("eagles_dawn_music_disc",
            () -> new RecordItem(6, ModSounds.EAGLES_DAWN,
                    new Item.Properties().stacksTo(1), 6080));

    public static final RegistryObject<Item> MANUFACTORY_MUSIC_DISC = ITEMS.register("manufactory_music_disc",
            () -> new RecordItem(6, ModSounds.MANUFACTORY,
                    new Item.Properties().stacksTo(1), 6600));

    public static final RegistryObject<Item> NECROFUNK_MUSIC_DISC = ITEMS.register("necrofunk_music_disc",
            () -> new RecordItem(6, ModSounds.NECROFUNK,
                    new Item.Properties().stacksTo(1), 4460));

    public static final RegistryObject<Item> SCOUTING_MUSIC_DISC = ITEMS.register("scouting_music_disc",
            () -> new RecordItem(6, ModSounds.SCOUTING,
                    new Item.Properties().stacksTo(1), 5180));

    public static final RegistryObject<Item> PRODIGAL_SON_MUSIC_DISC = ITEMS.register("prodigal_son_music_disc",
            () -> new RecordItem(6, ModSounds.PRODIGAL_SON,
                    new Item.Properties().stacksTo(1), 5700));

    public static final RegistryObject<Item> PYROTEK_MUSIC_DISC = ITEMS.register("pyrotek_music_disc",
            () -> new RecordItem(6, ModSounds.PYROTEK,
                    new Item.Properties().stacksTo(1), 6280));

    public static final RegistryObject<Item> REPENTANCE_MUSIC_DISC = ITEMS.register("repentance_music_disc",
            () -> new RecordItem(6, ModSounds.REPENTANCE,
                    new Item.Properties().stacksTo(1), 5460));

    public static final RegistryObject<Item> SPACE_ECHO_MUSIC_DISC = ITEMS.register("space_echo_music_disc",
            () -> new RecordItem(6, ModSounds.SPACE_ECHO,
                    new Item.Properties().stacksTo(1), 4260));

    public static final RegistryObject<Item> TOMBS_MUSIC_DISC = ITEMS.register("tombs_music_disc",
            () -> new RecordItem(6, ModSounds.TOMBS,
                    new Item.Properties().stacksTo(1), 5600));

    public static final RegistryObject<Item> UNYIELDING_MUSIC_DISC = ITEMS.register("unyielding_music_disc",
            () -> new RecordItem(6, ModSounds.UNYIELDING,
                    new Item.Properties().stacksTo(1), 10660));

    public static final RegistryObject<Item> WIRES_MUSIC_DISC = ITEMS.register("wires_music_disc",
            () -> new RecordItem(6, ModSounds.WIRES,
                    new Item.Properties().stacksTo(1), 6840));

    public static final RegistryObject<Item> XENOPHILE_MUSIC_DISC = ITEMS.register("xenophile_music_disc",
            () -> new RecordItem(6, ModSounds.XENOPHILE,
                    new Item.Properties().stacksTo(1), 6820));

    public static final RegistryObject<Item> APPROACH_MUSIC_DISC = ITEMS.register("approach_music_disc",
            () -> new RecordItem(6, ModSounds.APPROACH,
                    new Item.Properties().stacksTo(1), 5660));

    public static final RegistryObject<Item> DUSK_HOUR_MUSIC_DISC = ITEMS.register("dusk_hour_music_disc",
            () -> new RecordItem(6, ModSounds.DUSK_HOUR,
                    new Item.Properties().stacksTo(1), 4740));

    public static final RegistryObject<Item> TS_DUSK_HOUR_MUSIC_DISC = ITEMS.register("ts_dusk_hour_music_disc",
            () -> new RecordItem(6, ModSounds.TS_DUSK_HOUR,
                    new Item.Properties().stacksTo(1), 4680));

    public static final RegistryObject<Item> HEROISM_MUSIC_DISC = ITEMS.register("heroism_music_disc",
            () -> new RecordItem(6, ModSounds.HEROISM,
                    new Item.Properties().stacksTo(1), 4860));

    public static final RegistryObject<Item> LONE_TROOPER_MUSIC_DISC = ITEMS.register("lone_trooper_music_disc",
            () -> new RecordItem(6, ModSounds.LONE_TROOPER,
                    new Item.Properties().stacksTo(1), 6720));

    public static final RegistryObject<Item> PHAROTEK_MUSIC_DISC = ITEMS.register("pharotek_music_disc",
            () -> new RecordItem(6, ModSounds.PHAROTEK,
                    new Item.Properties().stacksTo(1), 5960));

    public static final RegistryObject<Item> VALVES_MUSIC_DISC = ITEMS.register("valves_music_disc",
            () -> new RecordItem(6, ModSounds.VALVES,
                    new Item.Properties().stacksTo(1), 6200));

    public static final RegistryObject<Item> WHAT_LURKS_MUSIC_DISC = ITEMS.register("what_lurks_music_disc",
            () -> new RecordItem(6, ModSounds.WHAT_LURKS,
                    new Item.Properties().stacksTo(1), 5680));

    public static final RegistryObject<Item> AIRSTRIKE_MUSIC_DISC = ITEMS.register("airstrike_music_disc",
            () -> new RecordItem(6, ModSounds.AIRSTRIKE,
                    new Item.Properties().stacksTo(1), 3940));

    public static final RegistryObject<Item> HEROISM_2_MUSIC_DISC = ITEMS.register("heroism_2_music_disc",
            () -> new RecordItem(6, ModSounds.HEROISM_2,
                    new Item.Properties().stacksTo(1), 4920));

    public static final RegistryObject<Item> CREEPING_UPON_MUSIC_DISC = ITEMS.register("creeping_upon_music_disc",
            () -> new RecordItem(6, ModSounds.CREEPING_UPON,
                    new Item.Properties().stacksTo(1), 4340));

    public static final RegistryObject<Item> DEPTH_CHARGE_MUSIC_DISC = ITEMS.register("depth_charge_music_disc",
            () -> new RecordItem(6, ModSounds.DEPTH_CHARGE,
                    new Item.Properties().stacksTo(1), 5100));

    public static final RegistryObject<Item> DRONE_MUSIC_DISC = ITEMS.register("drone_music_disc",
            () -> new RecordItem(6, ModSounds.DRONE,
                    new Item.Properties().stacksTo(1), 5440));

    public static final RegistryObject<Item> ON_THE_PROWL_MUSIC_DISC = ITEMS.register("on_the_prowl_music_disc",
            () -> new RecordItem(6, ModSounds.ON_THE_PROWL,
                    new Item.Properties().stacksTo(1), 3640));

    public static final RegistryObject<Item> RAIN_IN_THE_NIGHT_MUSIC_DISC = ITEMS.register("rain_in_the_night_music_disc",
            () -> new RecordItem(6, ModSounds.RAIN_IN_THE_NIGHT,
                    new Item.Properties().stacksTo(1), 3080));

    public static final RegistryObject<Item> RECON_MUSIC_DISC = ITEMS.register("recon_music_disc",
            () -> new RecordItem(6, ModSounds.RECON,
                    new Item.Properties().stacksTo(1), 5240));

    public static final RegistryObject<Item> AWAITING_MUSIC_DISC = ITEMS.register("awaiting_music_disc",
            () -> new RecordItem(6, ModSounds.AWAITING,
                    new Item.Properties().stacksTo(1), 5300));

    public static final RegistryObject<Item> DENSE_MUSIC_DISC = ITEMS.register("dense_music_disc",
            () -> new RecordItem(6, ModSounds.DENSE,
                    new Item.Properties().stacksTo(1), 6040));

    public static final RegistryObject<Item> DERELICT_MUSIC_DISC = ITEMS.register("derelict_music_disc",
            () -> new RecordItem(6, ModSounds.DERELICT,
                    new Item.Properties().stacksTo(1), 7200));

    public static final RegistryObject<Item> RUN_MUSIC_DISC = ITEMS.register("run_music_disc",
            () -> new RecordItem(6, ModSounds.RUN,
                    new Item.Properties().stacksTo(1), 6260));

    public static final RegistryObject<Item> THE_SEARCH_MUSIC_DISC = ITEMS.register("the_search_music_disc",
            () -> new RecordItem(6, ModSounds.THE_SEARCH,
                    new Item.Properties().stacksTo(1), 5620));

    public static final RegistryObject<Item> TRENCHES_MUSIC_DISC = ITEMS.register("trenches_music_disc",
            () -> new RecordItem(6, ModSounds.TRENCHES,
                    new Item.Properties().stacksTo(1), 6400));

    public static final RegistryObject<Item> VECTOR_MUSIC_DISC = ITEMS.register("vector_music_disc",
            () -> new RecordItem(6, ModSounds.VECTOR,
                    new Item.Properties().stacksTo(1), 5160));

    public static final RegistryObject<Item> VOICE_RHYTHM_2_MUSIC_DISC = ITEMS.register("voice_rhythm_2_music_disc",
            () -> new RecordItem(6, ModSounds.VOICE_RHYTHM_2,
                    new Item.Properties().stacksTo(1), 5180));

    //End of Music Discs



//Misc Items
    public static final RegistryObject<Item> FIRESTONE = ITEMS.register("firestone",
        () -> new Firestone(new Item.Properties().setNoRepair().durability(10)));

    public static final RegistryObject<Item> PLAGUED_STICK = ITEMS.register("plagued_stick",
        () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> GRINDER_GEAR = ITEMS.register("grinder_gear",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> ILLYRIM_GRINDER_GEAR = ITEMS.register("illyrim_grinder_gear",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> TIBERIUM_COMPOSITE_INGOT = ITEMS.register("tiberium_composite_ingot",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> ICHOR_COMPOSITE_INGOT = ITEMS.register("ichor_composite_ingot",
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

    public static final RegistryObject<Item> TIBERIUM_WATER_BUCKET = ITEMS.register("tiberium_water_bucket",
            () -> new BucketItem(ModFluids.SOURCE_TIBERIUM_WATER, new Item.Properties().craftRemainder(Items.BUCKET)
                    .stacksTo(1)));

    public static final RegistryObject<Item> MOLTEN_TIBERIUM_BUCKET = ITEMS.register("molten_tiberium_bucket",
            () -> new BucketItem(ModFluids.SOURCE_MOLTEN_TIBERIUM, new Item.Properties().craftRemainder(Items.BUCKET)
                    .stacksTo(1)));

    public static final RegistryObject<Item> MOLTEN_BLUE_TIBERIUM_BUCKET = ITEMS.register("molten_blue_tiberium_bucket",
            () -> new BucketItem(ModFluids.SOURCE_MOLTEN_BLUE_TIBERIUM, new Item.Properties().craftRemainder(Items.BUCKET)
                    .stacksTo(1)));

    public static final RegistryObject<Item> MOLTEN_RED_TIBERIUM_BUCKET = ITEMS.register("molten_red_tiberium_bucket",
            () -> new BucketItem(ModFluids.SOURCE_MOLTEN_RED_TIBERIUM, new Item.Properties().craftRemainder(Items.BUCKET)
                    .stacksTo(1)));

    public static final RegistryObject<Item> MOLTEN_PURPLE_TIBERIUM_BUCKET = ITEMS.register("molten_purple_tiberium_bucket",
            () -> new BucketItem(ModFluids.SOURCE_MOLTEN_PURPLE_TIBERIUM, new Item.Properties().craftRemainder(Items.BUCKET)
                    .stacksTo(1)));

    public static final RegistryObject<Item> PLAGUED_SIGN = ITEMS.register("plagued_sign",
            () -> new SignItem(new Item.Properties().stacksTo(16), ModBlocks.PLAGUED_SIGN.get(), ModBlocks.PLAGUED_WALL_SIGN.get()));

    public static final RegistryObject<Item> PLAGUED_HANGING_SIGN = ITEMS.register("plagued_hanging_sign",
            () -> new HangingSignItem(ModBlocks.PLAGUED_HANGING_SIGN.get(), ModBlocks.PLAGUED_WALL_HANGING_SIGN.get(), new Item.Properties().stacksTo(16)));

    public static final RegistryObject<Item> EMBER_OAK_SIGN = ITEMS.register("ember_oak_sign",
            () -> new SignItem(new Item.Properties().stacksTo(16), ModBlocks.EMBER_OAK_SIGN.get(), ModBlocks.EMBER_OAK_WALL_SIGN.get()));

    public static final RegistryObject<Item> EMBER_OAK_HANGING_SIGN = ITEMS.register("ember_oak_hanging_sign",
            () -> new HangingSignItem(ModBlocks.EMBER_OAK_HANGING_SIGN.get(), ModBlocks.EMBER_OAK_WALL_HANGING_SIGN.get(), new Item.Properties().stacksTo(16)));

    public static final RegistryObject<Item> DEAD_SIGN = ITEMS.register("dead_sign",
            () -> new SignItem(new Item.Properties().stacksTo(16), ModBlocks.DEAD_SIGN.get(), ModBlocks.DEAD_WALL_SIGN.get()));

    public static final RegistryObject<Item> DEAD_HANGING_SIGN = ITEMS.register("dead_hanging_sign",
            () -> new HangingSignItem(ModBlocks.DEAD_HANGING_SIGN.get(), ModBlocks.DEAD_WALL_HANGING_SIGN.get(), new Item.Properties().stacksTo(16)));

    public static final RegistryObject<Item> MARIKA_OAK_SIGN = ITEMS.register("marika_oak_sign",
            () -> new SignItem(new Item.Properties().stacksTo(16), ModBlocks.MARIKA_OAK_SIGN.get(), ModBlocks.MARIKA_OAK_WALL_SIGN.get()));

    public static final RegistryObject<Item> MARIKA_OAK_HANGING_SIGN = ITEMS.register("marika_oak_hanging_sign",
            () -> new HangingSignItem(ModBlocks.MARIKA_OAK_HANGING_SIGN.get(), ModBlocks.MARIKA_OAK_WALL_HANGING_SIGN.get(), new Item.Properties().stacksTo(16)));
//End of Misc Items




    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
