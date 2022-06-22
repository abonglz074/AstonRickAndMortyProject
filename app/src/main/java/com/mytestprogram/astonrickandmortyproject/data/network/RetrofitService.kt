package com.mytestprogram.astonrickandmortyproject.data.network

import com.mytestprogram.astonrickandmortyproject.data.models.allcharactersresponse.CharactersList
import com.mytestprogram.astonrickandmortyproject.data.models.allepisodesresponse.EpisodesListResponse
import com.mytestprogram.astonrickandmortyproject.data.models.alllocationsresponse.LocationsListResponse
import com.mytestprogram.astonrickandmortyproject.data.models.allcharactersresponse.SingleCharacter
import com.mytestprogram.astonrickandmortyproject.data.models.allepisodesresponse.SingleEpisode
import com.mytestprogram.astonrickandmortyproject.data.models.alllocationsresponse.SingleLocation
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface RetrofitService {

    @GET("character")
    suspend fun getAllCharacters(): Response<CharactersList>

    @GET("character/{character-id}")
    suspend fun getCharacterById(@Path("character-id") characterId: kotlin.Int): Response<SingleCharacter>

    @GET("location")
    suspend fun getAllLocations(): Response<LocationsListResponse>

    @GET("location/{location-id}")
    suspend fun getLocationById(@Path("location-id") locationId: kotlin.Int): Response<SingleLocation>

    @GET("episode")
    suspend fun getAllEpisodes(): Response<EpisodesListResponse>

    @GET("episode/{episode-id}")
    suspend fun getEpisodeById(@Path("episode-id") episodeId: kotlin.Int): Response<SingleEpisode>

    @GET("episode/{episode-id}")
    suspend fun getMultipleEpisodesById(@Path("episode-id") episodesId: List<kotlin.Int>): Response<List<SingleEpisode>>




}