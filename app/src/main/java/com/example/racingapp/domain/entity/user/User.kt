package com.example.racingapp.domain.entity.user

abstract class User(val login: String, val password: String){
    abstract val role: UserRole
}