package com.example.racingapp.domain.entity

data class Viewer(
    override val login: String,
    override val password: String,
    override val role: UserRole = UserRole.VIEWER
): User()