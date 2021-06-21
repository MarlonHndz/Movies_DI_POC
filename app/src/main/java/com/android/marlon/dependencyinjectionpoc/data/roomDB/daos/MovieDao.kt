package com.android.marlon.dependencyinjectionpoc.data.roomDB.daos

import androidx.lifecycle.LiveData
import androidx.room.*
import com.android.marlon.dependencyinjectionpoc.data.models.MovieLocal

@Dao
interface MovieDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(movies: List<MovieLocal>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(movie: MovieLocal)

    @Update
    fun updateMovie(movie: MovieLocal)

    @Delete
    fun delete(movie: MovieLocal)

    @Query("SELECT * FROM movie")
    fun getAll(): List<MovieLocal>

    @Query("SELECT * FROM movie WHERE name = :name LIMIT 1")
    fun getMovieByName(name: String): MovieLocal


    @Query("SELECT * FROM movie WHERE isFavorite = 1")
    fun getFavoriteMovies(): List<MovieLocal>

}
