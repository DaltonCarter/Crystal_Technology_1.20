package com.CartersDev.crystechmod.villager;

import com.CartersDev.crystechmod.CrystalTech;
import com.CartersDev.crystechmod.block.ModBlocks;
import com.google.common.collect.ImmutableSet;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.ai.village.poi.PoiType;
import net.minecraft.world.entity.npc.VillagerProfession;
import net.minecraft.world.item.alchemy.Potion;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModVillagers {

    public static final DeferredRegister<PoiType> POI_TYPES =
            DeferredRegister.create(ForgeRegistries.POI_TYPES, CrystalTech.MOD_ID);

    public static final RegistryObject<PoiType> VITRIC_POI = POI_TYPES.register("vitric_poi",
            () -> new PoiType(ImmutableSet.copyOf(ModBlocks.FOOLS_VITRICIUM.get().getStateDefinition().getPossibleStates()),
                    1, 5));



    public static final DeferredRegister<VillagerProfession> VILLAGER_PROFESSIONS =
            DeferredRegister.create(ForgeRegistries.VILLAGER_PROFESSIONS, CrystalTech.MOD_ID);

    public static final RegistryObject<VillagerProfession> VITRIC_GATHERER = VILLAGER_PROFESSIONS.register(
            "vitricgatherer", () -> new VillagerProfession("vitricgatherer",
                    holder -> holder.get() == VITRIC_POI.get(), holder -> holder.get() == VITRIC_POI.get(),
                    ImmutableSet.of(), ImmutableSet.of(), SoundEvents.VILLAGER_WORK_WEAPONSMITH));


    public static void register (IEventBus eventBus) {
        POI_TYPES.register(eventBus);
        VILLAGER_PROFESSIONS.register(eventBus);
    }
}
