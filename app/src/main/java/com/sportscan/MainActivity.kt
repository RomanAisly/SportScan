package com.sportscan

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.navigation.compose.rememberNavController
import com.sportscan.domain.navigation.NavGraph
import com.sportscan.ui.theme.SportScanTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            SportScanTheme {
                val navController = rememberNavController()
                NavGraph(
                    navHostController = navController
                )
            }
        }
    }
}