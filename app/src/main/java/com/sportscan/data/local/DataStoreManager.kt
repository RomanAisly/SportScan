package com.sportscan.data.local

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

private val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = "users")

class DataStoreManager(val context: Context) {

    suspend fun saveToken(email: String, password: String) {
        context.dataStore.edit {
            it[EMAIL_TOKEN_KEY] = email
            it[PASSWORD_TOKEN_KEY] = password
        }
    }

    fun isLoggedIn(): Flow<Boolean> {
        return context.dataStore.data.map { preferences ->
           preferences.contains(EMAIL_TOKEN_KEY) && preferences.contains(PASSWORD_TOKEN_KEY)
        }
    }


    suspend fun logout() {
        context.dataStore.edit {
            it.clear()
        }
    }


    companion object {
        private val EMAIL_TOKEN_KEY = stringPreferencesKey("email")
        private val PASSWORD_TOKEN_KEY = stringPreferencesKey("password")
    }
}