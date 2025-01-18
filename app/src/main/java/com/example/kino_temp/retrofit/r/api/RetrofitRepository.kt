package com.example.kino_temp.retrofit.r.api

import com.example.kino_temp.Const.Companion.API_KEY
import com.example.kino_temp.Const.Companion.BASE_URL_KINOP
import com.example.kino_temp.models.Omdb.MoviesModel
import com.example.kino_temp.models.Omdb_seart.MoviesModel_1
import com.example.kino_temp.models.kinopoisk.ModelKinop
import com.example.kino_temp.retrofit.r.api.RetrofitInstance.retrofit
import retrofit2.Response

class RetrofitRepository {
    suspend fun getMoves( page: Number): Response<ModelKinop>{

       // return RetrofitInstance.getPopularMovies()

        return retrofit.getPopularMovies(page = page)
    }
}