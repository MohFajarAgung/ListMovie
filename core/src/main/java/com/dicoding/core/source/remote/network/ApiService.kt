package com.dicoding.core.source.remote.network

import com.dicoding.core.BuildConfig
import com.dicoding.core.source.remote.response.ListMovieResponse
import retrofit2.http.GET

interface ApiService {
    @GET("movie/now_playing?api_key=$API_KEY")
    suspend fun getMovies(): ListMovieResponse

    companion object {
        const val API_KEY = BuildConfig.API_KEY
    }
}