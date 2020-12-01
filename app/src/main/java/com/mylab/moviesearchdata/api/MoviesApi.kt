package com.mylab.moviesearchdata.api

import com.mylab.moviesearchdata.model.ResponseMovie
import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface MoviesApi {

    companion object{
        const val BASE_URL = "http://www.omdbapi.com/"
        const val API_KEY = "1f63b279"
    }

    @GET("/")
    fun getMovies(
        @Query("s")name:String,
        @Query("apikey")apiKey:String
    ): Single<ResponseMovie>
}