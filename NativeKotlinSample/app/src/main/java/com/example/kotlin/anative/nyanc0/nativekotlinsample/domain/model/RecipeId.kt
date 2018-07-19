package com.example.kotlin.anative.nyanc0.nativekotlinsample.domain.model

data class RecipeId(var value: String) {
    init {
        if (value.isEmpty()) {
            throw IllegalStateException("RecipeId is must not null!!")
        }
    }
}