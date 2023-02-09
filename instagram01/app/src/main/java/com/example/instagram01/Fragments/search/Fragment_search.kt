package com.example.instagram01.Fragments.search

import android.app.SearchManager
import android.content.ClipData
import android.content.Context
import android.os.Bundle
import android.view.*
import androidx.appcompat.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.viewpager2.widget.ViewPager2
import com.example.instagram01.R
import com.example.instagram01.activity.HomePageActivity
import com.example.instagram01.adapters.CustemerAdapter_status_Search
import com.example.instagram01.adapters.ViewPageAdapter_Search
import com.example.instagram01.model.User
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator


class Fragment_search : Fragment() {
    private lateinit var mainActivity: HomePageActivity
    private val listUser = ArrayList<User>()
    private lateinit var adapter : CustemerAdapter_status_Search
    private lateinit var tabLayout: TabLayout
    private lateinit var viewPager: ViewPager2

    private val query = MutableLiveData<String>()

    fun setQuery(queryData: String) {
        query.value = queryData
    }

    fun getQuery(): LiveData<String>? {
        return query
    }

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

    class ItemViewModel : ViewModel() {
        private val mutableSelectedItem = MutableLiveData<ClipData.Item>()
        val selectedItem: LiveData<ClipData.Item> get() = mutableSelectedItem

        fun selectItem(item: ClipData.Item) {
            mutableSelectedItem.value = item
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_search, container, false)
        tabLayout = view.findViewById(R.id.tabLLayout_search_user)
        viewPager = view.findViewById(R.id.viewPager2_search_user)
        mainActivity = activity as HomePageActivity
        adapter = CustemerAdapter_status_Search(mainActivity,listUser )

        viewPager.adapter = ViewPageAdapter_Search(this)

        val tabMediator = TabLayoutMediator(tabLayout, viewPager) { tab, position ->
            when (position) {
                0 -> {
                    tab.setText("Mọi Người")
                }
                1 -> {
                    tab.setText("Bài Viết")
                }
            }
        }
        tabMediator.attach()


        //lv_user = view.findViewById(R.id.rv_Search)
        //lv_user.adapter = adapter
        adapter.setData(listUser)
        return view
    }
}