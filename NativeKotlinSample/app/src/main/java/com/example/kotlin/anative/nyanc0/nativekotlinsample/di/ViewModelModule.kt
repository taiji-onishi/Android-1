package com.example.kotlin.anative.nyanc0.nativekotlinsample.di

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import com.example.kotlin.anative.nyanc0.nativekotlinsample.presentation.recipe.RecipeDetailViewModel
import com.example.kotlin.anative.nyanc0.nativekotlinsample.presentation.recipe.RecipeListViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Suppress("unused")
@Module
abstract class ViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(RecipeListViewModel::class)
    abstract fun bindRecipeListViewModel(recipeListViewModel: RecipeListViewModel): ViewModel

    @Binds
    abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory

    @Binds
    @IntoMap
    @ViewModelKey(RecipeDetailViewModel::class)
    abstract fun bindRecipeViewModel(recipeDetailViewModel: RecipeDetailViewModel): ViewModel
}