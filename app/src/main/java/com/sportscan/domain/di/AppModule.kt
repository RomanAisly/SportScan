package com.sportscan.domain.di

import androidx.room.Room
import com.sportscan.data.local.UsersDB
import com.sportscan.data.repositories.AuthRepository
import com.sportscan.ui.viewmodels.LoginViewModel
import com.sportscan.ui.viewmodels.ProfileViewModel
import com.sportscan.ui.viewmodels.SignUpViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    single {
        Room.databaseBuilder(
            get(),
            UsersDB::class.java,
            "users_db"
        ).build()
    }
    single {
        get<UsersDB>().getUsersDao()
    }
    single {
        AuthRepository(get())
    }
    viewModel { LoginViewModel(get()) }
    viewModel { SignUpViewModel(get()) }
    viewModel { ProfileViewModel() }
}