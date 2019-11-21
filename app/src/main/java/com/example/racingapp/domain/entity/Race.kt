package com.example.racingapp.domain.entity

import com.example.racingapp.domain.entity.Track

data class Race(
    val title: String,
    val country: String,
    val track: Track,
    val cntLaps: Int
)