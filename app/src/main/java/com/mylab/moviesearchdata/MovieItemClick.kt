package com.mylab.moviesearchdata

import com.mylab.moviesearchdata.model.Search

interface MovieItemClick {
    fun onItemClick(movie: Search)
}