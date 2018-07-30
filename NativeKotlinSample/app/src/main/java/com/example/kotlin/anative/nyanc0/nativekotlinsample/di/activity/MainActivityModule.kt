package com.example.kotlin.anative.nyanc0.nativekotlinsample.di.activity

import android.support.v7.app.AppCompatActivity
import com.example.kotlin.anative.nyanc0.nativekotlinsample.presentation.MainActivity
import com.example.kotlin.anative.nyanc0.nativekotlinsample.presentation.recipe.RecipeListFragment
import com.example.kotlin.anative.nyanc0.nativekotlinsample.presentation.recipe.RecommendListFragment
import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector


@Module
interface MainActivityModule {

    @Binds
    fun providesAppCompatActivity(mainActivity: MainActivity): AppCompatActivity

    @ContributesAndroidInjector
    fun contributeRecipeListFragment(): RecipeListFragment

    @ContributesAndroidInjector
    fun contributeRecommendListFragment(): RecommendListFragment
}