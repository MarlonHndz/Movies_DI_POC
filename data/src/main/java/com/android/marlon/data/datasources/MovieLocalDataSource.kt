package com.android.marlon.dependencyinjectionpoc.data.datasources

import androidx.lifecycle.LiveData
import com.android.marlon.dependencyinjectionpoc.data.models.MovieLocal
import com.android.marlon.dependencyinjectionpoc.data.roomDB.AppDatabase
import com.android.marlon.dependencyinjectionpoc.data.roomDB.daos.MovieDao

class MovieLocalDataSource(
    private val appDatabase: AppDatabase
) {
    fun getMovies(): List<MovieLocal> = appDatabase.movieDao().getAll()

    fun insertMovies(listMovies: List<MovieLocal>) {
        appDatabase.movieDao().insertAll(listMovies)
    }
}
