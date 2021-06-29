package com.android.marlon.dependencyinjectionpoc.presentation

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.android.marlon.dependencyinjectionpoc.R
import com.android.marlon.dependencyinjectionpoc.domain.model.Movie
import com.squareup.picasso.Picasso
import javax.inject.Inject
import kotlinx.android.synthetic.main.item_movie.view.*

class MovieAdapter @Inject constructor() :
    RecyclerView.Adapter<MovieAdapter.ViewHolder>() {

    private var items = mutableListOf<Movie>()
    private var listener: Listener? = null

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        fun bind(movie: Movie) {
            itemView.txtTitle.text = movie.name
            itemView.txtGenre.text = movie.genre
            itemView.txtDirector.text = movie.director

            // Image
            Picasso.get()
                .load(movie.imageURL)
                .placeholder(R.drawable.movie_background)
                .into(itemView.imvMovie)

            // SetUp Listener
            itemView.setOnClickListener {
                listener?.itemClicked(movie)
            }
        }
    }

    fun replaceItems(posts: List<Movie>) {
        items.clear()
        items.addAll(posts)
        notifyDataSetChanged()
    }

    fun removeAllItems() {
        items.clear()
        notifyDataSetChanged()
    }

    fun addListener(listener: Listener) {
        this.listener = listener
    }
    interface Listener {
        fun itemClicked(movie: Movie)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return ViewHolder(layoutInflater.inflate(R.layout.item_movie, parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) = holder.bind(items[position])

    override fun getItemCount() = items.size
}
