package oak.oakapi.worldgen;

import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.BuiltinRegistries;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryKey;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.YOffset;
import net.minecraft.world.gen.decorator.RangeDecoratorConfig;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.OreFeatureConfig;
import net.minecraft.world.gen.heightprovider.UniformHeightProvider;
import oak.oakapi.OakApiMain;
import oak.oakapi.etc.CrashServer;

public class EasyStoneOreGenMaker {

    @Deprecated
    public static void makeOreGen(Block block, int maxHeight, int minHeight, int repeatAmount, int veinSize) {
        /**
         *
         * # please don't use this go to https://fabricmc.net/wiki/tutorial:ores for ores, this part of the mod does not work correctly
         *
         */
        ConfiguredFeature<?, ?> ORE_WOOL_OVERWORLD = Feature.ORE
                .configure(new OreFeatureConfig(
                        OreFeatureConfig.Rules.BASE_STONE_OVERWORLD,
                        block.getDefaultState(),
                        veinSize)) // Vein size
                .range(new RangeDecoratorConfig(
                        // You can also use one of the other height providers if you don't want a uniform distribution
                        UniformHeightProvider.create(YOffset.aboveBottom(minHeight), YOffset.fixed(maxHeight)))) // Inclusive min and max height
                .spreadHorizontally()
                .repeat(repeatAmount); // Number of veins per chunk
    }

    @Deprecated
    public static void registerOreGen(String id, String path) {
        /**
         *
         * # This is not recommended for use until this is fixed, please fix this
         *
         */
//        RegistryKey<ConfiguredFeature<?, ?>> oreWoolOverworld = RegistryKey.of(Registry.CONFIGURED_FEATURE_KEY,
//                new Identifier(id, path));
//        Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, oreWoolOverworld.getValue(), ORE_WOOL_OVERWORLD);
//        BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(), GenerationStep.Feature.UNDERGROUND_ORES, oreWoolOverworld);

        System.out.println("Ore gen id :" + id + ":" + path);

        OakApiMain.sendLoggerViaMainClass("Don't use \"registerOreGen\" ");

        CrashServer.crashServer();

    }

}
