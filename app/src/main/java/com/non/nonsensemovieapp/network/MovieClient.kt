package com.non.nonsensemovieapp.network

import com.google.gson.GsonBuilder
import com.non.nonsensemovieapp.core.Constants
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


object MovieClient {
    val webService: WebService by lazy {
        Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))
            .build()
            .create(WebService::class.java)
    }

}