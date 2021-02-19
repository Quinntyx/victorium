package flare.victorium.mixin;

import flare.victorium.tool.CustomPickaxeItem;
import flare.victorium.tool.CustomShovelItem;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.item.ItemStack;
import net.minecraft.recipe.ShapedRecipe;
import net.minecraft.util.Identifier;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;


@Mixin(ShapedRecipe.class)
public class CraftingInjector {
    private static final ItemStack VICTORIUM_PICKAXE_OVERRIDE = new ItemStack(CustomPickaxeItem.VICTORIUM_PICKAXE, 1);
    private static final ItemStack VICTORIUM_SHOVEL_OVERRIDE = new ItemStack(CustomShovelItem.VICTORIUM_SHOVEL, 1);

    static{
        VICTORIUM_PICKAXE_OVERRIDE.addEnchantment(Enchantments.FORTUNE, 4);
        VICTORIUM_SHOVEL_OVERRIDE.addEnchantment(Enchantments.SILK_TOUCH, 1);
    }

    @Shadow
    @Final
    private Identifier id;
    @Inject(method = "getOutput", at = @At("HEAD"), cancellable = true)
    public void victorium$overrideRecipeOutput(CallbackInfoReturnable<ItemStack> cir) {
        if (id.equals(new Identifier("victorium:victorium_pickaxe")))
            cir.setReturnValue(VICTORIUM_PICKAXE_OVERRIDE);

        if (id.equals(new Identifier("victorium:victorium_shovel")))
            cir.setReturnValue(VICTORIUM_SHOVEL_OVERRIDE);
    }
}
