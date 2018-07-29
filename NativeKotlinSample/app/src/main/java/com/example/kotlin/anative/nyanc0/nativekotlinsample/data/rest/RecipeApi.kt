package com.example.kotlin.anative.nyanc0.nativekotlinsample.data.rest

import android.support.annotation.CheckResult
import com.example.kotlin.anative.nyanc0.nativekotlinsample.data.rest.response.RecipeRestEntity
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query
import javax.inject.Singleton

@Singleton
interface RecipeApi {
    @GET("/recipe")
    @CheckResult
    fun getRecipeList(): Single<List<RecipeRestEntity>>

    @GET("/recipe")
    @CheckResult
    fun getRecipe(@Query("recipe_id") recipeId: String): Single<RecipeRestEntity>
}