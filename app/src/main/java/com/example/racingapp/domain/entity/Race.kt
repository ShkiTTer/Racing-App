package com.example.racingapp.domain.entity

import com.example.racingapp.domain.entity.result.Result
import com.example.racingapp.domain.entity.user.Racer

data class Race(
    val title: String,
    val country: String,
    val track: Track,
    val cntLaps: Int,
    val result: Result<Racer>
)