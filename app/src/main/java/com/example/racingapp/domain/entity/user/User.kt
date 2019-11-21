package com.example.racingapp.domain.entity.user

abstract class User{
    abstract val login: String
    abstract val password: String
    abstract val role: UserRole
}