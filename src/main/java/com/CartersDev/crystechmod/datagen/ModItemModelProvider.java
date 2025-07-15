package com.CartersDev.crystechmod.datagen;

import com.CartersDev.crystechmod.CrystalTech;
import com.CartersDev.crystechmod.block.ModBlocks;
import com.CartersDev.crystechmod.item.ModItems;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.packs.PackType;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.armortrim.TrimMaterial;
import net.minecraft.world.item.armortrim.TrimMaterials;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.LinkedHashMap;

public class ModItemModelProvider extends ItemModelProvider {

    private static LinkedHashMap<ResourceKey<TrimMaterial>, Float> trimMaterials = new LinkedHashMap<>();
    static {
        trimMaterials.put(TrimMaterials.QUARTZ, 0.1f);
        trimMaterials.put(TrimMaterials.IRON, 0.2f);
        trimMaterials.put(TrimMaterials.NETHERITE, 0.3f);
        trimMaterials.put(TrimMaterials.REDSTONE, 0.4f);
        trimMaterials.put(TrimMaterials.COPPER, 0.5f);
        trimMaterials.put(TrimMaterials.GOLD, 0.6f);
        trimMaterials.put(TrimMaterials.EMERALD, 0.7f);
        trimMaterials.put(TrimMaterials.DIAMOND, 0.8f);
        trimMaterials.put(TrimMaterials.LAPIS, 0.9f);
        trimMaterials.put(TrimMaterials.AMETHYST, 1.0f);
    }

    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, CrystalTech.MOD_ID, existingFileHelper);
    }


    @Override
    protected void registerModels() {

        //Simple Item Models:
        simpleItem(ModItems.TIBERIUM_LEATHER);
        simpleItem(ModItems.ICHOR_LEATHER);

        simpleItem(ModItems.YOKARAN_BLOOM_POWDER);
        simpleItem(ModItems.DEVILS_BLOOD_POWDER);

        simpleItem(ModItems.STILL_ALONE_MUSIC_DISC);
        simpleItem(ModItems.HYOUHAKU_WANDERING_MUSIC_DISC);
        simpleItem(ModItems.CORRODED_VALVES_MUSIC_DISC);
        simpleItem(ModItems.DARK_MACHINATIONS_MUSIC_DISC);
        simpleItem(ModItems.DARK_VALLEY_MUSIC_DISC);
        simpleItem(ModItems.EAGLES_DAWN_MUSIC_DISC);
        simpleItem(ModItems.MANUFACTORY_MUSIC_DISC);
        simpleItem(ModItems.NECROFUNK_MUSIC_DISC);
        simpleItem(ModItems.SCOUTING_MUSIC_DISC);
        simpleItem(ModItems.PRODIGAL_SON_MUSIC_DISC);
        simpleItem(ModItems.PYROTEK_MUSIC_DISC);
        simpleItem(ModItems.REPENTANCE_MUSIC_DISC);
        simpleItem(ModItems.SPACE_ECHO_MUSIC_DISC);
        simpleItem(ModItems.TOMBS_MUSIC_DISC);
        simpleItem(ModItems.UNYIELDING_MUSIC_DISC);
        simpleItem(ModItems.WIRES_MUSIC_DISC);
        simpleItem(ModItems.XENOPHILE_MUSIC_DISC);
        simpleItem(ModItems.APPROACH_MUSIC_DISC);
        simpleItem(ModItems.DUSK_HOUR_MUSIC_DISC);
        simpleItem(ModItems.TS_DUSK_HOUR_MUSIC_DISC);
        simpleItem(ModItems.HEROISM_MUSIC_DISC);
        simpleItem(ModItems.LONE_TROOPER_MUSIC_DISC);
        simpleItem(ModItems.PHAROTEK_MUSIC_DISC);
        simpleItem(ModItems.VALVES_MUSIC_DISC);
        simpleItem(ModItems.WHAT_LURKS_MUSIC_DISC);
        simpleItem(ModItems.AIRSTRIKE_MUSIC_DISC);
        simpleItem(ModItems.HEROISM_2_MUSIC_DISC);
        simpleItem(ModItems.CREEPING_UPON_MUSIC_DISC);
        simpleItem(ModItems.DEPTH_CHARGE_MUSIC_DISC);
        simpleItem(ModItems.DRONE_MUSIC_DISC);
        simpleItem(ModItems.ON_THE_PROWL_MUSIC_DISC);
        simpleItem(ModItems.RAIN_IN_THE_NIGHT_MUSIC_DISC);
        simpleItem(ModItems.RECON_MUSIC_DISC);
        simpleItem(ModItems.AWAITING_MUSIC_DISC);
        simpleItem(ModItems.DENSE_MUSIC_DISC);
        simpleItem(ModItems.DERELICT_MUSIC_DISC);
        simpleItem(ModItems.RUN_MUSIC_DISC);
        simpleItem(ModItems.THE_SEARCH_MUSIC_DISC);
        simpleItem(ModItems.TRENCHES_MUSIC_DISC);
        simpleItem(ModItems.VECTOR_MUSIC_DISC);
        simpleItem(ModItems.VOICE_RHYTHM_2_MUSIC_DISC);

        simpleItem(ModItems.TIBERIUM);
        simpleItem(ModItems.TIBERIUM_BLUE);
        simpleItem(ModItems.TIBERIUM_RED);
        simpleItem(ModItems.TIBERIUM_PURPLE);

        simpleItem(ModItems.AERIES_CRYSTAL);
        simpleItem(ModItems.ILLUMINA_CRYSTAL);
        simpleItem(ModItems.ENIGMA_CRYSTAL);
        simpleItem(ModItems.KRYON_CRYSTAL);

        simpleItem(ModItems.GUNDANIUM_DUST);
        simpleItem(ModItems.HARMONIUM_DUST);
        simpleItem(ModItems.GRINDER_GEAR);
        simpleItem(ModItems.ILLYRIM_GRINDER_GEAR);
        simpleItem(ModItems.TIBERIUM_COMPOSITE_INGOT);
        simpleItem(ModItems.ICHOR_COMPOSITE_INGOT);
        simpleItem(ModItems.IRON_DUST);
        simpleItem(ModItems.COPPER_DUST);
        simpleItem(ModItems.GOLD_DUST);
        simpleItem(ModItems.GUNDANIUM_INGOT);
        simpleItem(ModItems.PROTO_STEEL);
        simpleItem(ModItems.HARMONIUM_INGOT);
        simpleItem(ModItems.ALYTHUM_DUST);
        simpleItem(ModItems.ALYTHUM_INGOT);
        simpleItem(ModItems.LG_CORE_BLEND);
        simpleItem(ModItems.LG_CORE_INGOT);
        simpleItem(ModItems.MG_CORE_BLEND);
        simpleItem(ModItems.MG_CORE_INGOT);
        simpleItem(ModItems.HG_CORE_BLEND);
        simpleItem(ModItems.HG_CORE_INGOT);
        simpleItem(ModItems.ILLYRIM_BLEND);
        simpleItem(ModItems.ILLYRIM_INGOT);
        simpleItem(ModItems.RAW_QUALRITE);
        simpleItem(ModItems.RAW_ALYTHUM);
        simpleItem(ModItems.RAW_HARMONIUM);
        simpleItem(ModItems.RAW_GUNDANIUM);
        simpleItem(ModItems.QUALRIM_COMPOUND);
        simpleItem(ModItems.GDI_EMBLEM);
        simpleItem(ModItems.NOD_EMBLEM);
        simpleItem(ModItems.WOLF_EMBLEM);
        simpleItem(ModItems.PLAGUED_STICK);
        simpleItem(ModItems.FIRESTONE);
        simpleItem(ModItems.ILLUMINATE_COMPONENT);
        simpleItem(ModItems.HARMONIC_RELAY);
        simpleItem(ModItems.HARMONIC_CIRCUIT);
        simpleItem(ModItems.HARMONIC_FOCUS);
        simpleItem(ModItems.KRYONIC_CAPACITOR);
        simpleItem(ModItems.KRYONIC_RESERVOIR);
        simpleItem(ModItems.VITRIC_CIRCUIT);

        simpleItem(ModItems.TIBERIUM_FRUIT);
        simpleItem(ModItems.HEIM_BERRY);
        simpleItem(ModItems.HEL_FRUIT);
        simpleItem(ModItems.LAI_MELON_SLICE);
        simpleItem(ModItems.SABER_BREAD);
        simpleItem(ModItems.ZAIRAN_FRUIT_SALAD);
        simpleItem(ModItems.HEIM_BERRY_SEEDS);
        simpleItem(ModItems.HEL_FRUIT_SEEDS);
        simpleItem(ModItems.LAI_MELON_SEEDS);
        simpleItem(ModItems.RAW_INFECTED_MEAT);
        simpleItem(ModItems.COOKED_INFECTED_MEAT);
        simpleItem(ModItems.SABER_CORN);
        simpleItem(ModItems.SABER_CORN_SEEDS);

        //Panes:
        paneItem(ModBlocks.CLEAR_TIBERGLASS_PANE, ModBlocks.CLEAR_TIBERGLASS);
        paneItem(ModBlocks.MOSAIC_TIBERGLASS_PANE, ModBlocks.MOSAIC_TIBERGLASS);
        paneItem(ModBlocks.GDI_TIBERGLASS_PANE, ModBlocks.GDI_TIBERGLASS);
        paneItem(ModBlocks.NOD_TIBERGLASS_PANE, ModBlocks.NOD_TIBERGLASS);
        paneItem(ModBlocks.WOLF_TIBERGLASS_PANE, ModBlocks.WOLF_TIBERGLASS);
        paneItem(ModBlocks.BLACK_TIBERGLASS_PANE, ModBlocks.BLACK_TIBERGLASS);
        paneItem(ModBlocks.BLUE_TIBERGLASS_PANE, ModBlocks.BLUE_TIBERGLASS);
        paneItem(ModBlocks.BROWN_TIBERGLASS_PANE, ModBlocks.BROWN_TIBERGLASS);
        paneItem(ModBlocks.CYAN_TIBERGLASS_PANE, ModBlocks.CYAN_TIBERGLASS);
        paneItem(ModBlocks.GRAY_TIBERGLASS_PANE, ModBlocks.GRAY_TIBERGLASS);
        paneItem(ModBlocks.GREEN_TIBERGLASS_PANE, ModBlocks.GREEN_TIBERGLASS);
        paneItem(ModBlocks.LIGHT_BLUE_TIBERGLASS_PANE, ModBlocks.LIGHT_BLUE_TIBERGLASS);
        paneItem(ModBlocks.LIGHT_GRAY_TIBERGLASS_PANE, ModBlocks.LIGHT_GRAY_TIBERGLASS);
        paneItem(ModBlocks.LIME_TIBERGLASS_PANE, ModBlocks.LIME_TIBERGLASS);
        paneItem(ModBlocks.MAGENTA_TIBERGLASS_PANE, ModBlocks.MAGENTA_TIBERGLASS);
        paneItem(ModBlocks.ORANGE_TIBERGLASS_PANE, ModBlocks.ORANGE_TIBERGLASS);
        paneItem(ModBlocks.PINK_TIBERGLASS_PANE, ModBlocks.PINK_TIBERGLASS);
        paneItem(ModBlocks.PURPLE_TIBERGLASS_PANE, ModBlocks.PURPLE_TIBERGLASS);
        paneItem(ModBlocks.RED_TIBERGLASS_PANE, ModBlocks.RED_TIBERGLASS);
        paneItem(ModBlocks.WHITE_TIBERGLASS_PANE, ModBlocks.WHITE_TIBERGLASS);
        paneItem(ModBlocks.YELLOW_TIBERGLASS_PANE, ModBlocks.YELLOW_TIBERGLASS);

        //Fences:
        fenceItem(ModBlocks.PLAGUED_FENCE, ModBlocks.PLAGUED_PLANKS);
        fenceItem(ModBlocks.EMBER_OAK_FENCE, ModBlocks.EMBER_OAK_PLANKS);
        fenceItem(ModBlocks.DEAD_FENCE, ModBlocks.DEAD_PLANKS);
        fenceItem(ModBlocks.MARIKA_OAK_FENCE, ModBlocks.MARIKA_OAK_PLANKS);

        //Buttons:
        buttonItem(ModBlocks.EMBER_OAK_BUTTON, ModBlocks.EMBER_OAK_PLANKS);
        buttonItem(ModBlocks.DEAD_BUTTON, ModBlocks.DEAD_PLANKS);
        buttonItem(ModBlocks.MARIKA_OAK_BUTTON, ModBlocks.MARIKA_OAK_PLANKS);
        buttonItem(ModBlocks.PLAGUED_BUTTON, ModBlocks.PLAGUED_PLANKS);

        //Block Items:
        simpleBlockItem(ModBlocks.PLAGUED_DOOR);
        simpleBlockItem(ModBlocks.EMBER_OAK_DOOR);
        simpleBlockItem(ModBlocks.DEAD_DOOR);
        simpleBlockItem(ModBlocks.MARIKA_OAK_DOOR);

        evenSimplerBlockItem(ModBlocks.PLAGUED_STAIRS);
        evenSimplerBlockItem(ModBlocks.EMBER_OAK_STAIRS);
        evenSimplerBlockItem(ModBlocks.DEAD_STAIRS);
        evenSimplerBlockItem(ModBlocks.MARIKA_OAK_STAIRS);
        evenSimplerBlockItem(ModBlocks.INFESTED_COBBLE_STAIRS);
        evenSimplerBlockItem(ModBlocks.INFESTED_STONE_BRICK_STAIRS);
        evenSimplerBlockItem(ModBlocks.BLACK_TIBERCRETE_STAIRS);
        evenSimplerBlockItem(ModBlocks.BLUE_TIBERCRETE_STAIRS);
        evenSimplerBlockItem(ModBlocks.BROWN_TIBERCRETE_STAIRS);
        evenSimplerBlockItem(ModBlocks.CYAN_TIBERCRETE_STAIRS);
        evenSimplerBlockItem(ModBlocks.GRAY_TIBERCRETE_STAIRS);
        evenSimplerBlockItem(ModBlocks.GREEN_TIBERCRETE_STAIRS);
        evenSimplerBlockItem(ModBlocks.LIGHT_BLUE_TIBERCRETE_STAIRS);
        evenSimplerBlockItem(ModBlocks.LIGHT_GRAY_TIBERCRETE_STAIRS);
        evenSimplerBlockItem(ModBlocks.LIME_TIBERCRETE_STAIRS);
        evenSimplerBlockItem(ModBlocks.MAGENTA_TIBERCRETE_STAIRS);
        evenSimplerBlockItem(ModBlocks.ORANGE_TIBERCRETE_STAIRS);
        evenSimplerBlockItem(ModBlocks.PINK_TIBERCRETE_STAIRS);
        evenSimplerBlockItem(ModBlocks.PURPLE_TIBERCRETE_STAIRS);
        evenSimplerBlockItem(ModBlocks.RED_TIBERCRETE_STAIRS);
        evenSimplerBlockItem(ModBlocks.WHITE_TIBERCRETE_STAIRS);
        evenSimplerBlockItem(ModBlocks.YELLOW_TIBERCRETE_STAIRS);

        evenSimplerBlockItem(ModBlocks.PROTO_STEEL_STAIRS);
        evenSimplerBlockItem(ModBlocks.IRON_PLATING_STAIRS);
        evenSimplerBlockItem(ModBlocks.RUSTY_IRON_PLATING_STAIRS);
        evenSimplerBlockItem(ModBlocks.VITRIC_IRON_PLATING_STAIRS);
        evenSimplerBlockItem(ModBlocks.POLISHED_IRON_STAIRS);

        evenSimplerBlockItem(ModBlocks.VITRIC_DEEPSLATE_TILE_STAIRS);
        evenSimplerBlockItem(ModBlocks.VITRIC_DEEPSLATE_BRICK_STAIRS);

        evenSimplerBlockItem(ModBlocks.CS_SCAFFOLD_STAIRS);
        evenSimplerBlockItem(ModBlocks.CS_SCAFFOLD_SLAB);
        evenSimplerBlockItem(ModBlocks.PROTO_STEEL_SLAB);

        evenSimplerBlockItem(ModBlocks.IRON_PLATING_SLAB);
        evenSimplerBlockItem(ModBlocks.RUSTY_IRON_PLATING_SLAB);
        evenSimplerBlockItem(ModBlocks.VITRIC_IRON_PLATING_SLAB);
        evenSimplerBlockItem(ModBlocks.POLISHED_IRON_SLAB);

        evenSimplerBlockItem(ModBlocks.VITRIC_DEEPSLATE_BRICK_SLAB);
        evenSimplerBlockItem(ModBlocks.VITRIC_DEEPSLATE_TILE_SLAB);
        evenSimplerBlockItem(ModBlocks.CS_CATWALK_W_STAIRS);
        evenSimplerBlockItem(ModBlocks.CS_CATWALK_W_SLAB);
        evenSimplerBlockItem(ModBlocks.CS_CATWALK_BL_STAIRS);
        evenSimplerBlockItem(ModBlocks.CS_CATWALK_BL_SLAB);
        evenSimplerBlockItem(ModBlocks.CS_CATWALK_B_STAIRS);
        evenSimplerBlockItem(ModBlocks.CS_CATWALK_B_SLAB);
        evenSimplerBlockItem(ModBlocks.CS_CATWALK_G_STAIRS);
        evenSimplerBlockItem(ModBlocks.CS_CATWALK_G_SLAB);
        evenSimplerBlockItem(ModBlocks.CS_CATWALK_R_STAIRS);
        evenSimplerBlockItem(ModBlocks.CS_CATWALK_R_SLAB);
        evenSimplerBlockItem(ModBlocks.CS_CATWALK_P_STAIRS);
        evenSimplerBlockItem(ModBlocks.CS_CATWALK_P_SLAB);
        evenSimplerBlockItem(ModBlocks.CS_TILE_STAIRS);
        evenSimplerBlockItem(ModBlocks.CS_TILE_SLAB);
        evenSimplerBlockItem(ModBlocks.CS_TILE_BR_STAIRS);
        evenSimplerBlockItem(ModBlocks.CS_TILE_BR_SLAB);
        evenSimplerBlockItem(ModBlocks.CS_TILE_YB_STAIRS);
        evenSimplerBlockItem(ModBlocks.CS_TILE_YB_SLAB);
        evenSimplerBlockItem(ModBlocks.CS_TILE_G_STAIRS);
        evenSimplerBlockItem(ModBlocks.CS_TILE_G_SLAB);
        evenSimplerBlockItem(ModBlocks.CS_TILE_B_STAIRS);
        evenSimplerBlockItem(ModBlocks.CS_TILE_B_SLAB);
        evenSimplerBlockItem(ModBlocks.CS_TILE_R_STAIRS);
        evenSimplerBlockItem(ModBlocks.CS_TILE_R_SLAB);
        evenSimplerBlockItem(ModBlocks.CS_TILE_P_STAIRS);
        evenSimplerBlockItem(ModBlocks.CS_TILE_P_SLAB);
        evenSimplerBlockItem(ModBlocks.CS_TILE_LG_STAIRS);
        evenSimplerBlockItem(ModBlocks.CS_TILE_LG_SLAB);
        evenSimplerBlockItem(ModBlocks.CS_TILE_MG_STAIRS);
        evenSimplerBlockItem(ModBlocks.CS_TILE_MG_SLAB);
        evenSimplerBlockItem(ModBlocks.CS_TILE_HG_STAIRS);
        evenSimplerBlockItem(ModBlocks.CS_TILE_HG_SLAB);

        evenSimplerBlockItem(ModBlocks.CS_TILE_G_BAND_STAIRS);
        evenSimplerBlockItem(ModBlocks.CS_TILE_G_BAND_SLAB);
        evenSimplerBlockItem(ModBlocks.CS_TILE_G_FRAME_STAIRS);
        evenSimplerBlockItem(ModBlocks.CS_TILE_G_FRAME_SLAB);

        evenSimplerBlockItem(ModBlocks.CS_TILE_B_BAND_STAIRS);
        evenSimplerBlockItem(ModBlocks.CS_TILE_B_BAND_SLAB);
        evenSimplerBlockItem(ModBlocks.CS_TILE_B_FRAME_STAIRS);
        evenSimplerBlockItem(ModBlocks.CS_TILE_B_FRAME_SLAB);

        evenSimplerBlockItem(ModBlocks.CS_TILE_R_BAND_STAIRS);
        evenSimplerBlockItem(ModBlocks.CS_TILE_R_BAND_SLAB);
        evenSimplerBlockItem(ModBlocks.CS_TILE_R_FRAME_STAIRS);
        evenSimplerBlockItem(ModBlocks.CS_TILE_R_FRAME_SLAB);

        evenSimplerBlockItem(ModBlocks.CS_TILE_P_BAND_STAIRS);
        evenSimplerBlockItem(ModBlocks.CS_TILE_P_BAND_SLAB);
        evenSimplerBlockItem(ModBlocks.CS_TILE_P_FRAME_STAIRS);
        evenSimplerBlockItem(ModBlocks.CS_TILE_P_FRAME_SLAB);

        evenSimplerBlockItem(ModBlocks.CS_TILE_LG_BAND_STAIRS);
        evenSimplerBlockItem(ModBlocks.CS_TILE_LG_BAND_SLAB);
        evenSimplerBlockItem(ModBlocks.CS_TILE_LG_FRAME_STAIRS);
        evenSimplerBlockItem(ModBlocks.CS_TILE_LG_FRAME_SLAB);

        evenSimplerBlockItem(ModBlocks.CS_TILE_MG_BAND_STAIRS);
        evenSimplerBlockItem(ModBlocks.CS_TILE_MG_BAND_SLAB);
        evenSimplerBlockItem(ModBlocks.CS_TILE_MG_FRAME_STAIRS);
        evenSimplerBlockItem(ModBlocks.CS_TILE_MG_FRAME_SLAB);

        evenSimplerBlockItem(ModBlocks.CS_TILE_HG_BAND_STAIRS);
        evenSimplerBlockItem(ModBlocks.CS_TILE_HG_BAND_SLAB);
        evenSimplerBlockItem(ModBlocks.CS_TILE_HG_FRAME_STAIRS);
        evenSimplerBlockItem(ModBlocks.CS_TILE_HG_FRAME_SLAB);

        evenSimplerBlockItem(ModBlocks.CT_TILE_STAIRS);
        evenSimplerBlockItem(ModBlocks.CT_TILE_SLAB);
        evenSimplerBlockItem(ModBlocks.CT_TILE_STAIRS_G);
        evenSimplerBlockItem(ModBlocks.CT_TILE_SLAB_G);
        evenSimplerBlockItem(ModBlocks.CT_TILE_STAIRS_B);
        evenSimplerBlockItem(ModBlocks.CT_TILE_SLAB_B);
        evenSimplerBlockItem(ModBlocks.CT_TILE_STAIRS_R);
        evenSimplerBlockItem(ModBlocks.CT_TILE_SLAB_R);
        evenSimplerBlockItem(ModBlocks.CT_TILE_STAIRS_P);
        evenSimplerBlockItem(ModBlocks.CT_TILE_SLAB_P);

        evenSimplerBlockItem(ModBlocks.CT_TILE_STAIRS_2);
        evenSimplerBlockItem(ModBlocks.CT_TILE_SLAB_2);
        evenSimplerBlockItem(ModBlocks.CT_TILE_STAIRS_G_2);
        evenSimplerBlockItem(ModBlocks.CT_TILE_SLAB_G_2);
        evenSimplerBlockItem(ModBlocks.CT_TILE_STAIRS_B_2);
        evenSimplerBlockItem(ModBlocks.CT_TILE_SLAB_B_2);
        evenSimplerBlockItem(ModBlocks.CT_TILE_STAIRS_R_2);
        evenSimplerBlockItem(ModBlocks.CT_TILE_SLAB_R_2);
        evenSimplerBlockItem(ModBlocks.CT_TILE_STAIRS_P_2);
        evenSimplerBlockItem(ModBlocks.CT_TILE_SLAB_P_2);

        evenSimplerBlockItem(ModBlocks.CT_TILE_STAIRS_3);
        evenSimplerBlockItem(ModBlocks.CT_TILE_SLAB_3);
        evenSimplerBlockItem(ModBlocks.CT_TILE_STAIRS_G_3);
        evenSimplerBlockItem(ModBlocks.CT_TILE_SLAB_G_3);
        evenSimplerBlockItem(ModBlocks.CT_TILE_STAIRS_B_3);
        evenSimplerBlockItem(ModBlocks.CT_TILE_SLAB_B_3);
        evenSimplerBlockItem(ModBlocks.CT_TILE_STAIRS_R_3);
        evenSimplerBlockItem(ModBlocks.CT_TILE_SLAB_R_3);
        evenSimplerBlockItem(ModBlocks.CT_TILE_STAIRS_P_3);
        evenSimplerBlockItem(ModBlocks.CT_TILE_SLAB_P_3);

        evenSimplerBlockItem(ModBlocks.PLAGUED_SLAB);
        evenSimplerBlockItem(ModBlocks.EMBER_OAK_SLAB);
        evenSimplerBlockItem(ModBlocks.DEAD_SLAB);
        evenSimplerBlockItem(ModBlocks.MARIKA_OAK_SLAB);
        evenSimplerBlockItem(ModBlocks.INFESTED_COBBLE_SLAB);
        evenSimplerBlockItem(ModBlocks.INFESTED_STONE_BRICK_SLAB);
        evenSimplerBlockItem(ModBlocks.PLAGUED_PRESSURE_PLATE);
        evenSimplerBlockItem(ModBlocks.EMBER_OAK_PRESSURE_PLATE);
        evenSimplerBlockItem(ModBlocks.DEAD_PRESSURE_PLATE);
        evenSimplerBlockItem(ModBlocks.MARIKA_OAK_PRESSURE_PLATE);
        evenSimplerBlockItem(ModBlocks.PLAGUED_FENCE_GATE);
        evenSimplerBlockItem(ModBlocks.DEAD_FENCE_GATE);
        evenSimplerBlockItem(ModBlocks.MARIKA_OAK_FENCE_GATE);
        evenSimplerBlockItem(ModBlocks.EMBER_OAK_FENCE_GATE);
        evenSimplerBlockItem(ModBlocks.BLACK_TIBERCRETE_SLAB);
        evenSimplerBlockItem(ModBlocks.BLUE_TIBERCRETE_SLAB);
        evenSimplerBlockItem(ModBlocks.BROWN_TIBERCRETE_SLAB);
        evenSimplerBlockItem(ModBlocks.CYAN_TIBERCRETE_SLAB);
        evenSimplerBlockItem(ModBlocks.GRAY_TIBERCRETE_SLAB);
        evenSimplerBlockItem(ModBlocks.GREEN_TIBERCRETE_SLAB);
        evenSimplerBlockItem(ModBlocks.LIGHT_BLUE_TIBERCRETE_SLAB);
        evenSimplerBlockItem(ModBlocks.LIGHT_GRAY_TIBERCRETE_SLAB);
        evenSimplerBlockItem(ModBlocks.LIME_TIBERCRETE_SLAB);
        evenSimplerBlockItem(ModBlocks.MAGENTA_TIBERCRETE_SLAB);
        evenSimplerBlockItem(ModBlocks.ORANGE_TIBERCRETE_SLAB);
        evenSimplerBlockItem(ModBlocks.PINK_TIBERCRETE_SLAB);
        evenSimplerBlockItem(ModBlocks.PURPLE_TIBERCRETE_SLAB);
        evenSimplerBlockItem(ModBlocks.RED_TIBERCRETE_SLAB);
        evenSimplerBlockItem(ModBlocks.WHITE_TIBERCRETE_SLAB);
        evenSimplerBlockItem(ModBlocks.YELLOW_TIBERCRETE_SLAB);
        evenSimplerBlockItem(ModBlocks.BLACK_TIBERCRETE_BRICK_STAIRS);
        evenSimplerBlockItem(ModBlocks.BLUE_TIBERCRETE_BRICK_STAIRS);
        evenSimplerBlockItem(ModBlocks.BROWN_TIBERCRETE_BRICK_STAIRS);
        evenSimplerBlockItem(ModBlocks.CYAN_TIBERCRETE_BRICK_STAIRS);
        evenSimplerBlockItem(ModBlocks.GRAY_TIBERCRETE_BRICK_STAIRS);
        evenSimplerBlockItem(ModBlocks.GREEN_TIBERCRETE_BRICK_STAIRS);
        evenSimplerBlockItem(ModBlocks.LIGHT_BLUE_TIBERCRETE_BRICK_STAIRS);
        evenSimplerBlockItem(ModBlocks.LIGHT_GRAY_TIBERCRETE_BRICK_STAIRS);
        evenSimplerBlockItem(ModBlocks.LIME_TIBERCRETE_BRICK_STAIRS);
        evenSimplerBlockItem(ModBlocks.MAGENTA_TIBERCRETE_BRICK_STAIRS);
        evenSimplerBlockItem(ModBlocks.ORANGE_TIBERCRETE_BRICK_STAIRS);
        evenSimplerBlockItem(ModBlocks.PINK_TIBERCRETE_BRICK_STAIRS);
        evenSimplerBlockItem(ModBlocks.PURPLE_TIBERCRETE_BRICK_STAIRS);
        evenSimplerBlockItem(ModBlocks.RED_TIBERCRETE_BRICK_STAIRS);
        evenSimplerBlockItem(ModBlocks.WHITE_TIBERCRETE_BRICK_STAIRS);
        evenSimplerBlockItem(ModBlocks.YELLOW_TIBERCRETE_BRICK_STAIRS);

        evenSimplerBlockItem(ModBlocks.RIPARIUS_CRYSTAL_STAIRS);
        evenSimplerBlockItem(ModBlocks.RIPARIUS_CRYSTAL_SLAB);
        evenSimplerBlockItem(ModBlocks.ABOREUS_CRYSTAL_STAIRS);
        evenSimplerBlockItem(ModBlocks.ABOREUS_CRYSTAL_SLAB);
        evenSimplerBlockItem(ModBlocks.CRUENTUS_CRYSTAL_STAIRS);
        evenSimplerBlockItem(ModBlocks.CRUENTUS_CRYSTAL_SLAB);
        evenSimplerBlockItem(ModBlocks.VINIFERA_CRYSTAL_STAIRS);
        evenSimplerBlockItem(ModBlocks.VINIFERA_CRYSTAL_SLAB);

        evenSimplerBlockItem(ModBlocks.ABOREUS_STONE_STAIRS);
        evenSimplerBlockItem(ModBlocks.ABOREUS_STONE_SLAB);
        evenSimplerBlockItem(ModBlocks.CRUENTUS_STONE_STAIRS);
        evenSimplerBlockItem(ModBlocks.CRUENTUS_STONE_SLAB);
        evenSimplerBlockItem(ModBlocks.VINIFERA_STONE_STAIRS);
        evenSimplerBlockItem(ModBlocks.VINIFERA_STONE_SLAB);

        evenSimplerBlockItem(ModBlocks.PLAGUED_ANDESITE_STAIRS);
        evenSimplerBlockItem(ModBlocks.PLAGUED_ANDESITE_SLAB);

        evenSimplerBlockItem(ModBlocks.PLAGUED_STONE_STAIRS);
        evenSimplerBlockItem(ModBlocks.PLAGUED_STONE_SLAB);
        evenSimplerBlockItem(ModBlocks.PLAGUED_GRANITE_STAIRS);
        evenSimplerBlockItem(ModBlocks.PLAGUED_GRANITE_SLAB);
        evenSimplerBlockItem(ModBlocks.PLAGUED_DIORITE_STAIRS);
        evenSimplerBlockItem(ModBlocks.PLAGUED_DIORITE_SLAB);
        evenSimplerBlockItem(ModBlocks.RIPARIUS_STONE_STAIRS);
        evenSimplerBlockItem(ModBlocks.RIPARIUS_STONE_SLAB);
        evenSimplerBlockItem(ModBlocks.ABOREUS_STONE_BRICK_STAIRS);
        evenSimplerBlockItem(ModBlocks.ABOREUS_STONE_BRICK_SLAB);
        evenSimplerBlockItem(ModBlocks.VINIFERA_STONE_BRICK_STAIRS);
        evenSimplerBlockItem(ModBlocks.VINIFERA_STONE_BRICK_SLAB);
        evenSimplerBlockItem(ModBlocks.CRUENTUS_STONE_BRICK_STAIRS);
        evenSimplerBlockItem(ModBlocks.CRUENTUS_STONE_BRICK_SLAB);
        evenSimplerBlockItem(ModBlocks.RIPARIUS_STONE_BRICK_STAIRS);
        evenSimplerBlockItem(ModBlocks.RIPARIUS_STONE_BRICK_SLAB);

        evenSimplerBlockItem(ModBlocks.BLACK_TIBERCRETE_BRICK_SLAB);
        evenSimplerBlockItem(ModBlocks.BLUE_TIBERCRETE_BRICK_SLAB);
        evenSimplerBlockItem(ModBlocks.BROWN_TIBERCRETE_BRICK_SLAB);
        evenSimplerBlockItem(ModBlocks.CYAN_TIBERCRETE_BRICK_SLAB);
        evenSimplerBlockItem(ModBlocks.GRAY_TIBERCRETE_BRICK_SLAB);
        evenSimplerBlockItem(ModBlocks.GREEN_TIBERCRETE_BRICK_SLAB);
        evenSimplerBlockItem(ModBlocks.LIGHT_BLUE_TIBERCRETE_BRICK_SLAB);
        evenSimplerBlockItem(ModBlocks.LIGHT_GRAY_TIBERCRETE_BRICK_SLAB);
        evenSimplerBlockItem(ModBlocks.LIME_TIBERCRETE_BRICK_SLAB);
        evenSimplerBlockItem(ModBlocks.MAGENTA_TIBERCRETE_BRICK_SLAB);
        evenSimplerBlockItem(ModBlocks.ORANGE_TIBERCRETE_BRICK_SLAB);
        evenSimplerBlockItem(ModBlocks.PINK_TIBERCRETE_BRICK_SLAB);
        evenSimplerBlockItem(ModBlocks.PURPLE_TIBERCRETE_BRICK_SLAB);
        evenSimplerBlockItem(ModBlocks.RED_TIBERCRETE_BRICK_SLAB);
        evenSimplerBlockItem(ModBlocks.WHITE_TIBERCRETE_BRICK_SLAB);
        evenSimplerBlockItem(ModBlocks.YELLOW_TIBERCRETE_BRICK_SLAB);

        //Trapdoors:
        trapdoorItem((ModBlocks.PLAGUED_TRAPDOOR));
        trapdoorItem((ModBlocks.EMBER_OAK_TRAPDOOR));
        trapdoorItem((ModBlocks.DEAD_TRAPDOOR));
        trapdoorItem((ModBlocks.MARIKA_OAK_TRAPDOOR));

        //Walls:
        wallItem((ModBlocks.FIRESTONE_WALL), ModBlocks.FIRESTONE_BLOCK);
        wallItem((ModBlocks.PROTO_STEEL_WALL), ModBlocks.PROTO_STEEL_BLOCK);

        wallItem((ModBlocks.IRON_PLATING_WALL), ModBlocks.IRON_PLATING);
        wallItem((ModBlocks.RUSTY_IRON_PLATING_WALL), ModBlocks.RUSTY_IRON_PLATING);
        wallItem((ModBlocks.VITRIC_IRON_PLATING_WALL), ModBlocks.VITRIC_IRON_PLATING);
        wallItem((ModBlocks.POLISHED_IRON_WALL), ModBlocks.POLISHED_IRON_BLOCK);

        wallItem((ModBlocks.CS_TILE_WALL), ModBlocks.CS_TILE);
        wallItem((ModBlocks.CS_TILE_BR_WALL), ModBlocks.CS_TILE_BR);
        wallItem((ModBlocks.CS_TILE_YB_WALL), ModBlocks.CS_TILE_YB);
        wallItem((ModBlocks.CS_TILE_G_WALL), ModBlocks.CS_TILE_G);
        wallItem((ModBlocks.CS_TILE_G_BAND_WALL), ModBlocks.CS_TILE_G_BAND);
        wallItem((ModBlocks.CS_TILE_G_FRAME_WALL), ModBlocks.CS_TILE_G_FRAME);
        wallItem((ModBlocks.CS_TILE_B_BAND_WALL), ModBlocks.CS_TILE_B_BAND);
        wallItem((ModBlocks.CS_TILE_B_FRAME_WALL), ModBlocks.CS_TILE_B_FRAME);
        wallItem((ModBlocks.CS_TILE_HG_BAND_WALL), ModBlocks.CS_TILE_HG_BAND);
        wallItem((ModBlocks.CS_TILE_HG_FRAME_WALL), ModBlocks.CS_TILE_HG_FRAME);
        wallItem((ModBlocks.CS_TILE_MG_BAND_WALL), ModBlocks.CS_TILE_MG_BAND);
        wallItem((ModBlocks.CS_TILE_MG_FRAME_WALL), ModBlocks.CS_TILE_MG_FRAME);
        wallItem((ModBlocks.CS_TILE_LG_BAND_WALL), ModBlocks.CS_TILE_LG_BAND);
        wallItem((ModBlocks.CS_TILE_LG_FRAME_WALL), ModBlocks.CS_TILE_LG_FRAME);
        wallItem((ModBlocks.CS_TILE_P_BAND_WALL), ModBlocks.CS_TILE_P_BAND);
        wallItem((ModBlocks.CS_TILE_P_FRAME_WALL), ModBlocks.CS_TILE_P_FRAME);
        wallItem((ModBlocks.CS_TILE_R_BAND_WALL), ModBlocks.CS_TILE_R_BAND);
        wallItem((ModBlocks.CS_TILE_R_FRAME_WALL), ModBlocks.CS_TILE_R_FRAME);
        wallItem((ModBlocks.CS_TILE_B_WALL), ModBlocks.CS_TILE_B);
        wallItem((ModBlocks.CS_TILE_R_WALL), ModBlocks.CS_TILE_R);
        wallItem((ModBlocks.CS_TILE_P_WALL), ModBlocks.CS_TILE_P);
        wallItem((ModBlocks.CS_TILE_LG_WALL), ModBlocks.CS_TILE_LG);
        wallItem((ModBlocks.CS_TILE_MG_WALL), ModBlocks.CS_TILE_MG);
        wallItem((ModBlocks.CS_TILE_HG_WALL), ModBlocks.CS_TILE_HG);

        wallItem((ModBlocks.CT_TILE_WALL), ModBlocks.CT_PILLAR_TOP);
        wallItem((ModBlocks.CT_TILE_WALL_G), ModBlocks.CT_PILLAR_TOP_G);
        wallItem((ModBlocks.CT_TILE_WALL_B), ModBlocks.CT_PILLAR_TOP_B);
        wallItem((ModBlocks.CT_TILE_WALL_R), ModBlocks.CT_PILLAR_TOP_R);
        wallItem((ModBlocks.CT_TILE_WALL_P), ModBlocks.CT_PILLAR_TOP_P);

        wallItem((ModBlocks.CT_TILE_WALL_2), ModBlocks.CT_TILE_2);
        wallItem((ModBlocks.CT_TILE_WALL_G_2), ModBlocks.CT_TILE_G_2);
        wallItem((ModBlocks.CT_TILE_WALL_B_2), ModBlocks.CT_TILE_B_2);
        wallItem((ModBlocks.CT_TILE_WALL_R_2), ModBlocks.CT_TILE_R_2);
        wallItem((ModBlocks.CT_TILE_WALL_P_2), ModBlocks.CT_TILE_P_2);

        wallItem((ModBlocks.CT_TILE_WALL_3), ModBlocks.CT_TILE_3);
        wallItem((ModBlocks.CT_TILE_WALL_G_3), ModBlocks.CT_TILE_G_3);
        wallItem((ModBlocks.CT_TILE_WALL_B_3), ModBlocks.CT_TILE_B_3);
        wallItem((ModBlocks.CT_TILE_WALL_R_3), ModBlocks.CT_TILE_R_3);
        wallItem((ModBlocks.CT_TILE_WALL_P_3), ModBlocks.CT_TILE_P_3);


        wallItem((ModBlocks.VITRIC_DEEPSLATE_BRICK_WALL), ModBlocks.VITRIC_DEEPSLATE_BRICKS);
        wallItem((ModBlocks.VITRIC_DEEPSLATE_TILE_WALL), ModBlocks.VITRIC_DEEPSLATE_TILES);


        wallItem((ModBlocks.INFESTED_COBBLE_WALL), ModBlocks.INFESTED_COBBLE);
        wallItem((ModBlocks.INFESTED_STONE_BRICK_WALL), ModBlocks.INFESTED_STONE_BRICKS);

        wallItem((ModBlocks.BLACK_TIBERCRETE_WALL), ModBlocks.BLACK_TIBERCRETE);
        wallItem((ModBlocks.BLUE_TIBERCRETE_WALL), ModBlocks.BLUE_TIBERCRETE);
        wallItem((ModBlocks.BROWN_TIBERCRETE_WALL), ModBlocks.BROWN_TIBERCRETE);
        wallItem((ModBlocks.CYAN_TIBERCRETE_WALL), ModBlocks.CYAN_TIBERCRETE);
        wallItem((ModBlocks.GRAY_TIBERCRETE_WALL), ModBlocks.GRAY_TIBERCRETE);
        wallItem((ModBlocks.GREEN_TIBERCRETE_WALL), ModBlocks.GREEN_TIBERCRETE);
        wallItem((ModBlocks.LIGHT_BLUE_TIBERCRETE_WALL), ModBlocks.LIGHT_BLUE_TIBERCRETE);
        wallItem((ModBlocks.LIGHT_GRAY_TIBERCRETE_WALL), ModBlocks.LIGHT_GRAY_TIBERCRETE);
        wallItem((ModBlocks.LIME_TIBERCRETE_WALL), ModBlocks.LIME_TIBERCRETE);
        wallItem((ModBlocks.MAGENTA_TIBERCRETE_WALL), ModBlocks.MAGENTA_TIBERCRETE);
        wallItem((ModBlocks.ORANGE_TIBERCRETE_WALL), ModBlocks.ORANGE_TIBERCRETE);
        wallItem((ModBlocks.PINK_TIBERCRETE_WALL), ModBlocks.PINK_TIBERCRETE);
        wallItem((ModBlocks.PURPLE_TIBERCRETE_WALL), ModBlocks.PURPLE_TIBERCRETE);
        wallItem((ModBlocks.RED_TIBERCRETE_WALL), ModBlocks.RED_TIBERCRETE);
        wallItem((ModBlocks.WHITE_TIBERCRETE_WALL), ModBlocks.WHITE_TIBERCRETE);
        wallItem((ModBlocks.YELLOW_TIBERCRETE_WALL), ModBlocks.YELLOW_TIBERCRETE);

        wallItem((ModBlocks.BLACK_TIBERCRETE_BRICK_WALL), ModBlocks.BLACK_TIBERCRETE_BRICKS);
        wallItem((ModBlocks.BLUE_TIBERCRETE_BRICK_WALL), ModBlocks.BLUE_TIBERCRETE_BRICKS);
        wallItem((ModBlocks.BROWN_TIBERCRETE_BRICK_WALL), ModBlocks.BROWN_TIBERCRETE_BRICKS);
        wallItem((ModBlocks.CYAN_TIBERCRETE_BRICK_WALL), ModBlocks.CYAN_TIBERCRETE_BRICKS);
        wallItem((ModBlocks.GRAY_TIBERCRETE_BRICK_WALL), ModBlocks.GRAY_TIBERCRETE_BRICKS);
        wallItem((ModBlocks.GREEN_TIBERCRETE_BRICK_WALL), ModBlocks.GREEN_TIBERCRETE_BRICKS);
        wallItem((ModBlocks.LIGHT_BLUE_TIBERCRETE_BRICK_WALL), ModBlocks.LIGHT_BLUE_TIBERCRETE_BRICKS);
        wallItem((ModBlocks.LIGHT_GRAY_TIBERCRETE_BRICK_WALL), ModBlocks.LIGHT_GRAY_TIBERCRETE_BRICKS);
        wallItem((ModBlocks.LIME_TIBERCRETE_BRICK_WALL), ModBlocks.LIME_TIBERCRETE_BRICKS);
        wallItem((ModBlocks.MAGENTA_TIBERCRETE_BRICK_WALL), ModBlocks.MAGENTA_TIBERCRETE_BRICKS);
        wallItem((ModBlocks.ORANGE_TIBERCRETE_BRICK_WALL), ModBlocks.ORANGE_TIBERCRETE_BRICKS);
        wallItem((ModBlocks.PINK_TIBERCRETE_BRICK_WALL), ModBlocks.PINK_TIBERCRETE_BRICKS);
        wallItem((ModBlocks.PURPLE_TIBERCRETE_BRICK_WALL), ModBlocks.PURPLE_TIBERCRETE_BRICKS);
        wallItem((ModBlocks.RED_TIBERCRETE_BRICK_WALL), ModBlocks.RED_TIBERCRETE_BRICKS);
        wallItem((ModBlocks.WHITE_TIBERCRETE_BRICK_WALL), ModBlocks.WHITE_TIBERCRETE_BRICKS);
        wallItem((ModBlocks.YELLOW_TIBERCRETE_BRICK_WALL), ModBlocks.YELLOW_TIBERCRETE_BRICKS);

        wallItem((ModBlocks.PLAGUED_ANDESITE_WALL), ModBlocks.INFESTED_ANDESITE);
        wallItem((ModBlocks.PLAGUED_STONE_WALL), ModBlocks.INFESTED_STONE);
        wallItem((ModBlocks.PLAGUED_GRANITE_WALL), ModBlocks.INFESTED_GRANITE);
        wallItem((ModBlocks.PLAGUED_DIORITE_WALL), ModBlocks.INFESTED_DIORITE);
        wallItem((ModBlocks.RIPARIUS_STONE_WALL), ModBlocks.RIPARIUS_STONE);
        wallItem((ModBlocks.ABOREUS_STONE_WALL), ModBlocks.ABOREUS_STONE);
        wallItem((ModBlocks.VINIFERA_STONE_WALL), ModBlocks.VINIFERA_STONE);
        wallItem((ModBlocks.CRUENTUS_STONE_WALL), ModBlocks.CRUENTUS_STONE);
        wallItem((ModBlocks.RIPARIUS_STONE_BRICK_WALL), ModBlocks.RIPARIUS_STONE_BRICKS);
        wallItem((ModBlocks.ABOREUS_STONE_BRICK_WALL), ModBlocks.ABOREUS_STONE_BRICKS);
        wallItem((ModBlocks.VINIFERA_STONE_BRICK_WALL), ModBlocks.VINIFERA_STONE_BRICKS);
        wallItem((ModBlocks.CRUENTUS_STONE_BRICK_WALL), ModBlocks.CRUENTUS_STONE_BRICKS);
        wallItem((ModBlocks.RIPARIUS_CRYSTAL_WALL), ModBlocks.RIPARIUS_CRYSTAL);
        wallItem((ModBlocks.ABOREUS_CRYSTAL_WALL), ModBlocks.ABOREUS_CRYSTAL);
        wallItem((ModBlocks.VINIFERA_CRYSTAL_WALL), ModBlocks.VINIFERA_CRYSTAL);
        wallItem((ModBlocks.CRUENTUS_CRYSTAL_WALL), ModBlocks.CRUENTUS_CRYSTAL);

        //Handheld Items:
        handheldItem(ModItems.PLAGUED_SWORD);
        handheldItem(ModItems.PLAGUED_PICKAXE);
        handheldItem(ModItems.PLAGUED_AXE);
        handheldItem(ModItems.PLAGUED_SHOVEL);
        handheldItem(ModItems.PLAGUED_HOE);

        handheldItem(ModItems.GUNDANIUM_SWORD);
        handheldItem(ModItems.GUNDANIUM_PICKAXE);
        handheldItem(ModItems.GUNDANIUM_AXE);
        handheldItem(ModItems.GUNDANIUM_SHOVEL);
        handheldItem(ModItems.GUNDANIUM_HOE);
        handheldItem(ModItems.GUNDANIUM_PAXEL);
        handheldItem(ModItems.GUNDANIUM_HAMMER);
        handheldItem(ModItems.GUNDANIUM_EXCAVATOR);

        handheldItem(ModItems.ALYTHUM_SWORD);
        handheldItem(ModItems.ALYTHUM_PICKAXE);
        handheldItem(ModItems.ALYTHUM_AXE);
        handheldItem(ModItems.ALYTHUM_SHOVEL);
        handheldItem(ModItems.ALYTHUM_HOE);
        handheldItem(ModItems.ALYTHUM_PAXEL);
        handheldItem(ModItems.ALYTHUM_HAMMER);
        handheldItem(ModItems.ALYTHUM_EXCAVATOR);

        handheldItem(ModItems.ILLYRIM_PICKAXE);
        handheldItem(ModItems.ILLYRIM_AXE);
        handheldItem(ModItems.ILLYRIM_SHOVEL);
        handheldItem(ModItems.ILLYRIM_HOE);
        handheldItem(ModItems.ILLYRIM_PAXEL);
        handheldItem(ModItems.ILLYRIM_HAMMER);
        handheldItem(ModItems.ILLYRIM_EXCAVATOR);

        //Armors:
        trimmedArmorItem(ModItems.GUNDANIUM_HELMET);
        trimmedArmorItem(ModItems.GUNDANIUM_CHESTPLATE);
        trimmedArmorItem(ModItems.GUNDANIUM_LEGGINGS);
        trimmedArmorItem(ModItems.GUNDANIUM_BOOTS);

        trimmedArmorItem(ModItems.ALYTHUM_HELMET);
        trimmedArmorItem(ModItems.ALYTHUM_CHESTPLATE);
        trimmedArmorItem(ModItems.ALYTHUM_LEGGINGS);
        trimmedArmorItem(ModItems.ALYTHUM_BOOTS);

        trimmedArmorItem(ModItems.ILLYRIM_HELMET);
        trimmedArmorItem(ModItems.ILLYRIM_CHESTPLATE);
        trimmedArmorItem(ModItems.ILLYRIM_LEGGINGS);
        trimmedArmorItem(ModItems.ILLYRIM_BOOTS);

        trimmedArmorItem(ModItems.HAZMAT_MK1_HELMET);
        trimmedArmorItem(ModItems.HAZMAT_MK1_CHESTPLATE);
        trimmedArmorItem(ModItems.HAZMAT_MK1_LEGGINGS);
        trimmedArmorItem(ModItems.HAZMAT_MK1_BOOTS);

        trimmedArmorItem(ModItems.HAZMAT_MK2_HELMET);
        trimmedArmorItem(ModItems.HAZMAT_MK2_CHESTPLATE);
        trimmedArmorItem(ModItems.HAZMAT_MK2_LEGGINGS);
        trimmedArmorItem(ModItems.HAZMAT_MK2_BOOTS);

        simpleItem(ModItems.GUNDANIUM_HORSE_ARMOR);


        //Plants:
        simpleBlockItemBlockTexture(ModBlocks.HYACINTH);
        simpleBlockItemBlockTexture(ModBlocks.FLOWER_OF_LIFE);
        simpleBlockItemBlockTexture(ModBlocks.DEVILS_BLOOD);

        //Spawn Eggs:
        withExistingParent(ModItems.RHINO_SPAWN_EGG.getId().getPath(), mcLoc("item/template_spawn_egg"));

        //Signs:
        simpleItem(ModItems.PLAGUED_SIGN);
        simpleItem(ModItems.PLAGUED_HANGING_SIGN);
        simpleItem(ModItems.EMBER_OAK_SIGN);
        simpleItem(ModItems.EMBER_OAK_HANGING_SIGN);
        simpleItem(ModItems.DEAD_SIGN);
        simpleItem(ModItems.DEAD_HANGING_SIGN);
        simpleItem(ModItems.MARIKA_OAK_SIGN);
        simpleItem(ModItems.MARIKA_OAK_HANGING_SIGN);

        //Complex?:
//        complexBlock(ModBlocks.TIBERIUM_INFUSER.get());

        //Saplings:

        saplingItem(ModBlocks.PLAGUED_SAPLING);
        saplingItem(ModBlocks.EMBER_OAK_SAPLING);
        saplingItem(ModBlocks.MARIKA_OAK_SAPLING);
        saplingItem(ModBlocks.DYING_SAPLING);
    }

    private ItemModelBuilder saplingItem(RegistryObject<Block> item) {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/generated")).texture("layer0",
                new ResourceLocation(CrystalTech.MOD_ID,"block/" + item.getId().getPath()));
    }

    private ItemModelBuilder complexBlock(Block block) {
        return withExistingParent(ForgeRegistries.BLOCKS.getKey(block).getPath(), new ResourceLocation(CrystalTech.MOD_ID,
                "block/" + ForgeRegistries.BLOCKS.getKey(block).getPath()));
    }


    // Shoutout to El_Redstoniano for making this
    private void trimmedArmorItem(RegistryObject<Item> itemRegistryObject) {
        final String MOD_ID = CrystalTech.MOD_ID; // Change this to your mod id

        if(itemRegistryObject.get() instanceof ArmorItem armorItem) {
            trimMaterials.entrySet().forEach(entry -> {

                ResourceKey<TrimMaterial> trimMaterial = entry.getKey();
                float trimValue = entry.getValue();

                String armorType = switch (armorItem.getEquipmentSlot()) {
                    case HEAD -> "helmet";
                    case CHEST -> "chestplate";
                    case LEGS -> "leggings";
                    case FEET -> "boots";
                    default -> "";
                };

                String armorItemPath = "item/" + armorItem;
                String trimPath = "trims/items/" + armorType + "_trim_" + trimMaterial.location().getPath();
                String currentTrimName = armorItemPath + "_" + trimMaterial.location().getPath() + "_trim";
                ResourceLocation armorItemResLoc = new ResourceLocation(MOD_ID, armorItemPath);
                ResourceLocation trimResLoc = new ResourceLocation(trimPath); // minecraft namespace
                ResourceLocation trimNameResLoc = new ResourceLocation(MOD_ID, currentTrimName);

                // This is used for making the ExistingFileHelper acknowledge that this texture exist, so this will
                // avoid an IllegalArgumentException
                existingFileHelper.trackGenerated(trimResLoc, PackType.CLIENT_RESOURCES, ".png", "textures");

                // Trimmed armorItem files
                getBuilder(currentTrimName)
                        .parent(new ModelFile.UncheckedModelFile("item/generated"))
                        .texture("layer0", armorItemResLoc)
                        .texture("layer1", trimResLoc);

                // Non-trimmed armorItem file (normal variant)
                this.withExistingParent(itemRegistryObject.getId().getPath(),
                                mcLoc("item/generated"))
                        .override()
                        .model(new ModelFile.UncheckedModelFile(trimNameResLoc))
                        .predicate(mcLoc("trim_type"), trimValue).end()
                        .texture("layer0",
                                new ResourceLocation(MOD_ID,
                                        "item/" + itemRegistryObject.getId().getPath()));
            });
        }
    }

    private ItemModelBuilder simpleItem(RegistryObject<Item> item) {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/generated")).texture("layer0",
                new ResourceLocation(CrystalTech.MOD_ID, "item/" + item.getId().getPath()));
    }

    public void evenSimplerBlockItem(RegistryObject<Block> block) {
        this.withExistingParent(CrystalTech.MOD_ID + ":" + ForgeRegistries.BLOCKS.getKey(block.get()).getPath(),
                modLoc("block/" + ForgeRegistries.BLOCKS.getKey(block.get()).getPath()));
    }

    private ItemModelBuilder paneItem(RegistryObject<Block> item, RegistryObject<Block> baseBlock) {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/generated")).texture("layer0",
                new ResourceLocation(CrystalTech.MOD_ID,"block/" + baseBlock.getId().getPath()));
    }

    public void trapdoorItem(RegistryObject<Block> block) {
        this.withExistingParent(ForgeRegistries.BLOCKS.getKey(block.get()).getPath(),
                modLoc("block/" + ForgeRegistries.BLOCKS.getKey(block.get()).getPath() + "_bottom"));
    }

    public void fenceItem(RegistryObject<Block> block, RegistryObject<Block> baseBlock) {
        this.withExistingParent(ForgeRegistries.BLOCKS.getKey(block.get()).getPath(), mcLoc("block/fence_inventory"))
                .texture("texture",  new ResourceLocation(CrystalTech.MOD_ID, "block/" + ForgeRegistries.BLOCKS.getKey(baseBlock.get()).getPath()));
    }

    public void buttonItem(RegistryObject<Block> block, RegistryObject<Block> baseBlock) {
        this.withExistingParent(ForgeRegistries.BLOCKS.getKey(block.get()).getPath(), mcLoc("block/button_inventory"))
                .texture("texture",  new ResourceLocation(CrystalTech.MOD_ID, "block/" + ForgeRegistries.BLOCKS.getKey(baseBlock.get()).getPath()));
    }

    public void wallItem(RegistryObject<Block> block, RegistryObject<Block> baseBlock) {
        this.withExistingParent(ForgeRegistries.BLOCKS.getKey(block.get()).getPath(), mcLoc("block/wall_inventory"))
                .texture("wall",  new ResourceLocation(CrystalTech.MOD_ID, "block/" + ForgeRegistries.BLOCKS.getKey(baseBlock.get()).getPath()));
    }

    private ItemModelBuilder handheldItem(RegistryObject<Item> item) {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/handheld")).texture("layer0",
                new ResourceLocation(CrystalTech.MOD_ID, "item/" + item.getId().getPath()));
    }


    private ItemModelBuilder simpleBlockItem(RegistryObject<Block> item) {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/generated")).texture("layer0",
                new ResourceLocation(CrystalTech.MOD_ID,"item/" + item.getId().getPath()));
    }

    private ItemModelBuilder simpleBlockItemBlockTexture(RegistryObject<Block> item) {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/generated")).texture("layer0",
                new ResourceLocation(CrystalTech.MOD_ID,"block/" + item.getId().getPath()));
    }

}
