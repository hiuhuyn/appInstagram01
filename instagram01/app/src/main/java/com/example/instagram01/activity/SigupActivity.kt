package com.example.instagram01.activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.example.instagram01.R

class SigupActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sigup)
        val login = findViewById<TextView>(R.id.tv_login)
        login.setOnClickListener {
            startActivity(Intent(this, LoginActivity::class.java))
        }
    }
}