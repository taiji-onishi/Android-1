package com.example.kotlin.anative.nyanc0.nativekotlinsample.data.rest.response

import se.ansman.kotshi.JsonSerializable

@JsonSerializable
data class CookingIngredientsRestEntity(
        var material: String,
        var quantity: String
)