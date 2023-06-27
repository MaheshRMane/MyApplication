package com.ui.movieapi.Api

import com.ui.movieapi.Model.MovieInfo
import com.ui.movieapi.Model.ResponseData
import retrofit2.Call
import retrofit2.http.GET

interface MovieApiInterface {


    @GET("/?t=Game%20of%20Thrones&apikey=da57693e&Season=1")
    fun getAllMovies() : Call<ResponseData>


    @GET("/?t=Game%20of%20Thrones&apikey=da57693e&Season=1&Episode=1")
    fun getMovieInfo(): Call<MovieInfo>
}