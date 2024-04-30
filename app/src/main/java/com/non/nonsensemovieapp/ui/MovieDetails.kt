package com.non.nonsensemovieapp.ui

import android.content.Context
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.non.nonsensemovieapp.core.Constants
import com.non.nonsensemovieapp.databinding.ActivityMovieDetailsBinding


class MovieDetails : AppCompatActivity() {

    private lateinit var binding: ActivityMovieDetailsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMovieDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        fillUiWithIntentData(this)
    }

    private fun fillUiWithIntentData(context: Context) {
        Glide.with(context)
            .load("${Constants.BASE_URL_IMAGE}${intent.extras?.getString("movie_poster")}")
            .apply(RequestOptions().override(Constants.IMAGE_WIDTH, Constants.IMAGE_HEIGHT))
            .into(binding.ivMoviePoster)

        Glide.with(context)
            .load("${Constants.BASE_URL_IMAGE}${intent.extras?.getString("movie_poster")}")
            .apply(RequestOptions().override(Constants.IMAGE_WIDTH, Constants.IMAGE_HEIGHT))
            .into(binding.ivSmallMoviePoster)

        binding.apply {
            tvMovieDesc.text = intent.extras?.getString("movie_desc")
            tvMovieTitle.text = intent.extras?.getString("movie_title")
        }

    }
}