package com.example.racingapp.domain.entity.user

import androidx.room.Entity

@Entity
class Administrator(
    login: String = "",
    password: String = "",
    override val role: UserRole = UserRole.ADMINISTRATOR
): User(login, password)