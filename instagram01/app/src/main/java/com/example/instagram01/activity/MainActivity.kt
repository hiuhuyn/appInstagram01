package com.example.instagram01.activity

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2
import com.example.instagram01.Fragments.*
import com.example.instagram01.Fragments.home.Fragment_home
import com.example.instagram01.Fragments.notification.Fragment_notifications
import com.example.instagram01.Fragments.profile.Fragment_profile
import com.example.instagram01.Fragments.search.Fragment_search
import com.example.instagram01.R
import com.example.instagram01.adapters.SettingShowFragment
import com.example.instagram01.adapters.ViewPagerAdapter_main
import com.example.instagram01.model.User
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.navigation.NavigationBarView

class MainActivity : AppCompatActivity() {

    private lateinit var nav_bottom:BottomNavigationView
    private lateinit var viewPager2: ViewPager2
    lateinit var toolbar: Toolbar

    @SuppressLint("ResourceType")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        nav_bottom = findViewById(R.id.nav_bottom)
        toolbar = findViewById(R.id.toolbar)
        viewPager2 = findViewById(R.id.viewPager2)
        setSupportActionBar(toolbar)
        viewPager2.adapter = ViewPagerAdapter_main(this, object : SettingShowFragment{
            override fun isUserMain(): Boolean {
                return true
            }

            override fun user(): User {
                return User("Quan@1", 111, true, "29/11/22", "Minh Quân", "2911", "No desc", R.drawable.avt_test)
            }

        })


        addEvent()
    }


    private fun addEvent() {
        viewPager2.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageScrolled(
                position: Int,
                positionOffset: Float,
                positionOffsetPixels: Int
            ) {
            }

            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                when(position){
                    0 -> {
                        nav_bottom.selectedItemId = R.id.nav_home
                    }
                    1 -> {
                        nav_bottom.selectedItemId = R.id.nav_search
                    }
                    2 -> {
                        nav_bottom.selectedItemId = R.id.nav_notifications
                    }
                    3 -> {
                        nav_bottom.selectedItemId = R.id.nav_profile
                    }
                }
            }

            override fun onPageScrollStateChanged(state: Int) {
            }

        })


        nav_bottom.setOnItemSelectedListener {
            when(it.itemId) {
                R.id.nav_home -> {
                    viewPager2.currentItem = 0
                }
                R.id.nav_search -> {
                    viewPager2.currentItem = 1
                }
                R.id.nav_notifications -> {
                    viewPager2.currentItem = 2

                }
                R.id.nav_profile -> {
                    viewPager2.currentItem = 3
                }
            }
            true
        }
    }



}