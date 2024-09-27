package com.sportscan.ui.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch


class LoginViewModel : ViewModel() {

    private val _login = MutableStateFlow("")
    val login = _login.asStateFlow()

    private val _password = MutableStateFlow("")
    val password = _password.asStateFlow()



    fun updateLogin(login: String) {
        viewModelScope.launch {
            _login.value = login
        }
    }

    fun updatePassword(password: String) {
        viewModelScope.launch {
            _password.value = password
        }
    }
}