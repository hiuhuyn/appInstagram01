package com.example.instagram01.Fragments.profile.child_profile

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.Toolbar
import com.example.instagram01.R
import com.example.instagram01.activity.MainActivity


class Fragment_showAllOtherUser : Fragment() {
    private lateinit var mainActivity: MainActivity


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
        val view: View = inflater.inflate(R.layout.fragment_show_all_other_user, container, false)
        mainActivity = activity as MainActivity
        addEvent(view)
        return view
    }

    private fun addEvent(view: View) {

    }

    companion object {

        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            Fragment_showAllOtherUser().apply {
                arguments = Bundle().apply {

                }
            }
    }
}