package com.example.racingapp.domain.entity.user

import java.util.*

class Racer(
    login: String,
    password: String,
    val name: String,
    val secondName: String,
    val country: String,
    val birthday: Date,
    val rating: Double,
    val cntRace: Int,
    val cntWin: Int,
    val cntPodium: Int,
    val teamRole: TeamRole,
    override val role: UserRole = UserRole.RACER
): User(login, password) {
    override fun toString(): String {
        return "${this.name} ${this.secondName}"
    }
}