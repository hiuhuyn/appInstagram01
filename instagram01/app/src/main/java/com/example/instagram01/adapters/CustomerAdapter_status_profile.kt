package com.example.instagram01.adapters

import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import androidx.fragment.app.FragmentActivity
import com.example.instagram01.R
import com.example.instagram01.interfaceFun.OnClickListent
import com.example.instagram01.model.ImageStaus
import com.example.instagram01.model.Status


class CustomerAdapter_status_profile(val fragmentActivity: FragmentActivity, val list:List<Status>, val images: List<ImageStaus>, val onClickListent: OnClickListent): ArrayAdapter<Status>(fragmentActivity, R.layout.item_witget_status_profile) {
    override fun getCount(): Int {
        return list.size
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        return initView(position, convertView, parent)
    }

    private fun initView(position: Int, convertView: View?, parent: ViewGroup): View{
        val context = fragmentActivity.layoutInflater
        val rowView = context.inflate(R.layout.item_witget_status_profile, parent, false)
        val image = rowView.findViewById<ImageView>(R.id.img_status)
        val icon = rowView.findViewById<ImageView>(R.id.ic_photos)
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
            if(i.IdStatus == list[position].IdStatus){
                image.setImageResource(i.SrcImg)
                break
            }
        }
        rowView.setOnClickListener {
            onClickListent.OnClickView(position)
        }
        return rowView
    }
}