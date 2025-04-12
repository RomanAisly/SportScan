package com.sportscan.ui.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sportscan.data.repositories.AuthRepository
import com.sportscan.ui.events.SignUpEvents
import com.sportscan.ui.states.SignUpState
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch


class SignUpViewModel(private val authRepository: AuthRepository) :
    ViewModel() {

    private val _state = MutableStateFlow(SignUpState())
    val state: StateFlow<SignUpState> = _state.stateIn(
        scope = viewModelScope,
        started = SharingStarted.WhileSubscribed(5000),
        initialValue = SignUpState()
    )

    fun onEvent(event: SignUpEvents) {
        when (event) {
            is SignUpEvents.UpdateLogin -> _state.value = _state.value.copy(login = event.newLogin)
            is SignUpEvents.UpdatePassword -> _state.value =
                _state.value.copy(password = event.newPassword)

            is SignUpEvents.UpdateRepeatPassword -> _state.value =
                _state.value.copy(repeatPassword = event.newRepeatPassword)

            is SignUpEvents.UpdatePasswordVisibility -> _state.value =
                _state.value.copy(isPasswordVisible = !event.newPasswordVisibility)

            is SignUpEvents.UpdateChecked -> _state.value =
                _state.value.copy(checked = event.newChecked)

            is SignUpEvents.SignUp -> {
                viewModelScope.launch(Dispatchers.IO) {
                    val result = authRepository.signUpUser(
                        email = _state.value.login,
                        password = _state.value.password
                    )
                    _state.value = _state.value.copy(resultData = result)
                }
            }
        }

    }
}