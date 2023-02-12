package com.example.instagram01.adapters

import android.net.Uri
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import androidx.fragment.app.FragmentActivity
import com.example.instagram01.R
import com.example.instagram01.interfaceFun.OnClickListent
import com.example.instagram01.model.ImageStaus
import com.example.instagram01.model.Status
import com.example.instagram01.reusable_classes.DataTest


class CustomerAdapter_status_profile(val fragmentActivity: FragmentActivity, val list:List<Status>, val onClickListent: OnClickListent): ArrayAdapter<Status>(fragmentActivity, R.layout.item_witget_status_profile) {
    private var images = ArrayList<ImageStaus>()

    override fun getCount(): Int {
        return list.size
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        return initView(position, convertView, parent)
    }

    private fun initView(position: Int, convertView: View?, parent: ViewGroup): View{
        setData()
        val context = fragmentActivity.layoutInflater
        val rowView = context.inflate(R.layout.item_witget_status_profile, parent, false)
        val image = rowView.findViewById<ImageView>(R.id.imageView_main)
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
                image.setImageURI(i.SrcImg)
                break
            }
        }
        rowView.setOnClickListener {
            onClickListent.OnClickView(position)
        }
        return rowView
    }

    private fun setData() {
        images.add(ImageStaus(0, 0, DataTest().imageUriTest(R.drawable.avt_test)))
        images.add(ImageStaus(1, 1, DataTest().imageUriTest(R.drawable.avt_test)))
        images.add(ImageStaus(2, 2, DataTest().imageUriTest(R.drawable.backgroud_btn)))
        images.add(ImageStaus(3, 3, DataTest().imageUriTest(R.drawable.backgroud_instagram)))
        images.add(ImageStaus(4, 4, DataTest().imageUriTest(R.drawable.heart2)))
        images.add(ImageStaus(5, 5, DataTest().imageUriTest(R.drawable.backgroud_instagram)))
    }

}