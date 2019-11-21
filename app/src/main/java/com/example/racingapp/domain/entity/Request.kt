package com.example.racingapp.domain.entity

data class Request(
    val team: Team,
    val championShip: ChampionShip,
    val state: RequestState
)