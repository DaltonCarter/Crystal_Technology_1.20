package com.CartersDev.crystechmod.item;

import com.CartersDev.crystechmod.CrystalTech;
import com.CartersDev.crystechmod.block.ModBlocks;
import com.CartersDev.crystechmod.enchantment.ModEnchantments;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ItemLike;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModCreativeModTabs {

    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, CrystalTech.MOD_ID);

public static final RegistryObject<CreativeModeTab> INGREDIENTS_TAB = CREATIVE_MODE_TABS.register("crystal_technology_tab",
        () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.TIBERIUM.get()))
                .title(Component.translatable("creativetab.crystal_technology_tab"))
                .displayItems((itemDisplayParameters, output) -> {

//                    output.accept(ModBlocks.TEST_BLOCK.get());
//                    output.accept(ModBlocks.DOOR_CON.get());


                    output.accept(ModBlocks.FOOLS_VITRICIUM.get());
                    output.accept(ModBlocks.BLOSSOM_SPOUT.get());
                    output.accept(ModBlocks.BLOSSOM_CENTER.get());
                    output.accept(ModBlocks.BLOSSOM_BASE.get());


//                    output.accept(ModBlocks.NOD_CREST_LARGE.get());


                    output.accept(ModItems.PLAGUED_STICK.get());

                    output.accept(ModItems.YOKARAN_BLOOM_POWDER.get());
                    output.accept(ModItems.DEVILS_BLOOD_POWDER.get());

                    output.accept(ModItems.TIBERIUM_WATER_BUCKET.get());

                    output.accept(ModItems.TIBERIUM_LEATHER.get());
                    output.accept(ModItems.ICHOR_LEATHER.get());

                    output.accept(ModItems.LIQUID_PROTOCULTURE_BUCKET.get());
                    output.accept(ModItems.PROTO_STEEL.get());


                    output.accept(ModItems.FIRESTONE.get());
                    output.accept(ModBlocks.FIRESTONE_BLOCK.get());
                    output.accept(ModBlocks.FIRESTONE_WALL.get());

                    output.accept(ModItems.GREEN_TIBERIUM_DUST.get());
                    output.accept(ModItems.TIBERIUM.get());
                    output.accept(ModBlocks.TIBERIUM_BLOCK.get());
                    output.accept(ModItems.MOLTEN_TIBERIUM_BUCKET.get());
                    output.accept(ModItems.BLUE_TIBERIUM_DUST.get());
                    output.accept(ModItems.TIBERIUM_BLUE.get());
                    output.accept(ModBlocks.TIBERIUM_BLUE_BLOCK.get());
                    output.accept(ModItems.MOLTEN_BLUE_TIBERIUM_BUCKET.get());
                    output.accept(ModItems.RED_TIBERIUM_DUST.get());
                    output.accept(ModItems.TIBERIUM_RED.get());
                    output.accept(ModBlocks.TIBERIUM_RED_BLOCK.get());
                    output.accept(ModItems.MOLTEN_RED_TIBERIUM_BUCKET.get());
                    output.accept(ModItems.PURPLE_TIBERIUM_DUST.get());
                    output.accept(ModItems.TIBERIUM_PURPLE.get());
                    output.accept(ModBlocks.TIBERIUM_PURPLE_BLOCK.get());
                    output.accept(ModItems.MOLTEN_PURPLE_TIBERIUM_BUCKET.get());

                    output.accept(ModBlocks.AERIES_ORE.get());
                    output.accept(ModBlocks.DEEPSLATE_AERIES_ORE.get());
                    output.accept(ModBlocks.NETHER_AERIES_ORE.get());
                    output.accept(ModItems.AERIES_CRYSTAL.get());
                    output.accept(ModBlocks.AERIES_BLOCK.get());

                    output.accept(ModBlocks.ENIGMA_ORE.get());
                    output.accept(ModBlocks.DEEPSLATE_ENIGMA_ORE.get());
                    output.accept(ModBlocks.END_ENIGMA_ORE.get());
                    output.accept(ModItems.ENIGMA_CRYSTAL.get());
                    output.accept(ModBlocks.ENIGMA_BLOCK.get());

                    output.accept(ModBlocks.ILLUMINA_ORE.get());
                    output.accept(ModBlocks.DEEPSLATE_ILLUMINA_ORE.get());
                    output.accept(ModItems.ILLUMINA_CRYSTAL.get());
                    output.accept(ModBlocks.ILLUMINA_BLOCK.get());

                    output.accept(ModBlocks.KRYON_ORE.get());
                    output.accept(ModBlocks.DEEPSLATE_KRYON_ORE.get());
                    output.accept(ModBlocks.NETHER_KRYON_ORE.get());
                    output.accept(ModBlocks.END_KRYON_ORE.get());
                    output.accept(ModItems.KRYON_CRYSTAL.get());
                    output.accept(ModBlocks.KRYON_BLOCK.get());

                    output.accept(ModBlocks.QUALRITE_ORE.get());
                    output.accept(ModBlocks.DEEPSLATE_QUALRITE_ORE.get());
                    output.accept(ModBlocks.NETHER_QUALRITE_ORE.get());
                    output.accept(ModItems.RAW_QUALRITE.get());
                    output.accept(ModItems.QUALRIM_COMPOUND.get());

                    output.accept(ModItems.IRON_DUST.get());
                    output.accept(ModItems.COPPER_DUST.get());
                    output.accept(ModItems.GOLD_DUST.get());

                    output.accept(ModBlocks.GUNDANIUM_ORE.get());
                    output.accept(ModBlocks.DEEPSLATE_GUNDANIUM_ORE.get());
                    output.accept(ModItems.GUNDANIUM_DUST.get());
                    output.accept(ModItems.RAW_GUNDANIUM.get());
                    output.accept(ModItems.GUNDANIUM_INGOT.get());
                    output.accept(ModBlocks.GUNDANIUM_BLOCK.get());

                    output.accept(ModBlocks.HARMONIUM_ORE.get());
                    output.accept(ModBlocks.DEEPSLATE_HARMONIUM_ORE.get());
                    output.accept(ModBlocks.NETHER_HARMONIUM_ORE.get());
                    output.accept(ModBlocks.END_HARMONIUM_ORE.get());
                    output.accept(ModItems.HARMONIUM_DUST.get());
                    output.accept(ModItems.RAW_HARMONIUM.get());
                    output.accept(ModItems.HARMONIUM_INGOT.get());
                    output.accept(ModBlocks.HARMONIUM_BLOCK.get());

                    output.accept(ModBlocks.ALYTHUM_ORE.get());
                    output.accept(ModBlocks.DEEPSLATE_ALYTHUM_ORE.get());
                    output.accept(ModBlocks.NETHER_ALYTHUM_ORE.get());
                    output.accept(ModItems.ALYTHUM_DUST.get());
                    output.accept(ModItems.RAW_ALYTHUM.get());
                    output.accept(ModItems.ALYTHUM_INGOT.get());
                    output.accept(ModBlocks.ALYTHUM_BLOCK.get());

                    output.accept(ModItems.ILLYRIM_BLEND.get());
                    output.accept(ModItems.ILLYRIM_INGOT.get());
                    output.accept(ModBlocks.ILLYRIM_BLOCK.get());

                    output.accept(ModItems.LG_CORE_BLEND.get());
                    output.accept(ModItems.LG_CORE_INGOT.get());
                    output.accept(ModBlocks.LG_CORE_BLOCK.get());

                    output.accept(ModItems.MG_CORE_BLEND.get());
                    output.accept(ModItems.MG_CORE_INGOT.get());
                    output.accept(ModBlocks.MG_CORE_BLOCK.get());

                    output.accept(ModItems.HG_CORE_BLEND.get());
                    output.accept(ModItems.HG_CORE_INGOT.get());
                    output.accept(ModBlocks.HG_CORE_BLOCK.get());

                    output.accept(ModItems.GRINDER_GEAR.get());
                    output.accept(ModItems.ILLYRIM_GRINDER_GEAR.get());

                    output.accept(ModItems.TIBERIUM_COMPOSITE_INGOT.get());
                    output.accept(ModItems.ICHOR_COMPOSITE_INGOT.get());


                    output.accept(ModItems.GDI_EMBLEM.get());
                    output.accept(ModItems.NOD_EMBLEM.get());
                    output.accept(ModItems.WOLF_EMBLEM.get());


                })
                .build());

    public static final RegistryObject<CreativeModeTab> PLANT_TAB = CREATIVE_MODE_TABS.register("crystal_technology_plant_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.TIBERIUM_FRUIT.get()))
                    .title(Component.translatable("creativetab.crystal_technology_plant_tab"))
                    .displayItems((itemDisplayParameters, output) -> {

                        output.accept(ModBlocks.PLAGUED_SAPLING.get());
                        output.accept(ModBlocks.DYING_SAPLING.get());
                        output.accept(ModBlocks.EMBER_OAK_SAPLING.get());
                        output.accept(ModBlocks.MARIKA_OAK_SAPLING.get());
                        output.accept(ModItems.TIBERIUM_FRUIT.get());
                        output.accept(ModItems.HEL_FRUIT_SEEDS.get());
                        output.accept(ModItems.HEL_FRUIT.get());
                        output.accept(ModItems.HEIM_BERRY_SEEDS.get());
                        output.accept(ModItems.HEIM_BERRY.get());
                        output.accept(ModItems.LAI_MELON_SEEDS.get());
                        output.accept(ModItems.LAI_MELON_SLICE.get());
                        output.accept(ModBlocks.LAI_MELON.get());
                        output.accept(ModItems.ZAIRAN_FRUIT_SALAD.get());
                        output.accept(ModItems.SABER_CORN_SEEDS.get());
                        output.accept(ModItems.SABER_CORN.get());
                        output.accept(ModItems.SABER_BREAD.get());
                        output.accept(ModItems.RAW_INFECTED_MEAT.get());
                        output.accept(ModItems.COOKED_INFECTED_MEAT.get());
                        output.accept(ModBlocks.HYACINTH.get());
                        output.accept(ModBlocks.FLOWER_OF_LIFE.get());
                        output.accept(ModBlocks.DEVILS_BLOOD.get());
                        output.accept(ModBlocks.YOKARAN_BLOOM.get());
                        output.accept(ModBlocks.SPITFIRE.get());
                        output.accept(ModBlocks.FULGURBLOOM.get());
                        output.accept(ModBlocks.VITRIC_BLOOM.get());
                        output.accept(ModBlocks.VITRIC_ROSE.get());
                    })
                    .build());

    public static final RegistryObject<CreativeModeTab> MOB_TAB = CREATIVE_MODE_TABS.register("crystal_technology_mob_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.RHINO_SPAWN_EGG.get()))
                    .title(Component.translatable("creativetab.crystal_technology_mob_tab"))
                    .displayItems((itemDisplayParameters, output) -> {

                        output.accept(ModItems.RHINO_SPAWN_EGG.get());

                    })
                    .build());

    public static final RegistryObject<CreativeModeTab> TECH_TAB = CREATIVE_MODE_TABS.register("crystal_technology_tech_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModBlocks.TIBERIUM_INFUSER.get()))
                    .title(Component.translatable("creativetab.crystal_technology_tech_tab"))
                    .displayItems((itemDisplayParameters, output) -> {



                        output.accept(ModItems.HARMONIC_RELAY.get());
                        output.accept(ModItems.HARMONIC_CIRCUIT.get());
                        output.accept(ModItems.VITRIC_CIRCUIT.get());
                        output.accept(ModItems.HARMONIC_FOCUS.get());
                        output.accept(ModItems.ILLUMINATE_COMPONENT.get());
                        output.accept(ModItems.KRYONIC_CAPACITOR.get());
                        output.accept(ModItems.KRYONIC_RESERVOIR.get());

                        output.accept(ModBlocks.GUNDANIUM_MACHINE_CORE.get());
                        output.accept(ModBlocks.ALYTHUM_MACHINE_CORE.get());
                        output.accept(ModBlocks.VITRIC_MACHINE_CORE.get());
                        output.accept(ModBlocks.CRYSTAL_CORE_MACHINE_CORE.get());

                        output.accept(ModBlocks.TIBERIUM_GRINDER.get());
                        output.accept(ModBlocks.TIBERIUM_MACERATOR.get());
                        output.accept(ModBlocks.ALYTHUM_TIBERIUM_MACERATOR.get());
                        output.accept(ModBlocks.VITRIC_TIBERIUM_MACERATOR.get());
                        output.accept(ModBlocks.CRYSTAL_CORE_TIBERIUM_MACERATOR.get());

                        output.accept(ModBlocks.TIBERIUM_INFUSER.get());
                        output.accept(ModBlocks.ALYTHUM_TIBERIUM_INFUSER.get());
                        output.accept(ModBlocks.VITRIC_TIBERIUM_INFUSER.get());
                        output.accept(ModBlocks.CRYSTAL_CORE_TIBERIUM_INFUSER.get());

                        output.accept(ModBlocks.POWERED_KILN.get());
                        output.accept(ModBlocks.ALYTHUM_KILN.get());
                        output.accept(ModBlocks.VITRIC_KILN.get());
                        output.accept(ModBlocks.CRYSTAL_CORE_KILN.get());

                        output.accept(ModBlocks.ALLOY_KILN.get());
                        output.accept(ModBlocks.ALYTHUM_ALLOY_KILN.get());
                        output.accept(ModBlocks.VITRIC_ALLOY_KILN.get());
                        output.accept(ModBlocks.CRYSTAL_CORE_ALLOY_KILN.get());

                        output.accept(ModBlocks.VITRICIUM_REFINERY.get());
                        output.accept(ModBlocks.ALYTHUM_VITRICIUM_REFINERY.get());
                        output.accept(ModBlocks.VITRIC_VITRICIUM_REFINERY.get());
                        output.accept(ModBlocks.CRYSTAL_CORE_VITRICIUM_REFINERY.get());

                    })
                    .build());

    public static final RegistryObject<CreativeModeTab> EQUIP_TAB = CREATIVE_MODE_TABS.register("crystal_technology_equipment_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.GUNDANIUM_SWORD.get()))
                    .title(Component.translatable("creativetab.crystal_technology_equipment_tab"))
                    .displayItems((itemDisplayParameters, output) -> {

                        output.accept(ModItems.PLAGUED_SWORD.get());
                        output.accept(ModItems.PLAGUED_PICKAXE.get());
                        output.accept(ModItems.PLAGUED_AXE.get());
                        output.accept(ModItems.PLAGUED_SHOVEL.get());
                        output.accept(ModItems.PLAGUED_HOE.get());
                        output.accept(ModItems.PLAGUED_BOW.get());

                        output.accept(ModItems.GUNDANIUM_SWORD.get());
                        output.accept(ModItems.GUNDANIUM_PICKAXE.get());
                        output.accept(ModItems.GUNDANIUM_AXE.get());
                        output.accept(ModItems.GUNDANIUM_SHOVEL.get());
                        output.accept(ModItems.GUNDANIUM_HOE.get());
                        output.accept(ModItems.GUNDANIUM_PAXEL.get());
                        output.accept(ModItems.GUNDANIUM_HAMMER.get());
                        output.accept(ModItems.GUNDANIUM_EXCAVATOR.get());

                        output.accept(ModItems.ALYTHUM_SWORD.get());
                        output.accept(ModItems.ALYTHUM_PICKAXE.get());
                        output.accept(ModItems.ALYTHUM_AXE.get());
                        output.accept(ModItems.ALYTHUM_SHOVEL.get());
                        output.accept(ModItems.ALYTHUM_HOE.get());
                        output.accept(ModItems.ALYTHUM_PAXEL.get());
                        output.accept(ModItems.ALYTHUM_HAMMER.get());
                        output.accept(ModItems.ALYTHUM_EXCAVATOR.get());

                        output.accept(ModItems.ILLYRIM_SWORD.get());
                        output.accept(ModItems.ILLYRIM_PICKAXE.get());
                        output.accept(ModItems.ILLYRIM_AXE.get());
                        output.accept(ModItems.ILLYRIM_SHOVEL.get());
                        output.accept(ModItems.ILLYRIM_HOE.get());
                        output.accept(ModItems.ILLYRIM_PAXEL.get());
                        output.accept(ModItems.ILLYRIM_HAMMER.get());
                        output.accept(ModItems.ILLYRIM_EXCAVATOR.get());

                        output.accept(ModItems.HAZMAT_MK1_HELMET.get());
                        output.accept(ModItems.HAZMAT_MK1_CHESTPLATE.get());
                        output.accept(ModItems.HAZMAT_MK1_LEGGINGS.get());
                        output.accept(ModItems.HAZMAT_MK1_BOOTS.get());

                        output.accept(ModItems.HAZMAT_MK2_HELMET.get());
                        output.accept(ModItems.HAZMAT_MK2_CHESTPLATE.get());
                        output.accept(ModItems.HAZMAT_MK2_LEGGINGS.get());
                        output.accept(ModItems.HAZMAT_MK2_BOOTS.get());

                        output.accept(ModItems.GUNDANIUM_HELMET.get());
                        output.accept(ModItems.GUNDANIUM_CHESTPLATE.get());
                        output.accept(ModItems.GUNDANIUM_LEGGINGS.get());
                        output.accept(ModItems.GUNDANIUM_BOOTS.get());

                        output.accept(ModItems.ALYTHUM_HELMET.get());
                        output.accept(ModItems.ALYTHUM_CHESTPLATE.get());
                        output.accept(ModItems.ALYTHUM_LEGGINGS.get());
                        output.accept(ModItems.ALYTHUM_BOOTS.get());

                        output.accept(ModItems.ILLYRIM_HELMET.get());
                        output.accept(ModItems.ILLYRIM_CHESTPLATE.get());
                        output.accept(ModItems.ILLYRIM_LEGGINGS.get());
                        output.accept(ModItems.ILLYRIM_BOOTS.get());



                        output.accept(ModItems.GUNDANIUM_HORSE_ARMOR.get());
                    })
                    .build());

    public static final RegistryObject<CreativeModeTab> MUSIC_TAB = CREATIVE_MODE_TABS.register("crystal_technology_music_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.HYOUHAKU_WANDERING_MUSIC_DISC.get()))
                    .title(Component.translatable("creativetab.crystal_technology_music_tab"))
                    .displayItems((itemDisplayParameters, output) -> {
                        output.accept(ModBlocks.SOUND_BLOCK.get());
                        output.accept(ModItems.HYOUHAKU_WANDERING_MUSIC_DISC.get());
                        output.accept(ModItems.STILL_ALONE_MUSIC_DISC.get());
                        output.accept(ModItems.CORRODED_VALVES_MUSIC_DISC.get());
                        output.accept(ModItems.DARK_MACHINATIONS_MUSIC_DISC.get());
                        output.accept(ModItems.DARK_VALLEY_MUSIC_DISC.get());
                        output.accept(ModItems.EAGLES_DAWN_MUSIC_DISC.get());
                        output.accept(ModItems.MANUFACTORY_MUSIC_DISC.get());
                        output.accept(ModItems.NECROFUNK_MUSIC_DISC.get());
                        output.accept(ModItems.SCOUTING_MUSIC_DISC.get());
                        output.accept(ModItems.PRODIGAL_SON_MUSIC_DISC.get());
                        output.accept(ModItems.PYROTEK_MUSIC_DISC.get());
                        output.accept(ModItems.REPENTANCE_MUSIC_DISC.get());
                        output.accept(ModItems.SPACE_ECHO_MUSIC_DISC.get());
                        output.accept(ModItems.TOMBS_MUSIC_DISC.get());
                        output.accept(ModItems.UNYIELDING_MUSIC_DISC.get());
                        output.accept(ModItems.WIRES_MUSIC_DISC.get());
                        output.accept(ModItems.XENOPHILE_MUSIC_DISC.get());
                        output.accept(ModItems.APPROACH_MUSIC_DISC.get());
                        output.accept(ModItems.DUSK_HOUR_MUSIC_DISC.get());
                        output.accept(ModItems.TS_DUSK_HOUR_MUSIC_DISC.get());
                        output.accept(ModItems.HEROISM_MUSIC_DISC.get());
                        output.accept(ModItems.LONE_TROOPER_MUSIC_DISC.get());
                        output.accept(ModItems.PHAROTEK_MUSIC_DISC.get());
                        output.accept(ModItems.VALVES_MUSIC_DISC.get());
                        output.accept(ModItems.WHAT_LURKS_MUSIC_DISC.get());
                        output.accept(ModItems.AIRSTRIKE_MUSIC_DISC.get());
                        output.accept(ModItems.HEROISM_2_MUSIC_DISC.get());
                        output.accept(ModItems.CREEPING_UPON_MUSIC_DISC.get());
                        output.accept(ModItems.DEPTH_CHARGE_MUSIC_DISC.get());
                        output.accept(ModItems.DRONE_MUSIC_DISC.get());
                        output.accept(ModItems.ON_THE_PROWL_MUSIC_DISC.get());
                        output.accept(ModItems.RAIN_IN_THE_NIGHT_MUSIC_DISC.get());
                        output.accept(ModItems.RECON_MUSIC_DISC.get());
                        output.accept(ModItems.AWAITING_MUSIC_DISC.get());
                        output.accept(ModItems.DENSE_MUSIC_DISC.get());
                        output.accept(ModItems.DERELICT_MUSIC_DISC.get());
                        output.accept(ModItems.RUN_MUSIC_DISC.get());
                        output.accept(ModItems.THE_SEARCH_MUSIC_DISC.get());
                        output.accept(ModItems.TRENCHES_MUSIC_DISC.get());
                        output.accept(ModItems.VECTOR_MUSIC_DISC.get());
                        output.accept(ModItems.VOICE_RHYTHM_2_MUSIC_DISC.get());

                    })
                    .build());

    public static final RegistryObject<CreativeModeTab> NATURAL_TAB = CREATIVE_MODE_TABS.register("crystal_technology_natural_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModBlocks.YELLOW_ZONE_CRACKED_DIRT.get()))
                    .title(Component.translatable("creativetab.crystal_technology_natural_tab"))
                    .displayItems((itemDisplayParameters, output) -> {



                        output.accept(ModBlocks.TIBERIUM_SOIL.get());
                        output.accept(ModBlocks.ICHOR_SOIL.get());
                        output.accept(ModBlocks.INERT_VITRIC_SOIL.get());
                        output.accept(ModBlocks.INERT_ICHOR_SOIL.get());
                        output.accept(ModBlocks.YELLOW_ZONE_CRACKED_DIRT.get());
                        output.accept(ModBlocks.RED_ZONE_DIRT.get());
                        output.accept(ModBlocks.SEEDED_YELLOW_ZONE_CRACKED_DIRT.get());
                        output.accept(ModBlocks.SEEDED_RED_ZONE_DIRT.get());
                        output.accept(ModBlocks.YELLOW_ZONE_SAND.get());
                        output.accept(ModBlocks.YZ_SANDSTONE.get());
                        output.accept(ModBlocks.YZ_SANDSTONE_STAIRS.get());
                        output.accept(ModBlocks.YZ_SANDSTONE_SLAB.get());
                        output.accept(ModBlocks.YZ_SANDSTONE_WALL.get());
                        output.accept(ModBlocks.SMOOTH_YZ_SANDSTONE.get());
                        output.accept(ModBlocks.SMOOTH_YZ_SANDSTONE_STAIRS.get());
                        output.accept(ModBlocks.SMOOTH_YZ_SANDSTONE_SLAB.get());
                        output.accept(ModBlocks.CUT_YZ_SANDSTONE.get());
                        output.accept(ModBlocks.CUT_YZ_SANDSTONE_SLAB.get());
                        output.accept(ModBlocks.CHISELED_YZ_SANDSTONE.get());
                        output.accept(ModBlocks.RED_ZONE_SAND.get());
                        output.accept(ModBlocks.RZ_SANDSTONE.get());
                        output.accept(ModBlocks.RZ_SANDSTONE_STAIRS.get());
                        output.accept(ModBlocks.RZ_SANDSTONE_SLAB.get());
                        output.accept(ModBlocks.RZ_SANDSTONE_WALL.get());
                        output.accept(ModBlocks.SMOOTH_RZ_SANDSTONE.get());
                        output.accept(ModBlocks.SMOOTH_RZ_SANDSTONE_STAIRS.get());
                        output.accept(ModBlocks.SMOOTH_RZ_SANDSTONE_SLAB.get());
                        output.accept(ModBlocks.CUT_RZ_SANDSTONE.get());
                        output.accept(ModBlocks.CUT_RZ_SANDSTONE_SLAB.get());
                        output.accept(ModBlocks.CHISELED_RZ_SANDSTONE.get());
                        output.accept(ModBlocks.SEEDED_DIRT.get());

                        output.accept(ModBlocks.PLAGUED_LOG.get());
                        output.accept(ModBlocks.STRIPPED_PLAGUED_LOG.get());
                        output.accept(ModBlocks.PLAGUED_WOOD.get());
                        output.accept(ModBlocks.STRIPPED_PLAGUED_WOOD.get());
                        output.accept(ModBlocks.PLAGUED_LEAVES.get());
                        output.accept(ModBlocks.PLAGUED_PLANKS.get());
                        output.accept(ModBlocks.PLAGUED_STAIRS.get());
                        output.accept(ModBlocks.PLAGUED_SLAB.get());
                        output.accept(ModBlocks.PLAGUED_BUTTON.get());
                        output.accept(ModBlocks.PLAGUED_PRESSURE_PLATE.get());
                        output.accept(ModBlocks.PLAGUED_FENCE.get());
                        output.accept(ModBlocks.PLAGUED_FENCE_GATE.get());
                        output.accept(ModBlocks.PLAGUED_DOOR.get());
                        output.accept(ModBlocks.PLAGUED_TRAPDOOR.get());
                        output.accept(ModItems.PLAGUED_SIGN.get());
                        output.accept(ModItems.PLAGUED_HANGING_SIGN.get());

                        output.accept(ModBlocks.EMBER_OAK_LOG.get());
                        output.accept(ModBlocks.STRIPPED_EMBER_OAK_LOG.get());
                        output.accept(ModBlocks.EMBER_OAK_WOOD.get());
                        output.accept(ModBlocks.STRIPPED_EMBER_OAK_WOOD.get());
                        output.accept(ModBlocks.EMBER_OAK_LEAVES.get());
                        output.accept(ModBlocks.EMBER_OAK_PLANKS.get());
                        output.accept(ModBlocks.EMBER_OAK_STAIRS.get());
                        output.accept(ModBlocks.EMBER_OAK_SLAB.get());
                        output.accept(ModBlocks.EMBER_OAK_BUTTON.get());
                        output.accept(ModBlocks.EMBER_OAK_PRESSURE_PLATE.get());
                        output.accept(ModBlocks.EMBER_OAK_FENCE.get());
                        output.accept(ModBlocks.EMBER_OAK_FENCE_GATE.get());
                        output.accept(ModBlocks.EMBER_OAK_DOOR.get());
                        output.accept(ModBlocks.EMBER_OAK_TRAPDOOR.get());
                        output.accept(ModItems.EMBER_OAK_SIGN.get());
                        output.accept(ModItems.EMBER_OAK_HANGING_SIGN.get());

                        output.accept(ModBlocks.DEAD_LOG.get());
                        output.accept(ModBlocks.STRIPPED_DEAD_LOG.get());
                        output.accept(ModBlocks.DEAD_WOOD.get());
                        output.accept(ModBlocks.STRIPPED_DEAD_WOOD.get());
                        output.accept(ModBlocks.DEAD_LEAVES.get());
                        output.accept(ModBlocks.DEAD_PLANKS.get());
                        output.accept(ModBlocks.DEAD_STAIRS.get());
                        output.accept(ModBlocks.DEAD_SLAB.get());
                        output.accept(ModBlocks.DEAD_BUTTON.get());
                        output.accept(ModBlocks.DEAD_PRESSURE_PLATE.get());
                        output.accept(ModBlocks.DEAD_FENCE.get());
                        output.accept(ModBlocks.DEAD_FENCE_GATE.get());
                        output.accept(ModBlocks.DEAD_DOOR.get());
                        output.accept(ModBlocks.DEAD_TRAPDOOR.get());
                        output.accept(ModItems.DEAD_SIGN.get());
                        output.accept(ModItems.DEAD_HANGING_SIGN.get());

                        output.accept(ModBlocks.MARIKA_OAK_LOG.get());
                        output.accept(ModBlocks.STRIPPED_MARIKA_OAK_LOG.get());
                        output.accept(ModBlocks.MARIKA_OAK_WOOD.get());
                        output.accept(ModBlocks.STRIPPED_MARIKA_OAK_WOOD.get());
                        output.accept(ModBlocks.MARIKA_OAK_LEAVES.get());
                        output.accept(ModBlocks.MARIKA_OAK_PLANKS.get());
                        output.accept(ModBlocks.MARIKA_OAK_STAIRS.get());
                        output.accept(ModBlocks.MARIKA_OAK_SLAB.get());
                        output.accept(ModBlocks.MARIKA_OAK_BUTTON.get());
                        output.accept(ModBlocks.MARIKA_OAK_PRESSURE_PLATE.get());
                        output.accept(ModBlocks.MARIKA_OAK_FENCE.get());
                        output.accept(ModBlocks.MARIKA_OAK_FENCE_GATE.get());
                        output.accept(ModBlocks.MARIKA_OAK_DOOR.get());
                        output.accept(ModBlocks.MARIKA_OAK_TRAPDOOR.get());
                        output.accept(ModItems.MARIKA_OAK_SIGN.get());
                        output.accept(ModItems.MARIKA_OAK_HANGING_SIGN.get());

                        output.accept(ModBlocks.INFESTED_COBBLE.get());
                        output.accept(ModBlocks.INFESTED_COBBLE_SLAB.get());
                        output.accept(ModBlocks.INFESTED_COBBLE_STAIRS.get());
                        output.accept(ModBlocks.INFESTED_COBBLE_WALL.get());

                        output.accept(ModBlocks.INFESTED_STONE.get());
                        output.accept(ModBlocks.PLAGUED_STONE_STAIRS.get());
                        output.accept(ModBlocks.PLAGUED_STONE_SLAB.get());
                        output.accept(ModBlocks.PLAGUED_STONE_WALL.get());

                        output.accept(ModBlocks.INFESTED_DIORITE.get());
                        output.accept(ModBlocks.PLAGUED_DIORITE_STAIRS.get());
                        output.accept(ModBlocks.PLAGUED_DIORITE_SLAB.get());
                        output.accept(ModBlocks.PLAGUED_DIORITE_WALL.get());

                        output.accept(ModBlocks.INFESTED_GRANITE.get());
                        output.accept(ModBlocks.PLAGUED_GRANITE_STAIRS.get());
                        output.accept(ModBlocks.PLAGUED_GRANITE_SLAB.get());
                        output.accept(ModBlocks.PLAGUED_GRANITE_WALL.get());

                        output.accept(ModBlocks.INFESTED_ANDESITE.get());
                        output.accept(ModBlocks.PLAGUED_ANDESITE_STAIRS.get());
                        output.accept(ModBlocks.PLAGUED_ANDESITE_SLAB.get());
                        output.accept(ModBlocks.PLAGUED_ANDESITE_WALL.get());

                        output.accept(ModBlocks.VITRIC_DEEPSLATE.get());
                        output.accept(ModBlocks.VITRIC_DEEPSLATE_BRICKS.get());
                        output.accept(ModBlocks.VITRIC_DEEPSLATE_BRICK_STAIRS.get());
                        output.accept(ModBlocks.VITRIC_DEEPSLATE_BRICK_SLAB.get());
                        output.accept(ModBlocks.VITRIC_DEEPSLATE_BRICK_WALL.get());

                        output.accept(ModBlocks.VITRIC_DEEPSLATE_TILES.get());
                        output.accept(ModBlocks.VITRIC_DEEPSLATE_TILE_STAIRS.get());
                        output.accept(ModBlocks.VITRIC_DEEPSLATE_TILE_SLAB.get());
                        output.accept(ModBlocks.VITRIC_DEEPSLATE_TILE_WALL.get());

                        output.accept(ModBlocks.RIPARIUS_STONE.get());
                        output.accept(ModBlocks.RIPARIUS_STONE_STAIRS.get());
                        output.accept(ModBlocks.RIPARIUS_STONE_SLAB.get());
                        output.accept(ModBlocks.RIPARIUS_STONE_WALL.get());

                        output.accept(ModBlocks.RIPARIUS_STONE_BRICKS.get());
                        output.accept(ModBlocks.RIPARIUS_STONE_BRICK_STAIRS.get());
                        output.accept(ModBlocks.RIPARIUS_STONE_BRICK_SLAB.get());
                        output.accept(ModBlocks.RIPARIUS_STONE_BRICK_WALL.get());

                        output.accept(ModBlocks.CRUENTUS_STONE.get());
                        output.accept(ModBlocks.CRUENTUS_STONE_STAIRS.get());
                        output.accept(ModBlocks.CRUENTUS_STONE_SLAB.get());
                        output.accept(ModBlocks.CRUENTUS_STONE_WALL.get());

                        output.accept(ModBlocks.CRUENTUS_STONE_BRICKS.get());
                        output.accept(ModBlocks.CRUENTUS_STONE_BRICK_STAIRS.get());
                        output.accept(ModBlocks.CRUENTUS_STONE_BRICK_SLAB.get());
                        output.accept(ModBlocks.CRUENTUS_STONE_BRICK_WALL.get());

                        output.accept(ModBlocks.VINIFERA_STONE.get());
                        output.accept(ModBlocks.VINIFERA_STONE_STAIRS.get());
                        output.accept(ModBlocks.VINIFERA_STONE_SLAB.get());
                        output.accept(ModBlocks.VINIFERA_STONE_WALL.get());

                        output.accept(ModBlocks.VINIFERA_STONE_BRICKS.get());
                        output.accept(ModBlocks.VINIFERA_STONE_BRICK_STAIRS.get());
                        output.accept(ModBlocks.VINIFERA_STONE_BRICK_SLAB.get());
                        output.accept(ModBlocks.VINIFERA_STONE_BRICK_WALL.get());

                        output.accept(ModBlocks.ABOREUS_STONE.get());
                        output.accept(ModBlocks.ABOREUS_STONE_STAIRS.get());
                        output.accept(ModBlocks.ABOREUS_STONE_SLAB.get());
                        output.accept(ModBlocks.ABOREUS_STONE_WALL.get());

                        output.accept(ModBlocks.ABOREUS_STONE_BRICKS.get());
                        output.accept(ModBlocks.ABOREUS_STONE_BRICK_STAIRS.get());
                        output.accept(ModBlocks.ABOREUS_STONE_BRICK_SLAB.get());
                        output.accept(ModBlocks.ABOREUS_STONE_BRICK_WALL.get());


                        output.accept(ModBlocks.RIPARIUS_CRYSTAL.get());
                        output.accept(ModBlocks.RIPARIUS_CRYSTAL_STAIRS.get());
                        output.accept(ModBlocks.RIPARIUS_CRYSTAL_SLAB.get());
                        output.accept(ModBlocks.RIPARIUS_CRYSTAL_WALL.get());

                        output.accept(ModBlocks.CRUENTUS_CRYSTAL.get());
                        output.accept(ModBlocks.CRUENTUS_CRYSTAL_STAIRS.get());
                        output.accept(ModBlocks.CRUENTUS_CRYSTAL_SLAB.get());
                        output.accept(ModBlocks.CRUENTUS_CRYSTAL_WALL.get());

                        output.accept(ModBlocks.VINIFERA_CRYSTAL.get());
                        output.accept(ModBlocks.VINIFERA_CRYSTAL_STAIRS.get());
                        output.accept(ModBlocks.VINIFERA_CRYSTAL_SLAB.get());
                        output.accept(ModBlocks.VINIFERA_CRYSTAL_WALL.get());

                        output.accept(ModBlocks.ABOREUS_CRYSTAL.get());
                        output.accept(ModBlocks.ABOREUS_CRYSTAL_STAIRS.get());
                        output.accept(ModBlocks.ABOREUS_CRYSTAL_SLAB.get());
                        output.accept(ModBlocks.ABOREUS_CRYSTAL_WALL.get());


                    })
                    .build());

    public static final RegistryObject<CreativeModeTab> BUILDING_TAB = CREATIVE_MODE_TABS.register("crystal_technology_building_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModBlocks.INFESTED_STONE_BRICKS.get()))
                    .title(Component.translatable("creativetab.crystal_technology_building_tab"))
                    .displayItems((itemDisplayParameters, output) -> {

                        output.accept(ModBlocks.IRON_PLATING.get());
                        output.accept(ModBlocks.IRON_PLATING_STAIRS.get());
                        output.accept(ModBlocks.IRON_PLATING_SLAB.get());
                        output.accept(ModBlocks.IRON_PLATING_WALL.get());
                        output.accept(ModBlocks.IRON_PLATING_DOOR.get());
                        output.accept(ModBlocks.IRON_PLATING_TRAPDOOR.get());

                        output.accept(ModBlocks.RUSTY_IRON_PLATING.get());
                        output.accept(ModBlocks.RUSTY_IRON_PLATING_STAIRS.get());
                        output.accept(ModBlocks.RUSTY_IRON_PLATING_SLAB.get());
                        output.accept(ModBlocks.RUSTY_IRON_PLATING_WALL.get());

                        output.accept(ModBlocks.VITRIC_IRON_PLATING.get());
                        output.accept(ModBlocks.VITRIC_IRON_PLATING_STAIRS.get());
                        output.accept(ModBlocks.VITRIC_IRON_PLATING_SLAB.get());
                        output.accept(ModBlocks.VITRIC_IRON_PLATING_WALL.get());

                        output.accept(ModBlocks.POLISHED_IRON_BLOCK.get());
                        output.accept(ModBlocks.POLISHED_IRON_STAIRS.get());
                        output.accept(ModBlocks.POLISHED_IRON_SLAB.get());
                        output.accept(ModBlocks.POLISHED_IRON_WALL.get());

                        output.accept(ModBlocks.PROTO_STEEL_BLOCK.get());
                        output.accept(ModBlocks.PROTO_STEEL_STAIRS.get());
                        output.accept(ModBlocks.PROTO_STEEL_SLAB.get());
                        output.accept(ModBlocks.PROTO_STEEL_WALL.get());

                        output.accept(ModBlocks.CRYSTAL_CORE_LAMP_G.get());
                        output.accept(ModBlocks.INVERTED_CRYSTAL_CORE_LAMP_G.get());
                        output.accept(ModBlocks.CRYSTAL_CORE_LAMP_B.get());
                        output.accept(ModBlocks.INVERTED_CRYSTAL_CORE_LAMP_B.get());
                        output.accept(ModBlocks.CRYSTAL_CORE_LAMP_R.get());
                        output.accept(ModBlocks.INVERTED_CRYSTAL_CORE_LAMP_R.get());
                        output.accept(ModBlocks.CRYSTAL_CORE_LAMP_P.get());
                        output.accept(ModBlocks.INVERTED_CRYSTAL_CORE_LAMP_P.get());

                        output.accept(ModBlocks.CRYSTAL_CORE_LIGHT.get());
                        output.accept(ModBlocks.INVERTED_CRYSTAL_CORE_LIGHT.get());
                        output.accept(ModBlocks.VERT_CRYSTAL_CORE_LIGHT.get());
                        output.accept(ModBlocks.INVERTED_VERT_CRYSTAL_CORE_LIGHT.get());

                        output.accept(ModBlocks.BLACK_CRYSTAL_CORE_LIGHT.get());
                        output.accept(ModBlocks.INVERTED_BLACK_CRYSTAL_CORE_LIGHT.get());
                        output.accept(ModBlocks.BLACK_VERT_CRYSTAL_CORE_LIGHT.get());
                        output.accept(ModBlocks.INVERTED_BLACK_VERT_CRYSTAL_CORE_LIGHT.get());

                        output.accept(ModBlocks.BLUE_CRYSTAL_CORE_LIGHT.get());
                        output.accept(ModBlocks.INVERTED_BLUE_CRYSTAL_CORE_LIGHT.get());
                        output.accept(ModBlocks.BLUE_VERT_CRYSTAL_CORE_LIGHT.get());
                        output.accept(ModBlocks.INVERTED_BLUE_VERT_CRYSTAL_CORE_LIGHT.get());

                        output.accept(ModBlocks.BROWN_CRYSTAL_CORE_LIGHT.get());
                        output.accept(ModBlocks.INVERTED_BROWN_CRYSTAL_CORE_LIGHT.get());
                        output.accept(ModBlocks.BROWN_VERT_CRYSTAL_CORE_LIGHT.get());
                        output.accept(ModBlocks.INVERTED_BROWN_VERT_CRYSTAL_CORE_LIGHT.get());

                        output.accept(ModBlocks.CYAN_CRYSTAL_CORE_LIGHT.get());
                        output.accept(ModBlocks.INVERTED_CYAN_CRYSTAL_CORE_LIGHT.get());
                        output.accept(ModBlocks.CYAN_VERT_CRYSTAL_CORE_LIGHT.get());
                        output.accept(ModBlocks.INVERTED_CYAN_VERT_CRYSTAL_CORE_LIGHT.get());

                        output.accept(ModBlocks.FLAME_CRYSTAL_CORE_LIGHT.get());
                        output.accept(ModBlocks.INVERTED_FLAME_CRYSTAL_CORE_LIGHT.get());
                        output.accept(ModBlocks.FLAME_VERT_CRYSTAL_CORE_LIGHT.get());
                        output.accept(ModBlocks.INVERTED_FLAME_VERT_CRYSTAL_CORE_LIGHT.get());

                        output.accept(ModBlocks.GREEN_CRYSTAL_CORE_LIGHT.get());
                        output.accept(ModBlocks.INVERTED_GREEN_CRYSTAL_CORE_LIGHT.get());
                        output.accept(ModBlocks.GREEN_VERT_CRYSTAL_CORE_LIGHT.get());
                        output.accept(ModBlocks.INVERTED_GREEN_VERT_CRYSTAL_CORE_LIGHT.get());

                        output.accept(ModBlocks.GREY_CRYSTAL_CORE_LIGHT.get());
                        output.accept(ModBlocks.INVERTED_GREY_CRYSTAL_CORE_LIGHT.get());
                        output.accept(ModBlocks.GREY_VERT_CRYSTAL_CORE_LIGHT.get());
                        output.accept(ModBlocks.INVERTED_GREY_VERT_CRYSTAL_CORE_LIGHT.get());

                        output.accept(ModBlocks.LIGHT_BLUE_CRYSTAL_CORE_LIGHT.get());
                        output.accept(ModBlocks.INVERTED_LIGHT_BLUE_CRYSTAL_CORE_LIGHT.get());
                        output.accept(ModBlocks.LIGHT_BLUE_VERT_CRYSTAL_CORE_LIGHT.get());
                        output.accept(ModBlocks.INVERTED_LIGHT_BLUE_VERT_CRYSTAL_CORE_LIGHT.get());

                        output.accept(ModBlocks.LIGHT_GREY_CRYSTAL_CORE_LIGHT.get());
                        output.accept(ModBlocks.INVERTED_LIGHT_GREY_CRYSTAL_CORE_LIGHT.get());
                        output.accept(ModBlocks.LIGHT_GREY_VERT_CRYSTAL_CORE_LIGHT.get());
                        output.accept(ModBlocks.INVERTED_LIGHT_GREY_VERT_CRYSTAL_CORE_LIGHT.get());

                        output.accept(ModBlocks.LIME_CRYSTAL_CORE_LIGHT.get());
                        output.accept(ModBlocks.INVERTED_LIME_CRYSTAL_CORE_LIGHT.get());
                        output.accept(ModBlocks.LIME_VERT_CRYSTAL_CORE_LIGHT.get());
                        output.accept(ModBlocks.INVERTED_LIME_VERT_CRYSTAL_CORE_LIGHT.get());

                        output.accept(ModBlocks.MAGENTA_CRYSTAL_CORE_LIGHT.get());
                        output.accept(ModBlocks.INVERTED_MAGENTA_CRYSTAL_CORE_LIGHT.get());
                        output.accept(ModBlocks.MAGENTA_VERT_CRYSTAL_CORE_LIGHT.get());
                        output.accept(ModBlocks.INVERTED_MAGENTA_VERT_CRYSTAL_CORE_LIGHT.get());

                        output.accept(ModBlocks.ORANGE_CRYSTAL_CORE_LIGHT.get());
                        output.accept(ModBlocks.INVERTED_ORANGE_CRYSTAL_CORE_LIGHT.get());
                        output.accept(ModBlocks.ORANGE_VERT_CRYSTAL_CORE_LIGHT.get());
                        output.accept(ModBlocks.INVERTED_ORANGE_VERT_CRYSTAL_CORE_LIGHT.get());

                        output.accept(ModBlocks.PINK_CRYSTAL_CORE_LIGHT.get());
                        output.accept(ModBlocks.INVERTED_PINK_CRYSTAL_CORE_LIGHT.get());
                        output.accept(ModBlocks.PINK_VERT_CRYSTAL_CORE_LIGHT.get());
                        output.accept(ModBlocks.INVERTED_PINK_VERT_CRYSTAL_CORE_LIGHT.get());

                        output.accept(ModBlocks.PURPLE_CRYSTAL_CORE_LIGHT.get());
                        output.accept(ModBlocks.INVERTED_PURPLE_CRYSTAL_CORE_LIGHT.get());
                        output.accept(ModBlocks.PURPLE_VERT_CRYSTAL_CORE_LIGHT.get());
                        output.accept(ModBlocks.INVERTED_PURPLE_VERT_CRYSTAL_CORE_LIGHT.get());

                        output.accept(ModBlocks.RED_CRYSTAL_CORE_LIGHT.get());
                        output.accept(ModBlocks.INVERTED_RED_CRYSTAL_CORE_LIGHT.get());
                        output.accept(ModBlocks.RED_VERT_CRYSTAL_CORE_LIGHT.get());
                        output.accept(ModBlocks.INVERTED_RED_VERT_CRYSTAL_CORE_LIGHT.get());

                        output.accept(ModBlocks.WHITE_CRYSTAL_CORE_LIGHT.get());
                        output.accept(ModBlocks.INVERTED_WHITE_CRYSTAL_CORE_LIGHT.get());
                        output.accept(ModBlocks.WHITE_VERT_CRYSTAL_CORE_LIGHT.get());
                        output.accept(ModBlocks.INVERTED_WHITE_VERT_CRYSTAL_CORE_LIGHT.get());

                        output.accept(ModBlocks.INFESTED_STONE_BRICKS.get());
                        output.accept(ModBlocks.INFESTED_STONE_BRICK_SLAB.get());
                        output.accept(ModBlocks.INFESTED_STONE_BRICK_STAIRS.get());
                        output.accept(ModBlocks.INFESTED_STONE_BRICK_WALL.get());
                        output.accept(ModBlocks.BLACK_TIBERCRETE_POWDER.get());
                        output.accept(ModBlocks.BLACK_TIBERCRETE.get());
                        output.accept(ModBlocks.BLACK_TIBERCRETE_STAIRS.get());
                        output.accept(ModBlocks.BLACK_TIBERCRETE_SLAB.get());
                        output.accept(ModBlocks.BLACK_TIBERCRETE_WALL.get());
                        output.accept(ModBlocks.BLACK_TIBERCRETE_BRICKS.get());
                        output.accept(ModBlocks.BLACK_TIBERCRETE_BRICK_STAIRS.get());
                        output.accept(ModBlocks.BLACK_TIBERCRETE_BRICK_SLAB.get());
                        output.accept(ModBlocks.BLACK_TIBERCRETE_BRICK_WALL.get());
                        output.accept(ModBlocks.BLUE_TIBERCRETE_POWDER.get());
                        output.accept(ModBlocks.BLUE_TIBERCRETE.get());
                        output.accept(ModBlocks.BLUE_TIBERCRETE_STAIRS.get());
                        output.accept(ModBlocks.BLUE_TIBERCRETE_SLAB.get());
                        output.accept(ModBlocks.BLUE_TIBERCRETE_WALL.get());
                        output.accept(ModBlocks.BLUE_TIBERCRETE_BRICKS.get());
                        output.accept(ModBlocks.BLUE_TIBERCRETE_BRICK_STAIRS.get());
                        output.accept(ModBlocks.BLUE_TIBERCRETE_BRICK_SLAB.get());
                        output.accept(ModBlocks.BLUE_TIBERCRETE_BRICK_WALL.get());
                        output.accept(ModBlocks.BROWN_TIBERCRETE_POWDER.get());
                        output.accept(ModBlocks.BROWN_TIBERCRETE.get());
                        output.accept(ModBlocks.BROWN_TIBERCRETE_STAIRS.get());
                        output.accept(ModBlocks.BROWN_TIBERCRETE_SLAB.get());
                        output.accept(ModBlocks.BROWN_TIBERCRETE_WALL.get());
                        output.accept(ModBlocks.BROWN_TIBERCRETE_BRICKS.get());
                        output.accept(ModBlocks.BROWN_TIBERCRETE_BRICK_STAIRS.get());
                        output.accept(ModBlocks.BROWN_TIBERCRETE_BRICK_SLAB.get());
                        output.accept(ModBlocks.BROWN_TIBERCRETE_BRICK_WALL.get());
                        output.accept(ModBlocks.CYAN_TIBERCRETE_POWDER.get());
                        output.accept(ModBlocks.CYAN_TIBERCRETE.get());
                        output.accept(ModBlocks.CYAN_TIBERCRETE_STAIRS.get());
                        output.accept(ModBlocks.CYAN_TIBERCRETE_SLAB.get());
                        output.accept(ModBlocks.CYAN_TIBERCRETE_WALL.get());
                        output.accept(ModBlocks.CYAN_TIBERCRETE_BRICKS.get());
                        output.accept(ModBlocks.CYAN_TIBERCRETE_BRICK_STAIRS.get());
                        output.accept(ModBlocks.CYAN_TIBERCRETE_BRICK_SLAB.get());
                        output.accept(ModBlocks.CYAN_TIBERCRETE_BRICK_WALL.get());
                        output.accept(ModBlocks.GRAY_TIBERCRETE_POWDER.get());
                        output.accept(ModBlocks.GRAY_TIBERCRETE.get());
                        output.accept(ModBlocks.GRAY_TIBERCRETE_STAIRS.get());
                        output.accept(ModBlocks.GRAY_TIBERCRETE_SLAB.get());
                        output.accept(ModBlocks.GRAY_TIBERCRETE_WALL.get());
                        output.accept(ModBlocks.GRAY_TIBERCRETE_BRICKS.get());
                        output.accept(ModBlocks.GRAY_TIBERCRETE_BRICK_STAIRS.get());
                        output.accept(ModBlocks.GRAY_TIBERCRETE_BRICK_SLAB.get());
                        output.accept(ModBlocks.GRAY_TIBERCRETE_BRICK_WALL.get());
                        output.accept(ModBlocks.GREEN_TIBERCRETE_POWDER.get());
                        output.accept(ModBlocks.GREEN_TIBERCRETE.get());
                        output.accept(ModBlocks.GREEN_TIBERCRETE_STAIRS.get());
                        output.accept(ModBlocks.GREEN_TIBERCRETE_SLAB.get());
                        output.accept(ModBlocks.GREEN_TIBERCRETE_WALL.get());
                        output.accept(ModBlocks.GREEN_TIBERCRETE_BRICKS.get());
                        output.accept(ModBlocks.GREEN_TIBERCRETE_BRICK_STAIRS.get());
                        output.accept(ModBlocks.GREEN_TIBERCRETE_BRICK_SLAB.get());
                        output.accept(ModBlocks.GREEN_TIBERCRETE_BRICK_WALL.get());
                        output.accept(ModBlocks.LIGHT_BLUE_TIBERCRETE_POWDER.get());
                        output.accept(ModBlocks.LIGHT_BLUE_TIBERCRETE.get());
                        output.accept(ModBlocks.LIGHT_BLUE_TIBERCRETE_STAIRS.get());
                        output.accept(ModBlocks.LIGHT_BLUE_TIBERCRETE_SLAB.get());
                        output.accept(ModBlocks.LIGHT_BLUE_TIBERCRETE_WALL.get());
                        output.accept(ModBlocks.LIGHT_BLUE_TIBERCRETE_BRICKS.get());
                        output.accept(ModBlocks.LIGHT_BLUE_TIBERCRETE_BRICK_STAIRS.get());
                        output.accept(ModBlocks.LIGHT_BLUE_TIBERCRETE_BRICK_SLAB.get());
                        output.accept(ModBlocks.LIGHT_BLUE_TIBERCRETE_BRICK_WALL.get());
                        output.accept(ModBlocks.LIGHT_GRAY_TIBERCRETE_POWDER.get());
                        output.accept(ModBlocks.LIGHT_GRAY_TIBERCRETE.get());
                        output.accept(ModBlocks.LIGHT_GRAY_TIBERCRETE_STAIRS.get());
                        output.accept(ModBlocks.LIGHT_GRAY_TIBERCRETE_SLAB.get());
                        output.accept(ModBlocks.LIGHT_GRAY_TIBERCRETE_WALL.get());
                        output.accept(ModBlocks.LIGHT_GRAY_TIBERCRETE_BRICKS.get());
                        output.accept(ModBlocks.LIGHT_GRAY_TIBERCRETE_BRICK_STAIRS.get());
                        output.accept(ModBlocks.LIGHT_GRAY_TIBERCRETE_BRICK_SLAB.get());
                        output.accept(ModBlocks.LIGHT_GRAY_TIBERCRETE_BRICK_WALL.get());
                        output.accept(ModBlocks.LIME_TIBERCRETE_POWDER.get());
                        output.accept(ModBlocks.LIME_TIBERCRETE.get());
                        output.accept(ModBlocks.LIME_TIBERCRETE_STAIRS.get());
                        output.accept(ModBlocks.LIME_TIBERCRETE_SLAB.get());
                        output.accept(ModBlocks.LIME_TIBERCRETE_WALL.get());
                        output.accept(ModBlocks.LIME_TIBERCRETE_BRICKS.get());
                        output.accept(ModBlocks.LIME_TIBERCRETE_BRICK_STAIRS.get());
                        output.accept(ModBlocks.LIME_TIBERCRETE_BRICK_SLAB.get());
                        output.accept(ModBlocks.LIME_TIBERCRETE_BRICK_WALL.get());
                        output.accept(ModBlocks.MAGENTA_TIBERCRETE_POWDER.get());
                        output.accept(ModBlocks.MAGENTA_TIBERCRETE.get());
                        output.accept(ModBlocks.MAGENTA_TIBERCRETE_STAIRS.get());
                        output.accept(ModBlocks.MAGENTA_TIBERCRETE_SLAB.get());
                        output.accept(ModBlocks.MAGENTA_TIBERCRETE_WALL.get());
                        output.accept(ModBlocks.MAGENTA_TIBERCRETE_BRICKS.get());
                        output.accept(ModBlocks.MAGENTA_TIBERCRETE_BRICK_STAIRS.get());
                        output.accept(ModBlocks.MAGENTA_TIBERCRETE_BRICK_SLAB.get());
                        output.accept(ModBlocks.MAGENTA_TIBERCRETE_BRICK_WALL.get());
                        output.accept(ModBlocks.ORANGE_TIBERCRETE_POWDER.get());
                        output.accept(ModBlocks.ORANGE_TIBERCRETE.get());
                        output.accept(ModBlocks.ORANGE_TIBERCRETE_STAIRS.get());
                        output.accept(ModBlocks.ORANGE_TIBERCRETE_SLAB.get());
                        output.accept(ModBlocks.ORANGE_TIBERCRETE_WALL.get());
                        output.accept(ModBlocks.ORANGE_TIBERCRETE_BRICKS.get());
                        output.accept(ModBlocks.ORANGE_TIBERCRETE_BRICK_STAIRS.get());
                        output.accept(ModBlocks.ORANGE_TIBERCRETE_BRICK_SLAB.get());
                        output.accept(ModBlocks.ORANGE_TIBERCRETE_BRICK_WALL.get());
                        output.accept(ModBlocks.PINK_TIBERCRETE_POWDER.get());
                        output.accept(ModBlocks.PINK_TIBERCRETE.get());
                        output.accept(ModBlocks.PINK_TIBERCRETE_STAIRS.get());
                        output.accept(ModBlocks.PINK_TIBERCRETE_SLAB.get());
                        output.accept(ModBlocks.PINK_TIBERCRETE_WALL.get());
                        output.accept(ModBlocks.PINK_TIBERCRETE_BRICKS.get());
                        output.accept(ModBlocks.PINK_TIBERCRETE_BRICK_STAIRS.get());
                        output.accept(ModBlocks.PINK_TIBERCRETE_BRICK_SLAB.get());
                        output.accept(ModBlocks.PINK_TIBERCRETE_BRICK_WALL.get());
                        output.accept(ModBlocks.PURPLE_TIBERCRETE_POWDER.get());
                        output.accept(ModBlocks.PURPLE_TIBERCRETE.get());
                        output.accept(ModBlocks.PURPLE_TIBERCRETE_STAIRS.get());
                        output.accept(ModBlocks.PURPLE_TIBERCRETE_SLAB.get());
                        output.accept(ModBlocks.PURPLE_TIBERCRETE_WALL.get());
                        output.accept(ModBlocks.PURPLE_TIBERCRETE_BRICKS.get());
                        output.accept(ModBlocks.PURPLE_TIBERCRETE_BRICK_STAIRS.get());
                        output.accept(ModBlocks.PURPLE_TIBERCRETE_BRICK_SLAB.get());
                        output.accept(ModBlocks.PURPLE_TIBERCRETE_BRICK_WALL.get());
                        output.accept(ModBlocks.RED_TIBERCRETE_POWDER.get());
                        output.accept(ModBlocks.RED_TIBERCRETE.get());
                        output.accept(ModBlocks.RED_TIBERCRETE_STAIRS.get());
                        output.accept(ModBlocks.RED_TIBERCRETE_SLAB.get());
                        output.accept(ModBlocks.RED_TIBERCRETE_WALL.get());
                        output.accept(ModBlocks.RED_TIBERCRETE_BRICKS.get());
                        output.accept(ModBlocks.RED_TIBERCRETE_BRICK_STAIRS.get());
                        output.accept(ModBlocks.RED_TIBERCRETE_BRICK_SLAB.get());
                        output.accept(ModBlocks.RED_TIBERCRETE_BRICK_WALL.get());
                        output.accept(ModBlocks.WHITE_TIBERCRETE_POWDER.get());
                        output.accept(ModBlocks.WHITE_TIBERCRETE.get());
                        output.accept(ModBlocks.WHITE_TIBERCRETE_STAIRS.get());
                        output.accept(ModBlocks.WHITE_TIBERCRETE_SLAB.get());
                        output.accept(ModBlocks.WHITE_TIBERCRETE_WALL.get());
                        output.accept(ModBlocks.WHITE_TIBERCRETE_BRICKS.get());
                        output.accept(ModBlocks.WHITE_TIBERCRETE_BRICK_STAIRS.get());
                        output.accept(ModBlocks.WHITE_TIBERCRETE_BRICK_SLAB.get());
                        output.accept(ModBlocks.WHITE_TIBERCRETE_BRICK_WALL.get());
                        output.accept(ModBlocks.YELLOW_TIBERCRETE_POWDER.get());
                        output.accept(ModBlocks.YELLOW_TIBERCRETE.get());
                        output.accept(ModBlocks.YELLOW_TIBERCRETE_STAIRS.get());
                        output.accept(ModBlocks.YELLOW_TIBERCRETE_SLAB.get());
                        output.accept(ModBlocks.YELLOW_TIBERCRETE_WALL.get());
                        output.accept(ModBlocks.YELLOW_TIBERCRETE_BRICKS.get());
                        output.accept(ModBlocks.YELLOW_TIBERCRETE_BRICK_STAIRS.get());
                        output.accept(ModBlocks.YELLOW_TIBERCRETE_BRICK_SLAB.get());
                        output.accept(ModBlocks.YELLOW_TIBERCRETE_BRICK_WALL.get());
                        output.accept(ModBlocks.CLEAR_TIBERGLASS.get());
                        output.accept(ModBlocks.CLEAR_TIBERGLASS_PANE.get());
                        output.accept(ModBlocks.MOSAIC_TIBERGLASS.get());
                        output.accept(ModBlocks.MOSAIC_TIBERGLASS_PANE.get());
                        output.accept(ModBlocks.GDI_TIBERGLASS.get());
                        output.accept(ModBlocks.GDI_TIBERGLASS_PANE.get());
                        output.accept(ModBlocks.NOD_TIBERGLASS.get());
                        output.accept(ModBlocks.NOD_TIBERGLASS_PANE.get());
                        output.accept(ModBlocks.WOLF_TIBERGLASS.get());
                        output.accept(ModBlocks.WOLF_TIBERGLASS_PANE.get());
                        output.accept(ModBlocks.BLACK_TIBERGLASS.get());
                        output.accept(ModBlocks.BLACK_TIBERGLASS_PANE.get());
                        output.accept(ModBlocks.BLUE_TIBERGLASS.get());
                        output.accept(ModBlocks.BLUE_TIBERGLASS_PANE.get());
                        output.accept(ModBlocks.BROWN_TIBERGLASS.get());
                        output.accept(ModBlocks.BROWN_TIBERGLASS_PANE.get());
                        output.accept(ModBlocks.CYAN_TIBERGLASS.get());
                        output.accept(ModBlocks.CYAN_TIBERGLASS_PANE.get());
                        output.accept(ModBlocks.GRAY_TIBERGLASS.get());
                        output.accept(ModBlocks.GRAY_TIBERGLASS_PANE.get());
                        output.accept(ModBlocks.GREEN_TIBERGLASS.get());
                        output.accept(ModBlocks.GREEN_TIBERGLASS_PANE.get());
                        output.accept(ModBlocks.LIGHT_BLUE_TIBERGLASS.get());
                        output.accept(ModBlocks.LIGHT_BLUE_TIBERGLASS_PANE.get());
                        output.accept(ModBlocks.LIGHT_GRAY_TIBERGLASS.get());
                        output.accept(ModBlocks.LIGHT_GRAY_TIBERGLASS_PANE.get());
                        output.accept(ModBlocks.LIME_TIBERGLASS.get());
                        output.accept(ModBlocks.LIME_TIBERGLASS_PANE.get());
                        output.accept(ModBlocks.MAGENTA_TIBERGLASS.get());
                        output.accept(ModBlocks.MAGENTA_TIBERGLASS_PANE.get());
                        output.accept(ModBlocks.ORANGE_TIBERGLASS.get());
                        output.accept(ModBlocks.ORANGE_TIBERGLASS_PANE.get());
                        output.accept(ModBlocks.PINK_TIBERGLASS.get());
                        output.accept(ModBlocks.PINK_TIBERGLASS_PANE.get());
                        output.accept(ModBlocks.PURPLE_TIBERGLASS.get());
                        output.accept(ModBlocks.PURPLE_TIBERGLASS_PANE.get());
                        output.accept(ModBlocks.RED_TIBERGLASS.get());
                        output.accept(ModBlocks.RED_TIBERGLASS_PANE.get());
                        output.accept(ModBlocks.WHITE_TIBERGLASS.get());
                        output.accept(ModBlocks.WHITE_TIBERGLASS_PANE.get());
                        output.accept(ModBlocks.YELLOW_TIBERGLASS.get());
                        output.accept(ModBlocks.YELLOW_TIBERGLASS_PANE.get());

                        output.accept(ModBlocks.CS_CHAINLINK.get());
                        output.accept(ModBlocks.CS_SCAFFOLD.get());
                        output.accept(ModBlocks.CS_SCAFFOLD_STAIRS.get());
                        output.accept(ModBlocks.CS_SCAFFOLD_SLAB.get());
                        output.accept(ModBlocks.CS_SCAFFOLD_VERT.get());

                        output.accept(ModBlocks.CS_CATWALK_W.get());
                        output.accept(ModBlocks.CS_CATWALK_W_STAIRS.get());
                        output.accept(ModBlocks.CS_CATWALK_W_SLAB.get());
                        output.accept(ModBlocks.CS_CATWALK_W_VERT.get());

                        output.accept(ModBlocks.CS_CATWALK_BL.get());
                        output.accept(ModBlocks.CS_CATWALK_BL_STAIRS.get());
                        output.accept(ModBlocks.CS_CATWALK_BL_SLAB.get());
                        output.accept(ModBlocks.CS_CATWALK_BL_VERT.get());

                        output.accept(ModBlocks.CS_CATWALK_G.get());
                        output.accept(ModBlocks.CS_CATWALK_G_STAIRS.get());
                        output.accept(ModBlocks.CS_CATWALK_G_SLAB.get());
                        output.accept(ModBlocks.CS_CATWALK_G_VERT.get());

                        output.accept(ModBlocks.CS_CATWALK_B.get());
                        output.accept(ModBlocks.CS_CATWALK_B_STAIRS.get());
                        output.accept(ModBlocks.CS_CATWALK_B_SLAB.get());
                        output.accept(ModBlocks.CS_CATWALK_B_VERT.get());

                        output.accept(ModBlocks.CS_CATWALK_R.get());
                        output.accept(ModBlocks.CS_CATWALK_R_STAIRS.get());
                        output.accept(ModBlocks.CS_CATWALK_R_SLAB.get());
                        output.accept(ModBlocks.CS_CATWALK_R_VERT.get());

                        output.accept(ModBlocks.CS_CATWALK_P.get());
                        output.accept(ModBlocks.CS_CATWALK_P_STAIRS.get());
                        output.accept(ModBlocks.CS_CATWALK_P_SLAB.get());
                        output.accept(ModBlocks.CS_CATWALK_P_VERT.get());

                        output.accept(ModBlocks.CS_TILE.get());
                        output.accept(ModBlocks.CS_TILE_STAIRS.get());
                        output.accept(ModBlocks.CS_TILE_SLAB.get());
                        output.accept(ModBlocks.CS_TILE_WALL.get());
                        output.accept(ModBlocks.CS_TILE_VERT.get());
                        output.accept(ModBlocks.CS_PILLAR.get());

                        output.accept(ModBlocks.CS_TILE_BR.get());
                        output.accept(ModBlocks.CS_TILE_BR_STAIRS.get());
                        output.accept(ModBlocks.CS_TILE_BR_SLAB.get());
                        output.accept(ModBlocks.CS_TILE_BR_WALL.get());
                        output.accept(ModBlocks.CS_TILE_BR_VERT.get());

                        output.accept(ModBlocks.CS_TILE_YB.get());
                        output.accept(ModBlocks.CS_TILE_YB_STAIRS.get());
                        output.accept(ModBlocks.CS_TILE_YB_SLAB.get());
                        output.accept(ModBlocks.CS_TILE_YB_WALL.get());
                        output.accept(ModBlocks.CS_TILE_YB_VERT.get());

                        output.accept(ModBlocks.CS_TILE_G.get());
                        output.accept(ModBlocks.CS_TILE_G_STAIRS.get());
                        output.accept(ModBlocks.CS_TILE_G_SLAB.get());
                        output.accept(ModBlocks.CS_TILE_G_WALL.get());
                        output.accept(ModBlocks.CS_TILE_G_VERT.get());
                        output.accept(ModBlocks.CS_PILLAR_G.get());
                        output.accept(ModBlocks.CS_PILLAR_G_2.get());
                        output.accept(ModBlocks.CS_PILLAR_G_3.get());
                        output.accept(ModBlocks.CS_PILLAR_G_4.get());

                        output.accept(ModBlocks.CS_TILE_G_BAND.get());
                        output.accept(ModBlocks.CS_TILE_G_BAND_STAIRS.get());
                        output.accept(ModBlocks.CS_TILE_G_BAND_SLAB.get());
                        output.accept(ModBlocks.CS_TILE_G_BAND_WALL.get());
                        output.accept(ModBlocks.CS_TILE_G_BAND_VERT.get());

                        output.accept(ModBlocks.CS_TILE_G_FRAME.get());
                        output.accept(ModBlocks.CS_TILE_G_FRAME_STAIRS.get());
                        output.accept(ModBlocks.CS_TILE_G_FRAME_SLAB.get());
                        output.accept(ModBlocks.CS_TILE_G_FRAME_WALL.get());
                        output.accept(ModBlocks.CS_TILE_G_FRAME_VERT.get());

                        output.accept(ModBlocks.CS_TILE_B.get());
                        output.accept(ModBlocks.CS_TILE_B_STAIRS.get());
                        output.accept(ModBlocks.CS_TILE_B_SLAB.get());
                        output.accept(ModBlocks.CS_TILE_B_WALL.get());
                        output.accept(ModBlocks.CS_TILE_B_VERT.get());

                        output.accept(ModBlocks.CS_PILLAR_B.get());
                        output.accept(ModBlocks.CS_PILLAR_B_2.get());
                        output.accept(ModBlocks.CS_PILLAR_B_3.get());
                        output.accept(ModBlocks.CS_PILLAR_B_4.get());

                        output.accept(ModBlocks.CS_TILE_B_BAND.get());
                        output.accept(ModBlocks.CS_TILE_B_BAND_STAIRS.get());
                        output.accept(ModBlocks.CS_TILE_B_BAND_SLAB.get());
                        output.accept(ModBlocks.CS_TILE_B_BAND_WALL.get());
                        output.accept(ModBlocks.CS_TILE_B_BAND_VERT.get());

                        output.accept(ModBlocks.CS_TILE_B_FRAME.get());
                        output.accept(ModBlocks.CS_TILE_B_FRAME_STAIRS.get());
                        output.accept(ModBlocks.CS_TILE_B_FRAME_SLAB.get());
                        output.accept(ModBlocks.CS_TILE_B_FRAME_WALL.get());
                        output.accept(ModBlocks.CS_TILE_B_FRAME_VERT.get());
                        output.accept(ModBlocks.CS_TILE_R.get());
                        output.accept(ModBlocks.CS_TILE_R_STAIRS.get());
                        output.accept(ModBlocks.CS_TILE_R_SLAB.get());
                        output.accept(ModBlocks.CS_TILE_R_WALL.get());
                        output.accept(ModBlocks.CS_TILE_R_VERT.get());
                        output.accept(ModBlocks.CS_PILLAR_R.get());
                        output.accept(ModBlocks.CS_PILLAR_R_2.get());
                        output.accept(ModBlocks.CS_PILLAR_R_3.get());
                        output.accept(ModBlocks.CS_PILLAR_R_4.get());
                        output.accept(ModBlocks.CS_TILE_R_BAND.get());
                        output.accept(ModBlocks.CS_TILE_R_BAND_STAIRS.get());
                        output.accept(ModBlocks.CS_TILE_R_BAND_SLAB.get());
                        output.accept(ModBlocks.CS_TILE_R_BAND_WALL.get());
                        output.accept(ModBlocks.CS_TILE_R_BAND_VERT.get());
                        output.accept(ModBlocks.CS_TILE_R_FRAME.get());
                        output.accept(ModBlocks.CS_TILE_R_FRAME_STAIRS.get());
                        output.accept(ModBlocks.CS_TILE_R_FRAME_SLAB.get());
                        output.accept(ModBlocks.CS_TILE_R_FRAME_WALL.get());
                        output.accept(ModBlocks.CS_TILE_R_FRAME_VERT.get());
                        output.accept(ModBlocks.CS_TILE_P.get());
                        output.accept(ModBlocks.CS_TILE_P_STAIRS.get());
                        output.accept(ModBlocks.CS_TILE_P_SLAB.get());
                        output.accept(ModBlocks.CS_TILE_P_WALL.get());
                        output.accept(ModBlocks.CS_TILE_P_VERT.get());
                        output.accept(ModBlocks.CS_PILLAR_P.get());
                        output.accept(ModBlocks.CS_PILLAR_P_2.get());
                        output.accept(ModBlocks.CS_PILLAR_P_3.get());
                        output.accept(ModBlocks.CS_PILLAR_P_4.get());
                        output.accept(ModBlocks.CS_TILE_P_BAND.get());
                        output.accept(ModBlocks.CS_TILE_P_BAND_STAIRS.get());
                        output.accept(ModBlocks.CS_TILE_P_BAND_SLAB.get());
                        output.accept(ModBlocks.CS_TILE_P_BAND_WALL.get());
                        output.accept(ModBlocks.CS_TILE_P_BAND_VERT.get());
                        output.accept(ModBlocks.CS_TILE_P_FRAME.get());
                        output.accept(ModBlocks.CS_TILE_P_FRAME_STAIRS.get());
                        output.accept(ModBlocks.CS_TILE_P_FRAME_SLAB.get());
                        output.accept(ModBlocks.CS_TILE_P_FRAME_WALL.get());
                        output.accept(ModBlocks.CS_TILE_P_FRAME_VERT.get());
                        output.accept(ModBlocks.CS_TILE_LG.get());
                        output.accept(ModBlocks.CS_TILE_LG_STAIRS.get());
                        output.accept(ModBlocks.CS_TILE_LG_SLAB.get());
                        output.accept(ModBlocks.CS_TILE_LG_WALL.get());
                        output.accept(ModBlocks.CS_TILE_LG_VERT.get());
                        output.accept(ModBlocks.CS_PILLAR_LG.get());
                        output.accept(ModBlocks.CS_PILLAR_LG_2.get());
                        output.accept(ModBlocks.CS_PILLAR_LG_3.get());
                        output.accept(ModBlocks.CS_PILLAR_LG_4.get());
                        output.accept(ModBlocks.CS_TILE_LG_BAND.get());
                        output.accept(ModBlocks.CS_TILE_LG_BAND_STAIRS.get());
                        output.accept(ModBlocks.CS_TILE_LG_BAND_SLAB.get());
                        output.accept(ModBlocks.CS_TILE_LG_BAND_WALL.get());
                        output.accept(ModBlocks.CS_TILE_LG_BAND_VERT.get());
                        output.accept(ModBlocks.CS_TILE_LG_FRAME.get());
                        output.accept(ModBlocks.CS_TILE_LG_FRAME_STAIRS.get());
                        output.accept(ModBlocks.CS_TILE_LG_FRAME_SLAB.get());
                        output.accept(ModBlocks.CS_TILE_LG_FRAME_WALL.get());
                        output.accept(ModBlocks.CS_TILE_LG_FRAME_VERT.get());
                        output.accept(ModBlocks.CS_TILE_MG.get());
                        output.accept(ModBlocks.CS_TILE_MG_STAIRS.get());
                        output.accept(ModBlocks.CS_TILE_MG_SLAB.get());
                        output.accept(ModBlocks.CS_TILE_MG_WALL.get());
                        output.accept(ModBlocks.CS_TILE_MG_VERT.get());
                        output.accept(ModBlocks.CS_PILLAR_MG.get());
                        output.accept(ModBlocks.CS_PILLAR_MG_2.get());
                        output.accept(ModBlocks.CS_PILLAR_MG_3.get());
                        output.accept(ModBlocks.CS_PILLAR_MG_4.get());
                        output.accept(ModBlocks.CS_TILE_MG_BAND.get());
                        output.accept(ModBlocks.CS_TILE_MG_BAND_STAIRS.get());
                        output.accept(ModBlocks.CS_TILE_MG_BAND_SLAB.get());
                        output.accept(ModBlocks.CS_TILE_MG_BAND_WALL.get());
                        output.accept(ModBlocks.CS_TILE_MG_BAND_VERT.get());
                        output.accept(ModBlocks.CS_TILE_MG_FRAME.get());
                        output.accept(ModBlocks.CS_TILE_MG_FRAME_STAIRS.get());
                        output.accept(ModBlocks.CS_TILE_MG_FRAME_SLAB.get());
                        output.accept(ModBlocks.CS_TILE_MG_FRAME_WALL.get());
                        output.accept(ModBlocks.CS_TILE_MG_FRAME_VERT.get());
                        output.accept(ModBlocks.CS_TILE_HG.get());
                        output.accept(ModBlocks.CS_TILE_HG_STAIRS.get());
                        output.accept(ModBlocks.CS_TILE_HG_SLAB.get());
                        output.accept(ModBlocks.CS_TILE_HG_WALL.get());
                        output.accept(ModBlocks.CS_TILE_HG_VERT.get());
                        output.accept(ModBlocks.CS_PILLAR_HG.get());
                        output.accept(ModBlocks.CS_PILLAR_HG_2.get());
                        output.accept(ModBlocks.CS_PILLAR_HG_3.get());
                        output.accept(ModBlocks.CS_PILLAR_HG_4.get());
                        output.accept(ModBlocks.CS_TILE_HG_BAND.get());
                        output.accept(ModBlocks.CS_TILE_HG_BAND_STAIRS.get());
                        output.accept(ModBlocks.CS_TILE_HG_BAND_SLAB.get());
                        output.accept(ModBlocks.CS_TILE_HG_BAND_WALL.get());
                        output.accept(ModBlocks.CS_TILE_HG_BAND_VERT.get());
                        output.accept(ModBlocks.CS_TILE_HG_FRAME.get());
                        output.accept(ModBlocks.CS_TILE_HG_FRAME_STAIRS.get());
                        output.accept(ModBlocks.CS_TILE_HG_FRAME_SLAB.get());
                        output.accept(ModBlocks.CS_TILE_HG_FRAME_WALL.get());
                        output.accept(ModBlocks.CS_TILE_HG_FRAME_VERT.get());

                        output.accept(ModBlocks.CT_PILLAR_TOP.get());
                        output.accept(ModBlocks.CT_TILE_STAIRS.get());
                        output.accept(ModBlocks.CT_TILE_SLAB.get());
                        output.accept(ModBlocks.CT_TILE_WALL.get());
                        output.accept(ModBlocks.CT_PILLAR_TOP_VERT.get());

                        output.accept(ModBlocks.CT_TILE_2.get());
                        output.accept(ModBlocks.CT_TILE_STAIRS_2.get());
                        output.accept(ModBlocks.CT_TILE_SLAB_2.get());
                        output.accept(ModBlocks.CT_TILE_WALL_2.get());
                        output.accept(ModBlocks.CT_TILE_VERT_2.get());

                        output.accept(ModBlocks.CT_TILE_3.get());
                        output.accept(ModBlocks.CT_TILE_STAIRS_3.get());
                        output.accept(ModBlocks.CT_TILE_SLAB_3.get());
                        output.accept(ModBlocks.CT_TILE_WALL_3.get());
                        output.accept(ModBlocks.CT_TILE_VERT_3.get());

                        output.accept(ModBlocks.CT_PILLAR_TOP_G.get());
                        output.accept(ModBlocks.CT_TILE_STAIRS_G.get());
                        output.accept(ModBlocks.CT_TILE_SLAB_G.get());
                        output.accept(ModBlocks.CT_TILE_WALL_G.get());
                        output.accept(ModBlocks.CT_PILLAR_TOP_G_VERT.get());

                        output.accept(ModBlocks.CT_TILE_G_2.get());
                        output.accept(ModBlocks.CT_TILE_STAIRS_G_2.get());
                        output.accept(ModBlocks.CT_TILE_SLAB_G_2.get());
                        output.accept(ModBlocks.CT_TILE_WALL_G_2.get());
                        output.accept(ModBlocks.CT_TILE_G_VERT_2.get());

                        output.accept(ModBlocks.CT_TILE_G_3.get());
                        output.accept(ModBlocks.CT_TILE_STAIRS_G_3.get());
                        output.accept(ModBlocks.CT_TILE_SLAB_G_3.get());
                        output.accept(ModBlocks.CT_TILE_WALL_G_3.get());
                        output.accept(ModBlocks.CT_TILE_G_VERT_3.get());

                        output.accept(ModBlocks.CT_PILLAR_TOP_B.get());
                        output.accept(ModBlocks.CT_TILE_STAIRS_B.get());
                        output.accept(ModBlocks.CT_TILE_SLAB_B.get());
                        output.accept(ModBlocks.CT_TILE_WALL_B.get());
                        output.accept(ModBlocks.CT_PILLAR_TOP_B_VERT.get());

                        output.accept(ModBlocks.CT_TILE_B_2.get());
                        output.accept(ModBlocks.CT_TILE_STAIRS_B_2.get());
                        output.accept(ModBlocks.CT_TILE_SLAB_B_2.get());
                        output.accept(ModBlocks.CT_TILE_WALL_B_2.get());
                        output.accept(ModBlocks.CT_TILE_B_VERT_2.get());

                        output.accept(ModBlocks.CT_TILE_B_3.get());
                        output.accept(ModBlocks.CT_TILE_STAIRS_B_3.get());
                        output.accept(ModBlocks.CT_TILE_SLAB_B_3.get());
                        output.accept(ModBlocks.CT_TILE_WALL_B_3.get());
                        output.accept(ModBlocks.CT_TILE_B_VERT_3.get());

                        output.accept(ModBlocks.CT_PILLAR_TOP_R.get());
                        output.accept(ModBlocks.CT_TILE_STAIRS_R.get());
                        output.accept(ModBlocks.CT_TILE_SLAB_R.get());
                        output.accept(ModBlocks.CT_TILE_WALL_R.get());
                        output.accept(ModBlocks.CT_PILLAR_TOP_R_VERT.get());

                        output.accept(ModBlocks.CT_TILE_R_2.get());
                        output.accept(ModBlocks.CT_TILE_STAIRS_R_2.get());
                        output.accept(ModBlocks.CT_TILE_SLAB_R_2.get());
                        output.accept(ModBlocks.CT_TILE_WALL_R_2.get());
                        output.accept(ModBlocks.CT_TILE_R_VERT_2.get());

                        output.accept(ModBlocks.CT_TILE_R_3.get());
                        output.accept(ModBlocks.CT_TILE_STAIRS_R_3.get());
                        output.accept(ModBlocks.CT_TILE_SLAB_R_3.get());
                        output.accept(ModBlocks.CT_TILE_WALL_R_3.get());
                        output.accept(ModBlocks.CT_TILE_R_VERT_3.get());

                        output.accept(ModBlocks.CT_PILLAR_TOP_P.get());
                        output.accept(ModBlocks.CT_TILE_STAIRS_P.get());
                        output.accept(ModBlocks.CT_TILE_SLAB_P.get());
                        output.accept(ModBlocks.CT_TILE_WALL_P.get());
                        output.accept(ModBlocks.CT_PILLAR_TOP_P_VERT.get());

                        output.accept(ModBlocks.CT_TILE_P_2.get());
                        output.accept(ModBlocks.CT_TILE_STAIRS_P_2.get());
                        output.accept(ModBlocks.CT_TILE_SLAB_P_2.get());
                        output.accept(ModBlocks.CT_TILE_WALL_P_2.get());
                        output.accept(ModBlocks.CT_TILE_P_VERT_2.get());

                        output.accept(ModBlocks.CT_TILE_P_3.get());
                        output.accept(ModBlocks.CT_TILE_STAIRS_P_3.get());
                        output.accept(ModBlocks.CT_TILE_SLAB_P_3.get());
                        output.accept(ModBlocks.CT_TILE_WALL_P_3.get());
                        output.accept(ModBlocks.CT_TILE_P_VERT_3.get());

                        output.accept(ModBlocks.CT_PILLAR.get());
                        output.accept(ModBlocks.CT_PILLAR_2.get());
                        output.accept(ModBlocks.CT_PILLAR_3.get());
                        output.accept(ModBlocks.CT_PILLAR_G.get());
                        output.accept(ModBlocks.CT_PILLAR_G_2.get());
                        output.accept(ModBlocks.CT_PILLAR_B.get());
                        output.accept(ModBlocks.CT_PILLAR_B_2.get());
                        output.accept(ModBlocks.CT_PILLAR_R.get());
                        output.accept(ModBlocks.CT_PILLAR_R_2.get());
                        output.accept(ModBlocks.CT_PILLAR_P.get());
                        output.accept(ModBlocks.CT_PILLAR_P_2.get());






                    })
                    .build());

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }

}
