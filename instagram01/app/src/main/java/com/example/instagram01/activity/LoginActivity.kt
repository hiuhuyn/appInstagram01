package com.example.instagram01.activity

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.instagram01.R

class LoginActivity : AppCompatActivity() {
    private var check: Boolean = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val myperf: SharedPreferences = getSharedPreferences("dataSave", MODE_PRIVATE)
        check = myperf.getBoolean("checkLogin", false)


        if (check){
            val i = Intent(this, HomePageActivity::class.java)
            startActivity(i)
            finish()
        }else{
            setContentView(R.layout.activity_login)
            check = true // kiểm tra login thành công thì đổi check = true
        }
    }

    override fun onPause() {
        super.onPause()
        val myperf: SharedPreferences = getSharedPreferences("dataSave", MODE_PRIVATE)
        val myEdit: SharedPreferences.Editor = myperf.edit()
        myEdit.putBoolean("checkLogin", check)
        myEdit.apply()

    }
}