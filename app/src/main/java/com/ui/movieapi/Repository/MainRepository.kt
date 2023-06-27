package com.ui.movieapi.Repository

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.ui.movieapi.Api.MovieApiInterface
import com.ui.movieapi.Api.RetrofitInstance
import com.ui.movieapi.Model.MovieInfo
import com.ui.movieapi.Model.ResponseData
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainRepository() {

    private var movieLiveData : MutableLiveData<ResponseData> = MutableLiveData()
    private var infoLiveData : MutableLiveData<MovieInfo> = MutableLiveData()


    fun getMovieData() : MutableLiveData<ResponseData>{

        try {
            RetrofitInstance.instance.getAllMovies().enqueue(object : Callback<ResponseData?> {
                override fun onResponse(call: Call<ResponseData?>, response: Response<ResponseData?>) {
                 try {
                     movieLiveData.value = response.body()

                 }catch (e:Exception){
                     e.message
                 }
                }

                override fun onFailure(call: Call<ResponseData?>, t: Throwable) {
                    Log.d("error","${t.message}")
                }
            })
        }catch (e:Exception){
            e.stackTrace
        }

        return movieLiveData
    }

    fun getMovieInformation() : MutableLiveData<MovieInfo> {

        try {

            RetrofitInstance.instance.getMovieInfo().enqueue(object : Callback<MovieInfo?> {
                override fun onResponse(call: Call<MovieInfo?>, response: Response<MovieInfo?>) {

                    infoLiveData.value = response.body()

                }
                override fun onFailure(call: Call<MovieInfo?>, t: Throwable) {

                    Log.d("error","${t.message}")
                }
            })

        }catch (e:Exception){
            e.stackTrace
        }
        return infoLiveData
    }
}