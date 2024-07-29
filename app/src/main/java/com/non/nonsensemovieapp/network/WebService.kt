package com.non.nonsensemovieapp.network

import com.non.nonsensemovieapp.network.response.MovieResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface WebService {
    @GET("now_playing")
    suspend fun getNowPlayingMovie(
        @Query("api_key") apiKey: String
    ): Response<MovieResponse>

    @GET("popular")
    suspend fun getPopularMovie(
        @Query("api_key") apiKey: String
    ): Response<MovieResponse>

}
