package com.example.racingapp.presentation.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.racingapp.domain.entity.user.User

class MainViewModel : ViewModel() {
    val user = MutableLiveData<User>()
}