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

                    output.accept(ModBlocks.TEST_BLOCK.get());

                    output.accept(ModBlocks.BLOSSOM_SPOUT.get());
                    output.accept(ModBlocks.BLOSSOM_CENTER.get());
                    output.accept(ModBlocks.BLOSSOM_BASE.get());
                    output.accept(ModBlocks.BLOSSOM_ARM.get());

                    output.accept(ModBlocks.NOD_CREST_LARGE.get());
                    output.accept(ModItems.RHINO_SPAWN_EGG.get());

                    output.accept(ModBlocks.TIBERIUM_GRINDER.get());

                    output.accept(ModItems.PLAGUED_STICK.get());

                    output.accept(ModItems.YOKARAN_BLOOM_POWDER.get());
                    output.accept(ModItems.DEVILS_BLOOD_POWDER.get());
                    output.accept(ModItems.TIBERIUM_WATER_BUCKET.get());

                    output.accept(ModItems.TIBERIUM_LEATHER.get());
                    output.accept(ModItems.ICHOR_LEATHER.get());

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

                    output.accept(ModBlocks.GUNDANIUM_ORE.get());
                    output.accept(ModBlocks.DEEPSLATE_GUNDANIUM_ORE.get());
                    output.accept(ModItems.GUNDANIUM_DUST.get());
                    output.accept(ModItems.RAW_GUNDANIUM.get());
                    output.accept(ModItems.GUNDANIUM_INGOT.get());
                    output.accept(ModBlocks.GUNDANIUM_BLOCK.get());

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

                    output.accept(ModItems.GDI_EMBLEM.get());
                    output.accept(ModItems.NOD_EMBLEM.get());
                    output.accept(ModItems.WOLF_EMBLEM.get());


                })
                .build());

    public static final RegistryObject<CreativeModeTab> FOOD_TAB = CREATIVE_MODE_TABS.register("crystal_technology_food_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.TIBERIUM_FRUIT.get()))
                    .title(Component.translatable("creativetab.crystal_technology_food_tab"))
                    .displayItems((itemDisplayParameters, output) -> {
                        output.accept(ModItems.TIBERIUM_FRUIT.get());
                        output.accept(ModItems.STRAWBERRY.get());
                        output.accept(ModItems.CORN.get());
                        output.accept(ModItems.STRAWBERRY_SEEDS.get());
                        output.accept(ModItems.CORN_SEEDS.get());
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

                        output.accept(ModItems.ALYTHUM_SWORD.get());
                        output.accept(ModItems.ALYTHUM_PICKAXE.get());
                        output.accept(ModItems.ALYTHUM_AXE.get());
                        output.accept(ModItems.ALYTHUM_SHOVEL.get());
                        output.accept(ModItems.ALYTHUM_HOE.get());
                        output.accept(ModItems.ALYTHUM_PAXEL.get());
                        output.accept(ModItems.ALYTHUM_HAMMER.get());

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
                        output.accept(ModItems.OBSESSION_SOFTWARE_MUSIC_DISC.get());
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
                        output.accept(ModItems.CANYON_CHASE_MUSIC_DISC.get());
                        output.accept(ModItems.CREEPING_UPON_MUSIC_DISC.get());
                        output.accept(ModItems.DEPTH_CHARGE_MUSIC_DISC.get());
                        output.accept(ModItems.DRONE_MUSIC_DISC.get());
                        output.accept(ModItems.ON_THE_PROWL_MUSIC_DISC.get());
                        output.accept(ModItems.RAIN_IN_THE_NIGHT_MUSIC_DISC.get());
                        output.accept(ModItems.RECON_MUSIC_DISC.get());
                        output.accept(ModItems.AWAITING_MUSIC_DISC.get());
                        output.accept(ModItems.DENSE_MUSIC_DISC.get());
                        output.accept(ModItems.FLOATING_MUSIC_DISC.get());
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

                        output.accept(ModBlocks.HYACINTH.get());
                        output.accept(ModBlocks.FLOWER_OF_LIFE.get());
                        output.accept(ModBlocks.DEVILS_BLOOD.get());
                        output.accept(ModBlocks.YOKARAN_BLOOM.get());

                        output.accept(ModBlocks.TIBERIUM_SOIL.get());
                        output.accept(ModBlocks.ICHOR_SOIL.get());
                        output.accept(ModBlocks.YELLOW_ZONE_CRACKED_DIRT.get());
                        output.accept(ModBlocks.RED_ZONE_DIRT.get());
                        output.accept(ModBlocks.SEEDED_YELLOW_ZONE_CRACKED_DIRT.get());
                        output.accept(ModBlocks.SEEDED_RED_ZONE_DIRT.get());
                        output.accept(ModBlocks.YELLOW_ZONE_SAND.get());
                        output.accept(ModBlocks.RED_ZONE_SAND.get());
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

                        output.accept(ModBlocks.INFESTED_ANDESITE.get());
                        output.accept(ModBlocks.PLAGUED_ANDESITE_STAIRS.get());
                        output.accept(ModBlocks.PLAGUED_ANDESITE_SLAB.get());
                        output.accept(ModBlocks.PLAGUED_ANDESITE_WALL.get());

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

                        output.accept(ModBlocks.RIPARIUS_STONE.get());
                        output.accept(ModBlocks.RIPARIUS_STONE_STAIRS.get());
                        output.accept(ModBlocks.RIPARIUS_STONE_SLAB.get());
                        output.accept(ModBlocks.RIPARIUS_STONE_WALL.get());

                        output.accept(ModBlocks.RIPARIUS_STONE_BRICKS.get());
                        output.accept(ModBlocks.RIPARIUS_STONE_BRICK_SLAB.get());
                        output.accept(ModBlocks.RIPARIUS_STONE_BRICK_STAIRS.get());
                        output.accept(ModBlocks.RIPARIUS_STONE_BRICK_WALL.get());

                        output.accept(ModBlocks.CRUENTUS_STONE.get());
                        output.accept(ModBlocks.CRUENTUS_STONE_STAIRS.get());
                        output.accept(ModBlocks.CRUENTUS_STONE_SLAB.get());
                        output.accept(ModBlocks.CRUENTUS_STONE_WALL.get());

                        output.accept(ModBlocks.CRUENTUS_STONE_BRICKS.get());
                        output.accept(ModBlocks.CRUENTUS_STONE_BRICK_SLAB.get());
                        output.accept(ModBlocks.CRUENTUS_STONE_BRICK_STAIRS.get());
                        output.accept(ModBlocks.CRUENTUS_STONE_BRICK_WALL.get());

                        output.accept(ModBlocks.VINIFERA_STONE.get());
                        output.accept(ModBlocks.VINIFERA_STONE_STAIRS.get());
                        output.accept(ModBlocks.VINIFERA_STONE_SLAB.get());
                        output.accept(ModBlocks.VINIFERA_STONE_WALL.get());

                        output.accept(ModBlocks.VINIFERA_STONE_BRICKS.get());
                        output.accept(ModBlocks.VINIFERA_STONE_BRICK_SLAB.get());
                        output.accept(ModBlocks.VINIFERA_STONE_BRICK_STAIRS.get());
                        output.accept(ModBlocks.VINIFERA_STONE_BRICK_WALL.get());

                        output.accept(ModBlocks.ABOREUS_STONE.get());
                        output.accept(ModBlocks.ABOREUS_STONE_STAIRS.get());
                        output.accept(ModBlocks.ABOREUS_STONE_SLAB.get());
                        output.accept(ModBlocks.ABOREUS_STONE_WALL.get());

                        output.accept(ModBlocks.ABOREUS_STONE_BRICKS.get());
                        output.accept(ModBlocks.ABOREUS_STONE_BRICK_SLAB.get());
                        output.accept(ModBlocks.ABOREUS_STONE_BRICK_STAIRS.get());
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

                    })
                    .build());

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }

}
