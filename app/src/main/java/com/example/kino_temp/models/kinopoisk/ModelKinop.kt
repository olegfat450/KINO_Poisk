package com.example.kino_temp.models.kinopoisk

data class ModelKinop(
    val docs: List<Doc>,
    val limit: Int,
    val page: Int,
    val pages: Int,
    val total: Int
)