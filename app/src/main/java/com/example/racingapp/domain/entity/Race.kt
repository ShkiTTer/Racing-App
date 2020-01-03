package com.example.racingapp.domain.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.racingapp.domain.entity.result.RacerResult
import com.example.racingapp.domain.entity.result.Result
import com.example.racingapp.domain.entity.user.Racer

@Entity
data class Race(
    val title: String,
    val country: String,
    val track: Track,
    val cntLaps: Int,
    val result: RacerResult,
    @PrimaryKey(autoGenerate = true)
    val raceId: Int = 0
)