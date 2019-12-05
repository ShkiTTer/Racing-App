package com.example.racingapp.domain.entity.user

import androidx.room.Embedded
import androidx.room.Relation
import com.example.racingapp.domain.entity.Team

data class ManagerAndTeam(
    @Embedded
    val manager: Manager,
    @Relation(parentColumn = "teamId", entityColumn = "teamId", entity = Team::class)
    val team: Team
)