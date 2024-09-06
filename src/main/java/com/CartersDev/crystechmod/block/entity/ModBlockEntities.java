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








    public static void register(IEventBus eventBus) {
        BLOCK_ENTITIES.register(eventBus);
    }
}
