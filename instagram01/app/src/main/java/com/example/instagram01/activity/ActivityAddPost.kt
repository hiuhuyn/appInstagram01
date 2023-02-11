package com.example.instagram01.activity

import android.app.Activity
import android.content.Intent
import android.content.SharedPreferences
import android.graphics.Bitmap
import android.graphics.ImageDecoder
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.GridView
import android.widget.ImageButton
import android.widget.Toast
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.widget.Toolbar
import com.example.instagram01.R
import com.example.instagram01.adapters.CustemerAdapter_addImage
import com.example.instagram01.interfaceFun.interface_onClickView
import com.example.instagram01.model.ImageStaus
import com.example.instagram01.model.Status
import java.util.Calendar

class ActivityAddPost : AppCompatActivity() {
    private lateinit var adapter_addImage: CustemerAdapter_addImage
    private lateinit var toolbar: Toolbar
    private lateinit var edt_title: EditText
    private lateinit var btn_addImage: Button
    private lateinit var gridView: GridView
    private var listURI_Image: ArrayList<Uri> = ArrayList()
    private val staus: Status = Status()
    private lateinit var startGallery_images: ActivityResultLauncher<Intent>
    private lateinit var startResult:ActivityResultLauncher<Intent>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_post)
        toolbar = findViewById(R.id.toolbar)
        edt_title = findViewById(R.id.edt_title)
        btn_addImage  = findViewById(R.id.btn_addImage)
        gridView = findViewById(R.id.gridView)
        startResult = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
            if (result.resultCode == 10) {
                listURI_Image = result.data!!.extras!!.getParcelableArrayList<Uri>("listImage") as ArrayList<Uri>
                adapter_addImage.setData(listURI_Image)
                adapter_addImage.notifyDataSetChanged()
            }
        }


        staus.UserName = getSharedPreferences("dataSave", MODE_PRIVATE).getString("userName", "no user").toString()
        adapter_addImage = CustemerAdapter_addImage(this, listURI_Image, object : interface_onClickView{
            override fun onClickView(index: Int) {
                val intent = Intent(this@ActivityAddPost, Activity_showAll_Image_status::class.java)
                val bundle = Bundle()
                bundle.putParcelableArrayList("listImage", listURI_Image)
                bundle.putInt("check_genre",1)
                intent.putExtras(bundle)
                startResult.launch(intent)
            }

        })
        gridView.adapter = adapter_addImage


        startGallery_images= registerForActivityResult(
            ActivityResultContracts.StartActivityForResult()) { result ->
            if (result.resultCode == RESULT_OK && result.data != null) {
                if (result.data!!.clipData != null) {
                    // Get multiple images
                    for (i in 0 until result.data!!.clipData!!.itemCount) {
                        val imageUri = result.data!!.clipData!!.getItemAt(i).uri
                        // Do something with imageUri
                        listURI_Image.add(imageUri)
                    }
                } else {
                    // Get single image
                    val imageUri = result.data!!.data
                    if (imageUri != null) {
                        listURI_Image.add(imageUri)
                    }
                }
                adapter_addImage.notifyDataSetChanged()
            }
        }
        addEvent()
    }

    private fun addEvent() {
        toolbar.setNavigationOnClickListener {
            finish()
        }
        toolbar.setOnMenuItemClickListener {
            when(it.itemId){
                R.id.ic_save_profile -> {
                    // gửi dữ liệu lên server
                    sendData()
                    finish()
                }
            }
            true
        }
        btn_addImage.setOnClickListener {
            val intent = Intent(Intent.ACTION_GET_CONTENT)
            intent.type = "image/*"
            intent.putExtra(Intent.EXTRA_ALLOW_MULTIPLE, true)
            intent.addCategory(Intent.CATEGORY_OPENABLE)
            startGallery_images.launch(intent)

        }


    }
    private fun sendData() {
        staus.IdStatus = 2
        staus.PostTime = Calendar.getInstance().time
        staus.Title = edt_title.text.toString()

    }


}