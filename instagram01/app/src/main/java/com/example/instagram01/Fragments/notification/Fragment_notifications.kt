package com.example.instagram01.Fragments.notification

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import com.example.instagram01.R
import com.example.instagram01.activity.MainActivity

class Fragment_notifications : Fragment() {
    private lateinit var mainActivity: MainActivity

    override fun onCreate(savedInstanceState: Bundle?) {
        setHasOptionsMenu(true)
        super.onCreate(savedInstanceState)
        arguments?.let {

        }
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        mainActivity.toolbar.title = "Thông báo"

    }

    override fun onPause() {
        mainActivity.toolbar.title = ""
        super.onPause()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_notifications, container, false)
        mainActivity = activity as MainActivity
        return view
    }

}