package flare.victorium;

import flare.victorium.ore.VictoriumOreBlock;
import flare.victorium.tool.CustomHoeItem;
import flare.victorium.tool.CustomPickaxeItem;
import flare.victorium.tool.CustomShovelItem;
import flare.victorium.tool.CustomSwordItem;
import net.fabricmc.api.ModInitializer;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.BlockItem;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.block.Material;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.minecraft.block.Block;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.tool.attribute.v1.FabricToolTags;

public class Victorium implements ModInitializer {

	public static final Item VICTORIUM_CRYSTAL = new Item(new Item.Settings().group(ItemGroup.MATERIALS));

	public static final Block VICTORIUM_BLOCK = new Block(FabricBlockSettings.of(Material.AGGREGATE)
			.strength(15.0F, 15.0F).sounds(BlockSoundGroup.BONE).breakByTool(FabricToolTags.PICKAXES).requiresTool());

	public static final Item VICTORIUM_BLADE = new Item(new Item.Settings().group(ItemGroup.MATERIALS).maxCount(16));
	public static final Item SCORCHED_VICTORIUM = new Item(new Item.Settings().group(ItemGroup.MATERIALS));

	@Override
	public void onInitialize() {

		Registry.register(Registry.ITEM, new Identifier("victorium", "victorium_crystal"), VICTORIUM_CRYSTAL);

		//Registry.register(Registry.ITEM, new Identifier("victorium","pocket_star"), POCKET_STAR);

		Registry.register(Registry.BLOCK, new Identifier("victorium", "victorium_block"), VICTORIUM_BLOCK);
		Registry.register(Registry.ITEM, new Identifier("victorium", "victorium_block"),
				new BlockItem(VICTORIUM_BLOCK, new Item.Settings().group(ItemGroup.DECORATIONS)));
		Registry.register(Registry.ITEM, new Identifier("victorium", "victorium_blade"), VICTORIUM_BLADE);
		Registry.register(Registry.ITEM, new Identifier("victorium", "scorched_victorium"), SCORCHED_VICTORIUM);

		CustomHoeItem.registerItems();
		CustomSwordItem.registerItems();
		CustomPickaxeItem.registerItems();
		CustomShovelItem.registerItems();

		VictoriumOreBlock.registerItems();

	}
}



