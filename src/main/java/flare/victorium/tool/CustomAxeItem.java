package flare.victorium.tool;

import flare.victorium.toolmaterial.PocketStar;
import net.minecraft.item.AxeItem;

import net.minecraft.util.registry.Registry;

import flare.victorium.toolmaterial.VictoriumCrystal;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ToolItem;
import net.minecraft.item.ToolMaterial;
import net.minecraft.util.Identifier;

public class CustomAxeItem extends AxeItem {
    public CustomAxeItem(ToolMaterial toolMaterial, int attackDamage, float attackSpeed, Settings settings) {
        super(toolMaterial, attackDamage, attackSpeed, settings);
    }

    public static final ToolItem VICTORIUM_AXE = new CustomAxeItem(VictoriumCrystal.INSTANCE, 6, -3F, new Item.Settings().group(ItemGroup.TOOLS));
    public static void registerItems() {
        Registry.register(Registry.ITEM, new Identifier("victorium", "victorium_axe"), VICTORIUM_AXE);
    }
}