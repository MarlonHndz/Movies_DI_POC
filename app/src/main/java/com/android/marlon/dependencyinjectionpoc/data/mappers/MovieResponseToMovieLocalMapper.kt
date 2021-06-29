package com.android.marlon.dependencyinjectionpoc.data.mappers

import com.android.marlon.dependencyinjectionpoc.data.models.MovieLocal
import com.android.marlon.dependencyinjectionpoc.data.models.MovieResponse
import javax.inject.Inject

class MovieResponseToMovieLocalMapper @Inject constructor() {

    operator fun invoke(movieResponse: MovieResponse): List<MovieLocal> {
        val movieList = mutableListOf<MovieLocal>()
        movieResponse.data.movies.map { movie ->
            val newMovie = MovieLocal(
                name = movie.name,
                genre = movie.genre,
                director = movie.director,
                imageURL = movie.imageURL,
                synopsis = movie.synopsis,
                isFavorite = movie.isFavorite
            )
            movieList.add(newMovie)
        }
        return movieList
    }
}
