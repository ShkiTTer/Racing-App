package com.example.racingapp.domain.entity

class Track(
    title: String,
    country: String,
    length: Int // In meters
) {
    private var mTitle = title
    private var mCountry = country
    private var mLength = length

    val title: String
        get() = mTitle

    val country: String
        get() = mCountry

    val length: Int
        get() = mLength

    fun update(title: String, country: String, length: Int) {
        mTitle = title
        mCountry = country
        mLength = length
    }

    override fun toString(): String {
        return "$title - $country"
    }
}