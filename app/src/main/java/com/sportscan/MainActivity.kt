package com.sportscan

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.sportscan.domain.navigation.NavGraph
import com.sportscan.ui.theme.SportScanTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val navController = rememberNavController()
            SportScanTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    NavGraph(
                        navHostController = navController,
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}