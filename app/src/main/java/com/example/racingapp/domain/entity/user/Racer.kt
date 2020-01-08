package com.example.racingapp.domain.entity.user

import com.example.racingapp.domain.entity.Team
import java.util.*

class Racer(
    login: String,
    password: String,
    name: String,
    secondName: String,
    country: String,
    birthday: Date,
    cntRace: Int = 0,
    cntWin: Int = 0,
    team: Team? = null,
    teamRole: TeamRole = TeamRole.FIRST,
    override val role: UserRole = UserRole.RACER
) : User(login, password) {

    private var mName = name
    private var mSecondName = secondName
    private var mCountry = country
    private var mBirthday = birthday
    private var mCntRace = cntRace
    private var mCntWin = cntWin
    private var mTeam = team
    private var mTeamRole = teamRole

    val name: String
        get() = mName
    val secondName: String
        get() = mSecondName
    val country: String
        get() = mCountry
    val birthday: Date
        get() = mBirthday
    val cntRace: Int
        get() = mCntRace
    val cntWin: Int
        get() = mCntWin
    val team: Team?
        get() = mTeam
    val teamRole: TeamRole
        get() = mTeamRole

    fun updateTeamRole(teamRole: TeamRole) {
        mTeamRole = teamRole
    }

    fun setTeam(team: Team?) {
        mTeam = team
    }

    fun increaseRaceCount() {
        mCntRace++
    }

    fun increaseWinCount() {
        mCntWin++
    }

    override fun toString(): String {
        return "${this.name} ${this.secondName}"
    }
}