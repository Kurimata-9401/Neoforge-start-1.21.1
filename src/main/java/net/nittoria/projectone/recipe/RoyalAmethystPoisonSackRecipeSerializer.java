package net.nittoria.projectone.recipe;

import com.mojang.serialization.MapCodec;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.ShapedRecipe;

public class RoyalAmethystPoisonSackRecipeSerializer implements RecipeSerializer<RoyalAmethystPoisonSackRecipe> {

    public static final RoyalAmethystPoisonSackRecipeSerializer INSTANCE = new RoyalAmethystPoisonSackRecipeSerializer();

    public static final MapCodec<RoyalAmethystPoisonSackRecipe> CODEC =
            ShapedRecipe.Serializer.CODEC.xmap(
                    shaped -> new RoyalAmethystPoisonSackRecipe(
                            shaped.getGroup(),
                            shaped.category(),
                            shaped.pattern,
                            shaped.getResultItem(null),
                            shaped.showNotification()
                    ),
                    custom -> custom
            );

    public static final StreamCodec<RegistryFriendlyByteBuf, RoyalAmethystPoisonSackRecipe> STREAM_CODEC =
            ShapedRecipe.Serializer.STREAM_CODEC.map(
                    shaped -> new RoyalAmethystPoisonSackRecipe(
                            shaped.getGroup(),
                            shaped.category(),
                            shaped.pattern,
                            shaped.getResultItem(null),
                            shaped.showNotification()
                    ),
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