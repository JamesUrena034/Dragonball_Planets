package edu.ucne.dragonball_planets.domain.usecase

import edu.ucne.dragonball_planets.data.remote.Resource
import edu.ucne.dragonball_planets.domain.model.Character
import edu.ucne.dragonball_planets.domain.repository.CharacterRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetCharactersUseCase @Inject constructor(
    private val repository: CharacterRepository
) {
    operator fun invoke(
        page: Int = 1,
        limit: Int = 10,
        name: String? = null,
        gender: String? = null,
        race: String? = null
    ): Flow<Resource<List<Character>>> {
        return repository.getCharacters(page, limit, name, gender, race)
    }
}