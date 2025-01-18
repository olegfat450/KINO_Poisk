package com.example.kino_temp.retrofit.r.api

import com.example.kino_temp.models.Omdb.MoviesModel
import com.example.kino_temp.models.Omdb_2.S
import com.example.kino_temp.models.Omdb_seart.MoviesModel_1
import com.example.kino_temp.models.kinopoisk.ModelKinop
import com.google.android.gms.location.R
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Headers
import retrofit2.http.Query

interface ApiService {

    @GET("v1.4/movie")
    @Headers("X-API-KEY: 86EB3QK-1224QYY-M747S7E-A5RWJ5P")
      suspend fun getPopularMovies(
          @Query("limit") limit: Number = 10,
        //  @Query("notNullFields") notNullFields: String = "poster.url",
          @Query("page") page: Number
      ): Response<ModelKinop>

          @GET("http://www.omdbapi.com/?t=total")
          suspend fun getPopularMoviesOmdb(): Response<MoviesModel>

}