package com.example.racingapp.domain.entity.result

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
abstract class Result(
    val title: String,
    val place: Int,
    val points: Int,
    @PrimaryKey(autoGenerate = true)
    val resultId: Int = 0
)