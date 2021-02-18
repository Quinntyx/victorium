package flare.victorium.tool;

import net.minecraft.item.SwordItem;

import net.minecraft.util.registry.Registry;

import net.minecraft.item.ToolMaterial;
import flare.victorium.toolmaterial.VictoriumCrystal;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ToolItem;
import net.minecraft.util.Identifier;


public class CustomSwordItem extends SwordItem {
    public CustomSwordItem(ToolMaterial toolMaterial, int attackDamage, float attackSpeed, Settings settings) {
        super(toolMaterial, attackDamage, attackSpeed, settings);
    }

    public static final ToolItem VICTORIUM_SWORD = new CustomSwordItem(VictoriumCrystal.INSTANCE, 3, -2.4F,
        new Item.Settings().group(ItemGroup.COMBAT));
    public static void registerItems() {
        Registry.register(Registry.ITEM, new Identifier("victorium", "victorium_sword"), VICTORIUM_SWORD);
    }

}