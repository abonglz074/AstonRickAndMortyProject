package com.mytestprogram.astonrickandmortyproject.data.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object NetworkInstance {

    private const val BASE_URL = "https://rickandmortyapi.com/api/"

    val retrofit: RetrofitService = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(RetrofitService::class.java)

}