package com.sportscan.ui.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sportscan.data.repositories.AuthRepository
import com.sportscan.utils.ResultData
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(private val authRepository: AuthRepository) : ViewModel() {

    private val _login = MutableStateFlow("")
    val login = _login.asStateFlow()
    fun updateLogin(login: String) {
        _login.value = login
    }


    private val _password = MutableStateFlow("")
    val password = _password.asStateFlow()
    fun updatePassword(password: String) {
        _password.value = password
    }


    private val _isPasswordVisible = MutableStateFlow(false)
    val isPasswordVisible = _isPasswordVisible.asStateFlow()
    fun togglePasswordVisibility() {
        _isPasswordVisible.value = !_isPasswordVisible.value
    }

    private val _resultData = MutableStateFlow<ResultData?>(null)
    val resultData = _resultData.asStateFlow()

    suspend fun login() {
        viewModelScope.launch(Dispatchers.IO) {
            _resultData.value = authRepository.authUser(email = _login.value, password = _password.value)
        }
    }

}