package com.CartersDev.crystechmod.item;

import com.CartersDev.crystechmod.CrystalTech;
import com.CartersDev.crystechmod.block.ModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModCreativeModTabs {

    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, CrystalTech.MOD_ID);

public static final RegistryObject<CreativeModeTab> TUTORIAL_TAB = CREATIVE_MODE_TABS.register("crystal_technology_tab",
        () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.TIBERIUM.get()))
                .title(Component.translatable("creativetab.crystal_technology_tab"))
                .displayItems((itemDisplayParameters, output) -> {

                    output.accept(ModItems.TIBERIUM_FRUIT.get());

//                    output.accept(ModBlocks.BLOSSOM_SPOUT.get());

                    output.accept(ModItems.FIRESTONE.get());
                    output.accept(ModBlocks.FIRESTONE_BLOCK.get());
                    output.accept(ModBlocks.FIRESTONE_WALL.get());
                    output.accept(ModItems.TIBERIUM.get());
                    output.accept(ModBlocks.TIBERIUM_BLOCK.get());
                    output.accept(ModItems.TIBERIUM_BLUE.get());
                    output.accept(ModBlocks.TIBERIUM_BLUE_BLOCK.get());
                    output.accept(ModItems.TIBERIUM_RED.get());
                    output.accept(ModBlocks.TIBERIUM_RED_BLOCK.get());
                    output.accept(ModItems.TIBERIUM_PURPLE.get());
                    output.accept(ModBlocks.TIBERIUM_PURPLE_BLOCK.get());

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

                    output.accept(ModItems.PLAGUED_STICK.get());

                    output.accept(ModItems.GDI_EMBLEM.get());
                    output.accept(ModItems.NOD_EMBLEM.get());
                    output.accept(ModItems.WOLF_EMBLEM.get());


                    output.accept(ModBlocks.TIBERIUM_SOIL.get());
                    output.accept(ModBlocks.ICHOR_SOIL.get());
                    output.accept(ModBlocks.YELLOW_ZONE_CRACKED_DIRT.get());
                    output.accept(ModBlocks.RED_ZONE_DIRT.get());
                    output.accept(ModBlocks.SEEDED_YELLOW_ZONE_CRACKED_DIRT.get());
                    output.accept(ModBlocks.SEEDED_RED_ZONE_DIRT.get());
                    output.accept(ModBlocks.YELLOW_ZONE_SAND.get());
                    output.accept(ModBlocks.RED_ZONE_SAND.get());
                    output.accept(ModBlocks.SEEDED_DIRT.get());

                    output.accept(ModBlocks.PLAGUED_PLANKS.get());
                    output.accept(ModBlocks.PLAGUED_STAIRS.get());
                    output.accept(ModBlocks.PLAGUED_SLAB.get());
                    output.accept(ModBlocks.PLAGUED_BUTTON.get());
                    output.accept(ModBlocks.PLAGUED_PRESSURE_PLATE.get());
                    output.accept(ModBlocks.PLAGUED_FENCE.get());
                    output.accept(ModBlocks.PLAGUED_FENCE_GATE.get());
                    output.accept(ModBlocks.PLAGUED_DOOR.get());
                    output.accept(ModBlocks.PLAGUED_TRAPDOOR.get());

                    output.accept(ModBlocks.INFESTED_ANDESITE.get());
                    output.accept(ModBlocks.INFESTED_COBBLE.get());
                    output.accept(ModBlocks.INFESTED_COBBLE_SLAB.get());
                    output.accept(ModBlocks.INFESTED_COBBLE_STAIRS.get());
                    output.accept(ModBlocks.INFESTED_STONE.get());
                    output.accept(ModBlocks.INFESTED_STONE_BRICKS.get());
                    output.accept(ModBlocks.INFESTED_STONE_BRICK_SLAB.get());
                    output.accept(ModBlocks.INFESTED_STONE_BRICK_STAIRS.get());
                    output.accept(ModBlocks.INFESTED_DIORITE.get());
                    output.accept(ModBlocks.INFESTED_GRANITE.get());

                    output.accept(ModBlocks.RIPARIUS_STONE.get());
                    output.accept(ModBlocks.CRUENTUS_STONE.get());
                    output.accept(ModBlocks.VINIFERA_STONE.get());
                    output.accept(ModBlocks.ABOREUS_STONE.get());

                    output.accept(ModBlocks.RIPARIUS_CRYSTAL.get());
                    output.accept(ModBlocks.VINIFERA_CRYSTAL.get());
                    output.accept(ModBlocks.CRUENTUS_CRYSTAL.get());
                    output.accept(ModBlocks.ABOREUS_CRYSTAL.get());

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

                    output.accept(ModBlocks.BLACK_TIBERCRETE.get());
                    output.accept(ModBlocks.BLACK_TIBERCRETE_STAIRS.get());
                    output.accept(ModBlocks.BLACK_TIBERCRETE_POWDER.get());
                    output.accept(ModBlocks.BLUE_TIBERCRETE.get());
                    output.accept(ModBlocks.BLUE_TIBERCRETE_STAIRS.get());
                    output.accept(ModBlocks.BLUE_TIBERCRETE_POWDER.get());
                    output.accept(ModBlocks.BROWN_TIBERCRETE.get());
                    output.accept(ModBlocks.BROWN_TIBERCRETE_STAIRS.get());
                    output.accept(ModBlocks.BROWN_TIBERCRETE_POWDER.get());
                    output.accept(ModBlocks.CYAN_TIBERCRETE.get());
                    output.accept(ModBlocks.CYAN_TIBERCRETE_STAIRS.get());
                    output.accept(ModBlocks.CYAN_TIBERCRETE_POWDER.get());
                    output.accept(ModBlocks.GRAY_TIBERCRETE.get());
                    output.accept(ModBlocks.GRAY_TIBERCRETE_STAIRS.get());
                    output.accept(ModBlocks.GRAY_TIBERCRETE_POWDER.get());
                    output.accept(ModBlocks.GREEN_TIBERCRETE.get());
                    output.accept(ModBlocks.GREEN_TIBERCRETE_STAIRS.get());
                    output.accept(ModBlocks.GREEN_TIBERCRETE_POWDER.get());
                    output.accept(ModBlocks.LIGHT_BLUE_TIBERCRETE.get());
                    output.accept(ModBlocks.LIGHT_BLUE_TIBERCRETE_STAIRS.get());
                    output.accept(ModBlocks.LIGHT_BLUE_TIBERCRETE_POWDER.get());
                    output.accept(ModBlocks.LIGHT_GRAY_TIBERCRETE.get());
                    output.accept(ModBlocks.LIGHT_GRAY_TIBERCRETE_STAIRS.get());
                    output.accept(ModBlocks.LIGHT_GRAY_TIBERCRETE_POWDER.get());
                    output.accept(ModBlocks.LIME_TIBERCRETE.get());
                    output.accept(ModBlocks.LIME_TIBERCRETE_STAIRS.get());
                    output.accept(ModBlocks.LIME_TIBERCRETE_POWDER.get());
                    output.accept(ModBlocks.MAGENTA_TIBERCRETE.get());
                    output.accept(ModBlocks.MAGENTA_TIBERCRETE_STAIRS.get());
                    output.accept(ModBlocks.MAGENTA_TIBERCRETE_POWDER.get());
                    output.accept(ModBlocks.ORANGE_TIBERCRETE.get());
                    output.accept(ModBlocks.ORANGE_TIBERCRETE_STAIRS.get());
                    output.accept(ModBlocks.ORANGE_TIBERCRETE_POWDER.get());
                    output.accept(ModBlocks.PINK_TIBERCRETE.get());
                    output.accept(ModBlocks.PINK_TIBERCRETE_STAIRS.get());
                    output.accept(ModBlocks.PINK_TIBERCRETE_POWDER.get());
                    output.accept(ModBlocks.PURPLE_TIBERCRETE.get());
                    output.accept(ModBlocks.PURPLE_TIBERCRETE_STAIRS.get());
                    output.accept(ModBlocks.PURPLE_TIBERCRETE_POWDER.get());
                    output.accept(ModBlocks.RED_TIBERCRETE.get());
                    output.accept(ModBlocks.RED_TIBERCRETE_STAIRS.get());
                    output.accept(ModBlocks.RED_TIBERCRETE_POWDER.get());
                    output.accept(ModBlocks.WHITE_TIBERCRETE.get());
                    output.accept(ModBlocks.WHITE_TIBERCRETE_STAIRS.get());
                    output.accept(ModBlocks.WHITE_TIBERCRETE_POWDER.get());
                    output.accept(ModBlocks.YELLOW_TIBERCRETE.get());
                    output.accept(ModBlocks.YELLOW_TIBERCRETE_STAIRS.get());
                    output.accept(ModBlocks.YELLOW_TIBERCRETE_POWDER.get());


                })
                .build());


    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }

}
