package com.example.instagram01.Fragments.status

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.Toolbar
import androidx.recyclerview.widget.RecyclerView
import com.example.instagram01.R
import com.example.instagram01.activity.MainActivity

class Fragment_showStatus_User : Fragment() {

    private lateinit var mainActivity: MainActivity

    private lateinit var recyclerView: RecyclerView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_show_status__user, container, false)
        mainActivity = activity as MainActivity
        recyclerView = view.findViewById(R.id.rv_status)


        addEvent(view)
        return view
    }

    private fun addEvent(view: View?) {

    }

}