package com.example.kotlin.anative.nyanc0.nativekotlinsample.data.db.entity

import com.example.kotlin.anative.nyanc0.nativekotlinsample.domain.model.*

fun RecipeDbEntity.toRecipe(): Recipe =
        Recipe(
                recipeId = RecipeId(recipeId),
                genre = Genre(GenreCd(genreCd), genreName),
                introduction = introduction,
                imageUrl = imageUrl,
                recommendFlg = RecommendFlg(recommendFlg)
        )

fun List<RecipeDbEntity>.toRecipeList(): List<Recipe> = map {
    it.toRecipe()
}