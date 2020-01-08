package com.example.racingapp.domain.entity

import com.example.racingapp.domain.entity.user.Racer
import com.example.racingapp.domain.entity.result.Result

class Race(
    title: String,
    track: Track,
    cntLaps: Int
) {
    private val mRacerResults = mutableListOf<Result<Racer>>()
    private val mTeamResults = mutableListOf<Result<Team>>()

    private var mTitle = title
    private var mTrack = track
    private var mCntLaps = cntLaps

    val title: String
        get() = mTitle
    val track: Track
        get() = mTrack
    val cntLaps: Int
        get() = mCntLaps
    val racerResults: List<Result<Racer>>
        get() = mRacerResults
    val teamResults: List<Result<Team>>
        get() = mTeamResults

    fun update(title: String, track: Track, cntLaps: Int) {
        mTitle = title
        mTrack = track
        mCntLaps = cntLaps
    }

    fun addRacerResult(racerResult: Result<Racer>) {
        mRacerResults.add(racerResult)
    }

    fun addTeamResult(teamResult: Result<Team>) {
        mTeamResults.add(teamResult)
    }
}