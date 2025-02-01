package com.CartersDev.crystechmod.worldgen.carvers;

import com.CartersDev.crystechmod.CrystalTech;
import com.CartersDev.crystechmod.util.ModTags;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.valueproviders.ConstantFloat;
import net.minecraft.util.valueproviders.TrapezoidFloat;
import net.minecraft.util.valueproviders.UniformFloat;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.carver.*;
import net.minecraft.world.level.levelgen.heightproviders.UniformHeight;
import net.minecraftforge.fml.common.Mod;

public class ModCarvers {
    public static final ResourceKey<ConfiguredWorldCarver<?>> VITRIC_YZ_CAVE = createKey("vitric_yz_cave");
    public static final ResourceKey<ConfiguredWorldCarver<?>> VITRIC_RZ_CAVE = createKey("vitric_rz_cave");
    public static final ResourceKey<ConfiguredWorldCarver<?>> VITRIC_YZ_CAVE_EXTRA_UNDERGROUND = createKey("vitric_yz_cave_extra_underground");
    public static final ResourceKey<ConfiguredWorldCarver<?>> VITRIC_RZ_CAVE_EXTRA_UNDERGROUND = createKey("vitric_rz_cave_extra_underground");
    public static final ResourceKey<ConfiguredWorldCarver<?>> VITRIC_YZ_CANYON = createKey("vitric_yz_canyon");
    public static final ResourceKey<ConfiguredWorldCarver<?>> VITRIC_RZ_CANYON = createKey("vitric_rz_canyon");



    public static void bootstrap(BootstapContext<ConfiguredWorldCarver<?>> pContext) {
        HolderGetter<Block> holdergetter = pContext.lookup(Registries.BLOCK);
        pContext.register(VITRIC_YZ_CAVE, WorldCarver.CAVE.configured(new CaveCarverConfiguration(0.15F, UniformHeight.of(VerticalAnchor.aboveBottom(8), VerticalAnchor.absolute(180)), UniformFloat.of(0.1F, 0.9F), VerticalAnchor.aboveBottom(8), CarverDebugSettings.of(false, Blocks.CRIMSON_BUTTON.defaultBlockState()), holdergetter.getOrThrow(ModTags.Blocks.VITRIC_EXPANSE_YZ_CARVER), UniformFloat.of(0.7F, 1.4F), UniformFloat.of(0.8F, 1.3F), UniformFloat.of(-1.0F, -0.4F))));
        pContext.register(VITRIC_RZ_CAVE, WorldCarver.CAVE.configured(new CaveCarverConfiguration(0.15F, UniformHeight.of(VerticalAnchor.aboveBottom(8), VerticalAnchor.absolute(180)), UniformFloat.of(0.1F, 0.9F), VerticalAnchor.aboveBottom(8), CarverDebugSettings.of(false, Blocks.CRIMSON_BUTTON.defaultBlockState()), holdergetter.getOrThrow(ModTags.Blocks.VITRIC_EXPANSE_RZ_CARVER), UniformFloat.of(0.7F, 1.4F), UniformFloat.of(0.8F, 1.3F), UniformFloat.of(-1.0F, -0.4F))));
        pContext.register(VITRIC_YZ_CAVE_EXTRA_UNDERGROUND, WorldCarver.CAVE.configured(new CaveCarverConfiguration(0.07F, UniformHeight.of(VerticalAnchor.aboveBottom(8), VerticalAnchor.absolute(47)), UniformFloat.of(0.1F, 0.9F), VerticalAnchor.aboveBottom(8), CarverDebugSettings.of(false, Blocks.OAK_BUTTON.defaultBlockState()), holdergetter.getOrThrow(ModTags.Blocks.VITRIC_EXPANSE_YZ_CARVER), UniformFloat.of(0.7F, 1.4F), UniformFloat.of(0.8F, 1.3F), UniformFloat.of(-1.0F, -0.4F))));
        pContext.register(VITRIC_RZ_CAVE_EXTRA_UNDERGROUND, WorldCarver.CAVE.configured(new CaveCarverConfiguration(0.07F, UniformHeight.of(VerticalAnchor.aboveBottom(8), VerticalAnchor.absolute(47)), UniformFloat.of(0.1F, 0.9F), VerticalAnchor.aboveBottom(8), CarverDebugSettings.of(false, Blocks.OAK_BUTTON.defaultBlockState()), holdergetter.getOrThrow(ModTags.Blocks.VITRIC_EXPANSE_RZ_CARVER), UniformFloat.of(0.7F, 1.4F), UniformFloat.of(0.8F, 1.3F), UniformFloat.of(-1.0F, -0.4F))));
        pContext.register(VITRIC_YZ_CANYON, WorldCarver.CANYON.configured(new CanyonCarverConfiguration(0.01F, UniformHeight.of(VerticalAnchor.absolute(10), VerticalAnchor.absolute(67)), ConstantFloat.of(3.0F), VerticalAnchor.aboveBottom(8), CarverDebugSettings.of(false, Blocks.WARPED_BUTTON.defaultBlockState()), holdergetter.getOrThrow(ModTags.Blocks.VITRIC_EXPANSE_YZ_CARVER), UniformFloat.of(-0.125F, 0.125F), new CanyonCarverConfiguration.CanyonShapeConfiguration(UniformFloat.of(0.75F, 1.0F), TrapezoidFloat.of(0.0F, 6.0F, 2.0F), 3, UniformFloat.of(0.75F, 1.0F), 1.0F, 0.0F))));
        pContext.register(VITRIC_RZ_CANYON, WorldCarver.CANYON.configured(new CanyonCarverConfiguration(0.01F, UniformHeight.of(VerticalAnchor.absolute(10), VerticalAnchor.absolute(67)), ConstantFloat.of(3.0F), VerticalAnchor.aboveBottom(8), CarverDebugSettings.of(false, Blocks.WARPED_BUTTON.defaultBlockState()), holdergetter.getOrThrow(ModTags.Blocks.VITRIC_EXPANSE_RZ_CARVER), UniformFloat.of(-0.125F, 0.125F), new CanyonCarverConfiguration.CanyonShapeConfiguration(UniformFloat.of(0.75F, 1.0F), TrapezoidFloat.of(0.0F, 6.0F, 2.0F), 3, UniformFloat.of(0.75F, 1.0F), 1.0F, 0.0F))));

    }

    private static ResourceKey<ConfiguredWorldCarver<?>> createKey(String pName) {
        return ResourceKey.create(Registries.CONFIGURED_CARVER, new ResourceLocation(CrystalTech.MOD_ID, pName));
    }
}
