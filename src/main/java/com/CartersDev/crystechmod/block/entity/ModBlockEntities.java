package com.CartersDev.crystechmod.block.entity;

import com.CartersDev.crystechmod.CrystalTech;

import com.CartersDev.crystechmod.block.ModBlocks;
import com.CartersDev.crystechmod.block.entity.alloykiln.AlloyKilnBlockEntity;
import com.CartersDev.crystechmod.block.entity.alloykiln.AlythumAlloyKilnBlockEntity;
import com.CartersDev.crystechmod.block.entity.alloykiln.CrystalCoreAlloyKilnBlockEntity;
import com.CartersDev.crystechmod.block.entity.alloykiln.VitricAlloyKilnBlockEntity;
import com.CartersDev.crystechmod.block.entity.grinder.TiberiumGrinderBlockEntity;
import com.CartersDev.crystechmod.block.entity.infuser.AlythumTiberiumInfuserBlockEntity;
import com.CartersDev.crystechmod.block.entity.infuser.CrystalCoreTiberiumInfuserBlockEntity;
import com.CartersDev.crystechmod.block.entity.infuser.TiberiumInfuserBlockEntity;
import com.CartersDev.crystechmod.block.entity.infuser.VitricTiberiumInfuserBlockEntity;
import com.CartersDev.crystechmod.block.entity.macerator.AlythumTiberiumMaceratorBlockEntity;
import com.CartersDev.crystechmod.block.entity.macerator.CrystalCoreTiberiumMaceratorBlockEntity;
import com.CartersDev.crystechmod.block.entity.macerator.TiberiumMaceratorBlockEntity;
import com.CartersDev.crystechmod.block.entity.macerator.VitricTiberiumMaceratorBlockEntity;
import com.CartersDev.crystechmod.block.entity.poweredkiln.AlythumKilnBlockEntity;
import com.CartersDev.crystechmod.block.entity.poweredkiln.CrystalCoreKilnBlockEntity;
import com.CartersDev.crystechmod.block.entity.poweredkiln.PoweredKilnBlockEntity;
import com.CartersDev.crystechmod.block.entity.poweredkiln.VitricKilnBlockEntity;
import com.CartersDev.crystechmod.block.entity.refinery.AlythumVitriciumRefineryBlockEntity;
import com.CartersDev.crystechmod.block.entity.refinery.CrystalCoreVitriciumRefineryBlockEntity;
import com.CartersDev.crystechmod.block.entity.refinery.VitricVitriciumRefineryBlockEntity;
import com.CartersDev.crystechmod.block.entity.refinery.VitriciumRefineryBlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModBlockEntities {
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES =
            DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, CrystalTech.MOD_ID);


public static final RegistryObject<BlockEntityType<TiberiumGrinderBlockEntity>> TIBERIUM_GRINDER_BE =
        BLOCK_ENTITIES.register("tiberium_grinder_be", () -> BlockEntityType.Builder.of(
                TiberiumGrinderBlockEntity::new, ModBlocks.TIBERIUM_GRINDER.get()).build(null));

    public static final RegistryObject<BlockEntityType<TiberiumMaceratorBlockEntity>> TIBERIUM_MACERATOR_BE =
            BLOCK_ENTITIES.register("tiberium_macerator_be", () -> BlockEntityType.Builder.of(
                    TiberiumMaceratorBlockEntity::new, ModBlocks.TIBERIUM_MACERATOR.get()).build(null));

    public static final RegistryObject<BlockEntityType<AlythumTiberiumMaceratorBlockEntity>> ALYTHUM_TIBERIUM_MACERATOR_BE =
            BLOCK_ENTITIES.register("alythum_tiberium_macerator_be", () -> BlockEntityType.Builder.of(
                    AlythumTiberiumMaceratorBlockEntity::new, ModBlocks.ALYTHUM_TIBERIUM_MACERATOR.get()).build(null));

    public static final RegistryObject<BlockEntityType<VitricTiberiumMaceratorBlockEntity>> VITRIC_TIBERIUM_MACERATOR_BE =
            BLOCK_ENTITIES.register("vitric_tiberium_macerator_be", () -> BlockEntityType.Builder.of(
                    VitricTiberiumMaceratorBlockEntity::new, ModBlocks.VITRIC_TIBERIUM_MACERATOR.get()).build(null));

    public static final RegistryObject<BlockEntityType<CrystalCoreTiberiumMaceratorBlockEntity>> CRYSTAL_CORE_TIBERIUM_MACERATOR_BE =
            BLOCK_ENTITIES.register("crystal_core_tiberium_macerator_be", () -> BlockEntityType.Builder.of(
                    CrystalCoreTiberiumMaceratorBlockEntity::new, ModBlocks.CRYSTAL_CORE_TIBERIUM_MACERATOR.get()).build(null));




    public static final RegistryObject<BlockEntityType<TiberiumInfuserBlockEntity>> TIBERIUM_INFUSER_BE =
            BLOCK_ENTITIES.register("tiberium_infuser_be", () -> BlockEntityType.Builder.of(
                    TiberiumInfuserBlockEntity::new, ModBlocks.TIBERIUM_INFUSER.get()).build(null));

    public static final RegistryObject<BlockEntityType<AlythumTiberiumInfuserBlockEntity>> ALYTHUM_TIBERIUM_INFUSER_BE =
            BLOCK_ENTITIES.register("alythum_tiberium_infuser_be", () -> BlockEntityType.Builder.of(
                    AlythumTiberiumInfuserBlockEntity::new, ModBlocks.ALYTHUM_TIBERIUM_INFUSER.get()).build(null));

    public static final RegistryObject<BlockEntityType<VitricTiberiumInfuserBlockEntity>> VITRIC_TIBERIUM_INFUSER_BE =
            BLOCK_ENTITIES.register("vitric_tiberium_infuser_be", () -> BlockEntityType.Builder.of(
                    VitricTiberiumInfuserBlockEntity::new, ModBlocks.VITRIC_TIBERIUM_INFUSER.get()).build(null));

    public static final RegistryObject<BlockEntityType<CrystalCoreTiberiumInfuserBlockEntity>> CRYSTAL_CORE_TIBERIUM_INFUSER_BE =
            BLOCK_ENTITIES.register("crystal_core_tiberium_infuser_be", () -> BlockEntityType.Builder.of(
                    CrystalCoreTiberiumInfuserBlockEntity::new, ModBlocks.CRYSTAL_CORE_TIBERIUM_INFUSER.get()).build(null));



    public static final RegistryObject<BlockEntityType<PoweredKilnBlockEntity>> POWERED_KILN_BE =
            BLOCK_ENTITIES.register("powered_kiln_be", () -> BlockEntityType.Builder.of(
                    PoweredKilnBlockEntity::new, ModBlocks.POWERED_KILN.get()).build(null));

    public static final RegistryObject<BlockEntityType<AlythumKilnBlockEntity>> ALYTHUM_KILN_BE =
            BLOCK_ENTITIES.register("alythum_kiln_be", () -> BlockEntityType.Builder.of(
                    AlythumKilnBlockEntity::new, ModBlocks.ALYTHUM_KILN.get()).build(null));

    public static final RegistryObject<BlockEntityType<VitricKilnBlockEntity>> VITRIC_KILN_BE =
            BLOCK_ENTITIES.register("vitric_kiln_be", () -> BlockEntityType.Builder.of(
                    VitricKilnBlockEntity::new, ModBlocks.VITRIC_KILN.get()).build(null));

    public static final RegistryObject<BlockEntityType<CrystalCoreKilnBlockEntity>> CRYSTAL_CORE_KILN_BE =
            BLOCK_ENTITIES.register("crystal_core_kiln_be", () -> BlockEntityType.Builder.of(
                    CrystalCoreKilnBlockEntity::new, ModBlocks.CRYSTAL_CORE_KILN.get()).build(null));



    public static final RegistryObject<BlockEntityType<AlloyKilnBlockEntity>> ALLOY_KILN_BE =
            BLOCK_ENTITIES.register("alloy_kiln_be", () -> BlockEntityType.Builder.of(
                    AlloyKilnBlockEntity::new, ModBlocks.ALLOY_KILN.get()).build(null));

    public static final RegistryObject<BlockEntityType<AlythumAlloyKilnBlockEntity>> ALYTHUM_ALLOY_KILN_BE =
            BLOCK_ENTITIES.register("alythum_alloy_kiln_be", () -> BlockEntityType.Builder.of(
                    AlythumAlloyKilnBlockEntity::new, ModBlocks.ALYTHUM_ALLOY_KILN.get()).build(null));

    public static final RegistryObject<BlockEntityType<VitricAlloyKilnBlockEntity>> VITRIC_ALLOY_KILN_BE =
            BLOCK_ENTITIES.register("vitric_alloy_kiln_be", () -> BlockEntityType.Builder.of(
                    VitricAlloyKilnBlockEntity::new, ModBlocks.VITRIC_ALLOY_KILN.get()).build(null));

    public static final RegistryObject<BlockEntityType<CrystalCoreAlloyKilnBlockEntity>> CRYSTAL_CORE_ALLOY_KILN_BE =
            BLOCK_ENTITIES.register("crystal_core_alloy_kiln_be", () -> BlockEntityType.Builder.of(
                    CrystalCoreAlloyKilnBlockEntity::new, ModBlocks.CRYSTAL_CORE_ALLOY_KILN.get()).build(null));



    public static final RegistryObject<BlockEntityType<VitriciumRefineryBlockEntity>> VITRICIUM_REFINERY_BE =
            BLOCK_ENTITIES.register("vitricium_refinery_be", () -> BlockEntityType.Builder.of(
                    VitriciumRefineryBlockEntity::new, ModBlocks.VITRICIUM_REFINERY.get()).build(null));

    public static final RegistryObject<BlockEntityType<AlythumVitriciumRefineryBlockEntity>> ALYTHUM_VITRICIUM_REFINERY_BE =
            BLOCK_ENTITIES.register("alythum_vitricium_refinery_be", () -> BlockEntityType.Builder.of(
                    AlythumVitriciumRefineryBlockEntity::new, ModBlocks.ALYTHUM_VITRICIUM_REFINERY.get()).build(null));

    public static final RegistryObject<BlockEntityType<VitricVitriciumRefineryBlockEntity>> VITRIC_VITRICIUM_REFINERY_BE =
            BLOCK_ENTITIES.register("vitric_vitricium_refinery_be", () -> BlockEntityType.Builder.of(
                    VitricVitriciumRefineryBlockEntity::new, ModBlocks.VITRIC_VITRICIUM_REFINERY.get()).build(null));

    public static final RegistryObject<BlockEntityType<CrystalCoreVitriciumRefineryBlockEntity>> CRYSTAL_CORE_VITRICIUM_REFINERY_BE =
            BLOCK_ENTITIES.register("crystal_core_vitricium_refinery_be", () -> BlockEntityType.Builder.of(
                    CrystalCoreVitriciumRefineryBlockEntity::new, ModBlocks.CRYSTAL_CORE_VITRICIUM_REFINERY.get()).build(null));




    public static final RegistryObject<BlockEntityType<ModSignBlockEntity>> MOD_SIGN =
            BLOCK_ENTITIES.register("mod_sign", () -> BlockEntityType.Builder.of(
                    ModSignBlockEntity::new, ModBlocks.PLAGUED_SIGN.get(), ModBlocks.PLAGUED_WALL_SIGN.get(),
                    ModBlocks.MARIKA_OAK_SIGN.get(), ModBlocks.MARIKA_OAK_WALL_SIGN.get(),
                    ModBlocks.EMBER_OAK_SIGN.get(), ModBlocks.EMBER_OAK_WALL_SIGN.get(),
                    ModBlocks.DEAD_SIGN.get(), ModBlocks.DEAD_WALL_SIGN.get()).build(null));

    public static final RegistryObject<BlockEntityType<ModHangingSignBlockEntity>> MOD_HANGING_SIGN =
            BLOCK_ENTITIES.register("mod_hanging_sign", () -> BlockEntityType.Builder.of(
                    ModHangingSignBlockEntity::new,
                    ModBlocks.PLAGUED_HANGING_SIGN.get(), ModBlocks.PLAGUED_WALL_HANGING_SIGN.get(),
                    ModBlocks.EMBER_OAK_HANGING_SIGN.get(), ModBlocks.EMBER_OAK_WALL_HANGING_SIGN.get(),
                    ModBlocks.MARIKA_OAK_HANGING_SIGN.get(), ModBlocks.MARIKA_OAK_WALL_HANGING_SIGN.get(),
                    ModBlocks.DEAD_HANGING_SIGN.get(), ModBlocks.DEAD_WALL_HANGING_SIGN.get()).build(null));








    public static void register(IEventBus eventBus) {
        BLOCK_ENTITIES.register(eventBus);
    }
}
