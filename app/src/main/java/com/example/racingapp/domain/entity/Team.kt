package com.example.racingapp.domain.entity

import com.example.racingapp.domain.entity.user.Manager

data class Team(
    val title: String,
    val country: String,
    val manager: Manager
)