package com.example.racingapp.domain.entity.request

import androidx.room.Entity

@Entity
data class Request(
    val teamId: Int,
    val championShipId: Int,
    val state: RequestState
)