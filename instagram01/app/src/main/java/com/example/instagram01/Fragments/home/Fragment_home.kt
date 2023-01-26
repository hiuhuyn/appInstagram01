package com.example.instagram01.Fragments.home

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import com.example.instagram01.R
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.instagram01.activity.HomePageActivity


class Fragment_home : Fragment() {
    private lateinit var mainActivity: HomePageActivity

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
        arguments?.let {

        }

    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        val view : View = inflater.inflate(R.layout.fragment_home, container, false)
        mainActivity = activity as HomePageActivity
        mainActivity.toolbar.title = "Instagram"
        mainActivity.toolbar.navigationIcon = null

        var recyclerView: RecyclerView? = null
        recyclerView = view.findViewById(R.id.view_home)
        val linearLayoutManager = LinearLayoutManager(context)
        linearLayoutManager.reverseLayout = true
        linearLayoutManager.stackFromEnd
        recyclerView.layoutManager = linearLayoutManager

        return view
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.menu_appbar_home, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return true
    }

    override fun onPause() {
        super.onPause()
    }

}