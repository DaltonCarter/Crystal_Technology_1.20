package com.CartersDev.crystechmod.fluid;

import com.CartersDev.crystechmod.CrystalTech;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvents;
import net.minecraftforge.common.SoundAction;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fluids.FluidType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import org.joml.Vector3f;

public class ModFluidTypes {
    public static final ResourceLocation WATER_STILL_RL = new ResourceLocation("block/water_still");
    public static final ResourceLocation WATER_FLOWING_RL = new ResourceLocation("block/water_flow");
    public static final ResourceLocation WATER_OVERLAY_RL = new ResourceLocation("block/water_overlay");

    //for Tiberium
    public static final ResourceLocation LT_STILL_RL = new ResourceLocation(CrystalTech.MOD_ID, "block/liquid_tiberium_still");
    public static final ResourceLocation LT_FLOWING_RL = new ResourceLocation(CrystalTech.MOD_ID, "block/liquid_tiberium_flow");

    //end of Tiberium

    public static final DeferredRegister<FluidType> FLUID_TYPES =
            DeferredRegister.create(ForgeRegistries.Keys.FLUID_TYPES, CrystalTech.MOD_ID);


    public static final RegistryObject<FluidType> TIBERIUM_WATER_FLUID_TYPE = register("tiberium_water_fluid",
            FluidType.Properties.create().lightLevel(2).density(15).viscosity(5).sound(SoundAction.get("drink"),
                    SoundEvents.HONEY_DRINK).canConvertToSource(true).canHydrate(true).canDrown(true));

    public static final RegistryObject<FluidType> MOLTEN_TIBERIUM_FLUID_TYPE = registerGreen("molten_tiberium_fluid",
            FluidType.Properties.create().lightLevel(10).density(15).viscosity(5));

    public static final RegistryObject<FluidType> MOLTEN_BLUE_TIBERIUM_FLUID_TYPE = registerBlue("molten_blue_tiberium_fluid",
            FluidType.Properties.create().lightLevel(10).density(15).viscosity(5));

    public static final RegistryObject<FluidType> MOLTEN_RED_TIBERIUM_FLUID_TYPE = registerRed("molten_red_tiberium_fluid",
            FluidType.Properties.create().lightLevel(10).density(15).viscosity(5));

    public static final RegistryObject<FluidType> MOLTEN_PURPLE_TIBERIUM_FLUID_TYPE = registerPurple("molten_purple_tiberium_fluid",
            FluidType.Properties.create().lightLevel(10).density(15).viscosity(5));


    private static RegistryObject<FluidType> register(String name, FluidType.Properties properties) {
        return FLUID_TYPES.register(name, () -> new BaseFluidType(WATER_STILL_RL, WATER_FLOWING_RL, WATER_OVERLAY_RL,
                0xA1809848, new Vector3f(128f / 255f, 152f / 255f, 72f / 255f), properties));
    }

    private static RegistryObject<FluidType> registerGreen(String name, FluidType.Properties properties) {
        return FLUID_TYPES.register(name, () -> new BaseFluidType(LT_STILL_RL, LT_FLOWING_RL, WATER_OVERLAY_RL,
                0xA1038C11, new Vector3f(3f / 255f, 140f / 255f, 17f / 255f), properties));
    }

    private static RegistryObject<FluidType> registerBlue(String name, FluidType.Properties properties) {
        return FLUID_TYPES.register(name, () -> new BaseFluidType(LT_STILL_RL, LT_FLOWING_RL, WATER_OVERLAY_RL,
                0xA12800B8, new Vector3f(40f / 255f, 0f / 255f, 184f / 255f), properties));
    }

    private static RegistryObject<FluidType> registerRed(String name, FluidType.Properties properties) {
        return FLUID_TYPES.register(name, () -> new BaseFluidType(LT_STILL_RL, LT_FLOWING_RL, WATER_OVERLAY_RL,
                0xA1760000, new Vector3f(118f / 255f, 0f / 255f, 0f / 255f), properties));
    }

    private static RegistryObject<FluidType> registerPurple(String name, FluidType.Properties properties) {
        return FLUID_TYPES.register(name, () -> new BaseFluidType(LT_STILL_RL, LT_FLOWING_RL, WATER_OVERLAY_RL,
                0xA1740E90, new Vector3f(116f / 255f, 14f / 255f, 144f / 255f), properties));
    }

    public static void register(IEventBus eventBus) {
        FLUID_TYPES.register(eventBus);
    }

}
