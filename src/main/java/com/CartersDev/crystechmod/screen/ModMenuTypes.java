package com.CartersDev.crystechmod.screen;

import com.CartersDev.crystechmod.CrystalTech;
import com.CartersDev.crystechmod.screen.alloyKilnMenu.AlloyKilnMenu;
import com.CartersDev.crystechmod.screen.alloyKilnMenu.AlythumAlloyKilnMenu;
import com.CartersDev.crystechmod.screen.alloyKilnMenu.CrystalCoreAlloyKilnMenu;
import com.CartersDev.crystechmod.screen.alloyKilnMenu.VitricAlloyKilnMenu;
import com.CartersDev.crystechmod.screen.grinderMenu.TiberiumGrinderMenu;
import com.CartersDev.crystechmod.screen.infuserMenu.AlythumTiberiumInfuserMenu;
import com.CartersDev.crystechmod.screen.infuserMenu.CrystalCoreTiberiumInfuserMenu;
import com.CartersDev.crystechmod.screen.infuserMenu.TiberiumInfuserMenu;
import com.CartersDev.crystechmod.screen.infuserMenu.VitricTiberiumInfuserMenu;
import com.CartersDev.crystechmod.screen.maceratorMenu.AlythumTiberiumMaceratorMenu;
import com.CartersDev.crystechmod.screen.maceratorMenu.CrystalCoreTiberiumMaceratorMenu;
import com.CartersDev.crystechmod.screen.maceratorMenu.TiberiumMaceratorMenu;
import com.CartersDev.crystechmod.screen.maceratorMenu.VitricTiberiumMaceratorMenu;
import com.CartersDev.crystechmod.screen.poweredKilnMenu.AlythumKilnMenu;
import com.CartersDev.crystechmod.screen.poweredKilnMenu.CrystalCoreKilnMenu;
import com.CartersDev.crystechmod.screen.poweredKilnMenu.PoweredKilnMenu;
import com.CartersDev.crystechmod.screen.poweredKilnMenu.VitricKilnMenu;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.MenuType;
import net.minecraftforge.common.extensions.IForgeMenuType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.network.IContainerFactory;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModMenuTypes {

    public static final DeferredRegister<MenuType<?>> MENUS =
            DeferredRegister.create(ForgeRegistries.MENU_TYPES, CrystalTech.MOD_ID);


    public static final RegistryObject<MenuType<TiberiumGrinderMenu>> TIBERIUM_GRINDER_MENU =
            registerMenuType("tiberium_grinder_menu", TiberiumGrinderMenu::new);

    public static final RegistryObject<MenuType<TiberiumMaceratorMenu>> TIBERIUM_MACERATOR_MENU =
            registerMenuType("tiberium_macerator_menu", TiberiumMaceratorMenu::new);

    public static final RegistryObject<MenuType<AlythumTiberiumMaceratorMenu>> ALYTHUM_TIBERIUM_MACERATOR_MENU =
            registerMenuType("alythum_tiberium_macerator_menu", AlythumTiberiumMaceratorMenu::new);

    public static final RegistryObject<MenuType<VitricTiberiumMaceratorMenu>> VITRIC_TIBERIUM_MACERATOR_MENU =
            registerMenuType("vitric_tiberium_macerator_menu", VitricTiberiumMaceratorMenu::new);

    public static final RegistryObject<MenuType<CrystalCoreTiberiumMaceratorMenu>> CRYSTAL_CORE_TIBERIUM_MACERATOR_MENU =
            registerMenuType("crystal_core_tiberium_macerator_menu", CrystalCoreTiberiumMaceratorMenu::new);

    public static final RegistryObject<MenuType<TiberiumInfuserMenu>> TIBERIUM_INFUSER_MENU =
            registerMenuType("tiberium_infuser_menu", TiberiumInfuserMenu::new);

    public static final RegistryObject<MenuType<AlythumTiberiumInfuserMenu>> ALYTHUM_TIBERIUM_INFUSER_MENU =
            registerMenuType("alythum_tiberium_infuser_menu", AlythumTiberiumInfuserMenu::new);

    public static final RegistryObject<MenuType<VitricTiberiumInfuserMenu>> VITRIC_TIBERIUM_INFUSER_MENU =
            registerMenuType("vitric_tiberium_infuser_menu", VitricTiberiumInfuserMenu::new);

    public static final RegistryObject<MenuType<CrystalCoreTiberiumInfuserMenu>> CRYSTAL_CORE_TIBERIUM_INFUSER_MENU =
            registerMenuType("crystal_core_tiberium_infuser_menu", CrystalCoreTiberiumInfuserMenu::new);


    public static final RegistryObject<MenuType<PoweredKilnMenu>> POWERED_KILN_MENU =
            registerMenuType("powered_kiln_menu", PoweredKilnMenu::new);

    public static final RegistryObject<MenuType<AlythumKilnMenu>> ALYTHUM_KILN_MENU =
            registerMenuType("alythum_kiln_menu", AlythumKilnMenu::new);

    public static final RegistryObject<MenuType<VitricKilnMenu>> VITRIC_KILN_MENU =
            registerMenuType("vitric_kiln_menu", VitricKilnMenu::new);

    public static final RegistryObject<MenuType<CrystalCoreKilnMenu>> CRYSTAL_CORE_KILN_MENU =
            registerMenuType("crystal_core_kiln_menu", CrystalCoreKilnMenu::new);



    public static final RegistryObject<MenuType<AlloyKilnMenu>> ALLOY_KILN_MENU =
            registerMenuType("alloy_kiln_menu", AlloyKilnMenu::new);

    public static final RegistryObject<MenuType<AlythumAlloyKilnMenu>> ALYTHUM_ALLOY_KILN_MENU =
            registerMenuType("alythum_alloy_kiln_menu", AlythumAlloyKilnMenu::new);

    public static final RegistryObject<MenuType<VitricAlloyKilnMenu>> VITRIC_ALLOY_KILN_MENU =
            registerMenuType("vitric_alloy_kiln_menu", VitricAlloyKilnMenu::new);

    public static final RegistryObject<MenuType<CrystalCoreAlloyKilnMenu>> CRYSTAL_CORE_ALLOY_KILN_MENU =
            registerMenuType("crystal_core_alloy_kiln_menu", CrystalCoreAlloyKilnMenu::new);



private static <T extends AbstractContainerMenu>RegistryObject<MenuType<T>> registerMenuType(String name, IContainerFactory<T> factory) {
    return MENUS.register(name, () -> IForgeMenuType.create(factory));
}

    public static void register(IEventBus eventBus) {
        MENUS.register(eventBus);
    }

}
