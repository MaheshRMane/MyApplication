package com.ui.movieapi.Api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

object RetrofitInstance {

    private const val BASE_URL ="https://www.omdbapi.com"

    private val retrofit by lazy {

        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    val instance: MovieApiInterface by lazy {
        retrofit.create(MovieApiInterface::class.java)
    }
}