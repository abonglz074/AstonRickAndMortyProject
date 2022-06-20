package com.mytestprogram.astonrickandmortyproject.data.models.allcharactersresponse

data class CharactersListResponse(
    val info: Info,
    val results: List<SingleCharacter>
)