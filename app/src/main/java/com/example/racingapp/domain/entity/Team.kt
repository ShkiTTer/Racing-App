package com.example.racingapp.domain.entity

import com.example.racingapp.domain.entity.user.Manager
import com.example.racingapp.domain.entity.user.Racer

data class Team(
    var title: String,
    var country: String,
    val racers: List<Racer>,
    var manager: Manager? = null
)
{
    override fun toString(): String {
        return title
    }
}