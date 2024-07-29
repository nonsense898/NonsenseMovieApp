package com.non.nonsensemovieapp.repository

import com.non.nonsensemovieapp.network.MovieClient



class MovieRepository() {
    companion object{
        fun getWebService() = MovieClient.webService
    }
}









