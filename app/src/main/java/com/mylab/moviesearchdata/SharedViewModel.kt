package com.mylab.moviesearchdata


import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.mylab.moviesearchdata.model.MoviesApi
import com.mylab.moviesearchdata.model.ResponseMovie
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.disposables.CompositeDisposable

import io.reactivex.rxjava3.schedulers.Schedulers

class SharedViewModel(private val apiService: MoviesApi) : ViewModel() {

    val sharedResponseMovie = MutableLiveData<ResponseMovie>()
    private val compositeDisposable = CompositeDisposable()




    fun fetchData(name: String) {

        //val apiService = RetrofitClient.getClient()
        val disposable = apiService.getMovies(name, MoviesApi.API_KEY)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                {
                    it?.let {
                        sharedResponseMovie.value = it

                    }
                },
                {
                    it.printStackTrace()

                }
            )

        compositeDisposable.add(disposable)

    }




}