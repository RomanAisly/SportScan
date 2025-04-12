package com.sportscan.ui.states

import androidx.compose.ui.state.ToggleableState
import com.sportscan.utils.ResultData

data class SignUpState(
    val isLoading: Boolean = false,
    val login: String = "",
    val password: String = "",
    val repeatPassword: String = "",
    val checked: ToggleableState = ToggleableState.Off,
    val isPasswordVisible: Boolean = false,
    val resultData: ResultData? = null
)
