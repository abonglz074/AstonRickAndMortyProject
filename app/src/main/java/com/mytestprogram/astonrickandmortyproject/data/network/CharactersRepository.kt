package com.mytestprogram.astonrickandmortyproject.data.network

class CharactersRepository(
    private val retrofitService: RetrofitService
) {
    suspend fun getAllCharacters() = retrofitService.getAllCharacters()
}