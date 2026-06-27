package edu.ucne.dragonball_planets.presentation.navigation

import androidx.compose.material3.DrawerState
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import edu.ucne.dragonball_planets.presentation.detail.DetailCharacterScreen
import edu.ucne.dragonball_planets.presentation.character.list.ListCharacterScreen
import edu.ucne.dragonball_planets.presentation.planet.detail.DetailPlanetScreen
import edu.ucne.dragonball_planets.presentation.planet.list.ListPlanetScreen

@Composable
fun NavHost(
    navHostController: NavHostController,
    drawerState: DrawerState
) {
    NavHost(
        navController = navHostController,
        startDestination = Screen.PlanetList
    ) {
        composable<Screen.PlanetList> {
            ListPlanetScreen(
                drawerState = drawerState,
                onPlanetClick = { planetId ->
                    navHostController.navigate(Screen.PlanetDetail(planetId))
                }
            )
        }

        composable<Screen.PlanetDetail> {
            DetailPlanetScreen(
                onBack = {
                    navHostController.navigateUp()
                }
            )
        }

        composable<Screen.CharacterList> {
            ListCharacterScreen(
                drawerState = drawerState,
                onCharacterClick = { characterId ->
                    navHostController.navigate(Screen.CharacterDetail(characterId))
                }
            )
        }

        composable<Screen.CharacterDetail> {
            DetailCharacterScreen(
                onBack = {
                    navHostController.navigateUp()
                }
            )
        }
    }
}