package com.android.marlon.domain.models

import java.io.Serializable

data class Movie(
    val name: String,
    val genre: String,
    val director: String,
    val imageURL: String,
    val synopsis: String,
    val isFavorite: Boolean
) : Serializable
