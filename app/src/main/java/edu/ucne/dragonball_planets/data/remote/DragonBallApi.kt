package edu.ucne.dragonball_planets.data.remote

import edu.ucne.dragonball_planets.data.remote.dto.CharacterDto
import edu.ucne.dragonball_planets.data.remote.dto.CharacterResponseDto
import edu.ucne.dragonball_planets.data.remote.dto.PlanetDto
import edu.ucne.dragonball_planets.data.remote.dto.PlanetResponseDto
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface DragonBallApi {
    @GET("planets")
    suspend fun getPlanets(
        @Query("page") page: Int,
        @Query("limit") limit: Int
    ): Response<PlanetResponseDto>

    @GET("planets")
    suspend fun searchPlanets(
        @Query("name") name: String
    ): Response<List<PlanetDto>>

    @GET("planets/{id}")
    suspend fun getPlanetDetail(
        @Path("id") id: Int
    ): Response<PlanetDto>

    @GET("characters")
    suspend fun getCharacters(
        @Query("page") page: Int,
        @Query("limit") limit: Int,
        @Query("name") name: String? = null,
        @Query("gender") gender: String? = null,
        @Query("race") race: String? = null
    ): Response<CharacterResponseDto>

    @GET("characters/{id}")
    suspend fun getCharacterDetail(
        @Path("id") id: Int
    ): Response<CharacterDto>
}