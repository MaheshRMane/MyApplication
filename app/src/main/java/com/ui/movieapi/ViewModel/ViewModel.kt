package com.ui.movieapi.ViewModel


import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.ui.movieapi.Model.MovieInfo
import com.ui.movieapi.Model.ResponseData
import com.ui.movieapi.Repository.MainRepository


class MainViewModel : ViewModel() {

    private var mutableLiveData: MutableLiveData<ResponseData> = MutableLiveData<ResponseData>()
    private var liveData : MutableLiveData<MovieInfo> = MutableLiveData<MovieInfo>()

    fun movieViewModel(): MutableLiveData<ResponseData> {

        mutableLiveData = MainRepository().getMovieData()

        return mutableLiveData
    }

    fun infoViewModel(): MutableLiveData<MovieInfo>{

        liveData = MainRepository().getMovieInformation()

        return liveData
    }
}