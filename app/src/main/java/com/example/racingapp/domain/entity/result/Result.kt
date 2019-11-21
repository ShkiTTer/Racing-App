package com.example.racingapp.domain.entity.result

data class Result<T>(
    val member: T,
    val place: Int,
    val point: Int
)