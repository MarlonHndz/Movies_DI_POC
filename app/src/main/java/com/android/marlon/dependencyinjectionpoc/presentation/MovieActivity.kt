package com.android.marlon.dependencyinjectionpoc.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.android.marlon.dependencyinjectionpoc.R
import com.android.marlon.dependencyinjectionpoc.domain.model.Movie
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject
import kotlinx.android.synthetic.main.activity_movie.refreshMovies
import kotlinx.android.synthetic.main.activity_movie.rvMovies

@AndroidEntryPoint
class MovieActivity : AppCompatActivity() {

    @Inject
    lateinit var viewModel: MovieViewModel

    @Inject
    lateinit var movieAdapter: MovieAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie)

        listenViewModelChanges()
        listenListenersFromView()
        setupRecyclerViewPosts()
        loadData()
    }

    private fun listenViewModelChanges() {
        viewModel.movies.observe(this, Observer { movies ->
            refreshMovies.isRefreshing = false
            movieAdapter.replaceItems(movies)
        })
    }

    private fun listenListenersFromView() {
        refreshMovies.setOnRefreshListener {
            viewModel.fetchMovies()
        }
    }

    private fun setupRecyclerViewPosts() {
        val linearLayoutManager = LinearLayoutManager(this)
        rvMovies.apply {
            val dividerItemDecoration =
                DividerItemDecoration(this.context, linearLayoutManager.orientation)
            layoutManager = linearLayoutManager
            adapter = movieAdapter
            // addItemDecoration(dividerItemDecoration)
        }

        movieAdapter.addListener(object : MovieAdapter.Listener {
            override fun itemClicked(movie: Movie) {
                navigateToMovieDetails(movie)
            }
        })
    }

    private fun navigateToMovieDetails(movie: Movie) {
        // TODO: Create Navigation
        // MovieDetailsActivity.start(this, movie)
    }

    private fun loadData() {
        viewModel.fetchMovies()
    }
}
