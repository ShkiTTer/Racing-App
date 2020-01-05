package com.example.racingapp.domain.entity.tournament

import com.example.racingapp.domain.entity.Race
import com.example.racingapp.domain.entity.Team
import com.example.racingapp.domain.entity.result.RacerResult
import com.example.racingapp.domain.entity.result.TeamResult

class Tournament(
    var title: String,
    var type: TournamentType,
    var state: TournamentState
) {
    private val mTeams = mutableListOf<Team>()
    private val mRaces = mutableListOf<Race>()

    val teams: List<Team>
        get() = mTeams

    val races: List<Race>
        get() = mRaces

    fun addRace(race: Race) {
        mRaces.add(race)
    }

    fun addTeam(team: Team) {
        mTeams.add(team)
    }
}