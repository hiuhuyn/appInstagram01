package com.example.instagram01.Fragments.profile.child_profile

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.instagram01.R


class Fragment_showAllOtherUser : Fragment() {
    private lateinit var viewMain: View

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
        viewMain = inflater.inflate(R.layout.fragment_show_all_other_user, container, false)
        return viewMain
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