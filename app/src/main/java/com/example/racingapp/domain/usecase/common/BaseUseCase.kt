package com.example.racingapp.domain.usecase.common

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import kotlin.coroutines.CoroutineContext

abstract class BaseUseCase<T> : CoroutineScope {
    override val coroutineContext: CoroutineContext
        get() = Dispatchers.Main

    private val bgContext = Dispatchers.IO

    abstract fun doInBackground(): T

    fun execute(callback: Callback<T>) {
        launch {
            try {
                val data = withContext(Dispatchers.Default) { doInBackground() }

                callback.onSuccess(data)
            }
            catch (t: Throwable) {
                callback.onFailure(t)
            }
        }
    }
}