package com.android.marlon.dependencyinjectionpoc.di

import android.content.Context
import com.android.marlon.dependencyinjectionpoc.data.repositories.MovieRepositoryImpl
import com.android.marlon.dependencyinjectionpoc.data.roomDB.AppDatabase
import com.android.marlon.dependencyinjectionpoc.data.roomDB.daos.MovieDao
import com.android.marlon.dependencyinjectionpoc.domain.repositories.MovieRepository
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
abstract class DataModule {

    @Binds
    abstract fun bindMovieRepository(
        movieRepositoryImpl: MovieRepositoryImpl
    ): MovieRepository
}

@Module
@InstallIn(ApplicationComponent::class)
object DatabaseModule {

    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext appContext: Context): AppDatabase {
        return AppDatabase.getInstance(appContext)
    }

    @Provides
    fun provideMovieDao(database: AppDatabase): MovieDao {
        return database.movieDao()
    }
}
