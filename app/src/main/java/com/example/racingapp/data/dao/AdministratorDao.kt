package com.example.racingapp.data.dao

import androidx.room.Query
import com.example.racingapp.domain.entity.user.Administrator

interface AdministratorDao: BaseDao<Administrator> {
    //@Query("Select * From")
    fun getUserByLoginAndPassword(login: String, password: String)
}