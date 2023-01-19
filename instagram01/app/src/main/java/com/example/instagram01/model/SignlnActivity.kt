package com.example.instagram01

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_signln.*

class SignlnActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signln)
        sigup_link_edt.setOnClickListener {
            startActivity(Intent(this, SigUpActivity::class.java))
        }
    }
}