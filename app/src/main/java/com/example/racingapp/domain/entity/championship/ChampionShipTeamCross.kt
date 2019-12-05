package com.example.racingapp.domain.entity.championship

import androidx.room.Entity

@Entity(primaryKeys = ["championShipId", "teamId"])
data class ChampionShipTeamCross(
    val championShipId: Int,
    val teamId: Int
)