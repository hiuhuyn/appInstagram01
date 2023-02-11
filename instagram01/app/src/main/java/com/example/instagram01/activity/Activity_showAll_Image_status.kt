package com.example.instagram01.activity

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ListView
import androidx.appcompat.widget.Toolbar
import com.example.instagram01.R
import com.example.instagram01.adapters.CustomerAdapter_showAll_image_status
import com.example.instagram01.interfaceFun.interface_delete_item

class Activity_showAll_Image_status : AppCompatActivity() {
    private var listURI_Image: ArrayList<Uri> = ArrayList()
    private lateinit var toolbar: Toolbar
    private lateinit var listView: ListView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_acitivity_show_image)
        toolbar = findViewById(R.id.toolbar)
        listView = findViewById(R.id.listView)
        val intent = intent
        listURI_Image = intent.extras!!.getParcelableArrayList<Uri>("listImage") as ArrayList<Uri>
        /* giải thích check_genre để làm gì
        * có 2 kiểu show ảnh
        * 1 là show ảnh khi đang tạo bài viết, có thể xóa được ảnh
        * 2 là show ảnh khi ấn xem bài viết từ status, không thể xóa
        * */
        val check_genre = intent.extras!!.getInt("check_genre", 2)
        val adapter = CustomerAdapter_showAll_image_status(this, listURI_Image, check_genre, object : interface_delete_item{
            override fun deleteItem(index: Int) {
                listURI_Image.removeAt(index)
            }
        })
        listView.adapter = adapter

        addEvent()
    }

    private fun addEvent() {
        toolbar.setNavigationOnClickListener {
            finish()
        }
        toolbar.setOnMenuItemClickListener {
            when(it.itemId){
                R.id.ic_save_profile -> {
                    val intent = Intent()
                    val bundle = Bundle()
                    bundle.putParcelableArrayList("listImage", listURI_Image)
                    intent.putExtras(bundle)
                    setResult(10,intent)
                    finish()
                }
            }
            true
        }
    }
}