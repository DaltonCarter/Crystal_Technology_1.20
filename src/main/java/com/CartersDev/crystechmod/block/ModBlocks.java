package com.CartersDev.crystechmod.block;

import com.CartersDev.crystechmod.CrystalTech;
import com.CartersDev.crystechmod.block.custom.*;
import com.CartersDev.crystechmod.block.custom.terrainBlocks.VitricSandBlock;
import com.CartersDev.crystechmod.fluid.ModFluids;
import com.CartersDev.crystechmod.item.ModItems;
import com.CartersDev.crystechmod.sound.ModSounds;
import com.CartersDev.crystechmod.util.ModWoodTypes;
import com.CartersDev.crystechmod.worldgen.tree.DeadTreeGrower;
import com.CartersDev.crystechmod.worldgen.tree.EmberTreeGrower;
import com.CartersDev.crystechmod.worldgen.tree.MarikaTreeGrower;
import com.CartersDev.crystechmod.worldgen.tree.PlaguedTreeGrower;
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
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.material.PushReaction;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;
import java.util.function.ToIntFunction;

public class ModBlocks {

    public static ToIntFunction<BlockState> tiberiumglow = BlockState -> 7;
    public static ToIntFunction<BlockState> blossomglow = BlockState -> 12;
    public static ToIntFunction<BlockState> marikaglow = BlockState -> 15;

    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, CrystalTech.MOD_ID);

    public static final RegistryObject<Block> TEST_BLOCK = registerBlock("test_block",
            () -> new GlassBlock(BlockBehaviour.Properties.copy(Blocks.GLASS).noOcclusion()));

//    public static final RegistryObject<Block> DOOR_CON = registerBlock("door_con",
//            () -> new DoorControllerBlock(BlockBehaviour.Properties.copy(Blocks.LEVER).noOcclusion()));

    public static final RegistryObject<Block> SOUND_BLOCK = registerBlock("sound_block",
            () -> new SoundBlock(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).sound(ModSounds.SOUND_BLOCK_SOUNDS)));

    public static final RegistryObject<Block> FOOLS_VITRICIUM = registerBlock("fools_vitricium",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.AMETHYST_BLOCK).sound(SoundType.AMETHYST)));

    public static final RegistryObject<Block> FOOLS_CRYSTAL_CORE = registerBlock("fools_crystal_core",
            () -> new TempPortalBlock(BlockBehaviour.Properties.copy(Blocks.AMETHYST_BLOCK).noOcclusion().sound(SoundType.AMETHYST).lightLevel(tiberiumglow)));

    //Terrain Blocks:
        //Natural Terrain Blocks:
    public static final RegistryObject<Block> TIBERIUM_SOIL = registerBlock("tiberium_soil",
            () -> new TiberiumSoilBlock(BlockBehaviour.Properties.copy(Blocks.DIRT)
                    .strength(3f, 1200f).randomTicks()));

    public static final RegistryObject<Block> ICHOR_SOIL = registerBlock("ichor_soil",
            () -> new IchorSoilBlock(BlockBehaviour.Properties.copy(Blocks.DIRT)
                    .strength(3f, 1200f).randomTicks()));

    public static final RegistryObject<Block> INERT_VITRIC_SOIL = registerBlock("inert_vitric_soil",
            () -> new InertVitricSoilBlock(BlockBehaviour.Properties.copy(Blocks.STONE)
                    .strength(3f, 1200f).randomTicks()));

    public static final RegistryObject<Block> INERT_ICHOR_SOIL = registerBlock("inert_ichor_soil",
            () -> new InertIchorSoilBlock(BlockBehaviour.Properties.copy(Blocks.STONE)
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
            () -> new VitricSandBlock(24815329, BlockBehaviour.Properties.copy(Blocks.SAND)));

    public static final RegistryObject<Block> RED_ZONE_SAND = registerBlock("red_zone_sand",
            () -> new VitricSandBlock(414141, BlockBehaviour.Properties.copy(Blocks.SAND)));

    public static final RegistryObject<Block> SEEDED_DIRT = registerBlock("seeded_dirt",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.DIRT)));

        //Tiberium terrain blocks:

    public static final RegistryObject<Block> RIPARIUS_STONE = registerBlock("riparius_stone",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.STONE)));

    public static final RegistryObject<Block> VINIFERA_STONE = registerBlock("vinifera_stone",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.STONE)));

    public static final RegistryObject<Block> CRUENTUS_STONE = registerBlock("cruentus_stone",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.STONE)));

    public static final RegistryObject<Block> ABOREUS_STONE = registerBlock("aboreus_stone",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.STONE)));

    public static final RegistryObject<Block> RIPARIUS_CRYSTAL = registerBlock("riparius_crystal",
            () -> new TiberiumCrystalBlock(BlockBehaviour.Properties.copy(Blocks.OBSIDIAN).sound(SoundType.AMETHYST)
                    .noOcclusion().lightLevel(tiberiumglow)));

    public static final RegistryObject<Block> VINIFERA_CRYSTAL = registerBlock("vinifera_crystal",
            () -> new TiberiumCrystalBlock(BlockBehaviour.Properties.copy(Blocks.OBSIDIAN).sound(SoundType.AMETHYST)
                    .noOcclusion().lightLevel(tiberiumglow)));

    public static final RegistryObject<Block> CRUENTUS_CRYSTAL = registerBlock("cruentus_crystal",
            () -> new TiberiumCrystalBlock(BlockBehaviour.Properties.copy(Blocks.OBSIDIAN).sound(SoundType.AMETHYST)
                    .noOcclusion().lightLevel(tiberiumglow)));

    public static final RegistryObject<Block> ABOREUS_CRYSTAL = registerBlock("aboreus_crystal",
            () -> new TiberiumCrystalBlock(BlockBehaviour.Properties.copy(Blocks.OBSIDIAN).sound(SoundType.AMETHYST)
                    .noOcclusion().lightLevel(tiberiumglow)));

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

    public static final RegistryObject<Block> PROTO_STEEL_BLOCK = registerBlock("proto_steel_block",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK)
                    .explosionResistance(100.0f)));

    public static final RegistryObject<Block> IRON_PLATING = registerBlock("iron_plating",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK)
                    ));

    public static final RegistryObject<Block> RUSTY_IRON_PLATING = registerBlock("rusty_iron_plating",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK)));

    public static final RegistryObject<Block> VITRIC_IRON_PLATING = registerBlock("vitric_iron_plating",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK)));

    public static final RegistryObject<Block> POLISHED_IRON_BLOCK = registerBlock("polished_iron_block",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK)));

    public static final RegistryObject<Block> HARMONIUM_BLOCK = registerBlock("harmonium_block",
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


    public static final RegistryObject<Block> PURPLE_CORE_BLOCK = registerBlock("purple_core_block",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).sound(SoundType.AMETHYST)));

    public static final RegistryObject<Block> YELLOW_CORE_BLOCK = registerBlock("yellow_core_block",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).sound(SoundType.AMETHYST)));

    public static final RegistryObject<Block> ORANGE_CORE_BLOCK = registerBlock("orange_core_block",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).sound(SoundType.AMETHYST)));

    public static final RegistryObject<Block> BLUE_CORE_BLOCK = registerBlock("blue_core_block",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).sound(SoundType.AMETHYST)));

    public static final RegistryObject<Block> GREEN_CORE_BLOCK = registerBlock("green_core_block",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).sound(SoundType.AMETHYST)));

    public static final RegistryObject<Block> RED_CORE_BLOCK = registerBlock("red_core_block",
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




    public static final RegistryObject<Block> HARMONIUM_ORE = registerBlock("harmonium_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.STONE)
                    .strength(2f).requiresCorrectToolForDrops(), UniformInt.of(3, 6)));

    public static final RegistryObject<Block> DEEPSLATE_HARMONIUM_ORE = registerBlock("deepslate_harmonium_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.DEEPSLATE)
                    .strength(3f).requiresCorrectToolForDrops(), UniformInt.of(3, 6)));

    public static final RegistryObject<Block> NETHER_HARMONIUM_ORE = registerBlock("nether_harmonium_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.NETHERRACK)
                    .strength(2f).requiresCorrectToolForDrops(), UniformInt.of(3, 6)));

    public static final RegistryObject<Block> END_HARMONIUM_ORE = registerBlock("end_harmonium_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.END_STONE)
                    .strength(3f).requiresCorrectToolForDrops(), UniformInt.of(3, 6)));
    //End Ores


    //Deco Blocks:

    public static final RegistryObject<Block> NOD_CREST_LARGE = registerBlock("nod_crest_large",
            () -> new NodLogoLargeBlock(BlockBehaviour.Properties.copy(Blocks.STONE)));

    public static final RegistryObject<Block> FIRESTONE_WALL = registerBlock("firestone_wall",
            () -> new FirestoneWallBlock(BlockBehaviour.Properties.copy(ModBlocks.FIRESTONE_BLOCK.get())));

        //Tibercrete:
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

    public static final RegistryObject<Block> PROTO_STEEL_STAIRS = registerBlock("proto_steel_stairs",
            () -> new StairBlock(() -> ModBlocks.PROTO_STEEL_BLOCK.get().defaultBlockState(),
                    BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK)));

    public static final RegistryObject<Block> IRON_PLATING_STAIRS = registerBlock("iron_plating_stairs",
            () -> new StairBlock(() -> ModBlocks.IRON_PLATING.get().defaultBlockState(),
                    BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK)));

    public static final RegistryObject<Block> RUSTY_IRON_PLATING_STAIRS = registerBlock("rusty_iron_plating_stairs",
            () -> new StairBlock(() -> ModBlocks.RUSTY_IRON_PLATING.get().defaultBlockState(),
                    BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK)));

    public static final RegistryObject<Block> VITRIC_IRON_PLATING_STAIRS = registerBlock("vitric_iron_plating_stairs",
            () -> new StairBlock(() -> ModBlocks.VITRIC_IRON_PLATING.get().defaultBlockState(),
                    BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK)));

    public static final RegistryObject<Block> POLISHED_IRON_STAIRS = registerBlock("polished_iron_stairs",
            () -> new StairBlock(() -> ModBlocks.POLISHED_IRON_BLOCK.get().defaultBlockState(),
                    BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK)));

    public static final RegistryObject<Block> BLACK_TIBERCRETE_SLAB = registerBlock("black_tibercrete_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.copy(Blocks.STONE_BRICK_SLAB)));

    public static final RegistryObject<Block> BLUE_TIBERCRETE_SLAB = registerBlock("blue_tibercrete_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.copy(Blocks.STONE_BRICK_SLAB)));

    public static final RegistryObject<Block> BROWN_TIBERCRETE_SLAB = registerBlock("brown_tibercrete_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.copy(Blocks.STONE_BRICK_SLAB)));

    public static final RegistryObject<Block> CYAN_TIBERCRETE_SLAB = registerBlock("cyan_tibercrete_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.copy(Blocks.STONE_BRICK_SLAB)));

    public static final RegistryObject<Block> GRAY_TIBERCRETE_SLAB = registerBlock("gray_tibercrete_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.copy(Blocks.STONE_BRICK_SLAB)));

    public static final RegistryObject<Block> GREEN_TIBERCRETE_SLAB = registerBlock("green_tibercrete_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.copy(Blocks.STONE_BRICK_SLAB)));

    public static final RegistryObject<Block> LIGHT_BLUE_TIBERCRETE_SLAB = registerBlock("light_blue_tibercrete_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.copy(Blocks.STONE_BRICK_SLAB)));

    public static final RegistryObject<Block> LIGHT_GRAY_TIBERCRETE_SLAB = registerBlock("light_gray_tibercrete_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.copy(Blocks.STONE_BRICK_SLAB)));

    public static final RegistryObject<Block> LIME_TIBERCRETE_SLAB = registerBlock("lime_tibercrete_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.copy(Blocks.STONE_BRICK_SLAB)));

    public static final RegistryObject<Block> MAGENTA_TIBERCRETE_SLAB = registerBlock("magenta_tibercrete_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.copy(Blocks.STONE_BRICK_SLAB)));

    public static final RegistryObject<Block> ORANGE_TIBERCRETE_SLAB = registerBlock("orange_tibercrete_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.copy(Blocks.STONE_BRICK_SLAB)));

    public static final RegistryObject<Block> PINK_TIBERCRETE_SLAB = registerBlock("pink_tibercrete_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.copy(Blocks.STONE_BRICK_SLAB)));

    public static final RegistryObject<Block> PURPLE_TIBERCRETE_SLAB = registerBlock("purple_tibercrete_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.copy(Blocks.STONE_BRICK_SLAB)));

    public static final RegistryObject<Block> RED_TIBERCRETE_SLAB = registerBlock("red_tibercrete_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.copy(Blocks.STONE_BRICK_SLAB)));

    public static final RegistryObject<Block> WHITE_TIBERCRETE_SLAB = registerBlock("white_tibercrete_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.copy(Blocks.STONE_BRICK_SLAB)));

    public static final RegistryObject<Block> YELLOW_TIBERCRETE_SLAB = registerBlock("yellow_tibercrete_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.copy(Blocks.STONE_BRICK_SLAB)));

    public static final RegistryObject<Block> PROTO_STEEL_SLAB = registerBlock("proto_steel_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK)));

    public static final RegistryObject<Block> IRON_PLATING_SLAB = registerBlock("iron_plating_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK)));

    public static final RegistryObject<Block> RUSTY_IRON_PLATING_SLAB = registerBlock("rusty_iron_plating_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK)));

    public static final RegistryObject<Block> VITRIC_IRON_PLATING_SLAB = registerBlock("vitric_iron_plating_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK)));

    public static final RegistryObject<Block> POLISHED_IRON_SLAB = registerBlock("polished_iron_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK)));

    public static final RegistryObject<Block> BLACK_TIBERCRETE_BRICKS = registerBlock("black_tibercrete_bricks",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.BLACK_CONCRETE)));

    public static final RegistryObject<Block> BLUE_TIBERCRETE_BRICKS = registerBlock("blue_tibercrete_bricks",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.BLUE_CONCRETE)));

    public static final RegistryObject<Block> BROWN_TIBERCRETE_BRICKS = registerBlock("brown_tibercrete_bricks",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.BROWN_CONCRETE)));

    public static final RegistryObject<Block> CYAN_TIBERCRETE_BRICKS = registerBlock("cyan_tibercrete_bricks",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.CYAN_CONCRETE)));

    public static final RegistryObject<Block> GRAY_TIBERCRETE_BRICKS = registerBlock("gray_tibercrete_bricks",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.GRAY_CONCRETE)));

    public static final RegistryObject<Block> GREEN_TIBERCRETE_BRICKS = registerBlock("green_tibercrete_bricks",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.GREEN_CONCRETE)));

    public static final RegistryObject<Block> LIGHT_BLUE_TIBERCRETE_BRICKS = registerBlock("light_blue_tibercrete_bricks",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.LIGHT_BLUE_CONCRETE)));

    public static final RegistryObject<Block> LIGHT_GRAY_TIBERCRETE_BRICKS = registerBlock("light_gray_tibercrete_bricks",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.LIGHT_GRAY_CONCRETE)));

    public static final RegistryObject<Block> LIME_TIBERCRETE_BRICKS = registerBlock("lime_tibercrete_bricks",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.LIME_CONCRETE)));

    public static final RegistryObject<Block> MAGENTA_TIBERCRETE_BRICKS = registerBlock("magenta_tibercrete_bricks",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.MAGENTA_CONCRETE)));

    public static final RegistryObject<Block> ORANGE_TIBERCRETE_BRICKS = registerBlock("orange_tibercrete_bricks",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.ORANGE_CONCRETE)));

    public static final RegistryObject<Block> PINK_TIBERCRETE_BRICKS = registerBlock("pink_tibercrete_bricks",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.PINK_CONCRETE)));

    public static final RegistryObject<Block> PURPLE_TIBERCRETE_BRICKS = registerBlock("purple_tibercrete_bricks",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.PURPLE_CONCRETE)));

    public static final RegistryObject<Block> RED_TIBERCRETE_BRICKS = registerBlock("red_tibercrete_bricks",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.RED_CONCRETE)));

    public static final RegistryObject<Block> WHITE_TIBERCRETE_BRICKS = registerBlock("white_tibercrete_bricks",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.WHITE_CONCRETE)));

    public static final RegistryObject<Block> YELLOW_TIBERCRETE_BRICKS = registerBlock("yellow_tibercrete_bricks",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.YELLOW_CONCRETE)));

    public static final RegistryObject<Block> BLACK_TIBERCRETE_WALL = registerBlock("black_tibercrete_wall",
            () -> new WallBlock(BlockBehaviour.Properties.copy(ModBlocks.BLACK_TIBERCRETE.get())));

    public static final RegistryObject<Block> BLUE_TIBERCRETE_WALL = registerBlock("blue_tibercrete_wall",
            () -> new WallBlock(BlockBehaviour.Properties.copy(ModBlocks.BLUE_TIBERCRETE.get())));

    public static final RegistryObject<Block> BROWN_TIBERCRETE_WALL = registerBlock("brown_tibercrete_wall",
            () -> new WallBlock(BlockBehaviour.Properties.copy(ModBlocks.BROWN_TIBERCRETE.get())));

    public static final RegistryObject<Block> CYAN_TIBERCRETE_WALL = registerBlock("cyan_tibercrete_wall",
            () -> new WallBlock(BlockBehaviour.Properties.copy(ModBlocks.CYAN_TIBERCRETE.get())));

    public static final RegistryObject<Block> GRAY_TIBERCRETE_WALL = registerBlock("gray_tibercrete_wall",
            () -> new WallBlock(BlockBehaviour.Properties.copy(ModBlocks.GRAY_TIBERCRETE.get())));

    public static final RegistryObject<Block> GREEN_TIBERCRETE_WALL = registerBlock("green_tibercrete_wall",
            () -> new WallBlock(BlockBehaviour.Properties.copy(ModBlocks.GREEN_TIBERCRETE.get())));

    public static final RegistryObject<Block> LIGHT_BLUE_TIBERCRETE_WALL = registerBlock("light_blue_tibercrete_wall",
            () -> new WallBlock(BlockBehaviour.Properties.copy(ModBlocks.LIGHT_BLUE_TIBERCRETE.get())));

    public static final RegistryObject<Block> LIGHT_GRAY_TIBERCRETE_WALL = registerBlock("light_gray_tibercrete_wall",
            () -> new WallBlock(BlockBehaviour.Properties.copy(ModBlocks.LIGHT_GRAY_TIBERCRETE.get())));

    public static final RegistryObject<Block> LIME_TIBERCRETE_WALL = registerBlock("lime_tibercrete_wall",
            () -> new WallBlock(BlockBehaviour.Properties.copy(ModBlocks.LIME_TIBERCRETE.get())));

    public static final RegistryObject<Block> MAGENTA_TIBERCRETE_WALL = registerBlock("magenta_tibercrete_wall",
            () -> new WallBlock(BlockBehaviour.Properties.copy(ModBlocks.MAGENTA_TIBERCRETE.get())));

    public static final RegistryObject<Block> ORANGE_TIBERCRETE_WALL = registerBlock("orange_tibercrete_wall",
            () -> new WallBlock(BlockBehaviour.Properties.copy(ModBlocks.ORANGE_TIBERCRETE.get())));

    public static final RegistryObject<Block> PINK_TIBERCRETE_WALL = registerBlock("pink_tibercrete_wall",
            () -> new WallBlock(BlockBehaviour.Properties.copy(ModBlocks.PINK_TIBERCRETE.get())));

    public static final RegistryObject<Block> PURPLE_TIBERCRETE_WALL = registerBlock("purple_tibercrete_wall",
            () -> new WallBlock(BlockBehaviour.Properties.copy(ModBlocks.PURPLE_TIBERCRETE.get())));

    public static final RegistryObject<Block> RED_TIBERCRETE_WALL = registerBlock("red_tibercrete_wall",
            () -> new WallBlock(BlockBehaviour.Properties.copy(ModBlocks.RED_TIBERCRETE.get())));

    public static final RegistryObject<Block> WHITE_TIBERCRETE_WALL = registerBlock("white_tibercrete_wall",
            () -> new WallBlock(BlockBehaviour.Properties.copy(ModBlocks.WHITE_TIBERCRETE.get())));

    public static final RegistryObject<Block> YELLOW_TIBERCRETE_WALL = registerBlock("yellow_tibercrete_wall",
            () -> new WallBlock(BlockBehaviour.Properties.copy(ModBlocks.YELLOW_TIBERCRETE.get())));

    public static final RegistryObject<Block> PROTO_STEEL_WALL = registerBlock("proto_steel_wall",
            () -> new WallBlock(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK)));

    public static final RegistryObject<Block> IRON_PLATING_WALL = registerBlock("iron_plating_wall",
            () -> new WallBlock(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK)));

    public static final RegistryObject<Block> RUSTY_IRON_PLATING_WALL = registerBlock("rusty_iron_plating_wall",
            () -> new WallBlock(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK)));

    public static final RegistryObject<Block> VITRIC_IRON_PLATING_WALL = registerBlock("vitric_iron_plating_wall",
            () -> new WallBlock(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK)));

    public static final RegistryObject<Block> POLISHED_IRON_WALL = registerBlock("polished_iron_wall",
            () -> new WallBlock(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK)));

    public static final RegistryObject<Block> BLACK_TIBERCRETE_BRICK_STAIRS = registerBlock("black_tibercrete_brick_stairs",
            () -> new StairBlock(() -> ModBlocks.BLACK_TIBERCRETE_BRICKS.get().defaultBlockState(),
                    BlockBehaviour.Properties.copy(Blocks.STONE_BRICK_STAIRS)));

    public static final RegistryObject<Block> BLUE_TIBERCRETE_BRICK_STAIRS = registerBlock("blue_tibercrete_brick_stairs",
            () -> new StairBlock(() -> ModBlocks.BLUE_TIBERCRETE_BRICKS.get().defaultBlockState(),
                    BlockBehaviour.Properties.copy(Blocks.STONE_BRICK_STAIRS)));

    public static final RegistryObject<Block> BROWN_TIBERCRETE_BRICK_STAIRS = registerBlock("brown_tibercrete_brick_stairs",
            () -> new StairBlock(() -> ModBlocks.BROWN_TIBERCRETE_BRICKS.get().defaultBlockState(),
                    BlockBehaviour.Properties.copy(Blocks.STONE_BRICK_STAIRS)));

    public static final RegistryObject<Block> CYAN_TIBERCRETE_BRICK_STAIRS = registerBlock("cyan_tibercrete_brick_stairs",
            () -> new StairBlock(() -> ModBlocks.CYAN_TIBERCRETE_BRICKS.get().defaultBlockState(),
                    BlockBehaviour.Properties.copy(Blocks.STONE_BRICK_STAIRS)));

    public static final RegistryObject<Block> GRAY_TIBERCRETE_BRICK_STAIRS = registerBlock("gray_tibercrete_brick_stairs",
            () -> new StairBlock(() -> ModBlocks.GRAY_TIBERCRETE_BRICKS.get().defaultBlockState(),
                    BlockBehaviour.Properties.copy(Blocks.STONE_BRICK_STAIRS)));

    public static final RegistryObject<Block> GREEN_TIBERCRETE_BRICK_STAIRS = registerBlock("green_tibercrete_brick_stairs",
            () -> new StairBlock(() -> ModBlocks.GREEN_TIBERCRETE_BRICKS.get().defaultBlockState(),
                    BlockBehaviour.Properties.copy(Blocks.STONE_BRICK_STAIRS)));

    public static final RegistryObject<Block> LIGHT_BLUE_TIBERCRETE_BRICK_STAIRS = registerBlock("light_blue_tibercrete_brick_stairs",
            () -> new StairBlock(() -> ModBlocks.LIGHT_BLUE_TIBERCRETE_BRICKS.get().defaultBlockState(),
                    BlockBehaviour.Properties.copy(Blocks.STONE_BRICK_STAIRS)));

    public static final RegistryObject<Block> LIGHT_GRAY_TIBERCRETE_BRICK_STAIRS = registerBlock("light_gray_tibercrete_brick_stairs",
            () -> new StairBlock(() -> ModBlocks.LIGHT_GRAY_TIBERCRETE_BRICKS.get().defaultBlockState(),
                    BlockBehaviour.Properties.copy(Blocks.STONE_BRICK_STAIRS)));

    public static final RegistryObject<Block> LIME_TIBERCRETE_BRICK_STAIRS = registerBlock("lime_tibercrete_brick_stairs",
            () -> new StairBlock(() -> ModBlocks.LIME_TIBERCRETE_BRICKS.get().defaultBlockState(),
                    BlockBehaviour.Properties.copy(Blocks.STONE_BRICK_STAIRS)));

    public static final RegistryObject<Block> MAGENTA_TIBERCRETE_BRICK_STAIRS = registerBlock("magenta_tibercrete_brick_stairs",
            () -> new StairBlock(() -> ModBlocks.MAGENTA_TIBERCRETE_BRICKS.get().defaultBlockState(),
                    BlockBehaviour.Properties.copy(Blocks.STONE_BRICK_STAIRS)));

    public static final RegistryObject<Block> ORANGE_TIBERCRETE_BRICK_STAIRS = registerBlock("orange_tibercrete_brick_stairs",
            () -> new StairBlock(() -> ModBlocks.ORANGE_TIBERCRETE_BRICKS.get().defaultBlockState(),
                    BlockBehaviour.Properties.copy(Blocks.STONE_BRICK_STAIRS)));

    public static final RegistryObject<Block> PINK_TIBERCRETE_BRICK_STAIRS = registerBlock("pink_tibercrete_brick_stairs",
            () -> new StairBlock(() -> ModBlocks.PINK_TIBERCRETE_BRICKS.get().defaultBlockState(),
                    BlockBehaviour.Properties.copy(Blocks.STONE_BRICK_STAIRS)));

    public static final RegistryObject<Block> PURPLE_TIBERCRETE_BRICK_STAIRS = registerBlock("purple_tibercrete_brick_stairs",
            () -> new StairBlock(() -> ModBlocks.PURPLE_TIBERCRETE_BRICKS.get().defaultBlockState(),
                    BlockBehaviour.Properties.copy(Blocks.STONE_BRICK_STAIRS)));

    public static final RegistryObject<Block> RED_TIBERCRETE_BRICK_STAIRS = registerBlock("red_tibercrete_brick_stairs",
            () -> new StairBlock(() -> ModBlocks.RED_TIBERCRETE_BRICKS.get().defaultBlockState(),
                    BlockBehaviour.Properties.copy(Blocks.STONE_BRICK_STAIRS)));

    public static final RegistryObject<Block> WHITE_TIBERCRETE_BRICK_STAIRS = registerBlock("white_tibercrete_brick_stairs",
            () -> new StairBlock(() -> ModBlocks.WHITE_TIBERCRETE_BRICKS.get().defaultBlockState(),
                    BlockBehaviour.Properties.copy(Blocks.STONE_BRICK_STAIRS)));

    public static final RegistryObject<Block> YELLOW_TIBERCRETE_BRICK_STAIRS = registerBlock("yellow_tibercrete_brick_stairs",
            () -> new StairBlock(() -> ModBlocks.YELLOW_TIBERCRETE_BRICKS.get().defaultBlockState(),
                    BlockBehaviour.Properties.copy(Blocks.STONE_BRICK_STAIRS)));

    public static final RegistryObject<Block> BLACK_TIBERCRETE_BRICK_SLAB = registerBlock("black_tibercrete_brick_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.copy(Blocks.STONE_BRICK_SLAB)));

    public static final RegistryObject<Block> BLUE_TIBERCRETE_BRICK_SLAB = registerBlock("blue_tibercrete_brick_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.copy(Blocks.STONE_BRICK_SLAB)));

    public static final RegistryObject<Block> BROWN_TIBERCRETE_BRICK_SLAB = registerBlock("brown_tibercrete_brick_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.copy(Blocks.STONE_BRICK_SLAB)));

    public static final RegistryObject<Block> CYAN_TIBERCRETE_BRICK_SLAB = registerBlock("cyan_tibercrete_brick_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.copy(Blocks.STONE_BRICK_SLAB)));

    public static final RegistryObject<Block> GRAY_TIBERCRETE_BRICK_SLAB = registerBlock("gray_tibercrete_brick_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.copy(Blocks.STONE_BRICK_SLAB)));

    public static final RegistryObject<Block> GREEN_TIBERCRETE_BRICK_SLAB = registerBlock("green_tibercrete_brick_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.copy(Blocks.STONE_BRICK_SLAB)));

    public static final RegistryObject<Block> LIGHT_BLUE_TIBERCRETE_BRICK_SLAB = registerBlock("light_blue_tibercrete_brick_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.copy(Blocks.STONE_BRICK_SLAB)));

    public static final RegistryObject<Block> LIGHT_GRAY_TIBERCRETE_BRICK_SLAB = registerBlock("light_gray_tibercrete_brick_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.copy(Blocks.STONE_BRICK_SLAB)));

    public static final RegistryObject<Block> LIME_TIBERCRETE_BRICK_SLAB = registerBlock("lime_tibercrete_brick_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.copy(Blocks.STONE_BRICK_SLAB)));

    public static final RegistryObject<Block> MAGENTA_TIBERCRETE_BRICK_SLAB = registerBlock("magenta_tibercrete_brick_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.copy(Blocks.STONE_BRICK_SLAB)));

    public static final RegistryObject<Block> ORANGE_TIBERCRETE_BRICK_SLAB = registerBlock("orange_tibercrete_brick_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.copy(Blocks.STONE_BRICK_SLAB)));

    public static final RegistryObject<Block> PINK_TIBERCRETE_BRICK_SLAB = registerBlock("pink_tibercrete_brick_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.copy(Blocks.STONE_BRICK_SLAB)));

    public static final RegistryObject<Block> PURPLE_TIBERCRETE_BRICK_SLAB = registerBlock("purple_tibercrete_brick_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.copy(Blocks.STONE_BRICK_SLAB)));

    public static final RegistryObject<Block> RED_TIBERCRETE_BRICK_SLAB = registerBlock("red_tibercrete_brick_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.copy(Blocks.STONE_BRICK_SLAB)));

    public static final RegistryObject<Block> WHITE_TIBERCRETE_BRICK_SLAB = registerBlock("white_tibercrete_brick_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.copy(Blocks.STONE_BRICK_SLAB)));

    public static final RegistryObject<Block> YELLOW_TIBERCRETE_BRICK_SLAB = registerBlock("yellow_tibercrete_brick_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.copy(Blocks.STONE_BRICK_SLAB)));

    public static final RegistryObject<Block> BLACK_TIBERCRETE_BRICK_WALL = registerBlock("black_tibercrete_brick_wall",
            () -> new WallBlock(BlockBehaviour.Properties.copy(ModBlocks.BLACK_TIBERCRETE.get())));

    public static final RegistryObject<Block> BLUE_TIBERCRETE_BRICK_WALL = registerBlock("blue_tibercrete_brick_wall",
            () -> new WallBlock(BlockBehaviour.Properties.copy(ModBlocks.BLUE_TIBERCRETE.get())));

    public static final RegistryObject<Block> BROWN_TIBERCRETE_BRICK_WALL = registerBlock("brown_tibercrete_brick_wall",
            () -> new WallBlock(BlockBehaviour.Properties.copy(ModBlocks.BROWN_TIBERCRETE.get())));

    public static final RegistryObject<Block> CYAN_TIBERCRETE_BRICK_WALL = registerBlock("cyan_tibercrete_brick_wall",
            () -> new WallBlock(BlockBehaviour.Properties.copy(ModBlocks.CYAN_TIBERCRETE.get())));

    public static final RegistryObject<Block> GRAY_TIBERCRETE_BRICK_WALL = registerBlock("gray_tibercrete_brick_wall",
            () -> new WallBlock(BlockBehaviour.Properties.copy(ModBlocks.GRAY_TIBERCRETE.get())));

    public static final RegistryObject<Block> GREEN_TIBERCRETE_BRICK_WALL = registerBlock("green_tibercrete_brick_wall",
            () -> new WallBlock(BlockBehaviour.Properties.copy(ModBlocks.GREEN_TIBERCRETE.get())));

    public static final RegistryObject<Block> LIGHT_BLUE_TIBERCRETE_BRICK_WALL = registerBlock("light_blue_tibercrete_brick_wall",
            () -> new WallBlock(BlockBehaviour.Properties.copy(ModBlocks.LIGHT_BLUE_TIBERCRETE.get())));

    public static final RegistryObject<Block> LIGHT_GRAY_TIBERCRETE_BRICK_WALL = registerBlock("light_gray_tibercrete_brick_wall",
            () -> new WallBlock(BlockBehaviour.Properties.copy(ModBlocks.LIGHT_GRAY_TIBERCRETE.get())));

    public static final RegistryObject<Block> LIME_TIBERCRETE_BRICK_WALL = registerBlock("lime_tibercrete_brick_wall",
            () -> new WallBlock(BlockBehaviour.Properties.copy(ModBlocks.LIME_TIBERCRETE.get())));

    public static final RegistryObject<Block> MAGENTA_TIBERCRETE_BRICK_WALL = registerBlock("magenta_tibercrete_brick_wall",
            () -> new WallBlock(BlockBehaviour.Properties.copy(ModBlocks.MAGENTA_TIBERCRETE.get())));

    public static final RegistryObject<Block> ORANGE_TIBERCRETE_BRICK_WALL = registerBlock("orange_tibercrete_brick_wall",
            () -> new WallBlock(BlockBehaviour.Properties.copy(ModBlocks.ORANGE_TIBERCRETE.get())));

    public static final RegistryObject<Block> PINK_TIBERCRETE_BRICK_WALL = registerBlock("pink_tibercrete_brick_wall",
            () -> new WallBlock(BlockBehaviour.Properties.copy(ModBlocks.PINK_TIBERCRETE.get())));

    public static final RegistryObject<Block> PURPLE_TIBERCRETE_BRICK_WALL = registerBlock("purple_tibercrete_brick_wall",
            () -> new WallBlock(BlockBehaviour.Properties.copy(ModBlocks.PURPLE_TIBERCRETE.get())));

    public static final RegistryObject<Block> RED_TIBERCRETE_BRICK_WALL = registerBlock("red_tibercrete_brick_wall",
            () -> new WallBlock(BlockBehaviour.Properties.copy(ModBlocks.RED_TIBERCRETE.get())));

    public static final RegistryObject<Block> WHITE_TIBERCRETE_BRICK_WALL = registerBlock("white_tibercrete_brick_wall",
            () -> new WallBlock(BlockBehaviour.Properties.copy(ModBlocks.WHITE_TIBERCRETE.get())));

    public static final RegistryObject<Block> YELLOW_TIBERCRETE_BRICK_WALL = registerBlock("yellow_tibercrete_brick_wall",
            () -> new WallBlock(BlockBehaviour.Properties.copy(ModBlocks.YELLOW_TIBERCRETE.get())));

        //Stone Based:
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

    public static final RegistryObject<Block> INFESTED_COBBLE_WALL = registerBlock("infested_cobble_wall",
            () -> new WallBlock(BlockBehaviour.Properties.copy(ModBlocks.INFESTED_COBBLE.get())));

    public static final RegistryObject<Block> INFESTED_STONE_BRICK_WALL = registerBlock("infested_stone_brick_wall",
            () -> new WallBlock(BlockBehaviour.Properties.copy(ModBlocks.INFESTED_STONE_BRICKS.get())));

    public static final RegistryObject<Block> PLAGUED_ANDESITE_STAIRS = registerBlock("plagued_andesite_stairs",
            () -> new StairBlock(() -> ModBlocks.INFESTED_ANDESITE.get().defaultBlockState(),
                    BlockBehaviour.Properties.copy(Blocks.STONE_BRICK_STAIRS)));

    public static final RegistryObject<Block> PLAGUED_ANDESITE_SLAB = registerBlock("plagued_andesite_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.copy(Blocks.STONE_BRICK_SLAB)));

    public static final RegistryObject<Block> PLAGUED_ANDESITE_WALL = registerBlock("plagued_andesite_wall",
            () -> new WallBlock(BlockBehaviour.Properties.copy(Blocks.ANDESITE)));

    public static final RegistryObject<Block> PLAGUED_STONE_STAIRS = registerBlock("plagued_stone_stairs",
            () -> new StairBlock(() -> ModBlocks.INFESTED_STONE.get().defaultBlockState(),
                    BlockBehaviour.Properties.copy(Blocks.STONE_BRICK_STAIRS)));

    public static final RegistryObject<Block> PLAGUED_STONE_SLAB = registerBlock("plagued_stone_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.copy(Blocks.STONE_BRICK_SLAB)));

    public static final RegistryObject<Block> PLAGUED_STONE_WALL = registerBlock("plagued_stone_wall",
            () -> new WallBlock(BlockBehaviour.Properties.copy(Blocks.STONE)));

    public static final RegistryObject<Block> PLAGUED_GRANITE_STAIRS = registerBlock("plagued_granite_stairs",
            () -> new StairBlock(() -> ModBlocks.INFESTED_GRANITE.get().defaultBlockState(),
                    BlockBehaviour.Properties.copy(Blocks.STONE_BRICK_STAIRS)));

    public static final RegistryObject<Block> PLAGUED_GRANITE_SLAB = registerBlock("plagued_granite_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.copy(Blocks.STONE_BRICK_SLAB)));

    public static final RegistryObject<Block> PLAGUED_GRANITE_WALL = registerBlock("plagued_granite_wall",
            () -> new WallBlock(BlockBehaviour.Properties.copy(Blocks.STONE)));

    public static final RegistryObject<Block> PLAGUED_DIORITE_STAIRS = registerBlock("plagued_diorite_stairs",
            () -> new StairBlock(() -> ModBlocks.INFESTED_DIORITE.get().defaultBlockState(),
                    BlockBehaviour.Properties.copy(Blocks.STONE_BRICK_STAIRS)));

    public static final RegistryObject<Block> PLAGUED_DIORITE_SLAB = registerBlock("plagued_diorite_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.copy(Blocks.STONE_BRICK_SLAB)));

    public static final RegistryObject<Block> PLAGUED_DIORITE_WALL = registerBlock("plagued_diorite_wall",
            () -> new WallBlock(BlockBehaviour.Properties.copy(Blocks.STONE)));

    public static final RegistryObject<Block> VITRIC_DEEPSLATE = registerBlock("vitric_deepslate",
            () -> new RotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.DEEPSLATE)));

    public static final RegistryObject<Block> VITRIC_DEEPSLATE_BRICKS = registerBlock("vitric_deepslate_bricks",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.DEEPSLATE_BRICKS)));

    public static final RegistryObject<Block> VITRIC_DEEPSLATE_BRICK_STAIRS = registerBlock("vitric_deepslate_brick_stairs",
            () -> new StairBlock(() -> ModBlocks.VITRIC_DEEPSLATE_BRICKS.get().defaultBlockState(),
                    BlockBehaviour.Properties.copy(Blocks.DEEPSLATE_BRICK_STAIRS)));

    public static final RegistryObject<Block> VITRIC_DEEPSLATE_BRICK_SLAB = registerBlock("vitric_deepslate_brick_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.copy(Blocks.DEEPSLATE_BRICK_SLAB)));

    public static final RegistryObject<Block> VITRIC_DEEPSLATE_BRICK_WALL = registerBlock("vitric_deepslate_brick_wall",
            () -> new WallBlock(BlockBehaviour.Properties.copy(Blocks.DEEPSLATE_BRICK_WALL)));



    public static final RegistryObject<Block> VITRIC_DEEPSLATE_TILES = registerBlock("vitric_deepslate_tiles",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.DEEPSLATE_TILES)));

    public static final RegistryObject<Block> VITRIC_DEEPSLATE_TILE_STAIRS = registerBlock("vitric_deepslate_tile_stairs",
            () -> new StairBlock(() -> ModBlocks.VITRIC_DEEPSLATE_TILES.get().defaultBlockState(),
                    BlockBehaviour.Properties.copy(Blocks.DEEPSLATE_TILE_STAIRS)));

    public static final RegistryObject<Block> VITRIC_DEEPSLATE_TILE_SLAB = registerBlock("vitric_deepslate_tile_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.copy(Blocks.DEEPSLATE_TILE_SLAB)));

    public static final RegistryObject<Block> VITRIC_DEEPSLATE_TILE_WALL = registerBlock("vitric_deepslate_tile_wall",
            () -> new WallBlock(BlockBehaviour.Properties.copy(Blocks.DEEPSLATE_TILE_WALL)));


    public static final RegistryObject<Block> YZ_SANDSTONE = registerBlock("yz_sandstone",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.SANDSTONE)));

    public static final RegistryObject<Block> YZ_SANDSTONE_STAIRS = registerBlock("yz_sandstone_stairs",
            () -> new StairBlock(() -> ModBlocks.YZ_SANDSTONE.get().defaultBlockState(),
                    BlockBehaviour.Properties.copy(Blocks.SANDSTONE_STAIRS)));

    public static final RegistryObject<Block> YZ_SANDSTONE_SLAB = registerBlock("yz_sandstone_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.copy(Blocks.SANDSTONE_SLAB)));

    public static final RegistryObject<Block> YZ_SANDSTONE_WALL = registerBlock("yz_sandstone_wall",
            () -> new WallBlock(BlockBehaviour.Properties.copy(Blocks.SANDSTONE_WALL)));

    public static final RegistryObject<Block> SMOOTH_YZ_SANDSTONE = registerBlock("smooth_yz_sandstone",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.SANDSTONE)));

    public static final RegistryObject<Block> SMOOTH_YZ_SANDSTONE_STAIRS = registerBlock("smooth_yz_sandstone_stairs",
            () -> new StairBlock(() -> ModBlocks.SMOOTH_YZ_SANDSTONE.get().defaultBlockState(),
                    BlockBehaviour.Properties.copy(Blocks.SANDSTONE_STAIRS)));

    public static final RegistryObject<Block> SMOOTH_YZ_SANDSTONE_SLAB = registerBlock("smooth_yz_sandstone_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.copy(Blocks.SANDSTONE_SLAB)));

    public static final RegistryObject<Block> CUT_YZ_SANDSTONE = registerBlock("cut_yz_sandstone",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.SANDSTONE)));

    public static final RegistryObject<Block> CUT_YZ_SANDSTONE_SLAB = registerBlock("cut_yz_sandstone_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.copy(Blocks.SANDSTONE_SLAB)));

    public static final RegistryObject<Block> CHISELED_YZ_SANDSTONE = registerBlock("chiseled_yz_sandstone",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.SANDSTONE)));

    public static final RegistryObject<Block> RZ_SANDSTONE = registerBlock("rz_sandstone",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.SANDSTONE)));

    public static final RegistryObject<Block> RZ_SANDSTONE_STAIRS = registerBlock("rz_sandstone_stairs",
            () -> new StairBlock(() -> ModBlocks.RZ_SANDSTONE.get().defaultBlockState(),
                    BlockBehaviour.Properties.copy(Blocks.SANDSTONE_STAIRS)));

    public static final RegistryObject<Block> RZ_SANDSTONE_SLAB = registerBlock("rz_sandstone_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.copy(Blocks.SANDSTONE_SLAB)));

    public static final RegistryObject<Block> RZ_SANDSTONE_WALL = registerBlock("rz_sandstone_wall",
            () -> new WallBlock(BlockBehaviour.Properties.copy(Blocks.SANDSTONE_WALL)));

    public static final RegistryObject<Block> SMOOTH_RZ_SANDSTONE = registerBlock("smooth_rz_sandstone",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.SANDSTONE)));

    public static final RegistryObject<Block> SMOOTH_RZ_SANDSTONE_STAIRS = registerBlock("smooth_rz_sandstone_stairs",
            () -> new StairBlock(() -> ModBlocks.SMOOTH_RZ_SANDSTONE.get().defaultBlockState(),
                    BlockBehaviour.Properties.copy(Blocks.SANDSTONE_STAIRS)));

    public static final RegistryObject<Block> SMOOTH_RZ_SANDSTONE_SLAB = registerBlock("smooth_rz_sandstone_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.copy(Blocks.SANDSTONE_SLAB)));

    public static final RegistryObject<Block> CUT_RZ_SANDSTONE = registerBlock("cut_rz_sandstone",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.SANDSTONE)));

    public static final RegistryObject<Block> CUT_RZ_SANDSTONE_SLAB = registerBlock("cut_rz_sandstone_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.copy(Blocks.SANDSTONE_SLAB)));

    public static final RegistryObject<Block> CHISELED_RZ_SANDSTONE = registerBlock("chiseled_rz_sandstone",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.SANDSTONE)));

        //Tiberium Based:
    public static final RegistryObject<Block> RIPARIUS_STONE_STAIRS = registerBlock("riparius_stone_stairs",
            () -> new StairBlock(() -> ModBlocks.RIPARIUS_STONE.get().defaultBlockState(),
                    BlockBehaviour.Properties.copy(Blocks.STONE_BRICK_STAIRS)));

    public static final RegistryObject<Block> RIPARIUS_STONE_SLAB = registerBlock("riparius_stone_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.copy(Blocks.STONE_BRICK_SLAB)));

    public static final RegistryObject<Block> RIPARIUS_STONE_WALL = registerBlock("riparius_stone_wall",
            () -> new WallBlock(BlockBehaviour.Properties.copy(Blocks.STONE)));

    public static final RegistryObject<Block> VINIFERA_STONE_STAIRS = registerBlock("vinifera_stone_stairs",
            () -> new StairBlock(() -> ModBlocks.VINIFERA_STONE.get().defaultBlockState(),
                    BlockBehaviour.Properties.copy(Blocks.STONE_BRICK_STAIRS)));

    public static final RegistryObject<Block> VINIFERA_STONE_SLAB = registerBlock("vinifera_stone_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.copy(Blocks.STONE_BRICK_SLAB)));

    public static final RegistryObject<Block> VINIFERA_STONE_WALL = registerBlock("vinifera_stone_wall",
            () -> new WallBlock(BlockBehaviour.Properties.copy(Blocks.STONE)));

    public static final RegistryObject<Block> CRUENTUS_STONE_STAIRS = registerBlock("cruentus_stone_stairs",
            () -> new StairBlock(() -> ModBlocks.CRUENTUS_STONE.get().defaultBlockState(),
                    BlockBehaviour.Properties.copy(Blocks.STONE_BRICK_STAIRS)));

    public static final RegistryObject<Block> CRUENTUS_STONE_SLAB = registerBlock("cruentus_stone_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.copy(Blocks.STONE_BRICK_SLAB)));

    public static final RegistryObject<Block> CRUENTUS_STONE_WALL = registerBlock("cruentus_stone_wall",
            () -> new WallBlock(BlockBehaviour.Properties.copy(Blocks.STONE)));

    public static final RegistryObject<Block> ABOREUS_STONE_STAIRS = registerBlock("aboreus_stone_stairs",
            () -> new StairBlock(() -> ModBlocks.ABOREUS_STONE.get().defaultBlockState(),
                    BlockBehaviour.Properties.copy(Blocks.STONE_BRICK_STAIRS)));

    public static final RegistryObject<Block> ABOREUS_STONE_SLAB = registerBlock("aboreus_stone_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.copy(Blocks.STONE_BRICK_SLAB)));

    public static final RegistryObject<Block> ABOREUS_STONE_WALL = registerBlock("aboreus_stone_wall",
            () -> new WallBlock(BlockBehaviour.Properties.copy(Blocks.STONE)));

    public static final RegistryObject<Block> RIPARIUS_CRYSTAL_STAIRS = registerBlock("riparius_crystal_stairs",
            () -> new StairBlock(() -> ModBlocks.RIPARIUS_CRYSTAL.get().defaultBlockState(),
                    BlockBehaviour.Properties.copy(Blocks.OBSIDIAN).sound(SoundType.AMETHYST)
                            .noOcclusion().lightLevel(tiberiumglow)));

    public static final RegistryObject<Block> RIPARIUS_CRYSTAL_SLAB = registerBlock("riparius_crystal_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.copy(Blocks.OBSIDIAN).sound(SoundType.AMETHYST)
                    .noOcclusion().lightLevel(tiberiumglow)));

    public static final RegistryObject<Block> RIPARIUS_CRYSTAL_WALL = registerBlock("riparius_crystal_wall",
            () -> new WallBlock(BlockBehaviour.Properties.copy(Blocks.OBSIDIAN).sound(SoundType.AMETHYST)
                    .noOcclusion().lightLevel(tiberiumglow)));

    public static final RegistryObject<Block> VINIFERA_CRYSTAL_STAIRS = registerBlock("vinifera_crystal_stairs",
            () -> new StairBlock(() -> ModBlocks.VINIFERA_CRYSTAL.get().defaultBlockState(),
                    BlockBehaviour.Properties.copy(Blocks.OBSIDIAN).sound(SoundType.AMETHYST)
                            .noOcclusion().lightLevel(tiberiumglow)));

    public static final RegistryObject<Block> VINIFERA_CRYSTAL_SLAB = registerBlock("vinifera_crystal_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.copy(Blocks.OBSIDIAN).sound(SoundType.AMETHYST)
                    .noOcclusion().lightLevel(tiberiumglow)));

    public static final RegistryObject<Block> VINIFERA_CRYSTAL_WALL = registerBlock("vinifera_crystal_wall",
            () -> new WallBlock(BlockBehaviour.Properties.copy(Blocks.OBSIDIAN).sound(SoundType.AMETHYST)
                    .noOcclusion().lightLevel(tiberiumglow)));

    public static final RegistryObject<Block> CRUENTUS_CRYSTAL_STAIRS = registerBlock("cruentus_crystal_stairs",
            () -> new StairBlock(() -> ModBlocks.CRUENTUS_CRYSTAL.get().defaultBlockState(),
                    BlockBehaviour.Properties.copy(Blocks.OBSIDIAN).sound(SoundType.AMETHYST)
                            .noOcclusion().lightLevel(tiberiumglow)));

    public static final RegistryObject<Block> CRUENTUS_CRYSTAL_SLAB = registerBlock("cruentus_crystal_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.copy(Blocks.OBSIDIAN).sound(SoundType.AMETHYST)
                    .noOcclusion().lightLevel(tiberiumglow)));

    public static final RegistryObject<Block> CRUENTUS_CRYSTAL_WALL = registerBlock("cruentus_crystal_wall",
            () -> new WallBlock(BlockBehaviour.Properties.copy(Blocks.OBSIDIAN).sound(SoundType.AMETHYST)
                    .noOcclusion().lightLevel(tiberiumglow)));

    public static final RegistryObject<Block> ABOREUS_CRYSTAL_STAIRS = registerBlock("aboreus_crystal_stairs",
            () -> new StairBlock(() -> ModBlocks.ABOREUS_CRYSTAL.get().defaultBlockState(),
                    BlockBehaviour.Properties.copy(Blocks.OBSIDIAN).sound(SoundType.AMETHYST)
                            .noOcclusion().lightLevel(tiberiumglow)));

    public static final RegistryObject<Block> ABOREUS_CRYSTAL_SLAB = registerBlock("aboreus_crystal_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.copy(Blocks.OBSIDIAN).sound(SoundType.AMETHYST)
                    .noOcclusion().lightLevel(tiberiumglow)));

    public static final RegistryObject<Block> ABOREUS_CRYSTAL_WALL = registerBlock("aboreus_crystal_wall",
            () -> new WallBlock(BlockBehaviour.Properties.copy(Blocks.OBSIDIAN).sound(SoundType.AMETHYST)
                    .noOcclusion().lightLevel(tiberiumglow)));

    public static final RegistryObject<Block> RIPARIUS_STONE_BRICKS = registerBlock("riparius_stone_bricks",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.STONE_BRICKS)));

    public static final RegistryObject<Block> RIPARIUS_STONE_BRICK_STAIRS = registerBlock("riparius_stone_brick_stairs",
            () -> new StairBlock(() -> ModBlocks.RIPARIUS_STONE_BRICKS.get().defaultBlockState(),
                    BlockBehaviour.Properties.copy(Blocks.STONE_BRICK_STAIRS)));

    public static final RegistryObject<Block> RIPARIUS_STONE_BRICK_SLAB = registerBlock("riparius_stone_brick_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.copy(Blocks.STONE_BRICK_SLAB)));

    public static final RegistryObject<Block> RIPARIUS_STONE_BRICK_WALL = registerBlock("riparius_stone_brick_wall",
            () -> new WallBlock(BlockBehaviour.Properties.copy(Blocks.STONE_BRICK_WALL)));

    public static final RegistryObject<Block> VINIFERA_STONE_BRICKS = registerBlock("vinifera_stone_bricks",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.STONE_BRICKS)));

    public static final RegistryObject<Block> VINIFERA_STONE_BRICK_STAIRS = registerBlock("vinifera_stone_brick_stairs",
            () -> new StairBlock(() -> ModBlocks.VINIFERA_STONE_BRICKS.get().defaultBlockState(),
                    BlockBehaviour.Properties.copy(Blocks.STONE_BRICK_STAIRS)));

    public static final RegistryObject<Block> VINIFERA_STONE_BRICK_SLAB = registerBlock("vinifera_stone_brick_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.copy(Blocks.STONE_BRICK_SLAB)));

    public static final RegistryObject<Block> VINIFERA_STONE_BRICK_WALL = registerBlock("vinifera_stone_brick_wall",
            () -> new WallBlock(BlockBehaviour.Properties.copy(Blocks.STONE_BRICK_WALL)));

    public static final RegistryObject<Block> CRUENTUS_STONE_BRICKS = registerBlock("cruentus_stone_bricks",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.STONE_BRICKS)));

    public static final RegistryObject<Block> CRUENTUS_STONE_BRICK_STAIRS = registerBlock("cruentus_stone_brick_stairs",
            () -> new StairBlock(() -> ModBlocks.CRUENTUS_STONE_BRICKS.get().defaultBlockState(),
                    BlockBehaviour.Properties.copy(Blocks.STONE_BRICK_STAIRS)));

    public static final RegistryObject<Block> CRUENTUS_STONE_BRICK_SLAB = registerBlock("cruentus_stone_brick_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.copy(Blocks.STONE_BRICK_SLAB)));

    public static final RegistryObject<Block> CRUENTUS_STONE_BRICK_WALL = registerBlock("cruentus_stone_brick_wall",
            () -> new WallBlock(BlockBehaviour.Properties.copy(Blocks.STONE_BRICK_WALL)));

    public static final RegistryObject<Block> ABOREUS_STONE_BRICKS = registerBlock("aboreus_stone_bricks",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.STONE_BRICKS)));

    public static final RegistryObject<Block> ABOREUS_STONE_BRICK_STAIRS = registerBlock("aboreus_stone_brick_stairs",
            () -> new StairBlock(() -> ModBlocks.ABOREUS_STONE_BRICKS.get().defaultBlockState(),
                    BlockBehaviour.Properties.copy(Blocks.STONE_BRICK_STAIRS)));

    public static final RegistryObject<Block> ABOREUS_STONE_BRICK_SLAB = registerBlock("aboreus_stone_brick_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.copy(Blocks.STONE_BRICK_SLAB)));

    public static final RegistryObject<Block> ABOREUS_STONE_BRICK_WALL = registerBlock("aboreus_stone_brick_wall",
            () -> new WallBlock(BlockBehaviour.Properties.copy(Blocks.STONE_BRICK_WALL)));

        //Core Steel Based:
            //Vertical Slab:
        public static final RegistryObject<Block> CS_CHAINLINK = registerBlock("cs_chainlink",
                () -> new ModVerticalSlabBlock(BlockBehaviour.Properties.copy(Blocks.CHAIN)));

    public static final RegistryObject<Block> CS_SCAFFOLD_VERT = registerBlock("cs_scaffold_vert",
            () -> new ModVerticalSlabBlock(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK)));

    public static final RegistryObject<Block> CS_CATWALK_W_VERT = registerBlock("cs_catwalk_w_vert",
            () -> new ModVerticalSlabBlock(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK)));

    public static final RegistryObject<Block> CS_CATWALK_BL_VERT = registerBlock("cs_catwalk_bl_vert",
            () -> new ModVerticalSlabBlock(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK)));

    public static final RegistryObject<Block> CS_CATWALK_G_VERT = registerBlock("cs_catwalk_g_vert",
            () -> new ModVerticalSlabBlock(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK)));

    public static final RegistryObject<Block> CS_CATWALK_B_VERT = registerBlock("cs_catwalk_b_vert",
            () -> new ModVerticalSlabBlock(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK)));

    public static final RegistryObject<Block> CS_CATWALK_R_VERT = registerBlock("cs_catwalk_r_vert",
            () -> new ModVerticalSlabBlock(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK)));

    public static final RegistryObject<Block> CS_CATWALK_P_VERT = registerBlock("cs_catwalk_p_vert",
            () -> new ModVerticalSlabBlock(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK)));

    public static final RegistryObject<Block> CS_TILE_VERT = registerBlock("cs_tile_vert",
            () -> new ModVerticalSlabBlock(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK)));

    public static final RegistryObject<Block> CS_TILE_BR_VERT = registerBlock("cs_tile_br_vert",
            () -> new ModVerticalSlabBlock(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK)));

    public static final RegistryObject<Block> CS_TILE_YB_VERT = registerBlock("cs_tile_yb_vert",
            () -> new ModVerticalSlabBlock(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK)));

    public static final RegistryObject<Block> CS_TILE_G_VERT = registerBlock("cs_tile_g_vert",
            () -> new ModVerticalSlabBlock(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK)));

    public static final RegistryObject<Block> CS_TILE_G_BAND_VERT = registerBlock("cs_tile_g_band_vert",
            () -> new ModVerticalSlabBlock(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK)));

    public static final RegistryObject<Block> CS_TILE_G_FRAME_VERT = registerBlock("cs_tile_g_frame_vert",
            () -> new ModVerticalSlabBlock(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK)));

    public static final RegistryObject<Block> CS_TILE_B_VERT = registerBlock("cs_tile_b_vert",
            () -> new ModVerticalSlabBlock(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK)));

    public static final RegistryObject<Block> CS_TILE_B_BAND_VERT = registerBlock("cs_tile_b_band_vert",
            () -> new ModVerticalSlabBlock(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK)));

    public static final RegistryObject<Block> CS_TILE_B_FRAME_VERT = registerBlock("cs_tile_b_frame_vert",
            () -> new ModVerticalSlabBlock(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK)));

    public static final RegistryObject<Block> CS_TILE_R_VERT = registerBlock("cs_tile_r_vert",
            () -> new ModVerticalSlabBlock(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK)));

    public static final RegistryObject<Block> CS_TILE_R_BAND_VERT = registerBlock("cs_tile_r_band_vert",
            () -> new ModVerticalSlabBlock(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK)));

    public static final RegistryObject<Block> CS_TILE_R_FRAME_VERT = registerBlock("cs_tile_r_frame_vert",
            () -> new ModVerticalSlabBlock(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK)));

    public static final RegistryObject<Block> CS_TILE_P_VERT = registerBlock("cs_tile_p_vert",
            () -> new ModVerticalSlabBlock(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK)));

    public static final RegistryObject<Block> CS_TILE_P_BAND_VERT = registerBlock("cs_tile_p_band_vert",
            () -> new ModVerticalSlabBlock(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK)));

    public static final RegistryObject<Block> CS_TILE_P_FRAME_VERT = registerBlock("cs_tile_p_frame_vert",
            () -> new ModVerticalSlabBlock(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK)));

    public static final RegistryObject<Block> CS_TILE_LG_VERT = registerBlock("cs_tile_lg_vert",
            () -> new ModVerticalSlabBlock(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK)));

    public static final RegistryObject<Block> CS_TILE_LG_BAND_VERT = registerBlock("cs_tile_lg_band_vert",
            () -> new ModVerticalSlabBlock(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK)));

    public static final RegistryObject<Block> CS_TILE_LG_FRAME_VERT = registerBlock("cs_tile_lg_frame_vert",
            () -> new ModVerticalSlabBlock(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK)));

    public static final RegistryObject<Block> CS_TILE_MG_VERT = registerBlock("cs_tile_mg_vert",
            () -> new ModVerticalSlabBlock(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK)));

    public static final RegistryObject<Block> CS_TILE_MG_BAND_VERT = registerBlock("cs_tile_mg_band_vert",
            () -> new ModVerticalSlabBlock(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK)));

    public static final RegistryObject<Block> CS_TILE_MG_FRAME_VERT = registerBlock("cs_tile_mg_frame_vert",
            () -> new ModVerticalSlabBlock(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK)));

    public static final RegistryObject<Block> CS_TILE_HG_VERT = registerBlock("cs_tile_hg_vert",
            () -> new ModVerticalSlabBlock(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK)));

    public static final RegistryObject<Block> CS_TILE_HG_BAND_VERT = registerBlock("cs_tile_hg_band_vert",
            () -> new ModVerticalSlabBlock(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK)));

    public static final RegistryObject<Block> CS_TILE_HG_FRAME_VERT = registerBlock("cs_tile_hg_frame_vert",
            () -> new ModVerticalSlabBlock(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK)));

        //Regular:

    public static final RegistryObject<Block> CS_SCAFFOLD = registerBlock("cs_scaffold",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).noOcclusion()));

    public static final RegistryObject<Block> CS_SCAFFOLD_STAIRS = registerBlock("cs_scaffold_stairs",
            () -> new StairBlock(() -> ModBlocks.CS_SCAFFOLD.get().defaultBlockState(),
                    BlockBehaviour.Properties.copy(Blocks.STONE_BRICK_STAIRS).noOcclusion()));

    public static final RegistryObject<Block> CS_SCAFFOLD_SLAB = registerBlock("cs_scaffold_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.copy(Blocks.STONE_BRICK_SLAB).noOcclusion()));

    public static final RegistryObject<Block> CS_CATWALK_W = registerBlock("cs_catwalk_w",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).noOcclusion()));

    public static final RegistryObject<Block> CS_CATWALK_W_STAIRS = registerBlock("cs_catwalk_w_stairs",
            () -> new StairBlock(() -> ModBlocks.CS_CATWALK_W.get().defaultBlockState(),
                    BlockBehaviour.Properties.copy(Blocks.STONE_BRICK_STAIRS).noOcclusion()));

    public static final RegistryObject<Block> CS_CATWALK_W_SLAB = registerBlock("cs_catwalk_w_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.copy(Blocks.STONE_BRICK_SLAB).noOcclusion()));

    public static final RegistryObject<Block> CS_CATWALK_BL = registerBlock("cs_catwalk_bl",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).noOcclusion()));

    public static final RegistryObject<Block> CS_CATWALK_BL_STAIRS = registerBlock("cs_catwalk_bl_stairs",
            () -> new StairBlock(() -> ModBlocks.CS_CATWALK_BL.get().defaultBlockState(),
                    BlockBehaviour.Properties.copy(Blocks.STONE_BRICK_STAIRS).noOcclusion()));

    public static final RegistryObject<Block> CS_CATWALK_BL_SLAB = registerBlock("cs_catwalk_bl_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.copy(Blocks.STONE_BRICK_SLAB).noOcclusion()));

    public static final RegistryObject<Block> CS_CATWALK_G = registerBlock("cs_catwalk_g",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).noOcclusion()));

    public static final RegistryObject<Block> CS_CATWALK_G_STAIRS = registerBlock("cs_catwalk_g_stairs",
            () -> new StairBlock(() -> ModBlocks.CS_CATWALK_G.get().defaultBlockState(),
                    BlockBehaviour.Properties.copy(Blocks.STONE_BRICK_STAIRS).noOcclusion()));

    public static final RegistryObject<Block> CS_CATWALK_G_SLAB = registerBlock("cs_catwalk_g_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.copy(Blocks.STONE_BRICK_SLAB).noOcclusion()));

    public static final RegistryObject<Block> CS_CATWALK_B = registerBlock("cs_catwalk_b",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).noOcclusion()));

    public static final RegistryObject<Block> CS_CATWALK_B_STAIRS = registerBlock("cs_catwalk_b_stairs",
            () -> new StairBlock(() -> ModBlocks.CS_CATWALK_B.get().defaultBlockState(),
                    BlockBehaviour.Properties.copy(Blocks.STONE_BRICK_STAIRS).noOcclusion()));

    public static final RegistryObject<Block> CS_CATWALK_B_SLAB = registerBlock("cs_catwalk_b_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.copy(Blocks.STONE_BRICK_SLAB).noOcclusion()));

    public static final RegistryObject<Block> CS_CATWALK_R = registerBlock("cs_catwalk_r",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).noOcclusion()));

    public static final RegistryObject<Block> CS_CATWALK_R_STAIRS = registerBlock("cs_catwalk_r_stairs",
            () -> new StairBlock(() -> ModBlocks.CS_CATWALK_R.get().defaultBlockState(),
                    BlockBehaviour.Properties.copy(Blocks.STONE_BRICK_STAIRS).noOcclusion()));

    public static final RegistryObject<Block> CS_CATWALK_R_SLAB = registerBlock("cs_catwalk_r_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.copy(Blocks.STONE_BRICK_SLAB).noOcclusion()));

    public static final RegistryObject<Block> CS_CATWALK_P = registerBlock("cs_catwalk_p",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).noOcclusion()));

    public static final RegistryObject<Block> CS_CATWALK_P_STAIRS = registerBlock("cs_catwalk_p_stairs",
            () -> new StairBlock(() -> ModBlocks.CS_CATWALK_P.get().defaultBlockState(),
                    BlockBehaviour.Properties.copy(Blocks.STONE_BRICK_STAIRS).noOcclusion()));

    public static final RegistryObject<Block> CS_CATWALK_P_SLAB = registerBlock("cs_catwalk_p_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.copy(Blocks.STONE_BRICK_SLAB).noOcclusion()));

    public static final RegistryObject<Block> CS_TILE = registerBlock("cs_tile",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK)));

    public static final RegistryObject<Block> CS_TILE_STAIRS = registerBlock("cs_tile_stairs",
            () -> new StairBlock(() -> ModBlocks.CS_TILE.get().defaultBlockState(),
                    BlockBehaviour.Properties.copy(Blocks.STONE_BRICK_STAIRS)));

    public static final RegistryObject<Block> CS_TILE_SLAB = registerBlock("cs_tile_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.copy(Blocks.STONE_BRICK_SLAB)));

    public static final RegistryObject<Block> CS_TILE_WALL = registerBlock("cs_tile_wall",
            () -> new WallBlock(BlockBehaviour.Properties.copy(Blocks.STONE_BRICK_WALL)));

    public static final RegistryObject<Block> CS_TILE_BR = registerBlock("cs_tile_br",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK)));

    public static final RegistryObject<Block> CS_TILE_BR_STAIRS = registerBlock("cs_tile_br_stairs",
            () -> new StairBlock(() -> ModBlocks.CS_TILE_BR.get().defaultBlockState(),
                    BlockBehaviour.Properties.copy(Blocks.STONE_BRICK_STAIRS)));

    public static final RegistryObject<Block> CS_TILE_BR_SLAB = registerBlock("cs_tile_br_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.copy(Blocks.STONE_BRICK_SLAB)));

    public static final RegistryObject<Block> CS_TILE_BR_WALL = registerBlock("cs_tile_br_wall",
            () -> new WallBlock(BlockBehaviour.Properties.copy(Blocks.STONE_BRICK_WALL)));

    public static final RegistryObject<Block> CS_TILE_YB = registerBlock("cs_tile_yb",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK)));

    public static final RegistryObject<Block> CS_TILE_YB_STAIRS = registerBlock("cs_tile_yb_stairs",
            () -> new StairBlock(() -> ModBlocks.CS_TILE_YB.get().defaultBlockState(),
                    BlockBehaviour.Properties.copy(Blocks.STONE_BRICK_STAIRS)));

    public static final RegistryObject<Block> CS_TILE_YB_SLAB = registerBlock("cs_tile_yb_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.copy(Blocks.STONE_BRICK_SLAB)));

    public static final RegistryObject<Block> CS_TILE_YB_WALL = registerBlock("cs_tile_yb_wall",
            () -> new WallBlock(BlockBehaviour.Properties.copy(Blocks.STONE_BRICK_WALL)));

    public static final RegistryObject<Block> CS_TILE_G = registerBlock("cs_tile_g",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK)));

    public static final RegistryObject<Block> CS_TILE_G_STAIRS = registerBlock("cs_tile_g_stairs",
            () -> new StairBlock(() -> ModBlocks.CS_TILE_G.get().defaultBlockState(),
                    BlockBehaviour.Properties.copy(Blocks.STONE_BRICK_STAIRS)));

    public static final RegistryObject<Block> CS_TILE_G_SLAB = registerBlock("cs_tile_g_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.copy(Blocks.STONE_BRICK_SLAB)));

    public static final RegistryObject<Block> CS_TILE_G_WALL = registerBlock("cs_tile_g_wall",
            () -> new WallBlock(BlockBehaviour.Properties.copy(Blocks.STONE_BRICK_WALL)));

    public static final RegistryObject<Block> CS_TILE_B = registerBlock("cs_tile_b",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK)));

    public static final RegistryObject<Block> CS_TILE_B_STAIRS = registerBlock("cs_tile_b_stairs",
            () -> new StairBlock(() -> ModBlocks.CS_TILE_B.get().defaultBlockState(),
                    BlockBehaviour.Properties.copy(Blocks.STONE_BRICK_STAIRS)));

    public static final RegistryObject<Block> CS_TILE_B_SLAB = registerBlock("cs_tile_b_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.copy(Blocks.STONE_BRICK_SLAB)));

    public static final RegistryObject<Block> CS_TILE_B_WALL = registerBlock("cs_tile_b_wall",
            () -> new WallBlock(BlockBehaviour.Properties.copy(Blocks.STONE_BRICK_WALL)));

    public static final RegistryObject<Block> CS_TILE_R = registerBlock("cs_tile_r",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK)));

    public static final RegistryObject<Block> CS_TILE_R_STAIRS = registerBlock("cs_tile_r_stairs",
            () -> new StairBlock(() -> ModBlocks.CS_TILE_R.get().defaultBlockState(),
                    BlockBehaviour.Properties.copy(Blocks.STONE_BRICK_STAIRS)));

    public static final RegistryObject<Block> CS_TILE_R_SLAB = registerBlock("cs_tile_r_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.copy(Blocks.STONE_BRICK_SLAB)));

    public static final RegistryObject<Block> CS_TILE_R_WALL = registerBlock("cs_tile_r_wall",
            () -> new WallBlock(BlockBehaviour.Properties.copy(Blocks.STONE_BRICK_WALL)));

    public static final RegistryObject<Block> CS_TILE_P = registerBlock("cs_tile_p",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK)));

    public static final RegistryObject<Block> CS_TILE_P_STAIRS = registerBlock("cs_tile_p_stairs",
            () -> new StairBlock(() -> ModBlocks.CS_TILE_P.get().defaultBlockState(),
                    BlockBehaviour.Properties.copy(Blocks.STONE_BRICK_STAIRS)));

    public static final RegistryObject<Block> CS_TILE_P_SLAB = registerBlock("cs_tile_p_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.copy(Blocks.STONE_BRICK_SLAB)));

    public static final RegistryObject<Block> CS_TILE_P_WALL = registerBlock("cs_tile_p_wall",
            () -> new WallBlock(BlockBehaviour.Properties.copy(Blocks.STONE_BRICK_WALL)));

    public static final RegistryObject<Block> CS_TILE_LG = registerBlock("cs_tile_lg",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK)));

    public static final RegistryObject<Block> CS_TILE_LG_STAIRS = registerBlock("cs_tile_lg_stairs",
            () -> new StairBlock(() -> ModBlocks.CS_TILE_LG.get().defaultBlockState(),
                    BlockBehaviour.Properties.copy(Blocks.STONE_BRICK_STAIRS)));

    public static final RegistryObject<Block> CS_TILE_LG_SLAB = registerBlock("cs_tile_lg_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.copy(Blocks.STONE_BRICK_SLAB)));

    public static final RegistryObject<Block> CS_TILE_LG_WALL = registerBlock("cs_tile_lg_wall",
            () -> new WallBlock(BlockBehaviour.Properties.copy(Blocks.STONE_BRICK_WALL)));

    public static final RegistryObject<Block> CS_TILE_MG = registerBlock("cs_tile_mg",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK)));

    public static final RegistryObject<Block> CS_TILE_MG_STAIRS = registerBlock("cs_tile_mg_stairs",
            () -> new StairBlock(() -> ModBlocks.CS_TILE_MG.get().defaultBlockState(),
                    BlockBehaviour.Properties.copy(Blocks.STONE_BRICK_STAIRS)));

    public static final RegistryObject<Block> CS_TILE_MG_SLAB = registerBlock("cs_tile_mg_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.copy(Blocks.STONE_BRICK_SLAB)));

    public static final RegistryObject<Block> CS_TILE_MG_WALL = registerBlock("cs_tile_mg_wall",
            () -> new WallBlock(BlockBehaviour.Properties.copy(Blocks.STONE_BRICK_WALL)));

    public static final RegistryObject<Block> CS_TILE_HG = registerBlock("cs_tile_hg",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK)));

    public static final RegistryObject<Block> CS_TILE_HG_STAIRS = registerBlock("cs_tile_hg_stairs",
            () -> new StairBlock(() -> ModBlocks.CS_TILE_HG.get().defaultBlockState(),
                    BlockBehaviour.Properties.copy(Blocks.STONE_BRICK_STAIRS)));

    public static final RegistryObject<Block> CS_TILE_HG_SLAB = registerBlock("cs_tile_hg_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.copy(Blocks.STONE_BRICK_SLAB)));

    public static final RegistryObject<Block> CS_TILE_HG_WALL = registerBlock("cs_tile_hg_wall",
            () -> new WallBlock(BlockBehaviour.Properties.copy(Blocks.STONE_BRICK_WALL)));

    public static final RegistryObject<Block> CS_TILE_G_BAND = registerBlock("cs_tile_g_band",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK)));

    public static final RegistryObject<Block> CS_TILE_G_BAND_STAIRS = registerBlock("cs_tile_g_band_stairs",
            () -> new StairBlock(() -> ModBlocks.CS_TILE_G_BAND.get().defaultBlockState(),
                    BlockBehaviour.Properties.copy(Blocks.STONE_BRICK_STAIRS)));

    public static final RegistryObject<Block> CS_TILE_G_BAND_SLAB = registerBlock("cs_tile_g_band_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.copy(Blocks.STONE_BRICK_SLAB)));

    public static final RegistryObject<Block> CS_TILE_G_BAND_WALL = registerBlock("cs_tile_g_band_wall",
            () -> new WallBlock(BlockBehaviour.Properties.copy(Blocks.STONE_BRICK_WALL)));

    public static final RegistryObject<Block> CS_TILE_G_FRAME = registerBlock("cs_tile_g_frame",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK)));

    public static final RegistryObject<Block> CS_TILE_G_FRAME_STAIRS = registerBlock("cs_tile_g_frame_stairs",
            () -> new StairBlock(() -> ModBlocks.CS_TILE_G_FRAME.get().defaultBlockState(),
                    BlockBehaviour.Properties.copy(Blocks.STONE_BRICK_STAIRS)));

    public static final RegistryObject<Block> CS_TILE_G_FRAME_SLAB = registerBlock("cs_tile_g_frame_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.copy(Blocks.STONE_BRICK_SLAB)));

    public static final RegistryObject<Block> CS_TILE_G_FRAME_WALL = registerBlock("cs_tile_g_frame_wall",
            () -> new WallBlock(BlockBehaviour.Properties.copy(Blocks.STONE_BRICK_WALL)));

    public static final RegistryObject<Block> CS_TILE_B_BAND = registerBlock("cs_tile_b_band",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK)));

    public static final RegistryObject<Block> CS_TILE_B_BAND_STAIRS = registerBlock("cs_tile_b_band_stairs",
            () -> new StairBlock(() -> ModBlocks.CS_TILE_B_BAND.get().defaultBlockState(),
                    BlockBehaviour.Properties.copy(Blocks.STONE_BRICK_STAIRS)));

    public static final RegistryObject<Block> CS_TILE_B_BAND_SLAB = registerBlock("cs_tile_b_band_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.copy(Blocks.STONE_BRICK_SLAB)));

    public static final RegistryObject<Block> CS_TILE_B_BAND_WALL = registerBlock("cs_tile_b_band_wall",
            () -> new WallBlock(BlockBehaviour.Properties.copy(Blocks.STONE_BRICK_WALL)));

    public static final RegistryObject<Block> CS_TILE_B_FRAME = registerBlock("cs_tile_b_frame",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK)));

    public static final RegistryObject<Block> CS_TILE_B_FRAME_STAIRS = registerBlock("cs_tile_b_frame_stairs",
            () -> new StairBlock(() -> ModBlocks.CS_TILE_B_FRAME.get().defaultBlockState(),
                    BlockBehaviour.Properties.copy(Blocks.STONE_BRICK_STAIRS)));

    public static final RegistryObject<Block> CS_TILE_B_FRAME_SLAB = registerBlock("cs_tile_b_frame_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.copy(Blocks.STONE_BRICK_SLAB)));

    public static final RegistryObject<Block> CS_TILE_B_FRAME_WALL = registerBlock("cs_tile_b_frame_wall",
            () -> new WallBlock(BlockBehaviour.Properties.copy(Blocks.STONE_BRICK_WALL)));

    public static final RegistryObject<Block> CS_TILE_R_BAND = registerBlock("cs_tile_r_band",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK)));

    public static final RegistryObject<Block> CS_TILE_R_BAND_STAIRS = registerBlock("cs_tile_r_band_stairs",
            () -> new StairBlock(() -> ModBlocks.CS_TILE_R_BAND.get().defaultBlockState(),
                    BlockBehaviour.Properties.copy(Blocks.STONE_BRICK_STAIRS)));

    public static final RegistryObject<Block> CS_TILE_R_BAND_SLAB = registerBlock("cs_tile_r_band_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.copy(Blocks.STONE_BRICK_SLAB)));

    public static final RegistryObject<Block> CS_TILE_R_BAND_WALL = registerBlock("cs_tile_r_band_wall",
            () -> new WallBlock(BlockBehaviour.Properties.copy(Blocks.STONE_BRICK_WALL)));

    public static final RegistryObject<Block> CS_TILE_R_FRAME = registerBlock("cs_tile_r_frame",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK)));

    public static final RegistryObject<Block> CS_TILE_R_FRAME_STAIRS = registerBlock("cs_tile_r_frame_stairs",
            () -> new StairBlock(() -> ModBlocks.CS_TILE_R_FRAME.get().defaultBlockState(),
                    BlockBehaviour.Properties.copy(Blocks.STONE_BRICK_STAIRS)));

    public static final RegistryObject<Block> CS_TILE_R_FRAME_SLAB = registerBlock("cs_tile_r_frame_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.copy(Blocks.STONE_BRICK_SLAB)));

    public static final RegistryObject<Block> CS_TILE_R_FRAME_WALL = registerBlock("cs_tile_r_frame_wall",
            () -> new WallBlock(BlockBehaviour.Properties.copy(Blocks.STONE_BRICK_WALL)));

    public static final RegistryObject<Block> CS_TILE_P_BAND = registerBlock("cs_tile_p_band",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK)));

    public static final RegistryObject<Block> CS_TILE_P_BAND_STAIRS = registerBlock("cs_tile_p_band_stairs",
            () -> new StairBlock(() -> ModBlocks.CS_TILE_P_BAND.get().defaultBlockState(),
                    BlockBehaviour.Properties.copy(Blocks.STONE_BRICK_STAIRS)));

    public static final RegistryObject<Block> CS_TILE_P_BAND_SLAB = registerBlock("cs_tile_p_band_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.copy(Blocks.STONE_BRICK_SLAB)));

    public static final RegistryObject<Block> CS_TILE_P_BAND_WALL = registerBlock("cs_tile_p_band_wall",
            () -> new WallBlock(BlockBehaviour.Properties.copy(Blocks.STONE_BRICK_WALL)));

    public static final RegistryObject<Block> CS_TILE_P_FRAME = registerBlock("cs_tile_p_frame",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK)));

    public static final RegistryObject<Block> CS_TILE_P_FRAME_STAIRS = registerBlock("cs_tile_p_frame_stairs",
            () -> new StairBlock(() -> ModBlocks.CS_TILE_P_FRAME.get().defaultBlockState(),
                    BlockBehaviour.Properties.copy(Blocks.STONE_BRICK_STAIRS)));

    public static final RegistryObject<Block> CS_TILE_P_FRAME_SLAB = registerBlock("cs_tile_p_frame_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.copy(Blocks.STONE_BRICK_SLAB)));

    public static final RegistryObject<Block> CS_TILE_P_FRAME_WALL = registerBlock("cs_tile_p_frame_wall",
            () -> new WallBlock(BlockBehaviour.Properties.copy(Blocks.STONE_BRICK_WALL)));

    public static final RegistryObject<Block> CS_TILE_LG_BAND = registerBlock("cs_tile_lg_band",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK)));

    public static final RegistryObject<Block> CS_TILE_LG_BAND_STAIRS = registerBlock("cs_tile_lg_band_stairs",
            () -> new StairBlock(() -> ModBlocks.CS_TILE_LG_BAND.get().defaultBlockState(),
                    BlockBehaviour.Properties.copy(Blocks.STONE_BRICK_STAIRS)));

    public static final RegistryObject<Block> CS_TILE_LG_BAND_SLAB = registerBlock("cs_tile_lg_band_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.copy(Blocks.STONE_BRICK_SLAB)));

    public static final RegistryObject<Block> CS_TILE_LG_BAND_WALL = registerBlock("cs_tile_lg_band_wall",
            () -> new WallBlock(BlockBehaviour.Properties.copy(Blocks.STONE_BRICK_WALL)));

    public static final RegistryObject<Block> CS_TILE_LG_FRAME = registerBlock("cs_tile_lg_frame",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK)));

    public static final RegistryObject<Block> CS_TILE_LG_FRAME_STAIRS = registerBlock("cs_tile_lg_frame_stairs",
            () -> new StairBlock(() -> ModBlocks.CS_TILE_LG_FRAME.get().defaultBlockState(),
                    BlockBehaviour.Properties.copy(Blocks.STONE_BRICK_STAIRS)));

    public static final RegistryObject<Block> CS_TILE_LG_FRAME_SLAB = registerBlock("cs_tile_lg_frame_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.copy(Blocks.STONE_BRICK_SLAB)));

    public static final RegistryObject<Block> CS_TILE_LG_FRAME_WALL = registerBlock("cs_tile_lg_frame_wall",
            () -> new WallBlock(BlockBehaviour.Properties.copy(Blocks.STONE_BRICK_WALL)));

    public static final RegistryObject<Block> CS_TILE_MG_BAND = registerBlock("cs_tile_mg_band",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK)));

    public static final RegistryObject<Block> CS_TILE_MG_BAND_STAIRS = registerBlock("cs_tile_mg_band_stairs",
            () -> new StairBlock(() -> ModBlocks.CS_TILE_MG_BAND.get().defaultBlockState(),
                    BlockBehaviour.Properties.copy(Blocks.STONE_BRICK_STAIRS)));

    public static final RegistryObject<Block> CS_TILE_MG_BAND_SLAB = registerBlock("cs_tile_mg_band_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.copy(Blocks.STONE_BRICK_SLAB)));

    public static final RegistryObject<Block> CS_TILE_MG_BAND_WALL = registerBlock("cs_tile_mg_band_wall",
            () -> new WallBlock(BlockBehaviour.Properties.copy(Blocks.STONE_BRICK_WALL)));

    public static final RegistryObject<Block> CS_TILE_MG_FRAME = registerBlock("cs_tile_mg_frame",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK)));

    public static final RegistryObject<Block> CS_TILE_MG_FRAME_STAIRS = registerBlock("cs_tile_mg_frame_stairs",
            () -> new StairBlock(() -> ModBlocks.CS_TILE_MG_FRAME.get().defaultBlockState(),
                    BlockBehaviour.Properties.copy(Blocks.STONE_BRICK_STAIRS)));

    public static final RegistryObject<Block> CS_TILE_MG_FRAME_SLAB = registerBlock("cs_tile_mg_frame_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.copy(Blocks.STONE_BRICK_SLAB)));

    public static final RegistryObject<Block> CS_TILE_MG_FRAME_WALL = registerBlock("cs_tile_mg_frame_wall",
            () -> new WallBlock(BlockBehaviour.Properties.copy(Blocks.STONE_BRICK_WALL)));

    public static final RegistryObject<Block> CS_TILE_HG_BAND = registerBlock("cs_tile_hg_band",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK)));

    public static final RegistryObject<Block> CS_TILE_HG_BAND_STAIRS = registerBlock("cs_tile_hg_band_stairs",
            () -> new StairBlock(() -> ModBlocks.CS_TILE_HG_BAND.get().defaultBlockState(),
                    BlockBehaviour.Properties.copy(Blocks.STONE_BRICK_STAIRS)));

    public static final RegistryObject<Block> CS_TILE_HG_BAND_SLAB = registerBlock("cs_tile_hg_band_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.copy(Blocks.STONE_BRICK_SLAB)));

    public static final RegistryObject<Block> CS_TILE_HG_BAND_WALL = registerBlock("cs_tile_hg_band_wall",
            () -> new WallBlock(BlockBehaviour.Properties.copy(Blocks.STONE_BRICK_WALL)));

    public static final RegistryObject<Block> CS_TILE_HG_FRAME = registerBlock("cs_tile_hg_frame",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK)));

    public static final RegistryObject<Block> CS_TILE_HG_FRAME_STAIRS = registerBlock("cs_tile_hg_frame_stairs",
            () -> new StairBlock(() -> ModBlocks.CS_TILE_HG_FRAME.get().defaultBlockState(),
                    BlockBehaviour.Properties.copy(Blocks.STONE_BRICK_STAIRS)));

    public static final RegistryObject<Block> CS_TILE_HG_FRAME_SLAB = registerBlock("cs_tile_hg_frame_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.copy(Blocks.STONE_BRICK_SLAB)));

    public static final RegistryObject<Block> CS_TILE_HG_FRAME_WALL = registerBlock("cs_tile_hg_frame_wall",
            () -> new WallBlock(BlockBehaviour.Properties.copy(Blocks.STONE_BRICK_WALL)));

    public static final RegistryObject<Block> CS_PILLAR = registerBlock("cs_pillar",
            () -> new RotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.PURPUR_PILLAR)));

    public static final RegistryObject<Block> CS_PILLAR_G = registerBlock("cs_pillar_g",
            () -> new RotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.PURPUR_PILLAR)));

    public static final RegistryObject<Block> CS_PILLAR_G_2 = registerBlock("cs_pillar_g_2",
            () -> new RotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.PURPUR_PILLAR)));




    public static final RegistryObject<Block> CS_PILLAR_B = registerBlock("cs_pillar_b",
            () -> new RotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.PURPUR_PILLAR)));

    public static final RegistryObject<Block> CS_PILLAR_B_2 = registerBlock("cs_pillar_b_2",
            () -> new RotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.PURPUR_PILLAR)));




    public static final RegistryObject<Block> CS_PILLAR_R = registerBlock("cs_pillar_r",
            () -> new RotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.PURPUR_PILLAR)));

    public static final RegistryObject<Block> CS_PILLAR_R_2 = registerBlock("cs_pillar_r_2",
            () -> new RotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.PURPUR_PILLAR)));




    public static final RegistryObject<Block> CS_PILLAR_P = registerBlock("cs_pillar_p",
            () -> new RotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.PURPUR_PILLAR)));

    public static final RegistryObject<Block> CS_PILLAR_P_2 = registerBlock("cs_pillar_p_2",
            () -> new RotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.PURPUR_PILLAR)));




    public static final RegistryObject<Block> CS_PILLAR_LG = registerBlock("cs_pillar_lg",
            () -> new RotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.PURPUR_PILLAR)));

    public static final RegistryObject<Block> CS_PILLAR_LG_2 = registerBlock("cs_pillar_lg_2",
            () -> new RotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.PURPUR_PILLAR)));




    public static final RegistryObject<Block> CS_PILLAR_MG = registerBlock("cs_pillar_mg",
            () -> new RotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.PURPUR_PILLAR)));

    public static final RegistryObject<Block> CS_PILLAR_MG_2 = registerBlock("cs_pillar_mg_2",
            () -> new RotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.PURPUR_PILLAR)));




    public static final RegistryObject<Block> CS_PILLAR_HG = registerBlock("cs_pillar_hg",
            () -> new RotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.PURPUR_PILLAR)));

    public static final RegistryObject<Block> CS_PILLAR_HG_2 = registerBlock("cs_pillar_hg_2",
            () -> new RotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.PURPUR_PILLAR)));



        //Crystal Core Based:
            //Vertical Slab:
        public static final RegistryObject<Block> CT_PILLAR_TOP_VERT = registerBlock("ct_pillar_top_vert",
                () -> new ModVerticalSlabBlock(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK)));

    public static final RegistryObject<Block> CT_PILLAR_TOP_G_VERT = registerBlock("ct_pillar_top_g_vert",
            () -> new ModVerticalSlabBlock(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK)));

    public static final RegistryObject<Block> CT_PILLAR_TOP_B_VERT = registerBlock("ct_pillar_top_b_vert",
            () -> new ModVerticalSlabBlock(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK)));

    public static final RegistryObject<Block> CT_PILLAR_TOP_R_VERT = registerBlock("ct_pillar_top_r_vert",
            () -> new ModVerticalSlabBlock(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK)));

    public static final RegistryObject<Block> CT_PILLAR_TOP_P_VERT = registerBlock("ct_pillar_top_p_vert",
            () -> new ModVerticalSlabBlock(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK)));

    public static final RegistryObject<Block> CT_TILE_VERT_2= registerBlock("ct_tile_vert_2",
            () -> new ModVerticalSlabBlock(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK)));

    public static final RegistryObject<Block> CT_TILE_G_VERT_2 = registerBlock("ct_tile_g_vert_2",
            () -> new ModVerticalSlabBlock(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK)));

    public static final RegistryObject<Block> CT_TILE_B_VERT_2 = registerBlock("ct_tile_b_vert_2",
            () -> new ModVerticalSlabBlock(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK)));

    public static final RegistryObject<Block> CT_TILE_R_VERT_2 = registerBlock("ct_tile_r_vert_2",
            () -> new ModVerticalSlabBlock(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK)));

    public static final RegistryObject<Block> CT_TILE_P_VERT_2 = registerBlock("ct_tile_p_vert_2",
            () -> new ModVerticalSlabBlock(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK)));

    public static final RegistryObject<Block> CT_TILE_VERT_3= registerBlock("ct_tile_vert_3",
            () -> new ModVerticalSlabBlock(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK)));

    public static final RegistryObject<Block> CT_TILE_G_VERT_3 = registerBlock("ct_tile_g_vert_3",
            () -> new ModVerticalSlabBlock(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK)));

    public static final RegistryObject<Block> CT_TILE_B_VERT_3 = registerBlock("ct_tile_b_vert_3",
            () -> new ModVerticalSlabBlock(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK)));

    public static final RegistryObject<Block> CT_TILE_R_VERT_3 = registerBlock("ct_tile_r_vert_3",
            () -> new ModVerticalSlabBlock(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK)));

    public static final RegistryObject<Block> CT_TILE_P_VERT_3 = registerBlock("ct_tile_p_vert_3",
            () -> new ModVerticalSlabBlock(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK)));

            //Regular:
    public static final RegistryObject<Block> CT_PILLAR = registerBlock("ct_pillar",
                () -> new RotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.PURPUR_PILLAR).noOcclusion()));

    public static final RegistryObject<Block> CT_PILLAR_2 = registerBlock("ct_pillar_2",
            () -> new RotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.PURPUR_PILLAR).noOcclusion()));

    public static final RegistryObject<Block> CT_PILLAR_3 = registerBlock("ct_pillar_3",
            () -> new RotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.PURPUR_PILLAR).noOcclusion()));

    public static final RegistryObject<Block> CT_PILLAR_G = registerBlock("ct_pillar_g",
            () -> new RotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.PURPUR_PILLAR).noOcclusion()));

    public static final RegistryObject<Block> CT_PILLAR_G_2 = registerBlock("ct_pillar_g_2",
            () -> new RotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.PURPUR_PILLAR).noOcclusion()));
    
    public static final RegistryObject<Block> CT_PILLAR_B = registerBlock("ct_pillar_b",
            () -> new RotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.PURPUR_PILLAR).noOcclusion()));

    public static final RegistryObject<Block> CT_PILLAR_B_2 = registerBlock("ct_pillar_b_2",
            () -> new RotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.PURPUR_PILLAR).noOcclusion()));

    public static final RegistryObject<Block> CT_PILLAR_R = registerBlock("ct_pillar_r",
            () -> new RotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.PURPUR_PILLAR).noOcclusion()));

    public static final RegistryObject<Block> CT_PILLAR_R_2 = registerBlock("ct_pillar_r_2",
            () -> new RotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.PURPUR_PILLAR).noOcclusion()));

    public static final RegistryObject<Block> CT_PILLAR_P = registerBlock("ct_pillar_p",
            () -> new RotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.PURPUR_PILLAR).noOcclusion()));

    public static final RegistryObject<Block> CT_PILLAR_P_2 = registerBlock("ct_pillar_p_2",
            () -> new RotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.PURPUR_PILLAR).noOcclusion()));

    public static final RegistryObject<Block> CT_PILLAR_TOP = registerBlock("ct_pillar_top",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.PURPUR_PILLAR).noOcclusion()));

    public static final RegistryObject<Block> CT_TILE_STAIRS = registerBlock("ct_tile_stairs",
            () -> new StairBlock(() -> ModBlocks.CT_PILLAR_TOP.get().defaultBlockState(),
                    BlockBehaviour.Properties.copy(Blocks.STONE_BRICK_STAIRS).noOcclusion()));

    public static final RegistryObject<Block> CT_TILE_SLAB = registerBlock("ct_tile_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.copy(Blocks.STONE_BRICK_SLAB).noOcclusion()));

    public static final RegistryObject<Block> CT_TILE_WALL = registerBlock("ct_tile_wall",
            () -> new WallBlock(BlockBehaviour.Properties.copy(Blocks.STONE_BRICK_WALL).noOcclusion()));

    public static final RegistryObject<Block> CT_PILLAR_TOP_G = registerBlock("ct_pillar_top_g",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.PURPUR_PILLAR).noOcclusion()));

    public static final RegistryObject<Block> CT_TILE_STAIRS_G = registerBlock("ct_tile_stairs_g",
            () -> new StairBlock(() -> ModBlocks.CT_PILLAR_TOP_G.get().defaultBlockState(),
                    BlockBehaviour.Properties.copy(Blocks.STONE_BRICK_STAIRS).noOcclusion()));

    public static final RegistryObject<Block> CT_TILE_SLAB_G = registerBlock("ct_tile_slab_g",
            () -> new SlabBlock(BlockBehaviour.Properties.copy(Blocks.STONE_BRICK_SLAB).noOcclusion()));

    public static final RegistryObject<Block> CT_TILE_WALL_G = registerBlock("ct_tile_wall_g",
            () -> new WallBlock(BlockBehaviour.Properties.copy(Blocks.STONE_BRICK_WALL).noOcclusion()));

    public static final RegistryObject<Block> CT_PILLAR_TOP_B = registerBlock("ct_pillar_top_b",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.PURPUR_PILLAR).noOcclusion()));

    public static final RegistryObject<Block> CT_PILLAR_TOP_R = registerBlock("ct_pillar_top_r",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.PURPUR_PILLAR).noOcclusion()));

    public static final RegistryObject<Block> CT_PILLAR_TOP_P = registerBlock("ct_pillar_top_p",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.PURPUR_PILLAR).noOcclusion()));

    public static final RegistryObject<Block> CT_TILE_STAIRS_B = registerBlock("ct_tile_stairs_b",
            () -> new StairBlock(() -> ModBlocks.CT_PILLAR_TOP_B.get().defaultBlockState(),
                    BlockBehaviour.Properties.copy(Blocks.STONE_BRICK_STAIRS).noOcclusion()));

    public static final RegistryObject<Block> CT_TILE_SLAB_B = registerBlock("ct_tile_slab_b",
            () -> new SlabBlock(BlockBehaviour.Properties.copy(Blocks.STONE_BRICK_SLAB).noOcclusion()));

    public static final RegistryObject<Block> CT_TILE_WALL_B = registerBlock("ct_tile_wall_b",
            () -> new WallBlock(BlockBehaviour.Properties.copy(Blocks.STONE_BRICK_WALL).noOcclusion()));

    public static final RegistryObject<Block> CT_TILE_STAIRS_R = registerBlock("ct_tile_stairs_r",
            () -> new StairBlock(() -> ModBlocks.CT_PILLAR_TOP_R.get().defaultBlockState(),
                    BlockBehaviour.Properties.copy(Blocks.STONE_BRICK_STAIRS).noOcclusion()));

    public static final RegistryObject<Block> CT_TILE_SLAB_R = registerBlock("ct_tile_slab_r",
            () -> new SlabBlock(BlockBehaviour.Properties.copy(Blocks.STONE_BRICK_SLAB).noOcclusion()));

    public static final RegistryObject<Block> CT_TILE_WALL_R = registerBlock("ct_tile_wall_r",
            () -> new WallBlock(BlockBehaviour.Properties.copy(Blocks.STONE_BRICK_WALL).noOcclusion()));

    public static final RegistryObject<Block> CT_TILE_STAIRS_P = registerBlock("ct_tile_stairs_p",
            () -> new StairBlock(() -> ModBlocks.CT_PILLAR_TOP_P.get().defaultBlockState(),
                    BlockBehaviour.Properties.copy(Blocks.STONE_BRICK_STAIRS).noOcclusion()));

    public static final RegistryObject<Block> CT_TILE_SLAB_P = registerBlock("ct_tile_slab_p",
            () -> new SlabBlock(BlockBehaviour.Properties.copy(Blocks.STONE_BRICK_SLAB).noOcclusion()));

    public static final RegistryObject<Block> CT_TILE_WALL_P = registerBlock("ct_tile_wall_p",
            () -> new WallBlock(BlockBehaviour.Properties.copy(Blocks.STONE_BRICK_WALL).noOcclusion()));
    
    public static final RegistryObject<Block> CT_TILE_2 = registerBlock("ct_tile_2",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.PURPUR_PILLAR).noOcclusion()));

    public static final RegistryObject<Block> CT_TILE_STAIRS_2 = registerBlock("ct_tile_stairs_2",
            () -> new StairBlock(() -> ModBlocks.CT_TILE_2.get().defaultBlockState(),
                    BlockBehaviour.Properties.copy(Blocks.STONE_BRICK_STAIRS).noOcclusion()));

    public static final RegistryObject<Block> CT_TILE_SLAB_2 = registerBlock("ct_tile_slab_2",
            () -> new SlabBlock(BlockBehaviour.Properties.copy(Blocks.STONE_BRICK_SLAB).noOcclusion()));

    public static final RegistryObject<Block> CT_TILE_WALL_2 = registerBlock("ct_tile_wall_2",
            () -> new WallBlock(BlockBehaviour.Properties.copy(Blocks.STONE_BRICK_WALL).noOcclusion()));

    public static final RegistryObject<Block> CT_TILE_3 = registerBlock("ct_tile_3",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.PURPUR_PILLAR).noOcclusion()));

    public static final RegistryObject<Block> CT_TILE_STAIRS_3 = registerBlock("ct_tile_stairs_3",
            () -> new StairBlock(() -> ModBlocks.CT_TILE_3.get().defaultBlockState(),
                    BlockBehaviour.Properties.copy(Blocks.STONE_BRICK_STAIRS).noOcclusion()));

    public static final RegistryObject<Block> CT_TILE_SLAB_3 = registerBlock("ct_tile_slab_3",
            () -> new SlabBlock(BlockBehaviour.Properties.copy(Blocks.STONE_BRICK_SLAB).noOcclusion()));

    public static final RegistryObject<Block> CT_TILE_WALL_3 = registerBlock("ct_tile_wall_3",
            () -> new WallBlock(BlockBehaviour.Properties.copy(Blocks.STONE_BRICK_WALL).noOcclusion()));
    
    public static final RegistryObject<Block> CT_TILE_G_2 = registerBlock("ct_tile_g_2",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.PURPUR_PILLAR).noOcclusion()));

    public static final RegistryObject<Block> CT_TILE_STAIRS_G_2 = registerBlock("ct_tile_stairs_g_2",
            () -> new StairBlock(() -> ModBlocks.CT_TILE_G_2.get().defaultBlockState(),
                    BlockBehaviour.Properties.copy(Blocks.STONE_BRICK_STAIRS).noOcclusion()));

    public static final RegistryObject<Block> CT_TILE_SLAB_G_2 = registerBlock("ct_tile_slab_g_2",
            () -> new SlabBlock(BlockBehaviour.Properties.copy(Blocks.STONE_BRICK_SLAB).noOcclusion()));

    public static final RegistryObject<Block> CT_TILE_WALL_G_2 = registerBlock("ct_tile_wall_g_2",
            () -> new WallBlock(BlockBehaviour.Properties.copy(Blocks.STONE_BRICK_WALL).noOcclusion()));

    public static final RegistryObject<Block> CT_TILE_G_3 = registerBlock("ct_tile_g_3",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.PURPUR_PILLAR).noOcclusion()));

    public static final RegistryObject<Block> CT_TILE_STAIRS_G_3 = registerBlock("ct_tile_stairs_g_3",
            () -> new StairBlock(() -> ModBlocks.CT_TILE_G_3.get().defaultBlockState(),
                    BlockBehaviour.Properties.copy(Blocks.STONE_BRICK_STAIRS).noOcclusion()));

    public static final RegistryObject<Block> CT_TILE_SLAB_G_3 = registerBlock("ct_tile_slab_g_3",
            () -> new SlabBlock(BlockBehaviour.Properties.copy(Blocks.STONE_BRICK_SLAB).noOcclusion()));

    public static final RegistryObject<Block> CT_TILE_WALL_G_3 = registerBlock("ct_tile_wall_g_3",
            () -> new WallBlock(BlockBehaviour.Properties.copy(Blocks.STONE_BRICK_WALL).noOcclusion()));
    
    public static final RegistryObject<Block> CT_TILE_B_2 = registerBlock("ct_tile_b_2",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.PURPUR_PILLAR).noOcclusion()));

    public static final RegistryObject<Block> CT_TILE_STAIRS_B_2 = registerBlock("ct_tile_stairs_b_2",
            () -> new StairBlock(() -> ModBlocks.CT_TILE_B_2.get().defaultBlockState(),
                    BlockBehaviour.Properties.copy(Blocks.STONE_BRICK_STAIRS).noOcclusion()));

    public static final RegistryObject<Block> CT_TILE_SLAB_B_2 = registerBlock("ct_tile_slab_b_2",
            () -> new SlabBlock(BlockBehaviour.Properties.copy(Blocks.STONE_BRICK_SLAB).noOcclusion()));

    public static final RegistryObject<Block> CT_TILE_WALL_B_2 = registerBlock("ct_tile_wall_b_2",
            () -> new WallBlock(BlockBehaviour.Properties.copy(Blocks.STONE_BRICK_WALL).noOcclusion()));

    public static final RegistryObject<Block> CT_TILE_B_3 = registerBlock("ct_tile_b_3",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.PURPUR_PILLAR).noOcclusion()));

    public static final RegistryObject<Block> CT_TILE_STAIRS_B_3 = registerBlock("ct_tile_stairs_b_3",
            () -> new StairBlock(() -> ModBlocks.CT_TILE_B_3.get().defaultBlockState(),
                    BlockBehaviour.Properties.copy(Blocks.STONE_BRICK_STAIRS).noOcclusion()));

    public static final RegistryObject<Block> CT_TILE_SLAB_B_3 = registerBlock("ct_tile_slab_b_3",
            () -> new SlabBlock(BlockBehaviour.Properties.copy(Blocks.STONE_BRICK_SLAB).noOcclusion()));

    public static final RegistryObject<Block> CT_TILE_WALL_B_3 = registerBlock("ct_tile_wall_b_3",
            () -> new WallBlock(BlockBehaviour.Properties.copy(Blocks.STONE_BRICK_WALL).noOcclusion()));

    public static final RegistryObject<Block> CT_TILE_R_2 = registerBlock("ct_tile_r_2",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.PURPUR_PILLAR).noOcclusion()));

    public static final RegistryObject<Block> CT_TILE_STAIRS_R_2 = registerBlock("ct_tile_stairs_r_2",
            () -> new StairBlock(() -> ModBlocks.CT_TILE_R_2.get().defaultBlockState(),
                    BlockBehaviour.Properties.copy(Blocks.STONE_BRICK_STAIRS).noOcclusion()));

    public static final RegistryObject<Block> CT_TILE_SLAB_R_2 = registerBlock("ct_tile_slab_r_2",
            () -> new SlabBlock(BlockBehaviour.Properties.copy(Blocks.STONE_BRICK_SLAB).noOcclusion()));

    public static final RegistryObject<Block> CT_TILE_WALL_R_2 = registerBlock("ct_tile_wall_r_2",
            () -> new WallBlock(BlockBehaviour.Properties.copy(Blocks.STONE_BRICK_WALL).noOcclusion()));

    public static final RegistryObject<Block> CT_TILE_R_3 = registerBlock("ct_tile_r_3",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.PURPUR_PILLAR).noOcclusion()));

    public static final RegistryObject<Block> CT_TILE_STAIRS_R_3 = registerBlock("ct_tile_stairs_r_3",
            () -> new StairBlock(() -> ModBlocks.CT_TILE_R_3.get().defaultBlockState(),
                    BlockBehaviour.Properties.copy(Blocks.STONE_BRICK_STAIRS).noOcclusion()));

    public static final RegistryObject<Block> CT_TILE_SLAB_R_3 = registerBlock("ct_tile_slab_r_3",
            () -> new SlabBlock(BlockBehaviour.Properties.copy(Blocks.STONE_BRICK_SLAB).noOcclusion()));

    public static final RegistryObject<Block> CT_TILE_WALL_R_3 = registerBlock("ct_tile_wall_r_3",
            () -> new WallBlock(BlockBehaviour.Properties.copy(Blocks.STONE_BRICK_WALL).noOcclusion()));

    public static final RegistryObject<Block> CT_TILE_P_2 = registerBlock("ct_tile_p_2",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.PURPUR_PILLAR).noOcclusion()));

    public static final RegistryObject<Block> CT_TILE_STAIRS_P_2 = registerBlock("ct_tile_stairs_p_2",
            () -> new StairBlock(() -> ModBlocks.CT_TILE_P_2.get().defaultBlockState(),
                    BlockBehaviour.Properties.copy(Blocks.STONE_BRICK_STAIRS).noOcclusion()));

    public static final RegistryObject<Block> CT_TILE_SLAB_P_2 = registerBlock("ct_tile_slab_p_2",
            () -> new SlabBlock(BlockBehaviour.Properties.copy(Blocks.STONE_BRICK_SLAB).noOcclusion()));

    public static final RegistryObject<Block> CT_TILE_WALL_P_2 = registerBlock("ct_tile_wall_p_2",
            () -> new WallBlock(BlockBehaviour.Properties.copy(Blocks.STONE_BRICK_WALL).noOcclusion()));

    public static final RegistryObject<Block> CT_TILE_P_3 = registerBlock("ct_tile_p_3",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.PURPUR_PILLAR).noOcclusion()));

    public static final RegistryObject<Block> CT_TILE_STAIRS_P_3 = registerBlock("ct_tile_stairs_p_3",
            () -> new StairBlock(() -> ModBlocks.CT_TILE_P_3.get().defaultBlockState(),
                    BlockBehaviour.Properties.copy(Blocks.STONE_BRICK_STAIRS).noOcclusion()));

    public static final RegistryObject<Block> CT_TILE_SLAB_P_3 = registerBlock("ct_tile_slab_p_3",
            () -> new SlabBlock(BlockBehaviour.Properties.copy(Blocks.STONE_BRICK_SLAB).noOcclusion()));

    public static final RegistryObject<Block> CT_TILE_WALL_P_3 = registerBlock("ct_tile_wall_p_3",
            () -> new WallBlock(BlockBehaviour.Properties.copy(Blocks.STONE_BRICK_WALL).noOcclusion()));




    //End of Deco Blocks


    //Lamps, Lights, and Torch-likes:
    public static final RegistryObject<Block> CRYSTAL_CORE_LAMP_G = registerBlock("crystal_core_lamp_g",
            () -> new CrystalCoreLampBlock(BlockBehaviour.Properties.of().sound(SoundType.GLASS)
                    .lightLevel(state -> state.getValue(CrystalCoreLampBlock.LIT) ? 15 : 0)
                    .strength(3f)));

    public static final RegistryObject<Block> INVERTED_CRYSTAL_CORE_LAMP_G = registerBlock("inverted_crystal_core_lamp_g",
            () -> new CrystalCoreLampBlock(BlockBehaviour.Properties.of().sound(SoundType.GLASS)
                    .lightLevel(state -> state.getValue(CrystalCoreLampBlock.LIT) ? 0 : 15)
                    .strength(3f)));

    public static final RegistryObject<Block> CRYSTAL_CORE_LAMP_B = registerBlock("crystal_core_lamp_b",
            () -> new CrystalCoreLampBlock(BlockBehaviour.Properties.of().sound(SoundType.GLASS)
                    .lightLevel(state -> state.getValue(CrystalCoreLampBlock.LIT) ? 15 : 0)
                    .strength(3f)));

    public static final RegistryObject<Block> INVERTED_CRYSTAL_CORE_LAMP_B = registerBlock("inverted_crystal_core_lamp_b",
            () -> new CrystalCoreLampBlock(BlockBehaviour.Properties.of().sound(SoundType.GLASS)
                    .lightLevel(state -> state.getValue(CrystalCoreLampBlock.LIT) ? 0 : 15)
                    .strength(3f)));

    public static final RegistryObject<Block> CRYSTAL_CORE_LAMP_R = registerBlock("crystal_core_lamp_r",
            () -> new CrystalCoreLampBlock(BlockBehaviour.Properties.of().sound(SoundType.GLASS)
                    .lightLevel(state -> state.getValue(CrystalCoreLampBlock.LIT) ? 15 : 0)
                    .strength(3f)));

    public static final RegistryObject<Block> INVERTED_CRYSTAL_CORE_LAMP_R = registerBlock("inverted_crystal_core_lamp_r",
            () -> new CrystalCoreLampBlock(BlockBehaviour.Properties.of().sound(SoundType.GLASS)
                    .lightLevel(state -> state.getValue(CrystalCoreLampBlock.LIT) ? 0 : 15)
                    .strength(3f)));

    public static final RegistryObject<Block> CRYSTAL_CORE_LAMP_P = registerBlock("crystal_core_lamp_p",
            () -> new CrystalCoreLampBlock(BlockBehaviour.Properties.of().sound(SoundType.GLASS)
                    .lightLevel(state -> state.getValue(CrystalCoreLampBlock.LIT) ? 15 : 0)
                    .strength(3f)));

    public static final RegistryObject<Block> INVERTED_CRYSTAL_CORE_LAMP_P = registerBlock("inverted_crystal_core_lamp_p",
            () -> new CrystalCoreLampBlock(BlockBehaviour.Properties.of().sound(SoundType.GLASS)
                    .lightLevel(state -> state.getValue(CrystalCoreLampBlock.LIT) ? 0 : 15)
                    .strength(3f)));

    public static final RegistryObject<Block> CRYSTAL_CORE_LIGHT = registerBlock("crystal_core_light",
            () -> new CrystalCoreLampBlock(BlockBehaviour.Properties.of().sound(SoundType.GLASS)
                    .lightLevel(state -> state.getValue(CrystalCoreLampBlock.LIT) ? 15 : 0)
                    .strength(3f)));

    public static final RegistryObject<Block> INVERTED_CRYSTAL_CORE_LIGHT = registerBlock("inverted_crystal_core_light",
            () -> new CrystalCoreLampBlock(BlockBehaviour.Properties.of().sound(SoundType.GLASS)
                    .lightLevel(state -> state.getValue(CrystalCoreLampBlock.LIT) ? 0 : 15)
                    .strength(3f)));

    public static final RegistryObject<Block> VERT_CRYSTAL_CORE_LIGHT = registerBlock("vert_crystal_core_light",
            () -> new CrystalCoreLampBlock(BlockBehaviour.Properties.of().sound(SoundType.GLASS)
                    .lightLevel(state -> state.getValue(CrystalCoreLampBlock.LIT) ? 15 : 0)
                    .strength(3f)));

    public static final RegistryObject<Block> INVERTED_VERT_CRYSTAL_CORE_LIGHT = registerBlock("inverted_vert_crystal_core_light",
            () -> new CrystalCoreLampBlock(BlockBehaviour.Properties.of().sound(SoundType.GLASS)
                    .lightLevel(state -> state.getValue(CrystalCoreLampBlock.LIT) ? 0 : 15)
                    .strength(3f)));

    public static final RegistryObject<Block> BLACK_CRYSTAL_CORE_LIGHT = registerBlock("black_crystal_core_light",
            () -> new CrystalCoreLampBlock(BlockBehaviour.Properties.of().sound(SoundType.GLASS)
                    .lightLevel(state -> state.getValue(CrystalCoreLampBlock.LIT) ? 15 : 0)
                    .strength(3f)));

    public static final RegistryObject<Block> INVERTED_BLACK_CRYSTAL_CORE_LIGHT = registerBlock("inverted_black_crystal_core_light",
            () -> new CrystalCoreLampBlock(BlockBehaviour.Properties.of().sound(SoundType.GLASS)
                    .lightLevel(state -> state.getValue(CrystalCoreLampBlock.LIT) ? 0 : 15)
                    .strength(3f)));

    public static final RegistryObject<Block> BLACK_VERT_CRYSTAL_CORE_LIGHT = registerBlock("black_vert_crystal_core_light",
            () -> new CrystalCoreLampBlock(BlockBehaviour.Properties.of().sound(SoundType.GLASS)
                    .lightLevel(state -> state.getValue(CrystalCoreLampBlock.LIT) ? 15 : 0)
                    .strength(3f)));

    public static final RegistryObject<Block> INVERTED_BLACK_VERT_CRYSTAL_CORE_LIGHT = registerBlock("inverted_black_vert_crystal_core_light",
            () -> new CrystalCoreLampBlock(BlockBehaviour.Properties.of().sound(SoundType.GLASS)
                    .lightLevel(state -> state.getValue(CrystalCoreLampBlock.LIT) ? 0 : 15)
                    .strength(3f)));






    public static final RegistryObject<Block> BLUE_CRYSTAL_CORE_LIGHT = registerBlock("blue_crystal_core_light",
            () -> new CrystalCoreLampBlock(BlockBehaviour.Properties.of().sound(SoundType.GLASS)
                    .lightLevel(state -> state.getValue(CrystalCoreLampBlock.LIT) ? 15 : 0)
                    .strength(3f)));

    public static final RegistryObject<Block> INVERTED_BLUE_CRYSTAL_CORE_LIGHT = registerBlock("inverted_blue_crystal_core_light",
            () -> new CrystalCoreLampBlock(BlockBehaviour.Properties.of().sound(SoundType.GLASS)
                    .lightLevel(state -> state.getValue(CrystalCoreLampBlock.LIT) ? 0 : 15)
                    .strength(3f)));

    public static final RegistryObject<Block> BLUE_VERT_CRYSTAL_CORE_LIGHT = registerBlock("blue_vert_crystal_core_light",
            () -> new CrystalCoreLampBlock(BlockBehaviour.Properties.of().sound(SoundType.GLASS)
                    .lightLevel(state -> state.getValue(CrystalCoreLampBlock.LIT) ? 15 : 0)
                    .strength(3f)));

    public static final RegistryObject<Block> INVERTED_BLUE_VERT_CRYSTAL_CORE_LIGHT = registerBlock("inverted_blue_vert_crystal_core_light",
            () -> new CrystalCoreLampBlock(BlockBehaviour.Properties.of().sound(SoundType.GLASS)
                    .lightLevel(state -> state.getValue(CrystalCoreLampBlock.LIT) ? 0 : 15)
                    .strength(3f)));


    public static final RegistryObject<Block> BROWN_CRYSTAL_CORE_LIGHT = registerBlock("brown_crystal_core_light",
            () -> new CrystalCoreLampBlock(BlockBehaviour.Properties.of().sound(SoundType.GLASS)
                    .lightLevel(state -> state.getValue(CrystalCoreLampBlock.LIT) ? 15 : 0)
                    .strength(3f)));

    public static final RegistryObject<Block> INVERTED_BROWN_CRYSTAL_CORE_LIGHT = registerBlock("inverted_brown_crystal_core_light",
            () -> new CrystalCoreLampBlock(BlockBehaviour.Properties.of().sound(SoundType.GLASS)
                    .lightLevel(state -> state.getValue(CrystalCoreLampBlock.LIT) ? 0 : 15)
                    .strength(3f)));

    public static final RegistryObject<Block> BROWN_VERT_CRYSTAL_CORE_LIGHT = registerBlock("brown_vert_crystal_core_light",
            () -> new CrystalCoreLampBlock(BlockBehaviour.Properties.of().sound(SoundType.GLASS)
                    .lightLevel(state -> state.getValue(CrystalCoreLampBlock.LIT) ? 15 : 0)
                    .strength(3f)));

    public static final RegistryObject<Block> INVERTED_BROWN_VERT_CRYSTAL_CORE_LIGHT = registerBlock("inverted_brown_vert_crystal_core_light",
            () -> new CrystalCoreLampBlock(BlockBehaviour.Properties.of().sound(SoundType.GLASS)
                    .lightLevel(state -> state.getValue(CrystalCoreLampBlock.LIT) ? 0 : 15)
                    .strength(3f)));


    public static final RegistryObject<Block> CYAN_CRYSTAL_CORE_LIGHT = registerBlock("cyan_crystal_core_light",
            () -> new CrystalCoreLampBlock(BlockBehaviour.Properties.of().sound(SoundType.GLASS)
                    .lightLevel(state -> state.getValue(CrystalCoreLampBlock.LIT) ? 15 : 0)
                    .strength(3f)));

    public static final RegistryObject<Block> INVERTED_CYAN_CRYSTAL_CORE_LIGHT = registerBlock("inverted_cyan_crystal_core_light",
            () -> new CrystalCoreLampBlock(BlockBehaviour.Properties.of().sound(SoundType.GLASS)
                    .lightLevel(state -> state.getValue(CrystalCoreLampBlock.LIT) ? 0 : 15)
                    .strength(3f)));

    public static final RegistryObject<Block> CYAN_VERT_CRYSTAL_CORE_LIGHT = registerBlock("cyan_vert_crystal_core_light",
            () -> new CrystalCoreLampBlock(BlockBehaviour.Properties.of().sound(SoundType.GLASS)
                    .lightLevel(state -> state.getValue(CrystalCoreLampBlock.LIT) ? 15 : 0)
                    .strength(3f)));

    public static final RegistryObject<Block> INVERTED_CYAN_VERT_CRYSTAL_CORE_LIGHT = registerBlock("inverted_cyan_vert_crystal_core_light",
            () -> new CrystalCoreLampBlock(BlockBehaviour.Properties.of().sound(SoundType.GLASS)
                    .lightLevel(state -> state.getValue(CrystalCoreLampBlock.LIT) ? 0 : 15)
                    .strength(3f)));


    public static final RegistryObject<Block> GREEN_CRYSTAL_CORE_LIGHT = registerBlock("green_crystal_core_light",
            () -> new CrystalCoreLampBlock(BlockBehaviour.Properties.of().sound(SoundType.GLASS)
                    .lightLevel(state -> state.getValue(CrystalCoreLampBlock.LIT) ? 15 : 0)
                    .strength(3f)));

    public static final RegistryObject<Block> INVERTED_GREEN_CRYSTAL_CORE_LIGHT = registerBlock("inverted_green_crystal_core_light",
            () -> new CrystalCoreLampBlock(BlockBehaviour.Properties.of().sound(SoundType.GLASS)
                    .lightLevel(state -> state.getValue(CrystalCoreLampBlock.LIT) ? 0 : 15).strength(3f)));

    public static final RegistryObject<Block> GREEN_VERT_CRYSTAL_CORE_LIGHT = registerBlock("green_vert_crystal_core_light",
            () -> new CrystalCoreLampBlock(BlockBehaviour.Properties.of().sound(SoundType.GLASS)
                    .lightLevel(state -> state.getValue(CrystalCoreLampBlock.LIT) ? 15 : 0).strength(3f)));

    public static final RegistryObject<Block> INVERTED_GREEN_VERT_CRYSTAL_CORE_LIGHT = registerBlock("inverted_green_vert_crystal_core_light",
            () -> new CrystalCoreLampBlock(BlockBehaviour.Properties.of().sound(SoundType.GLASS)
                    .lightLevel(state -> state.getValue(CrystalCoreLampBlock.LIT) ? 0 : 15).strength(3f)));

    public static final RegistryObject<Block> GREY_CRYSTAL_CORE_LIGHT = registerBlock("grey_crystal_core_light",
            () -> new CrystalCoreLampBlock(BlockBehaviour.Properties.of().sound(SoundType.GLASS)
                    .lightLevel(state -> state.getValue(CrystalCoreLampBlock.LIT) ? 15 : 0).strength(3f)));

    public static final RegistryObject<Block> INVERTED_GREY_CRYSTAL_CORE_LIGHT = registerBlock("inverted_grey_crystal_core_light",
            () -> new CrystalCoreLampBlock(BlockBehaviour.Properties.of().sound(SoundType.GLASS)
                    .lightLevel(state -> state.getValue(CrystalCoreLampBlock.LIT) ? 0 : 15).strength(3f)));

    public static final RegistryObject<Block> GREY_VERT_CRYSTAL_CORE_LIGHT = registerBlock("grey_vert_crystal_core_light",
            () -> new CrystalCoreLampBlock(BlockBehaviour.Properties.of().sound(SoundType.GLASS)
                    .lightLevel(state -> state.getValue(CrystalCoreLampBlock.LIT) ? 15 : 0).strength(3f)));

    public static final RegistryObject<Block> INVERTED_GREY_VERT_CRYSTAL_CORE_LIGHT = registerBlock("inverted_grey_vert_crystal_core_light",
            () -> new CrystalCoreLampBlock(BlockBehaviour.Properties.of().sound(SoundType.GLASS)
                    .lightLevel(state -> state.getValue(CrystalCoreLampBlock.LIT) ? 0 : 15).strength(3f)));

    public static final RegistryObject<Block> LIGHT_BLUE_CRYSTAL_CORE_LIGHT = registerBlock("light_blue_crystal_core_light",
            () -> new CrystalCoreLampBlock(BlockBehaviour.Properties.of().sound(SoundType.GLASS)
                    .lightLevel(state -> state.getValue(CrystalCoreLampBlock.LIT) ? 15 : 0).strength(3f)));

    public static final RegistryObject<Block> INVERTED_LIGHT_BLUE_CRYSTAL_CORE_LIGHT = registerBlock("inverted_light_blue_crystal_core_light",
            () -> new CrystalCoreLampBlock(BlockBehaviour.Properties.of().sound(SoundType.GLASS)
                    .lightLevel(state -> state.getValue(CrystalCoreLampBlock.LIT) ? 0 : 15).strength(3f)));

    public static final RegistryObject<Block> LIGHT_BLUE_VERT_CRYSTAL_CORE_LIGHT = registerBlock("light_blue_vert_crystal_core_light",
            () -> new CrystalCoreLampBlock(BlockBehaviour.Properties.of().sound(SoundType.GLASS)
                    .lightLevel(state -> state.getValue(CrystalCoreLampBlock.LIT) ? 15 : 0).strength(3f)));

    public static final RegistryObject<Block> INVERTED_LIGHT_BLUE_VERT_CRYSTAL_CORE_LIGHT = registerBlock("inverted_light_blue_vert_crystal_core_light",
            () -> new CrystalCoreLampBlock(BlockBehaviour.Properties.of().sound(SoundType.GLASS)
                    .lightLevel(state -> state.getValue(CrystalCoreLampBlock.LIT) ? 0 : 15).strength(3f)));

    public static final RegistryObject<Block> LIGHT_GREY_CRYSTAL_CORE_LIGHT = registerBlock("light_grey_crystal_core_light",
            () -> new CrystalCoreLampBlock(BlockBehaviour.Properties.of().sound(SoundType.GLASS)
                    .lightLevel(state -> state.getValue(CrystalCoreLampBlock.LIT) ? 15 : 0).strength(3f)));

    public static final RegistryObject<Block> INVERTED_LIGHT_GREY_CRYSTAL_CORE_LIGHT = registerBlock("inverted_light_grey_crystal_core_light",
            () -> new CrystalCoreLampBlock(BlockBehaviour.Properties.of().sound(SoundType.GLASS)
                    .lightLevel(state -> state.getValue(CrystalCoreLampBlock.LIT) ? 0 : 15).strength(3f)));

    public static final RegistryObject<Block> LIGHT_GREY_VERT_CRYSTAL_CORE_LIGHT = registerBlock("light_grey_vert_crystal_core_light",
            () -> new CrystalCoreLampBlock(BlockBehaviour.Properties.of().sound(SoundType.GLASS)
                    .lightLevel(state -> state.getValue(CrystalCoreLampBlock.LIT) ? 15 : 0).strength(3f)));

    public static final RegistryObject<Block> INVERTED_LIGHT_GREY_VERT_CRYSTAL_CORE_LIGHT = registerBlock("inverted_light_grey_vert_crystal_core_light",
            () -> new CrystalCoreLampBlock(BlockBehaviour.Properties.of().sound(SoundType.GLASS)
                    .lightLevel(state -> state.getValue(CrystalCoreLampBlock.LIT) ? 0 : 15).strength(3f)));

    public static final RegistryObject<Block> LIME_CRYSTAL_CORE_LIGHT = registerBlock("lime_crystal_core_light",
            () -> new CrystalCoreLampBlock(BlockBehaviour.Properties.of().sound(SoundType.GLASS)
                    .lightLevel(state -> state.getValue(CrystalCoreLampBlock.LIT) ? 15 : 0).strength(3f)));

    public static final RegistryObject<Block> INVERTED_LIME_CRYSTAL_CORE_LIGHT = registerBlock("inverted_lime_crystal_core_light",
            () -> new CrystalCoreLampBlock(BlockBehaviour.Properties.of().sound(SoundType.GLASS)
                    .lightLevel(state -> state.getValue(CrystalCoreLampBlock.LIT) ? 0 : 15).strength(3f)));

    public static final RegistryObject<Block> LIME_VERT_CRYSTAL_CORE_LIGHT = registerBlock("lime_vert_crystal_core_light",
            () -> new CrystalCoreLampBlock(BlockBehaviour.Properties.of().sound(SoundType.GLASS)
                    .lightLevel(state -> state.getValue(CrystalCoreLampBlock.LIT) ? 15 : 0).strength(3f)));

    public static final RegistryObject<Block> INVERTED_LIME_VERT_CRYSTAL_CORE_LIGHT = registerBlock("inverted_lime_vert_crystal_core_light",
            () -> new CrystalCoreLampBlock(BlockBehaviour.Properties.of().sound(SoundType.GLASS)
                    .lightLevel(state -> state.getValue(CrystalCoreLampBlock.LIT) ? 0 : 15).strength(3f)));


    public static final RegistryObject<Block> MAGENTA_CRYSTAL_CORE_LIGHT = registerBlock("magenta_crystal_core_light",
            () -> new CrystalCoreLampBlock(BlockBehaviour.Properties.of().sound(SoundType.GLASS)
                    .lightLevel(state -> state.getValue(CrystalCoreLampBlock.LIT) ? 15 : 0).strength(3f)));

    public static final RegistryObject<Block> INVERTED_MAGENTA_CRYSTAL_CORE_LIGHT = registerBlock("inverted_magenta_crystal_core_light",
            () -> new CrystalCoreLampBlock(BlockBehaviour.Properties.of().sound(SoundType.GLASS)
                    .lightLevel(state -> state.getValue(CrystalCoreLampBlock.LIT) ? 0 : 15).strength(3f)));

    public static final RegistryObject<Block> MAGENTA_VERT_CRYSTAL_CORE_LIGHT = registerBlock("magenta_vert_crystal_core_light",
            () -> new CrystalCoreLampBlock(BlockBehaviour.Properties.of().sound(SoundType.GLASS)
                    .lightLevel(state -> state.getValue(CrystalCoreLampBlock.LIT) ? 15 : 0).strength(3f)));

    public static final RegistryObject<Block> INVERTED_MAGENTA_VERT_CRYSTAL_CORE_LIGHT = registerBlock("inverted_magenta_vert_crystal_core_light",
            () -> new CrystalCoreLampBlock(BlockBehaviour.Properties.of().sound(SoundType.GLASS)
                    .lightLevel(state -> state.getValue(CrystalCoreLampBlock.LIT) ? 0 : 15).strength(3f)));

    public static final RegistryObject<Block> ORANGE_CRYSTAL_CORE_LIGHT = registerBlock("orange_crystal_core_light",
            () -> new CrystalCoreLampBlock(BlockBehaviour.Properties.of().sound(SoundType.GLASS)
                    .lightLevel(state -> state.getValue(CrystalCoreLampBlock.LIT) ? 15 : 0).strength(3f)));

    public static final RegistryObject<Block> INVERTED_ORANGE_CRYSTAL_CORE_LIGHT = registerBlock("inverted_orange_crystal_core_light",
            () -> new CrystalCoreLampBlock(BlockBehaviour.Properties.of().sound(SoundType.GLASS)
                    .lightLevel(state -> state.getValue(CrystalCoreLampBlock.LIT) ? 0 : 15).strength(3f)));

    public static final RegistryObject<Block> ORANGE_VERT_CRYSTAL_CORE_LIGHT = registerBlock("orange_vert_crystal_core_light",
            () -> new CrystalCoreLampBlock(BlockBehaviour.Properties.of().sound(SoundType.GLASS)
                    .lightLevel(state -> state.getValue(CrystalCoreLampBlock.LIT) ? 15 : 0).strength(3f)));

    public static final RegistryObject<Block> INVERTED_ORANGE_VERT_CRYSTAL_CORE_LIGHT = registerBlock("inverted_orange_vert_crystal_core_light",
            () -> new CrystalCoreLampBlock(BlockBehaviour.Properties.of().sound(SoundType.GLASS)
                    .lightLevel(state -> state.getValue(CrystalCoreLampBlock.LIT) ? 0 : 15).strength(3f)));

    public static final RegistryObject<Block> PINK_CRYSTAL_CORE_LIGHT = registerBlock("pink_crystal_core_light",
            () -> new CrystalCoreLampBlock(BlockBehaviour.Properties.of().sound(SoundType.GLASS)
                    .lightLevel(state -> state.getValue(CrystalCoreLampBlock.LIT) ? 15 : 0).strength(3f)));

    public static final RegistryObject<Block> INVERTED_PINK_CRYSTAL_CORE_LIGHT = registerBlock("inverted_pink_crystal_core_light",
            () -> new CrystalCoreLampBlock(BlockBehaviour.Properties.of().sound(SoundType.GLASS)
                    .lightLevel(state -> state.getValue(CrystalCoreLampBlock.LIT) ? 0 : 15).strength(3f)));

    public static final RegistryObject<Block> PINK_VERT_CRYSTAL_CORE_LIGHT = registerBlock("pink_vert_crystal_core_light",
            () -> new CrystalCoreLampBlock(BlockBehaviour.Properties.of().sound(SoundType.GLASS)
                    .lightLevel(state -> state.getValue(CrystalCoreLampBlock.LIT) ? 15 : 0).strength(3f)));

    public static final RegistryObject<Block> INVERTED_PINK_VERT_CRYSTAL_CORE_LIGHT = registerBlock("inverted_pink_vert_crystal_core_light",
            () -> new CrystalCoreLampBlock(BlockBehaviour.Properties.of().sound(SoundType.GLASS)
                    .lightLevel(state -> state.getValue(CrystalCoreLampBlock.LIT) ? 0 : 15).strength(3f)));

    public static final RegistryObject<Block> PURPLE_CRYSTAL_CORE_LIGHT = registerBlock("purple_crystal_core_light",
            () -> new CrystalCoreLampBlock(BlockBehaviour.Properties.of().sound(SoundType.GLASS)
                    .lightLevel(state -> state.getValue(CrystalCoreLampBlock.LIT) ? 15 : 0).strength(3f)));

    public static final RegistryObject<Block> INVERTED_PURPLE_CRYSTAL_CORE_LIGHT = registerBlock("inverted_purple_crystal_core_light",
            () -> new CrystalCoreLampBlock(BlockBehaviour.Properties.of().sound(SoundType.GLASS)
                    .lightLevel(state -> state.getValue(CrystalCoreLampBlock.LIT) ? 0 : 15).strength(3f)));

    public static final RegistryObject<Block> PURPLE_VERT_CRYSTAL_CORE_LIGHT = registerBlock("purple_vert_crystal_core_light",
            () -> new CrystalCoreLampBlock(BlockBehaviour.Properties.of().sound(SoundType.GLASS)
                    .lightLevel(state -> state.getValue(CrystalCoreLampBlock.LIT) ? 15 : 0).strength(3f)));

    public static final RegistryObject<Block> INVERTED_PURPLE_VERT_CRYSTAL_CORE_LIGHT = registerBlock("inverted_purple_vert_crystal_core_light",
            () -> new CrystalCoreLampBlock(BlockBehaviour.Properties.of().sound(SoundType.GLASS)
                    .lightLevel(state -> state.getValue(CrystalCoreLampBlock.LIT) ? 0 : 15).strength(3f)));

    public static final RegistryObject<Block> FLAME_CRYSTAL_CORE_LIGHT = registerBlock("flame_crystal_core_light",
            () -> new CrystalCoreLampBlock(BlockBehaviour.Properties.of().sound(SoundType.GLASS)
                    .lightLevel(state -> state.getValue(CrystalCoreLampBlock.LIT) ? 15 : 0).strength(3f)));

    public static final RegistryObject<Block> INVERTED_FLAME_CRYSTAL_CORE_LIGHT = registerBlock("inverted_flame_crystal_core_light",
            () -> new CrystalCoreLampBlock(BlockBehaviour.Properties.of().sound(SoundType.GLASS)
                    .lightLevel(state -> state.getValue(CrystalCoreLampBlock.LIT) ? 0 : 15).strength(3f)));

    public static final RegistryObject<Block> FLAME_VERT_CRYSTAL_CORE_LIGHT = registerBlock("flame_vert_crystal_core_light",
            () -> new CrystalCoreLampBlock(BlockBehaviour.Properties.of().sound(SoundType.GLASS)
                    .lightLevel(state -> state.getValue(CrystalCoreLampBlock.LIT) ? 15 : 0).strength(3f)));

    public static final RegistryObject<Block> INVERTED_FLAME_VERT_CRYSTAL_CORE_LIGHT = registerBlock("inverted_flame_vert_crystal_core_light",
            () -> new CrystalCoreLampBlock(BlockBehaviour.Properties.of().sound(SoundType.GLASS)
                    .lightLevel(state -> state.getValue(CrystalCoreLampBlock.LIT) ? 0 : 15).strength(3f)));

    public static final RegistryObject<Block> RED_CRYSTAL_CORE_LIGHT = registerBlock("red_crystal_core_light",
            () -> new CrystalCoreLampBlock(BlockBehaviour.Properties.of().sound(SoundType.GLASS)
                    .lightLevel(state -> state.getValue(CrystalCoreLampBlock.LIT) ? 15 : 0).strength(3f)));

    public static final RegistryObject<Block> INVERTED_RED_CRYSTAL_CORE_LIGHT = registerBlock("inverted_red_crystal_core_light",
            () -> new CrystalCoreLampBlock(BlockBehaviour.Properties.of().sound(SoundType.GLASS)
                    .lightLevel(state -> state.getValue(CrystalCoreLampBlock.LIT) ? 0 : 15).strength(3f)));

    public static final RegistryObject<Block> RED_VERT_CRYSTAL_CORE_LIGHT = registerBlock("red_vert_crystal_core_light",
            () -> new CrystalCoreLampBlock(BlockBehaviour.Properties.of().sound(SoundType.GLASS)
                    .lightLevel(state -> state.getValue(CrystalCoreLampBlock.LIT) ? 15 : 0).strength(3f)));

    public static final RegistryObject<Block> INVERTED_RED_VERT_CRYSTAL_CORE_LIGHT = registerBlock("inverted_red_vert_crystal_core_light",
            () -> new CrystalCoreLampBlock(BlockBehaviour.Properties.of().sound(SoundType.GLASS)
                    .lightLevel(state -> state.getValue(CrystalCoreLampBlock.LIT) ? 0 : 15).strength(3f)));

    public static final RegistryObject<Block> WHITE_CRYSTAL_CORE_LIGHT = registerBlock("white_crystal_core_light",
            () -> new CrystalCoreLampBlock(BlockBehaviour.Properties.of().sound(SoundType.GLASS)
                    .lightLevel(state -> state.getValue(CrystalCoreLampBlock.LIT) ? 15 : 0).strength(3f)));

    public static final RegistryObject<Block> INVERTED_WHITE_CRYSTAL_CORE_LIGHT = registerBlock("inverted_white_crystal_core_light",
            () -> new CrystalCoreLampBlock(BlockBehaviour.Properties.of().sound(SoundType.GLASS)
                    .lightLevel(state -> state.getValue(CrystalCoreLampBlock.LIT) ? 0 : 15).strength(3f)));

    public static final RegistryObject<Block> WHITE_VERT_CRYSTAL_CORE_LIGHT = registerBlock("white_vert_crystal_core_light",
            () -> new CrystalCoreLampBlock(BlockBehaviour.Properties.of().sound(SoundType.GLASS)
                    .lightLevel(state -> state.getValue(CrystalCoreLampBlock.LIT) ? 15 : 0).strength(3f)));

    public static final RegistryObject<Block> INVERTED_WHITE_VERT_CRYSTAL_CORE_LIGHT = registerBlock("inverted_white_vert_crystal_core_light",
            () -> new CrystalCoreLampBlock(BlockBehaviour.Properties.of().sound(SoundType.GLASS)
                    .lightLevel(state -> state.getValue(CrystalCoreLampBlock.LIT) ? 0 : 15).strength(3f)));


    //End of Lamps, Lights, and Torch-likes:


    //Wood:

    public static final RegistryObject<Block> PLAGUED_LOG = registerBlock("plagued_log",
            () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.OAK_LOG).strength(3f)));

    public static final RegistryObject<Block> PLAGUED_WOOD = registerBlock("plagued_wood",
            () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.OAK_LOG).strength(3f)));

    public static final RegistryObject<Block> STRIPPED_PLAGUED_LOG = registerBlock("stripped_plagued_log",
            () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.STRIPPED_OAK_LOG).strength(3f)));

    public static final RegistryObject<Block> STRIPPED_PLAGUED_WOOD = registerBlock("stripped_plagued_wood",
            () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.STRIPPED_OAK_WOOD).strength(3f)));

    public static final RegistryObject<Block> PLAGUED_LEAVES = registerBlock("plagued_leaves",
            () -> new PlaguedLeavesBlock(BlockBehaviour.Properties.copy(Blocks.OAK_LEAVES).lightLevel(tiberiumglow)));

    public static final RegistryObject<Block> PLAGUED_PLANKS = registerBlock("plagued_planks",
            () -> new ModPlanksBlock(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS)));

    public static final RegistryObject<Block> PLAGUED_STAIRS = registerBlock("plagued_stairs",
            () -> new StairBlock(() -> ModBlocks.PLAGUED_PLANKS.get().defaultBlockState(),
                    BlockBehaviour.Properties.copy(Blocks.OAK_STAIRS)));

    public static final RegistryObject<Block> PLAGUED_SLAB = registerBlock("plagued_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.copy(Blocks.OAK_SLAB)));

    public static final RegistryObject<Block> PLAGUED_BUTTON = registerBlock("plagued_button",
            () -> new ButtonBlock(BlockBehaviour.Properties.copy(Blocks.OAK_BUTTON),
                    BlockSetType.OAK, 20, true));

    public static final RegistryObject<Block> PLAGUED_PRESSURE_PLATE = registerBlock("plagued_pressure_plate",
            () -> new PressurePlateBlock(PressurePlateBlock.Sensitivity.EVERYTHING, BlockBehaviour
                    .Properties.copy(Blocks.OAK_PRESSURE_PLATE), BlockSetType.OAK));

    public static final RegistryObject<Block> PLAGUED_FENCE = registerBlock("plagued_fence",
            () -> new FenceBlock(BlockBehaviour.Properties.copy(Blocks.OAK_FENCE)));

    public static final RegistryObject<Block> PLAGUED_FENCE_GATE = registerBlock("plagued_fence_gate",
            () -> new FenceGateBlock(BlockBehaviour.Properties.copy(Blocks.OAK_FENCE_GATE),
                    SoundEvents.FENCE_GATE_OPEN, SoundEvents.FENCE_GATE_CLOSE));

    public static final RegistryObject<Block> PLAGUED_DOOR = registerBlock("plagued_door",
            () -> new DoorBlock(BlockBehaviour.Properties.copy(Blocks.OAK_DOOR).noOcclusion(),
                    BlockSetType.OAK));

    public static final RegistryObject<Block> PLAGUED_TRAPDOOR = registerBlock("plagued_trapdoor",
            () -> new TrapDoorBlock(BlockBehaviour.Properties.copy(Blocks.OAK_TRAPDOOR).noOcclusion(),
                    BlockSetType.OAK));

    public static final RegistryObject<Block> IRON_PLATING_DOOR = registerBlock("iron_plating_door",
            () -> new DoorBlock(BlockBehaviour.Properties.copy(Blocks.OAK_DOOR).noOcclusion(),
                    BlockSetType.OAK));

    public static final RegistryObject<Block> IRON_PLATING_TRAPDOOR = registerBlock("iron_plating_trapdoor",
            () -> new TrapDoorBlock(BlockBehaviour.Properties.copy(Blocks.OAK_TRAPDOOR).noOcclusion(),
                    BlockSetType.OAK));

    public static final RegistryObject<Block> EMBER_OAK_LOG = registerBlock("ember_oak_log",
            () -> new EmberLogBlock(BlockBehaviour.Properties.copy(Blocks.OAK_LOG).strength(3f)));

    public static final RegistryObject<Block> EMBER_OAK_WOOD = registerBlock("ember_oak_wood",
            () -> new EmberLogBlock(BlockBehaviour.Properties.copy(Blocks.OAK_LOG).strength(3f)));

    public static final RegistryObject<Block> STRIPPED_EMBER_OAK_LOG = registerBlock("stripped_ember_oak_log",
            () -> new RotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.STRIPPED_OAK_LOG).strength(3f)));

    public static final RegistryObject<Block> STRIPPED_EMBER_OAK_WOOD = registerBlock("stripped_ember_oak_wood",
            () -> new RotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.STRIPPED_OAK_WOOD).strength(3f)));

    public static final RegistryObject<Block> EMBER_OAK_LEAVES = registerBlock("ember_oak_leaves",
            () -> new EmberLeavesBlock(BlockBehaviour.Properties.copy(Blocks.OAK_LEAVES).lightLevel(blossomglow)));

    public static final RegistryObject<Block> EMBER_OAK_PLANKS = registerBlock("ember_oak_planks",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS)));

    public static final RegistryObject<Block> EMBER_OAK_STAIRS = registerBlock("ember_oak_stairs",
            () -> new StairBlock(() -> ModBlocks.EMBER_OAK_PLANKS.get().defaultBlockState(),
                    BlockBehaviour.Properties.copy(Blocks.OAK_STAIRS)));

    public static final RegistryObject<Block> EMBER_OAK_SLAB = registerBlock("ember_oak_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.copy(Blocks.OAK_SLAB)));

    public static final RegistryObject<Block> EMBER_OAK_BUTTON = registerBlock("ember_oak_button",
            () -> new ButtonBlock(BlockBehaviour.Properties.copy(Blocks.OAK_BUTTON),
                    BlockSetType.OAK, 20, true));

    public static final RegistryObject<Block> EMBER_OAK_PRESSURE_PLATE = registerBlock("ember_oak_pressure_plate",
            () -> new PressurePlateBlock(PressurePlateBlock.Sensitivity.EVERYTHING, BlockBehaviour
                    .Properties.copy(Blocks.OAK_PRESSURE_PLATE), BlockSetType.OAK));

    public static final RegistryObject<Block> EMBER_OAK_FENCE = registerBlock("ember_oak_fence",
            () -> new FenceBlock(BlockBehaviour.Properties.copy(Blocks.OAK_FENCE)));

    public static final RegistryObject<Block> EMBER_OAK_FENCE_GATE = registerBlock("ember_oak_fence_gate",
            () -> new FenceGateBlock(BlockBehaviour.Properties.copy(Blocks.OAK_FENCE_GATE),
                    SoundEvents.FENCE_GATE_OPEN, SoundEvents.FENCE_GATE_CLOSE));

    public static final RegistryObject<Block> EMBER_OAK_DOOR = registerBlock("ember_oak_door",
            () -> new DoorBlock(BlockBehaviour.Properties.copy(Blocks.OAK_DOOR).noOcclusion(),
                    BlockSetType.OAK));

    public static final RegistryObject<Block> EMBER_OAK_TRAPDOOR = registerBlock("ember_oak_trapdoor",
            () -> new TrapDoorBlock(BlockBehaviour.Properties.copy(Blocks.OAK_TRAPDOOR).noOcclusion(),
                    BlockSetType.OAK));

    public static final RegistryObject<Block> DEAD_LOG = registerBlock("dead_log",
            () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.OAK_LOG).strength(3f)));

    public static final RegistryObject<Block> DEAD_WOOD = registerBlock("dead_wood",
            () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.OAK_LOG).strength(3f)));

    public static final RegistryObject<Block> STRIPPED_DEAD_LOG = registerBlock("stripped_dead_log",
            () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.STRIPPED_OAK_LOG).strength(3f)));

    public static final RegistryObject<Block> STRIPPED_DEAD_WOOD = registerBlock("stripped_dead_wood",
            () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.STRIPPED_OAK_WOOD).strength(3f)));

    public static final RegistryObject<Block> DEAD_LEAVES = registerBlock("dead_leaves",
            () -> new ModLeavesBlock(BlockBehaviour.Properties.copy(Blocks.OAK_LEAVES)));

    public static final RegistryObject<Block> DEAD_PLANKS = registerBlock("dead_planks",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS)));

    public static final RegistryObject<Block> DEAD_STAIRS = registerBlock("dead_stairs",
            () -> new StairBlock(() -> ModBlocks.DEAD_PLANKS.get().defaultBlockState(),
                    BlockBehaviour.Properties.copy(Blocks.OAK_STAIRS)));

    public static final RegistryObject<Block> DEAD_SLAB = registerBlock("dead_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.copy(Blocks.OAK_SLAB)));

    public static final RegistryObject<Block> DEAD_BUTTON = registerBlock("dead_button",
            () -> new ButtonBlock(BlockBehaviour.Properties.copy(Blocks.OAK_BUTTON),
                    BlockSetType.OAK, 20, true));

    public static final RegistryObject<Block> DEAD_PRESSURE_PLATE = registerBlock("dead_pressure_plate",
            () -> new PressurePlateBlock(PressurePlateBlock.Sensitivity.EVERYTHING, BlockBehaviour
                    .Properties.copy(Blocks.OAK_PRESSURE_PLATE), BlockSetType.OAK));

    public static final RegistryObject<Block> DEAD_FENCE = registerBlock("dead_fence",
            () -> new FenceBlock(BlockBehaviour.Properties.copy(Blocks.OAK_FENCE)));

    public static final RegistryObject<Block> DEAD_FENCE_GATE = registerBlock("dead_fence_gate",
            () -> new FenceGateBlock(BlockBehaviour.Properties.copy(Blocks.OAK_FENCE_GATE),
                    SoundEvents.FENCE_GATE_OPEN, SoundEvents.FENCE_GATE_CLOSE));

    public static final RegistryObject<Block> DEAD_DOOR = registerBlock("dead_door",
            () -> new DoorBlock(BlockBehaviour.Properties.copy(Blocks.OAK_DOOR).noOcclusion(),
                    BlockSetType.OAK));

    public static final RegistryObject<Block> DEAD_TRAPDOOR = registerBlock("dead_trapdoor",
            () -> new TrapDoorBlock(BlockBehaviour.Properties.copy(Blocks.OAK_TRAPDOOR).noOcclusion(),
                    BlockSetType.OAK));

    public static final RegistryObject<Block> MARIKA_OAK_LOG = registerBlock("marika_oak_log",
            () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.OAK_LOG).strength(3f).lightLevel(marikaglow)));

    public static final RegistryObject<Block> MARIKA_OAK_WOOD = registerBlock("marika_oak_wood",
            () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.OAK_LOG).strength(3f).lightLevel(marikaglow)));

    public static final RegistryObject<Block> STRIPPED_MARIKA_OAK_LOG = registerBlock("stripped_marika_oak_log",
            () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.STRIPPED_OAK_LOG).strength(3f).lightLevel(marikaglow)));

    public static final RegistryObject<Block> STRIPPED_MARIKA_OAK_WOOD = registerBlock("stripped_marika_oak_wood",
            () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.STRIPPED_OAK_WOOD).strength(3f).lightLevel(marikaglow)));

    public static final RegistryObject<Block> MARIKA_OAK_LEAVES = registerBlock("marika_oak_leaves",
            () -> new MarikaLeaves(BlockBehaviour.Properties.copy(Blocks.OAK_LEAVES).lightLevel(marikaglow)));

    public static final RegistryObject<Block> MARIKA_OAK_PLANKS = registerBlock("marika_oak_planks",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS)));

    public static final RegistryObject<Block> MARIKA_OAK_STAIRS = registerBlock("marika_oak_stairs",
            () -> new StairBlock(() -> ModBlocks.MARIKA_OAK_PLANKS.get().defaultBlockState(),
                    BlockBehaviour.Properties.copy(Blocks.OAK_STAIRS)));

    public static final RegistryObject<Block> MARIKA_OAK_SLAB = registerBlock("marika_oak_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.copy(Blocks.OAK_SLAB)));

    public static final RegistryObject<Block> MARIKA_OAK_BUTTON = registerBlock("marika_oak_button",
            () -> new ButtonBlock(BlockBehaviour.Properties.copy(Blocks.OAK_BUTTON),
                    BlockSetType.OAK, 20, true));

    public static final RegistryObject<Block> MARIKA_OAK_PRESSURE_PLATE = registerBlock("marika_oak_pressure_plate",
            () -> new PressurePlateBlock(PressurePlateBlock.Sensitivity.EVERYTHING, BlockBehaviour
                    .Properties.copy(Blocks.OAK_PRESSURE_PLATE), BlockSetType.OAK));

    public static final RegistryObject<Block> MARIKA_OAK_FENCE = registerBlock("marika_oak_fence",
            () -> new FenceBlock(BlockBehaviour.Properties.copy(Blocks.OAK_FENCE)));

    public static final RegistryObject<Block> MARIKA_OAK_FENCE_GATE = registerBlock("marika_oak_fence_gate",
            () -> new FenceGateBlock(BlockBehaviour.Properties.copy(Blocks.OAK_FENCE_GATE),
                    SoundEvents.FENCE_GATE_OPEN, SoundEvents.FENCE_GATE_CLOSE));

    public static final RegistryObject<Block> MARIKA_OAK_DOOR = registerBlock("marika_oak_door",
            () -> new DoorBlock(BlockBehaviour.Properties.copy(Blocks.OAK_DOOR).noOcclusion(),
                    BlockSetType.OAK));

    public static final RegistryObject<Block> MARIKA_OAK_TRAPDOOR = registerBlock("marika_oak_trapdoor",
            () -> new TrapDoorBlock(BlockBehaviour.Properties.copy(Blocks.OAK_TRAPDOOR).noOcclusion(),
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

    public static final RegistryObject<Block> VITRIC_ROSE = registerBlock("vitric_rose",
            () -> new TallFlowerBlock(BlockBehaviour.Properties.copy(Blocks.LILAC)
                    .noOcclusion().noCollission()));

    public static final RegistryObject<Block> DEVILS_BLOOD = registerBlock("devils_blood",
            () -> new DevilsBloodBlock(MobEffects.BLINDNESS, 5, BlockBehaviour.Properties
                    .copy(Blocks.ALLIUM).noOcclusion().noCollission()));

    public static final RegistryObject<Block> POTTED_DEVILS_BLOOD = BLOCKS.register("potted_devils_blood",
            () -> new FlowerPotBlock(() -> ((FlowerPotBlock) Blocks.FLOWER_POT), ModBlocks.DEVILS_BLOOD,
                    BlockBehaviour.Properties.copy(Blocks.POTTED_ALLIUM).noOcclusion()));

    public static final RegistryObject<Block> VITRIC_BLOOM = registerBlock("vitric_bloom",
            () -> new FlowerBlock(MobEffects.POISON, 5, BlockBehaviour.Properties
                    .copy(Blocks.ALLIUM).noOcclusion().noCollission()));

    public static final RegistryObject<Block> POTTED_VITRIC_BLOOM = BLOCKS.register("potted_vitric_bloom",
            () -> new FlowerPotBlock(() -> ((FlowerPotBlock) Blocks.FLOWER_POT), ModBlocks.VITRIC_BLOOM,
                    BlockBehaviour.Properties.copy(Blocks.POTTED_ALLIUM).noOcclusion()));

    public static final RegistryObject<Block> SPITFIRE = registerBlock("spitfire",
            () -> new SpitfireBlock(MobEffects.GLOWING, 5, BlockBehaviour.Properties
                    .copy(Blocks.ALLIUM).noOcclusion().noCollission()));

    public static final RegistryObject<Block> POTTED_SPITFIRE = BLOCKS.register("potted_spitfire",
            () -> new FlowerPotBlock(() -> ((FlowerPotBlock) Blocks.FLOWER_POT), ModBlocks.SPITFIRE,
                    BlockBehaviour.Properties.copy(Blocks.POTTED_ALLIUM).noOcclusion()));

    public static final RegistryObject<Block> FULGURBLOOM = registerBlock("fulgurbloom",
            () -> new FulgurBloomBlock(MobEffects.MOVEMENT_SPEED, 5, BlockBehaviour.Properties
                    .copy(Blocks.ALLIUM).noOcclusion().noCollission()));

    public static final RegistryObject<Block> POTTED_FULGURBLOOM = BLOCKS.register("potted_fulgurbloom",
            () -> new FlowerPotBlock(() -> ((FlowerPotBlock) Blocks.FLOWER_POT), ModBlocks.FULGURBLOOM,
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

    public static final RegistryObject<Block> HEL_FRUIT_CROP = BLOCKS.register("hel_fruit_crop",
            () -> new HelFruitCropBlock(BlockBehaviour.Properties.copy(Blocks.WHEAT)
                    .noOcclusion().noCollission()));

    public static final RegistryObject<Block> HEIM_BERRY_CROP = BLOCKS.register("heim_berry_crop",
            () -> new HeimBerryCropBlock(BlockBehaviour.Properties.copy(Blocks.WHEAT)
                    .noOcclusion().noCollission()));

    public static final RegistryObject<Block> SABER_CORN_CROP = BLOCKS.register("saber_corn_crop",
            () -> new SaberCornCropBlock(BlockBehaviour.Properties.copy(Blocks.WHEAT)
                    .noOcclusion().noCollission()));

    public static final RegistryObject<Block> LAI_MELON = registerBlock("lai_melon",
            () -> new LaiMelonBlock(BlockBehaviour.Properties.copy(Blocks.MELON)));

    public static final RegistryObject<Block> LAI_MELON_STEM = registerBlock("lai_melon_stem",
            () -> new StemBlock((StemGrownBlock) LAI_MELON.get(),() -> ModItems.LAI_MELON_SEEDS.get(), BlockBehaviour.Properties.copy(Blocks.MELON_STEM)
                    .noCollission()));

    public static final RegistryObject<Block> ATTACHED_LAI_MELON_STEM = registerBlock("attached_lai_melon_stem",
            () -> new AttachedStemBlock((StemGrownBlock) LAI_MELON.get(), ModItems.LAI_MELON_SEEDS, BlockBehaviour.Properties.copy(Blocks.ATTACHED_MELON_STEM)
                    .noCollission()));

    public static final RegistryObject<Block> EMBER_OAK_SAPLING = registerBlock("ember_oak_sapling",
            () -> new SaplingBlock(new EmberTreeGrower(), BlockBehaviour.Properties.copy(Blocks.OAK_SAPLING)
                    .noOcclusion().noCollission().lightLevel(marikaglow)));

    public static final RegistryObject<Block> MARIKA_OAK_SAPLING = registerBlock("marika_oak_sapling",
            () -> new SaplingBlock(new MarikaTreeGrower(), BlockBehaviour.Properties.copy(Blocks.OAK_SAPLING)
                    .noOcclusion().noCollission().lightLevel(marikaglow)));

    public static final RegistryObject<Block> PLAGUED_SAPLING = registerBlock("plagued_sapling",
            () -> new SaplingBlock(new PlaguedTreeGrower(), BlockBehaviour.Properties.copy(Blocks.OAK_SAPLING)
                    .noOcclusion().noCollission()));

    public static final RegistryObject<Block> DYING_SAPLING = registerBlock("dying_sapling",
            () -> new SaplingBlock(new DeadTreeGrower(), BlockBehaviour.Properties.copy(Blocks.OAK_SAPLING)
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
            () -> new LiquidBlock(ModFluids.SOURCE_TIBERIUM_WATER, BlockBehaviour.Properties.copy(Blocks.WATER).noLootTable().liquid()));

    public static final RegistryObject<LiquidBlock> MOLTEN_TIBERIUM_BLOCK = BLOCKS.register("molten_tiberium_block",
            () -> new MoltenTiberiumBlock(ModFluids.SOURCE_MOLTEN_TIBERIUM, BlockBehaviour.Properties.copy(Blocks.LAVA)
                    .randomTicks().noLootTable(), 5, 0.5f));

    public static final RegistryObject<LiquidBlock> MOLTEN_BLUE_TIBERIUM_BLOCK = BLOCKS.register("molten_blue_tiberium_block",
            () -> new MoltenBlueTiberiumBlock(ModFluids.SOURCE_MOLTEN_BLUE_TIBERIUM, BlockBehaviour.Properties.copy(Blocks.LAVA)
                    .randomTicks().noLootTable(), 5, 0.5f));

    public static final RegistryObject<LiquidBlock> MOLTEN_RED_TIBERIUM_BLOCK = BLOCKS.register("molten_red_tiberium_block",
            () -> new MoltenRedTiberiumBlock(ModFluids.SOURCE_MOLTEN_RED_TIBERIUM, BlockBehaviour.Properties.copy(Blocks.LAVA)
                    .randomTicks().noLootTable(), 5, 0.5f));

    public static final RegistryObject<LiquidBlock> MOLTEN_PURPLE_TIBERIUM_BLOCK = BLOCKS.register("molten_purple_tiberium_block",
            () -> new MoltenPurpleTiberiumBlock(ModFluids.SOURCE_MOLTEN_PURPLE_TIBERIUM, BlockBehaviour.Properties.copy(Blocks.LAVA)
                    .randomTicks().noLootTable(), 5, 0.5f));

    public static final RegistryObject<LiquidBlock> LIQUID_PROTOCULTURE_BLOCK = BLOCKS.register("liquid_protoculture_block",
            () -> new LiquidProtocultureBlock(ModFluids.SOURCE_LIQUID_PROTOCULTURE, BlockBehaviour.Properties.copy(Blocks.LAVA)
                    .randomTicks().noLootTable(), 5, 0.5f));

    //End of Tiberium

    //Component Blocks:
    public static final RegistryObject<Block> GUNDANIUM_MACHINE_CORE = registerBlock("gundanium_machine_core",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).noOcclusion()));

    public static final RegistryObject<Block> ALYTHUM_MACHINE_CORE = registerBlock("alythum_machine_core",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).noOcclusion()));

    public static final RegistryObject<Block> VITRIC_MACHINE_CORE = registerBlock("vitric_machine_core",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).noOcclusion()));

    public static final RegistryObject<Block> CRYSTAL_CORE_MACHINE_CORE = registerBlock("crystal_core_machine_core",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).noOcclusion()));


    //End Component Blocks:

    //Block Entities
        //Machines:
    public static final RegistryObject<Block> TIBERIUM_GRINDER = registerBlock("tiberium_grinder",
            () -> new TiberiumGrinderBlock(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).noOcclusion()));

    public static final RegistryObject<Block> TIBERIUM_MACERATOR = registerBlock("tiberium_macerator",
            () -> new TiberiumMaceratorBlock(1, BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).noOcclusion()
                    .lightLevel(state -> state.getValue(PoweredKilnBlock.WORKING) ? 15 : 0)));

    public static final RegistryObject<Block> ALYTHUM_TIBERIUM_MACERATOR = registerBlock("alythum_tiberium_macerator",
            () -> new TiberiumMaceratorBlock(2, BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).noOcclusion()
                    .lightLevel(state -> state.getValue(PoweredKilnBlock.WORKING) ? 15 : 0)));

    public static final RegistryObject<Block> VITRIC_TIBERIUM_MACERATOR = registerBlock("vitric_tiberium_macerator",
            () -> new TiberiumMaceratorBlock(3, BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).noOcclusion()
                    .lightLevel(state -> state.getValue(PoweredKilnBlock.WORKING) ? 15 : 0)));

    public static final RegistryObject<Block> CRYSTAL_CORE_TIBERIUM_MACERATOR = registerBlock("crystal_core_tiberium_macerator",
            () -> new TiberiumMaceratorBlock(4, BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).noOcclusion()
                    .lightLevel(state -> state.getValue(PoweredKilnBlock.WORKING) ? 15 : 0)));



    public static final RegistryObject<Block> TIBERIUM_INFUSER = registerBlock("tiberium_infuser",
            () -> new TiberiumInfuserBlock(1, BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).noOcclusion()
                    .lightLevel(state -> state.getValue(PoweredKilnBlock.WORKING) ? 15 : 0)));

    public static final RegistryObject<Block> ALYTHUM_TIBERIUM_INFUSER = registerBlock("alythum_tiberium_infuser",
            () -> new TiberiumInfuserBlock(2, BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).noOcclusion()
                    .lightLevel(state -> state.getValue(PoweredKilnBlock.WORKING) ? 15 : 0)));

    public static final RegistryObject<Block> VITRIC_TIBERIUM_INFUSER = registerBlock("vitric_tiberium_infuser",
            () -> new TiberiumInfuserBlock(3, BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).noOcclusion()
                    .lightLevel(state -> state.getValue(PoweredKilnBlock.WORKING) ? 15 : 0)));

    public static final RegistryObject<Block> CRYSTAL_CORE_TIBERIUM_INFUSER = registerBlock("crystal_core_tiberium_infuser",
            () -> new TiberiumInfuserBlock(4, BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).noOcclusion()
                    .lightLevel(state -> state.getValue(PoweredKilnBlock.WORKING) ? 15 : 0)));



    public static final RegistryObject<Block> POWERED_KILN = registerBlock("powered_kiln",
            () -> new PoweredKilnBlock(1, BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).noOcclusion()
                    .lightLevel(state -> state.getValue(PoweredKilnBlock.WORKING) ? 15 : 0)));

    public static final RegistryObject<Block> ALYTHUM_KILN = registerBlock("alythum_kiln",
            () -> new PoweredKilnBlock(2, BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).noOcclusion()
                    .lightLevel(state -> state.getValue(PoweredKilnBlock.WORKING) ? 15 : 0)));

    public static final RegistryObject<Block> VITRIC_KILN = registerBlock("vitric_kiln",
            () -> new PoweredKilnBlock(3, BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).noOcclusion()
                    .lightLevel(state -> state.getValue(PoweredKilnBlock.WORKING) ? 15 : 0)));

    public static final RegistryObject<Block> CRYSTAL_CORE_KILN = registerBlock("crystal_core_kiln",
            () -> new PoweredKilnBlock(4, BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).noOcclusion()
                    .lightLevel(state -> state.getValue(PoweredKilnBlock.WORKING) ? 15 : 0)));


    public static final RegistryObject<Block> ALLOY_KILN = registerBlock("alloy_kiln",
            () -> new AlloyKilnBlock(1, BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).noOcclusion()
                    .lightLevel(state -> state.getValue(AlloyKilnBlock.WORKING) ? 15 : 0)));

    public static final RegistryObject<Block> ALYTHUM_ALLOY_KILN = registerBlock("alythum_alloy_kiln",
            () -> new AlloyKilnBlock(2, BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).noOcclusion()
                    .lightLevel(state -> state.getValue(AlloyKilnBlock.WORKING) ? 15 : 0)));

    public static final RegistryObject<Block> VITRIC_ALLOY_KILN = registerBlock("vitric_alloy_kiln",
            () -> new AlloyKilnBlock(3, BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).noOcclusion()
                    .lightLevel(state -> state.getValue(AlloyKilnBlock.WORKING) ? 15 : 0)));

    public static final RegistryObject<Block> CRYSTAL_CORE_ALLOY_KILN = registerBlock("crystal_core_alloy_kiln",
            () -> new AlloyKilnBlock(4, BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).noOcclusion()
                    .lightLevel(state -> state.getValue(AlloyKilnBlock.WORKING) ? 15 : 0)));


    public static final RegistryObject<Block> VITRICIUM_REFINERY = registerBlock("vitricium_refinery",
            () -> new VitriciumRefineryBlock(1, BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).noOcclusion()
                    .lightLevel(state -> state.getValue(VitriciumRefineryBlock.WORKING) ? 15 : 0)));

    public static final RegistryObject<Block> ALYTHUM_VITRICIUM_REFINERY = registerBlock("alythum_vitricium_refinery",
            () -> new VitriciumRefineryBlock(2, BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).noOcclusion()
                    .lightLevel(state -> state.getValue(VitriciumRefineryBlock.WORKING) ? 15 : 0)));

    public static final RegistryObject<Block> VITRIC_VITRICIUM_REFINERY = registerBlock("vitric_vitricium_refinery",
            () -> new VitriciumRefineryBlock(3, BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).noOcclusion()
                    .lightLevel(state -> state.getValue(VitriciumRefineryBlock.WORKING) ? 15 : 0)));

    public static final RegistryObject<Block> CRYSTAL_CORE_VITRICIUM_REFINERY = registerBlock("crystal_core_vitricium_refinery",
            () -> new VitriciumRefineryBlock(4, BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).noOcclusion()
                    .lightLevel(state -> state.getValue(VitriciumRefineryBlock.WORKING) ? 15 : 0)));

        //Signs:

    public static final RegistryObject<Block> PLAGUED_SIGN = BLOCKS.register("plagued_sign",
            () -> new ModStandingSignBlock(BlockBehaviour.Properties.copy(Blocks.OAK_SIGN), ModWoodTypes.PLAGUED));

    public static final RegistryObject<Block> PLAGUED_WALL_SIGN = BLOCKS.register("plagued_wall_sign",
            () -> new ModWallSignBlock(BlockBehaviour.Properties.copy(Blocks.OAK_WALL_SIGN), ModWoodTypes.PLAGUED));

    public static final RegistryObject<Block> PLAGUED_HANGING_SIGN = BLOCKS.register("plagued_hanging_sign",
            () -> new ModHangingSignBlock(BlockBehaviour.Properties.copy(Blocks.OAK_HANGING_SIGN), ModWoodTypes.PLAGUED));

    public static final RegistryObject<Block> PLAGUED_WALL_HANGING_SIGN = BLOCKS.register("plagued_wall_hanging_sign",
            () -> new ModWallHangingSignBlock(BlockBehaviour.Properties.copy(Blocks.OAK_WALL_HANGING_SIGN), ModWoodTypes.PLAGUED));

    public static final RegistryObject<Block> EMBER_OAK_SIGN = BLOCKS.register("ember_oak_sign",
            () -> new ModStandingSignBlock(BlockBehaviour.Properties.copy(Blocks.OAK_SIGN), ModWoodTypes.EMBER_OAK));

    public static final RegistryObject<Block> EMBER_OAK_WALL_SIGN = BLOCKS.register("ember_oak_wall_sign",
            () -> new ModWallSignBlock(BlockBehaviour.Properties.copy(Blocks.OAK_WALL_SIGN), ModWoodTypes.EMBER_OAK));

    public static final RegistryObject<Block> EMBER_OAK_HANGING_SIGN = BLOCKS.register("ember_oak_hanging_sign",
            () -> new ModHangingSignBlock(BlockBehaviour.Properties.copy(Blocks.OAK_HANGING_SIGN), ModWoodTypes.EMBER_OAK));

    public static final RegistryObject<Block> EMBER_OAK_WALL_HANGING_SIGN = BLOCKS.register("ember_oak_wall_hanging_sign",
            () -> new ModWallHangingSignBlock(BlockBehaviour.Properties.copy(Blocks.OAK_WALL_HANGING_SIGN), ModWoodTypes.EMBER_OAK));

    public static final RegistryObject<Block> DEAD_SIGN = BLOCKS.register("dead_sign",
            () -> new ModStandingSignBlock(BlockBehaviour.Properties.copy(Blocks.OAK_SIGN), ModWoodTypes.DEAD));

    public static final RegistryObject<Block> DEAD_WALL_SIGN = BLOCKS.register("dead_wall_sign",
            () -> new ModWallSignBlock(BlockBehaviour.Properties.copy(Blocks.OAK_WALL_SIGN), ModWoodTypes.DEAD));

    public static final RegistryObject<Block> DEAD_HANGING_SIGN = BLOCKS.register("dead_hanging_sign",
            () -> new ModHangingSignBlock(BlockBehaviour.Properties.copy(Blocks.OAK_HANGING_SIGN), ModWoodTypes.DEAD));

    public static final RegistryObject<Block> DEAD_WALL_HANGING_SIGN = BLOCKS.register("dead_wall_hanging_sign",
            () -> new ModWallHangingSignBlock(BlockBehaviour.Properties.copy(Blocks.OAK_WALL_HANGING_SIGN), ModWoodTypes.DEAD));

    public static final RegistryObject<Block> MARIKA_OAK_SIGN = BLOCKS.register("marika_oak_sign",
            () -> new ModStandingSignBlock(BlockBehaviour.Properties.copy(Blocks.OAK_SIGN), ModWoodTypes.MARIKA_OAK));

    public static final RegistryObject<Block> MARIKA_OAK_WALL_SIGN = BLOCKS.register("marika_oak_wall_sign",
            () -> new ModWallSignBlock(BlockBehaviour.Properties.copy(Blocks.OAK_WALL_SIGN), ModWoodTypes.MARIKA_OAK));

    public static final RegistryObject<Block> MARIKA_OAK_HANGING_SIGN = BLOCKS.register("marika_oak_hanging_sign",
            () -> new ModHangingSignBlock(BlockBehaviour.Properties.copy(Blocks.OAK_HANGING_SIGN), ModWoodTypes.MARIKA_OAK));

    public static final RegistryObject<Block> MARIKA_OAK_WALL_HANGING_SIGN = BLOCKS.register("marika_oak_wall_hanging_sign",
            () -> new ModWallHangingSignBlock(BlockBehaviour.Properties.copy(Blocks.OAK_WALL_HANGING_SIGN), ModWoodTypes.MARIKA_OAK));

    //End of Block Entities


    //Blossom Tree
    public static final RegistryObject<Block> BLOSSOM_SPOUT = registerBlock("blossom_spout",
            () -> new BlossomTreeSpoutBlock(BlockBehaviour.Properties.copy(Blocks.BEDROCK).noLootTable()
                    .randomTicks().lightLevel(blossomglow)));

    public static final RegistryObject<Block> BLOSSOM_CENTER = registerBlock("blossom_center",
            () -> new RotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.BEDROCK).noLootTable().noOcclusion()
                    .randomTicks().lightLevel(blossomglow)));

    public static final RegistryObject<Block> BLOSSOM_BASE = registerBlock("blossom_base",
            () -> new BlossomTreeBaseBlock(BlockBehaviour.Properties.copy(Blocks.BEDROCK).noLootTable().noOcclusion()
                    .randomTicks().lightLevel(blossomglow)));


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
