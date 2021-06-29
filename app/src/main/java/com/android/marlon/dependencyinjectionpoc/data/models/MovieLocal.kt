package com.android.marlon.dependencyinjectionpoc.data.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.android.marlon.dependencyinjectionpoc.data.retrofit.StringUtils.EMPTY_STRING
import com.android.marlon.dependencyinjectionpoc.data.roomDB.AppDatabase.Companion.MOVIE_TABLE_NAME

@Entity(tableName = MOVIE_TABLE_NAME)
data class MovieLocal(
    @PrimaryKey @ColumnInfo(name = "name") val name: String = EMPTY_STRING,
    @ColumnInfo(name = "genre") val genre: String = EMPTY_STRING,
    @ColumnInfo(name = "director") val director: String = EMPTY_STRING,
    @ColumnInfo(name = "imageURL") val imageURL: String = EMPTY_STRING,
    @ColumnInfo(name = "synopsis") val synopsis: String = EMPTY_STRING,
    @ColumnInfo(name = "isFavorite") val isFavorite: Boolean = false
)
