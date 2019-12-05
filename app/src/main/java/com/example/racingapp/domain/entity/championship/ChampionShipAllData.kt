package com.example.racingapp.domain.entity.championship

import androidx.room.Embedded
import androidx.room.Junction
import androidx.room.Relation
import com.example.racingapp.domain.entity.Race
import com.example.racingapp.domain.entity.Team

data class ChampionShipAllData(
    @Embedded
    val championShip: ChampionShip,
    @Relation(
        parentColumn = "championShipId",
        entityColumn = "teamId",
        associateBy = Junction(ChampionShipTeamCross::class)
    )
    val teams: List<Team>,
    @Relation(
        parentColumn = "championShipId",
        entityColumn = "raceId",
        associateBy = Junction(ChampionShipRaceCross::class)
    )
    val races: List<Race>
)