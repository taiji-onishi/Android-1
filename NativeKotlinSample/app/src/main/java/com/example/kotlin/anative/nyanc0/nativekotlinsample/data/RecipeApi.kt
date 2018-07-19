package com.example.kotlin.anative.nyanc0.nativekotlinsample.data

import android.support.annotation.CheckResult
import com.example.kotlin.anative.nyanc0.nativekotlinsample.data.response.RecipeEntity
import io.reactivex.Flowable
import retrofit2.http.GET
import javax.inject.Singleton

@Singleton
interface RecipeApi {
    @GET
    @CheckResult
    fun getRecipeList(): Flowable<List<RecipeEntity>>
}