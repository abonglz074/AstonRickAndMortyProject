package com.mytestprogram.astonrickandmortyproject

import retrofit2.Call
import retrofit2.http.GET

interface RetrofitService {

    @GET("character/2")
    fun getCharacterById(): Call<GetCharacterByIdResponse>
}