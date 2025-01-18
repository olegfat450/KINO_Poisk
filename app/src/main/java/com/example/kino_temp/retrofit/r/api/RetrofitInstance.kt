package com.example.kino_temp.retrofit.r.api

import com.example.kino_temp.Const.Companion.BASE_URL_OMDB
import com.example.kino_temp.Const.Companion.BASE_URL_KINOP
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {

     val retrofit: ApiService by lazy {

        Retrofit.Builder()
            .baseUrl(BASE_URL_KINOP)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiService::class.java)
    }


  //  val api: ApiService by lazy { retrofit.create(ApiService::class.java) }
}