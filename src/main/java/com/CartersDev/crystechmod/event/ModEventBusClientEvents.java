package com.CartersDev.crystechmod.event;

import com.CartersDev.crystechmod.CrystalTech;
import com.CartersDev.crystechmod.block.entity.ModBlockEntities;
import com.CartersDev.crystechmod.block.entity.renderer.TiberiumGrinderBlockEntityRenderer;
import com.CartersDev.crystechmod.entity.client.ModModelLayers;
import com.CartersDev.crystechmod.entity.client.RhinoModel;
import com.CartersDev.crystechmod.particle.ModParticles;
import com.CartersDev.crystechmod.particle.custom.EmberParticles;
import com.CartersDev.crystechmod.particle.custom.MarikaParticles;
import com.CartersDev.crystechmod.particle.custom.YokariteParticles;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.blockentity.HangingSignRenderer;
import net.minecraft.client.renderer.blockentity.SignRenderer;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.client.event.RegisterParticleProvidersEvent;
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
        event.registerBlockEntityRenderer(ModBlockEntities.MOD_SIGN.get(), SignRenderer::new);
        event.registerBlockEntityRenderer(ModBlockEntities.MOD_HANGING_SIGN.get(), HangingSignRenderer::new);
}

@SubscribeEvent
    public static void registerParticleFactories(final RegisterParticleProvidersEvent event) {
    Minecraft.getInstance().particleEngine.register(ModParticles.YOKARITE_PARTICLES.get(),
            YokariteParticles.Provider::new);

    Minecraft.getInstance().particleEngine.register(ModParticles.MARIKA_PARTICLES.get(),
            MarikaParticles.Provider::new);

    Minecraft.getInstance().particleEngine.register(ModParticles.EMBER_PARTICLES.get(),
            EmberParticles.Provider::new);
}


}
