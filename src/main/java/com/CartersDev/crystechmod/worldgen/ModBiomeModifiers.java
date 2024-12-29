package com.CartersDev.crystechmod.worldgen;

import com.CartersDev.crystechmod.CrystalTech;
import net.minecraft.core.HolderSet;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BiomeTags;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.world.BiomeModifier;
import net.minecraftforge.common.world.ForgeBiomeModifiers;
import net.minecraftforge.registries.ForgeRegistries;

public class ModBiomeModifiers {
    //Trees:
    public static final ResourceKey<BiomeModifier> ADD_TREE_DEAD = registerKey("add_tree_dead");

    //Ores:
    public static final ResourceKey<BiomeModifier> ADD_CRYSTECH_GUNDANIUM_ORES = registerKey("add_crystech_gundanium_ores");
    public static final ResourceKey<BiomeModifier> ADD_CRYSTECH_KRYON_ORES = registerKey("add_crystech_kryon_ores");
    public static final ResourceKey<BiomeModifier> ADD_CRYSTECH_ILLUMINA_ORES = registerKey("add_crystech_illumina_ores");
    public static final ResourceKey<BiomeModifier> ADD_CRYSTECH_AERIES_ORES = registerKey("add_crystech_aeries_ores");
    public static final ResourceKey<BiomeModifier> ADD_CRYSTECH_ENIGMA_ORES = registerKey("add_crystech_enigma_ores");
    public static final ResourceKey<BiomeModifier> ADD_CRYSTECH_ALYTHUM_ORES = registerKey("add_crystech_alythum_ores");
    public static final ResourceKey<BiomeModifier> ADD_CRYSTECH_QUALRITE_ORES = registerKey("add_crystech_qualrite_ores");

    public static final ResourceKey<BiomeModifier> ADD_CRYSTECH_NETHER_ALYTHUM_ORES = registerKey("add_crystech_nether_alythum_ores");
    public static final ResourceKey<BiomeModifier> ADD_CRYSTECH_NETHER_QUALRITE_ORES = registerKey("add_crystech_nether_qualrite_ores");
    public static final ResourceKey<BiomeModifier> ADD_CRYSTECH_NETHER_KRYON_ORES = registerKey("add_crystech_nether_kryon_ores");
    public static final ResourceKey<BiomeModifier> ADD_CRYSTECH_NETHER_AERIES_ORES = registerKey("add_crystech_nether_aeries_ores");

    public static final ResourceKey<BiomeModifier> ADD_CRYSTECH_END_ENIGMA_ORES = registerKey("add_crystech_end_enigma_ores");
    public static final ResourceKey<BiomeModifier> ADD_CRYSTECH_END_KRYON_ORES = registerKey("add_crystech_end_kryon_ores");

    //Geode:
    public static final ResourceKey<BiomeModifier> ADD_TIBERIUM_GEODE = registerKey("add_tiberium_geode");

    //Flowers:
    public static final ResourceKey<BiomeModifier> ADD_HYACINTH = registerKey("add_hyacinth");
    public static final ResourceKey<BiomeModifier> ADD_SPITFIRE = registerKey("add_spitfire");
    public static final ResourceKey<BiomeModifier> ADD_FULGURBLOOM = registerKey("add_fulgurbloom");

    public static void bootstrap(BootstapContext<BiomeModifier> context) {
        var placedFeatures = context.lookup(Registries.PLACED_FEATURE);
        var biomes = context.lookup(Registries.BIOME);

        //Trees:
        context.register(ADD_TREE_DEAD, new ForgeBiomeModifiers.AddFeaturesBiomeModifier(
                biomes.getOrThrow(BiomeTags.IS_FOREST),
                HolderSet.direct(placedFeatures.getOrThrow(ModPlacedFeatures.DEAD_PLACED_KEY)),
                GenerationStep.Decoration.VEGETAL_DECORATION));

        //Ores:
            //Overworld:
        context.register(ADD_CRYSTECH_GUNDANIUM_ORES, new ForgeBiomeModifiers.AddFeaturesBiomeModifier(
                biomes.getOrThrow(BiomeTags.IS_OVERWORLD),
                HolderSet.direct(placedFeatures.getOrThrow(ModPlacedFeatures.CRYSTECH_GUNDANIUM_PLACED_KEY)),
                GenerationStep.Decoration.UNDERGROUND_ORES));

        context.register(ADD_CRYSTECH_KRYON_ORES, new ForgeBiomeModifiers.AddFeaturesBiomeModifier(
                biomes.getOrThrow(BiomeTags.IS_OVERWORLD),
                HolderSet.direct(placedFeatures.getOrThrow(ModPlacedFeatures.CRYSTECH_KRYON_PLACED_KEY)),
                GenerationStep.Decoration.UNDERGROUND_ORES));

        context.register(ADD_CRYSTECH_ILLUMINA_ORES, new ForgeBiomeModifiers.AddFeaturesBiomeModifier(
                biomes.getOrThrow(BiomeTags.IS_OVERWORLD),
                HolderSet.direct(placedFeatures.getOrThrow(ModPlacedFeatures.CRYSTECH_ILLUMINA_PLACED_KEY)),
                GenerationStep.Decoration.UNDERGROUND_ORES));

            //Nether:
        context.register(ADD_CRYSTECH_NETHER_ALYTHUM_ORES, new ForgeBiomeModifiers.AddFeaturesBiomeModifier(
                biomes.getOrThrow(BiomeTags.IS_NETHER),
                HolderSet.direct(placedFeatures.getOrThrow(ModPlacedFeatures.CRYSTECH_NETHER_ALYTHUM_PLACED_KEY)),
                GenerationStep.Decoration.UNDERGROUND_ORES));

        context.register(ADD_CRYSTECH_NETHER_QUALRITE_ORES, new ForgeBiomeModifiers.AddFeaturesBiomeModifier(
                biomes.getOrThrow(BiomeTags.IS_NETHER),
                HolderSet.direct(placedFeatures.getOrThrow(ModPlacedFeatures.CRYSTECH_NETHER_QUALRITE_PLACED_KEY)),
                GenerationStep.Decoration.UNDERGROUND_ORES));

        context.register(ADD_CRYSTECH_NETHER_KRYON_ORES, new ForgeBiomeModifiers.AddFeaturesBiomeModifier(
                biomes.getOrThrow(BiomeTags.IS_NETHER),
                HolderSet.direct(placedFeatures.getOrThrow(ModPlacedFeatures.CRYSTECH_NETHER_KRYON_PLACED_KEY)),
                GenerationStep.Decoration.UNDERGROUND_ORES));

        context.register(ADD_CRYSTECH_NETHER_AERIES_ORES, new ForgeBiomeModifiers.AddFeaturesBiomeModifier(
                biomes.getOrThrow(BiomeTags.IS_NETHER),
                HolderSet.direct(placedFeatures.getOrThrow(ModPlacedFeatures.CRYSTECH_NETHER_AERIES_PLACED_KEY)),
                GenerationStep.Decoration.UNDERGROUND_ORES));

            //End:
        context.register(ADD_CRYSTECH_END_ENIGMA_ORES, new ForgeBiomeModifiers.AddFeaturesBiomeModifier(
                biomes.getOrThrow(BiomeTags.IS_END),
                HolderSet.direct(placedFeatures.getOrThrow(ModPlacedFeatures.CRYSTECH_END_ENIGMA_PLACED_KEY)),
                GenerationStep.Decoration.UNDERGROUND_ORES));

        context.register(ADD_CRYSTECH_END_KRYON_ORES, new ForgeBiomeModifiers.AddFeaturesBiomeModifier(
                biomes.getOrThrow(BiomeTags.IS_END),
                HolderSet.direct(placedFeatures.getOrThrow(ModPlacedFeatures.CRYSTECH_END_KRYON_PLACED_KEY)),
                GenerationStep.Decoration.UNDERGROUND_ORES));

            //Geode:
        context.register(ADD_TIBERIUM_GEODE, new ForgeBiomeModifiers.AddFeaturesBiomeModifier(
                biomes.getOrThrow(BiomeTags.IS_OVERWORLD),
                HolderSet.direct(placedFeatures.getOrThrow(ModPlacedFeatures.TIBERIUM_GEODE_PLACED_KEY)),
                GenerationStep.Decoration.LOCAL_MODIFICATIONS));

        //Flowers:
        context.register(ADD_HYACINTH, new ForgeBiomeModifiers.AddFeaturesBiomeModifier(
                biomes.getOrThrow(Tags.Biomes.IS_PLAINS),
                HolderSet.direct(placedFeatures.getOrThrow(ModPlacedFeatures.HYACINTH_PLACED_KEY)),
                GenerationStep.Decoration.VEGETAL_DECORATION));

    }


    private static ResourceKey<BiomeModifier> registerKey(String name) {
        return ResourceKey.create(ForgeRegistries.Keys.BIOME_MODIFIERS, new ResourceLocation(CrystalTech.MOD_ID, name));
    }
}
