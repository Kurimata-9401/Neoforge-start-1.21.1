package net.nittoria.projectone;

import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.nittoria.projectone.ProjectOne;
import net.nittoria.projectone.recipe.RoyalAmethystPoisonSackRecipeSerializer;

public class ModRecipes {
    public static final DeferredRegister<RecipeSerializer<?>> SERIALIZERS =
            DeferredRegister.create(Registries.RECIPE_SERIALIZER, ProjectOne.MOD_ID);

    public static final DeferredHolder<RecipeSerializer<?>, RoyalAmethystPoisonSackRecipeSerializer> ROYAL_AMETHYST_POISON_SACK_SERIALIZER =
            SERIALIZERS.register("royal_amethyst_poison_sack", () -> RoyalAmethystPoisonSackRecipeSerializer.INSTANCE);

    public static void register(IEventBus eventBus) {
        SERIALIZERS.register(eventBus);
    }
}