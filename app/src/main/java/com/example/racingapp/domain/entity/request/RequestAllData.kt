package com.example.racingapp.domain.entity.request

import androidx.room.Embedded
import androidx.room.Relation
import com.example.racingapp.domain.entity.Team
import com.example.racingapp.domain.entity.championship.ChampionShip

data class RequestAllData(
    @Embedded
    val request: Request,
    @Relation(parentColumn = "teamId", entityColumn = "teamId", entity = Team::class)
    val team: Team,
    @Relation(
        parentColumn = "championShipId",
        entityColumn = "championShipId",
        entity = ChampionShip::class
    )
    val championShip: ChampionShip
)