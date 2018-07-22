package com.example.kotlin.anative.nyanc0.nativekotlinsample.presentation

open class Result<T>(val isLoading: Boolean) {

    class IsLoading<T> : Result<T>(true)
    class Success<T>(var data: T) : Result<T>(false)
    class Error<T>(val errorMessage: String?, val e: Throwable) : Result<T>(false)

    companion object {
        fun <T> isLoading(): Result<T> = IsLoading()
        fun <T> success(data: T) = Success(data)
        fun <T> error(errorMessage: String, e: Throwable): Result<T> = Error(errorMessage, e)
    }
}