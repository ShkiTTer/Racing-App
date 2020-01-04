package com.example.racingapp.domain.entity

import androidx.annotation.DrawableRes

data class Track(
    val title: String,
    val country: String,
    val length: Int, // In meters
    @DrawableRes val scheme: Int
)