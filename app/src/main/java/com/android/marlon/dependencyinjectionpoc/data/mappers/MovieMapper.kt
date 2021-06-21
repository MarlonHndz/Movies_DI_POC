package com.android.marlon.dependencyinjectionpoc.data.mappers

import com.android.marlon.dependencyinjectionpoc.data.models.MovieLocal
import com.android.marlon.dependencyinjectionpoc.domain.model.Movie

class MovieMapper {
    private val movieList = mutableListOf<Movie>()

    operator fun invoke(listMovieLocal: List<MovieLocal>): List<Movie>{
        listMovieLocal.map { movieLocal ->
            val newMovie = Movie(
                name = movieLocal.name,
                genre = movieLocal.genre,
                director = movieLocal.director,
                imageURL = movieLocal.imageURL,
                synopsis = movieLocal.synopsis,
                isFavorite = movieLocal.isFavorite
            )
            movieList.add(newMovie)
        }
        return movieList
    }
}
