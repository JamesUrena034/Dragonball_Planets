package edu.ucne.dragonball_planets.presentation.list

sealed interface ListCharacterUiEvent {

    data class UpdateFilters(
        val name: String,
        val gender: String,
        val race: String
    ) : ListCharacterUiEvent

    data object Search : ListCharacterUiEvent
}