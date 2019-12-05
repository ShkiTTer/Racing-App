package com.example.racingapp.presentation.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.racingapp.domain.entity.user.UserRole

class LoginViewModel: ViewModel() {
    val userRoles = UserRole.values().take(3)
    val userRole = MutableLiveData<UserRole>(UserRole.RACER)
}