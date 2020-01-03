package com.example.racingapp.domain.entity.championship

import androidx.room.Entity
import androidx.room.ForeignKey
import com.example.racingapp.domain.entity.Race

@Entity(
    primaryKeys = ["championShipId", "raceId"],
    foreignKeys = [
        ForeignKey(entity = Race::class, parentColumns = ["raceId"], childColumns = ["raceId"]),
        ForeignKey(
            entity = ChampionShip::class,
            parentColumns = ["championShipId"],
            childColumns = ["championShipId"]
        )]
)
data class ChampionShipRaceCross(
    val championShipId: Int,
    val raceId: Int
)