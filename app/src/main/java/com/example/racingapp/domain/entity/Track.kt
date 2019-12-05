package com.example.racingapp.domain.entity

import androidx.room.Entity

@Entity
data class Track(
    val title: String,
    val country: String,
    val length: Int // In meters
)