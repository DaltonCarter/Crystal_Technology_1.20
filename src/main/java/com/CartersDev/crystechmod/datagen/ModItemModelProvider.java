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

        simpleItem(ModItems.TIBERIUM_LEATHER);
        simpleItem(ModItems.ICHOR_LEATHER);

        simpleItem(ModItems.TIBERIUM);
        simpleItem(ModItems.TIBERIUM_BLUE);
        simpleItem(ModItems.TIBERIUM_RED);
        simpleItem(ModItems.TIBERIUM_PURPLE);

        simpleItem(ModItems.AERIES_CRYSTAL);
        simpleItem(ModItems.ILLUMINA_CRYSTAL);
        simpleItem(ModItems.ENIGMA_CRYSTAL);
        simpleItem(ModItems.KRYON_CRYSTAL);

        simpleItem(ModItems.GUNDANIUM_DUST);
        simpleItem(ModItems.GUNDANIUM_INGOT);
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
        simpleItem(ModItems.RAW_GUNDANIUM);
        simpleItem(ModItems.QUALRIM_COMPOUND);
        simpleItem(ModItems.GDI_EMBLEM);
        simpleItem(ModItems.NOD_EMBLEM);
        simpleItem(ModItems.WOLF_EMBLEM);
        simpleItem(ModItems.PLAGUED_STICK);
        simpleItem(ModItems.FIRESTONE);

        simpleItem(ModItems.TIBERIUM_FRUIT);
        simpleItem(ModItems.STRAWBERRY);
        simpleItem(ModItems.STRAWBERRY_SEEDS);
        simpleItem(ModItems.CORN);
        simpleItem(ModItems.CORN_SEEDS);

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

        simpleBlockItem(ModBlocks.PLAGUED_DOOR);

        fenceItem(ModBlocks.PLAGUED_FENCE, ModBlocks.PLAGUED_PLANKS);
        buttonItem(ModBlocks.PLAGUED_BUTTON, ModBlocks.PLAGUED_PLANKS);

        evenSimplerBlockItem(ModBlocks.PLAGUED_STAIRS);
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
        evenSimplerBlockItem(ModBlocks.PLAGUED_SLAB);
        evenSimplerBlockItem(ModBlocks.INFESTED_COBBLE_SLAB);
        evenSimplerBlockItem(ModBlocks.INFESTED_STONE_BRICK_SLAB);
        evenSimplerBlockItem(ModBlocks.PLAGUED_PRESSURE_PLATE);
        evenSimplerBlockItem(ModBlocks.PLAGUED_FENCE_GATE);

        trapdoorItem((ModBlocks.PLAGUED_TRAPDOOR));
        wallItem((ModBlocks.FIRESTONE_WALL), ModBlocks.FIRESTONE_BLOCK);

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

        handheldItem(ModItems.ALYTHUM_SWORD);
        handheldItem(ModItems.ALYTHUM_PICKAXE);
        handheldItem(ModItems.ALYTHUM_AXE);
        handheldItem(ModItems.ALYTHUM_SHOVEL);
        handheldItem(ModItems.ALYTHUM_HOE);

        trimmedArmorItem(ModItems.GUNDANIUM_HELMET);
        trimmedArmorItem(ModItems.GUNDANIUM_CHESTPLATE);
        trimmedArmorItem(ModItems.GUNDANIUM_LEGGINGS);
        trimmedArmorItem(ModItems.GUNDANIUM_BOOTS);

        trimmedArmorItem(ModItems.ALYTHUM_HELMET);
        trimmedArmorItem(ModItems.ALYTHUM_CHESTPLATE);
        trimmedArmorItem(ModItems.ALYTHUM_LEGGINGS);
        trimmedArmorItem(ModItems.ALYTHUM_BOOTS);

        trimmedArmorItem(ModItems.HAZMAT_MK1_HELMET);
        trimmedArmorItem(ModItems.HAZMAT_MK1_CHESTPLATE);
        trimmedArmorItem(ModItems.HAZMAT_MK1_LEGGINGS);
        trimmedArmorItem(ModItems.HAZMAT_MK1_BOOTS);

        trimmedArmorItem(ModItems.HAZMAT_MK2_HELMET);
        trimmedArmorItem(ModItems.HAZMAT_MK2_CHESTPLATE);
        trimmedArmorItem(ModItems.HAZMAT_MK2_LEGGINGS);
        trimmedArmorItem(ModItems.HAZMAT_MK2_BOOTS);

        simpleItem(ModItems.GUNDANIUM_HORSE_ARMOR);

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

}
