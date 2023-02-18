package com.example.instagram01.Fragments.follow

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ListView
import com.example.instagram01.R
import com.example.instagram01.activity.HomePageActivity
import com.example.instagram01.adapters.CustomerAdapter_userFollow
import com.example.instagram01.model.User
import com.example.instagram01.reusable_classes.DataTest


class Fragment_followers : Fragment() {


    private lateinit var homePageActivity: HomePageActivity
    private val listUser = ArrayList<User>()

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
        val view = inflater.inflate(R.layout.fragment_followers, container, false)
        val lv_followes = view.findViewById<ListView>(R.id.lv_followers)
        homePageActivity = activity as HomePageActivity
        addData()

        val adt = CustomerAdapter_userFollow(homePageActivity, listUser)
        lv_followes.adapter = adt




        return view
    }

    private fun addData() {

        listUser.add((User("Quan@1", 111, true, "29/11/22", "Nguyễn Minh Quân", "gynhuyn", "des", DataTest().imageUriTest(R.drawable.user ))))
        listUser.add((User("Quan@1", 111, true, "29/11/22", "Nguyễn Minh Quân", "ha", "des", DataTest().imageUriTest(R.drawable.user ))))
        listUser.add((User("Quan@1", 111, true, "29/11/22", "Nguyễn Minh Quân", "ssss", "des",DataTest().imageUriTest(R.drawable.user ))))
        listUser.add((User("Quan@1", 111, true, "29/11/22", "Nguyễn Minh Quân", "saaa", "des", DataTest().imageUriTest(R.drawable.user ))))
        listUser.add((User("Quan@1", 111, true, "29/11/22", "Nguyễn Minh Quân", "aaaa", "des", DataTest().imageUriTest(R.drawable.user ))))
        listUser.add((User("Quan@1", 111, true, "29/11/22", "Nguyễn Minh Quân", "rrrrr", "des", DataTest().imageUriTest(R.drawable.user ))))
        listUser.add((User("Quan@1", 111, true, "29/11/22", "Nguyễn Minh Quân", "jjjjj", "des", DataTest().imageUriTest(R.drawable.user ))))
        listUser.add((User("Quan@1", 111, true, "29/11/22", "Nguyễn Minh Quân", "jjjjj", "des", DataTest().imageUriTest(R.drawable.user ))))
    }


    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment Fragment_followers.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            Fragment_followers().apply {
                arguments = Bundle().apply {

                }
            }
    }
}