package com.example.kino_temp.models.kinopoisk

data class Doc(
    val ageRating: Int,
    val alternativeName: String,
    val countries: List<Country>,
    val description: String,
    val enName: Any,
    val genres: List<Genre>,
    val id: Int,
    val isSeries: Boolean,
    val movieLength: Int,
    val name: String,
    val poster: Poster,
    val rating: Rating,
    val ratingMpaa: Any,
    val releaseYears: List<ReleaseYear>,
    val seriesLength: Int,
    val shortDescription: Any,
    val status: Any,
    val ticketsOnSale: Boolean,
    val top10: Any,
    val top250: Any,
    val totalSeriesLength: Any,
    val type: String,
    val typeNumber: Int,
    val votes: Votes,
    val year: Int
)