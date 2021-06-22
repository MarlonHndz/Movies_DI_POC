package com.android.marlon.dependencyinjectionpoc.di

import com.android.marlon.dependencyinjectionpoc.domain.useCases.GetMoviesUseCase
import org.koin.dsl.module

val domainModule = module {
    factory { GetMoviesUseCase(get()) }
}
