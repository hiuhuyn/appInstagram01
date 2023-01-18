package com.example.instagram01.adapters

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.instagram01.Fragments.follow.Fragment_followed
import com.example.instagram01.Fragments.follow.Fragment_followers

class ViewPageAdapter_follow(fragment: Fragment) : FragmentStateAdapter(fragment) {
    override fun getItemCount(): Int {
        return 2
    }

    override fun createFragment(position: Int): Fragment {
        when(position){
            0 -> {
                return Fragment_followers()
            }
            1 -> {
                return Fragment_followed()
            }
            else -> {
                return Fragment_followers()
            }
        }
    }


}