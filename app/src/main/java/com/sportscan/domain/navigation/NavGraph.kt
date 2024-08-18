package com.sportscan.domain.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.sportscan.ui.screens.DetailScreen
import com.sportscan.ui.screens.HomeScreen
import com.sportscan.ui.screens.LoginScreen
import com.sportscan.ui.screens.ProfileScreen
import com.sportscan.ui.screens.RegisterScreen
import com.sportscan.ui.screens.SettingsScreen

@Composable
fun NavGraph(modifier: Modifier = Modifier, navHostController: NavHostController) {
    NavHost(navController = navHostController, startDestination = NavScreens.LoginScreen) {
        composable<NavScreens.HomeScreen> {
            HomeScreen {
                navHostController.navigate(it)
            }
        }
        composable<NavScreens.DetailsScreen> {
            DetailScreen {
                navHostController.navigate(it)
            }
        }
        composable<NavScreens.SettingsScreen> {
            SettingsScreen {
                navHostController.navigate(it)
            }
        }
        composable<NavScreens.LoginScreen> {
            LoginScreen(navigateTo = {
                navHostController.navigate(it)
            })
        }
        composable<NavScreens.RegisterScreen> {
            RegisterScreen(navigateTo = {
                navHostController.navigate(it)
            })
        }
        composable<NavScreens.ProfileScreen> {
            ProfileScreen {
                navHostController.navigate(it)
            }
        }

    }
}