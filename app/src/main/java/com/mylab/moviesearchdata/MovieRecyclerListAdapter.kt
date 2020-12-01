package com.mylab.moviesearchdata

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.mylab.moviesearchdata.databinding.MovieRecyclerViewItemBinding
import com.mylab.moviesearchdata.model.Search

class MovieRecyclerListAdapter(val movieItemClick: MovieItemClick) : ListAdapter<Search,MovieRecyclerListAdapter.MovieViewHolder>(Companion) {

    companion object:DiffUtil.ItemCallback<Search>() {
        override fun areItemsTheSame(oldItem: Search, newItem: Search): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: Search, newItem: Search): Boolean {
            return oldItem.imdbID == newItem.imdbID
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = MovieRecyclerViewItemBinding.inflate(layoutInflater)
        return MovieViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        val currentMovie = getItem(position)
        holder.binding.search = currentMovie
        holder.binding.executePendingBindings()
    }

    inner class MovieViewHolder(val binding: MovieRecyclerViewItemBinding) : RecyclerView.ViewHolder(binding.root){
        init {
            binding.itemClick = movieItemClick
        }
    }
}