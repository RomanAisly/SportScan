package com.sportscan.ui.viewmodels

import androidx.compose.ui.state.ToggleableState
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class SignUpViewModel : ViewModel() {

    private val _login = MutableStateFlow("")
    val login = _login.asStateFlow()

    private val _password = MutableStateFlow("")
    val password = _password.asStateFlow()

    private val _repeatPassword = MutableStateFlow("")
    val repeatPassword = _repeatPassword.asStateFlow()

    private val _checked = MutableStateFlow(ToggleableState.Off)
    val checked = _checked.asStateFlow()


    fun updateLogin(login: String) {
        _login.value = login
    }

    fun updatePassword(password: String) {
        _password.value = password
    }

    fun updateRepeatPassword(repeatPassword: String) {
        _repeatPassword.value = repeatPassword
    }

    fun updateChecked(checked: ToggleableState) {
        _checked.value = checked
    }


}