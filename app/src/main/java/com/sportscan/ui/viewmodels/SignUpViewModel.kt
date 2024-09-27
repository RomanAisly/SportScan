package com.sportscan.ui.viewmodels

import androidx.compose.ui.state.ToggleableState
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

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
        viewModelScope.launch {
            _login.value = login
        }
    }

    fun updatePassword(password: String) {
        viewModelScope.launch {
            _password.value = password
        }
    }

    fun updateRepeatPassword(repeatPassword: String) {
        viewModelScope.launch {
            _repeatPassword.value = repeatPassword
        }
    }

    fun updateChecked(checked: ToggleableState) {
        viewModelScope.launch {
            _checked.value = checked
        }
    }


}