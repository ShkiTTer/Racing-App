package com.example.racingapp.domain.entity.result

abstract class Result<T>(
    val subject: T,
    place: Int,
    points: Int
) {
    protected var mPoints = points
    protected var mPlace = place

    val points: Int
        get() = mPoints
    val place: Int
        get() = mPlace
}