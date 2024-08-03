package com.sportscan.domain.navigation

import kotlinx.serialization.Serializable

sealed class NavScreens {

    @Serializable
    data object HomeScreen : NavScreens()

    @Serializable
    data object DetailsScreen : NavScreens()

    @Serializable
    data object SettingsScreen : NavScreens()
}