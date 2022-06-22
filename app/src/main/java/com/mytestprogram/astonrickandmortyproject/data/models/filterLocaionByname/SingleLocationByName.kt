package com.mytestprogram.astonrickandmortyproject.data.models.filterLocaionByname

data class SingleLocationByName(
    val created: String,
    val dimension: String,
    val id: Int,
    val name: String,
    val residents: List<String>,
    val type: String,
    val url: String
)