package com.example.instagram01.activity

import android.annotation.SuppressLint
import android.content.Intent
import android.content.SharedPreferences
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MotionEvent
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment

import com.example.instagram01.Fragments.*
import com.example.instagram01.Fragments.home.Fragment_home
import com.example.instagram01.Fragments.notification.Fragment_notifications
import com.example.instagram01.Fragments.profile.Fragment_profile
import com.example.instagram01.Fragments.search.Fragment_search
import com.example.instagram01.R
import com.example.instagram01.model.User
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.bottomsheet.BottomSheetDialog

class HomePageActivity : AppCompatActivity() {
    private lateinit var nav_bottom:BottomNavigationView
    lateinit var toolbar: Toolbar

    @SuppressLint("ResourceType")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        nav_bottom = findViewById(R.id.nav_bottom)
        toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)
        supportFragmentManager.beginTransaction().add(
            R.id.fragment_main, Fragment_home()
        ).commit()

        addEvent()
    }

    override fun onPause() {
        super.onPause()
    }

    override fun onDestroy() {
        super.onDestroy()
    }
    fun clickBtnOpen() {
        var view = layoutInflater.inflate(R.layout.bottom_sheet, null)
        val bottomSheetDialog = BottomSheetDialog(this)
        bottomSheetDialog.setContentView(view)
        bottomSheetDialog.show()
        val btn_logOut = view.findViewById<Button>(R.id.btn_logOut)

        btn_logOut.setOnTouchListener { v, event ->
            when(event.action){
                MotionEvent.ACTION_DOWN -> {
                    btn_logOut.setBackgroundColor(Color.argb(100, 199,199,199))
                }
                MotionEvent.ACTION_UP -> {
                    btn_logOut.setBackgroundColor(Color.WHITE)
                    bottomSheetDialog.dismiss()
                    val myperf: SharedPreferences = getSharedPreferences("dataSave",
                        AppCompatActivity.MODE_PRIVATE
                    )
                    val myEdit: SharedPreferences.Editor = myperf.edit()
                    myEdit.putBoolean("checkLogin", false)
                    myEdit.apply()
                    startActivity(Intent(this, LoginActivity::class.java))
                    finish()
                }


            }
            false
        }

    }



    private fun addEvent() {

        nav_bottom.setOnItemSelectedListener {
            var tag = ""
            var selectorFragment: Fragment = Fragment_home()
            when(it.itemId) {
                R.id.nav_home -> {
                    tag = "home"
                    selectorFragment = Fragment_home()
                }
                R.id.nav_search -> {
                    tag = "search"
                    selectorFragment = Fragment_search()
                }
                R.id.nav_notifications -> {
                    tag = "notifications"
                    selectorFragment = Fragment_notifications()
                }
                R.id.nav_profile -> {
                    tag = "profile"
                    selectorFragment = Fragment_profile.newInstance(true, User("Quan@1", 111, true, "29/11/22", "Nguyễn Minh Quân", "jjjjj", "des", R.drawable.avt_test))
                }
            }
            supportFragmentManager.beginTransaction().replace(
                R.id.fragment_main,
                selectorFragment,
                tag
            ).commit()
            true
        }
    }



}