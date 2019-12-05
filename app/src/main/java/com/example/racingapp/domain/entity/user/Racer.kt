package com.example.racingapp.domain.entity.user

import androidx.room.Entity
import java.util.*

@Entity
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
    val teamId: Int,
    override val role: UserRole = UserRole.RACER
): User(login, password) {
    override fun toString(): String {
        return "${this.name} ${this.secondName}"
    }
}