package com.example.instagram01.adapters

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.result.ActivityResultCallback
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import com.example.instagram01.R
import com.example.instagram01.activity.ActivityAddPost
import com.example.instagram01.activity.Activity_showAll_Image_status
import com.example.instagram01.interfaceFun.interface_onClickView

class CustemerAdapter_addImage(val activity: ActivityAddPost, var listUri: ArrayList<Uri>, val onclickView: interface_onClickView): ArrayAdapter<Uri>(activity, R.layout.item_witget_status_profile) {
    override fun getCount(): Int {
        if (listUri.size > 4){
            return 4
        }
        return listUri.size
    }
    fun setData(list: ArrayList<Uri>){
        listUri = list
    }


    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val view = activity.layoutInflater.inflate(R.layout.item_witget_status_profile, parent, false)
        val imageView = view.findViewById<ImageView>(R.id.imageView_main)
        val tvBigSize = view.findViewById<TextView>(R.id.tv_bigSize)
        imageView.setImageURI(listUri[position])
        if (position>=3&&listUri.size>4){
            tvBigSize.setText("+${listUri.size-3}")
            tvBigSize.visibility = View.VISIBLE
        }else{
            tvBigSize.visibility = View.GONE
        }
        imageView.setOnClickListener {
            onclickView.onClickView(position)
            notifyDataSetChanged()
        }


        return view
    }
}