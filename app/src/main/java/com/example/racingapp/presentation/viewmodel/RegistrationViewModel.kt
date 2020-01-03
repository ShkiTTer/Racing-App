package com.example.racingapp.presentation.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.racingapp.AllData
import com.example.racingapp.domain.entity.Team
import com.example.racingapp.domain.entity.user.*

class RegistrationViewModel: ViewModel() {
    var userRole = MutableLiveData<UserRole>(UserRole.RACER)

    fun createAdmin(login: String, password: String) {
        AllData.users.add(Administrator(login, password))
    }

    fun createRacer(login: String, password: String, team: Team) {
        AllData.users.add(Racer(login = login, password = password, team = team))
    }

    fun createManager(login: String, password: String, team: Team) {
        AllData.users.add(Manager(login = login, password = password, team = team))
    }
}