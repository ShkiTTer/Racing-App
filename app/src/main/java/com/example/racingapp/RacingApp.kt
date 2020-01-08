package com.example.racingapp

import android.app.Application
import com.example.racingapp.data.repository.DbRepository
import com.example.racingapp.domain.entity.Race
import com.example.racingapp.domain.entity.Team
import com.example.racingapp.domain.entity.Track
import com.example.racingapp.domain.entity.tournament.Tournament
import com.example.racingapp.domain.entity.tournament.TournamentState
import com.example.racingapp.domain.entity.tournament.TournamentType
import com.example.racingapp.domain.entity.user.Administrator
import com.example.racingapp.domain.entity.user.Manager
import com.example.racingapp.domain.repository.IDbRepository
import com.example.racingapp.presentation.viewmodel.LoginViewModel
import com.example.racingapp.presentation.viewmodel.MainViewModel
import com.example.racingapp.presentation.viewmodel.TournamentViewModel
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.context.startKoin
import org.koin.dsl.module

class RacingApp : Application() {
    private val koinModule = module {
        single { DbRepository() as IDbRepository }

        viewModel { LoginViewModel() }
        viewModel { MainViewModel() }
        viewModel { TournamentViewModel() }
    }

    override fun onCreate() {
        super.onCreate()

        startKoin {
            modules(koinModule)
            androidContext(applicationContext)
        }

        AllData.users.add(Administrator("root", "root"))
        AllData.users.add(Manager("manager1", "manager", "Иван", "Иванов", null))
        AllData.teams.add(Team("Racing Point", "India", listOf(), AllData.managers[0]))
        AllData.tournaments.add(
            Tournament(
                "Season 2019",
                TournamentType.FORMULA2,
                TournamentState.BEGIN
            )
        )
        AllData.tournaments[0].addTeam(AllData.teams[0])
        AllData.tracks.add(Track("Нюрбургринг", "Германия", 2567))
        AllData.tournaments[0].addRace(Race("Гран-при Германии", AllData.tracks[0], 58))
    }
}