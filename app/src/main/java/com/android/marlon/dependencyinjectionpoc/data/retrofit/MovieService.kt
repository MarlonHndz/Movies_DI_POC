package com.android.marlon.dependencyinjectionpoc.data.retrofit

import android.content.Context
import com.android.marlon.dependencyinjectionpoc.R
import com.android.marlon.dependencyinjectionpoc.data.models.MovieLocal
import com.android.marlon.dependencyinjectionpoc.data.models.MovieResponse
import com.android.marlon.dependencyinjectionpoc.data.retrofit.StringUtils.EMPTY_STRING
import com.android.marlon.dependencyinjectionpoc.data.roomDB.AppDatabase
import java.util.*

class MovieService(
    private val context: Context
) {

    fun getMoviesFromServerEmulated(): MovieResponse {
        val movieList: MutableList<MovieResponse.Data.Movie> = ArrayList<MovieResponse.Data.Movie>()
        val arrayMovies = context.resources.getStringArray(R.array.movies_array)
        for (i in arrayMovies.indices) {
            val movie = arrayMovies[i].split(",").toTypedArray()
            val myMovie = MovieResponse.Data.Movie()
            myMovie.name = movie[0]
            myMovie.genre = movie[1]
            myMovie.director = movie[2]
            myMovie.imageURL = movie[3]
            myMovie.synopsis = movie[4]
            myMovie.isFavorite = false
            movieList.add(myMovie)
        }

        return MovieResponse(
            MovieResponse.Data(
                EMPTY_STRING,
                EMPTY_STRING,
                movieList,
                0
            ),
            EMPTY_STRING
        )
    }

    fun saveMoviesOnDB(movieList: List<MovieLocal>, db: AppDatabase) {
        db.movieDao().insertAll(movieList)
    }
}
