package com.sportscan.ui.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sportscan.data.repositories.AuthRepository
import com.sportscan.ui.events.LoginEvents
import com.sportscan.ui.states.LoginState
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted.Companion.WhileSubscribed
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch


class LoginViewModel(private val authRepository: AuthRepository) : ViewModel() {

    private val _state = MutableStateFlow(LoginState())
    val state: StateFlow<LoginState> = _state.stateIn(
        scope = viewModelScope,
        started = WhileSubscribed(5000),
        initialValue = LoginState()
    )

    fun onEvent(event: LoginEvents) {
        when (event) {
            is LoginEvents.UpdateLogin -> _state.value = _state.value.copy(login = event.newLogin)
            is LoginEvents.UpdatePassword -> _state.value =
                _state.value.copy(password = event.newPassword)

            is LoginEvents.UpdatePasswordVisibility -> _state.value =
                _state.value.copy(isPasswordVisible = !event.newPasswordVisibility)

            is LoginEvents.LoginIn -> {
                viewModelScope.launch(Dispatchers.IO) {
                    val result = authRepository.authUser(
                        email = _state.value.login,
                        password = _state.value.password
                    )
                    _state.value = _state.value.copy(resultData = result)
                }
            }
        }
    }
}