package com.example.instagram01.Fragments.search

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ListView
import com.example.instagram01.Fragments.follow.Fragment_followed
import com.example.instagram01.R
import com.example.instagram01.activity.HomePageActivity
import com.example.instagram01.adapters.CustemerAdapter_status
import com.example.instagram01.adapters.CustemerAdapter_status_Search
import com.example.instagram01.model.Status
import com.example.instagram01.model.User
import java.util.*
import kotlin.collections.ArrayList

class Fragment_search_status : Fragment() {
    private lateinit var lv_status: ListView
    private lateinit var homePageActivity: HomePageActivity
    private var listStatus = ArrayList<Status>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {

        }
    }
    @SuppressLint("MissingInflatedId")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_search_status, container, false)
        lv_status = view.findViewById(R.id.lv_status)
        homePageActivity = activity as HomePageActivity
        addData()
        val adapterr = CustemerAdapter_status(homePageActivity, listStatus, this)
        lv_status.adapter = adapterr

        return view
    }
    private fun addData() {
        listStatus.add(Status(1, "2222", "hello", Calendar.getInstance().time))
        listStatus.add(Status(1, "33", "world", Calendar.getInstance().time))
        listStatus.add(Status(1, "3444", "I", Calendar.getInstance().time))
        listStatus.add(Status(1, "55", "lm", Calendar.getInstance().time))
        listStatus.add(Status(1, "777", "status", Calendar.getInstance().time))
        listStatus.add(Status(1, "4554", "and", Calendar.getInstance().time))
        listStatus.add(Status(1, "356", "you", Calendar.getInstance().time))
        listStatus.add(Status(1, "476", "?", Calendar.getInstance().time))
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment Fragment_followed.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            Fragment_followed().apply {
                arguments = Bundle().apply {

                }
            }
    }
}