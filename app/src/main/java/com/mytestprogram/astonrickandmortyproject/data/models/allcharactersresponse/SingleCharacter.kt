package com.mytestprogram.astonrickandmortyproject.data.models.allcharactersresponse

import com.mytestprogram.astonrickandmortyproject.data.models.allepisodesresponse.SingleEpisode

data class SingleCharacter(
    val created: String,
    val episode: List<String>,
    val gender: String,
    val id: Int,
    val image: String,
    val location: Location,
    val name: String,
    val origin: Origin,
    val species: String,
    val status: String,
    val type: String,
    val url: String
)