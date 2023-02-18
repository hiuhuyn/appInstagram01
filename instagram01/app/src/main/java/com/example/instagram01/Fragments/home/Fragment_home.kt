package com.example.instagram01.Fragments.home

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.*
import android.widget.Button
import android.widget.ListView
import androidx.fragment.app.Fragment
import com.example.instagram01.R
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.instagram01.activity.EditProfile_Activity
import com.example.instagram01.activity.HomePageActivity
import com.example.instagram01.activity.MessagerActivity
import com.example.instagram01.adapters.CustemerAdapter_status
import com.example.instagram01.model.Status
import java.util.*
import kotlin.collections.ArrayList


class Fragment_home : Fragment() {
    private lateinit var mainActivity: HomePageActivity
    private lateinit var lv_status: ListView
    private var listStatus = ArrayList<Status>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
        arguments?.let {

        }

    }
    @SuppressLint("MissingInflatedId")
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
        lv_status = view.findViewById(R.id.list_view_status_home)
        addData()
        val adapterr = CustemerAdapter_status(mainActivity, listStatus, this)
        lv_status.adapter = adapterr

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
                mainActivity.openAddPost()
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

}