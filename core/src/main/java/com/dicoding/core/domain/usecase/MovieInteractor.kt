package com.dicoding.core.domain.usecase

import com.dicoding.core.domain.model.Movie
import com.dicoding.core.domain.repository.IMovieRepository

class MovieInteractor(private val movieRepository: IMovieRepository) : MovieUseCase {
    override fun getListMovie() = movieRepository.getListMovie()

    override fun getFavMovie() = movieRepository.getFavoriteMovie()

    override fun setFavMovie(movie: Movie, state: Boolean) =
        movieRepository.setFavoriteMovie(movie, state)

}