package com.example.instagram01.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.instagram01.R
import com.example.instagram01.model.User
import org.w3c.dom.Text

class CustomerAdapter_userFollow(val activity: AppCompatActivity, val array:ArrayList<User>): ArrayAdapter<User>(activity, R.layout.item_witget_user_follow) {

    override fun getCount(): Int {
        return array.size
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val view = activity.layoutInflater.inflate(R.layout.item_witget_user_follow, parent, false)
        val img_avt = view.findViewById<ImageView>(R.id.img_avt)
        val tv_userName = view.findViewById<TextView>(R.id.tv_userName)
        val tv_fullName = view.findViewById<TextView>(R.id.tv_fullName)
        val btn_follow = view.findViewById<Button>(R.id.btn_follow)

        img_avt.setImageResource(array[position].Avt)
        tv_userName.setText(array[position].UserName)
        tv_fullName.setText(array[position].FullName)

        //
        var isFollow = false
        btn_follow.setOnClickListener {
            if (isFollow){
                isFollow=false
                btn_follow.setText("Theo dõi")
                btn_follow.setTextColor(ContextCompat.getColor(context, R.color.white))
                btn_follow.setBackgroundColor(ContextCompat.getColor(context,R.color.blue))

            }else{
                isFollow=true
                btn_follow.setText("Xóa")
                btn_follow.setTextColor(ContextCompat.getColor(context, R.color.black))
                btn_follow.setBackgroundColor(ContextCompat.getColor(context, R.color.greyish))
            }


        }



        return view
    }
}