package flare.victorium.toolmaterial;

import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;
import flare.victorium.Victorium;

public class VictoriumCrystal implements ToolMaterial {

	public static final VictoriumCrystal INSTANCE = new VictoriumCrystal();

	@Override
	public int getDurability() {
		return 3500;
	}
	@Override
	public float getMiningSpeedMultiplier() {
		return 10.0f;
	}
	@Override
	public float getAttackDamage() {
		return 5.0f;
	}
	@Override
	public int getMiningLevel(){
		return 4;
	}
	@Override
	public int getEnchantability(){
		return 30;
	}
	@Override
	public Ingredient getRepairIngredient(){
		return Ingredient.ofItems(Victorium.VICTORIUM_CRYSTAL);
	}
}
