package com.example.kotlin.anative.nyanc0.nativekotlinsample.di

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import com.example.kotlin.anative.nyanc0.nativekotlinsample.presentation.recipe.RecipeDetailViewModel
import com.example.kotlin.anative.nyanc0.nativekotlinsample.presentation.recipe.RecipeListViewModel
import com.example.kotlin.anative.nyanc0.nativekotlinsample.presentation.recipe.RecommendListViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Suppress("unused")
@Module
interface ViewModelModule {

    @Binds
    fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory

    @Binds
    @IntoMap
    @ViewModelKey(RecipeListViewModel::class)
    fun bindRecipeListViewModel(recipeListViewModel: RecipeListViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(RecipeDetailViewModel::class)
    fun bindRecipeViewModel(recipeDetailViewModel: RecipeDetailViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(RecommendListViewModel::class)
    fun bindRecommendListViewModel(recommendListViewModel: RecommendListViewModel): ViewModel
}