package edu.ucne.dragonball_planets

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.rememberDrawerState
import androidx.navigation.compose.rememberNavController
import dagger.hilt.android.AndroidEntryPoint
import edu.ucne.dragonball_planets.ui.theme.Dragonball_PlanetsTheme
import edu.ucne.dragonball_planets.presentation.navigation.NavHost
import edu.ucne.planetapi.presentation.navigation.DrawerMenu

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Dragonball_PlanetsTheme {
                val navController = rememberNavController()
                val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)

                DrawerMenu(
                    drawerState = drawerState,
                    navHostController = navController
                ) {
                    NavHost(
                        navHostController = navController,
                        drawerState = drawerState
                    )
                }
            }
        }
    }
}