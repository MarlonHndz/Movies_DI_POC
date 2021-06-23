package com.android.marlon.data.datasources

import com.android.marlon.data.models.MovieResponse
import com.android.marlon.data.retrofit.MovieService

class MovieRemoteDataSource(
    private val movieService: MovieService
) {
    /**
     * Ideally this method is running a service through Retrofit,
     * so a \suspend fun\ should be used
     */
    fun getMovies(): MovieResponse =
        movieService.getMoviesFromServerEmulated()
}
