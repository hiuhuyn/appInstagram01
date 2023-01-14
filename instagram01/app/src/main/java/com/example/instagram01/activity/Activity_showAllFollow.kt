package com.example.instagram01.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.widget.Toolbar
import com.example.instagram01.R

class Activity_showAllFollow : AppCompatActivity() {
    private lateinit var toolbar_showAllUser: Toolbar


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_show_all_follow)
        val i = intent
        var check = i.getIntExtra("i", 0)
        toolbar_showAllUser = findViewById(R.id.toolbar_showAllUser)

        addEvent()
    }

    private fun addEvent() {
        toolbar_showAllUser.setNavigationOnClickListener {
            finish()
        }
    }
}