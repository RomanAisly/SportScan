package com.sportscan.domain.navigation

import androidx.compose.animation.core.tween
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.sportscan.ui.screens.Login
import com.sportscan.ui.screens.Profile
import com.sportscan.ui.screens.SignUp

@Composable
fun NavGraph(navHostController: NavHostController) {
    NavHost(
        navController = navHostController,
        startDestination = NavScreens.LoginScreen,
        enterTransition = {
            slideInHorizontally(tween(durationMillis = 1300),
                initialOffsetX = { it })
        },
        exitTransition = {
            slideOutHorizontally(tween(durationMillis = 1300),
                targetOffsetX = { -it })
        },
        popEnterTransition = {
            slideInHorizontally(
                tween(durationMillis = 1300),
                initialOffsetX = { it })
        },
        popExitTransition = {
            slideOutHorizontally(
                tween(durationMillis = 1300),
                targetOffsetX = { it })
        }
    ) {
        composable<NavScreens.LoginScreen> {
            Login(navigateTo = {
                navHostController.navigate(it)
            })
        }
        composable<NavScreens.SignUpScreen> {
            SignUp(navigateTo = {
                navHostController.navigate(it)
            })
        }
        composable<NavScreens.ProfileScreen> {
            Profile()
        }
    }
}