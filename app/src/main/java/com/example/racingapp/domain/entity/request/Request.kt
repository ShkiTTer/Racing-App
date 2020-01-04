package com.example.racingapp.domain.entity.request

import com.example.racingapp.domain.entity.Team
import com.example.racingapp.domain.entity.championship.ChampionShip

data class Request(
    val team: Team,
    val championShip: ChampionShip,
    val state: RequestState
)