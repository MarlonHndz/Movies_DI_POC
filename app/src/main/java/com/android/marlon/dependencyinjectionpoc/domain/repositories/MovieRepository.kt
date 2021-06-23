package com.android.marlon.dependencyinjectionpoc.domain.repositories

import com.android.marlon.dependencyinjectionpoc.domain.model.Movie

interface MovieRepository {
    suspend fun getMovies(): List<Movie>
}
