package com.example.racingapp.domain.entity.user

enum class UserRole(private val roleTitle: String) {
    RACER("Гонщик"),
    MANAGER("Менеджер"),
    ADMINISTRATOR("Администратор"),
    VIEWER("Зритель");

    override fun toString(): String {
        return this.roleTitle
    }
}