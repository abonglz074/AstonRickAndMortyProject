package com.mytestprogram.astonrickandmortyproject

import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface RetrofitService {

    @GET("character/{character-id}")
    fun getCharacterById(@Path("characer-id") characterId: Int): Response<GetCharacterByIdResponse>
}