package com.example.instagram01.adapters

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.instagram01.Fragments.follow.Fragment_followed
import com.example.instagram01.Fragments.follow.Fragment_followers
import com.example.instagram01.Fragments.search.Fragment_search_status
import com.example.instagram01.Fragments.search.Fragment_search_user

class ViewPageAdapter_Search(fragment: Fragment) : FragmentStateAdapter(fragment) {
    override fun getItemCount(): Int {
        return 2
    }

    override fun createFragment(position: Int): Fragment {
        when(position){
            0 -> {
                return Fragment_search_user()
            }
            1 -> {
                return Fragment_search_status()
            }
            else -> {
                return Fragment_search_user()
            }
        }
    }


}