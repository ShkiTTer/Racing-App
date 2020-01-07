package com.example.racingapp.domain.entity

import com.example.racingapp.domain.entity.user.Racer
import com.example.racingapp.domain.entity.result.Result

class Race(
    var title: String,
    var track: Track,
    var cntLaps: Int
) {
    private val mRacerResults = mutableListOf<Result<Racer>>()
    private val mTeamResults = mutableListOf<Result<Team>>()

    val racerResults: List<Result<Racer>>
        get() = mRacerResults

    val teamResults: List<Result<Team>>
        get() = mTeamResults

    fun addRacerResult(racerResult: Result<Racer>) {
        mRacerResults.add(racerResult)
    }

    fun addTeamResult(teamResult: Result<Team>) {
        mTeamResults.add(teamResult)
    }
}