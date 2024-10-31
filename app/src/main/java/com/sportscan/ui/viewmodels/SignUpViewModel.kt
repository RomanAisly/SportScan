package com.sportscan.ui.viewmodels

import androidx.compose.ui.state.ToggleableState
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow


class SignUpViewModel: ViewModel() {

    private val _login = MutableStateFlow("")
    val login = _login.asStateFlow()
    fun updateLogin(login: String) { _login.value = login }


    private val _password = MutableStateFlow("")
    val password = _password.asStateFlow()
    fun updatePassword(password: String) { _password.value = password }


    private val _repeatPassword = MutableStateFlow("")
    val repeatPassword = _repeatPassword.asStateFlow()
    fun updateRepeatPassword(repeatPassword: String) { _repeatPassword.value = repeatPassword }


    private val _checked = MutableStateFlow(ToggleableState.Off)
    val checked = _checked.asStateFlow()
    fun updateChecked(checked: ToggleableState) { _checked.value = checked }


    private val _isPasswordVisible = MutableStateFlow(false)
    val isPasswordVisible = _isPasswordVisible.asStateFlow()
    fun togglePasswordVisibility() { _isPasswordVisible.value = !_isPasswordVisible.value }
}