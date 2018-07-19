package com.example.kotlin.anative.nyanc0.nativekotlinsample.domain.repository

import android.support.annotation.CheckResult
import com.example.kotlin.anative.nyanc0.nativekotlinsample.domain.model.Recipe
import io.reactivex.Flowable

interface RecipeListRepository {
    @CheckResult
    fun getRecipeList(): Flowable<List<Recipe>>
}