package com.example.racingapp.domain.entity.championship

import androidx.room.Entity
import androidx.room.ForeignKey
import com.example.racingapp.domain.entity.result.TeamResult

@Entity(
    primaryKeys = ["championShipId", "teamResultId"],
    foreignKeys = [
        ForeignKey(
            entity = ChampionShip::class,
            parentColumns = ["championShipId"],
            childColumns = ["championShipId"]
        ),
        ForeignKey(
            entity = TeamResult::class,
            parentColumns = ["resultId"],
            childColumns = ["teamResultId"]
        )]
)
data class ChampionShipTeamResultJoin(
    val championShipId: Int,
    val teamResultId: Int
)