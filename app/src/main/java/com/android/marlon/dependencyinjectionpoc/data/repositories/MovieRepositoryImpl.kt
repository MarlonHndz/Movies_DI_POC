package com.android.marlon.dependencyinjectionpoc.data.repositories

import com.android.marlon.dependencyinjectionpoc.data.datasources.MovieLocalDataSource
import com.android.marlon.dependencyinjectionpoc.data.datasources.MovieRemoteDataSource
import com.android.marlon.dependencyinjectionpoc.data.mappers.MovieMapper
import com.android.marlon.dependencyinjectionpoc.data.mappers.MovieResponseToMovieLocalMapper
import com.android.marlon.dependencyinjectionpoc.data.models.MovieResponse
import com.android.marlon.dependencyinjectionpoc.domain.model.Movie
import com.android.marlon.dependencyinjectionpoc.domain.repositories.MovieRepository

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
