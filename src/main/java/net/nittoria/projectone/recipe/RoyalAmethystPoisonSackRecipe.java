package net.nittoria.projectone.recipe;

import net.minecraft.core.NonNullList;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.CraftingBookCategory;
import net.minecraft.world.item.crafting.CraftingInput;
import net.minecraft.world.item.crafting.ShapedRecipe;
import net.minecraft.world.item.crafting.ShapedRecipePattern;
import net.nittoria.projectone.item.ModItems;

public class RoyalAmethystPoisonSackRecipe extends ShapedRecipe {

    public RoyalAmethystPoisonSackRecipe(String group, CraftingBookCategory category,
                                         ShapedRecipePattern pattern, ItemStack result,
                                         boolean showNotification) {
        super(group, category, pattern, result, showNotification);
    }

    @Override
    public NonNullList<ItemStack> getRemainingItems(CraftingInput input) {
        NonNullList<ItemStack> remaining = super.getRemainingItems(input);

        for (int i = 0; i < input.size(); i++) {
            ItemStack stack = input.getItem(i);
            if (stack.is(ModItems.RAPS.get())) {
                ItemStack damaged = stack.copy();
                damaged.setDamageValue(damaged.getDamageValue() + 1);

                if (damaged.getDamageValue() >= damaged.getMaxDamage()) {
                    remaining.set(i, ItemStack.EMPTY);      // fully used
                } else {
                    remaining.set(i, damaged);              // return damaged sack
                }
            }
        }
        return remaining;
    }
}