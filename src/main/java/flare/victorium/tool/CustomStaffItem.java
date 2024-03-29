package flare.victorium.tool;

import flare.victorium.toolmaterial.VictoriumCrystal;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.passive.FoxEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ToolItem;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.World;

public class CustomStaffItem extends Item {
    public CustomStaffItem(Item.Settings settings) {
        super(settings);
    }

    public ItemStack finishUsing(ItemStack stack, World world, LivingEntity user) {
        ItemStack itemStack = super.finishUsing(stack, world, user);
        if (!world.isClient) {
            double d = user.getX();
            double e = user.getY();
            double f = user.getZ();

            for(int i = 0; i < 16; ++i) {
                double g = user.getX() + (user.getRandom().nextDouble() - 0.5D) * 16.0D;
                double h = MathHelper.clamp(user.getY() + (double)(user.getRandom().nextInt(16) - 8), 0.0D, (double)(world.getDimensionHeight() - 1));
                double j = user.getZ() + (user.getRandom().nextDouble() - 0.5D) * 16.0D;
                if (user.hasVehicle()) {
                    user.stopRiding();
                }

                if (user.teleport(g, h, j, true)) {
                    SoundEvent soundEvent = user instanceof FoxEntity ? SoundEvents.ENTITY_FOX_TELEPORT : SoundEvents.ITEM_CHORUS_FRUIT_TELEPORT;
                    world.playSound((PlayerEntity)null, d, e, f, soundEvent, SoundCategory.PLAYERS, 1.0F, 1.0F);
                    user.playSound(soundEvent, 1.0F, 1.0F);
                    break;
                }
            }

            if (user instanceof PlayerEntity) {
                ((PlayerEntity)user).getItemCooldownManager().set(this, 20);
            }
        }

        return itemStack;
    }

    public static final Item ENDER_STAFF = new CustomStaffItem(new Item.Settings().group(ItemGroup.TOOLS).maxCount(1));

    public static void registerItems() {
        Registry.register(Registry.ITEM, new Identifier("victorium", "ender_staff"), ENDER_STAFF);
    }
}
