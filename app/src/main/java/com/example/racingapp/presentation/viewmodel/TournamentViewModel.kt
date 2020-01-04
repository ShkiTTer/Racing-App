package com.example.racingapp.presentation.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.racingapp.domain.entity.tournament.Tournament
import com.example.racingapp.domain.entity.user.User

class TournamentViewModel: ViewModel() {
    var user: User? = null
    val tournament = MutableLiveData<Tournament>()
}