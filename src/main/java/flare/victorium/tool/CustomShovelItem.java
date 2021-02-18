package flare.victorium.tool;

import net.minecraft.item.*;

import net.minecraft.util.registry.Registry;

import flare.victorium.toolmaterial.VictoriumCrystal;
import net.minecraft.util.Identifier;


public class CustomShovelItem extends ShovelItem {
    public CustomShovelItem(ToolMaterial toolMaterial, float attackDamage, float attackSpeed, Settings settings) {
        super(toolMaterial, attackDamage, attackSpeed, settings);
    }

    public static final ToolItem VICTORIUM_SHOVEL = new CustomShovelItem(VictoriumCrystal.INSTANCE, -0.5F, -2.6F, new Item.Settings().group(ItemGroup.TOOLS));
    public static void registerItems() {
        Registry.register(Registry.ITEM, new Identifier("victorium", "victorium_shovel"), VICTORIUM_SHOVEL);
    }
}