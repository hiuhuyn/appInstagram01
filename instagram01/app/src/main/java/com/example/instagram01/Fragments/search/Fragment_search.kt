package com.example.instagram01.Fragments.search

import android.app.SearchManager
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.*
import androidx.appcompat.widget.SearchView
import androidx.core.content.ContextCompat
import androidx.core.content.getSystemService
import androidx.core.view.marginEnd
import androidx.fragment.app.Fragment
import com.example.instagram01.R
import com.example.instagram01.activity.MainActivity


class Fragment_search : Fragment() {
    private lateinit var mainActivity: MainActivity

    override fun onCreate(savedInstanceState: Bundle?) {
        setHasOptionsMenu(true)
        super.onCreate(savedInstanceState)
        arguments?.let {

        }
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.menu_search_view,menu)
        val searchManager: SearchManager = mainActivity.getSystemService(Context.SEARCH_SERVICE) as SearchManager
        var searchView: SearchView = menu.findItem(R.id.it_search).actionView as SearchView
        searchView.setSearchableInfo(searchManager.getSearchableInfo(mainActivity.componentName))
        searchView.queryHint = "Tìm kiếm"
        searchView.setIconifiedByDefault(false)
//        searchView.background = ContextCompat.getDrawable(mainActivity,R.drawable.background_search_view)
        searchView.maxWidth = Int.MAX_VALUE

        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_search, container, false)
        mainActivity = activity as MainActivity
        return view
    }

}