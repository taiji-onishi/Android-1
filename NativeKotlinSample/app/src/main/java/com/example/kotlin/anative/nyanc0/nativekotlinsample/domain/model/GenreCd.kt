package com.example.kotlin.anative.nyanc0.nativekotlinsample.domain.model

data class GenreCd(var value: String) {
    init {
        if (value.isEmpty()) {
            throw IllegalStateException("GenreCd is must not null!!")
        }
    }
}