package com.example.racingapp.domain.entity

import com.example.racingapp.domain.entity.result.RacerResult
import com.example.racingapp.domain.entity.result.TeamResult

class Race(
    title: String,
    track: Track,
    cntLaps: Int
) {
    private val mRacerResults = mutableListOf<RacerResult>()

    private var mTitle = title
    private var mTrack = track
    private var mCntLaps = cntLaps

    val title: String
        get() = mTitle
    val track: Track
        get() = mTrack
    val cntLaps: Int
        get() = mCntLaps
    val racerResults: List<RacerResult>
        get() = mRacerResults.sortedBy { it.place }
    val teamResults: List<TeamResult>
        get() {
            val results = mutableListOf<TeamResult>()

            racerResults.forEach {
                val result = results.find { r -> r.subject == it.subject.team }
                if (result == null)
                    results.add(TeamResult(it.subject.team!!, 0, it.points))
                else result.addPoints(it.points)
            }

            results.sortedByDescending { it.points }.forEachIndexed { index, teamResult ->
                teamResult.updatePlace(index + 1)
            }

            return results
        }

    fun update(title: String, track: Track, cntLaps: Int) {
        mTitle = title
        mTrack = track
        mCntLaps = cntLaps
    }

    fun addRacerResult(racerResult: RacerResult) {
        mRacerResults.add(racerResult)
    }
}