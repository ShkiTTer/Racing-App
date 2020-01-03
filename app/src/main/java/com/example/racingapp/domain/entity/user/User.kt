package com.example.racingapp.domain.entity.user

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
abstract class User(
    var login: String = "",
    var password: String = "",
    @PrimaryKey(autoGenerate = true) val userId: Int = 0
) {
    abstract val role: UserRole
}