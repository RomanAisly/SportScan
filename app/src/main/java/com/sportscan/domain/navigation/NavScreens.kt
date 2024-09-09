package com.sportscan.domain.navigation

import kotlinx.serialization.Serializable

sealed class NavScreens {

//    @Serializable
//    data object HomeScreen : NavScreens()
//
//    @Serializable
//    data object DetailsScreen : NavScreens()
//
//    @Serializable
//    data object SettingsScreen : NavScreens()

    @Serializable
    data object LoginScreen : NavScreens()

    @Serializable
    data object SignUpScreen : NavScreens()

    @Serializable
    data object ProfileScreen : NavScreens()
}