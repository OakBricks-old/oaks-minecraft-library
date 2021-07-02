package oak.oakapi.etc;

import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.rendering.v1.ColorProviderRegistry;
import net.minecraft.block.Block;
import net.minecraft.client.color.world.BiomeColors;
import net.minecraft.client.color.world.FoliageColors;
import net.minecraft.client.render.RenderLayer;

public class ClientSideRenderingMagic {

    public static void registerBlockitemFoliageColor(Block blockitem) {
        ColorProviderRegistry.ITEM.register((stack, tintIndex) -> tintIndex == 0
                ? FoliageColors.getDefaultColor()
                : FoliageColors.getDefaultColor(), blockitem.asItem());
    }

    public static void registerBlockFoliageColor(Block block) {
        ColorProviderRegistry.BLOCK.register((state, view, pos, tintIndex) ->
                view != null && pos != null
                        ? BiomeColors.getFoliageColor(view, pos)
                        : FoliageColors.getDefaultColor(), block);
    }

    public static void getMippedCutout(Block block) {
        BlockRenderLayerMap.INSTANCE.putBlock(block, RenderLayer.getCutoutMipped());
    }

    public static void getUnmippedCutout(Block block) {
        BlockRenderLayerMap.INSTANCE.putBlock(block, RenderLayer.getCutout());
    }

}
