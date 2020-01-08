package com.example.racingapp.domain.entity.request

import com.example.racingapp.domain.entity.Team
import com.example.racingapp.domain.entity.tournament.Tournament

class Request(
    val team: Team,
    val tournament: Tournament,
    state: RequestState = RequestState.FILED
) {
    private var mState = state

    val state: RequestState
        get() = mState

    fun cancel() {
        mState = RequestState.REJECTED
    }

    fun appove() {
        mState = RequestState.APPROVED

        tournament.addTeam(team)
    }
}