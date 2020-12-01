package com.mylab.moviesearchdata.model


import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize
import android.os.Parcelable
import com.mylab.moviesearchdata.model.Search


@Parcelize
data class ResponseMovie(

    @SerializedName("Response")
    val response: String?,
    @SerializedName("Search")
    val search: List<Search>?



) : Parcelable