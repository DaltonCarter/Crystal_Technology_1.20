package com.CartersDev.crystechmod.datagen;

import com.CartersDev.crystechmod.CrystalTech;
import com.CartersDev.crystechmod.block.ModBlocks;
import com.CartersDev.crystechmod.item.ModItems;
import com.CartersDev.crystechmod.util.ModTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.common.data.ForgeItemTagsProvider;
import net.minecraftforge.fml.common.Mod;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;



public class ModItemTagGenerator extends ItemTagsProvider {
    public ModItemTagGenerator(PackOutput p_275343_, CompletableFuture<HolderLookup.Provider> p_275729_,
                               CompletableFuture<TagLookup<Block>> p_275322_, @Nullable ExistingFileHelper existingFileHelper) {
        super(p_275343_, p_275729_, p_275322_, CrystalTech.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {

    this.copy(ModTags.Blocks.TIBERCRETE_SANDS, ModTags.Items.TIBERCRETE_SANDS);

        this.copy(ModTags.Blocks.HAZMAT_GLASS_PANES, ModTags.Items.HAZMAT_GLASS_PANES);
        this.copy(ModTags.Blocks.CONCRETES, ModTags.Items.CONCRETES);

        this.copy(ModTags.Blocks.EMBER_OAK_LOGS, ModTags.Items.EMBER_OAK_LOGS);
        this.copy(ModTags.Blocks.MARIKA_OAK_LOGS, ModTags.Items.MARIKA_OAK_LOGS);
        this.copy(ModTags.Blocks.DEAD_LOGS, ModTags.Items.DEAD_LOGS);
        this.copy(ModTags.Blocks.PLAGUED_LOGS, ModTags.Items.PLAGUED_LOGS);
        this.copy(ModTags.Blocks.MOD_PLANKS, ModTags.Items.MOD_PLANKS);

        this.copy(ModTags.Blocks.GUNDANIUM_ORES, ModTags.Items.GUNDANIUM_ORES);
        this.copy(ModTags.Blocks.HARMONIUM_ORES, ModTags.Items.HARMONIUM_ORES);
        this.copy(ModTags.Blocks.ALYTHUM_ORES, ModTags.Items.ALYTHUM_ORES);
        this.copy(ModTags.Blocks.QUALRITE_ORES, ModTags.Items.QUALRITE_ORES);
        this.copy(ModTags.Blocks.AERIES_ORES, ModTags.Items.AERIES_ORES);
        this.copy(ModTags.Blocks.ILLUMINA_ORES, ModTags.Items.ILLUMINA_ORES);
        this.copy(ModTags.Blocks.KRYON_ORES, ModTags.Items.KRYON_ORES);
        this.copy(ModTags.Blocks.ENIGMA_ORES, ModTags.Items.ENIGMA_ORES);
        this.copy(ModTags.Blocks.GLASS, ModTags.Items.GLASS);
        this.copy(ModTags.Blocks.GRINDABLE_FLOWERS, ModTags.Items.GRINDABLE_FLOWERS);
        this.copy(ModTags.Blocks.MACERATABLE, ModTags.Items.MACERATABLE);
        this.copy(ModTags.Blocks.MACERATING_RESULT, ModTags.Items.MACERATING_RESULT);

        this.copy(ModTags.Blocks.SMELTABLE, ModTags.Items.SMELTABLE);
        this.copy(ModTags.Blocks.SMELTING_RESULT, ModTags.Items.SMELTING_RESULT);

        this.copy(Tags.Blocks.ORES, Tags.Items.ORES);

        this.tag(Tags.Items.RODS)
                .add(
                        ModItems.PLAGUED_STICK.get()
                );

        this.tag(Tags.Items.DUSTS)
                .add(
                        ModItems.GUNDANIUM_DUST.get(),
                        ModItems.ALYTHUM_DUST.get(),
                        ModItems.HARMONIUM_DUST.get(),
                        ModItems.IRON_DUST.get(),
                        ModItems.GOLD_DUST.get(),
                        ModItems.COPPER_DUST.get(),
                        ModItems.ILLYRIM_BLEND.get(),
                        ModItems.LG_CORE_BLEND.get(),
                        ModItems.MG_CORE_BLEND.get(),
                        ModItems.HG_CORE_BLEND.get()
                );


        this.tag(Tags.Items.INGOTS)
                .add(
                        ModItems.GUNDANIUM_INGOT.get(),
                        ModItems.ALYTHUM_INGOT.get(),
                        ModItems.HARMONIUM_INGOT.get(),
                        ModItems.ILLYRIM_INGOT.get(),
                        ModItems.LG_CORE_INGOT.get(),
                        ModItems.MG_CORE_INGOT.get(),
                        ModItems.HG_CORE_INGOT.get()
                );

        this.tag(Tags.Items.RAW_MATERIALS)
                .add(
                        ModItems.RAW_GUNDANIUM.get(),
                        ModItems.RAW_ALYTHUM.get(),
                        ModItems.RAW_HARMONIUM.get()

                );

        this.tag(ModTags.Items.ALLOYING_INPUT)
                .add(
                        ModItems.ALYTHUM_INGOT.get(),
                        ModItems.ILLYRIM_INGOT.get(),
                        ModItems.LG_CORE_INGOT.get(),
                        ModItems.MG_CORE_INGOT.get(),
                        ModItems.PROTO_STEEL.get(),
                        ModItems.TIBERIUM_COMPOSITE_INGOT.get(),
                        ModItems.ICHOR_COMPOSITE_INGOT.get(),
                        ModItems.AERIES_CRYSTAL.get(),
                        ModItems.QUALRIM_COMPOUND.get(),
                        ModItems.ENIGMA_CRYSTAL.get(),
                        ModItems.GUNDANIUM_DUST.get(),
                        ModItems.IRON_DUST.get(),
                        Items.IRON_INGOT,
                        Items.COPPER_INGOT,
                        Items.GOLD_INGOT,
                        Items.NETHERITE_INGOT,
                        Items.MAGMA_BLOCK

                )
                .addTag(Tags.Items.INGOTS);

        this.tag(ModTags.Items.ALLOYING_RESULT)
                .add(

                        ModItems.ILLYRIM_INGOT.get(),
                        ModItems.LG_CORE_INGOT.get(),
                        ModItems.MG_CORE_INGOT.get(),
                        ModItems.HG_CORE_INGOT.get(),
                        ModItems.FIRESTONE.get()

                )
                .addTag(
                        Tags.Items.INGOTS
                );

        this.tag(ModTags.Items.BUCKET_OUTPUT)
                .add(

                        ModItems.MOLTEN_TIBERIUM_BUCKET.get(),
                        ModItems.MOLTEN_BLUE_TIBERIUM_BUCKET.get(),
                        ModItems.MOLTEN_RED_TIBERIUM_BUCKET.get(),
                        ModItems.MOLTEN_PURPLE_TIBERIUM_BUCKET.get(),
                        ModItems.LIQUID_PROTOCULTURE_BUCKET.get()


                )
                .addTag(
                        Tags.Items.INGOTS
                );


        this.tag(ModTags.Items.SMELTING)
                .add(
                        Items.BEEF,
                        Items.CHICKEN,
                        Items.PORKCHOP,
                        Items.RABBIT,
                        Items.MUTTON,
                        Items.COD,
                        Items.SALMON,
                        Items.POTATO,
                        Items.RAW_IRON,
                        Items.RAW_COPPER,
                        Items.RAW_GOLD,
                        Items.KELP,
                        Items.CLAY_BALL,
                        Items.CHORUS_FRUIT,
                        ModItems.RAW_ALYTHUM.get(),
                        ModItems.RAW_GUNDANIUM.get(),
                        ModItems.RAW_HARMONIUM.get(),
                        ModItems.RAW_INFECTED_MEAT.get(),
                        ModItems.IRON_DUST.get(),
                        ModItems.GOLD_DUST.get(),
                        ModItems.COPPER_DUST.get(),
                        ModItems.GUNDANIUM_DUST.get(),
                        ModItems.ALYTHUM_DUST.get(),
                        ModItems.HARMONIUM_DUST.get(),
                        ModItems.ILLYRIM_BLEND.get(),
                        ModItems.LG_CORE_BLEND.get(),
                        ModItems.MG_CORE_BLEND.get(),
                        ModItems.HG_CORE_BLEND.get()
                )
                .addTags(ModTags.Items.SMELTABLE,
                Tags.Items.ORES,
                        Tags.Items.DUSTS,
                        Tags.Items.RAW_MATERIALS);


        this.tag(ModTags.Items.SMELTING_RESULT_2)
                .add(
                        Items.COOKED_BEEF,
                        Items.COOKED_CHICKEN,
                        Items.COOKED_PORKCHOP,
                        Items.COOKED_RABBIT,
                        Items.COOKED_MUTTON,
                        Items.COOKED_COD,
                        Items.COOKED_SALMON,
                        Items.BAKED_POTATO,
                        Items.IRON_NUGGET,
                        Items.IRON_INGOT,
                        Items.COPPER_INGOT,
                        Items.GOLD_INGOT,
                        Items.DRIED_KELP,
                        Items.BRICK,
                        Items.POPPED_CHORUS_FRUIT,
                        Items.CHARCOAL,
                        Items.GREEN_DYE,
                        Items.LIME_DYE,
                        Items.NETHER_BRICK,
                        Items.NETHERITE_SCRAP,
                        ModItems.ALYTHUM_INGOT.get(),
                        ModItems.GUNDANIUM_INGOT.get(),
                        ModItems.HARMONIUM_INGOT.get(),
                        ModItems.COOKED_INFECTED_MEAT.get(),
                        ModItems.ILLYRIM_INGOT.get(),
                        ModItems.LG_CORE_INGOT.get(),
                        ModItems.MG_CORE_INGOT.get(),
                        ModItems.HG_CORE_INGOT.get()
                )
                .addTags(ModTags.Items.SMELTING_RESULT,
                        Tags.Items.INGOTS);






        this.tag(ModTags.Items.GRINDABLE)
                .add(
                        Items.RAW_COPPER,
                        Items.RAW_IRON,
                        Items.RAW_GOLD,
                        Items.ANCIENT_DEBRIS,
                        ModItems.RAW_ALYTHUM.get(),
                        ModItems.RAW_GUNDANIUM.get(),
                        ModItems.TIBERIUM.get(),
                        ModItems.TIBERIUM_BLUE.get(),
                        ModItems.TIBERIUM_RED.get(),
                        ModItems.TIBERIUM_PURPLE.get(),
                        Items.COPPER_INGOT,
                        Items.IRON_INGOT,
                        Items.GOLD_INGOT,
                        Items.COAL,
                        Items.DIAMOND,
                        Items.EMERALD,
                        Items.CHARCOAL,
                        Items.LAPIS_LAZULI,
                        Items.NETHERITE_INGOT,
                        ModItems.GUNDANIUM_INGOT.get(),
                        ModItems.ALYTHUM_INGOT.get(),
                        ModItems.ILLYRIM_INGOT.get(),
                        ModItems.LG_CORE_INGOT.get(),
                        ModItems.MG_CORE_INGOT.get(),
                        ModItems.HARMONIUM_INGOT.get(),
                        ModItems.RAW_HARMONIUM.get(),
                        ModItems.HG_CORE_INGOT.get()
                )
                .addTags(ModTags.Items.ALYTHUM_ORES,
                ModTags.Items.MACERATABLE,
                        ModTags.Items.GUNDANIUM_ORES,
                        ModTags.Items.HARMONIUM_ORES,
                        ModTags.Items.GRINDABLE_FLOWERS,
                        Tags.Items.RAW_MATERIALS,
                        Tags.Items.ORES,
                        Tags.Items.INGOTS);

        this.tag(ModTags.Items.GRINDING_RESULT)
                .add(
                        Items.NETHERITE_SCRAP,
                        ModItems.ALYTHUM_DUST.get(),
                        ModItems.GUNDANIUM_DUST.get(),
                        ModItems.IRON_DUST.get(),
                        ModItems.COPPER_DUST.get(),
                        ModItems.GOLD_DUST.get(),
                        ModItems.ILLYRIM_BLEND.get(),
                        ModItems.LG_CORE_BLEND.get(),
                        ModItems.MG_CORE_BLEND.get(),
                        ModItems.HG_CORE_BLEND.get(),
                        ModItems.BLUE_TIBERIUM_DUST.get(),
                        ModItems.GREEN_TIBERIUM_DUST.get(),
                        ModItems.PURPLE_TIBERIUM_DUST.get(),
                        ModItems.RED_TIBERIUM_DUST.get(),
                        ModItems.YOKARAN_BLOOM_POWDER.get(),
                        ModItems.DEVILS_BLOOD_POWDER.get(),
                        ModItems.HARMONIUM_DUST.get()
                )
                .addTags(
                        ModTags.Items.MACERATING_RESULT,
                        Tags.Items.DUSTS,
                        Tags.Items.GEMS
                );

        this.tag(ItemTags.PLANKS)
                .addTag(ModTags.Items.MOD_PLANKS);



        this.tag(ItemTags.TRIMMABLE_ARMOR)
                .add(
                        ModItems.GUNDANIUM_HELMET.get(),
                        ModItems.GUNDANIUM_CHESTPLATE.get(),
                        ModItems.GUNDANIUM_LEGGINGS.get(),
                        ModItems.GUNDANIUM_BOOTS.get(),
                        ModItems.ALYTHUM_HELMET.get(),
                        ModItems.ALYTHUM_CHESTPLATE.get(),
                        ModItems.ALYTHUM_LEGGINGS.get(),
                        ModItems.ALYTHUM_BOOTS.get(),
                        ModItems.ILLYRIM_HELMET.get(),
                        ModItems.ILLYRIM_CHESTPLATE.get(),
                        ModItems.ILLYRIM_LEGGINGS.get(),
                        ModItems.ILLYRIM_BOOTS.get(),
                        ModItems.HAZMAT_MK1_HELMET.get(),
                        ModItems.HAZMAT_MK1_CHESTPLATE.get(),
                        ModItems.HAZMAT_MK1_LEGGINGS.get(),
                        ModItems.HAZMAT_MK1_BOOTS.get(),
                        ModItems.HAZMAT_MK2_HELMET.get(),
                        ModItems.HAZMAT_MK2_CHESTPLATE.get(),
                        ModItems.HAZMAT_MK2_LEGGINGS.get(),
                        ModItems.HAZMAT_MK2_BOOTS.get());



        this.tag(ItemTags.MUSIC_DISCS)
                .add(ModItems.KODIAK_STRANDED_MUSIC_DISC.get(),
                        ModItems.DUSK_HOUR_MUSIC_DISC.get(),
                        ModItems.HEROISM_MUSIC_DISC.get(),
                        ModItems.LONE_TROOPER_MUSIC_DISC.get(),
                        ModItems.VALVES_MUSIC_DISC.get(),
                        ModItems.DERELICT_MUSIC_DISC.get());


        this.tag(ItemTags.CREEPER_DROP_MUSIC_DISCS)
                .add(ModItems.KODIAK_STRANDED_MUSIC_DISC.get(),
                        ModItems.DUSK_HOUR_MUSIC_DISC.get(),
                        ModItems.HEROISM_MUSIC_DISC.get(),
                        ModItems.LONE_TROOPER_MUSIC_DISC.get(),
                        ModItems.VALVES_MUSIC_DISC.get(),
                        ModItems.DERELICT_MUSIC_DISC.get());




        this.tag(ModTags.Items.STICKS)
                .add(ModItems.PLAGUED_STICK.get(),
                        Items.STICK);

        this.tag(Tags.Items.GEMS)
                .add(
                        ModItems.AERIES_CRYSTAL.get(),
                        ModItems.ILLUMINA_CRYSTAL.get(),
                        ModItems.KRYON_CRYSTAL.get(),
                        ModItems.ENIGMA_CRYSTAL.get(),
                        ModItems.TIBERIUM.get(),
                        ModItems.TIBERIUM_BLUE.get(),
                        ModItems.TIBERIUM_RED.get(),
                        ModItems.TIBERIUM_PURPLE.get()
                );

        this.tag(ItemTags.LOGS_THAT_BURN)
                .add(ModBlocks.PLAGUED_LOG.get().asItem())
                .add(ModBlocks.PLAGUED_WOOD.get().asItem())
                .add(ModBlocks.STRIPPED_PLAGUED_LOG.get().asItem())
                .add(ModBlocks.STRIPPED_PLAGUED_WOOD.get().asItem())
                .add(ModBlocks.MARIKA_OAK_LOG.get().asItem())
                .add(ModBlocks.MARIKA_OAK_WOOD.get().asItem())
                .add(ModBlocks.STRIPPED_MARIKA_OAK_LOG.get().asItem())
                .add(ModBlocks.STRIPPED_MARIKA_OAK_WOOD.get().asItem())
                .add(ModBlocks.DEAD_LOG.get().asItem())
                .add(ModBlocks.DEAD_WOOD.get().asItem())
                .add(ModBlocks.STRIPPED_DEAD_LOG.get().asItem())
                .add(ModBlocks.STRIPPED_DEAD_WOOD.get().asItem());

        this.tag(ItemTags.PLANKS)
                .add(ModBlocks.DEAD_PLANKS.get().asItem())
                .add(ModBlocks.MARIKA_OAK_PLANKS.get().asItem())
                .add(ModBlocks.EMBER_OAK_PLANKS.get().asItem());
    }

}
