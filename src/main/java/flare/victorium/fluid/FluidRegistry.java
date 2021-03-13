package flare.victorium.fluid;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.FluidBlock;
import net.minecraft.fluid.FlowableFluid;
import net.minecraft.item.BucketItem;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class FluidRegistry {


    public static FlowableFluid TAR_FLUID_STILL;
    public static FlowableFluid TAR_FLUID_FLOWING;

    public static Item TAR_BUCKET;

    public static Block TAR_FLUID;

    public static void registerAll() {
        Registry.register(Registry.FLUID, new Identifier("victorium", "tar"), new TarFluid.Still());
        Registry.register(Registry.FLUID, new Identifier("victorium", "flowing_tar"), new TarFluid.Flowing());

        Registry.register(Registry.ITEM, new Identifier("victorium", "tar_bucket"), new BucketItem(TAR_FLUID_STILL,
                new Item.Settings().recipeRemainder(Items.BUCKET).maxCount(1)));

        Registry.register(Registry.BLOCK, new Identifier("victorium", "tar"), new FluidBlock(TAR_FLUID_STILL, FabricBlockSettings.copy(Blocks.WATER)){});

    }
}
