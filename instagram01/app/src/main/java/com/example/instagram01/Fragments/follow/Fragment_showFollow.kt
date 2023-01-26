package com.example.instagram01.Fragments.follow

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.core.content.ContextCompat
import androidx.viewpager2.widget.ViewPager2
import com.example.instagram01.R
import com.example.instagram01.activity.HomePageActivity
import com.example.instagram01.adapters.ViewPageAdapter_follow
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator


class Fragment_showFollow : Fragment() {
   private lateinit var tabLayout: TabLayout
   private lateinit var viewPager: ViewPager2
   private lateinit var mainActivity: HomePageActivity

    override fun onCreate(savedInstanceState: Bundle?) {
        setHasOptionsMenu(true)
        super.onCreate(savedInstanceState)
        arguments?.let {

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_show_follow, container, false)
        tabLayout = view.findViewById(R.id.tabLLayout_follow)
        viewPager = view.findViewById(R.id.viewPager2_follow)
        mainActivity = activity as HomePageActivity

        mainActivity.toolbar.navigationIcon = ContextCompat.getDrawable(mainActivity, R.drawable.ic_return)
        mainActivity.toolbar.title = "gyn.huyn"
        mainActivity.toolbar.setNavigationOnClickListener {
            parentFragmentManager.popBackStack()
        }

        viewPager.adapter = ViewPageAdapter_follow(this)

        val tabMediator = TabLayoutMediator(tabLayout, viewPager) { tab, position ->
            when (position) {
                0 -> {
                    tab.setText("Người theo dõi")
                }
                1 -> {
                    tab.setText("Đang theo dõi")
                }
            }
        }
        tabMediator.attach()

        addEvent(view)

        return view
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onPause() {
        super.onPause()
    }

    private fun addEvent(view: View?) {

    }

}