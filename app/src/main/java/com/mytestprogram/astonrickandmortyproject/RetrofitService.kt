package com.mytestprogram.astonrickandmortyproject

import retrofit2.Call
import retrofit2.http.GET

interface RetrofitService {

    @GET("character")
    fun getCharacterById(): Call<GetCharacterByIdResponse>

    @GET("character/{character-id}")
    fun getSingleCharacterById(): Call<GetSingleCharacterByIResponse>
}