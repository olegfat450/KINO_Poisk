package com.example.kino_temp.models.Omdb_2

data class Parameter(
    val description: String,
    val `enum`: List<String>,
    val `in`: String,
    val name: String,
    val required: Boolean,
    val type: String
)