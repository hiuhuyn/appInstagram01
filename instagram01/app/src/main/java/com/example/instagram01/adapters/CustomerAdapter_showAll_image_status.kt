package com.example.instagram01.adapters

import android.net.Uri
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageButton
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.example.instagram01.R
import com.example.instagram01.interfaceFun.interface_delete_item

class CustomerAdapter_showAll_image_status(val activity: AppCompatActivity, val listUri: ArrayList<Uri>, val check_genre: Int, val interfaceDeleteItem: interface_delete_item): ArrayAdapter<Uri>(activity, R.layout.item_witget_image_and_delete) {
    override fun getCount(): Int {
        return listUri.size
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val view = activity.layoutInflater.inflate(R.layout.item_witget_image_and_delete, parent, false)
        val imageView = view.findViewById<ImageView>(R.id.imageView)
        val imageBtn_del = view.findViewById<ImageButton>(R.id.imageBtn_del)
        if (check_genre==2){
            imageBtn_del.visibility = View.GONE
        }else{
            imageBtn_del.visibility = View.VISIBLE
            imageBtn_del.setOnClickListener {
                interfaceDeleteItem.deleteItem(position)
                notifyDataSetChanged()
            }
        }
        imageView.setImageURI(listUri[position])
        return view
    }
}