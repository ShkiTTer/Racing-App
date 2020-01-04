package com.example.racingapp.domain.entity.championship

import com.example.racingapp.domain.entity.Race
import com.example.racingapp.domain.entity.Team
import com.example.racingapp.domain.entity.result.RacerResult
import com.example.racingapp.domain.entity.result.TeamResult

data class ChampionShip(
    val title: String,
    val type: ChampionShipType,
    var state: ChampionShipState,
    val teams: List<Team>,
    val races: List<Race>,
    val teamResults: List<TeamResult>,
    val racerResults: List<RacerResult>
)
{
    override fun toString(): String = title
}