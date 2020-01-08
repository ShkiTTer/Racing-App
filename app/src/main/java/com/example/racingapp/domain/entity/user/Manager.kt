package com.example.racingapp.domain.entity.user

import com.example.racingapp.domain.entity.Team
import com.example.racingapp.domain.entity.request.Request
import com.example.racingapp.domain.entity.tournament.Tournament

class Manager(
    login: String,
    password: String,
    name: String,
    secondName: String,
    team: Team? = null,
    override val role: UserRole = UserRole.MANAGER
) : User(login, password) {

    private var mName = name
    private var mSecondName = secondName
    private var mTeam = team

    val name: String
        get() = mName
    val secondName: String
        get() = mSecondName
    val team: Team?
        get() = mTeam

    fun setTeam(team: Team?) {
        mTeam = team
    }

    fun createRequest(tournament: Tournament) {
        val request = Request(team!!, tournament)
        team?.addRequest(request)
    }

    override fun toString(): String {
        return "$secondName $name"
    }
}