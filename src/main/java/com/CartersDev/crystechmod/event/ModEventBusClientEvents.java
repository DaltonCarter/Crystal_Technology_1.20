package com.CartersDev.crystechmod.event;

import com.CartersDev.crystechmod.CrystalTech;
import com.CartersDev.crystechmod.block.entity.ModBlockEntities;
import com.CartersDev.crystechmod.block.entity.renderer.TiberiumGrinderBlockEntityRenderer;
import com.CartersDev.crystechmod.entity.client.ModModelLayers;
import com.CartersDev.crystechmod.entity.client.RhinoModel;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = CrystalTech.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ModEventBusClientEvents {

    @SubscribeEvent
    public static void registerLayer(EntityRenderersEvent.RegisterLayerDefinitions event) {
        event.registerLayerDefinition(ModModelLayers.RHINO_LAYER, RhinoModel::createBodyLayer);
    }

    @SubscribeEvent
public static void registerBER(EntityRenderersEvent.RegisterRenderers event) {
        event.registerBlockEntityRenderer(ModBlockEntities.TIBERIUM_GRINDER_BE.get(), TiberiumGrinderBlockEntityRenderer::new);
}

}
