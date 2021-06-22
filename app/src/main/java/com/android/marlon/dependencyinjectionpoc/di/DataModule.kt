package com.android.marlon.dependencyinjectionpoc.di

import com.android.marlon.dependencyinjectionpoc.data.datasources.MovieLocalDataSource
import com.android.marlon.dependencyinjectionpoc.data.datasources.MovieRemoteDataSource
import com.android.marlon.dependencyinjectionpoc.data.mappers.MovieMapper
import com.android.marlon.dependencyinjectionpoc.data.mappers.MovieResponseToMovieLocalMapper
import com.android.marlon.dependencyinjectionpoc.data.repositories.MovieRepositoryImpl
import com.android.marlon.dependencyinjectionpoc.data.retrofit.MovieService
import com.android.marlon.dependencyinjectionpoc.data.roomDB.AppDatabase
import com.android.marlon.dependencyinjectionpoc.domain.repositories.MovieRepository
import org.koin.dsl.module

val dataModule = module {

    factory { MovieService(get()) }
    single { AppDatabase.getInstance(get()) }
    single { get<AppDatabase>().movieDao() }

    single { MovieLocalDataSource(get()) }
    single { MovieRemoteDataSource(get()) }

    factory { MovieMapper() }
    factory { MovieResponseToMovieLocalMapper() }
    factory<MovieRepository> { MovieRepositoryImpl(get(), get(), get(), get()) }
}
