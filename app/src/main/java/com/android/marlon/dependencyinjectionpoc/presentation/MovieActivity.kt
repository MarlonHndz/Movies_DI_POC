package com.android.marlon.dependencyinjectionpoc.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.android.marlon.dependencyinjectionpoc.R
import com.android.marlon.dependencyinjectionpoc.domain.model.Movie
import kotlinx.android.synthetic.main.activity_movie.*
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.viewModel

class MovieActivity : AppCompatActivity() {

    private val viewModel: MovieViewModel by viewModel()
    private val movieAdapter: MovieAdapter by inject()

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
