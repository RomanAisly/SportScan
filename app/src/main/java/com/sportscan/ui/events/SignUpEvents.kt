package com.sportscan.ui.events

import androidx.compose.ui.state.ToggleableState

sealed interface SignUpEvents {
    data class UpdateLogin(val newLogin: String) : SignUpEvents
    data class UpdatePassword(val newPassword: String) : SignUpEvents
    data class UpdateRepeatPassword(val newRepeatPassword: String) : SignUpEvents
    data class UpdatePasswordVisibility(val newPasswordVisibility: Boolean) : SignUpEvents
    data class UpdateChecked(val newChecked: ToggleableState) : SignUpEvents
    data object SignUp : SignUpEvents
}