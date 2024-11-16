package com.sportscan.domain.di

import com.sportscan.data.local.dao.UsersDao
import com.sportscan.data.repositories.AuthRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    @Singleton
    fun provideAuthRepository(usersDao: UsersDao): AuthRepository {
        return AuthRepository(usersDao)
    }

}