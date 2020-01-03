package com.example.racingapp.domain.entity.result

import androidx.room.Entity

@Entity
class TeamResult(
    title: String,
    place: Int,
    points: Int
) : Result(title, place, points)