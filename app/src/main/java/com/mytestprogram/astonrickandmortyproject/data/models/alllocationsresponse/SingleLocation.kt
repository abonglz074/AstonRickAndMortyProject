package com.mytestprogram.astonrickandmortyproject.data.models.alllocationsresponse

import kotlin.Int

data class SingleLocation(
    val created: String,
    val dimension: String,
    val id: Int,
    val name: String,
    val residents: List<Any>,
    val type: String,
    val url: String
)