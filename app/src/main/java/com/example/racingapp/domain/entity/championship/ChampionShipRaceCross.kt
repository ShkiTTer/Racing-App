package com.example.racingapp.domain.entity.championship

import androidx.room.Entity

@Entity(primaryKeys = ["championShipId", "raceId"])
data class ChampionShipRaceCross(
    val championShipId: Int,
    val raceId: Int
)