package com.example.kotlin.anative.nyanc0.nativekotlinsample.di.activity

import android.support.v7.app.AppCompatActivity
import com.example.kotlin.anative.nyanc0.nativekotlinsample.presentation.recipe.DetailActivity
import com.example.kotlin.anative.nyanc0.nativekotlinsample.presentation.recipe.RecipeDetailFragment
import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
interface DetailActivityModule {

    @Binds
    fun providesAppCompatActivity(detailActivity: DetailActivity): AppCompatActivity

    @ContributesAndroidInjector
    fun contributeRecipeDetailFragment(): RecipeDetailFragment

}