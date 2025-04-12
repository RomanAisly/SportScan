package com.sportscan.ui.events

sealed interface LoginEvents {
    data class UpdateLogin(val newLogin: String) : LoginEvents
    data class UpdatePassword(val newPassword: String) : LoginEvents
    data class UpdatePasswordVisibility(val newPasswordVisibility: Boolean) : LoginEvents
    data object LoginIn : LoginEvents
}