package com.ui.movieapi.Activityes

import android.app.Dialog
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.ui.movieapi.Adapter.MovieAdapter
import com.ui.movieapi.Model.Episode
import com.ui.movieapi.Model.ResponseData
import com.ui.movieapi.R
import com.ui.movieapi.ViewModel.MainViewModel
import com.ui.movieapi.databinding.ActivityMain4Binding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMain4Binding
    private lateinit var viewModel: MainViewModel
    private lateinit var progressBar : Dialog
    private var data: List<Episode>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMain4Binding.inflate(layoutInflater)
        setContentView(binding.root)

        showProgressBar()
        getData()

    }


    private fun getData() {

        viewModel = ViewModelProvider(this)[MainViewModel::class.java]

        viewModel.movieViewModel().observe(this, object : Observer<ResponseData?> {
            override fun onChanged(value: ResponseData?) {
                cancelProgressBar()
                try {
                    binding.tvTitle.text = value?.Title
                    binding.tvSeason.text = value?.Season
                    data = value?.Episodes

                    binding.rvRecyclerView.layoutManager = LinearLayoutManager(this@MainActivity)
                    binding.rvRecyclerView.setHasFixedSize(true)
                    val adapter = MovieAdapter(data!!)
                    binding.rvRecyclerView.adapter = adapter
                    adapter.setOnClickListener(object : MovieAdapter.OnClickListener {
                        override fun onClick(position: Int) {
                            startActivity(Intent(this@MainActivity,Information::class.java))
                        }
                    })

                } catch (e: Exception) {
                    e.message
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