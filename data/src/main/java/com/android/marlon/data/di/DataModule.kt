package com.android.marlon.data.di

import com.android.marlon.data.datasources.MovieLocalDataSource
import com.android.marlon.data.datasources.MovieRemoteDataSource
import com.android.marlon.data.mappers.MovieMapper
import com.android.marlon.data.mappers.MovieResponseToMovieLocalMapper
import com.android.marlon.data.repositories.MovieRepositoryImpl
import com.android.marlon.data.retrofit.MovieService
import com.android.marlon.data.roomDB.AppDatabase
import com.android.marlon.domain.repositories.MovieRepository
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
