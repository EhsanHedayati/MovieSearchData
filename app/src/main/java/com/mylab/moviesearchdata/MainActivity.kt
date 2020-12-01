package com.mylab.moviesearchdata

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import androidx.appcompat.widget.SearchView
import com.mylab.moviesearchdata.viewmodels.SharedViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel


class MainActivity : AppCompatActivity(), SearchView.OnQueryTextListener {


    private lateinit var searchView: SearchView
    private val sharedModel : SharedViewModel by viewModel<SharedViewModel>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.toolbar_menu, menu)
        val menuItem = menu?.findItem(R.id.action_search)
        searchView = menuItem?.actionView as SearchView
        searchView.setOnQueryTextListener(this)

        return true
    }

    override fun onQueryTextSubmit(query: String?): Boolean {

        sharedModel.fetchData(searchView.query.toString())
        searchView.clearFocus()

        return true
    }

    override fun onQueryTextChange(newText: String?): Boolean {

        return true
    }


}