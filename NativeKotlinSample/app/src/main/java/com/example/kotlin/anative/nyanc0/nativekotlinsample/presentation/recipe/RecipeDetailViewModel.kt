package com.example.kotlin.anative.nyanc0.nativekotlinsample.presentation.recipe

import android.arch.lifecycle.LifecycleObserver
import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import com.example.kotlin.anative.nyanc0.nativekotlinsample.domain.model.Recipe
import com.example.kotlin.anative.nyanc0.nativekotlinsample.domain.model.RecipeId
import com.example.kotlin.anative.nyanc0.nativekotlinsample.domain.repository.RecipeRepository
import com.example.kotlin.anative.nyanc0.nativekotlinsample.presentation.Result
import com.example.kotlin.anative.nyanc0.nativekotlinsample.presentation.common.mapper.map
import com.example.kotlin.anative.nyanc0.nativekotlinsample.presentation.common.mapper.toResult
import com.example.kotlin.anative.nyanc0.nativekotlinsample.util.SchedulerProvider
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.rxkotlin.addTo
import io.reactivex.rxkotlin.subscribeBy
import javax.inject.Inject

class RecipeDetailViewModel @Inject constructor(
        private val repository: RecipeRepository,
        private val schedulerProvider: SchedulerProvider
) : ViewModel(), LifecycleObserver {

    private val compositeDisposable: CompositeDisposable = CompositeDisposable()

    private val mutableRefreshState: MutableLiveData<Result<Recipe>> = MutableLiveData()
    val recipe: LiveData<Result<Recipe>> = mutableRefreshState

    val isLoading: LiveData<Boolean> by lazy {
        recipe.map { it.inProgress }
    }

    override fun onCleared() {
        super.onCleared()
        compositeDisposable.clear()
    }

    fun loadRecipe(recipeId: RecipeId) {
        repository.getRecipe(recipeId)
                .toResult(schedulerProvider)
                .subscribeBy { result ->
                    mutableRefreshState.postValue(result)
                }.addTo(compositeDisposable)
    }
}