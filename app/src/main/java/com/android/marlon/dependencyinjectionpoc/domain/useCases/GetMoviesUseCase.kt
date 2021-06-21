package com.android.marlon.dependencyinjectionpoc.domain.useCases

import com.android.marlon.dependencyinjectionpoc.domain.model.Movie
import com.android.marlon.dependencyinjectionpoc.domain.repositories.MovieRepository

class GetMoviesUseCase(
    private val movieRepository: MovieRepository
) {
    suspend fun getMovies(): List<Movie> {
        return movieRepository.getMovies()
    }
}
