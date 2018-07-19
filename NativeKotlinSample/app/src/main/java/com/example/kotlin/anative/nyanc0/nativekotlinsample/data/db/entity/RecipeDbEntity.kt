package com.example.kotlin.anative.nyanc0.nativekotlinsample.data.db.entity

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

@Entity(tableName = "recipe")
data class RecipeDbEntity(
        @PrimaryKey var recipeId: String,
        var recipeName: String,
        var genreCd: String,
        var genreName: String,
        var introduction: String,
        var imageUrl: String,
        var recommendFlg: Int
)