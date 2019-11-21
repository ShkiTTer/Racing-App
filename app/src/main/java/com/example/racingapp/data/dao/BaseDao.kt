package com.example.racingapp.data.dao

import androidx.room.*

@Dao
interface BaseDao<T> {
    @Insert
    fun insert(vararg data: T)

    @Update
    fun update(vararg data: T)

    @Delete
    fun delete(vararg data: T)
}