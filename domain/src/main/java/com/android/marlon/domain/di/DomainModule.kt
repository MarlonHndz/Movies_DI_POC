package com.android.marlon.domain.di

import com.android.marlon.domain.useCases.GetMoviesUseCase
import org.koin.dsl.module

val domainModule = module {
    factory { GetMoviesUseCase(get()) }
}
