package com.example.racingapp.domain.entity.result

import com.example.racingapp.domain.entity.Team

class TeamResult(subject: Team, place: Int = 0, points: Int = 0): Result<Team>(subject, place, points) {

    fun addPoints(points: Int) {
        mPoints += points
    }

    fun updatePlace(place: Int) {
        mPlace = place
    }
}