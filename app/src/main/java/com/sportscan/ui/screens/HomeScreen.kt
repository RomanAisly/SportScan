package com.sportscan.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.sportscan.domain.navigation.NavScreens

@Composable
fun HomeScreen(modifier: Modifier = Modifier, navigateTo: (NavScreens) -> Unit) {
    Column(modifier.fillMaxSize().background(Color.Blue)) {
        Button(onClick = { navigateTo.invoke(NavScreens.DetailsScreen) }) {

        }
    }
}