package com.example.racingapp.domain.entity

import com.example.racingapp.domain.entity.request.Request
import com.example.racingapp.domain.entity.user.Manager
import com.example.racingapp.domain.entity.user.Racer

class Team(
    title: String,
    country: String,
    racers: List<Racer>,
    manager: Manager
) {
    private var mTitle = title
    private var mCountry = country
    private val mRacers: MutableList<Racer> = racers.toMutableList()
    private var mManager = manager
    private val mRequests = mutableListOf<Request>()

    val title: String
        get() = mTitle
    val country: String
        get() = mCountry
    val racers: List<Racer>
        get() = mRacers
    val manager: Manager
        get() = mManager
    val requests: List<Request>
        get() = mRequests

    fun update(title: String, country: String, racers: List<Racer>, manager: Manager) {
        mTitle = title
        mCountry = country
        mManager = manager
        mRacers.clear()
        mRacers.addAll(racers)
    }

    fun addRequest(request: Request) {
        mRequests.add(request)
    }

    override fun toString(): String {
        return title
    }
}