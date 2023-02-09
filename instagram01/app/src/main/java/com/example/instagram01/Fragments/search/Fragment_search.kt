package com.example.instagram01.Fragments.search

import android.app.SearchManager
import android.content.Context
import android.os.Bundle
import android.view.*
import android.widget.ListView
import androidx.appcompat.widget.SearchView
import androidx.fragment.app.Fragment
import com.example.instagram01.R
import com.example.instagram01.activity.HomePageActivity
import com.example.instagram01.adapters.CustemerAdapter_status_Search
import com.example.instagram01.model.User
import kotlin.collections.ArrayList


class Fragment_search : Fragment() {
    private lateinit var mainActivity: HomePageActivity
    private val listUser = ArrayList<User>()
    private lateinit var lv_user: ListView
    private lateinit var adapter : CustemerAdapter_status_Search

    override fun onCreate(savedInstanceState: Bundle?) {
        setHasOptionsMenu(true)
        super.onCreate(savedInstanceState)
        arguments?.let {
        }

    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.menu_search_view,menu)
        val searchManager: SearchManager = mainActivity.getSystemService(Context.SEARCH_SERVICE) as SearchManager
        var searchView: SearchView = menu.findItem(R.id.it_search).actionView as SearchView
        searchView.setSearchableInfo(searchManager.getSearchableInfo(mainActivity.componentName))
        searchView.queryHint = "Tìm kiếm"
        searchView.setIconifiedByDefault(false)
//        searchView.background = ContextCompat.getDrawable(mainActivity,R.drawable.background_search_view)
        searchView.maxWidth = Int.MAX_VALUE
        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener{
            override fun onQueryTextSubmit(filterString: String?): Boolean {
                adapter.filter.filter(filterString)
                return true
            }
            override fun onQueryTextChange(filterString: String?): Boolean {
                adapter.filter.filter(filterString)
                return true
            }

        })
        super.onCreateOptionsMenu(menu, inflater)
    }



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_search, container, false)
        mainActivity = activity as HomePageActivity
        adapter = CustemerAdapter_status_Search(mainActivity,listUser )

        lv_user = view.findViewById(R.id.rv_Search)
        lv_user.adapter = adapter
        adapter.setData(listUser)
        addData()
        return view
    }
    private fun addData() {

        listUser.add((User("Quan@1", 111, true, "29/11/22", "Nguyễn Minh Quân", "gynhuyn", "des", R.drawable.user )))
        listUser.add((User("Quan@1", 111, true, "29/11/22", "yutar", "ha", "des", R.drawable.add )))
        listUser.add((User("Quan@1", 111, true, "29/11/22", "Nguyễn Minh Quân", "ssss", "des", R.drawable.ic_launcher_background )))
        listUser.add((User("Quan@1", 111, true, "29/11/22", "Nguyễn Minh Quân", "saaa", "des", androidx.appcompat.R.drawable.abc_ic_ab_back_material )))
        listUser.add((User("Quan@1", 111, true, "29/11/22", "Nguyễn Minh Quân", "aaaa", "des", R.drawable.home )))
        listUser.add((User("Quan@1", 111, true, "29/11/22", "Nguyễn Minh Quân", "rrrrr", "des", R.drawable.avt_test )))
        listUser.add((User("Quan@1", 111, true, "29/11/22", "Nguyễn Minh Quân", "jjjjj", "des", R.drawable.profile_icon )))
        listUser.add((User("Quan@1", 111, true, "29/11/22", "Nguyễn Minh Quân", "jjjjj", "des", R.drawable.avt_test)))
        listUser.add((User("Quan@1", 111, true, "29/11/22", "Nguyễn Minh Quân", "jjjjj", "des", R.drawable.avt_test)))
        listUser.add((User("Quan@1", 111, true, "29/11/22", "Nguyễn Minh Quân", "jjjjj", "des", R.drawable.avt_test)))
        listUser.add((User("Quan@1", 111, true, "29/11/22", "Nguyễn Minh Quân", "jjjjj", "des", R.drawable.avt_test)))
        listUser.add((User("Quan@1", 111, true, "29/11/22", "Nguyễn Minh Quân", "jjjjj", "des",
            R.drawable.backgroud_bt
        )))
        listUser.add((User("Quan@1", 111, true, "29/11/22", "Nguyễn Minh Quân", "jjjjj", "des", R.drawable.avt_test)))
        listUser.add((User("Quan@1", 111, true, "29/11/22", "Nguyễn Minh Quân", "jjjjj", "des",
            R.drawable.background_search_view
        )))
        listUser.add((User("Quan@1", 111, true, "29/11/22", "Nguyễn Minh Quân", "jjjjj", "des", R.drawable.avt_test)))
        listUser.add((User("Quan@1", 111, true, "29/11/22", "Nguyễn Minh Quân", "jjjjj", "des", R.drawable.avt_test)))
        listUser.add((User("Quan@1", 111, true, "29/11/22", "Nguyễn Minh Quân", "jjjjj", "des",
            R.drawable.avt_test
        )))
    }

}