package com.sportscan.ui.viewmodels

import androidx.compose.ui.state.ToggleableState
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sportscan.data.repositories.AuthRepository
import com.sportscan.utils.ResultData
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

data class SignUpState(
    val isLoading: Boolean = false,
    val login: String = "",
    val password: String = "",
    val repeatPassword: String = "",
    val checked: ToggleableState = ToggleableState.Off,
    val isPasswordVisible: Boolean = false,
    val resultData: ResultData? = null
)

class SignUpViewModel(private val authRepository: AuthRepository) :
    ViewModel() {

    private val _state = MutableStateFlow(SignUpState())
    val state: StateFlow<SignUpState> = _state.stateIn(
        scope = viewModelScope,
        started = SharingStarted.WhileSubscribed(5000),
        initialValue = SignUpState()
    )

    fun updateLogin(newLogin: String) {
        _state.value = _state.value.copy(login = newLogin)
    }

    fun updatePassword(newPassword: String) {
        _state.value = _state.value.copy(password = newPassword)
    }

    fun updateRepeatPassword(newRepeatPassword: String) {
        _state.value = _state.value.copy(repeatPassword = newRepeatPassword)
    }

    fun updateChecked(newChecked: ToggleableState) {
        _state.value = _state.value.copy(checked = newChecked)
    }

    fun updatePasswordVisibility(newPasswordVisibility: Boolean) {
        _state.value = _state.value.copy(isPasswordVisible = !newPasswordVisibility)
    }

    fun signUp() {
        viewModelScope.launch(Dispatchers.IO) {
            val result = authRepository.signUpUser(
                email = _state.value.login,
                password = _state.value.password
            )
            _state.value = _state.value.copy(resultData = result)
        }
    }
}