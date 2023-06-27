package com.ui.movieapi.Model

data class ResponseData(
    val Episodes: List<Episode>,
    val Response: String,
    val Season: String,
    val Title: String,
    val totalSeasons: String
)