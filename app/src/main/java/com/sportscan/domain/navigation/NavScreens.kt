package com.sportscan.domain.navigation

import kotlinx.serialization.Serializable

sealed class NavScreens {

    @Serializable
    data object LoginScreen : NavScreens()

    @Serializable
    data object SignUpScreen : NavScreens()

    @Serializable
    data object PersonalAccountScreen : NavScreens()
}