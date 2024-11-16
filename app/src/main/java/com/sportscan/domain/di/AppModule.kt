package com.sportscan.domain.di

import android.content.Context
import androidx.room.Room
import com.sportscan.data.local.UsersDB
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideUsersDatabase(@ApplicationContext context: Context): UsersDB {
        return Room.databaseBuilder(
            context,
            UsersDB::class.java,
            "users_db"
        ).build()
    }

    @Provides
    @Singleton
    fun provideUsersDao(usersDB: UsersDB) = usersDB.getUsersDao()

}