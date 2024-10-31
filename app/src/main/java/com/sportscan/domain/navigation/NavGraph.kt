package com.sportscan.domain.navigation

import android.content.res.Configuration
import androidx.compose.animation.core.tween
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalConfiguration
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.sportscan.ui.screens.LoginLandscape
import com.sportscan.ui.screens.LoginPortrait
import com.sportscan.ui.screens.ProfileLandscape
import com.sportscan.ui.screens.ProfilePortrait
import com.sportscan.ui.screens.SignUpLandscape
import com.sportscan.ui.screens.SignUpPortrait

@Composable
fun NavGraph(navHostController: NavHostController) {
    val configuration = LocalConfiguration.current

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
            if (configuration.orientation == Configuration.ORIENTATION_PORTRAIT) {
                LoginPortrait(navigateTo = {
                    navHostController.navigate(it)
                })
            } else {
                LoginLandscape(navigateTo = {
                    navHostController.navigate(it)
                })
            }

        }
        composable<NavScreens.SignUpScreen> {
            if (configuration.orientation == Configuration.ORIENTATION_PORTRAIT) {
                SignUpPortrait(navigateTo = {
                    navHostController.navigate(it)
                })
            } else {
                SignUpLandscape(navigateTo = {
                    navHostController.navigate(it)
                })
            }

        }
        composable<NavScreens.ProfileScreen> {
            if (configuration.orientation == Configuration.ORIENTATION_PORTRAIT) {
                ProfilePortrait()
            } else {
                ProfileLandscape()
            }
        }
    }
}