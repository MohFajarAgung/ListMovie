package com.dicoding.core.domain.usecase

import com.dicoding.core.domain.model.Movie
import com.dicoding.core.source.Resource
import kotlinx.coroutines.flow.Flow

interface MovieUseCase {
    fun getListMovie(): Flow<Resource<List<Movie>>>

    fun getFavMovie(): Flow<List<Movie>>

    fun setFavMovie(movie: Movie, state: Boolean)
}