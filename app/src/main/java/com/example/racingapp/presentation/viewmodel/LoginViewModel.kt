package com.example.racingapp.presentation.viewmodel

import androidx.lifecycle.ViewModel
import com.example.racingapp.domain.entity.user.UserRole

class LoginViewModel: ViewModel() {
    val userRoles = UserRole.values().take(3)
}