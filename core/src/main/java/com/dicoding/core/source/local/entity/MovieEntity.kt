package com.dicoding.core.source.local.entity

import androidx.annotation.NonNull
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "movie")
data class MovieEntity(
    @PrimaryKey
    @NonNull
    val id: Int,

    val coverMovie: String,

    val title: String,

    val date: String,

    val vote_average: Double,

    val desc: String,

    var isFav: Boolean = false
)
