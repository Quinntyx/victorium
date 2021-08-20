package flare.victorium;

import flare.victorium.armor.VictoriumCrystalArmor;
import flare.victorium.blockentity.FusionTableEntity;
import flare.victorium.fluid.FluidRegistry;
import flare.victorium.ore.EndiumOreBlock;
import flare.victorium.ore.VictoriumOreBlock;
import flare.victorium.tool.*;
import net.fabricmc.api.ModInitializer;
import net.minecraft.block.entity.BlockEntityType;
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

	public static final Block INFINITITE_BLOCK_T1 = new Block(FabricBlockSettings.of(Material.AGGREGATE)
			.strength(20.0F, 20.0F).sounds(BlockSoundGroup.ANCIENT_DEBRIS).breakByTool(FabricToolTags.PICKAXES).requiresTool());

	public static final Item VICTORIUM_BLADE = new Item(new Item.Settings().group(ItemGroup.MATERIALS).maxCount(16));
	public static final Item VICTORIUM_PLATE = new Item(new Item.Settings().group(ItemGroup.MATERIALS));

	public static final Item DEPLETED_ENDIUM = new Item(new Item.Settings().group(ItemGroup.MATERIALS));

	public static BlockEntityType<FusionTableEntity> FUSION_TABLE_ENTITY;
	public static final Block FUSION_TABLE = new Block(FabricBlockSettings.of(Material.WOOD)
			.strength(5.0F,15.0F).sounds(BlockSoundGroup.WOOD).breakByTool(FabricToolTags.AXES).requiresTool());


	@Override
	public void onInitialize() {

		Registry.register(Registry.ITEM, new Identifier("victorium", "victorium_crystal"), VICTORIUM_CRYSTAL);

		//Registry.register(Registry.ITEM, new Identifier("victorium","pocket_star"), POCKET_STAR);

		Registry.register(Registry.BLOCK, new Identifier("victorium", "victorium_block"), VICTORIUM_BLOCK);
		Registry.register(Registry.ITEM, new Identifier("victorium", "victorium_block"),
				new BlockItem(VICTORIUM_BLOCK, new Item.Settings().group(ItemGroup.DECORATIONS)));
		Registry.register(Registry.ITEM, new Identifier("victorium", "victorium_blade"), VICTORIUM_BLADE);
		Registry.register(Registry.ITEM, new Identifier("victorium", "victorium_plate"), VICTORIUM_PLATE);
		Registry.register(Registry.ITEM, new Identifier("victorium", "depleted_endium"), DEPLETED_ENDIUM);

		Registry.register(Registry.BLOCK, new Identifier("victorium", "infinitite_block_t1"), INFINITITE_BLOCK_T1);
		Registry.register(Registry.ITEM, new Identifier("victorium", "infinitite_block_t1"),
				new BlockItem(INFINITITE_BLOCK_T1, new Item.Settings().group(ItemGroup.DECORATIONS)));

		Registry.register(Registry.BLOCK, new Identifier("victorium", "fusion_table"), FUSION_TABLE);
		Registry.register(Registry.ITEM, new Identifier("victorium", "fusion_table"),
				new BlockItem(FUSION_TABLE, new Item.Settings().group(ItemGroup.DECORATIONS)));

		//FUSION_TABLE = Registry.register(Registry.BLOCK_ENTITY_TYPE, "victorium:fusion_table",
		//		BlockEntityType.Builder.create(FusionTableEntity::new, FUSION_TABLE).build(null));


		CustomShovelItem.registerItems();
		CustomPickaxeItem.registerItems();
		CustomAxeItem.registerItems();
		CustomHoeItem.registerItems();
		CustomStaffItem.registerItems();

		VictoriumCrystalArmor.RegisterItems();

		CustomSwordItem.registerItems();

		VictoriumOreBlock.registerItems();
		EndiumOreBlock.registerItems();

		//FluidRegistry.registerAll();

	}
}



