package com.CartersDev.crystechmod.screen;

import com.CartersDev.crystechmod.CrystalTech;
import com.CartersDev.crystechmod.screen.AlloyKiln.alloyKilnMenu.AlloyKilnMenu;
import com.CartersDev.crystechmod.screen.AlloyKiln.alloyKilnMenu.AlythumAlloyKilnMenu;
import com.CartersDev.crystechmod.screen.AlloyKiln.alloyKilnMenu.CrystalCoreAlloyKilnMenu;
import com.CartersDev.crystechmod.screen.AlloyKiln.alloyKilnMenu.VitricAlloyKilnMenu;
import com.CartersDev.crystechmod.screen.CrystalCoreMatrix.crystalCoreMatrixMenu.CrystalCoreMatrixMenu;
import com.CartersDev.crystechmod.screen.FluidSilo.fluidSiloMenu.FluidSiloMenu;
import com.CartersDev.crystechmod.screen.Grinder.grinderMenu.TiberiumGrinderMenu;
import com.CartersDev.crystechmod.screen.Infuser.infuserMenu.AlythumTiberiumInfuserMenu;
import com.CartersDev.crystechmod.screen.Infuser.infuserMenu.CrystalCoreTiberiumInfuserMenu;
import com.CartersDev.crystechmod.screen.Infuser.infuserMenu.TiberiumInfuserMenu;
import com.CartersDev.crystechmod.screen.Infuser.infuserMenu.VitricTiberiumInfuserMenu;
import com.CartersDev.crystechmod.screen.Macerator.maceratorMenu.AlythumTiberiumMaceratorMenu;
import com.CartersDev.crystechmod.screen.Macerator.maceratorMenu.CrystalCoreTiberiumMaceratorMenu;
import com.CartersDev.crystechmod.screen.Macerator.maceratorMenu.TiberiumMaceratorMenu;
import com.CartersDev.crystechmod.screen.Macerator.maceratorMenu.VitricTiberiumMaceratorMenu;
import com.CartersDev.crystechmod.screen.PowerCore.powerCoreMenu.PowerCoreMenu;
import com.CartersDev.crystechmod.screen.PoweredKiln.poweredKilnMenu.AlythumKilnMenu;
import com.CartersDev.crystechmod.screen.PoweredKiln.poweredKilnMenu.CrystalCoreKilnMenu;
import com.CartersDev.crystechmod.screen.PoweredKiln.poweredKilnMenu.PoweredKilnMenu;
import com.CartersDev.crystechmod.screen.PoweredKiln.poweredKilnMenu.VitricKilnMenu;
import com.CartersDev.crystechmod.screen.ProtocultureMatrix.protocultureMatrixMenu.ProtocultureMatrixMenu;
import com.CartersDev.crystechmod.screen.StirlingMatrix.stirlingMatrixMenu.StirlingMatrixMenu;
import com.CartersDev.crystechmod.screen.VitriciumMatrix.vitriciumMatrixMenu.VitriciumMatrixMenu;
import com.CartersDev.crystechmod.screen.VitriciumRefinery.vitriciumRefineryMenu.AlythumVitriciumRefineryMenu;
import com.CartersDev.crystechmod.screen.VitriciumRefinery.vitriciumRefineryMenu.CrystalCoreVitriciumRefineryMenu;
import com.CartersDev.crystechmod.screen.VitriciumRefinery.vitriciumRefineryMenu.VitricVitriciumRefineryMenu;
import com.CartersDev.crystechmod.screen.VitriciumRefinery.vitriciumRefineryMenu.VitriciumRefineryMenu;
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



    public static final RegistryObject<MenuType<VitriciumRefineryMenu>> VITRICIUM_REFINERY_MENU =
            registerMenuType("vitricium_refinery_menu", VitriciumRefineryMenu::new);

    public static final RegistryObject<MenuType<AlythumVitriciumRefineryMenu>> ALYTHUM_VITRICIUM_REFINERY_MENU =
            registerMenuType("alythum_vitricium_refinery_menu", AlythumVitriciumRefineryMenu::new);

    public static final RegistryObject<MenuType<VitricVitriciumRefineryMenu>> VITRIC_VITRICIUM_REFINERY_MENU =
            registerMenuType("vitric_vitricium_refinery_menu", VitricVitriciumRefineryMenu::new);

    public static final RegistryObject<MenuType<CrystalCoreVitriciumRefineryMenu>> CRYSTAL_CORE_VITRICIUM_REFINERY_MENU =
            registerMenuType("crystal_core_vitricium_refinery_menu", CrystalCoreVitriciumRefineryMenu::new);


    public static final RegistryObject<MenuType<FluidSiloMenu>> FLUID_SILO_MENU =
            registerMenuType("fluid_silo_menu", FluidSiloMenu::new);


    public static final RegistryObject<MenuType<PowerCoreMenu>> POWER_CORE_MENU =
            registerMenuType("power_core_menu", PowerCoreMenu::new);



    public static final RegistryObject<MenuType<StirlingMatrixMenu>> STIRLING_MATRIX_MENU =
            registerMenuType("stirling_matrix_menu", StirlingMatrixMenu::new);

    public static final RegistryObject<MenuType<VitriciumMatrixMenu>> VITRICIUM_MATRIX_MENU =
            registerMenuType("vitricium_matrix_menu", VitriciumMatrixMenu::new);

    public static final RegistryObject<MenuType<ProtocultureMatrixMenu>> PROTOCULTURE_MATRIX_MENU =
            registerMenuType("protoculture_matrix_menu", ProtocultureMatrixMenu::new);

    public static final RegistryObject<MenuType<CrystalCoreMatrixMenu>> CRYSTAL_CORE_MATRIX_MENU =
            registerMenuType("crystal_core_matrix_menu", CrystalCoreMatrixMenu::new);



private static <T extends AbstractContainerMenu>RegistryObject<MenuType<T>> registerMenuType(String name, IContainerFactory<T> factory) {
    return MENUS.register(name, () -> IForgeMenuType.create(factory));
}

    public static void register(IEventBus eventBus) {
        MENUS.register(eventBus);
    }

}
