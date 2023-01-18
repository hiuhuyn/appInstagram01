package com.example.instagram01.Fragments.follow

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.Toolbar
import androidx.core.content.ContextCompat
import androidx.fragment.app.FragmentStatePagerAdapter
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.widget.ViewPager2
import com.example.instagram01.R
import com.example.instagram01.activity.MainActivity
import com.example.instagram01.adapters.ViewPageAdapter_follow
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import com.google.android.material.tabs.TabLayoutMediator.TabConfigurationStrategy


class Fragment_showFollow : Fragment() {
   private lateinit var tabLayout: TabLayout
   private lateinit var viewPager: ViewPager2
   private lateinit var mainActivity: MainActivity

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
        mainActivity = activity as MainActivity
        mainActivity.toolbar.navigationIcon = ContextCompat.getDrawable(mainActivity, R.drawable.ic_return)
        mainActivity.toolbar.title = "gyn.huyn"
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

    override fun onPause() {
        setHasOptionsMenu(false)
        mainActivity.toolbar.navigationIcon = null
        mainActivity.toolbar.title = ""
        super.onPause()
    }

    private fun addEvent(view: View?) {

    }

}