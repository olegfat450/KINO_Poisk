package com.example.kino_temp.models.kinopoisk

data class Rating(
    val await: Int,
    val filmCritics: Int,
    val imdb: Double,
    val kp: Int,
    val russianFilmCritics: Int
)