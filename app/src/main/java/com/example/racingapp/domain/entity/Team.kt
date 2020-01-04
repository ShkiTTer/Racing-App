package com.example.racingapp.domain.entity

import com.example.racingapp.domain.entity.user.Racer

data class Team(
    val title: String,
    val country: String,
    val racers: List<Racer>
)