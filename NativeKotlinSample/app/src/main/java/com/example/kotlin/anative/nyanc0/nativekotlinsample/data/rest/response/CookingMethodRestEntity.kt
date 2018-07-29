package com.example.kotlin.anative.nyanc0.nativekotlinsample.data.rest.response

import se.ansman.kotshi.JsonSerializable

@JsonSerializable
data class CookingMethodRestEntity(
        var procedure_no: String,
        var procedure: String
)
