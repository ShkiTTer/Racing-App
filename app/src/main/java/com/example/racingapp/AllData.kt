package com.example.racingapp

import com.example.racingapp.domain.entity.Race
import com.example.racingapp.domain.entity.Team
import com.example.racingapp.domain.entity.Track
import com.example.racingapp.domain.entity.tournament.Tournament
import com.example.racingapp.domain.entity.user.Racer
import com.example.racingapp.domain.entity.user.User

object AllData {
    val users = mutableListOf<User>()
    var currentUser: User? = null
    val teams = mutableListOf<Team>()
    var currentTeam: Team? = null
    val racers = mutableListOf<Racer>()
    var currentRace: Race? = null
    val tournaments = mutableListOf<Tournament>()
    var currentTournament: Tournament? = null
    val tracks = mutableListOf<Track>()
    var currentTrack: Track? = null

    var racerResult = true
}