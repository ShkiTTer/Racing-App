package com.example.racingapp

import android.app.Application
import com.example.racingapp.data.repository.DbRepository
import com.example.racingapp.domain.entity.Team
import com.example.racingapp.domain.entity.user.Administrator
import com.example.racingapp.domain.entity.user.Manager
import com.example.racingapp.domain.repository.IDbRepository
import com.example.racingapp.presentation.viewmodel.LoginViewModel
import com.example.racingapp.presentation.viewmodel.MainViewModel
import com.example.racingapp.presentation.viewmodel.RegistrationViewModel
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.context.startKoin
import org.koin.dsl.module

class RacingApp: Application() {
    private val koinModule = module {
        single { DbRepository() as IDbRepository }

        viewModel { LoginViewModel() }
        viewModel { RegistrationViewModel() }
        viewModel { MainViewModel() }
    }

    override fun onCreate() {
        super.onCreate()

        startKoin {
            modules(koinModule)
            androidContext(applicationContext)
        }

        AllData.users.add(Administrator("root", "root"))
        AllData.teams.add(Team("Racing Point", "India"))
        AllData.users.add(Manager("manager1", "manager", team = AllData.teams[0]))
    }
}