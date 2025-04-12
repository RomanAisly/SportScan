package com.sportscan.ui.states

import com.sportscan.utils.ResultData

data class LoginState(
    val isLoading: Boolean = false,
    val login: String = "",
    val password: String = "",
    val isPasswordVisible: Boolean = false,
    val resultData: ResultData? = null
)
