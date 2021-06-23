package com.android.marlon.dependencyinjectionpoc.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.android.marlon.domain.models.Movie
import com.android.marlon.domain.useCases.GetMoviesUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MovieViewModel(
    private val getMoviesUseCase: GetMoviesUseCase
) : ViewModel() {

    private val _movies: MutableLiveData<List<Movie>> = MutableLiveData()

    val movies: LiveData<List<Movie>>
        get() = _movies

    fun fetchMovies() {
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                val postsList = getMoviesUseCase.getMovies()
                _movies.postValue(postsList)
            }
        }
    }

}
