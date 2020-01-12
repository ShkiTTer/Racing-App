package com.example.racingapp.domain.entity.user

import com.example.racingapp.domain.entity.request.Request

class Administrator(
    login: String = "",
    password: String = "",
    override val role: UserRole = UserRole.ADMINISTRATOR
): User(login, password) {
    fun aproveRequest(request: Request) {
        request.approve()
    }

    fun cancelRequest(request: Request) {
        request.cancel()
    }
}