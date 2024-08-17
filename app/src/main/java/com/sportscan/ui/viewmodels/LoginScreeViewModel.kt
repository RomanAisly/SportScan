package com.sportscan.ui.viewmodels

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow


class LoginScreeViewModel : ViewModel() {

    private val _login = MutableStateFlow("")
    val login = _login.asStateFlow()

    private val _password = MutableStateFlow("")
    val password = _password.asStateFlow()

    fun updateLogin(login: String) {
        _login.value = login
    }

    fun updatePassword(password: String) {
        _password.value = password
    }

}