package com.example.racingapp.domain.entity.user

import androidx.room.Entity
import androidx.room.PrimaryKey

abstract class User(
    val login: String,
    val password: String
) {
    abstract val role: UserRole
}