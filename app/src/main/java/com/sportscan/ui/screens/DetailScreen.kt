package com.sportscan.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.sportscan.domain.navigation.NavScreens

@Composable
fun DetailScreen(modifier: Modifier = Modifier, navigateTo: (NavScreens) -> Unit) {
    Box(
        modifier
            .fillMaxSize()
            .background(Color.Green)) {

    }
}