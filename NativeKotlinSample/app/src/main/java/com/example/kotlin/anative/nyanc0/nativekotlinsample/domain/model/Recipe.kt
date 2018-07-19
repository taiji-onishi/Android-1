package com.example.kotlin.anative.nyanc0.nativekotlinsample.domain.model

data class Recipe(
        val recipeId: RecipeId,
        val genre: Genre,
        val introduction: String?,
        val imageUrl: String?,
        val recommendFlg: RecommendFlg
)