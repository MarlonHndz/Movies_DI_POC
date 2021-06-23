package com.android.marlon.data.repositories

import com.android.marlon.data.datasources.MovieLocalDataSource
import com.android.marlon.data.datasources.MovieRemoteDataSource
import com.android.marlon.data.mappers.MovieMapper
import com.android.marlon.data.mappers.MovieResponseToMovieLocalMapper
import com.android.marlon.data.models.MovieResponse
import com.android.marlon.domain.models.Movie
import com.android.marlon.domain.repositories.MovieRepository

class MovieRepositoryImpl(
    private val movieLocalDataSource: MovieLocalDataSource,
    private val movieRemoteDataSource: MovieRemoteDataSource,
    private val movieResponseToMovieLocalMapper: MovieResponseToMovieLocalMapper,
    private val movieMapper: MovieMapper
) : MovieRepository {

    override suspend fun getMovies(): List<Movie> {
        val movieResponse = movieRemoteDataSource.getMovies()
        insertMoviesIntoDB(movieResponse)
        return movieMapper(movieLocalDataSource.getMovies())
    }

    private fun insertMoviesIntoDB(movieResponse: MovieResponse) {
        movieLocalDataSource.insertMovies(movieResponseToMovieLocalMapper(movieResponse))
    }
}
