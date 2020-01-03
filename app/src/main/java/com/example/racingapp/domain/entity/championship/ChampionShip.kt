package com.example.racingapp.domain.entity.championship

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class ChampionShip(
    val title: String,
    val country: String,
    val type: ChampionShipType,
    val teamResultId: Int,
    val racerResultId: Int,
    @PrimaryKey(autoGenerate = true)
    val championShipId: Int
)