package com.example.racingapp

import android.app.Application
import com.example.racingapp.data.repository.DbRepository
import com.example.racingapp.domain.usecase.IDbRepository
import com.example.racingapp.presentation.viewmodel.MainViewModel
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.context.startKoin
import org.koin.dsl.module

class RacingApp: Application() {
    private val koinModule = module {
        single { DbRepository() as IDbRepository }

        viewModel { MainViewModel() }
    }

    override fun onCreate() {
        super.onCreate()

        startKoin {
            modules(koinModule)
            androidContext(applicationContext)
        }
    }
}