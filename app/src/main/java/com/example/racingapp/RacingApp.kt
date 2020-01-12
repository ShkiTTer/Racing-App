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
import com.example.racingapp.domain.entity.user.Racer
import com.example.racingapp.domain.repository.IDbRepository
import com.example.racingapp.presentation.viewmodel.LoginViewModel
import com.example.racingapp.presentation.viewmodel.MainViewModel
import com.example.racingapp.presentation.viewmodel.TournamentViewModel
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.context.startKoin
import org.koin.dsl.module
import java.util.*

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
        val manager = Manager("manager1", "manager", "Иван", "Иванов", null)
        val manager2 = Manager("manager2", "manager", "Иван", "Иванов", null)
        val firstRacer = Racer("first", "racer", "Льюис", "Хэмилтон", "Великобритания", Date())
        val secondRacer = Racer("second", "racer", "Валттери", "Боттас", "Финляндия", Date())

        val firstRacer2 = Racer("first2", "racer", "Макс", "Ферстаппен", "Голландия", Date())
        val secondRacer2 = Racer("second2", "racer", "Александр", "Албон", "Тайланд", Date())

        AllData.users.add(manager)
        AllData.users.add(firstRacer)
        AllData.users.add(secondRacer)

        AllData.users.add(manager2)
        AllData.users.add(firstRacer2)
        AllData.users.add(secondRacer2)
        AllData.teams.add(Team("Мерседес", "Германия", listOf(firstRacer, secondRacer), manager))
        AllData.teams.add(Team("Ред булл", "Австрия", listOf(firstRacer2, secondRacer2), manager2))
        manager.setTeam(AllData.teams[0])
        firstRacer.setTeam(AllData.teams[0])
        secondRacer.setTeam(AllData.teams[0])

        manager2.setTeam(AllData.teams[1])
        firstRacer2.setTeam(AllData.teams[1])
        secondRacer2.setTeam(AllData.teams[1])

        AllData.tournaments.add(
            Tournament(
                "Season 2018",
                TournamentType.FORMULA1,
                TournamentState.BEGIN
            )
        )
        AllData.tournaments[0].addTeam(AllData.teams[0])
        AllData.tournaments[0].addTeam(AllData.teams[1])
        AllData.tracks.add(Track("Нюрбургринг", "Германия", 2567))
        AllData.tournaments[0].addRace(Race("Гран-при Германии", AllData.tracks[0], 58))
    }
}