package com.example.racingapp.domain.entity.tournament

import com.example.racingapp.domain.entity.Race
import com.example.racingapp.domain.entity.Team
import com.example.racingapp.domain.entity.result.RacerResult
import com.example.racingapp.domain.entity.result.TeamResult

data class Tournament(
    var title: String,
    var type: TournamentType,
    var state: TournamentState,
    val teams: List<Team>,
    val races: List<Race>
)