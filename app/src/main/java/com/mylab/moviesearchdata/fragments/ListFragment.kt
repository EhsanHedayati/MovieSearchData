package com.mylab.moviesearchdata.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.google.android.material.snackbar.Snackbar
import com.mylab.moviesearchdata.interfaces.MovieItemClick
import com.mylab.moviesearchdata.adapters.MovieRecyclerListAdapter
import com.mylab.moviesearchdata.viewmodels.SharedViewModel
import com.mylab.moviesearchdata.databinding.FragmentListBinding
import com.mylab.moviesearchdata.model.ResponseMovie
import com.mylab.moviesearchdata.model.Search
import org.koin.androidx.viewmodel.ext.android.sharedViewModel


class ListFragment : Fragment() {


    private val sharedModel: SharedViewModel by sharedViewModel()
    lateinit var binding: FragmentListBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentListBinding.inflate(inflater)
        binding.recyclerView.visibility = View.GONE

        return binding.root
    }


    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)



        sharedModel.sharedResponseMovie.observe(viewLifecycleOwner, Observer {

            getAdapter(it)

        })

    }

    private fun getAdapter(it: ResponseMovie) {
        if (it.response == "True") {
            binding.recyclerView.visibility = View.VISIBLE
            binding.recyclerTextMessage.visibility = View.GONE

            val movieListAdapter = MovieRecyclerListAdapter(object : MovieItemClick {
                override fun onItemClick(movie: Search) {
                    navigateToDetail(movie)
                }

            })

            binding.adapter = movieListAdapter
            val list = it.search
            movieListAdapter.submitList(list)

        } else {

            view?.let { view ->
                Snackbar.make(
                    view,
                    "There are'nt movies wit the same name pattern",
                    Snackbar.LENGTH_INDEFINITE
                )
                    .setAction("got it") {
                        //ToDo
                    }
                    .show()
            }
        }
    }

    private fun navigateToDetail(movie: Search) {
        findNavController().navigate(ListFragmentDirections.actionListFragmentToDetailFragment(movie))
    }


}