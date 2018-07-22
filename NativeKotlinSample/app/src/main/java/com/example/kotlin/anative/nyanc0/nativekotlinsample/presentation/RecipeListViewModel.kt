package com.example.kotlin.anative.nyanc0.nativekotlinsample.presentation

import android.arch.lifecycle.LifecycleObserver
import android.arch.lifecycle.ViewModel
import com.example.kotlin.anative.nyanc0.nativekotlinsample.domain.repository.RecipeListRepository
import com.example.kotlin.anative.nyanc0.nativekotlinsample.util.SchedulerProvider
import javax.inject.Inject

class RecipeListViewModel @Inject constructor(
        private val recipeListRepository: RecipeListRepository,
        private val schedulerProvider: SchedulerProvider
) : ViewModel(), LifecycleObserver {
    
}