package com.CartersDev.crystechmod.screen;

import com.CartersDev.crystechmod.CrystalTech;
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

    public static final RegistryObject<MenuType<TiberiumInfuserMenu>> TIBERIUM_INFUSER_MENU =
            registerMenuType("tiberium_infuser_menu", TiberiumInfuserMenu::new);




private static <T extends AbstractContainerMenu>RegistryObject<MenuType<T>> registerMenuType(String name, IContainerFactory<T> factory) {
    return MENUS.register(name, () -> IForgeMenuType.create(factory));
}

    public static void register(IEventBus eventBus) {
        MENUS.register(eventBus);
    }

}
