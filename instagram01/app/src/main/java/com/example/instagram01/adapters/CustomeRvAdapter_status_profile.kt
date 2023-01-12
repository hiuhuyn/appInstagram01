package com.example.instagram01.adapters

import android.app.Activity
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import com.example.instagram01.R
import com.example.instagram01.model.ImageStaus
import com.example.instagram01.model.Status

class CustomeRvAdapter_status_profile(val activity: Activity, val list:List<Status>, val images: List<ImageStaus>): ArrayAdapter<Status>(activity, R.layout.item_witget_status_profile) {
    override fun getCount(): Int {
        return list.size
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        return initView(position, convertView, parent)
    }

    private fun initView(position: Int, convertView: View?, parent: ViewGroup): View{
        val context = activity.layoutInflater
        val rowView = context.inflate(R.layout.item_witget_status_profile, parent, false)
        var image = rowView.findViewById<ImageView>(R.id.img_status)
        var icon = rowView.findViewById<ImageView>(R.id.ic_photos)
        var count: Short = 0
        for (i in images){
            if(i.IdStatus.equals(list[position].IdStatus)){
                count++
                if (count>=2){
                    icon.visibility = View.VISIBLE
                    break
                }
            }
        }
        for (i in images){
            if(i.IdStatus.equals(list[position].IdStatus)){
                image.setImageResource(i.SrcImg)
                break
            }
        }
        return rowView


    }
}