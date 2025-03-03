package com.CartersDev.crystechmod.event;


import com.CartersDev.crystechmod.CrystalTech;
import com.CartersDev.crystechmod.enchantment.ModEnchantments;
import com.CartersDev.crystechmod.item.ModItems;
import com.CartersDev.crystechmod.item.custom.HammerItem;
import com.CartersDev.crystechmod.villager.ModVillagers;
import it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import net.minecraft.client.sounds.MusicManager;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.npc.VillagerProfession;
import net.minecraft.world.entity.npc.VillagerTrades;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.EnchantedBookItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.enchantment.EnchantmentInstance;
import net.minecraft.world.item.trading.MerchantOffer;
import net.minecraftforge.event.level.BlockEvent;
import net.minecraftforge.event.village.VillagerTradesEvent;
import net.minecraftforge.event.village.WandererTradesEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Mod.EventBusSubscriber(modid = CrystalTech.MOD_ID)
public class ModEvents {

    // Done with the help of https://github.com/CoFH/CoFHCore/blob/1.19.x/src/main/java/cofh/core/event/AreaEffectEvents.java
    // Don't be a jerk License
    public static final Set<BlockPos> HARVESTED_BLOCKS = new HashSet<>();

    @SubscribeEvent
    public static void  onHammerUsage(BlockEvent.BreakEvent event) {
        Player player = event.getPlayer();
        ItemStack mainHandItem = player.getMainHandItem();

        if(mainHandItem.getItem() instanceof HammerItem hammer && player instanceof ServerPlayer serverPlayer) {
            BlockPos initalBlockPos = event.getPos();
            if (HARVESTED_BLOCKS.contains(initalBlockPos)) {
                return;
            }

            for (BlockPos pos : HammerItem.getBlocksToBeDestroyed(1, initalBlockPos, serverPlayer)) {
                if(pos == initalBlockPos || !hammer.isCorrectToolForDrops(mainHandItem, event.getLevel().getBlockState(pos))) {
                    continue;
                }

                // Have to add them to a Set otherwise, the same code right here will get called for each block!
                HARVESTED_BLOCKS.add(pos);
                serverPlayer.gameMode.destroyBlock(pos);
                HARVESTED_BLOCKS.remove(pos);
            }
        }
    }

    @SubscribeEvent
    public static void addCustomTrades (VillagerTradesEvent event) {
        if(event.getType() == VillagerProfession.FARMER) {
            Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = event.getTrades();

            //Level 1
            trades.get(1).add((pTrader, pRandom) -> new MerchantOffer(new ItemStack(Items.EMERALD,2),
                    new ItemStack(ModItems.HEIM_BERRY.get(), 12), 10, 8, 0.02f));

            trades.get(1).add((pTrader, pRandom) -> new MerchantOffer(new ItemStack(Items.EMERALD,2),
                    new ItemStack(ModItems.HEL_FRUIT.get(), 12), 10, 8, 0.02f));

            //Level 2
            trades.get(2).add((pTrader, pRandom) -> new MerchantOffer(new ItemStack(Items.EMERALD,5),
                    new ItemStack(ModItems.SABER_CORN.get(), 6), 5, 9, 0.035f));

            //Level 3
            trades.get(3).add((pTrader, pRandom) -> new MerchantOffer(new ItemStack(ModItems.TIBERIUM.get(),5),
                    new ItemStack(ModItems.HEIM_BERRY_SEEDS.get(), 2), 2, 13, 0.075f));

            trades.get(3).add((pTrader, pRandom) -> new MerchantOffer(new ItemStack(ModItems.TIBERIUM.get(),5),
                    new ItemStack(ModItems.HEL_FRUIT_SEEDS.get(), 2), 2, 13, 0.075f));

        }

        if(event.getType() == VillagerProfession.LIBRARIAN) {
            Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = event.getTrades();
            ItemStack enchantedBook = EnchantedBookItem.createForEnchantment(new EnchantmentInstance(ModEnchantments.LIGHTNING_STRIKER.get(), 1));

            ItemStack enchantedBook2 = EnchantedBookItem.createForEnchantment(new EnchantmentInstance(ModEnchantments.VITRIC_HARVESTER.get(), 1));

            //Level 1
            trades.get(1).add((pTrader, pRandom) -> new MerchantOffer(new ItemStack(ModItems.TIBERIUM_BLUE.get(),20),
                    enchantedBook, 2, 8, 0.02f));

            trades.get(1).add((pTrader, pRandom) -> new MerchantOffer(new ItemStack(ModItems.TIBERIUM_RED.get(),20),
                    enchantedBook2, 2, 8, 0.02f));

        }


        if(event.getType() == ModVillagers.TIBERIUM_GATHERER.get()) {
            Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = event.getTrades();

            //Level 1
            trades.get(1).add((pTrader, pRandom) -> new MerchantOffer(new ItemStack(Items.EMERALD,2),
                    new ItemStack(ModItems.TIBERIUM_FRUIT.get(), 4), 10, 10, 0.015f));

            //Level 2
            trades.get(2).add((pTrader, pRandom) -> new MerchantOffer(new ItemStack(Items.EMERALD,10),
                    new ItemStack(ModItems.TIBERIUM.get(), 1), 10, 10, 0.025f));

            //Level 3
            trades.get(3).add((pTrader, pRandom) -> new MerchantOffer(new ItemStack(ModItems.TIBERIUM.get(),4),
                    new ItemStack(ModItems.TIBERIUM_BLUE.get(), 1), 10, 12, 0.03f));

            //Level 4
            trades.get(4).add((pTrader, pRandom) -> new MerchantOffer(new ItemStack(ModItems.TIBERIUM_BLUE.get(),4),
                    new ItemStack(ModItems.TIBERIUM_RED.get(), 1), 10, 14, 0.035f));

            //Level 5
            trades.get(5).add((pTrader, pRandom) -> new MerchantOffer(new ItemStack(ModItems.TIBERIUM_RED.get(),4),
                    new ItemStack(ModItems.TIBERIUM_PURPLE.get(), 1), 10, 16, 0.04f));
        }



    }

    @SubscribeEvent
public static void addCustomWanderingTrades(WandererTradesEvent event) {

    List<VillagerTrades.ItemListing> genericTrades = event.getGenericTrades();
    List<VillagerTrades.ItemListing> rareTrades = event.getRareTrades();

genericTrades.add((pTrader, pRandom) -> new MerchantOffer( new ItemStack(Items.EMERALD, 32),
        new ItemStack(ModItems.GREEN_TIBERIUM_DUST.get(), 1), 10, 2, 0.2f));

rareTrades.add((pTrader, pRandom) -> new MerchantOffer( new ItemStack(Items.EMERALD, 12),
                new ItemStack(ModItems.HAZMAT_MK1_HELMET.get(), 1), 2, 12, 0.15f));

rareTrades.add((pTrader, pRandom) -> new MerchantOffer( new ItemStack(Items.EMERALD, 12),
                new ItemStack(ModItems.HAZMAT_MK1_CHESTPLATE.get(), 1), 2, 12, 0.15f));

rareTrades.add((pTrader, pRandom) -> new MerchantOffer( new ItemStack(Items.EMERALD, 12),
                new ItemStack(ModItems.HAZMAT_MK1_LEGGINGS.get(), 1), 2, 12, 0.15f));

rareTrades.add((pTrader, pRandom) -> new MerchantOffer( new ItemStack(Items.EMERALD, 12),
                new ItemStack(ModItems.HAZMAT_MK1_BOOTS.get(), 1), 2, 12, 0.15f));


    }





}
