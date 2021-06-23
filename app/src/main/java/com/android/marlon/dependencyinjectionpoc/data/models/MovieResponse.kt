package com.android.marlon.dependencyinjectionpoc.data.models

import com.android.marlon.dependencyinjectionpoc.data.retrofit.StringUtils.EMPTY_STRING

data class MovieResponse(
    val `data`: Data,
    val kind: String
) {
    data class Data(
        val after: String,
        val before: String,
        val movies: List<Movie>,
        val dist: Int
    ) {
        data class Movie(
            var genre: String = EMPTY_STRING,
            var director: String = EMPTY_STRING,
            var name: String = EMPTY_STRING,
            var imageURL: String = EMPTY_STRING,
            var synopsis: String = EMPTY_STRING,
            var isFavorite: Boolean = false
        )
    }
}
