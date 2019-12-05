package com.example.racingapp.domain.entity.user

class Manager(
    login: String,
    password: String,
    val name: String,
    val secondName: String,
    val teamId: Int,
    override val role: UserRole = UserRole.MANAGER
) : User(login, password)