package com.example.kotlin.anative.nyanc0.nativekotlinsample.data.db.entity

import com.example.kotlin.anative.nyanc0.nativekotlinsample.data.rest.response.CookingIngredientsRestEntity
import com.example.kotlin.anative.nyanc0.nativekotlinsample.data.rest.response.CookingMethodRestEntity
import com.example.kotlin.anative.nyanc0.nativekotlinsample.domain.model.*

fun RecipeDbEntity.toRecipe(): Recipe =
        Recipe(
                recipeId = RecipeId(recipeId),
                recipeName = recipeName,
                genre = Genre(GenreCd(genreCd), genreName),
                introduction = introduction,
                imageUrl = imageUrl,
                recommendFlg = RecommendFlg(recommendFlg),
                ingredients = listOf(),
                cookingMethod = listOf()
        )

fun List<RecipeDbEntity>.toRecipeList(): List<Recipe> = map {
    it.toRecipe()
}

fun List<CookingIngredientsRestEntity>.toCookingIngredientsList(): List<CookingIngredients> = map {
    CookingIngredients(it.material, it.quantity)
}

fun List<CookingMethodRestEntity>.toCookingMethodList(): List<CookingMethod> = map {
    CookingMethod(it.procedure_no, it.procedure)
}