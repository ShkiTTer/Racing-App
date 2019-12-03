package com.example.racingapp.domain.entity.user

import com.example.racingapp.domain.entity.Team

class Manager(
    login: String,
    password: String,
    val name: String,
    val secondName: String,
    val team: Team,
    override val role: UserRole = UserRole.MANAGER
) : User(login, password)