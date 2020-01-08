package com.example.racingapp.domain.entity.user

import com.example.racingapp.domain.entity.Team

class Manager(
    login: String,
    password: String,
    var name: String,
    var secondName: String,
    var team: Team? = null,
    override val role: UserRole = UserRole.MANAGER
) : User(login, password) {

    override fun toString(): String {
        return "$secondName $name"
    }
}