package flare.victorium.tool;

import net.minecraft.item.HoeItem;

import net.minecraft.util.registry.Registry;

import flare.victorium.toolmaterial.VictoriumCrystal;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ToolItem;
import net.minecraft.item.ToolMaterial;
import net.minecraft.util.Identifier;


public class CustomHoeItem extends HoeItem {
    public CustomHoeItem(ToolMaterial toolMaterial, int attackDamage, float attackSpeed, Settings settings) {
        super(toolMaterial, attackDamage, attackSpeed, settings);
    }

    public static final ToolItem VICTORIUM_HOE = new CustomHoeItem(VictoriumCrystal.INSTANCE, 1, -2.4F, new Item.Settings().group(ItemGroup.TOOLS));
    public static void registerItems() {
        Registry.register(Registry.ITEM, new Identifier("victorium", "victorium_hoe"), VICTORIUM_HOE);
    }
}