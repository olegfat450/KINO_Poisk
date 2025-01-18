package com.example.kino_temp.models.kinop_1

import java.security.Security

data class Get(
    val description: String,
    val operationId: String,
    val parameters: List<Parameter>,
    val responses: Responses,
    val security: List<Security>,
    val summary: String,
    val tags: List<String>
)