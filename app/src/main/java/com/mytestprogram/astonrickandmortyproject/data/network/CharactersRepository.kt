package com.mytestprogram.astonrickandmortyproject.data.network

import com.mytestprogram.astonrickandmortyproject.data.models.Character

class CharactersRepository(
    private val retrofitService: RetrofitService
) {
    suspend fun getAllCharacters() = retrofitService.getAllCharacters()
}