package com.mylab.moviesearchdata.interfaces

import com.mylab.moviesearchdata.model.Search

interface MovieItemClick {
    fun onItemClick(movie: Search)
}