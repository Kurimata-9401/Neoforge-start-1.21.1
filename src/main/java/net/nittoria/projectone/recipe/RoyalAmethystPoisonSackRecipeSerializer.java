package net.nittoria.projectone.recipe;

import com.mojang.serialization.MapCodec;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.ShapelessRecipe;
import net.nittoria.projectone.recipe.RoyalAmethystPoisonSackRecipe;

public class RoyalAmethystPoisonSackRecipeSerializer implements RecipeSerializer<RoyalAmethystPoisonSackRecipe> {

    // В 1.21.1 ShapelessRecipe уже имеет готовые кодек и стрим-кодек, которые можно переиспользовать
    public static final RoyalAmethystPoisonSackRecipeSerializer INSTANCE = new RoyalAmethystPoisonSackRecipeSerializer();
    public static final MapCodec<RoyalAmethystPoisonSackRecipe> CODEC = ShapelessRecipe.Serializer.CODEC.xmap(
            // Преобразование из стандартного ShapelessRecipe в наш кастомный
            shapeless -> new RoyalAmethystPoisonSackRecipe(shapeless.getGroup(), shapeless.category(), shapeless.getResultItem(null), shapeless.getIngredients()),
            // Обратное преобразование (обычно не требуется, но можно вернуть как есть)
            custom -> custom
    );
    public static final StreamCodec<RegistryFriendlyByteBuf, RoyalAmethystPoisonSackRecipe> STREAM_CODEC =
            ShapelessRecipe.Serializer.STREAM_CODEC.map(
                    shapeless -> new RoyalAmethystPoisonSackRecipe(shapeless.getGroup(), shapeless.category(), shapeless.getResultItem(null), shapeless.getIngredients()),
                    custom -> custom
            );

    @Override
    public MapCodec<RoyalAmethystPoisonSackRecipe> codec() {
        return CODEC;
    }

    @Override
    public StreamCodec<RegistryFriendlyByteBuf, RoyalAmethystPoisonSackRecipe> streamCodec() {
        return STREAM_CODEC;
    }
}