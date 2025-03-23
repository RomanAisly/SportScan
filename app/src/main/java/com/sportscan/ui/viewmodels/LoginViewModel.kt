package com.sportscan.ui.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sportscan.data.repositories.AuthRepository
import com.sportscan.utils.ResultData
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted.Companion.WhileSubscribed
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject

data class LoginState(
    val login: String = "",
    val password: String = "",
    val isPasswordVisible: Boolean = false,
    val resultData: ResultData? = null
)

@HiltViewModel
class LoginViewModel @Inject constructor(private val authRepository: AuthRepository) : ViewModel() {

    private val _state = MutableStateFlow(LoginState())
    val state: StateFlow<LoginState> = _state.stateIn(
        scope = viewModelScope,
        started = WhileSubscribed(5000),
        initialValue = LoginState()
    )

    fun updateLogin(newLogin: String) {
        _state.value = _state.value.copy(login = newLogin)
    }
    fun updatePassword(newPassword: String) {
        _state.value = _state.value.copy(password = newPassword)
    }
    fun updatePasswordVisibility(newPasswordVisibility: Boolean) {
        _state.value = _state.value.copy(isPasswordVisible = !newPasswordVisibility)
    }


    fun login() {
        viewModelScope.launch(Dispatchers.IO) {
            val result = authRepository.authUser(email = _state.value.login, password = _state.value.password)
            _state.value = _state.value.copy(resultData = result)
        }
    }

}