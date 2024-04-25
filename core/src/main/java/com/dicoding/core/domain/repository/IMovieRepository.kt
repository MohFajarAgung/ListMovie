package com.dicoding.core.domain.repository

import com.dicoding.core.domain.model.Movie
import com.dicoding.core.source.Resource
import kotlinx.coroutines.flow.Flow

interface IMovieRepository {

    fun getListMovie() : Flow<Resource<List<Movie>>>

    fun getFavoriteMovie(): Flow<List<Movie>>

    fun setFavoriteMovie(movie: Movie, state: Boolean)
}