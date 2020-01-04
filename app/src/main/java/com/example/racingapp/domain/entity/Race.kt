package com.example.racingapp.domain.entity

import com.example.racingapp.domain.entity.result.RacerResult
import com.example.racingapp.domain.entity.result.TeamResult

data class Race(
    val title: String,
    val country: String,
    val track: Track,
    val cntLaps: Int,
    val racerResults: List<RacerResult>,
    val teamResults: List<TeamResult>
    )