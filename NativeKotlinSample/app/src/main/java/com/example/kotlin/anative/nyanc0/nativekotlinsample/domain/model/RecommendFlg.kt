package com.example.kotlin.anative.nyanc0.nativekotlinsample.domain.model

data class RecommendFlg(val flg: Int) {
    fun isRecommend(): Boolean = flg == 1
}