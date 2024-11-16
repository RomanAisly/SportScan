package com.sportscan.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.sportscan.data.local.dao.UsersDao
import com.sportscan.data.local.entitys.Users

@Database(entities = [Users::class], version = 1, exportSchema = false)
abstract class UsersDB: RoomDatabase() {
    abstract fun getUsersDao(): UsersDao
}