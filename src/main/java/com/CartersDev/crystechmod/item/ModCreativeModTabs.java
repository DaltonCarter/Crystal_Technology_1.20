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

                    output.accept(ModItems.FIRESTONE.get());
                    output.accept(ModBlocks.FIRESTONE_BLOCK.get());
                    output.accept(ModItems.TIBERIUM.get());
                    output.accept(ModBlocks.TIBERIUM_BLOCK.get());
                    output.accept(ModItems.TIBERIUM_BLUE.get());
                    output.accept(ModBlocks.TIBERIUM_BLUE_BLOCK.get());
                    output.accept(ModItems.TIBERIUM_RED.get());
                    output.accept(ModBlocks.TIBERIUM_RED_BLOCK.get());
                    output.accept(ModItems.TIBERIUM_PURPLE.get());
                    output.accept(ModBlocks.TIBERIUM_PURPLE_BLOCK.get());

                    output.accept(ModBlocks.AERIES_ORE.get());
                    output.accept(ModItems.AERIES_CRYSTAL.get());
                    output.accept(ModBlocks.AERIES_BLOCK.get());

                    output.accept(ModBlocks.ENIGMA_ORE.get());
                    output.accept(ModItems.ENIGMA_CRYSTAL.get());
                    output.accept(ModBlocks.ENIGMA_BLOCK.get());

                    output.accept(ModBlocks.ILLUMINA_ORE.get());
                    output.accept(ModItems.ILLUMINA_CRYSTAL.get());
                    output.accept(ModBlocks.ILLUMINA_BLOCK.get());

                    output.accept(ModBlocks.KRYON_ORE.get());
                    output.accept(ModItems.KRYON_CRYSTAL.get());
                    output.accept(ModBlocks.KRYON_BLOCK.get());

                    output.accept(ModBlocks.QUALRITE_ORE.get());
                    output.accept(ModItems.RAW_QUALRITE.get());
                    output.accept(ModItems.QUALRIM_COMPOUND.get());

                    output.accept(ModBlocks.GUNDANIUM_ORE.get());
                    output.accept(ModItems.GUNDANIUM_DUST.get());
                    output.accept(ModItems.GUNDANIUM_INGOT.get());
                    output.accept(ModBlocks.GUNDANIUM_BLOCK.get());

                    output.accept(ModBlocks.ALYTHUM_ORE.get());
                    output.accept(ModItems.ALYTHUM_DUST.get());
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


                    output.accept(ModBlocks.YELLOW_ZONE_CRACKED_DIRT.get());
                    output.accept(ModBlocks.RED_ZONE_DIRT.get());
                    output.accept(ModBlocks.SEEDED_YELLOW_ZONE_CRACKED_DIRT.get());
                    output.accept(ModBlocks.SEEDED_RED_ZONE_DIRT.get());
                    output.accept(ModBlocks.YELLOW_ZONE_SAND.get());
                    output.accept(ModBlocks.RED_ZONE_SAND.get());
                    output.accept(ModBlocks.SEEDED_DIRT.get());

                    output.accept(ModBlocks.INFESTED_ANDESITE.get());
                    output.accept(ModBlocks.INFESTED_COBBLE.get());
                    output.accept(ModBlocks.INFESTED_STONE.get());
                    output.accept(ModBlocks.INFESTED_STONE_BRICKS.get());
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


                })
                .build());


    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }

}
