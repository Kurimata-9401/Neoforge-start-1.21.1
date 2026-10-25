package net.nittoria.projectone.recipe;

import net.minecraft.core.NonNullList;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.CraftingBookCategory;
import net.minecraft.world.item.crafting.CraftingInput;
import net.minecraft.world.item.crafting.ShapelessRecipe;
import net.minecraft.world.item.crafting.Ingredient;
import net.neoforged.neoforge.common.CommonHooks;
import net.nittoria.projectone.ProjectOne;
import net.nittoria.projectone.item.ModItems;

import java.util.List;

public class RoyalAmethystPoisonSackRecipe extends ShapelessRecipe {

    public RoyalAmethystPoisonSackRecipe(String group, CraftingBookCategory category, ItemStack result, List<Ingredient> ingredients) {
        super(group, category, result, ingredients);
    }

    @Override
    public NonNullList<ItemStack> getRemainingItems(CraftingInput input) {
        // Сначала получаем стандартные остатки (например, пустые ведра)
        NonNullList<ItemStack> remaining = super.getRemainingItems(input);

        for (int i = 0; i < input.size(); i++) {
            ItemStack stack = input.getItem(i);
            // Проверяем, что это именно наш инструмент
            if (stack.is(ModItems.RAPS.get())) {
                ItemStack damagedTool = stack.copy();
                // Увеличиваем значение урона (износ) на 1
                damagedTool.setDamageValue(damagedTool.getDamageValue() + 1);

                // Если инструмент сломался, он не остаётся в сетке
                if (damagedTool.getDamageValue() >= damagedTool.getMaxDamage()) {
                    remaining.set(i, ItemStack.EMPTY);
                    // Опционально: здесь можно вызвать событие поломки предмета
                    // CommonHooks.onPlayerDestroyItem(...)
                } else {
                    remaining.set(i, damagedTool);
                }
            }
        }
        return remaining;
    }
}