package com.mytestprogram.astonrickandmortyproject.data.network

import com.mytestprogram.astonrickandmortyproject.data.models.Character
import com.mytestprogram.astonrickandmortyproject.data.models.CharactersListResponse
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET

interface RetrofitService {

    @GET("character")
    suspend fun getAllCharacters(): Response<CharactersListResponse>

//    @GET("character/{character-id}")
//    fun getCharacterById(@Path("character-id") characterId: Int): Call<Character>
}