package com.android.marlon.domain.repositories

import com.android.marlon.domain.models.Movie


interface MovieRepository {
    suspend fun getMovies(): List<Movie>
}