package flare.victorium.ore;

import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.registry.BuiltinRegistries;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryKey;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.decorator.Decorator;
import net.minecraft.world.gen.decorator.RangeDecoratorConfig;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.OreFeatureConfig;

import java.util.Random;

public class VictoriumOreBlock extends Block {

    public VictoriumOreBlock(Settings settings) {
        super(settings);
    }

    protected int getExperienceWhenMined(Random random){
        return MathHelper.nextInt(random, 2, 7);
    }

    public void onStacksDropped(BlockState state, ServerWorld world, BlockPos pos, ItemStack stack) {
        super.onStacksDropped(state, world, pos, stack);
        if (EnchantmentHelper.getLevel(Enchantments.SILK_TOUCH, stack) == 0) {
            int i = this.getExperienceWhenMined(world.random);
            if(i>0) {
                this.dropExperience(world, pos, i);
            }
        }
    }
    public static final Block VICTORIUM_ORE = new VictoriumOreBlock(FabricBlockSettings.copy(Blocks.STONE));
    private static ConfiguredFeature<?, ?> VICTORIUM_ORE_OVERWORLD = Feature.ORE.configure(
            new OreFeatureConfig(OreFeatureConfig.Rules.BASE_STONE_OVERWORLD, VICTORIUM_ORE.getDefaultState(), 9))
            .decorate(Decorator.RANGE.configure(new RangeDecoratorConfig(0, 0, 17))).spreadHorizontally().repeat(2);

    public static void registerItems() {
        Registry.register(Registry.BLOCK, new Identifier("victorium", "victorium_ore"), VICTORIUM_ORE);
        Registry.register(Registry.ITEM, new Identifier("victorium", "victorium_ore"), new BlockItem(VICTORIUM_ORE,
                new Item.Settings().group(ItemGroup.BUILDING_BLOCKS)));
        RegistryKey<ConfiguredFeature<?, ?>>  victoriumOreOverworld = RegistryKey.of(Registry.CONFIGURED_FEATURE_WORLDGEN, new Identifier("victorium", "victorium_ore"));
        Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, victoriumOreOverworld.getValue(), VICTORIUM_ORE_OVERWORLD);
        BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(), GenerationStep.Feature.UNDERGROUND_ORES, victoriumOreOverworld);
    }


}
