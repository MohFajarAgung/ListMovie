package com.dicoding.listmovie

import androidx.lifecycle.ViewModel
import com.dicoding.core.domain.model.Movie
import com.dicoding.core.domain.usecase.MovieUseCase

class DetailMovieViewModel(private val movieUseCase: MovieUseCase): ViewModel() {

    fun setMovieFav(movie: Movie, newState : Boolean) {
        return movieUseCase.setFavMovie(movie,newState)
    }
}