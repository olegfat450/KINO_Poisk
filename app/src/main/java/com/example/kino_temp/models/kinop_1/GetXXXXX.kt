package com.example.kino_temp.models.kinop_1

data class GetXXXXX(
    val operationId: String,
    val parameters: List<Parameter>,
    val responses: Responses,
  //  val security: List<Security>,
    val summary: String,
    val tags: List<String>
)