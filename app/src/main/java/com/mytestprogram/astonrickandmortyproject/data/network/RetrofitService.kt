package com.mytestprogram.astonrickandmortyproject.data.network

import com.mytestprogram.astonrickandmortyproject.data.models.allcharactersresponse.CharactersListResponse
import com.mytestprogram.astonrickandmortyproject.data.models.allepisodesresponse.EpisodesListResponse
import com.mytestprogram.astonrickandmortyproject.data.models.alllocationsresponse.LocationsListResponse
import com.mytestprogram.astonrickandmortyproject.data.models.singlecharacterresponse.SingleCharacter
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface RetrofitService {

    @GET("character")
    suspend fun getAllCharacters(): Response<CharactersListResponse>

    @GET("character/{character-id}")
    suspend fun getCharacterById(@Path("character-id") characterId: Int): Response<SingleCharacter>

    @GET("location")
    suspend fun getAllLocations(): Response<LocationsListResponse>

    @GET("episode")
    suspend fun getAllEpisodes(): Response<EpisodesListResponse>


}