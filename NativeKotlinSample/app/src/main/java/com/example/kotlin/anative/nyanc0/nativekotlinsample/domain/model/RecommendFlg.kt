package com.example.kotlin.anative.nyanc0.nativekotlinsample.domain.model

data class RecommendFlg(private val flg: Int) {
    fun isReccomend(): Boolean = flg == 1
}