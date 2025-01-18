package com.example.kino_temp.models.kinop_1

data class GetXXXXXX(
    val description: String,
    val operationId: String,
    val parameters: List<ParameterXXXXXX>,
    val responses: Responses,
  //  val security: List<Security>,
    val summary: String,
    val tags: List<String>
)