package com.CartersDev.crystechmod.datagen;

import com.CartersDev.crystechmod.CrystalTech;
import com.CartersDev.crystechmod.item.ModItems;
import net.minecraft.advancements.Advancement;
import net.minecraft.advancements.DisplayInfo;
import net.minecraft.advancements.FrameType;
import net.minecraft.advancements.critereon.InventoryChangeTrigger;
import net.minecraft.core.HolderLookup;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.common.data.ForgeAdvancementProvider;

import java.util.function.Consumer;

public class ModAdvancementProvider implements ForgeAdvancementProvider.AdvancementGenerator {
    @Override
    public void generate(HolderLookup.Provider registries, Consumer<Advancement> saver, ExistingFileHelper existingFileHelper) {
        Advancement rootAdvancement = Advancement.Builder.advancement()
                .display(new DisplayInfo(new ItemStack(ModItems.TIBERIUM.get()),
                        Component.literal("Crystal Technology"), Component.literal("What could this strange mineral be?"),
                        new ResourceLocation(CrystalTech.MOD_ID, "textures/block/tiberium_block.png"), FrameType.TASK,
                        true, true, false))
                .addCriterion("has_tiberium", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.TIBERIUM.get()))
                .save(saver, new ResourceLocation(CrystalTech.MOD_ID, "crystechmod"), existingFileHelper);


        Advancement viniferatiberium = Advancement.Builder.advancement()
                .display(new DisplayInfo(new ItemStack(ModItems.TIBERIUM_BLUE.get()),
                        Component.literal("Vinifera Tiberium"), Component.literal("DANGER!!! EXPLOSIVE! Handle with extreme care!"),
                        null, FrameType.TASK,
                        true, true, false))
                .parent(rootAdvancement)
                .addCriterion("has_tiberium_blue", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.TIBERIUM_BLUE.get()))
                .save(saver, new ResourceLocation(CrystalTech.MOD_ID, "tiberium_blue"), existingFileHelper);



    }
}
