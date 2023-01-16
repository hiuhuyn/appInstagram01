package com.example.instagram01.activity

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import com.example.instagram01.Fragments.*
import com.example.instagram01.Fragments.home.Fragment_home
import com.example.instagram01.Fragments.notification.Fragment_notifications
import com.example.instagram01.Fragments.profile.Fragment_profile
import com.example.instagram01.Fragments.search.Fragment_search
import com.example.instagram01.R
import com.example.instagram01.interfaceFun.Interface_sendData
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    private lateinit var nav_bottom:BottomNavigationView

    @SuppressLint("ResourceType")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        nav_bottom = findViewById(R.id.nav_bottom)


        supportFragmentManager.beginTransaction().add(
            R.id.frame_layout_page, Fragment_home(), "tag1"
        )
        supportFragmentManager.beginTransaction().addToBackStack("tag1")
        supportFragmentManager.beginTransaction().commit()

        addEvent()

    }

    private fun addEvent() {


        nav_bottom.setOnNavigationItemSelectedListener { item ->
            when(item.itemId){
                R.id.nav_home -> {
                    goToFragment(Fragment_home(), "nav_home")
                }
                R.id.nav_search -> {
                    goToFragment(Fragment_search(), "nav_search")
                }
                R.id.nav_profile -> {
                    goToFragment(Fragment_profile(), "nav_profile")
                }
                R.id.nav_notifications -> {
                    goToFragment(Fragment_notifications(), "nav_notifications")
                }
            }
            true
        }
    }
    fun goToFragment(fragment: Fragment, tag: String){
        val fragmentManager = supportFragmentManager.beginTransaction()
        fragmentManager.replace(
            R.id.frame_layout_page, fragment, tag
        )
        fragmentManager.addToBackStack(tag)
        fragmentManager.commit()
    }
    fun goToFragment(fragment: Fragment, tag: String, count: Int){
        val fragmentManager = supportFragmentManager.beginTransaction()
        // gửi dũ liệu check
        val bundle: Bundle = Bundle()
        bundle.putInt("countItem", count)
        fragment.arguments = bundle

        fragmentManager.replace(
            R.id.frame_layout_page, fragment, tag
        )
        fragmentManager.addToBackStack(tag)
        fragmentManager.commit()
    }



}