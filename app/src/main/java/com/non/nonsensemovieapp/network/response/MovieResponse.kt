package com.non.nonsensemovieapp.network.response


import com.google.gson.annotations.SerializedName
import com.non.nonsensemovieapp.models.Movie

data class MovieResponse(
    @SerializedName("results")
    var results: List<Movie>
)