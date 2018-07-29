package com.example.kotlin.anative.nyanc0.nativekotlinsample.data.rest.response

import com.squareup.moshi.Json
import se.ansman.kotshi.JsonSerializable

@JsonSerializable
data class RecipeRestEntity(
        @Json(name = "recipe_id")
        var recipeId: String,
        @Json(name = "recipe_name")
        var recipeName: String,
        @Json(name = "genre_cd")
        var genreCd: String,
        @Json(name = "genre_name")
        var genreName: String,
        var introduction: String,
        @Json(name = "main_gazo")
        var imageUrl: String,
        @Json(name = "recommended_flg")
        var recommendFlg: Int,
        @Json(name = "cooking_ingredients")
        var cookingIngredientsList: List<CookingIngredientsRestEntity> = listOf(),
        @Json(name = "cooking_method")
        var cookingMethodList: List<CookingMethodRestEntity> = listOf()
)