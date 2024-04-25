package com.non.nonsensemovieapp.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.enableEdgeToEdge
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.non.nonsensemovieapp.databinding.ActivityMainBinding
import com.non.nonsensemovieapp.viewmodel.MovieViewModel

class MainActivity : ComponentActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: MovieViewModel
    private lateinit var movieAdapter: MovieAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        enableEdgeToEdge()
        setContentView(binding.root)

        viewModel = ViewModelProvider(this)[MovieViewModel::class.java]

        setupRecycleView()

        viewModel.movieList.observe(this) {
            movieAdapter.movieList = it
            movieAdapter.notifyDataSetChanged()
        }

        binding.btnGetMovies.setOnClickListener {
            viewModel.getMovies()
        }


        binding.btnGetPopularMovies.setOnClickListener {
            viewModel.getPopularMovies()
        }

        viewModel.getMovies()

    }

    private fun setupRecycleView() {
        val layoutManager = GridLayoutManager(this, 3)
        binding.rvMovie.layoutManager = layoutManager
        movieAdapter = MovieAdapter(this, arrayListOf())
        binding.rvMovie.adapter = movieAdapter
    }
}

