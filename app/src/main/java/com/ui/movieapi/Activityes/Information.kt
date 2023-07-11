package com.ui.movieapi.Activityes

import android.app.Dialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.ui.movieapi.Model.MovieInfo
import com.ui.movieapi.R
import com.ui.movieapi.ViewModel.MainViewModel
import com.ui.movieapi.databinding.ActivityInformaitionBinding

class Information : AppCompatActivity() {

    private lateinit var binding: ActivityInformaitionBinding
    private lateinit var viewModel : MainViewModel
    private lateinit var progressBar : Dialog

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityInformaitionBinding.inflate(layoutInflater)
        setContentView(binding.root)
        showProgressBar()
        getMovieData()
    }

    private fun getMovieData() {

        viewModel = ViewModelProvider(this)[MainViewModel::class.java]

        viewModel.infoViewModel().observe(this, object : Observer<MovieInfo?> {
            override fun onChanged(value: MovieInfo?) {
                cancelProgressBar()
                try {

                    Glide.with(this@Information).load(value?.Poster).into(binding.ivImage)

                    binding.apply {
                        tvTitle3.text = value?.Title
                        tvReleased.text = value?.Released
                        tvPlot.text = value?.Plot
                        tvActors.text = value?.Actors
                    }

                }catch (e:Exception){
                    e.stackTrace
                }
            }
        })

    }
    private fun showProgressBar(){

        progressBar = Dialog(this)
        progressBar.setContentView(R.layout.progress)
        progressBar.show()
    }
    private fun cancelProgressBar(){
        progressBar.dismiss()
    }

}