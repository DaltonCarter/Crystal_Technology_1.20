package com.CartersDev.crystechmod.block;

import com.CartersDev.crystechmod.CrystalTech;
import com.CartersDev.crystechmod.block.custom.*;
import com.CartersDev.crystechmod.fluid.ModFluids;
import com.CartersDev.crystechmod.item.ModItems;
import com.CartersDev.crystechmod.sound.ModSounds;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.block.state.properties.WoodType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
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



    public static final RegistryObject<Block> SOUND_BLOCK = registerBlock("sound_block",
            () -> new SoundBlock(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).sound(ModSounds.SOUND_BLOCK_SOUNDS)));

    //Terrain Blocks
    public static final RegistryObject<Block> TIBERIUM_SOIL = registerBlock("tiberium_soil",
            () -> new TiberiumSoilBlock(BlockBehaviour.Properties.copy(Blocks.STONE)
                    .strength(3f, 1200f).randomTicks()));

    public static final RegistryObject<Block> ICHOR_SOIL = registerBlock("ichor_soil",
            () -> new IchorSoilBlock(BlockBehaviour.Properties.copy(Blocks.DIRT)
                    .strength(3f, 1200f).randomTicks()));

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

    public static final RegistryObject<Block> FIRESTONE_BLOCK = registerBlock("firestone_block",
            () -> new FirestoneBlock(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK)));

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

    public static final RegistryObject<Block> DEEPSLATE_AERIES_ORE = registerBlock("deepslate_aeries_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.DEEPSLATE)
                    .strength(3f).requiresCorrectToolForDrops(), UniformInt.of(3, 6)));

    public static final RegistryObject<Block> NETHER_AERIES_ORE = registerBlock("nether_aeries_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.NETHERRACK)
                    .strength(2f).requiresCorrectToolForDrops(), UniformInt.of(3, 6)));

    public static final RegistryObject<Block> ILLUMINA_ORE = registerBlock("illumina_ore",
            () ->new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.STONE)
                    .strength(2f).requiresCorrectToolForDrops(), UniformInt.of(3, 6)));

    public static final RegistryObject<Block> DEEPSLATE_ILLUMINA_ORE = registerBlock("deepslate_illumina_ore",
        () ->new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.DEEPSLATE)
                    .strength(2f).requiresCorrectToolForDrops(), UniformInt.of(3, 6)));

    public static final RegistryObject<Block> KRYON_ORE = registerBlock("kryon_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.STONE)
                    .strength(2f).requiresCorrectToolForDrops(), UniformInt.of(3, 6)));

    public static final RegistryObject<Block> DEEPSLATE_KRYON_ORE = registerBlock("deepslate_kryon_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.DEEPSLATE)
                    .strength(3f).requiresCorrectToolForDrops(), UniformInt.of(3, 6)));

    public static final RegistryObject<Block> NETHER_KRYON_ORE = registerBlock("nether_kryon_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.NETHERRACK)
                    .strength(2f).requiresCorrectToolForDrops(), UniformInt.of(3, 6)));

    public static final RegistryObject<Block> END_KRYON_ORE = registerBlock("end_kryon_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.END_STONE)
                    .strength(3f).requiresCorrectToolForDrops(), UniformInt.of(3, 6)));

    public static final RegistryObject<Block> ENIGMA_ORE = registerBlock("enigma_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.STONE)
                    .strength(2f).requiresCorrectToolForDrops(), UniformInt.of(3, 6)));

    public static final RegistryObject<Block> DEEPSLATE_ENIGMA_ORE = registerBlock("deepslate_enigma_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.DEEPSLATE)
                    .strength(3f).requiresCorrectToolForDrops(), UniformInt.of(3, 6)));

    public static final RegistryObject<Block> END_ENIGMA_ORE = registerBlock("end_enigma_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.END_STONE)
                    .strength(3f).requiresCorrectToolForDrops(), UniformInt.of(3, 6)));

    public static final RegistryObject<Block> GUNDANIUM_ORE = registerBlock("gundanium_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.STONE)
                    .strength(2f).requiresCorrectToolForDrops(), UniformInt.of(3, 6)));

    public static final RegistryObject<Block> DEEPSLATE_GUNDANIUM_ORE = registerBlock("deepslate_gundanium_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.DEEPSLATE)
                    .strength(3f).requiresCorrectToolForDrops(), UniformInt.of(3, 6)));

    public static final RegistryObject<Block> ALYTHUM_ORE = registerBlock("alythum_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.STONE)
                    .strength(2f).requiresCorrectToolForDrops(), UniformInt.of(3, 6)));

    public static final RegistryObject<Block> DEEPSLATE_ALYTHUM_ORE = registerBlock("deepslate_alythum_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.DEEPSLATE)
                    .strength(3f).requiresCorrectToolForDrops(), UniformInt.of(3, 6)));

    public static final RegistryObject<Block> NETHER_ALYTHUM_ORE = registerBlock("nether_alythum_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.NETHERRACK)
                    .strength(2f).requiresCorrectToolForDrops(), UniformInt.of(3, 6)));

    public static final RegistryObject<Block> QUALRITE_ORE = registerBlock("qualrite_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.STONE)
                    .strength(2f).requiresCorrectToolForDrops(), UniformInt.of(3, 6)));

    public static final RegistryObject<Block> DEEPSLATE_QUALRITE_ORE = registerBlock("deepslate_qualrite_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.DEEPSLATE)
                    .strength(3f).requiresCorrectToolForDrops(), UniformInt.of(3, 6)));

    public static final RegistryObject<Block> NETHER_QUALRITE_ORE = registerBlock("nether_qualrite_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.NETHERRACK)
                    .strength(2f).requiresCorrectToolForDrops(), UniformInt.of(3, 6)));
    //End Ores


    //Deco Blocks:

    public static final RegistryObject<Block> NOD_CREST_LARGE = registerBlock("nod_crest_large",
            () -> new NodLogoLargeBlock(BlockBehaviour.Properties.copy(Blocks.STONE)));

    public static final RegistryObject<Block> BLACK_TIBERCRETE = registerBlock("black_tibercrete",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.BLACK_CONCRETE)));

    public static final RegistryObject<Block> BLUE_TIBERCRETE = registerBlock("blue_tibercrete",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.BLUE_CONCRETE)));

    public static final RegistryObject<Block> BROWN_TIBERCRETE = registerBlock("brown_tibercrete",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.BROWN_CONCRETE)));

    public static final RegistryObject<Block> CYAN_TIBERCRETE = registerBlock("cyan_tibercrete",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.CYAN_CONCRETE)));

    public static final RegistryObject<Block> GRAY_TIBERCRETE = registerBlock("gray_tibercrete",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.GRAY_CONCRETE)));

    public static final RegistryObject<Block> GREEN_TIBERCRETE = registerBlock("green_tibercrete",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.GREEN_CONCRETE)));

    public static final RegistryObject<Block> LIGHT_BLUE_TIBERCRETE = registerBlock("light_blue_tibercrete",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.LIGHT_BLUE_CONCRETE)));

    public static final RegistryObject<Block> LIGHT_GRAY_TIBERCRETE = registerBlock("light_gray_tibercrete",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.LIGHT_GRAY_CONCRETE)));

    public static final RegistryObject<Block> LIME_TIBERCRETE = registerBlock("lime_tibercrete",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.LIME_CONCRETE)));

    public static final RegistryObject<Block> MAGENTA_TIBERCRETE = registerBlock("magenta_tibercrete",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.MAGENTA_CONCRETE)));

    public static final RegistryObject<Block> ORANGE_TIBERCRETE = registerBlock("orange_tibercrete",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.ORANGE_CONCRETE)));

    public static final RegistryObject<Block> PINK_TIBERCRETE = registerBlock("pink_tibercrete",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.PINK_CONCRETE)));

    public static final RegistryObject<Block> PURPLE_TIBERCRETE = registerBlock("purple_tibercrete",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.PURPLE_CONCRETE)));

    public static final RegistryObject<Block> RED_TIBERCRETE = registerBlock("red_tibercrete",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.RED_CONCRETE)));

    public static final RegistryObject<Block> WHITE_TIBERCRETE = registerBlock("white_tibercrete",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.WHITE_CONCRETE)));

    public static final RegistryObject<Block> YELLOW_TIBERCRETE = registerBlock("yellow_tibercrete",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.YELLOW_CONCRETE)));

    public static final RegistryObject<Block> BLACK_TIBERCRETE_POWDER = registerBlock("black_tibercrete_powder",
            () -> new ConcretePowderBlock(BLACK_TIBERCRETE.get(),BlockBehaviour.Properties
                    .copy(Blocks.BLACK_CONCRETE_POWDER)));

    public static final RegistryObject<Block> BLUE_TIBERCRETE_POWDER = registerBlock("blue_tibercrete_powder",
            () -> new ConcretePowderBlock(BLUE_TIBERCRETE.get(),BlockBehaviour.Properties
                    .copy(Blocks.BLUE_CONCRETE_POWDER)));

    public static final RegistryObject<Block> BROWN_TIBERCRETE_POWDER = registerBlock("brown_tibercrete_powder",
            () -> new ConcretePowderBlock(BROWN_TIBERCRETE.get(),BlockBehaviour.Properties
                    .copy(Blocks.BROWN_CONCRETE_POWDER)));

    public static final RegistryObject<Block> CYAN_TIBERCRETE_POWDER = registerBlock("cyan_tibercrete_powder",
            () -> new ConcretePowderBlock(CYAN_TIBERCRETE.get(),BlockBehaviour.Properties
                    .copy(Blocks.CYAN_CONCRETE_POWDER)));

    public static final RegistryObject<Block> GRAY_TIBERCRETE_POWDER = registerBlock("gray_tibercrete_powder",
            () -> new ConcretePowderBlock(GRAY_TIBERCRETE.get(),BlockBehaviour.Properties
                    .copy(Blocks.GRAY_CONCRETE_POWDER)));

    public static final RegistryObject<Block> GREEN_TIBERCRETE_POWDER = registerBlock("green_tibercrete_powder",
            () -> new ConcretePowderBlock(GREEN_TIBERCRETE.get(),BlockBehaviour.Properties
                    .copy(Blocks.GREEN_CONCRETE_POWDER)));

    public static final RegistryObject<Block> LIGHT_BLUE_TIBERCRETE_POWDER = registerBlock("light_blue_tibercrete_powder",
            () -> new ConcretePowderBlock(LIGHT_BLUE_TIBERCRETE.get(),BlockBehaviour.Properties
                    .copy(Blocks.LIGHT_BLUE_CONCRETE_POWDER)));

    public static final RegistryObject<Block> LIGHT_GRAY_TIBERCRETE_POWDER = registerBlock("light_gray_tibercrete_powder",
            () -> new ConcretePowderBlock(LIGHT_GRAY_TIBERCRETE.get(),BlockBehaviour.Properties
                    .copy(Blocks.LIGHT_GRAY_CONCRETE_POWDER)));

    public static final RegistryObject<Block> LIME_TIBERCRETE_POWDER = registerBlock("lime_tibercrete_powder",
            () -> new ConcretePowderBlock(LIME_TIBERCRETE.get(),BlockBehaviour.Properties
                    .copy(Blocks.LIME_CONCRETE_POWDER)));

    public static final RegistryObject<Block> MAGENTA_TIBERCRETE_POWDER = registerBlock("magenta_tibercrete_powder",
            () -> new ConcretePowderBlock(MAGENTA_TIBERCRETE.get(),BlockBehaviour.Properties
                    .copy(Blocks.MAGENTA_CONCRETE_POWDER)));

    public static final RegistryObject<Block> ORANGE_TIBERCRETE_POWDER = registerBlock("orange_tibercrete_powder",
            () -> new ConcretePowderBlock(ORANGE_TIBERCRETE.get(),BlockBehaviour.Properties
                    .copy(Blocks.ORANGE_CONCRETE_POWDER)));

    public static final RegistryObject<Block> PINK_TIBERCRETE_POWDER = registerBlock("pink_tibercrete_powder",
            () -> new ConcretePowderBlock(PINK_TIBERCRETE.get(),BlockBehaviour.Properties
                    .copy(Blocks.PINK_CONCRETE_POWDER)));

    public static final RegistryObject<Block> PURPLE_TIBERCRETE_POWDER = registerBlock("purple_tibercrete_powder",
            () -> new ConcretePowderBlock(PURPLE_TIBERCRETE.get(),BlockBehaviour.Properties
                    .copy(Blocks.PURPLE_CONCRETE_POWDER)));

    public static final RegistryObject<Block> RED_TIBERCRETE_POWDER = registerBlock("red_tibercrete_powder",
            () -> new ConcretePowderBlock(RED_TIBERCRETE.get(),BlockBehaviour.Properties
                    .copy(Blocks.RED_CONCRETE_POWDER)));

    public static final RegistryObject<Block> WHITE_TIBERCRETE_POWDER = registerBlock("white_tibercrete_powder",
            () -> new ConcretePowderBlock(WHITE_TIBERCRETE.get(),BlockBehaviour.Properties
                    .copy(Blocks.WHITE_CONCRETE_POWDER)));

    public static final RegistryObject<Block> YELLOW_TIBERCRETE_POWDER = registerBlock("yellow_tibercrete_powder",
            () -> new ConcretePowderBlock(YELLOW_TIBERCRETE.get(),BlockBehaviour.Properties
                    .copy(Blocks.YELLOW_CONCRETE_POWDER)));

    public static final RegistryObject<Block> BLACK_TIBERCRETE_STAIRS = registerBlock("black_tibercrete_stairs",
            () -> new StairBlock(() -> ModBlocks.BLACK_TIBERCRETE.get().defaultBlockState(),
                    BlockBehaviour.Properties.copy(Blocks.BLACK_CONCRETE)));

    public static final RegistryObject<Block> BLUE_TIBERCRETE_STAIRS = registerBlock("blue_tibercrete_stairs",
            () -> new StairBlock(() -> ModBlocks.BLUE_TIBERCRETE.get().defaultBlockState(),
                    BlockBehaviour.Properties.copy(Blocks.BLUE_CONCRETE)));

    public static final RegistryObject<Block> BROWN_TIBERCRETE_STAIRS = registerBlock("brown_tibercrete_stairs",
            () -> new StairBlock(() -> ModBlocks.BROWN_TIBERCRETE.get().defaultBlockState(),
                    BlockBehaviour.Properties.copy(Blocks.BROWN_CONCRETE)));

    public static final RegistryObject<Block> CYAN_TIBERCRETE_STAIRS = registerBlock("cyan_tibercrete_stairs",
            () -> new StairBlock(() -> ModBlocks.CYAN_TIBERCRETE.get().defaultBlockState(),
                    BlockBehaviour.Properties.copy(Blocks.CYAN_CONCRETE)));

    public static final RegistryObject<Block> GRAY_TIBERCRETE_STAIRS = registerBlock("gray_tibercrete_stairs",
            () -> new StairBlock(() -> ModBlocks.GRAY_TIBERCRETE.get().defaultBlockState(),
                    BlockBehaviour.Properties.copy(Blocks.GRAY_CONCRETE)));

    public static final RegistryObject<Block> GREEN_TIBERCRETE_STAIRS = registerBlock("green_tibercrete_stairs",
            () -> new StairBlock(() -> ModBlocks.GREEN_TIBERCRETE.get().defaultBlockState(),
                    BlockBehaviour.Properties.copy(Blocks.GREEN_CONCRETE)));

    public static final RegistryObject<Block> LIGHT_BLUE_TIBERCRETE_STAIRS = registerBlock("light_blue_tibercrete_stairs",
            () -> new StairBlock(() -> ModBlocks.LIGHT_BLUE_TIBERCRETE.get().defaultBlockState(),
                    BlockBehaviour.Properties.copy(Blocks.LIGHT_BLUE_CONCRETE)));

    public static final RegistryObject<Block> LIGHT_GRAY_TIBERCRETE_STAIRS = registerBlock("light_gray_tibercrete_stairs",
            () -> new StairBlock(() -> ModBlocks.LIGHT_GRAY_TIBERCRETE.get().defaultBlockState(),
                    BlockBehaviour.Properties.copy(Blocks.LIGHT_GRAY_CONCRETE)));

    public static final RegistryObject<Block> LIME_TIBERCRETE_STAIRS = registerBlock("lime_tibercrete_stairs",
            () -> new StairBlock(() -> ModBlocks.LIME_TIBERCRETE.get().defaultBlockState(),
                    BlockBehaviour.Properties.copy(Blocks.LIME_CONCRETE)));

    public static final RegistryObject<Block> MAGENTA_TIBERCRETE_STAIRS = registerBlock("magenta_tibercrete_stairs",
            () -> new StairBlock(() -> ModBlocks.MAGENTA_TIBERCRETE.get().defaultBlockState(),
                    BlockBehaviour.Properties.copy(Blocks.MAGENTA_CONCRETE)));

    public static final RegistryObject<Block> ORANGE_TIBERCRETE_STAIRS = registerBlock("orange_tibercrete_stairs",
            () -> new StairBlock(() -> ModBlocks.ORANGE_TIBERCRETE.get().defaultBlockState(),
                    BlockBehaviour.Properties.copy(Blocks.ORANGE_CONCRETE)));

    public static final RegistryObject<Block> PINK_TIBERCRETE_STAIRS = registerBlock("pink_tibercrete_stairs",
            () -> new StairBlock(() -> ModBlocks.PINK_TIBERCRETE.get().defaultBlockState(),
                    BlockBehaviour.Properties.copy(Blocks.PINK_CONCRETE)));

    public static final RegistryObject<Block> PURPLE_TIBERCRETE_STAIRS = registerBlock("purple_tibercrete_stairs",
            () -> new StairBlock(() -> ModBlocks.PURPLE_TIBERCRETE.get().defaultBlockState(),
                    BlockBehaviour.Properties.copy(Blocks.PURPLE_CONCRETE)));

    public static final RegistryObject<Block> RED_TIBERCRETE_STAIRS = registerBlock("red_tibercrete_stairs",
            () -> new StairBlock(() -> ModBlocks.RED_TIBERCRETE.get().defaultBlockState(),
                    BlockBehaviour.Properties.copy(Blocks.RED_CONCRETE)));

    public static final RegistryObject<Block> WHITE_TIBERCRETE_STAIRS = registerBlock("white_tibercrete_stairs",
            () -> new StairBlock(() -> ModBlocks.WHITE_TIBERCRETE.get().defaultBlockState(),
                    BlockBehaviour.Properties.copy(Blocks.WHITE_CONCRETE)));

    public static final RegistryObject<Block> YELLOW_TIBERCRETE_STAIRS = registerBlock("yellow_tibercrete_stairs",
            () -> new StairBlock(() -> ModBlocks.YELLOW_TIBERCRETE.get().defaultBlockState(),
                    BlockBehaviour.Properties.copy(Blocks.YELLOW_CONCRETE)));

    public static final RegistryObject<Block> INFESTED_COBBLE_STAIRS = registerBlock("infested_cobble_stairs",
            () -> new StairBlock(() -> ModBlocks.INFESTED_COBBLE.get().defaultBlockState(),
                    BlockBehaviour.Properties.copy(Blocks.COBBLESTONE_STAIRS)));

    public static final RegistryObject<Block> INFESTED_COBBLE_SLAB = registerBlock("infested_cobble_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.copy(Blocks.COBBLESTONE_SLAB)));

    public static final RegistryObject<Block> INFESTED_STONE_BRICK_STAIRS = registerBlock("infested_stone_brick_stairs",
            () -> new StairBlock(() -> ModBlocks.INFESTED_STONE_BRICKS.get().defaultBlockState(),
                    BlockBehaviour.Properties.copy(Blocks.STONE_BRICK_STAIRS)));

    public static final RegistryObject<Block> INFESTED_STONE_BRICK_SLAB = registerBlock("infested_stone_brick_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.copy(Blocks.STONE_BRICK_SLAB)));

    public static final RegistryObject<Block> FIRESTONE_WALL = registerBlock("firestone_wall",
            () -> new FirestoneWallBlock(BlockBehaviour.Properties.copy(ModBlocks.FIRESTONE_BLOCK.get())));

    //End of Deco Blocks


    //Wood:

    public static final RegistryObject<Block> PLAGUED_PLANKS = registerBlock("plagued_planks",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS)));

    public static final RegistryObject<Block> PLAGUED_STAIRS = registerBlock("plagued_stairs",
            () -> new StairBlock(() -> ModBlocks.PLAGUED_PLANKS.get().defaultBlockState(),
                    BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS)));

    public static final RegistryObject<Block> PLAGUED_SLAB = registerBlock("plagued_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS)));

    public static final RegistryObject<Block> PLAGUED_BUTTON = registerBlock("plagued_button",
            () -> new ButtonBlock(BlockBehaviour.Properties.copy(Blocks.OAK_BUTTON),
                    BlockSetType.OAK, 20, true));

    public static final RegistryObject<Block> PLAGUED_PRESSURE_PLATE = registerBlock("plagued_pressure_plate",
            () -> new PressurePlateBlock(PressurePlateBlock.Sensitivity.EVERYTHING, BlockBehaviour
                    .Properties.copy(Blocks.OAK_PLANKS), BlockSetType.OAK));

    public static final RegistryObject<Block> PLAGUED_FENCE = registerBlock("plagued_fence",
            () -> new FenceBlock(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS)));

    public static final RegistryObject<Block> PLAGUED_FENCE_GATE = registerBlock("plagued_fence_gate",
            () -> new FenceGateBlock(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS),
                    SoundEvents.FENCE_GATE_OPEN, SoundEvents.FENCE_GATE_CLOSE));

    public static final RegistryObject<Block> PLAGUED_DOOR = registerBlock("plagued_door",
            () -> new DoorBlock(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS).noOcclusion(),
                    BlockSetType.OAK));

    public static final RegistryObject<Block> PLAGUED_TRAPDOOR = registerBlock("plagued_trapdoor",
            () -> new TrapDoorBlock(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS).noOcclusion(),
                    BlockSetType.OAK));

    //End of Wood


    //Glass:

    public static final RegistryObject<Block> CLEAR_TIBERGLASS = registerBlock("clear_tiberglass",
            () -> new GlassBlock(BlockBehaviour.Properties.copy(Blocks.GLASS).noOcclusion()));

    public static final RegistryObject<Block> MOSAIC_TIBERGLASS = registerBlock("mosaic_tiberglass",
            () -> new GlassBlock(BlockBehaviour.Properties.copy(Blocks.GLASS).noOcclusion()));

    public static final RegistryObject<Block> GDI_TIBERGLASS = registerBlock("gdi_tiberglass",
            () -> new GlassBlock(BlockBehaviour.Properties.copy(Blocks.GLASS).noOcclusion()));

    public static final RegistryObject<Block> NOD_TIBERGLASS = registerBlock("nod_tiberglass",
            () -> new GlassBlock(BlockBehaviour.Properties.copy(Blocks.GLASS).noOcclusion()));

    public static final RegistryObject<Block> WOLF_TIBERGLASS = registerBlock("wolf_tiberglass",
            () -> new GlassBlock(BlockBehaviour.Properties.copy(Blocks.GLASS).noOcclusion()));

    public static final RegistryObject<Block> BLACK_TIBERGLASS = registerBlock("black_tiberglass",
            () -> new StainedGlassBlock(DyeColor.BLACK,BlockBehaviour.Properties.copy(Blocks.BLACK_STAINED_GLASS)
                    .noOcclusion()));

    public static final RegistryObject<Block> BLUE_TIBERGLASS = registerBlock("blue_tiberglass",
            () -> new StainedGlassBlock(DyeColor.BLUE,BlockBehaviour.Properties.copy(Blocks.BLUE_STAINED_GLASS)
                    .noOcclusion()));

    public static final RegistryObject<Block> BROWN_TIBERGLASS = registerBlock("brown_tiberglass",
            () -> new StainedGlassBlock(DyeColor.BROWN,BlockBehaviour.Properties.copy(Blocks.BROWN_STAINED_GLASS)
                    .noOcclusion()));

    public static final RegistryObject<Block> CYAN_TIBERGLASS = registerBlock("cyan_tiberglass",
            () -> new StainedGlassBlock(DyeColor.CYAN,BlockBehaviour.Properties.copy(Blocks.CYAN_STAINED_GLASS)));

    public static final RegistryObject<Block> GRAY_TIBERGLASS = registerBlock("gray_tiberglass",
            () -> new StainedGlassBlock(DyeColor.GRAY,BlockBehaviour.Properties.copy(Blocks.GRAY_STAINED_GLASS)
                    .noOcclusion()));

    public static final RegistryObject<Block> GREEN_TIBERGLASS = registerBlock("green_tiberglass",
            () -> new StainedGlassBlock(DyeColor.GREEN,BlockBehaviour.Properties.copy(Blocks.GREEN_STAINED_GLASS)
                    .noOcclusion()));

    public static final RegistryObject<Block> LIGHT_BLUE_TIBERGLASS = registerBlock("light_blue_tiberglass",
            () -> new StainedGlassBlock(DyeColor.LIGHT_BLUE,BlockBehaviour.Properties.copy(Blocks.LIGHT_BLUE_STAINED_GLASS)
                    .noOcclusion()));

    public static final RegistryObject<Block> LIGHT_GRAY_TIBERGLASS = registerBlock("light_gray_tiberglass",
            () -> new StainedGlassBlock(DyeColor.LIGHT_GRAY,BlockBehaviour.Properties.copy(Blocks.LIGHT_GRAY_STAINED_GLASS)
                    .noOcclusion()));

    public static final RegistryObject<Block> LIME_TIBERGLASS = registerBlock("lime_tiberglass",
            () -> new StainedGlassBlock(DyeColor.LIME,BlockBehaviour.Properties.copy(Blocks.LIME_STAINED_GLASS)
                    .noOcclusion()));

    public static final RegistryObject<Block> MAGENTA_TIBERGLASS = registerBlock("magenta_tiberglass",
            () -> new StainedGlassBlock(DyeColor.MAGENTA,BlockBehaviour.Properties.copy(Blocks.MAGENTA_STAINED_GLASS)
                    .noOcclusion()));

    public static final RegistryObject<Block> ORANGE_TIBERGLASS = registerBlock("orange_tiberglass",
            () -> new StainedGlassBlock(DyeColor.ORANGE,BlockBehaviour.Properties.copy(Blocks.ORANGE_STAINED_GLASS)
                    .noOcclusion()));

    public static final RegistryObject<Block> PINK_TIBERGLASS = registerBlock("pink_tiberglass",
            () -> new StainedGlassBlock(DyeColor.PINK,BlockBehaviour.Properties.copy(Blocks.PINK_STAINED_GLASS)
                    .noOcclusion()));

    public static final RegistryObject<Block> PURPLE_TIBERGLASS = registerBlock("purple_tiberglass",
            () -> new StainedGlassBlock(DyeColor.PURPLE,BlockBehaviour.Properties.copy(Blocks.PURPLE_STAINED_GLASS)
                    .noOcclusion()));

    public static final RegistryObject<Block> RED_TIBERGLASS = registerBlock("red_tiberglass",
            () -> new StainedGlassBlock(DyeColor.RED,BlockBehaviour.Properties.copy(Blocks.RED_STAINED_GLASS)
                    .noOcclusion()));

    public static final RegistryObject<Block> WHITE_TIBERGLASS = registerBlock("white_tiberglass",
            () -> new StainedGlassBlock(DyeColor.WHITE,BlockBehaviour.Properties.copy(Blocks.WHITE_STAINED_GLASS)
                    .noOcclusion()));

    public static final RegistryObject<Block> YELLOW_TIBERGLASS = registerBlock("yellow_tiberglass",
            () -> new StainedGlassBlock(DyeColor.YELLOW,BlockBehaviour.Properties.copy(Blocks.YELLOW_STAINED_GLASS)
                    .noOcclusion()));

    public static final RegistryObject<Block> CLEAR_TIBERGLASS_PANE = registerBlock("clear_tiberglass_pane",
            () -> new IronBarsBlock(BlockBehaviour.Properties.copy(Blocks.GLASS_PANE).noOcclusion()));

    public static final RegistryObject<Block> MOSAIC_TIBERGLASS_PANE = registerBlock("mosaic_tiberglass_pane",
            () -> new IronBarsBlock(BlockBehaviour.Properties.copy(Blocks.GLASS_PANE).noOcclusion()));

    public static final RegistryObject<Block> GDI_TIBERGLASS_PANE = registerBlock("gdi_tiberglass_pane",
            () -> new IronBarsBlock(BlockBehaviour.Properties.copy(Blocks.GLASS_PANE).noOcclusion()));

    public static final RegistryObject<Block> NOD_TIBERGLASS_PANE = registerBlock("nod_tiberglass_pane",
            () -> new IronBarsBlock(BlockBehaviour.Properties.copy(Blocks.GLASS_PANE).noOcclusion()));

    public static final RegistryObject<Block> WOLF_TIBERGLASS_PANE = registerBlock("wolf_tiberglass_pane",
            () -> new IronBarsBlock(BlockBehaviour.Properties.copy(Blocks.GLASS_PANE).noOcclusion()));

    public static final RegistryObject<Block> BLACK_TIBERGLASS_PANE = registerBlock("black_tiberglass_pane",
            () -> new StainedGlassPaneBlock(DyeColor.BLACK ,BlockBehaviour.Properties.copy(Blocks.BLACK_STAINED_GLASS_PANE)
                    .noOcclusion()));

    public static final RegistryObject<Block> BLUE_TIBERGLASS_PANE = registerBlock("blue_tiberglass_pane",
            () -> new StainedGlassPaneBlock(DyeColor.BLUE ,BlockBehaviour.Properties.copy(Blocks.BLUE_STAINED_GLASS_PANE)
                    .noOcclusion()));

    public static final RegistryObject<Block> BROWN_TIBERGLASS_PANE = registerBlock("brown_tiberglass_pane",
            () -> new StainedGlassPaneBlock(DyeColor.BROWN ,BlockBehaviour.Properties.copy(Blocks.BROWN_STAINED_GLASS_PANE)
                    .noOcclusion()));

    public static final RegistryObject<Block> CYAN_TIBERGLASS_PANE = registerBlock("cyan_tiberglass_pane",
            () -> new StainedGlassPaneBlock(DyeColor.CYAN ,BlockBehaviour.Properties.copy(Blocks.CYAN_STAINED_GLASS_PANE)
                    .noOcclusion()));

    public static final RegistryObject<Block> GRAY_TIBERGLASS_PANE = registerBlock("gray_tiberglass_pane",
            () -> new StainedGlassPaneBlock(DyeColor.GRAY ,BlockBehaviour.Properties.copy(Blocks.GRAY_STAINED_GLASS_PANE)
                    .noOcclusion()));

    public static final RegistryObject<Block> GREEN_TIBERGLASS_PANE = registerBlock("green_tiberglass_pane",
            () -> new StainedGlassPaneBlock(DyeColor.GREEN ,BlockBehaviour.Properties.copy(Blocks.GREEN_STAINED_GLASS_PANE)
                    .noOcclusion()));

    public static final RegistryObject<Block> LIGHT_BLUE_TIBERGLASS_PANE = registerBlock("light_blue_tiberglass_pane",
            () -> new StainedGlassPaneBlock(DyeColor.LIGHT_BLUE ,BlockBehaviour.Properties.copy(Blocks.LIGHT_BLUE_STAINED_GLASS_PANE)
                    .noOcclusion()));

    public static final RegistryObject<Block> LIGHT_GRAY_TIBERGLASS_PANE = registerBlock("light_gray_tiberglass_pane",
            () -> new StainedGlassPaneBlock(DyeColor.LIGHT_GRAY ,BlockBehaviour.Properties.copy(Blocks.LIGHT_GRAY_STAINED_GLASS_PANE)
                    .noOcclusion()));

    public static final RegistryObject<Block> LIME_TIBERGLASS_PANE = registerBlock("lime_tiberglass_pane",
            () -> new StainedGlassPaneBlock(DyeColor.LIME ,BlockBehaviour.Properties.copy(Blocks.LIME_STAINED_GLASS_PANE)
                    .noOcclusion()));

    public static final RegistryObject<Block> MAGENTA_TIBERGLASS_PANE = registerBlock("magenta_tiberglass_pane",
            () -> new StainedGlassPaneBlock(DyeColor.MAGENTA ,BlockBehaviour.Properties.copy(Blocks.MAGENTA_STAINED_GLASS_PANE)
                    .noOcclusion()));

    public static final RegistryObject<Block> ORANGE_TIBERGLASS_PANE = registerBlock("orange_tiberglass_pane",
            () -> new StainedGlassPaneBlock(DyeColor.ORANGE ,BlockBehaviour.Properties.copy(Blocks.ORANGE_STAINED_GLASS_PANE)
                    .noOcclusion()));

    public static final RegistryObject<Block> PINK_TIBERGLASS_PANE = registerBlock("pink_tiberglass_pane",
            () -> new StainedGlassPaneBlock(DyeColor.PINK ,BlockBehaviour.Properties.copy(Blocks.PINK_STAINED_GLASS_PANE)
                    .noOcclusion()));

    public static final RegistryObject<Block> PURPLE_TIBERGLASS_PANE = registerBlock("purple_tiberglass_pane",
            () -> new StainedGlassPaneBlock(DyeColor.PURPLE ,BlockBehaviour.Properties.copy(Blocks.PURPLE_STAINED_GLASS_PANE)
                    .noOcclusion()));

    public static final RegistryObject<Block> RED_TIBERGLASS_PANE = registerBlock("red_tiberglass_pane",
            () -> new StainedGlassPaneBlock(DyeColor.RED ,BlockBehaviour.Properties.copy(Blocks.RED_STAINED_GLASS_PANE)
                    .noOcclusion()));

    public static final RegistryObject<Block> WHITE_TIBERGLASS_PANE = registerBlock("white_tiberglass_pane",
            () -> new StainedGlassPaneBlock(DyeColor.WHITE ,BlockBehaviour.Properties.copy(Blocks.WHITE_STAINED_GLASS_PANE)
                    .noOcclusion()));

    public static final RegistryObject<Block> YELLOW_TIBERGLASS_PANE = registerBlock("yellow_tiberglass_pane",
            () -> new StainedGlassPaneBlock(DyeColor.YELLOW ,BlockBehaviour.Properties.copy(Blocks.YELLOW_STAINED_GLASS_PANE)
                    .noOcclusion()));

    //End of Glass

    //Plants
    public static final RegistryObject<Block> YOKARAN_BLOOM = registerBlock("yokaran_bloom",
            () -> new YokaranBloomBlock(BlockBehaviour.Properties.copy(Blocks.LILAC)
                    .noOcclusion().noCollission()));

    public static final RegistryObject<Block> DEVILS_BLOOD = registerBlock("devils_blood",
            () -> new DevilsBloodBlock(MobEffects.BLINDNESS, 5, BlockBehaviour.Properties
                    .copy(Blocks.ALLIUM).noOcclusion().noCollission()));

    public static final RegistryObject<Block> POTTED_DEVILS_BLOOD = BLOCKS.register("potted_devils_blood",
            () -> new FlowerPotBlock(() -> ((FlowerPotBlock) Blocks.FLOWER_POT), ModBlocks.DEVILS_BLOOD,
                    BlockBehaviour.Properties.copy(Blocks.POTTED_ALLIUM).noOcclusion()));

    public static final RegistryObject<Block> FLOWER_OF_LIFE = registerBlock("flower_of_life",
            () -> new FlowerofLifeBlock(MobEffects.CONFUSION, 5, BlockBehaviour.Properties
                    .copy(Blocks.ALLIUM).noOcclusion().noCollission()));

    public static final RegistryObject<Block> POTTED_FLOWER_OF_LIFE = BLOCKS.register("potted_flower_of_life",
            () -> new FlowerPotBlock(() -> ((FlowerPotBlock) Blocks.FLOWER_POT), ModBlocks.FLOWER_OF_LIFE,
                    BlockBehaviour.Properties.copy(Blocks.POTTED_ALLIUM).noOcclusion()));

    public static final RegistryObject<Block> HYACINTH = registerBlock("hyacinth",
            () -> new FlowerBlock(() -> MobEffects.LUCK, 5, BlockBehaviour.Properties
                    .copy(Blocks.ALLIUM).noOcclusion().noCollission()));

    public static final RegistryObject<Block> POTTED_HYACINTH = BLOCKS.register("potted_hyacinth",
            () -> new FlowerPotBlock(() -> ((FlowerPotBlock) Blocks.FLOWER_POT), ModBlocks.DEVILS_BLOOD,
                    BlockBehaviour.Properties.copy(Blocks.POTTED_ALLIUM).noOcclusion()));


    public static final RegistryObject<Block> STRAWBERRY_CROP = BLOCKS.register("strawberry_crop",
            () -> new StrawberryCropBlock(BlockBehaviour.Properties.copy(Blocks.WHEAT)
                    .noOcclusion().noCollission()));

    public static final RegistryObject<Block> CORN_CROP = BLOCKS.register("corn_crop",
            () -> new CornCropBlock(BlockBehaviour.Properties.copy(Blocks.WHEAT)
                    .noOcclusion().noCollission()));
    //End of Plants


    //Tiberium
    public static final RegistryObject<Block> GREEN_TIBERIUM_CROP = BLOCKS.register("green_tiberium_crop",
            () -> new GreenTiberiumCrystalBlock(BlockBehaviour.Properties.copy(Blocks.AMETHYST_BLOCK).lightLevel(tiberiumglow)
                    .noOcclusion().noCollission()));

    public static final RegistryObject<Block> BLUE_TIBERIUM_CROP = BLOCKS.register("blue_tiberium_crop",
            () -> new BlueTiberiumCrystalBlock(BlockBehaviour.Properties.copy(Blocks.AMETHYST_BLOCK).lightLevel(tiberiumglow)
                    .noOcclusion().noCollission()));

    public static final RegistryObject<Block> RED_TIBERIUM_CROP = BLOCKS.register("red_tiberium_crop",
            () -> new RedTiberiumCrystalBlock(BlockBehaviour.Properties.copy(Blocks.AMETHYST_BLOCK).lightLevel(tiberiumglow)
                    .noOcclusion().noCollission()));

    public static final RegistryObject<Block> PURPLE_TIBERIUM_CROP = BLOCKS.register("purple_tiberium_crop",
            () -> new PurpleTiberiumCrystalBlock(BlockBehaviour.Properties.copy(Blocks.AMETHYST_BLOCK).lightLevel(tiberiumglow)
                    .noOcclusion().noCollission()));

    public static final RegistryObject<LiquidBlock> TIBERIUM_WATER_BLOCK = BLOCKS.register("tiberium_water_block",
            () -> new LiquidBlock(ModFluids.SOURCE_TIBERIUM_WATER, BlockBehaviour.Properties.copy(Blocks.WATER).noLootTable()));

    public static final RegistryObject<LiquidBlock> MOLTEN_TIBERIUM_BLOCK = BLOCKS.register("molten_tiberium_block",
            () -> new MoltenTiberiumBlock(ModFluids.SOURCE_MOLTEN_TIBERIUM, BlockBehaviour.Properties.copy(Blocks.LAVA)
                    .randomTicks().noLootTable(), 5, 0.5f));

    public static final RegistryObject<LiquidBlock> MOLTEN_BLUE_TIBERIUM_BLOCK = BLOCKS.register("molten_blue_tiberium_block",
            () -> new MoltenTiberiumBlock(ModFluids.SOURCE_MOLTEN_BLUE_TIBERIUM, BlockBehaviour.Properties.copy(Blocks.LAVA)
                    .randomTicks().noLootTable(), 5, 0.5f));

    public static final RegistryObject<LiquidBlock> MOLTEN_RED_TIBERIUM_BLOCK = BLOCKS.register("molten_red_tiberium_block",
            () -> new MoltenTiberiumBlock(ModFluids.SOURCE_MOLTEN_RED_TIBERIUM, BlockBehaviour.Properties.copy(Blocks.LAVA)
                    .randomTicks().noLootTable(), 5, 0.5f));

    public static final RegistryObject<LiquidBlock> MOLTEN_PURPLE_TIBERIUM_BLOCK = BLOCKS.register("molten_purple_tiberium_block",
            () -> new MoltenTiberiumBlock(ModFluids.SOURCE_MOLTEN_PURPLE_TIBERIUM, BlockBehaviour.Properties.copy(Blocks.LAVA)
                    .randomTicks().noLootTable(), 5, 0.5f));

    //End of Tiberium


    //Block Entities
    public static final RegistryObject<Block> TIBERIUM_GRINDER = registerBlock("tiberium_grinder",
            () -> new TiberiumGrinderBlock(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).noOcclusion()));

    //End of Block Entities


    //Blossom Tree
    public static final RegistryObject<Block> BLOSSOM_SPOUT = registerBlock("blossom_spout",
            () -> new BlossomTreeSpoutBlock(BlockBehaviour.Properties.copy(Blocks.BEDROCK).noLootTable()
                    .randomTicks()));
    //End Blossom Tree




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
