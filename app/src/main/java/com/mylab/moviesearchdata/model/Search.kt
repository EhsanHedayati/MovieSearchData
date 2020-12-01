package com.mylab.moviesearchdata.model


import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize
import android.os.Parcelable


@Parcelize
data class Search(
    @SerializedName("imdbID")
    val imdbID: String?,
    @SerializedName("Poster")
    val poster: String?,
    @SerializedName("Title")
    val title: String?,
    @SerializedName("Type")
    val type: String?,
    @SerializedName("Year")
    val year: String?
) : Parcelable