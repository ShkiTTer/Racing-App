package com.example.racingapp

import com.example.racingapp.domain.entity.Team
import com.example.racingapp.domain.entity.user.Racer
import com.example.racingapp.domain.entity.user.User

object AllData {
    val users = mutableListOf<User>()
    var currentUser: User? = null
    val teams = mutableListOf<Team>()
    val racers = mutableListOf<Racer>()
}