package com.CartersDev.crystechmod.datagen;

import com.CartersDev.crystechmod.CrystalTech;
import com.CartersDev.crystechmod.item.ModItems;
import net.minecraft.advancements.Advancement;
import net.minecraft.advancements.DisplayInfo;
import net.minecraft.advancements.FrameType;
import net.minecraft.advancements.critereon.ChangeDimensionTrigger;
import net.minecraft.advancements.critereon.InventoryChangeTrigger;
import net.minecraft.advancements.critereon.UsingItemTrigger;
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

//        Advancement actoninstinct = Advancement.Builder.advancement()
//                .display(new DisplayInfo(new ItemStack(ModItems.GUNDANIUM_SWORD.get()),
//                        Component.literal("Act on Instinct"), Component.literal("You're going to have to use your instincts to survive here."),
//                        null, FrameType.TASK,
//                        true, true, false))
//                .addCriterion("used_1way_mt", ChangeDimensionTrigger.TriggerInstance.(ModItems.TIBERIUM_BLUE.get()))
//                .save(saver, new ResourceLocation(CrystalTech.MOD_ID, "tiberium_blue"), existingFileHelper);


        Advancement viniferatiberium = Advancement.Builder.advancement()
                .display(new DisplayInfo(new ItemStack(ModItems.TIBERIUM_BLUE.get()),
                        Component.literal("Vinifera Tiberium"), Component.literal("DANGER!!! EXPLOSIVE! Handle with extreme care!"),
                        null, FrameType.TASK,
                        true, true, false))
                .parent(rootAdvancement)
                .addCriterion("has_tiberium_blue", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.TIBERIUM_BLUE.get()))
                .save(saver, new ResourceLocation(CrystalTech.MOD_ID, "tiberium_blue"), existingFileHelper);

//        @Override
//
//        public ActionResult<ItemStack> onItemUse(ItemStack stack, PlayerEntity player, World world, BlockPos pos, Direction side, HitResult hitResult) {
//
//            if (stack.getItem() == yourCustomItem) { // Check if the used item is your custom item
//
//                // Trigger the advancement
//
//                player.getAdvancements().grantCriterion("your_advancement_id", "item_used");
//
//            }
//
//            return ActionResult.success(stack);
//
//        }


    }
}
