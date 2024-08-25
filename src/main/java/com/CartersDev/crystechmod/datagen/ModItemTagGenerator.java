package com.CartersDev.crystechmod.datagen;

import com.CartersDev.crystechmod.CrystalTech;
import com.CartersDev.crystechmod.item.ModItems;
import com.CartersDev.crystechmod.util.ModTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.data.ExistingFileHelper;
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

        this.tag(ItemTags.TRIMMABLE_ARMOR)
                .add(
                        ModItems.GUNDANIUM_HELMET.get(),
                        ModItems.GUNDANIUM_CHESTPLATE.get(),
                        ModItems.GUNDANIUM_LEGGINGS.get(),
                        ModItems.GUNDANIUM_BOOTS.get(),
                        ModItems.ALYTHUM_HELMET.get(),
                        ModItems.ALYTHUM_CHESTPLATE.get(),
                        ModItems.ALYTHUM_LEGGINGS.get(),
                        ModItems.ALYTHUM_BOOTS.get());
                        ModItems.HAZMAT_MK1_HELMET.get();
                        ModItems.HAZMAT_MK1_CHESTPLATE.get();
                        ModItems.HAZMAT_MK1_LEGGINGS.get();
                        ModItems.HAZMAT_MK1_BOOTS.get();
                        ModItems.HAZMAT_MK2_HELMET.get();
                        ModItems.HAZMAT_MK2_CHESTPLATE.get();
                        ModItems.HAZMAT_MK2_LEGGINGS.get();
                        ModItems.HAZMAT_MK2_BOOTS.get();



        this.tag(ItemTags.MUSIC_DISCS)
                .add(ModItems.STILL_ALONE_MUSIC_DISC.get(),
                        ModItems.HYOUHAKU_WANDERING_MUSIC_DISC.get(),
                        ModItems.CORRODED_VALVES_MUSIC_DISC.get(),
                        ModItems.DARK_MACHINATIONS_MUSIC_DISC.get(),
                        ModItems.DARK_VALLEY_MUSIC_DISC.get(),
                        ModItems.EAGLES_DAWN_MUSIC_DISC.get(),
                        ModItems.MANUFACTORY_MUSIC_DISC.get(),
                        ModItems.NECROFUNK_MUSIC_DISC.get(),
                        ModItems.OBSESSION_SOFTWARE_MUSIC_DISC.get(),
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
                        ModItems.CANYON_CHASE_MUSIC_DISC.get(),
                        ModItems.CREEPING_UPON_MUSIC_DISC.get(),
                        ModItems.DEPTH_CHARGE_MUSIC_DISC.get(),
                        ModItems.DRONE_MUSIC_DISC.get(),
                        ModItems.ON_THE_PROWL_MUSIC_DISC.get(),
                        ModItems.RAIN_IN_THE_NIGHT_MUSIC_DISC.get(),
                        ModItems.RECON_MUSIC_DISC.get(),
                        ModItems.AWAITING_MUSIC_DISC.get(),
                        ModItems.DENSE_MUSIC_DISC.get(),
                        ModItems.FLOATING_MUSIC_DISC.get(),
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
                        ModItems.OBSESSION_SOFTWARE_MUSIC_DISC.get(),
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
                        ModItems.CANYON_CHASE_MUSIC_DISC.get(),
                        ModItems.CREEPING_UPON_MUSIC_DISC.get(),
                        ModItems.DEPTH_CHARGE_MUSIC_DISC.get(),
                        ModItems.DRONE_MUSIC_DISC.get(),
                        ModItems.ON_THE_PROWL_MUSIC_DISC.get(),
                        ModItems.RAIN_IN_THE_NIGHT_MUSIC_DISC.get(),
                        ModItems.RECON_MUSIC_DISC.get(),
                        ModItems.AWAITING_MUSIC_DISC.get(),
                        ModItems.DENSE_MUSIC_DISC.get(),
                        ModItems.FLOATING_MUSIC_DISC.get(),
                        ModItems.RUN_MUSIC_DISC.get(),
                        ModItems.THE_SEARCH_MUSIC_DISC.get(),
                        ModItems.TRENCHES_MUSIC_DISC.get(),
                        ModItems.VECTOR_MUSIC_DISC.get(),
                        ModItems.VOICE_RHYTHM_2_MUSIC_DISC.get());



        this.tag(ModTags.Items.STICKS)
                .add(ModItems.PLAGUED_STICK.get(),
                        Items.STICK);

    }
}
