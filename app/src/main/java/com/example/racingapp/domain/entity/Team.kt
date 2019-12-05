package com.example.racingapp.domain.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.racingapp.domain.entity.user.Manager

@Entity
data class Team(
    val title: String,
    val country: String,
    val manager: Manager,
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0
) {
    override fun toString(): String {
        return title
    }
}