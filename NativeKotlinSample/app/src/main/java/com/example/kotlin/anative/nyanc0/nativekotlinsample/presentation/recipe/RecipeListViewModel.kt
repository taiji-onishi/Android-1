package com.example.kotlin.anative.nyanc0.nativekotlinsample.presentation.recipe

import android.arch.lifecycle.*
import android.util.Log
import com.example.kotlin.anative.nyanc0.nativekotlinsample.domain.model.Recipe
import com.example.kotlin.anative.nyanc0.nativekotlinsample.domain.repository.RecipeListRepository
import com.example.kotlin.anative.nyanc0.nativekotlinsample.presentation.Result
import com.example.kotlin.anative.nyanc0.nativekotlinsample.presentation.common.mapper.map
import com.example.kotlin.anative.nyanc0.nativekotlinsample.presentation.common.mapper.toLiveData
import com.example.kotlin.anative.nyanc0.nativekotlinsample.presentation.common.mapper.toResult
import com.example.kotlin.anative.nyanc0.nativekotlinsample.util.SchedulerProvider
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.rxkotlin.addTo
import io.reactivex.rxkotlin.subscribeBy
import javax.inject.Inject

class RecipeListViewModel @Inject constructor(
        private val recipeListRepository: RecipeListRepository,
        private val schedulerProvider: SchedulerProvider
) : ViewModel(), LifecycleObserver {

    private val compositeDisposable: CompositeDisposable = CompositeDisposable()
    private val mutableRefreshState: MutableLiveData<Result<List<Recipe>>> = MutableLiveData()
    val refreshResult: LiveData<Result<List<Recipe>>> = mutableRefreshState

    val recipeList: LiveData<Result<List<Recipe>>> by lazy {
        recipeListRepository
                .recipeList
                .toResult(schedulerProvider)
                .toLiveData()
    }

    val isLoading: LiveData<Boolean> by lazy {
        recipeList.map { it.inProgress }
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    fun onCreate() {
        super.onCleared()
        loadRecipeList()
    }

    private fun loadRecipeList() =
            recipeListRepository
                    .getRecipeList()
                    .toResult<List<Recipe>>(schedulerProvider)
                    .subscribeBy(
                            onNext = {
                                mutableRefreshState.postValue(it) },
                            onError = { throwable -> Log.d("NWError", throwable.message) }
                    )
                    .addTo(compositeDisposable)


    override fun onCleared() {
        super.onCleared()
        compositeDisposable.clear()
    }

    fun onRetry() {
        loadRecipeList()
    }
}