package com.example.racingapp.domain.entity

import com.example.racingapp.domain.entity.result.Result
import com.example.racingapp.domain.entity.user.Racer

data class ChampionShip(
    val title: String,
    val country: String,
    val races: List<Race>,
    val teams: List<Team>,
    val type: ChampionShipType,
    val teamResult: Result<Team>,
    val racerResult: Result<Racer>
)