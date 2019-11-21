package com.example.racingapp.domain.entity.user

data class Manager(
    override val login: String,
    override val password: String,
    val name: String,
    val secondName: String,
    override val role: UserRole = UserRole.MANAGER
): User()