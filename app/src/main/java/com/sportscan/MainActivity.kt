package com.sportscan

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.navigation.compose.rememberNavController
import com.sportscan.data.local.DataStoreManager
import com.sportscan.domain.navigation.NavGraph
import com.sportscan.ui.theme.SportScanTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val dataStoreManager = DataStoreManager(this)
            val navController = rememberNavController()
            SportScanTheme {
                NavGraph(
                    navHostController = navController,
                    isloggedIn = dataStoreManager.isLoggedIn()
                )
            }
        }
    }
}