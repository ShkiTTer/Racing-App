package com.example.racingapp.domain.entity

abstract class User{
    abstract val login: String
    abstract val password: String
    abstract val role: UserRole
}