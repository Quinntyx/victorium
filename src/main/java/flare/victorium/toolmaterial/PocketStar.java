package flare.victorium.toolmaterial;

import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;
import flare.victorium.Victorium;

public class PocketStar implements ToolMaterial {

    public static final PocketStar INSTANCE = new PocketStar();

    @Override
    public int getDurability() {
        return 5500;
    }
    @Override
    public float getMiningSpeedMultiplier() {
        return 20.0f;
    }
    @Override
    public float getAttackDamage() {
        return 10.0f;
    }
    @Override
    public int getMiningLevel(){
        return 5;
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
