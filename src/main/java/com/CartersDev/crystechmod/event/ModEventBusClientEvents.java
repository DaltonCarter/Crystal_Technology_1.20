package com.CartersDev.crystechmod.event;

import com.CartersDev.crystechmod.CrystalTech;
import com.CartersDev.crystechmod.block.entity.ModBlockEntities;
import com.CartersDev.crystechmod.block.entity.alloykiln.AlloyKilnBlockEntity;
import com.CartersDev.crystechmod.block.entity.renderer.alloykiln.AlloyKilnBlockEntityRenderer;
import com.CartersDev.crystechmod.block.entity.renderer.alloykiln.AlythumAlloyKilnBlockEntityRenderer;
import com.CartersDev.crystechmod.block.entity.renderer.alloykiln.CrystalCoreAlloyKilnBlockEntityRenderer;
import com.CartersDev.crystechmod.block.entity.renderer.alloykiln.VitricAlloyKilnBlockEntityRenderer;
import com.CartersDev.crystechmod.block.entity.renderer.grinder.TiberiumGrinderBlockEntityRenderer;
import com.CartersDev.crystechmod.block.entity.renderer.infuser.AlythumTiberiumInfuserBlockEntityRenderer;
import com.CartersDev.crystechmod.block.entity.renderer.infuser.CrystalCoreTiberiumInfuserBlockEntityRenderer;
import com.CartersDev.crystechmod.block.entity.renderer.infuser.TiberiumInfuserBlockEntityRenderer;
import com.CartersDev.crystechmod.block.entity.renderer.infuser.VitricTiberiumInfuserBlockEntityRenderer;
import com.CartersDev.crystechmod.block.entity.renderer.macerator.AlythumTiberiumMaceratorBlockEntityRenderer;
import com.CartersDev.crystechmod.block.entity.renderer.macerator.CrystalCoreTiberiumMaceratorBlockEntityRenderer;
import com.CartersDev.crystechmod.block.entity.renderer.macerator.TiberiumMaceratorBlockEntityRenderer;
import com.CartersDev.crystechmod.block.entity.renderer.macerator.VitricTiberiumMaceratorBlockEntityRenderer;
import com.CartersDev.crystechmod.block.entity.renderer.poweredkiln.PoweredKilnBlockEntityRenderer;
import com.CartersDev.crystechmod.block.entity.renderer.poweredkiln.AlythumKilnBlockEntityRenderer;
import com.CartersDev.crystechmod.block.entity.renderer.poweredkiln.VitricKilnBlockEntityRenderer;
import com.CartersDev.crystechmod.block.entity.renderer.poweredkiln.CrystalCoreKilnBlockEntityRenderer;
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
        event.registerBlockEntityRenderer(ModBlockEntities.TIBERIUM_MACERATOR_BE.get(), TiberiumMaceratorBlockEntityRenderer::new);
        event.registerBlockEntityRenderer(ModBlockEntities.ALYTHUM_TIBERIUM_MACERATOR_BE.get(), AlythumTiberiumMaceratorBlockEntityRenderer::new);
        event.registerBlockEntityRenderer(ModBlockEntities.VITRIC_TIBERIUM_MACERATOR_BE.get(), VitricTiberiumMaceratorBlockEntityRenderer::new);
        event.registerBlockEntityRenderer(ModBlockEntities.CRYSTAL_CORE_TIBERIUM_MACERATOR_BE.get(), CrystalCoreTiberiumMaceratorBlockEntityRenderer::new);
        event.registerBlockEntityRenderer(ModBlockEntities.TIBERIUM_INFUSER_BE.get(), TiberiumInfuserBlockEntityRenderer::new);
        event.registerBlockEntityRenderer(ModBlockEntities.ALYTHUM_TIBERIUM_INFUSER_BE.get(), AlythumTiberiumInfuserBlockEntityRenderer::new);
        event.registerBlockEntityRenderer(ModBlockEntities.VITRIC_TIBERIUM_INFUSER_BE.get(), VitricTiberiumInfuserBlockEntityRenderer::new);
        event.registerBlockEntityRenderer(ModBlockEntities.CRYSTAL_CORE_TIBERIUM_INFUSER_BE.get(), CrystalCoreTiberiumInfuserBlockEntityRenderer::new);

        event.registerBlockEntityRenderer(ModBlockEntities.POWERED_KILN_BE.get(), PoweredKilnBlockEntityRenderer::new);
        event.registerBlockEntityRenderer(ModBlockEntities.ALYTHUM_KILN_BE.get(), AlythumKilnBlockEntityRenderer::new);
        event.registerBlockEntityRenderer(ModBlockEntities.VITRIC_KILN_BE.get(), VitricKilnBlockEntityRenderer::new);
        event.registerBlockEntityRenderer(ModBlockEntities.CRYSTAL_CORE_KILN_BE.get(), CrystalCoreKilnBlockEntityRenderer::new);

        event.registerBlockEntityRenderer(ModBlockEntities.ALLOY_KILN_BE.get(), AlloyKilnBlockEntityRenderer::new);
        event.registerBlockEntityRenderer(ModBlockEntities.ALYTHUM_ALLOY_KILN_BE.get(), AlythumAlloyKilnBlockEntityRenderer::new);
        event.registerBlockEntityRenderer(ModBlockEntities.VITRIC_ALLOY_KILN_BE.get(), VitricAlloyKilnBlockEntityRenderer::new);
        event.registerBlockEntityRenderer(ModBlockEntities.CRYSTAL_CORE_ALLOY_KILN_BE.get(), CrystalCoreAlloyKilnBlockEntityRenderer::new);

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
