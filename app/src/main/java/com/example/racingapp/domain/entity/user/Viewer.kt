package com.example.racingapp.domain.entity.user

class Viewer(
    login: String,
    password: String,
    override val role: UserRole = UserRole.VIEWER
) : User(login, password)