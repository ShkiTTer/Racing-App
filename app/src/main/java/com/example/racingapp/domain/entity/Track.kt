package com.example.racingapp.domain.entity

data class Track(
    var title: String,
    var country: String,
    var length: Int // In meters
) {
    override fun toString(): String {
        return "$title - $country"
    }
}