package flare.victorium.tool;

import flare.victorium.toolmaterial.PocketStar;
import net.minecraft.item.PickaxeItem;

import net.minecraft.util.registry.Registry;

import flare.victorium.toolmaterial.VictoriumCrystal;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ToolItem;
import net.minecraft.item.ToolMaterial;
import net.minecraft.util.Identifier;

public class CustomPickaxeItem extends PickaxeItem {
    public CustomPickaxeItem(ToolMaterial toolMaterial, int attackDamage, float attackSpeed, Settings settings) {
        super(toolMaterial, attackDamage, attackSpeed, settings);
    }

    public static final ToolItem VICTORIUM_PICKAXE = new CustomPickaxeItem(VictoriumCrystal.INSTANCE, 1, -2.8F, new Item.Settings().group(ItemGroup.TOOLS));
    public static final ToolItem POCKET_STAR = new CustomPickaxeItem(PocketStar.INSTANCE, 5, 0, new Item.Settings().group(ItemGroup.COMBAT));
    public static void registerItems() {
        Registry.register(Registry.ITEM, new Identifier("victorium", "victorium_pickaxe"), VICTORIUM_PICKAXE);
        Registry.register(Registry.ITEM, new Identifier("victorium", "pocket_star"), POCKET_STAR);
    }
}