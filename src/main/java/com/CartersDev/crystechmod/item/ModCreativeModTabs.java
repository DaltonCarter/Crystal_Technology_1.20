package com.CartersDev.crystechmod.item;

import com.CartersDev.crystechmod.CrystalTech;
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
                    output.accept(ModItems.TIBERIUM.get());
                    output.accept(ModItems.TIBERIUM_BLUE.get());
                    output.accept(ModItems.TIBERIUM_RED.get());
                    output.accept(ModItems.TIBERIUM_PURPLE.get());

                    output.accept(ModItems.AERIES_CRYSTAL.get());
                    output.accept(ModItems.ENIGMA_CRYSTAL.get());
                    output.accept(ModItems.ILLUMINA_CRYSTAL.get());
                    output.accept(ModItems.KRYON_CRYSTAL.get());

                    output.accept(ModItems.RAW_QUALRITE.get());
                    output.accept(ModItems.QUALRIM_COMPOUND.get());

                    output.accept(ModItems.GUNDANIUM_DUST.get());
                    output.accept(ModItems.GUNDANIUM_INGOT.get());

                    output.accept(ModItems.ALYTHUM_DUST.get());
                    output.accept(ModItems.ALYTHUM_INGOT.get());

                    output.accept(ModItems.ILLYRIM_BLEND.get());
                    output.accept(ModItems.ILLYRIM_INGOT.get());

                    output.accept(ModItems.LG_CORE_BLEND.get());
                    output.accept(ModItems.LG_CORE_INGOT.get());

                    output.accept(ModItems.MG_CORE_BLEND.get());
                    output.accept(ModItems.MG_CORE_INGOT.get());

                    output.accept(ModItems.HG_CORE_BLEND.get());
                    output.accept(ModItems.HG_CORE_INGOT.get());

                    output.accept(ModItems.PLAGUED_STICK.get());

                    output.accept(ModItems.GDI_EMBLEM.get());
                    output.accept(ModItems.NOD_EMBLEM.get());
                    output.accept(ModItems.WOLF_EMBLEM.get());


                })
                .build());


    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }

}
