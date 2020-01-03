package com.example.racingapp.domain.entity.championship

import androidx.room.Entity
import androidx.room.ForeignKey
import com.example.racingapp.domain.entity.Team

@Entity(
    primaryKeys = ["championShipId", "teamId"],
    foreignKeys = [
        ForeignKey(entity = Team::class, parentColumns = ["teamId"], childColumns = ["teamId"]),
        ForeignKey(
            entity = ChampionShip::class,
            parentColumns = ["championShipId"],
            childColumns = ["championShipId"]
        )]
)
data class ChampionShipTeamCross(
    val championShipId: Int,
    val teamId: Int
)