package com.example.kotlin.anative.nyanc0.nativekotlinsample.presentation.recipe

import android.arch.lifecycle.*
import com.example.kotlin.anative.nyanc0.nativekotlinsample.domain.model.Recipe
import com.example.kotlin.anative.nyanc0.nativekotlinsample.domain.repository.RecommendListRepository
import com.example.kotlin.anative.nyanc0.nativekotlinsample.presentation.Result
import com.example.kotlin.anative.nyanc0.nativekotlinsample.presentation.common.mapper.map
import com.example.kotlin.anative.nyanc0.nativekotlinsample.presentation.common.mapper.toResult
import com.example.kotlin.anative.nyanc0.nativekotlinsample.util.SchedulerProvider
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.rxkotlin.addTo
import io.reactivex.rxkotlin.subscribeBy
import javax.inject.Inject

class RecommendListViewModel @Inject constructor(
        private val recommendListRepository: RecommendListRepository,
        private val schedulerProvider: SchedulerProvider
) : ViewModel(), LifecycleObserver {

    private val compositeDisposable: CompositeDisposable = CompositeDisposable()
    private val mutableRefreshState: MutableLiveData<Result<List<Recipe>>> = MutableLiveData()
    val recipe: LiveData<Result<List<Recipe>>> = mutableRefreshState

    val isLoading: LiveData<Boolean> by lazy {
        recipe.map { it.inProgress }
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    fun onCreate() {
        super.onCleared()
        loadRecipeList()
    }

    override fun onCleared() {
        super.onCleared()
        compositeDisposable.clear()
    }

    private fun loadRecipeList() {
        recommendListRepository.getRecipe().toResult(schedulerProvider).subscribeBy {
            mutableRefreshState.postValue(it)
        }.addTo(compositeDisposable)
    }
}