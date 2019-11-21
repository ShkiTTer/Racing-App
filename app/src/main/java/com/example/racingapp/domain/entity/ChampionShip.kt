package com.example.racingapp.domain.entity

data class ChampionShip(
    val title: String,
    val country: String,
    val races: List<Race>,
    val teams: List<Team>,
    val type: ChampionShipType
)