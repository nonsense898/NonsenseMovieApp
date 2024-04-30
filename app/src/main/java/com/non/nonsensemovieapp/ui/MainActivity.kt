package com.non.nonsensemovieapp.ui

import android.content.Context
import android.os.Bundle
import android.view.View
import android.view.View.OnClickListener
import android.widget.Button
import androidx.activity.ComponentActivity
import androidx.activity.enableEdgeToEdge
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.non.nonsensemovieapp.R
import com.non.nonsensemovieapp.databinding.ActivityMainBinding
import com.non.nonsensemovieapp.viewmodel.MovieViewModel

class MainActivity : ComponentActivity(), OnClickListener  {
    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: MovieViewModel
    private lateinit var movieAdapter: MovieAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        enableEdgeToEdge()
        setContentView(binding.root)

        init(this)
    }

    private fun init(context: Context) {
        viewModel = ViewModelProvider(this)[MovieViewModel::class.java]
        movieAdapter = MovieAdapter(context, arrayListOf())

        viewModel.movieList.observe(this) {
            movieAdapter.movieList = it
            movieAdapter.notifyDataSetChanged()

            binding.apply {
                rvMovie.layoutManager = GridLayoutManager(context,3)
                rvMovie.adapter = movieAdapter}}

        viewModel.getMovie(false)
        binding.btnGetMovies.setOnClickListener(this)
        binding.btnGetPopularMovies.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when(v?.id){
            R.id.btnGetMovies -> viewModel.getMovie(false)
            R.id.btnGetPopularMovies -> viewModel.getMovie(true)
        }
    }
}

