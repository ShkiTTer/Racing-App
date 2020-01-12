package com.example.racingapp.domain.entity.tournament

import com.example.racingapp.domain.entity.Race
import com.example.racingapp.domain.entity.Team
import com.example.racingapp.domain.entity.result.RacerResult
import com.example.racingapp.domain.entity.result.TeamResult
import com.example.racingapp.domain.entity.user.Racer

class Tournament(
    title: String,
    type: TournamentType,
    state: TournamentState
) {
    private val mTeams = mutableListOf<Team>()
    private val mRaces = mutableListOf<Race>()

    private var mTitle = title
    private var mType = type
    private var mState = state

    val title: String
        get() = mTitle
    val type: TournamentType
        get() = mType
    val state: TournamentState
        get() = mState
    val teams: List<Team>
        get() = mTeams
    val races: List<Race>
        get() = mRaces
    val racerResults: List<RacerResult>
        get() {
            val tempResult = mutableMapOf<Racer, Int>()
            val result = mutableListOf<RacerResult>()

            races.forEach {
                it.racerResults.forEach { r ->
                    val currentResult = tempResult[r.subject]

                    if (currentResult == null) tempResult[r.subject] = r.points
                    else tempResult[r.subject] = r.points + currentResult
                }
            }

            tempResult.toList().sortedByDescending { it.second }.forEachIndexed { index, pair ->
                result.add(RacerResult(pair.first, index + 1, pair.second))
            }

            return result
        }
    val teamResults: List<TeamResult>
        get() {
            val tempResult = mutableMapOf<Team, Int>()
            val result = mutableListOf<TeamResult>()

            races.forEach {
                it.teamResults.forEach { r ->
                    val currentResult = tempResult[r.subject]

                    if (currentResult == null) tempResult[r.subject] = r.points
                    else tempResult[r.subject] = r.points + currentResult
                }
            }

            tempResult.toList().sortedByDescending { it.second }.forEachIndexed { index, pair ->
                result.add(TeamResult(pair.first, index + 1, pair.second))
            }

            return result
        }

    fun update(title: String, type: TournamentType, state: TournamentState) {
        mTitle = title
        mType = type
        mState = state
    }

    fun getRacers(): List<Racer> {
        val racers = mutableListOf<Racer>()

        teams.forEach {
            racers.addAll(it.racers)
        }

        return racers
    }

    fun addRace(race: Race) {
        mRaces.add(race)
    }

    fun addTeam(team: Team) {
        mTeams.add(team)
    }
}