package com.example.kino_temp.models.kinop_1

import java.security.Security

data class GetXXX(
    val description: String,
    val operationId: String,
    val parameters: List<ParameterXXX>,
    val responses: Responses,
   // val security: List<Security>,
    val summary: String,
    val tags: List<String>
)