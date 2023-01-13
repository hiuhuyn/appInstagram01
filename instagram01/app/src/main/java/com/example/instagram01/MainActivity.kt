package com.example.instagram01

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import android.widget.Toast
import android.widget.Toolbar
import androidx.fragment.app.Fragment
import com.example.instagram01.Fragments.Fragment_home
import com.example.instagram01.Fragments.Fragment_notifications
import com.example.instagram01.Fragments.Fragment_profile
import com.example.instagram01.Fragments.Fragment_search
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    @SuppressLint("ResourceType")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var selectedFragment: Fragment? = Fragment_home()
        var nav_bottom:BottomNavigationView = findViewById(R.id.nav_bottom)

        nav_bottom.setOnNavigationItemReselectedListener { item ->
            when(item.itemId){
                R.id.nav_home -> {
                    Toast.makeText(this, "Home", Toast.LENGTH_SHORT).show()
                    selectedFragment = Fragment_home()
                }
                R.id.nav_search -> {
                    Toast.makeText(this, "search", Toast.LENGTH_SHORT).show()
                    selectedFragment = Fragment_search()
                }
                R.id.nav_profile -> {
                    Toast.makeText(this, "Profile", Toast.LENGTH_SHORT).show()
                    selectedFragment = Fragment_profile()
                }
                R.id.nav_notifications -> {
                    Toast.makeText(this, "Notificatios", Toast.LENGTH_SHORT).show()
                    selectedFragment = Fragment_notifications()
                }
            }
            if(selectedFragment != null){
                supportFragmentManager.beginTransaction().apply {
                    replace(
                        R.id.frame_layout_page,
                        selectedFragment!!
                    )
                    commit()
                }

            }
        }

    }




}