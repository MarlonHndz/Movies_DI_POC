package com.android.marlon.dependencyinjectionpoc.di

import com.android.marlon.dependencyinjectionpoc.presentation.MovieAdapter
import com.android.marlon.dependencyinjectionpoc.presentation.MovieViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val presentationModule = module {

    viewModel { MovieViewModel(get()) }
    factory { MovieAdapter() }
}
