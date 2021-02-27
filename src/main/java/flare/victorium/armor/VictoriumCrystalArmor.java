package flare.victorium.armor;

import flare.victorium.Victorium;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.recipe.Ingredient;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class VictoriumCrystalArmor implements ArmorMaterial {
    private static final int[] BASE_DURABILITY = new int[] {13, 15, 16, 11};
    private static final int[] PROTECTION_VALUES = new int[] {3, 6, 8, 3};

    // In which A is helmet, B chestplate, C leggings and D boots.
    // For reference, Leather uses {1, 2, 3, 1}, and Diamond/Netherite {3, 6, 8, 3}
    @Override
    public int getDurability(EquipmentSlot slot) {
        return BASE_DURABILITY[slot.getEntitySlotId()] * 50;
    }

    @Override
    public int getProtectionAmount(EquipmentSlot slot) {
        return PROTECTION_VALUES[slot.getEntitySlotId()];
    }

    @Override
    public int getEnchantability() {
        return 3;
    }

    @Override
    public SoundEvent getEquipSound() {
        return SoundEvents.ITEM_ARMOR_EQUIP_NETHERITE;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return Ingredient.ofItems(Victorium.VICTORIUM_PLATE);
    }

    @Override
    public String getName() {
        return "victorium";
    }

    @Override
    public float getToughness() {
        return 3.0F;
    }

    @Override
    public float getKnockbackResistance() {
        return 0.0F;
    }

    public static final ArmorMaterial VictoriumCrystalArmor = new VictoriumCrystalArmor();
    public static final Item CUSTOM_MATERIAL_HELMET = new ArmorItem(VictoriumCrystalArmor, EquipmentSlot.HEAD, new Item.Settings().group(ItemGroup.COMBAT));
    public static final Item CUSTOM_MATERIAL_CHESTPLATE = new ArmorItem(VictoriumCrystalArmor, EquipmentSlot.CHEST, new Item.Settings().group(ItemGroup.COMBAT));
    public static final Item CUSTOM_MATERIAL_LEGGINGS = new ArmorItem(VictoriumCrystalArmor, EquipmentSlot.LEGS, new Item.Settings().group(ItemGroup.COMBAT));
    public static final Item CUSTOM_MATERIAL_BOOTS = new ArmorItem(VictoriumCrystalArmor, EquipmentSlot.FEET, new Item.Settings().group(ItemGroup.COMBAT));

    public static void RegisterItems() {
        Registry.register(Registry.ITEM, new Identifier("victorium", "victorium_helmet"), CUSTOM_MATERIAL_HELMET);
        Registry.register(Registry.ITEM, new Identifier("victorium", "victorium_chestplate"), CUSTOM_MATERIAL_CHESTPLATE);
        Registry.register(Registry.ITEM, new Identifier("victorium", "victorium_leggings"), CUSTOM_MATERIAL_LEGGINGS);
        Registry.register(Registry.ITEM, new Identifier("victorium", "victorium_boots"), CUSTOM_MATERIAL_BOOTS);
    }
}
