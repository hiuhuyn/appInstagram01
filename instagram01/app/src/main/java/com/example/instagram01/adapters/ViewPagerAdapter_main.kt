package com.example.instagram01.adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.instagram01.Fragments.home.Fragment_home
import com.example.instagram01.Fragments.notification.Fragment_notifications
import com.example.instagram01.Fragments.profile.Fragment_profile
import com.example.instagram01.Fragments.search.Fragment_search
import com.example.instagram01.model.User

interface SettingShowFragment{
    fun isUserMain() : Boolean
    fun user(): User
}

class ViewPagerAdapter_main(fragmentActivity: FragmentActivity, val setting: SettingShowFragment) :
    FragmentStateAdapter(fragmentActivity) {
    override fun getItemCount(): Int {
        return 4
    }

    override fun createFragment(position: Int): Fragment {
        when(position){
            0 -> {
                return Fragment_home()
            }
            1 -> {
                return Fragment_search()
            }
            2 -> {
                return Fragment_notifications()
            }
            3 -> {
                return Fragment_profile.newInstance(setting.isUserMain(), setting.user())
//                return Fragment_profile()
            }
            else->{
                return Fragment_home()
            }
        }
    }
}