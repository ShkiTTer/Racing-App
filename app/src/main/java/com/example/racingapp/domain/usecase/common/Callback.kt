package com.example.racingapp.domain.usecase.common

interface Callback<T> {
    fun onSuccess(result: T)
    fun onFailure(t: Throwable)
}