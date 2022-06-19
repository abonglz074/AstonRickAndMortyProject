package com.mytestprogram.astonrickandmortyproject

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ApiClient(
    private val retrofitService: RetrofitService
) {
    fun getCharacterById(characterId: Int): Response<GetCharacterByIdResponse> {
        return retrofitService.getCharacterById(characterId)
    }

}