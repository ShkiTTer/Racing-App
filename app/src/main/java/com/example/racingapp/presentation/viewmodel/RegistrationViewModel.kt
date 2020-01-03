package com.example.racingapp.presentation.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.racingapp.domain.entity.user.UserRole

class RegistrationViewModel: ViewModel() {
    var userRole = MutableLiveData<UserRole>(UserRole.RACER)
}