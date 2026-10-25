package net.nittoria.projectone.item.custom;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.effects.DamageItem;
import net.nittoria.projectone.ProjectOne;

public class RoyalAmethystPoisonSack extends Item {
    public RoyalAmethystPoisonSack(Properties properties) {
        super(properties);
    }

    @Override
    public boolean hasCraftingRemainingItem(ItemStack stack) {

        return super.hasCraftingRemainingItem(stack);
    }

    @Override
    public boolean isDamageable(ItemStack stack) {
        return super.isDamageable(stack);
    }
}
