package com.example.racingapp.domain.entity

data class Team(
    val title: String,
    val country: String
) {
    override fun toString(): String {
        return title
    }
}