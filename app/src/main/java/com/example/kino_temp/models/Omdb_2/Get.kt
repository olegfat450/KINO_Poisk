package com.example.kino_temp.models.Omdb_2

data class Get(
    val operationId: String,
    val parameters: List<Parameter>,
    val responses: Responses,
    val security: List<SecurityXXX>,
    val summary: String,
    val tags: List<String>
)