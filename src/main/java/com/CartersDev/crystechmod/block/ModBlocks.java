package com.CartersDev.crystechmod.block;

import com.CartersDev.crystechmod.CrystalTech;
import com.CartersDev.crystechmod.item.ModItems;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.DropExperienceBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;
import java.util.function.ToIntFunction;

public class ModBlocks {

    public static ToIntFunction<BlockState> tiberiumglow = BlockState -> 7;
    public static ToIntFunction<BlockState> blossomglow = BlockState -> 12;

    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, CrystalTech.MOD_ID);


    //Terrain Blocks
//    public static final RegistryObject<Block> TIBERIUM_SOIL = registerBlock("tiberium_soil",
//            () -> new TiberiumSoil(AbstractBlock.Properties.create(Material.EARTH)
//                    .harvestLevel(3).harvestTool(ToolType.SHOVEL).tickRandomly()
//                    .setRequiresTool().hardnessAndResistance(5f, 1200.0f).sound(SoundType.GROUND)));
//
//    public static final RegistryObject<Block> ICHOR_SOIL = registerBlock("ichor_soil",
//            () -> new IchorSoil(AbstractBlock.Properties.create(Material.EARTH)
//                    .harvestLevel(3).harvestTool(ToolType.SHOVEL).tickRandomly()
//                    .setRequiresTool().hardnessAndResistance(5f, 1200.0f).sound(SoundType.GROUND)));

    public static final RegistryObject<Block> INFESTED_STONE = registerBlock("infested_stone",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.STONE)));

    public static final RegistryObject<Block> INFESTED_STONE_BRICKS = registerBlock("infested_stone_bricks",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.STONE_BRICKS)));

    public static final RegistryObject<Block> INFESTED_COBBLE = registerBlock("infested_cobble",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.COBBLESTONE)));

    public static final RegistryObject<Block> INFESTED_DIORITE = registerBlock("infested_diorite",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.DIORITE)));

    public static final RegistryObject<Block> INFESTED_GRANITE = registerBlock("infested_granite",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.GRANITE)));

    public static final RegistryObject<Block> INFESTED_ANDESITE = registerBlock("infested_andesite",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.ANDESITE)));

    public static final RegistryObject<Block> YELLOW_ZONE_CRACKED_DIRT = registerBlock("yellow_zone_cracked_dirt",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.DIRT)));

    public static final RegistryObject<Block> RED_ZONE_DIRT = registerBlock("red_zone_dirt",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.DIRT)));

    public static final RegistryObject<Block> SEEDED_YELLOW_ZONE_CRACKED_DIRT = registerBlock("seeded_yellow_zone_cracked_dirt",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.DIRT)));

    public static final RegistryObject<Block> SEEDED_RED_ZONE_DIRT = registerBlock("seeded_red_zone_dirt",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.DIRT)));

    public static final RegistryObject<Block> YELLOW_ZONE_SAND = registerBlock("yellow_zone_sand",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.SAND)));

    public static final RegistryObject<Block> RED_ZONE_SAND = registerBlock("red_zone_sand",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.SAND)));

    public static final RegistryObject<Block> RIPARIUS_STONE = registerBlock("riparius_stone",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.STONE)));

    public static final RegistryObject<Block> VINIFERA_STONE = registerBlock("vinifera_stone",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.STONE)));

    public static final RegistryObject<Block> CRUENTUS_STONE = registerBlock("cruentus_stone",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.STONE)));

    public static final RegistryObject<Block> ABOREUS_STONE = registerBlock("aboreus_stone",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.STONE)));

    public static final RegistryObject<Block> RIPARIUS_CRYSTAL = registerBlock("riparius_crystal",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.OBSIDIAN).sound(SoundType.AMETHYST)
                    .noOcclusion().lightLevel(tiberiumglow)));

    public static final RegistryObject<Block> VINIFERA_CRYSTAL = registerBlock("vinifera_crystal",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.OBSIDIAN).sound(SoundType.AMETHYST)
                    .noOcclusion().lightLevel(tiberiumglow)));

    public static final RegistryObject<Block> CRUENTUS_CRYSTAL = registerBlock("cruentus_crystal",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.OBSIDIAN).sound(SoundType.AMETHYST)
                    .noOcclusion().lightLevel(tiberiumglow)));

    public static final RegistryObject<Block> ABOREUS_CRYSTAL = registerBlock("aboreus_crystal",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.OBSIDIAN).sound(SoundType.AMETHYST)
                    .noOcclusion().lightLevel(tiberiumglow)));

    public static final RegistryObject<Block> SEEDED_DIRT = registerBlock("seeded_dirt",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.DIRT)));


    //End Terrain Blocks


    //Metal and Mineral Blocks:

//    public static final RegistryObject<Block> FIRESTONE_BLOCK = registerBlock("firestone_block",
//            () -> new FirestoneBlock(AbstractBlock.Properties.create(Material.IRON)
//                    .harvestLevel(2).harvestTool(ToolType.PICKAXE)
//                    .setRequiresTool().hardnessAndResistance(5f)));

    public static final RegistryObject<Block> AERIES_BLOCK = registerBlock("aeries_block",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).sound(SoundType.AMETHYST)));

    public static final RegistryObject<Block> ILLUMINA_BLOCK = registerBlock("illumina_block",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).sound(SoundType.AMETHYST)));

    public static final RegistryObject<Block> ENIGMA_BLOCK = registerBlock("enigma_block",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).sound(SoundType.AMETHYST)));

    public static final RegistryObject<Block> KRYON_BLOCK = registerBlock("kryon_block",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).sound(SoundType.AMETHYST)));

    public static final RegistryObject<Block> GUNDANIUM_BLOCK = registerBlock("gundanium_block",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK)
                    .explosionResistance(100.0f)));

    public static final RegistryObject<Block> ALYTHUM_BLOCK = registerBlock("alythum_block",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK)
                    .explosionResistance(300.0f)));

    public static final RegistryObject<Block> ILLYRIM_BLOCK = registerBlock("illyrim_block",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK)
                    .explosionResistance(700.0f)));

    public static final RegistryObject<Block> LG_CORE_BLOCK = registerBlock("lg_core_block",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK)
                    .explosionResistance(200.0f)));

    public static final RegistryObject<Block> MG_CORE_BLOCK = registerBlock("mg_core_block",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK)
                    .explosionResistance(500.0f)));

    public static final RegistryObject<Block> HG_CORE_BLOCK = registerBlock("hg_core_block",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK)
                    .explosionResistance(1200.0f)));

    public static final RegistryObject<Block> TIBERIUM_BLOCK = registerBlock("tiberium_block",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).sound(SoundType.AMETHYST)));

    public static final RegistryObject<Block> TIBERIUM_BLUE_BLOCK = registerBlock("tiberium_blue_block",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).sound(SoundType.AMETHYST)));

    public static final RegistryObject<Block> TIBERIUM_RED_BLOCK = registerBlock("tiberium_red_block",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).sound(SoundType.AMETHYST)));

    public static final RegistryObject<Block> TIBERIUM_PURPLE_BLOCK = registerBlock("tiberium_purple_block",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).sound(SoundType.AMETHYST)));
    //End Metals and Minerals Blocks


    //Ores:
    public static final RegistryObject<Block> AERIES_ORE = registerBlock("aeries_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.STONE)
                    .strength(2f).requiresCorrectToolForDrops(), UniformInt.of(3, 6)));

    public static final RegistryObject<Block> ILLUMINA_ORE = registerBlock("illumina_ore",
            () ->new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.STONE)
                    .strength(2f).requiresCorrectToolForDrops(), UniformInt.of(3, 6)));

    public static final RegistryObject<Block> KRYON_ORE = registerBlock("kryon_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.STONE)
                    .strength(2f).requiresCorrectToolForDrops(), UniformInt.of(3, 6)));

    public static final RegistryObject<Block> ENIGMA_ORE = registerBlock("enigma_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.STONE)
                    .strength(2f).requiresCorrectToolForDrops(), UniformInt.of(3, 6)));

    public static final RegistryObject<Block> GUNDANIUM_ORE = registerBlock("gundanium_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.STONE)
                    .strength(2f).requiresCorrectToolForDrops(), UniformInt.of(3, 6)));

    public static final RegistryObject<Block> ALYTHUM_ORE = registerBlock("alythum_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.STONE)
                    .strength(2f).requiresCorrectToolForDrops(), UniformInt.of(3, 6)));

    public static final RegistryObject<Block> QUALRITE_ORE = registerBlock("qualrite_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.STONE)
                    .strength(2f).requiresCorrectToolForDrops(), UniformInt.of(3, 6)));
    //End Ores







    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block>RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block) {
        return ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }

}
