package com.example.instagram01.Fragments.home

import android.content.Intent
import android.os.Bundle
import android.view.*
import android.widget.Button
import androidx.fragment.app.Fragment
import com.example.instagram01.R
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.instagram01.activity.EditProfile_Activity
import com.example.instagram01.activity.HomePageActivity
import com.example.instagram01.activity.MessagerActivity


class Fragment_home : Fragment() {
    private lateinit var mainActivity: HomePageActivity

    private lateinit var btn_messenger: Button

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

        init(view)
        //addEvent(view, container)

        var recyclerView: RecyclerView? = null
        recyclerView = view.findViewById(R.id.posts_recycler_view)
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
        when(item.itemId){
            R.id.ic_messenger -> {
                val i = Intent(activity, MessagerActivity::class.java)
                startActivity(i)
            }
            R.id.ic_add -> {

            }
        }
        return true
    }
    private fun init(view: View?) {
        if (view != null) {
            mainActivity = activity as HomePageActivity
        }
    }
    private fun addEvent(view: View, container: ViewGroup?) {

    }

    override fun onPause() {
        super.onPause()
    }

}