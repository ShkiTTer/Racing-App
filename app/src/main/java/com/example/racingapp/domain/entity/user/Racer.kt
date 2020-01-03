package com.example.racingapp.domain.entity.user

import androidx.room.Entity
import com.example.racingapp.domain.entity.Team
import java.util.*

@Entity
class Racer(
    login: String = "",
    password: String = "",
    var name: String = "",
    var secondName: String = "",
    var country: String = "",
    var birthday: Date? = null,
    var rating: Double = .0,
    var cntRace: Int = 0,
    var cntWin: Int = 0,
    var cntPodium: Int = 0,
    var teamRole: TeamRole = TeamRole.FIRST,
    var team: Team,
    override val role: UserRole = UserRole.RACER
): User(login, password) {
    override fun toString(): String {
        return "${this.name} ${this.secondName}"
    }
}