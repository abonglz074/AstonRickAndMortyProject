package com.mytestprogram.astonrickandmortyproject.data.models.allepisodesresponse

data class SingleEpisode(
    val air_date: String,
    val characters: List<Any>,
    val created: String,
    val episode: String,
    val id: Int,
    val name: String,
    val url: String
)