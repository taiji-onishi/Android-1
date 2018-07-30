package com.example.kotlin.anative.nyanc0.nativekotlinsample.di

import com.example.kotlin.anative.nyanc0.nativekotlinsample.presentation.recipe.RecipeDetailFragment
import com.example.kotlin.anative.nyanc0.nativekotlinsample.presentation.recipe.RecipeListFragment
import com.example.kotlin.anative.nyanc0.nativekotlinsample.presentation.recipe.RecommendListFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
public abstract class FragmentBuilderModule {
    @ContributesAndroidInjector
    abstract fun contributeRecipeListFragment(): RecipeListFragment

    @ContributesAndroidInjector
    abstract fun contributeRecipeDetailFragment(): RecipeDetailFragment

    @ContributesAndroidInjector
    abstract fun contributeRecommendListFragment(): RecommendListFragment
}