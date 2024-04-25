package com.dicoding.core.domain.model

import android.os.Parcel
import android.os.Parcelable
import kotlinx.android.parcel.Parcelize
import java.io.Serializable

@Parcelize
data class Movie(
 val id: Int,

 val coverMovie: String,

 val title: String,

 val date: String,

 val vote_average: Double,

 val desc: String,

 val isFav: Boolean
): Parcelable