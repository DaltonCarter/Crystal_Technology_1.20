package com.CartersDev.crystechmod;

import com.CartersDev.crystechmod.block.ModBlocks;
import com.CartersDev.crystechmod.block.entity.ModBlockEntities;
import com.CartersDev.crystechmod.effect.ModEffects;
import com.CartersDev.crystechmod.enchantment.ModEnchantments;
import com.CartersDev.crystechmod.entity.ModEntities;
import com.CartersDev.crystechmod.entity.client.RhinoRenderer;
import com.CartersDev.crystechmod.fluid.ModFluidTypes;
import com.CartersDev.crystechmod.fluid.ModFluids;
import com.CartersDev.crystechmod.item.ModCreativeModTabs;
import com.CartersDev.crystechmod.item.ModItems;
import com.CartersDev.crystechmod.loot.ModLootModifiers;
import com.CartersDev.crystechmod.painting.ModPaintings;
import com.CartersDev.crystechmod.particle.ModParticles;
import com.CartersDev.crystechmod.potion.ModPotions;
import com.CartersDev.crystechmod.recipe.ModRecipes;
import com.CartersDev.crystechmod.screen.ModMenuTypes;
import com.CartersDev.crystechmod.screen.TiberiumGrinderScreen;
import com.CartersDev.crystechmod.screen.TiberiumInfuserScreen;
import com.CartersDev.crystechmod.sound.ModSounds;
import com.CartersDev.crystechmod.util.BetterBrewingRecipe;
import com.CartersDev.crystechmod.util.ModWoodTypes;
import com.CartersDev.crystechmod.villager.ModVillagers;
import com.CartersDev.crystechmod.worldgen.ModFeatureTypes.ModFeatures;
import com.CartersDev.crystechmod.worldgen.biome.ModTerraBlenderAPI;
import com.CartersDev.crystechmod.worldgen.biome.surface.ModSurfaceRules;
import com.mojang.logging.LogUtils;
import net.minecraft.client.gui.screens.MenuScreens;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.Sheets;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.alchemy.Potions;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.ComposterBlock;
import net.minecraft.world.level.block.FlowerPotBlock;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.brewing.BrewingRecipeRegistry;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

import org.slf4j.Logger;
import terrablender.api.SurfaceRuleManager;


// The value here should match an entry in the META-INF/mods.toml file
@Mod(CrystalTech.MOD_ID)
public class CrystalTech {
    public static final String MOD_ID = "crystechmod";
    public static final Logger LOGGER = LogUtils.getLogger();

    public CrystalTech() {



        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        ModCreativeModTabs.register(modEventBus);

        ModItems.register(modEventBus);
        ModBlocks.register(modEventBus);

        ModEffects.register(modEventBus);
        ModPotions.register(modEventBus);
        ModEnchantments.register(modEventBus);

        ModFluids.register(modEventBus);
        ModFluidTypes.register(modEventBus);

        ModLootModifiers.register(modEventBus);
        ModPaintings.register(modEventBus);
        ModVillagers.register(modEventBus);



        ModSounds.register(modEventBus);
        ModEntities.register(modEventBus);

        ModBlockEntities.register(modEventBus);
        ModMenuTypes.register(modEventBus);

        ModRecipes.register(modEventBus);
        ModParticles.register(modEventBus);

        ModTerraBlenderAPI.registerRegions();

        ModFeatures.register(modEventBus);

        modEventBus.addListener(this::commonSetup);

        MinecraftForge.EVENT_BUS.register(this);
        modEventBus.addListener(this::addCreative);
    }

    private void commonSetup(final FMLCommonSetupEvent event) {
        event.enqueueWork(() -> {
            //Potion Recipes
            BrewingRecipeRegistry.addRecipe(new BetterBrewingRecipe(Potions.AWKWARD,
                    ModItems.QUALRIM_COMPOUND.get(), ModPotions.FREEZE_POTION.get()));

            BrewingRecipeRegistry.addRecipe(new BetterBrewingRecipe(Potions.MUNDANE,
                    Items.SLIME_BALL, ModPotions.CLIMBING_POTION.get()));

            //End of Potion Recipes


            //Flowers
            ((FlowerPotBlock) Blocks.FLOWER_POT).addPlant(ModBlocks.HYACINTH.getId(), ModBlocks.POTTED_HYACINTH);
            ((FlowerPotBlock) Blocks.FLOWER_POT).addPlant(ModBlocks.FLOWER_OF_LIFE.getId(), ModBlocks.POTTED_FLOWER_OF_LIFE);
            ((FlowerPotBlock) Blocks.FLOWER_POT).addPlant(ModBlocks.DEVILS_BLOOD.getId(), ModBlocks.POTTED_DEVILS_BLOOD);
            ((FlowerPotBlock) Blocks.FLOWER_POT).addPlant(ModBlocks.SPITFIRE.getId(), ModBlocks.POTTED_SPITFIRE);
            ((FlowerPotBlock) Blocks.FLOWER_POT).addPlant(ModBlocks.FULGURBLOOM.getId(), ModBlocks.POTTED_FULGURBLOOM);
            ((FlowerPotBlock) Blocks.FLOWER_POT).addPlant(ModBlocks.VITRIC_BLOOM.getId(), ModBlocks.POTTED_VITRIC_BLOOM);
            //End of flowers

            ComposterBlock.COMPOSTABLES.put(ModItems.LAI_MELON_SEEDS.get(),0.35f);
            ComposterBlock.COMPOSTABLES.put(ModItems.HEIM_BERRY_SEEDS.get(),0.35f);
            ComposterBlock.COMPOSTABLES.put(ModItems.HEL_FRUIT_SEEDS.get(),0.35f);
            ComposterBlock.COMPOSTABLES.put(ModItems.SABER_CORN_SEEDS.get(),0.35f);
            ComposterBlock.COMPOSTABLES.put(ModItems.LAI_MELON_SLICE.get(),0.35f);
            ComposterBlock.COMPOSTABLES.put(ModItems.HEIM_BERRY.get(),0.35f);
            ComposterBlock.COMPOSTABLES.put(ModItems.HEL_FRUIT.get(),0.35f);
            ComposterBlock.COMPOSTABLES.put(ModItems.SABER_CORN.get(),0.35f);
            ComposterBlock.COMPOSTABLES.put(ModBlocks.DYING_SAPLING.get(),0.35f);
            ComposterBlock.COMPOSTABLES.put(ModBlocks.EMBER_OAK_SAPLING.get(),0.35f);
            ComposterBlock.COMPOSTABLES.put(ModBlocks.MARIKA_OAK_SAPLING.get(),0.35f);
            ComposterBlock.COMPOSTABLES.put(ModBlocks.PLAGUED_SAPLING.get(),0.35f);


            SurfaceRuleManager.addSurfaceRules(SurfaceRuleManager.RuleCategory.OVERWORLD, MOD_ID, ModSurfaceRules.vitricExpanse());



        });


    }


    private void addCreative(BuildCreativeModeTabContentsEvent event) {

    }

    // You can use SubscribeEvent and let the Event Bus discover methods to call
    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event) {

    }

    // You can use EventBusSubscriber to automatically register all static methods in the class annotated with @SubscribeEvent
    @Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event) {

            Sheets.addWoodType(ModWoodTypes.PLAGUED);
            Sheets.addWoodType(ModWoodTypes.EMBER_OAK);
            Sheets.addWoodType(ModWoodTypes.DEAD);
            Sheets.addWoodType(ModWoodTypes.MARIKA_OAK);

            EntityRenderers.register(ModEntities.RHINO.get(), RhinoRenderer::new);

            MenuScreens.register(ModMenuTypes.TIBERIUM_GRINDER_MENU.get(), TiberiumGrinderScreen::new);
            MenuScreens.register(ModMenuTypes.TIBERIUM_INFUSER_MENU.get(), TiberiumInfuserScreen::new);

            //Tiberium
            ItemBlockRenderTypes.setRenderLayer(ModBlocks.GREEN_TIBERIUM_CROP.get(), RenderType.cutout());
            ItemBlockRenderTypes.setRenderLayer(ModBlocks.BLUE_TIBERIUM_CROP.get(), RenderType.cutout());
            ItemBlockRenderTypes.setRenderLayer(ModBlocks.RED_TIBERIUM_CROP.get(), RenderType.cutout());
            ItemBlockRenderTypes.setRenderLayer(ModBlocks.PURPLE_TIBERIUM_CROP.get(), RenderType.cutout());
            ItemBlockRenderTypes.setRenderLayer(ModBlocks.LAI_MELON_STEM.get(), RenderType.cutout());
            ItemBlockRenderTypes.setRenderLayer(ModBlocks.ATTACHED_LAI_MELON_STEM.get(), RenderType.cutout());

            ItemBlockRenderTypes.setRenderLayer(ModBlocks.TEST_BLOCK.get(), RenderType.translucent());

            //End of Tiberium

            //Fluids
            ItemBlockRenderTypes.setRenderLayer(ModFluids.SOURCE_TIBERIUM_WATER.get(), RenderType.translucent());
            ItemBlockRenderTypes.setRenderLayer(ModFluids.FLOWING_TIBERIUM_WATER.get(), RenderType.translucent());
            //End of Fluids


            //Crystals and Glass
            ItemBlockRenderTypes.setRenderLayer(ModBlocks.RIPARIUS_CRYSTAL.get(), RenderType.translucent());
            ItemBlockRenderTypes.setRenderLayer(ModBlocks.VINIFERA_CRYSTAL.get(), RenderType.translucent());
            ItemBlockRenderTypes.setRenderLayer(ModBlocks.CRUENTUS_CRYSTAL.get(), RenderType.translucent());
            ItemBlockRenderTypes.setRenderLayer(ModBlocks.ABOREUS_CRYSTAL.get(), RenderType.translucent());

            ItemBlockRenderTypes.setRenderLayer(ModBlocks.RIPARIUS_CRYSTAL_STAIRS.get(), RenderType.translucent());
            ItemBlockRenderTypes.setRenderLayer(ModBlocks.VINIFERA_CRYSTAL_STAIRS.get(), RenderType.translucent());
            ItemBlockRenderTypes.setRenderLayer(ModBlocks.CRUENTUS_CRYSTAL_STAIRS.get(), RenderType.translucent());
            ItemBlockRenderTypes.setRenderLayer(ModBlocks.ABOREUS_CRYSTAL_STAIRS.get(), RenderType.translucent());

            ItemBlockRenderTypes.setRenderLayer(ModBlocks.RIPARIUS_CRYSTAL_SLAB.get(), RenderType.translucent());
            ItemBlockRenderTypes.setRenderLayer(ModBlocks.VINIFERA_CRYSTAL_SLAB.get(), RenderType.translucent());
            ItemBlockRenderTypes.setRenderLayer(ModBlocks.CRUENTUS_CRYSTAL_SLAB.get(), RenderType.translucent());
            ItemBlockRenderTypes.setRenderLayer(ModBlocks.ABOREUS_CRYSTAL_SLAB.get(), RenderType.translucent());

            ItemBlockRenderTypes.setRenderLayer(ModBlocks.RIPARIUS_CRYSTAL_WALL.get(), RenderType.translucent());
            ItemBlockRenderTypes.setRenderLayer(ModBlocks.VINIFERA_CRYSTAL_WALL.get(), RenderType.translucent());
            ItemBlockRenderTypes.setRenderLayer(ModBlocks.CRUENTUS_CRYSTAL_WALL.get(), RenderType.translucent());
            ItemBlockRenderTypes.setRenderLayer(ModBlocks.ABOREUS_CRYSTAL_WALL.get(), RenderType.translucent());

            ItemBlockRenderTypes.setRenderLayer(ModBlocks.CLEAR_TIBERGLASS.get(), RenderType.translucent());
            ItemBlockRenderTypes.setRenderLayer(ModBlocks.MOSAIC_TIBERGLASS.get(), RenderType.translucent());
            ItemBlockRenderTypes.setRenderLayer(ModBlocks.GDI_TIBERGLASS.get(), RenderType.translucent());
            ItemBlockRenderTypes.setRenderLayer(ModBlocks.NOD_TIBERGLASS.get(), RenderType.translucent());
            ItemBlockRenderTypes.setRenderLayer(ModBlocks.WOLF_TIBERGLASS.get(), RenderType.translucent());
            ItemBlockRenderTypes.setRenderLayer(ModBlocks.BLACK_TIBERGLASS.get(), RenderType.translucent());
            ItemBlockRenderTypes.setRenderLayer(ModBlocks.BLUE_TIBERGLASS.get(), RenderType.translucent());
            ItemBlockRenderTypes.setRenderLayer(ModBlocks.BROWN_TIBERGLASS.get(), RenderType.translucent());
            ItemBlockRenderTypes.setRenderLayer(ModBlocks.CYAN_TIBERGLASS.get(), RenderType.translucent());
            ItemBlockRenderTypes.setRenderLayer(ModBlocks.GRAY_TIBERGLASS.get(), RenderType.translucent());
            ItemBlockRenderTypes.setRenderLayer(ModBlocks.GREEN_TIBERGLASS.get(), RenderType.translucent());
            ItemBlockRenderTypes.setRenderLayer(ModBlocks.LIGHT_BLUE_TIBERGLASS.get(), RenderType.translucent());
            ItemBlockRenderTypes.setRenderLayer(ModBlocks.LIGHT_GRAY_TIBERGLASS.get(), RenderType.translucent());
            ItemBlockRenderTypes.setRenderLayer(ModBlocks.LIME_TIBERGLASS.get(), RenderType.translucent());
            ItemBlockRenderTypes.setRenderLayer(ModBlocks.MAGENTA_TIBERGLASS.get(), RenderType.translucent());
            ItemBlockRenderTypes.setRenderLayer(ModBlocks.ORANGE_TIBERGLASS.get(), RenderType.translucent());
            ItemBlockRenderTypes.setRenderLayer(ModBlocks.PINK_TIBERGLASS.get(), RenderType.translucent());
            ItemBlockRenderTypes.setRenderLayer(ModBlocks.PURPLE_TIBERGLASS.get(), RenderType.translucent());
            ItemBlockRenderTypes.setRenderLayer(ModBlocks.RED_TIBERGLASS.get(), RenderType.translucent());
            ItemBlockRenderTypes.setRenderLayer(ModBlocks.WHITE_TIBERGLASS.get(), RenderType.translucent());
            ItemBlockRenderTypes.setRenderLayer(ModBlocks.YELLOW_TIBERGLASS.get(), RenderType.translucent());
            //End of Crystals and Glass

            //Deco Blocks:
            ItemBlockRenderTypes.setRenderLayer(ModBlocks.CS_SCAFFOLD.get(), RenderType.cutout());
            ItemBlockRenderTypes.setRenderLayer(ModBlocks.CS_SCAFFOLD_STAIRS.get(), RenderType.cutout());
            ItemBlockRenderTypes.setRenderLayer(ModBlocks.CS_SCAFFOLD_SLAB.get(), RenderType.cutout());

            ItemBlockRenderTypes.setRenderLayer(ModBlocks.CS_CATWALK_W.get(), RenderType.cutout());
            ItemBlockRenderTypes.setRenderLayer(ModBlocks.CS_CATWALK_W_SLAB.get(), RenderType.cutout());
            ItemBlockRenderTypes.setRenderLayer(ModBlocks.CS_CATWALK_W_STAIRS.get(), RenderType.cutout());
            ItemBlockRenderTypes.setRenderLayer(ModBlocks.CS_CATWALK_BL.get(), RenderType.cutout());
            ItemBlockRenderTypes.setRenderLayer(ModBlocks.CS_CATWALK_BL_SLAB.get(), RenderType.cutout());
            ItemBlockRenderTypes.setRenderLayer(ModBlocks.CS_CATWALK_BL_STAIRS.get(), RenderType.cutout());
            ItemBlockRenderTypes.setRenderLayer(ModBlocks.CS_CATWALK_G.get(), RenderType.cutout());
            ItemBlockRenderTypes.setRenderLayer(ModBlocks.CS_CATWALK_G_SLAB.get(), RenderType.cutout());
            ItemBlockRenderTypes.setRenderLayer(ModBlocks.CS_CATWALK_G_STAIRS.get(), RenderType.cutout());
            ItemBlockRenderTypes.setRenderLayer(ModBlocks.CS_CATWALK_B.get(), RenderType.cutout());
            ItemBlockRenderTypes.setRenderLayer(ModBlocks.CS_CATWALK_B_SLAB.get(), RenderType.cutout());
            ItemBlockRenderTypes.setRenderLayer(ModBlocks.CS_CATWALK_B_STAIRS.get(), RenderType.cutout());
            ItemBlockRenderTypes.setRenderLayer(ModBlocks.CS_CATWALK_R.get(), RenderType.cutout());
            ItemBlockRenderTypes.setRenderLayer(ModBlocks.CS_CATWALK_R_SLAB.get(), RenderType.cutout());
            ItemBlockRenderTypes.setRenderLayer(ModBlocks.CS_CATWALK_R_STAIRS.get(), RenderType.cutout());
            ItemBlockRenderTypes.setRenderLayer(ModBlocks.CS_CATWALK_P.get(), RenderType.cutout());
            ItemBlockRenderTypes.setRenderLayer(ModBlocks.CS_CATWALK_P_SLAB.get(), RenderType.cutout());
            ItemBlockRenderTypes.setRenderLayer(ModBlocks.CS_CATWALK_P_STAIRS.get(), RenderType.cutout());

            ItemBlockRenderTypes.setRenderLayer(ModBlocks.CT_PILLAR.get(), RenderType.translucent());
            ItemBlockRenderTypes.setRenderLayer(ModBlocks.CT_PILLAR_2.get(), RenderType.translucent());
            ItemBlockRenderTypes.setRenderLayer(ModBlocks.CT_PILLAR_3.get(), RenderType.translucent());
            ItemBlockRenderTypes.setRenderLayer(ModBlocks.CT_PILLAR_G.get(), RenderType.translucent());
            ItemBlockRenderTypes.setRenderLayer(ModBlocks.CT_PILLAR_G_2.get(), RenderType.translucent());
            ItemBlockRenderTypes.setRenderLayer(ModBlocks.CT_PILLAR_B.get(), RenderType.translucent());
            ItemBlockRenderTypes.setRenderLayer(ModBlocks.CT_PILLAR_B_2.get(), RenderType.translucent());
            ItemBlockRenderTypes.setRenderLayer(ModBlocks.CT_PILLAR_R.get(), RenderType.translucent());
            ItemBlockRenderTypes.setRenderLayer(ModBlocks.CT_PILLAR_R_2.get(), RenderType.translucent());
            ItemBlockRenderTypes.setRenderLayer(ModBlocks.CT_PILLAR_P.get(), RenderType.translucent());
            ItemBlockRenderTypes.setRenderLayer(ModBlocks.CT_PILLAR_P_2.get(), RenderType.translucent());

            ItemBlockRenderTypes.setRenderLayer(ModBlocks.CT_PILLAR_TOP.get(), RenderType.translucent());
            ItemBlockRenderTypes.setRenderLayer(ModBlocks.CT_PILLAR_TOP_VERT.get(), RenderType.translucent());
            ItemBlockRenderTypes.setRenderLayer(ModBlocks.CT_PILLAR_TOP_G_VERT.get(), RenderType.translucent());
            ItemBlockRenderTypes.setRenderLayer(ModBlocks.CT_PILLAR_TOP_B_VERT.get(), RenderType.translucent());
            ItemBlockRenderTypes.setRenderLayer(ModBlocks.CT_PILLAR_TOP_R_VERT.get(), RenderType.translucent());
            ItemBlockRenderTypes.setRenderLayer(ModBlocks.CT_PILLAR_TOP_P_VERT.get(), RenderType.translucent());
            ItemBlockRenderTypes.setRenderLayer(ModBlocks.CT_PILLAR_TOP_G.get(), RenderType.translucent());
            ItemBlockRenderTypes.setRenderLayer(ModBlocks.CT_PILLAR_TOP_B.get(), RenderType.translucent());
            ItemBlockRenderTypes.setRenderLayer(ModBlocks.CT_PILLAR_TOP_R.get(), RenderType.translucent());
            ItemBlockRenderTypes.setRenderLayer(ModBlocks.CT_PILLAR_TOP_P.get(), RenderType.translucent());

            ItemBlockRenderTypes.setRenderLayer(ModBlocks.CT_TILE_VERT_2.get(), RenderType.translucent());
            ItemBlockRenderTypes.setRenderLayer(ModBlocks.CT_TILE_G_VERT_2.get(), RenderType.translucent());
            ItemBlockRenderTypes.setRenderLayer(ModBlocks.CT_TILE_B_VERT_2.get(), RenderType.translucent());
            ItemBlockRenderTypes.setRenderLayer(ModBlocks.CT_TILE_R_VERT_2.get(), RenderType.translucent());
            ItemBlockRenderTypes.setRenderLayer(ModBlocks.CT_TILE_P_VERT_2.get(), RenderType.translucent());

            ItemBlockRenderTypes.setRenderLayer(ModBlocks.CT_TILE_VERT_3.get(), RenderType.translucent());
            ItemBlockRenderTypes.setRenderLayer(ModBlocks.CT_TILE_G_VERT_3.get(), RenderType.translucent());
            ItemBlockRenderTypes.setRenderLayer(ModBlocks.CT_TILE_B_VERT_3.get(), RenderType.translucent());
            ItemBlockRenderTypes.setRenderLayer(ModBlocks.CT_TILE_R_VERT_3.get(), RenderType.translucent());
            ItemBlockRenderTypes.setRenderLayer(ModBlocks.CT_TILE_P_VERT_3.get(), RenderType.translucent());

            ItemBlockRenderTypes.setRenderLayer(ModBlocks.CT_TILE_STAIRS.get(), RenderType.translucent());
            ItemBlockRenderTypes.setRenderLayer(ModBlocks.CT_TILE_SLAB.get(), RenderType.translucent());
            ItemBlockRenderTypes.setRenderLayer(ModBlocks.CT_TILE_WALL.get(), RenderType.translucent());
            
            ItemBlockRenderTypes.setRenderLayer(ModBlocks.CT_TILE_STAIRS_G.get(), RenderType.translucent());
            ItemBlockRenderTypes.setRenderLayer(ModBlocks.CT_TILE_SLAB_G.get(), RenderType.translucent());
            ItemBlockRenderTypes.setRenderLayer(ModBlocks.CT_TILE_WALL_G.get(), RenderType.translucent());
            ItemBlockRenderTypes.setRenderLayer(ModBlocks.CT_TILE_STAIRS_B.get(), RenderType.translucent());
            ItemBlockRenderTypes.setRenderLayer(ModBlocks.CT_TILE_SLAB_B.get(), RenderType.translucent());
            ItemBlockRenderTypes.setRenderLayer(ModBlocks.CT_TILE_WALL_B.get(), RenderType.translucent());
            ItemBlockRenderTypes.setRenderLayer(ModBlocks.CT_TILE_STAIRS_R.get(), RenderType.translucent());
            ItemBlockRenderTypes.setRenderLayer(ModBlocks.CT_TILE_SLAB_R.get(), RenderType.translucent());
            ItemBlockRenderTypes.setRenderLayer(ModBlocks.CT_TILE_WALL_R.get(), RenderType.translucent());
            ItemBlockRenderTypes.setRenderLayer(ModBlocks.CT_TILE_STAIRS_P.get(), RenderType.translucent());
            ItemBlockRenderTypes.setRenderLayer(ModBlocks.CT_TILE_SLAB_P.get(), RenderType.translucent());
            ItemBlockRenderTypes.setRenderLayer(ModBlocks.CT_TILE_WALL_P.get(), RenderType.translucent());

            ItemBlockRenderTypes.setRenderLayer(ModBlocks.CT_TILE_STAIRS_2.get(), RenderType.translucent());
            ItemBlockRenderTypes.setRenderLayer(ModBlocks.CT_TILE_SLAB_2.get(), RenderType.translucent());
            ItemBlockRenderTypes.setRenderLayer(ModBlocks.CT_TILE_WALL_2.get(), RenderType.translucent());
            ItemBlockRenderTypes.setRenderLayer(ModBlocks.CT_TILE_2.get(), RenderType.translucent());
            ItemBlockRenderTypes.setRenderLayer(ModBlocks.CT_TILE_G_2.get(), RenderType.translucent());
            ItemBlockRenderTypes.setRenderLayer(ModBlocks.CT_TILE_B_2.get(), RenderType.translucent());
            ItemBlockRenderTypes.setRenderLayer(ModBlocks.CT_TILE_R_2.get(), RenderType.translucent());
            ItemBlockRenderTypes.setRenderLayer(ModBlocks.CT_TILE_P_2.get(), RenderType.translucent());
            ItemBlockRenderTypes.setRenderLayer(ModBlocks.CT_TILE_STAIRS_G_2.get(), RenderType.translucent());
            ItemBlockRenderTypes.setRenderLayer(ModBlocks.CT_TILE_SLAB_G_2.get(), RenderType.translucent());
            ItemBlockRenderTypes.setRenderLayer(ModBlocks.CT_TILE_WALL_G_2.get(), RenderType.translucent());
            ItemBlockRenderTypes.setRenderLayer(ModBlocks.CT_TILE_STAIRS_G_2.get(), RenderType.translucent());
            ItemBlockRenderTypes.setRenderLayer(ModBlocks.CT_TILE_SLAB_G_2.get(), RenderType.translucent());
            ItemBlockRenderTypes.setRenderLayer(ModBlocks.CT_TILE_WALL_G_2.get(), RenderType.translucent());
            ItemBlockRenderTypes.setRenderLayer(ModBlocks.CT_TILE_STAIRS_B_2.get(), RenderType.translucent());
            ItemBlockRenderTypes.setRenderLayer(ModBlocks.CT_TILE_SLAB_B_2.get(), RenderType.translucent());
            ItemBlockRenderTypes.setRenderLayer(ModBlocks.CT_TILE_WALL_B_2.get(), RenderType.translucent());
            ItemBlockRenderTypes.setRenderLayer(ModBlocks.CT_TILE_STAIRS_R_2.get(), RenderType.translucent());
            ItemBlockRenderTypes.setRenderLayer(ModBlocks.CT_TILE_SLAB_R_2.get(), RenderType.translucent());
            ItemBlockRenderTypes.setRenderLayer(ModBlocks.CT_TILE_WALL_R_2.get(), RenderType.translucent());
            ItemBlockRenderTypes.setRenderLayer(ModBlocks.CT_TILE_STAIRS_P_2.get(), RenderType.translucent());
            ItemBlockRenderTypes.setRenderLayer(ModBlocks.CT_TILE_SLAB_P_2.get(), RenderType.translucent());
            ItemBlockRenderTypes.setRenderLayer(ModBlocks.CT_TILE_WALL_P_2.get(), RenderType.translucent());

            ItemBlockRenderTypes.setRenderLayer(ModBlocks.CT_TILE_3.get(), RenderType.translucent());
            ItemBlockRenderTypes.setRenderLayer(ModBlocks.CT_TILE_SLAB_3.get(), RenderType.translucent());
            ItemBlockRenderTypes.setRenderLayer(ModBlocks.CT_TILE_WALL_3.get(), RenderType.translucent());
            ItemBlockRenderTypes.setRenderLayer(ModBlocks.CT_TILE_3.get(), RenderType.translucent());
            ItemBlockRenderTypes.setRenderLayer(ModBlocks.CT_TILE_G_3.get(), RenderType.translucent());
            ItemBlockRenderTypes.setRenderLayer(ModBlocks.CT_TILE_B_3.get(), RenderType.translucent());
            ItemBlockRenderTypes.setRenderLayer(ModBlocks.CT_TILE_R_3.get(), RenderType.translucent());
            ItemBlockRenderTypes.setRenderLayer(ModBlocks.CT_TILE_P_3.get(), RenderType.translucent());
            ItemBlockRenderTypes.setRenderLayer(ModBlocks.CT_TILE_STAIRS_3.get(), RenderType.translucent());
            ItemBlockRenderTypes.setRenderLayer(ModBlocks.CT_TILE_STAIRS_G_3.get(), RenderType.translucent());
            ItemBlockRenderTypes.setRenderLayer(ModBlocks.CT_TILE_SLAB_G_3.get(), RenderType.translucent());
            ItemBlockRenderTypes.setRenderLayer(ModBlocks.CT_TILE_WALL_G_3.get(), RenderType.translucent());
            ItemBlockRenderTypes.setRenderLayer(ModBlocks.CT_TILE_STAIRS_G_3.get(), RenderType.translucent());
            ItemBlockRenderTypes.setRenderLayer(ModBlocks.CT_TILE_SLAB_G_3.get(), RenderType.translucent());
            ItemBlockRenderTypes.setRenderLayer(ModBlocks.CT_TILE_WALL_G_3.get(), RenderType.translucent());
            ItemBlockRenderTypes.setRenderLayer(ModBlocks.CT_TILE_STAIRS_B_3.get(), RenderType.translucent());
            ItemBlockRenderTypes.setRenderLayer(ModBlocks.CT_TILE_SLAB_B_3.get(), RenderType.translucent());
            ItemBlockRenderTypes.setRenderLayer(ModBlocks.CT_TILE_WALL_B_3.get(), RenderType.translucent());
            ItemBlockRenderTypes.setRenderLayer(ModBlocks.CT_TILE_STAIRS_R_3.get(), RenderType.translucent());
            ItemBlockRenderTypes.setRenderLayer(ModBlocks.CT_TILE_SLAB_R_3.get(), RenderType.translucent());
            ItemBlockRenderTypes.setRenderLayer(ModBlocks.CT_TILE_WALL_R_3.get(), RenderType.translucent());
            ItemBlockRenderTypes.setRenderLayer(ModBlocks.CT_TILE_STAIRS_P_3.get(), RenderType.translucent());
            ItemBlockRenderTypes.setRenderLayer(ModBlocks.CT_TILE_SLAB_P_3.get(), RenderType.translucent());
            ItemBlockRenderTypes.setRenderLayer(ModBlocks.CT_TILE_WALL_P_3.get(), RenderType.translucent());



        }

    }
}
