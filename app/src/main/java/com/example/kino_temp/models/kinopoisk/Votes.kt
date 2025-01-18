package com.example.kino_temp.models.kinopoisk

data class Votes(
    val await: Int,
    val filmCritics: Int,
    val imdb: Int,
    val kp: Int,
    val russianFilmCritics: Int
)