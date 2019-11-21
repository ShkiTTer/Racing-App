package com.example.racingapp.domain.entity.user

import com.example.racingapp.domain.entity.Team

data class Manager(
    override val login: String,
    override val password: String,
    val name: String,
    val secondName: String,
    val team: Team,
    override val role: UserRole = UserRole.MANAGER
): User()