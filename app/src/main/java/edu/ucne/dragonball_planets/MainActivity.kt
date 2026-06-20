package edu.ucne.dragonball_planets

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.navigation.compose.rememberNavController
import dagger.hilt.android.AndroidEntryPoint
import edu.ucne.dragonball_planets.presentation.navigation.NavHost
import edu.ucne.dragonball_planets.ui.theme.Dragonball_PlanetsTheme

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Dragonball_PlanetsTheme {
                val navController = rememberNavController()
                NavHost(navHostController = navController)
            }
        }
    }
}