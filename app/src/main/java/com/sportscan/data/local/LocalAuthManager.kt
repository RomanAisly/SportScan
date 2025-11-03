package com.sportscan.data.local

import android.content.Context
import androidx.core.content.edit

class LocalAuthManager(context: Context) {
    private val sharedPreferences = context.getSharedPreferences("local_auth", Context.MODE_PRIVATE)

    fun rememberAuth(email: String, password: String) {
        sharedPreferences.edit(commit = true) {
            putString("email", email)
            putString("password", password)
        }
    }

    fun isLoggedIn(): Boolean {
        return sharedPreferences.contains("email") && sharedPreferences.contains("password")
    }

    fun signOut() {
        sharedPreferences.edit(commit = true) {
            remove("email")
            remove("password")
        }
    }
}