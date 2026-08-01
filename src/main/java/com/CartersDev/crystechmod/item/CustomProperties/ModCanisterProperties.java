package com.CartersDev.crystechmod.item.CustomProperties;

import com.CartersDev.crystechmod.CrystalTech;
import com.CartersDev.crystechmod.item.ModItems;
import net.minecraft.client.renderer.item.ItemProperties;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fluids.FluidUtil;

public class ModCanisterProperties {
    public static void registerCanisterVariants() {

        ItemProperties.register(ModItems.EMPTY_CANISTER.get(), new ResourceLocation(CrystalTech.MOD_ID, "fluid_type"),
                (itemStack, level, livingEntity, seed) -> {
            return FluidUtil.getFluidHandler(itemStack).map(handler -> {
                FluidStack fluid = handler.getFluidInTank(0);
                if(fluid.isEmpty()) return 0.0f;

                String fluidId = fluid.getFluid().getFluidType().toString();

                return switch(fluidId) {
                    case "minecraft:lava" -> 1.0f;
                    case "crystechmod:molten_tiberium_fluid" -> 2.0f;
                    case "crystechmod:molten_blue_tiberium_fluid" -> 3.0f;
                    case "crystechmod:molten_red_tiberium_fluid" -> 4.0f;
                    case "crystechmod:molten_purple_tiberium_fluid" -> 5.0f;
                    case "crystechmod:liquid_protoculture_fluid" -> 6.0f;
                    default -> 0.0f;

                };
            }).orElse(0.0f);
                });

        ItemProperties.register(ModItems.IMPROVED_EMPTY_CANISTER.get(), new ResourceLocation(CrystalTech.MOD_ID, "fluid_type"),
                (itemStack, level, livingEntity, seed) -> {
                    return FluidUtil.getFluidHandler(itemStack).map(handler -> {
                        FluidStack fluid = handler.getFluidInTank(0);
                        if(fluid.isEmpty()) return 0.0f;

                        String fluidId = fluid.getFluid().getFluidType().toString();

                        return switch(fluidId) {
                            case "minecraft:lava" -> 1.0f;
                            case "crystechmod:molten_tiberium_fluid" -> 2.0f;
                            case "crystechmod:molten_blue_tiberium_fluid" -> 3.0f;
                            case "crystechmod:molten_red_tiberium_fluid" -> 4.0f;
                            case "crystechmod:molten_purple_tiberium_fluid" -> 5.0f;
                            case "crystechmod:liquid_protoculture_fluid" -> 6.0f;
                            default -> 0.0f;

                        };
                    }).orElse(0.0f);
                });

        ItemProperties.register(ModItems.ADVANCED_EMPTY_CANISTER.get(), new ResourceLocation(CrystalTech.MOD_ID, "fluid_type"),
                (itemStack, level, livingEntity, seed) -> {
                    return FluidUtil.getFluidHandler(itemStack).map(handler -> {
                        FluidStack fluid = handler.getFluidInTank(0);
                        if(fluid.isEmpty()) return 0.0f;

                        String fluidId = fluid.getFluid().getFluidType().toString();

                        return switch(fluidId) {
                            case "minecraft:lava" -> 1.0f;
                            case "crystechmod:molten_tiberium_fluid" -> 2.0f;
                            case "crystechmod:molten_blue_tiberium_fluid" -> 3.0f;
                            case "crystechmod:molten_red_tiberium_fluid" -> 4.0f;
                            case "crystechmod:molten_purple_tiberium_fluid" -> 5.0f;
                            case "crystechmod:liquid_protoculture_fluid" -> 6.0f;
                            default -> 0.0f;

                        };
                    }).orElse(0.0f);
                });

        ItemProperties.register(ModItems.ULTIMATE_EMPTY_CANISTER.get(), new ResourceLocation(CrystalTech.MOD_ID, "fluid_type"),
                (itemStack, level, livingEntity, seed) -> {
                    return FluidUtil.getFluidHandler(itemStack).map(handler -> {
                        FluidStack fluid = handler.getFluidInTank(0);
                        if(fluid.isEmpty()) return 0.0f;

                        String fluidId = fluid.getFluid().getFluidType().toString();

                        return switch(fluidId) {
                            case "minecraft:lava" -> 1.0f;
                            case "crystechmod:molten_tiberium_fluid" -> 2.0f;
                            case "crystechmod:molten_blue_tiberium_fluid" -> 3.0f;
                            case "crystechmod:molten_red_tiberium_fluid" -> 4.0f;
                            case "crystechmod:molten_purple_tiberium_fluid" -> 5.0f;
                            case "crystechmod:liquid_protoculture_fluid" -> 6.0f;
                            default -> 0.0f;

                        };
                    }).orElse(0.0f);
                }

        );

    }



}
