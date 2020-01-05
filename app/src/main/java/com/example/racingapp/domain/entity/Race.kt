package com.example.racingapp.domain.entity

import com.example.racingapp.domain.entity.result.RacerResult
import com.example.racingapp.domain.entity.result.TeamResult

class Race(
    var title: String,
    var track: Track,
    var cntLaps: Int
) {
    private val mRacerResults = mutableListOf<RacerResult>()
    private val mTeamResults = mutableListOf<TeamResult>()

    val racerResults: List<RacerResult>
        get() = mRacerResults

    val teamResults: List<TeamResult>
        get() = mTeamResults

    fun addRacerResult(racerResult: RacerResult) {
        mRacerResults.add(racerResult)
    }

    fun addTeamResult(teamResult: TeamResult) {
        mTeamResults.add(teamResult)
    }
}