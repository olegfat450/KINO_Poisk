package com.example.kino_temp.models.Omdb_2

data class MovesModel_2(
    val basePath: String,
    val externalDocs: ExternalDocs,
    val host: String,
    val info: Info,
   // val paths: Paths,
    val schemes: List<String>,
    val security: List<SecurityXXX>,
    val securityDefinitions: SecurityDefinitions,
    val swagger: String,
    val tags: List<Tag>
)