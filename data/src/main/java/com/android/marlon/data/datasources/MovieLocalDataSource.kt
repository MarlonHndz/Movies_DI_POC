package com.android.marlon.data.datasources

import com.android.marlon.data.models.MovieLocal
import com.android.marlon.data.roomDB.AppDatabase

class MovieLocalDataSource(
    private val appDatabase: AppDatabase
) {
    fun getMovies(): List<MovieLocal> = appDatabase.movieDao().getAll()

    fun insertMovies(listMovies: List<MovieLocal>) {
        appDatabase.movieDao().insertAll(listMovies)
    }
}
