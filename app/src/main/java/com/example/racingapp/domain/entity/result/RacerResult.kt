package com.example.racingapp.domain.entity.result

import androidx.room.Entity

@Entity
class RacerResult(
    title: String,
    place: Int,
    points: Int,
    val time: Int
): Result(title, place, points)