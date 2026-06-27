package edu.ucne.dragonball_planets.presentation.detail

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import coil.compose.AsyncImage

@Composable
fun DetailCharacterScreen(
    viewModel: DetailCharacterViewModel = hiltViewModel(),
    onBack: () -> Unit
) {
    val state by viewModel.state.collectAsStateWithLifecycle()
    DetailCharacterBodyScreen(
        state = state,
        onBack = onBack
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetailCharacterBodyScreen(
    state: DetailCharacterUiState,
    onBack: () -> Unit
) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Detalle del Personaje") },
                navigationIcon = {
                    IconButton(onClick = onBack) {
                        Icon(Icons.Filled.ArrowBack, null)
                    }
                }
            )
        }
    ) { padding ->
        if (state.isLoading) {
            Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                CircularProgressIndicator()
            }
        }

        state.character?.let { character ->
            Column(
                modifier = Modifier
                    .padding(padding)
                    .padding(16.dp)
                    .fillMaxSize()
                    .verticalScroll(rememberScrollState())
            ) {
                AsyncImage(
                    model = character.image,
                    contentDescription = character.name,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(300.dp)
                )

                Spacer(modifier = Modifier.height(16.dp))

                Text(
                    text = character.name,
                    style = MaterialTheme.typography.headlineMedium
                )

                Text(
                    text = "Raza: ${character.race}",
                    style = MaterialTheme.typography.titleMedium
                )

                Text(
                    text = "Genero: ${character.gender}",
                    style = MaterialTheme.typography.titleMedium
                )

                Text(
                    text = "Ki: ${character.ki}",
                    style = MaterialTheme.typography.titleMedium
                )

                Text(
                    text = "Ki Maximo: ${character.maxKi}",
                    style = MaterialTheme.typography.titleMedium
                )

                Text(
                    text = "Afiliacion: ${character.affiliation}",
                    style = MaterialTheme.typography.titleMedium
                )

                Spacer(modifier = Modifier.height(8.dp))

                Text(
                    text = "Descripcion:",
                    style = MaterialTheme.typography.titleSmall
                )

                Text(
                    text = character.description,
                    style = MaterialTheme.typography.bodyLarge
                )
            }
        }
    }
}