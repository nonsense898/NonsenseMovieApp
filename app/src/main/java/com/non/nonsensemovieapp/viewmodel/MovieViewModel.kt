package com.non.nonsensemovieapp.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.non.nonsensemovieapp.core.Constants
import com.non.nonsensemovieapp.models.Movie
import com.non.nonsensemovieapp.network.MovieClient
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MovieViewModel : ViewModel() {
    private var _movieList = MutableLiveData<List<Movie>>()
    val movieList: MutableLiveData<List<Movie>> = _movieList

    fun getMovies() {
        viewModelScope.launch(Dispatchers.IO) {
            val response = MovieClient.webService.getMovie(Constants.API_KEY)
            withContext(Dispatchers.Main) {
                movieList.value = response.body()!!.results.sortedByDescending { it.voteAverage }
            }
        }
    }

    fun getPopularMovies() {
        viewModelScope.launch(Dispatchers.IO) {
            val response = MovieClient.webService.getPopular(Constants.API_KEY)
            withContext(Dispatchers.Main) {
                movieList.value = response.body()!!.results.sortedByDescending { it.voteAverage }
            }
        }
    }


}