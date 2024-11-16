package com.sportscan.data.local.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Query
import androidx.room.Upsert
import com.sportscan.data.local.entitys.Users

@Dao
interface UsersDao {

    @Upsert
    suspend fun upsertUser(users: Users)

    @Delete
    suspend fun deleteUser(users: Users)

    @Query("SELECT * FROM users WHERE email = :email")
    suspend fun getUserByEmail(email: String): Users?

    @Query("SELECT * FROM users WHERE email = :email AND password = :password")
    fun loginUser(email: String, password: String): Users?
}