package com.example.instagram01.reusable_classes

import android.net.Uri

class DataTest {
    fun imageUriTest(drawable: Int): Uri {  // tạo uri test từ drawable trong project
        val packageName = "com.example.instagram01"
        val imageUri = Uri.parse("android.resource://" + packageName + "/" + drawable)
        return imageUri
    }
}