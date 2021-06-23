package com.android.marlon.data.roomDB

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.android.marlon.data.models.MovieLocal
import com.android.marlon.data.roomDB.daos.MovieDao

@Database(entities = [MovieLocal::class], version = AppDatabase.DATABASE_VERSION)
abstract class AppDatabase : RoomDatabase() {
    abstract fun movieDao(): MovieDao

    companion object {
        fun getInstance(context: Context): AppDatabase {
            if (INSTANCE == null) {
                synchronized(AppDatabase::class) {
                    INSTANCE = buildRoomDB(context)
                }
            }
            return INSTANCE!!
        }

        private fun buildRoomDB(context: Context) =
            Room.databaseBuilder(
                context.applicationContext,
                AppDatabase::class.java,
                DATABASE_NAME
            )
                .fallbackToDestructiveMigration()
                .build()


        private var INSTANCE: AppDatabase? = null
        const val DATABASE_VERSION = 1
        private const val DATABASE_NAME = "di_poc_movie_database"

        const val MOVIE_TABLE_NAME = "Movie"
    }
}
