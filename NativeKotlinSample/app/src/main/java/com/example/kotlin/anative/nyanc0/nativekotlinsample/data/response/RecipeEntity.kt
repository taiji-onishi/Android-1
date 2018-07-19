package com.example.kotlin.anative.nyanc0.nativekotlinsample.data.response

import com.squareup.moshi.Json
import se.ansman.kotshi.JsonSerializable

@JsonSerializable
data class RecipeEntity(
        @Json(name = "genre_cd")
        var genreCd: String,
        @Json(name = "genre_name")
        var genreName: String,
        @Json(name = "recipe_id")
        var recipeId: String,
        @Json(name = "recipe_name")
        var recipeName: String,
        var introduction: String,
        @Json(name = "main_gazo")
        var imageUrl: String,
        @Json(name = "recommended_flg")
        var recommendFlg: Int
)