package com.example.racingapp.domain.entity.user

import com.example.racingapp.domain.entity.user.User
import com.example.racingapp.domain.entity.user.UserRole

data class Viewer(
    override val login: String,
    override val password: String,
    override val role: UserRole = UserRole.VIEWER
): User()