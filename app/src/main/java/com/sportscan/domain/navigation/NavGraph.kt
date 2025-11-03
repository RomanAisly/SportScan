package com.sportscan.domain.navigation

import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.tween
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.sportscan.ui.components.screenBackground
import com.sportscan.ui.screens.LoginScreen
import com.sportscan.ui.screens.ProfileScreen
import com.sportscan.ui.screens.SignUpScreen

@Composable
fun NavGraph(navHostController: NavHostController, islogedIn: Boolean) {
    Scaffold(containerColor = screenBackground()) { innerPadding ->
        NavHost(
            modifier = Modifier
                .padding(innerPadding)
                .background(screenBackground()),
            navController = navHostController,
            startDestination = if (islogedIn) NavScreens.ProfileScreen else NavScreens.LoginScreen,
            enterTransition = {
                slideInHorizontally(
                    initialOffsetX = { 900 },
                    animationSpec = tween(
                        durationMillis = 1200,
                        easing = FastOutSlowInEasing
                    )
                )
            },
            exitTransition = {
                slideOutHorizontally(
                    targetOffsetX = { 900 },
                    animationSpec = tween(
                        durationMillis = 1200,
                        easing = FastOutSlowInEasing
                    )
                )
            }
        ) {
            composable<NavScreens.LoginScreen> {
                LoginScreen(navigateTo = {
                    navHostController.navigate(it)
                })
            }
            composable<NavScreens.SignUpScreen> {
                SignUpScreen(navigateTo = {
                    navHostController.navigate(it)
                })

            }
            composable<NavScreens.ProfileScreen> {
                ProfileScreen()
            }
        }
    }
}
