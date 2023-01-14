package com.example.instagram01.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.widget.Toolbar
import com.example.instagram01.R

class EditProfile_Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_profile)
        val toolbar: Toolbar = findViewById(R.id.toolbar_editProfile)
        toolbar.setOnMenuItemClickListener {
            when(it.itemId){
                R.id.ic_save_profile -> {
                    Toast.makeText(this, "check", Toast.LENGTH_SHORT).show()
                }
            }
            true
        }
        toolbar.setNavigationOnClickListener {
            finish()
        }
    }

}