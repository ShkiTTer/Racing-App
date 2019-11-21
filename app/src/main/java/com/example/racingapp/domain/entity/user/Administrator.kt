package com.example.racingapp.domain.entity.user

data class Administrator(
    override val login: String,
    override val password: String,
    override val role: UserRole = UserRole.ADMINISTRATOR
): User()