package com.android.marlon.domain.useCases

import com.android.marlon.domain.models.Movie
import com.android.marlon.domain.repositories.MovieRepository

class GetMoviesUseCase(
    private val movieRepository: MovieRepository
) {
    suspend fun getMovies(): List<Movie> {
        return movieRepository.getMovies()
    }
}
