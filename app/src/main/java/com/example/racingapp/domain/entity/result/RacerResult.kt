package com.example.racingapp.domain.entity.result

class RacerResult(
    title: String,
    place: Int,
    points: Int,
    val time: String
) : Result(title, place, points)