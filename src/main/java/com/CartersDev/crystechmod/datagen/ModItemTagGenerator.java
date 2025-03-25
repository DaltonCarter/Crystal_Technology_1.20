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
        this.copy(Tags.Blocks.ORES, Tags.Items.ORES);

        this.tag(ModTags.Items.GRINDABLE)
                .add(
                        Items.RAW_COPPER,
                        Items.RAW_IRON,
                        Items.RAW_GOLD,
                        Items.ANCIENT_DEBRIS,
                        ModItems.RAW_ALYTHUM.get(),
                        ModItems.RAW_GUNDANIUM.get(),
                        Items.COPPER_INGOT,
                        Items.IRON_INGOT,
                        Items.GOLD_INGOT,
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
                        ModTags.Items.GUNDANIUM_ORES,
                        ModTags.Items.HARMONIUM_ORES);

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
                        ModItems.HARMONIUM_DUST.get()
                );

        this.tag(ItemTags.PLANKS)
                .addTag(ModTags.Items.MOD_PLANKS);

        this.tag(Tags.Items.DUSTS)
                .add(ModItems.IRON_DUST.get(),
                    ModItems.GOLD_DUST.get(),
                    ModItems.ALYTHUM_DUST.get(),
                    ModItems.GUNDANIUM_DUST.get(),
                        ModItems.COPPER_DUST.get());


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
                .add(ModItems.STILL_ALONE_MUSIC_DISC.get(),
                        ModItems.HYOUHAKU_WANDERING_MUSIC_DISC.get(),
                        ModItems.CORRODED_VALVES_MUSIC_DISC.get(),
                        ModItems.DARK_MACHINATIONS_MUSIC_DISC.get(),
                        ModItems.DARK_VALLEY_MUSIC_DISC.get(),
                        ModItems.EAGLES_DAWN_MUSIC_DISC.get(),
                        ModItems.MANUFACTORY_MUSIC_DISC.get(),
                        ModItems.NECROFUNK_MUSIC_DISC.get(),
                        ModItems.SCOUTING_MUSIC_DISC.get(),
                        ModItems.PRODIGAL_SON_MUSIC_DISC.get(),
                        ModItems.PYROTEK_MUSIC_DISC.get(),
                        ModItems.REPENTANCE_MUSIC_DISC.get(),
                        ModItems.SPACE_ECHO_MUSIC_DISC.get(),
                        ModItems.TOMBS_MUSIC_DISC.get(),
                        ModItems.UNYIELDING_MUSIC_DISC.get(),
                        ModItems.WIRES_MUSIC_DISC.get(),
                        ModItems.XENOPHILE_MUSIC_DISC.get(),
                        ModItems.APPROACH_MUSIC_DISC.get(),
                        ModItems.DUSK_HOUR_MUSIC_DISC.get(),
                        ModItems.TS_DUSK_HOUR_MUSIC_DISC.get(),
                        ModItems.HEROISM_MUSIC_DISC.get(),
                        ModItems.LONE_TROOPER_MUSIC_DISC.get(),
                        ModItems.PHAROTEK_MUSIC_DISC.get(),
                        ModItems.VALVES_MUSIC_DISC.get(),
                        ModItems.WHAT_LURKS_MUSIC_DISC.get(),
                        ModItems.AIRSTRIKE_MUSIC_DISC.get(),
                        ModItems.HEROISM_2_MUSIC_DISC.get(),
                        ModItems.CREEPING_UPON_MUSIC_DISC.get(),
                        ModItems.DEPTH_CHARGE_MUSIC_DISC.get(),
                        ModItems.DRONE_MUSIC_DISC.get(),
                        ModItems.ON_THE_PROWL_MUSIC_DISC.get(),
                        ModItems.RAIN_IN_THE_NIGHT_MUSIC_DISC.get(),
                        ModItems.RECON_MUSIC_DISC.get(),
                        ModItems.AWAITING_MUSIC_DISC.get(),
                        ModItems.DENSE_MUSIC_DISC.get(),
                        ModItems.DERELICT_MUSIC_DISC.get(),
                        ModItems.RUN_MUSIC_DISC.get(),
                        ModItems.THE_SEARCH_MUSIC_DISC.get(),
                        ModItems.TRENCHES_MUSIC_DISC.get(),
                        ModItems.VECTOR_MUSIC_DISC.get(),
                        ModItems.VOICE_RHYTHM_2_MUSIC_DISC.get());

        this.tag(ItemTags.CREEPER_DROP_MUSIC_DISCS)
                .add(ModItems.STILL_ALONE_MUSIC_DISC.get(),
                        ModItems.HYOUHAKU_WANDERING_MUSIC_DISC.get(),
                        ModItems.CORRODED_VALVES_MUSIC_DISC.get(),
                        ModItems.DARK_MACHINATIONS_MUSIC_DISC.get(),
                        ModItems.DARK_VALLEY_MUSIC_DISC.get(),
                        ModItems.EAGLES_DAWN_MUSIC_DISC.get(),
                        ModItems.MANUFACTORY_MUSIC_DISC.get(),
                        ModItems.NECROFUNK_MUSIC_DISC.get(),
                        ModItems.SCOUTING_MUSIC_DISC.get(),
                        ModItems.PRODIGAL_SON_MUSIC_DISC.get(),
                        ModItems.PYROTEK_MUSIC_DISC.get(),
                        ModItems.REPENTANCE_MUSIC_DISC.get(),
                        ModItems.SPACE_ECHO_MUSIC_DISC.get(),
                        ModItems.TOMBS_MUSIC_DISC.get(),
                        ModItems.UNYIELDING_MUSIC_DISC.get(),
                        ModItems.WIRES_MUSIC_DISC.get(),
                        ModItems.XENOPHILE_MUSIC_DISC.get(),
                        ModItems.APPROACH_MUSIC_DISC.get(),
                        ModItems.DUSK_HOUR_MUSIC_DISC.get(),
                        ModItems.TS_DUSK_HOUR_MUSIC_DISC.get(),
                        ModItems.HEROISM_MUSIC_DISC.get(),
                        ModItems.LONE_TROOPER_MUSIC_DISC.get(),
                        ModItems.PHAROTEK_MUSIC_DISC.get(),
                        ModItems.VALVES_MUSIC_DISC.get(),
                        ModItems.WHAT_LURKS_MUSIC_DISC.get(),
                        ModItems.AIRSTRIKE_MUSIC_DISC.get(),
                        ModItems.HEROISM_2_MUSIC_DISC.get(),
                        ModItems.CREEPING_UPON_MUSIC_DISC.get(),
                        ModItems.DEPTH_CHARGE_MUSIC_DISC.get(),
                        ModItems.DRONE_MUSIC_DISC.get(),
                        ModItems.ON_THE_PROWL_MUSIC_DISC.get(),
                        ModItems.RAIN_IN_THE_NIGHT_MUSIC_DISC.get(),
                        ModItems.RECON_MUSIC_DISC.get(),
                        ModItems.AWAITING_MUSIC_DISC.get(),
                        ModItems.DENSE_MUSIC_DISC.get(),
                        ModItems.DERELICT_MUSIC_DISC.get(),
                        ModItems.RUN_MUSIC_DISC.get(),
                        ModItems.THE_SEARCH_MUSIC_DISC.get(),
                        ModItems.TRENCHES_MUSIC_DISC.get(),
                        ModItems.VECTOR_MUSIC_DISC.get(),
                        ModItems.VOICE_RHYTHM_2_MUSIC_DISC.get());



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
