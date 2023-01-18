package com.example.instagram01.Fragments.profile.child_profile

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.appcompat.widget.Toolbar
import androidx.core.content.ContextCompat
import com.example.instagram01.R
import com.example.instagram01.activity.MainActivity


class Fragment_showAllOtherUser : Fragment() {
    private lateinit var mainActivity: MainActivity


    override fun onCreate(savedInstanceState: Bundle?) {
        setHasOptionsMenu(true)
        super.onCreate(savedInstanceState)
        arguments?.let {

        }
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onPause() {
        super.onPause()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view: View = inflater.inflate(R.layout.fragment_show_all_other_user, container, false)
        mainActivity = activity as MainActivity
        mainActivity.toolbar.navigationIcon = ContextCompat.getDrawable(mainActivity, R.drawable.ic_return)
        mainActivity.toolbar.title = "Khám phá mọi người"
        mainActivity.toolbar.setNavigationOnClickListener {
            parentFragmentManager.popBackStack()
        }


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