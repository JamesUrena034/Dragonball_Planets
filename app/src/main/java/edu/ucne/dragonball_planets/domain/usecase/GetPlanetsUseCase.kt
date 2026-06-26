package edu.ucne.dragonball_planets.domain.usecase

import edu.ucne.dragonball_planets.data.remote.Resource
import edu.ucne.dragonball_planets.domain.model.Planet
import edu.ucne.dragonball_planets.domain.repository.PlanetRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetPlanetsUseCase @Inject constructor(
    private val repository: PlanetRepository
) {
    operator fun invoke(
        page: Int = 1,
        limit: Int = 10,
        name: String? = null
    ): Flow<Resource<List<Planet>>> {
        return repository.getPlanets(page, limit, name)
    }
}