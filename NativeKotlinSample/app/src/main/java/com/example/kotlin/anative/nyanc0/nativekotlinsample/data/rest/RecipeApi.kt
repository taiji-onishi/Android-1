package com.example.kotlin.anative.nyanc0.nativekotlinsample.data.rest

import android.support.annotation.CheckResult
import com.example.kotlin.anative.nyanc0.nativekotlinsample.data.rest.response.RecipeRestEntity
import io.reactivex.Flowable
import io.reactivex.Single
import retrofit2.http.GET
import javax.inject.Singleton

@Singleton
interface RecipeApi {
    @GET
    @CheckResult
    fun getRecipeList(): Single<List<RecipeRestEntity>>
}