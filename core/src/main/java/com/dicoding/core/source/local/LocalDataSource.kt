package com.dicoding.core.source.local

import com.dicoding.core.source.local.room.MovieDao
import com.dicoding.core.source.local.entity.MovieEntity
import kotlinx.coroutines.flow.Flow

class LocalDataSource(private val movieDao: MovieDao) {


    fun getListMovie(): Flow<List<MovieEntity>> = movieDao.getListMovie()

    fun getFavMovie(): Flow<List<MovieEntity>> = movieDao.getFavMovie()

  fun insertMovie(movieList: List<MovieEntity>) = movieDao.insertMovieToFav(movieList)

    fun setFavMovie(movie: MovieEntity, newState: Boolean) {
        movie.isFav = newState
        movieDao.updateFavMovie(movie)
    }
}