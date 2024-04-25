package com.non.nonsensemovieapp.models

import com.google.gson.annotations.SerializedName

data class Movie(
    @SerializedName("id")
    var id: String,
    @SerializedName("original_title")
    var originalTitle: String,
    @SerializedName("overview")
    var description: String,
    @SerializedName("poster_path")
    var posterPath: String,
    @SerializedName("release_date")
    var releaseDate: String,
    @SerializedName("vote_average")
    var voteAverage: String,
    @SerializedName("vote_count")
    var voteCount: String
)
