package com.dicoding.listmovie.di

import com.dicoding.core.domain.usecase.MovieInteractor
import com.dicoding.core.domain.usecase.MovieUseCase
import com.dicoding.listmovie.DetailMovieViewModel
import com.dicoding.listmovie.MovieViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val useCaseModule = module {
    factory<MovieUseCase> { MovieInteractor(get()) }
}

val viewModelModule = module {
    viewModel { MovieViewModel(get()) }
    viewModel { DetailMovieViewModel(get()) }
}