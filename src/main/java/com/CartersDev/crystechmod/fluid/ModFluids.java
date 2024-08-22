package com.CartersDev.crystechmod.fluid;



import com.CartersDev.crystechmod.CrystalTech;
import com.CartersDev.crystechmod.block.ModBlocks;
import com.CartersDev.crystechmod.item.ModItems;
import net.minecraft.world.level.material.FlowingFluid;
import net.minecraft.world.level.material.Fluid;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fluids.ForgeFlowingFluid;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModFluids {
    public static final DeferredRegister<Fluid> FLUIDS =
            DeferredRegister.create(ForgeRegistries.FLUIDS, CrystalTech.MOD_ID);


//Tiberium Water
    public static final RegistryObject<FlowingFluid> SOURCE_TIBERIUM_WATER = FLUIDS.register("tiberium_water_source",
        () -> new ForgeFlowingFluid.Source(ModFluids.TIBERIUM_WATER_FLUID_PROPERTIES));
    public static final RegistryObject<FlowingFluid> FLOWING_TIBERIUM_WATER = FLUIDS.register("flowing_tiberium_water",
            () -> new ForgeFlowingFluid.Flowing(ModFluids.TIBERIUM_WATER_FLUID_PROPERTIES));

    public static final ForgeFlowingFluid.Properties TIBERIUM_WATER_FLUID_PROPERTIES = new ForgeFlowingFluid.Properties(
        ModFluidTypes.TIBERIUM_WATER_FLUID_TYPE, SOURCE_TIBERIUM_WATER, FLOWING_TIBERIUM_WATER).slopeFindDistance(2)
        .levelDecreasePerBlock(2).block(ModBlocks.TIBERIUM_WATER_BLOCK).bucket(ModItems.TIBERIUM_WATER_BUCKET);

//End of Tiberium Water


//Molten Tiberium
public static final RegistryObject<FlowingFluid> SOURCE_MOLTEN_TIBERIUM = FLUIDS.register("molten_tiberium_source",
        () -> new ForgeFlowingFluid.Source(ModFluids.MOLTEN_TIBERIUM_FLUID_PROPERTIES));
    public static final RegistryObject<FlowingFluid> FLOWING_MOLTEN_TIBERIUM = FLUIDS.register("molten_flowing_tiberium",
            () -> new ForgeFlowingFluid.Flowing(ModFluids.MOLTEN_TIBERIUM_FLUID_PROPERTIES));

    public static final ForgeFlowingFluid.Properties MOLTEN_TIBERIUM_FLUID_PROPERTIES = new ForgeFlowingFluid.Properties(
            ModFluidTypes.MOLTEN_TIBERIUM_FLUID_TYPE, SOURCE_MOLTEN_TIBERIUM, FLOWING_MOLTEN_TIBERIUM).slopeFindDistance(2)
            .levelDecreasePerBlock(2).block(ModBlocks.MOLTEN_TIBERIUM_BLOCK).bucket(ModItems.MOLTEN_TIBERIUM_BUCKET);


    public static final RegistryObject<FlowingFluid> SOURCE_MOLTEN_BLUE_TIBERIUM = FLUIDS.register("molten_blue_tiberium_source",
            () -> new ForgeFlowingFluid.Source(ModFluids.MOLTEN_BLUE_TIBERIUM_FLUID_PROPERTIES));
    public static final RegistryObject<FlowingFluid> FLOWING_MOLTEN_BLUE_TIBERIUM = FLUIDS.register("molten_flowing_blue_tiberium",
            () -> new ForgeFlowingFluid.Flowing(ModFluids.MOLTEN_BLUE_TIBERIUM_FLUID_PROPERTIES));

    public static final ForgeFlowingFluid.Properties MOLTEN_BLUE_TIBERIUM_FLUID_PROPERTIES = new ForgeFlowingFluid.Properties(
            ModFluidTypes.MOLTEN_BLUE_TIBERIUM_FLUID_TYPE, SOURCE_MOLTEN_BLUE_TIBERIUM, FLOWING_MOLTEN_BLUE_TIBERIUM).slopeFindDistance(2)
            .levelDecreasePerBlock(2).block(ModBlocks.MOLTEN_BLUE_TIBERIUM_BLOCK).bucket(ModItems.MOLTEN_BLUE_TIBERIUM_BUCKET);


    public static final RegistryObject<FlowingFluid> SOURCE_MOLTEN_RED_TIBERIUM = FLUIDS.register("molten_red_tiberium_source",
            () -> new ForgeFlowingFluid.Source(ModFluids.MOLTEN_RED_TIBERIUM_FLUID_PROPERTIES));
    public static final RegistryObject<FlowingFluid> FLOWING_MOLTEN_RED_TIBERIUM = FLUIDS.register("molten_flowing_red_tiberium",
            () -> new ForgeFlowingFluid.Flowing(ModFluids.MOLTEN_RED_TIBERIUM_FLUID_PROPERTIES));

    public static final ForgeFlowingFluid.Properties MOLTEN_RED_TIBERIUM_FLUID_PROPERTIES = new ForgeFlowingFluid.Properties(
            ModFluidTypes.MOLTEN_RED_TIBERIUM_FLUID_TYPE, SOURCE_MOLTEN_RED_TIBERIUM, FLOWING_MOLTEN_RED_TIBERIUM).slopeFindDistance(2)
            .levelDecreasePerBlock(2).block(ModBlocks.MOLTEN_RED_TIBERIUM_BLOCK).bucket(ModItems.MOLTEN_RED_TIBERIUM_BUCKET);


    public static final RegistryObject<FlowingFluid> SOURCE_MOLTEN_PURPLE_TIBERIUM = FLUIDS.register("molten_purple_tiberium_source",
            () -> new ForgeFlowingFluid.Source(ModFluids.MOLTEN_PURPLE_TIBERIUM_FLUID_PROPERTIES));
    public static final RegistryObject<FlowingFluid> FLOWING_MOLTEN_PURPLE_TIBERIUM = FLUIDS.register("molten_flowing_purple_tiberium",
            () -> new ForgeFlowingFluid.Flowing(ModFluids.MOLTEN_PURPLE_TIBERIUM_FLUID_PROPERTIES));

    public static final ForgeFlowingFluid.Properties MOLTEN_PURPLE_TIBERIUM_FLUID_PROPERTIES = new ForgeFlowingFluid.Properties(
            ModFluidTypes.MOLTEN_PURPLE_TIBERIUM_FLUID_TYPE, SOURCE_MOLTEN_PURPLE_TIBERIUM, FLOWING_MOLTEN_PURPLE_TIBERIUM).slopeFindDistance(2)
            .levelDecreasePerBlock(2).block(ModBlocks.MOLTEN_PURPLE_TIBERIUM_BLOCK).bucket(ModItems.MOLTEN_PURPLE_TIBERIUM_BUCKET);
//End of Molten Tiberium


public static void register(IEventBus eventBus) {
        FLUIDS.register(eventBus);
    }



}
