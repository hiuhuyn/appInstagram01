package com.example.instagram01.Fragments.status

import android.os.Bundle
import android.view.*
import android.widget.ListView
import androidx.fragment.app.Fragment
import androidx.core.content.ContextCompat
import com.example.instagram01.R
import com.example.instagram01.activity.HomePageActivity
import com.example.instagram01.adapters.CustemerAdapter_status
import com.example.instagram01.model.Status
import java.util.Calendar

class Fragment_showStatus_User : Fragment() {

    private lateinit var mainActivity: HomePageActivity
    private lateinit var lv_status: ListView
    private var listStatus = ArrayList<Status>()


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
        mainActivity.title = null
        mainActivity.toolbar.title = ""
        mainActivity.toolbar.navigationIcon = null
        super.onPause()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_show_status__user, container, false)
        createData()
        mainActivity = activity as HomePageActivity
        lv_status = view.findViewById(R.id.lv_status)
        mainActivity.toolbar.title = "Bài viết"
        mainActivity.toolbar.navigationIcon = ContextCompat.getDrawable(mainActivity, R.drawable.ic_return)
        mainActivity.toolbar.setNavigationOnClickListener {
            parentFragmentManager.popBackStack()
        }
        val custemerAdapter_status = CustemerAdapter_status(mainActivity, listStatus , this)
        lv_status.adapter = custemerAdapter_status



        addEvent(view)
        return view
    }

    private fun createData() {
        listStatus.add(Status(1, "2222", "hello", Calendar.getInstance().time))
        listStatus.add(Status(1, "33", "world", Calendar.getInstance().time))
        listStatus.add(Status(1, "3444", "I", Calendar.getInstance().time))
        listStatus.add(Status(1, "55", "lm", Calendar.getInstance().time))
        listStatus.add(Status(1, "777", "status", Calendar.getInstance().time))
        listStatus.add(Status(1, "4554", "and", Calendar.getInstance().time))
        listStatus.add(Status(1, "356", "you", Calendar.getInstance().time))
        listStatus.add(Status(1, "476", "?", Calendar.getInstance().time))
    }


    private fun addEvent(view: View?) {

    }

}