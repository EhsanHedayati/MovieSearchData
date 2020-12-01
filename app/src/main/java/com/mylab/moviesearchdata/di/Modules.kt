package com.mylab.moviesearchdata.di

import com.mylab.moviesearchdata.viewmodels.SharedViewModel
import com.mylab.moviesearchdata.api.MoviesApi
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

val viewModelModule = module {

    single { SharedViewModel(get()) }

}

val apiModule = module {

    fun provideMoviesApi(retrofit: Retrofit): MoviesApi {
        return retrofit.create(MoviesApi::class.java)
    }
    single { provideMoviesApi(get()) }

}


val networkModule = module {

    fun provideOkHttp():OkHttpClient{
        val loggingInterceptor = HttpLoggingInterceptor()
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY)
        return OkHttpClient.Builder()
            .addInterceptor(loggingInterceptor)
            .build()
    }

    fun provideCallAdapter(): RxJava3CallAdapterFactory {
        return RxJava3CallAdapterFactory.create()
    }


    fun provideRetrofit():Retrofit{

        return Retrofit.Builder()
            .baseUrl(MoviesApi.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(provideCallAdapter())
            .client(provideOkHttp())
            .build()
    }
    single { provideRetrofit() }
}