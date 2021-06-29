package com.android.marlon.dependencyinjectionpoc.data.datasources

import com.android.marlon.dependencyinjectionpoc.data.models.MovieResponse
import com.android.marlon.dependencyinjectionpoc.data.retrofit.MovieService
import javax.inject.Inject

class MovieRemoteDataSource @Inject constructor(
    private val movieService: MovieService
) {
    /**
     * Ideally this method is running a service through Retrofit,
     * so a \suspend fun\ should be used
     */
    fun getMovies(): MovieResponse =
        movieService.getMoviesFromServerEmulated()
}
