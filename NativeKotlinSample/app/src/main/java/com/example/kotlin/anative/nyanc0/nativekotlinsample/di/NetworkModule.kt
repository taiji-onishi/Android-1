package com.example.kotlin.anative.nyanc0.nativekotlinsample.di

import com.example.kotlin.anative.nyanc0.nativekotlinsample.data.ApplicationJsonAdapterFactory
import com.example.kotlin.anative.nyanc0.nativekotlinsample.data.RecipeApi
import com.squareup.moshi.Moshi
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton

@Module
open class NetworkModule {

    companion object {
        val instance = NetworkModule()
    }

    @Singleton
    @Provides
    fun provideOkHttpClient()
            : OkHttpClient = OkHttpClient.Builder().build()

    @Singleton
    @Provides
    fun provideRetrofit(okHttpClient: OkHttpClient)
            : Retrofit {
        return Retrofit.Builder()
                .client(okHttpClient)
                .baseUrl("http://10.0.0.2:3000/recipe/")
                .addConverterFactory(MoshiConverterFactory.create(Moshi.Builder()
                        .add(ApplicationJsonAdapterFactory.INSTANCE)
                        .build()))
                .addCallAdapterFactory(RxJava2CallAdapterFactory.createAsync())
                .build()
    }

    @Singleton
    @Provides
    fun provideRecipeApi(retrofit: Retrofit): RecipeApi {
        return retrofit.create(RecipeApi::class.java)
    }
}