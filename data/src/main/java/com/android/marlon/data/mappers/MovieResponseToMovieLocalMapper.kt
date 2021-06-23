package com.android.marlon.data.mappers

import com.android.marlon.data.models.MovieLocal
import com.android.marlon.data.models.MovieResponse

class MovieResponseToMovieLocalMapper {

    operator fun invoke(movieResponse: MovieResponse): List<MovieLocal>{
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