package com.example.instagram01

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_sig_up.*
import kotlinx.android.synthetic.main.activity_signln.*

class SigUpActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sig_up)
        signIn_link_edt.setOnClickListener {
            startActivity(Intent(this, SignlnActivity::class.java))
        }
    }
}