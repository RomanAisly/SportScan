package com.sportscan.domain.navigation

import androidx.compose.animation.core.tween
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.foundation.background
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.sportscan.ui.screens.Login
import com.sportscan.ui.screens.Profile
import com.sportscan.ui.screens.SignUp

@Composable
fun NavGraph(modifier: Modifier = Modifier, navHostController: NavHostController) {
    NavHost(
        modifier = modifier.background(MaterialTheme.colorScheme.background),
        navController = navHostController,
        startDestination = NavScreens.ProfileScreen,
        enterTransition = {
            slideInHorizontally(tween(durationMillis = 1150),
                initialOffsetX = { it })
        },
        exitTransition = {
            slideOutHorizontally(tween(durationMillis = 1150),
                targetOffsetX = { -it })
        },
        popEnterTransition = {
            slideInHorizontally(
                tween(durationMillis = 1150),
                initialOffsetX = { it })
        },
        popExitTransition = {
            slideOutHorizontally(
                tween(durationMillis = 1150),
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