package com.CartersDev.crystechmod.event;


import com.CartersDev.crystechmod.CrystalTech;
import com.CartersDev.crystechmod.entity.ModEntities;
import com.CartersDev.crystechmod.entity.custom.RhinoEntity;
import com.CartersDev.crystechmod.entity.custom.VitricCowEntity;
import com.CartersDev.crystechmod.entity.custom.VitricSheepEntity;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = CrystalTech.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModEventBusEvents {
    @SubscribeEvent
    public static void registerAttributes(EntityAttributeCreationEvent event) {
        event.put(ModEntities.RHINO.get(), RhinoEntity.createAttributes().build());
        event.put(ModEntities.VITRIC_SHEEP.get(), VitricSheepEntity.createAttributes().build());
        event.put(ModEntities.VITRIC_COW.get(), VitricCowEntity.createAttributes().build());
    }
}
