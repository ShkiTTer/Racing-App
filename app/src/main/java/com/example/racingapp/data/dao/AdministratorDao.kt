package com.example.racingapp.data.dao

import androidx.room.Dao
import androidx.room.Query
import com.example.racingapp.domain.entity.user.Administrator

@Dao
interface AdministratorDao : BaseDao<Administrator> {
    @Query("Select * From Administrator")
    fun getUserByLoginAndPassword(login: String, password: String): Administrator
}