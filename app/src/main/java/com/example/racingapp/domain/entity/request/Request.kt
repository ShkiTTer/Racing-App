package com.example.racingapp.domain.entity.request

import com.example.racingapp.domain.entity.Team
import com.example.racingapp.domain.entity.tournament.Tournament

data class Request(
    val team: Team,
    val tournament: Tournament,
    val state: RequestState
)