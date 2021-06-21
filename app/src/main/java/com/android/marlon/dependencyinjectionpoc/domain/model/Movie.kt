package com.android.marlon.dependencyinjectionpoc.domain.model

import java.io.Serializable

data class Movie(
    val name: String,
    val genre: String,
    val director: String,
    val imageURL: String,
    val synopsis: String,
    val isFavorite: Boolean
) : Serializable
