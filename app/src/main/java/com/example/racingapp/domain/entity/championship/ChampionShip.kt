package com.example.racingapp.domain.entity.championship

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.racingapp.domain.entity.Team
import com.example.racingapp.domain.entity.result.Result
import com.example.racingapp.domain.entity.user.Racer

@Entity
data class ChampionShip(
    val title: String,
    val country: String,
    val type: ChampionShipType,
    val teamResult: Result<Team>,
    val racerResult: Result<Racer>,
    @PrimaryKey(autoGenerate = true)
    val championShipId: Int
)