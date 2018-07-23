package com.example.kotlin.anative.nyanc0.nativekotlinsample.presentation.common.mapper

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.LiveDataReactiveStreams
import android.support.annotation.CheckResult
import com.example.kotlin.anative.nyanc0.nativekotlinsample.presentation.Result
import com.example.kotlin.anative.nyanc0.nativekotlinsample.util.SchedulerProvider
import io.reactivex.Completable
import io.reactivex.Flowable
import io.reactivex.Observable
import org.reactivestreams.Publisher

@CheckResult
fun <T> Flowable<T>.toResult(schedulerProvider: SchedulerProvider):
        Flowable<Result<T>> {
    return compose { item ->
        item
                .map { Result.success(it) }
                .onErrorReturn { e ->
                    Result.failure(e.message ?: "unknown", e)
                }.observeOn(schedulerProvider.ui())
                .startWith(Result.inProgress())
    }
}

@CheckResult fun <T> Observable<T>.toResult(schedulerProvider: SchedulerProvider):
        Observable<Result<T>> {
    return compose { item ->
        item
                .map { Result.success(it) }
                .onErrorReturn { e -> Result.failure(e.message ?: "unknown", e) }
                .observeOn(schedulerProvider.ui())
                .startWith(Result.inProgress())
    }
}

@CheckResult fun <T> Completable.toResult(schedulerProvider: SchedulerProvider):
        Observable<Result<T>> {
    return toObservable<T>().toResult(schedulerProvider)
}

fun <T> Publisher<T>.toLiveData()
        = LiveDataReactiveStreams.fromPublisher(this) as LiveData<T>
