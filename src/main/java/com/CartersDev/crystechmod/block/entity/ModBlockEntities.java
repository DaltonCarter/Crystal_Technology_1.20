package com.CartersDev.crystechmod.block.entity;

import com.CartersDev.crystechmod.CrystalTech;

import com.CartersDev.crystechmod.block.ModBlocks;
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

    public static final RegistryObject<BlockEntityType<TiberiumInfuserBlockEntity>> TIBERIUM_INFUSER_BE =
            BLOCK_ENTITIES.register("tiberium_infuser_be", () -> BlockEntityType.Builder.of(
                    TiberiumInfuserBlockEntity::new, ModBlocks.TIBERIUM_INFUSER.get()).build(null));

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
