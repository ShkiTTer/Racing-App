package com.example.racingapp.domain.entity.championship

import androidx.room.Entity
import androidx.room.ForeignKey
import com.example.racingapp.domain.entity.result.RacerResult

@Entity(
    primaryKeys = ["championShipId", "racerResultId"],
    foreignKeys = [
        ForeignKey(
            entity = ChampionShip::class,
            parentColumns = ["championShipId"],
            childColumns = ["championShipId"]
        ),
        ForeignKey(
            entity = RacerResult::class,
            parentColumns = ["resultId"],
            childColumns = ["championShipId"]
        )]
)
data class ChampionShipRacerResultJoin(
    val championShipId: Int,
    val racerResultId: Int
)