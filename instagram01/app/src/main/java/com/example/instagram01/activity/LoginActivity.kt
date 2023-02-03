package com.example.instagram01.activity

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.example.instagram01.R

class LoginActivity : AppCompatActivity() {
    private var check: Boolean = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // chưa khởi tạo layout
        val myperf: SharedPreferences = getSharedPreferences("dataSave", MODE_PRIVATE)
        check = myperf.getBoolean("checkLogin", false)

        // check xem đẽ đăng nhập chưa
        if (check){
            // đã đăng nhập thì next sang HomePage luôn ko tạo layout activity_login nữa
            val i = Intent(this, HomePageActivity::class.java)
            startActivity(i)
            finish()
        }else{
            // chưa đăng nhập thì nhảy vào đây, bây giờ mới tạo layout
            setContentView(R.layout.activity_login)
            // viết nội dung trong này
//            check = true // kiểm tra login thành công thì đổi check = true
            val sigup = findViewById<TextView>(R.id.tv_sigup)
            var btn_login = findViewById<Button>(R.id.btn_login)
            btn_login.setOnClickListener {
                check = true
                startActivity(Intent(this, HomePageActivity::class.java))
                finish()
            }

            sigup.setOnClickListener {
                startActivity(Intent(this, SigupActivity::class.java))
            }




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